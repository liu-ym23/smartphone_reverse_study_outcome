package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.livesdk.message.model.RTChorusOperateType;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a implements fd2.d {
    public final com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a a;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.realtimechorus.a$a, reason: collision with other inner class name */
    public static final class C0045a implements qh0.d<rh0.a> {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;

        public final void b(BaseCheckException r4) {
            Intrinsics.checkNotNullParameter(r4, "exception");
            ALogger.d("ChorusJsbService", "checkPermission onFailed");
            this.a.a.b(false, this.b);
            InteractLinkFullLinkMonitor.e(OperateType.APPLY.ordinal(), 2, r4);
            TalkRoomBusinessFullLinkMonitor.a.getClass();
            TalkRoomBusinessFullLinkMonitor.U(r4);
            com.bytedance.android.live.liveinteract.plantform.utils.x.K(r4);
        }

        public final void onResult(Object r3) {
            rh0.a r4 = (rh0.a) r3;
            ALogger.d("ChorusJsbService", "checkPermission onSuccess");
            this.a.a.b(true, this.b);
            InteractLinkFullLinkMonitor.f(OperateType.APPLY.ordinal(), 2);
            TalkRoomBusinessFullLinkMonitor.a.getClass();
            TalkRoomBusinessFullLinkMonitor.V();
            com.bytedance.android.live.liveinteract.plantform.utils.x.L();
        }

        public C0045a(a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public a(com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "chorusEventHandler");
        this.a = r2;
    }

    public final void c(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "source");
        OperateType r0 = OperateType.APPLY;
        ArrayList r1 = new ArrayList();
        r1.add(qh0.g.a(r0, 2));
        r1.add(new qh0.f.g(r6, r0, 2));
        r1.add(new qh0.f.c(r6, r0, 2));
        r1.add(new qh0.f.a(r6));
        r1.add(new qh0.f.f(r6, r0, 2, true));
        r1.add(new qh0.f.e(r6, r0));
        qh0.f.a(r1).a(new C0045a(this, r7));
    }

    public void a(int r3, RTChorusOperateType r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "actionType");
        Intrinsics.checkNotNullParameter(r5, "musicId");
        Intrinsics.checkNotNullParameter(r6, "orderUserId");
        Intrinsics.checkNotNullParameter(r4, "actionType");
        Intrinsics.checkNotNullParameter(r5, "musicId");
        Intrinsics.checkNotNullParameter(r6, "orderUserId");
    }
}
