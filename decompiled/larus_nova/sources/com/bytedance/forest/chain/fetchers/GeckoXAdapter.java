package com.bytedance.forest.chain.fetchers;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import com.bytedance.forest.Forest;
import com.bytedance.forest.g;
import com.bytedance.forest.model.FetcherType;
import com.bytedance.forest.model.ForestEnvData;
import com.bytedance.forest.model.ForestEnvType;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.GeckoSource;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.f;
import com.bytedance.forest.model.i;
import com.bytedance.forest.model.j;
import com.bytedance.forest.utils.h;
import com.bytedance.forest.utils.r;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.IESGurdKit;
import com.bytedance.iesgurd.IESGurdResFrom;
import com.bytedance.iesgurd.e;
import com.bytedance.iesgurd.loader.ResLoader;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0017\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b8\u00109J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ1\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r0\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002JO\u0010!\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001c\u001a\u00020\u001b2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dH\u0007¢\u0006\u0004\b!\u0010\"J\u0016\u0010#\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter;", "", "", "accessKey", "Lcom/bytedance/geckox/GeckoClient;", "initGeckoXMultiClient", "Landroid/net/Uri;", "uri", "url", "Lcom/bytedance/forest/model/Request;", "request", "", "isGeckoCDNAndMergeConfig", "", "getCustomParams$forest_release", "(Ljava/lang/String;)Ljava/util/Map;", "getCustomParams", "getNormalGeckoXClient$forest_release", "(Ljava/lang/String;)Lcom/bytedance/geckox/GeckoClient;", "getNormalGeckoXClient", "channel", "", "getChannelVersion", "Lcom/bytedance/forest/model/Response;", "response", "bundle", "channelVersion", "Lcom/bytedance/forest/model/GeckoConfig;", "loaderConfig", "Lkotlin/Function1;", "Lcom/bytedance/iesgurd/e;", "", "callback", "getGeckoResourceData", "(Lcom/bytedance/forest/model/Response;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/forest/model/GeckoConfig;Lkotlin/jvm/functions/Function1;)V", "checkChannelExists", "Lcom/bytedance/forest/model/i;", "forestConfig", "Lcom/bytedance/forest/model/i;", "Ljava/io/File;", "appFileDir", "Ljava/io/File;", "Ljava/util/HashMap;", "geckoClients", "Ljava/util/HashMap;", "Laz5/a;", "mStatisticMonitor", "Laz5/a;", "Landroid/app/Application;", "app", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "Lcom/bytedance/forest/Forest;", "forest", "Lcom/bytedance/forest/Forest;", "<init>", "(Landroid/app/Application;Lcom/bytedance/forest/Forest;)V", "Companion", "forest_release"}, k = 1, mv = {1, 4, 0})
public final class GeckoXAdapter {
    private static Map<String, String> CDNMultiVersionCommonParamsDelegate = null;
    public static final Companion Companion = null;
    private static final String DEFAULT_BUCKET_ID = "9";
    private static final String INVALID_BUCKET_ID = "-1";
    public static final String TAG = "GeckoXAdapter";
    private static final List<String> fallbackCDNMultiVersionDomains = null;
    private static String geckoBucketId;

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private final Application f244193app;
    private File appFileDir;
    private final Forest forest;
    private final i forestConfig;
    private final HashMap<String, GeckoClient> geckoClients;
    private final az5.a mStatisticMonitor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005J\u0012\u0010!\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0007R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter$Companion;", "", "()V", "CDNMultiVersionCommonParams", "", "", "getCDNMultiVersionCommonParams", "()Ljava/util/Map;", "CDNMultiVersionCommonParamsDelegate", "DEFAULT_BUCKET_ID", "INVALID_BUCKET_ID", "TAG", "fallbackCDNMultiVersionDomains", "", "geckoBucketId", "addCommonParamsForCDNMultiVersionURL", "url", "addDefaultCDNMultiVersionDomains", "", "domains", "", "canParsed", "", "uri", "Landroid/net/Uri;", "dealWithBoeDomainIfNeed", "host", "getGeckoBucketId", "deviceId", "", "(Ljava/lang/Long;)Ljava/lang/String;", "getPrefixAsGeckoCDN", "path", "isCDNMultiVersionResource", "forest_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final Map<String, String> getCDNMultiVersionCommonParams() {
            Companion r100 = GeckoXAdapter.Companion;
            if (access$getCDNMultiVersionCommonParamsDelegate$li(r100) == null) goto L8;
            Map<String, String> r101 = GeckoXAdapter.access$getCDNMultiVersionCommonParamsDelegate$cp();
            if (r101 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("CDNMultiVersionCommonParamsDelegate");
        L7:
            return r101;
        L8:
            com.bytedance.geckox.b r102 = com.bytedance.geckox.b.a.f245076a;
            if (com.bytedance.geckox.b.a() == null) goto L23;
            Pair[] r103 = new Pair[5];
            GeckoGlobalConfig r110 = com.bytedance.geckox.b.a();
            if (r110 == null) goto L13;
            String r111 = r110.getAppVersion();
        L14:
            r103[0] = TuplesKt.to("version_name", r111);
            r103[1] = TuplesKt.to("device_platform", "android");
            r103[2] = TuplesKt.to("os", "android");
            GeckoGlobalConfig r104 = com.bytedance.geckox.b.a();
            if (r104 == null) goto L17;
            String r105 = String.valueOf(r104.getAppId());
        L18:
            r103[3] = TuplesKt.to("aid", r105);
            r103[4] = TuplesKt.to("gecko_bkt", getGeckoBucketId$default(r100, null, 1, null));
            GeckoXAdapter.access$setCDNMultiVersionCommonParamsDelegate$cp(MapsKt.mapOf(r103));
            Map<String, String> r106 = GeckoXAdapter.access$getCDNMultiVersionCommonParamsDelegate$cp();
            if (r106 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("CDNMultiVersionCommonParamsDelegate");
        L21:
            return r106;
        L17:
            r105 = null;
            goto L18
        L13:
            r111 = null;
            goto L14
        L23:
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("version_name", ""), TuplesKt.to("device_platform", "android"), TuplesKt.to("os", "android"), TuplesKt.to("aid", ""), TuplesKt.to("gecko_bkt", "9")});
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static final /* synthetic */ Map access$getCDNMultiVersionCommonParamsDelegate$li(Companion r100) {
            return GeckoXAdapter.access$getCDNMultiVersionCommonParamsDelegate$cp();
        }

        private final String dealWithBoeDomainIfNeed(String r100) {
            ForestEnvData r101 = Forest.Companion.getEnvData$forest_release();
            if (r101 == null) goto L5;
            ForestEnvType r102 = r101.getType();
        L7:
            if (r102 == ForestEnvType.BOE) goto L9;
            return r100;
        L9:
            if (StringsKt.contains$default(r100, CJPayConstant.BOE_SUFFIX, false, 2, null) == false) goto L11;
            return r100;
        L11:
            return r100 + CJPayConstant.BOE_SUFFIX;
        L5:
            r102 = null;
            goto L7
        }

        public final String addCommonParamsForCDNMultiVersionURL(String r110) {
            if (isCDNMultiVersionResource(r110) == true) goto L6;
            com.bytedance.forest.utils.i r100 = com.bytedance.forest.utils.i.f244548a;
            com.bytedance.forest.utils.i.h(GeckoXAdapter.TAG, r110 + " is not a cdn-multiple-version url", false, 60);
            return r110;
        L6:
            Map<String, String> r101 = getCDNMultiVersionCommonParams();
            if (r101.isEmpty() == false) goto L41;
            com.bytedance.forest.utils.i r102 = com.bytedance.forest.utils.i.f244548a;
            com.bytedance.forest.utils.i.h(GeckoXAdapter.TAG, "no cdn-multiple-version params need to add on " + r110, false, 60);
        L41:
            Uri r103 = UriProtector.parse(r110);     // Catch: Throwable -> L38
            Uri.Builder r104 = r103.buildUpon();     // Catch: Throwable -> L38
            Iterator<Map.Entry<String, String>> r105 = r101.entrySet().iterator();     // Catch: Throwable -> L38
        L12:
            if (r105.hasNext() == false) goto L17;
            Map.Entry<String, String> r106 = r105.next();     // Catch: Throwable -> L38
            if (UriProtector.getQueryParameter(r103, r106.getKey()) == null) goto L15;
            com.bytedance.forest.utils.i r107 = com.bytedance.forest.utils.i.f244548a;     // Catch: Throwable -> L38
            com.bytedance.forest.utils.i.h(GeckoXAdapter.TAG, "Parameter " + r106.getKey() + " of cdn-multiple-version already exists, value is:" + r106.getValue() + '.', false, 60);     // Catch: Throwable -> L38
            goto L12
        L15:
            r104.appendQueryParameter(r106.getKey(), r106.getValue());     // Catch: Throwable -> L38
            goto L12
        L17:
            ForestEnvData r108 = Forest.Companion.getEnvData$forest_release();     // Catch: Throwable -> L38
            if (r108 == null) goto L30;
            Pair[] r109 = new Pair[2];     // Catch: Throwable -> L38
            if (r108.getType() != ForestEnvType.PPE) goto L22;
            String r111 = ByteNetEnvHeaderName.PPE;
        L23:
            r109[0] = TuplesKt.to(r111, "1");     // Catch: Throwable -> L38
            r109[1] = TuplesKt.to("x-tt-env", r108.getName());     // Catch: Throwable -> L38
            Iterator r112 = MapsKt.mapOf(r109).entrySet().iterator();     // Catch: Throwable -> L38
        L25:
            if (r112.hasNext() == false) goto L30;
            Map.Entry r113 = (Map.Entry) r112.next();     // Catch: Throwable -> L38
            if (UriProtector.getQueryParameter(r103, (String) r113.getKey()) == null) goto L28;
            com.bytedance.forest.utils.i r114 = com.bytedance.forest.utils.i.f244548a;     // Catch: Throwable -> L38
            com.bytedance.forest.utils.i.h(GeckoXAdapter.TAG, "Parameter " + ((String) r113.getKey()) + " of cdn-multiple-version already exists for " + r110 + ", except:" + ((String) r113.getValue()) + ", current:" + UriProtector.getQueryParameter(r103, (String) r113.getKey()) + '.', false, 60);     // Catch: Throwable -> L38
            goto L25
        L28:
            r104.appendQueryParameter((String) r113.getKey(), (String) r113.getValue());     // Catch: Throwable -> L38
            goto L25
        L22:
            r111 = ByteNetEnvHeaderName.BOE;
        L30:
            String r115 = r103.getHost();     // Catch: Throwable -> L38
            if (r115 != null) goto L33;
            Intrinsics.throwNpe();     // Catch: Throwable -> L38
        L33:
            String r116 = dealWithBoeDomainIfNeed(r115);     // Catch: Throwable -> L38
            if (Intrinsics.areEqual(r116, r115) == false) goto L37;
            return StringsKt.replace$default(r104.build().toString(), r115, r116, false, 4, null);
        L37:
            return r104.build().toString();
        L38:
            th = move-exception;
            com.bytedance.forest.utils.i r117 = com.bytedance.forest.utils.i.f244548a;
            com.bytedance.forest.utils.i.f(GeckoXAdapter.TAG, "build cdn-multiple-version for " + r110 + " failed, error: " + th.getMessage(), 4);
            return r110;
        }

        public final void addDefaultCDNMultiVersionDomains(List<String> r100) {
            GeckoXAdapter.access$getFallbackCDNMultiVersionDomains$cp().addAll(r100);
        }

        public final boolean canParsed(Uri r100) {
            boolean r101 = true;
            if (Intrinsics.areEqual(r100.getScheme(), "http") == false) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == true) goto L11;
            return false;
        L11:
            com.bytedance.geckox.b r103 = com.bytedance.geckox.b.a.f245076a;
            GlobalConfigSettings r104 = com.bytedance.geckox.b.b();
            String r105 = null;
            if (r104 == null) goto L14;
            GlobalConfigSettings.ResourceMeta r106 = r104.getResourceMeta();
        L16:
            if (r106 != null) goto L19;
            com.bytedance.forest.utils.i.f(null, "could not get any valid resource meta", 5);
            return false;
        L19:
            String r107 = r100.getPath();
            if (r107 != null) goto L23;
            r107 = "";
        L23:
            String r108 = getPrefixAsGeckoCDN(r107);
            if (r108.length() == 0) goto L27;
            r101 = false;
        L27:
            if (r101 == false) goto L29;
            return false;
        L29:
            GlobalConfigSettings.CurrentLevelConfig r109 = r106.getConfig();
            if (r109 != null) goto L33;
            com.bytedance.forest.utils.i.f(null, "could not get any valid config", 5);
            return false;
        L33:
            int r110 = h.f244547a;
            Map<String, String> r111 = r109.getPrefix2AccessKey();
            if (r111 == null) goto L37;
            r105 = r111.get(r108);
        L37:
            return h.a(r105);
        L14:
            r106 = null;
            goto L16
        L5:
            if (Intrinsics.areEqual(r100.getScheme(), "https") == true) goto L8;
            r102 = false;
            goto L9
        }

