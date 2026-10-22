package com.ss.ugc.effectplatform.task;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import com.ss.ugc.effectplatform.model.net.PreloadResourceList;
import com.ss.ugc.effectplatform.preload.DownloadType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b1 extends BaseTask {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.ugc.effectplatform.preload.d f457734g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a0.b<String> f457735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final EffectConfig f457736i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PreloadResourceList f457737j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f457738k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f457739l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.ss.ugc.effectplatform.preload.e f457740m;

    public static final class a {
    }

    public static final class b implements com.ss.ugc.effectplatform.download.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b1 f457741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.ugc.effectplatform.preload.c f457742b;

        public b(b1 r100, com.ss.ugc.effectplatform.preload.c r101) {
            this.f457741a = r100;
            this.f457742b = r101;
        }

        @Override // com.ss.ugc.effectplatform.download.k
        public final String a(com.ss.ugc.effectplatform.download.d r100, long r101, com.ss.ugc.effectplatform.download.e r102) {
            com.ss.ugc.effectplatform.preload.b.a r103 = com.ss.ugc.effectplatform.preload.b.f457436d;
            Object r104 = this.f457741a.f457736i.G;
            r103.getClass();
            com.ss.ugc.effectplatform.preload.b r105 = com.ss.ugc.effectplatform.preload.b.a.a(r104);
            if (r105 == null) goto L7;
            r105.d(this.f457742b);
            return "";
        L7:
            return "";
        }
    }

    public static final class c implements com.ss.ugc.effectplatform.bridge.network.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b1 f457743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f457744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f457745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f457746d;

        @Override // com.ss.ugc.effectplatform.bridge.network.a
        public final void onProgress(int r100, long r101) {
        }

        public final void a(com.ss.ugc.effectplatform.download.g r110) {
            boolean r100 = true;
            String r101 = null;
            if (r110.a() == false) goto L17;
            Logger.INSTANCE.d("JKL", "[预加载][文件下载][成功][" + this.f457744b + ']');
            com.ss.ugc.effectplatform.preload.e r102 = this.f457743a.f457740m;
            String r103 = this.f457745c;
            long r104 = r110.f457388e / ((long) 1024);
            ((ArrayList) r102.f457456c).add(r103);
            r102.f457455b += r104;
            c0.b r105 = r102.f457457d;
            if (r105 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("countDown");
        L8:
            if (r105.a() == 0) goto L11;
            r100 = false;
        L11:
            if (r100 == false) goto L13;
            r102.a();
        L13:
            z.d<b1> r106 = com.ss.ugc.effectplatform.preload.h.f457465a;
            com.ss.ugc.effectplatform.preload.h.f457465a.remove(this.f457743a);
            b1 r107 = this.f457743a;
            boolean r108 = r110.a();
            Exception r111 = r110.f457389f;
            if (r111 == null) goto L16;
            r101 = r111.getMessage();
        L16:
            r107.f(r108, r101, this.f457745c, this.f457746d);
        L39:
            ConcurrentHashMap<String, Pair<c0.b, Object>> r112 = llc.a.f509807a;
            String r113 = this.f457746d;
            llc.a.a(r113, r113);
            return;
        L17:
            long r109 = r110.f457388e;
            if (r109 != (-2)) goto L21;
            Logger.INSTANCE.w("JKL", "[预加载][文件下载][暂停][" + this.f457744b + ']');
            goto L39
        L21:
            if (r109 != (-3)) goto L23;
            Logger.INSTANCE.w("JKL", "[预加载][文件下载][取消][" + this.f457744b + ']');
            goto L39
        L23:
            com.ss.ugc.effectplatform.preload.e r114 = this.f457743a.f457740m;
            c0.b r115 = r114.f457457d;
            if (r115 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("countDown");
        L27:
            if (r115.a() == 0) goto L30;
            r100 = false;
        L30:
            if (r100 == false) goto L32;
            r114.a();
        L32:
            Logger.e$default(Logger.INSTANCE, "JKL", "[预加载][文件下载][失败][" + this.f457744b + ']', null, 4, null);
            Exception r116 = r110.f457389f;
            if (r116 == null) goto L35;
            r116.printStackTrace();
        L35:
            z.d<b1> r117 = com.ss.ugc.effectplatform.preload.h.f457465a;
            com.ss.ugc.effectplatform.preload.h.f457465a.remove(this.f457743a);
            b1 r118 = this.f457743a;
            boolean r119 = r110.a();
            Exception r120 = r110.f457389f;
            if (r120 == null) goto L38;
            r101 = r120.getMessage();
        L38:
            r118.f(r119, r101, this.f457745c, this.f457746d);
            goto L39
        }

        public c(b1 r100, String r101, String r102, String r103) {
            this.f457743a = r100;
            this.f457744b = r101;
            this.f457745c = r102;
            this.f457746d = r103;
        }
    }

    static {
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [V, java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void a() {
        if (this.f457532b == false) goto L5;
        return;
    L5:
        String r110 = this.f457737j.getKey();
        String r111 = this.f457737j.getUri();
        String r100 = this.f457737j.getType();
        String r101 = this.f457737j.getVersion();
        String r112 = "";
        if (r101 == null) goto L8;
        String r113 = r101;
    L9:
        String r102 = this.f457737j.getName();
        int r103 = b0.a.f16820a;
        long r210 = System.currentTimeMillis();
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = this.f457737j.getCdn_prefix_list().iterator();
    L11:
        if (r105.hasNext() == false) goto L14;
        r104.add(((String) r105.next()) + r111);
        goto L11
    L14:
        if (r104.isEmpty() == false) goto L16;
        return;
    L16:
        boolean r211 = Intrinsics.areEqual(this.f457737j.getBlock_file_type(), "zip");
        boolean r212 = Intrinsics.areEqual(r100, "algorithm_resource");
        if (r212 == true) goto L100;
        com.ss.ugc.effectplatform.cache.disklrucache.a.f457283w.getClass();
        String r106 = com.ss.ugc.effectplatform.cache.disklrucache.a.C5470a.c(r111);
    L28:
        String r114 = r106;
        com.ss.ugc.effectplatform.preload.c r115 = new com.ss.ugc.effectplatform.preload.c(r114, r110, r111, r102, r210, this.f457738k);
        EffectConfig r107 = this.f457736i;
        if (r212 == false) goto L31;
        String r108 = r107.f457165k;
    L32:
        StringBuilder r109 = new StringBuilder();
        r109.append(r108);
        String r116 = FileManager.f21782a;
        String r117 = FileManager.f21782a;
        r109.append(r117);
        r109.append(r114);
        if (FileManager.d(r109.toString()) == false) goto L36;
        Logger.INSTANCE.d("JKL", "[预加载][文件下载][默认缓存路径下，文件已存在，不重复下载][" + r114 + ']');
        return;
    L36:
        String r118 = this.f457736i.f457164j + r117 + r114;
        boolean r119 = true;
        if (FileManager.d(r118) == false) goto L56;
        com.ss.ugc.effectplatform.preload.b.a r120 = com.ss.ugc.effectplatform.preload.b.f457436d;
        Object r121 = this.f457736i.G;
        r120.getClass();
        com.ss.ugc.effectplatform.preload.b r122 = com.ss.ugc.effectplatform.preload.b.a.a(r121);
        if (r122 == null) goto L56;
        SQLiteDatabase r123 = r122.f457437a;     // Catch: Exception -> L50
        if (r123 == null) goto L52;
        Cursor r124 = r123.rawQuery("select * from preload_table where file_name=?", new String[]{r114});     // Catch: Exception -> L50
        if (r124 == null) goto L52;
        if (r124.getCount() <= 0) goto L47;
        boolean r125 = true;
    L48:
        r124.close();     // Catch: Exception -> L50
    L53:
        if (r125 != true) goto L56;
        Logger.INSTANCE.d("JKL", "[预加载][文件下载][文件已存在，不重复下载][" + r114 + ']');
        return;
    L47:
        r125 = false;
    L52:
        r125 = false;
    L50:
        e = move-exception;
        e.printStackTrace();
    L56:
        com.ss.ugc.effectplatform.preload.d.a r126 = new com.ss.ugc.effectplatform.preload.d.a();
        INetworkClient r127 = this.f457736i.f457175u.f1239a;
        if (r127 == null) goto L59;
        r126.f457451b = r127;
    L59:
        StringBuilder r128 = new StringBuilder();
        r128.append(r118);
        if (r211 == false) goto L62;
        r112 = ".zip";
    L62:
        r128.append(r112);
        String r213 = r128.toString();
        if (r212 == false) goto L65;
        DownloadType r129 = DownloadType.ALGORITHM;
    L66:
        r126.f457452c = r129;
        if (r211 == false) goto L69;
        r126.f457453d = new com.ss.ugc.effectplatform.preload.i(this.f457736i, r118);
    L69:
        r126.f457450a = new b(this, r115);
        if (r126.f457451b == null) goto L97;
        INetworkClient r130 = r126.f457451b;
        if (r130 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("networkClient");
    L74:
        com.ss.ugc.effectplatform.download.k r131 = r126.f457450a;
        if (r131 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("writeDisk");
    L77:
        this.f457734g = new com.ss.ugc.effectplatform.preload.d(r130, r131, r126.f457453d, r126.f457452c);
        ?? r132 = (String) ListProtector.remove(r104, 0);
        this.f457735h.f1239a = r132;
        if (r132 == 0) goto L105;
        llc.a.b(r111, r111);
        com.ss.ugc.effectplatform.preload.d r133 = this.f457734g;     // Catch: Exception -> L84
        if (r133 == 0) goto L106;
        r133.a(r132, r213, r104, this.f457739l, r114, new c(this, r114, r110, r111));     // Catch: Exception -> L84
        return;
    L106:
        return;
    L84:
        e = move-exception;
        e.printStackTrace();
        com.ss.ugc.effectplatform.preload.e r134 = this.f457740m;
        c0.b r135 = r134.f457457d;
        if (r135 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("countDown");
    L89:
        if (r135.a() == 0) goto L92;
        r119 = false;
    L92:
        if (r119 == false) goto L94;
        r134.a();
    L94:
        Logger.e$default(Logger.INSTANCE, "JKL", "[预加载][文件下载][失败][" + r114 + "][" + bytekn.foundation.utils.b.a(e, 5) + ']', null, 4, null);
        com.ss.ugc.effectplatform.preload.h.f457465a.remove(this);
        f(false, e.getMessage(), r110, r111);
        llc.a.a(r111, r111);
        return;
    L105:
        return;
    L97:
        throw new IllegalArgumentException("networkClient is required to setup!");
    L65:
        r129 = DownloadType.EFFECT;
        goto L66
    L31:
        r108 = r107.f457163i;
        goto L32
    L100:
        String r136 = this.f457737j.getLevel();     // Catch: Exception -> L24
        if (r136 == null) goto L22;
        int r137 = CastIntegerProtector.parseInt(r136);     // Catch: Exception -> L24
    L23:
        int r214 = r137;
    L26:
        String r138 = com.ss.ugc.effectplatform.util.k.a(new ModelInfo(r102, null, r113, new ExtendedUrlModel(null, r111, null, 5, null), 0, r214, 0, 82, null));
        com.ss.ugc.effectplatform.cache.disklrucache.a.f457283w.getClass();
        r106 = com.ss.ugc.effectplatform.cache.disklrucache.a.C5470a.c(r138);
        goto L28
    L22:
        r137 = 0;
    L24:
        e = move-exception;
        e.printStackTrace();
        r214 = 0;
        goto L26
    L8:
        r113 = "";
        goto L9
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask, e0.c
    public final void pause() {
        super.pause();
        if (this.f457534d == false) goto L15;
        String r100 = this.f457735h.f1239a;
        if (r100 == null) goto L16;
        com.ss.ugc.effectplatform.preload.d r101 = this.f457734g;
        if (r101 == null) goto L17;
        INetworkClient r102 = r101.f457446a;
        if ((r102 instanceof com.ss.ugc.effectplatform.bridge.network.b) == true) goto L11;
        r102 = null;
    L11:
        com.ss.ugc.effectplatform.bridge.network.b r103 = (com.ss.ugc.effectplatform.bridge.network.b) r102;
        if (r103 == null) goto L18;
        r103.pause(r100);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void f(boolean r100, String r101, String r102, String r103) {
        klc.a r104 = this.f457736i.f457176v.f1239a;
        if (r104 == null) goto L10;
        Pair[] r105 = new Pair[4];
        r105[0] = TuplesKt.to("key", r102);
        r105[1] = TuplesKt.to("uri", r103);
        r105[2] = TuplesKt.to("block_uri", "");
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r105[3] = TuplesKt.to(LocationMonitorConst.ERR_MSG, r101);
        Map<String, ? extends Object> r106 = MapsKt.mutableMapOf(r105);
        r104.monitorStatusRate("preload_resource_success_rate", !r100 ? 1 : 0, r106);
        return;
    }

    public b1(EffectConfig r100, PreloadResourceList r101, String r102, long r103, String r104, com.ss.ugc.effectplatform.preload.e r105) {
        super(r104, null);
        this.f457736i = r100;
        this.f457737j = r101;
        this.f457738k = r102;
        this.f457739l = r103;
        this.f457740m = r105;
        this.f457735h = new a0.b(null);
    }
}
