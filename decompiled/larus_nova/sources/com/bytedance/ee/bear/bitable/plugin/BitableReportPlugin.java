package com.bytedance.ee.bear.bitable.plugin;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguardWithoutSerializable;
import com.bytedance.locallife.cube.PrefetchTiming;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0006\u001d\u001e\u001f !\"B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0015\u001a\u00020\u00162\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\tH\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u0007¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/plugin/BitableReportPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "doc", "", "<init>", "(Z)V", "getDoc", "()Z", "handlers", "", "", "Lcom/bytedance/ee/bear/bitable/plugin/BitableReportPlugin$IReportHandler;", "defaultRouter", "", "getDefaultRouter", "()[Ljava/lang/String;", "defaultRouter$delegate", "Lkotlin/Lazy;", "disableTrace", "getDisableTrace", "disableTrace$delegate", "getBridgeHandlers", "", "handlersHolder", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onDetachFromHost", "Companion", "Router", "BitableReportHandler", "ReportList", "ReportModel", "IReportHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableReportPlugin extends DocumentPlugin {
    private static final String BRIDGE_REPORT = "biz.bitable.report";
    public static final b Companion = null;
    private static final String TAG = "BitableReportPlugin";
    private final Lazy defaultRouter$delegate;
    private final Lazy disableTrace$delegate;

    /* JADX INFO: renamed from: doc, reason: collision with root package name */
    private final boolean f214912doc;
    private final Map<String, c> handlers;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/plugin/BitableReportPlugin$ReportList;", "Lcom/bytedance/ee/util/io/NonProguardWithoutSerializable;", "list", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/plugin/BitableReportPlugin$ReportModel;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReportList implements NonProguardWithoutSerializable {
        private final ArrayList<ReportModel> list;

        public final ArrayList<ReportModel> getList() {
            return this.list;
        }

        public ReportList(ArrayList<ReportModel> r100) {
            Intrinsics.checkNotNullParameter(r100, "list");
            this.list = r100;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/plugin/BitableReportPlugin$ReportModel;", "Lcom/bytedance/ee/util/io/NonProguardWithoutSerializable;", "time", "", "token", "", PrefetchTiming.ROUTER, "", "event", "extra", "Lcom/alibaba/fastjson/JSONObject;", "<init>", "(JLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;)V", "getTime", "()J", "getToken", "()Ljava/lang/String;", "getRouter", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getEvent", "getExtra", "()Lcom/alibaba/fastjson/JSONObject;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReportModel implements NonProguardWithoutSerializable {
        private final String event;
        private final JSONObject extra;
        private final String[] router;
        private final long time;
        private final String token;

        public final String getEvent() {
            return this.event;
        }

        public final JSONObject getExtra() {
            return this.extra;
        }

        public final String[] getRouter() {
            return this.router;
        }

        public final long getTime() {
            return this.time;
        }

        public final String getToken() {
            return this.token;
        }

        public ReportModel(long r100, String r101, String[] r102, String r103, JSONObject r104) {
            Intrinsics.checkNotNullParameter(r101, "token");
            Intrinsics.checkNotNullParameter(r103, "event");
            this.time = r100;
            this.token = r101;
            this.router = r102;
            this.event = r103;
            this.extra = r104;
        }
    }

    public final class a implements i<ReportList> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableReportPlugin f214913a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(BitableReportPlugin r100) {
            this.f214913a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r110, m r111) {
            final ReportList r112 = (ReportList) r110;
            int r113 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
            final BitableReportPlugin r100 = this.f214913a;
            Function0<String> r114 = new BitableReportPlugin$BitableReportHandler$handle$1(r100, r112);
            Intrinsics.checkNotNullParameter(BitableReportPlugin.TAG, "tag");
            Intrinsics.checkNotNullParameter(r114, "msg");
            tt5.a.h("BitableStatistic", "BitableReportPlugin " + r114.invoke());
            if (r112 != null) goto L23;
            return;
        L23:
            ArrayList<ReportModel> r115 = r112.getList();     // Catch: Exception -> L20
            if (r115 == null) goto L30;
            BitableReportPlugin r101 = this.f214913a;     // Catch: Exception -> L20
            Iterator<T> r116 = r115.iterator();     // Catch: Exception -> L20
        L8:
            if (r116.hasNext() == false) goto L31;
            ReportModel r102 = (ReportModel) r116.next();     // Catch: Exception -> L20
            String[] r103 = r102.getRouter();     // Catch: Exception -> L20
            if (r103 != null) goto L13;
            r103 = BitableReportPlugin.access$getDefaultRouter(r101);     // Catch: Exception -> L20
        L13:
            int r104 = r103.length;     // Catch: Exception -> L20
            int r105 = 0;
        L14:
            if (r105 >= r104) goto L8;
            String r106 = r103[r105];     // Catch: Exception -> L20
            c r107 = (c) BitableReportPlugin.access$getHandlers$p(r101).get(r106);     // Catch: Exception -> L20
            if (r107 != null) goto L18;
            tt5.a.d(BitableReportPlugin.TAG, "not find match handler " + r106);     // Catch: Exception -> L20
        L19:
            r105 = r105 + 1;
            goto L14
        L18:
            r107.c(r102);     // Catch: Exception -> L20
            goto L19
        L31:
            return;
        L30:
            return;
        L20:
            e = move-exception;
            tt5.a.f(BitableReportPlugin.TAG, e, false);
        }
    }

    public static final class b {
        public b() {
        }
    }

    public interface c {
        void a(DocumentPluginHost r100);

        void b(DocumentPluginHost r100);

        void c(ReportModel r100);
    }

    static {
        Companion = new b();
    }

    public BitableReportPlugin() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final String[] getDefaultRouter() {
        return (String[]) this.defaultRouter$delegate.getValue();
    }

    private final boolean getDisableTrace() {
        return ((Boolean) this.disableTrace$delegate.getValue()).booleanValue();
    }

    public final boolean getDoc() {
        return this.f214912doc;
    }

    public BitableReportPlugin(boolean r100) {
        this.f214912doc = r100;
        this.handlers = new LinkedHashMap();
        this.defaultRouter$delegate = LazyKt.lazy(BitableReportPlugin$defaultRouter$2.INSTANCE);
        this.disableTrace$delegate = LazyKt.lazy(BitableReportPlugin$disableTrace$2.INSTANCE);
    }

    public static final /* synthetic */ String[] access$getDefaultRouter(BitableReportPlugin r100) {
        return r100.getDefaultRouter();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(BitableReportPlugin r100) {
        return r100.getDocViewModel();
    }

    public static final /* synthetic */ Map access$getHandlers$p(BitableReportPlugin r100) {
        return r100.handlers;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        if (getDisableTrace() == false) goto L5;
        return;
    L5:
        r100.put(BRIDGE_REPORT, new a(this));
    }

    public void onAttachToHost(DocumentPluginHost r100) {
        super.onAttachToHost(r100);
        if (getDisableTrace() == false) goto L5;
        return;
    L5:
        this.handlers.put("open_file", new tu4.c(this.f214912doc));
        this.handlers.put("view_lifecycle", new com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.f());
        Iterator<Map.Entry<String, c>> r101 = this.handlers.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().getValue().b(r100);
        goto L7
    }

    public void onDetachFromHost(DocumentPluginHost r100) {
        super.onDetachFromHost(r100);
        if (getDisableTrace() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, c>> r101 = this.handlers.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().getValue().a(r100);
        goto L7
    L9:
        this.handlers.clear();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((DocumentPluginHost) r100);
    }

    public /* synthetic */ BitableReportPlugin(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }
}
