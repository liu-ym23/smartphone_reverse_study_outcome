package com.ss.ugc.clientai.core.api;

import com.alipay.sdk.m.u.i;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016R2\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/ss/ugc/clientai/core/api/SmartServiceConfig;", "", "", "", "configMap", "toString", "extConfigMap", "Ljava/util/Map;", "getExtConfigMap", "()Ljava/util/Map;", "setExtConfigMap", "(Ljava/util/Map;)V", "extConfigObj", "Ljava/lang/Object;", "getExtConfigObj", "()Ljava/lang/Object;", "setExtConfigObj", "(Ljava/lang/Object;)V", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "core-api_release"}, k = 1, mv = {1, 4, 1})
public class SmartServiceConfig {
    public static final a Companion = null;
    private Map<String, Object> extConfigMap;
    private Object extConfigObj;
    private final String name;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final Map<String, Object> configMap() {
        Map<String, Object> r100 = this.extConfigMap;
        if (r100 == null) goto L5;
        return r100;
    L5:
        HashMap r101 = new HashMap();
        this.extConfigMap = r101;
        return r101;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("{");
        if (this.extConfigMap == null) goto L6;
        r100.append("extConfigMap:" + this.extConfigMap);
    L6:
        if (this.extConfigObj == null) goto L12;
        StringBuilder r101 = new StringBuilder(", extConfigObj:");
        Object r102 = this.extConfigObj;
        if (r102 == null) goto L10;
        String r103 = r102.getClass().getName();
    L11:
        r101.append(r103);
        r100.append(r101.toString());
        goto L12
    L10:
        r103 = null;
    L12:
        r100.append(i.f25855d);
        return r100.toString();
    }

    public final Map<String, Object> getExtConfigMap() {
        return this.extConfigMap;
    }

    public final Object getExtConfigObj() {
        return this.extConfigObj;
    }

    public final String getName() {
        return this.name;
    }

    public SmartServiceConfig(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.name = r100;
    }

    public final void setExtConfigMap(Map<String, Object> r100) {
        this.extConfigMap = r100;
    }

    public final void setExtConfigObj(Object r100) {
        this.extConfigObj = r100;
    }
}
