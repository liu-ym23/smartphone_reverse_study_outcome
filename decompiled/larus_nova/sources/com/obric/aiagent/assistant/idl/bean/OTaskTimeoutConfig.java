package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OTaskTimeoutConfig;", "Landroid/os/Parcelable;", "oAutoTaskTimeout", "", "complexTaskTimeout", "simpleTaskTimeout", "<init>", "(JJJ)V", "getOAutoTaskTimeout", "()J", "getComplexTaskTimeout", "getSimpleTaskTimeout", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OTaskTimeoutConfig implements Parcelable {
    public static final Parcelable.Creator<OTaskTimeoutConfig> CREATOR = null;
    private final long complexTaskTimeout;
    private final long oAutoTaskTimeout;
    private final long simpleTaskTimeout;

    public static final class a implements Parcelable.Creator<OTaskTimeoutConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OTaskTimeoutConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new OTaskTimeoutConfig(r100.readLong(), r100.readLong(), r100.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final OTaskTimeoutConfig[] newArray(int r100) {
            return new OTaskTimeoutConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.oAutoTaskTimeout);
        r100.writeLong(this.complexTaskTimeout);
        r100.writeLong(this.simpleTaskTimeout);
    }

    public final long getComplexTaskTimeout() {
        return this.complexTaskTimeout;
    }

    public final long getOAutoTaskTimeout() {
        return this.oAutoTaskTimeout;
    }

    public final long getSimpleTaskTimeout() {
        return this.simpleTaskTimeout;
    }

    public OTaskTimeoutConfig(long r100, long r101, long r102) {
        this.oAutoTaskTimeout = r100;
        this.complexTaskTimeout = r101;
        this.simpleTaskTimeout = r102;
    }
}
