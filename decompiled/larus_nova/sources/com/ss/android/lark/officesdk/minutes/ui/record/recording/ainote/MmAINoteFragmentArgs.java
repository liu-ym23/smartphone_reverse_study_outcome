package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001c¨\u0006+"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteFragmentArgs;", "Ljava/io/Serializable;", "ownerKey", "", "meetingId", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "minHeight", "", "initialDuration", "", "meetingStartTime", "expandImmediately", "", "isWavePlaying", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;IJJZZ)V", "getOwnerKey", "()Ljava/lang/String;", "getMeetingId", "getUiLaunchMode", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "getMinHeight", "()I", "getInitialDuration", "()J", "getMeetingStartTime", "getExpandImmediately", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmAINoteFragmentArgs implements Serializable {
    private final boolean expandImmediately;
    private final long initialDuration;
    private final boolean isWavePlaying;
    private final String meetingId;
    private final long meetingStartTime;
    private final int minHeight;
    private final String ownerKey;
    private final MmRecordingUILaunchMode uiLaunchMode;

    public static /* synthetic */ MmAINoteFragmentArgs copy$default(MmAINoteFragmentArgs r110, String r111, String r112, MmRecordingUILaunchMode r113, int r114, long r115, long r116, boolean r210, boolean r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.ownerKey;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.meetingId;
    L11:
        if ((r212 & 4) == 0) goto L13;
        MmRecordingUILaunchMode r102 = r110.uiLaunchMode;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r103 = r110.minHeight;
    L19:
        if ((r212 & 16) == 0) goto L21;
        long r104 = r110.initialDuration;
    L23:
        if ((r212 & 32) == 0) goto L25;
        long r105 = r110.meetingStartTime;
    L27:
        if ((r212 & 64) == 0) goto L29;
        boolean r117 = r110.expandImmediately;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r106 = r110.isWavePlaying;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r117, r106);
    L33:
        r106 = r211;
        goto L35
    L29:
        r117 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.ownerKey;
    }

    public final String component2() {
        return this.meetingId;
    }

    public final MmRecordingUILaunchMode component3() {
        return this.uiLaunchMode;
    }

    public final int component4() {
        return this.minHeight;
    }

    public final long component5() {
        return this.initialDuration;
    }

    public final long component6() {
        return this.meetingStartTime;
    }

    public final boolean component7() {
        return this.expandImmediately;
    }

    public final boolean component8() {
        return this.isWavePlaying;
    }

    public final MmAINoteFragmentArgs copy(String r110, String r111, MmRecordingUILaunchMode r112, int r113, long r114, long r115, boolean r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "ownerKey");
        Intrinsics.checkNotNullParameter(r111, "meetingId");
        Intrinsics.checkNotNullParameter(r112, "uiLaunchMode");
        return new MmAINoteFragmentArgs(r110, r111, r112, r113, r114, r115, r210, r211);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmAINoteFragmentArgs) == true) goto L8;
        return false;
    L8:
        MmAINoteFragmentArgs r101 = (MmAINoteFragmentArgs) r100;
        if (Intrinsics.areEqual(this.ownerKey, r101.ownerKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.meetingId, r101.meetingId) == true) goto L15;
        return false;
    L15:
        if (this.uiLaunchMode == r101.uiLaunchMode) goto L18;
        return false;
    L18:
        if (this.minHeight == r101.minHeight) goto L21;
        return false;
    L21:
        if (this.initialDuration == r101.initialDuration) goto L24;
        return false;
    L24:
        if (this.meetingStartTime == r101.meetingStartTime) goto L27;
        return false;
    L27:
        if (this.expandImmediately == r101.expandImmediately) goto L30;
        return false;
    L30:
        if (this.isWavePlaying == r101.isWavePlaying) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.ownerKey.hashCode() * 31) + this.meetingId.hashCode()) * 31) + this.uiLaunchMode.hashCode()) * 31) + this.minHeight) * 31;
        long r101 = this.initialDuration;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.meetingStartTime;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        int r105 = 1231;
        if (this.expandImmediately == false) goto L5;
        int r106 = 1231;
    L6:
        int r107 = (r104 + r106) * 31;
        if (this.isWavePlaying == true) goto L11;
        r105 = 1237;
    L11:
        return r107 + r105;
    L5:
        r106 = 1237;
        goto L6
    }

    public String toString() {
        return "MmAINoteFragmentArgs(ownerKey=" + this.ownerKey + ", meetingId=" + this.meetingId + ", uiLaunchMode=" + this.uiLaunchMode + ", minHeight=" + this.minHeight + ", initialDuration=" + this.initialDuration + ", meetingStartTime=" + this.meetingStartTime + ", expandImmediately=" + this.expandImmediately + ", isWavePlaying=" + this.isWavePlaying + ')';
    }

    public final boolean getExpandImmediately() {
        return this.expandImmediately;
    }

    public final long getInitialDuration() {
        return this.initialDuration;
    }

    public final String getMeetingId() {
        return this.meetingId;
    }

    public final long getMeetingStartTime() {
        return this.meetingStartTime;
    }

    public final int getMinHeight() {
        return this.minHeight;
    }

    public final String getOwnerKey() {
        return this.ownerKey;
    }

    public final MmRecordingUILaunchMode getUiLaunchMode() {
        return this.uiLaunchMode;
    }

    public final boolean isWavePlaying() {
        return this.isWavePlaying;
    }

    public MmAINoteFragmentArgs(String r100, String r101, MmRecordingUILaunchMode r102, int r103, long r104, long r105, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "ownerKey");
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        Intrinsics.checkNotNullParameter(r102, "uiLaunchMode");
        this.ownerKey = r100;
        this.meetingId = r101;
        this.uiLaunchMode = r102;
        this.minHeight = r103;
        this.initialDuration = r104;
        this.meetingStartTime = r105;
        this.expandImmediately = r110;
        this.isWavePlaying = r111;
    }

    public /* synthetic */ MmAINoteFragmentArgs(String r110, String r111, MmRecordingUILaunchMode r112, int r113, long r114, long r210, boolean r211, boolean r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 64) == 0) goto L5;
        boolean r115 = false;
    L7:
        if ((r213 & 128) == 0) goto L9;
        boolean r116 = true;
    L10:
        this(r110, r111, r112, r113, r114, r210, r115, r116);
        return;
    L9:
        r116 = r212;
        goto L10
    L5:
        r115 = r211;
        goto L7
    }
}
