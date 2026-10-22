package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyFolderPermPuller$Params;", "Lcom/bytedance/ee/util/io/NonProguard;", ResourceData.KEY_TOKEN, "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getMessage", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplyFolderPermPuller$Params implements NonProguard {
    private final String message;
    private final String token;

    public final String getMessage() {
        return this.message;
    }

    public final String getToken() {
        return this.token;
    }

    public ApplyFolderPermPuller$Params(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        this.token = r2;
        this.message = r3;
    }
}
