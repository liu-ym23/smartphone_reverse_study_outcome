package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmSpeakerAvatarToJS;", "Ljava/io/Serializable;", "key", "", "fsUnit", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getFsUnit", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmSpeakerAvatarToJS implements Serializable {

    @SerializedName("fs_unit")
    private final String fsUnit;

    @SerializedName("key")
    private final String key;

    public static /* synthetic */ MmSpeakerAvatarToJS copy$default(MmSpeakerAvatarToJS r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.fsUnit;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.fsUnit;
    }

    public final MmSpeakerAvatarToJS copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "fsUnit");
        return new MmSpeakerAvatarToJS(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmSpeakerAvatarToJS) == true) goto L8;
        return false;
    L8:
        MmSpeakerAvatarToJS r101 = (MmSpeakerAvatarToJS) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fsUnit, r101.fsUnit) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + this.fsUnit.hashCode();
    }

    public String toString() {
        return "MmSpeakerAvatarToJS(key=" + this.key + ", fsUnit=" + this.fsUnit + ')';
    }

    public final String getFsUnit() {
        return this.fsUnit;
    }

    public final String getKey() {
        return this.key;
    }

    public MmSpeakerAvatarToJS(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "fsUnit");
        this.key = r100;
        this.fsUnit = r101;
    }
}
