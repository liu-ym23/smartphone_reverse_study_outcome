package com.bytedance.ee.bear.office.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeFolderHeaderView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f235512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f235513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super View, Unit> f235514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f235515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f235516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f235517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f235518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f235519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f235520i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f235521j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f235522k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f235523l;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeFolderHeaderView f235524a;

        public a(OfficeFolderHeaderView r100) {
            this.f235524a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f235524a.getOnCancelSelectionClick();
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<View, Unit> f235525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f235526b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super View, Unit> r100, ImageView r101) {
            this.f235525a = r100;
            this.f235526b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f235525a.invoke(this.f235526b);
        }
    }

    public final Function0<Unit> getOnBackClick() {
        return this.f235512a;
    }

    public final Function0<Unit> getOnCancelSelectionClick() {
        return this.f235515d;
    }

    public final Function1<View, Unit> getOnMoreClick() {
        return this.f235514c;
    }

    public final Function0<Unit> getOnSearchClick() {
        return this.f235513b;
    }

    public OfficeFolderHeaderView(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        this.f235516e = "";
        int r100 = a(72);
        int r101 = a(104);
        int r102 = d.f235887a;
        int r103 = Math.max(r100, r101);
        this.f235518g = r103;
        ImageView r104 = b(R.drawable.office_ic_folder_header_back, new OfficeFolderHeaderView$backButton$1(this));
        this.f235519h = r104;
        ImageView r105 = b(R.drawable.office_ic_folder_header_search, new OfficeFolderHeaderView$searchButton$1(this));
        this.f235520i = r105;
        ImageView r106 = b(R.drawable.office_ic_screen_menu_more, new OfficeFolderHeaderView$moreButton$1(this));
        this.f235521j = r106;
        TextView r107 = new TextView(r110);
        r107.setText(r110.getString(R.string.LarkCCM_Common_Cancel_Button));
        r107.setGravity(17);
        r107.setTextColor(ContextCompat.getColor(r110, R.color.text_title));
        r107.setTextSize(16.0f);
        r107.setVisibility(8);
        r107.setClickable(true);
        r107.setOnClickListener(new a(this));
        this.f235522k = r107;
        TextView r108 = new TextView(r110);
        r108.setGravity(17);
        r108.setMaxLines(1);
        r108.setEllipsize(TextUtils.TruncateAt.END);
        r108.setTextColor(ContextCompat.getColor(r110, R.color.text_title));
        r108.setTextSize(17.0f);
        r108.setTypeface(Typeface.DEFAULT_BOLD);
        this.f235523l = r108;
        setBackgroundColor(ContextCompat.getColor(r110, R.color.bg_body));
        setLayoutParams(new FrameLayout.LayoutParams(-1, a(60)));
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(a(40), a(40), 8388627);
        r111.setMarginStart(a(4));
        Unit r112 = Unit.INSTANCE;
        addView(r104, r111);
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(a(64), -1, 8388627);
        r113.setMarginStart(a(4));
        addView(r107, r113);
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(-2, -1, 17);
        r114.setMarginStart(r103);
        r114.setMarginEnd(r103);
        addView(r108, r114);
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(a(40), a(40), 8388629);
        r115.setMarginEnd(a(52));
        addView(r105, r115);
        FrameLayout.LayoutParams r116 = new FrameLayout.LayoutParams(a(40), a(40), 8388629);
        r116.setMarginEnd(a(12));
        addView(r106, r116);
    }

    public final int a(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final void setOnBackClick(Function0<Unit> r100) {
        this.f235512a = r100;
    }

    public final void setOnCancelSelectionClick(Function0<Unit> r100) {
        this.f235515d = r100;
    }

    public final void setOnMoreClick(Function1<? super View, Unit> r100) {
        this.f235514c = r100;
    }

    public final void setOnSearchClick(Function0<Unit> r100) {
        this.f235513b = r100;
    }

    public final void setSelectionMode(boolean r100) {
        if (this.f235517f != r100) goto L5;
        return;
    L5:
        this.f235517f = r100;
        TextView r101 = this.f235522k;
        int r102 = 0;
        if (r100 == false) goto L8;
        int r103 = 0;
    L9:
        r101.setVisibility(r103);
        ImageView r104 = this.f235519h;
        if (r100 == false) goto L12;
        int r105 = 8;
    L13:
        r104.setVisibility(r105);
        ImageView r106 = this.f235520i;
        if (r100 == false) goto L16;
        int r107 = 8;
    L17:
        r106.setVisibility(r107);
        ImageView r108 = this.f235521j;
        if (r100 == false) goto L20;
        r102 = 8;
    L20:
        r108.setVisibility(r102);
        TextView r109 = this.f235523l;
        if (r100 == false) goto L23;
        String r110 = "";
    L24:
        r109.setText(r110);
        return;
    L23:
        r110 = this.f235516e;
        goto L24
    L16:
        r107 = 0;
        goto L17
    L12:
        r105 = 0;
        goto L13
    L8:
        r103 = 8;
        goto L9
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f235516e = r100;
        if (this.f235517f == true) goto L6;
        this.f235523l.setText(r100);
        return;
    }

    public final ImageView b(int r100, Function1<? super View, Unit> r101) {
        ImageView r102 = new ImageView(getContext());
        r102.setImageResource(r100);
        r102.setColorFilter(ContextCompat.getColor(r102.getContext(), R.color.text_title));
        r102.setScaleType(ImageView.ScaleType.CENTER);
        r102.setPadding(a(8), a(8), a(8), a(8));
        r102.setClickable(true);
        r102.setOnClickListener(new b(r101, r102));
        return r102;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        TextView r102 = this.f235523l;
        int r103 = d.f235887a;
        r102.setMaxWidth(RangesKt.coerceAtLeast(View.MeasureSpec.getSize(r100) - (this.f235518g * 2), 0));
        super.onMeasure(r100, r101);
    }
}
