package com.ss.android.lark.contact.base.service;

import android.os.SystemClock;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f418905a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f418906b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f418907c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f418908d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f418909e = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Scene f418910a;

        public a(Scene r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            this.f418910a = r100;
        }

        public final void b(Event r210, ErrorResult r211) {
            Intrinsics.checkNotNullParameter(r210, "event");
            Intrinsics.checkNotNullParameter(r211, "err");
            Intrinsics.checkNotNullParameter(r210, "event");
            Intrinsics.checkNotNullParameter(r211, "err");
            AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.UserGrowth, this.f418910a, r210, ErrorType.SDK, ErrorLevel.Fatal, r211.getErrorCode(), "", "", r211.getMessage(), true, null, null, null, 7168, null));
        }

        public final void c(Event r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            String r102 = AppreciableKit.Companion.getInstance().start(Biz.UserGrowth, this.f418910a, r100, "", r101);
            a0.f418906b.put(r100.name(), r102);
            a0.f418905a.put(r100.name(), Long.valueOf(SystemClock.uptimeMillis()));
        }

        public static void a(Event r100, Map r101, Map r110, Map r111) {
            Intrinsics.checkNotNullParameter(r100, "event");
            ConcurrentHashMap<String, String> r102 = a0.f418906b;
            String r103 = r102.get(r100.name());
            if (r103 != null) goto L5;
            return;
        L5:
            String r104 = r102.remove(r100.name());
            a0.b(r100.name());
            AppreciableKit.Companion.getInstance().end(r103, null, r101, r110, r111);
        }
    }

    static {
        f418905a = new ConcurrentHashMap();
        f418906b = new ConcurrentHashMap();
        f418907c = new a(Scene.Invite);
        f418908d = new a(Scene.Contact);
        f418909e = new a(Scene.DyResource);
    }

    public static void a(ErrorResult r110) {
        Intrinsics.checkNotNullParameter(r110, "err");
        AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.Messenger, Scene.Contact, Event.add_contacts, ErrorType.SDK, ErrorLevel.Fatal, r110.getErrorCode(), "GET_CONTACT_TOKEN_V2", "InviteExternalView", r110.getMessage(), Boolean.TRUE, null, null, null, 7168, null));
    }

    public static long b(String r100) {
        ConcurrentHashMap<String, Long> r101 = f418905a;
        Long r102 = r101.get(r100);
        if (r102 == null) goto L6;
        long r103 = r102.longValue();
        r101.remove(r100);
        return SystemClock.uptimeMillis() - r103;
    L6:
        return 0;
    }

    public static void c(boolean r100) {
        if (r100 == false) goto L5;
        String r101 = AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Contact, Event.contact_opt_approve_friend_fetch, "contact_opt_approve_friend_fetch", true);
        f418906b.put("contact_opt_approve_friend_fetch", r101);
        f418905a.put("contact_opt_approve_friend_fetch", Long.valueOf(SystemClock.uptimeMillis()));
        return;
    L5:
        ConcurrentHashMap<String, String> r102 = f418906b;
        String r103 = r102.get("contact_opt_approve_friend_fetch");
        if (r103 != null) goto L8;
        return;
    L8:
        String r104 = r102.remove("contact_opt_approve_friend_fetch");
        AppreciableKit.Companion.getInstance().end(r103);
    }

    public static void d(boolean r110) {
        if (r110 == false) goto L5;
        String r111 = AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Contact, Event.enter_contact_applications, "contact_applications_page", true);
        f418906b.put("contact_applications_page", r111);
        f418905a.put("contact_applications_page", Long.valueOf(SystemClock.uptimeMillis()));
        return;
    L5:
        ConcurrentHashMap<String, String> r112 = f418906b;
        String r100 = r112.get("contact_applications_page");
        if (r100 != null) goto L8;
        return;
    L8:
        String r113 = r112.remove("contact_applications_page");
        long r101 = b("contact_applications_page");
        AppreciableKit.end$default(AppreciableKit.Companion.getInstance(), r100, MapsKt.mapOf(TuplesKt.to("sdk_cost", Long.valueOf(r101))), null, null, null, 28, null);
    }

    public static void e(boolean r110) {
        String r100 = "ContactExternalView".concat("V2");
        if (r110 == false) goto L5;
        f418906b.put(r100, AppreciableKit.start$default(AppreciableKit.Companion.getInstance(), Biz.Messenger, Scene.Contact, Event.show_external_contacts, r100, true, null, null, MapsKt.mapOf(TuplesKt.to("member_count", "0")), null, 352, null));
        f418905a.put(r100, Long.valueOf(SystemClock.uptimeMillis()));
        return;
    L5:
        ConcurrentHashMap<String, String> r111 = f418906b;
        String r101 = r111.get(r100);
        if (r101 != null) goto L8;
        return;
    L8:
        String r112 = r111.remove(r100);
        long r102 = b(r100);
        AppreciableKit.end$default(AppreciableKit.Companion.getInstance(), r101, MapsKt.mapOf(new Pair[]{TuplesKt.to("sdk_cost", 0L), TuplesKt.to("init_view_cost", Long.valueOf(r102)), TuplesKt.to("first_render", Long.valueOf(r102))}), null, null, null, 28, null);
    }

    public static void f(boolean r110) {
        if (r110 == false) goto L5;
        f418906b.put("InviteExternalContactView", AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Contact, Event.show_address_book, "InviteExternalContactView", true));
        f418905a.put("InviteExternalContactView", Long.valueOf(SystemClock.uptimeMillis()));
        return;
    L5:
        ConcurrentHashMap<String, String> r111 = f418906b;
        String r100 = r111.get("InviteExternalContactView");
        if (r100 != null) goto L8;
        return;
    L8:
        String r112 = r111.remove("InviteExternalContactView");
        long r101 = b("InviteExternalContactView");
        AppreciableKit.end$default(AppreciableKit.Companion.getInstance(), r100, MapsKt.mapOf(new Pair[]{TuplesKt.to("sdk_cost", 0L), TuplesKt.to("init_view_cost", Long.valueOf(r101)), TuplesKt.to("first_render", Long.valueOf(r101))}), null, null, MapsKt.mapOf(TuplesKt.to("source_type", 1)), 12, null);
    }

    public static void g(boolean r110) {
        if (r110 == false) goto L5;
        f418906b.put("InviteExternalView", AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Contact, Event.add_contacts, "InviteExternalView", true));
        f418905a.put("InviteExternalView", Long.valueOf(SystemClock.uptimeMillis()));
        return;
    L5:
        ConcurrentHashMap<String, String> r111 = f418906b;
        String r100 = r111.get("InviteExternalView");
        if (r100 != null) goto L8;
        return;
    L8:
        String r112 = r111.remove("InviteExternalView");
        long r101 = b("InviteExternalView");
        AppreciableKit.end$default(AppreciableKit.Companion.getInstance(), r100, MapsKt.mapOf(new Pair[]{TuplesKt.to("link_cost", Long.valueOf(r101)), TuplesKt.to("qrcode_cost", Long.valueOf(r101)), TuplesKt.to("init_view_cost", Long.valueOf(r101)), TuplesKt.to("first_render", Long.valueOf(r101))}), null, null, null, 28, null);
    }
}
