package com.bytedance.ies.argus.bean.feStrategy;

import com.bytedance.ies.argus.bean.ArgusRouteRiskType;
import com.bytedance.ies.argus.bean.q;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/argus/bean/feStrategy/ArgusFeRouteSourceVerifyConfig;", "", "Lcom/bytedance/ies/argus/bean/ArgusRouteRiskType;", "routeSourceLimitType", "Lcom/bytedance/ies/argus/bean/ArgusRouteRiskType;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/ies/argus/bean/ArgusRouteRiskType;", "RouteSourceLimitTypeAdapter", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class ArgusFeRouteSourceVerifyConfig {

    @SerializedName("max_level")
    @JsonAdapter(RouteSourceLimitTypeAdapter.class)
    private final ArgusRouteRiskType routeSourceLimitType;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/argus/bean/feStrategy/ArgusFeRouteSourceVerifyConfig$RouteSourceLimitTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/bytedance/ies/argus/bean/ArgusRouteRiskType;", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class RouteSourceLimitTypeAdapter extends TypeAdapter<ArgusRouteRiskType> {
        public RouteSourceLimitTypeAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        public final ArgusRouteRiskType read(JsonReader r100) {
            Intrinsics.checkNotNullParameter(r100, "reader");
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
            Object r102 = Result.m9449constructorimpl(r100.nextString());     // Catch: Throwable -> L5
        L8:
            if (Result.m9455isFailureimpl(r102) == false) goto L10;
            r102 = null;
        L10:
            String r103 = (String) r102;
            if (r103 == null) goto L24;
            int r104 = q.f246041t1;
            ArgusRouteRiskType[] r105 = ArgusRouteRiskType.values();
            int r106 = r105.length;
            int r107 = 0;
        L14:
            if (r107 >= r106) goto L25;
            ArgusRouteRiskType r108 = r105[r107];
            if (Intrinsics.areEqual(r108.getStringValue(), r103) == true) goto L19;
            r107 = r107 + 1;
            goto L14
        L19:
            return r108;
        L25:
            return null;
        L24:
            return null;
        L5:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L8
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r100, ArgusRouteRiskType r101) {
            ArgusRouteRiskType r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "writer");
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
            if (r102 == null) goto L7;
            JsonWriter r104 = r100.value(r102.getStringValue());     // Catch: Throwable -> L10
            if (r104 == null) goto L7;
        L8:
            Result.m9449constructorimpl(r104);     // Catch: Throwable -> L10
            return;
        L7:
            r104 = r100.nullValue();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ArgusFeRouteSourceVerifyConfig) == true) goto L9;
        return false;
    L9:
        if (this.routeSourceLimitType == ((ArgusFeRouteSourceVerifyConfig) r100).routeSourceLimitType) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        ArgusRouteRiskType r100 = this.routeSourceLimitType;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "ArgusFeRouteSourceVerifyConfig(routeSourceLimitType=" + this.routeSourceLimitType + ')';
    }

    public ArgusFeRouteSourceVerifyConfig() {
        this.routeSourceLimitType = null;
    }

    public final ArgusRouteRiskType a() {
        return this.routeSourceLimitType;
    }
}
