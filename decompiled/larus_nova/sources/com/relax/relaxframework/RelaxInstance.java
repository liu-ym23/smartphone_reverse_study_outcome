package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.relax.runtime.gen.AnimationFrame;
import com.relax.runtime.gen.MediaQuery;
import com.relax.runtime.gen.NativeLayoutProxy;
import com.relax.runtime.gen.PageConfig;
import com.relax.runtime.gen.RendererFunction;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0017\u0018\u0000 F2\u00020\u0001:\u0001GBW\b\u0016\u0012\b\u0010)\u001a\u0004\u0018\u00010\t\u0012\b\u0010+\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010/\u001a\u00020\r\u0012\b\u0010-\u001a\u0004\u0018\u00010\u000f\u0012\b\u00107\u001a\u0004\u0018\u00010\u001b\u0012\b\u00109\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010;\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010=\u001a\u0004\u0018\u00010%¢\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0018j\b\u0012\u0004\u0012\u00020\u0015`\u0019H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020!H\u0016J\n\u0010&\u001a\u0004\u0018\u00010%H\u0016J\n\u0010(\u001a\u0004\u0018\u00010'H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R&\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0018j\b\u0012\u0004\u0012\u00020\u0015`\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u00109\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00102¨\u0006H"}, d2 = {"Lcom/relax/relaxframework/RelaxInstance;", "", "", "rtsPipelineEnabled", "enabled", "", "setRtsPipelineEnabled", MapMonitorConst.EVENT_DESTROY, "isDestroyed", "Lcom/relax/runtime/gen/RendererFunction;", "getRendererFunction", "Lcom/relax/runtime/gen/MediaQuery;", "getMediaQuery", "Lcom/relax/relaxframework/utils/a;", "getGlobalEventEmitter", "Lcom/relax/runtime/gen/AnimationFrame;", "getAnimationFrame", "Lcom/relax/relaxframework/j5;", "el", "setRootElement", "getRootElement", "", "modifier", "collectModifierToClean", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "getModifiersToClean", "Lqpa/f;", "getUIProxy", "Lcom/relax/runtime/gen/NativeLayoutProxy;", "getLayoutProxy", "Lqpa/e;", "getShadowNodeProxy", "Lcom/relax/relaxframework/z8;", "getViewportMetrics", "metrics", "setViewportMetrics", "Lqpa/b;", "getContextProxy", "Lcom/relax/runtime/gen/PageConfig;", "getPageConfig", "_renderer", "Lcom/relax/runtime/gen/RendererFunction;", "_mediaQuery", "Lcom/relax/runtime/gen/MediaQuery;", "_animationFrame", "Lcom/relax/runtime/gen/AnimationFrame;", "_globalEventEmitter", "Lcom/relax/relaxframework/utils/a;", "_destroyed", "Z", "_el", "Lcom/relax/relaxframework/j5;", "_modifiersToClean", "Ljava/util/ArrayList;", "_ui_proxy", "Lqpa/f;", "_layout_proxy", "Lcom/relax/runtime/gen/NativeLayoutProxy;", "_shadow_node_proxy", "Lqpa/e;", "_context_proxy", "Lqpa/b;", "_pageConfig", "Lcom/relax/runtime/gen/PageConfig;", "_viewportMetrics", "Lcom/relax/relaxframework/z8;", "_rtsPipelineEnabled", "<init>", "(Lcom/relax/runtime/gen/RendererFunction;Lcom/relax/runtime/gen/MediaQuery;Lcom/relax/relaxframework/utils/a;Lcom/relax/runtime/gen/AnimationFrame;Lqpa/f;Lcom/relax/runtime/gen/NativeLayoutProxy;Lqpa/e;Lqpa/b;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public class RelaxInstance {
    public static final a Companion = null;
    private static RelaxInstance currentInstance;
    private AnimationFrame _animationFrame;
    private qpa.b _context_proxy;
    private boolean _destroyed;
    private j5 _el;
    private com.relax.relaxframework.utils.a _globalEventEmitter;
    private NativeLayoutProxy _layout_proxy;
    private MediaQuery _mediaQuery;
    private ArrayList<Integer> _modifiersToClean;
    private PageConfig _pageConfig;
    private RendererFunction _renderer;
    private boolean _rtsPipelineEnabled;
    private qpa.e _shadow_node_proxy;
    private qpa.f _ui_proxy;
    private z8 _viewportMetrics;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public void destroy() {
        this._destroyed = true;
        this._el = null;
    }

    public AnimationFrame getAnimationFrame() {
        AnimationFrame r100 = this._animationFrame;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public com.relax.relaxframework.utils.a getGlobalEventEmitter() {
        com.relax.relaxframework.utils.a r100 = this._globalEventEmitter;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_globalEventEmitter");
        return null;
    L6:
        return r100;
    }

    public MediaQuery getMediaQuery() {
        MediaQuery r100 = this._mediaQuery;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public RendererFunction getRendererFunction() {
        RendererFunction r100 = this._renderer;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public z8 getViewportMetrics() {
        z8 r100 = this._viewportMetrics;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_viewportMetrics");
        return null;
    L6:
        return r100;
    }

    public static final /* synthetic */ RelaxInstance access$getCurrentInstance$cp() {
        return currentInstance;
    }

    public qpa.b getContextProxy() {
        return this._context_proxy;
    }

    public NativeLayoutProxy getLayoutProxy() {
        return this._layout_proxy;
    }

    public ArrayList<Integer> getModifiersToClean() {
        return this._modifiersToClean;
    }

    public PageConfig getPageConfig() {
        return this._pageConfig;
    }

    public j5 getRootElement() {
        return this._el;
    }

    public qpa.e getShadowNodeProxy() {
        return this._shadow_node_proxy;
    }

    public qpa.f getUIProxy() {
        return this._ui_proxy;
    }

    public boolean isDestroyed() {
        return this._destroyed;
    }

    public boolean rtsPipelineEnabled() {
        return this._rtsPipelineEnabled;
    }

    public static final /* synthetic */ void access$setCurrentInstance$cp(RelaxInstance r100) {
        currentInstance = r100;
    }

    public void collectModifierToClean(int r100) {
        com.bytedance.rts.foundation.j.j(this._modifiersToClean, Integer.valueOf(r100));
    }

    public void setRootElement(j5 r100) {
        this._el = r100;
    }

    public void setRtsPipelineEnabled(boolean r100) {
        this._rtsPipelineEnabled = r100;
    }

    public void setViewportMetrics(z8 r100) {
        Intrinsics.checkNotNullParameter(r100, "metrics");
        this._viewportMetrics = r100;
    }

    public RelaxInstance(RendererFunction r110, MediaQuery r111, com.relax.relaxframework.utils.a r112, AnimationFrame r113, qpa.f r114, NativeLayoutProxy r115, qpa.e r116, qpa.b r117) {
        Intrinsics.checkNotNullParameter(r112, "_globalEventEmitter");
        this._modifiersToClean = com.bytedance.rts.foundation.j.k(new Integer[0]);
        this._renderer = r110;
        this._mediaQuery = r111;
        this._globalEventEmitter = r112;
        this._animationFrame = r113;
        this._ui_proxy = r114;
        this._layout_proxy = r115;
        this._shadow_node_proxy = r116;
        this._context_proxy = r117;
        this._viewportMetrics = new z8(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d, false);
        if (r117 == null) goto L6;
        this._pageConfig = r117.f534444a.b();
        return;
    }
}
