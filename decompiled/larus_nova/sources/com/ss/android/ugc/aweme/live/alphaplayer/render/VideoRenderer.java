package com.ss.android.ugc.aweme.live.alphaplayer.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView;
import com.ss.android.ugc.aweme.live.alphaplayer.TouchEvent;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.mask.MaskRender;
import com.ss.android.ugc.aweme.live.alphaplayer.model.Align;
import com.ss.android.ugc.aweme.live.alphaplayer.model.Axis;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;
import com.ss.android.ugc.aweme.live.alphaplayer.model.Radio;
import com.ss.android.ugc.aweme.live.alphaplayer.model.Rect;
import com.ss.android.ugc.aweme.live.alphaplayer.utils.CoordinateUtil;
import com.ss.android.ugc.aweme.live.alphaplayer.utils.ShaderUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes40.dex */
public class VideoRenderer implements IRender, Handler.Callback {
    public MaskRender A;
    public Map<String, Map<String, DataSource.Element>> B;
    public List<DataSource.Layer> C;
    public final Radio D;
    public IPlayerController.FirstGLFrameListener E;
    public boolean F;
    public Handler G;
    public PthreadHandlerThreadV2 H;
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public LayersRenderer f451215J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f451216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f451217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f451218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FloatBuffer f451219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FloatBuffer f451220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FloatBuffer f451221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f451222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f451223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f451224i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f451225j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f451226k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SurfaceTexture f451227l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f451228m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f451229n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicInteger f451230o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public IRender.SurfaceListener f451231p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final IAlphaVideoView f451232q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DataSource.ScaleType f451233r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public DataSource.Area f451234s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public DataSource.Area f451235t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public DataSource.Area f451236u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f451237v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f451238w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f451239x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f451240y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f451241z;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.live.alphaplayer.render.VideoRenderer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f451242a = null;

