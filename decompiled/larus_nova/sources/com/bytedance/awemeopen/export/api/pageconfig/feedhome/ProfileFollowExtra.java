package com.bytedance.awemeopen.export.api.pageconfig.feedhome;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0015\u0010\u0016B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R$\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "fromPre", "Ljava/lang/Integer;", "getFromPre", "()Ljava/lang/Integer;", "setFromPre", "(Ljava/lang/Integer;)V", "fromLabel", "getFromLabel", "setFromLabel", "fromAction", "getFromAction", "setFromAction", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class ProfileFollowExtra implements Parcelable {
    public static final a CREATOR = null;
    private Integer fromAction;
    private Integer fromLabel;
    private Integer fromPre;

    public static final class a implements Parcelable.Creator<ProfileFollowExtra> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProfileFollowExtra createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ProfileFollowExtra(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ProfileFollowExtra[] newArray(int r100) {
            return new ProfileFollowExtra[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ProfileFollowExtra() {
    }

    public final Integer getFromAction() {
        return this.fromAction;
    }

    public final Integer getFromLabel() {
        return this.fromLabel;
    }

    public final Integer getFromPre() {
        return this.fromPre;
    }

    public ProfileFollowExtra(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        Class r101 = Integer.TYPE;
        Object r102 = r100.readValue(r101.getClassLoader());
        Integer r103 = null;
        if ((r102 instanceof Integer) == false) goto L5;
        Integer r104 = (Integer) r102;
    L6:
        this.fromPre = r104;
        Object r105 = r100.readValue(r101.getClassLoader());
        if ((r105 instanceof Integer) == false) goto L9;
        Integer r106 = (Integer) r105;
    L10:
        this.fromLabel = r106;
        Object r107 = r100.readValue(r101.getClassLoader());
        if ((r107 instanceof Integer) == false) goto L13;
        r103 = (Integer) r107;
    L13:
        this.fromAction = r103;
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public final void setFromAction(Integer r100) {
        this.fromAction = r100;
    }

    public final void setFromLabel(Integer r100) {
        this.fromLabel = r100;
    }

    public final void setFromPre(Integer r100) {
        this.fromPre = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeValue(this.fromPre);
        r100.writeValue(this.fromLabel);
        r100.writeValue(this.fromAction);
    }
}
