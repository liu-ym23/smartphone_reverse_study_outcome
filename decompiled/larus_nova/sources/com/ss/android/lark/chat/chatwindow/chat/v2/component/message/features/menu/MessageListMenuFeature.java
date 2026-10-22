package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu;

import android.content.Intent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.SwipeActionHandler;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.SwipeActionItemDecoration;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.message.menu.v2.MessageActionPanelManager;
import com.ss.android.lark.chat.message.menu.v2.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import t6b.g;

/* JADX INFO: loaded from: classes35.dex */
public final class MessageListMenuFeature implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f413846h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f413847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b f413848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s2b.c f413849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f413850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.ss.android.lark.biz.im.api.extension.chat_window.g<Object>> f413851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f413852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f413853g;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onActivityResult(int r100, int r101, Intent r102) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onDestroy() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onResume() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStart() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStop() {
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a m() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r100 = this.f413848b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r100 = null;
    L6:
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a) r100.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a.class);
    }

    public MessageListMenuFeature(g r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        this.f413847a = r100;
        this.f413850d = true;
        this.f413851e = new CopyOnWriteArrayList();
        this.f413853g = LazyKt.lazy(new MessageListMenuFeature$menuHandlerHub$2(this));
    }

    public static final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a l(MessageListMenuFeature r100) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r101 = r100.f413848b;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r101 = null;
    L6:
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a) r101.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a
    public final void D6(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f413852f = r100;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r110) {
        Intrinsics.checkNotNullParameter(r110, "initData");
        Intrinsics.checkNotNullParameter(r110, "initData");
        RecyclerView r100 = this.f413852f;
        boolean r101 = true;
        if (r100 != null) goto L5;
        Log.e("MessageListMenuFeature", "recyclerView not set");
    L20:
        if (this.f413847a.g() == false) goto L58;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r102 = this.f413848b;
        if (r102 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r102 = null;
    L25:
        s2b.d r111 = r102.a();
        if (r111 == null) goto L59;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r103 = this.f413848b;
        if (r103 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r103 = null;
    L31:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r104 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) r103.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
        if (r104 == null) goto L57;
        SceneCoordinateRecyclerView r105 = r104.getRecyclerView();
        if (r105 == null) goto L60;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.f r106 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.f(r111, new d(this));
        SwipeActionHandler r107 = new SwipeActionHandler(r111, r111.f540334c.C(), new c(this), new e(this), new f(this), r106);
        Intrinsics.checkNotNullParameter(r105, "recyclerView");
        RecyclerView r108 = r107.f414182j;
        if (r108 == null) goto L42;
        r108.removeOnItemTouchListener(r107.f414187o);
        SwipeActionItemDecoration r109 = r107.f414188p;
        if (r109 == null) goto L41;
        r108.removeItemDecoration(r109);
    L41:
        r108.removeOnChildAttachStateChangeListener(r107.f414189q);
    L42:
        r107.f414182j = null;
        jdb.g r112 = r107.f414174b;
        if (r112 != null) goto L45;
    L47:
        r101 = false;
    L48:
        if (r101 == false) goto L61;
        SwipeActionItemDecoration r113 = new SwipeActionItemDecoration(r105, r107.f414185m);
        r107.f414188p = r113;
        r105.addOnItemTouchListener(r107.f414187o);
        r105.addItemDecoration(r113);
        r105.addOnChildAttachStateChangeListener(r107.f414189q);
        r107.f414182j = r105;
        r107.f414183k = ViewConfiguration.get(r105.getContext()).getScaledTouchSlop();
        return;
    L61:
        return;
    L45:
        if (r112.isEnable("messenger.swipe.reply") != true) goto L47;
    L60:
        return;
    L57:
        return;
    L59:
        return;
    L58:
        return;
    L5:
        b r114 = new b(this);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r115 = this.f413848b;
        if (r115 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r115 = null;
    L8:
        v r116 = r115.getContainer();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r117 = this.f413848b;
        if (r117 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r117 = null;
    L11:
        this.f413849c = new s2b.c(r116, r100, r117.a(), (com.ss.android.lark.chat.chatwindow.chat.menu.handler.b) this.f413853g.getValue(), r114, this.f413847a);
        if ((!((CopyOnWriteArrayList) this.f413851e).isEmpty()) == false) goto L20;
        Iterator r118 = ((CopyOnWriteArrayList) this.f413851e).iterator();
    L15:
        if (r118.hasNext() == false) goto L20;
        com.ss.android.lark.biz.im.api.extension.chat_window.g<Object> r119 = (com.ss.android.lark.biz.im.api.extension.chat_window.g) r118.next();
        s2b.c r120 = this.f413849c;
        if (r120 == null) goto L15;
        MessageActionPanelManager<y6b.c<?>> r121 = r120.f540329f;
        r121.getClass();
        Intrinsics.checkNotNullParameter(r119, "interceptor");
        r121.B.add(r119);
        goto L15
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.f413848b = r100;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a
    public final boolean B(y6b.c r100, com.ss.android.lark.chat.message.menu.context.a r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "itemHook");
        s2b.c r102 = this.f413849c;
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r100.K != MessageStreamStatus.Transport) goto L11;
        return true;
    L11:
        return r102.f540329f.e(r100, r101);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a
    public final z D(y6b.c r100, com.ss.android.lark.chat.message.menu.context.a r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "itemHook");
        s2b.c r102 = this.f413849c;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.f540329f.i(r100, r101);
    }

    public final void F(String r100, int r101, PartialReplyInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r103 = m();
        if (r103 == null) goto L26;
        MessageInfo r104 = r103.getMessageInfoById(r100);
        if (r104 == null) goto L26;
        if (r102 == null) goto L13;
        RichText r105 = r102.getContent();
        if (r105 == null) goto L13;
        RichTextExtraInfo r106 = r105.getExtraInfo();
        if (r106 == null) goto L13;
        boolean r107 = Intrinsics.areEqual(r106.isPartialReplySelectTextEmpty(), Boolean.TRUE);
    L14:
        if (r107 == false) goto L17;
        Log.e(TitlebarViewModel.LOG_TAG, "onReplyMessage: isPartialReplySelectTextEmpty is true, stops reply message and returns null");
        return;
    L17:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r108 = this.f413848b;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r108 = null;
    L20:
        IMessageListComponent.e r109 = r108.getDependency();
        if (r109 == null) goto L28;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b r110 = r109.a();
        if (r110 == null) goto L29;
        r110.j(r104, r101, r102);
        return;
    L29:
        return;
    L28:
        return;
    L13:
        r107 = false;
    L26:
        Log.e(TitlebarViewModel.LOG_TAG, "onReEditMessage: get msg by id returns null");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a
    public final void u(y6b.c r100, com.ss.android.lark.chat.message.menu.context.a r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "itemHook");
        Intrinsics.checkNotNullParameter(r102, "messageActionList");
        s2b.c r103 = this.f413849c;
        if (r103 == null) goto L6;
        MessageActionPanelManager<y6b.c<?>> r104 = r103.f540329f;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "itemHook");
        Intrinsics.checkNotNullParameter(r102, "messageActionList");
        r104.h(r100, r101, MessageActionPanelManager.c(r100), r102);
        return;
    }
}
