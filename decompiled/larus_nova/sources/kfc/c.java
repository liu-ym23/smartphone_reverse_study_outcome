package kfc;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.log.PushLog;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.newmedia.redbadge.RedBadgePushProcessService;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile c f503296j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f503297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHandler f503298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f503299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f503300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f503301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f503302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f503303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f503304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C6548c f503305i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f503306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f503307b;

        public final void a() {
            c r100 = this.f503307b;
            Context r101 = this.f503306a;
            r100.getClass();
            if (r101 != null) goto L9;
        L6:
            c r102 = this.f503307b;
            r102.f503299c = mfc.a.a(r102.f503297a).f513691a.c("is_desktop_red_badge_show", false);
            return;
        L9:
            r101.getContentResolver().registerContentObserver(PushMultiProcessSharedProvider.c(r101, "is_desktop_red_badge_show", "boolean"), true, r100.f503304h);     // Catch: Throwable -> L8
            r101.getContentResolver().registerContentObserver(PushMultiProcessSharedProvider.c(r101, "desktop_red_badge_args", "string"), true, r100.f503305i);     // Catch: Throwable -> L8
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r100, Context r101) {
            this.f503307b = r100;
            this.f503306a = r101;
        }
    }

    public class b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f503308a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            if (com.bytedance.push.utils.f.f267065a == false) goto L5;
            com.bytedance.push.utils.f.b("RedBadgeControlClient", "KEY_IS_DESKTOP_RED_BADGE_SHOW");
        L5:
            c r101 = this.f503308a;
            r101.f503299c = mfc.a.a(r101.f503297a).f513691a.c("is_desktop_red_badge_show", false);
        }

        public b(c r100, WeakHandler r101) {
            this.f503308a = r100;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: kfc.c$c, reason: collision with other inner class name */
    public class C6548c extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f503309a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            if (com.bytedance.push.utils.f.f267065a == false) goto L5;
            com.bytedance.push.utils.f.b("RedBadgeControlClient", "KEY_DESKTOP_RED_BADGE_ARGS");
        L5:
            c r101 = this.f503309a;
            r101.f503299c = mfc.a.a(r101.f503297a).f513691a.c("is_desktop_red_badge_show", false);
        }

        public C6548c(c r100, WeakHandler r101) {
            this.f503309a = r100;
            super(r101);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f503310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f503311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f503312c;

        public d() {
        }

        public static d a(String r100) {
            d r101 = new d();
            JSONObject r102 = new JSONObject(r100);     // Catch: Throwable -> L5
            r101.f503310a = r102.optLong(EventVerify.TYPE_LAUNCH, 0);     // Catch: Throwable -> L5
            r101.f503311b = r102.optLong("leave", 0);     // Catch: Throwable -> L5
            r101.f503312c = r102.optLong(IAllianceService.CONTENT_TYPE_BADGE, 0);     // Catch: Throwable -> L5
        L7:
            return r101;
        L5:
            th = move-exception;
            th.printStackTrace();
            goto L7
        }
    }

    public final void c() {
        mfc.a r100 = mfc.a.a(this.f503297a);     // Catch: Throwable -> L17
        int r101 = this.f503300d;     // Catch: Throwable -> L17
        PushMultiProcessSharedProvider.a r102 = r100.f513691a.b();     // Catch: Throwable -> L17
        r102.f449558b.put("red_badge_launch_times", Integer.valueOf(r101));     // Catch: Throwable -> L17
        r102.a();     // Catch: Throwable -> L17
        mfc.a r103 = mfc.a.a(this.f503297a);     // Catch: Throwable -> L17
        int r104 = this.f503301e;     // Catch: Throwable -> L17
        PushMultiProcessSharedProvider.a r105 = r103.f513691a.b();     // Catch: Throwable -> L17
        r105.f449558b.put("red_badge_show_times", Integer.valueOf(r104));     // Catch: Throwable -> L17
        r105.a();     // Catch: Throwable -> L17
        mfc.a r106 = mfc.a.a(this.f503297a);     // Catch: Throwable -> L17
        d r107 = this.f503302f;     // Catch: Throwable -> L17
        String r108 = "";
        if (r107 != null) goto L6;
        String r109 = "";
    L9:
        PushMultiProcessSharedProvider.a r110 = r106.f513691a.b();     // Catch: Throwable -> L17
        r110.f449558b.put("red_badge_last_time_paras", r109);     // Catch: Throwable -> L17
        r110.a();     // Catch: Throwable -> L17
        mfc.a r111 = mfc.a.a(this.f503297a);     // Catch: Throwable -> L17
        d r112 = this.f503303g;     // Catch: Throwable -> L17
        if (r112 == null) goto L15;
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L17
        r113.put(EventVerify.TYPE_LAUNCH, r112.f503310a);     // Catch: Throwable -> L20
        r113.put("leave", r112.f503311b);     // Catch: Throwable -> L20
        r113.put(IAllianceService.CONTENT_TYPE_BADGE, r112.f503312c);     // Catch: Throwable -> L20
    L14:
        r108 = r113.toString();     // Catch: Throwable -> L17
    L15:
        PushMultiProcessSharedProvider.a r114 = r111.f513691a.b();     // Catch: Throwable -> L17
        r114.f449558b.put("red_badge_last_last_time_paras", r108);     // Catch: Throwable -> L17
        r114.a();     // Catch: Throwable -> L17
        return;
    L6:
        JSONObject r115 = new JSONObject();     // Catch: Throwable -> L17
        r115.put(EventVerify.TYPE_LAUNCH, r107.f503310a);     // Catch: Throwable -> L21
        r115.put("leave", r107.f503311b);     // Catch: Throwable -> L21
        r115.put(IAllianceService.CONTENT_TYPE_BADGE, r107.f503312c);     // Catch: Throwable -> L21
    L8:
        r109 = r115.toString();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    public c(Context r100) {
        this.f503304h = new b(this, this.f503298b);
        this.f503305i = new C6548c(this, this.f503298b);
        Context r101 = r100.getApplicationContext();
        this.f503297a = r101;
        this.f503298b = new WeakHandler(PushThreadHandlerManager.inst().getLooper(), this);
        this.f503300d = mfc.a.a(r101).f513691a.d("red_badge_launch_times", 0);     // Catch: Throwable -> L22
        this.f503301e = mfc.a.a(r101).f513691a.d("red_badge_show_times", 0);     // Catch: Throwable -> L22
        String r102 = mfc.a.a(r101).f513691a.e("red_badge_last_time_paras");     // Catch: Throwable -> L22
        if (StringUtils.isEmpty(r102) == true) goto L6;
        this.f503302f = d.a(r102);     // Catch: Throwable -> L22
    L6:
        String r103 = mfc.a.a(r101).f513691a.e("red_badge_last_last_time_paras");     // Catch: Throwable -> L22
        if (StringUtils.isEmpty(r103) == true) goto L9;
        this.f503303g = d.a(r103);     // Catch: Throwable -> L22
    L9:
        d r104 = this.f503302f;     // Catch: Throwable -> L22
        if (r104 == null) goto L24;
        boolean r105 = true;
        if (DateUtils.isToday(r104.f503310a) == true) goto L14;
        this.f503300d = 0;     // Catch: Throwable -> L22
        boolean r106 = true;
    L16:
        if (DateUtils.isToday(this.f503302f.f503312c) == true) goto L18;
        this.f503301e = 0;     // Catch: Throwable -> L22
    L19:
        if (r105 == false) goto L24;
        c();     // Catch: Throwable -> L22
        goto L24
    L18:
        r105 = r106;
        goto L19
    L14:
        r106 = false;
    L24:
        PushThreadHandlerManager.inst().postRunnable(new a(this, r100));
        return;
    L22:
        th = move-exception;
        th.printStackTrace();
        goto L24
    }

    public final void b(int r100) {
        long r101 = ToolUtils.currentTimeMillis();     // Catch: Throwable -> L25
        if (this.f503302f != null) goto L6;
        this.f503302f = new d();     // Catch: Throwable -> L25
    L6:
        if (this.f503303g != null) goto L9;
        this.f503303g = new d();     // Catch: Throwable -> L25
    L9:
        if (DateUtils.isToday(this.f503302f.f503310a) == true) goto L12;
        this.f503300d = 0;     // Catch: Throwable -> L25
    L12:
        if (DateUtils.isToday(this.f503302f.f503312c) == true) goto L15;
        this.f503301e = 0;     // Catch: Throwable -> L25
    L15:
        if (r100 == 0) goto L22;
        if (r100 != 1) goto L18;
        this.f503302f.f503311b = r101;     // Catch: Throwable -> L25
    L23:
        c();     // Catch: Throwable -> L25
        return;
    L18:
        if (r100 != 2) goto L23;
        d r102 = this.f503303g;     // Catch: Throwable -> L25
        d r103 = this.f503302f;     // Catch: Throwable -> L25
        r102.f503312c = r103.f503312c;     // Catch: Throwable -> L25
        r103.f503312c = r101;     // Catch: Throwable -> L25
        this.f503301e++;     // Catch: Throwable -> L25
        goto L23
    L22:
        d r104 = this.f503303g;     // Catch: Throwable -> L25
        d r105 = this.f503302f;     // Catch: Throwable -> L25
        r104.f503310a = r105.f503310a;     // Catch: Throwable -> L25
        r104.f503311b = r105.f503311b;     // Catch: Throwable -> L25
        r105.f503310a = r101;     // Catch: Throwable -> L25
        r105.f503311b = r101 + 900000;     // Catch: Throwable -> L25
        this.f503300d++;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L59;
        return;
    L59:
        int r101 = r100.what;     // Catch: Throwable -> L56
        if (r101 != 0) goto L8;
        b(0);     // Catch: Throwable -> L56
        if (PushServiceManager.get().getPullExternalService().allowAutoDismissBadge() == false) goto L40;
        PushServiceManager.get().getIRedBadgeExternalService().removeCount(this.f503297a);     // Catch: Throwable -> L56
    L40:
        if (com.bytedance.push.utils.f.f267065a == false) goto L43;
        com.bytedance.push.utils.f.b("RedBadgeControlClient", "isAllowRedBadgeShow = " + this.f503299c);     // Catch: Throwable -> L56
    L43:
        if (this.f503299c == true) goto L45;
        return;
    L45:
        if (PushServiceManager.get().getPushExternalService().curIsWorkerProcess(this.f503297a) == false) goto L54;
        zfc.a.a().W2();     // Catch: Throwable -> L56
        kfc.d r102 = kfc.d.d(w67.a.C8076a.f558434a);     // Catch: Throwable -> L56
        if (r102.f503319e == true) goto L51;
        return;
    L51:
        if (r102.f503331q == true) goto L70;
        r102.f503318d.sendEmptyMessage(1);     // Catch: Throwable -> L56
        return;
    L70:
        return;
    L54:
        Intent r103 = new Intent(this.f503297a, RedBadgePushProcessService.class);     // Catch: Throwable -> L56
        r103.putExtra("app_entrance", true);     // Catch: Throwable -> L56
        this.f503297a.startService(r103);     // Catch: Throwable -> L56
        return;
    L8:
        if (r101 == 1) goto L20;
        if (r101 != 2) goto L11;
        b(1);     // Catch: Throwable -> L56
        return;
    L11:
        if (r101 == 3) goto L14;
        return;
    L14:
        if (PushServiceManager.get().getPullExternalService().allowAutoDismissBadge() == false) goto L17;
        PushServiceManager.get().getIRedBadgeExternalService().removeCount(this.f503297a);     // Catch: Throwable -> L56
    L17:
        if (com.bytedance.push.utils.f.f267065a == false) goto L60;
        com.bytedance.push.utils.f.b("RedBadgeControlClient", "force clear redBadge");     // Catch: Throwable -> L56
        return;
    L60:
        return;
    L20:
        b(1);     // Catch: Throwable -> L56
        if (com.bytedance.push.utils.f.f267065a == false) goto L24;
        com.bytedance.push.utils.f.b("RedBadgeControlClient", "isAllowRedBadgeShow = " + this.f503299c);     // Catch: Throwable -> L56
    L24:
        if (this.f503299c == true) goto L26;
        return;
    L26:
        if (PushServiceManager.get().getPushExternalService().curIsWorkerProcess(this.f503297a) == false) goto L35;
        zfc.a.a().W2();     // Catch: Throwable -> L56
        kfc.d r104 = kfc.d.d(w67.a.C8076a.f558434a);     // Catch: Throwable -> L56
        if (r104.f503319e == true) goto L32;
        return;
    L32:
        if (r104.f503331q == true) goto L65;
        r104.f503318d.sendEmptyMessage(2);     // Catch: Throwable -> L56
        return;
    L65:
        return;
    L35:
        Intent r105 = new Intent(this.f503297a, RedBadgePushProcessService.class);     // Catch: Throwable -> L56
        r105.putExtra("app_exit", true);     // Catch: Throwable -> L56
        this.f503297a.startService(r105);     // Catch: Throwable -> L56
        return;
    L56:
        th = move-exception;
        th.printStackTrace();
    }

    public final void a(String r210, boolean r211, String r212, String r213) {
        if (r210 != null) goto L6;
        return;
    L6:
        if (this.f503297a != null) goto L8;
        return;
    L8:
        if (this.f503299c == false) goto L66;
        if (com.bytedance.push.utils.f.f267065a == false) goto L13;
        com.bytedance.push.utils.f.b("RedBadgeControlClient", "handleMessage = ".concat(r210));     // Catch: Throwable -> L54
    L13:
        JSONObject r100 = new JSONObject(r210);     // Catch: Throwable -> L54
        if (r100.optInt("show") > 0) goto L16;
        return;
    L16:
        String r101 = r100.optString("content_type");     // Catch: Throwable -> L54
        String r102 = r100.optString("content");     // Catch: Throwable -> L54
        long r110 = new JSONObject(r210).optLong("rule_id");     // Catch: Exception -> L20 Throwable -> L54
    L23:
        if (StringUtils.isEmpty(r101) == false) goto L25;
        return;
    L25:
        if (StringUtils.isEmpty(r102) == false) goto L27;
        return;
    L27:
        if (com.ss.android.pushmanager.setting.a.b().d() == false) goto L30;
        return;
    L30:
        if ("desktop_red_badge".equals(r101) == false) goto L47;
        int r103 = 1;
        int r104 = CastIntegerProtector.parseInt(r102);     // Catch: Throwable -> L34
    L35:
        if (r104 <= 0) goto L44;
        PushServiceManager.get().getIRedBadgeExternalService().applyCount(this.f503297a, r104);     // Catch: Throwable -> L54
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L54
        r105.put("content", r102);     // Catch: Throwable -> L54
        long r111 = r110;
        zfc.a.a().onEvent(this.f503297a, PushLog.CATEGORY, "red_badge", "desktop_red_badge", r104, 0, r105);     // Catch: Throwable -> L54
        Bundle r106 = new Bundle();     // Catch: Throwable -> L54
        r106.putInt("badge_number", r104);     // Catch: Throwable -> L54
        if (this.f503299c == true) goto L40;
        r103 = 0;
    L40:
        r106.putInt("red_badge_is_open", r103);     // Catch: Throwable -> L54
        r106.putString("show_type", "request");     // Catch: Throwable -> L54
        r106.putLong("rule_id", r111);     // Catch: Throwable -> L54
        r106.putBoolean("has_app_foreground", r211);     // Catch: Throwable -> L54
        r106.putString("red_data_from", r212);     // Catch: Throwable -> L54
        if (TextUtils.isEmpty(r213) == true) goto L43;
        r106.putString("use_last_resp_reason", r213);     // Catch: Throwable -> L54
    L43:
        zfc.a.a().V(r106);     // Catch: Throwable -> L54
    L45:
        b(2);     // Catch: Throwable -> L54
        return;
    L44:
        PushServiceManager.get().getIRedBadgeExternalService().removeCount(this.f503297a);     // Catch: Throwable -> L54
        goto L45
    L34:
        r104 = new Random().nextInt(5) + 1;     // Catch: Throwable -> L54
        goto L35
    L47:
        if ("notification".equals(r101) == false) goto L65;
        zfc.a.a().U();     // Catch: Throwable -> L54
        Intent r107 = new Intent("com.ss.android.message");     // Catch: Throwable -> L54
        zfc.a.a().F0();     // Catch: Throwable -> L54
        r107.putExtra("message_data", r102);     // Catch: Throwable -> L54
        r107.setPackage(this.f503297a.getPackageName());     // Catch: Throwable -> L54
        this.f503297a.startService(r107);     // Catch: Throwable -> L54
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L54
        r112.put("content", r102);     // Catch: Throwable -> L54
        zfc.a.a().onEvent(this.f503297a, PushLog.CATEGORY, "red_badge", "notification", 0, 0, r112);     // Catch: Throwable -> L54
        return;
    L65:
        return;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L54
        r110 = 0;
    L67:
        return;
    }
}
