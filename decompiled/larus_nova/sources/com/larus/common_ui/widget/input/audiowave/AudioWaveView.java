package com.larus.common_ui.widget.input.audiowave;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import b29.c;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common_ui.widget.input.audiowave.amplitude.AudioAmplitudeProcessor;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00190,J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0096@¢\u0006\u0002\u00101J\b\u00102\u001a\u00020.H\u0016J\b\u00103\u001a\u00020.H\u0016J\b\u00104\u001a\u00020&H\u0016J(\u00105\u001a\u00020.2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0014J(\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\bH\u0016J(\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010>\u001a\u00020\bH\u0016J\u0018\u0010B\u001a\u00020.2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\bH\u0014J\u0010\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020\fH\u0014J\u0010\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020GH\u0014J\b\u0010H\u001a\u00020\u0019H\u0002J\u0010\u0010I\u001a\u00020.2\u0006\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020.2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u001dR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/larus/common_ui/widget/input/audiowave/AudioWaveView;", "Landroid/view/View;", "Lcom/larus/common_ui/widget/input/audiowave/IAudioWaveView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barDrawable", "Landroid/graphics/drawable/Drawable;", "value", "barWidth", "getBarWidth", "()I", "barGap", "getBarGap", "barCountPerGroup", "getBarCountPerGroup", "maxBarHeight", "minBarHeight", "waveGroupList", "", "Lcom/larus/common_ui/widget/input/audiowave/AudioWaveGroup;", "waveGroupTotalWidth", "getWaveGroupTotalWidth", "setWaveGroupTotalWidth", "(I)V", "waveGroupTotalHeight", "getWaveGroupTotalHeight", "setWaveGroupTotalHeight", "waveAnimHelper", "Lcom/larus/common_ui/widget/input/audiowave/anim/AudioWaveAnimHelper;", "audioAmplitudeProcessor", "Lcom/larus/common_ui/widget/input/audiowave/amplitude/AudioAmplitudeProcessor;", "autoStartAnim", "", "hasAutoStarted", "barGroupCount", "barGroupCountMode", "pendingStartAnim", "getAudioWaveGroupList", "", "updateAudioData", "", "audioData", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWaveAnim", "stopWaveAnim", "isAnimating", "onSizeChanged", "w", "h", "oldw", "oldh", "setPadding", "left", "top", "right", "bottom", "setPaddingRelative", "start", "end", "updateBars", "verifyDrawable", "who", "onDraw", "canvas", "Landroid/graphics/Canvas;", "createWaveGroup", "setWaveTintList", "tint", "Landroid/content/res/ColorStateList;", "setWaveTintMode", "mode", "Landroid/graphics/PorterDuff$Mode;", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AudioWaveView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f328690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f328691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f328692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f328693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f328694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f328695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<AudioWaveGroup> f328696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f328697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f328698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b29.a f328699j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AudioAmplitudeProcessor f328700k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f328701l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f328702m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f328703n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f328704o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f328705p;

    public static final class a {
    }

    static {
    }

    public AudioWaveView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AudioWaveView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void b() {
        this.f328705p = false;
        b29.a r100 = this.f328699j;
        r100.f17095d = 1;
        AnimatorSet r101 = r100.f17093b;
        if (r101 == null) goto L5;
        r101.end();
    L5:
        r100.f17093b = null;
        c r102 = r100.f17094c;
        r102.getClass();
        r102.f17099a = CollectionsKt.emptyList();
        r102.f17101c = 0;
        r102.f17102d = -1;
        this.f328700k.f328708c.clear();
    }

    public final void a() {
        AnimatorSet r100 = this.f328699j.f17093b;
        if (r100 == null) goto L5;
        boolean r101 = r100.isRunning();
    L6:
        if (r101 == true) goto L20;
        if (this.f328705p == true) goto L20;
        if (getWidth() != 0) goto L13;
    L17:
        this.f328705p = true;
        return;
    L13:
        if (getHeight() == 0) goto L17;
        this.f328699j.a(new AudioWaveView$startWaveAnim$1(this.f328700k));
        return;
    L20:
        if (isInEditMode() == true) goto L23;
        FLogger.f375446a.v("AudioWaveView", "[startWaveAnim][ALREADY_START]");
        return;
    L23:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final List<AudioWaveGroup> getAudioWaveGroupList() {
        return this.f328696g;
    }

    public final int getBarCountPerGroup() {
        return this.f328693d;
    }

    public final int getBarGap() {
        return this.f328692c;
    }

    public final int getBarWidth() {
        return this.f328691b;
    }

    public final int getWaveGroupTotalHeight() {
        return this.f328698i;
    }

    public final int getWaveGroupTotalWidth() {
        return this.f328697h;
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        int r101 = (getWidth() - this.f328697h) / 2;
        int r102 = (getHeight() - this.f328698i) / 2;
        Iterator<T> r103 = this.f328696g.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        AudioWaveGroup r104 = (AudioWaveGroup) r103.next();
        int r105 = r104.getIntrinsicWidth() + r101;
        r104.setBounds(r101, r102, r105, r104.getIntrinsicHeight() + r102);
        r104.draw(r100);
        r101 = this.f328692c + r105;
        goto L4
    }

    public final void setWaveGroupTotalHeight(int r100) {
        this.f328698i = r100;
    }

    public final void setWaveGroupTotalWidth(int r100) {
        this.f328697h = r100;
    }

    public void setWaveTintList(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "tint");
        this.f328690a.setTintList(r100);
        invalidate();
        if (isInEditMode() == true) goto L6;
        FLogger.f375446a.i("AudioWaveView", "tint: " + r100);
        return;
    }

    public void setWaveTintMode(PorterDuff.Mode r100) {
        this.f328690a.setTintMode(r100);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (super.verifyDrawable(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (CollectionsKt.contains(this.f328696g, r100) == true) goto L8;
        return false;
    }

    public void c(int r110, int r111) {
        AnimatorSet r100 = this.f328699j.f17093b;
        if (r100 == null) goto L5;
        boolean r101 = r100.isRunning();
    L7:
        if (r101 == false) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L15;
        b();
    L15:
        int r103 = (r110 - getPaddingLeft()) - getPaddingRight();
        ArrayList r104 = new ArrayList();
        Ref.IntRef r105 = new Ref.IntRef();
        int r106 = 0;
    L17:
        if (r105.element <= r103) goto L20;
    L23:
        boolean r107 = false;
    L26:
        if (Boolean.valueOf(r107).booleanValue() == false) goto L40;
        if (((ArrayList) this.f328696g).size() <= 0) goto L30;
        AudioWaveGroup r108 = (AudioWaveGroup) ListProtector.remove(this.f328696g, 0);
    L31:
        r108.b();
        r108.setCallback(this);
        int r109 = r105.element;
        if (r109 != 0) goto L34;
        int r112 = r108.getIntrinsicWidth();
    L35:
        int r113 = r109 + r112;
        int r114 = Math.max(r106, r108.getIntrinsicHeight());
        if (this.f328704o != 0) goto L39;
        if (r113 > r103) goto L40;
    L39:
        r104.add(r108);
        r105.element = r113;
        r106 = r114;
        goto L17
    L34:
        r112 = this.f328692c + r108.getIntrinsicWidth();
        goto L35
    L30:
        r108 = new AudioWaveGroup(this.f328690a, this.f328693d, this.f328691b, this.f328692c, new Rect(0, 0, 0, 0), this.f328694e, this.f328695f);
    L40:
        ((ArrayList) this.f328696g).clear();
        ((ArrayList) this.f328696g).addAll(r104);
        this.f328697h = r105.element;
        this.f328698i = r106;
        if (r102 == false) goto L43;
    L48:
        this.f328702m = true;
        this.f328705p = false;
        this.f328699j.a(new AudioWaveView$updateBars$1(this.f328700k));
        return;
    L43:
        if (this.f328701l == false) goto L47;
        if (this.f328702m == false) goto L48;
    L47:
        if (this.f328705p == true) goto L48;
        return;
    L20:
        if (this.f328703n != 0) goto L22;
    L24:
        r107 = true;
        goto L26
    L22:
        if (r104.size() != this.f328703n) goto L24;
    L9:
        if (this.f328705p == true) goto L12;
        r102 = false;
        goto L13
    L5:
        r101 = false;
        goto L7
    }

    public AudioWaveView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328696g = new ArrayList();
        this.f328699j = new b29.a(this);
        this.f328700k = new AudioAmplitudeProcessor(0, 3);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_autoStartAnim, R.attr.larus_barColor, R.attr.larus_barCountPerGroup, R.attr.larus_barDrawable, R.attr.larus_barGap, R.attr.larus_barGroupCount, R.attr.larus_barGroupCountMode, R.attr.larus_barWidth, R.attr.larus_maxBarHeight, R.attr.larus_minBarHeight});
        Drawable r104 = r103.getDrawable(3);
        if (r104 == null) goto L10;
        this.f328690a = r104;
        this.f328691b = r103.getDimensionPixelSize(7, 0);
        this.f328692c = r103.getDimensionPixelSize(4, 0);
        this.f328693d = r103.getInt(2, 0);
        this.f328694e = r103.getDimensionPixelSize(8, 0);
        this.f328695f = r103.getDimensionPixelSize(9, 0);
        this.f328701l = r103.getBoolean(0, this.f328701l);
        this.f328703n = r103.getInt(5, 0);
        this.f328704o = r103.getInt(6, 0);
        if (r103.hasValue(1) == false) goto L7;
        r104.setTintList(ColorStateList.valueOf(r103.getColor(1, -1)));
    L7:
        r103.recycle();
        return;
    L10:
        throw new IllegalArgumentException("barDrawable is null");
    }

    public /* synthetic */ AudioWaveView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        c(r100, r101);
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        super.setPadding(r100, r101, r102, r103);
        c(getWidth(), getHeight());
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r100, int r101, int r102, int r103) {
        super.setPaddingRelative(r100, r101, r102, r103);
        c(getWidth(), getHeight());
    }
}
