package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\bJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0000J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0013\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u001eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "groupPath", "", "offset", "", "([II)V", "getGroupPath", "()[I", "setGroupPath", "([I)V", "getOffset", "()I", "setOffset", "(I)V", "outOfBoundIndex", "getOutOfBoundIndex", "setOutOfBoundIndex", "isGroupHeader", "", "isRecord", "isError", "isValid", "copy", "toPullAction", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/PullDataAction;", "pageSize", "toStringGroupPath", "", "equals", "other", "", "hashCode", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class GroupPosition implements NonProguard {
    private int[] groupPath;
    private int offset;
    private int outOfBoundIndex;

    public boolean isError() {
        return false;
    }

    public final GroupPosition copy() {
        return new GroupPosition(this.groupPath, this.offset);
    }

    public int hashCode() {
        int[] r100 = this.groupPath;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.length;
        int r102 = 1;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L6;
        int r104 = r102 * 31;
        r102 = r104 + r100[r103];
        r103 = r103 + 1;
        goto L3
    L6:
        return (r102 * 31) + this.offset;
    }

    public final boolean isGroupHeader() {
        if (this.offset != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRecord() {
        if (this.offset < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "GP(groupPath=" + Arrays.toString(this.groupPath) + ", offset=" + this.offset + ", oot=" + this.outOfBoundIndex + ')';
    }

    public final String toStringGroupPath() {
        return ArraysKt.joinToString$default(this.groupPath, "_", null, null, 0, null, null, 62, null) + '_' + this.offset;
    }

    public GroupPosition() {
        this.groupPath = new int[0];
    }

    public final boolean isValid() {
        if (isError() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.outOfBoundIndex != 0) goto L7;
        return true;
    }

    public final int[] getGroupPath() {
        return this.groupPath;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getOutOfBoundIndex() {
        return this.outOfBoundIndex;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GroupPosition) == false) goto L8;
        GroupPosition r101 = (GroupPosition) r100;
    L10:
        if (r101 != null) goto L12;
        return false;
    L12:
        if (r101.offset == this.offset) goto L14;
    L16:
        return false;
    L14:
        if (Arrays.equals(this.groupPath, r101.groupPath) == false) goto L16;
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setGroupPath(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupPath = r100;
    }

    public final void setOffset(int r100) {
        this.offset = r100;
    }

    public final void setOutOfBoundIndex(int r100) {
        this.outOfBoundIndex = r100;
    }

    public final PullDataAction toPullAction(int r100) {
        int[] r101 = this.groupPath;
        int r102 = this.offset;
        if (r102 != (-1)) goto L5;
        Integer r103 = null;
    L7:
        return new PullDataAction(r101, r103, 0, 4, null);
    L5:
        r103 = Integer.valueOf(r102 / r100);
        goto L7
    }

    public GroupPosition(int[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "groupPath");
        this.groupPath = r100;
        this.offset = r101;
    }
}