        public final String getGeckoBucketId(Long r100) {
            if ((!Intrinsics.areEqual(GeckoXAdapter.access$getGeckoBucketId$cp(), "-1")) == true) goto L5;
            if (r100 != null) goto L14;
            com.bytedance.geckox.b r101 = com.bytedance.geckox.b.a.f245076a;
            GeckoGlobalConfig r102 = com.bytedance.geckox.b.a();
            if (r102 == null) goto L13;
            String r103 = r102.getDeviceId();
            if (r103 == null) goto L13;
            r100 = StringsKt.toLongOrNull(r103);
        L13:
            r100 = null;
        L14:
            if (r100 == null) goto L31;
            int r104 = (int) (r100.longValue() % ((long) 100));
            if (r104 != 0) goto L18;
            String r105 = "s01";
        L30:
            GeckoXAdapter.access$setGeckoBucketId$cp(r105);
            return GeckoXAdapter.access$getGeckoBucketId$cp();
        L18:
            if (1 > r104) goto L24;
            if (4 < r104) goto L24;
            r105 = "s05";
        L24:
            if (5 <= r104) goto L27;
        L29:
            r105 = String.valueOf(r104 / 10);
            goto L30
        L27:
            if (9 < r104) goto L29;
            r105 = "0";
            goto L30
        L31:
            return "9";
        L5:
            return GeckoXAdapter.access$getGeckoBucketId$cp();
        }

