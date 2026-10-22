package com.larus.settings.provider;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/settings/provider/SendEntityConfig;", "", "maxParallelUploadEntityCount", "", "<init>", "(Ljava/lang/Integer;)V", "getMaxParallelUploadEntityCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/larus/settings/provider/SendEntityConfig;", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendEntityConfig {

    @SerializedName("max_parallel_upload_entity_count")
    private final Integer maxParallelUploadEntityCount;

    /* JADX WARN: Multi-variable type inference failed */
    public SendEntityConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SendEntityConfig copy$default(SendEntityConfig r100, Integer r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.maxParallelUploadEntityCount;
    L6:
        return r100.copy(r101);
    }

    public final Integer component1() {
        return this.maxParallelUploadEntityCount;
    }

    public final SendEntityConfig copy(Integer r100) {
        return new SendEntityConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SendEntityConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.maxParallelUploadEntityCount, ((SendEntityConfig) r100).maxParallelUploadEntityCount) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.maxParallelUploadEntityCount;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "SendEntityConfig(maxParallelUploadEntityCount=" + this.maxParallelUploadEntityCount + ')';
    }

    public final Integer getMaxParallelUploadEntityCount() {
        return this.maxParallelUploadEntityCount;
    }

    public SendEntityConfig(Integer r100) {
        this.maxParallelUploadEntityCount = r100;
    }

    public /* synthetic */ SendEntityConfig(Integer r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
