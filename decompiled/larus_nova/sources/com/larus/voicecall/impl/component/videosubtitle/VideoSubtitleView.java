package com.larus.voicecall.impl.component.videosubtitle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.audio.call.subtitle.DisplayType;
import com.larus.nova.R;
import com.larus.voicecall.impl.databinding.ViewVideoSubtitleBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 N2\u00020\u0001:\u0001NB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0014J&\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000eJ\u000e\u0010&\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u000eJ\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u000eH\u0002J\u0018\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0002J \u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020-2\u0006\u0010)\u001a\u00020\t2\u0006\u0010.\u001a\u00020\tH\u0002J \u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u0002012\u0006\u0010,\u001a\u00020-2\u0006\u00102\u001a\u00020\tH\u0002J\u0018\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u00020\tH\u0002J\b\u00107\u001a\u00020\tH\u0002J\u0010\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u000eH\u0002J\u0010\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u0016H\u0002J\u000e\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020$J\u0006\u0010>\u001a\u00020\u001cJ\u0006\u0010?\u001a\u00020\u001cJ\b\u0010@\u001a\u00020\u001cH\u0002J\b\u0010A\u001a\u00020\u001cH\u0002J\b\u0010B\u001a\u00020\u001cH\u0002J\b\u0010C\u001a\u00020\u001cH\u0002J\u0016\u0010D\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\t0EH\u0002J\b\u0010F\u001a\u00020\u000eH\u0002J\f\u0010G\u001a\u00020\u0016*\u00020\u000bH\u0002J\f\u0010H\u001a\u00020\u0016*\u00020\u000bH\u0002J\u0013\u0010I\u001a\u0004\u0018\u00010\u0016*\u00020\u000bH\u0002¢\u0006\u0002\u0010JJ\u001b\u0010K\u001a\u00020\u001c*\u00020\u000b2\b\u0010L\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010MR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/larus/voicecall/impl/component/videosubtitle/VideoSubtitleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lastSubtitleIndex", "", "lastSubtitleData", "Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "subtitleStartOffset", "subtitlePrefixLine", "", "binding", "Lcom/larus/voicecall/impl/databinding/ViewVideoSubtitleBinding;", "currentTranslateAnim", "Landroid/view/ViewPropertyAnimator;", "thinkingDotAnimator", "Landroid/animation/ObjectAnimator;", "lastScrollEndTime", "", "textTranslationAnimListener", "Landroid/animation/AnimatorListenerAdapter;", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "onVisibilityChanged", "", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "updateSubtitle", "data", "index", "append", "", "reason", "scrollToEnd", "checkToScrollNextLine", "calculateTranslationOffset", "topLineIndex", "offsetLineCount", "moveToNextLine", "layout", "Landroid/text/Layout;", "bottomLineIndex", "calcStayDuration", "textView", "Landroid/widget/TextView;", "currentBottomLineIndex", "createAnimator", "offsetY", "stayDuration", "getCurrentTopLineIndex", "getCurrentBottomLineIndex", "calcDuration", "lineText", "calcTextOffset", "duration", "showThinking", "breakSubtitle", "pauseSubtitle", "resumeSubtitle", "resetTextView", "resetScrollAnim", "resetScrollValue", "resetThinkingAnim", "resetSubtitleData", "Lkotlin/Pair;", "getLastLineText", "getPausedDuration", "updatePausedDuration", "getPauseStartTime", "(Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;)Ljava/lang/Long;", "setPauseStartTime", "pauseStartTime", "(Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;Ljava/lang/Long;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoSubtitleView extends ConstraintLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f377764k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f377765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.larus.voicecall.impl.subtitle.c f377766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f377767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f377768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewVideoSubtitleBinding f377769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPropertyAnimator f377770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ObjectAnimator f377771g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f377772h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f377773i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f377774j;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f377775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoSubtitleView f377776b;

        public b(VideoSubtitleView r100) {
            this.f377776b = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationCancel(r100);
            this.f377775a = true;
            this.f377776b.f377770f = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            int r101 = c68.b.f22600a;
            c68.b.d("VideoSubtitleView", "onAnimationEnd: canceled: " + this.f377775a + ", translationY: " + this.f377776b.f377769e.f378322c.getTranslationY());
            if (this.f377775a == false) goto L5;
            return;
        L5:
            VideoSubtitleView r102 = this.f377776b;
            r102.f377770f = null;
            r102.f377772h = System.currentTimeMillis();
            this.f377776b.R5("scroll_end");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            this.f377775a = false;
        }
    }

    static {
    }

    private final int getCurrentTopLineIndex() {
        Layout r100 = this.f377769e.f378322c.getLayout();
        if (r100 != null) goto L5;
        return 0;
    L5:
        float r101 = -this.f377769e.f378322c.getTranslationY();
        int r102 = 0;
        int r103 = 0;
    L7:
        if (r102 >= r101) goto L11;
        if (r103 >= r100.getLineCount()) goto L11;
        r103 = r103 + 1;
        r102 = r100.getLineTop(r103) - r100.getLineTop(0);
    L11:
        return r103;
    }

    private final String getLastLineText() {
        Layout r100 = this.f377769e.f378322c.getLayout();
        if (r100 != null) goto L5;
        return "";
    L5:
        int r101 = r100.getLineCount() - 1;
    L6:
        if (r101 < 0) goto L11;
        String r102 = this.f377769e.f378322c.getText().subSequence(r100.getLineStart(r101), r100.getLineEnd(r101)).toString();
        if (StringsKt.isBlank(r102) == false) goto L10;
        r101 = r101 - 1;
        goto L6
    L10:
        return r102;
    L11:
        return "";
    }

    public final void V5() {
        ViewPropertyAnimator r100 = this.f377770f;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f377770f = null;
    }

    public final void Y5() {
        ObjectAnimator r100 = this.f377771g;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f377771g = null;
        this.f377769e.f378323d.setVisibility(8);
    }

    public final void Z5() {
        com.larus.voicecall.impl.subtitle.c r100 = this.f377766b;
        if (r100 != null) goto L5;
        return;
    L5:
        Long r101 = T5(r100);
        if (r101 == null) goto L8;
        long r102 = U5(r100) + (System.currentTimeMillis() - r101.longValue());
        r100.f378864k.put("pause_duration", Long.valueOf(r102));
    L9:
        r100.f378864k.put("pause_start_time", null);
        if (r102 <= 0) goto L12;
        Pair r103 = TuplesKt.to(this.f377766b, Integer.valueOf(this.f377765a));
        this.f377766b = null;
        this.f377765a = -1;
        i6(r100, ((Number) r103.component2()).intValue(), false, "resume");
    L12:
        int r104 = c68.b.f22600a;
        c68.b.d("VideoSubtitleView", "resumeSubtitle, pausedDuration:" + r102);
        return;
    L8:
        r102 = 0;
        goto L9
    }

    private final int getCurrentBottomLineIndex() {
        int r100 = getCurrentTopLineIndex();
        if (r100 >= 0) goto L5;
        return r100;
    L5:
        Layout r101 = this.f377769e.f378322c.getLayout();
        int r102 = 0;
        if (r101 != null) goto L8;
        return 0;
    L8:
        int r103 = r101.getLineTop(r100);
        int r104 = (this.f377769e.f378321b.getHeight() - this.f377769e.f378321b.getPaddingTop()) - this.f377769e.f378321b.getPaddingBottom();
        int r105 = 0;
    L9:
        if (r102 >= r104) goto L14;
        if ((r100 + r105) >= r101.getLineCount()) goto L14;
        r105 = r105 + 1;
        r102 = r101.getLineBottom((r100 + r105) - 1) - r103;
    L14:
        return (r100 + r105) - 1;
    }

    public VideoSubtitleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static Long T5(com.larus.voicecall.impl.subtitle.c r100) {
        Object r101 = ((LinkedHashMap) r100.f378864k).get("pause_start_time");
        if ((r101 instanceof Long) == true) goto L7;
        return null;
    L7:
        return (Long) r101;
    }

    public static long U5(com.larus.voicecall.impl.subtitle.c r100) {
        Object r101 = ((LinkedHashMap) r100.f378864k).get("pause_duration");
        if ((r101 instanceof Long) == false) goto L5;
        Long r102 = (Long) r101;
    L6:
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.longValue();
    L5:
        r102 = null;
        goto L6
    }

    public final void R5(String r210) {
        if (this.f377770f == null) goto L6;
        return;
    L6:
        if (getVisibility() == 0) goto L8;
        return;
    L8:
        Layout r100 = this.f377769e.f378322c.getLayout();
        if (r100 != null) goto L11;
        return;
    L11:
        int r101 = getCurrentTopLineIndex();
        int r102 = getCurrentBottomLineIndex();
        int r103 = r100.getLineCount();
        int r104 = r103 - 1;
        if (r102 < r104) goto L14;
        int r105 = c68.b.f22600a;
        c68.b.d("VideoSubtitleView", "moveToNextLine, topLineIndex: " + r101 + ", bottomLine: " + r102 + ", already scroll to last line or no need to scroll, return");
        int r106 = 0;
    L22:
        if (r106 != 0) goto L25;
        c68.b.d("VideoSubtitleView", "checkToScrollNextLine: " + r210 + ", bottomLine: " + r102 + ", no next line, return");
        return;
    L25:
        Layout r107 = this.f377769e.f378322c.getLayout();
        if (r107 != null) goto L28;
        int r108 = 0;
    L29:
        AppCompatTextView r109 = this.f377769e.f378322c;
        if (r109.getTranslationY() != 0.0f) goto L32;
        boolean r110 = true;
    L33:
        if (r110 == true) goto L35;
        int r111 = r106;
        String r112 = "checkToScrollNextLine: ";
        int r113 = r100.getLineStart(r102);
        CharSequence r114 = StringsKt.trim(r109.getText().subSequence(r113, r100.getLineEnd(r102)));
        if ((true ^ StringsKt.isBlank(r114)) == false) goto L47;
        String r115 = r114.toString();
    L48:
        int r116 = StringsKt.trim(r115).toString().length();
        long r117 = (long) (((double) (r116 * 1000)) / 4.5d);
        c68.b.d("VideoSubtitleView", "calcDuration: lineText: " + r115 + ", readableLen: " + r116 + ", duration: " + r117);
        int r118 = r111;
        if (this.f377772h != 0) goto L51;
        long r119 = 0;
    L52:
        c68.b.d("VideoSubtitleView", "calcStayDuration, firstScroll: " + r110 + ", stayText: " + r115 + ", stayDuration: " + r117 + ", alreadyStayDuration: " + r119);
        long r120 = Math.max(0, r117 - r119);
        c68.b.d("VideoSubtitleView", r112 + r210 + ", bottomLineIndex: " + r102 + ", nextLineIndex: " + (r102 + r118) + ", offsetTranslation: " + r108 + ", stayDuration: " + r120);
        ViewPropertyAnimator r121 = S5(r108, r120);
        r121.start();
        this.f377770f = r121;
        return;
    L51:
        r119 = System.currentTimeMillis() - this.f377772h;
        goto L52
    L47:
        int r122 = r100.getLineStart(r102 - 1);
        r115 = r109.getText().subSequence(r122, (r113 + r122) / 2).toString();
        goto L48
    L35:
        if (this.f377768d.length() <= 0) goto L37;
        boolean r123 = true;
    L38:
        if (r123 == false) goto L40;
        r115 = "";
    L42:
        r111 = r106;
        r112 = "checkToScrollNextLine: ";
        goto L48
    L40:
        if (r102 != 0) goto L43;
        r115 = r109.getText().subSequence(0, r100.getLineEnd(r102)).toString();
        goto L42
    L43:
        r111 = r106;
        r112 = "checkToScrollNextLine: ";
        r115 = r109.getText().subSequence(0, (int) Math.max(((double) r100.getLineEnd(0)) + (((double) (r100.getLineEnd(1) - r100.getLineStart(1))) * 0.2d), ((double) r100.getLineEnd(r102)) * 0.5d)).toString();
        goto L48
    L37:
        r123 = false;
        goto L38
    L32:
        r110 = false;
        goto L33
    L28:
        r108 = r107.getLineTop(r106 + r101) - r107.getLineTop(r101);
        goto L29
    L14:
        Ref.IntRef r124 = new Ref.IntRef();
        r124.element = 1;
    L15:
        int r125 = Integer.valueOf(r124.element + r101).intValue();
        if (StringsKt.isBlank(StringsKt.trim(this.f377769e.f378322c.getText().subSequence(r100.getLineStart(r125), r100.getLineEnd(r125)))) == false) goto L20;
        if (Integer.valueOf(r124.element + r102).intValue() >= r104) goto L20;
        r124.element++;
    L20:
        int r126 = c68.b.f22600a;
        c68.b.d("VideoSubtitleView", "moveToNextLine, topLineIndex: " + r101 + ", bottomLineIndex: " + r102 + ", offsetCount: " + r124.element + ", lineCount: " + r103);
        r106 = r124.element;
        goto L22
    }

    public final long b6(String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        V5();
        Layout r100 = this.f377769e.f378322c.getLayout();
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = getCurrentTopLineIndex();
        int r102 = getCurrentBottomLineIndex();
        int r103 = r100.getLineCount() - 1;
        if (r102 < r103) goto L9;
        int r104 = c68.b.f22600a;
        c68.b.d("VideoSubtitleView", "scrollToEnd: " + r110 + ", topLineIndex: " + r101 + ", bottomLine: " + r102 + ", already scroll to last line or no need to scroll, return");
        return 0;
    L9:
        int r105 = r103 - r102;
        Layout r106 = this.f377769e.f378322c.getLayout();
        if (r106 != null) goto L12;
        int r107 = 0;
    L13:
        int r111 = c68.b.f22600a;
        c68.b.d("VideoSubtitleView", "scrollToEnd: " + r110 + ", topLineIndex: " + r101 + ", bottomLine: " + r102 + ", offsetLineCount: " + r105);
        ViewPropertyAnimator r112 = S5(r107, 0);
        r112.start();
        this.f377770f = r112;
        return 100;
    L12:
        r107 = r106.getLineTop(r105 + r101) - r106.getLineTop(r101);
        goto L13
    }

    public final void c6(boolean r100) {
        int r101 = c68.b.f22600a;
        c68.b.d("VideoSubtitleView", "showThinking, breakSubtitle: " + r100);
        if (r100 == false) goto L6;
        this.f377769e.f378322c.setText("");
        V5();
        this.f377769e.f378322c.setTranslationY(0.0f);
    L6:
        if (StringsKt.isBlank(this.f377769e.f378322c.getText()) == false) goto L8;
        this.f377769e.f378322c.setText(" ");
        long r102 = 0;
    L9:
        this.f377769e.f378323d.setVisibility(0);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.f377769e.f378323d, ViewGroup.ALPHA, new float[]{1.0f, 0.0f, 1.0f}).setDuration(1500);
        r103.setInterpolator(new LinearInterpolator());
        r103.setRepeatCount(-1);
        r103.setRepeatMode(1);
        r103.setStartDelay(r102);
        r103.start();
        this.f377771g = r103;
        return;
    L8:
        this.f377769e.f378322c.append("\n");
        r102 = b6("think");
        goto L9
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.larus.voicecall.impl.component.videosubtitle.i] */
    public VideoSubtitleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f377765a = -1;
        this.f377768d = "";
        this.f377773i = new b(this);
        this.f377774j = new i(this);
        ViewGroup.inflate(r100, R.layout.view_video_subtitle, this);
        int r102 = R.id.subtitleContainer;
        VideoSubtitleContainer r103 = (VideoSubtitleContainer) ViewBindings.findChildViewById(this, R.id.subtitleContainer);
        if (r103 == null) goto L11;
        r102 = R.id.subtitleText;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.subtitleText);
        if (r104 == null) goto L11;
        r102 = R.id.subtitleThinkingDotView;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.subtitleThinkingDotView);
        if (r105 == null) goto L11;
        this.f377769e = new ViewVideoSubtitleBinding(this, r103, r104, r105);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public final ViewPropertyAnimator S5(int r100, long r101) {
        float r102 = this.f377769e.f378322c.getTranslationY();
        float r103 = r102 - r100;
        int r104 = c68.b.f22600a;
        c68.b.d("VideoSubtitleView", "createAnimator: startTranslationY: " + r102 + ", endTranslationY: " + r103 + ", offsetY: " + r100 + ", stayDuration: " + r101);
        return this.f377769e.f378322c.animate().translationY(r103).setInterpolator(new LinearInterpolator()).setDuration(100).setStartDelay(r101).setListener(this.f377773i);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (Intrinsics.areEqual(r100, this) == false) goto L12;
        int r102 = c68.b.f22600a;
        c68.b.d("VideoSubtitleView", "onVisibilityChanged: " + r101);
        if (r101 != 0) goto L10;
        this.f377769e.f378322c.addOnLayoutChangeListener(this.f377774j);
        Pair r103 = TuplesKt.to(this.f377766b, Integer.valueOf(this.f377765a));
        this.f377766b = null;
        this.f377765a = -1;
        com.larus.voicecall.impl.subtitle.c r104 = (com.larus.voicecall.impl.subtitle.c) r103.component1();
        int r105 = ((Number) r103.component2()).intValue();
        if (r104 == null) goto L13;
        if (r105 == (-1)) goto L14;
        i6(r104, r105, false, "visible");
        return;
    L14:
        return;
    L13:
        return;
    L10:
        this.f377769e.f378322c.removeOnLayoutChangeListener(this.f377774j);
        this.f377769e.f378322c.setText("");
        V5();
        this.f377769e.f378322c.setTranslationY(0.0f);
        Y5();
        return;
    }

    public final void i6(com.larus.voicecall.impl.subtitle.c r110, int r111, boolean r210, String r211) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r211, "reason");
        DisplayType r100 = r110.f378856c;
        DisplayType r101 = DisplayType.REPLY_BLOCK;
        if (r100 != r101) goto L11;
        com.larus.voicecall.impl.subtitle.c r102 = this.f377766b;
        if (r102 == null) goto L17;
        String r103 = r102.f378857d;
        if (r103 == null) goto L17;
        String r104 = StringsKt.trim(r103).toString();
        if (r104 == null) goto L17;
    L19:
        if (r110.f378856c != r101) goto L25;
        String r105 = r110.f378857d;
        if (r105 == null) goto L24;
        String r106 = StringsKt.trim(r105).toString();
        if (r106 == null) goto L24;
    L27:
        if (r111 != this.f377765a) goto L32;
        if (Intrinsics.areEqual(r106, r104) == false) goto L32;
        return;
    L32:
        if (r111 == this.f377765a) goto L51;
        if (r210 == false) goto L51;
        if (r104.length() <= 0) goto L37;
        boolean r107 = true;
    L38:
        if (r107 == false) goto L51;
        if (U5(r110) != 0) goto L51;
        if (T5(r110) != null) goto L51;
        V5();
        this.f377769e.f378322c.setTranslationY(0.0f);
        this.f377772h = System.currentTimeMillis();
        String r108 = StringsKt.trimEnd(getLastLineText()).toString();
        this.f377768d = r108;
        if (r108.length() <= 0) goto L46;
        boolean r109 = true;
    L47:
        if (r109 == false) goto L49;
        this.f377768d += '\n';
    L49:
        this.f377767c = 0;
        CharSequence r112 = this.f377768d + r106;
    L66:
        this.f377769e.f378322c.setText(r112);
        this.f377765a = r111;
        this.f377766b = r110;
        if (r112.length() <= 0) goto L69;
        boolean r113 = true;
    L70:
        if (r113 == false) goto L73;
        Y5();
        return;
    L73:
        return;
    L69:
        r113 = false;
        goto L70
    L46:
        r109 = false;
        goto L47
    L37:
        r107 = false;
    L51:
        if (r111 == this.f377765a) goto L53;
    L57:
        V5();
        this.f377769e.f378322c.setTranslationY(0.0f);
        this.f377772h = System.currentTimeMillis();
        this.f377768d = "";
        long r114 = U5(r110);
        Long r115 = T5(r110);
        if (r115 == null) goto L60;
        long r116 = r115.longValue();
    L62:
        if (r116 <= 0) goto L64;
        long r117 = r116;
    L65:
        String r118 = r106;
        int r119 = (int) (((((r117 - r110.f378858e) - r114) - ((long) (-200))) * 4.5d) / ((double) 1000));
        this.f377767c = r119;
        this.f377767c = Math.max(0, Math.min(r119, r118.length()));
        int r120 = c68.b.f22600a;
        c68.b.d("VideoSubtitleView", "updateSubtitle: " + r211 + ", index: " + r111 + ", pausedDuration: " + r114 + ", pauseStartTime: " + r116 + ", readTs: " + r117 + ", subtitleStartOffset: " + this.f377767c + ", trimedContent: " + r118);
        r112 = r118.subSequence(this.f377767c, r118.length());
        goto L66
    L64:
        r117 = System.currentTimeMillis();
        goto L65
    L60:
        r116 = 0;
        goto L62
    L53:
        if (StringsKt.startsWith$default(r106, r104, false, 2, null) == false) goto L57;
        r112 = this.f377768d + r106.subSequence(this.f377767c, r106.length());
    L24:
        r106 = "";
        goto L27
    L25:
        r106 = StringsKt.trim(r110.f378854a).toString();
    L17:
        r104 = "";
        goto L19
    L11:
        com.larus.voicecall.impl.subtitle.c r121 = this.f377766b;
        if (r121 == null) goto L17;
        String r122 = r121.f378854a;
        if (r122 == null) goto L17;
        r104 = StringsKt.trim(r122).toString();
        if (r104 != null) goto L19;
        goto L17
    }
}
