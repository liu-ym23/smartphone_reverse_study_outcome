package com.obric.common.oea.style.scene.alpha;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/AlphaView;", "Landroid/widget/FrameLayout;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController;", "getController", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "getStatus", "Lcom/obric/common/oea/style/scene/alpha/AlphaView$a;", "listener", "Lcom/obric/common/oea/style/scene/alpha/AlphaView$a;", "getListener", "()Lcom/obric/common/oea/style/scene/alpha/AlphaView$a;", "setListener", "(Lcom/obric/common/oea/style/scene/alpha/AlphaView$a;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PlayerController f396563a;

    public interface a {
    }

    public static final class b implements nja.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlphaView f396564a;

        @Override // nja.b
        public final void a() {
            this.f396564a.getListener();
        }

        @Override // nja.b
        public final void b() {
            this.f396564a.getListener();
        }

        public b(AlphaView r100) {
            this.f396564a = r100;
        }

        @Override // nja.b
        public final void c(ScaleType r100) {
            Intrinsics.checkNotNullParameter(r100, "scaleType");
            this.f396564a.getListener();
        }
    }

    public AlphaView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AlphaView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final a getListener() {
        return null;
    }

    public final void setListener(a r100) {
    }

    private final PlayerController getController() {
        if (this.f396563a != null) goto L16;
        Object r100 = getContext();
    L6:
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        if ((r100 instanceof LifecycleOwner) == true) goto L9;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L6
    L9:
        LifecycleOwner r101 = (LifecycleOwner) r100;
    L12:
        if (r101 == null) goto L15;
        pja.a r102 = new pja.a(getContext(), r101);
        AlphaVideoViewType r103 = AlphaVideoViewType.GL_TEXTURE_VIEW;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f529528a = r103;
        PlayerController r104 = new PlayerController(r102);
        b r105 = new b(this);
        Intrinsics.checkNotNullParameter(r105, "playerAction");
        r104.f396573h = r105;
        Unit r106 = Unit.INSTANCE;
        this.f396563a = r104;
        goto L16
    L15:
        throw new IllegalStateException("AlphaView must be attached to a LifecycleOwner (Activity or Fragment).");
    L11:
        r101 = null;
    L16:
        PlayerController r107 = this.f396563a;
        Intrinsics.checkNotNull(r107);
        return r107;
    }

    public final PlayerState getStatus() {
        PlayerController r100 = this.f396563a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f396572g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        PlayerController r100 = getController();
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, "parentView");
        tja.a r101 = r100.f396569d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r101.d(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PlayerController r100 = this.f396563a;
        if (r100 == null) goto L8;
        Intrinsics.checkNotNullParameter(this, "parentView");
        tja.a r101 = r100.f396569d;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L7:
        r101.b(this);
    L8:
        PlayerController r102 = this.f396563a;
        if (r102 == null) goto L11;
        r102.e(PlayerController.c(7, null));
    L11:
        this.f396563a = null;
    }

    public AlphaView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ AlphaView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
