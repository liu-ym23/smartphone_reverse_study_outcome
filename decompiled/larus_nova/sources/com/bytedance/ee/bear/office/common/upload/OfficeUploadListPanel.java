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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeUploadListPanel extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeUploadListAdapter f235273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f235274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f235275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f235276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<u> f235277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super u, Unit> f235278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super u, Unit> f235279g;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeUploadListPanel f235280a;

        public a(OfficeUploadListPanel r100) {
            this.f235280a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f235280a.setVisibility(8);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeUploadListPanel f235281a;

        public b(OfficeUploadListPanel r100) {
            this.f235281a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f235281a.setVisibility(8);
        }
    }

    public OfficeUploadListPanel(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        OfficeUploadListAdapter r100 = new OfficeUploadListAdapter(new OfficeUploadListPanel$adapter$1(this), new OfficeUploadListPanel$adapter$2(this));
        this.f235273a = r100;
        LinearLayout r101 = new LinearLayout(r110);
        r101.setOrientation(1);
        r101.setBackground(ContextCompat.getDrawable(r110, R.drawable.office_bg_upload_panel));
        r101.setVisibility(4);
        r101.setClickable(true);
        this.f235274b = r101;
        TextView r102 = new TextView(r110);
        r102.setTextColor(ContextCompat.getColor(r110, R.color.office_upload_text_primary));
        r102.setTextSize(17.0f);
        r102.setTypeface(Typeface.DEFAULT_BOLD);
        r102.setIncludeFontPadding(false);
        this.f235275c = r102;
        ImageView r103 = new ImageView(r110);
        r103.setImageResource(R.drawable.office_ic_upload_panel_close);
        r103.setContentDescription(null);
        RecyclerView r104 = new RecyclerView(r110);
        r104.setLayoutManager(new LinearLayoutManager(r110));
        r104.setAdapter(r100);
        r104.setOverScrollMode(2);
        r104.setBackgroundColor(ContextCompat.getColor(r110, R.color.office_upload_surface));
        this.f235276d = r104;
        this.f235277e = CollectionsKt.emptyList();
        setBackgroundColor(ContextCompat.getColor(r110, R.color.office_upload_mask));
        setElevation(e.a(r110, 8));
        setClickable(true);
        setOnClickListener(new a(this));
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-1, -2);
        r105.gravity = 80;
        Unit r106 = Unit.INSTANCE;
        addView(r101, r105);
        FrameLayout r107 = new FrameLayout(getContext());
        r107.setClickable(true);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-2, -2);
        r108.gravity = 8388627;
        r108.leftMargin = e.a(r107.getContext(), 20);
        r107.addView(r102, r108);
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(e.a(r107.getContext(), 30), e.a(r107.getContext(), 30));
        r109.gravity = 8388629;
        r109.rightMargin = e.a(r107.getContext(), 13);
        r107.addView(r103, r109);
        r101.addView(r107, new LinearLayout.LayoutParams(-1, e.a(r110, 56)));
        r101.addView(r104, new LinearLayout.LayoutParams(-1, e.a(r110, 240)));
        r103.setOnClickListener(new b(this));
    }

    public final void a(List<u> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f235277e = r100;
        TextView r101 = this.f235275c;
        k0 r102 = k0.f235400a;
        Context r103 = getContext();
        r102.getClass();
        r101.setText(k0.b(r103, r100));
        this.f235273a.submitList(r100);
        Resources r104 = getResources();
        int r105 = (int) (WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).heightPixels * 0.8f);
        int r106 = RangesKt.coerceAtLeast(r100.size() * e.a(getContext(), 80), e.a(getContext(), 80));
        RecyclerView r107 = this.f235276d;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        r108.height = RangesKt.coerceAtMost(r106, r105);
        r107.setLayoutParams(r108);
    }

    public final void setOnRemoveClickListener(Function1<? super u, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f235278f = r100;
    }

    public final void setOnRetryClickListener(Function1<? super u, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f235279g = r100;
    }
}
