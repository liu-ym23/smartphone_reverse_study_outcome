package com.ss.android.lark.todo.impl.features.center.v3;

import android.text.TextUtils;
import com.bytedance.lark.pb.todo.v1.FieldFilterValue;
import com.bytedance.lark.pb.todo.v1.FilterCondition;
import com.bytedance.lark.pb.todo.v1.FilterPredicate;
import com.bytedance.lark.pb.todo.v1.MemberFieldFilterValue;
import com.bytedance.lark.pb.todo.v1.TaskCompleteStatusFieldFilterValue;
import com.bytedance.lark.pb.todo.v1.TaskViewFilters;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class FilterUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f441373a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441374a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f441375b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f441376c = null;

        static {
            int[] r100 = new int[TaskFieldType.values().length];
            r100[TaskFieldType.TASK_NO_SECTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L72:
            r100[TaskFieldType.TASK_DEFAULT_SECTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L86:
            r100[TaskFieldType.TASK_DEFAULT_SORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L54:
            r100[TaskFieldType.ASSIGNEE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
        L56:
            r100[TaskFieldType.CREATOR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
        L64:
            r100[TaskFieldType.DUE_TIME.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
        L78:
            r100[TaskFieldType.START_TIME.ordinal()] = 7;     // Catch: NoSuchFieldError -> L37
        L60:
            r100[TaskFieldType.SOURCE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L38
        L74:
            r100[TaskFieldType.CREATE_TIME.ordinal()] = 9;     // Catch: NoSuchFieldError -> L39
        L76:
            r100[TaskFieldType.COMPLETE_TIME.ordinal()] = 10;     // Catch: NoSuchFieldError -> L40
        L50:
            r100[TaskFieldType.UPDATE_TIME.ordinal()] = 11;     // Catch: NoSuchFieldError -> L41
        L19:
            f441374a = r100;
            int[] r101 = new int[TaskCompleteStatusFieldFilterValue.TaskCompleteStatus.values().length];
            r101[TaskCompleteStatusFieldFilterValue.TaskCompleteStatus.UNCOMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L42
        L80:
            r101[TaskCompleteStatusFieldFilterValue.TaskCompleteStatus.COMPLETED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L43
        L22:
            f441375b = r101;
            int[] r102 = new int[FilterPredicate.values().length];
            r102[FilterPredicate.EQUAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L44
        L84:
            r102[FilterPredicate.NOT_EQUAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L45
        L52:
            r102[FilterPredicate.INCLUDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L46
        L58:
            r102[FilterPredicate.EXCLUDE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L47
        L68:
            r102[FilterPredicate.EMPTY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L48
        L82:
            r102[FilterPredicate.NOT_EMPTY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L49
        L29:
            f441376c = r102;
        }
    }

    static {
    }

    public static String a(TaskCompleteStatusFieldFilterValue.TaskCompleteStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "completeStatus");
        int r101 = a.f441375b[r100.ordinal()];
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L11;
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_AllTasks_FilterOption);
    L11:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_Completed_FilterOption);
    L9:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_Ongoing_FilterOption);
    }

    public static String b(TaskFieldType r100) {
        Intrinsics.checkNotNullParameter(r100, "fieldType");
        switch(a.f441374a[r100.ordinal()]) {
            case 1: goto L16;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            default: goto L4;
        };
    L4:
        return "";
    L18:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_UpdatedAtTime_Text);
    L19:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_CompletedAtTime_Text);
    L20:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_CreatedAtTime_Text);
    L21:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_SourceInDetail_Text);
    L22:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_StartTime_Text);
    L23:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_DueTime_Text);
    L24:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_Creator_Text);
    L25:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_Owner_Text);
    L26:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_Sort_CustomSort_Button);
    L27:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_Section_GroupBy_Section_Button);
    L16:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_NoSelectedSection_Option);
    }

    public static Function1 c(final TaskCompleteStatusFieldFilterValue.TaskCompleteStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "completeStatus");
        return new FilterUtil$getTaskCompleteStatusFilter$1(r100);
    }

    public static TaskCompleteStatusFieldFilterValue.TaskCompleteStatus d(TaskViewFilters r100) {
        Intrinsics.checkNotNullParameter(r100, "viewFilters");
        Iterator<FilterCondition> r101 = r100.conditions.iterator();
    L4:
        if (r101.hasNext() == false) goto L24;
        FilterCondition r102 = r101.next();
        TaskFieldType.a r103 = TaskFieldType.Companion;
        String r104 = r102.field_key;
        r103.getClass();
        if (TaskFieldType.a.a(r104) != TaskFieldType.COMPLETE_STATUS) goto L4;
        List<FieldFilterValue> r105 = r102.field_filter_value;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L10:
        if (r107.hasNext() == false) goto L14;
        TaskCompleteStatusFieldFilterValue r108 = ((FieldFilterValue) r107.next()).task_complete_status_value;
        if (r108 == null) goto L10;
        r106.add(r108);
        goto L10
    L14:
        TaskCompleteStatusFieldFilterValue r109 = (TaskCompleteStatusFieldFilterValue) CollectionsKt.firstOrNull(r106);
        if (r109 == null) goto L17;
        TaskCompleteStatusFieldFilterValue.TaskCompleteStatus r110 = r109.task_complete_status;
    L19:
        if (r102.predicate != FilterPredicate.EQUAL) goto L4;
        if (r110 == null) goto L22;
        return r110;
    L22:
        return TaskCompleteStatusFieldFilterValue.TaskCompleteStatus.UNCOMPLETED;
    L17:
        r110 = null;
        goto L19
    L24:
        return TaskCompleteStatusFieldFilterValue.TaskCompleteStatus.UNCOMPLETED;
    }

    public static Function1 e(final TaskViewFilters r100) {
        if (r100 != null) goto L6;
        return FilterUtil$getTodoFilter$1.INSTANCE;
    L6:
        return new FilterUtil$getTodoFilter$2(r100);
    }

    public static boolean f(FilterPredicate r100, List r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Intrinsics.checkNotNullParameter(r101, "memberFilters");
        Intrinsics.checkNotNullParameter(r102, "oldUserIds");
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        Iterator r105 = r101.iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        String r106 = ((MemberFieldFilterValue) r105.next()).member_id.toString();
        if (r106 == null) goto L4;
        r104.add(r106);
        goto L4
    L8:
        r103.addAll(r104);
        ArrayList r107 = new ArrayList();
        r107.addAll(r102);
        CollectionsKt.sort(r103);
        CollectionsKt.sort(r107);
        boolean r108 = false;
        switch(a.f441376c[r100.ordinal()]) {
            case 1: goto L58;
            case 2: goto L47;
            case 3: goto L29;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L67;
        };
    L11:
        r107.isEmpty();
        goto L67
    L12:
        r107.isEmpty();
        goto L67
    L13:
        Iterator r109 = r103.iterator();
    L15:
        if (r109.hasNext() == false) goto L67;
        String r110 = (String) r109.next();
        if (r107.isEmpty() == true) goto L25;
        Iterator r111 = r107.iterator();
    L21:
        if (r111.hasNext() == false) goto L25;
        if (TextUtils.equals((String) r111.next(), r110) == false) goto L21;
        boolean r112 = true;
    L26:
        if (r112 == false) goto L15;
        return false;
    L25:
        r112 = false;
    L67:
        return true;
    L29:
        if (r103.size() > r107.size()) goto L95;
        Iterator r113 = r103.iterator();
    L33:
        if (r113.hasNext() == false) goto L67;
        String r114 = (String) r113.next();
        if (r107.isEmpty() == true) goto L43;
        Iterator r115 = r107.iterator();
    L39:
        if (r115.hasNext() == false) goto L43;
        if (TextUtils.equals((String) r115.next(), r114) == false) goto L39;
        boolean r116 = true;
    L44:
        if (r116 == true) goto L33;
        return false;
    L43:
        r116 = false;
        goto L44
    L95:
        return false;
    L47:
        if (r103.size() != r107.size()) goto L67;
        Iterator r117 = r103.iterator();
        int r118 = 0;
    L50:
        if (r117.hasNext() == false) goto L55;
        int r119 = r118 + 1;
        if (TextUtils.equals((String) r117.next(), (CharSequence) CollectionsKt.getOrNull(r107, r118)) == false) goto L94;
        r118 = r119;
    L94:
        return !r108;
    L55:
        r108 = true;
        goto L94
    L58:
        if (r103.size() != r107.size()) goto L96;
        Iterator r120 = r103.iterator();
        int r121 = 0;
    L62:
        if (r120.hasNext() == false) goto L67;
        int r122 = r121 + 1;
        if (TextUtils.equals((String) r120.next(), (CharSequence) CollectionsKt.getOrNull(r107, r121)) == false) goto L99;
        r121 = r122;
        goto L62
    L99:
        return false;
    L96:
        return false;
    }
}
