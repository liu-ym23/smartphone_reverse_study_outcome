package com.obric.assistant.settings;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0003JE\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0001J\u0013\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u001eHÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lcom/obric/assistant/settings/SelectableToggleItem;", "Landroid/os/Parcelable;", "toggleName", "Lcom/obric/assistant/settings/ToggleName;", "title", "", "subTitle", "selected", "", "permissionList", "", "<init>", "(Lcom/obric/assistant/settings/ToggleName;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getToggleName", "()Lcom/obric/assistant/settings/ToggleName;", "getTitle", "()Ljava/lang/String;", "getSubTitle", "getSelected", "()Z", "setSelected", "(Z)V", "getPermissionList", "()Ljava/util/List;", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectableToggleItem implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ToggleName f391762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f391763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f391764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f391765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f391766e;

    public static final class a implements Parcelable.Creator<SelectableToggleItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SelectableToggleItem createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            ToggleName r102 = ToggleName.valueOf(r101);
            String r103 = r100.readString();
            if (r103 != null) goto L8;
            String r104 = "";
        L9:
            String r105 = r100.readString();
            if (r100.readInt() == 0) goto L12;
            boolean r106 = true;
        L14:
            return new SelectableToggleItem(r102, r104, r105, r106, r100.createStringArrayList());
        L12:
            r106 = false;
            goto L14
        L8:
            r104 = r103;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final SelectableToggleItem[] newArray(int r100) {
            return new SelectableToggleItem[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SelectableToggleItem) == true) goto L8;
        return false;
    L8:
        SelectableToggleItem r101 = (SelectableToggleItem) r100;
        if (this.f391762a == r101.f391762a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f391763b, r101.f391763b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f391764c, r101.f391764c) == true) goto L18;
        return false;
    L18:
        if (this.f391765d == r101.f391765d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f391766e, r101.f391766e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f391762a.hashCode() * 31) + this.f391763b.hashCode()) * 31;
        String r101 = this.f391764c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        if (this.f391765d == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        List<String> r107 = this.f391766e;
        if (r107 == null) goto L15;
        r102 = r107.hashCode();
    L15:
        return r106 + r102;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SelectableToggleItem(toggleName=" + this.f391762a + ", title=" + this.f391763b + ", subTitle=" + this.f391764c + ", selected=" + this.f391765d + ", permissionList=" + this.f391766e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f391762a.name());
        r100.writeString(this.f391763b);
        r100.writeString(this.f391764c);
        r100.writeInt(this.f391765d ? 1 : 0);
        r100.writeStringList(this.f391766e);
    }

    public /* synthetic */ SelectableToggleItem(ToggleName r100, String r110, String r111, List r112, int r113) {
        if ((r113 & 4) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r113 & 16) == 0) goto L13;
        List r103 = null;
    L14:
        this(r100, r110, r101, r102, r103);
        return;
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = false;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }

    public SelectableToggleItem(ToggleName r100, String r101, String r102, boolean r103, List<String> r104) {
        Intrinsics.checkNotNullParameter(r100, "toggleName");
        Intrinsics.checkNotNullParameter(r101, "title");
        this.f391762a = r100;
        this.f391763b = r101;
        this.f391764c = r102;
        this.f391765d = r103;
        this.f391766e = r104;
    }
}
