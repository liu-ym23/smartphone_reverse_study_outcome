package com.ss.android.lark.forwardv3.configuration;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.RemoteOnForwardConfirmDialogListener;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010 H\u0002J\b\u0010&\u001a\u0004\u0018\u00010 J\u0018\u0010'\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/ForwardConfirmDialogConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "titleBarText", "", "getTitleBarText", "()Ljava/lang/String;", "setTitleBarText", "(Ljava/lang/String;)V", "confirmButtonText", "getConfirmButtonText", "setConfirmButtonText", "cancelButtonText", "getCancelButtonText", "setCancelButtonText", "dialogContentConfig", "Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "getDialogContentConfig", "()Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "setDialogContentConfig", "(Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;)V", "customConfirmDialogContentView", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;", "getCustomConfirmDialogContentView", "()Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;", "setCustomConfirmDialogContentView", "(Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;)V", "confirmDialogListener", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardConfirmDialogListener;", "confirmDialogListenerProxy", "Lcom/ss/android/lark/forwardv3/RemoteOnForwardConfirmDialogListener;", "setConfirmDialogListener", "", "listener", "getConfirmDialogListener", "writeToParcel", "flags", "", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardConfirmDialogConfig implements Parcelable {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f425174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f425175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f425176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BasicDialogContentConfig f425177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnCustomForwardConfirmDialogContentView f425178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f425179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RemoteOnForwardConfirmDialogListener f425180g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f425181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f425182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f425183c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public BasicDialogContentConfig f425184d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public OnCustomForwardConfirmDialogContentView f425185e;

        public final ForwardConfirmDialogConfig a() {
            ForwardConfirmDialogConfig r100 = new ForwardConfirmDialogConfig();
            String r101 = this.f425181a;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f425174a = r101;
            String r102 = this.f425182b;
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r100.f425175b = r102;
            String r103 = this.f425183c;
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r100.f425176c = r103;
            r100.f425177d = this.f425184d;
            r100.f425178e = this.f425185e;
            return r100;
        }

        public a() {
            this.f425181a = "";
            this.f425182b = "";
            this.f425183c = "";
        }
    }

    public static final class b implements Parcelable.Creator<ForwardConfirmDialogConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardConfirmDialogConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ForwardConfirmDialogConfig r101 = new ForwardConfirmDialogConfig();
            String r102 = r100.readString();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.f425174a = r102;
            String r104 = r100.readString();
            if (r104 != null) goto L8;
            r104 = "";
        L8:
            r101.f425175b = r104;
            String r105 = r100.readString();
            if (r105 == null) goto L12;
            r103 = r105;
        L12:
            r101.f425176c = r103;
            r101.f425177d = (BasicDialogContentConfig) r100.readParcelable(ForwardConfirmDialogConfig.class.getClassLoader());
            if (r100.readInt() <= 0) goto L15;
            r101.f425180g = RemoteOnForwardConfirmDialogListener.Stub.asInterface(r100.readStrongBinder());
        L15:
            r101.f425178e = (OnCustomForwardConfirmDialogContentView) r100.readParcelable(ForwardConfirmDialogConfig.class.getClassLoader());
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardConfirmDialogConfig[] newArray(int r100) {
            return new ForwardConfirmDialogConfig[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardConfirmDialogConfig() {
        this.f425174a = "";
        this.f425175b = "";
        this.f425176c = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f425174a);
        r100.writeString(this.f425175b);
        r100.writeString(this.f425176c);
        r100.writeParcelable(this.f425177d, r101);
        if (this.f425180g == null) goto L9;
        r100.writeInt(1);
        RemoteOnForwardConfirmDialogListener r102 = this.f425180g;
        if (r102 == null) goto L7;
        IBinder r103 = r102.asBinder();
    L8:
        r100.writeStrongBinder(r103);
    L10:
        r100.writeParcelable(this.f425178e, r101);
        return;
    L7:
        r103 = null;
        goto L8
    L9:
        r100.writeInt(0);
        goto L10
    }
}
