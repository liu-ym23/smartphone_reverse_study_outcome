package com.bytedance.android.livesdk.ktvimpl.base.skin.viewHolder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.message.ChangeDressMode;
import com.bytedance.android.livesdkapi.depend.message.DressPageItemCommon;
import com.bytedance.android.livesdkapi.depend.message.KTVDressType;
import com.bytedance.android.livesdkapi.depend.message.TagDressPageItem;
import com.bytedance.bdlocation.exception.BDLocationException;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ KtvHonorTagViewBinder.KtvHonorTagViewHolder a;
    public final /* synthetic */ MicPosTagInfo b;
    public final /* synthetic */ Boolean c;
    public final /* synthetic */ KtvHonorTagViewBinder.a d;
    public final /* synthetic */ boolean e;

    public a(KtvHonorTagViewBinder.KtvHonorTagViewHolder r1, MicPosTagInfo r2, Boolean r3, KtvHonorTagViewBinder.a r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r19) {
        Long r1 = KtvLoggerHelper.a;
        MicPosTagInfo r2 = this.b;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = String.valueOf(r2.getTagType());
    L6:
        MicPosTagInfo r5 = this.b;
        if (r5 == null) goto L9;
        String r6 = r5.getPositionTagName();
    L10:
        Boolean r7 = this.c;
        Boolean r9 = Boolean.FALSE;
        boolean r8 = Intrinsics.areEqual(r7, r9);
        String r10 = BDLocationException.ERROR_TIMEOUT;
        if (r8 == false) goto L13;
        String r11 = BDLocationException.ERROR_TIMEOUT;
    L14:
        KtvLoggerHelper.S(r4, r6, "ksong", r11, null, 48);
        if (Intrinsics.areEqual(this.c, r9) == false) goto L53;
        KtvHonorTagViewBinder.a r12 = this.d;
        if (r12 == null) goto L23;
        TagDressPageItem r13 = r12.b;
        if (r13 == null) goto L23;
        DressPageItemCommon r14 = r13.common;
        if (r14 == null) goto L23;
        String r15 = r14.schema;
    L25:
        if (TextUtils.isEmpty(r15) == true) goto L35;
        IBaseLiveActionHandler r16 = k.n(IBaseLiveActionHandler.class);
        Context r17 = ((RecyclerView.ViewHolder) this.a).itemView.getContext();
        KtvHonorTagViewBinder.a r18 = this.d;
        if (r18 == null) goto L33;
        TagDressPageItem r20 = r18.b;
        if (r20 == null) goto L33;
        DressPageItemCommon r21 = r20.common;
        if (r21 == null) goto L33;
        String r22 = r21.schema;
    L34:
        r16.handle(r17, r22);
    L36:
        MicPosTagInfo r23 = this.b;
        if (r23 == null) goto L39;
        String r24 = String.valueOf(r23.getTagType());
    L40:
        MicPosTagInfo r25 = this.b;
        if (r25 == null) goto L44;
        r3 = r25.getPositionTagName();
    L44:
        if (Intrinsics.areEqual(this.c, r9) == true) goto L48;
        r10 = "1";
    L48:
        if (TextUtils.isEmpty(r15) == true) goto L50;
        String r26 = "jump";
    L51:
        KtvLoggerHelper.U(r24, r3, r10, r26);
        return;
    L50:
        r26 = "unavailable";
        goto L51
    L39:
        r24 = null;
    L33:
        r22 = null;
        goto L34
    L35:
        f2.b(2131918374, 0);
    L23:
        r15 = null;
        goto L25
    L53:
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r27 = this.a.e.b;
        if (r27 == null) goto L63;
        TagDressPageItem r28 = r27.getCurrentSelectHonorTag();
        if (r28 == null) goto L63;
        DressPageItemCommon r29 = r28.common;
        if (r29 == null) goto L63;
        String r30 = r29.dressId;
        if (r30 == null) goto L63;
        String r110 = r30;
    L64:
        boolean r31 = this.e;
        if (r31 == true) goto L77;
        KtvHonorTagViewBinder.a r32 = this.d;
        if (r32 == null) goto L77;
        TagDressPageItem r33 = r32.b;
        if (r33 == null) goto L77;
        DressPageItemCommon r34 = r33.common;
        if (r34 == null) goto L77;
        String r35 = r34.dressId;
        if (r35 == null) goto L77;
        String r111 = r35;
    L78:
        if (r31 == false) goto L80;
        ChangeDressMode r36 = ChangeDressMode.CHANGE_MODE_UNDRESS;
    L81:
        int r37 = r36.getValue();
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r112 = this.a.e.b;
        if (r112 == null) goto L85;
        r112.changeDress(KTVDressType.KTV_DRESS_TYPE_TAG.getValue(), r110, r111, r37, 0);
    L85:
        if (r37 != ChangeDressMode.CHANGE_MODE_UPDATE.getValue()) goto L100;
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r38 = this.a.e.b;
        if (r38 == null) goto L93;
        TagDressPageItem r39 = r38.getCurrentSelectHonorTag();
        if (r39 == null) goto L93;
        DressPageItemCommon r40 = r39.common;
        if (r40 == null) goto L93;
        r40.isSelected = false;
    L93:
        KtvHonorTagViewBinder.a r41 = this.d;
        if (r41 == null) goto L107;
        TagDressPageItem r42 = r41.b;
        if (r42 == null) goto L107;
        DressPageItemCommon r43 = r42.common;
        if (r43 == null) goto L107;
        r43.isSelected = true;
    L107:
        MicPosTagInfo r44 = this.b;
        if (r44 == null) goto L110;
        String r45 = String.valueOf(r44.getTagType());
    L111:
        MicPosTagInfo r46 = this.b;
        if (r46 == null) goto L115;
        r3 = r46.getPositionTagName();
    L115:
        if (Intrinsics.areEqual(this.c, r9) == true) goto L119;
        r10 = "1";
    L119:
        if (this.e == false) goto L121;
        String r47 = "cancel";
    L122:
        KtvLoggerHelper.U(r45, r3, r10, r47);
        return;
    L121:
        r47 = "use";
        goto L122
    L110:
        r45 = null;
        goto L111
    L100:
        KtvHonorTagViewBinder.a r48 = this.d;
        if (r48 == null) goto L107;
        TagDressPageItem r49 = r48.b;
        if (r49 == null) goto L107;
        DressPageItemCommon r50 = r49.common;
        if (r50 == null) goto L107;
        r50.isSelected = false;
        goto L107
    L80:
        r36 = ChangeDressMode.CHANGE_MODE_UPDATE;
    L77:
        r111 = "";
    L63:
        r110 = "";
        goto L64
    L13:
        r11 = "1";
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
