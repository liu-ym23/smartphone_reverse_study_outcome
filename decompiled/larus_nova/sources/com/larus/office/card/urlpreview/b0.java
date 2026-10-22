package com.larus.office.card.urlpreview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.larus.nova.R;
import com.lynx.textra.PlatformFontCaps;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class b0 extends FrameLayout {
    public static final int[] I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final float[] f361833J = null;
    public static final float[] K = null;
    public static final int[] L = null;
    public static final float[] M = null;
    public static final float[] N = null;
    public static final Set<OfficeUrlPreviewClientState> O = null;
    public static final Set<OfficeUrlPreviewClientState> P = null;
    public final ImageView A;
    public OfficeUrlPreviewClientState B;
    public boolean C;
    public Integer D;
    public Function0<Unit> E;
    public Function0<Unit> F;
    public Function0<Unit> G;
    public Function0<Unit> H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f361834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Typeface f361835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Typeface f361836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f361837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f361838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f361839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f361840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f361841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f361842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<k2> f361843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinearLayout f361844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f361845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f361846m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinearLayout f361847n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinearLayout f361848o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f361849p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final FrameLayout f361850q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinearLayout f361851r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f361852s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TextView f361853t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LinearLayout f361854u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LinearLayout f361855v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ImageView f361856w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ImageView f361857x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ImageView f361858y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ImageView f361859z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f361860a = null;

        static {
            int[] r100 = new int[OfficeUrlPreviewSourceKind.values().length];
            r100[OfficeUrlPreviewSourceKind.HTML.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[OfficeUrlPreviewSourceKind.MARKDOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[OfficeUrlPreviewSourceKind.OFFICE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f361860a = r100;
        }
    }

    static {
        I = new int[]{-1, 160, 100, 200};
        f361833J = new float[]{0.8f, 0.4f, 0.4f, 0.4f};
        K = new float[]{0.4f, 0.8f, 0.8f, 0.4f};
        L = new int[]{160, 80};
        M = new float[]{0.8f, 0.4f};
        N = new float[]{0.4f, 0.8f};
        OfficeUrlPreviewClientState r100 = OfficeUrlPreviewClientState.LOADING;
        O = SetsKt.setOf(new OfficeUrlPreviewClientState[]{OfficeUrlPreviewClientState.GENERATING, r100});
        P = SetsKt.setOf(new OfficeUrlPreviewClientState[]{r100, OfficeUrlPreviewClientState.PREVIEW_FAILED, OfficeUrlPreviewClientState.STATIC_CARD});
    }

    public final void d() {
        setVisibility(8);
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        setClickable(false);
        Iterator<T> r100 = this.f361843j.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((k2) r100.next()).b();
        goto L4
    }

    public final void e() {
        Iterator<T> r100 = this.f361843j.iterator();
    L4:
        if (r100.hasNext() == false) goto L20;
        final k2 r101 = (k2) r100.next();
        boolean r102 = false;
        if (isAttachedToWindow() == true) goto L8;
    L17:
        if (r102 == false) goto L18;
        r101.post(new z(this, r101));
        goto L4
    L18:
        r101.b();
        goto L4
    L8:
        if (getVisibility() != 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L17;
        if (O.contains(this.B) == false) goto L17;
        if (r101.isShown() == false) goto L17;
        r102 = true;
        goto L17
    L10:
        r103 = false;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Iterator<T> r100 = this.f361843j.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((k2) r100.next()).b();
        goto L4
    L6:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new u(this));
    }

    public b0(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        Typeface r100 = Typeface.create("sans-serif-medium", 0);
        this.f361834a = r100;
        this.f361835b = Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 1);
        this.f361836c = Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0);
        LinearLayout r101 = new LinearLayout(r110);
        this.f361837d = r101;
        FrameLayout r102 = new FrameLayout(r110);
        this.f361838e = r102;
        this.f361839f = new FrameLayout(r110);
        ImageView r103 = new ImageView(r110);
        this.f361840g = r103;
        TextView r104 = new TextView(r110);
        this.f361841h = r104;
        LinearLayout r105 = new LinearLayout(r110);
        this.f361842i = r105;
        this.f361843j = new ArrayList();
        this.f361844k = new LinearLayout(r110);
        this.f361845l = new TextView(r110);
        this.f361846m = new TextView(r110);
        this.f361847n = new LinearLayout(r110);
        this.f361848o = new LinearLayout(r110);
        this.f361849p = new ImageView(r110);
        this.f361850q = new FrameLayout(r110);
        this.f361851r = new LinearLayout(r110);
        this.f361852s = new TextView(r110);
        this.f361853t = new TextView(r110);
        this.f361854u = new LinearLayout(r110);
        this.f361855v = new LinearLayout(r110);
        this.f361856w = b(R.drawable.larus_ic_card_deep_research_report_copy, R.string.larus_accessibility_icon_copy);
        this.f361857x = b(R.drawable.larus_ic_card_deep_research_report_export, R.string.larus_accessibility_icon_download);
        this.f361858y = b(R.drawable.larus_ic_office_url_preview_expand, R.string.larus_accessibility_input_fullScreen);
        this.f361859z = b(R.drawable.larus_ic_card_deep_research_report_export, R.string.larus_accessibility_icon_download);
        this.A = b(R.drawable.larus_ic_office_url_preview_expand, R.string.larus_accessibility_input_fullScreen);
        this.B = OfficeUrlPreviewClientState.LOADING;
        GradientDrawable r111 = new GradientDrawable();
        r111.setShape(0);
        r111.setColor(v19.c.a(R.attr.larus_base_1, r110, R.color.larus_base_1));
        r111.setCornerRadius(c(r110, 12));
        Resources r112 = r110.getResources();
        r111.setStroke(RangesKt.coerceAtLeast((int) ((WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).density * 0.5f) + 0.5f), 1), v19.c.a(R.attr.larus_neutral_transparent_2, r110, R.color.larus_neutral_transparent_2));
        setBackground(r111);
        setClipToOutline(true);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        setVisibility(8);
        r101.setOrientation(0);
        r101.setGravity(16);
        r101.addView(r103, new LinearLayout.LayoutParams(c(r110, 24), c(r110, 24)));
        r104.setGravity(16);
        r104.setMaxLines(1);
        r104.setEllipsize(TextUtils.TruncateAt.END);
        r104.setTextSize(14.0f);
        r104.setTypeface(r100);
        r104.setTextColor(v19.c.a(R.attr.larus_neutral_100, r110, R.color.larus_neutral_100));
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        r113.setMarginStart(c(r110, 8));
        Unit r106 = Unit.INSTANCE;
        r101.addView(r104, r113);
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-1, c(r110, 24));
        r107.gravity = 48;
        r107.setMargins(c(r110, 16), c(r110, 16), c(r110, 16), 0);
        addView(r101, r107);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-1, c(r110, 172));
        r108.topMargin = c(r110, 48);
        addView(r102, r108);
        r105.setOrientation(1);
        int[] r109 = I;
        int r114 = 0;
        int r115 = 0;
    L4:
        if (r114 >= 4) goto L13;
        int r116 = r109[r114];
        int r117 = r115 + 1;
        k2 r118 = new k2(r110, f361833J[r115], K[r115]);
        ((ArrayList) this.f361843j).add(r118);
        if (r116 != (-1)) goto L8;
        int r119 = -1;
    L9:
        LinearLayout.LayoutParams r120 = new LinearLayout.LayoutParams(r119, c(r110, 16));
        if (r115 <= 0) goto L12;
        r120.topMargin = c(r110, 20);
    L12:
        Unit r121 = Unit.INSTANCE;
        r105.addView(r118, r120);
        r114 = r114 + 1;
        r115 = r117;
        goto L4
    L8:
        r119 = c(r110, r116);
        goto L9
    L13:
        FrameLayout r122 = this.f361838e;
        LinearLayout r123 = this.f361842i;
        FrameLayout.LayoutParams r124 = new FrameLayout.LayoutParams(-1, -2);
        r124.setMargins(c(r110, 24), c(r110, 20), c(r110, 24), 0);
        Unit r125 = Unit.INSTANCE;
        r122.addView(r123, r124);
        LinearLayout r126 = this.f361844k;
        r126.setOrientation(1);
        r126.setGravity(1);
        r126.setVisibility(8);
        ImageView r127 = new ImageView(r110);
        r127.setImageResource(R.drawable.larus_ic_office_url_preview_failed);
        r127.setImageTintList(ColorStateList.valueOf(v19.c.a(R.attr.larus_neutral_50, r110, R.color.larus_neutral_50)));
        r126.addView(r127, new LinearLayout.LayoutParams(c(r110, 40), c(r110, 40)));
        TextView r128 = this.f361845l;
        r128.setText(r110.getString(R.string.larus_artifactCard_status_previewFail));
        r128.setTextColor(v19.c.a(R.attr.larus_neutral_50, r110, R.color.larus_neutral_50));
        r128.setTextSize(14.0f);
        LinearLayout.LayoutParams r129 = new LinearLayout.LayoutParams(-2, -2);
        r129.topMargin = c(r110, 8);
        r126.addView(r128, r129);
        FrameLayout r130 = this.f361838e;
        LinearLayout r131 = this.f361844k;
        FrameLayout.LayoutParams r132 = new FrameLayout.LayoutParams(-2, -2);
        r132.gravity = 17;
        r130.addView(r131, r132);
        FrameLayout r133 = this.f361839f;
        TextView r134 = this.f361846m;
        r134.setGravity(16);
        r134.setTextColor(v19.c.a(R.attr.larus_neutral_100, r110, R.color.larus_neutral_100));
        r134.setTextSize(14.0f);
        FrameLayout.LayoutParams r135 = new FrameLayout.LayoutParams(-2, c(r110, 24));
        r135.gravity = 8388691;
        r133.addView(r134, r135);
        LinearLayout r136 = this.f361847n;
        r136.setOrientation(0);
        r136.setGravity(16);
        r136.addView(this.f361856w, a(r110, false));
        r136.addView(this.f361857x, a(r110, true));
        r136.addView(this.f361858y, a(r110, true));
        FrameLayout r137 = this.f361839f;
        LinearLayout r138 = this.f361847n;
        FrameLayout.LayoutParams r139 = new FrameLayout.LayoutParams(-2, c(r110, 18));
        r139.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        r137.addView(r138, r139);
        View r140 = this.f361839f;
        FrameLayout.LayoutParams r141 = new FrameLayout.LayoutParams(-1, c(r110, 36));
        r141.gravity = 80;
        r141.setMargins(c(r110, 16), 0, c(r110, 16), c(r110, 16));
        addView(r140, r141);
        LinearLayout r142 = new LinearLayout(r110);
        r142.setOrientation(0);
        r142.setGravity(16);
        r142.addView(this.f361849p, new LinearLayout.LayoutParams(c(r110, 36), c(r110, 36)));
        LinearLayout r143 = this.f361851r;
        r143.setOrientation(1);
        r143.setGravity(16);
        TextView r144 = this.f361852s;
        r144.setGravity(16);
        r144.setMaxLines(1);
        r144.setEllipsize(TextUtils.TruncateAt.END);
        r144.setIncludeFontPadding(false);
        r144.setTextSize(14.0f);
        r144.setTypeface(this.f361834a);
        r144.setTextColor(v19.c.a(R.attr.larus_neutral_100, r110, R.color.larus_neutral_100));
        TextViewCompat.setLineHeight(r144, c(r110, 22));
        r143.addView(r144, new LinearLayout.LayoutParams(-1, -1));
        TextView r145 = this.f361853t;
        r145.setGravity(16);
        r145.setMaxLines(1);
        r145.setEllipsize(TextUtils.TruncateAt.END);
        r145.setIncludeFontPadding(false);
        r145.setTypeface(this.f361836c);
        r145.setTextColor(v19.c.a(R.attr.larus_neutral_50, r110, R.color.larus_neutral_50));
        Resources r146 = r145.getContext().getResources();
        r145.setTextSize(0, (int) ((14.0f * WindowDisplayMetricsOverride.apply(r146, r146.getDisplayMetrics()).density) + 0.5f));
        TextViewCompat.setLineHeight(r145, c(r110, 20));
        r145.setVisibility(8);
        r143.addView(r145, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f361850q.addView(this.f361851r, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout r147 = this.f361854u;
        r147.setOrientation(1);
        r147.setGravity(16);
        int[] r148 = L;
        int r149 = 0;
        int r150 = 0;
    L15:
        if (r149 >= 2) goto L24;
        int r151 = r148[r149];
        int r152 = r150 + 1;
        k2 r153 = new k2(r110, M[r150], N[r150]);
        ((ArrayList) this.f361843j).add(r153);
        if (r151 != (-1)) goto L19;
        int r154 = -1;
    L20:
        LinearLayout.LayoutParams r155 = new LinearLayout.LayoutParams(r154, c(r110, 12));
        if (r150 <= 0) goto L23;
        r155.topMargin = c(r110, 12);
    L23:
        Unit r156 = Unit.INSTANCE;
        r147.addView(r153, r155);
        r149 = r149 + 1;
        r150 = r152;
        goto L15
    L19:
        r154 = c(r110, r151);
        goto L20
    L24:
        this.f361850q.addView(this.f361854u, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r157 = this.f361850q;
        LinearLayout.LayoutParams r158 = new LinearLayout.LayoutParams(0, c(r110, 40), 1.0f);
        r158.setMarginStart(c(r110, 8));
        Unit r159 = Unit.INSTANCE;
        r142.addView(r157, r158);
        LinearLayout r160 = this.f361855v;
        r160.setOrientation(0);
        r160.setGravity(16);
        r160.addView(this.f361859z, new LinearLayout.LayoutParams(c(r110, 18), c(r110, 18)));
        r160.addView(this.A, new LinearLayout.LayoutParams(c(r110, 18), c(r110, 18)));
        LinearLayout r161 = this.f361848o;
        r161.setOrientation(0);
        r161.setGravity(16);
        r161.setPadding(c(r110, 16), 0, c(r110, 16), 0);
        r161.setVisibility(8);
        r161.addView(r142, new LinearLayout.LayoutParams(0, c(r110, 40), 1.0f));
        LinearLayout r162 = this.f361855v;
        LinearLayout.LayoutParams r163 = new LinearLayout.LayoutParams(-2, -1);
        r163.setMarginStart(c(r110, 16));
        r161.addView(r162, r163);
        addView(this.f361848o, new FrameLayout.LayoutParams(-1, -1));
        setOnClickListener(new v(this));
        setClickable(false);
    }

    public static LinearLayout.LayoutParams a(Context r100, boolean r101) {
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(c(r100, 18), c(r100, 18));
        if (r101 == false) goto L5;
        r102.setMarginStart(c(r100, 12));
    L5:
        return r102;
    }

    public static int c(Context r100, int r101) {
        Resources r102 = r100.getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public final ImageView b(int r100, int r101) {
        ImageView r102 = new ImageView(getContext());
        r102.setImageResource(r100);
        r102.setScaleType(ImageView.ScaleType.CENTER);
        r102.setContentDescription(r102.getContext().getString(r101));
        r102.setPadding(c(r102.getContext(), 0), c(r102.getContext(), 0), c(r102.getContext(), 0), c(r102.getContext(), 0));
        if (r101 != R.string.larus_accessibility_icon_copy) goto L6;
        r102.setOnClickListener(new w(this));
    L9:
        return r102;
    L6:
        if (r101 != R.string.larus_accessibility_icon_download) goto L8;
        r102.setOnClickListener(new x(this));
        goto L9
    L8:
        r102.setOnClickListener(new y(this));
        goto L9
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        if (View.MeasureSpec.getMode(r100) != 0) goto L5;
        int r103 = c(getContext(), 400);
    L6:
        int r104 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
        Integer r105 = this.D;
        if (r105 == null) goto L9;
        int r106 = r105.intValue();
    L14:
        super.onMeasure(r104, View.MeasureSpec.makeMeasureSpec(r106, 1073741824));
        return;
    L9:
        Context r107 = getContext();
        if (this.C == false) goto L12;
        int r108 = 72;
    L13:
        r106 = c(r107, r108);
        goto L14
    L12:
        r108 = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME;
        goto L13
    L5:
        r103 = RangesKt.coerceAtMost(r102, c(getContext(), 400));
        goto L6
    }

    public static void f(ImageView r100, boolean r101, boolean r102) {
        if (r101 == false) goto L4;
        int r103 = 0;
    L5:
        r100.setVisibility(r103);
        r100.setEnabled(r102);
        if (r102 == false) goto L8;
        float r104 = 1.0f;
    L9:
        r100.setAlpha(r104);
        return;
    L8:
        r104 = 0.3f;
        goto L9
    L4:
        r103 = 8;
        goto L5
    }

    public final void g(ImageView r100, boolean r101, boolean r102, boolean r103) {
        f(r100, r101, r102);
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
        if ((r104 instanceof LinearLayout.LayoutParams) == false) goto L5;
        LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r104;
    L6:
        if (r105 == null) goto L14;
        Context r106 = getContext();
        if (r101 == false) goto L11;
        if (r103 == false) goto L11;
        int r107 = 12;
    L12:
        r105.setMarginStart(c(r106, r107));
        r100.setLayoutParams(r105);
        return;
    L11:
        r107 = 0;
        goto L12
    L14:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
