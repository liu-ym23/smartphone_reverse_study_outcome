package com.ss.android.lark.todo.impl.features.detail.sections;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.lark.pb.todo.v1.TaskMode;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.ICUUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatarList;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.AssigneeBean;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoData;
import com.ss.android.lark.todo.impl.features.detail.widget.KeyboardScrollView;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class AssigneeSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f443117j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f443118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f443119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f443120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f443121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f443122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f443123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f443124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f443125i;

    public static final class a {
        public a() {
        }

        public static final void a(ImageView r100) {
            int r101 = AssigneeSection.f443117j;
            RotateAnimation r102 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            r102.setDuration(400);
            r102.setInterpolator(new LinearInterpolator());
            r102.setRepeatCount(-1);
            r102.setRepeatMode(1);
            r100.startAnimation(r102);
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AssigneeSection f443126a;

        public final void a() {
            long r100 = this.f443126a.f443122f - System.currentTimeMillis();
            AssigneeSection r101 = this.f443126a;
            long r102 = r100 + r101.f443123g;
            if (r102 > 0) goto L5;
            ((LinearLayout) r101.f443119c.findViewById(R.id.layout_revoke_assignee)).setVisibility(8);
            this.f443126a.b().e(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.x.f443790a, false);
            return;
        L5:
            ((Handler) r101.f443124h.getValue()).postDelayed(this, r102);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(AssigneeSection r100) {
            this.f443126a = r100;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AssigneeSection f443127a;

        public c(AssigneeSection r100) {
            this.f443127a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f443127a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.h.f443704a);
            this.f443127a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.r1.f443762a);
            this.f443127a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.m4.f443739a);
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AssigneeSection f443128a;

        public d(AssigneeSection r100) {
            this.f443128a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f443128a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.h.f443704a);
            this.f443128a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.C5354a.f443662a);
            this.f443128a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.m4.f443739a);
        }
    }

    public static final class e implements KeyboardScrollView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AssigneeSection f443129a;

        public e(AssigneeSection r100) {
            this.f443129a = r100;
        }

        @Override // com.ss.android.lark.todo.impl.features.detail.widget.KeyboardScrollView.a
        public final void a(KeyboardScrollView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            View r101 = this.f443129a.o().findViewById(R.id.assignee_shader);
            boolean r102 = false;
            if (r100.getChildAt(0).getMeasuredWidth() <= (r100.getScrollX() + r100.getWidth())) goto L5;
            r102 = true;
        L5:
            com.larksuite.framework.section.utils.a.e(r101, r102);
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatImageView f443130a;

        public f(AppCompatImageView r100) {
            this.f443130a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.lark.todo.impl.utils.b.a(this.f443130a, UIHelper.dp2px(10.0f));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        new a();
    }

    public final View o() {
        return (View) this.f443120d.getValue();
    }

    @Override // com.larksuite.framework.section.h
    public final void i() {
        ((LinearLayout) o().findViewById(R.id.detail_owner_text_container)).setOnClickListener(new c(this));
        ((LinearLayout) this.f443118b.findViewById(R.id.detail_assignee_container)).setOnClickListener(new d(this));
        ((KeyboardScrollView) o().findViewById(R.id.scroll_view_assignee)).setOnScrollChangeListener(new e(this));
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        final com.ss.android.lark.todo.impl.features.detail.viewmodel.p r100 = e();
        k(r100.getAssignees(), new AssigneeSection$initViewObserver$1$1(this));
        k(r100.getTaskMode(), new AssigneeSection$initViewObserver$1$2(r100, this));
        k(r100.getShowRevokeAssignee(), new AssigneeSection$initViewObserver$1$3(this));
        k(r100.getOwnerDeleteIconShow(), new AssigneeSection$initViewObserver$1$4(this));
    }

    public final void q() {
        List<AssigneeBean> r100 = e().getAssignees().getValue();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L11;
        com.larksuite.framework.section.utils.a.d(this.f443118b.findViewById(R.id.avatar_more_icon), Intrinsics.areEqual(e().getOwnerDeleteIconShow().getValue(), Boolean.TRUE));
        AppCompatImageView r102 = (AppCompatImageView) this.f443118b.findViewById(R.id.avatar_more_icon);
        r102.setImageDrawable(UDIconUtils.getIconDrawable(r102.getContext(), R.drawable.ud_icon_close_outlined, com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.icon_n1)));
        r102.post(new f(r102));
        com.larksuite.framework.section.utils.a.b(r102, b(), new com.ss.android.lark.todo.impl.features.detail.viewmodel.a[]{com.ss.android.lark.todo.impl.features.detail.viewmodel.a.e1.f443688a});
        return;
    L11:
        com.larksuite.framework.section.utils.a.d(this.f443118b.findViewById(R.id.avatar_more_icon), false);
        ((AppCompatImageView) this.f443118b.findViewById(R.id.avatar_more_icon)).setOnClickListener(null);
        return;
    L5:
        if (r100.size() != 1) goto L7;
        r101 = true;
        goto L9
    }

    public final void p(TaskSection r100) {
        TextView r101 = (TextView) o().findViewById(R.id.todo_section_txt);
        if (TextUtils.isEmpty(r100.name) == true) goto L5;
        String r102 = r100.name;
    L9:
        r101.setText(r102);
        return;
    L5:
        if (r100.is_default.booleanValue() == false) goto L7;
        r102 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_Section_NoSection_Title);
        goto L9
    L7:
        r102 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_UntitledSection_Title);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.String] */
    public static final void n(AssigneeSection r110, List r111) {
        r110.q();
        int r100 = r111.size();
        if (r100 <= 0) goto L35;
        ((TextView) r110.f443118b.findViewById(R.id.text_add_assignee)).setVisibility(8);
        ((LinearLayout) r110.f443118b.findViewById(R.id.detail_assignee_container)).setClickable(false);
        r110.o().setVisibility(0);
        if (r111.size() <= 3) goto L7;
        List r101 = r111.subList(0, 3);
    L8:
        TaskUDAvatarList r102 = (TaskUDAvatarList) r110.o().findViewById(R.id.avatar_list_view);
        ArrayList r103 = new ArrayList();
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        AssigneeBean r105 = (AssigneeBean) r104.next();
        r103.add(new com.ss.android.lark.todo.impl.features.detail.sections.c(r105.getId(), r105.getAvatarKey(), r105.isShowComplete(), 0));
        goto L10
    L12:
        r102.setAdapter(new com.ss.android.lark.todo.impl.features.detail.sections.d(r103, 0, 6));
        r102.setOverlapWidth(new UDDimension.Dp(4.0f));
        if (r100 != 1) goto L15;
        ((TextView) r110.o().findViewById(R.id.avatar_text)).setText(((AssigneeBean) ListProtector.get(r111, 0)).getName());
    L36:
        ((LinearLayout) r110.o().findViewById(R.id.set_section_container)).setVisibility(8);
        ((ImageView) r110.o().findViewById(R.id.loading_image)).setVisibility(8);
        ((ImageView) r110.o().findViewById(R.id.loading_image)).clearAnimation();
        Iterator r112 = r111.iterator();
    L38:
        if (r112.hasNext() == false) goto L42;
        Object r106 = r112.next();
        if (Intrinsics.areEqual(((AssigneeBean) r106).getId(), r110.f443121e) == false) goto L38;
    L43:
        if (r106 != null) goto L45;
        return;
    L45:
        if (Intrinsics.areEqual(r110.e().getTodoSectionViewCanShow().getValue(), Boolean.TRUE) == false) goto L104;
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        TodoData r107 = r110.e().getTodoDataLiveData().getValue();
        String r108 = "";
        if (r107 == null) goto L50;
        String r109 = r107.getOwnedSectionGuid();
        T r114 = r109;
        if (r109 == null) goto L50;
    L51:
        r113.element = r114;
        TodoData r115 = r110.e().getTodoDataLiveData().getValue();
        if (r115 == null) goto L57;
        String r116 = r115.getOwnedContainerGuid();
        if (r116 == null) goto L57;
        r108 = r116;
    L57:
        TodoData r117 = r110.e().getTodoDataLiveData().getValue();
        if (r117 == null) goto L62;
        List r118 = r117.getOwnedSections();
        if (r118 == null) goto L62;
    L63:
        Iterator r119 = r118.iterator();
    L65:
        if (r119.hasNext() == false) goto L69;
        Object r120 = r119.next();
        if (Intrinsics.areEqual(((TaskSection) r120).guid, r113.element) == false) goto L65;
    L70:
        TaskSection r121 = (TaskSection) r120;
        if (r121 != null) goto L85;
        TodoData r122 = r110.e().getTodoDataLiveData().getValue();
        if (r122 == null) goto L84;
        ArrayList<TaskSection> r123 = r122.getOwnedSections();
        if (r123 == null) goto L84;
        Iterator<T> r124 = r123.iterator();
    L78:
        if (r124.hasNext() == false) goto L82;
        Object r125 = r124.next();
        if (((TaskSection) r125).is_default.booleanValue() == false) goto L78;
    L83:
        r121 = (TaskSection) r125;
        goto L85
    L82:
        r125 = null;
    L84:
        r121 = null;
    L85:
        if (r121 == null) goto L105;
        r113.element = r121.guid;
        ((LinearLayout) r110.o().findViewById(R.id.set_section_container)).setVisibility(0);
        ((TextView) r110.o().findViewById(R.id.todo_section_txt)).setCompoundDrawables(null, null, UDIconUtils.getIconDrawable(r110.getContext(), R.drawable.ud_icon_down_outlined, com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.icon_n1), new UDDimension.b(14)), null);
        r110.p(r121);
        ((TextView) r110.o().findViewById(R.id.todo_section_txt)).setOnClickListener(new com.ss.android.lark.todo.impl.features.detail.sections.b(r110, r108, r118, r113));
        return;
    L105:
        return;
    L69:
        r120 = null;
    L62:
        r118 = CollectionsKt.emptyList();
    L50:
        r114 = "";
        goto L51
    L104:
        return;
    L42:
        r106 = null;
        goto L43
    L15:
        TodoData r126 = r110.e().getTodoDataLiveData().getValue();
        if (r126 == null) goto L18;
        TaskMode r127 = r126.getMode();
    L20:
        if (r127 != TaskMode.TASK_COMPLETE) goto L22;
        boolean r128 = true;
    L23:
        if (r128 == false) goto L25;
        ((TextView) r110.o().findViewById(R.id.avatar_text)).setText(UIHelper.getQuantityString(R.plurals.Todo_NumTaskOwners_ICU, r100));
        goto L36
    L25:
        ArrayList r129 = new ArrayList();
        Iterator r130 = r111.iterator();
    L27:
        if (r130.hasNext() == false) goto L34;
        Object r131 = r130.next();
        if (((AssigneeBean) r131).getCompletedMilliTime() <= 0) goto L31;
        boolean r132 = true;
    L32:
        if (r132 == false) goto L27;
        r129.add(r131);
        goto L27
    L31:
        r132 = false;
        goto L32
    L34:
        int r133 = r129.size();
        TextView r134 = (TextView) r110.o().findViewById(R.id.avatar_text);
        String r135 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_MultiOwners_CompleteRatio_Text);
        StringBuilder r136 = new StringBuilder();
        r136.append(r133);
        r136.append('/');
        r136.append(r100);
        r134.setText(ICUUtils.icuFormat(r135, MapBundleKey.OfflineMapKey.OFFLINE_RATION, r136.toString()));
        goto L36
    L22:
        r128 = false;
        goto L23
    L18:
        r127 = null;
        goto L20
    L7:
        r101 = r111;
        goto L8
    L35:
        ((TextView) r110.f443118b.findViewById(R.id.text_add_assignee)).setVisibility(0);
        ((LinearLayout) r110.f443118b.findViewById(R.id.detail_assignee_container)).setClickable(true);
        r110.o().setVisibility(8);
        goto L36
    }

    public AssigneeSection(View r100, View r101, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r102) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "revokeView");
        Intrinsics.checkNotNullParameter(r102, "viewAbility");
        super(r102);
        this.f443118b = r100;
        this.f443119c = r101;
        this.f443120d = LazyKt.lazy(new AssigneeSection$layoutAssignee$2(this));
        this.f443121e = TodoDependencyHolder.a().loginDependency().getUserId();
        ((TextView) r100.findViewById(R.id.text_add_assignee)).setText(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_TaskDetails_AddAnOwner_Button));
        ((AppCompatImageView) r100.findViewById(R.id.icon_assignee)).setImageResource(R.drawable.ud_icon_member_outlined);
        this.f443122f = 3000;
        this.f443124h = LazyKt.lazy(AssigneeSection$handler$2.INSTANCE);
        this.f443125i = LazyKt.lazy(new AssigneeSection$dismissRevokeRunnable$2(this));
    }
}
