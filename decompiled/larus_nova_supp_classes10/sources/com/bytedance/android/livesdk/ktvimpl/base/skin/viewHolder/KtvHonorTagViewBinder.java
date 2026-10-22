package com.bytedance.android.livesdk.ktvimpl.base.skin.viewHolder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.livesdkapi.depend.message.DressPageItemCommon;
import com.bytedance.android.livesdkapi.depend.message.GetDressPageListMode;
import com.bytedance.android.livesdkapi.depend.message.TagDressPageItem;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvHonorTagViewBinder extends me.drakeet.multitype.b<a, KtvHonorTagViewHolder> {
    public final com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a b;
    public final yd2.a c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/skin/viewHolder/KtvHonorTagViewBinder$KtvHonorTagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class KtvHonorTagViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int f = 0;
        public final Lazy a;
        public final Lazy b;
        public final Lazy c;
        public final Lazy d;
        public final /* synthetic */ KtvHonorTagViewBinder e;

        public KtvHonorTagViewHolder(KtvHonorTagViewBinder r2, final View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.e = r2;
            super(r3);
            this.a = LazyKt.lazy(new KtvHonorTagViewBinder$KtvHonorTagViewHolder$avatar$2(r3));
            this.b = LazyKt.lazy(new KtvHonorTagViewBinder$KtvHonorTagViewHolder$honorTag$2(r3));
            this.c = LazyKt.lazy(new KtvHonorTagViewBinder$KtvHonorTagViewHolder$lockImage$2(r3));
            this.d = LazyKt.lazy(new KtvHonorTagViewBinder$KtvHonorTagViewHolder$expiredTime$2(r3));
        }
    }

    public static final class a {
        public final k a;
        public final TagDressPageItem b;
        public final int c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            k r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            TagDressPageItem r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return ((r3 + r1) * 31) + this.c;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "KtvHonorTagData(avatar=" + this.a + ", tagDressPageItem=" + this.b + ", mode=" + this.c + ")";
        }

        public a(k r2, TagDressPageItem r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "tagDressPageItem");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public KtvHonorTagViewBinder(com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r2, yd2.a r3) {
        Intrinsics.checkNotNullParameter(r3, "reportWrapper");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r12, Object r13) {
        KtvHonorTagViewHolder r14 = (KtvHonorTagViewHolder) r12;
        a r15 = (a) r13;
        Intrinsics.checkNotNullParameter(r14, "viewHolder");
        Intrinsics.checkNotNullParameter(r15, "data");
        HSImageView r0 = (HSImageView) r14.a.getValue();
        if (r15 == null) goto L5;
        k r1 = r15.a;
    L6:
        ImageUtil.loadRoundImageAntiFlink(r0, r1, 0);
        if (r15 == null) goto L11;
        TagDressPageItem r2 = r15.b;
        if (r2 == null) goto L11;
        MicPosTagInfo r3 = r2.micPosTagInfo;
    L12:
        if (r3 == null) goto L27;
        TextView r4 = (TextView) r14.b.getValue();
        if (r4 == null) goto L16;
        r4.post(new c(r14, r3));
    L16:
        String r5 = r3.getPositionTagName();
        if (r5 == null) goto L22;
        TextView r6 = (TextView) r14.b.getValue();
        if (r6 == null) goto L22;
        r6.setText(r5);
    L22:
        if (TextUtils.isEmpty(r3.getTextColor()) == true) goto L27;
        TextView r7 = (TextView) r14.b.getValue();
        if (r7 == null) goto L27;
        r7.setTextColor(ColorProtector.parseColor(r3.getTextColor()));
    L27:
        if (r15 == null) goto L35;
        TagDressPageItem r8 = r15.b;
        if (r8 == null) goto L35;
        DressPageItemCommon r9 = r8.common;
        if (r9 == null) goto L35;
        if (r9.isUnlocked != true) goto L35;
        ((View) r14.c.getValue()).setVisibility(8);
    L36:
        if (r15 == null) goto L42;
        TagDressPageItem r10 = r15.b;
        if (r10 == null) goto L42;
        DressPageItemCommon r11 = r10.common;
        if (r11 == null) goto L42;
        String r16 = r11.expireText;
    L44:
        if (TextUtils.isEmpty(r16) == true) goto L54;
        ((TextView) r14.d.getValue()).setVisibility(0);
        TextView r17 = (TextView) r14.d.getValue();
        if (r15 == null) goto L52;
        TagDressPageItem r18 = r15.b;
        if (r18 == null) goto L52;
        DressPageItemCommon r19 = r18.common;
        if (r19 == null) goto L52;
        String r20 = r19.expireText;
    L53:
        r17.setText(r20);
    L55:
        if (r15 == null) goto L63;
        TagDressPageItem r21 = r15.b;
        if (r21 == null) goto L63;
        DressPageItemCommon r22 = r21.common;
        if (r22 == null) goto L63;
        if (r22.isSelected != true) goto L63;
        boolean r23 = true;
    L64:
        View r24 = ((RecyclerView.ViewHolder) r14).itemView;
        if (r23 == false) goto L67;
        int r25 = 2131249311;
    L68:
        r24.setBackgroundResource(r25);
        if (r15 == null) goto L71;
        Integer r26 = Integer.valueOf(r15.c);
    L72:
        int r27 = GetDressPageListMode.LIST_MODE_FULL.getValue();
        if (r26 != null) goto L76;
    L78:
        a1.l(((RecyclerView.ViewHolder) r14).itemView, s1.f(14.0f));
    L79:
        if (r15 == null) goto L83;
        TagDressPageItem r28 = r15.b;
        if (r28 == null) goto L83;
        MicPosTagInfo r29 = r28.micPosTagInfo;
    L84:
        if (r15 == null) goto L90;
        TagDressPageItem r30 = r15.b;
        if (r30 == null) goto L90;
        DressPageItemCommon r31 = r30.common;
        if (r31 == null) goto L90;
        Boolean r32 = Boolean.valueOf(r31.isUnlocked);
    L91:
        ((RecyclerView.ViewHolder) r14).itemView.setOnClickListener(new com.bytedance.android.livesdk.ktvimpl.base.skin.viewHolder.a(r14, r29, r32, r15, r23));
        yd2.a r33 = r14.e.c;
        r33.getClass();
        Intrinsics.checkNotNullParameter("ksong", "key");
        List<String> r34 = r33.a.get("ksong");
        if (r15 == null) goto L98;
        TagDressPageItem r110 = r15.b;
        if (r110 == null) goto L98;
        DressPageItemCommon r111 = r110.common;
        if (r111 == null) goto L98;
        String r35 = r111.dressId;
    L99:
        ((RecyclerView.ViewHolder) r14).itemView.post(new b(r14, r34, r35, r29, r32));
        return;
    L98:
        r35 = null;
    L90:
        r32 = null;
    L83:
        r29 = null;
        goto L84
    L76:
        if (r26.intValue() != r27) goto L78;
        a1.l(((RecyclerView.ViewHolder) r14).itemView, s1.f(7.0f));
        goto L79
    L71:
        r26 = null;
        goto L72
    L67:
        r25 = 2131249320;
    L63:
        r23 = false;
    L52:
        r20 = null;
        goto L53
    L54:
        ((TextView) r14.d.getValue()).setVisibility(8);
    L42:
        r16 = null;
    L35:
        ((View) r14.c.getValue()).setVisibility(0);
    L11:
        r3 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new KtvHonorTagViewHolder(this, r4.inflate(2131566491, r5, false));
    }
}
