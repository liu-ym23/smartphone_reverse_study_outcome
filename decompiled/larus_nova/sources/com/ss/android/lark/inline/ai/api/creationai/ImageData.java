package com.ss.android.lark.inline.ai.api.creationai;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/ImageData;", "Ljava/io/Serializable;", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "id", "getId", "setId", "checkable", "", "getCheckable", "()Z", "setCheckable", "(Z)V", "equals", "other", "", "hashCode", "", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageData implements Serializable {
    private boolean checkable;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f426815id;
    private String url;

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f426815id;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("ImageData(url='");
        String r101 = this.url;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        r100.append(r103);
        r100.append("', id='");
        String r104 = this.f426815id;
        if (r104 == null) goto L9;
        r102 = r104.hashCode();
    L9:
        r100.append(r102);
        r100.append("', checkable=");
        r100.append(this.checkable);
        r100.append(')');
        return r100.toString();
    L5:
        r103 = 0;
        goto L6
    }

    public ImageData() {
        this.checkable = true;
        String r100 = this.url;
        if (r100 == null) goto L5;
        String r101 = StringsKt.trim(r100).toString();
    L6:
        this.url = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean getCheckable() {
        return this.checkable;
    }

    public final String getId() {
        return this.f426815id;
    }

    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageData) == true) goto L8;
        return false;
    L8:
        ImageData r101 = (ImageData) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f426815id, r101.f426815id) == true) goto L15;
        return false;
    L15:
        if (this.checkable == r101.checkable) goto L17;
        return false;
    L17:
        return true;
    }

    public final void setCheckable(boolean r100) {
        this.checkable = r100;
    }

    public final void setId(String r100) {
        this.f426815id = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
