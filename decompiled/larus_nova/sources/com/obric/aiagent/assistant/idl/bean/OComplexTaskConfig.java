package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OComplexTaskConfig;", "Landroid/os/Parcelable;", "taskMode", "", "llmModel", "localSearchEnableScene", "", "modeLevel", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getTaskMode", "()Ljava/lang/String;", "getLlmModel", "getLocalSearchEnableScene", "()I", "getModeLevel", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OComplexTaskConfig implements Parcelable {
    public static final Parcelable.Creator<OComplexTaskConfig> CREATOR = null;
    private final String llmModel;
    private final int localSearchEnableScene;
    private final String modeLevel;
    private final String taskMode;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<OComplexTaskConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OComplexTaskConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new OComplexTaskConfig(r100.readString(), r100.readString(), r100.readInt(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final OComplexTaskConfig[] newArray(int r100) {
            return new OComplexTaskConfig[r100];
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
        r100.writeString(this.taskMode);
        r100.writeString(this.llmModel);
        r100.writeInt(this.localSearchEnableScene);
        r100.writeString(this.modeLevel);
    }

    public final String getLlmModel() {
        return this.llmModel;
    }

    public final int getLocalSearchEnableScene() {
        return this.localSearchEnableScene;
    }

    public final String getModeLevel() {
        return this.modeLevel;
    }

    public final String getTaskMode() {
        return this.taskMode;
    }

    public OComplexTaskConfig(String r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "taskMode");
        Intrinsics.checkNotNullParameter(r101, "llmModel");
        Intrinsics.checkNotNullParameter(r103, "modeLevel");
        this.taskMode = r100;
        this.llmModel = r101;
        this.localSearchEnableScene = r102;
        this.modeLevel = r103;
    }
}
