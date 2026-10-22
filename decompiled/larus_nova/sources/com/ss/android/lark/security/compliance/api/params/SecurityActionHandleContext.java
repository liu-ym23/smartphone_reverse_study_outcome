package com.ss.android.lark.security.compliance.api.params;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/params/SecurityActionHandleContext;", "Landroid/os/Parcelable;", "pointKey", "", "cacheHitTaskId", "cacheType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPointKey", "()Ljava/lang/String;", "getCacheHitTaskId", "getCacheType", "cacheHitIdentifier", "getCacheHitIdentifier", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecurityActionHandleContext implements Parcelable {
    public static final Parcelable.Creator<SecurityActionHandleContext> CREATOR = null;
    private final String cacheHitTaskId;
    private final String cacheType;
    private final String pointKey;

    public static final class a implements Parcelable.Creator<SecurityActionHandleContext> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SecurityActionHandleContext createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SecurityActionHandleContext(r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SecurityActionHandleContext[] newArray(int r100) {
            return new SecurityActionHandleContext[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SecurityActionHandleContext() {
        this(null, null, null, 7, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.pointKey);
        r100.writeString(this.cacheHitTaskId);
        r100.writeString(this.cacheType);
    }

    public final String getCacheHitIdentifier() {
        return this.cacheType;
    }

    public final String getCacheHitTaskId() {
        return this.cacheHitTaskId;
    }

    public final String getCacheType() {
        return this.cacheType;
    }

    public final String getPointKey() {
        return this.pointKey;
    }

    public SecurityActionHandleContext(String r100, String r101, String r102) {
        this.pointKey = r100;
        this.cacheHitTaskId = r101;
        this.cacheType = r102;
    }

    public /* synthetic */ SecurityActionHandleContext(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
