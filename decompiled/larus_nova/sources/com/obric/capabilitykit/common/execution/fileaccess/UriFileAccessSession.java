package com.obric.capabilitykit.common.execution.fileaccess;

import android.content.res.AssetFileDescriptor;
import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "Landroid/os/Parcelable;", "ErrorCode", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final class UriFileAccessSession implements Parcelable {
    public static final Parcelable.Creator<UriFileAccessSession> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f396183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f396184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AssetFileDescriptor f396185c;

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession$ErrorCode;", "", "()V", "ERROR_ACCESSING_INPUT_STREAM", "", "ERROR_ACCESSING_SHARER", "ERROR_INVALID_SHARER", "ERROR_NOT_SHARED_BY_THIS_ENTITY", "ERROR_OPENING_INPUT_STREAM", "ERROR_OPENING_URI", "ERROR_REQUESTING_URI", "ERROR_TIMEOUT", "ERROR_UNKNOWN_ERROR", "NO_ERROR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ErrorCode {
        public static final int ERROR_ACCESSING_INPUT_STREAM = 6;
        public static final int ERROR_ACCESSING_SHARER = 8;
        public static final int ERROR_INVALID_SHARER = 3;
        public static final int ERROR_NOT_SHARED_BY_THIS_ENTITY = 2;
        public static final int ERROR_OPENING_INPUT_STREAM = 5;
        public static final int ERROR_OPENING_URI = 4;
        public static final int ERROR_REQUESTING_URI = 7;
        public static final int ERROR_TIMEOUT = 9;
        public static final int ERROR_UNKNOWN_ERROR = 1;
        public static final ErrorCode INSTANCE = null;
        public static final int NO_ERROR = 0;

        static {
            INSTANCE = new ErrorCode();
        }

        private ErrorCode() {
        }
    }

    public static final class a implements Parcelable.Creator<UriFileAccessSession> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UriFileAccessSession createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new UriFileAccessSession(r100.readInt(), r100.readString(), (AssetFileDescriptor) r100.readParcelable(UriFileAccessSession.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final UriFileAccessSession[] newArray(int r100) {
            return new UriFileAccessSession[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public UriFileAccessSession() {
        int r100 = 0;
        this(r100, null, 7);
    }

    public /* synthetic */ UriFileAccessSession(int r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101, null);
    }

    public UriFileAccessSession(int r100, String r101, AssetFileDescriptor r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f396183a = r100;
        this.f396184b = r101;
        this.f396185c = r102;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UriFileAccessSession) == true) goto L8;
        return false;
    L8:
        UriFileAccessSession r101 = (UriFileAccessSession) r100;
        if (this.f396183a == r101.f396183a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f396184b, r101.f396184b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f396185c, r101.f396185c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f396183a * 31) + this.f396184b.hashCode()) * 31;
        AssetFileDescriptor r101 = this.f396185c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "UriFileAccessSession(status=" + this.f396183a + ", message=" + this.f396184b + ", fd=" + this.f396185c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeInt(this.f396183a);
        r100.writeString(this.f396184b);
        r100.writeParcelable(this.f396185c, r101);
    }
}
