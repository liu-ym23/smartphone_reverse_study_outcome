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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B;\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J=\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020!HÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/ShowCitationData;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "id", "", "title", "citations", "", "Lcom/bytedance/ee/bear/document/ai/citation/Citation;", "deletable", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getTitle", com.alipay.sdk.m.x.d.f25925o, "getCitations", "()Ljava/util/List;", "setCitations", "(Ljava/util/List;)V", "getDeletable", "()Z", "setDeletable", "(Z)V", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowCitationData implements NonProguard, Parcelable {
    public static final a CREATOR = null;
    private List<Citation> citations;
    private boolean deletable;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f218754id;
    private String title;

    public static final class a implements Parcelable.Creator<ShowCitationData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShowCitationData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ShowCitationData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ShowCitationData[] newArray(int r100) {
            return new ShowCitationData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ShowCitationData() {
        this(null, null, null, false, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShowCitationData copy$default(ShowCitationData r100, String r101, String r102, List r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f218754id;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.title;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.citations;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.deletable;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.f218754id;
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

    public final ShowCitationData copy(String r100, String r101, List<Citation> r102, boolean r103) {
        return new ShowCitationData(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShowCitationData) == true) goto L8;
        return false;
    L8:
        ShowCitationData r101 = (ShowCitationData) r100;
        if (Intrinsics.areEqual(this.f218754id, r101.f218754id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.citations, r101.citations) == true) goto L18;
        return false;
    L18:
        if (this.deletable == r101.deletable) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.f218754id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<Citation> r107 = this.citations;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        if (this.deletable == false) goto L17;
        int r109 = 1231;
    L19:
        return r108 + r109;
    L17:
        r109 = 1237;
        goto L19
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ShowCitationData(id=" + this.f218754id + ", title=" + this.title + ", citations=" + this.citations + ", deletable=" + this.deletable + ')';
    }

    public final List<Citation> getCitations() {
        return this.citations;
    }

    public final boolean getDeletable() {
        return this.deletable;
    }

    public final String getId() {
        return this.f218754id;
    }

    public final String getTitle() {
        return this.title;
    }

    public ShowCitationData(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        String r101 = r100.readString();
        String r102 = r100.readString();
        ArrayList r103 = r100.createTypedArrayList(Citation.CREATOR);
        if (r100.readByte() == 0) goto L5;
        boolean r104 = true;
    L6:
        this(r101, r102, r103, r104);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public final void setCitations(List<Citation> r100) {
        this.citations = r100;
    }

    public final void setDeletable(boolean r100) {
        this.deletable = r100;
    }

    public final void setId(String r100) {
        this.f218754id = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f218754id);
        r100.writeString(this.title);
        r100.writeTypedList(this.citations);
        r100.writeByte(this.deletable ? 1 : 0);
    }

    public ShowCitationData(String r100, String r101, List<Citation> r102, boolean r103) {
        this.f218754id = r100;
        this.title = r101;
        this.citations = r102;
        this.deletable = r103;
    }

    public /* synthetic */ ShowCitationData(String r100, String r101, List r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = CollectionsKt.emptyList();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
