package com.bytedance.ee.bear.templates.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\tJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/templates/bean/SelectTemplateConfig;", "Landroid/os/Parcelable;", "disableDefaultLoading", "", "tipsStr", "", "templateSource", "enablePreviewDetail", "itemSecondTitleType", "", "<init>", "(ZLjava/lang/String;Ljava/lang/String;ZI)V", "getDisableDefaultLoading", "()Z", "getTipsStr", "()Ljava/lang/String;", "getTemplateSource", "getEnablePreviewDetail", "getItemSecondTitleType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "features-templates-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectTemplateConfig implements Parcelable {
    public static final Parcelable.Creator<SelectTemplateConfig> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f238863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f238864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f238865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f238866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f238867e;

    public static final class a implements Parcelable.Creator<SelectTemplateConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SelectTemplateConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L6:
            String r102 = r100.readString();
            String r103 = r100.readString();
            if (r100.readInt() == 0) goto L9;
            boolean r104 = true;
        L10:
            boolean r105 = r101;
            boolean r106 = r104;
            return new SelectTemplateConfig(r105, r102, r103, r106, r100.readInt());
        L9:
            r104 = false;
            goto L10
        L5:
            r101 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final SelectTemplateConfig[] newArray(int r100) {
            return new SelectTemplateConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SelectTemplateConfig() {
        this(false, null, null, false, -1);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SelectTemplateConfig) == true) goto L8;
        return false;
    L8:
        SelectTemplateConfig r101 = (SelectTemplateConfig) r100;
        if (this.f238863a == r101.f238863a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f238864b, r101.f238864b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f238865c, r101.f238865c) == true) goto L18;
        return false;
    L18:
        if (this.f238866d == r101.f238866d) goto L21;
        return false;
    L21:
        if (this.f238867e == r101.f238867e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f238863a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        String r103 = this.f238864b;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f238865c;
        if (r107 == null) goto L14;
        r104 = r107.hashCode();
    L14:
        int r108 = (r106 + r104) * 31;
        if (this.f238866d == true) goto L19;
        r100 = 1237;
    L19:
        return ((r108 + r100) * 31) + this.f238867e;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SelectTemplateConfig(disableDefaultLoading=" + this.f238863a + ", tipsStr=" + this.f238864b + ", templateSource=" + this.f238865c + ", enablePreviewDetail=" + this.f238866d + ", itemSecondTitleType=" + this.f238867e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f238863a ? 1 : 0);
        r100.writeString(this.f238864b);
        r100.writeString(this.f238865c);
        r100.writeInt(this.f238866d ? 1 : 0);
        r100.writeInt(this.f238867e);
    }

    public SelectTemplateConfig(boolean r100, String r101, String r102, boolean r103, int r104) {
        this.f238863a = r100;
        this.f238864b = r101;
        this.f238865c = r102;
        this.f238866d = r103;
        this.f238867e = r104;
    }
}
