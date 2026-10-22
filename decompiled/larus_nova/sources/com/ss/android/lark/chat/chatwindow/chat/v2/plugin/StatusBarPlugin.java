package com.ss.android.lark.chat.chatwindow.chat.v2.plugin;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes35.dex */
public final class StatusBarPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c f414445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ITitlebarComponent f414446h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IKeyboardComponent f414447i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f414448j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f414449k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BottomSheetViewModel f414450l;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f414451a = null;

        static {
            int[] r100 = new int[TitleTheme.ThemeType.values().length];
            r100[TitleTheme.ThemeType.DARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TitleTheme.ThemeType.LIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f414451a = r100;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        if (this.f414446h != null) goto L7;
        super.D();
        return;
    L7:
        throw null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        super.C(r100, r101);
        this.f414445g = r100;
        Chat r102 = r101.f488506f;
        this.f414448j = r100.getFragment().getActivity() instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.b;
        final BaseFragment r103 = B();
        this.f414450l = (BottomSheetViewModel) FragmentViewModelLazyKt.createViewModelLazy(r103, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new StatusBarPlugin$onCreate$$inlined$activityViewModels$default$1(r103), new StatusBarPlugin$onCreate$$inlined$activityViewModels$default$2(r103)).getValue();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r104 = this.f414445g;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r105 = null;
        if (r104 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r104 = null;
    L6:
        if (r104.u().D() == true) goto L8;
        F(TitleTheme.ThemeType.LIGHT, null);
    L9:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r106 = this.f414445g;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r106 = null;
    L12:
        this.f414446h = (ITitlebarComponent) r106.a(ITitlebarComponent.class);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r107 = this.f414445g;
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r107 = null;
    L15:
        final IKeyboardComponent r108 = (IKeyboardComponent) r107.a(IKeyboardComponent.class);
        this.f414447i = r108;
        if (this.f414446h != null) goto L30;
        if (r108 == null) goto L19;
        r108.m7(new StatusBarPlugin$onCreate$1$1(r108, this));
    L19:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r109 = this.f414445g;
        if (r109 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r109 = null;
    L22:
        Fragment r110 = r109.getFragment();
        if (r110 == null) goto L31;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r111 = this.f414445g;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
    L28:
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(r105.getViewModel(ChatWindowOpenViewModel.class).getInitializeStateLiveData(), r110.getViewLifecycleOwner(), new d(r110, this));
        return;
    L27:
        r105 = r111;
        goto L28
    L31:
        return;
    L30:
        throw null;
    L8:
        this.f414449k = 1;
        goto L9
    }

    public final void F(TitleTheme.ThemeType r100, Integer r101) {
        Context r102 = getContext();
        if ((r102 instanceof Activity) == true) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        int r103 = r101.intValue();
    L14:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r104 = this.f414445g;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r104 = null;
    L17:
        Fragment r105 = r104.getFragment();
        if (this.f414448j == true) goto L20;
        f r106 = WindowInsetsUtils.b(r105);
        r106.k(true);
        r106.b(r103);
        return;
    L20:
        BottomSheetViewModel r107 = this.f414450l;
        if (r107 == null) goto L26;
        r107.triggerStatusColorChange(new BottomSheetViewModel.b(r103));
        return;
    L26:
        return;
    L7:
        int r108 = b.f414451a[r100.ordinal()];
        if (r108 != 1) goto L10;
        r103 = UIUtils.getColor(r102, 0);
        goto L14
    L10:
        if (r108 == 2) goto L12;
        r103 = UIUtils.getColor(r102, 0);
        goto L14
    L12:
        r103 = UIUtils.getColor(r102, 0);
        goto L14
    }
}
