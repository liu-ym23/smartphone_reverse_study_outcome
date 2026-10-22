package com.bytedance.xelement.markdown;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxShadowNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.textra.TTTextUtils;
import i8a.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kr7.h;
import kr7.l;
import kr7.m0;
import kr7.p;
import kr7.s;
import kr7.u;
import kr7.w;
import kr7.y;
import y6a.e;
import y6a.g;
import y6a.j;
import y6a.k;

/* JADX INFO: loaded from: classes22.dex */
@LynxShadowNode(tagName = "x-markdown")
@LynxGeneratorName(packageName = "com.bytedance.ies.xelement.markdown")
public class MarkdownShadowNode extends ShadowNode implements e, kr7.a {
    public static final float[] V1 = null;
    public ReadableMap A;
    public l B;
    public MarkdownDocument C;
    public kr7.c D;
    public HashMap<String, s> E;
    public HashSet<String> F;
    public float G;
    public boolean G1;
    public int H;
    public int H0;
    public long H1;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f272663J;
    public float K;
    public float L;
    public int L0;
    public int L1;
    public boolean M;
    public float[] M1;
    public boolean N;
    public int O;
    public int P;
    public boolean P0;
    public final b P1;
    public int Q;
    public boolean Q1;
    public boolean R;
    public int S;
    public boolean S1;
    public int T;
    public final Map<String, p> T1;
    public j U;
    public g V;
    public boolean V0;
    public float W;
    public float X;
    public float Y;
    public float Z;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f272664b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public final Looper f272665g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final Handler f272666h1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public float f272667k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public float f272668k1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public float f272669p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public m0 f272670p1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f272671v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f272672v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f272673w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f272674x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public final boolean f272675x1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f272676y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public boolean f272677y1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f272678z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f272679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f272680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f272681c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f272682d;

        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f272683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f272684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f272685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f272686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f272687e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f272688f;

