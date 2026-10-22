package com.ss.android.lark.flow.chat.message.block.audio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\t\b\u0007\u0018\u0000 [2\u00020\u0001:\u0003YZ[B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010 J\u0010\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010\u0016J\u000e\u0010)\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010*\u001a\u00020%J\u0006\u0010+\u001a\u00020%J\u0006\u0010,\u001a\u00020%J\u000e\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u0007J\u000e\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u0007J\u000e\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020\u0007J\u000e\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020\u0007J\u000e\u00107\u001a\u00020%2\u0006\u00106\u001a\u00020\u0007J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0010\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020<H\u0014J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u0018H\u0002J@\u0010B\u001a\u00020%2\u0006\u0010;\u001a\u00020<2\u0006\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u000bH\u0002J\u0018\u0010I\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u0007H\u0002J\u0010\u0010K\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u0018H\u0002J\u0010\u0010M\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0018H\u0002J \u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u00182\u0006\u0010P\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u0018H\u0002J\u0018\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0018H\u0002J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0016H\u0002J\u0018\u0010W\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioWaveView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "wavePaint", "Landroid/graphics/Paint;", "playedPaint", "drawRect", "Landroid/graphics/RectF;", "unPlayedColor", "playedColor", "barWidthPx", "barSpacingPx", "minBarHeightPx", "cornerRadiusPx", "waveformBytes", "", "progress", "", "lastMonotonicProgress", Keys.API_EVENT_KEY_PLAY_STATE, "Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioWaveView$PlayState;", "isDraggingInternal", "", "dragProgress", "dragListener", "Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioWaveView$OnProgressDragListener;", "initialTouchX", "initialTouchY", "touchSlop", "setOnProgressDragListener", "", "listener", "setWaveformBytes", HTTP.CONTENT_RANGE_BYTES, "setProgress", "setPlaying", "setPaused", "setStopped", "setBarWidthPx", "widthPx", "setBarSpacingPx", "spacingPx", "setMinBarHeightPx", "minHeightPx", "setCornerRadiusPx", "radiusPx", "setUnPlayedColor", "color", "setPlayedColor", "setEnabled", "enabled", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "calcProgressByX", "x", "drawRoundRect", "left", "top", "right", "bottom", "radius", "paint", "decode5BitsValue", "index", "dpToPx", "dp", "dpToPxInt", "computeBarCount", "contentWidth", "barWidth", "barSpacing", "buildBarHalfHeightsPx", "", "barCount", "contentHeight", "stableSeedFromBytes", "stableNoise", "seed", "OnProgressDragListener", "PlayState", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowAudioWaveView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f422381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f422382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f422383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f422384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f422385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f422386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f422387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f422388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f422389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f422390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f422391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f422392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PlayState f422393m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f422394n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f422395o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f422396p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f422397q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f422398r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f422399s;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioWaveView$PlayState;", "", "<init>", "(Ljava/lang/String;I)V", "PLAYING", "PAUSED", "STOPPED", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PlayState extends Enum<PlayState> {
        public static final PlayState PAUSED = null;
        public static final PlayState PLAYING = null;
        public static final PlayState STOPPED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PlayState[] f422400a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f422401b = null;

        public static EnumEntries<PlayState> getEntries() {
            return f422401b;
        }

        static {
            PlayState r100 = new PlayState("PLAYING", 0);
            PLAYING = r100;
            PlayState r101 = new PlayState("PAUSED", 1);
            PAUSED = r101;
            PlayState r102 = new PlayState("STOPPED", 2);
            STOPPED = r102;
            PlayState[] r103 = {r100, r101, r102};
            f422400a = r103;
            f422401b = EnumEntriesKt.enumEntries(r103);
        }

        public static PlayState[] values() {
            return (PlayState[]) f422400a.clone();
        }

        public static PlayState valueOf(String r100) {
            return (PlayState) r27.a.a(PlayState.class, r100);
        }

        public PlayState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(FlowAudioWaveView r100, float r101);

        void c(FlowAudioWaveView r100, float r101);

        void d(FlowAudioWaveView r100, float r101);
    }

    static {
    }

    public FlowAudioWaveView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FlowAudioWaveView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final float a(float r100) {
        float r101 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (r101 > 0.0f) goto L6;
        return 0.0f;
    L6:
        return RangesKt.coerceIn((RangesKt.coerceIn(r100, getPaddingLeft(), getWidth() - getPaddingRight()) - getPaddingLeft()) / r101, 0.0f, 1.0f);
    }

    public final float b(float r100) {
        Resources r101 = getResources();
        return TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        float r100 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float r101 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        if (r101 <= 0.0f) goto L160;
        byte[] r102 = this.f422390j;
        int r103 = 1;
        if (r102.length != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        return;
    L13:
        float r105 = this.f422386f;
        float r106 = this.f422387g + r105;
        if (r106 > 0.0f) goto L16;
        return;
    L16:
        if (r106 > 0.0f) goto L18;
    L21:
        int r110 = 0;
    L22:
        if (r110 > 0) goto L24;
        return;
    L24:
        int r107 = (r102.length * 8) / 5;
        if (r107 <= 0) goto L107;
        if (r110 <= 0) goto L107;
        float[] r111 = new float[r107];
        int r112 = 0;
    L29:
        if (r112 >= r107) goto L40;
        byte[] r113 = this.f422390j;
        int r114 = r112 * 5;
        int r108 = r114 / 8;
        int r115 = r114 - (r108 * 8);
        int r116 = 8 - r115;
        int r211 = 5 - r116;
        Byte r212 = ArraysKt.getOrNull(r113, r108);
        if (r212 == null) goto L33;
        int r109 = r212.byteValue() & UByte.MAX_VALUE;
    L34:
        int r117 = (r109 >> r115) & ((1 << Math.min(5, r116)) - 1);
        if (r211 <= 0) goto L39;
        int r118 = r108 + 1;
        if (r118 >= r113.length) goto L39;
        r117 = (r117 << r211) | ((r113[r118] & UByte.MAX_VALUE) & ((1 << r211) - 1));
    L39:
        r111[r112] = r117;
        r112 = r112 + 1;
        goto L29
    L33:
        r109 = 0;
        goto L34
    L40:
        float[] r119 = new float[r110];
        if (r107 <= r110) goto L55;
        int r120 = 0;
    L43:
        if (r120 >= r110) goto L54;
        int r121 = (r120 * r107) / r110;
        int r122 = r120 + 1;
        int r123 = (r122 * r107) / r110;
        if (r123 > r121) goto L47;
        r123 = RangesKt.coerceAtMost(r121 + 1, r107);
    L47:
        int r124 = RangesKt.coerceAtLeast(r123 - r121, r103);
        float r125 = 0.0f;
        float r213 = 0.0f;
    L48:
        if (r121 >= r123) goto L53;
        float r214 = r111[r121];
        if (r214 <= r213) goto L52;
        r213 = r214;
    L52:
        r125 = r125 + (r214 * r214);
        r121 = r121 + 1;
        goto L48
    L53:
        r119[r120] = (((float) Math.sqrt(r125 / r124)) * 0.7f) + (r213 * 0.3f);
        r120 = r122;
        r106 = r106;
        r103 = 1;
        goto L43
    L54:
        float r126 = r106;
    L66:
        float r127 = r119[0];
        float r128 = r127;
        int r129 = 1;
    L67:
        if (r129 >= r110) goto L75;
        float r130 = r119[r129];
        if (r130 >= r128) goto L72;
        r128 = r130;
    L72:
        if (r130 <= r127) goto L74;
        r127 = r130;
    L74:
        r129 = r129 + 1;
        goto L67
    L75:
        float[] r131 = new float[r110];
        float r132 = r127 - r128;
        if (r132 >= 0.001f) goto L83;
        byte[] r133 = this.f422390j;
        int r134 = r133.length;
        int r135 = 0;
        int r136 = 1;
    L78:
        if (r135 >= r134) goto L80;
        r136 = (r136 * 31) + (r133[r135] & UByte.MAX_VALUE);
        r135 = r135 + 1;
        goto L78
    L80:
        int r137 = 0;
    L81:
        if (r137 >= r110) goto L86;
        int r138 = ((-1640531527) * r137) ^ r136;
        int r139 = (r138 ^ (r138 >>> 16)) * 2146121005;
        int r140 = (r139 ^ (r139 >>> 15)) * (-2073254261);
        r131[r137] = RangesKt.coerceIn(((((((r140 ^ (r140 >>> 16)) >>> 8) & 65535) / 65535.0f) - 0.5f) * 0.05f) + 0.5f, 0.0f, 1.0f);
        r137 = r137 + 1;
    L86:
        float[] r141 = new float[r110];
        int r142 = 0;
    L87:
        if (r142 >= r110) goto L89;
        r141[r142] = (float) Math.pow(r131[r142], 0.8f);
        r142 = r142 + 1;
        goto L87
    L89:
        float r143 = RangesKt.coerceAtMost(Math.max(this.f422388h, b(4.0f)), r101);
        float r144 = RangesKt.coerceAtLeast(Math.min(b(20.0f), r101), r143);
        float[] r145 = new float[r110];
        int r146 = 0;
    L90:
        if (r146 >= r110) goto L92;
        r145[r146] = RangesKt.coerceIn((r141[r146] * (r144 - r143)) + r143, r143, r144);
        r146 = r146 + 1;
        goto L90
    L92:
        float[] r147 = new float[r110];
        int r148 = 0;
    L93:
        if (r148 >= r110) goto L103;
        Float r149 = ArraysKt.getOrNull(r145, r148 - 1);
        if (r149 == null) goto L97;
        float r150 = r149.floatValue();
    L98:
        int r151 = r148 + 1;
        Float r152 = ArraysKt.getOrNull(r145, r151);
        if (r152 == null) goto L101;
        float r153 = r152.floatValue();
    L102:
        r147[r148] = RangesKt.coerceIn(((r150 * 0.2f) + (r145[r148] * 0.6f)) + (r153 * 0.2f), r143, r144);
        r148 = r151;
        goto L93
    L101:
        r153 = r145[r148];
        goto L102
    L97:
        r150 = r145[r148];
        goto L98
    L103:
        float r154 = 2.0f;
        float r155 = r143 / 2.0f;
        float r156 = RangesKt.coerceAtMost(r144 / 2.0f, r101 / 2.0f);
        float[] r157 = new float[r110];
        int r158 = 0;
    L104:
        if (r158 >= r110) goto L108;
        r157[r158] = RangesKt.coerceIn(r147[r158] / r154, r155, r156);
        r158 = r158 + 1;
        r154 = 2.0f;
    L108:
        this.f422381a.setColor(this.f422384d);
        this.f422382b.setColor(this.f422385e);
        float r159 = r101 / 2.0f;
        float r160 = getPaddingTop() + r159;
        float r161 = this.f422388h / 2.0f;
        if (this.f422394n == false) goto L112;
        float r162 = this.f422395o;
    L114:
        float r163 = 0.0f;
        float r164 = getPaddingLeft() + (RangesKt.coerceIn(r162, 0.0f, 1.0f) * r100);
        if (this.f422394n == true) goto L120;
        r163 = r105 / 2.0f;
    L120:
        int r165 = 0;
    L121:
        if (r165 >= r110) goto L161;
        float r166 = getPaddingLeft() + (r165 * r126);
        float r167 = r166 + r105;
        if (r167 > (getPaddingLeft() + r100)) goto L162;
        Float r168 = ArraysKt.getOrNull(r157, r165);
        if (r168 == null) goto L127;
        float r169 = r168.floatValue();
    L128:
        float r170 = RangesKt.coerceIn(r169, r161, r159);
        float r171 = r100;
        float r172 = r159;
        float r173 = Math.min(this.f422389i, Math.min(r105 / 2.0f, r170));
        float r174 = r160 - r170;
        float r175 = r170 + r160;
        if ((r166 + r163) < r164) goto L131;
        Paint r176 = this.f422381a;
        this.f422383c.set(r166, r174, r167, r175);
        r210.drawRoundRect(this.f422383c, r173, r173, r176);
    L132:
        r165 = r165 + 1;
        r100 = r171;
        r159 = r172;
        r160 = r160;
        r105 = r105;
        goto L121
    L131:
        Paint r177 = this.f422382b;
        this.f422383c.set(r166, r174, r167, r175);
        r210.drawRoundRect(this.f422383c, r173, r173, r177);
        goto L132
    L127:
        r169 = r161;
        goto L128
    L162:
        return;
    L161:
        return;
    L112:
        if (this.f422393m != PlayState.STOPPED) goto L115;
        r162 = 1.0f;
        goto L114
    L115:
        r162 = this.f422391k;
        goto L114
    L83:
        float r178 = 1.0f;
        float r179 = 0.0f;
        int r180 = 0;
    L84:
        if (r180 >= r110) goto L86;
        r131[r180] = RangesKt.coerceIn((r119[r180] - r128) / r132, r179, r178);
        r180 = r180 + 1;
        r178 = 1.0f;
        r179 = 0.0f;
        goto L84
    L55:
        r126 = r106;
        if (r107 < r110) goto L58;
        int r181 = 0;
    L64:
        if (r181 >= r110) goto L66;
        r119[r181] = r111[r181];
        r181 = r181 + 1;
        goto L64
    L58:
        if (r110 != 1) goto L60;
        r119[0] = r111[0];
        goto L66
    L60:
        int r182 = 0;
        int r183 = RangesKt.coerceAtLeast(r107 - 1, 0);
        int r184 = 0;
    L61:
        if (r184 >= r110) goto L66;
        float r185 = (r184 * r183) / (r110 - 1);
        int r186 = RangesKt.coerceIn((int) r185, r182, r183);
        int r187 = RangesKt.coerceIn(r186 + 1, r182, r183);
        float r188 = RangesKt.coerceIn(r185 - r186, 0.0f, 1.0f);
        r119[r184] = (r111[r186] * (1.0f - r188)) + (r111[r187] * r188);
        r184 = r184 + 1;
        r182 = 0;
    L107:
        r126 = r106;
        r157 = new float[0];
        goto L108
    L18:
        if (r100 < r105) goto L21;
        r110 = ((int) ((r100 - r105) / r106)) + 1;
        goto L22
    L10:
        r104 = false;
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = false;
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        int r102 = r100.getActionMasked();
        if (r102 != 0) goto L8;
        super.onTouchEvent(r100);
        this.f422397q = r100.getX();
        this.f422398r = r100.getY();
        this.f422394n = false;
        return true;
    L8:
        if (r102 == 1) goto L40;
        if (r102 == 2) goto L14;
        if (r102 == 3) goto L40;
        return super.onTouchEvent(r100);
    L14:
        super.onTouchEvent(r100);
        if (this.f422394n == true) goto L30;
        float r103 = Math.abs(r100.getX() - this.f422397q);
        float r104 = Math.abs(r100.getY() - this.f422398r);
        int r105 = this.f422399s;
        if (r103 <= r105) goto L19;
    L20:
        this.f422394n = true;
        ViewParent r106 = getParent();
        if (r106 == null) goto L23;
        r106.requestDisallowInterceptTouchEvent(true);
    L23:
        cancelLongPress();
        float r107 = a(r100.getX());
        this.f422395o = r107;
        b r108 = this.f422396p;
        if (r108 == null) goto L26;
        r108.a(this, r107);
    L26:
        b r109 = this.f422396p;
        if (r109 == null) goto L29;
        r109.c(this, r107);
    L29:
        invalidate();
    L38:
        return true;
    L19:
        if (r104 <= r105) goto L38;
    L30:
        float r110 = a(r100.getX());
        if (r110 != this.f422395o) goto L33;
        r101 = true;
    L33:
        if (r101 == true) goto L38;
        this.f422395o = r110;
        b r111 = this.f422396p;
        if (r111 == null) goto L37;
        r111.c(this, r110);
    L37:
        invalidate();
    L40:
        if (this.f422394n == false) goto L48;
        r100.setAction(3);
        super.onTouchEvent(r100);
        float r112 = a(r100.getX());
        this.f422395o = r112;
        b r113 = this.f422396p;
        if (r113 == null) goto L44;
        r113.d(this, r112);
    L44:
        this.f422394n = false;
        this.f422391k = r112;
        this.f422392l = r112;
        ViewParent r114 = getParent();
        if (r114 == null) goto L47;
        r114.requestDisallowInterceptTouchEvent(false);
    L47:
        invalidate();
    L49:
        return true;
    L48:
        super.onTouchEvent(r100);
        goto L49
    }

    public final void setBarSpacingPx(int r100) {
        this.f422387g = RangesKt.coerceAtLeast(r100, 0);
        invalidate();
    }

    public final void setBarWidthPx(int r100) {
        this.f422386f = RangesKt.coerceAtLeast(r100, 0);
        invalidate();
    }

    public final void setCornerRadiusPx(int r100) {
        this.f422389i = RangesKt.coerceAtLeast(r100, 0);
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == false) goto L5;
        return;
    L5:
        if (this.f422394n == false) goto L9;
        this.f422394n = false;
        invalidate();
        return;
    }

    public final void setMinBarHeightPx(int r100) {
        this.f422388h = RangesKt.coerceAtLeast(r100, 0);
        invalidate();
    }

    public final void setOnProgressDragListener(b r100) {
        this.f422396p = r100;
    }

    public final void setPlayedColor(int r100) {
        this.f422385e = r100;
        invalidate();
    }

    public final void setProgress(float r100) {
        float r101 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        if (this.f422393m == PlayState.PLAYING) goto L5;
    L7:
        this.f422391k = r101;
        invalidate();
        return;
    L5:
        if (this.f422394n == true) goto L7;
        r101 = Math.max(r101, this.f422392l);
        this.f422392l = r101;
        goto L7
    }

    public final void setUnPlayedColor(int r100) {
        this.f422384d = r100;
        invalidate();
    }

    public final void setWaveformBytes(byte[] r100) {
        if (r100 != null) goto L4;
    L8:
        r100 = new byte[64];
    L9:
        this.f422390j = r100;
        invalidate();
        return;
    L4:
        if (r100.length != 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
    L6:
        r101 = false;
        goto L7
    }

    public FlowAudioWaveView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.FILL);
        this.f422381a = r103;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.FILL);
        this.f422382b = r104;
        this.f422383c = new RectF();
        this.f422384d = Color.argb(51, 255, 255, 255);
        this.f422385e = Color.rgb(255, 255, 255);
        this.f422386f = MathKt.roundToInt(b(2.5f));
        this.f422387g = MathKt.roundToInt(b(2.0f));
        this.f422388h = MathKt.roundToInt(b(4.0f));
        this.f422389i = MathKt.roundToInt(b(2.0f));
        this.f422390j = new byte[64];
        this.f422393m = PlayState.STOPPED;
        setClickable(false);
        this.f422399s = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public /* synthetic */ FlowAudioWaveView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
