package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.exception.CurrentEditingException;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.UrlModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
public final class y extends o1<nlc.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a0.b<String> f457993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0.b<Long> f457994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a0.b<Long> f457995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a0.b<Long> f457996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Effect f457997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.ss.ugc.effectplatform.task.algorithm.f f457998i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.ss.ugc.effectplatform.task.algorithm.h f457999j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final blc.b f458000k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.ss.ugc.effectplatform.download.f f458001l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final EffectConfig f458002m;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ugc.effectplatform.task.o1
    public final void a() {
        this.f457887b = true;
        String r100 = this.f457993d.f1239a;
        if (r100 == null) goto L24;
        com.ss.ugc.effectplatform.a r101 = this.f458000k.f19534d;
        if (r101 == null) goto L25;
        Effect r102 = this.f457997h;
        boolean r103 = false;
        if (r102 != null) goto L9;
        boolean r104 = false;
    L10:
        if (r104 == true) goto L12;
    L14:
        if (r103 != true) goto L26;
        com.ss.ugc.effectplatform.download.f r105 = this.f458001l;
        if (r105 == null) goto L27;
        INetworkClient r106 = r105.f457374a;
        if ((r106 instanceof com.ss.ugc.effectplatform.bridge.network.b) == true) goto L20;
        r106 = null;
    L20:
        com.ss.ugc.effectplatform.bridge.network.b r107 = (com.ss.ugc.effectplatform.bridge.network.b) r106;
        if (r107 == null) goto L28;
        r107.cancel(r100);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L12:
        if (r101.f457228b == false) goto L14;
        r103 = true;
        goto L14
    L9:
        r104 = ArraysKt.contains(r101.f457231e, r102.getPanel());
        goto L10
    L25:
        return;
    }

    @Override // com.ss.ugc.effectplatform.task.o1
    public final void j() {
        this.f457888c = true;
        String r100 = this.f457993d.f1239a;
        if (r100 == null) goto L24;
        com.ss.ugc.effectplatform.a r101 = this.f458000k.f19534d;
        if (r101 == null) goto L25;
        Effect r102 = this.f457997h;
        boolean r103 = false;
        if (r102 != null) goto L9;
        boolean r104 = false;
    L10:
        if (r104 == true) goto L12;
    L14:
        if (r103 != true) goto L26;
        com.ss.ugc.effectplatform.download.f r105 = this.f458001l;
        if (r105 == null) goto L27;
        INetworkClient r106 = r105.f457374a;
        if ((r106 instanceof com.ss.ugc.effectplatform.bridge.network.b) == true) goto L20;
        r106 = null;
    L20:
        com.ss.ugc.effectplatform.bridge.network.b r107 = (com.ss.ugc.effectplatform.bridge.network.b) r106;
        if (r107 == null) goto L28;
        r107.pause(r100);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L12:
        if (r101.f457228b == false) goto L14;
        r103 = true;
        goto L14
    L9:
        r104 = ArraysKt.contains(r101.f457231e, r102.getPanel());
        goto L10
    L25:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v7, types: [V, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v14, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v13, types: [V, java.lang.Object] */
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
    @Override // com.ss.ugc.effectplatform.task.o1
    public final void b() {
        String r100 = com.ss.ugc.effectplatform.model.b.a(this.f457997h);
        if (r100 == null) goto L5;
        llc.a.b(r100, r100);
    L5:
        Logger r101 = Logger.INSTANCE;
        r101.w("JKL", "[流程][开始][" + this.f457997h.getName() + ']');
        com.ss.ugc.effectplatform.a r102 = this.f458000k.f19534d;
        String r110 = "download: ";
        String r103 = "EffectFetcherTask";
        String r111 = "editor in currently editing!";
        if (r102 == null) goto L143;
        Effect r112 = this.f457997h;
        if (r112 != null) goto L10;
        boolean r113 = false;
    L11:
        if (r113 == true) goto L13;
    L15:
        boolean r104 = false;
    L17:
        if (r104 != true) goto L142;
        int r210 = com.ss.ugc.effectplatform.util.r.f458047a;
        if (com.ss.ugc.effectplatform.util.r.b(this.f457997h.getZipPath()) == false) goto L21;
    L24:
        Effect r105 = this.f457997h;
        StringBuilder r114 = new StringBuilder();
        r114.append(this.f458000k.f19533c);
        String r115 = FileManager.f21782a;
        r114.append(r115);
        r114.append(this.f457997h.getId());
        r114.append(".zip");
        r105.setZipPath(r114.toString());
        this.f457997h.setUnzipPath(this.f458000k.f19533c + r115 + this.f457997h.getId());
    L26:
        if (this.f458002m.T == false) goto L44;
        StringBuilder r106 = new StringBuilder();
        r106.append(this.f458002m.f457164j);
        String r107 = FileManager.f21782a;
        r106.append(FileManager.f21782a);
        r106.append(this.f457997h.getId());
        String r108 = r106.toString();
        if (FileManager.d(r108) == false) goto L44;
        r101.w("JKL", "[预加载][读取][特效][检测到已有预加载资源!][" + this.f457997h.getId() + ']');
        this.f457997h.setUnzipPath(r108);
        com.ss.ugc.effectplatform.a r109 = this.f458000k.f19534d;
        if (r109 != null) goto L32;
    L36:
        l(this, new nlc.a(this.f457997h));
        com.ss.ugc.effectplatform.preload.b.a r116 = com.ss.ugc.effectplatform.preload.b.f457436d;
        Object r117 = this.f458002m.G;
        r116.getClass();
        com.ss.ugc.effectplatform.preload.b r118 = com.ss.ugc.effectplatform.preload.b.a.a(r117);
        if (r118 == null) goto L39;
        com.ss.ugc.effectplatform.preload.c r119 = r118.e(this.f457997h.getId());
    L40:
        if (r119 == null) goto L216;
        klc.a r120 = this.f458002m.f457176v.f1239a;
        if (r120 == null) goto L216;
        String r121 = r119.f457445f;
        String r122 = r119.f457441b;
        com.ss.ugc.effectplatform.util.i r123 = com.ss.ugc.effectplatform.util.i.f458038a;
        klc.b.l(r120, r121, r122, com.ss.ugc.effectplatform.util.i.f(r108) / ((long) 1024));
    L216:
        String r124 = com.ss.ugc.effectplatform.model.b.a(this.f457997h);
        if (r124 == null) goto L233;
        llc.a.a(r124, r124);
        return;
    L233:
        return;
    L39:
        r119 = null;
        goto L40
    L32:
        if (r109.a(this.f457997h) != true) goto L36;
        com.ss.ugc.effectplatform.task.algorithm.f r125 = this.f457998i;
        if (r125 == null) goto L36;
        r125.b(new EffectFetcherTask$executeImp2$1(this));
    L44:
        k();
        com.ss.ugc.effectplatform.repository.d r126 = this.f458002m.M;
        Effect r127 = this.f457997h;
        int r128 = com.ss.ugc.effectplatform.h.f457401a;
        Boolean r129 = Boolean.TRUE;
        r126.getClass();
        if (com.ss.ugc.effectplatform.repository.d.b(r127, false, r129) == false) goto L60;
        r101.d("EffectFetcherTask", "fetchEffect: " + this.f457997h.getEffect_id() + " name: " + this.f457997h.getName() + " already exists!");
        com.ss.ugc.effectplatform.a r130 = this.f458000k.f19534d;
        if (r130 != null) goto L49;
    L59:
        l(this, new nlc.a(this.f457997h));
        goto L216
    L49:
        if (r130.a(this.f457997h) != true) goto L59;
        com.ss.ugc.effectplatform.task.algorithm.f r131 = this.f457998i;
        if (r131 == null) goto L53;
        r131.b(new EffectFetcherTask$executeImp2$3(this));
    L53:
        com.ss.ugc.effectplatform.task.algorithm.h r132 = this.f457999j;
        if (r132 == null) goto L56;
        Exception r133 = r132.f457731a;
    L57:
        if (r133 == null) goto L59;
    L56:
        r133 = null;
        goto L57
    L60:
        i(this);
        r101.d("EffectFetcherTask", "download effect: " + this.f457997h.getEffect_id() + ", name: " + this.f457997h.getName() + ", uri: " + this.f457997h.getFile_url().getUri() + " start");
        Ref.ObjectRef r134 = new Ref.ObjectRef();
        r134.element = null;
        int r135 = com.ss.ugc.effectplatform.util.l.f458042a;
        if (com.ss.ugc.effectplatform.util.l.a(this.f458002m.G) == true) goto L63;
        d(this, new ExceptionResult(10011));
        goto L216
    L63:
        List<String> r136 = this.f458000k.f19532b;
        if (r136 != null) goto L66;
    L69:
        boolean r137 = true;
    L70:
        if (r137 == true) goto L141;
        com.ss.ugc.effectplatform.util.h r138 = com.ss.ugc.effectplatform.util.h.f458037a;
        UrlModel r139 = this.f457997h.getFile_url();
        r138.getClass();
        if (com.ss.ugc.effectplatform.util.h.c(r139) == true) goto L141;
        if (this.f457887b == false) goto L78;
        d(this, new ExceptionResult(10001, new Exception(String.valueOf(10001))));
        goto L216
    L78:
        if (this.f457888c == false) goto L80;
        d(this, new ExceptionResult(10019, new Exception(String.valueOf(10019))));
        goto L216
    L80:
        r103 = new ArrayList();
        r103.addAll(r136);
        ?? r140 = (String) ListProtector.remove(r103, 0);
        this.f457993d.f1239a = r140;     // Catch: Exception -> L129
        if (r140 == 0) goto L216;
        int r141 = b0.a.f16820a;     // Catch: Exception -> L129
        long r142 = System.currentTimeMillis();     // Catch: Exception -> L129
        r101.d("JKL", "[请求下载][特效][" + this.f457997h.getName() + ']');     // Catch: Exception -> L129
        com.ss.ugc.effectplatform.download.f r143 = this.f458001l;     // Catch: Exception -> L129
        if (r143 == 0) goto L86;
        NetResponse r144 = r143.b(r140, this.f457997h.getZipPath(), r103, this.f457997h.getName() + "-特效", new a0(this, r134));     // Catch: Exception -> L129
    L87:
        StringBuilder r145 = new StringBuilder("[下载成功][特效][");     // Catch: Exception -> L129
        r145.append(this.f457997h.getName());     // Catch: Exception -> L129
        r145.append("][耗时:");     // Catch: Exception -> L129
        r145.append(System.currentTimeMillis() - r142);     // Catch: Exception -> L129
        r145.append("][");     // Catch: Exception -> L129
        if (r144 == null) goto L90;
        Long r146 = Long.valueOf(r144.getContentLength());     // Catch: Exception -> L129
    L91:
        r145.append(r146);     // Catch: Exception -> L129
        r145.append(']');     // Catch: Exception -> L129
        r101.d("JKL", r145.toString());     // Catch: Exception -> L129
        com.ss.ugc.effectplatform.a r147 = this.f458000k.f19534d;     // Catch: Exception -> L129
        if (r147 == null) goto L221;
        if (r147.a(this.f457997h) != true) goto L221;
        com.ss.ugc.effectplatform.task.algorithm.f r148 = this.f457998i;     // Catch: Exception -> L129
        if (r148 == null) goto L98;
        r148.b(new EffectFetcherTask$executeImp2$4(this));     // Catch: Exception -> L129
    L98:
        com.ss.ugc.effectplatform.task.algorithm.h r149 = this.f457999j;     // Catch: Exception -> L129
        if (r149 == null) goto L101;
        Exception r150 = r149.f457731a;     // Catch: Exception -> L129
    L102:
        if (r150 == null) goto L221;
    L101:
        r150 = null;
    L221:
        if (this.f457888c == true) goto L125;
        if (r144 == null) goto L111;
        if (r144.getStatusCode() == 206) goto L125;
    L111:
        if (this.f457887b == true) goto L124;
        if (r144 != null) goto L114;
    L116:
        if (r144 != null) goto L118;
    L121:
        d(this, new ExceptionResult((Exception) r134.element));
        goto L216
    L118:
        if (r144.getStatusCode() != 200) goto L121;
        l(this, new nlc.a(this.f457997h));     // Catch: Exception -> L129
        goto L216
    L114:
        if (r144.getStatusCode() != 600) goto L116;
    L124:
        Logger.e$default(r101, "JKL", "[流程][结束][取消][" + this.f457997h.getName() + ']', null, 4, null);     // Catch: Exception -> L127
        c(this);     // Catch: Exception -> L127
    L220:
    L125:
        Logger.e$default(r101, "JKL", "[流程][结束][暂停][" + this.f457997h.getName() + ']', null, 4, null);     // Catch: Exception -> L127
        f(this);     // Catch: Exception -> L127
    L127:
        e = e;
    L131:
        Logger.INSTANCE.e(r103, "download: " + this.f457997h.getEffect_id() + ", name: " + this.f457997h.getName() + " failed", e);
        ExceptionResult r151 = new ExceptionResult(e);
        r151.setTrackParams(this.f457993d.f1239a, "", "");
        if ((e instanceof CurrentEditingException) == true) goto L139;
        com.ss.ugc.effectplatform.util.i r152 = com.ss.ugc.effectplatform.util.i.f458038a;
        String r153 = com.ss.ugc.effectplatform.util.i.g(this.f457997h.getZipPath());
        if (r153 == null) goto L140;
        com.ss.ugc.effectplatform.cache.j r154 = com.ss.ugc.effectplatform.cache.h.a(r153);
        if ((r154 instanceof com.ss.ugc.effectplatform.cache.i) == false) goto L138;
        ((com.ss.ugc.effectplatform.cache.i) r154).h(this.f457997h);
        goto L140
    L138:
        String r155 = FileManager.f21782a;
        FileManager.o(this.f457997h.getUnzipPath());
        FileManager.o(this.f457997h.getZipPath());
    L140:
        d(this, r151);
        goto L216
    L139:
        r151.setMsg(r111);
        goto L140
    L90:
        r146 = null;
        goto L91
    L86:
        r144 = null;
    L129:
        e = e;
        r103 = "EffectFetcherTask";
    L141:
        d(this, new ExceptionResult(10003));
        goto L216
    L66:
        if (r136.isEmpty() == true) goto L69;
        r137 = false;
        goto L70
    L21:
        if (com.ss.ugc.effectplatform.util.r.b(this.f457997h.getUnzipPath()) == false) goto L26;
    L142:
        String r156 = "";
        r110 = r110;
    L144:
        int r157 = com.ss.ugc.effectplatform.util.r.f458047a;
        if (com.ss.ugc.effectplatform.util.r.b(this.f457997h.getZipPath()) == false) goto L147;
    L150:
        Effect r158 = this.f457997h;
        StringBuilder r159 = new StringBuilder();
        r159.append(this.f458000k.f19533c);
        String r160 = FileManager.f21782a;
        r159.append(r160);
        r159.append(this.f457997h.getId());
        r159.append(".zip");
        r158.setZipPath(r159.toString());
        this.f457997h.setUnzipPath(this.f458000k.f19533c + r160 + this.f457997h.getId());
    L152:
        if (this.f458002m.T == false) goto L163;
        StringBuilder r161 = new StringBuilder();
        r161.append(this.f458002m.f457164j);
        String r162 = FileManager.f21782a;
        r161.append(FileManager.f21782a);
        r161.append(this.f457997h.getId());
        String r163 = r161.toString();
        if (FileManager.d(r163) == false) goto L163;
        r101.w("JKL", "[预加载][读取][特效][检测到已有预加载资源!][" + this.f457997h.getId() + ']');
        this.f457997h.setUnzipPath(r163);
        l(this, new nlc.a(this.f457997h));
        com.ss.ugc.effectplatform.preload.b.a r164 = com.ss.ugc.effectplatform.preload.b.f457436d;
        Object r165 = this.f458002m.G;
        r164.getClass();
        com.ss.ugc.effectplatform.preload.b r166 = com.ss.ugc.effectplatform.preload.b.a.a(r165);
        if (r166 == null) goto L158;
        com.ss.ugc.effectplatform.preload.c r167 = r166.e(this.f457997h.getId());
    L159:
        if (r167 == null) goto L216;
        klc.a r168 = this.f458002m.f457176v.f1239a;
        if (r168 == null) goto L216;
        String r169 = r167.f457445f;
        String r170 = r167.f457441b;
        com.ss.ugc.effectplatform.util.i r171 = com.ss.ugc.effectplatform.util.i.f458038a;
        klc.b.l(r168, r169, r170, com.ss.ugc.effectplatform.util.i.f(r163) / ((long) 1024));
        goto L216
    L158:
        r167 = null;
    L163:
        k();
        com.ss.ugc.effectplatform.repository.d r172 = this.f458002m.M;
        Effect r173 = this.f457997h;
        int r174 = com.ss.ugc.effectplatform.h.f457401a;
        Boolean r175 = Boolean.TRUE;
        r172.getClass();
        if (com.ss.ugc.effectplatform.repository.d.b(r173, false, r175) == false) goto L166;
        r101.d("EffectFetcherTask", "fetchEffect: " + this.f457997h.getEffect_id() + " name: " + this.f457997h.getName() + " already exists!");
        l(this, new nlc.a(this.f457997h));
        goto L216
    L166:
        i(this);
        r101.d(r103, "download effect: " + this.f457997h.getEffect_id() + ", name: " + this.f457997h.getName() + ", uri: " + this.f457997h.getFile_url().getUri() + " start");
        Ref.ObjectRef r176 = new Ref.ObjectRef();
        r176.element = null;
        int r177 = com.ss.ugc.effectplatform.util.l.f458042a;
        if (com.ss.ugc.effectplatform.util.l.a(this.f458002m.G) == true) goto L169;
        d(this, new ExceptionResult(10011));
        goto L216
    L169:
        List<String> r178 = this.f458000k.f19532b;
        List<String> r179 = r178;
        if (r179 != null) goto L172;
    L175:
        boolean r180 = true;
    L176:
        if (r180 == true) goto L215;
        com.ss.ugc.effectplatform.util.h r181 = com.ss.ugc.effectplatform.util.h.f458037a;
        UrlModel r182 = this.f457997h.getFile_url();
        r181.getClass();
        if (com.ss.ugc.effectplatform.util.h.c(r182) == true) goto L215;
        int r183 = r179.size();
        int r184 = 0;
    L181:
        if (r184 >= r183) goto L214;
        if (this.f457887b == true) goto L184;
        this.f457993d.f1239a = ListProtector.get(r178, r184);     // Catch: Exception -> L197
        String r185 = this.f457993d.f1239a;     // Catch: Exception -> L197
        if (r185 == null) goto L214;
        com.ss.ugc.effectplatform.download.f r186 = this.f458001l;     // Catch: Exception -> L197
        if (r186 == null) goto L191;
        Long r187 = Long.valueOf(r186.a(r185, new z(this, r176)));     // Catch: Exception -> L197
    L192:
        if (r187 != null) goto L194;
    L199:
        String r188 = r110;
    L213:
        r184 = r184 + 1;
        r156 = r156;
        r110 = r188;
        r111 = r111;
        goto L181
    L194:
        if (r187.longValue() <= 0) goto L199;
        l(this, new nlc.a(this.f457997h));     // Catch: Exception -> L197
        goto L216
    L191:
        r187 = null;
    L197:
        e = move-exception;
        r188 = r110;
        Logger.INSTANCE.e(r103, r188 + this.f457997h.getEffect_id() + ", name: " + this.f457997h.getName() + " failed, count: " + r184, e);
        if (r184 != (r178.size() - 1)) goto L213;
        ExceptionResult r189 = new ExceptionResult(e);
        String r190 = r156;
        r189.setTrackParams(this.f457993d.f1239a, r190, r190);
        if ((e instanceof CurrentEditingException) == true) goto L210;
        com.ss.ugc.effectplatform.util.i r191 = com.ss.ugc.effectplatform.util.i.f458038a;
        String r192 = com.ss.ugc.effectplatform.util.i.g(this.f457997h.getZipPath());
        if (r192 == null) goto L211;
        com.ss.ugc.effectplatform.cache.j r193 = com.ss.ugc.effectplatform.cache.h.a(r192);
        if ((r193 instanceof com.ss.ugc.effectplatform.cache.i) == false) goto L209;
        ((com.ss.ugc.effectplatform.cache.i) r193).h(this.f457997h);
        goto L211
    L209:
        String r194 = FileManager.f21782a;
        FileManager.o(this.f457997h.getUnzipPath());
        FileManager.o(this.f457997h.getZipPath());
    L211:
        d(this, r189);
        goto L216
    L210:
        r189.setMsg(r111);
        goto L211
    L184:
        d(this, new ExceptionResult(10001, new Exception(String.valueOf(10001))));
    L214:
        d(this, new ExceptionResult((Exception) r176.element));
    L215:
        d(this, new ExceptionResult(10003));
        goto L216
    L172:
        if (r179.isEmpty() == true) goto L175;
        r180 = false;
        goto L176
    L147:
        if (com.ss.ugc.effectplatform.util.r.b(this.f457997h.getUnzipPath()) == false) goto L152;
    L13:
        if (r102.f457228b == false) goto L15;
        r104 = true;
        goto L17
    L10:
        r113 = ArraysKt.contains(r102.f457231e, r112.getPanel());
        goto L11
    L143:
        r156 = "";
        goto L144
    }

    public final void k() {
        EffectConfig r100 = this.f458002m;
        if (r100.f457155b0 == true) goto L5;
        return;
    L5:
        Object r101 = r100.G;
        if (r101 == null) goto L8;
        com.ss.ugc.effectplatform.cache.l.f457359c.getClass();
        com.ss.ugc.effectplatform.cache.l r102 = com.ss.ugc.effectplatform.cache.l.a.a(r101);
    L9:
        if (r102 == null) goto L12;
        new com.ss.ugc.effectplatform.cache.k(this.f457997h);
        return;
    L12:
        return;
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.ss.ugc.effectplatform.task.o1
    public final void d(o1<nlc.a> r110, ExceptionResult r111) {
        Logger.e$default(Logger.INSTANCE, "JKL", "[流程][结束][失败][特效][" + this.f457997h.getName() + "][" + this.f457997h.getEffect_id() + "][错误码：" + r111.getErrorCode() + "][错误信息：" + r111.getMsg() + ']', null, 4, null);
        super.d(r110, r111);
        Effect r112 = this.f457997h;
        if (r111.getErrorCode() != 10001) goto L5;
    L14:
        boolean r113 = false;
    L15:
        if (r113 == false) goto L28;
        EffectConfig r100 = this.f458002m;
        klc.a r101 = r100.f457176v.f1239a;
        if (r101 == null) goto L29;
        Effect r102 = this.f457997h;
        Pair[] r114 = new Pair[2];
        r114[0] = TuplesKt.to("error_code", Integer.valueOf(r111.getErrorCode()));
        String r103 = this.f457993d.f1239a;
        if (r103 != null) goto L22;
        r103 = "";
    L22:
        r114[1] = TuplesKt.to("download_url", r103);
        Map r104 = MapsKt.mapOf(r114);
        String r115 = r111.getMsg();
        if (r115 == null) goto L25;
        String r105 = r115;
    L26:
        klc.b.d(r101, false, r100, r102, r104, r105);
        return;
    L25:
        r105 = "";
        goto L26
    L29:
        return;
    L28:
        return;
    L5:
        if (r111.getErrorCode() == 10019) goto L14;
        if (r112 != null) goto L9;
    L13:
        r113 = true;
        goto L15
    L9:
        if (r111.getErrorCode() != 10003) goto L13;
        if (r112.getEffect_type() != 1) goto L13;
        goto L13
    }

    public final void l(o1<nlc.a> r100, nlc.a r101) {
        h(r100, r101);
        Logger.INSTANCE.w("JKL", "[流程][结束][成功][" + this.f457997h.getName() + "][" + this.f457997h.getEffect_id() + ']');
        EffectConfig r102 = this.f458002m;
        klc.a r103 = r102.f457176v.f1239a;
        if (r103 == null) goto L10;
        Effect r104 = this.f457997h;
        Pair[] r105 = new Pair[4];
        r105[0] = TuplesKt.to("duration", this.f457994e.f1239a);
        r105[1] = TuplesKt.to(MobConstants.UNZIP_TIME, this.f457995f.f1239a);
        r105[2] = TuplesKt.to("size", this.f457996g.f1239a);
        String r106 = this.f457993d.f1239a;
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        r105[3] = TuplesKt.to("download_url", r106);
        klc.b.d(r103, true, r102, r104, MapsKt.mapOf(r105), "");
        return;
    }

    public y(blc.b r100, com.ss.ugc.effectplatform.download.f r101, EffectConfig r102) {
        this.f458000k = r100;
        this.f458001l = r101;
        this.f458002m = r102;
        this.f457993d = new a0.b(null);
        this.f457994e = new a0.b(0L);
        this.f457995f = new a0.b(0L);
        this.f457996g = new a0.b(0L);
        this.f457997h = r100.f19531a;
    }
}
