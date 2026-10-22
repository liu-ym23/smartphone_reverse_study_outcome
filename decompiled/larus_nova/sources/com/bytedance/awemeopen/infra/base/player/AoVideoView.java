package com.bytedance.awemeopen.infra.base.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.player.surface.AbsSurfaceSource;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001 B\u0019\u0012\u0006\u00102\u001a\u000201\u0012\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u0010#¨\u00067"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/player/AoVideoView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/awemeopen/infra/base/player/h;", "Lcom/bytedance/awemeopen/infra/base/player/surface/AbsSurfaceSource;", "getSurfaceSource", "source", "", "setSurfaceSource", "Landroid/view/ViewGroup;", KtvSubElement.CONTAINER, "setScaleContainer", "Lc64/e;", "setScaleSizeSource", "Lc64/d;", "calculator", "setSizeCalculator", "Lcom/bytedance/awemeopen/infra/base/player/k;", "listener", "setPlayStatusListener", "", "getCurrentPosition", "getDuration", "getWatchDuration", "Lcom/bytedance/awemeopen/infra/base/player/PlayState;", "getPlayState", "", "isMute", "setIsMute", "", "speed", "setPlaySpeed", "Lcom/bytedance/awemeopen/infra/base/player/g;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/awemeopen/infra/base/player/g;", "getCustomPlayer", "()Lcom/bytedance/awemeopen/infra/base/player/g;", "setCustomPlayer", "(Lcom/bytedance/awemeopen/infra/base/player/g;)V", "customPlayer", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "getSurfaceAvailableResumeCallback", "()Lkotlin/jvm/functions/Function0;", "setSurfaceAvailableResumeCallback", "(Lkotlin/jvm/functions/Function0;)V", "surfaceAvailableResumeCallback", "getPlayer", "player", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final class AoVideoView extends FrameLayout implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f198724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AbsSurfaceSource f198725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c64.e f198726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c64.d f198727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f198728e;

    public static final class a {
    }

    public static final class b implements com.bytedance.awemeopen.infra.base.player.surface.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AoVideoView f198729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f198730b;

        @Override // com.bytedance.awemeopen.infra.base.player.surface.d
        public final void a(Surface r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            AoVideoView.b(this.f198729a).a(r100);
            Function0<Unit> r101 = this.f198730b;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }

        public b(AoVideoView r100, Function0<Unit> r101) {
            this.f198729a = r100;
            this.f198730b = r101;
        }
    }

    public static final class c implements com.bytedance.awemeopen.infra.base.player.surface.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AoVideoView f198731a;

        public c(AoVideoView r100) {
            this.f198731a = r100;
        }

        @Override // com.bytedance.awemeopen.infra.base.player.surface.b
        public final void a(Surface r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            AoVideoView.b(this.f198731a).a(r100);
            AoVideoView.b(this.f198731a).resume();
            Function0<Unit> r101 = this.f198731a.getSurfaceAvailableResumeCallback();
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    static {
    }

    public final void f() {
        AbsSurfaceSource r100 = this.f198725b;
        Boolean r101 = null;
        if ((r100 instanceof com.bytedance.awemeopen.infra.base.player.surface.j) == false) goto L5;
        com.bytedance.awemeopen.infra.base.player.surface.j r102 = (com.bytedance.awemeopen.infra.base.player.surface.j) r100;
    L6:
        if (r102 == null) goto L8;
        SurfaceTexture r103 = r102.f198800e;
    L9:
        if (r100 == null) goto L11;
        Surface r104 = r100.b();
    L12:
        boolean r105 = true;
        Object[] r106 = new Object[1];
        StringBuilder r107 = new StringBuilder("resume, hash(");
        r107.append(Integer.toString(hashCode(), CharsKt.checkRadix(16)));
        r107.append("), source: ");
        r107.append(this.f198725b);
        r107.append(", pre texture: ");
        r107.append(r103);
        r107.append(", valid?: ");
        if (r104 == null) goto L15;
        r101 = Boolean.valueOf(r104.isValid());
    L15:
        r107.append(r101);
        r106[0] = r107.toString();
        AoLogger.b("AoVideoView", r106);
        if (r100 == null) goto L27;
        if (r103 == null) goto L19;
        getPlayer().a(new Surface(r103));
        getPlayer().resume();
        return;
    L19:
        if (r104 != null) goto L21;
    L23:
        r105 = false;
    L24:
        if (r105 == false) goto L26;
        getPlayer().a(r104);
        getPlayer().resume();
        return;
    L26:
        c r108 = new c(this);
        Intrinsics.checkNotNullParameter(r108, "resumeCallback");
        com.bytedance.awemeopen.infra.base.player.surface.e r109 = r100.f198783b;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r108, "callback");
        r109.f198788c = r108;
        return;
    L21:
        if (r104.isValid() != true) goto L23;
    L27:
        getPlayer().resume();
        return;
    L11:
        r104 = null;
        goto L12
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    private final g getPlayer() {
        g r100 = getCustomPlayer();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("you should set custom player first");
    }

    public final void d() {
        getPlayer().pause();
    }

    public long getCurrentPosition() {
        return getPlayer().getCurrentPosition();
    }

    public long getDuration() {
        return getPlayer().getDuration();
    }

    public PlayState getPlayState() {
        return getPlayer().getPlayState();
    }

    public long getWatchDuration() {
        return getPlayer().getWatchDuration();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.h
    public g getCustomPlayer() {
        return this.f198724a;
    }

    public final Function0<Unit> getSurfaceAvailableResumeCallback() {
        return this.f198728e;
    }

    public final AbsSurfaceSource getSurfaceSource() {
        return this.f198725b;
    }

    public static final /* synthetic */ g b(AoVideoView r100) {
        return r100.getPlayer();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.h
    public final void a(Function0<Unit> r110) {
        AbsSurfaceSource r100 = this.f198725b;
        if ((r100 instanceof com.bytedance.awemeopen.infra.base.player.surface.j) == false) goto L5;
        com.bytedance.awemeopen.infra.base.player.surface.j r101 = (com.bytedance.awemeopen.infra.base.player.surface.j) r100;
    L6:
        if (r101 == null) goto L8;
        SurfaceTexture r102 = r101.f198800e;
    L9:
        if (r100 == null) goto L11;
        Surface r103 = r100.b();
    L12:
        boolean r104 = true;
        Object[] r105 = new Object[1];
        StringBuilder r106 = new StringBuilder("bind, hash(");
        r106.append(Integer.toString(hashCode(), CharsKt.checkRadix(16)));
        r106.append("), source: ");
        r106.append(this.f198725b);
        r106.append(", pre texture: ");
        r106.append(r102);
        r106.append(", valid?: ");
        if (r103 == null) goto L15;
        Boolean r107 = Boolean.valueOf(r103.isValid());
    L16:
        r106.append(r107);
        r105[0] = r106.toString();
        AoLogger.b("AoVideoView", r105);
        if (r100 == null) goto L30;
        getPlayer().i(null);
        if (r102 == null) goto L21;
        getPlayer().a(new Surface(r102));
        r110.invoke();
        return;
    L21:
        Surface r108 = r100.b();
        if (r108 != null) goto L24;
    L26:
        r104 = false;
    L27:
        if (r104 == false) goto L29;
        getPlayer().a(r100.b());
        r110.invoke();
        return;
    L29:
        b r109 = new b(this, r110);
        Intrinsics.checkNotNullParameter(r109, "prepareCallback");
        com.bytedance.awemeopen.infra.base.player.surface.e r111 = r100.f198783b;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r109, "callback");
        r111.f198787b = r109;
        return;
    L24:
        if (r108.isValid() != true) goto L26;
    L30:
        getPlayer().a(null);
        getPlayer().i(this);
        r110.invoke();
        return;
    L15:
        r107 = null;
        goto L16
    L11:
        r103 = null;
        goto L12
    L8:
        r102 = null;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    public final void c(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        AbsSurfaceSource r101 = this.f198725b;
        if (r101 == null) goto L5;
        Surface r102 = r101.b();
    L6:
        if (r102 != null) goto L10;
        AbsSurfaceSource r103 = this.f198725b;
        if (r103 == null) goto L10;
        f r104 = new f(r100);
        Intrinsics.checkNotNullParameter(r104, "preRenderCallback");
        com.bytedance.awemeopen.infra.base.player.surface.e r105 = r103.f198783b;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, "callback");
        r105.f198786a = r104;
    L10:
        AbsSurfaceSource r106 = this.f198725b;
        if (r106 == null) goto L14;
        r106.b();
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void e(final j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        AoLogger.g("AoVideoView", new Object[]{"prepare:", r100.toString()});
        a(new AoVideoView$prepare$1(this, r100));
    }

    public final void g(long r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (r100 > getDuration()) goto L9;
        getPlayer().seekTo(r100);
        return;
    }

    public void setCustomPlayer(g r100) {
        this.f198724a = r100;
    }

    public void setIsMute(boolean r100) {
        getPlayer().setIsMute(r100);
    }

    public void setPlaySpeed(float r100) {
        getPlayer().d(r100);
    }

    public void setPlayStatusListener(k r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getPlayer().k(r100);
    }

    public void setScaleContainer(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f198726c = new c64.g(r100);
    }

    public void setScaleSizeSource(c64.e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f198726c = r100;
    }

    public void setSizeCalculator(c64.d r100) {
        Intrinsics.checkNotNullParameter(r100, "calculator");
        this.f198727d = r100;
    }

    public final void setSurfaceAvailableResumeCallback(Function0<Unit> r100) {
        this.f198728e = r100;
    }

    public void setSurfaceSource(AbsSurfaceSource r100) {
        AoLogger.b("AoVideoView", new Object[]{"hash(" + Integer.toString(hashCode(), CharsKt.checkRadix(16)) + ") ,set surface source: " + this.f198725b + " -> " + r100});
        removeAllViews();
        this.f198725b = r100;
        if (r100 == null) goto L9;
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -1);
        r101.gravity = 17;
        Context r102 = getContext();
        Intrinsics.checkNotNullParameter(r102, "c");
        com.bytedance.awemeopen.infra.base.player.surface.a r103 = r100.f198784c;
        if (r103 == null) goto L7;
        r103.release();
    L7:
        com.bytedance.awemeopen.infra.base.player.surface.i r104 = r100.a(r102);
        r100.f198784c = r104;
        r104.f198798f = r100;
        addView(r104.f198793a, r101);
        return;
    }

    public AoVideoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101);
        this.f198726c = new c64.g(this);
        this.f198727d = new c64.c();
    }
}
