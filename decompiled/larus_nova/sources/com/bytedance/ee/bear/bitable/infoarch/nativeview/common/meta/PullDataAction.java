package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00000!R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/PullDataAction;", "Lcom/bytedance/ee/util/io/NonProguard;", "groupPath", "", "pageIndex", "", "direction", "<init>", "([ILjava/lang/Integer;I)V", "getGroupPath", "()[I", "setGroupPath", "([I)V", "getPageIndex", "()Ljava/lang/Integer;", "setPageIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDirection", "()I", "setDirection", "(I)V", "equals", "", "other", "", "hashCode", "toString", "", "toFirstItemGroupPosition", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "pageSize", "toParentsRequest", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PullDataAction implements NonProguard {
    public static final a Companion = null;
    public static final int DIRECTION_BOTTOM = -1;
    public static final int DIRECTION_TOP = 1;
    private int direction;
    private int[] groupPath;
    private Integer pageIndex;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public int hashCode() {
        int[] r100 = this.groupPath;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.length;
        int r102 = 1;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        int r104 = r102 * 31;
        r102 = r104 + r100[r103];
        r103 = r103 + 1;
        goto L3
    L5:
        int r105 = r102 * 31;
        Integer r106 = this.pageIndex;
        if (r106 == null) goto L8;
        int r107 = r106.intValue();
    L10:
        return r105 + r107;
    L8:
        r107 = -1;
        goto L10
    }

    public final List<PullDataAction> toParentsRequest() {
        if (this.pageIndex == null) goto L5;
        int[] r100 = this.groupPath;
    L6:
        ArrayList r101 = new ArrayList();
    L8:
        if (r100.length <= 0) goto L10;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int[] r102 = r100;
        r101.add(new PullDataAction(r102, null, 0, 4, null));
        r100 = et4.a.c(r100);
        goto L8
    L10:
        return r101;
    L5:
        r100 = et4.a.c(this.groupPath);
        goto L6
    }

    public String toString() {
        return "Action(GP=" + Arrays.toString(this.groupPath) + ", pageIndex=" + this.pageIndex + ", direction=" + this.direction + ')';
    }

    public final int getDirection() {
        return this.direction;
    }

    public final int[] getGroupPath() {
        return this.groupPath;
    }

    public final Integer getPageIndex() {
        return this.pageIndex;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PullDataAction) == false) goto L8;
        PullDataAction r101 = (PullDataAction) r100;
    L10:
        if (r101 != null) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(r101.pageIndex, this.pageIndex) == true) goto L14;
    L16:
        return false;
    L14:
        if (Arrays.equals(this.groupPath, r101.groupPath) == false) goto L16;
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setDirection(int r100) {
        this.direction = r100;
    }

    public final void setGroupPath(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupPath = r100;
    }

    public final void setPageIndex(Integer r100) {
        this.pageIndex = r100;
    }

    public final GroupPosition toFirstItemGroupPosition(int r100) {
        int[] r101 = this.groupPath;
        Integer r102 = this.pageIndex;
        if (r102 == null) goto L5;
        int r103 = r102.intValue() * r100;
    L7:
        return new GroupPosition(r101, r103);
    L5:
        r103 = -1;
        goto L7
    }

    public PullDataAction(int[] r100, Integer r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "groupPath");
        this.groupPath = r100;
        this.pageIndex = r101;
        this.direction = r102;
    }

    public /* synthetic */ PullDataAction(int[] r100, Integer r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = 1;
    L5:
        this(r100, r101, r102);
    }
}
