package com.bytedance.android.shopping.widget.ecvideoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.ttvideoengine.utils.Error;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001'B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rR*\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/b;", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;", "ecVideoPlayer", "", "setPlayer", "getPlayer", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getCoverView", "", "resourceId", "setCoverResourceId", "", "imgUrl", "setCoverUrl", "value", "d", "I", "getScaleType", "()I", "setScaleType", "(I)V", "scaleType", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/e;", "f", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/e;", "getOnVideoViewListener", "()Lcom/bytedance/android/shopping/widget/ecvideoplayer/e;", "setOnVideoViewListener", "(Lcom/bytedance/android/shopping/widget/ecvideoplayer/e;)V", "onVideoViewListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECVideoView extends FrameLayout implements b {
    public static final /* synthetic */ int h = 0;
    public final TextureRender a;
    public ECVideoPlayer b;
    public final LinkedList<g> c;
    public int d;
    public final SimpleDraweeView e;
    public e f;
    public final View g;

    public static final class a {
    }

    static {
    }

    public ECVideoView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECVideoView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void E() {
        e r0 = this.f;
        if (r0 == null) goto L5;
        r0.E();
    L5:
        Iterator<T> r1 = this.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((g) r1.next()).E();
        goto L7
    }

    public final void a() {
        this.e.setVisibility(8);
        this.g.setVisibility(8);
        e r0 = this.f;
        if (r0 == null) goto L5;
        r0.T(8);
    L5:
        Iterator<T> r1 = this.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((g) r1.next()).T(8);
        goto L7
    }

    public final void b() {
        if (this.b != null) goto L5;
        return;
    L5:
        int r0 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        StringBuilder r1 = new StringBuilder("Remove PlayerTaskExecutor");
        ECVideoPlayer r2 = this.b;
        if (r2 == null) goto L8;
        k r3 = r2.b;
    L9:
        if (r3 == null) goto L11;
        int r4 = r3.hashCode();
    L12:
        r1.append(r4);
        r1.append(" ECVideoView");
        r1.append(hashCode());
        r1.append(" playerStatus=");
        int r5 = ECVideoPlayer.r;
        ECVideoPlayer r6 = this.b;
        Intrinsics.checkNotNull(r6);
        r1.append(ECVideoPlayer.a.a(r6.g.d));
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a(r1.toString());
        TextureRender r7 = this.a;
        ECVideoPlayer r8 = r7.b;
        if (r8 == null) goto L15;
        r8.i();
    L15:
        r7.b = null;
        ECVideoPlayer r9 = this.b;
        if (r9 == null) goto L18;
        r9.m(this);
    L18:
        ECVideoPlayer r10 = this.b;
        if (r10 == null) goto L27;
        e r11 = this.f;
        if (r11 == null) goto L23;
        r11.m0(r10);
    L23:
        Iterator<T> r12 = this.c.iterator();
    L25:
        if (r12.hasNext() == false) goto L27;
        ((g) r12.next()).m0(r10);
    L27:
        this.b = null;
        int r13 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("ShowMaskAndCover ECVideoView" + hashCode() + " due to removePlayer");
        c();
        return;
    L11:
        r4 = 0;
        goto L12
    L8:
        r3 = null;
        goto L9
    }

    public final void c() {
        this.g.setVisibility(0);
        this.e.setVisibility(0);
        e r0 = this.f;
        if (r0 == null) goto L5;
        r0.T(0);
    L5:
        Iterator<T> r1 = this.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((g) r1.next()).T(0);
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void g() {
        e r0 = this.f;
        if (r0 == null) goto L5;
        r0.g();
    L5:
        Iterator<T> r1 = this.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((g) r1.next()).g();
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onIdle() {
        int r0 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("ShowMaskAndCover ECVideoView" + hashCode() + " due to onIdle");
        c();
        e r1 = this.f;
        if (r1 == null) goto L5;
        r1.onIdle();
    L5:
        Iterator<T> r2 = this.c.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        ((g) r2.next()).onIdle();
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onPaused() {
        e r0 = this.f;
        if (r0 == null) goto L5;
        r0.onPaused();
    L5:
        Iterator<T> r1 = this.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((g) r1.next()).onPaused();
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onPlaying() {
        e r0 = this.f;
        if (r0 == null) goto L5;
        r0.onPlaying();
    L5:
        Iterator<T> r1 = this.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((g) r1.next()).onPlaying();
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onRenderStart() {
        int r0 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("HideMaskAndCover ECVideoView" + hashCode() + " due to onRenderStart");
        a();
        e r1 = this.f;
        if (r1 == null) goto L6;
        r1.onRenderStart();
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void w() {
        e r0 = this.f;
        if (r0 == null) goto L5;
        r0.w();
    L5:
        Iterator<T> r1 = this.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((g) r1.next()).w();
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onRelease() {
        b();
        e r0 = this.f;
        if (r0 == null) goto L5;
        r0.onRelease();
    L5:
        Iterator<T> r1 = this.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((g) r1.next()).onRelease();
        goto L7
    }

    public final SimpleDraweeView getCoverView() {
        return this.e;
    }

    public final e getOnVideoViewListener() {
        return this.f;
    }

    public final ECVideoPlayer getPlayer() {
        return this.b;
    }

    public final int getScaleType() {
        return this.d;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onError(Error r3) {
        e r0 = this.f;
        if (r0 == null) goto L5;
        r0.onError(r3);
    L5:
        Iterator<T> r1 = this.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((g) r1.next()).onError(r3);
        goto L7
    }

    public final void setCoverResourceId(int r3) {
        this.e.setVisibility(0);
        this.e.setActualImageResource(r3);
    }

    public final void setCoverUrl(String r3) {
        Intrinsics.checkNotNullParameter(r3, "imgUrl");
        this.e.setVisibility(0);
        this.e.setImageURI(r3);
    }

    public final void setOnVideoViewListener(e r1) {
        this.f = r1;
    }

    public final void setPlayer(ECVideoPlayer r7) {
        Intrinsics.checkNotNullParameter(r7, "ecVideoPlayer");
        if (this.b != null) goto L46;
        int r0 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        StringBuilder r1 = new StringBuilder("SetPlayer PlayerTaskExecutor");
        r1.append(r7.b.hashCode());
        r1.append(" ECVideoView");
        r1.append(hashCode());
        r1.append(" playerStatus=");
        int r2 = ECVideoPlayer.r;
        r1.append(ECVideoPlayer.a.a(r7.g.d));
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a(r1.toString());
        this.b = r7;
        this.a.setPlayer(r7);
        ECVideoPlayer r3 = this.b;
        if (r3 == null) goto L7;
        r3.a(this);
    L7:
        boolean r4 = true;
        if (r7.e() == false) goto L10;
    L14:
        k r5 = r7.b;
        Object r6 = r5.f;
        monitor-enter(r6);
        j r8 = r5.g;     // Catch: Throwable -> L42
        if (r8 != null) goto L19;
    L22:
        Iterator<T> r9 = r5.d.iterator();     // Catch: Throwable -> L42
    L24:
        if (r9.hasNext() == false) goto L29;
        if (((j) r9.next()).getType() != 2) goto L24;
        monitor-exit(r6);
    L32:
        if (r4 == true) goto L34;
        int r10 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("HideMaskAndCover ECVideoView" + hashCode() + " due to setPlayer");
        a();
    L34:
        e r11 = this.f;
        if (r11 == null) goto L37;
        r11.U2(r7);
    L37:
        Iterator<T> r12 = this.c.iterator();
    L39:
        if (r12.hasNext() == false) goto L41;
        ((g) r12.next()).U2(r7);
        goto L39
    L41:
        return;
    L29:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(r6);
        r4 = false;
        goto L32
    L19:
        if (r8.getType() != 2) goto L22;
        monitor-exit(r6);
    L42:
        th = move-exception;
        throw th;
    L10:
        if (r7.g.d != 4) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L34;
    L12:
        r14 = false;
        goto L13
    L46:
        throw new IllegalStateException("ECVideoView already has player");
    }

    public final void setScaleType(int r3) {
        if (this.d == r3) goto L12;
        if (r3 != 0) goto L6;
        this.e.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    L10:
        this.a.setScaleType(r3);
        this.d = r3;
        return;
    L6:
        if (r3 != 1) goto L10;
        this.e.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        goto L10
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void h(int r3, int r4) {
        e r0 = this.f;
        if (r0 == null) goto L5;
        r0.h(r3, r4);
    L5:
        Iterator<T> r1 = this.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((g) r1.next()).h(r3, r4);
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onVideoSizeChanged(int r3, int r4) {
        l r0 = this.a.f;
        if (r0.b == r4) goto L5;
    L6:
        r0.b = r4;
        r0.a = r3;
        r0.c.requestLayout();
        return;
    L5:
        if (r0.a != r3) goto L6;
    }

    public ECVideoView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        AttributeSet r1 = null;
        TextureRender r8 = new TextureRender(r5, r1, 6, 0);
        this.a = r8;
        this.c = new LinkedList();
        this.d = 1;
        View r0 = new SimpleDraweeView(r5);
        this.e = r0;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -1);
        r2.gravity = 17;
        Unit r3 = Unit.INSTANCE;
        r8.setLayoutParams(r2);
        addView(r8);
        setScaleType(1);
        View r9 = new View(r5);
        this.g = r9;
        addView(r9, -1, -1);
        r9.setBackgroundColor(-16777216);
        addView(r0, -1, -1);
    }

    public /* synthetic */ ECVideoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
