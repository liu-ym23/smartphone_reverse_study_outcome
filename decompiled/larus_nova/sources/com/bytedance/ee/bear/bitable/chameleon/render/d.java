package com.bytedance.ee.bear.bitable.chameleon.render;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.bear.bitable.chameleon.BitableSubType;
import com.bytedance.ee.bear.bitable.chameleon.render.cache.BitableCacheBlockType;
import com.bytedance.ee.bear.bitable.preload.BitablePreloadConfig;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.render.node.l;
import com.bytedance.ee.bear.document.render.node.q;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements l {

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JSONObject f209731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f209732b;

        public b() {
            this(null, null, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f209731a, r101.f209731a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f209732b, r101.f209732b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            JSONObject r100 = this.f209731a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f209732b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "PreparedMainPage(page=" + this.f209731a + ", failureReason=" + this.f209732b + ')';
        }

        public b(JSONObject r100, String r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this.f209731a = r100;
            this.f209732b = r101;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f209733a = null;

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
            f209733a = r100;
        }
    }

    static {
    }

    public d() {
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public final q.c d(DocumentLoaderV3 r110) {
        ChameleonPluginHost r100 = r110.f221315d;
        com.bytedance.ee.bear.bitable.chameleon.i.f209652a.getClass();
        if (com.bytedance.ee.bear.bitable.chameleon.i.a(r100) != BitableSubType.BaseMain) goto L5;
        int r101 = com.bytedance.ee.bear.bitable.chameleon.a.f209646a;
        com.bytedance.ee.bear.bitable.chameleon.a.d(r100, "BITABLE_NATIVE_GET_CACHE_START");
        com.bytedance.ee.bear.bitable.chameleon.a.b(r100, "not_render_nativeview_cache_reason", "default");
    L5:
        com.bytedance.ee.bear.bitable.chameleon.render.cache.a r102 = (com.bytedance.ee.bear.bitable.chameleon.render.cache.a) r100.getHostAbilityOrNull(com.bytedance.ee.bear.bitable.chameleon.render.cache.a.class);
        if (r102 == null) goto L87;
        com.bytedance.ee.bear.bitable.chameleon.render.cache.g r103 = r102.s6();
        if (r103 == null) goto L87;
        StringBuilder r104 = new StringBuilder();
        r104.append(r110.f221320i);
        r104.append(" cache snapshot found, scene=");
        r104.append(r103.f209712a);
        r104.append(", mainPageSize=");
        String r105 = r103.f209716e;
        if (r105 == null) goto L12;
        int r106 = r105.length();
    L13:
        r104.append(r106);
        r104.append(", recordDataSize=");
        String r107 = r103.f209717f;
        if (r107 == null) goto L16;
        int r108 = r107.length();
    L17:
        r104.append(r108);
        r104.append(", addRecordPageSize=");
        String r109 = r103.f209718g;
        if (r109 == null) goto L20;
        int r111 = r109.length();
    L21:
        r104.append(r111);
        tt5.a.h("BitableCacheRenderNode", r104.toString());
        int r112 = c.f209733a[r103.f209712a.ordinal()];
        boolean r113 = true;
        if (r112 == 1) goto L33;
        if (r112 != 2) goto L25;
    L85:
        q.f221388a.getClass();
        return new q.c();
    L25:
        if (r112 == 3) goto L85;
        if (r112 == 4) goto L85;
        if (r112 == 5) goto L85;
        throw new NoWhenBranchMatchedException();
    L33:
        tt5.a.h("BitableCacheRenderNode", r110.f221320i + " main page eligibility check start");
        com.bytedance.ee.bear.bitable.chameleon.render.cache.c r114 = r103.f209714c;
        if (r114 != null) goto L36;
    L73:
        tt5.a.h("BitableCacheRenderNode", "main page skipped, firstBlock is missing");
        b r115 = new b(null, "firstBlockNotExist", 1);
    L74:
        JSONObject r116 = r115.f209731a;
        if (r116 != null) goto L78;
        r113 = false;
    L78:
        r103.f209720i = r113;
        int r117 = com.bytedance.ee.bear.bitable.chameleon.a.f209646a;
        com.bytedance.ee.bear.bitable.chameleon.a.b(r100, "is_native_card_render_ready", Boolean.valueOf(r113));
        tt5.a.h("BitableCacheRenderNode", r110.f221320i + " main cache eligibility checked, nativeReady=" + r103.f209720i);
        if (r116 == null) goto L81;
        tt5.a.h("BitableCacheRenderNode", r110.f221320i + " async main cache render scheduled");
        j.c(new e(r110, this, r103, r116));
        goto L85
    L81:
        String r118 = r115.f209732b;
        if (r118 != null) goto L84;
        r118 = "nativeCardException";
    L84:
        e(r110, r118, false);
        goto L85
    L36:
        if (r114.f209697b.length() != 0) goto L38;
        boolean r119 = true;
    L39:
        if (r119 == true) goto L73;
        BitableCacheBlockType r120 = r114.f209700e;
        if (r120.getSupportsNativeMainPage() == true) goto L45;
        tt5.a.h("BitableCacheRenderNode", "main page skipped, unsupported block type=" + r120);
        r115 = new b(null, "firstBlockNotNativeView", 1);
        goto L74
    L45:
        if (r120 != BitableCacheBlockType.Default) goto L47;
        tt5.a.h("BitableCacheRenderNode", "main page uses compatible default block type");
    L47:
        String r121 = r103.f209716e;
        if (r121 != null) goto L50;
    L53:
        boolean r122 = true;
    L54:
        if (r122 == false) goto L89;
        tt5.a.h("BitableCacheRenderNode", "main page skipped, cache is empty");
        r115 = new b(null, "mainPageCacheNotExist", 1);
        goto L74
    L89:
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L58
        Object r124 = Result.m9449constructorimpl(new JSONObject(r121));     // Catch: Throwable -> L58
    L60:
        Throwable r125 = Result.m9452exceptionOrNullimpl(r124);
        if (r125 == null) goto L64;
        tt5.a.l("BitableCacheRenderNode", "main page parse failed", r125);
    L64:
        if (Result.m9455isFailureimpl(r124) == false) goto L66;
        r124 = null;
    L66:
        JSONObject r126 = (JSONObject) r124;
        if (r126 != null) goto L70;
        r115 = new b(null, "tableJsonInvalid", 1);
        goto L74
    L70:
        if (r126.has("viewData") == true) goto L72;
        tt5.a.h("BitableCacheRenderNode", "main page skipped, viewData is missing");
        r115 = new b(null, "tableJsonInvalid", 1);
        goto L74
    L72:
        r115 = new b(r126, null, 2);
    L58:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L60
    L50:
        if (r121.length() == 0) goto L53;
        r122 = false;
        goto L54
    L38:
        r119 = false;
        goto L39
    L20:
        r111 = 0;
        goto L21
    L16:
        r108 = 0;
        goto L17
    L12:
        r106 = 0;
    L87:
        tt5.a.h("BitableCacheRenderNode", r110.f221320i + " skip render cache, ability is missing");
        e(r110, "loaderNotExist", false);
        q.f221388a.getClass();
        return new q.c();
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r100, Continuation r101) {
        tt5.a.h("BitableCacheRenderNode", r100.f221320i + " render cache node start");
    L12:
        return d(r100);
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        tt5.a.l("BitableCacheRenderNode", "render cache failed, continue with Web render", th);
        e(r100, "nativeCardException", false);
        q.f221388a.getClass();
        return new q.c();
    }

    public static final boolean a(d r110, com.bytedance.ee.bear.document.render.node.e r111, JSONObject r112) {
        r110.getClass();
        tt5.a.h("BitableCacheRenderNode", r111.f() + " async main page dispatch start");
        BitablePreloadConfig.Companion.getClass();
        HashMap<String, String> r113 = BitablePreloadConfig.a.a().getBaseRenderKeyToBridgeName();
        LinkedHashSet r100 = new LinkedHashSet();
        Iterator r101 = CollectionsKt.listOf(new String[]{"sceneData", "header", "viewList", NewBroadcastMonitor.STAGE.TOOLBAR, "viewData"}).iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        String r102 = (String) r101.next();
        if (r112.has(r102) == false) goto L4;
        String r103 = r113.get(r102);
        if (r103 != null) goto L10;
        r103 = r102;
    L10:
        String r104 = r112.optString(r102);
        tt5.a.h("BitableCacheRenderNode", r111.f() + " dispatch main page bridge, key=" + r102 + ", bridge=" + r103 + ", size=" + r104.length());
        f r105 = f.f209738a;
        ChameleonPluginHost r106 = r111.getPluginHost();
        Intrinsics.checkNotNull(r104);
        if (f.b(r105, r106, r103, r104) == false) goto L12;
        r100.add(r102);
        goto L4
    L12:
        tt5.a.h("BitableCacheRenderNode", "main page dispatch failed, key=" + r102);
    L25:
        return false;
    L14:
        Iterator<String> r107 = r112.keys();
    L16:
        if (r107.hasNext() == false) goto L26;
        String r108 = r107.next();
        if (r100.contains(r108) == true) goto L16;
        String r109 = r113.get(r108);
        if (r109 != null) goto L22;
        r109 = r108;
    L22:
        String r114 = r112.optString(r108);
        tt5.a.h("BitableCacheRenderNode", r111.f() + " dispatch compatible main page bridge, key=" + r108 + ", bridge=" + r109 + ", size=" + r114.length());
        f r115 = f.f209738a;
        ChameleonPluginHost r116 = r111.getPluginHost();
        Intrinsics.checkNotNull(r109);
        Intrinsics.checkNotNull(r114);
        if (f.b(r115, r116, r109, r114) == true) goto L16;
        tt5.a.h("BitableCacheRenderNode", "main page dispatch failed, key=" + r108);
        goto L25
    L26:
        tt5.a.h("BitableCacheRenderNode", "main page dispatched, keys=" + r112.length());
        return true;
    }

    public static void e(com.bytedance.ee.bear.document.render.node.e r100, String r101, boolean r102) {
        ChameleonPluginHost r103 = r100.getPluginHost();
        com.bytedance.ee.bear.bitable.chameleon.i.f209652a.getClass();
        if (com.bytedance.ee.bear.bitable.chameleon.i.a(r103) == BitableSubType.BaseMain) goto L5;
        return;
    L5:
        int r104 = com.bytedance.ee.bear.bitable.chameleon.a.f209646a;
        com.bytedance.ee.bear.bitable.chameleon.a.b(r103, "not_render_nativeview_cache_reason", r101);
        com.bytedance.ee.bear.bitable.chameleon.a.b(r103, "is_native_cache_render", Boolean.valueOf(r102));
    }
}
