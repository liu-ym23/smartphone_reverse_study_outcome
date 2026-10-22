package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.kh;
import com.bytedance.ies.sdk.widgets.Widget;
import fd2.x;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/kh;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/message/model/kh;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvComponentAnchorLogicWidget$subscribeAll$6 extends FunctionReferenceImpl implements Function1<kh, Unit> {
    public KtvComponentAnchorLogicWidget$subscribeAll$6(KtvComponentAnchorLogicWidget r8) {
        super(1, r8, KtvComponentAnchorLogicWidget.class, "openKtvComponentFromInteract", "openKtvComponentFromInteract(Lcom/bytedance/android/livesdk/message/model/OpenKSongEvent;)V", 0);
    }

    public final void invoke(kh r14) {
        KtvComponentAnchorLogicWidget r0 = (KtvComponentAnchorLogicWidget) ((CallableReference) this).receiver;
        int r1 = KtvComponentAnchorLogicWidget.q;
        r0.getClass();
        MusicPanel r2 = null;
        if (r14 == null) goto L5;
        MusicPanel r3 = r14.a;
    L7:
        if (r3 == null) goto L11;
        KtvMusic r4 = r3.a;
        if (r4 == null) goto L11;
        long r5 = r4.getMId();
    L12:
        Long r6 = KtvLoggerHelper.a;
        String r7 = com.bytedance.android.live.ktv.common.util.j.b(((Widget) r0).dataCenter);
        String r8 = com.bytedance.android.live.ktv.common.util.j.e(((Widget) r0).dataCenter);
        String r9 = com.bytedance.android.live.ktv.common.util.j.a(((Widget) r0).dataCenter);
        if (r5 > 0) goto L15;
        String r10 = "audience_empty";
    L16:
        KtvLoggerHelper.L(r7, r8, r9, r10, "audience_sing");
        if (jc1.k.n(IKtvService.class).requestConflictCheck(KtvConflictScene.SCENE_KSONG) == false) goto L28;
        if (r14 == null) goto L22;
        String r11 = r14.b;
        if (r11 == null) goto L22;
    L23:
        String r12 = r11;
        if (r14 == null) goto L26;
        r2 = r14.a;
    L26:
        r0.zq(new x(1, Boolean.FALSE, r12, r2, Boolean.TRUE, r12, null, null, 192));
        return;
    L22:
        r11 = "";
        goto L23
    L28:
        return;
    L15:
        r10 = "audience_sing";
    L11:
        r5 = 0;
        goto L12
    L5:
        r3 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((kh) r1);
        return Unit.INSTANCE;
    }
}
