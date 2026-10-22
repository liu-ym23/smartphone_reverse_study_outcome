package com.bytedance.ee.bear.list.dto;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/list/dto/SpaceMakeCopyToSpaceResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/list/dto/SpaceMakeCopyToSpaceResult$Data;", "<init>", "()V", "Data", "contentmanager-list-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpaceMakeCopyToSpaceResult extends Result<Data> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/list/dto/SpaceMakeCopyToSpaceResult$Data;", "Ljava/io/Serializable;", "objToken", "", "token", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getObjToken", "()Ljava/lang/String;", "getToken", "getUrl", "setUrl", "(Ljava/lang/String;)V", "contentmanager-list-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Data implements Serializable {
        private final String objToken;
        private final String token;
        private String url;

        public final String getObjToken() {
            return this.objToken;
        }

        public final String getToken() {
            return this.token;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.url = r100;
        }

        public Data(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "objToken");
            Intrinsics.checkNotNullParameter(r101, "token");
            Intrinsics.checkNotNullParameter(r102, "url");
            this.objToken = r100;
            this.token = r101;
            this.url = r102;
        }
    }

    public SpaceMakeCopyToSpaceResult() {
    }
}
