package com.volcengine.zeus.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqc.p;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/volcengine/zeus/receiver/BaseProxyStaticReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "getPluginPkgName", XmlPullParser.NO_NAMESPACE, "onReceive", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseProxyStaticReceiver extends BroadcastReceiver {
    public abstract String getPluginPkgName();

    public BaseProxyStaticReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r6, Intent r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "intent");
        String r0 = getClass().getName();
        ZeusLogger.i(ZeusLogger.TAG_RECEIVER, String.format("[%s] onReceive, intent = %s", Arrays.copyOf(new Object[]{r0, r7.toString()}, 2)));
        p.a(new a(this, r7, r0, r6));
    }
}
