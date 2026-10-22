package com.bytedance.ee.bear.document.offline.sync.preloadtask;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/preloadtask/ResDetail;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "data", "Lcom/bytedance/ee/bear/document/offline/sync/preloadtask/ResDetaildata;", "getData", "()Lcom/bytedance/ee/bear/document/offline/sync/preloadtask/ResDetaildata;", "setData", "(Lcom/bytedance/ee/bear/document/offline/sync/preloadtask/ResDetaildata;)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResDetail implements NonProguard {
    private ResDetaildata data;
    private String type;

    public String toString() {
        return "ResDetail(type='" + this.type + "', data=" + this.data + ')';
    }

    public ResDetail() {
        this.type = "image";
    }

    public final ResDetaildata getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }

    public final void setData(ResDetaildata r100) {
        this.data = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }
}
