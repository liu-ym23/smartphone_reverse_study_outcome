package com.bytedance.ee.bear.list.applydelete;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ApplyDeleteSpacePuller {
    public final NetService a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B/\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/list/applydelete/ApplyDeleteSpacePuller$Params;", "Lcom/bytedance/ee/util/io/NonProguard;", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "", "reason", "reviewer", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", ResourceData.KEY_OBJ_TOKEN, "getObj_token", "()Ljava/lang/String;", "setObj_token", "(Ljava/lang/String;)V", "getReason", "setReason", "getReviewer", "setReviewer", "obj_type", "getObj_type", "()I", "setObj_type", "(I)V", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Params implements NonProguard {
        private String obj_token;
        private int obj_type;
        private String reason;
        private String reviewer;

        public final String getObj_token() {
            return this.obj_token;
        }

        public final int getObj_type() {
            return this.obj_type;
        }

        public final String getReason() {
            return this.reason;
        }

        public final String getReviewer() {
            return this.reviewer;
        }

        public final void setObj_token(String r1) {
            this.obj_token = r1;
        }

        public final void setObj_type(int r1) {
            this.obj_type = r1;
        }

        public final void setReason(String r1) {
            this.reason = r1;
        }

        public final void setReviewer(String r1) {
            this.reviewer = r1;
        }

        public Params(String r1, int r2, String r3, String r4) {
            this.obj_token = r1;
            this.reason = r3;
            this.reviewer = r4;
            this.obj_type = r2;
        }
    }

    public static final class a {
    }

    static {
    }

    public ApplyDeleteSpacePuller(NetService r2) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        this.a = r2;
    }
}
