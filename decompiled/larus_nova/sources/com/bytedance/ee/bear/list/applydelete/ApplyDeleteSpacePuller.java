package com.bytedance.ee.bear.list.applydelete;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class ApplyDeleteSpacePuller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f227664a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B/\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/list/applydelete/ApplyDeleteSpacePuller$Params;", "Lcom/bytedance/ee/util/io/NonProguard;", "token", "", "type", "", "reason", "reviewer", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "obj_token", "getObj_token", "()Ljava/lang/String;", "setObj_token", "(Ljava/lang/String;)V", "getReason", "setReason", "getReviewer", "setReviewer", "obj_type", "getObj_type", "()I", "setObj_type", "(I)V", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        public final void setObj_token(String r100) {
            this.obj_token = r100;
        }

        public final void setObj_type(int r100) {
            this.obj_type = r100;
        }

        public final void setReason(String r100) {
            this.reason = r100;
        }

        public final void setReviewer(String r100) {
            this.reviewer = r100;
        }

        public Params(String r100, int r101, String r102, String r103) {
            this.obj_token = r100;
            this.reason = r102;
            this.reviewer = r103;
            this.obj_type = r101;
        }
    }

    public static final class a {
    }

    static {
    }

    public ApplyDeleteSpacePuller(NetService r100) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        this.f227664a = r100;
    }
}
