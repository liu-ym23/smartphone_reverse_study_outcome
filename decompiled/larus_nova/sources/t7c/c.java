package t7c;

import com.bytedance.lark.pb.todo.v1.TaskCompleteStatusFieldFilterValue;
import com.bytedance.lark.pb.todo.v1.TaskContainerFilter;
import com.larksuite.arch.jack.j;
import com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<TaskFieldType> f544999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<TaskFieldType, Boolean> f545000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TaskCompleteStatusFieldFilterValue.TaskCompleteStatus f545001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TaskFieldType f545002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TaskFieldType f545003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f545004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f545005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f545006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TaskContainerFilter.TabFilter.TaskContainerTabCategory f545007i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f544999a, r101.f544999a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f545000b, r101.f545000b) == true) goto L15;
        return false;
    L15:
        if (this.f545001c == r101.f545001c) goto L18;
        return false;
    L18:
        if (this.f545002d == r101.f545002d) goto L21;
        return false;
    L21:
        if (this.f545003e == r101.f545003e) goto L24;
        return false;
    L24:
        if (this.f545004f == r101.f545004f) goto L27;
        return false;
    L27:
        if (this.f545005g == r101.f545005g) goto L30;
        return false;
    L30:
        if (this.f545006h == r101.f545006h) goto L33;
        return false;
    L33:
        if (this.f545007i == r101.f545007i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f544999a.hashCode() * 31) + this.f545000b.hashCode()) * 31) + this.f545001c.hashCode()) * 31) + this.f545002d.hashCode()) * 31) + this.f545003e.hashCode()) * 31;
        int r101 = 1231;
        if (this.f545004f == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f545005g == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f545006h == true) goto L15;
        r101 = 1237;
    L15:
        return ((r105 + r101) * 31) + this.f545007i.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "FilterSectionViewState(groupFieldTypes=" + this.f544999a + ", sortFieldMap=" + this.f545000b + ", selectedStatus=" + this.f545001c + ", selectedGroup=" + this.f545002d + ", selectedSort=" + this.f545003e + ", isSelectAsc=" + this.f545004f + ", isSectionShow=" + this.f545005g + ", isTaskListFilterShow=" + this.f545006h + ", curSelectTabCategory=" + this.f545007i + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends TaskFieldType> r100, LinkedHashMap<TaskFieldType, Boolean> r101, TaskCompleteStatusFieldFilterValue.TaskCompleteStatus r102, TaskFieldType r103, TaskFieldType r104, boolean r105, boolean r106, boolean r107, TaskContainerFilter.TabFilter.TaskContainerTabCategory r110) {
        Intrinsics.checkNotNullParameter(r100, "groupFieldTypes");
        Intrinsics.checkNotNullParameter(r101, "sortFieldMap");
        Intrinsics.checkNotNullParameter(r102, "selectedStatus");
        Intrinsics.checkNotNullParameter(r103, "selectedGroup");
        Intrinsics.checkNotNullParameter(r104, "selectedSort");
        Intrinsics.checkNotNullParameter(r110, "curSelectTabCategory");
        this.f544999a = r100;
        this.f545000b = r101;
        this.f545001c = r102;
        this.f545002d = r103;
        this.f545003e = r104;
        this.f545004f = r105;
        this.f545005g = r106;
        this.f545006h = r107;
        this.f545007i = r110;
    }
}
