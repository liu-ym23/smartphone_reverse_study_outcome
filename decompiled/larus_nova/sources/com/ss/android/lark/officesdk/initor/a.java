package com.ss.android.lark.officesdk.initor;

import com.alipay.sdk.m.u.i;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.basic.v1.NetDecorator;
import com.ss.android.lark.framework.assembly.rust.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.HostUriParamGroup;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKHostAppHeaderProvider;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IOfficeSDKConfigProvider f433257a;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.initor.a$a, reason: collision with other inner class name */
    public static final class C5153a {
    }

    static {
    }

    @Inject
    public a(IOfficeSDKConfigProvider r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKConfigProvider");
        this.f433257a = r100;
    }

    @Override // com.ss.android.lark.framework.assembly.rust.c
    public final void interceptRustInitRequest(InitSDKRequest.Builder r110) {
        if (this.f433257a.isDebug() == false) goto L5;
        r110.is_anydoor_enable(Boolean.TRUE);
        Log.i("DevRustInitIntercept", "AnyDoor enabled for OfficeSDK debug package");
    L5:
        String r100 = this.f433257a.getAppId();
        if (r100 == null) goto L8;
        r110.app_id(r100);
    L8:
        String r101 = this.f433257a.getHostAppVersion();
        boolean r102 = false;
        if (r101 != null) goto L11;
    L19:
        String r103 = this.f433257a.getAppName();
        if (r103 == null) goto L31;
        if (r103.length() <= 0) goto L24;
        boolean r104 = true;
    L25:
        if (r104 == false) goto L31;
        Map<String, String> r105 = r110.customized_init_meta;
        if (r105 != null) goto L29;
        r105 = MapsKt.emptyMap();
    L29:
        Map<String, String> r106 = MapsKt.toMutableMap(r105);
        r106.put("host_app_name", r103);
        r110.customized_init_meta(r106);
        goto L31
    L24:
        r104 = false;
    L31:
        if (this.f433257a.isDebug() == false) goto L50;
        Object r107 = null;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L41
        String r109 = LarkContext.getApplication().getSharedPreferences("office_sdk_env_prefs", 0).getString("tt_env", "");     // Catch: Throwable -> L41
        if (r109 != null) goto L36;
    L38:
        r109 = null;
    L39:
        Object r111 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L41
    L44:
        if (Result.m9455isFailureimpl(r111) == true) goto L47;
        r107 = r111;
    L47:
        String r112 = (String) r107;
        if (r112 == null) goto L50;
        Log.i("DevRustInitIntercept", "use debug tt env from office sdk panel");
    L51:
        if (r112 == null) goto L53;
        r110.x_tt_env(r112);
    L53:
        Integer r113 = this.f433257a.getEnv();
        if (r113 == null) goto L56;
        int r114 = r113.intValue();
        gpb.a r115 = (gpb.a) ApiUtils.getApi(gpb.a.class);
        r110.env_v2(new InitSDKRequest.EnvV2.Builder().type(InitSDKRequest.EnvV2.Type.fromValue(r114)).unit(r115.getUserUnit()).brand(r115.getTenantBrand()).build());
    L56:
        List<String> r116 = this.f433257a.getJournalPaths();
        if ((!r116.isEmpty()) == false) goto L62;
        Map<String, String> r117 = r110.customized_init_meta;
        if (r117 != null) goto L61;
        r117 = MapsKt.emptyMap();
    L61:
        Map<String, String> r118 = MapsKt.toMutableMap(r117);
        r118.put("host_journal_paths", new JSONArray(r116).toString());
        r110.customized_init_meta(r118);
    L62:
        String r119 = this.f433257a.getRequestTagBase();
        if (r119 == null) goto L74;
        String r120 = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.map(CollectionsKt.asSequence(StringsKt.split$default(r119, new String[]{i.f25853b}, false, 0, 6, null)), DevRustInitIntercept$toRequestTagInitMeta$1.INSTANCE), DevRustInitIntercept$toRequestTagInitMeta$2.INSTANCE));
        if (r120 == null) goto L74;
        if (r120.length() <= 0) goto L69;
        r102 = true;
    L69:
        if (r102 == false) goto L74;
        Map<String, String> r121 = r110.customized_init_meta;
        if (r121 != null) goto L73;
        r121 = MapsKt.emptyMap();
    L73:
        Map<String, String> r122 = MapsKt.toMutableMap(r121);
        r122.put(OfficeSDKRequestTag.INIT_META_KEY, r120);
        r110.customized_init_meta(r122);
        Log.i("DevRustInitIntercept", "request tag init meta applied");
    L74:
        Boolean r123 = this.f433257a.isEnableNewTtnetLogReporter();
        if (r123 == null) goto L77;
        boolean r124 = r123.booleanValue();
        r110.enable_new_ttnet_log_reporter(Boolean.valueOf(r124));
        Log.i("DevRustInitIntercept", "enable_new_ttnet_log_reporter applied: " + r124);
    L77:
        IOfficeSDKHostAppHeaderProvider r125 = this.f433257a.getHostAppHeaderProvider();
        if (r125 == null) goto L127;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L81
        Object r127 = Result.m9449constructorimpl(r125.getOfficeSDKHeader());     // Catch: Throwable -> L81
    L84:
        if (Result.m9456isSuccessimpl(r127) == false) goto L111;
        List r128 = (List) r127;
        Log.i("DevRustInitIntercept", "HostApp header groups fetched, count=" + r128.size());
        List r129 = r128;
        Iterator r130 = r129.iterator();
    L87:
        if (r130.hasNext() == false) goto L98;
        HostUriParamGroup r131 = (HostUriParamGroup) r130.next();
        Set<String> r132 = r131.getUris();
        if (r132 == null) goto L94;
        Iterator<T> r133 = r132.iterator();
    L92:
        if (r133.hasNext() == false) goto L94;
        Log.d("DevRustInitIntercept", "HostApp header init uri: " + ((String) r133.next()));
    L94:
        Iterator<Map.Entry<String, String>> r134 = r131.getParams().entrySet().iterator();
    L96:
        if (r134.hasNext() == false) goto L87;
        Log.d("DevRustInitIntercept", "HostApp header init param: " + r134.next());
        goto L96
    L98:
        ArrayList r135 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
        Iterator r136 = r129.iterator();
    L100:
        if (r136.hasNext() == false) goto L118;
        HostUriParamGroup r137 = (HostUriParamGroup) r136.next();
        Set<String> r138 = r137.getUris();
        if (r138 == null) goto L105;
        List<String> r139 = CollectionsKt.toList(r138);
        if (r139 == null) goto L105;
    L106:
        r135.add(new NetDecorator.Builder().urls(r139).headers(r137.getParams()).build());
    L105:
        r139 = CollectionsKt.emptyList();
        goto L106
    L118:
        r110.net_decorators(r135);     // Catch: Throwable -> L109
        Log.i("DevRustInitIntercept", "net_decorators applied: groups=" + r135.size());     // Catch: Throwable -> L109
    L109:
        th = move-exception;
        Log.e("DevRustInitIntercept", "apply net_decorators failed", th);
    L111:
        Throwable r140 = Result.m9452exceptionOrNullimpl(r127);
        if (r140 == null) goto L114;
        Log.e("DevRustInitIntercept", "fetch HostApp header groups failed", r140);
    L114:
        Result.m9448boximpl(r127);
        return;
    L81:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L84
    L127:
        return;
    L36:
        if ((!StringsKt.isBlank(r109)) == false) goto L38;
    L41:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L50:
        r112 = this.f433257a.getTTEnv();
        goto L51
    L11:
        if (r101.length() <= 0) goto L13;
        boolean r143 = true;
    L14:
        if (r143 == false) goto L19;
        Map<String, String> r144 = r110.customized_init_meta;
        if (r144 != null) goto L18;
        r144 = MapsKt.emptyMap();
    L18:
        Map<String, String> r145 = MapsKt.toMutableMap(r144);
        r145.put("host_app_version", r101);
        r110.customized_init_meta(r145);
        goto L19
    L13:
        r143 = false;
        goto L14
    }
}
