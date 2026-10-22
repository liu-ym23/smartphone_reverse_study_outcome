package com.bytedance.livesdk.ktvcommon.midi.view.miditone;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import bl6.f;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.KtvMode;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\b\u000eB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ \u0010\u0006\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/midi/view/miditone/KSongToneView;", "Landroid/view/View;", "Lkotlin/Pair;", "", "toneLineColor", "", "setToneLineColorConfig", "Landroid/graphics/Paint;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getNormalLinePaint", "()Landroid/graphics/Paint;", "normalLinePaint", "Landroid/graphics/Path;", "b", "getNormalLinePath", "()Landroid/graphics/Path;", "normalLinePath", "c", "getHitPaint", "hitPaint", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KSongToneView extends View {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f256266n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f256267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f256268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f256269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f256270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Path> f256271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<b> f256272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Shader> f256273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f256274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f256275i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f256276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f256277k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f256278l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f256279m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Stack<Path> f256280a;

        public a() {
            this.f256280a = new Stack();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Shader f256281a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f256281a, ((b) r100).f256281a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            Shader r100 = this.f256281a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "ShaderInfo(shader=" + this.f256281a + ")";
        }

        public b(Shader r100) {
            Intrinsics.checkNotNullParameter(r100, "shader");
            this.f256281a = r100;
        }
    }

    public KSongToneView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KSongToneView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Paint getHitPaint() {
        return (Paint) this.f256269c.getValue();
    }

    private final Paint getNormalLinePaint() {
        return (Paint) this.f256267a.getValue();
    }

    private final Path getNormalLinePath() {
        return (Path) this.f256268b.getValue();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((LinkedHashMap) this.f256273g).clear();
        this.f256270d.f256280a.clear();
        ((ArrayList) this.f256271e).clear();
        ((ArrayList) this.f256272f).clear();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (getNormalLinePath().isEmpty() == true) goto L5;
        r100.drawPath(getNormalLinePath(), getNormalLinePaint());
    L5:
        int r101 = this.f256271e.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        Path r103 = (Path) ListProtector.get(this.f256271e, r102);
        if (r103.isEmpty() == true) goto L10;
        getHitPaint().setShader(((b) ListProtector.get(this.f256272f, r102)).f256281a);
        r100.drawPath(r103, getHitPaint());
    L10:
        r102 = r102 + 1;
        goto L6
    }

    public final void setToneLineColorConfig(Pair<String, String> r100) {
        if (Intrinsics.areEqual(this.f256274h.f256302q, r100) == false) goto L5;
        return;
    L5:
        this.f256274h.f256302q = r100;
        ((LinkedHashMap) this.f256273g).clear();
        invalidate();
    }

    public final void a(long r100, long r101) {
        d r102 = this.f256274h;
        if (r102.f256294i == r100) goto L5;
    L7:
        r102.f256294i = r100;
        r102.f256295j = r101;
        r102.f256296k = r100 + r101;
        this.f256275i.b();
        invalidate();
        return;
    L5:
        if (r102.f256295j != r101) goto L7;
    }

    public final void b(long r100, List<f> r101) {
        Intrinsics.checkNotNullParameter(r101, DBDefinition.SEGMENT_TABLE_NAME);
        int r102 = r101.hashCode();
        if (this.f256278l == r100) goto L5;
    L7:
        this.f256278l = r100;
        this.f256279m = r102;
        c r103 = this.f256275i;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, DBDefinition.SEGMENT_TABLE_NAME);
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        Intrinsics.checkNotNullParameter(r104, "normalSegments");
        Intrinsics.checkNotNullParameter(r105, "hitSegments");
        long r106 = r100 - r103.f256283b.f256294i;
        Iterator<T> r107 = r101.iterator();
        if (r107.hasNext() == false) goto L14;
        ((f) r107.next()).getClass();
        d r108 = r103.f256283b;
        if (r108.f256287b <= 0) goto L12;
        int r109 = r108.f256286a;
    L12:
        r103.a(null, r106);
        throw null;
    L14:
        Iterator r110 = ((ArrayList) this.f256271e).iterator();
    L16:
        if (r110.hasNext() == false) goto L20;
        Path r111 = (Path) r110.next();
        a r112 = this.f256270d;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r111, "path");
        if (r112.f256280a.size() >= 10) goto L16;
        r111.reset();
        r112.f256280a.push(r111);
        goto L16
    L20:
        ((ArrayList) this.f256271e).clear();
        ((ArrayList) this.f256272f).clear();
        getNormalLinePath().reset();
        Iterator r113 = r104.iterator();
    L22:
        if (r113.hasNext() == false) goto L24;
        com.bytedance.livesdk.ktvcommon.midi.view.miditone.b r114 = (com.bytedance.livesdk.ktvcommon.midi.view.miditone.b) r113.next();
        Path r115 = getNormalLinePath();
        r114.getClass();
        r114.getClass();
        r115.moveTo(0.0f, 0.0f);
        Path r116 = getNormalLinePath();
        r114.getClass();
        r114.getClass();
        r116.lineTo(0.0f, 0.0f);
        goto L22
    L24:
        Iterator r117 = r105.iterator();
        if (r117.hasNext() == false) goto L32;
        com.bytedance.livesdk.ktvcommon.midi.view.miditone.a r118 = (com.bytedance.livesdk.ktvcommon.midi.view.miditone.a) r117.next();
        r118.getClass();
        r118.getClass();
        r118.getClass();
        r118.getClass();
        a r119 = this.f256270d;
        if ((!r119.f256280a.isEmpty()) == false) goto L29;
        Path r120 = r119.f256280a.pop();
    L30:
        r120.reset();
        Iterable r121 = (Iterable) null;
        throw null;
    L29:
        r120 = new Path();
        goto L30
    L32:
        invalidate();
        return;
    L5:
        if (this.f256279m != r102) goto L7;
    }

    public final void c(int r100, int r101) {
        d r102 = this.f256274h;
        if (r102.f256288c == r100) goto L5;
    L7:
        r102.f256288c = r100;
        r102.f256289d = r101 - (r102.f256292g + r102.f256293h);
        this.f256275i.b();
        invalidate();
        return;
    L5:
        if (r102.f256289d != (r101 - (r102.f256292g + r102.f256293h))) goto L7;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        if (this.f256276j == r102) goto L5;
    L6:
        this.f256276j = r102;
        this.f256277k = r103;
        c(r102, r103);
        return;
    L5:
        if (this.f256277k != r103) goto L6;
    }

    public KSongToneView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f256267a = InfraKotlinExtsKt.mainThreadLazy(new KSongToneView$normalLinePaint$2(this));
        this.f256268b = InfraKotlinExtsKt.mainThreadLazy(KSongToneView$normalLinePath$2.INSTANCE);
        this.f256269c = InfraKotlinExtsKt.mainThreadLazy(new KSongToneView$hitPaint$2(this));
        this.f256270d = new a();
        this.f256271e = new ArrayList();
        this.f256272f = new ArrayList();
        this.f256273g = new LinkedHashMap();
        d r103 = new d();
        this.f256274h = r103;
        this.f256275i = new c(r103);
        this.f256278l = -1;
        r103.f256287b = 90;
        r103.f256286a = 58;
        r103.f256291f = s1.f(7.0f);
        r103.f256292g = s1.f(5.0f);
        r103.f256293h = s1.f(11.0f);
        if (bb0.b.a() != KtvMode.SOLO_KTV) goto L5;
        r103.f256297l = s1.h(R.color.ttlive_solo_ktv_tone_line);
        r103.f256298m = s1.f(4.0f);
    L6:
        r103.f256299n = s1.f(4.0f);
        r103.f256300o = ColorProtector.parseColor("#FF4BE8");
        r103.f256301p = ColorProtector.parseColor("#FF386B");
        r103.f256294i = 1180;
        r103.f256295j = 4720;
        r103.f256296k = 5900;
        setLayerType(2, null);
        return;
    L5:
        r103.f256297l = s1.h(R.color.ttlive_ktv_tone_line);
        r103.f256298m = s1.f(3.0f);
        goto L6
    }

    public /* synthetic */ KSongToneView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