        public final boolean a() {
            if (Float.compare(this.f272687e, this.f272684b) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public b() {
            this.f272683a = 0.0f;
            this.f272684b = 0.0f;
            this.f272685c = 0;
            this.f272686d = 0;
            this.f272687e = 0.0f;
            this.f272688f = 0;
        }

        public void update(long r100) {
            this.f272688f = r100;
            if (this.f272686d != 0) goto L5;
            this.f272686d = r100;
        L5:
            long r101 = this.f272685c;
            if (r101 > 0) goto L9;
            this.f272687e = this.f272684b;
            return;
        L9:
            long r102 = this.f272686d;
            if (r100 < (r102 + r101)) goto L12;
            this.f272687e = this.f272684b;
            return;
        L12:
            float r103 = this.f272683a;
            this.f272687e = r103 + (((this.f272684b - r103) * (r100 - r102)) / r101);
        }
    }

    public static class c implements com.lynx.tasm.behavior.shadow.text.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<ShadowNode> f272689a;

        public c(MarkdownShadowNode r100) {
            this.f272689a = new WeakReference(r100);
        }

        @Override // com.lynx.tasm.behavior.shadow.text.g.c
        public final void a(Typeface r100, int r101) {
            ShadowNode r102 = this.f272689a.get();
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.f382222o == false) goto L8;
            return;
        L8:
            if ((r102 instanceof MarkdownShadowNode) == false) goto L10;
            final MarkdownShadowNode r103 = (MarkdownShadowNode) r102;
            r103.I(new y(r103));
        L10:
            r102.q();
        }
    }

    static {
        V1 = new float[]{0.0f, 0.0f};
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public final void g() {
    }

    public final String C() {
        return "type=" + this.I + ", step=" + this.f272663J + HTTP.URL_DEFAULT + this.O;
    }

    public final void D() {
        float[] r100 = this.C.findCursorPosition(this.f272663J, !this.f272676y);
        this.M1 = r100;
        if (this.f272678z == false) goto L19;
        float r101 = this.L;
        if (r101 > 0.0f) goto L7;
        this.f272667k0 = r100[3];
        return;
    L7:
        if (this.M == true) goto L9;
        this.f272667k0 = r100[3];
        return;
    L9:
        if (this.I != 2) goto L15;
        int r102 = ((int) (r101 * this.G)) + 1;
        int r103 = this.Q;
        if (r103 > 0) goto L14;
        r103 = F(this.f272663J);
    L14:
        float[] r104 = this.C.findCursorPosition(G(Math.min(r103 + r102, this.P)), !this.f272676y);
    L16:
        this.f272667k0 = r104[3];
        return;
    L15:
        r104 = this.C.findCursorPosition(this.f272663J + (((int) (r101 * this.G)) + 1), !this.f272676y);
        goto L16
    L19:
        this.f272667k0 = this.Z;
    }

    public final void H() {
        LLog.i("MarkdownShadowNode", "resetAnimationState: initialStep=" + this.H + ", " + C());
        if (this.f272672v1 == false) goto L7;
        m0 r100 = this.f272670p1;
        if (r100 == null) goto L7;
        r100.h(this.H);
    L7:
        I(new w(this));
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final Object m() {
        StringBuilder r100 = new StringBuilder("getExtraBundle: hasBundle=");
        boolean r101 = true;
        if (this.B == null) goto L5;
        boolean r102 = true;
    L6:
        r100.append(r102);
        r100.append(", contentUpdated=");
        l r103 = this.B;
        if (r103 != null) goto L9;
    L11:
        r101 = false;
    L12:
        r100.append(r101);
        LLog.d("MarkdownShadowNode", r100.toString());
        l r104 = this.B;
        if (r104 != null) goto L16;
        return null;
    L16:
        l r105 = new l(r104);
        r104.f505770k = false;
        return r105;
    L9:
        if (r103.f505770k == false) goto L11;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void q() {
        if (this.f382222o == false) goto L5;
        return;
    L5:
        super.q();
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void t() {
        I(new u(this));
    }

    public MarkdownShadowNode() {
        this.f272676y = true;
        this.f272678z = false;
        this.G = 1.0f;
        this.H = 0;
        this.I = 0;
        this.f272663J = 0;
        this.K = 15.0f;
        this.L = 0.0f;
        this.M = true;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = false;
        this.S = 0;
        this.T = -1;
        this.W = 0.0f;
        this.X = 0.0f;
        this.Y = 0.0f;
        this.Z = 0.0f;
        this.f272667k0 = 0.0f;
        this.f272669p0 = Float.MAX_VALUE;
        this.H0 = 0;
        this.L0 = Integer.MAX_VALUE;
        this.P0 = false;
        this.V0 = false;
        this.f272664b1 = false;
        this.f272665g1 = null;
        this.f272666h1 = null;
        this.f272668k1 = 0.0f;
        this.f272670p1 = null;
        this.f272672v1 = false;
        this.f272675x1 = true;
        this.f272677y1 = false;
        this.G1 = false;
        this.H1 = 0;
        this.L1 = 0;
        this.M1 = null;
        this.P1 = new b();
        this.Q1 = true;
        this.S1 = false;
        this.T1 = new HashMap();
        h(this);
        Looper r100 = Looper.myLooper();
        this.f272665g1 = r100;
        if (r100 == null) goto L5;
        this.f272666h1 = new Handler(r100);
    L5:
        ILynxTrailService r101 = (ILynxTrailService) n.c().a(ILynxTrailService.class);
        if (r101 == null) goto L14;
        String r102 = r101.stringValueForTrailKey("enable_markdown_density_update");
        if ("true".equals(r102) == false) goto L11;
        this.f272675x1 = true;
        return;
    L11:
        if ("false".equals(r102) == false) goto L16;
        this.f272675x1 = false;
        return;
    L16:
        return;
    }

    public final boolean E(String r100) {
        Map<String, EventsListener> r101 = this.f382223p;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.containsKey(r100) == false) goto L7;
        return true;
    }

    public final int F(int r100) {
        int r101 = 0;
        if (this.C == null) goto L15;
        if (r100 <= 0) goto L15;
        int r102 = Math.max(0, this.P);
        if (r102 != 0) goto L9;
        return 0;
    L9:
        int r103 = this.C.getLineIndexByCharIndex(r100) + 1;
        if (r103 < 0) goto L14;
        r101 = r103;
    L14:
        return Math.min(r101, r102);
    L15:
        return 0;
    }

    public final int G(int r100) {
        int r101 = 0;
        if (this.C == null) goto L15;
        if (r100 <= 0) goto L15;
        int r102 = Math.max(0, this.P);
        if (r102 != 0) goto L9;
        return 0;
    L9:
        int r103 = this.C.getCharIndexByLineIndex(Math.min(r100 - 1, r102 - 1));
        if (r103 < 0) goto L14;
        r101 = r103;
    L14:
        return Math.min(r101, this.O);
    L15:
        return 0;
    }

    public final void I(Runnable r100) {
        if (this.f272665g1 == null) goto L5;
        this.f272666h1.post(r100);
        return;
    L5:
        UIThreadUtils.runOnUiThread(r100);
    }

    @LynxProp(name = "allow-break-around-punctuation")
    public void setAllowBreakAroundPunctuation(boolean r100) {
        this.P0 = r100;
    }

    @LynxProp(name = "animation-frame-rate")
    public void setAnimationFrameRate(float r100) {
        this.K = r100;
    }

    @LynxProp(name = "animation-type")
    public void setAnimationType(String r100) {
        int r101 = this.I;
        if (r100.equals("typewriter") == false) goto L6;
        this.I = 1;
    L9:
        int r102 = this.I;
        if (r101 == r102) goto L13;
        if (r102 != 2) goto L13;
        this.R = true;
    L13:
        this.Q1 = true;
        q();
        return;
    L6:
        if (r100.equals("line-expand") == false) goto L8;
        this.I = 2;
        goto L9
    L8:
        this.I = 0;
        goto L9
    }

    @LynxProp(name = "animation-velocity")
    public void setAnimationVelocity(float r100) {
        if (r100 >= 0.0f) goto L6;
        r100 = 1.0f;
    L6:
        this.G = r100;
        q();
    }

    @LynxProp(name = "content")
    public void setContent(String r100) {
        this.f272671v = r100;
        this.S1 = true;
        this.Q1 = true;
        q();
    }

    @LynxProp(name = "content-complete")
    public void setContentComplete(boolean r100) {
        this.f272676y = r100;
        this.Q1 = true;
        q();
    }

    @LynxProp(name = "content-id")
    public void setContentID(String r100) {
        this.f272673w = r100;
    }

    @LynxProp(name = "exposure-tags")
    public void setExposureTags(ReadableArray r100) {
        this.F = new HashSet();
        int r101 = 0;
    L4:
        if (r101 >= r100.size()) goto L6;
        this.F.add(r100.getString(r101));
        r101 = r101 + 1;
        goto L4
    }

    @LynxProp(name = "image-downsampling")
    public void setImageDownSampling(boolean r100) {
        this.V0 = r100;
    }

    @LynxProp(name = "image-sync-load")
    public void setImageSyncLoad(boolean r100) {
        this.f272664b1 = r100;
    }

    @LynxProp(name = "initial-animation-step")
    public void setInitialAnimationStep(int r100) {
        this.H = r100;
        this.f272663J = r100;
        if (this.I != 2) goto L5;
        this.R = true;
    L5:
        this.Q1 = true;
        q();
    }

    @LynxProp(name = "content-range")
    public void setMarkdownContentRange(ReadableArray r100) {
        if (r100.size() <= 0) goto L6;
        this.H0 = r100.getInt(0);
    L6:
        if (r100.size() <= 1) goto L9;
        this.L0 = r100.getInt(1);
        return;
    }

    @LynxProp(name = "markdown-max-height")
    public void setMarkdownMaxHeight(float r100) {
        this.f272669p0 = r100 * getContext().getScreenMetrics().density;
        q();
    }

    @LynxProp(name = "markdown-style")
    public void setStyleSheet(ReadableMap r100) {
        this.A = r100;
        this.Q1 = true;
        q();
    }

    @LynxProp(name = "text-maxline")
    public void setTextMaxLine(int r100) {
        this.T = r100;
        this.Q1 = true;
        q();
    }

    @LynxProp(name = "typewriter-dynamic-height")
    public void setTypewriterAutoHeight(boolean r100) {
        this.f272678z = r100;
        q();
    }

    @LynxProp(name = "typewriter-height-transition-duration")
    public void setTypewriterHeightTransitionDuration(float r100) {
        this.L = r100;
    }

    @LynxProp(name = "typewriter-height-transition-prefetch")
    public void setTypewriterHeightTransitionPrefetch(boolean r100) {
        this.M = r100;
        q();
    }

    @LynxProp(name = "enable-region-view")
    public void setVSyncAnimation(boolean r100) {
        this.f272672v1 = r100;
    }

    public final void J(long r100, boolean r101) {
        if (this.L > 0.0f) goto L5;
        return;
    L5:
        if (this.P1.a() == false) goto L8;
        this.P1.f272688f = r100;
    L8:
        if (Float.compare(this.f272667k0, this.P1.f272684b) == 0) goto L12;
        if (r101 == false) goto L11;
        b r102 = this.P1;
        float r103 = this.f272667k0;
        r102.f272683a = r102.f272687e;
        r102.f272684b = r103;
        r102.f272685c = 0;
        r102.f272686d = r102.f272688f;
        r102.f272687e = r103;
        goto L12
    L11:
        b r104 = this.P1;
        float r105 = this.f272667k0;
        long r106 = (long) (this.L * 1000.0f);
        r104.f272683a = r104.f272687e;
        r104.f272684b = r105;
        r104.f272685c = r106;
        r104.f272686d = r104.f272688f;
    L12:
        this.P1.update(r100);
        this.f272667k0 = this.P1.f272687e;
    }

    @Override // y6a.e
    public final k b(j r110, g r210) {
        Markdown.ensureInitialized();
        DisplayMetrics r100 = getContext().getScreenMetrics();
        if (r100 != null) goto L5;
    L8:
        this.U = r110;
        this.V = r210;
        float r101 = Float.MAX_VALUE;
        if (r110.f566411b != MeasureMode.UNDEFINED) goto L11;
        float r102 = Float.MAX_VALUE;
    L12:
        float r103 = this.f382209h.a();
        float r104 = 0.0f;
        if (r103 <= 0.0f) goto L16;
        r101 = r103;
    L16:
        float r105 = Math.min(this.f272669p0, r101);
        MeasureMode r106 = r110.f566411b;
        MeasureMode r107 = MeasureMode.EXACTLY;
        if (r106 != r107) goto L19;
        float r108 = r102;
    L21:
        if (r110.f566413d != r107) goto L23;
        float r109 = r105;
    L24:
        StringBuilder r111 = new StringBuilder("measure start: width=");
        r111.append(r102);
        r111.append(", height=");
        r111.append(r105);
        r111.append(", widthMode=");
        r111.append(r110.f566411b);
        r111.append(", heightMode=");
        r111.append(r110.f566413d);
        r111.append(", contentLength=");
        String r112 = this.f272671v;
        boolean r113 = false;
        if (r112 == null) goto L27;
        int r114 = r112.length();
    L28:
        r111.append(r114);
        LLog.d("MarkdownShadowNode", r111.toString());
        long r115 = 0;
        if (this.f272671v == null) goto L98;
        if (this.Q1 == false) goto L33;
    L47:
        this.W = r102;
        this.X = r105;
        MarkdownDocument r116 = this.C;
        MarkdownDocument r117 = new MarkdownDocument(this, this);
        this.C = r117;
        if (r116 == null) goto L50;
        r117.inheritState(r116);
    L50:
        this.C.allowBreakAroundPunctuation(this.P0);
        kr7.c r118 = new kr7.c();
        this.D = r118;
        r118.f505727b = new WeakReference(this);
        ReadableMap r119 = this.A;
        if (r119 == null) goto L58;
        this.C.setStyle(r119);
        ReadableMap r120 = this.A;
        String r121 = "";
        if (r120 == null) goto L57;
        ReadableMap r122 = r120.getMap("typewriterCursor", null);
        if (r122 == null) goto L57;
        r121 = r122.getString("customCursor", "");
    L57:
        this.f272674x = r121;
    L59:
        ReadableMap r123 = this.A;
        float r124 = getContext().getScreenMetrics().density;
        if (r123 == null) goto L64;
        ReadableMap r125 = r123.getMap("normalText", null);
        if (r125 == null) goto L64;
        float r126 = ((float) r125.getDouble("fontSize", 17.0d)) * r124;
    L65:
        this.f272668k1 = r126;
        TraceEvent.beginSection("x-markdown.ShadowNode.parse");
        this.C.parseMarkdown(this.f272671v, this.H0, this.L0, r102);
        TraceEvent.endSection("x-markdown.ShadowNode.parse");
        TraceEvent.beginSection("x-markdown.ShadowNode.layout");
        if (this.S1 == false) goto L68;
        String r127 = this.f272673w;
        final m7a.a r128 = new m7a.a(this.f382203b, "parseEnd");
        r128.a("id", r127);
        UIThreadUtils.runOnUiThread(new kr7.g(this, r128));
        this.S1 = false;
    L68:
        float[] r129 = this.C.layoutMarkdown(r102, r105, this.T);
        float r130 = r129[0];
        r109 = r129[1];
        this.Y = r130;
        this.Z = r109;
        int r131 = this.I;
        if (r131 == 1) goto L72;
        if (r131 == 2) goto L72;
    L75:
        if (this.I == 2) goto L77;
    L82:
        this.E = null;
        if (E("childrenexpose") == false) goto L93;
        HashSet<String> r132 = this.F;
        if (r132 == null) goto L93;
        if (r132.contains("link") == false) goto L93;
        ArrayList<s> r133 = this.C.getLinks();
        this.E = new HashMap();
        Iterator<s> r134 = r133.iterator();
    L91:
        if (r134.hasNext() == false) goto L93;
        s r135 = r134.next();
        this.E.put(this.f382203b + "_link_" + r135.f505837c, r135);
    L93:
        this.S = this.f272671v.length();
        l r136 = new l();
        this.B = r136;
        r136.f505760a = this.C;
        r136.f505764e = new WeakReference(this);
        l r137 = this.B;
        r137.f505763d = this.D;
        r137.f505761b = this.I;
        r137.f505762c = this.f272663J;
        r137.f505767h = this.f272676y;
        r137.f505768i = this.E;
        r137.f505769j = this.f272674x;
        if (this.Q1 == false) goto L96;
        this.G1 = false;
        this.Q1 = false;
        this.H1 = 0;
    L96:
        r137.f505770k = true;
        LLog.i("MarkdownShadowNode", "measure layout complete: measuredWidth=" + r130 + ", measuredHeight=" + r109 + ", contentLength=" + this.S);
        TraceEvent.endSection("x-markdown.ShadowNode.layout");
        r108 = r130;
        goto L98
    L77:
        if (this.G < 0.0f) goto L82;
        this.P = this.C.getLineCount();
        if (this.R == false) goto L81;
        int r138 = F(this.f272663J);
        this.Q = r138;
        this.f272663J = G(r138);
        this.R = false;
        goto L82
    L81:
        this.Q = F(this.f272663J);
    L72:
        if (this.G < 0.0f) goto L75;
        this.O = this.C.getMaxTypewriterStep();
    L64:
        r126 = (float) (((double) r124) * 17.0d);
        goto L65
    L58:
        this.C.setStyle(null);
        goto L59
    L33:
        if (Float.compare(this.W, r102) != 0) goto L47;
        if (Float.compare(this.X, r105) != 0) goto L47;
        int r139 = 0;
        boolean r140 = false;
    L38:
        if (r139 >= l()) goto L46;
        ShadowNode r141 = k(r139);
        if ((r141 instanceof NativeLayoutNodeRef) == false) goto L45;
        if (r141.o() == false) goto L45;
        r141.f382206e = false;
        r140 = true;
    L45:
        r139 = r139 + 1;
        goto L38
    L46:
        if (r140 == true) goto L47;
    L98:
        if (this.B != null) goto L100;
    L204:
        LLog.d("MarkdownShadowNode", "measure result: width=" + r108 + ", height=" + r109);
        return new k(r108, r109);
    L100:
        if (this.f272672v1 == false) goto L112;
        boolean r142 = this.f272677y1;
        boolean r143 = !r142;
        if (r142 == true) goto L105;
        this.f272677y1 = true;
        h.b(this, "drawStart");
    L105:
        if (this.I != 0) goto L109;
        this.f272667k0 = this.Z;
        if (this.G1 == true) goto L203;
        h.b(this, "drawEnd");
        this.G1 = true;
    L203:
        r108 = this.Y;
        r109 = this.f272667k0;
        l r144 = this.B;
        r144.f505765f = r108;
        r144.f505766g = r109;
        r144.f505762c = this.f272663J;
        goto L204
    L109:
        long r145 = SystemClock.elapsedRealtime();
        D();
        J(r145, r143);
        if (r143 == false) goto L203;
        this.H1 = r145;
        int r146 = this.f272663J;
        this.L1 = r146;
        h.a(this, r146, this.O, this.S);
        LLog.i("MarkdownShadowNode", "measure first vsync frame: time=" + r145 + ", maxDrawHeight=" + this.f272667k0 + ", " + C());
        goto L203
    L112:
        boolean r147 = this.f272677y1;
        boolean r148 = !r147;
        if (r147 == true) goto L115;
        this.f272677y1 = true;
        h.b(this, "drawStart");
    L115:
        long r149 = SystemClock.elapsedRealtime();
        int r150 = this.I;
        if (r150 == 1) goto L118;
        if (r150 == 2) goto L118;
    L179:
        this.f272667k0 = this.Z;
        float r151 = 0.0f;
        r113 = true;
    L180:
        if (r113 == false) goto L191;
        float r152 = this.Z;
        if (r152 <= this.f272667k0) goto L185;
        this.f272667k0 = Math.min(r152, this.f272669p0);
    L185:
        if (this.G1 == false) goto L187;
    L189:
        r151 = this.f272667k0;
        goto L191
    L187:
        if (this.f272676y == false) goto L189;
        h.b(this, "drawEnd");
        this.G1 = true;
        LLog.i("MarkdownShadowNode", "animation complete: maxDrawHeight=" + this.f272667k0);
    L191:
        if (this.L > 0.0f) goto L193;
    L202:
        this.B.f505770k = true;
        goto L203
    L193:
        if (this.P1.a() == false) goto L196;
        this.P1.f272688f = r149;
    L196:
        if (Float.compare(r151, this.P1.f272684b) == 0) goto L201;
        if (r148 == true) goto L200;
        r104 = this.L;
    L200:
        b r153 = this.P1;
        r153.f272683a = r153.f272687e;
        r153.f272684b = r151;
        r153.f272685c = (long) (r104 * 1000.0f);
        r153.f272686d = r153.f272688f;
    L201:
        this.P1.update(r149);
        this.f272667k0 = this.P1.f272687e;
    L118:
        float r154 = this.G;
        if (r154 < 0.0f) goto L179;
        if (r154 <= 0.0f) goto L122;
        long r155 = (long) (1000.0d / ((double) r154));
    L124:
        if (this.N == true) goto L131;
        long r156 = this.H1;
        long r157 = r149 - r156;
        if (r157 < r155) goto L131;
        if (r156 != 0) goto L130;
        long r158 = 1;
    L133:
        if (r158 <= 0) goto L151;
        monitor-enter(this);
    L148:
        th = move-exception;
        throw th;
    L136:
        if (this.N == false) goto L138;
        r158 = 0;
    L144:
        monitor-exit(this);     // Catch: Throwable -> L148
        if (r158 <= 0) goto L151;
        LLog.d("MarkdownShadowNode", "animation advance: delta=" + r158 + ", timestamp=" + r149 + ", " + C());
        goto L151
    L138:
        if (this.I != 2) goto L140;
        int r159 = Math.min(this.Q + ((int) r158), this.P);     // Catch: Throwable -> L148
        this.Q = r159;     // Catch: Throwable -> L148
        this.f272663J = G(r159);     // Catch: Throwable -> L148
        goto L144
    L140:
        int r160 = (int) (((long) this.f272663J) + r158);     // Catch: Throwable -> L148
        this.f272663J = r160;     // Catch: Throwable -> L148
        int r161 = this.O;     // Catch: Throwable -> L148
        if (r160 <= r161) goto L144;
        this.f272663J = r161;     // Catch: Throwable -> L148
    L151:
        l r162 = this.B;
        int r163 = this.f272663J;
        r162.f505762c = r163;
        float[] r164 = this.C.findCursorPosition(r163, !this.f272676y);
        this.M1 = r164;
        int r165 = this.I;
        if (r165 != 2) goto L159;
        if (this.Q < this.P) goto L156;
    L160:
        r113 = true;
    L162:
        if (this.f272678z == false) goto L172;
        r151 = r164[3];
        this.f272667k0 = r151;
        float r166 = this.L;
        if (r166 > 0.0f) goto L166;
        r151 = 0.0f;
    L173:
        int r167 = this.L1;
        int r168 = this.f272663J;
        if (r167 == r168) goto L180;
        if (r113 == true) goto L178;
        r115 = r149;
    L178:
        this.H1 = r115;
        this.L1 = r168;
        h.a(this, r168, this.O, this.S);
        goto L180
    L166:
        if (this.M == false) goto L173;
        if (r165 != 2) goto L169;
        float[] r169 = this.C.findCursorPosition(G(Math.min(this.Q + (((int) (r166 * this.G)) + 1), this.P)), !this.f272676y);
    L170:
        r151 = r169[3];
        goto L173
    L169:
        r169 = this.C.findCursorPosition(this.f272663J + (((int) (r166 * this.G)) + 1), !this.f272676y);
        goto L170
    L172:
        r151 = this.Z;
        this.f272667k0 = r151;
        goto L173
    L156:
        if (this.f272663J < this.O) goto L162;
    L159:
        if (r164[2] <= 0.0f) goto L162;
    L130:
        r158 = r157 / r155;
    L131:
        r158 = 0;
        goto L133
    L122:
        r155 = Long.MAX_VALUE;
        goto L124
    L27:
        r114 = 0;
        goto L28
    L23:
        r109 = 0.0f;
        goto L24
    L19:
        r108 = 0.0f;
        goto L21
    L11:
        r102 = r110.f566410a;
        goto L12
    L5:
        if (this.f272675x1 == false) goto L7;
        MarkdownDocument.nativeSetDensity(r100.density, r100.widthPixels, r100.heightPixels);
        goto L8
    L7:
        TTTextUtils.SetDpi(r100.densityDpi);
        goto L8
    }

    @Override // y6a.e
    public final void d(y6a.b r100, y6a.a r101) {
        int r102 = 0;
    L4:
        if (r102 >= l()) goto L25;
        ShadowNode r103 = k(r102);
        if ((r103 instanceof NativeLayoutNodeRef) == false) goto L24;
        NativeLayoutNodeRef r104 = (NativeLayoutNodeRef) r103;
        String r105 = r104.f382216z;
        if (r105 != null) goto L11;
    L18:
        float[] r106 = null;
    L19:
        if (r106 != null) goto L21;
    L22:
        r106 = V1;
    L23:
        y6a.b r107 = new y6a.b();
        r107.f566403a = r106[0];
        r107.f566404b = r106[1];
        r104.C(r107);
        goto L24
    L21:
        if (r106.length >= 2) goto L23;
    L11:
        if (r105.isEmpty() == true) goto L18;
        if (this.C == null) goto L18;
        if (r105.equals(this.f272674x) == false) goto L17;
        r106 = this.M1;
        goto L19
    L17:
        r106 = this.C.getInlineViewOrigin(r105);
    L24:
        r102 = r102 + 1;
        goto L4
    }
}
