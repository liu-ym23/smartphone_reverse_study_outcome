package kec;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/widget/richtext/json/property/TextPropertyParser$TextPropertyBean;", "", "content", "", "i18nKey", "numberOfLines", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "getI18nKey", "getNumberOfLines", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "richtext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("content")
    private final String content;

    @SerializedName("i18nKey")
    private final String i18nKey;

    @SerializedName("numberOfLines")
    private final int numberOfLines;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.i18nKey, r101.i18nKey) == true) goto L15;
        return false;
    L15:
        if (this.numberOfLines == r101.numberOfLines) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.content.hashCode() * 31) + this.i18nKey.hashCode()) * 31) + this.numberOfLines;
    }

    public final String toString() {
        return "TextPropertyBean(content=" + this.content + ", i18nKey=" + this.i18nKey + ", numberOfLines=" + this.numberOfLines + ')';
    }

    public f() {
        Intrinsics.checkNotNullParameter("", "content");
        Intrinsics.checkNotNullParameter("", "i18nKey");
        this.content = "";
        this.i18nKey = "";
        this.numberOfLines = 0;
    }
}
