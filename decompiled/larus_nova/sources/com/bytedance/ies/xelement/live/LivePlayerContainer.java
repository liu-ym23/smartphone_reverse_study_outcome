package com.bytedance.ies.xelement.live;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.view.KeepSurfaceTextureRenderView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/xelement/live/LivePlayerContainer;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdkapi/roomplayer/AbsLivePlayerView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/livesdkapi/roomplayer/AbsLivePlayerView;", "getPlayerView$x_element_live_release", "()Lcom/bytedance/android/livesdkapi/roomplayer/AbsLivePlayerView;", "setPlayerView$x_element_live_release", "(Lcom/bytedance/android/livesdkapi/roomplayer/AbsLivePlayerView;)V", "playerView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "x-element-live_release"}, k = 1, mv = {1, 6, 0})
public final class LivePlayerContainer extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f250103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<Boolean> f250104d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbsLivePlayerView f250105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KeepSurfaceTextureRenderView f250106b;

    public static final class a {
        public a() {
        }
    }

    public LivePlayerContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LivePlayerContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        new a();
        f250103c = 1;
        f250104d = LazyKt.lazy(LivePlayerContainer$Companion$saas$2.INSTANCE);
    }

    public static final long getFakeRoomId() {
        return f250103c;
    }

    public final AbsLivePlayerView getPlayerView$x_element_live_release() {
        return this.f250105a;
    }

    public static final void setFakeRoomId(long r100) {
        f250103c = r100;
    }

    public final void setPlayerView$x_element_live_release(AbsLivePlayerView r100) {
        this.f250105a = r100;
    }

    public LivePlayerContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        if (f250104d.getValue().booleanValue() == false) goto L6;
        this.f250105a = (AbsLivePlayerView) LayoutInflater.from(r100).inflate(R.layout.x_element_x_live_legacy, this, true).findViewById(R.id.xlive_player);
        return;
    }

    public /* synthetic */ LivePlayerContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
