package com.suite.lark.platform.component.cta.newstyle.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/entity/CTAParams;", "Ljava/io/Serializable;", "featureKey", "", "scene", "checkpointTenantId", "checkpointUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFeatureKey", "()Ljava/lang/String;", "getScene", "getCheckpointTenantId", "getCheckpointUserId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CTAParams implements Serializable {
    private final String checkpointTenantId;
    private final String checkpointUserId;
    private final String featureKey;
    private final String scene;

    public static /* synthetic */ CTAParams copy$default(CTAParams r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.featureKey;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.scene;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.checkpointTenantId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.checkpointUserId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.featureKey;
    }

    public final String component2() {
        return this.scene;
    }

    public final String component3() {
        return this.checkpointTenantId;
    }

    public final String component4() {
        return this.checkpointUserId;
    }

    public final CTAParams copy(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "featureKey");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "checkpointTenantId");
        Intrinsics.checkNotNullParameter(r103, "checkpointUserId");
        return new CTAParams(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CTAParams) == true) goto L8;
        return false;
    L8:
        CTAParams r101 = (CTAParams) r100;
        if (Intrinsics.areEqual(this.featureKey, r101.featureKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.checkpointTenantId, r101.checkpointTenantId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.checkpointUserId, r101.checkpointUserId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.featureKey.hashCode() * 31) + this.scene.hashCode()) * 31) + this.checkpointTenantId.hashCode()) * 31) + this.checkpointUserId.hashCode();
    }

    public String toString() {
        return "CTAParams(featureKey=" + this.featureKey + ", scene=" + this.scene + ", checkpointTenantId=" + this.checkpointTenantId + ", checkpointUserId=" + this.checkpointUserId + ')';
    }

    public final String getCheckpointTenantId() {
        return this.checkpointTenantId;
    }

    public final String getCheckpointUserId() {
        return this.checkpointUserId;
    }

    public final String getFeatureKey() {
        return this.featureKey;
    }

    public final String getScene() {
        return this.scene;
    }

    public CTAParams(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "featureKey");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "checkpointTenantId");
        Intrinsics.checkNotNullParameter(r103, "checkpointUserId");
        this.featureKey = r100;
        this.scene = r101;
        this.checkpointTenantId = r102;
        this.checkpointUserId = r103;
    }

    public /* synthetic */ CTAParams(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = "0";
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = "0";
    L8:
        this(r100, r101, r102, r103);
    }
}
