package com.bytedance.locallife.poi.media;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.locallife.poi.media.api.PlayState;
import com.bytedance.locallife.poi.media.entity.PoiPlayActionType;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/locallife/poi/media/PoiCommentVideoPlayer;", "Landroid/widget/FrameLayout;", "", "Lhy6/b;", "", "playDrawableResId", "", "setPlayDrawable", "Landroid/graphics/drawable/Drawable;", "playDrawable", "pauseDrawableResId", "setPauseDrawable", "pauseDrawable", "getCurrentPosition", "", ITTVideoEngineEventSource.KEY_MUTE, "setMute", "loop", "setLoop", "Landroid/widget/ImageView;", "b", "Lkotlin/Lazy;", "getControllerImg", "()Landroid/widget/ImageView;", "controllerImg", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiCommentVideoPlayer extends FrameLayout implements hy6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<hy6.b> f262624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f262625b;

    public PoiCommentVideoPlayer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiCommentVideoPlayer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getCurrentPosition() {
        return 0;
    }

    @Override // hy6.b
    public final void onRenderStart() {
    }

    public void setLoop(boolean r100) {
    }

    public void setMute(boolean r100) {
    }

    public final void setPauseDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "pauseDrawable");
    }

    public final void setPlayDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "playDrawable");
    }

    private final ImageView getControllerImg() {
        return (ImageView) this.f262625b.getValue();
    }

    @Override // hy6.b
    public final void g() {
        Iterator r100 = ((ArrayList) this.f262624a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((hy6.b) r100.next()).g();
        goto L4
    }

    @Override // hy6.b
    public final void o(PlayState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator<T> r101 = this.f262624a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((hy6.b) r101.next()).o(r100);
        goto L4
    }

    @Override // hy6.b
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        Iterator r101 = ((ArrayList) this.f262624a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((hy6.b) r101.next()).onError(r100);
        goto L4
    }

    public final void setPauseDrawable(int r100) {
        ContextCompat.getDrawable(getContext(), r100);
    }

    public final void setPlayDrawable(int r100) {
        ContextCompat.getDrawable(getContext(), r100);
    }

    @Override // hy6.b
    public final void h(int r100, int r101) {
        Iterator<T> r102 = this.f262624a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((hy6.b) r102.next()).h(r100, r101);
        goto L4
    }

    @Override // hy6.b
    public final void onVideoSizeChanged(int r100, int r101) {
        Iterator<T> r102 = this.f262624a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((hy6.b) r102.next()).onVideoSizeChanged(r100, r101);
        goto L4
    }

    public PoiCommentVideoPlayer(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f262624a = new ArrayList();
        PoiPlayActionType r103 = PoiPlayActionType.AUTO_PLAY;
        this.f262625b = LazyKt.lazy(new PoiCommentVideoPlayer$controllerImg$2(r100));
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.poiPlayerPauseDrawable, R.attr.poiPlayerPauseShowDuration, R.attr.poiPlayerPlayDrawable});
        if (r104.getDrawable(2) != null) goto L5;
        ContextCompat.getDrawable(r100, R.drawable.life_poi_media_ic_player_play);
    L5:
        r104.getDrawable(0);
        r104.recycle();
        addView(getControllerImg());
    }

    public /* synthetic */ PoiCommentVideoPlayer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
