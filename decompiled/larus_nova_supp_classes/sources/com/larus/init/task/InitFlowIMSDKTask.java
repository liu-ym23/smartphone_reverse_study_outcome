package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.FlowRuntime;
import com.larus.im.e;
import com.larus.im.service.s;
import com.larus.init.task.imsdk.o0;
import com.larus.init.task.imsdk.r;
import com.larus.init.task.imsdk.z;
import gd9.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/larus/init/task/InitFlowIMSDKTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitFlowIMSDKTask extends d implements bg9.i {
    public final String a;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        xf9.f.a = new o0();
        int r0 = com.larus.im.d.a;
        b r1 = new b();
        Intrinsics.checkNotNullParameter(r1, "depend");
        s.a.getClass();
        s.a.a().triggerInit(r1);
        e r2 = com.larus.im.c.a;
        c r3 = new c();
        Intrinsics.checkNotNullParameter(r3, "depend");
        Object r4 = com.larus.im.c.c;
        monitor-enter(r4);
        buc.a r5 = com.larus.im.c.b;     // Catch: Throwable -> L31
        if (r5.c() == false) goto L13;
        e r6 = com.larus.im.c.a;     // Catch: Throwable -> L31
        if (r6 == null) goto L11;
        r6.a();     // Catch: Throwable -> L31
        n r7 = n.a;
        com.larus.init.task.imsdk.q.a.e("FlowIMPlugin", "has already init");     // Catch: Throwable -> L31
    L11:
        monitor-exit(r4);
    L17:
        int r8 = com.larus.im.a.a;
        d r9 = new d();
        Intrinsics.checkNotNullParameter(r9, "depend");
        o r10 = com.larus.im.internal.d.a;
        Intrinsics.checkNotNullParameter(r9, "depend");
        if (com.larus.im.internal.d.c == true) goto L29;
        com.larus.im.internal.d.a = r9;
        gd9.q r11 = FlowRuntime.a;
        FlowRuntime.c(n.a);
        gf9.a r12 = gf9.a.a;
        Set r13 = r9.e();
        Intrinsics.checkNotNullParameter(r13, "traceSet");
        if (r13.isEmpty() == true) goto L28;
        Iterator r14 = r13.iterator();
    L24:
        if (r14.hasNext() == false) goto L28;
        gf9.b r15 = (gf9.b) r14.next();
        Intrinsics.checkNotNullParameter(r15, "trace");
        ArrayList r16 = (ArrayList) gf9.a.b;
        if (r16.contains(r15) == true) goto L24;
        r16.add(r15);
    L28:
        qf9.b r17 = new qf9.b();
        r9.d(r17);
        com.larus.im.internal.d.b = r17;
        com.larus.im.internal.d.c = true;
    L29:
        r r18 = r.a;
        com.larus.im.d.e().addMessageConcatObserver(r.b);
        com.larus.im.d.e().registerOnGlobalMessageObserver(z.a);
        PollingConfigService.a.j(new e());
        return;
    L13:
        com.larus.im.c.a = r3;     // Catch: Throwable -> L31
        gd9.q r19 = FlowRuntime.a;     // Catch: Throwable -> L31
        FlowRuntime.c(n.a);     // Catch: Throwable -> L31
        r5.d(true);     // Catch: Throwable -> L31
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r4);
    L31:
        th = move-exception;
        throw th;
    }

    public InitFlowIMSDKTask() {
        this.a = "Message";
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.a;
    }
}
