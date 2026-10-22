package com.bytedance.sdk.bridge.model;

import android.text.TextUtils;
import com.bytedance.sdk.bridge.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/sdk/bridge/model/BridgeResult;", "", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "isRaw", "", "()Z", "setRaw", "(Z)V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "toJSON", "CODE", "Companion", "bridge_release"}, k = 1, mv = {1, 1, 15})
public final class BridgeResult {
    public static final Companion Companion = null;
    private static final String TAG = "BridgeResult";
    private int code;
    private JSONObject data;
    private boolean isRaw;
    private String message;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/bridge/model/BridgeResult$CODE;", "", "", "value", "I", "getValue", "()I", "SUCCESS", "ERROR", "NOT_FOUND", "NO_PRIVILEGE", "PARAMS_ERROR", "bridge_release"}, k = 1, mv = {1, 4, 0})
    public static final enum CODE extends Enum<CODE> {
        public static final CODE ERROR = null;
        public static final CODE NOT_FOUND = null;
        public static final CODE NO_PRIVILEGE = null;
        public static final CODE PARAMS_ERROR = null;
        public static final CODE SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CODE[] f269599a = null;
        private final int value;

        static {
            CODE r100 = new CODE("SUCCESS", 0, 1);
            SUCCESS = r100;
            CODE r101 = new CODE("ERROR", 1, 0);
            ERROR = r101;
            CODE r102 = new CODE("NOT_FOUND", 2, -2);
            NOT_FOUND = r102;
            CODE r103 = new CODE("NO_PRIVILEGE", 3, -1);
            NO_PRIVILEGE = r103;
            CODE r104 = new CODE("PARAMS_ERROR", 4, -3);
            PARAMS_ERROR = r104;
            f269599a = new CODE[]{r100, r101, r102, r103, r104};
        }

        public static CODE valueOf(String r100) {
            return (CODE) a.a(CODE.class, r100);
        }

