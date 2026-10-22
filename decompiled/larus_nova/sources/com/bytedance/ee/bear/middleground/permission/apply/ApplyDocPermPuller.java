package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class ApplyDocPermPuller extends kg5.d<Params, Result> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyDocPermPuller$Params;", "Lcom/bytedance/ee/util/io/NonProguard;", "token", "", "obj_type", "message", "permission", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getObj_type", "getMessage", "getPermission", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Params implements NonProguard {
        private final String message;
        private final String obj_type;
        private final String permission;
        private final String token;

        public final String getMessage() {
            return this.message;
        }

        public final String getObj_type() {
            return this.obj_type;
        }

        public final String getPermission() {
            return this.permission;
        }

        public final String getToken() {
            return this.token;
        }

        public Params(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r101, "obj_type");
            Intrinsics.checkNotNullParameter(r102, "message");
            Intrinsics.checkNotNullParameter(r103, "permission");
            this.token = r100;
            this.obj_type = r101;
            this.message = r102;
            this.permission = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyDocPermPuller$Result;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "ret", "", "getRet", "()Ljava/lang/Boolean;", "setRet", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Result implements NonProguard {
        private Boolean ret;

        public Result() {
        }

        public final Boolean getRet() {
            return this.ret;
        }

        public final void setRet(Boolean r100) {
            this.ret = r100;
        }
    }

    public ApplyDocPermPuller(NetService r100) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        super(r100);
    }
}
