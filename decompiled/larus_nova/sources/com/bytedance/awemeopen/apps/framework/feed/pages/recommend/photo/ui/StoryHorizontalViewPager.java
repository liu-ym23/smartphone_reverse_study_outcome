package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nz3.c;
import nz3.d;
import nz3.e;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u00015B\u001d\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00066"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/StoryHorizontalViewPager;", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/HandyViewPager;", "Lnz3/e;", "scrollInterceptor", "", "setScrollInterceptor", "", "isDisableScroll", "setDisableScroll", "isDisableOutScroll", "setDisableOutScroll", "", "getScrollState", "Lnz3/a;", "slidesPhotosViewPagerInterceptor", "setISlidesPhotosViewPagerInterceptor", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "setOffscreenPageLimit", "Lnz3/d;", "p1", "Lnz3/d;", "getSwipeOutListener", "()Lnz3/d;", "setSwipeOutListener", "(Lnz3/d;)V", "swipeOutListener", "Lnz3/c;", "v1", "Lnz3/c;", "getScrollListener", "()Lnz3/c;", "setScrollListener", "(Lnz3/c;)V", "scrollListener", "G1", "Z", "getEnableBounce", "()Z", "setEnableBounce", "(Z)V", "enableBounce", "L1", "Lnz3/a;", "getSlidesPhotosViewPagerInterceptor", "()Lnz3/a;", "setSlidesPhotosViewPagerInterceptor", "(Lnz3/a;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class StoryHorizontalViewPager extends HandyViewPager {
    public boolean G1;
    public boolean H0;
    public boolean H1;
    public boolean L0;
    public nz3.a L1;
    public float P0;
    public float V0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f195273b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f195274g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f195275h1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f195276k1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public d f195277p1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public c f195278v1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public e f195279x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public boolean f195280y1;

    public static final class a {
    }

    static {
    }

    public final boolean getEnableBounce() {
        return this.G1;
    }

    public final c getScrollListener() {
        return this.f195278v1;
    }

    public final int getScrollState() {
        return this.V;
    }

    public final nz3.a getSlidesPhotosViewPagerInterceptor() {
        return this.L1;
    }

    public final d getSwipeOutListener() {
        return this.f195277p1;
    }

    public StoryHorizontalViewPager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.HandyViewPager, android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.H0 == false) goto L6;
        return false;
    L6:
        if (r100 <= 0) goto L15;
        nz3.a r101 = this.L1;
        if (r101 != null) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L15;
        return false;
    L10:
        if (r101.b() != true) goto L12;
        r102 = true;
    L15:
        if (r100 >= 0) goto L25;
        nz3.a r103 = this.L1;
        if (r103 != null) goto L19;
    L21:
        boolean r104 = false;
    L22:
        if (r104 == false) goto L25;
        return false;
    L19:
        if (r103.a() != true) goto L21;
        r104 = true;
    L25:
        if (this.L0 == false) goto L28;
        return true;
    L28:
        return super.canScrollHorizontally(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.HandyViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        boolean r101 = false;
        if (this.H0 == false) goto L6;
        return false;
    L6:
        if (this.f195273b1 >= 0) goto L8;
        this.f195273b1 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    L8:
        int r102 = r100.getAction();
        if (r102 != 0) goto L11;
        this.P0 = r100.getX();
        this.V0 = r100.getY();
        this.f195274g1 = r100.getPointerId(0);
        if (this.G1 == false) goto L115;
        if (this.H1 == false) goto L115;
        e r103 = this.f195279x1;
        if (r103 != null) goto L109;
    L111:
        boolean r104 = false;
    L112:
        if (r104 == false) goto L115;
        this.f195280y1 = true;
        goto L115
    L109:
        if (r103.b() != true) goto L111;
        r104 = true;
    L115:
        if (this.V != 2) goto L124;
        e r105 = this.f195279x1;
        if (r105 != null) goto L119;
    L121:
        boolean r106 = false;
    L122:
        if (r106 == false) goto L124;
        return false;
    L119:
        if (r105.intercept() != true) goto L121;
        r106 = true;
    L124:
        this.f195276k1 = false;
        this.f195275h1 = false;
    L125:
        int r107 = this.V;
        boolean r108 = super.onInterceptTouchEvent(r100);
        if (this.V != 1) goto L130;
        if (r107 != 2) goto L130;
        r100.getAction();
    L130:
        return r108;
    L11:
        if (r102 == 1) goto L94;
        if (r102 != 2) goto L14;
        int r109 = this.f195274g1;
        if (r109 == (-1)) goto L93;
        int r110 = r100.findPointerIndex(r109);
        if (r110 == (-1)) goto L93;
        float r111 = r100.getX(r110);
        float r112 = r100.getY(r110);
        if (Math.abs(r111 - this.P0) <= this.f195273b1) goto L36;
        if (Math.abs(r111 - this.P0) <= Math.abs(r112 - this.V0)) goto L36;
        c r113 = this.f195278v1;
        if (r113 == null) goto L36;
        r113.b();
    L36:
        if (this.G1 == true) goto L38;
    L52:
        nz3.a r114 = this.L1;
        if (r114 != null) goto L55;
    L57:
        boolean r115 = false;
    L59:
        if (r115 == true) goto L61;
    L73:
        nz3.a r116 = this.L1;
        if (r116 != null) goto L76;
    L78:
        boolean r117 = false;
    L79:
        if (r117 == false) goto L125;
        if ((this.P0 - r111) <= 20.0f) goto L125;
        d r118 = this.f195277p1;
        if (r118 != null) goto L85;
    L87:
        if (r101 == false) goto L125;
        d r119 = this.f195277p1;
        if (r119 == null) goto L91;
        r119.c();
    L91:
        this.f195276k1 = true;
        return true;
    L85:
        if (r118.d() != true) goto L87;
        r101 = true;
        goto L87
    L76:
        if (r116.b() != true) goto L78;
        r117 = true;
        goto L79
    L61:
        if ((r111 - this.P0) <= 20.0f) goto L73;
        d r120 = this.f195277p1;
        if (r120 != null) goto L65;
    L67:
        if (r101 == false) goto L125;
        d r121 = this.f195277p1;
        if (r121 == null) goto L71;
        r121.a();
    L71:
        this.f195275h1 = true;
        return true;
    L65:
        if (r120.b() != true) goto L67;
        r101 = true;
        goto L67
    L55:
        if (r114.a() != true) goto L57;
        r115 = true;
        goto L59
    L38:
        if (this.H1 == false) goto L52;
        if ((this.P0 - r111) <= 0.0f) goto L52;
        if (this.f195280y1 == true) goto L52;
        e r122 = this.f195279x1;
        if (r122 != null) goto L46;
    L48:
        boolean r123 = false;
    L49:
        if (r123 == false) goto L52;
        this.f195280y1 = true;
        return true;
    L46:
        if (r122.b() != true) goto L48;
        r123 = true;
    L93:
        return false;
    L14:
        if (r102 != 3) goto L125;
        this.f195274g1 = -1;
        if (this.G1 == false) goto L125;
        if (this.f195280y1 == false) goto L125;
        e r124 = this.f195279x1;
        if (r124 == null) goto L23;
        r124.a();
    L23:
        this.f195280y1 = false;
        goto L125
    L94:
        this.f195274g1 = -1;
        if (this.G1 == false) goto L125;
        if (this.f195280y1 == false) goto L125;
        e r125 = this.f195279x1;
        if (r125 == null) goto L101;
        r125.a();
    L101:
        this.f195280y1 = false;
        goto L125
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.HandyViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L6;
        r100.getAction();
    L6:
        if (this.G1 == false) goto L27;
        if (this.f195280y1 == false) goto L27;
        if (r100 != null) goto L12;
    L14:
        boolean r101 = false;
    L15:
        if (r101 == true) goto L22;
        if (r100 != null) goto L18;
    L20:
        boolean r102 = false;
    L21:
        if (r102 == false) goto L27;
    L18:
        if (r100.getAction() != 3) goto L20;
        r102 = true;
    L22:
        e r103 = this.f195279x1;
        if (r103 == null) goto L25;
        r103.a();
    L25:
        this.f195280y1 = false;
        goto L27
    L12:
        if (r100.getAction() != 1) goto L14;
        r101 = true;
    L27:
        if (this.f195276k1 == true) goto L34;
        if (this.f195275h1 == true) goto L34;
        return super.onTouchEvent(r100);
    L34:
        if (r100 == null) goto L36;
        r100.getAction();
    L36:
        return true;
    }

    public final void setDisableOutScroll(boolean r100) {
        this.L0 = r100;
    }

    public final void setDisableScroll(boolean r100) {
        this.H0 = r100;
    }

    public final void setEnableBounce(boolean r100) {
        this.G1 = r100;
    }

    public final void setISlidesPhotosViewPagerInterceptor(nz3.a r100) {
        this.L1 = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.HandyViewPager
    public void setOffscreenPageLimit(int r100) {
        if (r100 == getOffscreenPageLimit()) goto L9;
        if (r100 != 0) goto L9;
        Field r101 = ViewPager.class.getDeclaredField("mOffscreenPageLimit");     // Catch: Exception -> L7
        r101.setAccessible(true);     // Catch: Exception -> L7
        r101.set(this, Integer.valueOf(r100));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        AoNpthService r102 = AoExceptionReporter.f198706a;
        AoExceptionReporter.a(ErrorPriority.f198711p1, "StoryHorizontalViewPager", "", "setOffscreenPageLimit exception", e);
        return;
    L9:
        super.setOffscreenPageLimit(r100);
    }

    public final void setScrollInterceptor(e r100) {
        this.f195279x1 = r100;
    }

    public final void setScrollListener(c r100) {
        this.f195278v1 = r100;
    }

    public final void setSlidesPhotosViewPagerInterceptor(nz3.a r100) {
        this.L1 = r100;
    }

    public final void setSwipeOutListener(d r100) {
        this.f195277p1 = r100;
    }

    public StoryHorizontalViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101);
        this.f195273b1 = -1;
        this.f195274g1 = -1;
        b(new AnonymousClass1(this));
    }
}
