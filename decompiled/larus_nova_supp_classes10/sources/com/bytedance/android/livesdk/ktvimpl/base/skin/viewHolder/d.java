package com.bytedance.android.livesdk.ktvimpl.base.skin.viewHolder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.message.ChangeDressMode;
import com.bytedance.android.livesdkapi.depend.message.DressPageItemCommon;
import com.bytedance.android.livesdkapi.depend.message.KTVDressType;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressPageItem;
import com.bytedance.bdlocation.exception.BDLocationException;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ KtvMidiSkinViewBinder.KtvMidiSkinViewHolder a;
    public final /* synthetic */ Boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ KtvMidiSkinViewBinder.a d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;

    public d(KtvMidiSkinViewBinder.KtvMidiSkinViewHolder r1, Boolean r2, String r3, KtvMidiSkinViewBinder.a r4, String r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r19) {
        Long r1 = KtvLoggerHelper.a;
        Boolean r2 = this.b;
        Boolean r8 = Boolean.FALSE;
        if (Intrinsics.areEqual(r2, r8) == false) goto L5;
        String r5 = BDLocationException.ERROR_TIMEOUT;
    L6:
        KtvLoggerHelper.S("", "", "midi", r5, this.c, 32);
        if (Intrinsics.areEqual(this.b, r8) == false) goto L38;
        KtvMidiSkinViewBinder.a r3 = this.d;
        String r4 = null;
        if (r3 == null) goto L15;
        MidiSkinDressPageItem r6 = r3.a;
        if (r6 == null) goto L15;
        DressPageItemCommon r7 = r6.common;
        if (r7 == null) goto L15;
        String r9 = r7.schema;
    L17:
        if (TextUtils.isEmpty(r9) == true) goto L26;
        IBaseLiveActionHandler r10 = k.n(IBaseLiveActionHandler.class);
        Context r11 = ((RecyclerView.ViewHolder) this.a).itemView.getContext();
        KtvMidiSkinViewBinder.a r12 = this.d;
        if (r12 == null) goto L25;
        MidiSkinDressPageItem r13 = r12.a;
        if (r13 == null) goto L25;
        DressPageItemCommon r14 = r13.common;
        if (r14 == null) goto L25;
        r4 = r14.schema;
    L25:
        r10.handle(r11, r4);
    L28:
        if (Intrinsics.areEqual(this.b, r8) == false) goto L30;
        String r15 = BDLocationException.ERROR_TIMEOUT;
    L31:
        String r16 = this.c;
        if (TextUtils.isEmpty(r9) == true) goto L34;
        String r17 = "jump";
    L35:
        KtvLoggerHelper.T("", "", "midi", r15, r16, r17, this.e);
        return;
    L34:
        r17 = "unavailable";
        goto L35
    L30:
        r15 = "1";
        goto L31
    L26:
        f2.b(2131918374, 0);
    L15:
        r9 = null;
        goto L17
    L38:
        if (this.f == true) goto L40;
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r18 = this.a.e.b;
        if (r18 == null) goto L53;
        MidiSkinDressPageItem r20 = r18.getCurrentSelectMidiSkin();
        if (r20 == null) goto L53;
        DressPageItemCommon r21 = r20.common;
        if (r21 == null) goto L53;
        String r22 = r21.dressId;
        if (r22 == null) goto L53;
    L54:
        String r110 = r22;
        if (this.f == false) goto L57;
        ChangeDressMode r23 = ChangeDressMode.CHANGE_MODE_UNDRESS;
    L58:
        int r24 = r23.getValue();
        KtvMidiSkinViewBinder.a r25 = this.d;
        if (r25 == null) goto L65;
        MidiSkinDressPageItem r26 = r25.a;
        if (r26 == null) goto L65;
        Integer r27 = r26.ownerDegree;
        if (r27 == null) goto L65;
        int r111 = r27.intValue();
    L66:
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r112 = this.a.e.b;
        if (r112 == null) goto L70;
        r112.changeDress(KTVDressType.KTV_DRESS_TYPE_MIDI_SKIN.getValue(), r110, this.e, r24, r111);
    L70:
        if (r24 != ChangeDressMode.CHANGE_MODE_UPDATE.getValue()) goto L86;
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r28 = this.a.e.b;
        if (r28 == null) goto L78;
        MidiSkinDressPageItem r29 = r28.getCurrentSelectMidiSkin();
        if (r29 == null) goto L78;
        DressPageItemCommon r30 = r29.common;
        if (r30 == null) goto L78;
        r30.isSelected = false;
    L78:
        KtvMidiSkinViewBinder.a r31 = this.d;
        if (r31 == null) goto L86;
        MidiSkinDressPageItem r32 = r31.a;
        if (r32 == null) goto L86;
        DressPageItemCommon r33 = r32.common;
        if (r33 == null) goto L86;
        r33.isSelected = true;
    L86:
        if (Intrinsics.areEqual(this.b, r8) == false) goto L88;
        String r113 = BDLocationException.ERROR_TIMEOUT;
    L89:
        KtvLoggerHelper.T("", "", "midi", r113, this.c, "use", this.e);
        return;
    L88:
        r113 = "1";
    L65:
        r111 = 0;
        goto L66
    L57:
        r23 = ChangeDressMode.CHANGE_MODE_UPDATE;
    L53:
        r22 = "";
        goto L54
    L40:
        if (Intrinsics.areEqual(this.b, r8) == false) goto L42;
        String r114 = BDLocationException.ERROR_TIMEOUT;
    L43:
        KtvLoggerHelper.T("", "", "midi", r114, this.c, "remain", this.e);
        return;
    L42:
        r114 = "1";
        goto L43
    L5:
        r5 = "1";
        goto L6
    }
}
