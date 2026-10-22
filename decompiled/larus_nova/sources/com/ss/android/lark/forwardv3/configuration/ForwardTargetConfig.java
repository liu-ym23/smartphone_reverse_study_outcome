package com.ss.android.lark.forwardv3.configuration;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.RemoteOnForwardTargetCustomDisableListener;
import com.ss.android.lark.forwardv3.configuration.targetconfig.DisableConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010 H\u0002J\b\u0010&\u001a\u0004\u0018\u00010 J\u0018\u0010'\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/ForwardTargetConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "enableChatPreview", "", "getEnableChatPreview", "()Z", "setEnableChatPreview", "(Z)V", "enableAIKnowledge", "getEnableAIKnowledge", "setEnableAIKnowledge", "enableExternalTarget", "getEnableExternalTarget", "setEnableExternalTarget", "includeConfig", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/IncludeConfig;", "getIncludeConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/IncludeConfig;", "setIncludeConfig", "(Lcom/ss/android/lark/forwardv3/configuration/targetconfig/IncludeConfig;)V", "disableConfig", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/DisableConfig;", "getDisableConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/DisableConfig;", "setDisableConfig", "(Lcom/ss/android/lark/forwardv3/configuration/targetconfig/DisableConfig;)V", "customDisableListener", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardTargetCustomDisableListener;", "customDisableListenerProxy", "Lcom/ss/android/lark/forwardv3/RemoteOnForwardTargetCustomDisableListener;", "setOnForwardTargetCustomDisableListener", "", "listener", "getOnForwardTargetCustomDisableListener", "writeToParcel", "flags", "", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardTargetConfig implements Parcelable {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f425194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f425195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f425196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IncludeConfig f425197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DisableConfig f425198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f425199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RemoteOnForwardTargetCustomDisableListener f425200g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f425201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f425202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f425203c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public IncludeConfig f425204d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public DisableConfig f425205e;

        public final ForwardTargetConfig a() {
            ForwardTargetConfig r100 = new ForwardTargetConfig();
            r100.f425194a = this.f425201a;
            r100.f425195b = this.f425202b;
            r100.f425196c = this.f425203c;
            r100.f425197d = this.f425204d;
            r100.f425198e = this.f425205e;
            return r100;
        }

        public a() {
            this.f425201a = true;
        }
    }

    public static final class b implements Parcelable.Creator<ForwardTargetConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ForwardTargetConfig r101 = new ForwardTargetConfig();
            boolean r102 = true;
            if (r100.readByte() == 0) goto L5;
            boolean r103 = true;
        L6:
            r101.f425194a = r103;
            if (r100.readByte() == 0) goto L9;
            boolean r104 = true;
        L10:
            r101.f425195b = r104;
            if (r100.readByte() != 0) goto L14;
            r102 = false;
        L14:
            r101.f425196c = r102;
            r101.f425197d = (IncludeConfig) r100.readParcelable(ForwardTargetConfig.class.getClassLoader());
            r101.f425198e = (DisableConfig) r100.readParcelable(ForwardTargetConfig.class.getClassLoader());
            if (r100.readInt() <= 0) goto L17;
            r101.f425200g = RemoteOnForwardTargetCustomDisableListener.Stub.asInterface(r100.readStrongBinder());
        L17:
            return r101;
        L9:
            r104 = false;
            goto L10
        L5:
            r103 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetConfig[] newArray(int r100) {
            return new ForwardTargetConfig[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardTargetConfig() {
        this.f425194a = true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeByte(this.f425194a ? 1 : 0);
        r100.writeByte(this.f425195b ? 1 : 0);
        r100.writeByte(this.f425196c ? 1 : 0);
        r100.writeParcelable(this.f425197d, r101);
        r100.writeParcelable(this.f425198e, r101);
        if (this.f425200g == null) goto L9;
        r100.writeInt(1);
        RemoteOnForwardTargetCustomDisableListener r102 = this.f425200g;
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
