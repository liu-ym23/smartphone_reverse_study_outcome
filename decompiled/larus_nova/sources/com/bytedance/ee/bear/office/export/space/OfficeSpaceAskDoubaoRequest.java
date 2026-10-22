package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceAskDoubaoRequest;", "Ljava/io/Serializable;", "current", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceAskDoubaoItem;", "source", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventSource;", "fileList", "Ljava/util/ArrayList;", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceAskDoubaoItem;Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventSource;Ljava/util/ArrayList;)V", "getCurrent", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceAskDoubaoItem;", "getSource", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventSource;", "getFileList", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceAskDoubaoRequest implements Serializable {
    private final OfficeSpaceAskDoubaoItem current;
    private final ArrayList<OfficeSpaceAskDoubaoItem> fileList;
    private final OfficeSpaceEventSource source;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSpaceAskDoubaoRequest copy$default(OfficeSpaceAskDoubaoRequest r100, OfficeSpaceAskDoubaoItem r101, OfficeSpaceEventSource r102, ArrayList r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.current;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.source;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.fileList;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final OfficeSpaceAskDoubaoItem component1() {
        return this.current;
    }

    public final OfficeSpaceEventSource component2() {
        return this.source;
    }

    public final ArrayList<OfficeSpaceAskDoubaoItem> component3() {
        return this.fileList;
    }

    public final OfficeSpaceAskDoubaoRequest copy(OfficeSpaceAskDoubaoItem r100, OfficeSpaceEventSource r101, ArrayList<OfficeSpaceAskDoubaoItem> r102) {
        Intrinsics.checkNotNullParameter(r100, "current");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "fileList");
        return new OfficeSpaceAskDoubaoRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSpaceAskDoubaoRequest) == true) goto L8;
        return false;
    L8:
        OfficeSpaceAskDoubaoRequest r101 = (OfficeSpaceAskDoubaoRequest) r100;
        if (Intrinsics.areEqual(this.current, r101.current) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fileList, r101.fileList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.current.hashCode() * 31) + this.source.hashCode()) * 31) + this.fileList.hashCode();
    }

    public String toString() {
        return "OfficeSpaceAskDoubaoRequest(current=" + this.current + ", source=" + this.source + ", fileList=" + this.fileList + ')';
    }

    public final OfficeSpaceAskDoubaoItem getCurrent() {
        return this.current;
    }

    public final ArrayList<OfficeSpaceAskDoubaoItem> getFileList() {
        return this.fileList;
    }

    public final OfficeSpaceEventSource getSource() {
        return this.source;
    }

    public OfficeSpaceAskDoubaoRequest(OfficeSpaceAskDoubaoItem r100, OfficeSpaceEventSource r101, ArrayList<OfficeSpaceAskDoubaoItem> r102) {
        Intrinsics.checkNotNullParameter(r100, "current");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "fileList");
        this.current = r100;
        this.source = r101;
        this.fileList = r102;
    }

    public /* synthetic */ OfficeSpaceAskDoubaoRequest(OfficeSpaceAskDoubaoItem r100, OfficeSpaceEventSource r101, ArrayList r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = new ArrayList();
    L5:
        this(r100, r101, r102);
    }
}
