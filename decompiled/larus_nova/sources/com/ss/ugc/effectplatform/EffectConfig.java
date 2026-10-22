package com.ss.ugc.effectplatform;

import bytekn.foundation.concurrent.executor.AsyncExecutor;
import bytekn.foundation.io.file.FileManager;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.model.algorithm.FetchModelType;
import com.ss.ugc.effectplatform.task.q1;
import faceverify.q;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class EffectConfig {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final /* synthetic */ int f457150d0 = 0;
    public final a0.b<com.ss.ugc.effectplatform.cache.j> A;
    public final String B;
    public final String C;
    public q1 D;
    public final String E;
    public List<String> F;
    public final Object G;
    public final FetchModelType H;
    public final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ModelFileEnv f457151J;
    public final String K;
    public final long L;
    public final com.ss.ugc.effectplatform.repository.d M;
    public final hlc.a N;
    public final Integer O;
    public final boolean P;
    public final String Q;
    public final boolean R;
    public final String[] S;
    public final boolean T;
    public final boolean U;
    public final boolean V;
    public final int W;
    public final boolean X;
    public final boolean Y;
    public final boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f457152a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final boolean f457153a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f457154b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final boolean f457155b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f457156c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final boolean f457157c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f457158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f457159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f457160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f457161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f457162h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f457163i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f457164j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f457165k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f457166l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f457167m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f457168n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashMap<String, String> f457169o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f457170p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f457171q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f457172r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f457173s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final dlc.a f457174t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a0.b<INetworkClient> f457175u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a0.b<klc.a> f457176v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a0.b<clc.a> f457177w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final bytekn.foundation.concurrent.executor.a f457178x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f457179y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final a0.b<blc.a> f457180z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/ugc/effectplatform/EffectConfig$Builder;", "", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
    public static class Builder {
        public List<String> A;
        public Object B;
        public FetchModelType C;
        public String D;
        public ModelFileEnv E;
        public Integer F;
        public long G;
        public boolean H;
        public String I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f457181J;
        public boolean K;
        public String[] L;
        public boolean M;
        public boolean N;
        public boolean O;
        public boolean P;
        public boolean Q;
        public boolean R;
        public boolean S;
        public boolean T;
        public int U;
        public boolean V;
        public boolean W;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f457182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f457183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f457184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f457185d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f457186e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f457187f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public INetworkClient f457188g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public dlc.a f457189h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f457190i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f457191j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f457192k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f457193l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f457194m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f457195n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f457196o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f457197p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f457198q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public bytekn.foundation.concurrent.executor.a f457199r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public blc.a f457200s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public klc.a f457201t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public String f457202u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f457203v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final HashMap<String, String> f457204w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f457205x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f457206y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f457207z;

        public Builder() {
            this.f457196o = 1;
            this.f457197p = 3;
            this.f457204w = new HashMap();
            this.f457207z = true;
            this.C = FetchModelType.ORIGIN;
            this.G = 838860800;
            this.I = "";
            this.f457181J = 5;
            this.L = new String[0];
            this.R = true;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/ugc/effectplatform/EffectConfig$ModelFileEnv;", "", FlowDoraWifiScene.TEST, "ONLINE", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
    public static final enum ModelFileEnv extends Enum<ModelFileEnv> {
        public static final ModelFileEnv ONLINE = null;
        public static final ModelFileEnv TEST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ModelFileEnv[] f457208a = null;

        static {
            ModelFileEnv r100 = new ModelFileEnv(FlowDoraWifiScene.TEST, 0);
            TEST = r100;
            ModelFileEnv r101 = new ModelFileEnv("ONLINE", 1);
            ONLINE = r101;
            f457208a = new ModelFileEnv[]{r100, r101};
        }

        public static ModelFileEnv valueOf(String r100) {
            return (ModelFileEnv) r27.a.a(ModelFileEnv.class, r100);
        }

        public static ModelFileEnv[] values() {
            return (ModelFileEnv[]) f457208a.clone();
        }

        public ModelFileEnv(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    /* JADX INFO: loaded from: classes36.dex */
    public interface b {
    }

    /* JADX INFO: loaded from: classes36.dex */
    public interface c {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [V, klc.a] */
    /* JADX WARN: Type inference failed for: r4v21, types: [V, llc.d] */
    public EffectConfig(Builder r110) {
        this.f457152a = r110.f457182a;
        this.f457154b = r110.f457183b;
        this.f457156c = r110.f457184c;
        this.f457158d = r110.f457185d;
        String r100 = r110.f457190i;
        if (r100 != null) goto L6;
        r100 = "online";
    L6:
        this.f457159e = r100;
        String r101 = r110.f457191j;
        if (r101 != null) goto L9;
        r101 = "android";
    L9:
        this.f457160f = r101;
        this.f457161g = r110.f457192k;
        this.f457162h = r110.f457193l;
        String r102 = r110.f457194m;
        if (r102 == null) goto L12;
        String r103 = r102;
    L13:
        this.f457163i = r103;
        if (r102 != null) goto L17;
        r102 = "";
    L17:
        this.f457164j = r102;
        String r104 = r110.f457195n;
        if (r104 != null) goto L21;
        r104 = "";
    L21:
        this.f457165k = r104;
        this.f457166l = r110.f457186e;
        String r105 = r110.f457187f;
        if (r105 != null) goto L24;
        r105 = "0";
    L24:
        this.f457167m = r105;
        this.f457168n = r110.f457198q;
        this.f457169o = r110.f457204w;
        this.f457170p = r110.f457207z;
        this.f457171q = r110.f457196o;
        this.f457172r = r110.f457197p;
        this.f457173s = r110.f457205x;
        dlc.a r106 = r110.f457189h;
        if (r106 != null) goto L28;
        r106 = null;
    L28:
        this.f457174t = r106;
        a0.b<INetworkClient> r107 = new a0.b(null);
        this.f457175u = r107;
        a0.b<klc.a> r108 = new a0.b(null);
        this.f457176v = r108;
        this.f457177w = new a0.b(null);
        bytekn.foundation.concurrent.executor.a r109 = r110.f457199r;
        if (r109 != null) goto L32;
        r109 = new AsyncExecutor();
    L32:
        this.f457178x = r109;
        int r111 = r110.f457181J;
        this.f457179y = r111;
        a0.b<blc.a> r112 = new a0.b(null);
        this.f457180z = r112;
        a0.b<com.ss.ugc.effectplatform.cache.j> r113 = new a0.b(null);
        this.A = r113;
        this.B = r110.f457203v;
        this.C = r110.f457202u;
        q1.a r114 = new q1.a();
        r114.f457918b = r111;
        r114.f457917a = r109;
        this.D = r114.a();
        this.E = r110.f457206y;
        this.F = r110.A;
        this.G = r110.B;
        this.H = r110.C;
        this.I = r110.D;
        this.f457151J = r110.E;
        String r115 = r110.f457195n;
        if (r115 != null) goto L36;
        r115 = r103 + FileManager.f21782a + q.KEY_ALGORITHM_CONFIG;
    L36:
        this.K = r115;
        this.L = r110.G;
        this.M = com.ss.ugc.effectplatform.repository.d.f457497c;
        this.N = new hlc.a();
        this.O = r110.F;
        this.P = r110.H;
        String r116 = r110.f457183b;
        boolean r117 = false;
        if (r110.I.length() != 0) goto L39;
        boolean r118 = true;
    L40:
        if (r118 == false) goto L49;
        if (r116 != null) goto L43;
    L46:
        boolean r119 = true;
    L47:
        if (r119 == true) goto L49;
    L50:
        this.Q = r116;
        this.R = r110.K;
        this.S = r110.L;
        this.T = r110.M;
        this.U = r110.N;
        this.V = r110.O;
        this.W = r110.U;
        this.X = r110.Q;
        this.Y = r110.R;
        this.Z = r110.S;
        this.f457153a0 = r110.T;
        this.f457155b0 = r110.V;
        this.f457157c0 = r110.W;
        Object r120 = r110.B;
        if (r120 != null) goto L53;
    L78:
        String r121 = r110.f457194m;
        if (r121 != null) goto L82;
        r121 = r110.f457195n;
    L82:
        com.ss.ugc.effectplatform.util.i r122 = com.ss.ugc.effectplatform.util.i.f458038a;
        String r123 = com.ss.ugc.effectplatform.util.i.g(r121);
        if (r123 != null) goto L85;
    L90:
        String r124 = com.ss.ugc.effectplatform.util.i.g(r121);
        if (r124 != null) goto L93;
    L98:
        blc.a r125 = r110.f457200s;
        V r126 = r125;
        if (r125 != null) goto L102;
        r126 = new blc.c(this);
    L102:
        r112.f1239a = r126;
        r108.f1239a = r110.f457201t;
        r113.f1239a = null;
        boolean r127 = com.ss.ugc.effectplatform.util.k.f458040a;
        boolean r128 = r110.O;
        if (com.ss.ugc.effectplatform.util.k.f458040a == true) goto L107;
        if (r128 == true) goto L107;
        boolean r129 = false;
    L108:
        com.ss.ugc.effectplatform.util.k.f458040a = r129;
        com.ss.ugc.effectplatform.task.algorithm.b r130 = com.ss.ugc.effectplatform.task.algorithm.a.f457708a;
        boolean r131 = r110.P;
        if (com.ss.ugc.effectplatform.task.algorithm.a.f457710c == true) goto L111;
        if (r131 == true) goto L111;
    L112:
        com.ss.ugc.effectplatform.task.algorithm.a.f457710c = r117;
        return;
    L111:
        r117 = true;
    L107:
        r129 = true;
        goto L108
    L93:
        if (r124.length() <= 0) goto L95;
        boolean r132 = true;
    L96:
        if (r132 != true) goto L98;
        this.f457165k = com.ss.ugc.effectplatform.util.i.g(r121) + FileManager.f21782a + "effectmodel";
        goto L98
    L95:
        r132 = false;
        goto L96
    L85:
        if (r123.length() <= 0) goto L87;
        boolean r133 = true;
    L88:
        if (r133 != true) goto L90;
        this.f457164j = com.ss.ugc.effectplatform.util.i.g(r121) + FileManager.f21782a + "effectpreload";
        goto L90
    L87:
        r133 = false;
        goto L88
    L53:
        if (r110.f457188g == null) goto L78;
        llc.b.a r134 = llc.b.f509810g;
        if (r120 != null) goto L57;
        Intrinsics.throwNpe();
    L57:
        r134.getClass();
        if (llc.b.f509809f != null) goto L70;
        Object r135 = llc.b.f509808e;
        monitor-enter(r135);
    L67:
        th = move-exception;
        throw th;
    L62:
        if (llc.b.f509809f != null) goto L64;
        llc.b.f509809f = new llc.b(r120);     // Catch: Throwable -> L67
    L64:
        Unit r136 = Unit.INSTANCE;     // Catch: Throwable -> L67
        monitor-exit(r135);
    L70:
        llc.b r137 = llc.b.f509809f;
        if (r137 != null) goto L74;
        r137 = new llc.b(r120);
    L74:
        INetworkClient r138 = r110.f457188g;
        if (r138 != null) goto L77;
        Intrinsics.throwNpe();
    L77:
        r107.f1239a = new llc.d(r137, r138);
        goto L78
    L43:
        if (r116.length() == 0) goto L46;
        r119 = false;
    L49:
        r116 = r110.I;
        goto L50
    L39:
        r118 = false;
        goto L40
    L12:
        r103 = "";
        goto L13
    }
}
