package com.ss.android.lark.forwardv3.configuration;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.RemoteOnCloseForwardListener;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u000245B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010$H\u0002J\b\u00100\u001a\u0004\u0018\u00010$J\u0018\u00101\u001a\u00020.2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00102\u001a\u00020\bH\u0016J\b\u00103\u001a\u00020\bH\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00066"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/ForwardCommonConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "resultCode", "", "getResultCode", "()Ljava/lang/Integer;", "setResultCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "showTitleBar", "", "getShowTitleBar", "()Z", "setShowTitleBar", "(Z)V", "enableCreateGroupChat", "getEnableCreateGroupChat", "setEnableCreateGroupChat", "enableRecentForward", "getEnableRecentForward", "setEnableRecentForward", "titleBarText", "", "getTitleBarText", "()Ljava/lang/String;", "setTitleBarText", "(Ljava/lang/String;)V", "enableBackOriginalApplication", "getEnableBackOriginalApplication", "setEnableBackOriginalApplication", "onCloseForwardListener", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCloseForwardListener;", "onCloseForwardListenerProxy", "Lcom/ss/android/lark/forwardv3/RemoteOnCloseForwardListener;", "forwardContentListener", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "getForwardContentListener", "()Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "setForwardContentListener", "(Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;)V", "setOnCloseForwardListener", "", "listener", "getOnCloseForwardListener", "writeToParcel", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardCommonConfig implements Parcelable {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f425159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f425160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f425161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f425162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f425163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f425164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f425165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RemoteOnCloseForwardListener f425166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OnForwardContentListener f425167i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f425168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f425169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f425170c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f425171d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public oib.b f425172e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public OnForwardContentListener f425173f;

        public final ForwardCommonConfig a() {
            ForwardCommonConfig r100 = new ForwardCommonConfig();
            r100.f425159a = null;
            r100.f425160b = this.f425168a;
            r100.f425161c = this.f425169b;
            r100.f425162d = this.f425170c;
            String r101 = this.f425171d;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f425163e = r101;
            r100.f425164f = false;
            final oib.b r102 = this.f425172e;
            if (r102 == null) goto L6;
            r100.f425166h = new ForwardCommonConfig$setOnCloseForwardListener$1(r102);
        L6:
            r100.f425167i = this.f425173f;
            return r100;
        }

        public a() {
            this.f425168a = true;
            this.f425169b = true;
            this.f425170c = true;
            this.f425171d = "";
        }
    }

    public static final class b implements Parcelable.Creator<ForwardCommonConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardCommonConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ForwardCommonConfig r101 = new ForwardCommonConfig();
            if (r100.readInt() != (-10000)) goto L5;
            Integer r102 = null;
        L6:
            r101.f425159a = r102;
            boolean r103 = true;
            if (r100.readByte() == 0) goto L9;
            boolean r104 = true;
        L10:
            r101.f425160b = r104;
            if (r100.readByte() == 0) goto L13;
            boolean r105 = true;
        L14:
            r101.f425161c = r105;
            if (r100.readByte() == 0) goto L17;
            boolean r106 = true;
        L18:
            r101.f425162d = r106;
            String r107 = r100.readString();
            if (r107 != null) goto L21;
            r107 = "";
        L21:
            r101.f425163e = r107;
            if (r100.readByte() != 0) goto L25;
            r103 = false;
        L25:
            r101.f425164f = r103;
            if (r100.readInt() <= 0) goto L28;
            r101.f425166h = RemoteOnCloseForwardListener.Stub.asInterface(r100.readStrongBinder());
        L28:
            r101.f425167i = (OnForwardContentListener) r100.readParcelable(ForwardCommonConfig.class.getClassLoader());
            return r101;
        L17:
            r106 = false;
            goto L18
        L13:
            r105 = false;
            goto L14
        L9:
            r104 = false;
            goto L10
        L5:
            r102 = Integer.valueOf(r100.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardCommonConfig[] newArray(int r100) {
            return new ForwardCommonConfig[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardCommonConfig() {
        this.f425160b = true;
        this.f425161c = true;
        this.f425162d = true;
        this.f425163e = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        Integer r102 = this.f425159a;
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        r100.writeInt(r103);
        r100.writeByte(this.f425160b ? 1 : 0);
        r100.writeByte(this.f425161c ? 1 : 0);
        r100.writeByte(this.f425162d ? 1 : 0);
        r100.writeString(this.f425163e);
        r100.writeByte(this.f425164f ? 1 : 0);
        if (this.f425166h == null) goto L13;
        r100.writeInt(1);
        RemoteOnCloseForwardListener r104 = this.f425166h;
        if (r104 == null) goto L11;
        IBinder r105 = r104.asBinder();
    L12:
        r100.writeStrongBinder(r105);
    L14:
        r100.writeParcelable(this.f425167i, r101);
        return;
    L11:
        r105 = null;
        goto L12
    L13:
        r100.writeInt(0);
        goto L14
    L5:
        r103 = -10000;
        goto L6
    }
}
