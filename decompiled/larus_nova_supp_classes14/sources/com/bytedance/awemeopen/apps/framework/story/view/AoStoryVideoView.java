package com.bytedance.awemeopen.apps.framework.story.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c64.e;
import com.bytedance.awemeopen.infra.base.player.PlayState;
import com.bytedance.awemeopen.infra.base.player.g;
import com.bytedance.awemeopen.infra.base.player.h;
import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.infra.base.player.surface.AbsSurfaceSource;
import com.bytedance.awemeopen.infra.base.player.surface.d;
import com.bytedance.awemeopen.infra.base.player.surface.i;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB\u0019\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\"¨\u0006."}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/story/view/AoStoryVideoView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/awemeopen/infra/base/player/h;", "Lcom/bytedance/awemeopen/infra/base/player/surface/AbsSurfaceSource;", "source", "", "setSurfaceSource", "Landroid/view/ViewGroup;", "container", "setScaleContainer", "Lc64/e;", "setScaleSizeSource", "Lc64/d;", "calculator", "setSizeCalculator", "Lcom/bytedance/awemeopen/infra/base/player/k;", "listener", "setPlayStatusListener", "", "getCurrentPosition", "getDuration", "getWatchDuration", "Lcom/bytedance/awemeopen/infra/base/player/PlayState;", "getPlayState", "", "isMute", "setIsMute", "", "speed", "setPlaySpeed", "Lcom/bytedance/awemeopen/infra/base/player/g;", "a", "Lcom/bytedance/awemeopen/infra/base/player/g;", "getCustomPlayer", "()Lcom/bytedance/awemeopen/infra/base/player/g;", "setCustomPlayer", "(Lcom/bytedance/awemeopen/infra/base/player/g;)V", "customPlayer", "getPlayer", "player", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AoStoryVideoView extends FrameLayout implements h {
    public g a;
    public AbsSurfaceSource b;
    public View c;

    public static final class a {
    }

    public static final class b implements d {
        public final /* synthetic */ AoStoryVideoView a;
        public final /* synthetic */ Function0<Unit> b;

        public final void a(Surface r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
            AoStoryVideoView.b(this.a).a(r2);
            Function0<Unit> r3 = this.b;
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }

        public b(AoStoryVideoView r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public void setScaleSizeSource(e r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    public void setSizeCalculator(c64.d r2) {
        Intrinsics.checkNotNullParameter(r2, "calculator");
    }

    private final g getPlayer() {
        g r0 = getCustomPlayer();
        if (r0 == null) goto L6;
        return r0;
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

    public g getCustomPlayer() {
        return this.a;
    }

    public static final /* synthetic */ g b(AoStoryVideoView r0) {
        return r0.getPlayer();
    }

    public final void a(Function0<Unit> r4) {
        AbsSurfaceSource r0 = this.b;
        if (r0 == null) goto L13;
        getPlayer().i(null);
        Surface r1 = r0.b();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.isValid() != true) goto L9;
    L10:
        if (r2 == false) goto L12;
        getPlayer().a(r0.b());
        r4.invoke();
        return;
    L12:
        b r3 = new b(this, r4);
        Intrinsics.checkNotNullParameter(r3, "prepareCallback");
        com.bytedance.awemeopen.infra.base.player.surface.e r5 = r0.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r3, "callback");
        r5.b = r3;
        return;
    L9:
        r2 = false;
        goto L10
    L13:
        getPlayer().a(null);
        getPlayer().i(this);
        r4.invoke();
    }

    public void setCustomPlayer(g r1) {
        this.a = r1;
    }

    public void setIsMute(boolean r2) {
        getPlayer().setIsMute(r2);
    }

    public void setPlaySpeed(float r2) {
        getPlayer().d(r2);
    }

    public void setPlayStatusListener(k r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        getPlayer().k(r2);
    }

    public void setScaleContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public void setSurfaceSource(AbsSurfaceSource r4) {
        removeAllViews();
        this.b = r4;
        if (r4 == null) goto L9;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(0, 0);
        r0.gravity = 1;
        Context r1 = getContext();
        Intrinsics.checkNotNullParameter(r1, "c");
        com.bytedance.awemeopen.infra.base.player.surface.a r2 = r4.c;
        if (r2 == null) goto L7;
        r2.release();
    L7:
        i r3 = r4.a(r1);
        r4.c = r3;
        r3.f = r4;
        View r5 = r3.a;
        this.c = r5;
        addView(r5, r0);
        return;
    }

    public AoStoryVideoView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3);
        Intrinsics.checkNotNullParameter(this, "v");
    }
}
