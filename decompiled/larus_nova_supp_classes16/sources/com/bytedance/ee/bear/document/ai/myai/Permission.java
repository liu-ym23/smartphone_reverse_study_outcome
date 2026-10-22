package com.bytedance.ee.bear.document.ai.myai;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/myai/Permission;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "read", "", "getRead", "()Ljava/lang/Boolean;", "setRead", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", JSEventListener.ACTION_EDIT, "getEdit", "setEdit", "copy", "getCopy", "setCopy", "share", "getShare", "setShare", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Permission implements NonProguard {
    private Boolean copy;
    private Boolean edit;
    private Boolean read;
    private Boolean share;

    public Permission() {
    }

    public String toString() {
        return "Permission(read=" + this.read + ", edit=" + this.edit + ", copy=" + this.copy + ", share=" + this.share + ')';
    }

    public final Boolean getCopy() {
        return this.copy;
    }

    public final Boolean getEdit() {
        return this.edit;
    }

    public final Boolean getRead() {
        return this.read;
    }

    public final Boolean getShare() {
        return this.share;
    }

    public final void setCopy(Boolean r1) {
        this.copy = r1;
    }

    public final void setEdit(Boolean r1) {
        this.edit = r1;
    }

    public final void setRead(Boolean r1) {
        this.read = r1;
    }

    public final void setShare(Boolean r1) {
        this.share = r1;
    }
}
