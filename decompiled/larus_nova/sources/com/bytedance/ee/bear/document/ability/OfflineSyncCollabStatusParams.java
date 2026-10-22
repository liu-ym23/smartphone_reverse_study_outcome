package com.bytedance.ee.bear.document.ability;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/document/ability/OfflineSyncCollabStatusParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "status", "Lcom/bytedance/ee/bear/document/ability/OfflineSyncCollabStatus;", "getStatus", "()Lcom/bytedance/ee/bear/document/ability/OfflineSyncCollabStatus;", "setStatus", "(Lcom/bytedance/ee/bear/document/ability/OfflineSyncCollabStatus;)V", "pageToken", "", "getPageToken", "()Ljava/lang/String;", "setPageToken", "(Ljava/lang/String;)V", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfflineSyncCollabStatusParams implements NonProguard {
    private String pageToken;
    private OfflineSyncCollabStatus status;

    public OfflineSyncCollabStatusParams() {
        this.status = OfflineSyncCollabStatus.UNKNOWN;
        this.pageToken = "";
    }

    public final String getPageToken() {
        return this.pageToken;
    }

    public final OfflineSyncCollabStatus getStatus() {
        return this.status;
    }

    public final void setPageToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageToken = r100;
    }

    public final void setStatus(OfflineSyncCollabStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.status = r100;
    }
}
