package t7c;

import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.bytedance.lark.pb.todo.v1.TaskContainerSection;
import com.bytedance.lark.pb.todo.v1.TaskContainerSectionItem;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberRole;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.larksuite.arch.jack.j;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.ss.android.lark.todo.impl.features.center.v3.tablayout.b> f544982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<TaskContainerSection> f544983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<TaskContainerSectionItem> f544984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ContainerType f544985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f544986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f544987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f544988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f544989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TaskContainer.Category f544990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<com.ss.android.lark.todo.impl.features.detail.sections.c> f544991j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f544992k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TodoItemMemberRole f544993l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TodoUser f544994m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f544995n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f544996o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f544997p;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f544982a, r101.f544982a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544983b, r101.f544983b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f544984c, r101.f544984c) == true) goto L18;
        return false;
    L18:
        if (this.f544985d == r101.f544985d) goto L21;
        return false;
    L21:
        if (this.f544986e == r101.f544986e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f544987f, r101.f544987f) == true) goto L27;
        return false;
    L27:
        if (this.f544988g == r101.f544988g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f544989h, r101.f544989h) == true) goto L33;
        return false;
    L33:
        if (this.f544990i == r101.f544990i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f544991j, r101.f544991j) == true) goto L39;
        return false;
    L39:
        if (this.f544992k == r101.f544992k) goto L42;
        return false;
    L42:
        if (this.f544993l == r101.f544993l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f544994m, r101.f544994m) == true) goto L48;
        return false;
    L48:
        if (this.f544995n == r101.f544995n) goto L51;
        return false;
    L51:
        if (this.f544996o == r101.f544996o) goto L54;
        return false;
    L54:
        if (this.f544997p == r101.f544997p) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f544982a.hashCode() * 31) + this.f544983b.hashCode()) * 31) + this.f544984c.hashCode()) * 31) + this.f544985d.hashCode()) * 31;
        int r101 = 1231;
        if (this.f544986e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f544987f.hashCode()) * 31;
        if (this.f544988g == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((((((((((r103 + r104) * 31) + this.f544989h.hashCode()) * 31) + this.f544990i.hashCode()) * 31) + this.f544991j.hashCode()) * 31) + this.f544992k) * 31) + this.f544993l.hashCode()) * 31;
        TodoUser r106 = this.f544994m;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.f544995n == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f544996o == false) goto L21;
        int r111 = 1231;
    L22:
        int r112 = (r110 + r111) * 31;
        if (this.f544997p == true) goto L27;
        r101 = 1237;
    L27:
        return r112 + r101;
    L21:
        r111 = 1237;
        goto L22
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ContainerTabViewState(containerList=" + this.f544982a + ", containerSectionList=" + this.f544983b + ", containerSectionItems=" + this.f544984c + ", currentContainer=" + this.f544985d + ", isSectionShow=" + this.f544986e + ", containerName=" + this.f544987f + ", isMoreIconShow=" + this.f544988g + ", containerId=" + this.f544989h + ", containerCategory=" + this.f544990i + ", collaborators=" + this.f544991j + ", collaboratorsTotal=" + this.f544992k + ", operatorRole=" + this.f544993l + ", owner=" + this.f544994m + ", isSelectAllTaskEvents=" + this.f544995n + ", isSelectTaskListMange=" + this.f544996o + ", isSelectTaskListArchiveView=" + this.f544997p + ')';
    }

    public a(List<com.ss.android.lark.todo.impl.features.center.v3.tablayout.b> r110, ArrayList<TaskContainerSection> r111, ArrayList<TaskContainerSectionItem> r112, ContainerType r113, boolean r114, String r115, boolean r116, String r117, TaskContainer.Category r210, List<com.ss.android.lark.todo.impl.features.detail.sections.c> r211, int r212, TodoItemMemberRole r213, TodoUser r214, boolean r215, boolean r216, boolean r217) {
        Intrinsics.checkNotNullParameter(r110, "containerList");
        Intrinsics.checkNotNullParameter(r111, "containerSectionList");
        Intrinsics.checkNotNullParameter(r112, "containerSectionItems");
        Intrinsics.checkNotNullParameter(r113, "currentContainer");
        Intrinsics.checkNotNullParameter(r115, "containerName");
        Intrinsics.checkNotNullParameter(r117, "containerId");
        Intrinsics.checkNotNullParameter(r210, "containerCategory");
        Intrinsics.checkNotNullParameter(r211, "collaborators");
        Intrinsics.checkNotNullParameter(r213, "operatorRole");
        this.f544982a = r110;
        this.f544983b = r111;
        this.f544984c = r112;
        this.f544985d = r113;
        this.f544986e = r114;
        this.f544987f = r115;
        this.f544988g = r116;
        this.f544989h = r117;
        this.f544990i = r210;
        this.f544991j = r211;
        this.f544992k = r212;
        this.f544993l = r213;
        this.f544994m = r214;
        this.f544995n = r215;
        this.f544996o = r216;
        this.f544997p = r217;
    }
}
