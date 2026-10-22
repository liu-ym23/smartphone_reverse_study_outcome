package com.ss.android.lark.inline.ai.api.ui;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J'\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/ImageData;", "Ljava/io/Serializable;", "url", "", "id", "checkable", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getId", "setId", "getCheckable", "()Z", "setCheckable", "(Z)V", "equals", "other", "", "hashCode", "", "toString", "component1", "component2", "component3", "copy", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageData implements Serializable {
    private boolean checkable;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f426840id;
    private String url;

    public static /* synthetic */ ImageData copy$default(ImageData r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f426840id;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.checkable;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.f426840id;
    }

    public final boolean component3() {
        return this.checkable;
    }

    public final ImageData copy(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "id");
        return new ImageData(r100, r101, r102);
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.f426840id.hashCode();
    }

    public String toString() {
        return "ImageData(url='" + this.url.hashCode() + "', id='" + this.f426840id.hashCode() + "', checkable=" + this.checkable + ')';
    }

    public final boolean getCheckable() {
        return this.checkable;
    }

    public final String getId() {
        return this.f426840id;
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
        if (Intrinsics.areEqual(this.f426840id, r101.f426840id) == true) goto L15;
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
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f426840id = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }

    public ImageData(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "id");
        this.url = r100;
        this.f426840id = r101;
        this.checkable = r102;
        this.url = StringsKt.trim(r100).toString();
    }

    public /* synthetic */ ImageData(String r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = true;
    L5:
        this(r100, r101, r102);
    }
}
