package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/view/secondleveltab/ApplyUserItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ApplyUserItemViewHolder extends RecyclerView.ViewHolder {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final d k;

    public static final class a {
    }

    static {
    }

    public static String T3(com.bytedance.android.live.ktv.common.model.bean.d r8) {
        int r1 = (int) r8.e();
        String r0 = r8.a();
        String r2 = "";
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (r1 <= 1) goto L12;
        String r9 = r8.c();
        if (r9.length() <= 7) goto L11;
        r9 = r9.substring(0, 7) + "...";
    L11:
        return s1.C(2131918294, new Object[]{r9, Integer.valueOf(r1), r0});
    L12:
        if (r1 != 1) goto L15;
        r2 = r8.c();
    L15:
        if (r2.length() <= 7) goto L18;
        r2 = r2.substring(0, 6) + "...";
    L18:
        return s1.C(2131918296, new Object[]{r2, r0});
    }

    public ApplyUserItemViewHolder(final View r4, d r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        this.k = r5;
        this.a = LazyKt.lazy(new ApplyUserItemViewHolder$avatarView$2(r4));
        this.b = LazyKt.lazy(new ApplyUserItemViewHolder$genderView$2(r4));
        Lazy r6 = LazyKt.lazy(new ApplyUserItemViewHolder$nickNameView$2(r4));
        this.c = r6;
        this.d = LazyKt.lazy(new ApplyUserItemViewHolder$highScoreLayout$2(r4));
        this.e = LazyKt.lazy(new ApplyUserItemViewHolder$ivHighScoreIcon$2(r4));
        this.f = LazyKt.lazy(new ApplyUserItemViewHolder$tvHighScore$2(r4));
        Lazy r0 = LazyKt.lazy(new ApplyUserItemViewHolder$microphoneIcon$2(r4));
        this.g = r0;
        Lazy r1 = LazyKt.lazy(new ApplyUserItemViewHolder$musicAndApplyTimeTv$2(r4));
        this.h = r1;
        this.i = LazyKt.lazy(new ApplyUserItemViewHolder$btnAccept$2(r4));
        Lazy r7 = LazyKt.lazy(new ApplyUserItemViewHolder$removeBtn$2(r4));
        this.j = r7;
        TextView r8 = (TextView) r6.getValue();
        if (r8 == null) goto L5;
        KtvOrderSongThemeManager.d(r8, KtvOrderSongThemeManager.G);
    L5:
        TextView r9 = (TextView) r1.getValue();
        if (r9 == null) goto L8;
        KtvOrderSongThemeManager.d(r9, KtvOrderSongThemeManager.H);
    L8:
        ImageView r10 = (ImageView) r0.getValue();
        if (r10 == null) goto L11;
        KtvOrderSongThemeManager.c(r10, KtvOrderSongThemeManager.I);
    L11:
        ImageView r11 = (ImageView) r7.getValue();
        if (r11 == null) goto L15;
        KtvOrderSongThemeManager.c(r11, KtvOrderSongThemeManager.J);
        return;
    }
}
