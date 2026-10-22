package com.ss.android.lark.todo.impl.features.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.lark.pb.basic.v1.Command;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.setting.widget.TodoSwitchView;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 K2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020/H\u0016J&\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u001a\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020:2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010C\u001a\u00020/H\u0002J\b\u0010D\u001a\u00020/H\u0016J\b\u0010E\u001a\u00020/H\u0002J\b\u0010F\u001a\u00020/H\u0002J\b\u0010G\u001a\u00020/H\u0002J\b\u0010H\u001a\u00020/H\u0002J\b\u0010I\u001a\u00020/H\u0002J\b\u0010J\u001a\u00020/H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001e\u0010\"\u001a\u0004\u0018\u00010#8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001e\u0010+\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b3\u00104R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/setting/TodoBadgeSettingFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "llOwnedUnfinishedFromXml", "Landroid/widget/LinearLayout;", "getLlOwnedUnfinishedFromXml", "()Landroid/widget/LinearLayout;", "setLlOwnedUnfinishedFromXml", "(Landroid/widget/LinearLayout;)V", "titleBarFromXml", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getTitleBarFromXml", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setTitleBarFromXml", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "badgeSwitchViewFromXml", "Lcom/ss/android/lark/todo/impl/features/setting/widget/TodoSwitchView;", "getBadgeSwitchViewFromXml", "()Lcom/ss/android/lark/todo/impl/features/setting/widget/TodoSwitchView;", "setBadgeSwitchViewFromXml", "(Lcom/ss/android/lark/todo/impl/features/setting/widget/TodoSwitchView;)V", "llOverdueFromXml", "getLlOverdueFromXml", "setLlOverdueFromXml", "imageOverdueCheckedFromXml", "Landroid/widget/ImageView;", "getImageOverdueCheckedFromXml", "()Landroid/widget/ImageView;", "setImageOverdueCheckedFromXml", "(Landroid/widget/ImageView;)V", "imageOverdueTodayCheckedFromXml", "getImageOverdueTodayCheckedFromXml", "setImageOverdueTodayCheckedFromXml", "imageOwnedUnfinishedCheckedFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getImageOwnedUnfinishedCheckedFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setImageOwnedUnfinishedCheckedFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "llOverdueTodayFromXml", "getLlOverdueTodayFromXml", "setLlOverdueTodayFromXml", "llBadgeTypeContainerFromXml", "getLlBadgeTypeContainerFromXml", "setLlBadgeTypeContainerFromXml", "clearFromXmlViewCache", "", "onDestroyView", "mViewModel", "Lcom/ss/android/lark/todo/impl/features/setting/TodoBadgeSettingViewModel;", "getMViewModel", "()Lcom/ss/android/lark/todo/impl/features/setting/TodoBadgeSettingViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mTodoSettingNotification", "Lcom/ss/android/lark/todo/impl/rustadapter/push/TodoPushHandleCallBack;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", LiveCommonConstants.REASON_ON_DEDTROY, "registerTodoSettingPush", "unRegisterTodoSettingPush", "initTitleBar", "initListener", "initOperationToast", "bindSettingItemLv", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TodoBadgeSettingFragment extends BaseFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f443955o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f443956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CommonTitleBar f443957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TodoSwitchView f443958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f443959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f443960h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f443961i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AppCompatImageView f443962j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f443963k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f443964l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f443965m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public h f443966n;

    public static final class a {
    }

    static {
    }

    public final ImageView S90() {
        View r100 = this.f443960h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.image_overdue_checked);
    L8:
        this.f443960h = (ImageView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (ImageView) r100;
    }

    public final ImageView T90() {
        View r100 = this.f443961i;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.image_overdue_today_checked);
    L8:
        this.f443961i = (ImageView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (ImageView) r100;
    }

    public final AppCompatImageView U90() {
        View r100 = this.f443962j;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.image_owned_unfinished_checked);
    L8:
        this.f443962j = (AppCompatImageView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (AppCompatImageView) r100;
    }

    public final TodoBadgeSettingViewModel V90() {
        return (TodoBadgeSettingViewModel) this.f443965m.getValue();
    }

    public final CommonTitleBar W90() {
        View r100 = this.f443957e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.title_bar);
    L8:
        this.f443957e = (CommonTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CommonTitleBar) r100;
    }

    public TodoBadgeSettingFragment() {
        final Function0<Fragment> r100 = new TodoBadgeSettingFragment$special$$inlined$viewModels$default$1(this);
        this.f443965m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TodoBadgeSettingViewModel.class), new TodoBadgeSettingFragment$special$$inlined$viewModels$default$2(r100), new TodoBadgeSettingFragment$special$$inlined$viewModels$default$3(r100, this));
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        h r100 = this.f443966n;
        if (r100 == null) goto L6;
        com.ss.android.lark.todo.impl.rustadapter.push.c.f444233a.b(Command.PUSH_TODO_SETTING_CHANGE_NOTIFICATION, r100);
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f443956d = null;
        this.f443957e = null;
        this.f443958f = null;
        this.f443959g = null;
        this.f443960h = null;
        this.f443961i = null;
        this.f443962j = null;
        this.f443963k = null;
        this.f443964l = null;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        W90().setLeftClickListener(new g(this));
        W90().setLeftImageResource(CommonTitleBarConstants.ICON_BACK);
        W90().setTitle(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Settings_BadgeCountTitle));
        View r102 = this.f443956d;
        if (r102 != null) goto L9;
        View r103 = getView();
        if (r103 == null) goto L7;
        r102 = r103.findViewById(R.id.ll_owned_unfinished);
    L8:
        this.f443956d = (LinearLayout) r102;
        goto L9
    L7:
        r102 = null;
    L9:
        com.larksuite.framework.section.utils.a.d((LinearLayout) r102, TodoDependencyHolder.b().f2210a.a("todo.red_bot_owned_unfinish", false));
        View r104 = this.f443958f;
        if (r104 != null) goto L16;
        View r105 = getView();
        if (r105 == null) goto L14;
        r104 = r105.findViewById(R.id.badgeSwitchView);
    L15:
        this.f443958f = (TodoSwitchView) r104;
        goto L16
    L14:
        r104 = null;
    L16:
        ((TodoSwitchView) r104).setOnStateChangedListener(new b(this));
        View r106 = this.f443959g;
        if (r106 != null) goto L23;
        View r107 = getView();
        if (r107 == null) goto L21;
        r106 = r107.findViewById(R.id.ll_overdue);
    L22:
        this.f443959g = (LinearLayout) r106;
        goto L23
    L21:
        r106 = null;
    L23:
        ((LinearLayout) r106).setOnClickListener(new c(this));
        View r108 = this.f443963k;
        if (r108 != null) goto L30;
        View r109 = getView();
        if (r109 == null) goto L28;
        r108 = r109.findViewById(R.id.ll_overdue_today);
    L29:
        this.f443963k = (LinearLayout) r108;
        goto L30
    L28:
        r108 = null;
    L30:
        ((LinearLayout) r108).setOnClickListener(new d(this));
        View r110 = this.f443956d;
        if (r110 != null) goto L37;
        View r111 = getView();
        if (r111 == null) goto L35;
        r110 = r111.findViewById(R.id.ll_owned_unfinished);
    L36:
        this.f443956d = (LinearLayout) r110;
        goto L37
    L35:
        r110 = null;
    L37:
        ((LinearLayout) r110).setOnClickListener(new e(this));
        V90().getBadgeSettingShowLv().observe(this, new com.ss.android.lark.todo.impl.features.setting.a(this));
        V90().getErrorToastLv().observe(this, new f(this));
        V90().initSettingData();
        this.f443966n = new h(this);
        com.ss.android.lark.todo.impl.rustadapter.push.c.f444233a.a(Command.PUSH_TODO_SETTING_CHANGE_NOTIFICATION, this.f443966n);
        a9c.b.b(a9c.b.f2313a, "setting_todo_badge_view", null, 6);
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.todo_badge_setting, r101, false);
    }
}
