package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonStackAvatarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonStackAvatarViewHolder;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvCommonStackAvatarAdapter extends RecyclerView.Adapter<KtvCommonStackAvatarViewHolder> {
    public String a;
    public final int b;
    public final List<py.k> c;
    public int d;
    public String e;
    public int f;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public KtvCommonStackAvatarAdapter() {
        this.a = "scene_ktv_component";
        this.b = s1.f(3.0f);
        this.c = new ArrayList();
        this.e = BDLocationException.ERROR_TIMEOUT;
    }

    public final int getItemViewType(int r6) {
        if (Intrinsics.areEqual(this.a, "scene_video_chorus_top_control") == true) goto L18;
        if (Intrinsics.areEqual(this.a, "scene_video_chorus_ordered_list") == true) goto L18;
        int r0 = this.d;
        int r4 = this.f;
        if (r0 >= r4) goto L11;
    L9:
        return 0;
    L11:
        if (r6 != (r4 - 1)) goto L14;
        return 2;
    L14:
        if (r6 != (r4 - 2)) goto L9;
        return 1;
    L18:
        if (r6 == (this.f - 1)) goto L24;
        return 0;
    L24:
        return 2;
    }

    public static void y2(View r2, int r3) {
        if ((r2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if (r0 == null) goto L8;
        ((ViewGroup.MarginLayoutParams) r0).setMargins(r3, 0, 0, 0);
        r2.requestLayout();
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        KtvCommonStackAvatarViewHolder r11 = (KtvCommonStackAvatarViewHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        int r0 = ((ArrayList) this.c).size();
        if (r10 < 0) goto L45;
        if (r0 <= r10) goto L42;
        py.k r1 = (py.k) ListProtector.get(this.c, r10);
        int r2 = this.d;
        String r3 = this.e;
        String r4 = this.a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r1, "model");
        Intrinsics.checkNotNullParameter(r3, "totalCountStr");
        Intrinsics.checkNotNullParameter(r4, "scene");
        r11.c = r1;
        HSImageView r5 = (HSImageView) r11.a.getValue();
        if (r5 == null) goto L10;
        ImageUtil.loadRoundImage(r5, r1);
    L10:
        if (Intrinsics.areEqual(r4, "scene_video_chorus_top_control") == false) goto L12;
    L15:
        int r6 = 2131918639;
    L17:
        if (Intrinsics.areEqual(r4, "scene_video_chorus_top_control") == false) goto L19;
    L24:
        TextView r7 = (TextView) r11.b.getValue();
        if (r7 == null) goto L28;
        r7.setText(s1.C(r6, new Object[]{r3}));
    L28:
        if (Intrinsics.areEqual(r4, "scene_video_chorus_ordered_list") == false) goto L32;
        TextView r8 = (TextView) r11.b.getValue();
        if (r8 == null) goto L35;
        r8.setTextColor(ColorProtector.parseColor("#898A8F"));
    L35:
        if (r10 != 0) goto L38;
        y2(((RecyclerView.ViewHolder) r11).itemView, 0);
        return;
    L38:
        if (r10 != (this.f - 1)) goto L40;
        y2(((RecyclerView.ViewHolder) r11).itemView, this.b);
        return;
    L40:
        y2(((RecyclerView.ViewHolder) r11).itemView, -this.b);
        return;
    L32:
        TextView r12 = (TextView) r11.b.getValue();
        if (r12 == null) goto L35;
        r12.setTextColor(ColorProtector.parseColor("#B3FFFFFF"));
        goto L35
    L19:
        if (Intrinsics.areEqual(r4, "scene_video_chorus_ordered_list") == true) goto L24;
        TextView r13 = (TextView) r11.b.getValue();
        if (r13 == null) goto L28;
        r13.setText(s1.C(r6, new Object[]{Integer.valueOf(r2)}));
        goto L28
    L12:
        if (Intrinsics.areEqual(r4, "scene_video_chorus_ordered_list") == true) goto L15;
        r6 = 2131918435;
        goto L17
    L42:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        LayoutInflater r1 = LayoutInflater.from(r5.getContext());
        if (r6 != 0) goto L6;
        int r7 = 2131566543;
    L13:
        return new KtvCommonStackAvatarViewHolder(r1.inflate(r7, r5, false));
    L6:
        if (r6 != 1) goto L9;
        r7 = 2131566544;
        goto L13
    L9:
        if (r6 != 2) goto L11;
        r7 = 2131566545;
        goto L13
    L11:
        r7 = 0;
        goto L13
    }
}
