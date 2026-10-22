package com.bytedance.ee.bear.document.ai.citation;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B;\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J=\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020!HÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/ShowCitationData;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "id", "", "title", "citations", "", "Lcom/bytedance/ee/bear/document/ai/citation/Citation;", "deletable", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getCitations", "()Ljava/util/List;", "setCitations", "(Ljava/util/List;)V", "getDeletable", "()Z", "setDeletable", "(Z)V", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowCitationData implements NonProguard, Parcelable {
    public static final a CREATOR = null;
    private List<Citation> citations;
    private boolean deletable;
    private String id;
    private String title;

    public static final class a implements Parcelable.Creator<ShowCitationData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShowCitationData createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new ShowCitationData(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ShowCitationData[] newArray(int r1) {
            return new ShowCitationData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ShowCitationData() {
        this(null, null, null, false, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShowCitationData copy$default(ShowCitationData r0, String r1, String r2, List r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.title;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.citations;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.deletable;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final List<Citation> component3() {
        return this.citations;
    }

    public final boolean component4() {
        return this.deletable;
    }

    public final ShowCitationData copy(String r2, String r3, List<Citation> r4, boolean r5) {
        return new ShowCitationData(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ShowCitationData) == true) goto L8;
        return false;
    L8:
        ShowCitationData r6 = (ShowCitationData) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.citations, r6.citations) == true) goto L18;
        return false;
    L18:
        if (this.deletable == r6.deletable) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<Citation> r7 = this.citations;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        int r8 = (r6 + r1) * 31;
        if (this.deletable == false) goto L17;
        int r9 = 1231;
    L19:
        return r8 + r9;
    L17:
        r9 = 1237;
        goto L19
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ShowCitationData(id=" + this.id + ", title=" + this.title + ", citations=" + this.citations + ", deletable=" + this.deletable + ')';
    }

    public final List<Citation> getCitations() {
        return this.citations;
    }

    public final boolean getDeletable() {
        return this.deletable;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public ShowCitationData(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        String r0 = r4.readString();
        String r1 = r4.readString();
        ArrayList r2 = r4.createTypedArrayList(Citation.CREATOR);
        if (r4.readByte() == 0) goto L5;
        boolean r5 = true;
    L6:
        this(r0, r1, r2, r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    public final void setCitations(List<Citation> r1) {
        this.citations = r1;
    }

    public final void setDeletable(boolean r1) {
        this.deletable = r1;
    }

    public final void setId(String r1) {
        this.id = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.id);
        r1.writeString(this.title);
        r1.writeTypedList(this.citations);
        r1.writeByte(this.deletable ? 1 : 0);
    }

    public ShowCitationData(String r1, String r2, List<Citation> r3, boolean r4) {
        this.id = r1;
        this.title = r2;
        this.citations = r3;
        this.deletable = r4;
    }

    public /* synthetic */ ShowCitationData(String r2, String r3, List r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = CollectionsKt.emptyList();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }
}
