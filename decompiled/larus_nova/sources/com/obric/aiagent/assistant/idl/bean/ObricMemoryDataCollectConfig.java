package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/ObricMemoryDataCollectConfig;", "Landroid/os/Parcelable;", "enable", "", "<init>", "(Ljava/lang/Boolean;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMemoryDataCollectConfig implements Parcelable {
    public static final Parcelable.Creator<ObricMemoryDataCollectConfig> CREATOR = null;
    private final Boolean enable;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<ObricMemoryDataCollectConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ObricMemoryDataCollectConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L6;
            Boolean r101 = null;
        L11:
            return new ObricMemoryDataCollectConfig(r101);
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r102 = true;
        L9:
            r101 = Boolean.valueOf(r102);
            goto L11
        L8:
            r102 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final ObricMemoryDataCollectConfig[] newArray(int r100) {
            return new ObricMemoryDataCollectConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricMemoryDataCollectConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Boolean r102 = this.enable;
        if (r102 != null) goto L6;
        ?? r103 = 0;
    L5:
        r100.writeInt(r103);
        return;
    L6:
        r100.writeInt(1);
        r103 = r102.booleanValue();
        goto L5
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public ObricMemoryDataCollectConfig(Boolean r100) {
        this.enable = r100;
    }

    public /* synthetic */ ObricMemoryDataCollectConfig(Boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = Boolean.FALSE;
    L5:
        this(r100);
    }
}
