package com.ss.android.lark.todo.impl.features.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.lark.pb.basic.v1.Command;
import com.larksuite.component.ignition.widget.setting_group.SettingGroupLayout;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.todo.impl.features.setting.widget.TodoReminderPickerMenu;
import com.ss.android.lark.todo.impl.features.setting.widget.TodoSwitchView;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020&H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u0002032\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010<\u001a\u00020&H\u0002J\b\u0010=\u001a\u00020&H\u0016J\b\u0010>\u001a\u00020&H\u0002J\b\u0010?\u001a\u00020&H\u0002J\b\u0010@\u001a\u00020&H\u0002J\b\u0010A\u001a\u00020&H\u0002J\b\u0010B\u001a\u00020&H\u0002J\b\u0010C\u001a\u00020&H\u0002J\b\u0010D\u001a\u00020&H\u0002J\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020FJ\b\u0010H\u001a\u00020IH\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/setting/TodoSettingFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "llBadgeContainerFromXml", "Lcom/larksuite/component/ignition/widget/setting_group/SettingGroupLayout;", "getLlBadgeContainerFromXml", "()Lcom/larksuite/component/ignition/widget/setting_group/SettingGroupLayout;", "setLlBadgeContainerFromXml", "(Lcom/larksuite/component/ignition/widget/setting_group/SettingGroupLayout;)V", "titleBarFromXml", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getTitleBarFromXml", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setTitleBarFromXml", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "reminderSwitchViewFromXml", "Lcom/ss/android/lark/todo/impl/features/setting/widget/TodoSwitchView;", "getReminderSwitchViewFromXml", "()Lcom/ss/android/lark/todo/impl/features/setting/widget/TodoSwitchView;", "setReminderSwitchViewFromXml", "(Lcom/ss/android/lark/todo/impl/features/setting/widget/TodoSwitchView;)V", "llReminderFromXml", "Landroid/widget/LinearLayout;", "getLlReminderFromXml", "()Landroid/widget/LinearLayout;", "setLlReminderFromXml", "(Landroid/widget/LinearLayout;)V", "tvReminderTimeFromXml", "Landroid/widget/TextView;", "getTvReminderTimeFromXml", "()Landroid/widget/TextView;", "setTvReminderTimeFromXml", "(Landroid/widget/TextView;)V", "tvBadgeSettingFromXml", "getTvBadgeSettingFromXml", "setTvBadgeSettingFromXml", "clearFromXmlViewCache", "", "onDestroyView", "mViewModel", "Lcom/ss/android/lark/todo/impl/features/setting/TodoSettingViewModel;", "getMViewModel", "()Lcom/ss/android/lark/todo/impl/features/setting/TodoSettingViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mTodoSettingNotification", "Lcom/ss/android/lark/todo/impl/rustadapter/push/TodoPushHandleCallBack;", "mReminderDialog", "Lcom/ss/android/lark/todo/impl/features/setting/widget/TodoReminderPickerMenu;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", LiveCommonConstants.REASON_ON_DEDTROY, "registerTodoSettingPush", "unRegisterTodoSettingPush", "initTitleBar", "initListener", "initOperationToast", "initReminderDialog", "bindSettingItemLv", "getEnterAnimationConfig", "Lcom/ss/android/lark/base/activity/ActivityAnimationManager$AnimationConfig;", "getExitAnimationConfig", "isStartSettingFromTodoTab", "", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TodoSettingFragment extends BaseFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f443968m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SettingGroupLayout f443969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CommonTitleBar f443970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TodoSwitchView f443971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f443972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f443973h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f443974i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f443975j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public s f443976k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TodoReminderPickerMenu f443977l;

    public static final class a {
    }

    static {
    }

    public final TodoSettingViewModel S90() {
        return (TodoSettingViewModel) this.f443975j.getValue();
    }

    public final CommonTitleBar T90() {
        View r100 = this.f443970e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.title_bar);
    L8:
        this.f443970e = (CommonTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CommonTitleBar) r100;
    }

    public TodoSettingFragment() {
        final Function0<Fragment> r100 = new TodoSettingFragment$special$$inlined$viewModels$default$1(this);
        this.f443975j = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TodoSettingViewModel.class), new TodoSettingFragment$special$$inlined$viewModels$default$2(r100), new TodoSettingFragment$special$$inlined$viewModels$default$3(r100, this));
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        s r100 = this.f443976k;
        if (r100 == null) goto L6;
        com.ss.android.lark.todo.impl.rustadapter.push.c.f444233a.b(Command.PUSH_TODO_SETTING_CHANGE_NOTIFICATION, r100);
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f443969d = null;
        this.f443970e = null;
        this.f443971f = null;
        this.f443972g = null;
        this.f443973h = null;
        this.f443974i = null;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        T90().setLeftClickListener(new q(this));
        CommonTitleBar r102 = T90();
        Bundle r103 = getArguments();
        boolean r104 = false;
        if (r103 == null) goto L5;
        r104 = r103.getBoolean("todo_from_tab", false);
    L5:
        if (r104 == false) goto L7;
        int r105 = CommonTitleBarConstants.ICON_CLOSE;
    L8:
        r102.setLeftImageResource(r105);
        T90().setTitle(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Task_Tasks));
        View r106 = this.f443969d;
        if (r106 != null) goto L15;
        View r107 = getView();
        if (r107 == null) goto L13;
        r106 = r107.findViewById(R.id.ll_badge_container);
    L14:
        this.f443969d = (SettingGroupLayout) r106;
        goto L15
    L13:
        r106 = null;
    L15:
        ((SettingGroupLayout) r106).setOnClickListener(new r(this));
        Context r108 = getContext();
        if (r108 == null) goto L18;
        this.f443977l = new TodoReminderPickerMenu(r108);
    L18:
        View r109 = this.f443971f;
        if (r109 != null) goto L25;
        View r110 = getView();
        if (r110 == null) goto L23;
        r109 = r110.findViewById(R.id.reminderSwitchView);
    L24:
        this.f443971f = (TodoSwitchView) r109;
        goto L25
    L23:
        r109 = null;
    L25:
        ((TodoSwitchView) r109).setOnStateChangedListener(new m(this));
        View r111 = this.f443972g;
        if (r111 != null) goto L32;
        View r112 = getView();
        if (r112 == null) goto L30;
        r111 = r112.findViewById(R.id.ll_reminder);
    L31:
        this.f443972g = (LinearLayout) r111;
        goto L32
    L30:
        r111 = null;
    L32:
        ((LinearLayout) r111).setOnClickListener(new n(this));
        TodoReminderPickerMenu r113 = this.f443977l;
        if (r113 == null) goto L35;
        o r114 = new o(this);
        Intrinsics.checkNotNullParameter(r114, "actionListener");
        r113.f444002a = r114;
    L35:
        S90().isReminderShowLv().observe(this, new i(this));
        S90().getDefaultReminderLv().observe(this, new j(this));
        S90().getDefaultReminderChosenIndex().observe(this, new k(this));
        S90().getBadgeSettingShowLv().observe(this, new l(this));
        S90().getErrorToastLv().observe(this, new p(this));
        S90().initSettingData();
        this.f443976k = new s(this);
        com.ss.android.lark.todo.impl.rustadapter.push.c.f444233a.a(Command.PUSH_TODO_SETTING_CHANGE_NOTIFICATION, this.f443976k);
        a9c.b.b(a9c.b.f2313a, "setting_todo_view", null, 6);
        return;
    L7:
        r105 = CommonTitleBarConstants.ICON_BACK;
        goto L8
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.todo_bg_setting, r101, false);
    }
}
