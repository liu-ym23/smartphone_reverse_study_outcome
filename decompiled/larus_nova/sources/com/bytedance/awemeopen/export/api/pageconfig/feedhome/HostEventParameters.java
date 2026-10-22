package com.bytedance.awemeopen.export.api.pageconfig.feedhome;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001c\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006!"}, d2 = {"Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/HostEventParameters;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "enterFrom", "Ljava/lang/String;", "getEnterFrom", "()Ljava/lang/String;", "setEnterFrom", "(Ljava/lang/String;)V", "enterMethod", "getEnterMethod", "setEnterMethod", "enterFromMerge", "getEnterFromMerge", "setEnterFromMerge", "impr", "getImpr", "setImpr", "roomId", "getRoomId", "setRoomId", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class HostEventParameters implements Parcelable {
    public static final a CREATOR = null;
    private String enterFrom;
    private String enterFromMerge;
    private String enterMethod;
    private String impr;
    private String roomId;

    public static final class a implements Parcelable.Creator<HostEventParameters> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HostEventParameters createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new HostEventParameters(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final HostEventParameters[] newArray(int r100) {
            return new HostEventParameters[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HostEventParameters() {
        this.enterFrom = "";
        this.enterMethod = "";
        this.enterFromMerge = "";
        this.impr = "";
        this.roomId = "";
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getImpr() {
        return this.impr;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public HostEventParameters(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        Object r101 = r100.readValue(String.class.getClassLoader());
        String r102 = null;
        if ((r101 instanceof String) == false) goto L5;
        String r103 = (String) r101;
    L6:
        String r104 = "";
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        this.enterFrom = r103;
        Object r105 = r100.readValue(String.class.getClassLoader());
        if ((r105 instanceof String) == false) goto L12;
        String r106 = (String) r105;
    L13:
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        this.enterMethod = r106;
        Object r107 = r100.readValue(String.class.getClassLoader());
        if ((r107 instanceof String) == false) goto L18;
        String r108 = (String) r107;
    L19:
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        this.enterFromMerge = r108;
        Object r109 = r100.readValue(String.class.getClassLoader());
        if ((r109 instanceof String) == false) goto L24;
        String r110 = (String) r109;
    L25:
        if (r110 != null) goto L27;
        r110 = "";
    L27:
        this.impr = r110;
        Object r111 = r100.readValue(String.class.getClassLoader());
        if ((r111 instanceof String) == false) goto L30;
        r102 = (String) r111;
    L30:
        if (r102 == null) goto L33;
        r104 = r102;
    L33:
        this.roomId = r104;
        return;
    L24:
        r110 = null;
        goto L25
    L18:
        r108 = null;
        goto L19
    L12:
        r106 = null;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public final void setEnterFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFrom = r100;
    }

    public final void setEnterFromMerge(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFromMerge = r100;
    }

    public final void setEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethod = r100;
    }

    public final void setImpr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.impr = r100;
    }

    public final void setRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomId = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeValue(this.enterFrom);
        r100.writeValue(this.enterMethod);
        r100.writeValue(this.enterFromMerge);
        r100.writeValue(this.impr);
        r100.writeValue(this.roomId);
    }
}
