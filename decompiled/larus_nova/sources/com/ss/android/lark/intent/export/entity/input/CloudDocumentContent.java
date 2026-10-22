package com.ss.android.lark.intent.export.entity.input;

import android.text.TextUtils;
import java.io.Serializable;
import knb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/CloudDocumentContent;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/intent/export/entity/input/IContentValid;", "id", "", "title", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getUrl", "isValid", "", "toString", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloudDocumentContent implements Serializable, IContentValid {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f428141id;
    private final String title;
    private final String url;

    public static /* synthetic */ CloudDocumentContent copy$default(CloudDocumentContent r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f428141id;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.title;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.url;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.f428141id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.url;
    }

    public final CloudDocumentContent copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "url");
        return new CloudDocumentContent(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CloudDocumentContent) == true) goto L8;
        return false;
    L8:
        CloudDocumentContent r101 = (CloudDocumentContent) r100;
        if (Intrinsics.areEqual(this.f428141id, r101.f428141id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f428141id.hashCode() * 31) + this.title.hashCode()) * 31) + this.url.hashCode();
    }

    @Override // com.ss.android.lark.intent.export.entity.input.IContentValid
    public boolean isValid() {
        return !TextUtils.isEmpty(this.url);
    }

    public String toString() {
        return "CloudDocumentContent(id='" + this.f428141id + "', title='" + this.title + "', url='" + a.a(this.url) + "')";
    }

    public final String getId() {
        return this.f428141id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public CloudDocumentContent(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "url");
        this.f428141id = r100;
        this.title = r101;
        this.url = r102;
    }
}
