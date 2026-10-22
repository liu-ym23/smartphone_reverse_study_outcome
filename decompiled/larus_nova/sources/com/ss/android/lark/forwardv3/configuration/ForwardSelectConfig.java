package com.ss.android.lark.forwardv3.configuration;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.RemoteOnCancelMultiSelectListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020\u0011H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/ForwardSelectConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "enableSwitchSelectMode", "", "getEnableSwitchSelectMode", "()Z", "setEnableSwitchSelectMode", "(Z)V", "defaultSingleSelectMode", "getDefaultSingleSelectMode", "setDefaultSingleSelectMode", "maxLimitSelectNum", "", "getMaxLimitSelectNum", "()I", "setMaxLimitSelectNum", "(I)V", "cancelMultiSelectListener", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCancelMultiSelectListener;", "cancelMultiSelectListenerProxy", "Lcom/ss/android/lark/forwardv3/RemoteOnCancelMultiSelectListener;", "setCancelMultiSelectListener", "", "listener", "getCancelMultiSelectListener", "writeToParcel", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardSelectConfig implements Parcelable {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f425186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f425187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f425188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f425189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RemoteOnCancelMultiSelectListener f425190e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f425191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f425192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f425193c;

        public final ForwardSelectConfig a() {
            ForwardSelectConfig r100 = new ForwardSelectConfig();
            r100.f425186a = this.f425191a;
            r100.f425187b = this.f425192b;
            r100.f425188c = this.f425193c;
            final e r101 = r100.f425189d;
            if (r101 == null) goto L6;
            r100.f425190e = new ForwardSelectConfig$setCancelMultiSelectListener$1(r101);
        L6:
            return r100;
        }

        public a() {
            this.f425191a = true;
            this.f425192b = true;
            this.f425193c = 10;
        }
    }

    public static final class b implements Parcelable.Creator<ForwardSelectConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardSelectConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ForwardSelectConfig r101 = new ForwardSelectConfig();
            boolean r102 = true;
            if (r100.readByte() == 0) goto L5;
            boolean r103 = true;
        L6:
            r101.f425186a = r103;
            if (r100.readByte() != 0) goto L10;
            r102 = false;
        L10:
            r101.f425187b = r102;
            r101.f425188c = r100.readInt();
            if (r100.readInt() <= 0) goto L13;
            r101.f425190e = RemoteOnCancelMultiSelectListener.Stub.asInterface(r100.readStrongBinder());
        L13:
            return r101;
        L5:
            r103 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardSelectConfig[] newArray(int r100) {
            return new ForwardSelectConfig[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardSelectConfig() {
        this.f425186a = true;
        this.f425187b = true;
        this.f425188c = 10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeByte(this.f425186a ? 1 : 0);
        r100.writeByte(this.f425187b ? 1 : 0);
        r100.writeInt(this.f425188c);
        if (this.f425190e == null) goto L9;
        r100.writeInt(1);
        RemoteOnCancelMultiSelectListener r102 = this.f425190e;
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
