package com.ss.android.lark.chat.configurator;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowMessageList;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollAlign;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollEvent;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.biz.im.api.q0;
import com.ss.android.lark.biz.im.api.r0;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.k;
import com.ss.android.lark.log.Log;
import jdb.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import s2b.q;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements ChatWindowMessageList.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IMessageListComponent f414727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f414728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f414729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f414730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f414731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f414732f;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.configurator.a$a, reason: collision with other inner class name */
    public static final class C4845a {
    }

    static {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowMessageList.a
    public final void b() {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowMessageList.a
    public final void a() {
        s2b.d r100 = this.f414727a.W2();
        if (r100 != null) goto L6;
        Log.e("InitialPositionHandler", "messageContext == null");
        return;
    L6:
        int r101 = this.f414728b.invoke().intValue();
        Log.i("InitialPositionHandler", "scroll position:" + r101 + ",size:" + this.f414727a.Tc().getItemCount());
        if (r101 < 0) goto L10;
        Log.i("InitialPositionHandler", "scrollToSpecifiedPosition useNewScroller:" + this.f414732f);
        final q r102 = new q(this.f414727a.Tc(), r101);
        r102.f540409b = this.f414727a.rY().f410454k;
        ScrollScene r103 = ScrollScene.INITIAL_SPECIFIED_POSITION;
        Intrinsics.checkNotNullParameter(r103, "scene");
        Function1<RecyclerView, Integer> r104 = new InitialPositionHandler$scrollToSpecifiedPosition$event$1$1(r102);
        Intrinsics.checkNotNullParameter(r104, "value");
        ScrollAlign r105 = ScrollAlign.CENTER;
        Intrinsics.checkNotNullParameter(r105, "value");
        this.f414727a.Ar().f(new ScrollEvent(r103, r104, null, r105, true, 0, new c(this, r101, r102)));
        return;
    L10:
        Chat r106 = r100.getChat();
        if (k.c(r106) != Chat.MessagePosition.NEWEST_UNREAD) goto L14;
        c();
        return;
    L14:
        if (r106 != null) goto L16;
        Log.e("InitialPositionHandler", "scrollToRecentPosition chat == null");
        return;
    L16:
        int r107 = r106.getRecentReadPosition();
        final Ref.BooleanRef r108 = new Ref.BooleanRef();
        float r109 = r106.getRecentReadOffset();
        final boolean r110 = this.f414730d.isCurrentEnable("im.chat.position.record");
        r0 r111 = this.f414727a.rY().f410457n;
        if (r111 == null) goto L19;
        q0 r112 = r111.a(r106);
    L20:
        if (r112 == null) goto L22;
        int r113 = r112.f410437a;
    L23:
        if (r112 == null) goto L25;
        int r114 = r112.f410438b;
    L26:
        if (r112 == null) goto L29;
        if (r113 > 0) goto L29;
        Log.i("InitialPositionHandler", "scrollToRecentPosition custom position has no unread, scrollToNewestMessage");
        c();
        return;
    L29:
        if (r107 >= 0) goto L35;
        if (r113 <= 0) goto L34;
        if (r110 == true) goto L34;
        Log.i("InitialPositionHandler", "scrollToRecentPosition position unreadReadBadgeCount > 0");
        r108.element = true;
        r109 = 2.1474836E9f;
        r107 = r114;
    L34:
        Log.i("InitialPositionHandler", "scrollToRecentPosition position unreadReadBadgeCount <= 0 and fg: " + r110 + ", scrollToNewestMessage");
        c();
        return;
    L35:
        Log.i("InitialPositionHandler", "scrollToRecentPosition position:" + r107 + ",offset:" + r109);
        final q r115 = new q(this.f414727a.Tc(), r107);
        r115.f540409b = this.f414727a.rY().f410454k;
        com.ss.android.lark.biz.im.api.extension.scroll.d r116 = new com.ss.android.lark.biz.im.api.extension.scroll.d(ScrollScene.INITIAL_PREVIOUS_POSITION);
        Function1<RecyclerView, Integer> r117 = new InitialPositionHandler$scrollToRecentRead$event$1$1(r110, r115, r108);
        Intrinsics.checkNotNullParameter(r117, "value");
        r116.f410235b = r117;
        r116.b((int) r109);
        ScrollAlign r118 = ScrollAlign.TOP;
        Intrinsics.checkNotNullParameter(r118, "value");
        r116.f410237d = r118;
        r116.f410240g = new b(this);
        this.f414727a.Ar().f(r116.a());
        return;
    L25:
        r114 = r106.getReadPosition();
        goto L26
    L22:
        r113 = r106.getUnReadBadgeCount();
        goto L23
    L19:
        r112 = null;
        goto L20
    }

    public final void c() {
        Log.i("InitialPositionHandler", "scrollToNewestMessage useNewScroller:" + this.f414732f);
        com.ss.android.lark.biz.im.api.extension.scroll.a.a(this.f414727a.Ar(), ScrollScene.INITIAL_NEWEST_MESSAGE, 0, false);
    }

    public a(IMessageListComponent r100, Function0<Integer> r101, String r102, g r103, Function0<Boolean> r104) {
        Intrinsics.checkNotNullParameter(r100, "component");
        Intrinsics.checkNotNullParameter(r101, "showPosition");
        Intrinsics.checkNotNullParameter(r103, "fgService");
        Intrinsics.checkNotNullParameter(r104, "showNotFoundTip");
        this.f414727a = r100;
        this.f414728b = r101;
        this.f414729c = r102;
        this.f414730d = r103;
        this.f414731e = r104;
        this.f414732f = r100.Qv();
    }
}
