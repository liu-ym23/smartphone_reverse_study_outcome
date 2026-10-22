package com.larus.bmhome.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.bmhome.view.textview.impl.SelectorRestore;
import com.larus.chat.common.databinding.LarusLayoutMessageMenuBinding;
import com.larus.chat.common.databinding.LarusLayoutMessageMenuNewBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.ArrowOrientation;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class MessageMenu implements st8.b.c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static WeakReference<MessageMenu> f315548x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final CopyOnWriteArraySet<WeakReference<Balloon>> f315549y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CustomMarkdownTextView f315550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BotModel f315551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f315552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f315553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f315554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f315555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f315556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Integer, Unit> f315557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public qt8.a f315558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Balloon f315559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView f315560k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MessageMenu$scrollListener$1 f315561l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f315562m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f315563n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f315564o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f315565p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f315566q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f315567r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.larus.bmhome.chat.api.d0 f315568s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f315569t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f315570u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f315571v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f315572w;

    public static final class a {
        public static void a() {
            WeakReference<MessageMenu> r100 = MessageMenu.f315548x;
            if (r100 == null) goto L22;
            MessageMenu r101 = r100.get();
            if (r101 == null) goto L23;
            SelectorRestore r102 = null;
            if (r101.f315550a.z() == false) goto L14;
            Balloon r103 = r101.f315559j;
            if (r103 == null) goto L11;
            r103.h();
        L11:
            r101.f315559j = null;
            tt8.b r104 = r101.f315550a.m8544getTextSelector();
            if (r104 == null) goto L14;
            r104.i();
        L14:
            Object r105 = r101.f315550a.getTag(R.id.get_restore_selector);
            if ((r105 instanceof SelectorRestore) == false) goto L17;
            r102 = (SelectorRestore) r105;
        L17:
            if (r102 == null) goto L24;
            Map<String, tt8.c> r106 = r102.f317438b;
            if (r106 == null) goto L25;
            ((LinkedHashMap) r106).clear();
            return;
        L25:
            return;
        L24:
            return;
        L23:
            return;
        }

        public static boolean b(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            WeakReference<MessageMenu> r101 = MessageMenu.f315548x;
            if (r101 == null) goto L7;
            MessageMenu r102 = r101.get();
            if (r102 == null) goto L7;
            CustomMarkdownTextView r103 = r102.f315550a;
        L8:
            if (r103 == null) goto L10;
            Context r104 = r103.getContext();
        L12:
            if (Intrinsics.areEqual(r104, r100) == true) goto L14;
            MessageMenu.f315548x = null;
        L14:
            if (r103 != null) goto L16;
        L18:
            return false;
        L16:
            if (r103.z() != true) goto L18;
            return true;
        L10:
            r104 = null;
        L7:
            r103 = null;
            goto L8
        }
    }

    public static final class b implements com.larus.bmhome.chat.api.d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageMenu f315573a;

        public b(MessageMenu r100) {
            this.f315573a = r100;
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void a(View r100, int r101, int r102) {
            com.larus.bmhome.chat.api.d0 r103 = this.f315573a.f315568s;
            if (r103 == null) goto L6;
            r103.a(r100, r101, r102);
        L6:
            if (r102 != 1) goto L12;
            MessageMenu r104 = this.f315573a;
            if (r104.f315564o == false) goto L10;
            r104.f315563n = true;
            MessageMenu.c(r104, false, true, false, 4);
            return;
        L10:
            r104.f315563n = false;
            r104.onShow();
            return;
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void b(SelectionRangeType r110, int r111, int r112, boolean r113, boolean r114, Rect r115, String r116) {
            Intrinsics.checkNotNullParameter(r110, "rangeType");
            Intrinsics.checkNotNullParameter(r116, "selectedText");
            com.larus.bmhome.chat.api.d0 r100 = this.f315573a.f315568s;
            if (r100 == null) goto L6;
            r100.b(r110, r111, r112, r113, r114, r115, r116);
            return;
        }
    }

    public static final class c implements st8.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageMenu f315574a;

        public c(MessageMenu r100) {
            this.f315574a = r100;
        }

        @Override // st8.c
        public final void a(ut8.i r100, boolean r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "selector");
            qt8.a r104 = this.f315574a.f315558i;
            if (r104 == null) goto L5;
            r104.a(r100, r101, r102, r103);
        L5:
            boolean r105 = false;
            if (r101 == false) goto L17;
            MessageMenu r106 = this.f315574a;
            Balloon r107 = r106.f315559j;
            if (r107 != null) goto L10;
        L13:
            r106.f315562m = true;
            if (r107 == null) goto L16;
            r107.h();
        L16:
            this.f315574a.f315559j = null;
            return;
        L10:
            if (r107.f406024g != true) goto L12;
            r105 = true;
        L12:
            if (r105 == true) goto L13;
            return;
        L17:
            MessageMenu r108 = this.f315574a;
            if (r108.f315562m == false) goto L23;
            r108.f315563n = false;
            r108.f315564o = true;
            r108.d();
            this.f315574a.g();
            this.f315574a.f315562m = false;
            return;
        }
    }

    public static final class d implements ut8.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ va8.o f315575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.larus.bmhome.chat.component.bottom.reference.a f315576b;

        @Override // ut8.f
        public final void a() {
            if (((com.larus.platform.model.chat.m0) nd8.b.f518806a.getValue()).a() == true) goto L5;
            return;
        L5:
            com.larus.bmhome.chat.component.bottom.reference.a r100 = this.f315576b;
            if (r100 != null) goto L8;
            return;
        L8:
            if (r100.i9() == false) goto L12;
            r100.sZ();
            return;
        }

        @Override // ut8.f
        public final boolean b(MotionEvent r100) {
            if (((com.larus.platform.model.chat.m0) nd8.b.f518806a.getValue()).a() == true) goto L5;
            return true;
        L5:
            FLogger.f375446a.i("MessageMenu", "outsideTouchInterceptor event=" + r100 + " inputViewAbility=" + this.f315575a);
            if (r100 == null) goto L17;
            va8.o r101 = this.f315575a;
            if (r101 != null) goto L10;
        L12:
            boolean r102 = false;
        L13:
            if (r102 == false) goto L18;
            return false;
        L18:
            return true;
        L10:
            if (r101.xO(r100) != true) goto L12;
            r102 = true;
            goto L13
        L17:
            return true;
        }

        public d(va8.o r100, com.larus.bmhome.chat.component.bottom.reference.a r101) {
            this.f315575a = r100;
            this.f315576b = r101;
        }
    }

    static {
        f315549y = new CopyOnWriteArraySet();
    }

    public final void b() {
        Iterator<WeakReference<Balloon>> r100 = f315549y.iterator();
        int r101 = 0;
    L3:
        int r102 = 1;
        if (r100.hasNext() == false) goto L12;
        Balloon r103 = r100.next().get();
        if (r103 != null) goto L8;
    L10:
        r102 = 0;
    L11:
        r101 = r101 + r102;
        goto L3
    L8:
        if (r103.f406024g != true) goto L10;
    L12:
        if (r101 != 0) goto L14;
        return;
    L14:
        Iterator<T> r104 = f315549y.iterator();
    L16:
        if (r104.hasNext() == false) goto L27;
        WeakReference r105 = (WeakReference) r104.next();
        Balloon r106 = (Balloon) r105.get();
        if (r106 != null) goto L20;
    L22:
        boolean r107 = false;
    L23:
        if (r107 == false) goto L16;
        Balloon r108 = (Balloon) r105.get();
        if (r108 == null) goto L16;
        r108.h();
        goto L16
    L20:
        if (r106.f406024g != true) goto L22;
        r107 = true;
        goto L23
    }

    public final void d() {
        RecyclerView r100 = this.f315560k;
        if (r100 == null) goto L5;
        r100.removeOnScrollListener(this.f315561l);
    L5:
        RecyclerView r101 = this.f315560k;
        if (r101 == null) goto L8;
        r101.addOnScrollListener(this.f315561l);
    L8:
        boolean r102 = true;
        if (Intrinsics.areEqual(this.f315553d, Boolean.TRUE) == false) goto L22;
        CustomMarkdownTextView r103 = this.f315550a;
        r103.getClass();
        LarusLayoutMessageMenuNewBinding r104 = LarusLayoutMessageMenuNewBinding.a(LayoutInflater.from(r103.getContext()));
        com.larus.utils.e1.x(r104.f324024f);
        com.larus.utils.e1.o(r104.f324026h);
        com.larus.utils.e1.o(r104.f324026h);
        com.larus.utils.e1.o(r104.f324027i);
        Message r105 = this.f315552c;
        if (r105 != null) goto L13;
    L15:
        r102 = false;
    L16:
        if (r102 == false) goto L18;
        com.larus.utils.e1.o(r104.f324029k);
    L18:
        this.f315550a.A(this.f315566q);
        this.f315550a.x(this.f315566q);
        Balloon r106 = this.f315559j;
        if (r106 == null) goto L21;
        r106.h();
    L21:
        b();
    L36:
        tt8.b r107 = this.f315550a.m8544getTextSelector();
        if (r107 == null) goto L42;
        r107.E = this;
        return;
    L42:
        return;
    L13:
        if (com.larus.im.bean.message.a.p0(r105) != true) goto L15;
    L22:
        CustomMarkdownTextView r108 = this.f315550a;
        r108.getClass();
        Context r109 = r108.getContext();
        Context r110 = null;
        View r111 = LayoutInflater.from(r109).inflate(R.layout.larus_layout_message_menu, null, false);
        int r112 = android.R.id.copy;
        FrameLayout r113 = (FrameLayout) ViewBindings.findChildViewById(r111, android.R.id.copy);
        if (r113 == null) goto L41;
        r112 = R.id.modify;
        FrameLayout r114 = (FrameLayout) ViewBindings.findChildViewById(r111, R.id.modify);
        if (r114 == null) goto L41;
        LarusLayoutMessageMenuBinding r115 = new LarusLayoutMessageMenuBinding((LinearLayoutCompat) r111, r113, r114);
        r114.setVisibility(8);
        this.f315550a.A(this.f315566q);
        this.f315550a.x(this.f315566q);
        Balloon r116 = this.f315559j;
        if (r116 == null) goto L29;
        r116.h();
    L29:
        Intrinsics.checkNotNull(r109);
        Balloon.a r117 = new Balloon.a(r109);
        r117.n(Integer.MIN_VALUE);
        r117.j(Integer.MIN_VALUE);
        r117.f406065z = 16.0f;
        r117.e(ArrowPositionRules.ALIGN_BALLOON);
        r117.f(Integer.MIN_VALUE);
        r117.d(ArrowOrientation.TOP);
        r117.f406055p = 0.5f;
        r117.m();
        r117.f406062w = TypedValue.applyDimension(1, 8.0f, Balloon.a.a(Resources.getSystem()));
        r117.f406061v = ContextCompat.getColor(r109, v19.c.b(R.attr.larus_neutral_70, r109, R.color.larus_neutral_70));
        r117.i();
        r117.g(BalloonAnimation.FADE);
        r117.f406044g0 = false;
        r117.h(false);
        Function1 r118 = new j3(this);
        Intrinsics.checkNotNullParameter(r118, "block");
        r117.O = new com.skydoves.balloon.j(r118);
        r117.l(new k3(this));
        CustomMarkdownTextView r119 = this.f315550a;
        if (r119 == null) goto L32;
        r110 = r119.getContext();
    L32:
        r117.c(v19.c.b(R.attr.larus_message_menu_arrow, r110, R.drawable.larus_message_menu_arrow));
        r117.k(r115);
        this.f315559j = r117.b();
        Balloon r120 = this.f315559j;
        if (r120 == null) goto L35;
        f315549y.add(new WeakReference(r120));
    L35:
        b();
        r113.setOnClickListener(new l3(this));
        r114.setOnClickListener(new m3(this));
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r112)));
    }

    public final void g() {
        if (Intrinsics.areEqual(this.f315556g, Boolean.FALSE) == false) goto L6;
        return;
    L6:
        if (this.f315572w == false) goto L8;
        return;
    L8:
        CustomMarkdownTextView r100 = this.f315550a;
        r100.getClass();
        final View r101 = r100.getRootView();
        r101.post(new i3(this, r101));
    }

    @Override // st8.b.c
    public final void onShow() {
        if (this.f315563n == false) goto L5;
        return;
    L5:
        this.f315564o = true;
        FLogger.f375446a.i("MessageMenu", SendEventContainerMethodParamModel.EventKinds.onShow);
        d();
        g();
    }

    @Override // st8.b.c
    public final void a(boolean r100) {
        c(this, r100, false, false, 6);
    }

    public final void e(String r100) {
        Intent r101 = new Intent(r100);
        ((LocalBroadcastManager) this.f315567r.getValue()).sendBroadcast(r101);
    }

    public final void f(RecyclerView r100, va8.o r101, com.larus.bmhome.chat.component.bottom.reference.a r102) {
        FLogger.f375446a.i("MessageMenu", "show");
        this.f315560k = r100;
        f315548x = new WeakReference(this);
        Object r103 = this.f315550a.getTag(R.id.get_restore_selector);
        if ((r103 instanceof SelectorRestore) == false) goto L5;
        SelectorRestore r104 = (SelectorRestore) r103;
    L6:
        if (r104 == null) goto L10;
        Map<String, tt8.c> r105 = r104.f317438b;
        if (r105 == null) goto L10;
        ((LinkedHashMap) r105).clear();
    L10:
        d();
        tt8.b r106 = this.f315550a.m8544getTextSelector();
        if (r106 == null) goto L13;
        r106.f551674u = new d(r101, r102);
    L13:
        tt8.b r107 = this.f315550a.m8544getTextSelector();
        if (r107 == null) goto L16;
        r107.f551672s = (b) this.f315571v.getValue();
    L16:
        tt8.b r108 = this.f315550a.m8544getTextSelector();
        if (r108 == null) goto L19;
        r108.r((int) this.f315550a.getClickX(), (int) this.f315550a.getClickY(), this.f315570u, this.f315569t);
    L19:
        g();
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static void c(MessageMenu r100, boolean r101, boolean r110, boolean r111, int r112) {
        boolean r102 = false;
        if ((r112 & 2) == 0) goto L6;
        r110 = false;
    L6:
        if ((r112 & 4) == 0) goto L8;
        r111 = false;
    L8:
        r100.getClass();
        if (r101 == true) goto L19;
        if (r110 == true) goto L19;
        long r103 = SystemClock.elapsedRealtime();
        if ((r103 - r100.f315565p) <= 300) goto L19;
        r100.f315565p = r103;
        Balloon r113 = r100.f315559j;
        if (r113 != null) goto L16;
    L18:
        r100.f315564o = r102;
        goto L19
    L16:
        if (r113.f406024g != true) goto L18;
        r102 = true;
    L19:
        FLogger r114 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("onDismiss, fromClick=");
        r104.append(r101);
        r104.append(", fromSingleClickInSelectedArea=");
        r104.append(r110);
        r104.append(", isForce=");
        r104.append(r111);
        r104.append(", balloonShowing=");
        Balloon r115 = r100.f315559j;
        if (r115 == null) goto L22;
        Boolean r116 = Boolean.valueOf(r115.f406024g);
    L23:
        r104.append(r116);
        r104.append(", selectorShowing=");
        r104.append(r100.f315550a.z());
        r104.append(", forbidShowAgain=");
        r104.append(r100.f315572w);
        r114.i("MessageMenu", r104.toString());
        Balloon r117 = r100.f315559j;
        if (r117 == null) goto L26;
        r117.h();
    L26:
        r100.f315559j = null;
        if (r101 == false) goto L31;
        RecyclerView r105 = r100.f315560k;
        if (r105 == null) goto L31;
        r105.removeOnScrollListener(r100.f315561l);
    L31:
        if (r111 == true) goto L35;
        r100.b();
        return;
    L35:
        return;
    L22:
        r116 = null;
        goto L23
    }

    public /* synthetic */ MessageMenu(CustomMarkdownTextView r110, BotModel r111, Message r112, Boolean r113, Boolean r114, Function1 r115, int r116) {
        Boolean r100 = null;
        if ((r116 & 2) == 0) goto L5;
        BotModel r101 = null;
    L7:
        if ((r116 & 4) == 0) goto L9;
        Message r102 = null;
    L11:
        if ((r116 & 8) == 0) goto L13;
        Boolean r103 = Boolean.FALSE;
    L15:
        if ((r116 & 16) == 0) goto L17;
        Boolean r104 = Boolean.TRUE;
    L19:
        if ((r116 & 32) == 0) goto L21;
        Boolean r105 = Boolean.TRUE;
    L23:
        if ((r116 & 64) == 0) goto L25;
        r100 = Boolean.TRUE;
    L25:
        this(r110, r101, r102, r103, r104, r105, r100, r115);
        return;
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = r114;
        goto L19
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.bmhome.view.MessageMenu$scrollListener$1] */
    public MessageMenu(CustomMarkdownTextView r100, BotModel r101, Message r102, Boolean r103, Boolean r104, Boolean r105, Boolean r106, Function1<? super Integer, Unit> r107) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        Intrinsics.checkNotNullParameter(r107, "callback");
        this.f315550a = r100;
        this.f315551b = r101;
        this.f315552c = r102;
        this.f315553d = r103;
        this.f315554e = r104;
        this.f315555f = r105;
        this.f315556g = r106;
        this.f315557h = r107;
        this.f315561l = new MessageMenu$scrollListener$1(this);
        this.f315564o = true;
        c r108 = new c(this);
        this.f315566q = r108;
        this.f315567r = LazyKt.lazy(new y2(this));
        this.f315570u = 2;
        this.f315571v = LazyKt.lazy(new h3(this));
        this.f315550a.x(r108);
    }
}