        public final String getPrefixAsGeckoCDN(String r100) {
            List r101 = StringsKt.split$default(r100, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
            if (r101.isEmpty() == false) goto L5;
            return "";
        L5:
            if (r101.size() >= 6) goto L8;
            return "";
        L8:
            return HTTP.URL_DEFAULT + ((String) ListProtector.get(r101, 1)) + '/' + ((String) ListProtector.get(r101, 2)) + '/' + ((String) ListProtector.get(r101, 3)) + '/' + ((String) ListProtector.get(r101, 4)) + '/' + ((String) ListProtector.get(r101, 5));
        }

        public final boolean isCDNMultiVersionResource(String r100) {
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L11;
            return false;
        L11:
            com.bytedance.geckox.b r102 = com.bytedance.geckox.b.a.f245076a;
            GlobalConfigSettings r103 = com.bytedance.geckox.b.b();
            Object r104 = null;
            if (r103 == null) goto L16;
            GlobalConfigSettings.ResourceMeta r105 = r103.getResourceMeta();
            if (r105 == null) goto L16;
            GlobalConfigSettings.CurrentLevelConfig r106 = r105.getConfig();
        L17:
            if (r106 == null) goto L23;
            GlobalConfigSettings.CDNMultiVersion r107 = r106.getCdnMultiVersion();
            if (r107 == null) goto L23;
            List<String> r108 = r107.getDomains();
            if (r108 == null) goto L23;
        L25:
            if (r108.isEmpty() == true) goto L40;
            Iterator<T> r109 = r108.iterator();
        L29:
            if (r109.hasNext() == false) goto L33;
            Object r110 = r109.next();
            if (StringsKt.contains$default(r100, (String) r110, false, 2, null) == false) goto L29;
            r104 = r110;
        L33:
            if (r104 != null) goto L41;
            return false;
        L41:
            return true;
        L40:
            return StringsKt.contains$default(r100, "gr-sourcecdn.bytegecko.com", false, 2, null);
        L23:
            r108 = GeckoXAdapter.access$getFallbackCDNMultiVersionDomains$cp();
        L16:
            r106 = null;
            goto L17
        L5:
            if (StringsKt.isBlank(r100) == true) goto L8;
            r101 = false;
            goto L9
        }

        public final boolean canParsed(String r100) {
            if (r100.length() != 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L20;
            return false;
        L20:
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
            Object r103 = Result.m9449constructorimpl(UriProtector.parse(r100));     // Catch: Throwable -> L10
        L13:
            if (Result.m9455isFailureimpl(r103) == false) goto L15;
            r103 = null;
        L15:
            Uri r104 = (Uri) r103;
            if (r104 != null) goto L18;
            return false;
        L18:
            return canParsed(r104);
        L10:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L13
        L5:
            r101 = false;
            goto L6
        }

        public static final /* synthetic */ void access$setCDNMultiVersionCommonParamsDelegate$li(Companion r100, Map r101) {
            GeckoXAdapter.access$setCDNMultiVersionCommonParamsDelegate$cp(r101);
        }

        public static /* synthetic */ String getGeckoBucketId$default(Companion r100, Long r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.getGeckoBucketId(r101);
        }
    }

    public static final class a implements az5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f244194a = null;

        static {
            f244194a = new a();
        }

        public a() {
        }

        @Override // az5.a
        public final void a(String r100, JSONObject r101) {
            if (TextUtils.isEmpty(r100) == true) goto L7;
            if (r101 == null) goto L8;
            com.bytedance.forest.utils.i r102 = com.bytedance.forest.utils.i.f244548a;
            com.bytedance.forest.utils.i.h(GeckoXAdapter.TAG, "event:" + r100 + ",data:" + r101, false, 60);
            return;
        L8:
            return;
        }
    }

