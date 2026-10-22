package com.bytedance.ee.bear.bitable.chameleon.render;

import android.net.Uri;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.bitable.chameleon.BitableSubType;
import com.bytedance.ee.bear.bitable.chameleon.render.cache.BitableCacheBlockType;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.render.node.l;
import com.bytedance.ee.bear.document.render.node.o;
import com.bytedance.ee.bear.document.render.node.q;
import com.bytedance.ee.bear.document.render.preload.WebViewLoadStateWebService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.trace.CopyContentTypeString;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements l {

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f209795a = null;

        static {
            int[] r100 = new int[BitableSubType.values().length];
            r100[BitableSubType.BaseMain.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[BitableSubType.BaseRecord.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[BitableSubType.BaseAdd.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[BitableSubType.BaseApp.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[BitableSubType.Unknown.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f209795a = r100;
        }
    }

    static {
    }

    public h() {
    }

    public static boolean a(String r100) {
        boolean r101 = true;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L23;
        return false;
    L23:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L16
        Object r104 = new JSONTokener(r100).nextValue();     // Catch: Throwable -> L16
        if ((r104 instanceof JSONObject) == false) goto L11;
    L14:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r101));     // Catch: Throwable -> L16
    L18:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L22;
        r105 = r106;
    L22:
        return ((Boolean) r105).booleanValue();
    L11:
        if ((r104 instanceof JSONArray) == true) goto L14;
        r101 = false;
    L16:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r110, Continuation r111) {
        com.bytedance.ee.bear.bitable.chameleon.render.cache.a r112 = (com.bytedance.ee.bear.bitable.chameleon.render.cache.a) r110.f221315d.getHostAbilityOrNull(com.bytedance.ee.bear.bitable.chameleon.render.cache.a.class);
        if (r112 == null) goto L116;
        com.bytedance.ee.bear.bitable.chameleon.render.cache.g r113 = r112.s6();
        if (r113 == null) goto L116;
        int r100 = b.f209795a[r113.f209712a.ordinal()];
        boolean r101 = false;
        if (r100 != 1) goto L9;
        com.bytedance.ee.bear.bitable.chameleon.render.cache.c r102 = r113.f209714c;
        if (r102 != null) goto L118;
    L75:
        d(r110.f221319h, "isNativeCacheReady", Boxing.boxBoolean(r113.f209720i));
        d(r110.f221319h, "isNativeLocalCSReady", Boxing.boxBoolean(r113.f209719h));
        com.bytedance.ee.bear.bitable.chameleon.render.cache.c r103 = r113.f209714c;
        if (r103 == null) goto L79;
        BitableCacheBlockType r104 = r103.f209700e;
        if (r104 == null) goto L79;
    L80:
        WebViewLoadStateWebService r105 = (WebViewLoadStateWebService) r110.f221315d.getWebService(WebViewLoadStateWebService.class);
        if (r105 != null) goto L83;
    L85:
        boolean r106 = false;
    L86:
        boolean r107 = r113.f209720i;
        Intrinsics.checkNotNullParameter(r104, "blockType");
        if (r106 == true) goto L90;
    L95:
        boolean r108 = false;
    L96:
        String r109 = r113.f209715d;
        if (r109 != null) goto L99;
    L101:
        boolean r114 = false;
    L102:
        StringBuilder r115 = new StringBuilder();
        r115.append(r110.f221320i);
        r115.append(" cache clientVars check, blockType=");
        r115.append(r104);
        r115.append(", templateReady=");
        r115.append(r106);
        r115.append(", nativeReady=");
        r115.append(r113.f209720i);
        r115.append(", blockTypeSupported=");
        r115.append(r108);
        r115.append(", hit=");
        if (r109 != null) goto L105;
    L106:
        r101 = true;
    L107:
        r115.append(!r101);
        r115.append(", valid=");
        r115.append(r114);
        tt5.a.h("BitableSenseInitNode", r115.toString());
        if (r108 == false) goto L113;
        if (r114 == false) goto L113;
        if (r109 == null) goto L113;
        o r116 = r110.f221319h;
        r116.getClass();
        Intrinsics.checkNotNullParameter("clientvars", "key");
        Intrinsics.checkNotNullParameter(r109, "value");
        r116.f221360b.put("clientvars", r109);
        tt5.a.h("BitableSenseInitNode", r110.f221320i + " cache clientVars merged, size=" + r109.length());
    L113:
        tt5.a.h("BitableSenseInitNode", r110.f221320i + " BaseMain sense initialized, nativeReady=" + r113.f209720i + ", nativeLocalCSReady=" + r113.f209719h);
    L114:
        q.f221388a.getClass();
        return new q.c();
    L105:
        if (r109.length() != 0) goto L107;
    L99:
        if (a(r109) != true) goto L101;
        r114 = true;
        goto L102
    L90:
        switch(i.f209796a[r104.ordinal()]) {
            case 1: goto L93;
            case 2: goto L93;
            case 3: goto L94;
            case 4: goto L94;
            case 5: goto L94;
            case 6: goto L94;
            default: goto L92;
        };
    L93:
        if (r107 == true) goto L95;
    L94:
        r108 = true;
        goto L96
    L92:
        throw new NoWhenBranchMatchedException();
    L83:
        if (r105.c(r110.getDocumentMetadata().getDocumentType()) != true) goto L85;
        r106 = true;
    L79:
        r104 = BitableCacheBlockType.Unsupported;
        goto L80
    L118:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L39
        Object r118 = Result.m9449constructorimpl(UriProtector.parse(r110.getDocumentMetadata().getUrl()));     // Catch: Throwable -> L39
    L41:
        String r119 = null;
        if (Result.m9455isFailureimpl(r118) == false) goto L44;
        r118 = null;
    L44:
        Uri r120 = (Uri) r118;
        if (r120 != null) goto L47;
        tt5.a.h("BitableSenseInitNode", r110.f221320i + " skip URL update, invalid URL");
        goto L75
    L47:
        String r121 = UriProtector.getQueryParameter(r120, CopyContentTypeString.TABLE);
        if (r121 != null) goto L50;
    L53:
        boolean r122 = true;
    L54:
        if (r122 == true) goto L57;
        tt5.a.h("BitableSenseInitNode", r110.f221320i + " skip URL update, explicit table exists");
        goto L75
    L57:
        if (r102.f209697b.length() != 0) goto L59;
        boolean r123 = true;
    L60:
        if (r123 == false) goto L62;
        tt5.a.h("BitableSenseInitNode", r110.f221320i + " skip URL update, firstBlock is empty");
        goto L75
    L62:
        Map<String, String> r124 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(CopyContentTypeString.TABLE, r102.f209697b)});
        String r125 = r102.f209698c;
        if (r125.length() <= 0) goto L65;
        boolean r126 = true;
    L66:
        if (r126 == false) goto L69;
        r119 = r125;
    L69:
        if (r119 == null) goto L71;
        r124.put("view", r119);
    L71:
        DocViewModel r127 = (DocViewModel) r110.f221315d.getHostAbilityOrNull(DocViewModel.class);
        if (r127 != null) goto L74;
        tt5.a.h("BitableSenseInitNode", r110.f221320i + " skip URL update, DocViewModel is missing");
        goto L75
    L74:
        r127.updateUrlQueryParams(r124);
        tt5.a.h("BitableSenseInitNode", r110.f221320i + " URL query updated from firstBlock, hasTable=true, hasView=" + r124.containsKey("view"));
        goto L75
    L65:
        r126 = false;
        goto L66
    L59:
        r123 = false;
        goto L60
    L50:
        if (r121.length() == 0) goto L53;
        r122 = false;
    L39:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    L9:
        if (r100 != 2) goto L11;
    L19:
        String r129 = r113.f209717f;
        if (r129 != null) goto L22;
    L24:
        boolean r130 = false;
    L25:
        StringBuilder r131 = new StringBuilder();
        r131.append(r110.f221320i);
        r131.append(" record cache check, hit=");
        if (r129 != null) goto L28;
    L29:
        r101 = true;
    L30:
        r131.append(!r101);
        r131.append(", valid=");
        r131.append(r130);
        tt5.a.h("BitableSenseInitNode", r131.toString());
        if (r130 == false) goto L34;
        if (r129 == null) goto L34;
        d(r110.f221319h, "cacheRecordData", r129);
        tt5.a.h("BitableSenseInitNode", r110.f221320i + " record cache merged, size=" + r129.length());
    L34:
        int r132 = com.bytedance.ee.bear.bitable.chameleon.a.f209646a;
        com.bytedance.ee.bear.bitable.chameleon.a.b(r110.f221315d, "is_native_cache_render", Boxing.boxBoolean(r130));
        goto L114
    L28:
        if (r129.length() != 0) goto L30;
    L22:
        if (a(r129) != true) goto L24;
        r130 = true;
        goto L25
    L11:
        if (r100 == 3) goto L19;
        if (r100 == 4) goto L114;
        if (r100 == 5) goto L114;
        throw new NoWhenBranchMatchedException();
    L116:
        tt5.a.h("BitableSenseInitNode", r110.f221320i + " skip sense init, cache ability is missing");
        q.f221388a.getClass();
        return new q.c();
    }

    public static void d(o r100, String r101, Object r102) {
        Serializable r103 = (Serializable) ((LinkedHashMap) r100.f221359a).get("extraParams");
        if ((r103 instanceof com.alibaba.fastjson.JSONObject) == false) goto L6;
        com.alibaba.fastjson.JSONObject r104 = (com.alibaba.fastjson.JSONObject) r103;
    L18:
        r104.put(r101, r102);
        r100.a("extraParams", r104);
        return;
    L6:
        if ((r103 instanceof String) == true) goto L20;
        r104 = new com.alibaba.fastjson.JSONObject();
        goto L18
    L20:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L9
        Object r106 = Result.m9449constructorimpl(JSON.parseObject((String) r103));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r106) == false) goto L14;
        r106 = null;
    L14:
        r104 = (com.alibaba.fastjson.JSONObject) r106;
        if (r104 != null) goto L18;
        r104 = new com.alibaba.fastjson.JSONObject();
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
