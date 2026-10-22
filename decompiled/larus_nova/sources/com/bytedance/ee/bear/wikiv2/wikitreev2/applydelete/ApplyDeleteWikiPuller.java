package com.bytedance.ee.bear.wikiv2.wikitreev2.applydelete;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class ApplyDeleteWikiPuller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f241374a;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B9\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/applydelete/ApplyDeleteWikiPuller$Params;", "Lcom/bytedance/ee/util/io/NonProguard;", "token", "", "reason", "reviewer", "spaceId", "deleteOpt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getReason", "setReason", "getReviewer", "setReviewer", DocViewModel.EXTRA_SPACE_ID, "getSpace_id", "setSpace_id", "delete_opt", "getDelete_opt", "()I", "setDelete_opt", "(I)V", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Params implements NonProguard {
        private int delete_opt;
        private String reason;
        private String reviewer;
        private String space_id;
        private String token;

        public final int getDelete_opt() {
            return this.delete_opt;
        }

        public final String getReason() {
            return this.reason;
        }

        public final String getReviewer() {
            return this.reviewer;
        }

        public final String getSpace_id() {
            return this.space_id;
        }

        public final String getToken() {
            return this.token;
        }

        public final void setDelete_opt(int r100) {
            this.delete_opt = r100;
        }

        public final void setReason(String r100) {
            this.reason = r100;
        }

        public final void setReviewer(String r100) {
            this.reviewer = r100;
        }

        public final void setSpace_id(String r100) {
            this.space_id = r100;
        }

        public final void setToken(String r100) {
            this.token = r100;
        }

        public Params(String r100, String r101, String r102, String r103, int r104) {
            this.token = r100;
            this.reason = r101;
            this.reviewer = r102;
            this.space_id = r103;
            this.delete_opt = r104;
        }
    }

    public static final class a {
    }

    static {
    }

    public ApplyDeleteWikiPuller(NetService r100) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        this.f241374a = r100;
    }
}