    public final void getGeckoResourceData(Response r110, String r111, String r112, GeckoConfig r113, Function1<? super e, Unit> r114) {
        getGeckoResourceData$default(this, r110, r111, r112, null, r113, r114, 8, null);
    }

    static {
        Companion = new Companion(null);
        fallbackCDNMultiVersionDomains = new ArrayList();
        geckoBucketId = "-1";
    }

    public static final /* synthetic */ Map access$getCDNMultiVersionCommonParamsDelegate$cp() {
        return CDNMultiVersionCommonParamsDelegate;
    }

    public static final /* synthetic */ List access$getFallbackCDNMultiVersionDomains$cp() {
        return fallbackCDNMultiVersionDomains;
    }

    public static final /* synthetic */ String access$getGeckoBucketId$cp() {
        return geckoBucketId;
    }

    public final Application getApp() {
        return this.f244193app;
    }

    public static final /* synthetic */ void access$setCDNMultiVersionCommonParamsDelegate$cp(Map r100) {
        CDNMultiVersionCommonParamsDelegate = r100;
    }

    public static final /* synthetic */ void access$setGeckoBucketId$cp(String r100) {
        geckoBucketId = r100;
    }

    private final GeckoClient initGeckoXMultiClient(String r100) {
        GeckoClient r101 = com.bytedance.geckox.a.a(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        GeckoConfig r102 = this.forestConfig.a(r100);
        if (r102 == null) goto L15;
        String r103 = r102.f244245f;
        return GeckoClient.create(new com.bytedance.geckox.GeckoConfig.Builder(this.f244193app).host(this.forestConfig.f244345g).appId(r102.f244243d).appVersion(r102.f244244e).netStack(null).cacheConfig(null).statisticMonitor(this.mStatisticMonitor).region(r102.f244246g).accessKey(new String[]{r100}).allLocalAccessKeys(new String[]{r100}).deviceId(r103).resRootDir(r102.a(this.f244193app)).build());
    L10:
        e = move-exception;
        com.bytedance.forest.utils.i.f244548a.c(TAG, "GeckoClient.create error", e);
        return null;
    L15:
        return null;
    }

    public final Map<String, Map<String, String>> getCustomParams$forest_release(String r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == null) goto L5;
        String r102 = r100;
    L6:
        LinkedHashMap r103 = new LinkedHashMap();
        GeckoConfig r104 = this.forestConfig.a(r100);
        if (r104 == null) goto L9;
        String r105 = (String) r103.put("business_version", r104.f244244e);
    L9:
        r101.put(r102, r103);
        return r101;
    L5:
        r102 = "";
        goto L6
    }

