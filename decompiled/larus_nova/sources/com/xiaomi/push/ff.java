package com.xiaomi.push;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.vivo.push.PushClientConstants;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes41.dex */
public final class ff {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f463529a = 5000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Vector<String> f566a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f463530b = 330000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f463531c = 600000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f463532d = 330000;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m9091a() {
        return "3.1.0";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static ClassLoader[] m9092a() {
        int r100 = 0;
        ClassLoader[] r101 = {ff.class.getClassLoader(), ThreadMethodProxy.currentThread().getContextClassLoader()};
        ArrayList r102 = new ArrayList();
    L3:
        if (r100 >= 2) goto L9;
        ClassLoader r103 = r101[r100];
        if (r103 == null) goto L7;
        r102.add(r103);
    L7:
        r100 = r100 + 1;
        goto L3
    L9:
        return (ClassLoader[]) r102.toArray(new ClassLoader[r102.size()]);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f566a = new Vector();
        ClassLoader[] r100 = m9092a();     // Catch: Exception -> L37
        int r101 = r100.length;     // Catch: Exception -> L37
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L55;
        Enumeration<URL> r103 = r100[r102].getResources("META-INF/smack-config.xml");     // Catch: Exception -> L37
    L7:
        if (r103.hasMoreElements() == false) goto L36;
        InputStream r104 = null;
        r104 = r103.nextElement().openStream();     // Catch: Throwable -> L29 Exception -> L31
        XmlPullParser r105 = XmlPullParserFactory.newInstance().newPullParser();     // Catch: Throwable -> L29 Exception -> L31
        r105.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);     // Catch: Throwable -> L29 Exception -> L31
        r105.setInput(r104, "UTF-8");     // Catch: Throwable -> L29 Exception -> L31
        int r106 = r105.getEventType();     // Catch: Throwable -> L29 Exception -> L31
    L12:
        if (r106 == 2) goto L14;
    L25:
        r106 = r105.next();     // Catch: Throwable -> L29 Exception -> L31
        if (r106 != 1) goto L12;
    L46:
        r104.close();     // Catch: Exception -> L40
        goto L7
    L14:
        if (r105.getName().equals(PushClientConstants.TAG_CLASS_NAME) == false) goto L17;
        a(r105);     // Catch: Throwable -> L29 Exception -> L31
        goto L25
    L17:
        if (r105.getName().equals("packetReplyTimeout") == false) goto L20;
        f463529a = a(r105, f463529a);     // Catch: Throwable -> L29 Exception -> L31
        goto L25
    L20:
        if (r105.getName().equals("keepAliveInterval") == false) goto L23;
        f463530b = a(r105, f463530b);     // Catch: Throwable -> L29 Exception -> L31
        goto L25
    L23:
        if (r105.getName().equals("mechName") == false) goto L25;
        f566a.add(r105.nextText());     // Catch: Throwable -> L29 Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r104.close();     // Catch: Exception -> L41
    L35:
        throw th;     // Catch: Exception -> L37
    L36:
        r102 = r102 + 1;
        goto L4
    L55:
        return;
    L37:
        e = move-exception;
        e.printStackTrace();
    }

    private ff() {
    }

    public static int b() {
        return f463531c;
    }

    public static int a() {
        return f463530b;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_xiaomi_push_ff_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static void a(XmlPullParser r100) {
        String r101 = r100.nextText();
        INVOKESTATIC_com_xiaomi_push_ff_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101);     // Catch: ClassNotFoundException -> L5
        return;
    L5:
        System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: " + r101);
    }

    private static int a(XmlPullParser r100, int r101) {
        return CastIntegerProtector.parseInt(r100.nextText());
    L4:
        e = move-exception;
        e.printStackTrace();
        return r101;
    }
}
