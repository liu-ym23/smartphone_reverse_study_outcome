package com.ss.android.lark.todo.impl.features.common.helper;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.lark.pb.todo.v1.Commit;
import com.bytedance.lark.pb.todo.v1.TaskMode;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.bytedance.lark.pb.todo.v1.TodoSource;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class MultiCompleteHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f442436a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/common/helper/MultiCompleteHelper$MultiCompleteType;", "", "<init>", "(Ljava/lang/String;I)V", "COMPLETE_USER", "COMPLETE_TODO_WITHOUT_DIALOG", "COMPLETE_TODO_WITH_DIALOG", "NOT_COMPLETE", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MultiCompleteType extends Enum<MultiCompleteType> {
        public static final MultiCompleteType COMPLETE_TODO_WITHOUT_DIALOG = null;
        public static final MultiCompleteType COMPLETE_TODO_WITH_DIALOG = null;
        public static final MultiCompleteType COMPLETE_USER = null;
        public static final MultiCompleteType NOT_COMPLETE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MultiCompleteType[] f442437a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f442438b = null;

        public static EnumEntries<MultiCompleteType> getEntries() {
            return f442438b;
        }

        static {
            MultiCompleteType r100 = new MultiCompleteType("COMPLETE_USER", 0);
            COMPLETE_USER = r100;
            MultiCompleteType r101 = new MultiCompleteType("COMPLETE_TODO_WITHOUT_DIALOG", 1);
            COMPLETE_TODO_WITHOUT_DIALOG = r101;
            MultiCompleteType r102 = new MultiCompleteType("COMPLETE_TODO_WITH_DIALOG", 2);
            COMPLETE_TODO_WITH_DIALOG = r102;
            MultiCompleteType r103 = new MultiCompleteType("NOT_COMPLETE", 3);
            NOT_COMPLETE = r103;
            MultiCompleteType[] r104 = {r100, r101, r102, r103};
            f442437a = r104;
            f442438b = EnumEntriesKt.enumEntries(r104);
        }

        public static MultiCompleteType[] values() {
            return (MultiCompleteType[]) f442437a.clone();
        }

        public static MultiCompleteType valueOf(String r100) {
            return (MultiCompleteType) r27.a.a(MultiCompleteType.class, r100);
        }

        public MultiCompleteType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a();

        void b();
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f442439a;

        public b(a r100) {
            this.f442439a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f442439a.b();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f442440a;

        public c(a r100) {
            this.f442440a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f442440a.a();
        }
    }

    public static final class d implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f442441a;

        public d(a r100) {
            this.f442441a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f442441a.b();
        }
    }

    public static final class e implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f442442a;

        public e(a r100) {
            this.f442442a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f442442a.a();
        }
    }

    static {
    }

    public static long b(Todo r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (d(r100.source, r100.mode) == true) goto L8;
        Long r101 = r100.completed_milli_time;
        Intrinsics.checkNotNull(r101);
        return r101.longValue();
    L8:
        Long r102 = r100.display_completed_milli_time;
        Intrinsics.checkNotNull(r102);
        return r102.longValue();
    }

    public static boolean c(Map r100, Commit.Key r101) {
        Intrinsics.checkNotNullParameter(r100, "editCommitKeys");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100.containsKey(Integer.valueOf(r101.getValue())) == false) goto L7;
        Boolean r102 = (Boolean) r100.get(Integer.valueOf(r101.getValue()));
        if (r102 == null) goto L7;
        return r102.booleanValue();
    L7:
        return false;
    }

    public static boolean d(TodoSource r100, TaskMode r101) {
        if (r100 != TodoSource.DOC) goto L5;
    L7:
        return false;
    L5:
        if (r101 == TaskMode.TASK_COMPLETE) goto L7;
        return true;
    }

    public static boolean e(TodoSource r100, TaskMode r101) {
        if (r100 != TodoSource.DOC) goto L6;
        return false;
    L6:
        if (r101 == TaskMode.TASK_COMPLETE) goto L9;
        return true;
    L9:
        return false;
    }

    public static void f(Context r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listener");
        new UDDialogBuilder(r100).title(R.string.Todo_CollabTask_RestoreTask).titleLineCount(2).message(R.string.Todo_CollabTask_RestoreTaskDesc).addActionButton(R.id.ud_dialog_btn_primary, R.string.Todo_CollabTask_ComfirmRestore, new b(r101)).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Todo_CollabTask_CancelButton, new c(r101)).cancelOnTouchOutside(false).show();
    }

    public static void g(Context r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listener");
        new UDDialogBuilder(r100).title(R.string.Todo_CollabTask_CompletedTask).titleLineCount(2).message(R.string.Todo_CollabTask_NotCompletedDialog).addActionButton(R.id.ud_dialog_btn_primary, R.string.Todo_CollabTask_ConfirmComplete, new d(r101)).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Todo_CollabTask_CancelButton, new e(r101)).cancelOnTouchOutside(false).show();
    }

    public static MultiCompleteType a(TodoSource r100, TaskMode r101, String r102, long r103, List r110, String r111) {
        Intrinsics.checkNotNullParameter(r102, "creatorId");
        Intrinsics.checkNotNullParameter(r111, "operationUserId");
        if (d(r100, r101) == false) goto L5;
        boolean r104 = true;
        String r105 = null;
        if (Intrinsics.areEqual(r102, r111) == false) goto L51;
        List r106 = r110;
        if (r106 != null) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == false) goto L19;
        return MultiCompleteType.COMPLETE_TODO_WITHOUT_DIALOG;
    L19:
        if (r103 > 0) goto L39;
        ArrayList r108 = new ArrayList();
        Iterator r109 = r110.iterator();
    L23:
        if (r109.hasNext() == false) goto L37;
        Object r112 = r109.next();
        TodoAssignee r113 = (TodoAssignee) r112;
        if (r113 == null) goto L34;
        TodoAssignee.User r114 = r113.user;
        if (r114 == null) goto L34;
        Long r115 = r114.completed_milli_time;
        if (r115 == null) goto L34;
        if (r115.longValue() != 0) goto L34;
        boolean r116 = true;
    L35:
        if (r116 == false) goto L23;
        r108.add(r112);
    L34:
        r116 = false;
        goto L35
    L37:
        r110 = r108;
    L39:
        if (r110.size() != 1) goto L47;
        TodoAssignee r117 = (TodoAssignee) ListProtector.get(r110, 0);
        if (r117 == null) goto L44;
        r105 = r117.assignee_id;
    L44:
        if (Intrinsics.areEqual(r105, r111) == false) goto L47;
        return MultiCompleteType.COMPLETE_USER;
    L47:
        if ((!r110.isEmpty()) == false) goto L50;
        return MultiCompleteType.COMPLETE_TODO_WITH_DIALOG;
    L50:
        return MultiCompleteType.COMPLETE_TODO_WITHOUT_DIALOG;
    L11:
        if (r106.isEmpty() == true) goto L14;
        r107 = false;
        goto L15
    L51:
        if (r110 == null) goto L70;
        List r118 = r110;
        if ((r118 instanceof Collection) == true) goto L55;
    L57:
        Iterator r119 = r118.iterator();
    L59:
        if (r119.hasNext() == false) goto L67;
        TodoAssignee r120 = (TodoAssignee) r119.next();
        if (r120 == null) goto L63;
        String r121 = r120.assignee_id;
    L65:
        if (Intrinsics.areEqual(r121, r111) == false) goto L59;
        boolean r122 = true;
    L68:
        if (r122 != true) goto L70;
    L71:
        if (r104 == false) goto L74;
        return MultiCompleteType.COMPLETE_USER;
    L74:
        return MultiCompleteType.NOT_COMPLETE;
    L63:
        r121 = null;
    L67:
        r122 = false;
        goto L68
    L55:
        if (r118.isEmpty() == false) goto L57;
    L70:
        r104 = false;
        goto L71
    L5:
        return MultiCompleteType.COMPLETE_TODO_WITHOUT_DIALOG;
    }
}
