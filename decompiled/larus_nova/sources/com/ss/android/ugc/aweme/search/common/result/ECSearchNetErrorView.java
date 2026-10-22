package com.ss.android.ugc.aweme.search.common.result;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.dux.image.DuxImageView;
import com.bytedance.dux.text.DuxTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.ecommerce.api.srp.ECSearchBizScene;
import com.ss.android.ugc.aweme.search.utils.DimensUtilKt;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0019B\u001d\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/ECSearchNetErrorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/Function0;", "", "b", "Lkotlin/jvm/functions/Function0;", "getListener", "()Lkotlin/jvm/functions/Function0;", "setListener", "(Lkotlin/jvm/functions/Function0;)V", "listener", "", RXScreenCaptureService.KEY_INDEX, "I", "getTheme", "()I", "setTheme", "(I)V", "theme", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchNetErrorView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f451840j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f451841k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DuxTextView f451842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f451843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f451844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f451845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f451846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DuxImageView f451847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DuxTextView f451848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DuxTextView f451849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f451850i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/ECSearchNetErrorView$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
        f451840j = DimenExtensionsKt.b(120);
        f451841k = DimenExtensionsKt.b(160);
    }

    public final Function0<Unit> getListener() {
        return this.f451843b;
    }

    public final int getTheme() {
        return this.f451850i;
    }

    public ECSearchNetErrorView(Context r100) {
        this(r100, null);
    }

    public final void setListener(Function0<Unit> r100) {
        this.f451843b = r100;
    }

    public final void setTheme(int r100) {
        this.f451850i = r100;
    }

    public ECSearchNetErrorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f451850i = 1;
        ViewGroup.inflate(r100, R.layout.saas_ec_search_common_result_error_layout, this);
        LinearLayout r102 = (LinearLayout) findViewById(R.id.search_ec_common_result_error_layout);
        this.f451844c = (ConstraintLayout) findViewById(R.id.search_ec_common_result_error);
        this.f451845d = findViewById(R.id.search_ec_common_error_top_bg);
        this.f451846e = findViewById(R.id.search_ec_common_error_gradient_bg);
        this.f451847f = (DuxImageView) findViewById(R.id.search_ec_common_result_error_img);
        this.f451848g = (DuxTextView) findViewById(R.id.search_ec_common_result_error_title);
        this.f451849h = (DuxTextView) findViewById(R.id.search_ec_common_result_error_des);
        DuxTextView r103 = (DuxTextView) findViewById(R.id.search_ec_common_result_refresh);
        this.f451842a = r103;
        if (r103 == null) goto L6;
        r103.setOnClickListener(new ECSearchNetErrorView$initView$1(this));
        return;
    }

    public final void R5(int r210, ECSearchBizScene r211) {
        Intrinsics.checkNotNullParameter(r211, "searchBizScene");
        ECSearchBizScene r100 = ECSearchBizScene.EC_AI_SEARCH;
        if (r211 != r100) goto L5;
        int r101 = ContextCompat.getColor(getContext(), R.color.transparent);
    L8:
        if (r211 != r100) goto L10;
        int r102 = ContextCompat.getColor(getContext(), R.color.transparent);
    L13:
        float r103 = DimensUtilKt.a(20);
        GradientDrawable r104 = new GradientDrawable();
        r104.setShape(0);
        r104.setColor(ColorStateList.valueOf(r102));
        r104.setCornerRadii(new float[]{r103, r103, r103, r103, 0.0f, 0.0f, 0.0f, 0.0f});
        ConstraintLayout r110 = this.f451844c;
        if (r110 == null) goto L16;
        r110.setBackground(r104);
    L16:
        GradientDrawable r105 = new GradientDrawable();
        r105.setShape(0);
        r105.setColor(ColorStateList.valueOf(r101));
        r105.setCornerRadii(new float[]{r103, r103, r103, r103, 0.0f, 0.0f, 0.0f, 0.0f});
        View r106 = this.f451845d;
        if (r106 == null) goto L19;
        r106.setBackground(r105);
    L19:
        GradientDrawable r107 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{r101, r102});
        r107.setShape(0);
        r107.setGradientType(0);
        View r108 = this.f451846e;
        if (r108 == null) goto L22;
        r108.setBackground(r107);
    L22:
        ViewGroup.LayoutParams r109 = null;
        if (r211 == ECSearchBizScene.EC_SEARCH) goto L45;
        if (r211 == r100) goto L45;
        DuxImageView r111 = this.f451847f;
        if (r111 == null) goto L29;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
    L31:
        if ((r112 instanceof LinearLayout.LayoutParams) == false) goto L34;
        r109 = r112;
    L34:
        LinearLayout.LayoutParams r113 = (LinearLayout.LayoutParams) r109;
        if (r113 == null) goto L37;
        r113.width = DimenExtensionsKt.b(240);
    L37:
        if (r113 == null) goto L39;
        r113.height = f451841k;
    L39:
        DuxImageView r114 = this.f451847f;
        if (r114 == null) goto L42;
        r114.setLayoutParams(r113);
    L42:
        DuxImageView r115 = this.f451847f;
        if (r115 == null) goto L64;
        r115.setImageResource(R.drawable.duximg_illu_s_networkerror_w3h2);
    L64:
        if (r210 != 1) goto L66;
        int r116 = ContextCompat.getColor(getContext(), R.color.ec_search_status_title_color_light);
    L67:
        DuxTextView r117 = this.f451848g;
        if (r117 == null) goto L70;
        r117.setTextColor(r116);
    L70:
        if (r210 != 1) goto L72;
        int r118 = ContextCompat.getColor(getContext(), R.color.ec_search_status_des_color_light);
    L73:
        DuxTextView r119 = this.f451849h;
        if (r119 == null) goto L76;
        r119.setTextColor(r118);
    L76:
        if (r210 != 1) goto L78;
        int r120 = ContextCompat.getColor(getContext(), R.color.ec_search_status_refresh_color_light);
    L79:
        DuxTextView r121 = this.f451842a;
        if (r121 == null) goto L82;
        r121.setTextColor(r116);
    L82:
        GradientDrawable r122 = new GradientDrawable();
        r122.setShape(0);
        r122.setColor(ColorStateList.valueOf(r120));
        r122.setCornerRadius(DimensUtilKt.a(100));
        DuxTextView r123 = this.f451842a;
        if (r123 == null) goto L86;
        r123.setBackground(r122);
        return;
    L86:
        return;
    L78:
        r120 = ContextCompat.getColor(getContext(), R.color.ec_search_status_refresh_color);
        goto L79
    L72:
        r118 = ContextCompat.getColor(getContext(), R.color.ec_search_status_des_color);
        goto L73
    L66:
        r116 = ContextCompat.getColor(getContext(), R.color.ec_search_status_title_color);
        goto L67
    L29:
        r112 = null;
    L45:
        DuxImageView r124 = this.f451847f;
        if (r124 == null) goto L48;
        ViewGroup.LayoutParams r125 = r124.getLayoutParams();
    L50:
        if ((r125 instanceof LinearLayout.LayoutParams) == false) goto L53;
        r109 = r125;
    L53:
        LinearLayout.LayoutParams r126 = (LinearLayout.LayoutParams) r109;
        if (r126 == null) goto L56;
        r126.width = DimenExtensionsKt.b(120);
    L56:
        if (r126 == null) goto L58;
        r126.height = f451840j;
    L58:
        DuxImageView r127 = this.f451847f;
        if (r127 == null) goto L61;
        r127.setLayoutParams(r126);
    L61:
        DuxImageView r128 = this.f451847f;
        if (r128 == null) goto L64;
        r128.setImageResource(R.drawable.search_ec_common_error_img_light);
        goto L64
    L48:
        r125 = null;
        goto L50
    L10:
        if (r210 != 1) goto L12;
        r102 = ContextCompat.getColor(getContext(), R.color.simplify_commodity_color_bottom_light);
        goto L13
    L12:
        r102 = ContextCompat.getColor(getContext(), R.color.simplify_commodity_color_bottom);
        goto L13
    L5:
        if (r210 != 1) goto L7;
        r101 = ContextCompat.getColor(getContext(), R.color.simplify_commodity_color_top_light);
        goto L8
    L7:
        r101 = ContextCompat.getColor(getContext(), R.color.simplify_commodity_color_top);
        goto L8
    }
}
