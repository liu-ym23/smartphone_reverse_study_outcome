package com.bytedance.gkfs;

import android.app.Application;
import android.content.Context;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.gkfs.cdc.Chunker;
import com.bytedance.gkfs.cdc.GkFSByteBuffer;
import com.bytedance.gkfs.io.GkFSError;
import com.bytedance.gkfs.io.f;
import com.bytedance.gkfs.io.k;
import com.bytedance.gkfs.io.l;
import com.bytedance.gkfs.io.m;
import com.bytedance.gkfs.io.n;
import com.bytedance.gkfs.io.o;
import com.bytedance.gkfs.io.p;
import com.bytedance.gkfs.storage.GkFSChunkStorage;
import com.bytedance.gkfs.storage.GkFSChunkStorageInfo;
import com.bytedance.gkfs.storage.GkFSCombinedChunkIndexing;
import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.UnsignedKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class GeckoFileSystem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f245101a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Chunker f245102b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f245103c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Application f245104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f245105e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final GeckoFileSystem f245106f = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f245107a;

        public a(Context r100) {
            this.f245107a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String[] r100 = GeckoFileSystem.f245101a;     // Catch: Throwable -> L7
            com.bytedance.gkfs.storage.c r101 = GeckoFileSystem.d();     // Catch: Throwable -> L7
            if (r101 == null) goto L14;
            int r102 = d.f245158a;     // Catch: Throwable -> L7
            List<Function0<Unit>> r103 = GkFSUtils.f245072a;     // Catch: Throwable -> L7
            d.c(null, r101, GkFSUtils.a(this.f245107a) * 1024);     // Catch: Throwable -> L7
            return;
        L14:
            return;
        L7:
            th = move-exception;
            d.c(th, null, 0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public GeckoFileSystem() {
    }

    static {
        f245106f = new GeckoFileSystem();
        f245101a = new String[]{".so", Dex2OatHelper.DEX_SUFFIX, ".gkfsf"};
        f245102b = new Chunker();
        f245103c = new AtomicBoolean(false);
        f245105e = new c();
    }

    public static com.bytedance.gkfs.storage.c d() throws Throwable {
        if (f245103c.get() == true) goto L7;
        c.e(f245105e, "GeckoFileSystem", "invoke tidyUp without init", 0, false, 28);
        return null;
    L7:
        if (UtilsKt.e() == true) goto L10;
        c.b(f245105e, "GeckoFileSystem", "invoke tidyUp in sub-process, skip", 0, true, 4);
        return null;
    L10:
        c.b(f245105e, "GeckoFileSystem", "start tidy up GkFS storage", 0, true, 4);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L13
        Object r101 = Result.m9449constructorimpl(GkFSChunkStorage.e());     // Catch: Throwable -> L13
    L15:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L18;
        c.c(f245105e, "GeckoFileSystem", "tidy up failed, cause by " + r102, r102, false, 20);
    L18:
        ResultKt.throwOnFailure(r101);
        return (com.bytedance.gkfs.storage.c) r101;
    L13:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static void b(Context r110) {
        int r100 = 0;
        if (f245103c.compareAndSet(false, true) == false) goto L49;
        Context r101 = r110.getApplicationContext();
        if (r101 == null) goto L48;
        f245104d = (Application) r101;
        Application r102 = GkFSChunkStorage.f245262a;
        Application r103 = f245104d;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L9:
        GkFSChunkStorage.f245262a = r103;
        com.bytedance.gkfs.storage.io.b.f245352n.getClass();
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103.getFilesDir(), "gkfs_chunk");
        r104.mkdirs();
        com.bytedance.gkfs.storage.io.b.f245348j = r104;
        com.bytedance.gkfs.io.a r105 = new com.bytedance.gkfs.io.a(0);
        File r106 = com.bytedance.gkfs.storage.io.b.f245348j;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("rootDir");
    L12:
        File[] r107 = r106.listFiles();
        if (r107 == null) goto L42;
        int r108 = r107.length;
        int r109 = 0;
    L15:
        if (r109 >= r108) goto L42;
        File r111 = r107[r109];
        if (StringsKt.endsWith$default(r111.getName(), "-rewriting", false, 2, null) == false) goto L20;
        r111.delete();
    L41:
        r109 = r109 + 1;
        goto L15
    L20:
        if (StringsKt.endsWith$default(r111.getName(), "-backup", false, 2, null) == false) goto L36;
        com.bytedance.gkfs.storage.io.b.f245352n.getClass();
        com.bytedance.gkfs.io.a r112 = com.bytedance.gkfs.storage.io.b.a.d(r111);
        if (Intrinsics.areEqual(r112, com.bytedance.gkfs.io.a.f245184b) == false) goto L24;
        r111.delete();
        goto L41
    L24:
        PolarisFileWrapper r113 = com.bytedance.gkfs.storage.io.b.a.i(r112);
        if (r113 != null) goto L28;
        Intrinsics.throwNpe();
    L28:
        if (r113.exists() == false) goto L31;
        r111.delete();
        goto L41
    L31:
        if (r111.renameTo(new PolarisFileWrapper(StringsKt.removeSuffix(r111.getAbsolutePath(), "-backup"))) == false) goto L41;
        if (r105.f245185a >= r112.f245185a) goto L41;
        r105 = r112;
        goto L41
    L36:
        if (Intrinsics.areEqual(FilesKt.getExtension(r111), "gkfsb") == false) goto L40;
        com.bytedance.gkfs.storage.io.b.f245352n.getClass();
        com.bytedance.gkfs.io.a r114 = com.bytedance.gkfs.storage.io.b.a.d(r111);
        if (r105.f245185a >= r114.f245185a) goto L41;
        r105 = r114;
        goto L41
    L40:
        r111.delete();
    L42:
        com.bytedance.gkfs.storage.io.b.f245346h = r105;
        GkFSChunkStorage.f245264c = new GkFSCombinedChunkIndexing(r103, GkFSChunkStorage.f245263b);
        GkFSExecutor r115 = GkFSExecutor.f245112c;
    L43:
        r115.getClass();
        if (r100 >= 3) goto L46;
        GkFSExecutor.f245110a.execute(new com.bytedance.gkfs.a(r100));
        r100 = r100 + 1;
        goto L43
    L46:
        ((Executor) GkFSExecutor.f245111b.getValue()).execute(b.f245126a);
        List<Function0<Unit>> r116 = GkFSUtils.f245072a;
        GkFSUtils.b(r110, GeckoFileSystem$init$1.INSTANCE);
        GkFSExecutor.a(new a(r110));
        return;
    L48:
        throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
    }

    public final boolean delete(File r100) {
        final Ref.BooleanRef r101 = new Ref.BooleanRef();
        r101.element = true;
        UtilsKt.g(r100, new AnonymousClass1(r101));
        boolean r102 = r101.element;
        boolean r103 = r100.delete() & r102;
        r101.element = r103;
        return r103;
    }

    public static final o a(File r210, PolarisFileWrapper r211) {
        File r100 = r210;
        Chunker r101 = f245102b;
        r101.getClass();
        int r110 = 0;
        if (r210.length() > 2048) goto L5;
        Chunker.c r102 = new Chunker.c(r100, CollectionsKt.emptyList(), UtilsKt.f245117c, new com.bytedance.gkfs.cdc.c(new p(false, new IllegalStateException("size " + r210.length() + " is less than 2048"), GkFSError.TINY_FILE), 0, 62));
        File r103 = r100;
        String r104 = null;
    L94:
        boolean r105 = false;
    L110:
        p r106 = r102.f245140d.f245151a;
        if (r106.f245246a == true) goto L134;
        GkFSError r107 = r106.f245248c;
        if (r107 != GkFSError.TINY_FILE) goto L115;
    L118:
        boolean r111 = true;
    L120:
        if (UtilsKt.d() == false) goto L126;
        c r108 = f245105e;
        StringBuilder r109 = new StringBuilder("cdc error on ");
        PolarisFileWrapper r112 = r211;
        r109.append(r112);
        r109.append(" transferring, cause ");
        Throwable r113 = r102.f245140d.f245151a.f245247b;
        if (r113 == null) goto L124;
        String r114 = r113.getMessage();
    L125:
        r109.append(r114);
        c.c(r108, "GeckoFileSystem", r109.toString(), null, !r111, 12);
    L184:
        return new o(new k(r112, new m(1, 0, 6), CollectionsKt.emptyList()), r103, r102.f245140d, new n(null, 0, 0, null, 0, 0, 0, 255));
    L124:
        r114 = r104;
        goto L125
    L126:
        r112 = r211;
        if (r111 == true) goto L184;
        c r115 = f245105e;
        StringBuilder r116 = new StringBuilder("cdc error on ");
        r116.append(r112);
        r116.append(" transferring, cause ");
        Throwable r117 = r102.f245140d.f245151a.f245247b;
        if (r117 == null) goto L131;
        String r118 = r117.getMessage();
    L132:
        r116.append(r118);
        c.c(r115, "GeckoFileSystem", r116.toString(), null, false, 28);
        goto L184
    L131:
        r118 = r104;
        goto L132
    L115:
        if (r107 == GkFSError.CDC_NO_CHUNK) goto L118;
        r111 = false;
        goto L120
    L134:
        l r119 = new l(r103, r211, r102);
        n r120 = r119.a();
        if (r120.f245232c.f245246a == true) goto L137;
    L147:
        c r121 = f245105e;
        StringBuilder r122 = new StringBuilder("write error on ");
        r122.append(r211);
        r122.append(" transferring, write error=");
        Throwable r123 = r120.f245232c.f245247b;
        if (r123 == null) goto L150;
        String r124 = r123.getMessage();
    L151:
        r122.append(r124);
        r122.append(", headerMeta is empty:");
        if (r119.f245218a != m.f245226d) goto L154;
        r105 = true;
    L154:
        r122.append(r105);
        c.c(r121, "GeckoFileSystem", r122.toString(), null, false, 28);
        return new o(new k(r211, r119.f245218a, CollectionsKt.emptyList()), r103, r102.f245140d, r120);
    L150:
        r124 = r104;
        goto L151
    L137:
        if (Intrinsics.areEqual(r119.f245218a, m.f245226d) == true) goto L147;
        Iterable r125 = CollectionsKt.withIndex(r102.f245138b);
        ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
        Iterator r127 = r125.iterator();
    L141:
        if (r127.hasNext() == false) goto L185;
        IndexedValue r128 = (IndexedValue) r127.next();
        f r129 = new f(((Chunker.b) r128.getValue()).f245134a, ((Chunker.b) r128.getValue()).f245135b);
        GkFSChunkStorageInfo r130 = r120.f245235f.f245199c.get(((Chunker.b) r128.getValue()).f245134a);
        if (r130 != null) goto L145;
        Intrinsics.throwNpe();
    L145:
        r126.add(new com.bytedance.gkfs.io.d(r129, r130));
        goto L141
    L185:
        return new o(new k(r211, r119.f245218a, r126), r103, r102.f245140d, r120);
    L5:
        ArrayList r131 = new ArrayList();
        LinkedHashMap r132 = new LinkedHashMap();
        LinkedHashMap r133 = new LinkedHashMap();
        long r134 = System.currentTimeMillis();
        long r135 = System.currentTimeMillis();     // Catch: Throwable -> L107
        PolarisFileInputStreamWrapper r136 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L107
        int r137 = 0;
        int r138 = 0;
        int r212 = 0;
        int r213 = 0;
    L164:
        int r139 = r136.read(Chunker.f245132c);     // Catch: Throwable -> L97
        Unit r214 = Unit.INSTANCE;     // Catch: Throwable -> L97
        if (r139 == (-1)) goto L55;
        int r140 = r213;
    L12:
        if (r110 >= r139) goto L54;
        byte r141 = Chunker.f245132c[r110];     // Catch: Throwable -> L51
        byte[] r142 = Chunker.f245131b;     // Catch: Throwable -> L51
        r142[r137] = r141;     // Catch: Throwable -> L51
        long r215 = r134;
    L49:
        th = th;
    L53:
        r104 = null;
        r103 = r210;
    L99:
        Throwable r143 = th;
        throw r143;     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        CloseableKt.closeFinally(r136, r143);     // Catch: Throwable -> L105
        throw th;     // Catch: Throwable -> L105
    L105:
        th = th;
    L109:
        r105 = false;
        r102 = new Chunker.c(r103, CollectionsKt.emptyList(), UtilsKt.f245117c, new com.bytedance.gkfs.cdc.c(new p(false, th, GkFSError.CDC_ERROR), System.currentTimeMillis() - r215, 30));
        goto L110
    L16:
        if (((int) UnsignedKt.m9803ulongRemaindereb3DHEI(ULong.m9623constructorimpl(r101.f245133a.d(r141)), ULong.m9623constructorimpl(8192))) != 4) goto L18;
        boolean r144 = true;
    L19:
        r137 = r137 + 1;     // Catch: Throwable -> L49
        if (r144 == true) goto L22;
    L24:
        if (r137 != 32768) goto L26;
        r212 = r212 + 1;     // Catch: Throwable -> L49
    L26:
        if (r144 == false) goto L31;
        if (r137 < 2048) goto L31;
    L32:
        r101.f245133a.c();     // Catch: Throwable -> L49
        if (r137 <= 0) goto L35;
        boolean r145 = true;
    L36:
        if (r145 == false) goto L38;
        Chunker r146 = r101;
    L40:
        if (r146 == null) goto L47;
        com.bytedance.gkfs.io.c r147 = new com.bytedance.gkfs.io.c(r142, r137);     // Catch: Throwable -> L43
        GkFSByteBuffer r148 = com.bytedance.gkfs.cdc.a.a(r137);     // Catch: Throwable -> L43
        UtilsKt.b(r142, r148, r137);     // Catch: Throwable -> L43
        Unit r149 = Unit.INSTANCE;     // Catch: Throwable -> L43
        r131.add(new Chunker.b(r147, r140, r148));     // Catch: Throwable -> L49
        r132.put(r147, Long.valueOf(System.currentTimeMillis() - r135));     // Catch: Throwable -> L49
        r133.put(r147, 0L);     // Catch: Throwable -> L49
        r140 = r140 + r137;     // Catch: Throwable -> L49
        r135 = System.currentTimeMillis();     // Catch: Throwable -> L49
        r137 = 0;
    L48:
        r110 = r110 + 1;
        r134 = r215;
        goto L12
    L43:
        th = move-exception;
        throw new IllegalStateException("ComputeHash error:" + th.getMessage() + ",{chunkSize:" + r137 + ", currentPos:" + r110 + ", chunkStartPos:" + r140 + ", posInChunk=" + r137 + '}');     // Catch: Throwable -> L49
    L47:
        throw new IllegalStateException("Divided chunk size is ZERO, {currentPos:" + r110 + ", chunkStartPos:" + r140 + ", posInChunk=" + r137 + '}');     // Catch: Throwable -> L49
    L38:
        r146 = null;
        goto L40
    L35:
        r145 = false;
    L31:
        if (r137 < 32768) goto L48;
    L22:
        if (r137 >= 2048) goto L24;
        r138 = r138 + 1;     // Catch: Throwable -> L49
        goto L26
    L18:
        r144 = false;
    L51:
        th = th;
        r215 = r134;
        goto L53
    L54:
        r110 = 0;
        r100 = r210;
        r213 = r140;
        goto L164
    L55:
        r215 = r134;
        r104 = null;
        CloseableKt.closeFinally(r136, null);     // Catch: Throwable -> L95
        com.bytedance.gkfs.cdc.c r150 = new com.bytedance.gkfs.cdc.c(p.f245245d, r138, r212, r133, r132, System.currentTimeMillis() - r215);     // Catch: Throwable -> L95
        if (r131.isEmpty() == false) goto L60;
        r103 = r210;
        r102 = new Chunker.c(r103, CollectionsKt.emptyList(), UtilsKt.f245117c, new com.bytedance.gkfs.cdc.c(new p(false, new IOException("can not find break point and file size:" + r210.length() + " is less than 32768"), GkFSError.CDC_NO_CHUNK), 0, 62));
        goto L94
    L60:
        r103 = r210;
        if (r137 > 1) goto L166;
        byte[] r151 = UtilsKt.f245117c;
    L77:
        Iterator r152 = r131.iterator();
        int r153 = 0;
    L79:
        if (r152.hasNext() == false) goto L82;
        r153 = r153 + ((Chunker.b) r152.next()).f245136c.f245144d;
        goto L79
    L82:
        if ((r153 + r151.length) == ((int) r210.length())) goto L92;
        GkFSError r154 = GkFSError.CDC_ERROR;
        StringBuilder r155 = new StringBuilder("size of ");
        Iterator r156 = r131.iterator();
        int r157 = 0;
    L85:
        if (r156.hasNext() == false) goto L87;
        r157 = r157 + ((Chunker.b) r156.next()).f245136c.f245144d;
        goto L85
    L87:
        r155.append(r157 + r151.length);
        r155.append("=chunks(");
        ArrayList r158 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r131, 10));
        Iterator r159 = r131.iterator();
    L89:
        if (r159.hasNext() == false) goto L91;
        r158.add(Integer.valueOf(((Chunker.b) r159.next()).f245136c.f245144d));
        goto L89
    L91:
        r155.append(CollectionsKt.joinToString$default(r158, null, null, null, 0, null, null, 63, null));
        r155.append(") + tail(");
        r155.append(r151.length);
        r155.append(") not equals to file size ");
        r155.append(r210.length());
        Chunker.c r160 = new Chunker.c(r103, r131, r151, new com.bytedance.gkfs.cdc.c(new p(false, new IllegalStateException(r155.toString()), r154), 0, 62));
    L93:
        r102 = r160;
        goto L94
    L92:
        r160 = new Chunker.c(r103, r131, r151, r150);
        goto L93
    L166:
        Result.Companion r161 = Result.Companion;     // Catch: Throwable -> L64
        Object r162 = Result.m9449constructorimpl(Chunker.a(r137, r131));     // Catch: Throwable -> L64
    L66:
        Throwable r163 = Result.m9452exceptionOrNullimpl(r162);
        if (r163 == null) goto L70;
        r102 = new Chunker.c(r103, CollectionsKt.emptyList(), UtilsKt.f245117c, new com.bytedance.gkfs.cdc.c(new p(false, r163, GkFSError.TRANSFER_RESULT_NOT_WORTH), 0, 62));
        goto L94
    L70:
        if (Result.m9455isFailureimpl(r162) == false) goto L72;
        r162 = null;
    L72:
        r151 = (byte[]) r162;
        if (r151 != null) goto L77;
        r151 = UtilsKt.f245117c;
    L64:
        th = move-exception;
        Result.Companion r164 = Result.Companion;
        r162 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L95:
        th = th;
        r103 = r210;
    L97:
        th = th;
        r103 = r100;
        r215 = r134;
        r104 = null;
    L107:
        th = th;
        r103 = r100;
        r215 = r134;
        r104 = null;
        goto L109
    }

    public static void c(File r110, final List r111, final boolean r112) {
        if (UtilsKt.e() == true) goto L7;
        c.b(f245105e, "GeckoFileSystem", "invoke store in sub-process, skip", 0, true, 4);
        CollectionsKt.emptyList();
        return;
    L7:
        if (f245103c.get() == true) goto L11;
        c.e(f245105e, "GeckoFileSystem", "invoke store without init", 0, false, 28);
        CollectionsKt.emptyList();
        return;
    L11:
        if (r110.exists() == true) goto L14;
        int r113 = d.f245158a;
        int r114 = o.f245240e;
        d.b(o.a.a(r110, new PolarisFileWrapper(""), new IOException(r110 + " not exists"), GkFSError.CHUNK_WRITE_ERROR));
        CollectionsKt.emptyList();
        return;
    L14:
        final ArrayList r100 = new ArrayList();
        UtilsKt.g(r110, new GeckoFileSystem$store$1(r111, r100, r112));
        if (UtilsKt.d() == false) goto L85;
        c r101 = f245105e;
        c.b(r101, "GeckoFileSystem", "finish storing " + r110, r101.f245128a.getAndIncrement(), false, 8);
        UtilsKt.f("迁移GkFS完成:" + r110);
        StringBuilder r115 = new StringBuilder("chunk size:");
        Iterator r116 = r100.iterator();
        long r102 = 0;
        long r103 = 0;
    L18:
        if (r116.hasNext() == false) goto L24;
        Iterator<T> r117 = ((o) r116.next()).f245241a.f245216c.iterator();
        long r104 = 0;
    L21:
        if (r117.hasNext() == false) goto L23;
        r104 = r104 + ((long) ((com.bytedance.gkfs.io.d) r117.next()).f245195c.f245293h);
        goto L21
    L23:
        r103 = r103 + r104;
        goto L18
    L24:
        r115.append(r103);
        r115.append("\ncdcCost:");
        Iterator r118 = r100.iterator();
        long r105 = 0;
    L26:
        if (r118.hasNext() == false) goto L32;
        Iterator<T> r119 = ((o) r118.next()).f245243c.f245154d.values().iterator();
        long r106 = 0;
    L29:
        if (r119.hasNext() == false) goto L31;
        r106 = r106 + ((Number) r119.next()).longValue();
        goto L29
    L31:
        r105 = r105 + r106;
        goto L26
    L32:
        r115.append(r105);
        r115.append("\ncdcTotalCost:");
        Iterator r120 = r100.iterator();
        long r107 = 0;
    L34:
        if (r120.hasNext() == false) goto L36;
        r107 = r107 + ((o) r120.next()).f245243c.f245156f;
        goto L34
    L36:
        r115.append(r107);
        r115.append("\ntotalSize:");
        ArrayList r121 = new ArrayList();
        Iterator r122 = r100.iterator();
    L37:
        boolean r108 = true;
        if (r122.hasNext() == false) goto L47;
        Object r109 = r122.next();
        o r123 = (o) r109;
        if (r123.f245243c.f245151a.f245246a == true) goto L42;
    L44:
        r108 = false;
    L45:
        if (r108 == false) goto L37;
        r121.add(r109);
        goto L37
    L42:
        if (r123.f245244d.f245232c.f245246a == false) goto L44;
    L47:
        Iterator r124 = r121.iterator();
        long r125 = 0;
    L49:
        if (r124.hasNext() == false) goto L51;
        r125 = r125 + ((o) r124.next()).f245244d.f245231b;
        goto L49
    L51:
        r115.append(r125);
        r115.append("\ntotalTimeCost:");
        ArrayList r126 = new ArrayList();
        Iterator r127 = r100.iterator();
    L53:
        if (r127.hasNext() == false) goto L62;
        Object r128 = r127.next();
        o r129 = (o) r128;
        if (r129.f245243c.f245151a.f245246a == true) goto L57;
    L59:
        boolean r130 = false;
    L60:
        if (r130 == false) goto L53;
        r126.add(r128);
        goto L53
    L57:
        if (r129.f245244d.f245232c.f245246a == false) goto L59;
        r130 = true;
        goto L60
    L62:
        Iterator r131 = r126.iterator();
    L64:
        if (r131.hasNext() == false) goto L66;
        r102 = r102 + ((o) r131.next()).f245244d.f245239j;
        goto L64
    L66:
        r115.append(r102);
        String r132 = r115.toString();
        c.b(f245105e, "GeckoFileSystem", "performance=" + r132, 0, false, 12);
        return;
    }
}
