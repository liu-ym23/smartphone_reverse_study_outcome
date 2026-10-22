package com.bytedance.android.shopping.api.video;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.base.service.ECServiceManager;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001d\u00103\u001a\u0004\u0018\u00010.8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/api/video/ECVideoPlayerView;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/shopping/api/video/i;", "", "gravity", "", "setTextureVGravity", "", "speed", "setSpeed", "", "getDuration", "getCurPosition", "getWatchedDuration", "Landroid/view/TextureView;", "getTextureView", "Landroid/view/Surface;", "getSurface", "getVideoHeight", "getVideoWidth", "", "getCurrentSimInfo", "b", "Lcom/bytedance/android/shopping/api/video/i;", "getPlayer", "()Lcom/bytedance/android/shopping/api/video/i;", "setPlayer", "(Lcom/bytedance/android/shopping/api/video/i;)V", "player", "Lcom/bytedance/android/shopping/api/video/c;", "g", "Lcom/bytedance/android/shopping/api/video/c;", "getPlayHost", "()Lcom/bytedance/android/shopping/api/video/c;", "setPlayHost", "(Lcom/bytedance/android/shopping/api/video/c;)V", "playHost", "Lcom/bytedance/android/shopping/api/video/e;", "h", "Lcom/bytedance/android/shopping/api/video/e;", "getVideoModel", "()Lcom/bytedance/android/shopping/api/video/e;", "setVideoModel", "(Lcom/bytedance/android/shopping/api/video/e;)V", "videoModel", "Lcom/bytedance/android/shopping/api/video/j;", "j", "Lkotlin/Lazy;", "getVideoViewHelper", "()Lcom/bytedance/android/shopping/api/video/j;", "videoViewHelper", "a", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECVideoPlayerView extends FrameLayout implements i {
    public final s83.f a;
    public i b;
    public ScaleType c;
    public int d;
    public int e;
    public int f;
    public c g;
    public e h;
    public final l i;
    public final Lazy j;

    public static final class a implements h {
        public a(WeakReference<ECVideoPlayerView> r2) {
            Intrinsics.checkNotNullParameter(r2, "viewWeakRef");
        }
    }

    public static final class b implements h {
        public b() {
        }
    }

    public ECVideoPlayerView(Context r7) {
        this(r7, null, 0, null, 14);
    }

    public ECVideoPlayerView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, null, 12);
    }

    public ECVideoPlayerView(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, r9, null, 8);
    }

    public final j getVideoViewHelper() {
        return (j) this.j.getValue();
    }

    public final void c() {
        if (this.b == null) goto L5;
        return;
    L5:
        s83.f r0 = this.a;
        if (r0 == null) goto L11;
        l r1 = this.i;
        if (r1 != null) goto L10;
        r1 = new l(null, false, false, false, null, false, false, 255);
    L10:
        r0.d(r1);
    L11:
        this.b = null;
    }

    public final boolean d() {
        i r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return ((ECVideoPlayerView) r0).d();
    }

    public final boolean e() {
        i r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return ((ECVideoPlayerView) r0).e();
    }

    public final boolean f() {
        i r0 = this.b;
        if (r0 != null) goto L7;
        return true;
    L7:
        return ((ECVideoPlayerView) r0).f();
    }

    public final boolean g() {
        i r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return ((ECVideoPlayerView) r0).g();
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public long getCurPosition() {
        i r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCurPosition();
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public String getCurrentSimInfo() {
        i r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentSimInfo();
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public long getDuration() {
        i r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getDuration();
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public int getVideoHeight() {
        i r0 = this.b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getVideoHeight();
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public int getVideoWidth() {
        i r0 = this.b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getVideoWidth();
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public long getWatchedDuration() {
        i r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getWatchedDuration();
    }

    public final boolean h() {
        i r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return ((ECVideoPlayerView) r0).h();
    }

    public final boolean i() {
        i r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return ((ECVideoPlayerView) r0).i();
    }

    public final void m() {
        i r0 = this.b;
        if (r0 == null) goto L6;
        ((ECVideoPlayerView) r0).m();
        return;
    }

    public final void p() {
        i r0 = this.b;
        if (r0 == null) goto L6;
        ((ECVideoPlayerView) r0).p();
        return;
    }

    public final void q() {
        i r0 = this.b;
        if (r0 == null) goto L6;
        ((ECVideoPlayerView) r0).q();
        return;
    }

    public final void s() {
        i r0 = this.b;
        if (r0 == null) goto L5;
        ((ECVideoPlayerView) r0).s();
    L5:
        this.b = null;
    }

    public final void u() {
        i r0 = this.b;
        if (r0 == null) goto L6;
        ((ECVideoPlayerView) r0).u();
        return;
    }

    public final void x() {
        i r0 = this.b;
        if (r0 == null) goto L6;
        ((ECVideoPlayerView) r0).x();
        return;
    }

    public Surface getSurface() {
        j r0 = getVideoViewHelper();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSurface();
    }

    public TextureView getTextureView() {
        j r0 = getVideoViewHelper();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final boolean n() {
        c();
        i r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return ((ECVideoPlayerView) r0).n();
    }

    public final c getPlayHost() {
        return this.g;
    }

    public final i getPlayer() {
        return this.b;
    }

    public final e getVideoModel() {
        return this.h;
    }

    public final void a(i r3) {
        Intrinsics.checkNotNullParameter(r3, "player");
        this.b = r3;
        c r0 = this.g;
        if (r0 == null) goto L8;
        if (r3 == null) goto L6;
        Intrinsics.checkNotNullParameter(r0, "host");
        Intrinsics.checkNotNullParameter(r0, "host");
    L6:
        l(r3.getVideoHeight(), r3.getVideoWidth());
        return;
    }

    public final void b(e r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        c();
        i r0 = this.b;
        if (r0 == null) goto L5;
        ((ECVideoPlayerView) r0).b(r3);
    L5:
        l(r3.j, r3.k);
        this.h = r3;
    }

    public final void j(boolean r2) {
        i r0 = this.b;
        if (r0 == null) goto L6;
        ((ECVideoPlayerView) r0).j(r2);
        return;
    }

    public final void k(boolean r2) {
        i r0 = this.b;
        if (r0 == null) goto L5;
        ((ECVideoPlayerView) r0).k(r2);
    L5:
        e r1 = this.h;
        if (r1 == null) goto L11;
        d r3 = r1.f;
        if (r3 == null) goto L12;
        r3.a = r2;
        return;
    L12:
        return;
    }

    public final void o(int r2) {
        i r0 = this.b;
        if (r0 == null) goto L6;
        ((ECVideoPlayerView) r0).o(r2);
        return;
    }

    public final void r(h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        c();
        i r0 = this.b;
        if (r0 == null) goto L6;
        ((ECVideoPlayerView) r0).r(r2);
        return;
    }

    public final void setPlayHost(c r1) {
        this.g = r1;
    }

    public final void setPlayer(i r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public void setSpeed(float r2) {
        i r0 = this.b;
        if (r0 == null) goto L6;
        r0.setSpeed(r2);
        return;
    }

    public void setTextureVGravity(int r1) {
        if (r1 <= 0) goto L5;
        this.d = r1;
        requestLayout();
        return;
    }

    public final void setVideoModel(e r1) {
        this.h = r1;
    }

    public final void t(h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        i r0 = this.b;
        if (r0 == null) goto L6;
        ((ECVideoPlayerView) r0).t(r2);
        return;
    }

    public final void v(float r2) {
        i r0 = this.b;
        if (r0 == null) goto L6;
        ((ECVideoPlayerView) r0).v(r2);
        return;
    }

    public final void w(ScaleType r2) {
        Intrinsics.checkNotNullParameter(r2, "scaleType");
        if (this.c == r2) goto L9;
        this.c = r2;
        j r3 = getVideoViewHelper();
        if (r3 == null) goto L7;
        r3.f();
    L7:
        requestLayout();
        return;
    }

    public final void l(int r2, int r3) {
        if (r2 <= 0) goto L14;
        if (r3 > 0) goto L6;
        return;
    L6:
        if (this.f == r3) goto L8;
    L9:
        this.e = r2;
        this.f = r3;
        j r4 = getVideoViewHelper();
        if (r4 == null) goto L12;
        r4.e();
    L12:
        requestLayout();
        return;
    L8:
        if (this.e != r2) goto L9;
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        j r5 = getVideoViewHelper();
        if (r5 == null) goto L12;
        getMeasuredWidth();
        getMeasuredHeight();
        Pair r6 = r5.d();
        if (r6 == null) goto L13;
        int r7 = View.MeasureSpec.makeMeasureSpec(((Number) r6.getFirst()).intValue(), 1073741824);
        int r8 = View.MeasureSpec.makeMeasureSpec(((Number) r6.getSecond()).intValue(), 1073741824);
        View r1 = getChildAt(0);
        if (r1 != null) goto L10;
        return;
    L10:
        measureChild(r1, r7 + 0, r8 + 0);
        return;
    L13:
        return;
    }

    public ECVideoPlayerView(Context r11, AttributeSet r12, int r13, l r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        boolean r15 = ECServiceManager.a;
        this.a = ((s83.g) ECServiceManager.c(s83.g.class)).p();
        this.c = ScaleType.CENTER_CROP;
        this.d = 17;
        this.e = -1;
        this.f = -1;
        this.j = LazyKt.lazy(new ECVideoPlayerView$videoViewHelper$2(this));
        s83.a r16 = ((s83.g) ECServiceManager.c(s83.g.class)).q();
        if (r16 != null) goto L5;
    L7:
        new b();
    L8:
        if (r12 == null) goto L39;
        TypedArray r17 = r11.obtainStyledAttributes(r12, new int[]{2130968753, 2130969743, 2130969954, 2130969957, 2130970440, 2130973508, 2130975032});
        int r18 = l.i;
        if (r17 != null) goto L12;
        l r19 = new l(null, false, false, false, null, false, false, 255);
    L35:
        this.i = r19;
        boolean r110 = r19.b;
        this.g = new c(this);
        if (r110 == true) goto L38;
        c();
    L38:
        r17.recycle();
    L44:
        j r111 = getVideoViewHelper();
        if (r111 == null) goto L52;
        SelectBitrateResolutionStrategy r112 = SelectBitrateResolutionStrategy.DEFAULT;
        r111.c();
        return;
    L52:
        return;
    L12:
        String r113 = r17.getString(5);
        AVScene.Companion.getClass();
        if (r113 != null) goto L15;
        AVScene r114 = AVScene.CONTENT_DEFAULT;
    L30:
        AVScene r2 = r114;
    L31:
        boolean r4 = r17.getBoolean(2, false);
        boolean r3 = r17.getBoolean(1, false);
        boolean r5 = r17.getBoolean(3, false);
        int r115 = r17.getInteger(6, 0);
        SelectBitrateResolutionStrategy.Companion.getClass();
        SelectBitrateResolutionStrategy r116 = (SelectBitrateResolutionStrategy) SelectBitrateResolutionStrategy.access$getMap$cp().get(Integer.valueOf(r115));
        if (r116 != null) goto L34;
        r116 = SelectBitrateResolutionStrategy.DEFAULT;
    L34:
        r19 = new l(r2, r3, r4, r5, r116, r17.getBoolean(4, false), r17.getBoolean(0, false), 8);
        goto L35
    L15:
        List r117 = StringsKt.split$default(r113, new char[]{'#'}, false, 0, 6, null);
        String r1 = (String) CollectionsKt.firstOrNull(r117);
        if (r1 != null) goto L18;
        r114 = AVScene.CONTENT_DEFAULT;
        goto L30
    L18:
        String r118 = (String) CollectionsKt.getOrNull(r117, 1);
        if (r118 != null) goto L21;
        r114 = AVScene.CONTENT_DEFAULT;
        goto L30
    L21:
        AVScene[] r6 = AVScene.values();
        int r7 = r6.length;
        int r8 = 0;
    L22:
        if (r8 >= r7) goto L29;
        AVScene r9 = r6[r8];
        if (Intrinsics.areEqual(r9.getTag(), r1) == false) goto L28;
        if (Intrinsics.areEqual(r9.getSubTag(), r118) == false) goto L28;
        r2 = r9;
    L28:
        r8 = r8 + 1;
        goto L22
    L29:
        int r119 = ye.a.a;
        ye.a.a("AVScene#stringConvert2AVScene fail, can't parse AVScene from XML: ".concat(r113));
        r114 = AVScene.CONTENT_DEFAULT;
        goto L30
    L39:
        if (r14 != null) goto L41;
        r14 = new l(null, false, false, false, null, false, false, 255);
    L41:
        this.i = r14;
        boolean r120 = r14.b;
        this.g = new c(this);
        if (r120 == true) goto L44;
        c();
        goto L44
    L5:
        if (r16.f() != true) goto L7;
        new a(new WeakReference(this));
        goto L8
    }

    public /* synthetic */ ECVideoPlayerView(Context r3, AttributeSet r4, int r5, l r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = null;
    L11:
        this(r3, r4, r5, r6);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        View r0 = getChildAt(0);
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof FrameLayout.LayoutParams) == true) goto L8;
        r1 = null;
    L8:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        if (r2 == null) goto L11;
        r2.gravity = this.d;
    L11:
        super.onLayout(r3, r4, r5, r6, r7);
        j r8 = getVideoViewHelper();
        if (r8 == null) goto L15;
        r8.b();
        return;
    }
}
