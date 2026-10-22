package com.bytedance.android.shopping.commentv3.data.interfaces;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentTemplate;", "Ljava/io/Serializable;", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "type", "getType", "setType", "url", "getUrl", "setUrl", "equals", "", "other", "", "hashCode", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentTemplate implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    public CommentTemplate() {
        this.type = "";
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof CommentTemplate) == true) goto L5;
        return false;
    L5:
        CommentTemplate r5 = (CommentTemplate) r4;
        if (Intrinsics.areEqual(this.url, r5.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r5.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.type, r5.type) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }
}
