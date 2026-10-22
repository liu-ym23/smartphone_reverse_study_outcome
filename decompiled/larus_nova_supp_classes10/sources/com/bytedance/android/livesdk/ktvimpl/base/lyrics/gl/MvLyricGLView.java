package com.bytedance.android.livesdk.ktvimpl.base.lyrics.gl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.canvasgl.glview.GLContinuousSurfaceAdapterView;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fb0.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\b\u0016\u0012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u0001¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001B\u001f\b\u0016\u0012\b\u0010\u0086\u0001\u001a\u00030\u0085\u0001\u0012\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001¢\u0006\u0006\b\u0087\u0001\u0010\u008b\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J*\u0010\u0019\u001a\u00020\b*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J$\u0010\u001c\u001a\u00020\b*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J$\u0010\u001d\u001a\u00020\b*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J(\u0010\"\u001a\u00020\b*\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\u0002J(\u0010#\u001a\u00020\b*\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\fH\u0002J\u0018\u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fH\u0002J\b\u0010*\u001a\u00020\bH\u0016J \u0010,\u001a\u00020\b2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010+\u001a\u00020\nH\u0016J\u0018\u0010/\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u0017H\u0016J\u0012\u00101\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u00102\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u00103\u001a\u00020\bH\u0016J\b\u00105\u001a\u000204H\u0016J\u0018\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u001506j\b\u0012\u0004\u0012\u00020\u0015`7H\u0016J\b\u00109\u001a\u00020\u0017H\u0016J\b\u0010:\u001a\u00020\u0017H\u0016J\b\u0010<\u001a\u00020;H\u0016J\b\u0010>\u001a\u00020=H\u0016J\b\u0010?\u001a\u00020\bH\u0016J\b\u0010@\u001a\u00020\fH\u0016J\b\u0010A\u001a\u00020\u000fH\u0016J\b\u0010B\u001a\u00020\u0017H\u0014R\u0014\u0010C\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010DR\u0014\u0010F\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR$\u0010M\u001a\u0012\u0012\u0004\u0012\u00020\u001506j\b\u0012\u0004\u0012\u00020\u0015`78\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010PR\u0016\u0010R\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010SR\u001e\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010XR \u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010GR\u001e\u0010^\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010VR\u0016\u0010`\u001a\u00020_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010dR\u0016\u0010f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010GR\u0016\u0010g\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010GR\u0016\u0010h\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010SR\u0016\u0010i\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010SR\u0016\u0010j\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010SR\u0016\u0010k\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010XR\u0018\u0010l\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010n\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010mR\u0018\u0010p\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010DR\u0016\u0010s\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010DR\u0016\u0010t\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010GR\"\u0010u\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zRY\u0010\u007f\u001a4\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b|\u0012\b\bA\u0012\u0004\b\b(}\u0012\u0013\u0012\u00110\n¢\u0006\f\b|\u0012\b\bA\u0012\u0004\b\b(~\u0012\u0004\u0012\u00020\b\u0018\u00010{8\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001¨\u0006\u008c\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/gl/MvLyricGLView;", "Lcom/bytedance/android/live/ktv/common/canvasgl/glview/GLContinuousSurfaceAdapterView;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/a;", "Lcom/bytedance/android/live/ktv/common/util/c;", "Landroid/graphics/Paint$FontMetrics;", "fontMetrics", "", "getMiddleLine", "", "dynamicPreload", "", "playTime", "", "findCurrentIndex", "calculateLineProgress", "", "text", "measureShowText", "Leb0/c;", "index", "", "Lcom/bytedance/component/lyric/model/b;", "lyricsLineInfoList", "", "isCurrentLine", "drawLyric", "content", "baseLineHeight", "drawOtherLineLyric", "drawCurrentLineLyric", "Landroid/graphics/Bitmap;", "bitmap", "Lib0/b;", "cropFilter", "drawLeftLyric", "drawRightLyric", "nextShowIndex", "startAlphaAnimation", "start", "end", "Landroid/animation/ValueAnimator;", "getAlphaAnim", "onConfigComplete", LayoutSizeLargeModeConfig.TYPE_SIZE_DP, "addLyrics", "lyricsLineInfo", "dynamicAdd", "adjustAddLyricsLine", "canvas", "onGLDraw", "renderLyricsByPlayTime", "release", "Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", "getDisplayConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCurrentLyrics", "isDrawLastLine", "isFinishDrawLastLine", "Landroid/view/View;", "asView", "Landroid/graphics/Paint$Align;", "getTextAlign", "updateDynamicPaintColor", "getCurrentIndex", "name", "useGLChoreographer", "countDownEnable", "Z", "lyricsTrimEnable", "interlude_gap", "I", "config", "Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", "Lvd2/a;", "lyricsBitmapCache", "Lvd2/a;", "lyricsLineInfos", "Ljava/util/ArrayList;", "dynamicCropFilter", "Lib0/b;", "dynamicCropFilterForWhiteTxt", "dynamicDistance", "F", "lastAdjustLyricWidth", "lastLyricsLineInfoList", "Ljava/util/List;", "lastOffset", "J", "lastoffset", "", "textMeasuredLengthMap", "Ljava/util/Map;", "addedLines", "lastLyric", "Landroid/graphics/Paint;", "normalLyricPaint", "Landroid/graphics/Paint;", "Landroid/graphics/Rect;", "lyricsRect", "Landroid/graphics/Rect;", "pendingLyricsRect", "curToAddLineIndex", "curShowIndex", "middleBaseShowPaint", "middleBaseOtherPaint", "middleBaseDynamicPaint", "currMusicProcess", "alphaHide", "Landroid/animation/ValueAnimator;", "alphaShow", "Landroid/animation/AnimatorSet;", "alphaAnimSet", "Landroid/animation/AnimatorSet;", "isAnimating", "isAnimatingHide", "otherLineAlpha", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "isTimeOut", "timeStamp", "oneDrawCallback", "Lkotlin/jvm/functions/Function2;", "getOneDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setOneDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvLyricGLView extends GLContinuousSurfaceAdapterView implements com.bytedance.android.livesdk.ktvimpl.base.lyrics.a, com.bytedance.android.live.ktv.common.util.c {
    private int addedLines;
    private AnimatorSet alphaAnimSet;
    private ValueAnimator alphaHide;
    private ValueAnimator alphaShow;
    private LyricsDisplayConfig config;
    private final boolean countDownEnable;
    private volatile int curShowIndex;
    private int curToAddLineIndex;
    private long currMusicProcess;
    private final ib0.b dynamicCropFilter;
    private final ib0.b dynamicCropFilterForWhiteTxt;
    private float dynamicDistance;
    private final int interlude_gap;
    private volatile boolean isAnimating;
    private volatile boolean isAnimatingHide;
    private float lastAdjustLyricWidth;
    private List<com.bytedance.component.lyric.model.b> lastLyric;
    private List<com.bytedance.component.lyric.model.b> lastLyricsLineInfoList;
    private long lastOffset;
    private long lastoffset;
    private final vd2.a lyricsBitmapCache;
    private final ArrayList<com.bytedance.component.lyric.model.b> lyricsLineInfos;
    private final Rect lyricsRect;
    private final boolean lyricsTrimEnable;
    private float middleBaseDynamicPaint;
    private float middleBaseOtherPaint;
    private float middleBaseShowPaint;
    private Paint normalLyricPaint;
    private Function2<? super Boolean, ? super Long, Unit> oneDrawCallback;
    private volatile int otherLineAlpha;
    private final Rect pendingLyricsRect;
    private final Map<String, Float> textMeasuredLengthMap;
    private String typeName;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ MvLyricGLView a;

        public a(MvLyricGLView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            MvLyricGLView r0 = this.a;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            MvLyricGLView.access$setOtherLineAlpha$p(r0, ((Integer) r3).intValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ MvLyricGLView a;
        public final /* synthetic */ int b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            MvLyricGLView.access$setAnimating$p(this.a, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            MvLyricGLView.access$setAnimating$p(this.a, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            MvLyricGLView.access$setAnimating$p(this.a, true);
            int r5 = MvLyricGLView.access$getLyricsLineInfos$p(this.a).size();
            if ((this.b % 2) == 0) goto L5;
        L15:
            MvLyricGLView.access$setCurShowIndex$p(this.a, this.b);
            if (MvLyricGLView.access$getCountDownEnable$p(this.a) == false) goto L19;
            MvLyricGLView.access$setDynamicDistance$p(this.a, 0.0f);
            return;
        L19:
            return;
        L5:
            if (MvLyricGLView.access$getCountDownEnable$p(this.a) == false) goto L15;
            int r1 = this.b;
            if (r1 < 0) goto L15;
            if (r1 >= (r5 - 1)) goto L15;
            if (((com.bytedance.component.lyric.model.b) ListProtector.get(MvLyricGLView.access$getLyricsLineInfos$p(this.a), this.b)).i == false) goto L15;
            int r6 = MvLyricGLView.access$getLyricsLineInfos$p(this.a).size();
            if (this.b >= (r6 - 1)) goto L15;
            ArrayList r7 = MvLyricGLView.access$getLyricsLineInfos$p(this.a);
            int r2 = this.b + 1;
            com.bytedance.component.lyric.model.b r3 = new com.bytedance.component.lyric.model.b();
            r3.a = 1;
            Unit r0 = Unit.INSTANCE;
            ListProtector.add(r7, r2, r3);
            goto L15
        }

        public b(MvLyricGLView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ MvLyricGLView a;

        public c(MvLyricGLView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            MvLyricGLView.access$setAnimatingHide$p(this.a, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            MvLyricGLView.access$setAnimatingHide$p(this.a, true);
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ MvLyricGLView a;

        public d(MvLyricGLView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            MvLyricGLView.access$setAnimating$p(this.a, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            MvLyricGLView.access$setAnimating$p(this.a, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public View asView() {
        return this;
    }

    public String name() {
        return "MvLyricGLView";
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void release() {
        this.curToAddLineIndex = 0;
        this.currMusicProcess = 0;
        this.curShowIndex = 0;
        this.lyricsLineInfos.clear();
        this.lastLyricsLineInfoList = null;
        this.lyricsBitmapCache.b();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void resetCurrMusicProcess() {
    }

    public void setHideFirstLineLyric(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void setLyricOneLineMaxWidth(float r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void setLyricVisible(int r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void updateCurrentState(KtvRoomLyricsStateMachineConfig.d r1) {
    }

    public boolean useGLChoreographer() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void dynamicPreload() {
        this.lyricsBitmapCache.c(this.lyricsLineInfos, this.curShowIndex, getMeasuredWidth(), getMeasuredHeight(), this.middleBaseShowPaint, this.middleBaseDynamicPaint, this.middleBaseOtherPaint);
    }

    public boolean isDrawLastLine() {
        int r0 = this.curShowIndex;
        ArrayList r1 = new ArrayList(this.lyricsLineInfos);
        if (r0 > 0) goto L5;
    L9:
        return false;
    L5:
        if (r0 != (r1.size() - 1)) goto L9;
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0)).c > this.currMusicProcess) goto L9;
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public boolean isFinishDrawLastLine() {
        int r0 = this.curShowIndex;
        ArrayList r1 = new ArrayList(this.lyricsLineInfos);
        if (r0 > 0) goto L5;
        return false;
    L5:
        if (r0 == (r1.size() - 1)) goto L7;
        return false;
    L7:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0)).g == null) goto L18;
        int[] r3 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0)).g;
        Intrinsics.checkNotNull(r3);
        int r5 = r3.length;
        int r6 = 0;
        int r7 = 0;
    L9:
        if (r6 >= r5) goto L12;
        r7 = r7 + r3[r6];
        r6 = r6 + 1;
        goto L9
    L12:
        if ((((com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0)).b + r7) > this.currMusicProcess) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void onConfigComplete() {
        vd2.a r0 = this.lyricsBitmapCache;
        LyricsDisplayConfig r1 = this.config;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "config");
        r0.c = r1;
        this.middleBaseShowPaint = getMiddleLine(this.config.k.getFontMetrics());
        this.middleBaseOtherPaint = getMiddleLine(this.config.i.getFontMetrics());
        this.middleBaseDynamicPaint = getMiddleLine(this.config.l.getFontMetrics());
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void updateDynamicPaintColor() {
        this.lyricsBitmapCache.b();
        this.lyricsBitmapCache.a(this.lyricsLineInfos, this.curShowIndex);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public int getCurrentIndex() {
        return this.curShowIndex;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public ArrayList<com.bytedance.component.lyric.model.b> getCurrentLyrics() {
        return this.lyricsLineInfos;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public LyricsDisplayConfig getDisplayConfig() {
        return this.config;
    }

    public Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.oneDrawCallback;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public Paint.Align getTextAlign() {
        return Paint.Align.LEFT;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public MvLyricGLView(Context r1) {
        super(r1);
        this.countDownEnable = h.m();
        this.lyricsTrimEnable = h.v();
        this.interlude_gap = h.s();
        this.config = new LyricsDisplayConfig();
        this.lyricsBitmapCache = new vd2.a();
        this.lyricsLineInfos = new ArrayList();
        this.dynamicCropFilter = new ib0.b();
        this.dynamicCropFilterForWhiteTxt = new ib0.b();
        this.textMeasuredLengthMap = new LinkedHashMap();
        this.normalLyricPaint = this.config.k;
        this.lyricsRect = new Rect();
        this.pendingLyricsRect = new Rect();
        this.otherLineAlpha = 255;
        this.typeName = "lyric";
    }

    public static final /* synthetic */ boolean access$getCountDownEnable$p(MvLyricGLView r0) {
        return r0.countDownEnable;
    }

    public static final /* synthetic */ int access$getCurShowIndex$p(MvLyricGLView r0) {
        return r0.curShowIndex;
    }

    public static final /* synthetic */ float access$getDynamicDistance$p(MvLyricGLView r0) {
        return r0.dynamicDistance;
    }

    public static final /* synthetic */ ArrayList access$getLyricsLineInfos$p(MvLyricGLView r0) {
        return r0.lyricsLineInfos;
    }

    public static final /* synthetic */ int access$getOtherLineAlpha$p(MvLyricGLView r0) {
        return r0.otherLineAlpha;
    }

    public static final /* synthetic */ boolean access$isAnimating$p(MvLyricGLView r0) {
        return r0.isAnimating;
    }

    public static final /* synthetic */ boolean access$isAnimatingHide$p(MvLyricGLView r0) {
        return r0.isAnimatingHide;
    }

    private final void calculateLineProgress(long r13) {
        int r0 = this.curShowIndex;
        ArrayList r1 = new ArrayList(this.lyricsLineInfos);
        if (r0 >= r1.size()) goto L25;
        if (r0 < 0) goto L26;
        com.bytedance.component.lyric.model.b r2 = (com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0);
        float r3 = measureShowText(r2.d);
        long r14 = r13 - ((long) r2.b);
        StringBuilder r4 = new StringBuilder();
        int[] r5 = r2.g;
        float r6 = 0.0f;
        if (r5 == null) goto L21;
        int r7 = r5.length;
        long r8 = 0;
        int r9 = 0;
    L9:
        if (r9 >= r7) goto L21;
        int r10 = r5[r9];
        r8 = r8 + ((long) r10);
        String[] r11 = r2.f;
        if (r11 == null) goto L14;
        String r12 = r11[r9];
        if (r12 == null) goto L14;
    L16:
        if (r14 < r8) goto L17;
        r4.append(r12);
        r9 = r9 + 1;
        goto L9
    L17:
        if (r9 <= 0) goto L19;
        r14 = r14 - (r8 - ((long) r10));
    L19:
        r6 = (measureShowText(r12) / r5[r9]) * r14;
    L14:
        r12 = "";
    L21:
        this.dynamicDistance = (r6 + measureShowText(r4.toString())) / r3;
        return;
    L26:
        return;
    }

    private final int findCurrentIndex(long r9) {
        int r0 = this.lyricsLineInfos.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L42;
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.lyricsLineInfos, r2)).a != 1) goto L10;
        if (this.countDownEnable == false) goto L10;
    L32:
        r2 = r2 + 1;
    L10:
        if (r9 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.lyricsLineInfos, 0)).b) goto L43;
        if (r9 >= ((com.bytedance.component.lyric.model.b) ListProtector.get(this.lyricsLineInfos, r2)).b) goto L25;
        if (r2 <= 0) goto L25;
        if (this.config.n != 3) goto L18;
        calculateLineProgress(r9);
    L18:
        int r3 = r2 - 1;
        if (this.countDownEnable == false) goto L33;
        int r10 = com.bytedance.component.lyric.model.b.o;
        if (com.bytedance.component.lyric.model.b.a.a((com.bytedance.component.lyric.model.b) ListProtector.get(this.lyricsLineInfos, r3)) == false) goto L33;
        r3 = r3 - 1;
    L33:
        return r3;
    L25:
        if (r2 != (this.lyricsLineInfos.size() - 1)) goto L32;
        if (r9 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.lyricsLineInfos, r2)).b) goto L32;
        if (this.config.n != 3) goto L41;
        calculateLineProgress(r9);
    L41:
        return this.lyricsLineInfos.size() - 1;
    L43:
        return 0;
    L42:
        return 0;
    }

    private final float getMiddleLine(Paint.FontMetrics r3) {
        float r0 = r3.descent;
        return ((r0 - r3.ascent) / 2) - r0;
    }

    private final float measureShowText(String r4) {
        if (r4 != null) goto L4;
    L9:
        return 0.0f;
    L4:
        if (this.textMeasuredLengthMap.get(r4) == null) goto L6;
        Float r5 = this.textMeasuredLengthMap.get(r4);
    L7:
        if (r5 == null) goto L9;
        return r5.floatValue();
    L6:
        float r0 = this.config.k.measureText(r4);
        this.textMeasuredLengthMap.put(r4, Float.valueOf(r0));
        r5 = Float.valueOf(r0);
        goto L7
    }

    private final void startAlphaAnimation(int r6) {
        AnimatorSet r0 = this.alphaAnimSet;
        if (r0 != null) goto L5;
    L19:
        this.alphaAnimSet = new AnimatorSet();
        int r1 = this.otherLineAlpha;
        AnimatorSet r3 = this.alphaAnimSet;
        if (r3 == null) goto L22;
        r3.addListener(new b(this, r6));
    L22:
        this.alphaHide = getAlphaAnim(r1, 0);
        this.alphaShow = getAlphaAnim(0, 255);
        d r2 = new d(this);
        AnimatorSet r4 = this.alphaAnimSet;
        if (r4 == null) goto L25;
        r4.addListener(r2);
    L25:
        ValueAnimator r5 = this.alphaHide;
        if (r5 == null) goto L28;
        r5.addListener(new c(this));
    L28:
        AnimatorSet r7 = this.alphaAnimSet;
        if (r7 == null) goto L31;
        r7.playSequentially(new Animator[]{this.alphaHide, this.alphaShow});
    L31:
        AnimatorSet r8 = this.alphaAnimSet;
        if (r8 == null) goto L34;
        r8.setDuration(500);
    L34:
        AnimatorSet r9 = this.alphaAnimSet;
        if (r9 == null) goto L38;
        r9.start();
        return;
    L38:
        return;
    L5:
        if (r0.isRunning() != true) goto L19;
        AnimatorSet r10 = this.alphaAnimSet;
        if (r10 == null) goto L9;
        r10.cancel();
    L9:
        AnimatorSet r11 = this.alphaAnimSet;
        if (r11 == null) goto L12;
        r11.removeAllListeners();
    L12:
        ValueAnimator r12 = this.alphaShow;
        if (r12 == null) goto L15;
        r12.removeAllUpdateListeners();
    L15:
        ValueAnimator r13 = this.alphaHide;
        if (r13 == null) goto L18;
        r13.removeAllUpdateListeners();
    L18:
        this.otherLineAlpha = 255;
        goto L19
    }

    public void onGLDraw(eb0.c r11) {
        int r0 = this.curShowIndex;
        ArrayList r1 = new ArrayList(this.lyricsLineInfos);
        if (r0 >= r1.size()) goto L53;
        if (r0 < 0) goto L58;
        Function2<Boolean, Long, Unit> r2 = getOneDrawCallback();
        if (r2 == null) goto L10;
        Unit r3 = (Unit) r2.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
    L10:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0)).i == true) goto L12;
    L34:
        if (r11 == null) goto L37;
        drawLyric(r11, r0, r1, true);
    L37:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0)).i == true) goto L39;
        if (r11 != null) goto L45;
        return;
    L45:
        if (this.isAnimatingHide == false) goto L47;
        int r4 = r0 - 1;
    L48:
        drawLyric(r11, r4, r1, false);
        return;
    L47:
        r4 = r0 + 1;
        goto L48
    L39:
        if (this.currMusicProcess < (((com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0)).c + 1000)) goto L54;
        this.otherLineAlpha = 255;
        if (r11 == null) goto L55;
        drawLyric(r11, r0 + 1, r1, false);
        return;
    L55:
        return;
    L54:
        return;
    L12:
        if (r1.size() > 0) goto L14;
    L19:
        int r5 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0)).c;
    L21:
        if ((this.currMusicProcess - ((long) r5)) <= 1000) goto L34;
        int r6 = r0 + 1;
        if (r6 >= r1.size()) goto L50;
        com.bytedance.component.lyric.model.b r7 = (com.bytedance.component.lyric.model.b) ListProtector.get(r1, r6);
        if (this.countDownEnable == false) goto L30;
        int r8 = com.bytedance.component.lyric.model.b.o;
        if (com.bytedance.component.lyric.model.b.a.a(r7) == false) goto L30;
        r6 = r0 + 2;
        r7 = (com.bytedance.component.lyric.model.b) ListProtector.get(r1, r6);
    L30:
        if (r7.b >= (this.currMusicProcess + ((long) 3000))) goto L51;
        if (r11 == null) goto L52;
        drawLyric(r11, r6, r1, false);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L14:
        if (r0 < (r1.size() - 1)) goto L19;
        Integer r9 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0)).m;
        if (r9 == null) goto L18;
        r5 = r9.intValue();
        goto L21
    L18:
        r5 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0)).c;
        goto L21
    L58:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void renderLyricsByPlayTime(long r2) {
        if (this.lyricsLineInfos.isEmpty() == false) goto L5;
        return;
    L5:
        this.currMusicProcess = r2;
        int r3 = findCurrentIndex(r2);
        this.lyricsBitmapCache.a(this.lyricsLineInfos, r3);
        if (this.curShowIndex == r3) goto L9;
        startAlphaAnimation(r3);
        return;
    }

    public void setLyricAlignStyle(Paint.Align r2) {
        Intrinsics.checkNotNullParameter(r2, "align");
        Intrinsics.checkNotNullParameter(r2, "align");
    }

    public void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
        this.oneDrawCallback = r1;
    }

    public void setTypeName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.typeName = r2;
    }

    public MvLyricGLView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.countDownEnable = h.m();
        this.lyricsTrimEnable = h.v();
        this.interlude_gap = h.s();
        this.config = new LyricsDisplayConfig();
        this.lyricsBitmapCache = new vd2.a();
        this.lyricsLineInfos = new ArrayList();
        this.dynamicCropFilter = new ib0.b();
        this.dynamicCropFilterForWhiteTxt = new ib0.b();
        this.textMeasuredLengthMap = new LinkedHashMap();
        this.normalLyricPaint = this.config.k;
        this.lyricsRect = new Rect();
        this.pendingLyricsRect = new Rect();
        this.otherLineAlpha = 255;
        this.typeName = "lyric";
    }

    public static final /* synthetic */ void access$setAnimating$p(MvLyricGLView r0, boolean r1) {
        r0.isAnimating = r1;
    }

    public static final /* synthetic */ void access$setAnimatingHide$p(MvLyricGLView r0, boolean r1) {
        r0.isAnimatingHide = r1;
    }

    public static final /* synthetic */ void access$setCurShowIndex$p(MvLyricGLView r0, int r1) {
        r0.curShowIndex = r1;
    }

    public static final /* synthetic */ void access$setDynamicDistance$p(MvLyricGLView r0, float r1) {
        r0.dynamicDistance = r1;
    }

    public static final /* synthetic */ void access$setOtherLineAlpha$p(MvLyricGLView r0, int r1) {
        r0.otherLineAlpha = r1;
    }

    private final ValueAnimator getAlphaAnim(int r5, int r6) {
        if (KtvSettingHelper.z() == false) goto L5;
        LiveDegradeFpsAnimator r7 = LiveDegradeFpsAnimator.ofInt(new int[]{r5, r6}).setFpsConfig(KtvSettingHelper.k());
    L6:
        r7.setDuration(250);
        r7.addUpdateListener(new a(this));
        return r7;
    L5:
        r7 = ValueAnimator.ofInt(new int[]{r5, r6});
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void addLyrics(List<com.bytedance.component.lyric.model.b> r9, long r10) {
        this.lastLyricsLineInfoList = r9;
        int r1 = 0;
        if (this.config.d <= 0) goto L5;
    L9:
        this.lastOffset = r10;
        StringBuilder r0 = new StringBuilder("addLyrics ");
        if (r9 == null) goto L12;
        Integer r2 = Integer.valueOf(r9.size());
    L13:
        r0.append(r2);
        ALogger.i("mv_lyric_glImpl", r0.toString());
        this.lyricsLineInfos.clear();
        this.addedLines = 0;
        this.dynamicDistance = 0.0f;
        this.lyricsRect.setEmpty();
        this.pendingLyricsRect.setEmpty();
        this.textMeasuredLengthMap.clear();
        this.curShowIndex = 0;
        if (r9 == null) goto L21;
        Iterator<com.bytedance.component.lyric.model.b> r3 = r9.iterator();
    L17:
        if (r3.hasNext() == false) goto L21;
        com.bytedance.component.lyric.model.b r4 = r3.next();
        if (TextUtils.isEmpty(r4.d) == true) goto L17;
        adjustAddLyricsLine(r4, false);
    L21:
        long r5 = this.currMusicProcess;
        if (r5 <= 0) goto L24;
        r10 = r5;
    L24:
        this.curShowIndex = findCurrentIndex(r10);
        if (getMeasuredWidth() > 0) goto L27;
    L28:
        measure(0, 0);
    L30:
        if (r9 == null) goto L40;
        Iterator<T> r11 = r9.iterator();
        int r6 = 0;
    L33:
        if (r11.hasNext() == false) goto L40;
        com.bytedance.component.lyric.model.b r7 = (com.bytedance.component.lyric.model.b) r11.next();
        int r8 = r6 - 1;
        if (r8 <= 5) goto L39;
        if ((((com.bytedance.component.lyric.model.b) ListProtector.get(r9, r6)).b - ((com.bytedance.component.lyric.model.b) ListProtector.get(r9, r8)).c) <= this.interlude_gap) goto L39;
        ((com.bytedance.component.lyric.model.b) ListProtector.get(r9, r8)).i = true;
        ((com.bytedance.component.lyric.model.b) ListProtector.get(r9, r6)).j = true;
    L39:
        r6 = r6 + 1;
    L40:
        if (r9 == null) goto L51;
        com.bytedance.component.lyric.model.b r12 = (com.bytedance.component.lyric.model.b) CollectionsKt.lastOrNull(r9);
        if (r12 == null) goto L51;
        r12.i = true;
        int[] r13 = r12.g;
        if (r13 == null) goto L49;
        int r14 = r13.length;
        int r15 = 0;
    L46:
        if (r1 >= r14) goto L48;
        r15 = r15 + r13[r1];
        r1 = r1 + 1;
        goto L46
    L48:
        r1 = r15;
    L49:
        if (r1 <= 0) goto L51;
        r12.m = Integer.valueOf(r1 + r12.b);
    L51:
        this.lyricsBitmapCache.c(r9, this.curShowIndex, getMeasuredWidth(), getMeasuredHeight(), this.middleBaseShowPaint, this.middleBaseDynamicPaint, this.middleBaseOtherPaint);
        return;
    L27:
        if (getMeasuredHeight() > 0) goto L30;
    L12:
        r2 = null;
        goto L13
    L5:
        if (getWidth() <= 0) goto L7;
        this.config.f(getWidth());
        goto L9
    L7:
        this.lastLyric = r9;
        this.lastoffset = r10;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void adjustAddLyricsLine(com.bytedance.component.lyric.model.b r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r20, "lyricsLineInfo");
        LyricsDisplayConfig r2 = this.config;
        float r3 = r2.d;
        String r4 = r20.d;
        Paint r5 = r2.k;
        if (r21 == false) goto L5;
        int r6 = this.lyricsLineInfos.size();
    L6:
        this.addedLines = r6;
        this.lastAdjustLyricWidth = r3;
        if (r5.measureText(r4) > r3) goto L14;
        int r7 = this.curToAddLineIndex + 1;
        this.curToAddLineIndex = r7;
        if (this.addedLines >= r7) goto L11;
        this.lyricsLineInfos.add(r20);
    L11:
        if (r21 == false) goto L103;
        dynamicPreload();
        return;
    L103:
        return;
    L14:
        int r8 = this.config.n;
        if (r8 != 2) goto L32;
        com.bytedance.component.lyric.model.b r9 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r10 = new com.bytedance.component.lyric.model.b();
        StringBuilder r11 = new StringBuilder();
        StringBuilder r12 = new StringBuilder();
        StringBuilder r13 = new StringBuilder();
        String r14 = r20.d;
        if (r14 == null) goto L84;
        int r15 = r14.length();
        int r16 = 0;
    L19:
        if (r16 >= r15) goto L25;
        char r17 = r14.charAt(r16);
        r11.append(r17);
        if (r5.measureText(r11.toString()) <= r3) goto L23;
        r13.append(r17);
    L24:
        r16 = r16 + 1;
        goto L19
    L23:
        r12.append(r17);
        goto L24
    L25:
        r9.b = r20.b;
        r9.d = r12.toString();
        int r18 = this.curToAddLineIndex + 1;
        this.curToAddLineIndex = r18;
        if (this.addedLines >= r18) goto L28;
        this.lyricsLineInfos.add(r9);
    L28:
        r10.b = r20.b + 4000;
        r10.d = r13.toString();
        int r1 = this.curToAddLineIndex + 1;
        this.curToAddLineIndex = r1;
        if (this.addedLines >= r1) goto L84;
        this.lyricsLineInfos.add(r10);
    L84:
        if (r21 == false) goto L104;
        dynamicPreload();
        return;
    L104:
        return;
    L32:
        if (r8 != 3) goto L84;
        com.bytedance.component.lyric.model.b r19 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r22 = new com.bytedance.component.lyric.model.b();
        StringBuilder r23 = new StringBuilder();
        String[] r24 = r20.f;
        if (r24 == null) goto L84;
        ArrayList r25 = new ArrayList();
        ArrayList r110 = new ArrayList();
        ArrayList r111 = new ArrayList();
        StringBuilder r112 = new StringBuilder();
        StringBuilder r113 = new StringBuilder();
        ArrayList r114 = new ArrayList();
        int r115 = r20.b;
        int r26 = r24.length;
        int r27 = 0;
    L36:
        if (r27 >= r26) goto L50;
        int r116 = r26;
        String r28 = r24[r27];
        r23.append(r28);
        String[] r117 = r24;
        if (r5.measureText(r23.toString()) <= r3) goto L44;
        r111.add(r28);
        r113.append(r28);
        int[] r29 = r20.g;
        if (r29 == null) goto L49;
        if (r27 >= r29.length) goto L49;
        r114.add(Integer.valueOf(r29[r27]));
    L49:
        r27 = r27 + 1;
        r26 = r116;
        r24 = r117;
        goto L36
    L44:
        r25.add(r28);
        r112.append(r28);
        int[] r30 = r20.g;
        if (r30 == null) goto L49;
        if (r27 >= r30.length) goto L49;
        r110.add(Integer.valueOf(r30[r27]));
        r115 = r115 + r30[r27];
        goto L49
    L50:
        r19.b = r20.b;
        Object[] r31 = r25.toArray(new String[0]);
        if (r31 == null) goto L83;
        r19.f = (String[]) r31;
        r19.g = new int[r110.size()];
        int r32 = r110.size();
        int r33 = 0;
    L53:
        if (r33 >= r32) goto L59;
        int[] r34 = r19.g;
        if (r34 == null) goto L57;
        r34[r33] = ((Number) ListProtector.get(r110, r33)).intValue();
    L57:
        r33 = r33 + 1;
        goto L53
    L59:
        if (this.lyricsTrimEnable == false) goto L65;
        String r35 = r112.toString();
        if (r35 == null) goto L64;
        r19.d = StringsKt.trim(r35).toString();
    L66:
        int r36 = this.curToAddLineIndex + 1;
        this.curToAddLineIndex = r36;
        if (this.addedLines >= r36) goto L69;
        this.lyricsLineInfos.add(r19);
    L69:
        r22.b = r115;
        Object[] r37 = r111.toArray(new String[0]);
        if (r37 == null) goto L81;
        r22.f = (String[]) r37;
        r22.g = new int[r114.size()];
        int r38 = r114.size();
        int r39 = 0;
    L72:
        if (r39 >= r38) goto L77;
        int[] r40 = r22.g;
        if (r40 == null) goto L76;
        r40[r39] = ((Number) ListProtector.get(r114, r39)).intValue();
    L76:
        r39 = r39 + 1;
        goto L72
    L77:
        r22.d = r113.toString();
        int r41 = this.curToAddLineIndex + 1;
        this.curToAddLineIndex = r41;
        if (this.addedLines >= r41) goto L84;
        this.lyricsLineInfos.add(r22);
        goto L84
    L81:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L64:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L65:
        r19.d = r112.toString();
        goto L66
    L83:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L5:
        r6 = 0;
        goto L6
    }

    private final void drawCurrentLineLyric(eb0.c r5, int r6, String r7, float r8) {
        vd2.b r0 = (vd2.b) ((LinkedHashMap) this.lyricsBitmapCache.d).get(r7);
        if (r0 == null) goto L12;
        Bitmap r1 = r0.a;
        if (r1 == null) goto L12;
        float r2 = this.dynamicDistance;
        if (r2 >= 1.0f) goto L12;
        ib0.b r3 = this.dynamicCropFilterForWhiteTxt;
        r3.b = 1.0f;
        r3.a = r2;
        if ((r6 % 2) != 0) goto L11;
        drawLeftLyric(r5, r1, r8, r3);
        goto L12
    L11:
        drawRightLyric(r5, r1, r8, r3);
    L12:
        vd2.b r9 = (vd2.b) ((LinkedHashMap) this.lyricsBitmapCache.d).get(r7);
        if (r9 == null) goto L23;
        Bitmap r10 = r9.b;
        if (r10 == null) goto L24;
        float r4 = this.dynamicDistance;
        if (r4 <= 0.0f) goto L25;
        ib0.b r11 = this.dynamicCropFilter;
        r11.b = r4;
        if ((r6 % 2) != 0) goto L21;
        drawLeftLyric(r5, r10, r8, r11);
        return;
    L21:
        drawRightLyric(r5, r10, r8, r11);
        return;
    L25:
        return;
    L24:
        return;
    }

    private final void drawLeftLyric(eb0.c r1, Bitmap r2, float r3, ib0.b r4) {
        if (r2.isRecycled() == false) goto L6;
        return;
    L6:
        if (r4 == null) goto L8;
        ((eb0.b) r1).b(r2, 0, 0, r4);
        return;
    L8:
        eb0.b r5 = (eb0.b) r1;
        r5.b(r2, 0, 0, r5.c);
    }

    private final void drawLyric(eb0.c r6, int r7, List<com.bytedance.component.lyric.model.b> r8, boolean r9) {
        if (r7 >= r8.size()) goto L18;
        if (r7 < 0) goto L20;
        String r10 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r8, r7)).d;
        if (r10 != null) goto L10;
        r10 = "";
    L10:
        if (r9 == false) goto L12;
        float r1 = this.middleBaseShowPaint;
        Paint r3 = this.config.k;
        float r2 = r1;
        int r4 = 255;
    L13:
        this.normalLyricPaint = r3;
        if (r9 == true) goto L16;
        eb0.b r11 = (eb0.b) r6;
        e r12 = r11.b;
        r12.d[r12.f] = r4 / 255.0f;
        drawOtherLineLyric(r11, r7, r10, r2);
        e r13 = r11.b;
        r13.d[r13.f] = 255 / 255.0f;
        return;
    L16:
        drawCurrentLineLyric(r6, r7, r10, this.middleBaseDynamicPaint);
        return;
    L12:
        r4 = this.otherLineAlpha;
        r2 = this.middleBaseOtherPaint;
        r3 = this.config.i;
        goto L13
    L20:
        return;
    }

    private final void drawOtherLineLyric(eb0.c r8, int r9, String r10, float r11) {
        vd2.b r12 = (vd2.b) ((LinkedHashMap) this.lyricsBitmapCache.d).get(r10);
        if (r12 == null) goto L11;
        Bitmap r2 = r12.c;
        if (r2 != null) goto L7;
        return;
    L7:
        if ((r9 % 2) != 0) goto L9;
        drawLeftLyric$default(this, r8, r2, r11, null, 4, null);
        return;
    L9:
        drawRightLyric$default(this, r8, r2, r11, null, 4, null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void drawRightLyric(eb0.c r3, Bitmap r4, float r5, ib0.b r6) {
        if (r4.isRecycled() == false) goto L5;
        return;
    L5:
        int r7 = r4.getWidth();
        eb0.b r8 = (eb0.b) r3;
        int r0 = r8.e;
        int r1 = r8.f;
        if (r0 <= 0) goto L8;
        if (r1 <= 0) goto L8;
    L9:
        int r2 = r0 - r7;
        int r9 = (int) (r1 / 2.0f);
        if (r6 == null) goto L12;
        r8.b(r4, r2, r9, r6);
        return;
    L12:
        r8.b(r4, r2, r9, r8.c);
        return;
    L8:
        measure(0, 0);
        r0 = getMeasuredWidth();
        r1 = getMeasuredHeight();
        goto L9
    }

    public static /* synthetic */ void drawLeftLyric$default(MvLyricGLView r0, eb0.c r1, Bitmap r2, float r3, ib0.b r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        r0.drawLeftLyric(r1, r2, r3, r4);
    }

    public static /* synthetic */ void drawRightLyric$default(MvLyricGLView r0, eb0.c r1, Bitmap r2, float r3, ib0.b r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        r0.drawRightLyric(r1, r2, r3, r4);
    }
}
