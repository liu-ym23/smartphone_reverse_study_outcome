package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ApplyDocPermPuller extends kg5.d<Params, Result> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyDocPermPuller$Params;", "Lcom/bytedance/ee/util/io/NonProguard;", ResourceData.KEY_TOKEN, "", "obj_type", "message", "permission", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getObj_type", "getMessage", "getPermission", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        public Params(String r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r3, "obj_type");
            Intrinsics.checkNotNullParameter(r4, "message");
            Intrinsics.checkNotNullParameter(r5, "permission");
            this.token = r2;
            this.obj_type = r3;
            this.message = r4;
            this.permission = r5;
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

        public final void setRet(Boolean r1) {
            this.ret = r1;
        }
    }

    public ApplyDocPermPuller(NetService r2) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        super(r2);
    }
}
