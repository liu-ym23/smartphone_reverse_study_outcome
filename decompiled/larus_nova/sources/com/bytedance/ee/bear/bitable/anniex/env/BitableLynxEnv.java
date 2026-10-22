package com.bytedance.ee.bear.bitable.anniex.env;

import android.app.Application;
import android.content.Context;
import com.ss.android.lark.lynxkit.initializer.LarkLynxKitInitializer;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import lo4.d;
import lo4.e;
import lo4.f;
import lo4.g;
import lo4.h;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableLynxEnv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f206706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile InitState f206707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Throwable f206708c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/anniex/env/BitableLynxEnv$InitState;", "", "<init>", "(Ljava/lang/String;I)V", "NEW", "INITIALIZED", "FAILED", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum InitState extends Enum<InitState> {
        public static final InitState FAILED = null;
        public static final InitState INITIALIZED = null;
        public static final InitState NEW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InitState[] f206709a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f206710b = null;

        public static EnumEntries<InitState> getEntries() {
            return f206710b;
        }

        static {
            InitState r100 = new InitState("NEW", 0);
            NEW = r100;
            InitState r101 = new InitState("INITIALIZED", 1);
            INITIALIZED = r101;
            InitState r102 = new InitState("FAILED", 2);
            FAILED = r102;
            InitState[] r103 = {r100, r101, r102};
            f206709a = r103;
            f206710b = EnumEntriesKt.enumEntries(r103);
        }

        public static InitState[] values() {
            return (InitState[]) f206709a.clone();
        }

        public static InitState valueOf(String r100) {
            return (InitState) r27.a.a(InitState.class, r100);
        }

        public InitState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f206711a = null;

        static {
            int[] r100 = new int[InitState.values().length];
            r100[InitState.INITIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[InitState.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[InitState.NEW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f206711a = r100;
        }
    }

    public static final class b implements com.ss.android.lark.lynxkit.templateloader.loaderimpl.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.bitable.anniex.host.c f206712a;

        public b(com.bytedance.ee.bear.bitable.anniex.host.c r100) {
            this.f206712a = r100;
        }

        @Override // com.ss.android.lark.lynxkit.templateloader.loaderimpl.a
        public final com.ss.android.lark.lynxkit.templateloader.loaderimpl.b a(Context r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "resolverContext");
            Intrinsics.checkNotNullParameter(r101, "accessKey");
            Intrinsics.checkNotNullParameter(r102, "channel");
            Intrinsics.checkNotNullParameter(r103, "bundlePath");
            return this.f206712a.d(r100, r101, r102, r103);
        }
    }

    static {
        f206706a = new Object();
        f206707b = InitState.NEW;
    }

    public static void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        InitState r101 = f206707b;
        InitState r102 = InitState.INITIALIZED;
        if (r101 != r102) goto L5;
        return;
    L5:
        Object r103 = f206706a;
        monitor-enter(r103);
        InitState r104 = f206707b;     // Catch: Throwable -> L27
        int r105 = a.f206711a[r104.ordinal()];     // Catch: Throwable -> L27
        if (r105 != 1) goto L11;
        monitor-exit(r103);
        return;
    L11:
        if (r105 == 2) goto L24;
        if (r105 != 3) goto L22;
        b(r100);     // Catch: Throwable -> L18
        f206707b = r102;     // Catch: Throwable -> L18
        tt5.a.h("BitableLynxEnv", "init success");     // Catch: Throwable -> L18
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r103);
        return;
    L18:
        th = move-exception;
        f206708c = th;     // Catch: Throwable -> L27
        f206707b = InitState.FAILED;     // Catch: Throwable -> L27
        tt5.a.e("BitableLynxEnv", "init failed", th, false);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L22:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L27
    L24:
        throw new IllegalStateException("Bitable Lynx env initialization previously failed", f206708c);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public static void b(Context r100) {
        Context r101 = r100.getApplicationContext();
        if (r101 != null) goto L6;
        r101 = r100;
    L6:
        if ((r101 instanceof Application) == false) goto L8;
        Application r102 = (Application) r101;
    L9:
        if (r102 == null) goto L20;
        ((com.bytedance.ee.bear.lynx.api.b) org.koin.java.a.c(com.bytedance.ee.bear.lynx.api.b.class, null, null, 6)).init(r102);
        int r103 = io4.c.f495197a;
        tt5.a.h("BitableLynx: BitableXBridgeManager", "registerXBridges");
        io4.c.a(lo4.c.class);
        io4.c.a(d.class);
        io4.c.a(lo4.a.class);
        io4.c.a(lo4.b.class);
        io4.c.a(g.class);
        io4.c.a(f.class);
        io4.c.a(h.class);
        io4.c.a(e.class);
        io4.c.a(oo4.b.class);
        io4.c.a(oo4.c.class);
        io4.c.a(oo4.a.class);
        io4.c.a(ko4.b.class);
        io4.c.a(ko4.c.class);
        io4.c.a(ko4.d.class);
        io4.c.a(ko4.a.class);
        io4.c.a(no4.c.class);
        io4.c.a(no4.a.class);
        io4.c.a(no4.b.class);
        io4.c.a(com.bytedance.ee.bear.bitable.lynx.c.class);
        io4.c.a(jo4.a.class);
        int r104 = io4.b.f495196a;
        Iterator r105 = CollectionsKt.emptyList().iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        io4.c.a((Class) r105.next());
        goto L12
    L14:
        com.bytedance.ee.bear.bitable.anniex.env.b r106 = ((zm4.b) org.koin.java.a.c(zm4.b.class, null, null, 6)).getGeckoConfig();
        com.bytedance.ee.bear.bitable.anniex.host.c r107 = (com.bytedance.ee.bear.bitable.anniex.host.c) org.koin.java.a.c(com.bytedance.ee.bear.bitable.anniex.host.c.class, null, null, 6);
        LarkLynxKitInitializer.Companion.getClass();
        LarkLynxKitInitializer r108 = LarkLynxKitInitializer.b.a();
        int r109 = com.bytedance.ee.bear.bitable.anniex.util.g.f206757a;
        ArrayList r110 = new ArrayList();
        r110.add(new com.bytedance.ee.bear.bitable.anniex.util.c());
        r110.add(new com.bytedance.ee.bear.bitable.anniex.util.d());
        r110.add(new com.bytedance.ee.bear.bitable.anniex.util.e());
        r110.add(new com.bytedance.ee.bear.bitable.anniex.util.f());
        int r111 = com.bytedance.ee.bear.lynx.impl.c.f229867c;
        r110.addAll(com.bytedance.ee.bear.lynx.impl.c.a.a());
        int r112 = com.bytedance.lark.lynxlib.image.g.f253276a;
        com.bytedance.lynx.tasm.ui.imageloader.a.f265015a = new com.bytedance.lark.lynxlib.image.d();
        ArrayList r113 = new ArrayList();
        r113.add(new b17.c());
        r113.add(new b17.d());
        r113.add(new b17.e());
        r110.addAll(r113);
        r108.registerCustomComponents("BitableBiz", r110);
        com.ss.android.lark.lynxkit.templateloader.loaderimpl.d r114 = new com.ss.android.lark.lynxkit.templateloader.loaderimpl.d(r106.a(), new b(r107));
        int r115 = com.ss.android.lark.lynxkit.templateloader.loaderimpl.e.f431548a;
        List r116 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r114, "builtInConfig");
        Intrinsics.checkNotNullParameter(r116, "fallbackLoaders");
        ArrayList r117 = new ArrayList();
        if (r114.f431544c == false) goto L17;
        r117.add(new com.ss.android.lark.lynxkit.templateloader.loaderimpl.c(r100, r114));
    L17:
        r117.addAll(r116);
        r108.registerTemplateLoaders("BitableBiz", r117);
        return;
    L20:
        throw new IllegalStateException("application context is unavailable");
    L8:
        r102 = null;
        goto L9
    }
}
