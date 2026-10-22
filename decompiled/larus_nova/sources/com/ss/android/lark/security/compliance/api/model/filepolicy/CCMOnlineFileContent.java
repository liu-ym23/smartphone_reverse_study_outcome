package com.ss.android.lark.security.compliance.api.model.filepolicy;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/CCMOnlineFileContent;", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/RefreshableScene;", "token", "", "tokenEntityType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getTokenEntityType", "getPointKeys", "", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMOnlineFileContent extends i {
    private final String token;
    private final String tokenEntityType;

    @Override // com.ss.android.lark.security.compliance.api.model.filepolicy.i
    public List<String> getPointKeys() {
        return CollectionsKt.listOf(new String[]{"PointKey_CCM_CONTENT_COPY", "PointKey_CCM_CONTENT_PREVIEW"});
    }

    public final String getToken() {
        return this.token;
    }

    public final String getTokenEntityType() {
        return this.tokenEntityType;
    }

    public CCMOnlineFileContent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "tokenEntityType");
        super(null);
        this.token = r100;
        this.tokenEntityType = r101;
    }
}
