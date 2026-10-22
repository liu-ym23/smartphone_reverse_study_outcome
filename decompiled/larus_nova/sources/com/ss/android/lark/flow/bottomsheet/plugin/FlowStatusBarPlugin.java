package com.ss.android.lark.flow.bottomsheet.plugin;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowStatusBarPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c f422004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f422005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f422006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ITitlebarComponent f422007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IKeyboardComponent f422008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f422009l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f422010m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BottomSheetViewModel f422011n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f422012o;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f422013a = null;

        static {
            int[] r100 = new int[TitleTheme.ThemeType.values().length];
            r100[TitleTheme.ThemeType.DARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TitleTheme.ThemeType.LIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f422013a = r100;
        }
    }

    public static final class c implements ChatWindowKeyboard.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowStatusBarPlugin f422014a;

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void d() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void f() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void a() {
            FlowStatusBarPlugin r100 = this.f422014a;
            if (r100.f422009l == true) goto L5;
        L7:
            ITitlebarComponent r101 = r100.f422007j;
            if (r101 == null) goto L10;
            TitleTheme r102 = r101.getTheme();
        L11:
            if (r102 == null) goto L17;
            FlowStatusBarPlugin r103 = this.f422014a;
            Integer r104 = r102.f415367b;
            if (r104 == null) goto L15;
            r103.F(r102.getType(), r104);
            return;
        L15:
            r103.F(r102.getType(), null);
            return;
        L17:
            return;
        L10:
            r102 = null;
            goto L11
        L5:
            if (r100.f422010m == 2) goto L7;
        }

        public c(FlowStatusBarPlugin r100) {
            this.f422014a = r100;
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void g(com.ss.android.lark.keyboard.b r100) {
            Intrinsics.checkNotNullParameter(r100, ObricActionBarTrackType.KEY_BOARD);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        ITitlebarComponent r100 = this.f422007j;
        if (r100 == null) goto L5;
        r100.Yr((ITitlebarComponent.c) this.f422012o.getValue());
    L5:
        super.D();
    }

    public FlowStatusBarPlugin() {
        this.f422005h = R.color.flow_ud_bg_base_1;
        this.f422006i = R.color.bg_tips;
        this.f422010m = 2;
        this.f422012o = LazyKt.lazy(new FlowStatusBarPlugin$themeChangeListener$2(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        super.C(r100, r101);
        this.f422004g = r100;
        Chat r102 = r101.f488506f;
        this.f422009l = r100.getFragment().getActivity() instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.b;
        final BaseFragment r103 = B();
        this.f422011n = (BottomSheetViewModel) FragmentViewModelLazyKt.createViewModelLazy(r103, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new FlowStatusBarPlugin$onCreate$$inlined$activityViewModels$default$1(r103), new FlowStatusBarPlugin$onCreate$$inlined$activityViewModels$default$2(r103)).getValue();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r104 = this.f422004g;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r105 = null;
        if (r104 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r104 = null;
    L6:
        if (r104.u().D() == true) goto L8;
        F(TitleTheme.ThemeType.LIGHT, null);
    L9:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r106 = this.f422004g;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r106 = null;
    L12:
        this.f422007j = (ITitlebarComponent) r106.a(ITitlebarComponent.class);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r107 = this.f422004g;
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r107 = null;
    L15:
        this.f422008k = (IKeyboardComponent) r107.a(IKeyboardComponent.class);
        ITitlebarComponent r108 = this.f422007j;
        if (r108 == null) goto L18;
        r108.PA((ITitlebarComponent.c) this.f422012o.getValue());
    L18:
        IKeyboardComponent r109 = this.f422008k;
        if (r109 == null) goto L21;
        r109.m7(new c(this));
    L21:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r110 = this.f422004g;
        if (r110 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r110 = null;
    L24:
        Fragment r111 = r110.getFragment();
        if (r111 == null) goto L32;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r112 = this.f422004g;
        if (r112 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
    L30:
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(r105.getViewModel(ChatWindowOpenViewModel.class).getInitializeStateLiveData(), r111.getViewLifecycleOwner(), new e(r111, this));
        return;
    L29:
        r105 = r112;
        goto L30
    L32:
        return;
    L8:
        this.f422010m = 1;
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
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r104 = this.f422004g;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r104 = null;
    L17:
        Fragment r105 = r104.getFragment();
        if (this.f422009l == true) goto L20;
        f r106 = WindowInsetsUtils.b(r105);
        r106.k(true);
        r106.b(r103);
        return;
    L20:
        BottomSheetViewModel r107 = this.f422011n;
        if (r107 == null) goto L26;
        r107.triggerStatusColorChange(new BottomSheetViewModel.b(r103));
        return;
    L26:
        return;
    L7:
        int r108 = b.f422013a[r100.ordinal()];
        if (r108 != 1) goto L10;
        r103 = UIUtils.getColor(r102, this.f422006i);
        goto L14
    L10:
        if (r108 == 2) goto L12;
        r103 = UIUtils.getColor(r102, this.f422005h);
        goto L14
    L12:
        r103 = UIUtils.getColor(r102, this.f422005h);
        goto L14
    }
}
