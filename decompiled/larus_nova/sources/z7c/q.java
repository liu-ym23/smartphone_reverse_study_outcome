package z7c;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.lark.pb.todo.v1.TaskItemMember;
import com.bytedance.lark.pb.todo.v1.TaskListMember;
import com.bytedance.lark.pb.todo.v1.TodoChat;
import com.bytedance.lark.pb.todo.v1.TodoDoc;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberRole;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberType;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class q extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TaskListMember f570803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TodoItemMemberRole f570804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f570805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p.a f570806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f570807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f570808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f570809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f570810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f570811i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f570812j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LarkAvatarView f570813k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f570814l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f570815m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f570816n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f570817o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f570818p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f570819q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f570820r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f570821s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f570822t;

    public static final class a extends AvatarModel.a<a> {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f570823a = null;

        static {
            int[] r100 = new int[TodoItemMemberType.values().length];
            r100[TodoItemMemberType.USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[TodoItemMemberType.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[TodoItemMemberType.DOCS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f570823a = r100;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f570824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f570825b;

        public c(q r100) {
            this.f570825b = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f570824a;
            long r102 = System.currentTimeMillis();
            this.f570824a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            UDDialogBuilder r103 = new UDDialogBuilder(this.f570825b.getContext());
            com.ss.android.lark.todo.impl.utils.i r104 = com.ss.android.lark.todo.impl.utils.i.f444291a;
            TextView r105 = this.f570825b.f570814l;
            String r106 = "";
            if (r105 == null) goto L11;
            CharSequence r107 = r105.getText();
            if (r107 == null) goto L11;
            String r108 = r107.toString();
            if (r108 == null) goto L11;
        L12:
            UDDialogBuilder r109 = r103.title(com.ss.android.lark.todo.impl.utils.i.d(R.string.Todo_List_TransferOwnership_Title, "name", r108));
            TextView r110 = this.f570825b.f570814l;
            if (r110 == null) goto L20;
            CharSequence r111 = r110.getText();
            if (r111 == null) goto L20;
            String r112 = r111.toString();
            if (r112 == null) goto L20;
            r106 = r112;
        L20:
            r109.message(com.ss.android.lark.todo.impl.utils.i.d(R.string.Todo_List_TransferOwnership_Desc, "name", r106)).addActionButton(R.id.ud_dialog_btn_primary, R.string.Todo_List_TransferOwnershipTransfer_Button, new g(this.f570825b)).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Todo_List_TransferOwnershipCancel_Button, null).show();
            UDDialog r113 = this.f570825b.getMDialog();
            if (r113 == null) goto L39;
            Handler r114 = DialogLancet.resolveDialogHandler(r113);
            if (r114 != null) goto L25;
        L27:
            DialogLancet.beforeDialogDismiss(r113);
            r113.dismiss();     // Catch: Throwable -> L30 Exception -> L32
        L36:
            DialogLancet.afterDialogDismiss(r113);
            return;
        L32:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L30
            Throwable r115 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L30
            if (r115 == null) goto L36;
            com.bytedance.crash.d.d(r115, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r113);
            throw th;
        L25:
            if (Looper.myLooper() == r114.getLooper()) goto L27;
            r114.post(DialogLancet.createDismissRunnable(r113));
            return;
        L39:
            return;
        L11:
            r108 = "";
            goto L12
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f570826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f570827b;

        public d(q r100) {
            this.f570827b = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f570826a;
            long r102 = System.currentTimeMillis();
            this.f570826a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            UDDialog r103 = this.f570827b.getMDialog();
            if (r103 == null) goto L24;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r103);
            return;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r105 == null) goto L21;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L10:
            if (Looper.myLooper() == r104.getLooper()) goto L12;
            r104.post(DialogLancet.createDismissRunnable(r103));
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f570828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f570829b;

        public e(q r100) {
            this.f570829b = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f570828a;
            long r102 = System.currentTimeMillis();
            this.f570828a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            UDDialog r103 = this.f570829b.getMDialog();
            if (r103 == null) goto L24;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r103);
            return;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r105 == null) goto L21;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L10:
            if (Looper.myLooper() == r104.getLooper()) goto L12;
            r104.post(DialogLancet.createDismissRunnable(r103));
            return;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f570830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f570831b;

        public f(q r100) {
            this.f570831b = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f570830a;
            long r102 = System.currentTimeMillis();
            this.f570830a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            UDDialog r103 = this.f570831b.getMDialog();
            if (r103 == null) goto L24;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r103);
            return;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r105 == null) goto L21;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L10:
            if (Looper.myLooper() == r104.getLooper()) goto L12;
            r104.post(DialogLancet.createDismissRunnable(r103));
            return;
        }
    }

    public static final class g implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f570832a;

        public g(q r100) {
            this.f570832a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            q r102 = this.f570832a;
            p.a r103 = r102.f570806d;
            if (r103 == null) goto L6;
            r103.a(TodoItemMemberRole.OWNER, q.b(r102));
            return;
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f570833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f570834b;

        public h(q r100) {
            this.f570834b = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f570833a;
            long r102 = System.currentTimeMillis();
            this.f570833a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            q r103 = this.f570834b;
            p.a r104 = r103.f570806d;
            if (r104 == null) goto L8;
            r104.a(TodoItemMemberRole.READER, q.b(r103));
        L8:
            UDDialog r105 = this.f570834b.getMDialog();
            if (r105 == null) goto L27;
            Handler r106 = DialogLancet.resolveDialogHandler(r105);
            if (r106 != null) goto L13;
        L15:
            DialogLancet.beforeDialogDismiss(r105);
            r105.dismiss();     // Catch: Throwable -> L18 Exception -> L20
        L24:
            DialogLancet.afterDialogDismiss(r105);
            return;
        L18:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r105);
            throw th;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
            Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
            if (r107 == null) goto L24;
            com.bytedance.crash.d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
            goto L24
        L13:
            if (Looper.myLooper() == r106.getLooper()) goto L15;
            r106.post(DialogLancet.createDismissRunnable(r105));
            return;
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultRootRes() {
        return R.layout.task_list_member_role_dialog_root;
    }

    public final void c() {
        TextView r100 = this.f570817o;
        if (r100 == null) goto L5;
        r100.setTextColor(com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.text_title));
    L5:
        ViewGroup r101 = this.f570810h;
        if (r101 == null) goto L8;
        r101.setClickable(true);
    L8:
        ViewGroup r102 = this.f570810h;
        if (r102 == null) goto L12;
        r102.setOnClickListener(new h(this));
        return;
    }

    public final void initView() {
        ViewGroup r100 = this.f570811i;
        if (r100 == null) goto L6;
        com.larksuite.framework.section.utils.a.d(r100, !this.f570805c);
    L6:
        if (this.f570805c == false) goto L10;
        TextView r101 = this.f570822t;
        if (r101 == null) goto L13;
        r101.setText(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Lark_Legacy_Delete));
    L13:
        TodoItemMemberRole r102 = this.f570804b;
        TodoItemMemberRole r103 = TodoItemMemberRole.OWNER;
        TodoItemMemberRole r104 = null;
        if (r102 != r103) goto L32;
        TaskListMember r105 = this.f570803a;
        if (r105 == null) goto L20;
        TaskItemMember r106 = r105.member;
        if (r106 == null) goto L20;
        TodoItemMemberType r107 = r106.type;
    L22:
        if (r107 != TodoItemMemberType.USER) goto L32;
        TextView r108 = this.f570821s;
        if (r108 == null) goto L26;
        r108.setTextColor(com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.text_title));
    L26:
        ViewGroup r109 = this.f570811i;
        if (r109 == null) goto L29;
        r109.setClickable(true);
    L29:
        ViewGroup r110 = this.f570811i;
        if (r110 == null) goto L32;
        r110.setOnClickListener(new c(this));
    L20:
        r107 = null;
    L32:
        TodoItemMemberRole r111 = this.f570804b;
        TodoItemMemberRole r112 = TodoItemMemberRole.WRITER;
        if (r111 == r112) goto L35;
        if (r111 == r103) goto L35;
    L54:
        TodoItemMemberRole r113 = this.f570804b;
        TodoItemMemberRole r114 = TodoItemMemberRole.READER;
        if (r113 != r114) goto L57;
        c();
    L57:
        TaskListMember r115 = this.f570803a;
        if (r115 == null) goto L64;
        List<TodoItemMemberRole> r116 = r115.enable_roles;
        if (r116 == null) goto L64;
        if (r116.contains(r103) != true) goto L64;
        boolean r117 = true;
    L65:
        if (r117 == false) goto L69;
        ViewGroup r118 = this.f570811i;
        if (r118 == null) goto L69;
        r118.setVisibility(0);
    L69:
        TaskListMember r119 = this.f570803a;
        if (r119 == null) goto L76;
        List<TodoItemMemberRole> r120 = r119.enable_roles;
        if (r120 == null) goto L76;
        if (r120.contains(r112) != true) goto L76;
        boolean r121 = true;
    L77:
        if (r121 == false) goto L81;
        ViewGroup r122 = this.f570809g;
        if (r122 == null) goto L81;
        r122.setVisibility(0);
    L81:
        TaskListMember r123 = this.f570803a;
        if (r123 == null) goto L88;
        List<TodoItemMemberRole> r124 = r123.enable_roles;
        if (r124 == null) goto L88;
        if (r124.contains(r114) != true) goto L88;
        boolean r125 = true;
    L89:
        if (r125 == false) goto L93;
        ViewGroup r126 = this.f570810h;
        if (r126 == null) goto L93;
        r126.setVisibility(0);
    L93:
        TaskListMember r127 = this.f570803a;
        if (r127 == null) goto L100;
        List<TodoItemMemberRole> r128 = r127.enable_roles;
        if (r128 == null) goto L100;
        if (r128.contains(TodoItemMemberRole.INHERIT) != true) goto L100;
        boolean r129 = true;
    L101:
        if (r129 == false) goto L106;
        ViewGroup r130 = this.f570808f;
        if (r130 == null) goto L106;
        r130.setVisibility(0);
    L106:
        if (this.f570805c == false) goto L113;
        ViewGroup r131 = this.f570809g;
        if (r131 == null) goto L110;
        r131.setVisibility(0);
    L110:
        ViewGroup r132 = this.f570810h;
        if (r132 == null) goto L113;
        r132.setVisibility(0);
    L113:
        TaskListMember r133 = this.f570803a;
        if (r133 == null) goto L116;
        TodoItemMemberRole r134 = r133.role;
    L118:
        if (r134 != TodoItemMemberRole.INHERIT) goto L128;
        ImageView r135 = this.f570818p;
        if (r135 == null) goto L122;
        r135.setVisibility(0);
    L122:
        ViewGroup r136 = this.f570808f;
        if (r136 == null) goto L125;
        r136.setClickable(true);
    L125:
        ViewGroup r137 = this.f570808f;
        if (r137 == null) goto L128;
        r137.setOnClickListener(new d(this));
    L128:
        TaskListMember r138 = this.f570803a;
        if (r138 == null) goto L131;
        TodoItemMemberRole r139 = r138.role;
    L132:
        if (r139 != r112) goto L142;
        ImageView r140 = this.f570819q;
        if (r140 == null) goto L136;
        r140.setVisibility(0);
    L136:
        ViewGroup r141 = this.f570809g;
        if (r141 == null) goto L139;
        r141.setClickable(true);
    L139:
        ViewGroup r142 = this.f570809g;
        if (r142 == null) goto L142;
        r142.setOnClickListener(new e(this));
    L142:
        TaskListMember r143 = this.f570803a;
        if (r143 == null) goto L145;
        r104 = r143.role;
    L145:
        if (r104 != r114) goto L156;
        ImageView r144 = this.f570820r;
        if (r144 == null) goto L149;
        r144.setVisibility(0);
    L149:
        ViewGroup r145 = this.f570810h;
        if (r145 == null) goto L152;
        r145.setClickable(true);
    L152:
        ViewGroup r146 = this.f570810h;
        if (r146 == null) goto L157;
        r146.setOnClickListener(new f(this));
        return;
    L157:
        return;
    L156:
        return;
    L131:
        r139 = null;
        goto L132
    L116:
        r134 = null;
    L100:
        r129 = false;
    L88:
        r125 = false;
    L76:
        r121 = false;
    L64:
        r117 = false;
    L35:
        TextView r147 = this.f570815m;
        if (r147 == null) goto L38;
        r147.setTextColor(com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.text_title));
    L38:
        ViewGroup r148 = this.f570808f;
        if (r148 == null) goto L41;
        r148.setClickable(true);
    L41:
        ViewGroup r149 = this.f570808f;
        if (r149 == null) goto L44;
        r149.setOnClickListener(new t(this));
    L44:
        TextView r150 = this.f570816n;
        if (r150 == null) goto L47;
        r150.setTextColor(com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.text_title));
    L47:
        ViewGroup r151 = this.f570809g;
        if (r151 == null) goto L50;
        r151.setClickable(true);
    L50:
        ViewGroup r152 = this.f570809g;
        if (r152 == null) goto L53;
        r152.setOnClickListener(new s(this));
    L53:
        c();
        goto L54
    L10:
        TextView r153 = this.f570822t;
        if (r153 == null) goto L13;
        r153.setText(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_ShareList_ManageCollaboratorsRemove_MenuItem));
        goto L13
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View createView() {
        View r100 = super.createView();
        String r101 = null;
        if (r100 == null) goto L5;
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.task_list_member_role_container);
    L6:
        this.f570807e = r102;
        if (r100 == null) goto L9;
        ViewGroup r103 = (ViewGroup) r100.findViewById(R.id.task_list_member_role_inherit_container);
    L10:
        this.f570808f = r103;
        if (r100 == null) goto L13;
        ViewGroup r104 = (ViewGroup) r100.findViewById(R.id.task_list_member_role_edit_container);
    L14:
        this.f570809g = r104;
        if (r100 == null) goto L17;
        ViewGroup r105 = (ViewGroup) r100.findViewById(R.id.task_list_member_role_read_container);
    L18:
        this.f570810h = r105;
        if (r100 == null) goto L21;
        ViewGroup r106 = (ViewGroup) r100.findViewById(R.id.task_list_member_set_owner_container);
    L22:
        this.f570811i = r106;
        if (r100 == null) goto L25;
        ViewGroup r107 = (ViewGroup) r100.findViewById(R.id.task_list_member_role_remove_container);
    L26:
        this.f570812j = r107;
        if (r100 == null) goto L29;
        LarkAvatarView r108 = (LarkAvatarView) r100.findViewById(R.id.member_role_avatar);
    L30:
        this.f570813k = r108;
        if (r100 == null) goto L33;
        TextView r109 = (TextView) r100.findViewById(R.id.member_role_name);
    L34:
        this.f570814l = r109;
        if (r100 == null) goto L37;
        TextView r110 = (TextView) r100.findViewById(R.id.task_list_member_role_inherit_tv);
    L38:
        this.f570815m = r110;
        if (r100 == null) goto L41;
        TextView r111 = (TextView) r100.findViewById(R.id.task_list_member_role_edit_tv);
    L42:
        this.f570816n = r111;
        if (r100 == null) goto L45;
        TextView r112 = (TextView) r100.findViewById(R.id.task_list_member_role_read_tv);
    L46:
        this.f570817o = r112;
        if (r100 == null) goto L49;
        ImageView r113 = (ImageView) r100.findViewById(R.id.task_list_member_role_inherit_icon);
    L50:
        this.f570818p = r113;
        if (r100 == null) goto L53;
        ImageView r114 = (ImageView) r100.findViewById(R.id.task_list_member_role_edit_icon);
    L54:
        this.f570819q = r114;
        if (r100 == null) goto L57;
        ImageView r115 = (ImageView) r100.findViewById(R.id.task_list_member_role_read_icon);
    L58:
        this.f570820r = r115;
        if (r100 == null) goto L61;
        TextView r116 = (TextView) r100.findViewById(R.id.task_list_member_set_owner_txt);
    L62:
        this.f570821s = r116;
        if (r100 == null) goto L65;
        TextView r117 = (TextView) r100.findViewById(R.id.task_list_member_role_remove_txt);
    L66:
        this.f570822t = r117;
        initView();
        TaskListMember r118 = this.f570803a;
        if (r118 == null) goto L69;
        TaskItemMember r119 = r118.member;
    L70:
        if (r119 == null) goto L117;
        TodoItemMemberType r120 = r119.type;
        if (r120 != null) goto L75;
        int r121 = -1;
    L76:
        boolean r122 = true;
        if (r121 != 1) goto L79;
        LarkAvatarView r123 = this.f570813k;
        if (r123 == null) goto L114;
        a r124 = new a();
        r124.b(r119.user.avatar_key);
        r124.f(r119.user.user_id);
        r123.j(new AvatarModel(r124));
    L114:
        TextView r125 = this.f570814l;
        if (r125 == null) goto L117;
        r125.setText(r119.user.name);
        goto L117
    L79:
        if (r121 != 2) goto L81;
        LarkAvatarView r126 = this.f570813k;
        if (r126 == null) goto L108;
        a r127 = new a();
        r127.b(r119.chat.avatar_key);
        r127.f(r119.chat.chat_id);
        r126.j(new AvatarModel(r127));
    L108:
        TextView r128 = this.f570814l;
        if (r128 == null) goto L117;
        r128.setText(r119.chat.name);
        goto L117
    L81:
        if (r121 != 3) goto L117;
        LarkAvatarView r129 = this.f570813k;
        if (r129 == null) goto L86;
        a r130 = new a();
        r130.d(kac.a.b(R.drawable.ud_icon_wiki_docx_circle_colorful));
        r129.j(new AvatarModel(r130));
    L86:
        TextView r131 = this.f570814l;
        if (r131 == null) goto L117;
        TodoDoc r132 = r119.f253777doc;
        if (r132 == null) goto L91;
        r101 = r132.name;
    L91:
        boolean r133 = false;
        if (r101 != null) goto L94;
    L97:
        if (r122 == false) goto L104;
        TodoDoc r134 = r119.f253777doc;
        if (r134 == null) goto L101;
        r133 = Intrinsics.areEqual(r134.has_permission, Boolean.TRUE);
    L101:
        if (r133 == false) goto L103;
        r101 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Doc_UntitledDocument_Title);
        goto L104
    L103:
        r101 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Activities_DocNameUnauthorized_Text);
    L104:
        r131.setText(r101);
        goto L117
    L94:
        if (r101.length() == 0) goto L97;
        r122 = false;
        goto L97
    L75:
        r121 = b.f570823a[r120.ordinal()];
    L117:
        ViewGroup r135 = this.f570812j;
        if (r135 == null) goto L120;
        r135.setOnClickListener(new r(this));
    L120:
        return r100;
    L69:
        r119 = null;
        goto L70
    L65:
        r117 = null;
        goto L66
    L61:
        r116 = null;
        goto L62
    L57:
        r115 = null;
        goto L58
    L53:
        r114 = null;
        goto L54
    L49:
        r113 = null;
        goto L50
    L45:
        r112 = null;
        goto L46
    L41:
        r111 = null;
        goto L42
    L37:
        r110 = null;
        goto L38
    L33:
        r109 = null;
        goto L34
    L29:
        r108 = null;
        goto L30
    L25:
        r107 = null;
        goto L26
    L21:
        r106 = null;
        goto L22
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public q(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        this.f570804b = TodoItemMemberRole.NONE;
    }

    public static final String b(q r100) {
        TaskListMember r101 = r100.f570803a;
        if (r101 == null) goto L7;
        TaskItemMember r102 = r101.member;
        if (r102 == null) goto L7;
        TodoItemMemberType r103 = r102.type;
    L8:
        if (r103 != null) goto L10;
        int r104 = -1;
    L12:
        if (r104 != 1) goto L14;
        TaskListMember r105 = r100.f570803a;
        if (r105 == null) goto L41;
        TaskItemMember r106 = r105.member;
        if (r106 == null) goto L41;
        TodoUser r107 = r106.user;
        if (r107 == null) goto L41;
        String r108 = r107.user_id;
        if (r108 == null) goto L41;
        return r108;
    L41:
        return "";
    L14:
        if (r104 == 3) goto L24;
        TaskListMember r109 = r100.f570803a;
        if (r109 == null) goto L41;
        TaskItemMember r110 = r109.member;
        if (r110 == null) goto L41;
        TodoChat r111 = r110.chat;
        if (r111 == null) goto L41;
        String r112 = r111.chat_id;
        if (r112 == null) goto L41;
        return r112;
    L24:
        TaskListMember r113 = r100.f570803a;
        if (r113 == null) goto L41;
        TaskItemMember r114 = r113.member;
        if (r114 == null) goto L41;
        TodoDoc r115 = r114.f253777doc;
        if (r115 == null) goto L41;
        String r116 = r115.f253781id;
        if (r116 == null) goto L41;
        return r116;
    L10:
        r104 = b.f570823a[r103.ordinal()];
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof p) == false) goto L7;
        super.apply(r100, r101);
        p r102 = (p) r100;
        this.f570803a = r102.f570799a;
        this.f570804b = r102.f570800b;
        this.f570805c = r102.f570801c;
        this.f570806d = r102.f570802d;
        return;
    L7:
        throw new IllegalArgumentException("builder should be TaskListMemberDialogBuilder, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }
}
