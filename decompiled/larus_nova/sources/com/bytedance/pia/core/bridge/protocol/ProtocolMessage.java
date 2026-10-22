package com.bytedance.pia.core.bridge.protocol;

import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.pia.core.utils.GsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0004\u001a\u001b\u001c\u001dR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage;", "", "Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Type;", "type", "Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Type;", "getType", "()Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Type;", "", "id", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Lcom/google/gson/JsonObject;", "data", "Lcom/google/gson/JsonObject;", "getData", "()Lcom/google/gson/JsonObject;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "status", "getStatus", "message", "getMessage", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "Type", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class ProtocolMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f266224a = 0;

    @SerializedName("data")
    private final JsonObject data;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final Integer f266225id;

    @SerializedName(LocationMonitorConst.ERR_MSG)
    private final String message;

    @SerializedName("name")
    private final String name;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("type")
    private final Type type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Type;", "", "(Ljava/lang/String;I)V", "Invocation", "Callback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;

        @SerializedName("callback")
        public static final Type Callback = null;

        @SerializedName("invocation")
        public static final Type Invocation = null;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{Invocation, Callback};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            Invocation = new Type("Invocation", 0);
            Callback = new Type("Callback", 1);
            $VALUES = $values();
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f266226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f266227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final JsonObject f266228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f266229d;

        public a(int r100, int r101, JsonObject r102, String r103) {
            this.f266226a = r100;
            this.f266227b = r101;
            this.f266228c = r102;
            this.f266229d = r103;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f266230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f266231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final JsonObject f266232c;

        public c(int r100, String r101, JsonObject r102) {
            Intrinsics.checkNotNullParameter(r101, "name");
            this.f266230a = r100;
            this.f266231b = r101;
            this.f266232c = r102;
        }
    }

    static {
    }

    public final a a() {
        if (Type.Callback == this.type) goto L5;
        return null;
    L5:
        Integer r100 = this.f266225id;
        if (r100 == null) goto L17;
        if (r100 == null) goto L13;
        if (r100.intValue() == 0) goto L17;
    L13:
        if (this.status != null) goto L16;
        return null;
    L16:
        return new a(this.f266225id.intValue(), this.status.intValue(), this.data, this.message);
    L17:
        return null;
    }

    public final c b() {
        if (Type.Invocation == this.type) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(this.name) == false) goto L8;
        return null;
    L8:
        Integer r100 = this.f266225id;
        if (r100 != null) goto L11;
        return null;
    L11:
        int r101 = r100.intValue();
        String r102 = this.name;
        Intrinsics.checkNotNull(r102);
        return new c(r101, r102, this.data);
    }

    public final Type getType() {
        return this.type;
    }

    @JvmStatic
    public static final JsonObject c(a r110) {
        int r100 = r110.f266226a;
        Object r101 = null;
        if (r100 == 0) goto L18;
        ProtocolMessage r102 = new ProtocolMessage(Type.Callback, Integer.valueOf(r100), r110.f266228c, null, Integer.valueOf(r110.f266227b), r110.f266229d);
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L8
        JsonElement r112 = GsonUtils.b().toJsonTree(r102);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type com.google.gson.JsonObject");     // Catch: Throwable -> L8
        Object r113 = Result.m9449constructorimpl((JsonObject) r112);     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r113) == true) goto L15;
        r101 = r113;
    L15:
        return (JsonObject) r101;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    L18:
        return null;
    }

    @JvmStatic
    public static final JsonObject d(c r100) {
        Object r101 = null;
        if (TextUtils.isEmpty(r100.f266231b) == true) goto L18;
        ProtocolMessage r102 = new ProtocolMessage(Type.Invocation, Integer.valueOf(r100.f266230a), r100.f266232c, r100.f266231b, null, null);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        JsonElement r104 = GsonUtils.b().toJsonTree(r102);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.google.gson.JsonObject");     // Catch: Throwable -> L8
        Object r105 = Result.m9449constructorimpl((JsonObject) r104);     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r105) == true) goto L15;
        r101 = r105;
    L15:
        return (JsonObject) r101;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    L18:
        return null;
    }

    public ProtocolMessage(Type r100, Integer r101, JsonObject r102, String r103, Integer r104, String r105) {
        this.type = r100;
        this.f266225id = r101;
        this.data = r102;
        this.name = r103;
        this.status = r104;
        this.message = r105;
    }
}
