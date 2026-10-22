package com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.ktvapi.config.ScrollLyricConfigV2;
import com.bytedance.android.livesdk.ktvimpl.base.lyricmodule.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\t\n\u000b\fR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyricv2/view/ScrollLyricAdapterV2;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyricv2/view/ScrollLyricAdapterV2$AbsLineViewHolder;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "AbsLineViewHolder", "a", "PlaceHolderLineViewHolder", "SingleLineViewHolder", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ScrollLyricAdapterV2 extends RecyclerView.Adapter<AbsLineViewHolder> {
    public static final /* synthetic */ int e = 0;
    public final b a;
    public final Context b;
    public final ScrollLyricConfigV2 c;
    public final d d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyricv2/view/ScrollLyricAdapterV2$AbsLineViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static abstract class AbsLineViewHolder extends RecyclerView.ViewHolder {
        public final ScrollLyricConfigV2 a;

        public abstract void T3(com.bytedance.component.lyric.model.b r1, int r2);

        public abstract void U3();

        public AbsLineViewHolder(View r2, ScrollLyricConfigV2 r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "config");
            super(r2);
            this.a = r3;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyricv2/view/ScrollLyricAdapterV2$PlaceHolderLineViewHolder;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyricv2/view/ScrollLyricAdapterV2$AbsLineViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class PlaceHolderLineViewHolder extends AbsLineViewHolder {
        public final View b;

        @Override // com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.ScrollLyricAdapterV2.AbsLineViewHolder
        public final void U3() {
        }

        public PlaceHolderLineViewHolder(View r2, ScrollLyricConfigV2 r3) {
            Intrinsics.checkNotNullParameter(r2, "emptyView");
            Intrinsics.checkNotNullParameter(r3, "config");
            super(r2, r3);
            this.b = r2;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.ScrollLyricAdapterV2.AbsLineViewHolder
        public final void T3(com.bytedance.component.lyric.model.b r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "lyricLine");
            View r4 = this.b;
            ViewGroup.LayoutParams r5 = r4.getLayoutParams();
            if (r5 == null) goto L5;
            r5.height = this.a.m;
            Unit r0 = Unit.INSTANCE;
        L6:
            r4.setLayoutParams(r5);
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyricv2/view/ScrollLyricAdapterV2$SingleLineViewHolder;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyricv2/view/ScrollLyricAdapterV2$AbsLineViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class SingleLineViewHolder extends AbsLineViewHolder {
        public com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.a b;
        public Integer c;
        public final FrameLayout d;
        public final com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.b e;

        @Override // com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.ScrollLyricAdapterV2.AbsLineViewHolder
        public final void U3() {
            com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.b r0 = this.e;
            if (r0.b == false) goto L5;
            r0.setInSweeping(false);
        L5:
            this.e.setNeedHighLight(false);
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.ScrollLyricAdapterV2.AbsLineViewHolder
        public final void T3(com.bytedance.component.lyric.model.b r6, int r7) {
            Intrinsics.checkNotNullParameter(r6, "lyricLine");
            if (r6.a != 2) goto L13;
            this.d.removeView(this.b);
            FrameLayout r0 = this.d;
            com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.a r1 = new com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.a(this.d.getContext(), this.a);
            Integer r2 = this.c;
            if (r2 == null) goto L12;
            int r3 = r2.intValue();
            if (r3 <= 0) goto L12;
            r1.c = r3;
            int r4 = r1.b;
            if (r3 <= r4) goto L11;
            r1.c = r4;
        L11:
            r1.invalidate();
        L12:
            this.b = r1;
            r1.setVisibility(8);
            Unit r5 = Unit.INSTANCE;
            r0.addView(r1, new ViewGroup.LayoutParams(-1, UtilityKotlinExtentionsKt.i(6)));
        L17:
            this.e.setPos(r7);
            ScrollLyricConfigV2 r8 = this.a;
            if (r8.p == false) goto L25;
            Integer r9 = (Integer) r8.n.getValue();
            if (r9 == null) goto L25;
            if (r7 != r9.intValue()) goto L25;
            boolean r10 = true;
        L26:
            this.e.setNeedHighLight(r10);
            this.e.setLyricLine(r6);
            ScrollLyricConfigV2 r11 = this.a;
            if (r7 == r11.i) goto L37;
            Integer r12 = r11.f;
            if (r12 != null) goto L32;
        L34:
            com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.b r13 = this.e;
            if (r13.b == false) goto L41;
            r13.setInSweeping(false);
            return;
        L41:
            return;
        L32:
            if (r7 != r12.intValue()) goto L34;
        L37:
            com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.b r14 = this.e;
            if (r14.b == true) goto L43;
            r14.setInSweeping(true);
            return;
        L43:
            return;
        L25:
            r10 = false;
            goto L26
        L13:
            com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.a r15 = this.b;
            if (r15 == null) goto L16;
            this.d.removeView(r15);
            this.c = null;
            goto L17
        L16:
            this.c = null;
            goto L17
        }

        public SingleLineViewHolder(FrameLayout r2, com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.b r3, ScrollLyricConfigV2 r4) {
            Intrinsics.checkNotNullParameter(r2, "container");
            Intrinsics.checkNotNullParameter(r3, "singleLineView");
            Intrinsics.checkNotNullParameter(r4, "config");
            super(r2, r4);
            this.d = r2;
            this.e = r3;
            r2.addView(r3);
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ScrollLyricAdapterV2 a;

        public b(ScrollLyricAdapterV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if ((r2 instanceof com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.b) == true) goto L6;
            r2 = null;
        L6:
            if (((com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.b) r2) == null) goto L9;
            ScrollLyricAdapterV2 r3 = this.a;
            int r0 = ScrollLyricAdapterV2.e;
            r3.getClass();
            return;
        }
    }

    static {
        new ArrayList();
    }

    public final int getItemCount() {
        return this.d.a.size();
    }

    public final Context getContext() {
        return this.b;
    }

    public final int getItemViewType(int r3) {
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.d.a, r3)).a != 2) goto L6;
        return 1;
    L6:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.d.a, r3)).a == 3) goto L11;
        return 0;
    L11:
        return 2;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        AbsLineViewHolder r3 = (AbsLineViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled(r3);
        r3.U3();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        AbsLineViewHolder r4 = (AbsLineViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "vh");
        r4.T3((com.bytedance.component.lyric.model.b) ListProtector.get(this.d.a, r3), r3);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        int r0 = ((com.bytedance.android.livesdk.ktvapi.config.a) this.c).a;
        if (r0 > 0) goto L6;
        r0 = -2;
    L6:
        if (r5 != 2) goto L8;
        View r6 = new View(r4.getContext());
        r6.setLayoutParams(new ViewGroup.LayoutParams(1, this.c.m));
        Unit r7 = Unit.INSTANCE;
        return new PlaceHolderLineViewHolder(r6, this.c);
    L8:
        FrameLayout r8 = new FrameLayout(r4.getContext());
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, r0));
        Unit r1 = Unit.INSTANCE;
        com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.b r2 = new com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.b(r4.getContext(), this.c);
        r2.setOnClickListener(this.a);
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new SingleLineViewHolder(r8, r2, this.c);
    }

    public ScrollLyricAdapterV2(Context r2, ScrollLyricConfigV2 r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "model");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new b(this);
        Function1<List<com.bytedance.component.lyric.model.b>, Unit> r5 = new AnonymousClass1(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "cb");
        r4.e.add(r5);
    }
}
