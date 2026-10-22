package com.larus.bmhome.chat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.mainbot.impl.databinding.LarusDeepThinkHeaderVideoBgBinding;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import j19.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import po8.f;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020\u0019J\u0006\u0010#\u001a\u00020\u0019J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/view/DeepThinkHeaderVideoView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "videoSurface", "Landroid/view/Surface;", "tag", "", "binding", "Lcom/larus/mainbot/impl/databinding/LarusDeepThinkHeaderVideoBgBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusDeepThinkHeaderVideoBgBinding;", "binding$delegate", "Lkotlin/Lazy;", "path", "Landroid/graphics/Path;", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "showFrame", "", "frame", "play", "video", "Lcom/larus/bmhome/chat/view/DeepThinkVideoDiskExt$VoiceVideo;", "tryInitVideoController", "initSurfaceView", "textureView", "Landroid/view/TextureView;", "release", "pause", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepThinkHeaderVideoView extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f310324d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f310325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f310326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f310327c;

    public static final class a {
    }

    static {
    }

    public DeepThinkHeaderVideoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepThinkHeaderVideoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final LarusDeepThinkHeaderVideoBgBinding getBinding() {
        return (LarusDeepThinkHeaderVideoBgBinding) this.f310326b.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        int r101 = getMeasuredWidth();     // Catch: Throwable -> L5
        int r102 = getMeasuredHeight();     // Catch: Throwable -> L5
        float r103 = c.c(16);     // Catch: Throwable -> L5
        this.f310327c.reset();     // Catch: Throwable -> L5
        this.f310327c.addRoundRect(0.0f, 0.0f, r101, r102, r103, r103, Path.Direction.CW);     // Catch: Throwable -> L5
        r110.clipPath(this.f310327c);     // Catch: Throwable -> L5
        super.dispatchDraw(r110);     // Catch: Throwable -> L5
        Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L14;
        FLogger.f375446a.e(this.f310325a, "dispatchDraw failed:" + r112);
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public DeepThinkHeaderVideoView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f310325a = "TextSourceVideoView-" + hashCode();
        this.f310326b = LazyKt.lazy(new f(r100, this));
        this.f310327c = new Path();
    }

    public /* synthetic */ DeepThinkHeaderVideoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
