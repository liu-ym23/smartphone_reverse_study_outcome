package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.v;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import y9c.d;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e*\u0001'\u0018\u0000 N2\u00020\u0001:\u0001NB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0014J(\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\tH\u0014J\u0016\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020 J\u000e\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020\tJ\u0006\u0010:\u001a\u00020/J\u0006\u0010;\u001a\u00020/J\u0006\u0010<\u001a\u00020/J\u0006\u0010=\u001a\u00020/J\u0010\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020$J \u0010@\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001b2\u0006\u0010A\u001a\u00020\tH\u0002J\u0010\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020$H\u0002J0\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001b2\u0006\u0010E\u001a\u00020\t2\u0006\u0010\r\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020$H\u0002J8\u0010F\u001a\u00020/2\u0016\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001b2\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001bH\u0002J \u0010I\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010K\u001a\u00020\fH\u0002J\u0014\u0010L\u001a\u00020/*\u0002012\u0006\u0010I\u001a\u00020\u001eH\u0002J\b\u0010M\u001a\u00020/H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001aj\b\u0012\u0004\u0012\u00020\u001e`\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceWaveBar;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "eachFlameWidth", "", "spaceBetweenFlames", "maxWidth", "", "maxHeight", "minHeight", "axisY", "r", "nFlames", "startX", "endX", "smoothFactor", "rateFactor", GestureAction.zoom, "flamesPaint", "Landroid/graphics/Paint;", "orgHeightArr", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newHeightArr", "rectArr", "Landroid/graphics/RectF;", "sigmoidXOffset", "", "shouldRefresh", "", "lastVolume", "", "maxVolume", "rectFPool", "com/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceWaveBar$rectFPool$1", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceWaveBar$rectFPool$1;", "dp5", "dp7", "dp9", "dp11", "currentX", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "setWaveBarColor", "colorResId", "alpha", BasicTestActionHandler.TEST_ACTION_RESET, "pauseRefresh", "resumeRefresh", "stopRefresh", "refresh", ITTVideoEngineEventSource.KEY_VOLUME, "generateHeight", "barItemCounts", "sigmoidTransformation", "num", "randomHeightArray", OfficeSDKRequestTag.KEY_NEW_USER, "startAnimation", "orgArr", "newArr", "rectF", "left", "height", "drawRoundRectF", "calculateNFlames", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceWaveBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f430683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f430684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f430685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f430686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f430687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f430688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f430689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f430690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f430691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f430692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f430693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f430694l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f430695m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList<Float> f430696n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<Float> f430697o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<RectF> f430698p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final double f430699q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f430700r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f430701s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f430702t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f430703u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f430704v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f430705w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f430706x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f430707y;

    public static final class a {
    }

    public static final class b extends v<RectF> {
        public b() {
            super(100);
        }

        @Override // com.larksuite.framework.utils.v
        public final RectF a(Object[] r100) {
            Intrinsics.checkNotNullParameter(r100, "args");
            return new RectF();
        }
    }

    static {
    }

    public final void a(Number r110) {
        Intrinsics.checkNotNullParameter(r110, ITTVideoEngineEventSource.KEY_VOLUME);
        if (this.f430700r == true) goto L5;
        return;
    L5:
        this.f430701s = RangesKt.coerceAtLeast(this.f430701s, r110.floatValue());
        ArrayList<Float> r100 = this.f430696n;
        if (r100.size() == this.f430690h) goto L12;
        r100.clear();
        int r101 = this.f430690h;
        ArrayList r102 = new ArrayList(r101);
        int r103 = 0;
    L8:
        if (r103 >= r101) goto L10;
        r102.add(Float.valueOf(0.0f));
        r103 = r103 + 1;
        goto L8
    L10:
        r100.addAll(r102);
    L12:
        if (this.f430697o.size() == this.f430690h) goto L17;
        this.f430697o.clear();
        ArrayList<Float> r104 = this.f430697o;
        int r105 = this.f430690h;
        ArrayList r106 = new ArrayList(r105);
        int r107 = 0;
    L14:
        if (r107 >= r105) goto L16;
        r106.add(Float.valueOf(0.0f));
        r107 = r107 + 1;
        goto L14
    L16:
        r104.addAll(r106);
    L17:
        float r108 = Math.max(this.f430687e, (float) (((double) this.f430686d) / (Math.exp(-(r110.doubleValue() - this.f430699q)) + 1.0d)));
        if (r108 >= 0.0f) goto L21;
        r108 = 0.0f;
    L21:
        if (r110.floatValue() <= 46.7f) goto L23;
        this.f430707y = 0;
        int r111 = this.f430690h;
        Float r109 = Float.valueOf(r108);
        float r112 = 2;
        Float r113 = Float.valueOf(this.f430689g * r112);
        Intrinsics.checkNotNullParameter(r109, "maxHeight");
        ArrayList r114 = new ArrayList(r111);
        int r115 = 0;
    L45:
        if (r115 >= r111) goto L47;
        r114.add(Float.valueOf(Random.Default.nextFloat() * r109.floatValue()));
        r115 = r115 + 1;
        goto L45
    L47:
        ArrayList<Float> r116 = new ArrayList(r111);
        int r117 = 0;
    L48:
        if (r117 >= r111) goto L58;
        float r118 = ((Number) ListProtector.get(r114, r117)).floatValue();
        if (r117 != 0) goto L52;
        float r119 = 0.0f;
    L53:
        int r120 = r111 - 1;
        if (r117 != r120) goto L56;
        float r121 = 0.0f;
    L57:
        r116.add(Float.valueOf(Math.max(Math.min((r118 + Math.min(((r119 + r121) - (r112 * r118)) / this.f430692j, this.f430693k * r118)) * (((float) Math.sin((r117 * 3.1415927f) / r120)) * this.f430694l), r109.floatValue()), r113.floatValue())));
        r117 = r117 + 1;
        goto L48
    L56:
        r121 = ((Number) ListProtector.get(r114, r117 + 1)).floatValue();
        goto L57
    L52:
        r119 = ((Number) ListProtector.get(r114, r117 - 1)).floatValue();
        goto L53
    L58:
        ArrayList<Float> r122 = r116;
    L59:
        float r123 = this.f430691i;
        Iterator<T> r124 = r100.iterator();
        int r125 = 0;
    L61:
        if (r124.hasNext() == false) goto L67;
        int r126 = r125 + 1;
        float r127 = ((Number) r124.next()).floatValue();
        float r128 = this.f430688f;
        float r129 = r127 / 2;
        float r130 = r128 - r129;
        float r131 = r128 + r129;
        float r132 = this.f430683a + r123;
        RectF r133 = this.f430702t.c(new Object[0]);
        r133.set(r123, r130, r132, r131);
        if (this.f430698p.size() > r125) goto L65;
        this.f430698p.add(r133);
    L66:
        r123 = r123 + (this.f430683a + this.f430684b);
        r125 = r126;
        goto L61
    L65:
        ListProtector.set(this.f430698p, r125, r133);
        goto L66
    L67:
        int r134 = r100.size();
        if (r134 == r122.size()) goto L70;
    L73:
        Log.e("AudioWaveBar", "size not equal");
    L74:
        this.f430696n = r122;
        return;
    L70:
        if (r134 != this.f430698p.size()) goto L73;
        ValueAnimator r135 = ValueAnimator.ofFloat(new float[]{0.0f, 12.0f});
        r135.addUpdateListener(new c(this, r100, r122));
        r135.setDuration(200);
        r135.start();
        goto L74
    L23:
        if (this.f430707y > 0) goto L25;
        this.f430707y = 1;
    L25:
        int r136 = this.f430690h;
        int r137 = 0;
    L26:
        if (r137 >= r136) goto L43;
        int r138 = Math.abs((r136 / 2) - r137);
        int r139 = this.f430707y;
        if (r139 > r138) goto L30;
        int r140 = this.f430703u;
    L42:
        ListProtector.set(this.f430697o, r137, Float.valueOf(r140));
        r137 = r137 + 1;
        goto L26
    L30:
        switch(((r139 - r138) % 9)) {
            case 0: goto L40;
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L33;
            case 8: goto L32;
            default: goto L31;
        };
    L31:
        r140 = this.f430703u;
        goto L42
    L32:
        r140 = this.f430703u;
        goto L42
    L33:
        r140 = this.f430703u;
        goto L42
    L34:
        r140 = this.f430704v;
        goto L42
    L35:
        r140 = this.f430705w;
        goto L42
    L36:
        r140 = this.f430706x;
        goto L42
    L37:
        r140 = this.f430705w;
        goto L42
    L38:
        r140 = this.f430704v;
        goto L42
    L39:
        r140 = this.f430703u;
        goto L42
    L40:
        r140 = this.f430703u;
        goto L42
    L43:
        this.f430707y = (this.f430707y + 1) % 16;
        r122 = this.f430697o;
        goto L59
    }

    public final void b(int r100) {
        this.f430695m.setColor(UIUtils.getColor(getContext(), r100));
        this.f430695m.setAlpha((int) (0.8d * ((double) 255)));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        Iterator<T> r101 = this.f430698p.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        RectF r102 = (RectF) r101.next();
        float r103 = this.f430689g;
        r100.drawRoundRect(r102, r103, r103, this.f430695m);
        this.f430702t.d(r102);
        goto L4
    }

    public final void setWaveBarColor(int r100) {
        this.f430695m.setColor(d.c(getContext(), r100));
    }

    public VoiceWaveBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        int r102 = d.a(2);
        this.f430683a = r102;
        this.f430684b = d.a(2);
        this.f430687e = d.a(5);
        this.f430689g = r102 / 2.0f;
        this.f430692j = 4;
        this.f430693k = 0.5f;
        this.f430694l = 1.15f;
        Paint r103 = new Paint();
        this.f430695m = r103;
        this.f430696n = new ArrayList(this.f430690h);
        this.f430697o = new ArrayList(this.f430690h);
        this.f430698p = new ArrayList(this.f430690h);
        this.f430699q = 5.0d;
        this.f430700r = true;
        this.f430702t = new b();
        this.f430703u = d.b(r100, 5.0f);
        this.f430704v = d.b(r100, 7.0f);
        this.f430705w = d.b(r100, 9.0f);
        this.f430706x = d.b(r100, 11.0f);
        this.f430707y = 1;
        r103.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        this.f430685c = r100;
        float r104 = r101;
        this.f430686d = r104;
        this.f430688f = r104 / 2.0f;
        this.f430698p.clear();
        this.f430696n.clear();
        this.f430690h = 0;
        float r105 = this.f430685c;
    L3:
        int r106 = this.f430683a;
        float r107 = r105 - r106;
        int r108 = this.f430684b;
        if (r107 <= (r106 + r108)) goto L6;
        this.f430690h++;
        r105 = r107 - r108;
        goto L3
    L6:
        this.f430691i = r107 / 2;
        a(Float.valueOf(this.f430701s));
    }
}
