package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nz3.c;
import nz3.d;
import nz3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u00015B\u001d\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00066"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/StoryHorizontalViewPager;", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/HandyViewPager;", "Lnz3/e;", "scrollInterceptor", "", "setScrollInterceptor", "", "isDisableScroll", "setDisableScroll", "isDisableOutScroll", "setDisableOutScroll", "", "getScrollState", "Lnz3/a;", "slidesPhotosViewPagerInterceptor", "setISlidesPhotosViewPagerInterceptor", "limit", "setOffscreenPageLimit", "Lnz3/d;", "p1", "Lnz3/d;", "getSwipeOutListener", "()Lnz3/d;", "setSwipeOutListener", "(Lnz3/d;)V", "swipeOutListener", "Lnz3/c;", "v1", "Lnz3/c;", "getScrollListener", "()Lnz3/c;", "setScrollListener", "(Lnz3/c;)V", "scrollListener", "G1", "Z", "getEnableBounce", "()Z", "setEnableBounce", "(Z)V", "enableBounce", "L1", "Lnz3/a;", "getSlidesPhotosViewPagerInterceptor", "()Lnz3/a;", "setSlidesPhotosViewPagerInterceptor", "(Lnz3/a;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class StoryHorizontalViewPager extends HandyViewPager {
    public boolean G1;
    public boolean H0;
    public boolean H1;
    public boolean L0;
    public nz3.a L1;
    public float P0;
    public float V0;
    public int b1;
    public int g1;
    public boolean h1;
    public boolean k1;
    public d p1;
    public c v1;
    public e x1;
    public boolean y1;

    public static final class a {
    }

    static {
    }

    public final boolean getEnableBounce() {
        return this.G1;
    }

    public final c getScrollListener() {
        return this.v1;
    }

    public final int getScrollState() {
        return this.V;
    }

    public final nz3.a getSlidesPhotosViewPagerInterceptor() {
        return this.L1;
    }

    public final d getSwipeOutListener() {
        return this.p1;
    }

    public StoryHorizontalViewPager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.HandyViewPager, android.view.View
    public final boolean canScrollHorizontally(int r4) {
        if (this.H0 == false) goto L6;
        return false;
    L6:
        if (r4 <= 0) goto L15;
        nz3.a r2 = this.L1;
        if (r2 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L15;
        return false;
    L10:
        if (r2.b() != true) goto L12;
        r3 = true;
    L15:
        if (r4 >= 0) goto L25;
        nz3.a r5 = this.L1;
        if (r5 != null) goto L19;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == false) goto L25;
        return false;
    L19:
        if (r5.a() != true) goto L21;
        r6 = true;
    L25:
        if (this.L0 == false) goto L28;
        return true;
    L28:
        return super.canScrollHorizontally(r4);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.HandyViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        boolean r1 = false;
        if (this.H0 == false) goto L6;
        return false;
    L6:
        if (this.b1 >= 0) goto L8;
        this.b1 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    L8:
        int r0 = r8.getAction();
        if (r0 != 0) goto L11;
        this.P0 = r8.getX();
        this.V0 = r8.getY();
        this.g1 = r8.getPointerId(0);
        if (this.G1 == false) goto L115;
        if (this.H1 == false) goto L115;
        e r2 = this.x1;
        if (r2 != null) goto L109;
    L111:
        boolean r3 = false;
    L112:
        if (r3 == false) goto L115;
        this.y1 = true;
        goto L115
    L109:
        if (r2.b() != true) goto L111;
        r3 = true;
    L115:
        if (this.V != 2) goto L124;
        e r4 = this.x1;
        if (r4 != null) goto L119;
    L121:
        boolean r5 = false;
    L122:
        if (r5 == false) goto L124;
        return false;
    L119:
        if (r4.intercept() != true) goto L121;
        r5 = true;
    L124:
        this.k1 = false;
        this.h1 = false;
    L125:
        int r6 = this.V;
        boolean r7 = super.onInterceptTouchEvent(r8);
        if (this.V != 1) goto L130;
        if (r6 != 2) goto L130;
        r8.getAction();
    L130:
        return r7;
    L11:
        if (r0 == 1) goto L94;
        if (r0 != 2) goto L14;
        int r9 = this.g1;
        if (r9 == (-1)) goto L93;
        int r10 = r8.findPointerIndex(r9);
        if (r10 == (-1)) goto L93;
        float r11 = r8.getX(r10);
        float r12 = r8.getY(r10);
        if (Math.abs(r11 - this.P0) <= this.b1) goto L36;
        if (Math.abs(r11 - this.P0) <= Math.abs(r12 - this.V0)) goto L36;
        c r13 = this.v1;
        if (r13 == null) goto L36;
        r13.b();
    L36:
        if (this.G1 == true) goto L38;
    L52:
        nz3.a r14 = this.L1;
        if (r14 != null) goto L55;
    L57:
        boolean r15 = false;
    L59:
        if (r15 == true) goto L61;
    L73:
        nz3.a r16 = this.L1;
        if (r16 != null) goto L76;
    L78:
        boolean r17 = false;
    L79:
        if (r17 == false) goto L125;
        if ((this.P0 - r11) <= 20.0f) goto L125;
        d r18 = this.p1;
        if (r18 != null) goto L85;
    L87:
        if (r1 == false) goto L125;
        d r19 = this.p1;
        if (r19 == null) goto L91;
        r19.c();
    L91:
        this.k1 = true;
        return true;
    L85:
        if (r18.d() != true) goto L87;
        r1 = true;
        goto L87
    L76:
        if (r16.b() != true) goto L78;
        r17 = true;
        goto L79
    L61:
        if ((r11 - this.P0) <= 20.0f) goto L73;
        d r20 = this.p1;
        if (r20 != null) goto L65;
    L67:
        if (r1 == false) goto L125;
        d r21 = this.p1;
        if (r21 == null) goto L71;
        r21.a();
    L71:
        this.h1 = true;
        return true;
    L65:
        if (r20.b() != true) goto L67;
        r1 = true;
        goto L67
    L55:
        if (r14.a() != true) goto L57;
        r15 = true;
        goto L59
    L38:
        if (this.H1 == false) goto L52;
        if ((this.P0 - r11) <= 0.0f) goto L52;
        if (this.y1 == true) goto L52;
        e r22 = this.x1;
        if (r22 != null) goto L46;
    L48:
        boolean r23 = false;
    L49:
        if (r23 == false) goto L52;
        this.y1 = true;
        return true;
    L46:
        if (r22.b() != true) goto L48;
        r23 = true;
    L93:
        return false;
    L14:
        if (r0 != 3) goto L125;
        this.g1 = -1;
        if (this.G1 == false) goto L125;
        if (this.y1 == false) goto L125;
        e r24 = this.x1;
        if (r24 == null) goto L23;
        r24.a();
    L23:
        this.y1 = false;
        goto L125
    L94:
        this.g1 = -1;
        if (this.G1 == false) goto L125;
        if (this.y1 == false) goto L125;
        e r25 = this.x1;
        if (r25 == null) goto L101;
        r25.a();
    L101:
        this.y1 = false;
        goto L125
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.HandyViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        if (r5 == null) goto L6;
        r5.getAction();
    L6:
        if (this.G1 == false) goto L27;
        if (this.y1 == false) goto L27;
        if (r5 != null) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == true) goto L22;
        if (r5 != null) goto L18;
    L20:
        boolean r3 = false;
    L21:
        if (r3 == false) goto L27;
    L18:
        if (r5.getAction() != 3) goto L20;
        r3 = true;
    L22:
        e r4 = this.x1;
        if (r4 == null) goto L25;
        r4.a();
    L25:
        this.y1 = false;
        goto L27
    L12:
        if (r5.getAction() != 1) goto L14;
        r2 = true;
    L27:
        if (this.k1 == true) goto L34;
        if (this.h1 == true) goto L34;
        return super.onTouchEvent(r5);
    L34:
        if (r5 == null) goto L36;
        r5.getAction();
    L36:
        return true;
    }

    public final void setDisableOutScroll(boolean r1) {
        this.L0 = r1;
    }

    public final void setDisableScroll(boolean r1) {
        this.H0 = r1;
    }

    public final void setEnableBounce(boolean r1) {
        this.G1 = r1;
    }

    public final void setISlidesPhotosViewPagerInterceptor(nz3.a r1) {
        this.L1 = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.HandyViewPager
    public void setOffscreenPageLimit(int r5) {
        if (r5 == getOffscreenPageLimit()) goto L9;
        if (r5 != 0) goto L9;
        Field r0 = ViewPager.class.getDeclaredField("mOffscreenPageLimit");     // Catch: Exception -> L7
        r0.setAccessible(true);     // Catch: Exception -> L7
        r0.set(this, Integer.valueOf(r5));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        AoNpthService r1 = AoExceptionReporter.a;
        AoExceptionReporter.a(ErrorPriority.p1, "StoryHorizontalViewPager", "", "setOffscreenPageLimit exception", e);
        return;
    L9:
        super.setOffscreenPageLimit(r5);
    }

    public final void setScrollInterceptor(e r1) {
        this.x1 = r1;
    }

    public final void setScrollListener(c r1) {
        this.v1 = r1;
    }

    public final void setSlidesPhotosViewPagerInterceptor(nz3.a r1) {
        this.L1 = r1;
    }

    public final void setSwipeOutListener(d r1) {
        this.p1 = r1;
    }

    public StoryHorizontalViewPager(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3);
        this.b1 = -1;
        this.g1 = -1;
        b(new AnonymousClass1(this));
    }
}