    public final GeckoClient getNormalGeckoXClient$forest_release(String r100) {
        GeckoClient r101 = this.geckoClients.get(r100);
        if (r101 != null) goto L6;
        GeckoClient r102 = initGeckoXMultiClient(r100);
        this.geckoClients.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public GeckoXAdapter(Application r100, Forest r101) {
        this.f244193app = r100;
        this.forest = r101;
        this.forestConfig = r101.getConfig();
        this.geckoClients = new HashMap();
        this.mStatisticMonitor = a.f244194a;
    }

    public final boolean checkChannelExists(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        if (IESGurdKit.a(r100, r101) <= 0) goto L12;
        return true;
    L12:
        return false;
    }

    public final long getChannelVersion(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return 0;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return 0;
    L8:
        return IESGurdKit.a(r100, r101);
    }

    public final boolean isGeckoCDNAndMergeConfig(Uri r110, String r111, Request r112) {
        com.bytedance.geckox.b r100 = com.bytedance.geckox.b.a.f245076a;
        GlobalConfigSettings r101 = com.bytedance.geckox.b.b();
        GlobalConfigSettings.CDNFallBackConfig r102 = null;
        if (r101 == null) goto L5;
        GlobalConfigSettings.ResourceMeta r103 = r101.getResourceMeta();
    L6:
        boolean r104 = false;
        if (r103 != null) goto L10;
        com.bytedance.forest.utils.i.f(null, "could not get any valid resource meta", 5);
        return false;
    L10:
        Companion r105 = Companion;
        String r113 = r110.getPath();
        if (r113 != null) goto L14;
        r113 = "";
    L14:
        String r114 = r105.getPrefixAsGeckoCDN(r113);
        GlobalConfigSettings.CurrentLevelConfig r106 = r103.getConfig();
        if (r106 != null) goto L18;
        com.bytedance.forest.utils.i.f(null, "could not get any valid config", 5);
        return false;
    L18:
        Map<String, String> r107 = r106.getPrefix2AccessKey();
        if (r107 == null) goto L21;
        String r108 = r107.get(r114);
    L23:
        if (r108 != null) goto L25;
    L28:
        boolean r109 = true;
    L29:
        if (r109 == false) goto L32;
        com.bytedance.forest.utils.i.f(null, "could not get any valid access key from remote settings", 5);
        return false;
    L32:
        r112.getGeckoModel().f244348a = r108;
        GlobalConfigSettings.AccessKeyMetaInfo r115 = r103.getAccessKeys().get(r108);
        if (r115 == null) goto L35;
        GlobalConfigSettings.CurrentLevelConfig r116 = r115.getConfig();
    L36:
        j r117 = r.a(r111, r114);
        if (r117 != null) goto L39;
    L41:
        GlobalConfigSettings.AccessKeyMetaInfo r118 = r103.getAccessKeys().get(r108);
        if (r118 == null) goto L48;
        Map<String, GlobalConfigSettings.ChannelMetaInfo> r119 = r118.getChannels();
        if (r119 == null) goto L48;
        GlobalConfigSettings.ChannelMetaInfo r120 = r119.get(r112.getGeckoModel().f244349b);
        if (r120 == null) goto L48;
        GlobalConfigSettings.CurrentLevelConfig r121 = r120.getConfig();
    L49:
        if (r121 == null) goto L53;
        List<GlobalConfigSettings.PipelineStep> r122 = r121.getPipeline();
        if (r122 == null) goto L53;
    L56:
        if (r122 != null) goto L59;
        r122 = r106.getPipeline();
    L59:
        if (r122 != null) goto L61;
    L87:
        if (r121 == null) goto L91;
        GlobalConfigSettings.CDNFallBackConfig r123 = r121.getCdnFallback();
        if (r123 == null) goto L91;
        r102 = r123;
    L93:
        if (r102 != null) goto L96;
        r102 = r106.getCdnFallback();
    L96:
        if (r102 != null) goto L98;
    L107:
        return true;
    L98:
        if (r102.getDomains() == null) goto L107;
        List<String> r124 = r102.getDomains();
        Iterator<String> r125 = r124.iterator();
    L101:
        if (r125.hasNext() == false) goto L103;
        r112.getRemainedFallbackDomains$forest_release().add(r125.next());
        goto L101
    L103:
        r112.setFallbackDomains(r124);
        r112.setLoadRetryTimes(RangesKt.coerceAtLeast(r102.getMaxAttempts(), 1) - 1);
        if (r102.getShuffle() != 1) goto L106;
        r104 = true;
    L106:
        r112.setSupportShuffle(r104);
    L91:
        if (r116 == null) goto L93;
        r102 = r116.getCdnFallback();
        goto L93
    L61:
        if ((!r122.isEmpty()) == false) goto L87;
        List<FetcherType> r126 = r112.getFetcherSequence();
        r126.clear();
        Iterator<GlobalConfigSettings.PipelineStep> r127 = r122.iterator();
    L64:
        if (r127.hasNext() == false) goto L87;
        GlobalConfigSettings.PipelineStep r128 = r127.next();
        if (r128 == null) goto L64;
        int r129 = r128.getType();
        if (r129 != 1) goto L70;
        r126.add(FetcherType.f244229d);
        int r130 = f.f244335a;
        int r131 = r128.getUpdate();
        if (r131 == 1) goto L85;
        if (r131 == 2) goto L85;
        boolean r132 = false;
    L86:
        r112.setWaitGeckoUpdate(r132);
    L85:
        r132 = true;
        goto L86
    L70:
        if (r129 != 2) goto L72;
        r126.add(FetcherType.f244231f);
        if (r128.getNoCache() == 1) goto L78;
        boolean r133 = true;
    L79:
        r112.setEnableCDNCache(r133);
        goto L64
    L78:
        r133 = false;
        goto L79
    L72:
        if (r129 != 3) goto L64;
        r126.add(FetcherType.f244230e);
    L53:
        if (r116 == null) goto L55;
        r122 = r116.getPipeline();
        goto L56
    L55:
        r122 = null;
    L48:
        r121 = null;
        goto L49
    L39:
        if (r117.a() == true) goto L41;
        r112.setGeckoSource(GeckoSource.REMOTE_SETTING);
        r112.getGeckoModel().f244349b = r117.f244349b;
        r112.getGeckoModel().f244350c = r117.f244350c;
        goto L41
    L35:
        r116 = null;
        goto L36
    L25:
        if (r108.length() == 0) goto L28;
        r109 = false;
        goto L29
    L21:
        r108 = null;
        goto L23
    L5:
        r103 = null;
        goto L6
    }

    public final void getGeckoResourceData(Response r210, String r211, String r212, Long r213, GeckoConfig r214, Function1<? super e, Unit> r215) {
        String r100 = r214.f244241b;
        boolean r101 = false;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
    L80:
        r215.invoke(new e(new com.bytedance.iesgurd.f(Integer.MIN_VALUE, "ak/channel/bundle is empty", 60), IESGurdResFrom.NONE, 0, null, 28));
        return;
    L9:
        if (r211.length() != 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L80;
        if (r212.length() != 0) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == true) goto L80;
        PolarisFileWrapper r105 = r214.a(this.f244193app);
        Request r110 = r210.f244315q;
        String r111 = r110.getSessionId();
        if (r111 != null) goto L22;
    L25:
        boolean r112 = true;
    L26:
        if (r112 == true) goto L59;
        g r106 = this.forest.getSessionManager$forest_release();
        r106.getClass();
        Pair r107 = TuplesKt.to(r111, r100);
        Map<Pair<String, String>, uy5.c> r108 = r106.f244206a;
        monitor-enter(r108);
        LinkedHashMap r113 = (LinkedHashMap) r106.f244206a;     // Catch: Throwable -> L56
        uy5.c r114 = (uy5.c) r113.get(r107);     // Catch: Throwable -> L56
        if (r114 == null) goto L33;
        monitor-exit(r108);
    L84:
        String r115 = r114.a(r211 + File.separator + r212);     // Catch: Throwable -> L46
        if (r115 == null) goto L49;
        IESGurdResFrom r116 = IESGurdResFrom.OFFLINE;     // Catch: Throwable -> L46
        if (r213 == null) goto L40;
        Long r109 = r213;
    L41:
        if (r109 == null) goto L43;
        long r117 = r109.longValue();     // Catch: Throwable -> L46
    L44:
        e r118 = new e(null, r116, r117, r115, 17);     // Catch: Throwable -> L46
        r114.b();
    L52:
        r215.invoke(r118);
        return;
    L43:
        r117 = 0;
        goto L44
    L40:
        r109 = (Long) ((HashMap) r114.f552136a.c()).get(r211);     // Catch: Throwable -> L46
        goto L41
    L49:
        throw new IllegalStateException("can not get file path from gecko");     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        com.bytedance.forest.utils.i.f244548a.c(TAG, "get file data for " + r100 + '/' + r211 + '/' + r212 + " from gecko failed", th);     // Catch: Throwable -> L53
        e r119 = new e(new com.bytedance.iesgurd.f(Integer.MIN_VALUE, th.getMessage(), 60), IESGurdResFrom.NONE, 0, null, 28);     // Catch: Throwable -> L53
        r114.b();
        r118 = r119;
    L53:
        th = move-exception;
        r114.b();
        throw th;
    L33:
        r114 = new uy5.c(r106.f244207b, r100, r105);     // Catch: Throwable -> L56
        r113.put(r107, r114);     // Catch: Throwable -> L56
        monitor-exit(r108);
    L56:
        th = move-exception;
        throw th;
    L59:
        String r120 = r214.f244241b;
        if (Forest.Companion.getDelegateUpdateByGecko$forest_release() == true) goto L62;
    L68:
        boolean r121 = false;
    L70:
        if (r110.getOnlyLocal() == false) goto L72;
    L77:
        r101 = true;
    L78:
        com.bytedance.iesgurd.g r122 = new com.bytedance.iesgurd.g("Forest", r120, r211, r212, r101, r121, r105.getAbsolutePath(), 160);
        Map<String, com.bytedance.iesgurd.c> r123 = IESGurdKit.f250623a;
        new ResLoader(r122, r215).c();
        return;
    L72:
        if (r110.getNeedLocalFile() == true) goto L77;
        if (r110.getDisableCdn() == true) goto L77;
        if (r110.getLoadToMemory() == true) goto L78;
    L62:
        if (r110.getOnlyLocal() == true) goto L68;
        if (r110.getDisableGeckoUpdate() == true) goto L68;
        if (r110.getWaitGeckoUpdate() == false) goto L68;
        r121 = true;
        goto L70
    L22:
        if (r111.length() == 0) goto L25;
        r112 = false;
        goto L26
    L16:
        r104 = false;
        goto L17
    L11:
        r103 = false;
        goto L12
    L5:
        r102 = false;
        goto L7
    }

    public static /* synthetic */ void getGeckoResourceData$default(GeckoXAdapter r100, Response r101, String r102, String r110, Long r111, GeckoConfig r112, Function1 r113, int r114, Object r115) {
        if ((r114 & 8) == 0) goto L5;
        r111 = null;
    L5:
        r100.getGeckoResourceData(r101, r102, r110, r111, r112, r113);
    }
}
