package com.bytedance.ee.bear.templates.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\tJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/templates/bean/SelectTemplateConfig;", "Landroid/os/Parcelable;", "disableDefaultLoading", "", "tipsStr", "", "templateSource", "enablePreviewDetail", "itemSecondTitleType", "", "<init>", "(ZLjava/lang/String;Ljava/lang/String;ZI)V", "getDisableDefaultLoading", "()Z", "getTipsStr", "()Ljava/lang/String;", "getTemplateSource", "getEnablePreviewDetail", "getItemSecondTitleType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "features-templates-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectTemplateConfig implements Parcelable {
    public static final Parcelable.Creator<SelectTemplateConfig> CREATOR = null;
    public final boolean a;
    public final String b;
    public final String c;
    public final boolean d;
    public final int e;

    public static final class a implements Parcelable.Creator<SelectTemplateConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SelectTemplateConfig createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            if (r9.readInt() == 0) goto L5;
            boolean r4 = true;
        L6:
            String r5 = r9.readString();
            String r6 = r9.readString();
            if (r9.readInt() == 0) goto L9;
            boolean r7 = true;
        L10:
            boolean r2 = r4;
            boolean r8 = r7;
            return new SelectTemplateConfig(r2, r5, r6, r8, r9.readInt());
        L9:
            r7 = false;
            goto L10
        L5:
            r4 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final SelectTemplateConfig[] newArray(int r1) {
            return new SelectTemplateConfig[r1];
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

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SelectTemplateConfig) == true) goto L8;
        return false;
    L8:
        SelectTemplateConfig r6 = (SelectTemplateConfig) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        String r3 = this.b;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L14;
        r4 = r7.hashCode();
    L14:
        int r8 = (r6 + r4) * 31;
        if (this.d == true) goto L19;
        r1 = 1237;
    L19:
        return ((r8 + r1) * 31) + this.e;
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "SelectTemplateConfig(disableDefaultLoading=" + this.a + ", tipsStr=" + this.b + ", templateSource=" + this.c + ", enablePreviewDetail=" + this.d + ", itemSecondTitleType=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.a ? 1 : 0);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeInt(this.d ? 1 : 0);
        r1.writeInt(this.e);
    }

    public SelectTemplateConfig(boolean r1, String r2, String r3, boolean r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
