package com.bytedance.ee.bear.office.export.space;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003JK\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001J\t\u0010'\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionRequest;", "Ljava/io/Serializable;", "action", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", PickerReporterConstants.KEY.TARGET, "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget;", "maxSelectCount", "", "requestId", "", "acceptedMimeTypes", "", "supportVideo", "", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget;ILjava/lang/String;Ljava/util/List;Z)V", "getAction", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "getTarget", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget;", "getMaxSelectCount", "()I", "getRequestId", "()Ljava/lang/String;", "getAcceptedMimeTypes", "()Ljava/util/List;", "getSupportVideo", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceUploadSelectionRequest implements Serializable {
    private final List<String> acceptedMimeTypes;
    private final OfficeSpaceHeaderAction action;
    private final int maxSelectCount;
    private final String requestId;
    private final boolean supportVideo;
    private final OfficeSpaceUploadTarget target;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSpaceUploadSelectionRequest copy$default(OfficeSpaceUploadSelectionRequest r100, OfficeSpaceHeaderAction r101, OfficeSpaceUploadTarget r102, int r103, String r104, List r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.action;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.target;
    L8:
        OfficeSpaceUploadTarget r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.maxSelectCount;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.requestId;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.acceptedMimeTypes;
    L17:
        List r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.supportVideo;
    L20:
        OfficeSpaceHeaderAction r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
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

    public final OfficeSpaceUploadSelectionRequest copy(OfficeSpaceHeaderAction r100, OfficeSpaceUploadTarget r110, int r111, String r112, List<String> r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r112, "requestId");
        Intrinsics.checkNotNullParameter(r113, "acceptedMimeTypes");
        return new OfficeSpaceUploadSelectionRequest(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSpaceUploadSelectionRequest) == true) goto L8;
        return false;
    L8:
        OfficeSpaceUploadSelectionRequest r101 = (OfficeSpaceUploadSelectionRequest) r100;
        if (this.action == r101.action) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L15;
        return false;
    L15:
        if (this.maxSelectCount == r101.maxSelectCount) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.acceptedMimeTypes, r101.acceptedMimeTypes) == true) goto L24;
        return false;
    L24:
        if (this.supportVideo == r101.supportVideo) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.action.hashCode() * 31) + this.target.hashCode()) * 31) + this.maxSelectCount) * 31) + this.requestId.hashCode()) * 31) + this.acceptedMimeTypes.hashCode()) * 31;
        if (this.supportVideo == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
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

    public OfficeSpaceUploadSelectionRequest(OfficeSpaceHeaderAction r100, OfficeSpaceUploadTarget r101, int r102, String r103, List<String> r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "requestId");
        Intrinsics.checkNotNullParameter(r104, "acceptedMimeTypes");
        this.action = r100;
        this.target = r101;
        this.maxSelectCount = r102;
        this.requestId = r103;
        this.acceptedMimeTypes = r104;
        this.supportVideo = r105;
    }

    public /* synthetic */ OfficeSpaceUploadSelectionRequest(OfficeSpaceHeaderAction r100, OfficeSpaceUploadTarget r101, int r110, String r111, List r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 16) == 0) goto L5;
        r112 = CollectionsKt.emptyList();
    L5:
        List r102 = r112;
        if ((r114 & 32) == 0) goto L8;
        boolean r103 = false;
    L9:
        this(r100, r101, r110, r111, r102, r103);
        return;
    L8:
        r103 = r113;
        goto L9
    }
}
