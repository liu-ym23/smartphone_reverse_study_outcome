package com.ss.android.ugc.aweme.search.filter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import com.amap.api.col.s.ce;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.config.d;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vl4.b;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001BB\u001d\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u000bR*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010-\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010;\u001a\u00020*8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b9\u0010,\u001a\u0004\b\t\u0010.\"\u0004\b:\u00100¨\u0006C"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchFilterBoard;", "Landroid/widget/FrameLayout;", "Landroid/view/ViewGroup;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getContentLayout", "()Landroid/view/ViewGroup;", "contentLayout", "Landroid/view/View;", "b", "getMaskView", "()Landroid/view/View;", "maskView", "c", "Landroid/view/View;", "getClickHideView", "clickHideView", "Lkotlin/Function0;", "", "e", "Lkotlin/jvm/functions/Function0;", "getOnClickHideListener", "()Lkotlin/jvm/functions/Function0;", "setOnClickHideListener", "(Lkotlin/jvm/functions/Function0;)V", "onClickHideListener", "Landroid/view/View$OnClickListener;", "f", "Landroid/view/View$OnClickListener;", "getOnHideListener", "()Landroid/view/View$OnClickListener;", "setOnHideListener", "(Landroid/view/View$OnClickListener;)V", "onHideListener", "", ce.f26391f, "Ljava/lang/String;", "getContentType", "()Ljava/lang/String;", "setContentType", "(Ljava/lang/String;)V", "contentType", "", "h", "Z", "isFromCommodity", "()Z", "setFromCommodity", "(Z)V", "", RXScreenCaptureService.KEY_INDEX, "I", "getTheme", "()I", "setTheme", "(I)V", "theme", ce.f26395j, "setFromPhoto", "isFromPhoto", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECSearchFilterBoard extends FrameLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f452798k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f452799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f452800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f452801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f452802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f452803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnClickListener f452804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f452805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f452806h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f452807i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f452808j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchFilterBoard$Companion;", "", "()V", "TYPE_DEFAULT", "", "TYPE_POI_MULTI_DROPDOWN", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public final ViewGroup getContentLayout() {
        return (ViewGroup) this.f452799a.getValue();
    }

    public final View getMaskView() {
        return (View) this.f452800b.getValue();
    }

    public boolean b() {
        return this.f452808j;
    }

    public final View getClickHideView() {
        return this.f452801c;
    }

    public final String getContentType() {
        return this.f452805g;
    }

    public final Function0<Unit> getOnClickHideListener() {
        return this.f452803e;
    }

    public final View.OnClickListener getOnHideListener() {
        return this.f452804f;
    }

    public final int getTheme() {
        return this.f452807i;
    }

    public ECSearchFilterBoard(Context r100) {
        this(r100, null);
    }

    public final void a(boolean r100) {
        if (this.f452806h == true) goto L5;
    L8:
        getContentLayout().removeAllViews();
        setVisibility(8);
        View.OnClickListener r101 = this.f452804f;
        if (r101 == null) goto L13;
        r101.onClick(this);
        return;
    L13:
        return;
    L5:
        if (getContentLayout().getChildCount() <= 0) goto L8;
        if (r100 == true) goto L8;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, -getContentLayout().getChildAt(0).getHeight()});
        r102.setInterpolator(new b(this.f452802d));
        r102.addUpdateListener(new ECSearchFilterBoard$hideBoard$$inlined$apply$lambda$1(this));
        r102.addListener(new ECSearchFilterBoard$hideBoard$$inlined$apply$lambda$2(this));
        r102.setDuration(200);
        r102.start();
    }

    public void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        if (indexOfChild(getContentLayout()) == (-1)) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        addView(getMaskView());
        addView(getContentLayout());
    L9:
        if (this.f452806h == false) goto L18;
        Context r102 = getContext();
        if (this.f452807i != 1) goto L13;
    L16:
        int r103 = R.drawable.filter_panel_corner_bg_light;
    L17:
        r100.setBackground(AppCompatResources.getDrawable(r102, r103));
        goto L18
    L13:
        if (b() == true) goto L16;
        r103 = R.drawable.filter_panel_corner_bg;
    L18:
        ViewGroup r104 = getContentLayout();
        r104.removeAllViews();
        r104.addView(r100);
        r104.addView(this.f452801c);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void d(float r100) {
        setVisibility(0);
        setTranslationY(r100);
        if (this.f452806h == false) goto L8;
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == false) goto L8;
        getMaskView().setVisibility(8);
        float r101 = -r100;
        getContentLayout().setTranslationY(r101);
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{r101, 0.0f});
        r102.setInterpolator(new b(4.0f));
        r102.addUpdateListener(new ECSearchFilterBoard$showBoard$$inlined$apply$lambda$1(this));
        r102.addListener(new ECSearchFilterBoard$showBoard$$inlined$apply$lambda$2(this));
        r102.setDuration(271);
        r102.start();
        return;
    L8:
        if (this.f452806h == false) goto L15;
        JSONObject r103 = new JSONObject();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
        Result.m9449constructorimpl(r103.put("FileName", "FilterBoard"));     // Catch: Throwable -> L12
    L14:
        d.a r105 = d.a();
        r105.f190465a = "ec_search_animation_not_in_main_thread";
        r105.f190467c = r103;
        ApmAgent.monitorEvent(new d(r105));
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L15:
        setBackgroundColor(Color.argb(128, 0, 0, 0));
    }

    public final void setContentType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f452805g = r100;
    }

    public final void setFromCommodity(boolean r100) {
        this.f452806h = r100;
    }

    public void setFromPhoto(boolean r100) {
        this.f452808j = r100;
    }

    public final void setOnClickHideListener(Function0<Unit> r100) {
        this.f452803e = r100;
    }

    public final void setOnHideListener(View.OnClickListener r100) {
        this.f452804f = r100;
    }

    public final void setTheme(int r100) {
        this.f452807i = r100;
    }

    public ECSearchFilterBoard(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setVisibility(8);
        setOnClickListener(ECSearchFilterBoard$init$1.f452812a);
        this.f452799a = LazyKt.lazy(new ECSearchFilterBoard$contentLayout$2(r100));
        this.f452800b = LazyKt.lazy(new ECSearchFilterBoard$maskView$2(this, r100));
        View r102 = new View(r100);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        r102.setOnClickListener(new ECSearchFilterBoard$$special$$inlined$apply$lambda$1(this));
        Unit r103 = Unit.INSTANCE;
        this.f452801c = r102;
        this.f452802d = 2.366f;
        this.f452805g = "default";
    }
}
