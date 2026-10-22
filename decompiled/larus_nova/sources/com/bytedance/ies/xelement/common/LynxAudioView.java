package com.bytedance.ies.xelement.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l76.c;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/xelement/common/LynxAudioView;", "Landroid/widget/FrameLayout;", "Ll76/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ll76/c;", "getPlayer", "()Ll76/c;", "setPlayer", "(Ll76/c;)V", "player", "Lcom/bytedance/ies/xelement/common/LynxAudioView$a;", "b", "Lcom/bytedance/ies/xelement/common/LynxAudioView$a;", "getLifecycle", "()Lcom/bytedance/ies/xelement/common/LynxAudioView$a;", "setLifecycle", "(Lcom/bytedance/ies/xelement/common/LynxAudioView$a;)V", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public abstract class LynxAudioView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f249858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f249859b;

    public interface a {
        void onAttachedToWindow();

        void onDetachedFromWindow();
    }

    public LynxAudioView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LynxAudioView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c r100 = this.f249858a;
        if (r100 == null) goto L5;
        r100.attach();
    L5:
        a r101 = this.f249859b;
        if (r101 == null) goto L9;
        r101.onAttachedToWindow();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c r100 = this.f249858a;
        if (r100 == null) goto L5;
        r100.detach();
    L5:
        a r101 = this.f249859b;
        if (r101 == null) goto L9;
        r101.onDetachedFromWindow();
        return;
    }

    public final a getLifecycle() {
        return this.f249859b;
    }

    public final c getPlayer() {
        return this.f249858a;
    }

    public final void setLifecycle(a r100) {
        this.f249859b = r100;
    }

    public final void setPlayer(c r100) {
        this.f249858a = r100;
    }

    public LynxAudioView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
    }

    public /* synthetic */ LynxAudioView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
