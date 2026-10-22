package com.obric.assistant.dora;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0001/B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010$\u001a\u00020\fJ\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\fHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u00060"}, d2 = {"Lcom/obric/assistant/dora/DoraMainProcessConnectResult;", "Landroid/os/Parcelable;", "requestId", "", "deviceInfo", "Lcom/obric/assistant/dora/DoraDeviceInfo;", "isBound", "", "connectAttempted", "connectSuccess", "shouldStartOnboarding", "errorCode", "", "errorMessage", "<init>", "(Ljava/lang/String;Lcom/obric/assistant/dora/DoraDeviceInfo;ZZZZILjava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "getDeviceInfo", "()Lcom/obric/assistant/dora/DoraDeviceInfo;", "()Z", "getConnectAttempted", "getConnectSuccess", "getShouldStartOnboarding", "getErrorCode", "()I", "getErrorMessage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraMainProcessConnectResult implements Parcelable {
    public static final Parcelable.Creator<DoraMainProcessConnectResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f389082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraDeviceInfo f389083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f389084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f389085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f389086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f389087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f389088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f389089h;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<DoraMainProcessConnectResult> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoraMainProcessConnectResult createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            DoraDeviceInfo r101 = DoraDeviceInfo.CREATOR.createFromParcel(r110);
            if (r110.readInt() == 0) goto L5;
            boolean r102 = true;
        L7:
            if (r110.readInt() == 0) goto L9;
            boolean r103 = true;
        L11:
            if (r110.readInt() == 0) goto L13;
            boolean r104 = true;
        L15:
            if (r110.readInt() == 0) goto L17;
            boolean r105 = true;
        L18:
            boolean r106 = r102;
            boolean r107 = r103;
            boolean r108 = r104;
            boolean r109 = r105;
            return new DoraMainProcessConnectResult(r100, r101, r106, r107, r108, r109, r110.readInt(), r110.readString());
        L17:
            r105 = false;
            goto L18
        L13:
            r104 = false;
            goto L15
        L9:
            r103 = false;
            goto L11
        L5:
            r102 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final DoraMainProcessConnectResult[] newArray(int r100) {
            return new DoraMainProcessConnectResult[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    public DoraMainProcessConnectResult() {
        this(null, null, false, false, false, 0, null, 255);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraMainProcessConnectResult) == true) goto L8;
        return false;
    L8:
        DoraMainProcessConnectResult r101 = (DoraMainProcessConnectResult) r100;
        if (Intrinsics.areEqual(this.f389082a, r101.f389082a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f389083b, r101.f389083b) == true) goto L15;
        return false;
    L15:
        if (this.f389084c == r101.f389084c) goto L18;
        return false;
    L18:
        if (this.f389085d == r101.f389085d) goto L21;
        return false;
    L21:
        if (this.f389086e == r101.f389086e) goto L24;
        return false;
    L24:
        if (this.f389087f == r101.f389087f) goto L27;
        return false;
    L27:
        if (this.f389088g == r101.f389088g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f389089h, r101.f389089h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f389082a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f389083b.hashCode()) * 31;
        int r104 = 1231;
        if (this.f389084c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f389085d == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f389086e == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f389087f == true) goto L22;
        r104 = 1237;
    L22:
        int r111 = (((r110 + r104) * 31) + this.f389088g) * 31;
        String r112 = this.f389089h;
        if (r112 == null) goto L27;
        r101 = r112.hashCode();
    L27:
        return r111 + r101;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraMainProcessConnectResult(requestId=" + this.f389082a + ", deviceInfo=" + this.f389083b + ", isBound=" + this.f389084c + ", connectAttempted=" + this.f389085d + ", connectSuccess=" + this.f389086e + ", shouldStartOnboarding=" + this.f389087f + ", errorCode=" + this.f389088g + ", errorMessage=" + this.f389089h + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f389082a);
        this.f389083b.writeToParcel(r100, r101);
        r100.writeInt(this.f389084c ? 1 : 0);
        r100.writeInt(this.f389085d ? 1 : 0);
        r100.writeInt(this.f389086e ? 1 : 0);
        r100.writeInt(this.f389087f ? 1 : 0);
        r100.writeInt(this.f389088g);
        r100.writeString(this.f389089h);
    }

    public /* synthetic */ DoraMainProcessConnectResult(String r110, DoraDeviceInfo r210, boolean r211, boolean r212, boolean r213, int r214, String r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        DoraDeviceInfo r101 = new DoraDeviceInfo(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 16383);
    L11:
        if ((r216 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r216 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r216 & 32) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r216 & 64) == 0) goto L25;
        int r111 = 0;
    L27:
        if ((r216 & 128) == 0) goto L29;
        String r112 = null;
    L30:
        this(r100, r101, r102, r103, false, r104, r111, r112);
        return;
    L29:
        r112 = r215;
        goto L30
    L25:
        r111 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public DoraMainProcessConnectResult(String r100, DoraDeviceInfo r101, boolean r102, boolean r103, boolean r104, boolean r105, int r106, String r107) {
        Intrinsics.checkNotNullParameter(r101, "deviceInfo");
        this.f389082a = r100;
        this.f389083b = r101;
        this.f389084c = r102;
        this.f389085d = r103;
        this.f389086e = r104;
        this.f389087f = r105;
        this.f389088g = r106;
        this.f389089h = r107;
    }
}
