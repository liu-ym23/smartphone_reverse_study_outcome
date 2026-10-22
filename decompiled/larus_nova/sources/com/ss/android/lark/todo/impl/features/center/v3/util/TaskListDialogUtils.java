package com.ss.android.lark.todo.impl.features.center.v3.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.bytedance.lark.pb.todo.v1.TaskContainerPermission;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import z5c.c2;
import z5c.e4;
import z5c.p3;
import z5c.r;
import z5c.v;
import z5c.w;
import z5c.x;
import z5c.y3;
import z5c.z1;

/* JADX INFO: loaded from: classes38.dex */
public final class TaskListDialogUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f441775a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/util/TaskListDialogUtils$Icon;", "", "<init>", "(Ljava/lang/String;I)V", "ShareIcon", "ActivityIcon", "RenameIcon", "ArchiveIcon", "DeleteIcon", "RemoveIcon", "CreateIcon", "CreateSectionIcon", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Icon extends Enum<Icon> {
        public static final Icon ActivityIcon = null;
        public static final Icon ArchiveIcon = null;
        public static final Icon CreateIcon = null;
        public static final Icon CreateSectionIcon = null;
        public static final Icon DeleteIcon = null;
        public static final Icon RemoveIcon = null;
        public static final Icon RenameIcon = null;
        public static final Icon ShareIcon = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Icon[] f441776a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f441777b = null;

        public static EnumEntries<Icon> getEntries() {
            return f441777b;
        }

        static {
            Icon r100 = new Icon("ShareIcon", 0);
            ShareIcon = r100;
            Icon r101 = new Icon("ActivityIcon", 1);
            ActivityIcon = r101;
            Icon r102 = new Icon("RenameIcon", 2);
            RenameIcon = r102;
            Icon r103 = new Icon("ArchiveIcon", 3);
            ArchiveIcon = r103;
            Icon r104 = new Icon("DeleteIcon", 4);
            DeleteIcon = r104;
            Icon r105 = new Icon("RemoveIcon", 5);
            RemoveIcon = r105;
            Icon r110 = new Icon("CreateIcon", 6);
            CreateIcon = r110;
            Icon r111 = new Icon("CreateSectionIcon", 7);
            CreateSectionIcon = r111;
            Icon[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
            f441776a = r112;
            f441777b = EnumEntriesKt.enumEntries(r112);
        }

        public static Icon[] values() {
            return (Icon[]) f441776a.clone();
        }

        public static Icon valueOf(String r100) {
            return (Icon) r27.a.a(Icon.class, r100);
        }

        public Icon(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a();

        void b();
    }

    public interface b {
        void a();

        void b(boolean r100);
    }

    public interface c {
        void a();

        void b();

        void c();

        void d(boolean r100);

        void e();

        void f();
    }

    public interface d {
        void a();

        void b(String r100);
    }

    public static final class e implements UDListDialogController.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap<Integer, Icon> f441778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f441779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TaskContainer f441780c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f441781d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f441782e;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f441783a = null;

            static {
                int[] r100 = new int[Icon.values().length];
                r100[Icon.ShareIcon.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r100[Icon.ActivityIcon.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r100[Icon.RenameIcon.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r100[Icon.ArchiveIcon.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[Icon.DeleteIcon.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r100[Icon.RemoveIcon.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                f441783a = r100;
            }
        }

        @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
        public final void onItemClick(int r110) {
            Icon r111 = this.f441778a.get(Integer.valueOf(r110));
            if (r111 != null) goto L5;
            int r112 = -1;
        L6:
            String r100 = "";
            switch(r112) {
                case 1: goto L40;
                case 2: goto L38;
                case 3: goto L30;
                case 4: goto L14;
                case 5: goto L10;
                case 6: goto L9;
                default: goto L56;
            };
        L9:
            int r113 = a9c.a.f2310a;
            String r114 = this.f441780c.guid;
            Intrinsics.checkNotNullParameter(r114, "taskListId");
            s5c.a r101 = r.O2;
            s5c.a r115 = z1.f570429c.a(r114);
            r101.getClass();
            a9c.a.c("todo_mobile_container_menu_click", s5c.d.b.b(r101, r115).plus(p3.f570282c).toJson());
            this.f441781d.c();
            return;
        L10:
            int r116 = TaskListDialogUtils.f441775a;
            Context r117 = this.f441782e;
            TaskContainer r102 = this.f441780c;
            boolean r103 = this.f441779b;
            c r104 = this.f441781d;
            Ref.BooleanRef r105 = new Ref.BooleanRef();
            if (r117 == null) goto L50;
            com.larksuite.component.universe_design.dialog.a r118 = new com.larksuite.component.universe_design.dialog.a(r117).title(UIHelper.mustacheFormat(R.string.Todo_List_DeleteList_Title, "List", r102.name)).message(R.string.Todo_List_DeleteList_Desc);
            SpannableStringBuilder r106 = new SpannableStringBuilder();
            ForegroundColorSpan r107 = new ForegroundColorSpan(UIHelper.getColor(R.color.text_title));
            int r119 = r106.length();
            r106.append(UIHelper.getString(R.string.Todo_List_DeleteListUnassignedTasks_Checkbox));
            r106.setSpan(r107, r119, r106.length(), 17);
            SpannedString r108 = new SpannedString(r106);
            r118.getClass();
            Intrinsics.checkNotNullParameter(r108, "value");
            r118.f284870a = r108;
            r118.f284871b = new com.ss.android.lark.todo.impl.features.center.v3.util.c(r105);
            r118.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.Todo_List_DeleteListDelete_Button).textColorRes(R.color.function_danger_fill_default).onClickListener(new com.ss.android.lark.todo.impl.features.center.v3.util.d(r103, r105, r102, r104))).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Todo_List_DeleteListCancel_Button, null).cancelOnTouchOutside(false).show();
            return;
        L50:
            return;
        L38:
            int r120 = a9c.a.f2310a;
            TaskContainer r121 = this.f441780c;
            Intrinsics.checkNotNullParameter(r121, "taskContainer");
            s5c.a r109 = r.f570348v2;
            s5c.a r122 = p3.f570296q;
            r109.getClass();
            a9c.a.c("todo_center_task_list_click", s5c.d.b.b(r109, r122).plus(e4.f570193c).plus(a9c.a.a(r121)).toJson());
            TaskContainer r123 = this.f441780c;
            Intrinsics.checkNotNullParameter(r123, "taskContainer");
            a9c.a.c("todo_task_list_progress_view", a9c.a.a(r123).toJson());
            this.f441781d.b();
            return;
        L56:
            return;
        L14:
            if (this.f441779b == false) goto L24;
            int r124 = a9c.a.f2310a;
            int r125 = com.ss.android.lark.todo.impl.features.center.v3.b.f441422a;
            boolean r126 = !com.ss.android.lark.todo.impl.features.center.v3.b.i(this.f441780c);
            TaskContainer r127 = this.f441780c;
            String r128 = r127.key;
            TaskContainer.Category r129 = TaskContainer.Category.TASK_LIST;
            String r130 = r127.guid;
            Intrinsics.checkNotNullParameter(r128, "containerKey");
            Intrinsics.checkNotNullParameter(r129, "category");
            s5c.a r131 = r.f570340p2;
            s5c.a r132 = p3.f570282c;
            r131.getClass();
            s5c.d r133 = s5c.d.b.b(r131, r132);
            if (r126 == false) goto L18;
            s5c.a r134 = y3.f570412d;
        L19:
            s5c.d r135 = r133.plus(r134).plus(x.f570398c.a(r128)).plus(v.f570386c.a(String.valueOf(r129.getValue())));
            w r136 = w.f570392c;
            if (r130 == null) goto L23;
            r100 = r130;
        L23:
            a9c.a.c("todo_mobile_container_menu_click", r135.plus(r136.a(r100)).toJson());
        L26:
            if (com.ss.android.lark.todo.impl.features.center.v3.b.i(this.f441780c) == false) goto L28;
            this.f441781d.e();
            return;
        L28:
            int r137 = TaskListDialogUtils.f441775a;
            Context r138 = this.f441782e;
            TaskContainer r139 = this.f441780c;
            c r140 = this.f441781d;
            UDDialogBuilder r141 = new UDDialogBuilder(r138);
            String r142 = UIHelper.getString(R.string.Todo_TaskList_ArchiveList_Title);
            ICUUtils.FormatArgsBuilder r143 = new ICUUtils.FormatArgsBuilder();
            r143.b("listName", r139.name);
            r141.title(ICUUtils.icuFormat("en-US", r142, r143.f285892a)).message(R.string.Todo_TaskList_ArchiveList_Desc).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.Todo_TaskList_ArchiveList_Archive_Button).onClickListener(new com.ss.android.lark.todo.impl.features.center.v3.util.a(r140))).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Todo_TaskList_ArchiveList_Cancel_Button, null).cancelOnTouchOutside(false).show();
            return;
        L18:
            r134 = y3.f570420l;
            goto L19
        L24:
            int r144 = a9c.a.f2310a;
            TaskContainer r145 = this.f441780c;
            a9c.a.h(r145, !com.ss.android.lark.todo.impl.features.center.v3.b.i(r145), false);
            goto L26
        L30:
            if (this.f441779b == false) goto L36;
            int r146 = a9c.a.f2310a;
            TaskContainer r147 = this.f441780c;
            String r148 = r147.key;
            TaskContainer.Category r149 = r147.category;
            String r150 = r147.guid;
            Intrinsics.checkNotNullParameter(r148, "containerKey");
            Intrinsics.checkNotNullParameter(r149, "category");
            s5c.a r151 = r.G1;
            s5c.a r152 = p3.f570282c;
            r151.getClass();
            s5c.d r153 = s5c.d.b.b(r151, r152).plus(x.f570398c.a(r148)).plus(v.f570386c.a(String.valueOf(r149.getValue())));
            w r154 = w.f570392c;
            if (r150 == null) goto L35;
            r100 = r150;
        L35:
            a9c.a.c("todo_mobile_container_menu_click", r153.plus(r154.a(r100)).toJson());
        L37:
            this.f441781d.f();
            return;
        L36:
            int r155 = a9c.a.f2310a;
            TaskContainer r156 = this.f441780c;
            Intrinsics.checkNotNullParameter(r156, "taskContainer");
            s5c.a r157 = r.G1;
            s5c.a r158 = p3.f570282c;
            r157.getClass();
            a9c.a.c("todo_center_task_list_click", s5c.d.b.b(r157, r158).plus(c2.f570169g).plus(a9c.a.a(r156)).toJson());
            goto L37
        L40:
            if (this.f441779b == false) goto L46;
            int r159 = a9c.a.f2310a;
            TaskContainer r160 = this.f441780c;
            String r161 = r160.key;
            TaskContainer.Category r162 = r160.category;
            String r163 = r160.guid;
            Intrinsics.checkNotNullParameter(r161, "containerKey");
            Intrinsics.checkNotNullParameter(r162, "category");
            s5c.a r164 = r.f570354y1;
            s5c.a r165 = p3.f570294o;
            r164.getClass();
            s5c.d r166 = s5c.d.b.b(r164, r165).plus(x.f570398c.a(r161)).plus(v.f570386c.a(String.valueOf(r162.getValue())));
            w r167 = w.f570392c;
            if (r163 == null) goto L45;
            r100 = r163;
        L45:
            a9c.a.c("todo_mobile_container_menu_click", r166.plus(r167.a(r100)).toJson());
        L47:
            this.f441781d.a();
            return;
        L46:
            int r168 = a9c.a.f2310a;
            TaskContainer r169 = this.f441780c;
            Intrinsics.checkNotNullParameter(r169, "taskContainer");
            s5c.a r170 = r.f570354y1;
            s5c.a r171 = p3.f570294o;
            r170.getClass();
            a9c.a.c("todo_center_task_list_click", s5c.d.b.b(r170, r171).plus(c2.f570169g).plus(a9c.a.a(r169)).toJson());
            goto L47
        L5:
            r112 = a.f441783a[r111.ordinal()];
            goto L6
        }

        public e(HashMap<Integer, Icon> r100, boolean r101, TaskContainer r102, c r103, Context r104) {
            this.f441778a = r100;
            this.f441779b = r101;
            this.f441780c = r102;
            this.f441781d = r103;
            this.f441782e = r104;
        }
    }

    static {
    }

    public static void a(Context r100, DialogInterface r101) {
        View r102 = null;
        if ((r101 instanceof Dialog) == false) goto L5;
        Dialog r103 = (Dialog) r101;
    L6:
        if (r103 == null) goto L10;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L10;
        r102 = r104.getCurrentFocus();
    L10:
        KeyboardUtils.hideKeyboard(r100, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Context r110, TaskContainer r111, boolean r112, c r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r113, "listener");
        TaskContainerPermission r100 = r111.current_user_permission;
        if (r100 == null) goto L5;
        Map<Integer, Boolean> r101 = r100.permissions;
    L7:
        if (r101 == null) goto L11;
        Boolean r102 = r101.get(Integer.valueOf(TaskContainerPermission.Action.EDIT_CONTAINER.getValue()));
        if (r102 == null) goto L11;
        boolean r103 = r102.booleanValue();
    L12:
        if (r101 == null) goto L16;
        Boolean r104 = r101.get(Integer.valueOf(TaskContainerPermission.Action.EDIT_CONTAINER.getValue()));
        if (r104 == null) goto L16;
        boolean r105 = r104.booleanValue();
    L17:
        if (r101 == null) goto L21;
        Boolean r106 = r101.get(Integer.valueOf(TaskContainerPermission.Action.DELETE_CONTAINER.getValue()));
        if (r106 == null) goto L21;
        boolean r107 = r106.booleanValue();
    L22:
        HashMap r108 = new HashMap();
        ArrayList r109 = new ArrayList();
        com.ss.android.lark.todo.impl.utils.i r114 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r109.add(new UDBaseListDialogBuilder.ListItemBuilder(r114.g(R.string.Todo_List_Share_MenuItem)).build());
        r108.put(0, Icon.ShareIcon);
        r109.add(new UDBaseListDialogBuilder.ListItemBuilder(r114.g(R.string.Todo_Updates_Title)).build());
        r108.put(1, Icon.ActivityIcon);
        int r115 = 2;
        if (r103 == false) goto L25;
        r109.add(new UDBaseListDialogBuilder.ListItemBuilder(r114.g(R.string.Todo_List_Rename_MenuItem)).build());
        r108.put(2, Icon.RenameIcon);
        r115 = 3;
    L25:
        if (r105 == true) goto L27;
    L31:
        if (r112 == false) goto L33;
        r109.add(new UDBaseListDialogBuilder.ListItemBuilder(r114.g(R.string.Todo_TaskListSection_RemoveFromSection_DropDown_Button)).build());
        r108.put(Integer.valueOf(r115), Icon.RemoveIcon);
        r115 = r115 + 1;
    L33:
        if (r107 == false) goto L35;
        r109.add(new UDBaseListDialogBuilder.ListItemBuilder(r114.g(R.string.Todo_List_Delete_MenuItem)).build());
        r108.put(Integer.valueOf(r115), Icon.DeleteIcon);
    L35:
        ((UDActionPanelBuilder) new UDActionPanelBuilder(r110).itemList(r109).itemClickListener(new e(r108, r112, r111, r113, r110)).addActionButton(R.id.ud_dialog_btn_cancel, r114.g(R.string.Todo_Common_Cancel), null)).show();
        return;
    L27:
        if (com.ss.android.lark.todo.impl.features.center.v3.b.i(r111) == false) goto L29;
        int r116 = R.string.Todo_TaskList_Restore_Button;
    L30:
        r109.add(new UDBaseListDialogBuilder.ListItemBuilder(r114.g(r116)).build());
        r108.put(Integer.valueOf(r115), Icon.ArchiveIcon);
        r115 = r115 + 1;
        goto L31
    L29:
        r116 = R.string.Todo_TaskList_Archive_Button;
    L21:
        r107 = false;
    L16:
        r105 = false;
    L11:
        r103 = false;
        goto L12
    L5:
        r101 = null;
        goto L7
    }
}
