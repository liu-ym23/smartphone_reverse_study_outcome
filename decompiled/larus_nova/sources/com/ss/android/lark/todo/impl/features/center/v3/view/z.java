package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.content.DialogInterface;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.todo.impl.features.center.v3.data.SectionHeaderItem;
import com.ss.android.lark.todo.impl.features.center.v3.util.TaskListDialogUtils;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class z implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SectionHeaderItem f442139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SectionItemViewHolder f442140b;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SectionItemViewHolder f442141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SectionHeaderItem f442142b;

        public a(SectionItemViewHolder r100, SectionHeaderItem r101) {
            this.f442141a = r100;
            this.f442142b = r101;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f442141a.f441894b.c(this.f442142b.f441435a);
        }
    }

    public static final class b implements com.larksuite.component.universe_design.dialog.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f442143a;

        public b(Ref.ObjectRef<String> r100) {
            this.f442143a = r100;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
        @Override // com.larksuite.component.universe_design.dialog.c.a
        public final void onTextChanged(CharSequence r100) {
            Ref.ObjectRef<String> r101 = this.f442143a;
            r101.element = String.valueOf(r100);
        }
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SectionItemViewHolder f442144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SectionHeaderItem f442145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f442146c;

        public c(SectionItemViewHolder r100, SectionHeaderItem r101, Ref.ObjectRef<String> r102) {
            this.f442144a = r100;
            this.f442145b = r101;
            this.f442146c = r102;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            int r102 = TaskListDialogUtils.f441775a;
            TaskListDialogUtils.a(this.f442144a.f441893a.getContext(), r100);
            this.f442144a.f441894b.n(this.f442145b.f441435a, this.f442146c.element);
        }
    }

    public static final class d implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SectionItemViewHolder f442147a;

        public d(SectionItemViewHolder r100) {
            this.f442147a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            int r102 = TaskListDialogUtils.f441775a;
            TaskListDialogUtils.a(this.f442147a.f441893a.getContext(), r100);
        }
    }

    public static final class e implements com.larksuite.component.universe_design.dialog.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f442148a;

        public e(Ref.ObjectRef<String> r100) {
            this.f442148a = r100;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
        @Override // com.larksuite.component.universe_design.dialog.c.a
        public final void onTextChanged(CharSequence r100) {
            Ref.ObjectRef<String> r101 = this.f442148a;
            r101.element = String.valueOf(r100);
        }
    }

    public static final class f implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SectionItemViewHolder f442149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SectionHeaderItem f442150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f442151c;

        public f(SectionItemViewHolder r100, SectionHeaderItem r101, Ref.ObjectRef<String> r102) {
            this.f442149a = r100;
            this.f442150b = r101;
            this.f442151c = r102;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            int r102 = TaskListDialogUtils.f441775a;
            TaskListDialogUtils.a(this.f442149a.f441893a.getContext(), r100);
            this.f442149a.f441894b.e(this.f442150b.f441435a, this.f442151c.element);
        }
    }

    public static final class g implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SectionItemViewHolder f442152a;

        public g(SectionItemViewHolder r100) {
            this.f442152a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            int r102 = TaskListDialogUtils.f441775a;
            TaskListDialogUtils.a(this.f442152a.f441893a.getContext(), r100);
        }
    }

    public static final class h implements com.larksuite.component.universe_design.dialog.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f442153a;

        public h(Ref.ObjectRef<String> r100) {
            this.f442153a = r100;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
        @Override // com.larksuite.component.universe_design.dialog.c.a
        public final void onTextChanged(CharSequence r100) {
            Ref.ObjectRef<String> r101 = this.f442153a;
            r101.element = String.valueOf(r100);
        }
    }

    public static final class i implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SectionItemViewHolder f442154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SectionHeaderItem f442155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f442156c;

        public i(SectionItemViewHolder r100, SectionHeaderItem r101, Ref.ObjectRef<String> r102) {
            this.f442154a = r100;
            this.f442155b = r101;
            this.f442156c = r102;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            int r102 = TaskListDialogUtils.f441775a;
            TaskListDialogUtils.a(this.f442154a.f441893a.getContext(), r100);
            this.f442154a.f441894b.b(this.f442155b.f441435a, this.f442156c.element);
        }
    }

    public static final class j implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SectionItemViewHolder f442157a;

        public j(SectionItemViewHolder r100) {
            this.f442157a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            int r102 = TaskListDialogUtils.f441775a;
            TaskListDialogUtils.a(this.f442157a.f441893a.getContext(), r100);
        }
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [T, java.lang.String] */
    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r110) {
        if (r110 != 0) goto L5;
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        r111.element = this.f442139a.f441436b;
        com.larksuite.component.universe_design.dialog.c r100 = new com.larksuite.component.universe_design.dialog.c(this.f442140b.f441893a.getContext());
        com.ss.android.lark.todo.impl.utils.i r101 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        com.larksuite.component.universe_design.dialog.c r102 = r100.title(r101.g(R.string.Todo_New_Section_RenameSection_Button)).titleGravity(3);
        String r103 = this.f442139a.f441436b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "value");
        r102.f284887k = r103;
        r102.f284890n = new b(r111);
        com.larksuite.component.universe_design.dialog.c r112 = r102.addActionButton(R.id.ud_dialog_btn_primary, r101.g(R.string.Lark_Legacy_Confirm), new c(this.f442140b, this.f442139a, r111)).addActionButton(R.id.ud_dialog_btn_secondary, r101.g(R.string.Lark_Legacy_Cancel), new d(this.f442140b));
        r112.f284889m = true;
        r112.f284888l = true;
        r112.show();
        return;
    L5:
        if (r110 != 1) goto L7;
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        r113.element = "";
        com.larksuite.component.universe_design.dialog.c r104 = new com.larksuite.component.universe_design.dialog.c(this.f442140b.f441893a.getContext());
        com.ss.android.lark.todo.impl.utils.i r114 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        com.larksuite.component.universe_design.dialog.c r105 = r104.title(r114.g(R.string.Todo_New_Section_NewSection_Button)).titleGravity(3);
        String r106 = r114.g(R.string.Todo_New_Section_EnterSectionName_Placeholder);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "value");
        r105.f284886j = r106;
        r105.f284890n = new e(r113);
        com.larksuite.component.universe_design.dialog.c r115 = r105.addActionButton(R.id.ud_dialog_btn_primary, r114.g(R.string.Lark_Legacy_Confirm), new f(this.f442140b, this.f442139a, r113)).addActionButton(R.id.ud_dialog_btn_secondary, r114.g(R.string.Lark_Legacy_Cancel), new g(this.f442140b));
        r115.f284889m = true;
        r115.f284888l = true;
        r115.show();
        return;
    L7:
        if (r110 == 2) goto L16;
        if (r110 == 3) goto L15;
        UDDialog r116 = new UDDialogBuilder(this.f442140b.f441893a.getContext()).title(R.string.Todo_New_Section_DeleteSection_Button).message(R.string.Todo_SectionDeletedTasksReturnedToNoSection_Title).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.Todo_common_Delete).textColorRes(R.color.function_danger_fill_default).onClickListener(new a(this.f442140b, this.f442139a))).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Todo_Common_Cancel, null).build();
        if (DialogLancet.shouldBlockDialogShow(r116) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r116);
    L14:
        Unit r117 = Unit.INSTANCE;
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L13:
        DialogLancet.beforeDialogShow(r116);
        r116.show();
        DialogLancet.afterDialogShow(r116);
        goto L14
    L15:
        this.f442140b.f441894b.p();
        Unit r118 = Unit.INSTANCE;
        return;
    L16:
        Ref.ObjectRef r119 = new Ref.ObjectRef();
        r119.element = "";
        com.larksuite.component.universe_design.dialog.c r107 = new com.larksuite.component.universe_design.dialog.c(this.f442140b.f441893a.getContext());
        com.ss.android.lark.todo.impl.utils.i r120 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        com.larksuite.component.universe_design.dialog.c r108 = r107.title(r120.g(R.string.Todo_New_Section_NewSection_Button)).titleGravity(3);
        String r109 = r120.g(R.string.Todo_New_Section_EnterSectionName_Placeholder);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "value");
        r108.f284886j = r109;
        r108.f284890n = new h(r119);
        com.larksuite.component.universe_design.dialog.c r121 = r108.addActionButton(R.id.ud_dialog_btn_primary, r120.g(R.string.Lark_Legacy_Confirm), new i(this.f442140b, this.f442139a, r119)).addActionButton(R.id.ud_dialog_btn_secondary, r120.g(R.string.Lark_Legacy_Cancel), new j(this.f442140b));
        r121.f284889m = true;
        r121.f284888l = true;
        r121.show();
    }

    public z(SectionHeaderItem r100, SectionItemViewHolder r101) {
        this.f442139a = r100;
        this.f442140b = r101;
    }
}
