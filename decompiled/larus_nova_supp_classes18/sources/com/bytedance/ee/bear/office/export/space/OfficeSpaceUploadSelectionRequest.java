package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003JK\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001J\t\u0010'\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionRequest;", "Ljava/io/Serializable;", "action", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "target", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget;", "maxSelectCount", "", "requestId", "", "acceptedMimeTypes", "", "supportVideo", "", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget;ILjava/lang/String;Ljava/util/List;Z)V", "getAction", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "getTarget", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget;", "getMaxSelectCount", "()I", "getRequestId", "()Ljava/lang/String;", "getAcceptedMimeTypes", "()Ljava/util/List;", "getSupportVideo", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceUploadSelectionRequest implements Serializable {
    private final List<String> acceptedMimeTypes;
    private final OfficeSpaceHeaderAction action;
    private final int maxSelectCount;
    private final String requestId;
    private final boolean supportVideo;
    private final OfficeSpaceUploadTarget target;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSpaceUploadSelectionRequest copy$default(OfficeSpaceUploadSelectionRequest r4, OfficeSpaceHeaderAction r5, OfficeSpaceUploadTarget r6, int r7, String r8, List r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.action;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.target;
    L8:
        OfficeSpaceUploadTarget r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.maxSelectCount;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.requestId;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.acceptedMimeTypes;
    L17:
        List r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.supportVideo;
    L20:
        OfficeSpaceHeaderAction r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final OfficeSpaceHeaderAction component1() {
        return this.action;
    }

    public final OfficeSpaceUploadTarget component2() {
        return this.target;
    }

    public final int component3() {
        return this.maxSelectCount;
    }

    public final String component4() {
        return this.requestId;
    }

    public final List<String> component5() {
        return this.acceptedMimeTypes;
    }

    public final boolean component6() {
        return this.supportVideo;
    }

    public final OfficeSpaceUploadSelectionRequest copy(OfficeSpaceHeaderAction r9, OfficeSpaceUploadTarget r10, int r11, String r12, List<String> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r9, "action");
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r12, "requestId");
        Intrinsics.checkNotNullParameter(r13, "acceptedMimeTypes");
        return new OfficeSpaceUploadSelectionRequest(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeSpaceUploadSelectionRequest) == true) goto L8;
        return false;
    L8:
        OfficeSpaceUploadSelectionRequest r6 = (OfficeSpaceUploadSelectionRequest) r5;
        if (this.action == r6.action) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L15;
        return false;
    L15:
        if (this.maxSelectCount == r6.maxSelectCount) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.requestId, r6.requestId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.acceptedMimeTypes, r6.acceptedMimeTypes) == true) goto L24;
        return false;
    L24:
        if (this.supportVideo == r6.supportVideo) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.action.hashCode() * 31) + this.target.hashCode()) * 31) + this.maxSelectCount) * 31) + this.requestId.hashCode()) * 31) + this.acceptedMimeTypes.hashCode()) * 31;
        if (this.supportVideo == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "OfficeSpaceUploadSelectionRequest(action=" + this.action + ", target=" + this.target + ", maxSelectCount=" + this.maxSelectCount + ", requestId=" + this.requestId + ", acceptedMimeTypes=" + this.acceptedMimeTypes + ", supportVideo=" + this.supportVideo + ')';
    }

    public final List<String> getAcceptedMimeTypes() {
        return this.acceptedMimeTypes;
    }

    public final OfficeSpaceHeaderAction getAction() {
        return this.action;
    }

    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final boolean getSupportVideo() {
        return this.supportVideo;
    }

    public final OfficeSpaceUploadTarget getTarget() {
        return this.target;
    }

    public OfficeSpaceUploadSelectionRequest(OfficeSpaceHeaderAction r2, OfficeSpaceUploadTarget r3, int r4, String r5, List<String> r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "target");
        Intrinsics.checkNotNullParameter(r5, "requestId");
        Intrinsics.checkNotNullParameter(r6, "acceptedMimeTypes");
        this.action = r2;
        this.target = r3;
        this.maxSelectCount = r4;
        this.requestId = r5;
        this.acceptedMimeTypes = r6;
        this.supportVideo = r7;
    }

    public /* synthetic */ OfficeSpaceUploadSelectionRequest(OfficeSpaceHeaderAction r8, OfficeSpaceUploadTarget r9, int r10, String r11, List r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 16) == 0) goto L5;
        r12 = CollectionsKt.emptyList();
    L5:
        List r5 = r12;
        if ((r14 & 32) == 0) goto L8;
        boolean r6 = false;
    L9:
        this(r8, r9, r10, r11, r5, r6);
        return;
    L8:
        r6 = r13;
        goto L9
    }
}
