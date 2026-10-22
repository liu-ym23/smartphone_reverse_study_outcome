package com.ss.android.lark.appsetting.api.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.settings.v1.GetCommonSettingsRequest;
import com.bytedance.lark.pb.settings.v1.GetUserSettingsRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appsetting.api.AppSettingApiModule;
import com.ss.android.lark.framework.assembly.appconfig.AppSettingDependencyImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import idb.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.appsetting.api.a.InterfaceC4749a f408954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f408955b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f408956a = null;

        static {
            f408956a = new d();
        }
    }

    public interface b {
        void a();

        void onError(ErrorResult r100);
    }

    public d() {
        this.f408955b = new CopyOnWriteArrayList();
        this.f408954a = AppSettingApiModule.a().getFeatureGatingDependency();
    }

    public final void a(List r100, opb.d r110) {
        Log.i("SettingFetcherImpl", "fetchSettings");
        final c r101 = new c(this, r110);
        GetUserSettingsRequest.Builder r111 = new GetUserSettingsRequest.Builder().fields(r100);
        SyncDataStrategy r102 = SyncDataStrategy.LOCAL;
        r111.sync_data_strategy(r102);
        Boolean r103 = Boolean.FALSE;
        r111.need_domain(r103);
        StringBuilder r104 = new StringBuilder("fetchUserSettings, fetch config keys size: ");
        ArrayList r105 = (ArrayList) r100;
        r104.append(r105.size());
        r104.append(", uid: ");
        r104.append(AppSettingApiModule.a().getUid());
        Log.i("SettingFetcherImpl", r104.toString());
        SdkSender.asynSendRequestNonWrap(Command.GET_USER_SETTINGS, r111, new SettingFetcherImpl$3(this, r101), new com.ss.android.lark.appsetting.api.service.a());
        GetCommonSettingsRequest.Builder r106 = new GetCommonSettingsRequest.Builder().fields(r100);
        r106.sync_data_strategy(r102);
        r106.need_domain(r103);
        Log.i("SettingFetcherImpl", "fetchCommonSettings, fetch config keys size: " + r105.size());
        String r112 = AppSettingApiModule.a().getBrand();
        int r107 = AppSettingApiModule.a().getType();
        InitSDKRequest.EnvV2 r108 = null;
        if (r107 != 1) goto L5;
        InitSDKRequest.EnvV2.Type r109 = InitSDKRequest.EnvV2.Type.RELEASE;
    L12:
        String r113 = AppSettingApiModule.a().getUnit();
        Log.d("SettingFetcherImpl", "env, brand: " + r112 + ", type: " + r109 + ", unit: " + r113);
        if (TextUtils.isEmpty(r112) == true) goto L18;
        if (r109 == null) goto L18;
        if (TextUtils.isEmpty(r113) == true) goto L18;
        r108 = new InitSDKRequest.EnvV2.Builder().brand(r112).type(r109).unit(r113).build();
    L18:
        if (r108 == null) goto L20;
        r106.env_v2(r108);
        SdkSender.asynSendRequestNonWrap(Command.GET_COMMON_SETTINGS, r106, new SettingFetcherImpl$2(this, r101), new com.ss.android.lark.appsetting.api.service.b());
        return;
    L20:
        Log.e("SettingFetcherImpl", "fetchCommonSettings, err, env is illegal.");
        r101.onError(new ErrorResult("fetchCommonSettings, err, env is illegal."));
        return;
    L5:
        if (r107 != 2) goto L7;
        r109 = InitSDKRequest.EnvV2.Type.STAGING;
        goto L12
    L7:
        if (r107 == 3) goto L9;
        Log.e("SettingFetcherImpl", "type err: " + r107);
        r109 = null;
        goto L12
    L9:
        r109 = InitSDKRequest.EnvV2.Type.PRE_RELEASE;
        goto L12
    }

    public final void b(Map<String, String> r100, String r101) {
        ((AppSettingDependencyImpl.a) this.f408954a).getClass();
        Set<String> r102 = f.a().getSettingsFGKeys();
        if (r100 == null) goto L18;
        if (r102 == null) goto L19;
        HashSet r103 = new HashSet(r102);
        HashMap r104 = new HashMap();
        Iterator r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        String r106 = (String) r105.next();
        if (r100.containsKey(r106) == false) goto L7;
        r104.put(r106, Boolean.valueOf(Boolean.parseBoolean(r100.get(r106))));
        goto L7
    L11:
        ((AppSettingDependencyImpl.a) this.f408954a).getClass();
        f.a().notifySettingsFGChanged(r104, r101);
        return;
    L19:
        return;
    }
}
