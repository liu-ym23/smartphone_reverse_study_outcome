package com.obric.sva.sdk.db;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JL\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\tHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006$"}, d2 = {"Lcom/obric/sva/sdk/db/SvaVoicePrintControl;", "", "id", "", "verisonId", "", ST.UUID_DEVICE, "audioEngineVersion", "state", "", "misc", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVerisonId", "()Ljava/lang/String;", "getUuid", "getAudioEngineVersion", "getState", "()I", "getMisc", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/obric/sva/sdk/db/SvaVoicePrintControl;", "equals", "", "other", "hashCode", "toString", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SvaVoicePrintControl {
    private final String audioEngineVersion;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final Long f403888id;
    private final String misc;
    private final int state;
    private final String uuid;
    private final String verisonId;

    public static /* synthetic */ SvaVoicePrintControl copy$default(SvaVoicePrintControl r100, Long r101, String r102, String r103, String r104, int r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f403888id;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.verisonId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.uuid;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.audioEngineVersion;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.state;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.misc;
    L20:
        Long r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Long component1() {
        return this.f403888id;
    }

    public final String component2() {
        return this.verisonId;
    }

    public final String component3() {
        return this.uuid;
    }

    public final String component4() {
        return this.audioEngineVersion;
    }

    public final int component5() {
        return this.state;
    }

    public final String component6() {
        return this.misc;
    }

    public final SvaVoicePrintControl copy(Long r100, String r110, String r111, String r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "verisonId");
        Intrinsics.checkNotNullParameter(r111, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r112, "audioEngineVersion");
        Intrinsics.checkNotNullParameter(r114, "misc");
        return new SvaVoicePrintControl(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SvaVoicePrintControl) == true) goto L8;
        return false;
    L8:
        SvaVoicePrintControl r101 = (SvaVoicePrintControl) r100;
        if (Intrinsics.areEqual(this.f403888id, r101.f403888id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.verisonId, r101.verisonId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uuid, r101.uuid) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.audioEngineVersion, r101.audioEngineVersion) == true) goto L21;
        return false;
    L21:
        if (this.state == r101.state) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.misc, r101.misc) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Long r100 = this.f403888id;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((((((r101 * 31) + this.verisonId.hashCode()) * 31) + this.uuid.hashCode()) * 31) + this.audioEngineVersion.hashCode()) * 31) + this.state) * 31) + this.misc.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "SvaVoicePrintControl(id=" + this.f403888id + ", verisonId=" + this.verisonId + ", uuid=" + this.uuid + ", audioEngineVersion=" + this.audioEngineVersion + ", state=" + this.state + ", misc=" + this.misc + ')';
    }

    public final String getAudioEngineVersion() {
        return this.audioEngineVersion;
    }

    public final Long getId() {
        return this.f403888id;
    }

    public final String getMisc() {
        return this.misc;
    }

    public final int getState() {
        return this.state;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getVerisonId() {
        return this.verisonId;
    }

    public SvaVoicePrintControl(Long r100, String r101, String r102, String r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r101, "verisonId");
        Intrinsics.checkNotNullParameter(r102, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r103, "audioEngineVersion");
        Intrinsics.checkNotNullParameter(r105, "misc");
        this.f403888id = r100;
        this.verisonId = r101;
        this.uuid = r102;
        this.audioEngineVersion = r103;
        this.state = r104;
        this.misc = r105;
    }

    public /* synthetic */ SvaVoicePrintControl(Long r100, String r101, String r110, String r111, int r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        r100 = null;
    L5:
        Long r102 = r100;
        if ((r114 & 4) == 0) goto L8;
        String r103 = "";
    L10:
        if ((r114 & 8) == 0) goto L12;
        String r104 = "";
    L14:
        if ((r114 & 16) == 0) goto L16;
        int r105 = 0;
    L18:
        if ((r114 & 32) == 0) goto L20;
        String r106 = "";
    L21:
        this(r102, r101, r103, r104, r105, r106);
        return;
    L20:
        r106 = r113;
        goto L21
    L16:
        r105 = r112;
        goto L18
    L12:
        r104 = r111;
        goto L14
    L8:
        r103 = r110;
        goto L10
    }
}
