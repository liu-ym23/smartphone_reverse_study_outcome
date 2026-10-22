package com.bytedance.ee.bear.bitable.chameleon.render;

import com.bytedance.ee.bear.bitable.chameleon.BitableSubType;
import com.bytedance.ee.bear.bitable.chameleon.render.cache.BitableCacheBlockType;
import com.bytedance.ee.bear.bitable.chameleon.render.cache.BitablePreloadLoader;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.render.node.l;
import com.bytedance.ee.bear.document.render.node.q;
import com.bytedance.ee.bear.document.y3;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f209679b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.chameleon.render.cache.b f209680a;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.ee.bear.bitable.chameleon.render.cache.b r101 = this.f209680a;
        if (r101 == null) goto L5;
        tt5.a.h("BitableCacheDataNode", r100.f221320i + " unregister cache data ability");
        r100.f221315d.unregisterHostAbility(r101);
    L5:
        this.f209680a = null;
    }

    public final Object a(DocumentLoaderV3 r110, Continuation r111) {
        DocumentLoaderV3 r100 = r110;
        if ((r111 instanceof BitableCacheDataNode$loadCache$1) == false) goto L7;
        BitableCacheDataNode$loadCache$1 r101 = (BitableCacheDataNode$loadCache$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        BitableCacheBlockType r106 = null;
        boolean r107 = true;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        long r108 = r101.J$0;
        BitableSubType r112 = (BitableSubType) r101.L$2;
        ChameleonPluginHost r113 = (ChameleonPluginHost) r101.L$1;
        com.bytedance.ee.bear.document.render.node.e r109 = (com.bytedance.ee.bear.document.render.node.e) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L144
        com.bytedance.ee.bear.document.render.node.e r114 = r109;
    L51:
        com.bytedance.ee.bear.bitable.chameleon.render.cache.g r115 = (com.bytedance.ee.bear.bitable.chameleon.render.cache.g) r103;     // Catch: Throwable -> L144
        if (r112 != BitableSubType.BaseMain) goto L55;
        long r116 = System.currentTimeMillis();
        int r117 = com.bytedance.ee.bear.bitable.chameleon.a.f209646a;
        com.bytedance.ee.bear.bitable.chameleon.a.c(r113, "BITABLE_NATIVE_PRELOAD_CLIENTVAR_END", r116);
        com.bytedance.ee.bear.bitable.chameleon.a.c(r113, "BITABLE_MAIN_PAGE_PRELOAD_CACHE_END", r116);
    L55:
        StringBuilder r118 = new StringBuilder();
        r118.append(r114.f());
        r118.append(" preload cache acquired, scene=");
        r118.append(r112);
        r118.append(", cost=");
        r118.append(System.currentTimeMillis() - r108);
        r118.append(", clientVarsSize=");
        String r119 = r115.f209715d;
        if (r119 == null) goto L58;
        int r120 = r119.length();
    L59:
        r118.append(r120);
        r118.append(", mainPageSize=");
        String r121 = r115.f209716e;
        if (r121 == null) goto L62;
        int r122 = r121.length();
    L63:
        r118.append(r122);
        r118.append(", recordDataSize=");
        String r123 = r115.f209717f;
        if (r123 == null) goto L66;
        int r124 = r123.length();
    L67:
        r118.append(r124);
        r118.append(", addRecordPageSize=");
        String r125 = r115.f209718g;
        if (r125 == null) goto L70;
        int r126 = r125.length();
    L71:
        r118.append(r126);
        tt5.a.h("BitableCacheDataNode", r118.toString());
        com.bytedance.ee.bear.bitable.chameleon.render.cache.c r127 = r115.f209714c;
        if (r127 != null) goto L74;
    L76:
        boolean r128 = false;
    L77:
        if (r128 == false) goto L79;
        String r129 = "explicit_url";
    L92:
        StringBuilder r130 = new StringBuilder();
        r130.append(r114.f());
        r130.append(" cache snapshot ready, scene=");
        r130.append(r112);
        r130.append(", firstBlockSource=");
        r130.append(r129);
        r130.append(", hasBlock=");
        if (r127 == null) goto L102;
        String r131 = r127.f209697b;
        if (r131 == null) goto L102;
        if (r131.length() <= 0) goto L99;
        boolean r132 = true;
    L100:
        if (r132 != true) goto L102;
        boolean r133 = true;
    L103:
        r130.append(r133);
        r130.append(", hasView=");
        if (r127 == null) goto L113;
        String r134 = r127.f209698c;
        if (r134 == null) goto L113;
        if (r134.length() <= 0) goto L110;
        boolean r135 = true;
    L111:
        if (r135 != true) goto L113;
        boolean r136 = true;
    L114:
        r130.append(r136);
        r130.append(", hasRecord=");
        if (r127 == null) goto L124;
        String r137 = r127.f209699d;
        if (r137 == null) goto L124;
        if (r137.length() <= 0) goto L121;
        boolean r138 = true;
    L122:
        if (r138 != true) goto L124;
        boolean r139 = true;
    L125:
        r130.append(r139);
        r130.append(", blockType=");
        if (r127 == null) goto L128;
        r106 = r127.f209700e;
    L128:
        r130.append(r106);
        r130.append(", nativeLocalCSReady=");
        r130.append(r115.f209719h);
        tt5.a.h("BitableCacheDataNode", r130.toString());
        com.bytedance.ee.bear.bitable.chameleon.render.cache.a r140 = (com.bytedance.ee.bear.bitable.chameleon.render.cache.a) r113.getHostAbilityOrNull(com.bytedance.ee.bear.bitable.chameleon.render.cache.a.class);
        if (r140 == null) goto L131;
        tt5.a.h("BitableCacheDataNode", r114.f() + " unregister stale cache data ability");
        r113.unregisterHostAbility(r140);
    L131:
        com.bytedance.ee.bear.bitable.chameleon.render.cache.b r141 = new com.bytedance.ee.bear.bitable.chameleon.render.cache.b(r115);
        r113.registerHostAbility(r141);
        this.f209680a = r141;
        StringBuilder r142 = new StringBuilder();
        r142.append(r114.f());
        r142.append(" cache data ability registered, scene=");
        r142.append(r112);
        r142.append(", firstBlock=");
        if (r127 == null) goto L141;
        String r143 = r127.f209697b;
        if (r143 == null) goto L141;
        if (r143.length() <= 0) goto L138;
        boolean r144 = true;
    L139:
        if (r144 != true) goto L141;
    L142:
        r142.append(r107);
        r142.append(", source=");
        r142.append(r129);
        tt5.a.h("BitableCacheDataNode", r142.toString());
        q.f221388a.getClass();
        return new q.c();
    L138:
        r144 = false;
    L141:
        r107 = false;
        goto L142
    L121:
        r138 = false;
    L124:
        r139 = false;
        goto L125
    L110:
        r135 = false;
    L113:
        r136 = false;
        goto L114
    L99:
        r132 = false;
    L102:
        r133 = false;
        goto L103
    L79:
        if (r127 == null) goto L88;
        String r145 = r127.f209697b;
        if (r145 == null) goto L88;
        if (r145.length() <= 0) goto L85;
        boolean r146 = true;
    L86:
        if (r146 != true) goto L88;
        boolean r147 = true;
    L89:
        if (r147 == false) goto L91;
        r129 = "rust";
        goto L92
    L91:
        r129 = "empty";
        goto L92
    L85:
        r146 = false;
    L88:
        r147 = false;
        goto L89
    L74:
        if (r127.f209701f != true) goto L76;
        r128 = true;
        goto L77
    L70:
        r126 = 0;
        goto L71
    L66:
        r124 = 0;
        goto L67
    L62:
        r122 = 0;
        goto L63
    L58:
        r120 = 0;
        goto L59
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        r113 = r100.f221315d;
        com.bytedance.ee.bear.bitable.chameleon.i.f209652a.getClass();
        r112 = com.bytedance.ee.bear.bitable.chameleon.i.a(r113);
        com.bytedance.ee.bear.document.d r148 = r110.getDocumentMetadata();
        y3 r149 = (y3) r113.getHostAbility(y3.class);
        WikiInfo r150 = r149.getWikiInfo();
        if (r150 == null) goto L19;
        String r151 = r150.getObjToken();
    L20:
        if (r151 != null) goto L22;
    L25:
        boolean r152 = true;
    L26:
        boolean r153 = !r152;
        WikiInfo r154 = r149.getWikiInfo();
        if (r154 == null) goto L39;
        String r155 = r154.getObjToken();
        if (r155 == null) goto L39;
        if (r155.length() <= 0) goto L33;
        boolean r156 = true;
    L34:
        if (r156 == true) goto L37;
        r155 = null;
    L37:
        if (r155 == null) goto L39;
    L40:
        BitablePreloadLoader r157 = BitablePreloadLoader.f209683a;
        String r158 = r148.getUrl();
        r157.getClass();
        com.bytedance.ee.bear.bitable.chameleon.render.cache.f r159 = BitablePreloadLoader.b(r112, r155, r158);
        if (r159 != null) goto L44;
        tt5.a.h("BitableCacheDataNode", r100.f221320i + " skip unsupported cache request, scene=" + r112 + ", isWiki=" + r153);
        q.f221388a.getClass();
        return new q.c();
    L44:
        long r160 = System.currentTimeMillis();
        if (r112 != BitableSubType.BaseMain) goto L47;
        int r161 = com.bytedance.ee.bear.bitable.chameleon.a.f209646a;
        com.bytedance.ee.bear.bitable.chameleon.a.c(r113, "BITABLE_NATIVE_PRELOAD_CLIENTVAR_START", r160);
        com.bytedance.ee.bear.bitable.chameleon.a.c(r113, "BITABLE_MAIN_PAGE_PRELOAD_CACHE_START", r160);
    L47:
        r101.L$0 = r100;     // Catch: Throwable -> L144
        r101.L$1 = r113;     // Catch: Throwable -> L144
        r101.L$2 = r112;     // Catch: Throwable -> L144
        r101.J$0 = r160;     // Catch: Throwable -> L144
        r101.label = 1;     // Catch: Throwable -> L144
        r103 = BitablePreloadLoader.c(r159).await(r101);     // Catch: Throwable -> L144
        if (r103 != r104) goto L50;
        return r104;
    L50:
        r108 = r160;
        r114 = r100;
        goto L51
    L33:
        r156 = false;
    L39:
        r155 = r148.getToken();
        goto L40
    L22:
        if (r151.length() == 0) goto L25;
        r152 = false;
        goto L26
    L19:
        r151 = null;
    L144:
        th = move-exception;
        if (r112 != BitableSubType.BaseMain) goto L148;
        long r162 = System.currentTimeMillis();
        int r163 = com.bytedance.ee.bear.bitable.chameleon.a.f209646a;
        com.bytedance.ee.bear.bitable.chameleon.a.c(r113, "BITABLE_NATIVE_PRELOAD_CLIENTVAR_END", r162);
        com.bytedance.ee.bear.bitable.chameleon.a.c(r113, "BITABLE_MAIN_PAGE_PRELOAD_CACHE_END", r162);
    L148:
        throw th;
    L7:
        r101 = new BitableCacheDataNode$loadCache$1(this, r111);
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r100, Continuation r101) {
        if ((r101 instanceof BitableCacheDataNode$run$1) == false) goto L7;
        BitableCacheDataNode$run$1 r102 = (BitableCacheDataNode$run$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L21 CancellationException -> L23
    L19:
    L30:
        return (q) r104;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        tt5.a.h("BitableCacheDataNode", r100.f221320i + " cache data node start");
        r102.label = 1;     // Catch: Throwable -> L21 CancellationException -> L23
        r104 = a(r100, r102);     // Catch: Throwable -> L21 CancellationException -> L23
        if (r104 != r105) goto L19;
        return r105;
    L23:
        e = move-exception;
        throw e;
    L21:
        th = move-exception;
        tt5.a.l("BitableCacheDataNode", "load cache failed, continue without cache", th);
        q.f221388a.getClass();
        return new q.c();
    L7:
        r102 = new BitableCacheDataNode$run$1(this, r101);
        goto L8
    }
}
