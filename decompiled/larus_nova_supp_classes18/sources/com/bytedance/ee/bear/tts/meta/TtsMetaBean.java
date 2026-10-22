package com.bytedance.ee.bear.tts.meta;

import du5.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/tts/meta/TtsMetaBean;", "Ljava/io/Serializable;", "<init>", "()V", "objToken", "", "getObjToken", "()Ljava/lang/String;", "setObjToken", "(Ljava/lang/String;)V", "objType", "", "getObjType", "()I", "setObjType", "(I)V", "title", "getTitle", "setTitle", "ownerName", "getOwnerName", "setOwnerName", "iconInfo", "getIconInfo", "setIconInfo", "toString", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsMetaBean implements Serializable {
    private String iconInfo;
    private String objToken;
    private int objType;
    private String ownerName;
    private String title;

    public String toString() {
        StringBuilder r0 = new StringBuilder("TtsMetaBean@");
        r0.append(hashCode());
        r0.append("{objToken: ");
        r0.append(b.i(this.objToken));
        r0.append(", objType: ");
        r0.append(this.objType);
        r0.append(", title: ");
        r0.append(this.title);
        r0.append(", ownerName: ");
        r0.append(this.ownerName);
        r0.append(", iconInfo(length): ");
        String r1 = this.iconInfo;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length());
    L6:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public TtsMetaBean() {
        this.objToken = "";
        this.objType = -1;
        this.title = "";
        this.ownerName = "";
    }

    public final String getIconInfo() {
        return this.iconInfo;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final int getObjType() {
        return this.objType;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setIconInfo(String r1) {
        this.iconInfo = r1;
    }

    public final void setObjToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.objToken = r2;
    }

    public final void setObjType(int r1) {
        this.objType = r1;
    }

    public final void setOwnerName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ownerName = r2;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }
}
