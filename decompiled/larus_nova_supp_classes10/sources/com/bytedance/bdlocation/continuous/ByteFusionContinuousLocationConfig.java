package com.bytedance.bdlocation.continuous;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationConfig;", "", "platformContext", "Landroid/content/Context;", "navInstanceId", "", "bpeaCert", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)V", "getBpeaCert", "()Ljava/lang/Object;", "getNavInstanceId", "()Ljava/lang/String;", "getPlatformContext", "()Landroid/content/Context;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class ByteFusionContinuousLocationConfig {
    public static final Companion Companion = null;
    public static final String DEFAULT_NAV_INSTANCE_ID = "byte_fusion_continuous_location";
    private final Object bpeaCert;
    private final String navInstanceId;
    private final Context platformContext;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationConfig$Companion;", "", "()V", "DEFAULT_NAV_INSTANCE_ID", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ByteFusionContinuousLocationConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ByteFusionContinuousLocationConfig copy$default(ByteFusionContinuousLocationConfig r0, Context r1, String r2, Object r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.platformContext;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.navInstanceId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.bpeaCert;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Context component1() {
        return this.platformContext;
    }

    public final String component2() {
        return this.navInstanceId;
    }

    public final Object component3() {
        return this.bpeaCert;
    }

    public final ByteFusionContinuousLocationConfig copy(Context r2, String r3, Object r4) {
        return new ByteFusionContinuousLocationConfig(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ByteFusionContinuousLocationConfig) == false) goto L12;
        ByteFusionContinuousLocationConfig r4 = (ByteFusionContinuousLocationConfig) r3;
        if (Intrinsics.areEqual(this.platformContext, r4.platformContext) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.navInstanceId, r4.navInstanceId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bpeaCert, r4.bpeaCert) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Context r0 = this.platformContext;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.navInstanceId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Object r7 = this.bpeaCert;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ByteFusionContinuousLocationConfig(platformContext=" + this.platformContext + ", navInstanceId=" + this.navInstanceId + ", bpeaCert=" + this.bpeaCert + ")";
    }

    public final Object getBpeaCert() {
        return this.bpeaCert;
    }

    public final String getNavInstanceId() {
        return this.navInstanceId;
    }

    public final Context getPlatformContext() {
        return this.platformContext;
    }

    public ByteFusionContinuousLocationConfig(Context r1, String r2, Object r3) {
        this.platformContext = r1;
        this.navInstanceId = r2;
        this.bpeaCert = r3;
    }

    public /* synthetic */ ByteFusionContinuousLocationConfig(Context r2, String r3, Object r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = DEFAULT_NAV_INSTANCE_ID;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
