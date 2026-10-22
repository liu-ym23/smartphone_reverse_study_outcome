package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.xiaomi.push.gj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f464194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Object f1034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static WeakHashMap<Integer, af> f1035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f1036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f1037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f464195b;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f1035a = new WeakHashMap();
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List<NotificationChannel> m9353a() {
        String r100 = this.f1037a;
        List<NotificationChannel> r101 = null;
    L25:
        e = move-exception;
        m9345a("getNotificationChannels error " + e);
        return r101;
    L4:
        if (m9346a() == false) goto L13;
        int r102 = a(r100);     // Catch: Exception -> L25
        if (r102 == (-1)) goto L12;
        Object r103 = f1034a;     // Catch: Exception -> L25
        Object[] r104 = {r100, Integer.valueOf(r102), Boolean.FALSE};     // Catch: Exception -> L25
        String r105 = "mipush|%s|%s";
        r101 = (List) a(com.xiaomi.push.av.a(r103, "getNotificationChannelsForPackage", r104));     // Catch: Exception -> L25
    L15:
        if (com.xiaomi.push.j.m9294a() == false) goto L35;
        if (r101 == null) goto L36;
        ArrayList r106 = new ArrayList();     // Catch: Exception -> L25
        String r107 = a(r105, r100, "");     // Catch: Exception -> L25
        Iterator<NotificationChannel> r108 = r101.iterator();     // Catch: Exception -> L25
    L18:
        if (r108.hasNext() == false) goto L37;
        NotificationChannel r109 = r108.next();     // Catch: Exception -> L25
        if (r109.getId().startsWith(r107) == false) goto L18;
        r106.add(r109);     // Catch: Exception -> L25
        goto L18
    L37:
        return r106;
    L36:
        return r101;
    L35:
        return r101;
    L12:
        r105 = null;
        goto L15
    L13:
        r101 = a().getNotificationChannels();     // Catch: Exception -> L25
        r105 = "mipush_%s_%s";
        goto L15
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public List<StatusBarNotification> m9355b() {
        String r100 = this.f1037a;
        NotificationManager r101 = a();
        ArrayList r102 = null;
        int r103 = 0;
        if (m9346a() == false) goto L9;
        int r104 = com.xiaomi.push.i.a();     // Catch: Throwable -> L25
        if (r104 != (-1)) goto L35;
        return null;
    L35:
        return (List) a(com.xiaomi.push.av.a(f1034a, "getAppActiveNotifications", new Object[]{r100, Integer.valueOf(r104)}));
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        StatusBarNotification[] r105 = r101.getActiveNotifications();     // Catch: Throwable -> L25
    L12:
        if (r105 != null) goto L14;
        return null;
    L14:
        if (r105.length <= 0) goto L37;
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L25
        int r107 = r105.length;     // Catch: Throwable -> L23
    L17:
        if (r103 >= r107) goto L38;
        StatusBarNotification r108 = r105[r103];     // Catch: Throwable -> L23
        if (r100.equals(ag.c(r108.getNotification())) == false) goto L21;
        r106.add(r108);     // Catch: Throwable -> L23
    L21:
        r103 = r103 + 1;
        goto L17
    L38:
        return r106;
    L23:
        th = th;
        r102 = r106;
    L26:
        m9345a("getActiveNotifications error " + th);
        return r102;
    L37:
        return null;
    L11:
        r105 = m9348a();     // Catch: Throwable -> L25
    L25:
        th = th;
        goto L26
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f1037a + com.alipay.sdk.m.u.i.f25855d;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private StatusBarNotification[] m9348a() {
        if (com.xiaomi.push.j.m9295a(m9350a()) == false) goto L13;
        Object r100 = com.xiaomi.push.av.a(f1034a, "getActiveNotifications", new Object[]{m9350a().getPackageName()});     // Catch: Throwable -> L8
        if ((r100 instanceof StatusBarNotification[]) == false) goto L14;
        return (StatusBarNotification[]) r100;
    L14:
        return null;
    L8:
        th = move-exception;
        m9345a("getAllNotifications error " + th);
        return null;
    L13:
        return null;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f464195b) == false) goto L6;
        this.f464195b = b("default");
    L6:
        return this.f464195b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m9346a() {
        if (com.xiaomi.push.j.m9294a() == true) goto L6;
        return false;
    L6:
        if (ah.a(f464194a).a(gj.aZ.a(), true) == true) goto L9;
        return false;
    L9:
        return f1036a;
    }

    private static NotificationManager a() {
        return (NotificationManager) f464194a.getSystemService("notification");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Context m9350a() {
        return f464194a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m9351a() {
        return this.f1037a;
    }

    private af(String r100) {
        this.f1037a = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_xiaomi_push_service_af_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private String b(String r100) {
        return b(this.f1037a, r100);
    }

    public void a(int r110) {
        String r100 = this.f1037a;
    L13:
        e = move-exception;
        m9345a("cancel error" + e);
        return;
    L4:
        if (m9346a() == false) goto L11;
        int r101 = com.xiaomi.push.i.a();     // Catch: Exception -> L13
        String r102 = m9350a().getPackageName();     // Catch: Exception -> L13
        if (Build.VERSION.SDK_INT < 30) goto L9;
        com.xiaomi.push.av.b(f1034a, "cancelNotificationWithTag", new Object[]{r100, r102, null, Integer.valueOf(r110), Integer.valueOf(r101)});     // Catch: Exception -> L13
    L10:
        m9345a("cancel succ:" + r110);     // Catch: Exception -> L13
        return;
    L9:
        com.xiaomi.push.av.b(f1034a, "cancelNotificationWithTag", new Object[]{r100, null, Integer.valueOf(r110), Integer.valueOf(r101)});     // Catch: Exception -> L13
        goto L10
    L11:
        a().cancel(r110);     // Catch: Exception -> L13
    }

    public void a(NotificationChannel r100) {
        String r101 = this.f1037a;
    L10:
        e = move-exception;
        m9345a("createNotificationChannel error" + e);
        return;
    L4:
        if (m9346a() == false) goto L8;
        int r102 = a(r101);     // Catch: Exception -> L10
        if (r102 == (-1)) goto L13;
        com.xiaomi.push.av.b(f1034a, "createNotificationChannelsForPackage", new Object[]{r101, Integer.valueOf(r102), a(Arrays.asList(new NotificationChannel[]{r100}))});     // Catch: Exception -> L10
    L13:
        return;
    L8:
        a().createNotificationChannel(r100);     // Catch: Exception -> L10
        goto L13
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NotificationChannel m9349a(String r100) {
        NotificationChannel r101 = null;
    L15:
        e = move-exception;
        m9345a("getNotificationChannel error" + e);
    L17:
        return r101;
    L4:
        if (m9346a() == false) goto L14;
        List<NotificationChannel> r102 = m9353a();     // Catch: Exception -> L15
        if (r102 == null) goto L18;
        Iterator<NotificationChannel> r103 = r102.iterator();     // Catch: Exception -> L15
    L9:
        if (r103.hasNext() == false) goto L18;
        NotificationChannel r104 = r103.next();     // Catch: Exception -> L15
        if (r100.equals(r104.getId()) == false) goto L9;
        r101 = r104;
    L18:
        goto L17
    L14:
        r101 = a().getNotificationChannel(r100);     // Catch: Exception -> L15
        goto L18
    }

    private static void a(Context r100) {
        if (f464194a != null) goto L12;
        f464194a = r100.getApplicationContext();
        NotificationManager r101 = a();
        Boolean r102 = (Boolean) com.xiaomi.push.av.a(r101, "isSystemConditionProviderEnabled", new Object[]{"xmsf_fake_condition_provider_path"});
        m9345a("fwk is support.init:" + r102);
        if (r102 == null) goto L7;
        boolean r103 = r102.booleanValue();
    L8:
        f1036a = r103;
        if (r103 == false) goto L13;
        f1034a = com.xiaomi.push.av.a(r101, "getService", new Object[0]);
        return;
    L13:
        return;
    L7:
        r103 = false;
        goto L8
    }

    private static Object a(List r100) {
        return INVOKESTATIC_com_xiaomi_push_service_af_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.pm.ParceledListSlice").getConstructor(new Class[]{List.class}).newInstance(new Object[]{r100});
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m9352a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return b();
    L6:
        if (com.xiaomi.push.j.m9295a(m9350a()) == true) goto L8;
        return r100;
    L8:
        return b(r100);
    }

    private static <T> T a(Object r100) {
        if (r100 != null) goto L8;
        return null;
    L8:
        return (T) r100.getClass().getMethod("getList", new Class[0]).invoke(r100, new Object[0]);
    L10:
        return null;
    }

    private static int a(String r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L9;
        return -1;
    L9:
        return f464194a.getPackageManager().getPackageUid(r100, 0);
    L11:
        return -1;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9354a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        return r100.startsWith(b(""));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m9345a(String r100) {
        com.xiaomi.channel.commonutils.logger.b.m8718a("NMHelper:" + r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9347a(Context r100) {
        a(r100);
        return m9346a();
    }

    public static String b(String r100, String r101) {
        if (m9346a() == false) goto L5;
        String r102 = "mipush|%s|%s";
    L7:
        return a(r102, r100, r101);
    L5:
        r102 = "mipush_%s_%s";
        goto L7
    }

    public void a(NotificationChannel r100, boolean r101) {
        String r102 = this.f1037a;
        if (r101 == false) goto L7;
        int r103 = a(r102);     // Catch: Exception -> L9
        if (r103 == (-1)) goto L12;
        com.xiaomi.push.av.b(f1034a, "updateNotificationChannelForPackage", new Object[]{r102, Integer.valueOf(r103), r100});     // Catch: Exception -> L9
    L12:
        return;
    L7:
        a(r100);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        m9345a("updateNotificationChannel error " + e);
    }

    public String c(String r100, String r101) {
        if (m9346a() == false) goto L6;
        return r100;
    L6:
        return r101;
    }

    public void a(int r100, Notification r101) {
        String r102 = this.f1037a;
        NotificationManager r103 = a();
        int r104 = Build.VERSION.SDK_INT;     // Catch: Exception -> L11
        if (m9346a() == false) goto L9;
        r101.extras.putString("xmsf_target_package", r102);     // Catch: Exception -> L11
        if (r104 < 29) goto L8;
        r103.notifyAsPackage(r102, null, r100, r101);     // Catch: Exception -> L11
    L12:
        return;
    L8:
        r103.notify(r100, r101);     // Catch: Exception -> L11
        goto L12
    L9:
        r103.notify(r100, r101);     // Catch: Exception -> L11
    }

    public static af a(Context r100, String r101) {
        a(r100);
        int r102 = r101.hashCode();
        af r103 = f1035a.get(Integer.valueOf(r102));
        if (r103 != null) goto L6;
        af r104 = new af(r101);
        f1035a.put(Integer.valueOf(r102), r104);
        return r104;
    L6:
        return r103;
    }

    public static String a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        String r102 = a("mipush|%s|%s", r101, "");
        if (r100.startsWith(r102) == true) goto L7;
        return r100;
    L7:
        return a("mipush_%s_%s", r101, r100.replace(r102, ""));
    L8:
        return r100;
    }

    private static String a(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        return String.format(r100, new Object[]{r101, r102});
    }
}
