package com.ss.android.lark.forwardv3.configuration;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.RemoteOnForwardNoteListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/ForwardAdditionNoteConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "enableAdditionNote", "", "getEnableAdditionNote", "()Z", "setEnableAdditionNote", "(Z)V", "enableAdditionNoteAT", "getEnableAdditionNoteAT", "setEnableAdditionNoteAT", "forwardNoteListener", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardNoteListener;", "forwardNoteListenerProxy", "Lcom/ss/android/lark/forwardv3/RemoteOnForwardNoteListener;", "setForwardNoteListener", "", "listener", "getForwardNoteListener", "writeToParcel", "flags", "", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardAdditionNoteConfig implements Parcelable {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f425153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f425154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.lark.forwardv3.configuration.b f425155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RemoteOnForwardNoteListener f425156d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f425157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f425158b;

        public final ForwardAdditionNoteConfig a() {
            ForwardAdditionNoteConfig r100 = new ForwardAdditionNoteConfig();
            r100.f425153a = this.f425157a;
            r100.f425154b = this.f425158b;
            return r100;
        }

        public a() {
            this.f425157a = true;
            this.f425158b = true;
        }
    }

    public static final class b implements Parcelable.Creator<ForwardAdditionNoteConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardAdditionNoteConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ForwardAdditionNoteConfig r101 = new ForwardAdditionNoteConfig();
            boolean r102 = true;
            if (r100.readByte() == 0) goto L5;
            boolean r103 = true;
        L6:
            r101.f425153a = r103;
            if (r100.readByte() != 0) goto L10;
            r102 = false;
        L10:
            r101.f425154b = r102;
            if (r100.readInt() <= 0) goto L13;
            r101.f425156d = RemoteOnForwardNoteListener.Stub.asInterface(r100.readStrongBinder());
        L13:
            return r101;
        L5:
            r103 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardAdditionNoteConfig[] newArray(int r100) {
            return new ForwardAdditionNoteConfig[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardAdditionNoteConfig() {
        this.f425153a = true;
        this.f425154b = true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeByte(this.f425153a ? 1 : 0);
        r100.writeByte(this.f425154b ? 1 : 0);
        if (this.f425156d == null) goto L9;
        r100.writeInt(1);
        RemoteOnForwardNoteListener r102 = this.f425156d;
        if (r102 == null) goto L7;
        IBinder r103 = r102.asBinder();
    L8:
        r100.writeStrongBinder(r103);
        return;
    L7:
        r103 = null;
        goto L8
    L9:
        r100.writeInt(0);
    }
}