        public static CODE[] values() {
            return (CODE[]) f269599a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public CODE(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J \u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J \u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J \u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0006\u0010\r\u001a\u00020\u0006J\u0012\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ\u001c\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J&\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/bridge/model/BridgeResult$Companion;", "", "()V", "TAG", "", "createErrorResult", "Lcom/bytedance/sdk/bridge/model/BridgeResult;", "message", "data", "Lorg/json/JSONObject;", "createMethodNotFoundResult", "createNoPrivilegeResult", "createParamsErrorResult", "createSuccessResult", "isRaw", "", "bridge_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public final BridgeResult createErrorResult() {
            return createErrorResult$default(this, null, null, 3, null);
        }

        public final BridgeResult createErrorResult(String r100) {
            return createErrorResult$default(this, r100, null, 2, null);
        }

        public final BridgeResult createMethodNotFoundResult() {
            return createMethodNotFoundResult$default(this, null, null, 3, null);
        }

        public final BridgeResult createMethodNotFoundResult(String r100) {
            return createMethodNotFoundResult$default(this, r100, null, 2, null);
        }

        public final BridgeResult createNoPrivilegeResult() {
            return createNoPrivilegeResult$default(this, null, null, 3, null);
        }

        public final BridgeResult createNoPrivilegeResult(String r100) {
            return createNoPrivilegeResult$default(this, r100, null, 2, null);
        }

        public final BridgeResult createParamsErrorResult() {
            return createParamsErrorResult$default(this, null, null, 3, null);
        }

        public final BridgeResult createParamsErrorResult(String r100) {
            return createParamsErrorResult$default(this, r100, null, 2, null);
        }

        public final BridgeResult createSuccessResult() {
            return createSuccessResult(null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final BridgeResult createSuccessResult(JSONObject r100) {
            return createSuccessResult(r100, "");
        }

        public final BridgeResult createErrorResult(String r100, JSONObject r101) {
            Logger r102 = Logger.f269563c;
            String.valueOf(r101);
            r102.getClass();
            Logger.a();
            BridgeResult r103 = new BridgeResult(null);
            r103.setCode(CODE.ERROR.getValue());
            if (TextUtils.isEmpty(r100) == true) goto L5;
            r103.setMessage(r100);
        L5:
            if (r101 == null) goto L7;
            r103.setData(r101);
        L7:
            return r103;
        }

        public final BridgeResult createMethodNotFoundResult(String r100, JSONObject r101) {
            Logger r102 = Logger.f269563c;
            String.valueOf(r101);
            r102.getClass();
            Logger.a();
            BridgeResult r103 = new BridgeResult(null);
            r103.setCode(CODE.NOT_FOUND.getValue());
            if (TextUtils.isEmpty(r100) == false) goto L5;
            r103.setMessage("the bridge is not found, are u register?");
        L6:
            if (r101 == null) goto L8;
            r103.setData(r101);
        L8:
            return r103;
        L5:
            r103.setMessage(r100);
            goto L6
        }

        public final BridgeResult createNoPrivilegeResult(String r100, JSONObject r101) {
            Logger r102 = Logger.f269563c;
            String.valueOf(r101);
            r102.getClass();
            Logger.a();
            BridgeResult r103 = new BridgeResult(null);
            r103.setCode(CODE.NO_PRIVILEGE.getValue());
            if (TextUtils.isEmpty(r100) == false) goto L5;
            r103.setMessage("the bridge is no privilege, please check again.");
        L6:
            if (r101 == null) goto L8;
            r103.setData(r101);
        L8:
            return r103;
        L5:
            r103.setMessage(r100);
            goto L6
        }

        public final BridgeResult createParamsErrorResult(String r100, JSONObject r101) {
            Logger r102 = Logger.f269563c;
            String.valueOf(r101);
            r102.getClass();
            Logger.a();
            BridgeResult r103 = new BridgeResult(null);
            r103.setCode(CODE.PARAMS_ERROR.getValue());
            if (TextUtils.isEmpty(r100) == false) goto L5;
            r103.setMessage("the bridge's params is error, please check again.");
        L6:
            if (r101 == null) goto L8;
            r103.setData(r101);
        L8:
            return r103;
        L5:
            r103.setMessage(r100);
            goto L6
        }

        public final BridgeResult createSuccessResult(JSONObject r100, String r101) {
            return createSuccessResult(r100, r101, false);
        }

        public final BridgeResult createSuccessResult(JSONObject r100, String r101, boolean r102) {
            Logger r103 = Logger.f269563c;
            String.valueOf(r100);
            r103.getClass();
            Logger.a();
            BridgeResult r104 = new BridgeResult(null);
            r104.setCode(CODE.SUCCESS.getValue());
            if (TextUtils.isEmpty(r101) == true) goto L5;
            r104.setMessage(r101);
        L5:
            if (r100 == null) goto L7;
            r104.setData(r100);
        L7:
            r104.setRaw(r102);
            return r104;
        }

        public static /* synthetic */ BridgeResult createSuccessResult$default(Companion r100, JSONObject r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.createSuccessResult(r101);
        }

        public static /* synthetic */ BridgeResult createErrorResult$default(Companion r100, String r101, JSONObject r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = null;
        L9:
            return r100.createErrorResult(r101, r102);
        }

        public static /* synthetic */ BridgeResult createMethodNotFoundResult$default(Companion r100, String r101, JSONObject r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = null;
        L9:
            return r100.createMethodNotFoundResult(r101, r102);
        }

        public static /* synthetic */ BridgeResult createNoPrivilegeResult$default(Companion r100, String r101, JSONObject r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = null;
        L9:
            return r100.createNoPrivilegeResult(r101, r102);
        }

        public static /* synthetic */ BridgeResult createParamsErrorResult$default(Companion r100, String r101, JSONObject r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = null;
        L9:
            return r100.createParamsErrorResult(r101, r102);
        }

        public static /* synthetic */ BridgeResult createSuccessResult$default(Companion r100, JSONObject r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.createSuccessResult(r101, r102);
        }

        public static /* synthetic */ BridgeResult createSuccessResult$default(Companion r100, JSONObject r101, String r102, boolean r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = "";
        L9:
            return r100.createSuccessResult(r101, r102, r103);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final JSONObject toJSON() {
        JSONObject r100 = new JSONObject();
        r100.put("code", this.code);
        String r101 = this.message;
        if (r101 == null) goto L5;
        r100.put("status", r101);
    L5:
        JSONObject r102 = this.data;
        if (r102 == null) goto L8;
        r100.put("data", r102);
    L8:
        return r100;
    }

    private BridgeResult() {
        this.code = CODE.ERROR.getValue();
    }

    public final int getCode() {
        return this.code;
    }

    public final JSONObject getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean isRaw() {
        return this.isRaw;
    }

    public /* synthetic */ BridgeResult(DefaultConstructorMarker r100) {
        this();
    }

    public final void setCode(int r100) {
        this.code = r100;
    }

    public final void setData(JSONObject r100) {
        this.data = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setRaw(boolean r100) {
        this.isRaw = r100;
    }
}
