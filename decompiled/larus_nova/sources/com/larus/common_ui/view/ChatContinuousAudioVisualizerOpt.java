package com.larus.common_ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.larus.utils.l0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0002RSB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0012\u0010(\u001a\u00020)2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J(\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0014J\u001a\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u000202H\u0002J\u0018\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u000bH\u0014J\u0006\u00106\u001a\u00020)J\u0010\u00107\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0014J\u0010\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\u000fH\u0002J\u0018\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020\u001b2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010>\u001a\u00020)2\u0006\u00105\u001a\u00020\u000bH\u0016J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\u000bH\u0016J\u0010\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u000202H\u0016J\u0018\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u000202H\u0016J\u0010\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020\u000bH\u0016J\u0010\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u00020)2\u0006\u0010O\u001a\u00020\u000fH\u0002J\b\u0010P\u001a\u00020\u000fH\u0002J\u0006\u0010Q\u001a\u00020)R\u000e\u0010\r\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%¨\u0006T"}, d2 = {"Lcom/larus/common_ui/view/ChatContinuousAudioVisualizerOpt;", "Landroid/view/View;", "Lcom/larus/common_ui/view/IAudioVisualizer;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "barWidth", "", "gapWidth", "sideMargin", "minBarHeight", "maxBarHeight", "barCountInGroup", "topGroupCount", "visualizerWidth", "waveGroupNumber", "amplitude", "Ljava/util/LinkedList;", "lastTime", "", "barParams", "", "Lcom/larus/common_ui/view/ChatContinuousAudioVisualizerOpt$BarParam;", "barCount", "paint", "Landroid/graphics/Paint;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "getLifecycleScope", "()Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope$delegate", "Lkotlin/Lazy;", "init", "", "onSizeChanged", "w", "h", "oldw", "oldh", "ensureCapacity", "capacity", "force", "", "onVisibilityChanged", "changedView", RemoteMessageConst.Notification.VISIBILITY, "resetData", "onDraw", "canvas", "Landroid/graphics/Canvas;", "genBarData", "currAmp", "drawBars", "stage", "changeVisibility", "setColor", "color", "setAudioData", "data", "", "switchPostInvalidateDelayed", "enable", "setMultipleFactor", "multipleFactor", "needOpt", "setFps", "fps", "optAmplitude", "before", "", "setAmplitude", "value", "getAmplitude", "clearData", "BarParam", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatContinuousAudioVisualizerOpt extends View implements u {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f328151q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f328152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f328153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f328154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f328155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f328156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f328157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f328158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f328159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f328160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f328161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedList<Float> f328162k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f328163l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<Integer, a> f328164m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f328165n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f328166o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f328167p;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f328168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f328169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f328170c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f328171d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f328172e;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f328168a == r101.f328168a) goto L12;
            return false;
        L12:
            if (this.f328169b == r101.f328169b) goto L15;
            return false;
        L15:
            if (Float.compare(this.f328170c, r101.f328170c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f328171d, r101.f328171d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.f328172e, r101.f328172e) == 0) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f328168a * 31) + this.f328169b) * 31) + Float.floatToIntBits(this.f328170c)) * 31) + Float.floatToIntBits(this.f328171d)) * 31) + Float.floatToIntBits(this.f328172e);
        }

        public final String toString() {
            return "BarParam(barType=" + this.f328168a + ", groupType=" + this.f328169b + ", barHeight=" + this.f328170c + ", curBarHeight=" + this.f328171d + ", change=" + this.f328172e + ')';
        }

        public a(int r100) {
            this.f328168a = 2;
            this.f328169b = 2;
            this.f328170c = 0.0f;
            this.f328171d = 0.0f;
            this.f328172e = 0.0f;
        }
    }

    public static final class b {
    }

    /* JADX INFO: renamed from: com.larus.common_ui.view.ChatContinuousAudioVisualizerOpt$setAudioData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common_ui.view.ChatContinuousAudioVisualizerOpt$setAudioData$1", f = "ChatContinuousAudioVisualizerOpt.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $data;
        int label;
        final /* synthetic */ ChatContinuousAudioVisualizerOpt this$0;

        public AnonymousClass1(byte[] r100, ChatContinuousAudioVisualizerOpt r101, Continuation<? super AnonymousClass1> r102) {
            this.$data = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$data, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            Iterator r103 = ((ArrayList) r100).iterator();
            if (r103.hasNext() == true) goto L14;
            Double r104 = null;
        L19:
            if (r104 == null) goto L21;
            double r105 = r104.doubleValue();
        L22:
            ChatContinuousAudioVisualizerOpt r106 = this.this$0;
            int r107 = ChatContinuousAudioVisualizerOpt.f328151q;
            r106.getClass();
            if (r105 <= 0.5d) goto L25;
            double r108 = 1.0d;
        L26:
            ChatContinuousAudioVisualizerOpt.e(r106, RangesKt.coerceAtMost(((float) r108) * 2.5f, 1.0f));
            return Unit.INSTANCE;
        L25:
            r108 = Math.sin(r105 * 3.141592653589793d);
            goto L26
        L21:
            r105 = AudioStats.AUDIO_AMPLITUDE_NONE;
            goto L22
        L14:
            double r109 = Math.abs(((Number) r103.next()).doubleValue());
        L16:
            if (r103.hasNext() == false) goto L18;
            r109 = Math.max(r109, Math.abs(((Number) r103.next()).doubleValue()));
            goto L16
        L18:
            r104 = Boxing.boxDouble(r109);
            goto L19
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            int r110 = com.larus.common_ui.widget.input.a.f328681a;
            byte[] r111 = this.$data;
            int r112 = this.this$0.f328152a;
            this.label = 1;
            r100 = com.larus.common_ui.widget.input.a.a(r111, r112, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    static {
    }

    @Override // com.larus.common_ui.view.u
    public final void b() {
    }

    @Override // com.larus.common_ui.view.u
    public final void c(boolean r100) {
    }

    @Override // com.larus.common_ui.view.u
    public void setFps(int r100) {
    }

    private final float getAmplitude() {
        Float r100 = CollectionsKt.m9877maxOrNull(this.f328162k);
        if (r100 == null) goto L5;
        float r101 = r100.floatValue();
    L6:
        this.f328162k.clear();
        return Math.min(r101 * 1.5f, 1.0f);
    L5:
        r101 = 0.0f;
        goto L6
    }

    private final CoroutineScope getLifecycleScope() {
        return (CoroutineScope) this.f328167p.getValue();
    }

    public ChatContinuousAudioVisualizerOpt(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f328152a = 45;
        float r101 = i5.N();
        this.f328153b = r101;
        this.f328154c = i5.z();
        this.f328155d = i5.l0();
        this.f328156e = i5.N();
        this.f328157f = i5.d0();
        this.f328158g = 5;
        this.f328159h = 3;
        this.f328162k = new LinkedList();
        this.f328164m = new LinkedHashMap();
        Paint r102 = new Paint();
        r102.setAntiAlias(true);
        r102.setFilterBitmap(true);
        r102.setStrokeCap(Paint.Cap.ROUND);
        r102.setStrokeWidth(r101);
        r102.setColor(-1);
        this.f328166o = r102;
        this.f328167p = LazyKt.lazy(new g(this));
    }

    public static CoroutineScope d(final ChatContinuousAudioVisualizerOpt r100) {
        int r101 = l0.f375430a;
        return (CoroutineScope) l0.a(CoroutineScopeKt.MainScope(), new h(r100));
    }

    private final void setAmplitude(float r100) {
        this.f328162k.offer(Float.valueOf(r100));
        if (this.f328162k.size() <= 10) goto L6;
        this.f328162k.poll();
        return;
    }

    @Override // com.larus.common_ui.view.u
    public final void a(int r100) {
        setVisibility(r100);
    }

    public final void g(AttributeSet r100) {
        if (r100 == null) goto L5;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.larus_bar_color, R.attr.larus_bar_max_height, R.attr.larus_bar_min_height, R.attr.larus_group_bar_count, R.attr.larus_side_margin, R.attr.larus_top_group_count});
        this.f328157f = r101.getDimension(1, this.f328157f);
        this.f328156e = r101.getDimension(2, this.f328156e);
        this.f328155d = r101.getDimension(4, this.f328155d);
        this.f328158g = r101.getInteger(3, this.f328158g);
        this.f328159h = r101.getInteger(5, this.f328159h);
        this.f328166o.setColor(r101.getColor(0, -1));
        r101.recycle();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        super.onDraw(r210);
        long r100 = SystemClock.elapsedRealtime();
        long r101 = r100 - this.f328163l;
        int r110 = 2;
        int r111 = 1;
        if (r101 < 400) goto L71;
        this.f328163l = r100;
        float r102 = getAmplitude();
        if (r101 < 800) goto L7;
        r102 = 0.0f;
        r101 = 0;
    L8:
        int r103 = this.f328161j / 2;
        if (this.f328159h != 1) goto L11;
        int r104 = r103 + 1;
    L12:
        int r105 = this.f328161j;
        if (1 > r105) goto L71;
        int r106 = 1;
    L16:
        if (r106 != r104) goto L18;
        float r112 = 1.0f;
    L26:
        if (r106 != r104) goto L28;
        int r113 = 0;
    L36:
        int r107 = Random.Default.nextInt(r110, this.f328158g);
        float r114 = RangesKt.coerceAtLeast((this.f328157f * r102) * r112, this.f328156e);
        float r115 = RangesKt.coerceAtLeast((0.7f * r114) * r112, this.f328156e);
        float r116 = RangesKt.coerceAtLeast(r112 * (0.4f * r114), this.f328156e);
        int r117 = this.f328158g;
        if (r111 > r117) goto L68;
    L38:
        float r211 = r102;
        int r212 = ((r106 - 1) * this.f328158g) + r111;
        int r213 = r103;
        a r108 = this.f328164m.get(Integer.valueOf(r212));
        if (r108 == null) goto L41;
        r108.f328169b = r113;
    L41:
        if (r111 != r107) goto L48;
        a r109 = this.f328164m.get(Integer.valueOf(r212));
        if (r109 == null) goto L45;
        r109.f328168a = 0;
    L45:
        a r118 = this.f328164m.get(Integer.valueOf(r212));
        if (r118 == null) goto L66;
        r118.f328170c = r114;
    L66:
        if (r111 == r117) goto L69;
        r111 = r111 + 1;
        r102 = r211;
        r103 = r213;
    L69:
        if (r106 == r105) goto L71;
        r106 = r106 + 1;
        r102 = r211;
        r103 = r213;
        r110 = 2;
        r111 = 1;
        goto L16
    L48:
        int r119 = r107 - 1;
        if (r111 > (r107 + 1)) goto L52;
        if (r119 > r111) goto L52;
        boolean r120 = true;
    L53:
        if (r120 == false) goto L60;
        a r121 = this.f328164m.get(Integer.valueOf(r212));
        if (r121 == null) goto L57;
        r121.f328168a = 1;
    L57:
        a r122 = this.f328164m.get(Integer.valueOf(r212));
        if (r122 == null) goto L66;
        r122.f328170c = r115;
        goto L66
    L60:
        a r123 = this.f328164m.get(Integer.valueOf(r212));
        if (r123 == null) goto L63;
        r123.f328168a = 2;
    L63:
        a r124 = this.f328164m.get(Integer.valueOf(r212));
        if (r124 == null) goto L66;
        r124.f328170c = r116;
    L52:
        r120 = false;
        goto L53
    L68:
        r211 = r102;
        r213 = r103;
        goto L69
    L28:
        if (r103 <= r106) goto L30;
    L32:
        boolean r125 = false;
    L33:
        if (r125 == false) goto L35;
        r113 = 1;
        goto L36
    L35:
        r113 = 2;
        goto L36
    L30:
        if (r106 > (r103 + 3)) goto L32;
        r125 = true;
        goto L33
    L18:
        int r126 = r104 - 1;
        if (r106 > (r104 + 1)) goto L22;
        if (r126 > r106) goto L22;
        boolean r127 = true;
    L23:
        if (r127 == false) goto L25;
        r112 = (Random.Default.nextFloat() * 0.2f) + 0.6f;
        goto L26
    L25:
        r112 = (Random.Default.nextFloat() * 0.1f) + 0.4f;
    L22:
        r127 = false;
        goto L23
    L11:
        r104 = Random.Default.nextInt(r103, r103 + 3);
        goto L12
    L7:
        r101 = r101 - ((long) 400);
    L71:
        long r128 = r101;
        if (this.f328159h != 1) goto L74;
        float r129 = 0.0f;
    L75:
        int r130 = this.f328165n;
        if (1 > r130) goto L210;
        int r131 = 1;
    L78:
        a r132 = this.f328164m.get(Integer.valueOf(r131));
        if (r132 == null) goto L208;
        int r133 = r132.f328169b;
        if (r133 == 0) goto L84;
    L86:
        boolean r134 = false;
    L87:
        if (r133 != 0) goto L91;
        int r135 = 1;
        if (r132.f328168a != 1) goto L92;
    L95:
        boolean r136 = true;
    L97:
        if (r133 == 0) goto L99;
    L102:
        int r137 = 1;
        if (r133 == 1) goto L105;
    L107:
        boolean r138 = false;
    L108:
        if (r133 != r137) goto L112;
        int r139 = 2;
        if (r132.f328168a != 2) goto L113;
    L114:
        boolean r140 = true;
    L117:
        if (0 <= r128) goto L119;
    L121:
        boolean r141 = false;
    L123:
        if (r141 == false) goto L133;
        if (r134 == false) goto L207;
        float r142 = r132.f328171d;
        if (r142 > 0.0f) goto L129;
        r142 = this.f328156e;
    L129:
        r132.f328172e = (r132.f328170c - r142) / 20;
    L207:
        float r143 = RangesKt.coerceAtLeast(r132.f328171d + r132.f328172e, this.f328156e);
        r132.f328171d = r143;
        float r144 = (getHeight() - r143) / 2;
        r129 = r129 + (this.f328153b + this.f328154c);
        r210.drawLine(r129, r144, r129, r144 + r143, this.f328166o);
        goto L208
    L133:
        if (50 <= r128) goto L135;
    L137:
        boolean r145 = false;
    L138:
        if (r145 == false) goto L146;
        if (r136 == false) goto L207;
        float r146 = r132.f328171d;
        if (r146 > 0.0f) goto L144;
        r146 = this.f328156e;
    L144:
        r132.f328172e = (r132.f328170c - r146) / 20;
        goto L207
    L146:
        if (100 <= r128) goto L148;
    L150:
        boolean r147 = false;
    L151:
        if (r147 == false) goto L159;
        if (r138 == false) goto L207;
        float r148 = r132.f328171d;
        if (r148 > 0.0f) goto L157;
        r148 = this.f328156e;
    L157:
        r132.f328172e = (r132.f328170c - r148) / 20;
        goto L207
    L159:
        if (150 <= r128) goto L161;
    L163:
        boolean r149 = false;
    L164:
        if (r149 == false) goto L172;
        if (r140 == false) goto L207;
        float r150 = r132.f328171d;
        if (r150 > 0.0f) goto L170;
        r150 = this.f328156e;
    L170:
        r132.f328172e = (r132.f328170c - r150) / 20;
        goto L207
    L172:
        if (200 <= r128) goto L174;
    L176:
        boolean r151 = false;
    L177:
        if (r151 == false) goto L181;
        if (r134 == false) goto L207;
        r132.f328172e = (this.f328156e - r132.f328170c) / 20;
        goto L207
    L181:
        if (250 <= r128) goto L183;
    L185:
        boolean r152 = false;
    L186:
        if (r152 == false) goto L190;
        if (r136 == false) goto L207;
        r132.f328172e = (this.f328156e - r132.f328170c) / 20;
        goto L207
    L190:
        if (300 <= r128) goto L192;
    L194:
        boolean r153 = false;
    L195:
        if (r153 == false) goto L199;
        if (r138 == false) goto L207;
        r132.f328172e = (this.f328156e - r132.f328170c) / 20;
        goto L207
    L199:
        if (350 <= r128) goto L201;
    L203:
        boolean r154 = false;
    L204:
        if (r154 == false) goto L207;
        if (r140 == false) goto L207;
        r132.f328172e = (this.f328156e - r132.f328170c) / 20;
        goto L207
    L201:
        if (r128 >= 400) goto L203;
        r154 = true;
        goto L204
    L192:
        if (r128 >= 350) goto L194;
        r153 = true;
        goto L195
    L183:
        if (r128 >= 300) goto L185;
        r152 = true;
        goto L186
    L174:
        if (r128 >= 250) goto L176;
        r151 = true;
        goto L177
    L161:
        if (r128 >= 200) goto L163;
        r149 = true;
        goto L164
    L148:
        if (r128 >= 150) goto L150;
        r147 = true;
        goto L151
    L135:
        if (r128 >= 100) goto L137;
        r145 = true;
        goto L138
    L119:
        if (r128 >= 50) goto L121;
        r141 = true;
    L113:
        if (r133 == r139) goto L114;
        r140 = false;
        goto L117
    L112:
        r139 = 2;
        goto L113
    L105:
        if (r132.f328168a != 1) goto L107;
    L106:
        r138 = true;
        goto L108
    L99:
        if (r132.f328168a != 2) goto L102;
        r137 = 1;
    L92:
        if (r133 == r135) goto L94;
    L96:
        r136 = false;
        goto L97
    L94:
        if (r132.f328168a != 0) goto L96;
    L91:
        r135 = 1;
        goto L92
    L84:
        if (r132.f328168a != 0) goto L86;
        r134 = true;
    L208:
        if (r131 == r130) goto L210;
        r131 = r131 + 1;
    L210:
        postInvalidateDelayed(10);
        return;
    L74:
        r129 = (getWidth() - this.f328160i) / 2;
        goto L75
    }

    @Override // com.larus.common_ui.view.u
    public void setAudioData(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        BuildersKt.launch$default(getLifecycleScope(), Dispatchers.getMain(), null, new AnonymousClass1(r100, this, null), 2, null);
    }

    @Override // com.larus.common_ui.view.u
    public void setColor(int r100) {
        this.f328166o.setColor(r100);
    }

    public ChatContinuousAudioVisualizerOpt(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f328152a = 45;
        float r102 = i5.N();
        this.f328153b = r102;
        this.f328154c = i5.z();
        this.f328155d = i5.l0();
        this.f328156e = i5.N();
        this.f328157f = i5.d0();
        this.f328158g = 5;
        this.f328159h = 3;
        this.f328162k = new LinkedList();
        this.f328164m = new LinkedHashMap();
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setFilterBitmap(true);
        r103.setStrokeCap(Paint.Cap.ROUND);
        r103.setStrokeWidth(r102);
        r103.setColor(-1);
        this.f328166o = r103;
        this.f328167p = LazyKt.lazy(new g(this));
        g(r101);
    }

    public static final /* synthetic */ void e(ChatContinuousAudioVisualizerOpt r100, float r101) {
        r100.setAmplitude(r101);
    }

    public final void f(int r100, boolean r101) {
        Map<Integer, a> r102 = this.f328164m;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        if (r103.get(Integer.valueOf(r100)) == null) goto L6;
        if (r101 == true) goto L6;
        return;
    L6:
        ((LinkedHashMap) this.f328164m).clear();
        int r104 = 1;
        if (1 > r100) goto L11;
    L8:
        Integer r105 = Integer.valueOf(r104);
        this.f328164m.put(r105, new a(0));
        if (r104 == r100) goto L13;
        r104 = r104 + 1;
        goto L8
    L13:
        return;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (r101 == 0) goto L8;
        int r102 = this.f328165n;
        if (r102 <= 0) goto L9;
        f(r102, true);
        this.f328163l = 0;
        return;
    L9:
        return;
    }

    public ChatContinuousAudioVisualizerOpt(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328152a = 45;
        float r103 = i5.N();
        this.f328153b = r103;
        this.f328154c = i5.z();
        this.f328155d = i5.l0();
        this.f328156e = i5.N();
        this.f328157f = i5.d0();
        this.f328158g = 5;
        this.f328159h = 3;
        this.f328162k = new LinkedList();
        this.f328164m = new LinkedHashMap();
        Paint r104 = new Paint();
        r104.setAntiAlias(true);
        r104.setFilterBitmap(true);
        r104.setStrokeCap(Paint.Cap.ROUND);
        r104.setStrokeWidth(r103);
        r104.setColor(-1);
        this.f328166o = r104;
        this.f328167p = LazyKt.lazy(new g(this));
        g(r101);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = getWidth() - (this.f328155d * 2);
        float r105 = (this.f328153b + this.f328154c) * this.f328158g;
        int r106 = (int) (r104 / r105);
        this.f328161j = r106;
        if ((r106 % 2) != 0) goto L5;
        this.f328161j = r106 - 1;
    L5:
        int r107 = RangesKt.coerceAtLeast(this.f328161j, 3);
        this.f328161j = r107;
        this.f328160i = r107 * r105;
        int r108 = r107 * this.f328158g;
        this.f328165n = r108;
        f(r108, false);
    }
}
