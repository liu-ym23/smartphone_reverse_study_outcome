package com.bytedance.android.livesdk.ktvimpl.base.skin.viewHolder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.depend.message.DressPageItemCommon;
import com.bytedance.android.livesdkapi.depend.message.GetDressPageListMode;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressPageItem;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvMidiSkinViewBinder extends me.drakeet.multitype.b<a, KtvMidiSkinViewHolder> {
    public final com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a b;
    public final yd2.a c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/skin/viewHolder/KtvMidiSkinViewBinder$KtvMidiSkinViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class KtvMidiSkinViewHolder extends RecyclerView.ViewHolder {
        public final Lazy a;
        public final Lazy b;
        public final Lazy c;
        public final Lazy d;
        public final /* synthetic */ KtvMidiSkinViewBinder e;

        public KtvMidiSkinViewHolder(KtvMidiSkinViewBinder r2, final View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.e = r2;
            super(r3);
            this.a = LazyKt.lazy(new KtvMidiSkinViewBinder$KtvMidiSkinViewHolder$midiSkinThumbnail$2(r3));
            this.b = LazyKt.lazy(new KtvMidiSkinViewBinder$KtvMidiSkinViewHolder$midiSkinExpiredTime$2(r3));
            this.c = LazyKt.lazy(new KtvMidiSkinViewBinder$KtvMidiSkinViewHolder$midiSkinLimitTag$2(r3));
            this.d = LazyKt.lazy(new KtvMidiSkinViewBinder$KtvMidiSkinViewHolder$midiSkinLock$2(r3));
        }
    }

    public static final class a {
        public final MidiSkinDressPageItem a;
        public final int b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            MidiSkinDressPageItem r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (r1 * 31) + this.b;
        L5:
            r1 = 0;
            goto L7
        }

        public final String toString() {
            return "KtvMidiSkinData(midiSkinPageItem=" + this.a + ", mode=" + this.b + ")";
        }

        public a(MidiSkinDressPageItem r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "midiSkinPageItem");
            this.a = r2;
            this.b = r3;
        }
    }

    public KtvMidiSkinViewBinder(com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r2, yd2.a r3) {
        Intrinsics.checkNotNullParameter(r3, "reportWrapper");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r12, Object r13) {
        KtvMidiSkinViewHolder r14 = (KtvMidiSkinViewHolder) r12;
        a r4 = (a) r13;
        Intrinsics.checkNotNullParameter(r14, "viewHolder");
        Intrinsics.checkNotNullParameter(r4, "data");
        HSImageView r15 = (HSImageView) r14.a.getValue();
        k r0 = null;
        if (r4 == null) goto L7;
        MidiSkinDressPageItem r1 = r4.a;
        if (r1 == null) goto L7;
        k r2 = r1.thumbnail;
    L8:
        ImageLoader.bindImage(r15, r2);
        if (r4 == null) goto L15;
        MidiSkinDressPageItem r16 = r4.a;
        if (r16 == null) goto L15;
        DressPageItemCommon r17 = r16.common;
        if (r17 == null) goto L15;
        String r18 = r17.expireText;
    L16:
        int r3 = 8;
        if (TextUtils.isEmpty(r18) == true) goto L31;
        TextView r19 = (TextView) r14.b.getValue();
        if (r19 == null) goto L21;
        r19.setVisibility(0);
    L21:
        TextView r110 = (TextView) r14.b.getValue();
        if (r110 == null) goto L34;
        if (r4 == null) goto L29;
        MidiSkinDressPageItem r5 = r4.a;
        if (r5 == null) goto L29;
        DressPageItemCommon r6 = r5.common;
        if (r6 == null) goto L29;
        String r7 = r6.expireText;
    L30:
        r110.setText(r7);
    L29:
        r7 = null;
    L34:
        if (r4 == null) goto L38;
        MidiSkinDressPageItem r111 = r4.a;
        if (r111 == null) goto L38;
        k r112 = r111.topRightImage;
    L39:
        if (r112 == null) goto L49;
        HSImageView r113 = (HSImageView) r14.c.getValue();
        if (r4 == null) goto L45;
        MidiSkinDressPageItem r8 = r4.a;
        if (r8 == null) goto L45;
        k r9 = r8.topRightImage;
    L46:
        ImageUtil.loadImage(r113, r9, 0);
        HSImageView r114 = (HSImageView) r14.c.getValue();
        if (r114 == null) goto L52;
        r114.setVisibility(0);
    L52:
        View r115 = (View) r14.d.getValue();
        if (r115 == null) goto L64;
        if (r4 == null) goto L62;
        MidiSkinDressPageItem r10 = r4.a;
        if (r10 == null) goto L62;
        DressPageItemCommon r11 = r10.common;
        if (r11 == null) goto L62;
        if (r11.isUnlocked != true) goto L62;
    L63:
        r115.setVisibility(r3);
    L62:
        r3 = 0;
    L64:
        if (r4 == null) goto L72;
        MidiSkinDressPageItem r116 = r4.a;
        if (r116 == null) goto L72;
        DressPageItemCommon r117 = r116.common;
        if (r117 == null) goto L72;
        if (r117.isSelected != true) goto L72;
        boolean r20 = true;
    L73:
        View r118 = ((RecyclerView.ViewHolder) r14).itemView;
        if (r20 == false) goto L76;
        int r21 = 2131249311;
    L77:
        r118.setBackgroundResource(r21);
        if (r4 == null) goto L80;
        Integer r119 = Integer.valueOf(r4.b);
    L81:
        int r22 = GetDressPageListMode.LIST_MODE_FULL.getValue();
        if (r119 != null) goto L85;
    L87:
        a1.n(((RecyclerView.ViewHolder) r14).itemView, s1.f(16.0f));
        a1.p(((RecyclerView.ViewHolder) r14).itemView, s1.f(236.0f));
        a1.k(((RecyclerView.ViewHolder) r14).itemView, s1.f(89.0f));
    L88:
        if (r4 == null) goto L95;
        MidiSkinDressPageItem r120 = r4.a;
        if (r120 == null) goto L95;
        DressPageItemCommon r121 = r120.common;
        if (r121 == null) goto L95;
        String r122 = r121.dressId;
        if (r122 == null) goto L95;
    L96:
        if (r4 == null) goto L102;
        MidiSkinDressPageItem r23 = r4.a;
        if (r23 == null) goto L102;
        DressPageItemCommon r24 = r23.common;
        if (r24 == null) goto L102;
        Boolean r25 = Boolean.valueOf(r24.isUnlocked);
    L103:
        if (r4 == null) goto L107;
        MidiSkinDressPageItem r26 = r4.a;
        if (r26 == null) goto L107;
        r0 = r26.topRightImage;
    L107:
        if (r0 == null) goto L116;
        if (r4 == null) goto L116;
        MidiSkinDressPageItem r27 = r4.a;
        if (r27 == null) goto L116;
        k r28 = r27.topRightImage;
        if (r28 == null) goto L116;
        if (r28.isValid() != true) goto L116;
        String r29 = "1";
    L117:
        String r30 = r29;
        ((RecyclerView.ViewHolder) r14).itemView.setOnClickListener(new d(r14, r25, r30, r4, r122, r20));
        yd2.a r31 = r14.e.c;
        r31.getClass();
        Intrinsics.checkNotNullParameter("midi", "key");
        ((RecyclerView.ViewHolder) r14).itemView.post(new e(r14, r31.a.get("midi"), r122, r25, r30));
        return;
    L116:
        r29 = BDLocationException.ERROR_TIMEOUT;
    L102:
        r25 = null;
    L95:
        r122 = "";
        goto L96
    L85:
        if (r119.intValue() != r22) goto L87;
        a1.n(((RecyclerView.ViewHolder) r14).itemView, s1.f(8.0f));
        a1.p(((RecyclerView.ViewHolder) r14).itemView, s1.f(156.0f));
        a1.k(((RecyclerView.ViewHolder) r14).itemView, s1.f(70.0f));
        goto L88
    L80:
        r119 = null;
        goto L81
    L76:
        r21 = 2131249309;
    L72:
        r20 = false;
    L45:
        r9 = null;
        goto L46
    L49:
        HSImageView r123 = (HSImageView) r14.c.getValue();
        if (r123 == null) goto L52;
        r123.setVisibility(8);
    L38:
        r112 = null;
        goto L39
    L31:
        TextView r124 = (TextView) r14.b.getValue();
        if (r124 == null) goto L34;
        r124.setVisibility(8);
    L15:
        r18 = null;
    L7:
        r2 = null;
        goto L8
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new KtvMidiSkinViewHolder(this, r4.inflate(2131566492, r5, false));
    }
}
