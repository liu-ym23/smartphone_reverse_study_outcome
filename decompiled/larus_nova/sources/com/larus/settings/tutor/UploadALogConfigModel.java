package com.larus.settings.tutor;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larus/settings/tutor/UploadALogConfigModel;", "", "enable", "", "times", "", "<init>", "(ZI)V", "getEnable", "()Z", "getTimes", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadALogConfigModel {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("times")
    private final int times;

    /* JADX WARN: Multi-variable type inference failed */
    public UploadALogConfigModel() {
        boolean r100 = false;
        Object[] r101 = 0 == true ? 1 : 0;
        this(r100, r101, 3, null);
    }

    public static /* synthetic */ UploadALogConfigModel copy$default(UploadALogConfigModel r100, boolean r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.times;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final int component2() {
        return this.times;
    }

    public final UploadALogConfigModel copy(boolean r100, int r101) {
        return new UploadALogConfigModel(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UploadALogConfigModel) == true) goto L8;
        return false;
    L8:
        UploadALogConfigModel r101 = (UploadALogConfigModel) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.times == r101.times) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.times;
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "UploadALogConfigModel(enable=" + this.enable + ", times=" + this.times + ')';
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getTimes() {
        return this.times;
    }

    public UploadALogConfigModel(boolean r100, int r101) {
        this.enable = r100;
        this.times = r101;
    }

    public /* synthetic */ UploadALogConfigModel(boolean r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 5;
    L8:
        this(r100, r101);
    }
}
