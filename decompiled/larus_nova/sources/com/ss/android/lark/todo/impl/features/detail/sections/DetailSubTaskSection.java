package com.ss.android.lark.todo.impl.features.detail.sections;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.todo.v1.Progress;
import com.bytedance.lark.pb.todo.v1.SimpleTodo;
import com.larksuite.component.blockit.hashtag.widget.SwipeLayout;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.forsetiutils.BizType;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.todo.impl.features.detail.TodoDetailFragment;
import com.ss.android.lark.todo.impl.features.detail.at.TodoAtController;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.SubTaskLoadingStatus;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoData;
import com.ss.android.lark.utils.UIHelper;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class DetailSubTaskSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f443205k = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f443206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f443207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f443208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DetailSubTaskAdapter f443209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f443210f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EditText f443211g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TodoAtController f443212h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f443213i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q0 f443214j;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f443215a = null;

        static {
            int[] r100 = new int[SubTaskLoadingStatus.values().length];
            r100[SubTaskLoadingStatus.LOADING_SUCCESS_ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[SubTaskLoadingStatus.LOADING_SUCCESS_NEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[SubTaskLoadingStatus.LOADING_PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[SubTaskLoadingStatus.LOADING_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f443215a = r100;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetailSubTaskSection f443216a;

        public c(DetailSubTaskSection r100) {
            this.f443216a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DetailSubTaskSection r101 = this.f443216a;
            long r102 = r101.f443213i;
            r101.f443213i = System.currentTimeMillis();
            DetailSubTaskSection r103 = this.f443216a;
            if ((r103.f443213i - r102) >= 500) goto L6;
            return;
        L6:
            if (r103.f443211g.getEditableText().length() != 0) goto L8;
            boolean r104 = true;
        L9:
            if (r104 == false) goto L11;
            this.f443216a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.x2.f443793a);
            return;
        L11:
            this.f443216a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.i.f443710a);
            return;
        L8:
            r104 = false;
            goto L9
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetailSubTaskSection f443217a;

        public d(DetailSubTaskSection r100) {
            this.f443217a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DetailSubTaskSection r101 = this.f443217a;
            long r102 = r101.f443213i;
            r101.f443213i = System.currentTimeMillis();
            DetailSubTaskSection r103 = this.f443217a;
            if ((r103.f443213i - r102) >= 500) goto L6;
            return;
        L6:
            if (r103.f443211g.getEditableText().length() != 0) goto L8;
            boolean r104 = true;
        L9:
            if (r104 == false) goto L11;
            this.f443217a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.x2.f443793a);
            return;
        L11:
            this.f443217a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.o.f443745a);
            return;
        L8:
            r104 = false;
            goto L9
        }
    }

    public static final class e implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetailSubTaskSection f443218a;

        public e(DetailSubTaskSection r100) {
            this.f443218a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            this.f443218a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.h.f443704a);
            return false;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetailSubTaskSection f443219a;

        public f(DetailSubTaskSection r100) {
            this.f443219a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f443219a.f443207c.findViewById(R.id.text_add_subtask).getVisibility() != 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L9;
            this.f443219a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.j.f443716a);
            return;
        L9:
            return;
        L5:
            r101 = false;
            goto L6
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetailSubTaskSection f443220a;

        public g(DetailSubTaskSection r100) {
            this.f443220a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f443220a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.j.f443716a);
        }
    }

    public static final class h implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetailSubTaskSection f443221a;

        public h(DetailSubTaskSection r100) {
            this.f443221a = r100;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            if (r101 == 5) goto L8;
            if (r101 == 6) goto L8;
        L13:
            return true;
        L8:
            if (this.f443221a.f443211g.getEditableText().length() <= 0) goto L10;
            boolean r103 = true;
        L11:
            if (r103 == false) goto L13;
            this.f443221a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.r0.f443761a);
            DetailSubTaskSection.n(this.f443221a);
            goto L13
        L10:
            r103 = false;
            goto L11
        }
    }

    public static final class i implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetailSubTaskSection f443222a;

        public i(DetailSubTaskSection r100) {
            this.f443222a = r100;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r100, int r101, KeyEvent r102) {
            boolean r103 = true;
            if (r102 != null) goto L5;
        L7:
            boolean r104 = false;
        L8:
            if (r104 == true) goto L10;
        L19:
            return false;
        L10:
            if (r101 != 67) goto L19;
            if (this.f443222a.f443211g.getEditableText().length() == 0) goto L15;
            r103 = false;
        L15:
            if (r103 == false) goto L19;
            if (this.f443222a.f443208d.findViewById(R.id.edit_subtask_container).getVisibility() != 0) goto L19;
            this.f443222a.b().e(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.e2.f443689a, false);
            goto L19
        L5:
            if (r102.getAction() != 0) goto L7;
            r104 = true;
            goto L8
        }
    }

    public static final class j extends com.ss.android.lark.utils.q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetailSubTaskSection f443224a;

        public j(DetailSubTaskSection r100) {
            this.f443224a = r100;
        }

        @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            this.f443224a.b().d(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.p.f443750a, com.ss.android.lark.todo.impl.features.common.richtext2.b.a(this.f443224a.f443211g));
        }
    }

    public static final class k implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetailSubTaskSection f443225a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DetailSubTaskSection f443226a;

            public a(DetailSubTaskSection r100) {
                this.f443226a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DetailSubTaskSection r100 = this.f443226a;     // Catch: Throwable -> L13
                Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
                if (ForsetiFGHelpers.e() == true) goto L6;
            L8:
                KeyboardUtils.showKeyboard(r100.f443211g);     // Catch: Throwable -> L10
                Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
            L18:
                return;
            L6:
                if (r100.f443206b.isResumed() == true) goto L8;
            L10:
                th = move-exception;
                Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
                Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L23;
                throw th;
            }
        }

        public k(DetailSubTaskSection r100) {
            this.f443225a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (this.f443225a.f443208d.findViewById(R.id.edit_subtask_container).getVisibility() != 8) goto L5;
            return;
        L5:
            if (r101 == false) goto L7;
            return;
        L7:
            if (Intrinsics.areEqual(this.f443225a.e().isInAddSubTask().getValue(), Boolean.TRUE) == false) goto L14;
            Lazy r102 = ForsetiFGHelpers.f424763a;
            if (ForsetiFGHelpers.c(BizType.MEEGO, "fix_show_keyboard_bug") == false) goto L11;
            DetailSubTaskSection r103 = this.f443225a;
            r103.f443211g.postDelayed(new a(r103), 16);
            return;
        L11:
            KeyboardUtils.showKeyboard(this.f443225a.f443211g);
            return;
        L14:
            if (this.f443225a.f443211g.getEditableText().length() <= 0) goto L16;
            boolean r104 = true;
        L17:
            if (r104 == false) goto L19;
            this.f443225a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.r0.f443761a);
            DetailSubTaskSection.n(this.f443225a);
        L19:
            KeyboardUtils.hideKeyboard(this.f443225a.f443211g.getContext(), this.f443225a.f443211g);
            return;
        L16:
            r104 = false;
            goto L17
        }
    }

    public static final class l implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetailSubTaskSection f443227a;

        public l(DetailSubTaskSection r100) {
            this.f443227a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f443227a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.q.f443755a);
            ((AppCompatImageView) this.f443227a.f443208d.findViewById(R.id.subtask_time_icon)).setVisibility(0);
            ((LinearLayout) this.f443227a.f443208d.findViewById(R.id.subtask_time_container)).setVisibility(8);
        }
    }

    static {
    }

    @Override // com.larksuite.framework.section.h
    public final void i() {
        int r100 = com.ss.android.lark.todo.impl.features.common.richtext2.n.f442477a;
        com.ss.android.lark.todo.impl.features.common.richtext2.n.b(this.f443211g, false, false, false, 30);
        this.f443211g.setSingleLine(true);
        this.f443211g.setImeOptions(5);
        ((SwipeLayout) this.f443208d.findViewById(R.id.subtask_swipelayout)).setSwipeEnabled(false);
        ((AppCompatImageView) this.f443208d.findViewById(R.id.subtask_check_box)).setImageDrawable(y9c.d.e(getContext(), R.drawable.todo_svg_icon_uncheck_new));
        ((AppCompatImageView) this.f443208d.findViewById(R.id.subtask_check_box)).setScaleType(ImageView.ScaleType.CENTER);
        ((LinearLayout) this.f443207c.findViewById(R.id.progress_add_container)).setOnClickListener(new f(this));
        ((LinearLayout) this.f443208d.findViewById(R.id.add_subtask_container)).setOnClickListener(new g(this));
        this.f443211g.setOnEditorActionListener(new h(this));
        this.f443211g.setOnKeyListener(new i(this));
        this.f443211g.addTextChangedListener(new j(this));
        this.f443211g.setOnFocusChangeListener(new k(this));
        ViewGroup.LayoutParams r101 = ((AppCompatImageView) this.f443208d.findViewById(R.id.subtask_time_icon)).getLayoutParams();
        r101.width = com.ss.android.lark.todo.impl.utils.m.a(32);
        r101.height = com.ss.android.lark.todo.impl.utils.m.a(32);
        ((AppCompatImageView) this.f443208d.findViewById(R.id.subtask_time_icon)).setOnClickListener(this.f443214j);
        ((LinearLayout) this.f443208d.findViewById(R.id.subtask_time_container)).setOnClickListener(this.f443214j);
        com.ss.android.lark.todo.impl.utils.b.a(this.f443208d.findViewById(R.id.subtask_time_delete_icon), com.ss.android.lark.todo.impl.utils.m.a(4));
        ((ImageView) this.f443208d.findViewById(R.id.subtask_time_delete_icon)).setOnClickListener(new l(this));
        ViewGroup.LayoutParams r102 = ((AppCompatImageView) this.f443208d.findViewById(R.id.subtask_owner_icon)).getLayoutParams();
        r102.width = com.ss.android.lark.todo.impl.utils.m.a(32);
        r102.height = com.ss.android.lark.todo.impl.utils.m.a(32);
        ((AppCompatImageView) this.f443208d.findViewById(R.id.subtask_owner_icon)).setOnClickListener(new c(this));
        ((LinearLayout) this.f443208d.findViewById(R.id.subtask_owner_avatar_container)).setOnClickListener(new d(this));
        View r103 = this.f443208d.findViewById(R.id.subtask_show_more_tv);
        com.larksuite.framework.section.c r104 = b();
        com.ss.android.lark.todo.impl.features.detail.viewmodel.a.a3 r105 = com.ss.android.lark.todo.impl.features.detail.viewmodel.a.a3.f443666a;
        com.larksuite.framework.section.utils.a.a(r103, r104, r105);
        com.larksuite.framework.section.utils.a.a(this.f443208d.findViewById(R.id.subtasks_loading_failed_container), b(), r105);
        ((FrameLayout) this.f443208d.findViewById(R.id.subtasks_load_container)).setOnTouchListener(new e(this));
    }

    @Override // com.larksuite.framework.section.h
    public final void a() {
        b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.r0.f443761a);
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        final com.ss.android.lark.todo.impl.features.detail.viewmodel.p r100 = e();
        k(r100.getSubTaskProgress(), new DetailSubTaskSection$initViewObserver$1$1(this));
        k(r100.getAddSubTaskTimeInfo(), new DetailSubTaskSection$initViewObserver$1$2(this));
        k(r100.getAddSubTaskOwnerInfo(), new DetailSubTaskSection$initViewObserver$1$3(this));
        k(r100.getAddSubTaskRequestFocus(), new DetailSubTaskSection$initViewObserver$1$4(this, r100));
        k(r100.isInAddSubTask(), new DetailSubTaskSection$initViewObserver$1$5(this));
        k(r100.getInitAtController(), new DetailSubTaskSection$initViewObserver$1$6(this));
        k(r100.getAddSubTaskSelectAtChatter(), new DetailSubTaskSection$initViewObserver$1$7(this));
        k(r100.getSubTaskLoadingStatus(), new DetailSubTaskSection$initViewObserver$1$8(this));
        k(r100.getNeedUpdate(), new DetailSubTaskSection$initViewObserver$1$9(this, r100));
        k(r100.getAddSubTaskSummary(), new DetailSubTaskSection$initViewObserver$1$10(this));
        k(r100.isSubTaskEditEnable(), new DetailSubTaskSection$initViewObserver$1$11(this));
    }

    public static final void n(DetailSubTaskSection r100) {
        r100.f443211g.getEditableText().clear();
        ((AppCompatImageView) r100.f443208d.findViewById(R.id.subtask_time_icon)).setVisibility(0);
        ((AppCompatImageView) r100.f443208d.findViewById(R.id.subtask_owner_icon)).setVisibility(0);
        ((LinearLayout) r100.f443208d.findViewById(R.id.subtask_owner_avatar_container)).setVisibility(8);
        ((LinearLayout) r100.f443208d.findViewById(R.id.subtask_time_container)).setVisibility(8);
        r100.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.y.f443795a);
    }

    @Override // com.larksuite.framework.section.h
    public final void f(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(r100, com.ss.android.lark.todo.impl.features.detail.viewmodel.a.y2.f443798a) == false) goto L6;
        this.f443209e.y2();
        return;
    }

    public static final void o(DetailSubTaskSection r110, Progress r111, boolean r112) {
        r110.getClass();
        int r100 = UIHelper.dp2px(14.0f);
        int r101 = UIHelper.dp2px(8.0f);
        boolean r102 = false;
        if (r111 == null) goto L7;
        Integer r103 = r111.total;
        if (r103 == null) goto L7;
        int r104 = r103.intValue();
    L8:
        int r105 = r104 + (r112 ? 1 : 0);
        if (r105 != 0) goto L20;
        com.larksuite.framework.section.utils.a.d(r110.f443208d, false);
        ((TextView) r110.f443207c.findViewById(R.id.text_add_subtask)).setVisibility(0);
        ((TextView) r110.f443207c.findViewById(R.id.text_progress)).setVisibility(8);
        ((UDProgress) r110.f443207c.findViewById(R.id.subtask_progress)).setVisibility(8);
        ((LinearLayout) r110.f443207c.findViewById(R.id.progress_add_container)).setPadding(0, r100, 0, r100);
        LinearLayout r113 = (LinearLayout) r110.f443207c.findViewById(R.id.progress_add_container);
        TodoData r114 = r110.e().getTodoDataLiveData().getValue();
        if (r114 == null) goto L15;
        Map<String, SimpleTodo> r115 = r114.getAncestors();
        if (r115 == null) goto L15;
        int r116 = r115.size();
    L17:
        if (r116 >= 4) goto L19;
        r102 = true;
    L19:
        r113.setClickable(r102);
        return;
    L15:
        r116 = 0;
        goto L17
    L20:
        com.larksuite.framework.section.utils.a.d(r110.f443208d, true);
        ((TextView) r110.f443207c.findViewById(R.id.text_add_subtask)).setVisibility(8);
        ((TextView) r110.f443207c.findViewById(R.id.text_progress)).setVisibility(0);
        ((UDProgress) r110.f443207c.findViewById(R.id.subtask_progress)).setVisibility(0);
        TextView r106 = (TextView) r110.f443207c.findViewById(R.id.text_progress);
        StringBuilder r107 = new StringBuilder();
        if (r111 == null) goto L25;
        Integer r108 = r111.completed;
        if (r108 == null) goto L25;
        int r109 = r108.intValue();
    L26:
        r107.append(r109);
        r107.append('/');
        r107.append(r105);
        r106.setText(r107.toString());
        UDProgress r117 = (UDProgress) r110.f443207c.findViewById(R.id.subtask_progress);
        if (r111 == null) goto L31;
        Integer r118 = r111.completed;
        if (r118 == null) goto L31;
        int r119 = r118.intValue();
    L32:
        r117.setProgress((r119 * 100) / r105);
        ((LinearLayout) r110.f443207c.findViewById(R.id.progress_add_container)).setPadding(0, r100, 0, r101);
        ((LinearLayout) r110.f443207c.findViewById(R.id.progress_add_container)).setClickable(false);
        if (r112 == false) goto L35;
        return;
    L35:
        if (Intrinsics.areEqual(r110.e().isSubTaskEditEnable().getValue(), Boolean.TRUE) == false) goto L40;
        ((LinearLayout) r110.f443208d.findViewById(R.id.add_subtask_container)).setVisibility(0);
        return;
    L40:
        return;
    L31:
        r119 = 0;
    L25:
        r109 = 0;
    L7:
        r104 = 0;
        goto L8
    }

    public DetailSubTaskSection(TodoDetailFragment r100, View r101, View r102, DetailSubTaskAdapter r103, FrameLayout r104, com.larksuite.framework.section.e r105) {
        Intrinsics.checkNotNullParameter(r100, "containerFragment");
        Intrinsics.checkNotNullParameter(r101, "progressView");
        Intrinsics.checkNotNullParameter(r102, "addView");
        Intrinsics.checkNotNullParameter(r103, "adapter");
        Intrinsics.checkNotNullParameter(r104, "atContainerView");
        Intrinsics.checkNotNullParameter(r105, "viewAbility");
        super(r105);
        this.f443206b = r100;
        this.f443207c = r101;
        this.f443208d = r102;
        this.f443209e = r103;
        this.f443210f = r104;
        this.f443211g = (EditText) r102.findViewById(R.id.todo_detail_subtask_summary);
        this.f443214j = new q0(this);
    }
}
