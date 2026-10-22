package com.volcengine.zeus.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.Plugin;
import iqc.b;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqc.p;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/volcengine/zeus/receiver/BaseProxyStaticReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "getPluginPkgName", "", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseProxyStaticReceiver extends BroadcastReceiver {

    /* JADX INFO: loaded from: classes41.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseProxyStaticReceiver f462830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f462831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f462832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f462833d;

        /* JADX INFO: renamed from: com.volcengine.zeus.receiver.BaseProxyStaticReceiver$a$a, reason: collision with other inner class name */
        public static final class RunnableC5556a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f462834a;

            public RunnableC5556a(a r100) {
                this.f462834a = r100;
            }

            public final void a() {
                if (Zeus.isPluginLoaded(this.f462834a.f462830a.getPluginPkgName()) == true) goto L5;
                Zeus.loadPlugin(this.f462834a.f462830a.getPluginPkgName());
            L5:
                Plugin r100 = Zeus.getPlugin(this.f462834a.f462830a.getPluginPkgName());
                if (r100 == null) goto L8;
                this.f462834a.f462831b.setExtrasClassLoader(r100.mClassLoader);
            L8:
                b r101 = b.c();
                this.f462834a.f462830a.getPluginPkgName();
                a r102 = this.f462834a;
                String r103 = r102.f462832c;
                Context r104 = r102.f462833d;
                Intent r105 = r102.f462831b;
                PluginBroadcastReceiver r106 = (PluginBroadcastReceiver) ((HashMap) r101.f495432e).get(r103);
                if (r106 == null) goto L12;
                r106.onReceive(r104, r105);
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(BaseProxyStaticReceiver r100, Intent r101, String r102, Context r103) {
            this.f462830a = r100;
            this.f462831b = r101;
            this.f462832c = r102;
            this.f462833d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p.b(new RunnableC5556a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract String getPluginPkgName();

    public BaseProxyStaticReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "intent");
        String r102 = getClass().getName();
        ZeusLogger.i(ZeusLogger.TAG_RECEIVER, String.format("[%s] onReceive, intent = %s", Arrays.copyOf(new Object[]{r102, r101.toString()}, 2)));
        p.a(new a(this, r101, r102, r100));
    }
}
