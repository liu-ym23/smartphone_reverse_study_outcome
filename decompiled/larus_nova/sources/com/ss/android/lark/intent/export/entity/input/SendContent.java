package com.ss.android.lark.intent.export.entity.input;

import android.text.TextUtils;
import java.io.Serializable;
import knb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SendContent;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/intent/export/entity/input/IContentValid;", "textContent", "", "cloudDocumentContent", "Lcom/ss/android/lark/intent/export/entity/input/CloudDocumentContent;", "photoContent", "Lcom/ss/android/lark/intent/export/entity/input/PhotoContent;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/intent/export/entity/input/CloudDocumentContent;Lcom/ss/android/lark/intent/export/entity/input/PhotoContent;)V", "getTextContent", "()Ljava/lang/String;", "getCloudDocumentContent", "()Lcom/ss/android/lark/intent/export/entity/input/CloudDocumentContent;", "getPhotoContent", "()Lcom/ss/android/lark/intent/export/entity/input/PhotoContent;", "isValid", "", "toString", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendContent implements Serializable, IContentValid {
    private final CloudDocumentContent cloudDocumentContent;
    private final PhotoContent photoContent;
    private final String textContent;

    public static /* synthetic */ SendContent copy$default(SendContent r100, String r101, CloudDocumentContent r102, PhotoContent r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.textContent;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.cloudDocumentContent;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.photoContent;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.textContent;
    }

    public final CloudDocumentContent component2() {
        return this.cloudDocumentContent;
    }

    public final PhotoContent component3() {
        return this.photoContent;
    }

    public final SendContent copy(String r100, CloudDocumentContent r101, PhotoContent r102) {
        return new SendContent(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SendContent) == true) goto L8;
        return false;
    L8:
        SendContent r101 = (SendContent) r100;
        if (Intrinsics.areEqual(this.textContent, r101.textContent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cloudDocumentContent, r101.cloudDocumentContent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.photoContent, r101.photoContent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.textContent;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        CloudDocumentContent r104 = this.cloudDocumentContent;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        PhotoContent r107 = this.photoContent;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    @Override // com.ss.android.lark.intent.export.entity.input.IContentValid
    public boolean isValid() {
        if (TextUtils.isEmpty(this.textContent) == false) goto L21;
        CloudDocumentContent r100 = this.cloudDocumentContent;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L22;
        PhotoContent r102 = this.photoContent;
        if (r102 != null) goto L14;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == true) goto L23;
        return false;
    L23:
        return true;
    L14:
        if (r102.isValid() != true) goto L16;
        r103 = true;
        goto L17
    L22:
        return true;
    L7:
        if (r100.isValid() != true) goto L9;
        r101 = true;
        goto L10
    L21:
        return true;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("SendContent(textContent=");
        String r101 = this.textContent;
        Object r102 = "null";
        if (r101 == null) goto L6;
        String r103 = a.a(r101);
        if (r103 == null) goto L6;
    L7:
        r100.append(r103);
        r100.append(", cloudDocumentContent=");
        Object r104 = this.cloudDocumentContent;
        if (r104 != null) goto L11;
        r104 = "null";
    L11:
        r100.append(r104);
        r100.append(", photoContent=");
        PhotoContent r105 = this.photoContent;
        if (r105 == null) goto L14;
        r102 = r105;
    L14:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L6:
        r103 = "null";
        goto L7
    }

    public final CloudDocumentContent getCloudDocumentContent() {
        return this.cloudDocumentContent;
    }

    public final PhotoContent getPhotoContent() {
        return this.photoContent;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public SendContent(String r100, CloudDocumentContent r101, PhotoContent r102) {
        this.textContent = r100;
        this.cloudDocumentContent = r101;
        this.photoContent = r102;
    }
}
