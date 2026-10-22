package com.bytedance.ee.bear.document.ai.citation;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J7\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/Citation;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "title", "", "url", "urlType", "", "token", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getUrl", "setUrl", "getUrlType", "()I", "setUrlType", "(I)V", "getToken", "setToken", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Citation implements NonProguard, Parcelable {
    public static final a CREATOR = null;
    private String title;
    private String token;
    private String url;
    private int urlType;

    public static final class a implements Parcelable.Creator<Citation> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Citation createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new Citation(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final Citation[] newArray(int r1) {
            return new Citation[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public Citation() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ Citation copy$default(Citation r0, String r1, String r2, int r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.title;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.url;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.urlType;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.token;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.url;
    }

    public final int component3() {
        return this.urlType;
    }

    public final String component4() {
        return this.token;
    }

    public final Citation copy(String r2, String r3, @JSONField(name = "url_type") int r4, String r5) {
        return new Citation(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Citation) == true) goto L8;
        return false;
    L8:
        Citation r6 = (Citation) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L15;
        return false;
    L15:
        if (this.urlType == r6.urlType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.url;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.urlType) * 31;
        String r7 = this.token;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Citation(title=" + this.title + ", url=" + this.url + ", urlType=" + this.urlType + ", token=" + this.token + ')';
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getUrlType() {
        return this.urlType;
    }

    public Citation(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        this(r4.readString(), r4.readString(), r4.readInt(), r4.readString());
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public final void setUrlType(int r1) {
        this.urlType = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.title);
        r1.writeString(this.url);
        r1.writeInt(this.urlType);
        r1.writeString(this.token);
    }

    public Citation(String r1, String r2, @JSONField(name = "url_type") int r3, String r4) {
        this.title = r1;
        this.url = r2;
        this.urlType = r3;
        this.token = r4;
    }

    public /* synthetic */ Citation(String r2, String r3, int r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
