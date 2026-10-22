package com.bytedance.awemeopen.apps.framework.feed.mix;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.bizmodels.feed.Video;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import r14.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0005\u0006\u0007B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/mix/MixAwemeListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "a", "b", "c", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MixAwemeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final /* synthetic */ int e = 0;
    public final q24.c a;
    public final int b;
    public List<c> c;
    public Function1<? super r14.c, Unit> d;

    public static final class a {
    }

    public static final class b extends DiffUtil.Callback {
        public final List<c> a;
        public final List<c> b;

        public final int getNewListSize() {
            return this.a.size();
        }

        public final int getOldListSize() {
            return this.b.size();
        }

        public b(List<c> r2, List<c> r3) {
            Intrinsics.checkNotNullParameter(r2, "newData");
            Intrinsics.checkNotNullParameter(r3, "oldData");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r4, int r5) {
            r14.c r0 = ((c) ListProtector.get(this.b, r4)).a;
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.c();
        L6:
            r14.c r3 = ((c) ListProtector.get(this.a, r5)).a;
            if (r3 == null) goto L10;
            r1 = r3.c();
        L10:
            if (Intrinsics.areEqual(r2, r1) == true) goto L12;
        L18:
            return false;
        L12:
            if (((c) ListProtector.get(this.b, r4)).b != ((c) ListProtector.get(this.a, r5)).b) goto L18;
            if (((c) ListProtector.get(this.b, r4)).c != ((c) ListProtector.get(this.a, r5)).c) goto L18;
            if (((c) ListProtector.get(this.b, r4)).d != ((c) ListProtector.get(this.a, r5)).d) goto L18;
            return true;
        L5:
            r2 = null;
            goto L6
        }

        public final boolean areItemsTheSame(int r3, int r4) {
            r14.c r5 = ((c) ListProtector.get(this.b, r3)).a;
            String r0 = null;
            if (r5 == null) goto L5;
            String r6 = r5.c();
        L6:
            r14.c r7 = ((c) ListProtector.get(this.a, r4)).a;
            if (r7 == null) goto L10;
            r0 = r7.c();
        L10:
            return Intrinsics.areEqual(r6, r0);
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class c {
        public final r14.c a;
        public final boolean b;
        public final boolean c;
        public final boolean d;

        public c(r14.c r1, boolean r2, boolean r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final int getItemCount() {
        return this.c.size();
    }

    public final r14.c y2() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        c r1 = (c) r0.next();
        r14.c r2 = r1.a;
        if (r2 == null) goto L4;
        if (r1.b == false) goto L4;
        return r2;
    L10:
        return null;
    }

    public MixAwemeListAdapter() {
        d14.a r0 = b14.a.a;
        this.a = b14.a.a(q24.c.class);
        Resources r1 = Resources.getSystem();
        this.b = MathKt.roundToInt(TypedValue.applyDimension(1, 300, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
        this.c = new ArrayList();
    }

    public final int getItemViewType(int r2) {
        c r3 = (c) ListProtector.get(this.c, r2);
        if (r3.c == false) goto L7;
        return 1;
    L7:
        if (r3.d == false) goto L10;
        return 2;
    L10:
        return 0;
    }

    public final void setData(List<c> r3) {
        Intrinsics.checkNotNullParameter(r3, "newData");
        DiffUtil.DiffResult r0 = DiffUtil.calculateDiff(new b(r3, this.c));
        this.c = r3;
        r0.dispatchUpdatesTo(this);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        boolean r1 = true;
        if ((r8 instanceof MixAwemeListLoadingViewHolder) == false) goto L6;
        MixAwemeListLoadingViewHolder r0 = (MixAwemeListLoadingViewHolder) r8;
        r0.a.setResumeWhenAttached(true);
        r0.a.c();
    L6:
        if ((r8 instanceof MixAwemeListViewHolder) == false) goto L66;
        final r14.c r2 = ((c) ListProtector.get(this.c, r9)).a;
        if (r2 != null) goto L10;
        return;
    L10:
        r8.itemView.setOnClickListener(new m(this, r2));
        int r3 = 0;
        if (((c) ListProtector.get(this.c, r9)).b == false) goto L13;
        r8.itemView.setBackgroundResource(2131100293);
    L14:
        Video r10 = r2.P();
        if (r10 != null) goto L17;
    L52:
        ((MixAwemeListViewHolder) r8).a.setImageResource(2131231542);
    L53:
        MixAwemeListViewHolder r4 = (MixAwemeListViewHolder) r8;
        r4.b.setText(y.a(r2));
        if (r10 == null) goto L56;
        r3 = r10.getDuration();
    L56:
        int r5 = r3 / ECDraweeView.SQUARE;
        int r11 = r5 % 60;
        if (r11 >= 10) goto L59;
        String r12 = "0" + r11;
    L60:
        int r6 = r5 / 60;
        if (r6 >= 10) goto L63;
        String r7 = "0" + r6;
    L64:
        r4.c.setText(r7 + ':' + r12);
        x04.a.a(r4.d, this.a.f0(r8.itemView.getContext(), r2));
        return;
    L63:
        r7 = String.valueOf(r6);
        goto L64
    L59:
        r12 = String.valueOf(r11);
        goto L60
    L17:
        if (r10.getPlayAddr() == null) goto L52;
        j0 r13 = r10.getPlayAddr();
        List r14 = null;
        if (r13 == null) goto L21;
        List r15 = r13.g();
    L23:
        if (com.bytedance.awemeopen.infra.util.d.a(r15) == true) goto L52;
        if (com.bytedance.awemeopen.apps.framework.utils.f.a(r10.getOriginCover()) == false) goto L52;
        if (r10.getHeight() >= this.b) goto L29;
        ((MixAwemeListViewHolder) r8).a.setBackgroundResource(2131231413);
    L30:
        int r16 = com.bytedance.awemeopen.bizmodels.user.d.a;
        d14.a r17 = b14.a.a;
        com.bytedance.awemeopen.bizmodels.user.c r18 = b14.a.a(k34.b.class).getAccessToken();
        if (r18 == null) goto L34;
        String r19 = r18.b;
        if (r19 == null) goto L34;
    L35:
        Intrinsics.checkNotNullParameter(r19, "openId");
        if (com.bytedance.awemeopen.bizmodels.user.d.c(r2, r19) == true) goto L38;
    L40:
        r1 = false;
    L41:
        if (r1 == false) goto L44;
        ((MixAwemeListViewHolder) r8).a.setImageResource(2131231542);
        return;
    L44:
        Video r20 = r2.P();
        if (r20 == null) goto L50;
        t14.a r21 = r20.getOriginCover();
        if (r21 == null) goto L49;
        r14 = r21.g();
    L49:
        if (r14 == null) goto L50;
    L51:
        AoImageView r22 = ((MixAwemeListViewHolder) r8).a;
        com.bytedance.awemeopen.infra.base.image.b r23 = new com.bytedance.awemeopen.infra.base.image.b(r14);
        r23.m = ImageView.ScaleType.CENTER_CROP;
        r22.j(r23);
    L50:
        r14 = new ArrayList();
        goto L51
    L38:
        if (r2.Z() == false) goto L40;
    L34:
        r19 = "";
        goto L35
    L29:
        ((MixAwemeListViewHolder) r8).a.setBackgroundResource(2131231414);
        goto L30
    L21:
        r15 = null;
        goto L23
    L13:
        r8.itemView.setBackgroundColor(0);
        goto L14
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        if (r8 != 2) goto L6;
        int r9 = MixAwemeListLoadingViewHolder.b;
        return MixAwemeListLoadingViewHolder.a.a(r7.getContext());
    L6:
        if (r8 != 1) goto L8;
        int r10 = MixAwemeListLoadingViewHolder.b;
        return MixAwemeListLoadingViewHolder.a.a(r7.getContext());
    L8:
        int r11 = MixAwemeListViewHolder.e;
        Context r12 = r7.getContext();
        Intrinsics.checkNotNullParameter(r12, "context");
        x r13 = new x(r12);
        View r1 = r13.j();
        AoImageView r0 = r13.c;
        if (r0 == null) goto L11;
        AoImageView r3 = r0;
    L12:
        TextView r2 = r13.d;
        if (r2 == null) goto L15;
        TextView r4 = r2;
    L16:
        TextView r5 = r13.e;
        if (r5 == null) goto L19;
        TextView r6 = r5;
    L20:
        TextView r14 = r13.f;
        if (r14 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("likeCount");
        r14 = null;
    L25:
        return new MixAwemeListViewHolder(r1, r3, r4, r6, r14);
    L19:
        Intrinsics.throwUninitializedPropertyAccessException("time");
        r6 = null;
        goto L20
    L15:
        Intrinsics.throwUninitializedPropertyAccessException("desc");
        r4 = null;
        goto L16
    L11:
        Intrinsics.throwUninitializedPropertyAccessException("img");
        r3 = null;
        goto L12
    }
}
