package com.huawei.agconnect.core.a;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.impl.Utils;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class b extends AGConnectInstance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<Service> f276753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, AGConnectInstance> f276754b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f276755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AGConnectOptions f276756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d f276757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f276758f;

    static {
        f276754b = new HashMap();
    }

    public b(AGConnectOptions r100) {
        this.f276756d = r100;
        this.f276757e = new d(f276753a, r100.getContext());
        d r101 = new d(null, r100.getContext());
        this.f276758f = r101;
        if ((r100 instanceof com.huawei.agconnect.config.impl.b) == false) goto L6;
        r101.a(((com.huawei.agconnect.config.impl.b) r100).a(), r100.getContext());
        return;
    }

    public static AGConnectInstance a() {
        String r100 = f276755c;
        if (r100 != null) goto L6;
        r100 = Utils.DEFAULT_NAME;
    L6:
        return a(r100);
    }

    public static AGConnectInstance a(AGConnectOptions r100) {
        return a(r100, false);
    }

    private static synchronized AGConnectInstance a(AGConnectOptions r100, boolean r101) {
        monitor-enter(b.class);
        Map<String, AGConnectInstance> r102 = f276754b;     // Catch: Throwable -> L10
        AGConnectInstance r103 = r102.get(r100.getIdentifier());     // Catch: Throwable -> L10
        if (r103 == null) goto L7;
        if (r101 == true) goto L7;
    L8:
        monitor-exit(b.class);
        return r103;
    L7:
        r103 = new b(r100);     // Catch: Throwable -> L10
        r102.put(r100.getIdentifier(), r103);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized AGConnectInstance a(String r100) {
        monitor-enter(b.class);
        AGConnectInstance r101 = f276754b.get(r100);     // Catch: Throwable -> L12
        if (r101 == null) goto L7;
    L10:
        monitor-exit(b.class);
        return r101;
    L7:
        if (Utils.DEFAULT_NAME.equals(r100) == true) goto L10;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(Context r100) {
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f276754b.size() <= 0) goto L8;
        monitor-exit(b.class);
        return;
    L8:
        a(r100, AGConnectServicesConfig.fromContext(r100));     // Catch: Throwable -> L11
        monitor-exit(b.class);
    }

    private static synchronized void a(Context r100, AGConnectOptions r101) {
        monitor-enter(b.class);
        Context r102 = r100.getApplicationContext();     // Catch: Throwable -> L14
        if (r102 == null) goto L8;
        r100 = r102;
    L8:
        b();     // Catch: Throwable -> L14
        if (f276753a != null) goto L11;
        f276753a = new c(r100).a();     // Catch: Throwable -> L14
    L11:
        a(r101, true);     // Catch: Throwable -> L14
        f276755c = r101.getIdentifier();     // Catch: Throwable -> L14
        a.a();     // Catch: Throwable -> L14
        monitor-exit(b.class);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(Context r100, AGConnectOptionsBuilder r101) {
        monitor-enter(b.class);
        b(r100, r101);     // Catch: Throwable -> L7
        a(r100, r101.build(r100));     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void b() {
        JsonProcessingFactory.registerProcessor("/agcgw/url", new AnonymousClass1());
        JsonProcessingFactory.registerProcessor("/agcgw/backurl", new AnonymousClass2());
    }

    private static void b(Context r100, AGConnectOptionsBuilder r101) {
        AGConnectServicesConfig r102 = AGConnectServicesConfig.fromContext(r100);
        if (r101.getInputStream() != null) goto L14;
    L5:
        Iterator<Map.Entry<String, String>> r103 = r101.getCustomConfigMap().entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, String> r104 = r103.next();
        r102.setParam(r104.getKey(), r104.getValue());
        goto L7
    L10:
        if (r101.getRoutePolicy() == AGCRoutePolicy.UNKNOWN) goto L17;
        r102.setRoutePolicy(r101.getRoutePolicy());
        return;
    L17:
        return;
    L14:
        String r105 = Utils.toString(r101.getInputStream(), "UTF-8");     // Catch: IOException -> L13
        r101.getInputStream().reset();     // Catch: IOException -> L13
        r102.overlayWith(new ByteArrayInputStream(r105.getBytes(Charset.forName("UTF-8"))));     // Catch: IOException -> L13
        goto L5
    }

    public void a(final CustomAuthProvider r100) {
        Service r101 = Service.builder(AuthProvider.class, new AnonymousClass4(this, r100)).build();
        this.f276758f.a(Collections.singletonList(r101), this.f276756d.getContext());
    }

    public void a(final CustomCredentialsProvider r100) {
        Service r101 = Service.builder(CredentialsProvider.class, new AnonymousClass3(this, r100)).build();
        this.f276758f.a(Collections.singletonList(r101), this.f276756d.getContext());
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public Context getContext() {
        return this.f276756d.getContext();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public String getIdentifier() {
        return this.f276756d.getIdentifier();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public AGConnectOptions getOptions() {
        return this.f276756d;
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public <T> T getService(Class<? super T> r100) {
        T r101 = (T) this.f276758f.a(this, r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return (T) this.f276757e.a(this, r100);
    }
}
