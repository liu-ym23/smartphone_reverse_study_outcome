package com.bytedance.ee.bear.office.common.upload;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeUploadListPanel extends FrameLayout {
    public final OfficeUploadListAdapter a;
    public final LinearLayout b;
    public final TextView c;
    public final RecyclerView d;
    public List<u> e;
    public Function1<? super u, Unit> f;
    public Function1<? super u, Unit> g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ OfficeUploadListPanel a;

        public a(OfficeUploadListPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.setVisibility(8);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ OfficeUploadListPanel a;

        public b(OfficeUploadListPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.setVisibility(8);
        }
    }

    public OfficeUploadListPanel(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        OfficeUploadListAdapter r0 = new OfficeUploadListAdapter(new OfficeUploadListPanel$adapter$1(this), new OfficeUploadListPanel$adapter$2(this));
        this.a = r0;
        LinearLayout r1 = new LinearLayout(r10);
        r1.setOrientation(1);
        r1.setBackground(ContextCompat.getDrawable(r10, 2131244663));
        r1.setVisibility(4);
        r1.setClickable(true);
        this.b = r1;
        TextView r3 = new TextView(r10);
        r3.setTextColor(ContextCompat.getColor(r10, 2131103959));
        r3.setTextSize(17.0f);
        r3.setTypeface(Typeface.DEFAULT_BOLD);
        r3.setIncludeFontPadding(false);
        this.c = r3;
        ImageView r4 = new ImageView(r10);
        r4.setImageResource(2131244690);
        r4.setContentDescription(null);
        RecyclerView r5 = new RecyclerView(r10);
        r5.setLayoutManager(new LinearLayoutManager(r10));
        r5.setAdapter(r0);
        r5.setOverScrollMode(2);
        r5.setBackgroundColor(ContextCompat.getColor(r10, 2131103958));
        this.d = r5;
        this.e = CollectionsKt.emptyList();
        setBackgroundColor(ContextCompat.getColor(r10, 2131103956));
        setElevation(e.a(r10, 8));
        setClickable(true);
        setOnClickListener(new a(this));
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -2);
        r2.gravity = 80;
        Unit r8 = Unit.INSTANCE;
        addView(r1, r2);
        FrameLayout r6 = new FrameLayout(getContext());
        r6.setClickable(true);
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        r7.gravity = 8388627;
        r7.leftMargin = e.a(r6.getContext(), 20);
        r6.addView(r3, r7);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(e.a(r6.getContext(), 30), e.a(r6.getContext(), 30));
        r9.gravity = 8388629;
        r9.rightMargin = e.a(r6.getContext(), 13);
        r6.addView(r4, r9);
        r1.addView(r6, new LinearLayout.LayoutParams(-1, e.a(r10, 56)));
        r1.addView(r5, new LinearLayout.LayoutParams(-1, e.a(r10, 240)));
        r4.setOnClickListener(new b(this));
    }

    public final void a(List<u> r4) {
        Intrinsics.checkNotNullParameter(r4, "items");
        this.e = r4;
        TextView r0 = this.c;
        k0 r1 = k0.a;
        Context r2 = getContext();
        r1.getClass();
        r0.setText(k0.b(r2, r4));
        this.a.submitList(r4);
        Resources r3 = getResources();
        int r5 = (int) (WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).heightPixels * 0.8f);
        int r6 = RangesKt.coerceAtLeast(r4.size() * e.a(getContext(), 80), e.a(getContext(), 80));
        RecyclerView r7 = this.d;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        r8.height = RangesKt.coerceAtMost(r6, r5);
        r7.setLayoutParams(r8);
    }

    public final void setOnRemoveClickListener(Function1<? super u, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f = r2;
    }

    public final void setOnRetryClickListener(Function1<? super u, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g = r2;
    }
}
