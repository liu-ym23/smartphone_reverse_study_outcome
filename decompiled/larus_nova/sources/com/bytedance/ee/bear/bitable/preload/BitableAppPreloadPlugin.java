package com.bytedance.ee.bear.bitable.preload;

import com.bytedance.ee.bear.bitable.load.dataloader.BitableAppLoader;
import com.bytedance.ee.bear.bitable.preload.bean.BitableOfflineResultModel;
import com.bytedance.ee.bear.bitable.preload.util.BitablePreloadBridgeUtil;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0007\u0014\u0015\u0016\u0017\u0018\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J$\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/preload/BitableAppPreloadPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "getBitableLoader", "Lcom/bytedance/ee/bear/bitable/load/BitableLoaderImpl;", "buildPrefetchMessageJson", "prefetchMessage", "Lcom/bytedance/ee/bear/bitable/load/dataloader/BitableAppLoader$AppResourceMessage;", "extraErrorMsg", "success", "", "escapeJson", "value", "Companion", "GetFirstScreenDataParams", "GetClientVarsParams", "GetTableSsrDataParams", "GetClientVarsHandler", "GetFirstScreenDataHandler", "GetTableSsrDataHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableAppPreloadPlugin extends DocumentPlugin {
    public static final a Companion = null;
    private static final String TABLE_SSR_PREFETCH_DISABLED_ERROR = "Table SSR prefetch disabled";
    private static final String TAG = "BitableAppPreloadPlugin";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/preload/BitableAppPreloadPlugin$GetClientVarsParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "token", "", "<init>", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetClientVarsParams implements NonProguard {
        private final String token;

        /* JADX WARN: Multi-variable type inference failed */
        public GetClientVarsParams() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final String getToken() {
            return this.token;
        }

        public GetClientVarsParams(String r100) {
            Intrinsics.checkNotNullParameter(r100, "token");
            this.token = r100;
        }

        public /* synthetic */ GetClientVarsParams(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "";
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/preload/BitableAppPreloadPlugin$GetFirstScreenDataParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "token", "", "pageID", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getPageID", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetFirstScreenDataParams implements NonProguard {
        private final String pageID;
        private final String token;

        public final String getPageID() {
            return this.pageID;
        }

        public final String getToken() {
            return this.token;
        }

        public GetFirstScreenDataParams(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "token");
            this.token = r100;
            this.pageID = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/preload/BitableAppPreloadPlugin$GetTableSsrDataParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "token", "", "pageID", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getPageID", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetTableSsrDataParams implements NonProguard {
        private final String pageID;
        private final String token;

        public final String getPageID() {
            return this.pageID;
        }

        public final String getToken() {
            return this.token;
        }

        public GetTableSsrDataParams(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "token");
            this.token = r100;
            this.pageID = r101;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<GetClientVarsParams> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableAppPreloadPlugin f214966a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(BitableAppPreloadPlugin r100) {
            this.f214966a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r110) {
            GetClientVarsParams r101 = (GetClientVarsParams) r100;
            com.bytedance.ee.bear.bitable.load.d r102 = BitableAppPreloadPlugin.access$getBitableLoader(this.f214966a);
            if (r102 == null) goto L5;
            BitableAppLoader r103 = (BitableAppLoader) r102.e(BitableAppLoader.class);
        L6:
            if (r103 != null) goto L8;
            tt5.a.d(BitableAppPreloadPlugin.TAG, "Native cache controller is null");
            BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214966a, null, "Native loader not initialized", false), null), r110);
            return;
        L8:
            BitableAppLoader.AppResourceType r104 = BitableAppLoader.AppResourceType.ClientVarsData;
            r103.n(r104, new com.bytedance.ee.bear.bitable.preload.d(r103, r104, r101, this.f214966a, r110));
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public final class c implements tb5.i<GetFirstScreenDataParams> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableAppPreloadPlugin f214967a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(BitableAppPreloadPlugin r100) {
            this.f214967a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r110) {
            GetFirstScreenDataParams r101 = (GetFirstScreenDataParams) r100;
            com.bytedance.ee.bear.bitable.load.d r102 = BitableAppPreloadPlugin.access$getBitableLoader(this.f214967a);
            if (r102 == null) goto L5;
            BitableAppLoader r103 = (BitableAppLoader) r102.e(BitableAppLoader.class);
        L6:
            if (r103 != null) goto L8;
            tt5.a.d(BitableAppPreloadPlugin.TAG, "Native cache controller is null");
            BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214967a, null, "Native loader not initialized", false), null), r110);
            return;
        L8:
            BitableAppLoader.AppResourceType r104 = BitableAppLoader.AppResourceType.FirstScreenData;
            r103.n(r104, new e(r103, r104, r101, this.f214967a, r110));
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public final class d implements tb5.i<GetTableSsrDataParams> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableAppPreloadPlugin f214968a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(BitableAppPreloadPlugin r100) {
            this.f214968a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            GetTableSsrDataParams r102 = (GetTableSsrDataParams) r100;
            int r103 = com.bytedance.ee.bear.bitable.c.f207079a;
            if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.app_mode.mobile.table_prefetch.enable") == true) goto L5;
            tt5.a.k(BitableAppPreloadPlugin.TAG, BitableAppPreloadPlugin.TABLE_SSR_PREFETCH_DISABLED_ERROR);
            BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214968a, null, BitableAppPreloadPlugin.TABLE_SSR_PREFETCH_DISABLED_ERROR, false), null), r101);
            return;
        L5:
            com.bytedance.ee.bear.bitable.load.d r104 = BitableAppPreloadPlugin.access$getBitableLoader(this.f214968a);
            if (r104 == null) goto L8;
            BitableAppLoader r105 = (BitableAppLoader) r104.e(BitableAppLoader.class);
        L9:
            if (r105 != null) goto L11;
            tt5.a.d(BitableAppPreloadPlugin.TAG, "Native cache controller is null");
            BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214968a, null, "Native loader not initialized", false), null), r101);
            return;
        L11:
            r105.n(BitableAppLoader.AppResourceType.TableSsrData, new f(r102, r105, this.f214968a, r101));
            return;
        L8:
            r105 = null;
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final com.bytedance.ee.bear.bitable.load.d getBitableLoader() {
        x2 r100 = ((DocumentPluginHost) getHost()).getDocumentLoader();
        if ((r100 instanceof com.bytedance.ee.bear.bitable.load.d) == true) goto L7;
        return null;
    L7:
        return (com.bytedance.ee.bear.bitable.load.d) r100;
    }

    public BitableAppPreloadPlugin() {
    }

    public static final /* synthetic */ com.bytedance.ee.bear.bitable.load.d access$getBitableLoader(BitableAppPreloadPlugin r100) {
        return r100.getBitableLoader();
    }

    private final String escapeJson(String r100) {
        int r101 = 0;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return "";
    L9:
        StringBuilder r103 = new StringBuilder(r100.length());
    L11:
        if (r101 >= r100.length()) goto L28;
        char r104 = r100.charAt(r101);
        if (r104 != '\r') goto L15;
        r103.append("\\r");
    L26:
        r101 = r101 + 1;
        goto L11
    L15:
        if (r104 != '\"') goto L17;
        r103.append("\\\"");
        goto L26
    L17:
        if (r104 == '\\') goto L23;
        switch(r104) {
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            default: goto L19;
        };
    L19:
        r103.append(r104);
        goto L26
    L20:
        r103.append("\\n");
        goto L26
    L21:
        r103.append("\\t");
        goto L26
    L22:
        r103.append("\\b");
        goto L26
    L23:
        r103.append("\\\\");
        goto L26
    L28:
        return r103.toString();
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        int r101 = com.bytedance.ee.bear.bitable.c.f207079a;
        boolean r102 = com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.app_mode.mobile_native.prefetch");
        boolean r103 = com.bytedance.ee.bear.bitable.c.e();
        boolean r104 = com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.app_mode.mobile.table_prefetch.enable");
        if (r102 == true) goto L7;
        if (r103 == true) goto L7;
        if (r104 == true) goto L7;
        return;
    L7:
        if (r103 == false) goto L9;
        r100.put("biz.bitable.app.getClientVars", new b(this));
    L9:
        if (r102 == false) goto L11;
        r100.put("biz.bitable.app.getFirstScreenData", new c(this));
    L11:
        if (r104 == false) goto L14;
        r100.put("biz.bitable.app.getPrefetchedTableSSR", new d(this));
        return;
    }

    private final String buildPrefetchMessageJson(BitableAppLoader.a r110, String r111, boolean r112) {
        long r100 = 0;
        if (r110 == null) goto L5;
        long r101 = r110.f214491a;
    L6:
        boolean r102 = false;
        if (r110 == null) goto L9;
        int r113 = r110.f214492b;
    L12:
        String r103 = null;
        if (r110 == null) goto L15;
        String r104 = r110.f214493c;
    L16:
        String r105 = "";
        if (r104 != null) goto L20;
        r104 = "";
    L20:
        if (r111 != null) goto L22;
    L25:
        boolean r106 = true;
    L26:
        if (r106 == true) goto L29;
    L34:
        if (r110 == null) goto L36;
        String r107 = r110.f214494d;
    L37:
        if (r107 != null) goto L39;
        r107 = "";
    L39:
        if (r110 == null) goto L41;
        String r108 = r110.f214495e;
    L42:
        if (r108 != null) goto L44;
        r108 = "";
    L44:
        if (r110 == null) goto L46;
        r100 = r110.f214496f;
    L46:
        if (r110 == null) goto L48;
        r103 = r110.f214497g;
    L48:
        if (r103 == null) goto L52;
        r105 = r103;
    L52:
        return "{\"requestStart\":" + r101 + ",\"apiCode\":" + r113 + ",\"errorMsg\":\"" + escapeJson(r111) + "\",\"xttLogId\":\"" + escapeJson(r107) + "\",\"source\":\"" + escapeJson(r108) + "\",\"cacheElapsedTime\":" + r100 + ",\"preloadQueryResult\":\"" + escapeJson(r105) + "\"}";
    L41:
        r108 = null;
        goto L42
    L36:
        r107 = null;
        goto L37
    L29:
        if (r104.length() <= 0) goto L31;
        r102 = true;
    L31:
        if (r102 == false) goto L33;
        r111 = r104;
        goto L34
    L33:
        r111 = "";
        goto L34
    L22:
        if (r111.length() == 0) goto L25;
        r106 = false;
        goto L26
    L15:
        r104 = null;
        goto L16
    L9:
        if (r112 == false) goto L11;
        r113 = 0;
        goto L12
    L11:
        r113 = -1;
        goto L12
    L5:
        r101 = 0;
        goto L6
    }

    public static final /* synthetic */ String access$buildPrefetchMessageJson(BitableAppPreloadPlugin r100, BitableAppLoader.a r101, String r102, boolean r103) {
        return r100.buildPrefetchMessageJson(r101, r102, r103);
    }
}
