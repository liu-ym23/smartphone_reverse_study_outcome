package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/platform/model/EnterpriseConfig;", "Ljava/io/Serializable;", "driveListFileType", "", "", "<init>", "(Ljava/util/List;)V", "getDriveListFileType", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnterpriseConfig implements Serializable {

    @SerializedName("drive_list_file_type")
    private final List<Integer> driveListFileType;

    /* JADX WARN: Multi-variable type inference failed */
    public EnterpriseConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EnterpriseConfig copy$default(EnterpriseConfig r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.driveListFileType;
    L6:
        return r100.copy(r101);
    }

    public final List<Integer> component1() {
        return this.driveListFileType;
    }

    public final EnterpriseConfig copy(List<Integer> r100) {
        return new EnterpriseConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EnterpriseConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.driveListFileType, ((EnterpriseConfig) r100).driveListFileType) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<Integer> r100 = this.driveListFileType;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "EnterpriseConfig(driveListFileType=" + this.driveListFileType + ')';
    }

    public final List<Integer> getDriveListFileType() {
        return this.driveListFileType;
    }

    public EnterpriseConfig(List<Integer> r100) {
        this.driveListFileType = r100;
    }

    public /* synthetic */ EnterpriseConfig(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = CollectionsKt.listOf(new Integer[]{0, 12, 22, 30, 3});
    L5:
        this(r100);
    }
}