        static {
            int[] r100 = new int[DataSource.ScaleType.values().length];
            f451242a = r100;
            r100[DataSource.ScaleType.ScaleToFill.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L28:
            f451242a[DataSource.ScaleType.ScaleAspectFitCenter.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            f451242a[DataSource.ScaleType.ScaleAspectFill.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L46:
            f451242a[DataSource.ScaleType.TopFill.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L30:
            f451242a[DataSource.ScaleType.BottomFill.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L36:
            f451242a[DataSource.ScaleType.LeftFill.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L40:
            f451242a[DataSource.ScaleType.RightFill.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L42:
            f451242a[DataSource.ScaleType.TopFit.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L26:
            f451242a[DataSource.ScaleType.BottomFit.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L32:
            f451242a[DataSource.ScaleType.LeftFit.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L38:
            f451242a[DataSource.ScaleType.RightFit.ordinal()] = 11;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public final void e() {
        if (this.I == false) goto L8;
        Handler r100 = this.G;
        if (r100 == null) goto L8;
        r100.removeCallbacksAndMessages(null);
    L8:
        if (this.I == false) goto L12;
        PthreadHandlerThreadV2 r101 = this.H;
        if (r101 == null) goto L12;
        r101.quit();
        this.H = null;
    L12:
        LayersRenderer r102 = this.f451215J;
        if (r102 == null) goto L16;
        ((LinkedHashMap) r102.f451208a).clear();
        this.f451215J = null;
        return;
    }

    public final void g() {
        MaskRender r100 = this.A;
        if (r100 == null) goto L23;
        Iterator r101 = ((HashMap) r100.f451118l).entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        int r102 = ((Integer) ((Map.Entry) r101.next()).getValue()).intValue();
        if (r102 == 0) goto L6;
        GLES20.glDeleteTextures(1, new int[]{r102}, 0);
        goto L6
    L11:
        Iterator r103 = ((HashMap) r100.f451117k).entrySet().iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        ((MaskSrc) ((Map.Entry) r103.next()).getValue()).getClass();
        goto L13
    L15:
        ((HashMap) r100.f451117k).clear();
        ((HashMap) r100.f451118l).clear();
        ((ArrayList) r100.f451119m).clear();
        this.A = null;
        return;
    }

    public static void b() {
        if (GLES20.glGetError() != 0) goto L5;
        return;
    }

    public final void a(List<MaskSrc> r100) {
        if (this.B == null) goto L11;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isEmpty() == true) goto L13;
        this.A = new MaskRender(this.f451232q.getContext(), r100);
        new AlphaVideoProgram(this.f451223h, this.f451224i, this.f451225j, this.f451226k);
        if (this.f451232q.a() == false) goto L14;
        this.A.a();
        return;
    L14:
        return;
    L13:
        return;
    }

    public final List<String> d(TouchEvent r110) {
        MaskRender r100 = this.A;
        List<DataSource.Layer> r101 = this.C;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 != null) goto L7;
        return null;
    L7:
        ArrayList r102 = new ArrayList(r101);
        Collections.reverse(r102);
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L33;
        DataSource.Layer r105 = (DataSource.Layer) r104.next();
        int r106 = r105.f451148b;
        boolean r107 = true;
        if (r106 == 1) goto L15;
        if (r106 != 0) goto L9;
    L15:
        if (r105.f451151e == false) goto L9;
        DataSource.Area r108 = (DataSource.Area) ((HashMap) r100.f451120n).get(r105.f451147a);
        boolean r109 = false;
        if (r108 == null) goto L31;
        double r111 = r110.f451057a;
        if (r111 >= r108.f451131a) goto L23;
    L29:
        r107 = false;
    L30:
        r109 = r107;
        goto L31
    L23:
        if (r111 > r108.f451133c) goto L29;
        double r112 = r110.f451058b;
        if (r112 > r108.f451132b) goto L29;
        if (r112 < r108.f451134d) goto L29;
    L31:
        if (r109 == false) goto L9;
        r103.add(r105.f451147a);
        goto L9
    L33:
        return r103;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        if (r100.what == 1) goto L6;
    L8:
        return false;
    L6:
        if (this.f451232q == null) goto L8;
        this.f451228m.compareAndSet(false, true);
        this.f451232q.requestRender();
        goto L8
    }

    public final void i(DataSource.DataInfo r110) {
        this.f451233r = r110.f451136b;
        int r100 = r110.f451140f;
        this.f451237v = r100;
        int r101 = r110.f451141g;
        this.f451238w = r101;
        this.f451239x = r110.f451142h;
        this.f451240y = r110.f451143i;
        boolean r102 = true;
        if (r110.f451144j >= 1) goto L5;
    L9:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L33;
        DataSource.Area r104 = r110.f451139e;
        float r105 = r100;
        float r106 = r101;
        r104.getClass();
        if (r105 != 0.0f) goto L15;
    L22:
        this.f451235t = r104;
        DataSource.Area r107 = r110.f451138d;
        float r108 = r110.f451140f;
        float r109 = r110.f451141g;
        r107.getClass();
        if (r108 != 0.0f) goto L25;
    L32:
        this.f451234s = r107;
    L34:
        this.f451236u = new DataSource.Area(0.0f, 0.0f, 1.0f, 1.0f);
        if (r110.f451144j < 1) goto L41;
        Map<String, Map<String, DataSource.Element>> r111 = r110.f451145k;
        if (r111 == null) goto L41;
        if (r111.isEmpty() == true) goto L41;
        boolean r112 = true;
    L43:
        if (r112 == false) goto L45;
        this.B = r110.f451145k;
    L46:
        this.f451241z = r110.f451137c;
        if (r110.f451144j < 2) goto L53;
        List<DataSource.Layer> r113 = r110.f451146l;
        if (r113 == null) goto L53;
        if (r113.isEmpty() == true) goto L53;
    L54:
        if (r102 == false) goto L61;
        this.C = r110.f451146l;
        LayersRenderer r114 = this.f451215J;
        if (r114 == null) goto L58;
        ((LinkedHashMap) r114.f451208a).clear();
        this.f451215J = null;
    L58:
        List<DataSource.Layer> r115 = this.C;
        if (r115 == null) goto L62;
        this.f451215J = new LayersRenderer(r115, new AlphaVideoProgram(this.f451223h, this.f451224i, this.f451225j, this.f451226k));
    L62:
        DataSource.Area r116 = this.f451236u;
        float r117 = r116.f451131a - 0.5f;
        float r118 = r116.f451132b - 0.5f;
        float r119 = r116.f451133c - 0.5f;
        float r120 = r116.f451134d - 0.5f;
        float r121 = r117 * 2.0f;
        r116.f451131a = r121;
        float r122 = r119 * 2.0f;
        r116.f451133c = r122;
        float r123 = -(r118 * 2.0f);
        r116.f451132b = r123;
        float r124 = -(r120 * 2.0f);
        r116.f451134d = r124;
        CoordinateUtil.a(this.f451216a, r121, r123, r122, r124);
        FloatBuffer r125 = ByteBuffer.allocateDirect(this.f451216a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.f451216a);
        this.f451219d = r125;
        r125.position(0);
        float[] r126 = this.f451217b;
        DataSource.Area r127 = this.f451235t;
        CoordinateUtil.a(r126, r127.f451131a, r127.f451132b, r127.f451133c, r127.f451134d);
        FloatBuffer r128 = ByteBuffer.allocateDirect(this.f451217b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.f451217b);
        this.f451220e = r128;
        r128.position(0);
        float[] r129 = this.f451218c;
        DataSource.Area r130 = this.f451234s;
        CoordinateUtil.a(r129, r130.f451131a, r130.f451132b, r130.f451133c, r130.f451134d);
        FloatBuffer r131 = ByteBuffer.allocateDirect(this.f451218c.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.f451218c);
        this.f451221f = r131;
        r131.position(0);
        Radio r132 = this.D;
        r132.f451163a = 0.0f;
        r132.f451164b = 0.0f;
        r132.f451165c = 0.0f;
        r132.f451166d = 0.0f;
        g();
        return;
    L61:
        this.C = null;
    L53:
        r102 = false;
        goto L54
    L45:
        this.B = null;
    L41:
        r112 = false;
        goto L43
    L25:
        if (r109 == 0.0f) goto L32;
        float r133 = r107.f451131a;
        float r134 = r107.f451132b;
        float r135 = r107.f451133c;
        float r136 = r107.f451134d;
        if (r108 == 0.0f) goto L32;
        if (r109 == 0.0f) goto L32;
        r107.f451131a = r133 / r108;
        r107.f451132b = r134 / r109;
        r107.f451133c = r135 / r108;
        r107.f451134d = r136 / r109;
        goto L32
    L15:
        if (r106 == 0.0f) goto L22;
        float r137 = r104.f451131a;
        float r138 = r104.f451132b;
        float r139 = r104.f451133c;
        float r140 = r104.f451134d;
        if (r105 == 0.0f) goto L22;
        if (r106 == 0.0f) goto L22;
        r104.f451131a = r137 / r105;
        r104.f451132b = r138 / r106;
        r104.f451133c = r139 / r105;
        r104.f451134d = r140 / r106;
        goto L22
    L33:
        this.f451235t = new DataSource.Area(0.5f, 0.0f, 1.0f, 1.0f);
        this.f451234s = new DataSource.Area(0.0f, 0.0f, 0.5f, 1.0f);
        goto L34
    L5:
        if (r110.f451139e == null) goto L9;
        if (r110.f451138d == null) goto L9;
        r103 = true;
        goto L11
    }

    @Override // android.opengl.GLSurfaceView.Renderer, com.ss.android.ugc.aweme.live.alphaplayer.GLTextureView.Renderer
    public final void onDrawFrame(GL10 r310) {
        if (this.f451228m.compareAndSet(true, false) == false) goto L8;
        this.f451227l.updateTexImage();     // Catch: Exception -> L6
    L8:
        if (this.f451229n.get() == false) goto L10;
        this.f451230o.addAndGet(1);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        int r100 = this.f451231p.b();
        int r101 = this.f451230o.get();
        if (r100 <= (r101 + 2)) goto L17;
        this.f451230o.set(r100);
    L19:
        if (this.f451219d != null) goto L21;
    L26:
        Map<String, Map<String, DataSource.Element>> r102 = this.B;
        if (r102 == null) goto L29;
        Map<String, DataSource.Element> r103 = r102.get(String.valueOf(r100 % this.f451241z));
    L30:
        List<DataSource.Layer> r104 = this.C;
        if (r104 == null) goto L69;
        Iterator<DataSource.Layer> r105 = r104.iterator();
    L34:
        if (r105.hasNext() == false) goto L77;
        DataSource.Layer r106 = r105.next();
        int r107 = r106.f451148b;
        if (r107 == 0) goto L61;
        if (r107 == 1) goto L61;
        if (r107 != 2) goto L34;
        String r108 = r106.f451147a;
        LayersRenderer r109 = this.f451215J;
        if (r109 == null) goto L34;
        if (r109.f451209b.contains(r108) == true) goto L34;
        DataSource.Layer r110 = (DataSource.Layer) ((LinkedHashMap) r109.f451208a).get(r108);
        if (r110 == null) goto L60;
        if (r110.f451150d == null) goto L58;
        DataSource.Area r111 = r110.f451149c;
        if (r111 == null) goto L58;
        if (r110.f451148b != 2) goto L56;
        AlphaVideoProgram r112 = r109.f451213f;
        Rect r113 = r109.f451210c;
        Rect.f451168g.getClass();
        Rect r114 = Rect.Companion.a(r111, false).d(r109.f451211d, r109.f451212e);
        Rect r115 = Rect.Companion.a(r110.f451150d, false).d(r109.f451211d, r109.f451212e);
        r112.getClass();
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glUseProgram(r112.f451204d);
        int r116 = r112.f451205e;
        ByteBuffer r117 = r112.f451201a;
        AlphaVideoProgram.a(r113, r117, true);
        GLES20.glVertexAttribPointer(r116, 2, 5126, false, 0, r117);
        int r118 = r112.f451206f;
        ByteBuffer r119 = r112.f451202b;
        AlphaVideoProgram.a(r114, r119, false);
        GLES20.glVertexAttribPointer(r118, 2, 5126, false, 0, r119);
        int r120 = r112.f451207g;
        ByteBuffer r121 = r112.f451203c;
        AlphaVideoProgram.a(r115, r121, false);
        GLES20.glVertexAttribPointer(r120, 2, 5126, false, 0, r121);
        GLES20.glEnableVertexAttribArray(r112.f451205e);
        GLES20.glEnableVertexAttribArray(r112.f451206f);
        GLES20.glEnableVertexAttribArray(r112.f451207g);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisable(3042);
        goto L34
    L56:
        throw new LayerRenderException("layer " + r110.f451147a + " is not a video layer", null, 2, null);
    L58:
        throw new LayerRenderException("rgb area or alpha area is null: rgbArea=" + r110.f451149c + ", alphaArea=" + r110.f451150d, null, 2, null);
    L60:
        throw new LayerRenderException("no such layer: layerName=" + r108, null, 2, null);
    L61:
        String r122 = r106.f451147a;
        MaskRender r123 = this.A;
        if (r103 == null) goto L34;
        if (r123 == null) goto L34;
        DataSource.Element r124 = r103.get(r122);
        if (r124 == null) goto L34;
        r103.toString();
        r124.toString();
    L77:
        GLES20.glFinish();
        IPlayerController.FirstGLFrameListener r125 = this.E;
        if (r125 != null) goto L80;
        return;
    L80:
        if (this.F == false) goto L115;
        r125.a();
        this.F = false;
        return;
    L115:
        return;
    L69:
        if (r103 == null) goto L77;
        Iterator<Map.Entry<String, DataSource.Element>> r126 = r103.entrySet().iterator();
    L73:
        if (r126.hasNext() == false) goto L77;
        Map.Entry<String, DataSource.Element> r127 = r126.next();
        if (this.A == null) goto L73;
        String r128 = r127.getKey();
        DataSource.Element r129 = r127.getValue();
        r129.getClass();
        r129.toString();
        goto L73
    L29:
        r103 = null;
        goto L30
    L21:
        if (this.f451220e == null) goto L26;
        if (this.f451221f == null) goto L26;
        GLES20.glUseProgram(this.f451223h);
        b();
        this.f451219d.position(0);
        GLES20.glVertexAttribPointer(this.f451224i, 2, 5126, false, 0, this.f451219d);
        b();
        GLES20.glEnableVertexAttribArray(this.f451224i);
        b();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f451222g);
        this.f451220e.position(0);
        GLES20.glVertexAttribPointer(this.f451225j, 2, 5126, false, 0, this.f451220e);
        b();
        GLES20.glEnableVertexAttribArray(this.f451225j);
        b();
        this.f451221f.position(0);
        GLES20.glVertexAttribPointer(this.f451226k, 2, 5126, false, 0, this.f451221f);
        b();
        GLES20.glEnableVertexAttribArray(this.f451226k);
        b();
        GLES20.glDrawArrays(5, 0, 4);
        b();
        goto L26
    L17:
        r100 = r101;
        goto L19
    L10:
        if (this.f451232q.getLastFrameHold() == true) goto L12;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
    L12:
        GLES20.glFinish();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r100) {
        if (this.I == false) goto L12;
        PthreadHandlerThreadV2 r101 = this.H;
        if (r101 == null) goto L12;
        if (ThreadMethodProxy.isAlive(r101) == false) goto L12;
        Handler r102 = this.G;
        if (r102 == null) goto L12;
        r102.sendEmptyMessage(1);
        return;
    L12:
        if (this.f451232q == null) goto L16;
        this.f451228m.compareAndSet(false, true);
        this.f451232q.requestRender();
        return;
    }

    public VideoRenderer(IAlphaVideoView r100, boolean r101) {
        this.f451216a = new float[8];
        this.f451217b = new float[8];
        this.f451218c = new float[8];
        this.f451228m = new AtomicBoolean(false);
        this.f451229n = new AtomicBoolean(false);
        this.f451230o = new AtomicInteger(0);
        this.f451233r = DataSource.ScaleType.ScaleAspectFill;
        this.C = null;
        this.D = new Radio();
        this.f451232q = r100;
        this.I = r101;
        if (r101 == true) goto L5;
        return;
    L5:
        if (this.H != null) goto L9;
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("renderWorker");
        this.H = r102;
        ThreadMethodProxy.start(r102);
        this.G = new Handler(this.H.getLooper(), this);
        return;
    }

    @Override // android.opengl.GLSurfaceView.Renderer, com.ss.android.ugc.aweme.live.alphaplayer.GLTextureView.Renderer
    public final void onSurfaceCreated(GL10 r100, EGLConfig r101) {
        int r102 = ShaderUtil.b(ShaderUtil.c("video/video_vertex.sh", this.f451232q.getResources()), ShaderUtil.c("video/video_frag.sh", this.f451232q.getResources()));
        this.f451223h = r102;
        if (r102 == 0) goto L17;
        this.f451224i = GLES20.glGetAttribLocation(r102, "aPosition");
        b();
        if (this.f451224i == (-1)) goto L29;
        this.f451225j = GLES20.glGetAttribLocation(this.f451223h, "aTextureCoord");
        b();
        if (this.f451225j == (-1)) goto L27;
        this.f451226k = GLES20.glGetAttribLocation(this.f451223h, "aAlphaTextureCoord");
        b();
        int r103 = this.f451226k;
        if (r103 == (-1)) goto L25;
        LayersRenderer r104 = this.f451215J;
        if (r104 == null) goto L15;
        r104.f451213f = new AlphaVideoProgram(this.f451223h, this.f451224i, this.f451225j, r103);
    L15:
        if (this.A == null) goto L17;
        new AlphaVideoProgram(this.f451223h, this.f451224i, this.f451225j, this.f451226k);
        goto L17
    L25:
        throw new RuntimeException("Could not get attrib location for aAlphaTextureCoord");
    L27:
        throw new RuntimeException("Could not get attrib location for aTextureCoord");
    L29:
        throw new RuntimeException("Could not get attrib location for aPosition");
    L17:
        int[] r105 = new int[1];
        GLES20.glGenTextures(1, r105, 0);
        int r106 = r105[0];
        this.f451222g = r106;
        GLES20.glBindTexture(36197, r106);
        b();
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        SurfaceTexture r107 = new SurfaceTexture(this.f451222g);
        this.f451227l = r107;
        r107.setDefaultBufferSize(this.f451232q.getMeasuredWidth(), this.f451232q.getMeasuredHeight());
        this.f451227l.setOnFrameAvailableListener(this);
        Surface r108 = new Surface(this.f451227l);
        IRender.SurfaceListener r109 = this.f451231p;
        if (r109 == null) goto L20;
        r109.a(r108);
    L20:
        this.f451228m.compareAndSet(true, false);
        MaskRender r110 = this.A;
        if (r110 == null) goto L30;
        r110.a();
        return;
    }

    @Override // android.opengl.GLSurfaceView.Renderer, com.ss.android.ugc.aweme.live.alphaplayer.GLTextureView.Renderer
    public final void onSurfaceChanged(GL10 r100, int r101, int r102) {
        GLES20.glViewport(0, 0, r101, r102);
    }

    public final void c(float r100, float r110, float r111, float r112) {
        if (this.f451220e == null) goto L14;
        DataSource.Area r101 = this.f451235t;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f451221f != null) goto L10;
        return;
    L10:
        if (this.f451234s == null) goto L17;
        Radio r102 = this.D;
        float r103 = (1.0f - r111) - r100;
        float r104 = (-r100) / r103;
        float r105 = (1.0f - r110) - r112;
        float r106 = (-r111) / r103;
        r102.f451163a = r104;
        r102.f451164b = (-r110) / r105;
        r102.f451165c = r106;
        r102.f451166d = (-r112) / r105;
        float[] r107 = this.f451217b;
        float r108 = r101.f451131a;
        float r109 = r101.f451133c;
        float r113 = r109 - r108;
        float r114 = (r113 * r100) + r108;
        float r115 = r101.f451132b;
        float r116 = r101.f451134d;
        float r117 = r116 - r115;
        CoordinateUtil.a(r107, r114, (r117 * r110) + r115, r109 - (r113 * r111), r116 - (r117 * r112));
        this.f451220e.position(0);
        this.f451220e.put(this.f451217b);
        float[] r118 = this.f451218c;
        DataSource.Area r119 = this.f451234s;
        float r120 = r119.f451131a;
        float r121 = r119.f451133c;
        float r122 = r121 - r120;
        float r123 = (r100 * r122) + r120;
        float r124 = r119.f451132b;
        float r125 = r119.f451134d;
        float r126 = r125 - r124;
        CoordinateUtil.a(r118, r123, (r110 * r126) + r124, r121 - (r111 * r122), r125 - (r112 * r126));
        this.f451221f.position(0);
        this.f451221f.put(this.f451218c);
        return;
    L17:
        return;
    }

    public final void h(float r110, float r111, float r112, float r113) {
        float r100 = 0.0f;
        if (r110 > 0.0f) goto L5;
        return;
    L5:
        if (r111 > 0.0f) goto L7;
        return;
    L7:
        if (r112 > 0.0f) goto L9;
        return;
    L9:
        if (r113 <= 0.0f) goto L63;
        LayersRenderer r101 = this.f451215J;
        if (r101 == null) goto L28;
        DataSource.ScaleType r102 = this.f451233r;
        float r103 = this.f451237v;
        float r104 = this.f451238w;
        float r105 = this.f451239x;
        float r106 = this.f451240y;
        r101.f451211d = r103;
        r101.f451212e = r104;
        Rect.f451168g.getClass();
        Rect r107 = new Rect(0.0f, 0.0f, r105, r106);
        Rect r108 = new Rect(0.0f, 0.0f, r110, r111);
        switch(LayersRendererKt$WhenMappings.f451214a[r102.ordinal()]) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            default: goto L16;
        };
    L17:
        r108 = r107.b(r108, Axis.Y).a(r108, Axis.X, Align.End);
        goto L27
    L18:
        r108 = r107.b(r108, Axis.Y).a(r108, Axis.X, Align.Start);
        goto L27
    L19:
        r108 = r107.b(r108, Axis.X).a(r108, Axis.Y, Align.End);
        goto L27
    L20:
        r108 = r107.b(r108, Axis.X).a(r108, Axis.Y, Align.Start);
        goto L27
    L21:
        r108 = r107.b(r108, Axis.Shorter).a(r108, Axis.Longer, Align.Center).a(r108, Axis.X, Align.End);
        goto L27
    L22:
        r108 = r107.b(r108, Axis.Shorter).a(r108, Axis.Longer, Align.Center).a(r108, Axis.X, Align.Start);
        goto L27
    L23:
        r108 = r107.b(r108, Axis.Shorter).a(r108, Axis.Longer, Align.Center).a(r108, Axis.Y, Align.End);
        goto L27
    L24:
        r108 = r107.b(r108, Axis.Shorter).a(r108, Axis.Longer, Align.Center).a(r108, Axis.Y, Align.Start);
        goto L27
    L25:
        r108 = r107.b(r108, Axis.Shorter).a(r108, Axis.Longer, Align.Center);
        goto L27
    L26:
        r108 = r107.b(r108, Axis.Longer).a(r108, Axis.Shorter, Align.Center);
    L27:
        Rect r109 = r108.d(r110, r111);
        float r114 = 2;
        float r115 = (r109.f451170b - 0.5f) * r114;
        float r116 = r109.f451171c;
        float r117 = r109.f451173e;
        r101.f451210c = new Rect(r115, (-((r116 + r117) - 0.5f)) * r114, r109.f451172d * r114, r117 * r114);
        goto L28
    L16:
        throw new NoWhenBranchMatchedException();
    L28:
        float r118 = r110 / r111;
        float r119 = r112 / r113;
        if (r118 <= r119) goto L31;
        float r120 = (1.0f - (r111 / (r110 / r119))) / 2.0f;
        float r121 = 0.0f;
    L33:
        switch(AnonymousClass1.f451242a[this.f451233r.ordinal()]) {
            case 1: goto L48;
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L39;
            case 8: goto L38;
            case 9: goto L37;
            case 10: goto L36;
            case 11: goto L35;
            default: goto L64;
        };
    L35:
        j(((1.0f - ((r111 * r119) / r110)) / 2.0f) * 2.0f, 0.0f, 0.0f, 0.0f);
        return;
    L36:
        j(0.0f, 0.0f, ((1.0f - ((r111 * r119) / r110)) / 2.0f) * 2.0f, 0.0f);
        return;
    L37:
        j(0.0f, ((1.0f - ((r110 / r119) / r111)) / 2.0f) * 2.0f, 0.0f, 0.0f);
        return;
    L38:
        j(0.0f, 0.0f, 0.0f, ((1.0f - ((r110 / r119) / r111)) / 2.0f) * 2.0f);
        return;
    L39:
        c(r121 * 2.0f, r120, 0.0f, r120);
        return;
    L40:
        c(0.0f, r120, r121 * 2.0f, r120);
        return;
    L41:
        c(r121, r120 * 2.0f, r121, 0.0f);
        return;
    L42:
        c(r121, 0.0f, r121, r120 * 2.0f);
        return;
    L43:
        c(r121, r120, r121, r120);
        return;
    L44:
        if (r118 <= r119) goto L46;
        r100 = (1.0f - ((r111 * r119) / r110)) / 2.0f;
        float r122 = 0.0f;
    L47:
        j(r100, r122, r100, r122);
        return;
    L46:
        r122 = (1.0f - ((r110 / r119) / r111)) / 2.0f;
        goto L47
    L48:
        c(0.0f, 0.0f, 0.0f, 0.0f);
        return;
    L64:
        return;
    L31:
        r121 = (1.0f - (r110 / (r111 * r119))) / 2.0f;
        r120 = 0.0f;
        goto L33
    }

    public final void j(float r100, float r101, float r102, float r103) {
        if (this.f451219d != null) goto L5;
        return;
    L5:
        Radio r104 = this.D;
        r104.f451163a = r100;
        r104.f451164b = r101;
        r104.f451165c = r102;
        r104.f451166d = r103;
        float[] r105 = this.f451216a;
        DataSource.Area r106 = this.f451236u;
        CoordinateUtil.a(r105, r106.f451131a + (r100 * 2.0f), r106.f451132b - (r101 * 2.0f), r106.f451133c - (r102 * 2.0f), r106.f451134d + (r103 * 2.0f));
        this.f451219d.position(0);
        this.f451219d.put(this.f451216a);
    }
}
