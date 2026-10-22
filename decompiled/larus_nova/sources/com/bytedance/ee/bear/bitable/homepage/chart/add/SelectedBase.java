package com.bytedance.ee.bear.bitable.homepage.chart.add;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/add/SelectedBase;", "Landroid/os/Parcelable;", "title", "", "url", "token", "iconInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getUrl", "getToken", "getIconInfo", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectedBase implements Parcelable {
    public static final Parcelable.Creator<SelectedBase> CREATOR = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SelectedBase f212401e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f212402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f212403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f212404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f212405d;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<SelectedBase> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final SelectedBase createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SelectedBase(r100.readString(), r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SelectedBase[] newArray(int r100) {
            return new SelectedBase[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SelectedBase) == true) goto L8;
        return false;
    L8:
        SelectedBase r101 = (SelectedBase) r100;
        if (Intrinsics.areEqual(this.f212402a, r101.f212402a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f212403b, r101.f212403b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f212404c, r101.f212404c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f212405d, r101.f212405d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f212402a.hashCode() * 31) + this.f212403b.hashCode()) * 31) + this.f212404c.hashCode()) * 31;
        String r101 = this.f212405d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SelectedBase(title=" + this.f212402a + ", url=" + this.f212403b + ", token=" + this.f212404c + ", iconInfo=" + this.f212405d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f212402a);
        r100.writeString(this.f212403b);
        r100.writeString(this.f212404c);
        r100.writeString(this.f212405d);
    }

    static {
        CREATOR = new b();
        f212401e = new SelectedBase("", "", "", "");
    }

    public SelectedBase(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "token");
        this.f212402a = r100;
        this.f212403b = r101;
        this.f212404c = r102;
        this.f212405d = r103;
    }
}
