package com.ss.android.lark.framework.assembly.featuregating;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import c3c.f;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.entity.DeviceId;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;
import opb.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class FeatureGatingModuleDependency extends c0c.b implements fdb.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f425637f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f425638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final epb.a f425639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final yzb.b f425640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<hdb.a> f425641e;

    /* JADX INFO: renamed from: com.ss.android.lark.framework.assembly.featuregating.FeatureGatingModuleDependency$1, reason: invalid class name */
    public class AnonymousClass1 implements IGetDataCallback<DeviceId> {
        final /* synthetic */ FeatureGatingModuleDependency this$0;
        final /* synthetic */ String val$apiDomain;
        final /* synthetic */ IGetDataCallback val$callback;
        final /* synthetic */ Map val$header;
        final /* synthetic */ bjb.b val$networkClient;

        public static /* synthetic */ void a(AnonymousClass1 r100, bjb.b r101, String r102, Map r103, IGetDataCallback r104) {
            r100.lambda$onSuccess$0(r101, r102, r103, r104);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.larksuite.framework.callback.IGetDataCallback
        public void onError(ErrorResult r100) {
            Log.i("FeatureGatingModuleDependency", "getDeviceId failed, e: " + r100);
        }

        public void onSuccess(DeviceId r110) {
            Log.i("FeatureGatingModuleDependency", "getDeviceId success");
            FeatureGatingModuleDependency r100 = this.this$0;
            String r111 = r110.getDeviceId();
            int r101 = FeatureGatingModuleDependency.f425637f;
            r100.getClass();
            String r102 = Integer.toString(LarkAppContext.inst().appIdInfo().f18218a);
            HashMap r103 = new HashMap();
            if (r111 == null) goto L5;
            r103.put("device_id", r111);
        L5:
            r103.put("app_id", r102);
            r103.put(PromotionProductPrivilegesStruct.TAGS, "NO_USER_FG");
            FeatureGatingModuleDependency r112 = this.this$0;
            String r104 = this.val$apiDomain;
            r112.getClass();
            if (TextUtils.isEmpty(r104) == false) goto L10;
            String r113 = "";
        L8:
            final String r105 = r113;
            Log.i("FeatureGatingModuleDependency", "api domain: " + this.val$apiDomain + ", settings url: " + r105 + ", queryParams: " + r103);
            if (TextUtils.isEmpty(r105) == false) goto L20;
            return;
        L20:
            if (CollectionUtils.isEmpty(r103) == true) goto L26;
            ExecutorService r114 = CoreThreadPool.getDefault().getFixedThreadPool();
            final bjb.b r106 = this.val$networkClient;
            final Map r107 = this.val$header;
            final IGetDataCallback r108 = this.val$callback;
            r114.execute(new a(this, r106, r105, r107, r108));
            return;
        L26:
            return;
        L10:
            if (r104.startsWith("https://") == true) goto L12;
            r104 = "https://".concat(r104);
        L12:
            Uri.Builder r115 = UriProtector.parse(r104).buildUpon();
            r115.appendPath("/settings/v3/");
            Iterator r109 = r103.entrySet().iterator();
        L14:
            if (r109.hasNext() == false) goto L16;
            Map.Entry r116 = (Map.Entry) r109.next();
            r115.appendQueryParameter((String) r116.getKey(), (String) r116.getValue());
            goto L14
        L16:
            r113 = r115.build().toString();
            goto L8
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
            onError(r100);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
            onSuccess((DeviceId) r100);
        }

        private /* synthetic */ void lambda$onSuccess$0(bjb.b r100, String r101, Map r102, IGetDataCallback r103) {
            r103.onSuccess(FeatureGatingModuleDependency.rf(this.this$0, r100.get(r101, r102, new NetworkClient.ReqContext())));     // Catch: Exception -> L5
            Log.i("FeatureGatingModuleDependency", "request settings success");     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            r103.onError(new ErrorResult(e));
            Log.e("FeatureGatingModuleDependency", "request settings failed, e: " + e);
        }

        public AnonymousClass1(FeatureGatingModuleDependency r100, String r101, bjb.b r102, Map r103, IGetDataCallback r104) {
            this.this$0 = r100;
            this.val$apiDomain = r101;
            this.val$networkClient = r102;
            this.val$header = r103;
            this.val$callback = r104;
        }
    }

    @Override // fdb.b
    public final void N8() {
        e.a.f524824a.e();
    }

    @Override // fdb.b
    public final String getUserId() {
        return this.f425640d.c();
    }

    @Override // fdb.b
    public final int Ue() {
        return ((FeatureGatingUseSettingConfig) SettingManager.getInstance().get(FeatureGatingUseSettingConfig.class)).fgKeyCapacity;
    }

    @Override // fdb.b
    public final Boolean Y() {
        return Boolean.valueOf(LarkAppContext.inst().buildConfig().isOfficeSDK());
    }

    @Override // fdb.b
    public Context getContext() {
        return LarkContext.getApplication();
    }

    @Override // fdb.b
    public final int mc() {
        return ((FeatureGatingUseSettingConfig) SettingManager.getInstance().get(FeatureGatingUseSettingConfig.class)).fgMemoryLimit;
    }

    @Override // fdb.b
    public final boolean e6(String r100) {
        new i3c.b(f.a());
        int r101 = i3c.b.f488116b;
        if (FeatureGatingModule.getFeatureGatingService().isNoUserFGEnable("lazy_load_fg_barrier_before_login") == true) goto L8;
        Boolean r102 = (Boolean) ((HashMap) i3c.b.f488117c).get(r100);
        if (r102 != null) goto L13;
    L10:
        return false;
    L13:
        return r102.booleanValue();
    L8:
        Boolean r103 = (Boolean) ((HashMap) i3c.b.f488118d).get(r100);
        if (r103 == null) goto L10;
        return r103.booleanValue();
    }

    @Override // fdb.b
    public final boolean e9(String r100) {
        return Boolean.parseBoolean(SettingManager.getInstance().getSettingConfig(r100, false));
    }

    @Override // c0c.b
    public final void nf(f0c.b r100) {
        Log.i("FeatureGatingModuleDependency", "onPrepared");
        Scene r101 = r100.f475024b.f475036b;
        if (Scene.FIRST_ONLINE.equals(r101) == false) goto L5;
    L8:
        Iterator r102 = ((ArrayList) this.f425641e).iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        ((hdb.a) r102.next()).a();
        goto L10
    L14:
        return;
    L5:
        if (Scene.FAST_ONLINE.equals(r101) == true) goto L8;
        if (Scene.SWITCH_ONLINE.equals(r101) == true) goto L8;
    }

    @Override // fdb.b
    public final void ve(ndb.a r100) {
        ((ArrayList) this.f425641e).add(r100);
    }

    public static Map rf(FeatureGatingModuleDependency r100, String r101) {
        r100.getClass();
        Gson r102 = new Gson();
        HashMap r103 = new HashMap();
        Iterator<Map.Entry<String, JsonElement>> r104 = ((c) r102.fromJson(r101, c.class)).data.entrySet().iterator();     // Catch: Exception -> L13
    L5:
        if (r104.hasNext() == false) goto L11;
        Map.Entry<String, JsonElement> r105 = r104.next();     // Catch: Exception -> L13
        JsonElement r106 = r105.getValue();     // Catch: Exception -> L13
        if (r106.isJsonPrimitive() == false) goto L5;
        if (r106.getAsJsonPrimitive().isBoolean() == false) goto L5;
        r103.put(r105.getKey(), Boolean.valueOf(r106.getAsBoolean()));     // Catch: Exception -> L13
        goto L5
    L11:
        Log.i("FeatureGatingModuleDependency", "getSettingsFGMap success, settingsFGMap: " + r103.toString());     // Catch: Exception -> L13
    L15:
        return r103;
    L13:
        e = move-exception;
        Log.e("FeatureGatingModuleDependency", "getSettingsFGMap failed, e: " + e);
        goto L15
    }

    @Override // fdb.b
    public final void ic(Context r100, IGetDataCallback<Map<String, Boolean>> r110) {
        bjb.b r101 = new bjb.b(bjb.e.a());
        String r102 = jcb.b.c().a("api");
        HashMap r103 = new HashMap();
        r103.put("Accept-Encoding", "gzip,deflate,br");
        r103.put("X-LS-Caller-Type", "native");
        this.f425639c.getDeviceId(LarkContext.getApplication(), new AnonymousClass1(this, r102, r101, r103, r110));
    }

    @Override // fdb.b
    public final void sendEvent(String r100, JSONObject r101) {
        Statistics.sendEvent(r100, r101);
    }

    @Inject
    public FeatureGatingModuleDependency(j r100, epb.a r101, yzb.b r102) {
        super(r100);
        this.f425641e = new ArrayList();
        this.f425638b = r100;
        this.f425639c = r101;
        this.f425640d = r102;
        h.a(this);
    }
}
