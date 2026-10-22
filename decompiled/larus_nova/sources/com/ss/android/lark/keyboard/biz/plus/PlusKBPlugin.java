package com.ss.android.lark.keyboard.biz.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.lark.pb.basic.v1.Message;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.extension.chat_window.h;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.ComponentType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.keyboard.dependency.KeyboardAssemblerModule;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.PanelMenuItem;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams$IsFullScreen;
import com.ss.android.lark.utils.statistics.PerfLog;
import cya.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class PlusKBPlugin extends PanelMenuItem implements d5b.c, com.ss.android.lark.keyboard.base.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f428486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f428488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f428489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f428490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f428491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<d5b.a> f428492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Unit> f428493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<d5b.c.a> f428494l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f428495m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PanelMenuItem.InitialStrategy f428496n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Set<Object> f428497o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final KeyboardMenuItemKey f428498p;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return R.drawable.kb_more_btn_bg_selector;
    }

    public static void J() {
        ChatHitPointExtraParams$IsFullScreen r100 = ChatHitPointExtraParams$IsFullScreen.FALSE;
        int r101 = xob.a.f564691a;
        Intrinsics.checkNotNullParameter("im_chat_input_plus_view", "keyEvent");
        Intrinsics.checkNotNullParameter(r100, "param");
        Map<String, Object> r102 = ChatParamUtils.e();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L13;
        Statistics.sendEvent("im_chat_input_plus_view", s5c.b.a(r102, r100).toJson());
        return;
    L13:
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void v() {
        Iterator<T> r100 = this.f428494l.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((d5b.c.a) r100.next()).onDestroy();
        goto L4
    }

    public final i H() {
        com.ss.android.lark.keyboard.keyboard2.b r100 = n().L();
        if ((r100 instanceof cya.c) == false) goto L9;
        cya.c r101 = (cya.c) r100;
        if (r101.a().c(2) == true) goto L8;
        return null;
    L8:
        return (i) r101.a().d().f465978a.a(i.f465980h);
    L9:
        return null;
    }

    @Override // d5b.c
    public final PartialReplyInfo c() {
        i r100 = H();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f465987g;
    }

    @Override // d5b.c
    public final String d() {
        i r100 = H();
        if (r100 == null) goto L6;
        String r101 = r100.f465981a;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // d5b.c
    public final Message.PartialReplyInfo f() {
        i r100 = H();
        if (r100 == null) goto L5;
        PartialReplyInfo r101 = r100.f465987g;
    L7:
        return ReplyActionUtils.e(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // d5b.c
    public Activity getActivity() {
        return n().l().getContext();
    }

    @Override // d5b.c
    public final String h() {
        i r100 = H();
        if (r100 == null) goto L6;
        String r101 = r100.f465982b;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // d5b.c
    public final void i() {
        n().H().h();
    }

    @Override // d5b.c
    public final Fragment l() {
        return n().l().f429560d;
    }

    @Override // d5b.c
    public final void m() {
        k.a.a(n().e(), q.a.f429311a);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final Integer q() {
        return Integer.valueOf(R.string.test_kb_plugin_plus);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.PanelMenuItem
    public final PanelMenuItem.InitialStrategy C() {
        return this.f428496n;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return this.f428498p;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.o
    public final void A(boolean r100) {
        eya.b r101 = (eya.b) this.f428495m.getValue();
        if (r101 == null) goto L5;
        r101.d7(r100);
    L5:
        View r102 = null;
        if (r100 == false) goto L35;
        this.f428493k.invoke();
        if (this.f428490h == true) goto L22;
        this.f428490h = true;
        View r103 = this.f428488f;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
    L13:
        r102.setSelected(true);
        Iterator<d5b.a> r104 = this.f428492j.iterator();
    L15:
        if (r104.hasNext() == false) goto L17;
        r104.next().c();
        goto L15
    L17:
        Iterator<T> r105 = this.f428494l.iterator();
    L19:
        if (r105.hasNext() == false) goto L21;
        ((d5b.c.a) r105.next()).onStart();
        goto L19
    L21:
        J();
    L43:
        int r106 = xob.a.f564691a;
        Context r107 = this.f428487e.f410096a.requireContext();
        String r108 = this.f428487e.f410098c.getId();
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r108, "chatId");
        xob.a.b(new Pair[]{new Pair("chat_id", r108), new Pair("click", "switch_menu"), new Pair(PickerReporterConstants.KEY.TARGET, "none"), new Pair("keyboard_status", xob.a.a(r107))});
        return;
    L12:
        r102 = r103;
        goto L13
    L22:
        View r109 = this.f428488f;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
    L26:
        r102.setSelected(true);
        Iterator<d5b.a> r110 = this.f428492j.iterator();
    L28:
        if (r110.hasNext() == false) goto L30;
        r110.next().c();
        goto L28
    L30:
        Iterator<T> r111 = this.f428494l.iterator();
    L32:
        if (r111.hasNext() == false) goto L34;
        ((d5b.c.a) r111.next()).a();
        goto L32
    L34:
        J();
        goto L43
    L25:
        r102 = r109;
        goto L26
    L35:
        View r112 = this.f428488f;
        if (r112 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
    L39:
        r102.setSelected(false);
        Iterator<T> r113 = this.f428494l.iterator();
    L41:
        if (r113.hasNext() == false) goto L43;
        ((d5b.c.a) r113.next()).onStop();
        goto L41
    L38:
        r102 = r112;
        goto L39
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.PanelMenuItem
    public final View G(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        CollectionsKt.sortWith(this.f428492j, d.f428503a);
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.kb_plugin_more_assembler, r100, false);
        this.f428491i = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        r101 = null;
    L5:
        this.f428489g = (FrameLayout) r101.findViewById(R.id.more_items_panel_view_group);
        eya.b r102 = (eya.b) this.f428495m.getValue();
        if (r102 == null) goto L22;
        com.ss.android.lark.keyboard.dependency.a r103 = KeyboardAssemblerModule.a();
        Chat r104 = this.f428487e.f410098c;
        FrameLayout r105 = this.f428489g;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mMoreItemsPanel");
        r105 = null;
    L11:
        h r106 = this.f428487e.f410100e;
        if (r106 == null) goto L14;
        ComponentType r107 = r106.f410101a;
    L15:
        eya.a r108 = r103.getLocationPanelItemConfig(r104, this, r105, r107);
        if (r108 == null) goto L18;
        r102.J4(r108);
    L18:
        Map<String, ? extends Object> r109 = ChatParamUtils.a(this.f428487e.f410098c, ChatCoreModule.a().getLoginDependency().getUserId(), this.f428487e.f410099d);
        FrameLayout r110 = this.f428489g;
        if (r110 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mMoreItemsPanel");
        r110 = null;
    L21:
        r102.c7(r110, r109);
        goto L22
    L14:
        r107 = null;
    L22:
        View r111 = this.f428491i;
        if (r111 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    L26:
        return r111;
    }

    @Override // d5b.c
    public final void k(xb5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f428494l.add(r100);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void w(boolean r100) {
        View r101 = this.f428488f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        r101 = null;
    L5:
        r101.setEnabled(r100);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(com.ss.android.lark.keyboard.keyboard2.i r100) {
        Intrinsics.checkNotNullParameter(r100, "iconHolder");
        Intrinsics.checkNotNullParameter(r100, "iconHolder");
        View r101 = r100.f429551a;
        this.f428488f = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        r101 = null;
    L5:
        r101.setActivated(this.f428486d);
    }

    public PlusKBPlugin(boolean r100, com.ss.android.lark.biz.im.api.extension.chat_window.b r101) {
        Intrinsics.checkNotNullParameter(r101, "pluginContext");
        this.f428486d = r100;
        this.f428487e = r101;
        this.f428492j = new ArrayList();
        this.f428493k = PlusKBPlugin$mOnPluginClickListener$1.INSTANCE;
        this.f428494l = new LinkedHashSet();
        this.f428495m = LazyKt.lazy(new PlusKBPlugin$plusExtension$2(this));
        Lazy r102 = ChatCoreModule.f414742a;
        this.f428496n = PanelMenuItem.InitialStrategy.Lazy;
        this.f428497o = new LinkedHashSet();
        this.f428498p = KeyboardMenuItemKey.Plus;
    }

    @Override // com.ss.android.lark.keyboard.base.b
    public final void e(int r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Iterator<T> r102 = this.f428492j.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((d5b.a) r102.next()).a(r101, r100);
        goto L4
    }
}
