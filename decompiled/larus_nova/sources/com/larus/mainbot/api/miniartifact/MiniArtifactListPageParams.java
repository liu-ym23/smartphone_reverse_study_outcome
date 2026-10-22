package com.larus.mainbot.api.miniartifact;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t1a.c;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\fJ\u001b\u0010\u0011\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0006HÆ\u0003J6\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR(\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/mainbot/api/miniartifact/MiniArtifactListPageParams;", "Ljava/io/Serializable;", "Lcom/larus/ui/arch/context/external/VData;", "pushFromBottom", "", "trackParams", "", "", "", "<init>", "(Ljava/lang/Boolean;Ljava/util/Map;)V", "getPushFromBottom", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTrackParams", "()Ljava/util/Map;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/Map;)Lcom/larus/mainbot/api/miniartifact/MiniArtifactListPageParams;", "equals", "other", "hashCode", "", "toString", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactListPageParams implements Serializable, c {

    @SerializedName("push_from_bottom")
    private final Boolean pushFromBottom;

    @SerializedName("track_params")
    private final Map<String, Object> trackParams;

    /* JADX WARN: Multi-variable type inference failed */
    public MiniArtifactListPageParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MiniArtifactListPageParams copy$default(MiniArtifactListPageParams r100, Boolean r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.pushFromBottom;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.trackParams;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.pushFromBottom;
    }

    public final Map<String, Object> component2() {
        return this.trackParams;
    }

    public final MiniArtifactListPageParams copy(Boolean r100, Map<String, ? extends Object> r101) {
        return new MiniArtifactListPageParams(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MiniArtifactListPageParams) == true) goto L8;
        return false;
    L8:
        MiniArtifactListPageParams r101 = (MiniArtifactListPageParams) r100;
        if (Intrinsics.areEqual(this.pushFromBottom, r101.pushFromBottom) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.pushFromBottom;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.trackParams;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MiniArtifactListPageParams(pushFromBottom=" + this.pushFromBottom + ", trackParams=" + this.trackParams + ')';
    }

    public final Boolean getPushFromBottom() {
        return this.pushFromBottom;
    }

    public final Map<String, Object> getTrackParams() {
        return this.trackParams;
    }

    public MiniArtifactListPageParams(Boolean r100, Map<String, ? extends Object> r101) {
        this.pushFromBottom = r100;
        this.trackParams = r101;
    }

    public /* synthetic */ MiniArtifactListPageParams(Boolean r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
