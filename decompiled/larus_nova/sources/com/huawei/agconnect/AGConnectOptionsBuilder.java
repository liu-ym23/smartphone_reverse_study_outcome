package com.huawei.agconnect;

import android.content.Context;
import com.huawei.agconnect.config.impl.b;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class AGConnectOptionsBuilder {
    private static final String API_KEY_PATH = "/client/api_key";
    private static final String APP_ID_PATH = "/client/app_id";
    private static final String CLIENT_ID_PATH = "/client/client_id";
    private static final String CLIENT_SECRET_PATH = "/client/client_secret";
    private static final String CP_ID_PATH = "/client/cp_id";
    private static final String PRODUCT_ID_PATH = "/client/product_id";
    private final Map<String, String> customConfigMap;
    private final List<Service> customServices;
    private InputStream inputStream;
    private String packageName;
    private AGCRoutePolicy routePolicy;

    public AGConnectOptionsBuilder() {
        this.routePolicy = AGCRoutePolicy.UNKNOWN;
        this.customConfigMap = new HashMap();
        this.customServices = new ArrayList();
    }

    public AGConnectOptions build(Context r110) {
        return new b(r110, this.packageName, this.routePolicy, this.inputStream, this.customConfigMap, this.customServices, null);
    }

    public AGConnectOptions build(Context r110, String r111) {
        return new b(r110, this.packageName, this.routePolicy, this.inputStream, this.customConfigMap, this.customServices, r111);
    }

    public Map<String, String> getCustomConfigMap() {
        return new HashMap(this.customConfigMap);
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public AGCRoutePolicy getRoutePolicy() {
        return this.routePolicy;
    }

    public AGConnectOptionsBuilder setApiKey(String r100) {
        this.customConfigMap.put(API_KEY_PATH, r100);
        return this;
    }

    public AGConnectOptionsBuilder setAppId(String r100) {
        this.customConfigMap.put(APP_ID_PATH, r100);
        return this;
    }

    public AGConnectOptionsBuilder setCPId(String r100) {
        this.customConfigMap.put(CP_ID_PATH, r100);
        return this;
    }

    public AGConnectOptionsBuilder setClientId(String r100) {
        this.customConfigMap.put(CLIENT_ID_PATH, r100);
        return this;
    }

    public AGConnectOptionsBuilder setClientSecret(String r100) {
        this.customConfigMap.put(CLIENT_SECRET_PATH, r100);
        return this;
    }

    public AGConnectOptionsBuilder setCustomAuthProvider(final CustomAuthProvider r100) {
        if (r100 == null) goto L4;
        Service r101 = Service.builder(AuthProvider.class, new AnonymousClass2(this, r100)).build();
        this.customServices.add(r101);
    L4:
        return this;
    }

    public AGConnectOptionsBuilder setCustomCredentialProvider(final CustomCredentialsProvider r100) {
        if (r100 == null) goto L4;
        Service r101 = Service.builder(CredentialsProvider.class, new AnonymousClass1(this, r100)).build();
        this.customServices.add(r101);
    L4:
        return this;
    }

    public AGConnectOptionsBuilder setCustomValue(String r100, String r101) {
        this.customConfigMap.put(r100, r101);
        return this;
    }

    public AGConnectOptionsBuilder setInputStream(InputStream r100) {
        this.inputStream = r100;
        return this;
    }

    public AGConnectOptionsBuilder setPackageName(String r100) {
        this.packageName = r100;
        return this;
    }

    public AGConnectOptionsBuilder setProductId(String r100) {
        this.customConfigMap.put(PRODUCT_ID_PATH, r100);
        return this;
    }

    public AGConnectOptionsBuilder setRoutePolicy(AGCRoutePolicy r100) {
        this.routePolicy = r100;
        return this;
    }
}
