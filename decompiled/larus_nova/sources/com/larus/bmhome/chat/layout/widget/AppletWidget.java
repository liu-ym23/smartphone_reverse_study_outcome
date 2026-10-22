package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.widget.view.WidgetBoxView;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.obric.assistant.spi.miniapp.IObricIntentWidgetPolicy;
import com.obric.assistant.spi.miniapp.ObricIntentWidgetUpdateMode;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes25.dex */
public final class AppletWidget extends FrameLayout {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f304738y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f304739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f304740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f304741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f304742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f304743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.larus.bmhome.chat.api.r f304744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f304745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WidgetShowState f304746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super WidgetEvent, Unit> f304747i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f304748j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f304749k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.bmhome.chat.api.v0 f304750l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Job f304751m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.ai.applet.base.log.i f304752n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public kc8.n f304753o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public kc8.e0 f304754p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View.OnLongClickListener f304755q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CopyOnWriteArrayList<ic8.x> f304756r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ImageView f304757s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RelativeLayout f304758t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RelativeLayout f304759u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d f304760v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Path f304761w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final RectF f304762x;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/AppletWidget$WidgetEvent;", "", "<init>", "(Ljava/lang/String;I)V", "LAYOUT_FINISH", "SCROLL_TO_BOTTOM", "PAGE_UPDATE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum WidgetEvent extends Enum<WidgetEvent> {
        public static final WidgetEvent LAYOUT_FINISH = null;
        public static final WidgetEvent PAGE_UPDATE = null;
        public static final WidgetEvent SCROLL_TO_BOTTOM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WidgetEvent[] f304763a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f304764b = null;

        public static EnumEntries<WidgetEvent> getEntries() {
            return f304764b;
        }

        static {
            WidgetEvent r100 = new WidgetEvent("LAYOUT_FINISH", 0);
            LAYOUT_FINISH = r100;
            WidgetEvent r101 = new WidgetEvent("SCROLL_TO_BOTTOM", 1);
            SCROLL_TO_BOTTOM = r101;
            WidgetEvent r102 = new WidgetEvent("PAGE_UPDATE", 2);
            PAGE_UPDATE = r102;
            WidgetEvent[] r103 = {r100, r101, r102};
            f304763a = r103;
            f304764b = EnumEntriesKt.enumEntries(r103);
        }

        public static WidgetEvent[] values() {
            return (WidgetEvent[]) f304763a.clone();
        }

        public static WidgetEvent valueOf(String r100) {
            return (WidgetEvent) r27.a.a(WidgetEvent.class, r100);
        }

