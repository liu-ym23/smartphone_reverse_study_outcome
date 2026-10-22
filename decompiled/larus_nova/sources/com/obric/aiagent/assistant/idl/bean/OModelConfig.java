package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OModelConfig;", "Landroid/os/Parcelable;", "intentModel", "", "pcSearchModel", "queryWithPicTimeout", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getIntentModel", "()Ljava/lang/String;", "getPcSearchModel", "getQueryWithPicTimeout", "()J", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OModelConfig implements Parcelable {
    public static final Parcelable.Creator<OModelConfig> CREATOR = null;
    private final String intentModel;
    private final String pcSearchModel;
    private final long queryWithPicTimeout;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<OModelConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OModelConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new OModelConfig(r100.readString(), r100.readString(), r100.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final OModelConfig[] newArray(int r100) {
            return new OModelConfig[r100];
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
        r100.writeString(this.intentModel);
        r100.writeString(this.pcSearchModel);
        r100.writeLong(this.queryWithPicTimeout);
    }

    public final String getIntentModel() {
        return this.intentModel;
    }

    public final String getPcSearchModel() {
        return this.pcSearchModel;
    }

    public final long getQueryWithPicTimeout() {
        return this.queryWithPicTimeout;
    }

    public OModelConfig(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "intentModel");
        Intrinsics.checkNotNullParameter(r101, "pcSearchModel");
        this.intentModel = r100;
        this.pcSearchModel = r101;
        this.queryWithPicTimeout = r102;
    }
}
