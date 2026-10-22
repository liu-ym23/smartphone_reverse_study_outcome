package com.ss.android.lark.passport.signinsdk_api.country;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B-\b\u0007\u0012\u0010\b\u0003\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J-\u0010\u000b\u001a\u00020\u00002\u0010\b\u0003\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rR\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/country/CountryFilterBean;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "allowRegionList", "", "", "blockRegionList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CountryFilterBean implements Parcelable, Serializable {
    public static final Parcelable.Creator<CountryFilterBean> CREATOR = null;
    public List<String> allowRegionList;
    public List<String> blockRegionList;

    public static final class a implements Parcelable.Creator<CountryFilterBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CountryFilterBean createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new CountryFilterBean(r100.createStringArrayList(), r100.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final CountryFilterBean[] newArray(int r100) {
            return new CountryFilterBean[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CountryFilterBean() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CountryFilterBean(@JSONField(name = "allow_region_list") List<String> r100) {
        this(r100, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CountryFilterBean copy$default(CountryFilterBean r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.allowRegionList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.blockRegionList;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.allowRegionList;
    }

    public final List<String> component2() {
        return this.blockRegionList;
    }

    public final CountryFilterBean copy(@JSONField(name = "allow_region_list") List<String> r100, @JSONField(name = "block_region_list") List<String> r101) {
        return new CountryFilterBean(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CountryFilterBean) == true) goto L8;
        return false;
    L8:
        CountryFilterBean r101 = (CountryFilterBean) r100;
        if (Intrinsics.areEqual(this.allowRegionList, r101.allowRegionList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockRegionList, r101.blockRegionList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.allowRegionList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.blockRegionList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CountryFilterBean(allowRegionList=" + this.allowRegionList + ", blockRegionList=" + this.blockRegionList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeStringList(this.allowRegionList);
        r100.writeStringList(this.blockRegionList);
    }

    public CountryFilterBean(@JSONField(name = "allow_region_list") List<String> r100, @JSONField(name = "block_region_list") List<String> r101) {
        this.allowRegionList = r100;
        this.blockRegionList = r101;
    }

    public /* synthetic */ CountryFilterBean(List r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
