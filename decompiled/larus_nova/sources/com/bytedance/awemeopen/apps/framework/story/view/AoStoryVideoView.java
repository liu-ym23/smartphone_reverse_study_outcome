package com.bytedance.awemeopen.apps.framework.story.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c64.e;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.awemeopen.infra.base.player.PlayState;
import com.bytedance.awemeopen.infra.base.player.g;
import com.bytedance.awemeopen.infra.base.player.h;
import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.infra.base.player.surface.AbsSurfaceSource;
import com.bytedance.awemeopen.infra.base.player.surface.d;
import com.bytedance.awemeopen.infra.base.player.surface.i;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB\u0019\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\"¨\u0006."}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/story/view/AoStoryVideoView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/awemeopen/infra/base/player/h;", "Lcom/bytedance/awemeopen/infra/base/player/surface/AbsSurfaceSource;", "source", "", "setSurfaceSource", "Landroid/view/ViewGroup;", KtvSubElement.CONTAINER, "setScaleContainer", "Lc64/e;", "setScaleSizeSource", "Lc64/d;", "calculator", "setSizeCalculator", "Lcom/bytedance/awemeopen/infra/base/player/k;", "listener", "setPlayStatusListener", "", "getCurrentPosition", "getDuration", "getWatchDuration", "Lcom/bytedance/awemeopen/infra/base/player/PlayState;", "getPlayState", "", "isMute", "setIsMute", "", "speed", "setPlaySpeed", "Lcom/bytedance/awemeopen/infra/base/player/g;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/awemeopen/infra/base/player/g;", "getCustomPlayer", "()Lcom/bytedance/awemeopen/infra/base/player/g;", "setCustomPlayer", "(Lcom/bytedance/awemeopen/infra/base/player/g;)V", "customPlayer", "getPlayer", "player", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AoStoryVideoView extends FrameLayout implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f197649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AbsSurfaceSource f197650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f197651c;

    public static final class a {
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AoStoryVideoView f197652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f197653b;

        @Override // com.bytedance.awemeopen.infra.base.player.surface.d
        public final void a(Surface r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            AoStoryVideoView.b(this.f197652a).a(r100);
            Function0<Unit> r101 = this.f197653b;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }

        public b(AoStoryVideoView r100, Function0<Unit> r101) {
            this.f197652a = r100;
            this.f197653b = r101;
        }
    }

    static {
    }

    public void setScaleSizeSource(e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }

    public void setSizeCalculator(c64.d r100) {
        Intrinsics.checkNotNullParameter(r100, "calculator");
    }

    private final g getPlayer() {
        g r100 = getCustomPlayer();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("you should set custom player first");
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
        return getPlayer().getDuration();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.h
    public g getCustomPlayer() {
        return this.f197649a;
    }

    public static final /* synthetic */ g b(AoStoryVideoView r100) {
        return r100.getPlayer();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.h
    public final void a(Function0<Unit> r100) {
        AbsSurfaceSource r101 = this.f197650b;
        if (r101 == null) goto L13;
        getPlayer().i(null);
        Surface r102 = r101.b();
        if (r102 == null) goto L9;
        boolean r103 = true;
        if (r102.isValid() != true) goto L9;
    L10:
        if (r103 == false) goto L12;
        getPlayer().a(r101.b());
        r100.invoke();
        return;
    L12:
        b r104 = new b(this, r100);
        Intrinsics.checkNotNullParameter(r104, "prepareCallback");
        com.bytedance.awemeopen.infra.base.player.surface.e r105 = r101.f198783b;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, "callback");
        r105.f198787b = r104;
        return;
    L9:
        r103 = false;
        goto L10
    L13:
        getPlayer().a(null);
        getPlayer().i(this);
        r100.invoke();
    }

    public void setCustomPlayer(g r100) {
        this.f197649a = r100;
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
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    public void setSurfaceSource(AbsSurfaceSource r100) {
        removeAllViews();
        this.f197650b = r100;
        if (r100 == null) goto L9;
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(0, 0);
        r101.gravity = 1;
        Context r102 = getContext();
        Intrinsics.checkNotNullParameter(r102, "c");
        com.bytedance.awemeopen.infra.base.player.surface.a r103 = r100.f198784c;
        if (r103 == null) goto L7;
        r103.release();
    L7:
        i r104 = r100.a(r102);
        r100.f198784c = r104;
        r104.f198798f = r100;
        View r105 = r104.f198793a;
        this.f197651c = r105;
        addView(r105, r101);
        return;
    }

    public AoStoryVideoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101);
        Intrinsics.checkNotNullParameter(this, BaseSwitches.V);
    }
}
