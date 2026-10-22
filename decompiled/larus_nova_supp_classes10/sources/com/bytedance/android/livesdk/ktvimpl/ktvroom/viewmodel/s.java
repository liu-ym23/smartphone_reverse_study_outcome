package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.common.utility.StringUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s extends c {
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.c
    public final MusicPanel k(com.bytedance.android.livesdk.ktvimpl.base.sei.k r9) {
        Intrinsics.checkNotNullParameter(r9, "seiModel");
        MusicPanel r1 = this.f.d().a();
        String r2 = null;
        if (r1 == null) goto L25;
        KtvMusic r3 = r1.a;
        long r4 = r9.j();
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r6 = r9.w();
        if (r6 == null) goto L8;
        String r7 = r6.h();
        if (r7 == null) goto L8;
    L10:
        if (KtvUtilsKt.s(r3, r4, r7) == true) goto L20;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r5 = r9.w();
        if (r5 == null) goto L14;
        String r8 = r5.h();
    L15:
        if (r8 == null) goto L17;
    L19:
        boolean r10 = false;
    L21:
        if (r10 == true) goto L24;
        r1 = null;
    L24:
        if (r1 == null) goto L25;
    L42:
        return r1;
    L17:
        if (r1.a.getMId() != r9.j()) goto L19;
    L14:
        r8 = null;
    L20:
        r10 = true;
    L8:
        r7 = "";
    L25:
        r1 = com.bytedance.android.livesdk.ktvimpl.base.util.o.a(r9);
        Intrinsics.checkNotNullParameter(r1, "$this$initKtvMusicBySei");
        Intrinsics.checkNotNullParameter(r9, "seiModel");
        KtvMusic r0 = r1.a;
        if (r9.j() == 0) goto L28;
        r0.setMId(r9.j());
    L28:
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r11 = r9.w();
        if (r11 == null) goto L31;
        String r12 = r11.g();
    L33:
        if (StringUtils.isEmpty(r12) == true) goto L39;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r13 = r9.w();
        if (r13 == null) goto L37;
        r2 = r13.g();
    L37:
        r0.setMTitle(r2);
    L39:
        if (((long) r9.h()) <= 0) goto L41;
        r0.setMDuration((long) r9.h());
    L41:
        r0.setOrderInfo(com.bytedance.android.livesdk.ktvimpl.base.util.o.f(r1, r9));
        goto L42
    L31:
        r12 = null;
        goto L33
    }

    public s(KtvContext r2, BaseCoreViewModel r3, sb0.b r4, Function2<? super Integer, ? super Long, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "coreViewModel");
        Intrinsics.checkNotNullParameter(r4, "dataEntity");
        Intrinsics.checkNotNullParameter(r5, "singerUpdateAction");
        super(r2, r3, r4, r5);
        ALogger.i("logKtvMainPath", "KtvRoomListenerController init, invoke class :".concat(s.class.getSimpleName()));
    }
}