        public WidgetEvent(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/AppletWidget$WidgetShowState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "FAIL", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum WidgetShowState extends Enum<WidgetShowState> {
        public static final WidgetShowState FAIL = null;
        public static final WidgetShowState LOADING = null;
        public static final WidgetShowState SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WidgetShowState[] f304765a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f304766b = null;

        public static EnumEntries<WidgetShowState> getEntries() {
            return f304766b;
        }

        static {
            WidgetShowState r100 = new WidgetShowState("LOADING", 0);
            LOADING = r100;
            WidgetShowState r101 = new WidgetShowState("FAIL", 1);
            FAIL = r101;
            WidgetShowState r102 = new WidgetShowState("SUCCESS", 2);
            SUCCESS = r102;
            WidgetShowState[] r103 = {r100, r101, r102};
            f304765a = r103;
            f304766b = EnumEntriesKt.enumEntries(r103);
        }

        public static WidgetShowState[] values() {
            return (WidgetShowState[]) f304765a.clone();
        }

        public static WidgetShowState valueOf(String r100) {
            return (WidgetShowState) r27.a.a(WidgetShowState.class, r100);
        }

        public WidgetShowState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f304767a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f304768b = null;

        static {
            int[] r100 = new int[ObricIntentWidgetUpdateMode.values().length];
            r100[ObricIntentWidgetUpdateMode.UPDATE_IN_PLACE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r100[ObricIntentWidgetUpdateMode.RECREATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[ObricIntentWidgetUpdateMode.DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            f304767a = r100;
            int[] r101 = new int[WidgetShowState.values().length];
            r101[WidgetShowState.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r101[WidgetShowState.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r101[WidgetShowState.FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            f304768b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f304769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f304770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, Object> f304771c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f304769a, r101.f304769a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f304770b, r101.f304770b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f304771c, r101.f304771c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f304769a.hashCode() * 31;
            String r101 = this.f304770b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Map<String, Object> r105 = this.f304771c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "WidgetBindingKey(messageId=" + this.f304769a + ", renderData=" + this.f304770b + ", extra=" + this.f304771c + ')';
        }

        public c(String r100, String r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            this.f304769a = r100;
            this.f304770b = r101;
            this.f304771c = r102;
        }
    }

    public static final class d implements ic8.x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppletWidget f304772a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f304773a = null;

            static {
                int[] r100 = new int[com.larus.bmhome.chat.bean.WidgetEvent.values().length];
                r100[com.larus.bmhome.chat.bean.WidgetEvent.SCROLL_TO_BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[com.larus.bmhome.chat.bean.WidgetEvent.PAGE_UPDATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f304773a = r100;
            }
        }

        @Override // ic8.x
        public final void a() {
            this.f304772a.f304752n.c("onPageStart: this = " + this);
            Iterator<T> r100 = this.f304772a.f304756r.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((ic8.x) r100.next()).a();
            goto L4
        }

        @Override // ic8.x
        public final void b() {
            this.f304772a.f304752n.c("onPageError: this = " + this);
            this.f304772a.k(WidgetShowState.FAIL, false);
            Iterator<ic8.x> r100 = this.f304772a.f304756r.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            r100.next().b();
            goto L4
        }

        @Override // ic8.x
        public final void c() {
            this.f304772a.f304752n.c("onPageFinish: this = " + this);
            this.f304772a.k(WidgetShowState.SUCCESS, false);
            Iterator<ic8.x> r100 = this.f304772a.f304756r.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            r100.next().c();
            goto L4
        }

        @Override // ic8.x
        public final void onDestroy() {
            Iterator<T> r100 = this.f304772a.f304756r.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((ic8.x) r100.next()).onDestroy();
            goto L4
        }

        @Override // ic8.x
        public final void onStart() {
            this.f304772a.f304752n.c("onStart: this = " + this);
            this.f304772a.k(WidgetShowState.LOADING, false);
            Iterator<ic8.x> r100 = this.f304772a.f304756r.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            r100.next().onStart();
            goto L4
        }

        public d(AppletWidget r100) {
            this.f304772a = r100;
        }

        @Override // ic8.x
        public void onEvent(com.larus.bmhome.chat.bean.WidgetEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            int r101 = a.f304773a[r100.ordinal()];
            if (r101 != 1) goto L5;
            Function1<WidgetEvent, Unit> r102 = this.f304772a.getWidgetEventCallback();
            if (r102 == null) goto L13;
            r102.invoke(WidgetEvent.SCROLL_TO_BOTTOM);
        L13:
            Iterator<T> r103 = this.f304772a.f304756r.iterator();
        L15:
            if (r103.hasNext() == false) goto L17;
            ((ic8.x) r103.next()).onEvent(r100);
            goto L15
        L17:
            return;
        L5:
            if (r101 != 2) goto L13;
            AppletWidget r104 = this.f304772a;
            int r105 = AppletWidget.f304738y;
            r104.f();
            Function1<WidgetEvent, Unit> r106 = this.f304772a.getWidgetEventCallback();
            if (r106 == null) goto L13;
            r106.invoke(WidgetEvent.PAGE_UPDATE);
            goto L13
        }
    }

    static {
    }

    private final int getContentMaxWidth() {
        int r100 = this.f304739a;
        kc8.n r101 = this.f304753o;
        return Math.max((r100 - r101.f502530a) - r101.f502532c, 0);
    }

    public final void c() {
        this.f304761w.reset();
        Path r100 = this.f304761w;
        RectF r101 = this.f304762x;
        float r102 = this.f304740b;
        float r103 = this.f304741c;
        float r104 = this.f304742d;
        float r105 = this.f304743e;
        r100.addRoundRect(r101, new float[]{r102, r102, r103, r103, r104, r104, r105, r105}, Path.Direction.CW);
        this.f304761w.close();
        invalidate();
    }

    public final void f() {
        final View.OnLongClickListener r100 = this.f304755q;
        if (r100 != null) goto L5;
        return;
    L5:
        com.larus.bmhome.chat.api.r r101 = this.f304744f;
        if (r101 == null) goto L12;
        WidgetBoxView r102 = r101.a();
        if (r102 == null) goto L13;
        r102.post(new v(this, r100));
        return;
    L13:
        return;
    }

    public final void h() {
        int r100 = getContentMaxWidth();
        RelativeLayout r101 = this.f304758t;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L19;
        r102.width = r100;
        r101.setLayoutParams(r102);
        RelativeLayout r103 = this.f304759u;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L17;
        r104.width = r100;
        r103.setLayoutParams(r104);
        com.larus.bmhome.chat.api.r r105 = this.f304744f;
        if (r105 == null) goto L15;
        WidgetBoxView r106 = r105.a();
        if (r106 == null) goto L20;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L14;
        r107.width = r100;
        r106.setLayoutParams(r107);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L20:
        return;
    L15:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f304746h != WidgetShowState.LOADING) goto L5;
        g(this.f304757s);
        return;
    L5:
        this.f304757s.clearAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f304757s.clearAnimation();
    }

    public final WidgetShowState getCurrentStatus() {
        return this.f304746h;
    }

    public final int getMaxWidth() {
        return this.f304739a;
    }

    public final com.larus.bmhome.chat.api.r getWidgetContainer() {
        return this.f304744f;
    }

    public final Function1<WidgetEvent, Unit> getWidgetEventCallback() {
        return this.f304747i;
    }

    public static final /* synthetic */ int a(AppletWidget r100) {
        return r100.getContentMaxWidth();
    }

    public static void g(ImageView r100) {
        RotateAnimation r101 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r101.setDuration(600);
        r101.setRepeatCount(-1);
        r101.setRepeatMode(1);
        r101.setInterpolator(new LinearInterpolator());
        r100.startAnimation(r101);
    }

    public final void b(u r310) {
        Intrinsics.checkNotNullParameter(r310, "appletBindData");
        String r110 = r310.f305258a;
        String r100 = r310.f305259b;
        String r101 = r310.f305260c;
        String r102 = r310.f305261d;
        String r103 = r310.f305262e;
        String r111 = r310.f305263f;
        Fragment r112 = r310.f305264g;
        int r104 = r310.f305265h;
        Map<String, String> r113 = r310.f305266i;
        Map<String, Object> r105 = r310.f305267j;
        String r106 = r310.f305268k;
        boolean r107 = r310.f305269l;
        String r108 = r310.f305270m;
        kc8.n r114 = r310.f305271n;
        kc8.e0 r109 = r310.f305272o;
        String r115 = r310.f305273p;
        String r116 = r310.f305274q;
        Map<String, Object> r117 = r310.f305275r;
        Intrinsics.checkNotNullParameter(r110, RemoteMessageConst.MSGID);
        this.f304752n.c("bindData: messageId = " + r110 + ", cardId = " + r106 + ", this = " + this);
        if (r114 != null) goto L5;
        r114 = new kc8.n(0, 0, 0, 0);
    L5:
        this.f304753o = r114;
        setPadding(r114.f502530a, r114.f502531b, r114.f502532c, r114.f502533d);
        h();
        this.f304754p = r109;
        int r118 = kc8.z0.f502682a;
        com.larus.bmhome.chat.api.r r119 = this.f304744f;
        if (r119 == null) goto L8;
        WidgetBoxView r120 = r119.a();
    L10:
        if (r120 == null) goto L12;
        r120.setTag(R.id.larus_widget_menu_interceptor, r109);
    L12:
        d r121 = this.f304760v;
        int r210 = getContentMaxWidth();
        LinkedHashMap r122 = new LinkedHashMap();
        r122.put("app_cold_start_time", Long.valueOf(AppHost.f326268a.getAppStartTime().getSecond().longValue() / ((long) 1000)));
        wc9.e r123 = IAIChatControlTraceService.a.h(IAIChatControlTraceService.f365889a, r101);
        if (r123 == null) goto L17;
        Integer r124 = r123.E;
        if (r124 == null) goto L17;
        int r125 = r124.intValue();
    L18:
        r122.put("conversation_create_scene", Integer.valueOf(r125));
        if (r102 != null) goto L21;
        String r126 = "";
    L22:
        r122.put("section_id", r126);
        if (r117 == null) goto L25;
        r122.putAll(r117);
    L25:
        if (r115 != null) goto L27;
        r115 = "";
    L27:
        r122.put(ConversationConstants.KEY_ORIGIN_MESSAGE_ID, r115);
        com.larus.bmhome.chat.api.v0 r127 = new com.larus.bmhome.chat.api.v0(r110, r100, r101, r102, r103, r111, this, r121, r104, r210, r113, r105, r107, false, r108, r116, r122, 8192);
        if (r112 != null) goto L30;
        this.f304752n.b("bindData: hostFragment is NULL", null);
        return;
    L30:
        c r128 = new c(r110, r111, r127.f297271q);
        if (Intrinsics.areEqual(this.f304748j, r110) == true) goto L33;
        boolean r129 = false;
        String r130 = this.f304748j;
        if (r130 != null) goto L78;
    L81:
        boolean r131 = true;
    L82:
        if (r131 == true) goto L84;
        this.f304752n.b("bindData: it is use again, msgId = " + r110 + ", it is " + this, null);
    L84:
        this.f304748j = r110;
        this.f304749k = r128;
        this.f304745g = r111;
    L85:
        WidgetRenderDelegate r132 = WidgetRenderDelegate.f297181a;
        if (r106 != null) goto L88;
    L95:
        String r133 = r110;
    L96:
        int r134 = r132.i(r133, getResources().getDimensionPixelOffset(v19.c.b(R.attr.larus_dp_134, null, R.dimen.larus_dp_134)));
        this.f304752n.a("bindData currentStatus=" + this.f304746h + ' ' + this + " widgetContainer=" + this.f304744f + " height: " + r134 + ' ');
        this.f304758t.getLayoutParams().height = r134;
        this.f304759u.getLayoutParams().height = r134;
        Job r135 = this.f304751m;
        if (r135 != null) goto L99;
    L101:
        if (r129 == false) goto L105;
        this.f304752n.b("bindData: bindJob is Active", null);
        Job r136 = this.f304751m;
        if (r136 == null) goto L105;
        Job.DefaultImpls.cancel$default(r136, null, 1, null);
    L105:
        this.f304751m = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r112), this.f304752n.f34529b, null, new AppletWidget$bindData$1(r112, r127, this, null), 2, null);
        return;
    L99:
        if (r135.isActive() != true) goto L101;
        r129 = true;
        goto L101
    L88:
        if (r106.length() <= 0) goto L90;
        boolean r137 = true;
    L91:
        if (r137 == false) goto L93;
        r133 = r106;
    L94:
        if (r133 != null) goto L96;
    L93:
        r133 = null;
        goto L94
    L90:
        r137 = false;
        goto L91
    L78:
        if (r130.length() == 0) goto L81;
        r131 = false;
        goto L82
    L33:
        if (Intrinsics.areEqual(this.f304749k, r128) == true) goto L74;
        this.f304752n.c("bindData: update same message");
        com.larus.bmhome.chat.api.v0 r138 = com.larus.bmhome.chat.api.v0.a(r127, this.f304745g, 131039);
        this.f304749k = r128;
        this.f304745g = r111;
        IObricIntentWidgetPolicy r139 = (IObricIntentWidgetPolicy) ServiceManager.get().getService(IObricIntentWidgetPolicy.class);
        if (r139 == null) goto L40;
        rga.a r140 = r139.resolve(r111);
        if (r140 == null) goto L40;
        r129 = false;
    L41:
        ObricIntentWidgetUpdateMode r141 = r140.f537738a;
        if (this.f304744f != null) goto L44;
        this.f304750l = r127;
        return;
    L44:
        int r142 = b.f304767a[r141.ordinal()];
        if (r142 != 1) goto L47;
        this.f304750l = null;
        com.larus.bmhome.chat.api.r r143 = this.f304744f;
        if (r143 == null) goto L110;
        r143.updateData(r111);
        return;
    L110:
        return;
    L47:
        if (r142 != 2) goto L49;
        this.f304752n.c("bindData: recreate widget for updated render data");
        Job r144 = this.f304751m;
        if (r144 == null) goto L56;
        Job.DefaultImpls.cancel$default(r144, null, 1, null);
    L56:
        this.f304750l = null;
        com.larus.bmhome.chat.api.r r145 = this.f304744f;
        if (r145 == null) goto L59;
        WidgetBoxView r146 = r145.a();
    L60:
        if (r146 == null) goto L62;
        r146.setTag(R.id.larus_widget_menu_interceptor, null);
    L62:
        if (r146 == null) goto L64;
        r146.setOnLongClickListener(null);
    L64:
        WidgetRenderDelegate.f297181a.d(r112, com.larus.bmhome.chat.api.v0.a(r138, null, 122879));
        if (r146 == null) goto L67;
        ViewParent r147 = r146.getParent();
    L68:
        if (r147 != this) goto L70;
        removeView(r146);
    L70:
        this.f304744f = null;
        k(WidgetShowState.LOADING, true);
        goto L85
    L67:
        r147 = null;
        goto L68
    L59:
        r146 = null;
        goto L60
    L49:
        if (r142 != 3) goto L52;
        this.f304750l = null;
        WidgetRenderDelegate.f297181a.e(r112, r127);
        return;
    L52:
        throw new NoWhenBranchMatchedException();
    L40:
        r129 = false;
        r140 = new rga.a(0);
        goto L41
    L74:
        this.f304752n.a("bindData: skip unchanged message");
        return;
    L21:
        r126 = r102;
    L17:
        r125 = 0;
        goto L18
    L8:
        r120 = null;
        goto L10
    }

    public final void d(View r100) {
        if (r100.getVisibility() != 8) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return;
    L9:
        if (r100.getMeasuredWidth() == getMeasuredWidth()) goto L11;
    L13:
        r100.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        return;
    L11:
        if (r100.getMeasuredHeight() != getMeasuredHeight()) goto L13;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.clipPath(this.f304761w);
        super.dispatchDraw(r100);
    }

    public final void i(View.OnLongClickListener r100) {
        setOnLongClickListener(r100);
        com.larus.bmhome.chat.api.r r101 = this.f304744f;
        if (r101 == null) goto L8;
        WidgetBoxView r102 = r101.a();
        if (r102 == null) goto L9;
        r102.setOnLongClickListener(r100);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.clipPath(this.f304761w);
        super.onDraw(r100);
    }

    public final void setMaxWidth(int r100) {
        this.f304739a = r100;
        h();
    }

    public final void setWidgetContainer(com.larus.bmhome.chat.api.r r100) {
        this.f304744f = r100;
    }

    public final void setWidgetEventCallback(Function1<? super WidgetEvent, Unit> r100) {
        this.f304747i = r100;
    }

    public final void k(WidgetShowState r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "showState");
        if (this.f304746h != r100) goto L6;
        if (r101 == true) goto L6;
        return;
    L6:
        this.f304746h = r100;
        int r102 = b.f304768b[r100.ordinal()];
        if (r102 != 1) goto L9;
        com.larus.utils.e1.x(this.f304758t);
        g(this.f304757s);
        com.larus.utils.e1.o(this.f304759u);
        return;
    L9:
        if (r102 != 2) goto L11;
        f();
        this.f304757s.clearAnimation();
        com.larus.utils.e1.o(this.f304758t);
        com.larus.utils.e1.o(this.f304759u);
        GradientDrawable r103 = new GradientDrawable();
        r103.setColor(0);
        setBackground(r103);
        Function1<? super WidgetEvent, Unit> r104 = this.f304747i;
        if (r104 == null) goto L21;
        r104.invoke(WidgetEvent.LAYOUT_FINISH);
        return;
    L21:
        return;
    L11:
        if (r102 != 3) goto L14;
        this.f304757s.clearAnimation();
        com.larus.utils.e1.x(this.f304759u);
        com.larus.utils.e1.o(this.f304758t);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        d(this.f304758t);
        d(this.f304759u);
    }

    public final void j(Float r100, Float r101, Float r102, Float r103) {
        if (r100 == null) goto L4;
        this.f304740b = r100.floatValue();
    L4:
        if (r101 == null) goto L6;
        this.f304741c = r101.floatValue();
    L6:
        if (r102 == null) goto L8;
        this.f304742d = r102.floatValue();
    L8:
        if (r103 == null) goto L10;
        this.f304743e = r103.floatValue();
    L10:
        c();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f304762x.set(0.0f, 0.0f, r100, r101);
        c();
    }

    public AppletWidget(Context r100, int r101, float r102, float r110, float r111, float r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f304739a = r101;
        this.f304740b = r102;
        this.f304741c = r110;
        this.f304742d = r111;
        this.f304743e = r112;
        this.f304746h = WidgetShowState.LOADING;
        this.f304752n = new com.bytedance.ai.applet.base.log.i("AppletWidget", new com.bytedance.ai.applet.base.log.e(MapsKt.mapOf(TuplesKt.to("logId", com.bytedance.ai.applet.base.log.e.f34524c + '-' + com.bytedance.ai.applet.base.log.e.f34525d.incrementAndGet()))));
        this.f304753o = new kc8.n(0, 0, 0, 0);
        this.f304756r = new CopyOnWriteArrayList();
        ImageView r103 = new ImageView(r100);
        r103.setImageResource(R.drawable.larus_widget_loading_view);
        r103.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams r113 = new RelativeLayout.LayoutParams(r103.getResources().getDimensionPixelOffset(v19.c.b(R.attr.larus_dp_40, null, R.dimen.larus_dp_40)), r103.getResources().getDimensionPixelOffset(v19.c.b(R.attr.larus_dp_40, null, R.dimen.larus_dp_40)));
        r113.addRule(13);
        r103.setLayoutParams(r113);
        this.f304757s = r103;
        RelativeLayout r114 = new RelativeLayout(r100);
        r114.setLayoutParams(new ViewGroup.LayoutParams(this.f304739a, r114.getResources().getDimensionPixelOffset(v19.c.b(R.attr.larus_dp_134, null, R.dimen.larus_dp_134))));
        r114.setVisibility(0);
        r114.setBackgroundResource(R.color.larus_base_2_overlay);
        this.f304758t = r114;
        RelativeLayout r115 = new RelativeLayout(r100);
        r115.setLayoutParams(new ViewGroup.LayoutParams(this.f304739a, r115.getResources().getDimensionPixelOffset(v19.c.b(R.attr.larus_dp_134, null, R.dimen.larus_dp_134))));
        r115.setVisibility(8);
        r115.setBackgroundResource(R.color.larus_base_2_overlay);
        this.f304759u = r115;
        ImageView r104 = new ImageView(r100);
        r104.setImageResource(R.drawable.larus_widget_error_view);
        r104.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams r105 = new RelativeLayout.LayoutParams(r104.getResources().getDimensionPixelOffset(v19.c.b(R.attr.larus_dp_58, null, R.dimen.larus_dp_58)), r104.getResources().getDimensionPixelOffset(v19.c.b(R.attr.larus_dp_58, null, R.dimen.larus_dp_58)));
        r105.addRule(13);
        r104.setLayoutParams(r105);
        this.f304760v = new d(this);
        r114.addView(r103);
        r115.addView(r104);
        addView(r114);
        addView(r115);
        this.f304761w = new Path();
        this.f304762x = new RectF();
    }

    public final void e(Fragment r210, String r211, String r212, String r213, String r214, String r215, int r216, boolean r217) {
        Intrinsics.checkNotNullParameter(r211, "messageId");
        this.f304752n.c("onViewRecycled: messageId = " + r211 + ", this = " + this);
        this.f304748j = null;
        this.f304749k = null;
        this.f304750l = null;
        Job r100 = this.f304751m;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f304754p = null;
        this.f304755q = null;
        com.larus.bmhome.chat.api.r r101 = this.f304744f;
        if (r101 == null) goto L8;
        WidgetBoxView r102 = r101.a();
    L9:
        int r103 = kc8.z0.f502682a;
        if (r102 == null) goto L12;
        r102.setTag(R.id.larus_widget_menu_interceptor, null);
    L12:
        i(null);
        this.f304756r.clear();
        if (r102 == null) goto L15;
        ViewParent r104 = r102.getParent();
    L17:
        if (Intrinsics.areEqual(r104, this) == true) goto L28;
        com.bytedance.ai.applet.base.log.i r105 = this.f304752n;
        String r106 = "onViewRecycled: messageId=" + r211 + ", this=" + this + ", widgetView is not added";
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "msg");
        ThreadLocal<Map<String, String>> r107 = com.bytedance.ai.applet.base.log.f.f34527a;
        com.bytedance.ai.applet.base.log.e r108 = r105.f34529b;
        if (r108.f34526a.isEmpty() == false) goto L21;
        com.bytedance.ai.applet.base.log.b r109 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.d(r105.f34528a, r106, null);
        return;
    L21:
        Map<String, String> r110 = com.bytedance.ai.applet.base.log.f.f34527a.get();
        com.bytedance.ai.applet.base.log.f.b(MapsKt.plus(com.bytedance.ai.applet.base.log.f.a(), r108.f34526a));
        com.bytedance.ai.applet.base.log.b r111 = com.bytedance.ai.applet.base.log.a.f34518a;     // Catch: Throwable -> L25
        com.bytedance.ai.applet.base.log.a.d(r105.f34528a, r106, null);     // Catch: Throwable -> L25
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L25
        com.bytedance.ai.applet.base.log.f.b(r110);
        return;
    L25:
        th = move-exception;
        com.bytedance.ai.applet.base.log.f.b(r110);
        throw th;
    L28:
        if (r102 == null) goto L30;
        removeView(r102);
    L30:
        WidgetRenderDelegate.f297181a.d(r210, new com.larus.bmhome.chat.api.v0(r211, r212, r213, r214, r215, this.f304745g, this, this.f304760v, r216, this.f304739a, null, null, false, r217, null, null, null, 53248));
        return;
    L15:
        r104 = null;
        goto L17
    L8:
        r102 = null;
        goto L9
    }
}
