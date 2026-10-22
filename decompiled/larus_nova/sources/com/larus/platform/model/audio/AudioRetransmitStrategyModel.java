package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lq9.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/model/audio/AudioRetransmitStrategyModel;", "", "data", "Lcom/larus/platform/model/audio/AudioRetransmitModel;", "<init>", "(Lcom/larus/platform/model/audio/AudioRetransmitModel;)V", "getData", "()Lcom/larus/platform/model/audio/AudioRetransmitModel;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioRetransmitStrategyModel {

    @SerializedName("retransmit_data")
    private final e data;

    /* JADX WARN: Multi-variable type inference failed */
    public AudioRetransmitStrategyModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AudioRetransmitStrategyModel copy$default(AudioRetransmitStrategyModel r100, e r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        return r100.copy(r101);
    }

    public final e component1() {
        return this.data;
    }

    public final AudioRetransmitStrategyModel copy(e r100) {
        return new AudioRetransmitStrategyModel(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioRetransmitStrategyModel) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.data, ((AudioRetransmitStrategyModel) r100).data) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        e r100 = this.data;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "AudioRetransmitStrategyModel(data=" + this.data + ')';
    }

    public final e getData() {
        return this.data;
    }

    public AudioRetransmitStrategyModel(e r100) {
        this.data = r100;
    }

    public /* synthetic */ AudioRetransmitStrategyModel(e r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new e(0);
    L5:
        this(r100);
    }
}
