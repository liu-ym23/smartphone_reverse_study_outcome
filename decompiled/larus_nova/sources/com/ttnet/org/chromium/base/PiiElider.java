package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import android.util.Patterns;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class PiiElider {
    private static final String[] APP_NAMESPACE = null;
    private static final String CONSOLE_ELISION = "[ELIDED:CONSOLE(0)] ELIDED CONSOLE MESSAGE";
    private static final Pattern CONSOLE_MSG = null;
    private static final String DOMAIN_NAME = "(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))";
    private static final String EMAIL_ELISION = "XXX@EMAIL.ELIDED";
    private static final String GOOD_GTLD_CHAR = "a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef";
    private static final String GOOD_IRI_CHAR = "a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef";
    private static final String GTLD = "[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}";
    private static final String HOST_NAME = "([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}";
    private static final String INTENT = "([a-zA-Z][a-zA-Z0-9+.-]+://((([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+))";
    private static final String INTENT_SCHEME = "[a-zA-Z][a-zA-Z0-9+.-]+://";
    private static final String IP_ADDRESS = "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))";
    private static final String IP_ELISION = "1.2.3.4";
    private static final String IRI = "[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}";
    private static final Pattern LIKELY_EXCEPTION_LOG = null;
    private static final Pattern MAC_ADDRESS = null;
    private static final String MAC_ELISION = "01:23:45:67:89:AB";
    private static final String PATH_CHAR = "(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))";
    private static final String PATH_COMPONENT = "((([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+)";
    private static final String PORT = "(:\\d{1,5})";
    private static final String[] SYSTEM_NAMESPACE = null;
    private static final String URI_CHAR = "([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2}))";
    private static final String URI_ENCODED_CHAR = "(%[a-fA-F0-9]{2})";
    private static final String URI_SCHEME = "((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)";
    private static final String URL_ELISION = "HTTP://WEBADDRESS.ELIDED";
    private static final String URL_OR_INTENT = "((((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)?(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(:\\d{1,5})?)|([a-zA-Z][a-zA-Z0-9+.-]+://((([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+)))";
    private static final String URL_WITH_OPTIONAL_SCHEME_AND_PORT = "(((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)?(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(:\\d{1,5})?)";
    private static final Pattern WEB_URL = null;

    public PiiElider() {
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    static {
        WEB_URL = PatternProtector.compile("(\\b|^)(((((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)?(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(:\\d{1,5})?)|([a-zA-Z][a-zA-Z0-9+.-]+://((([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+))))(/(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))*)?(\\b|$)");
        LIKELY_EXCEPTION_LOG = PatternProtector.compile("\\sat\\sorg\\.chromium\\.[^ ]+.|Caused by: java.lang.(ClassNotFoundException|NoClassDefFoundError):");
        MAC_ADDRESS = PatternProtector.compile("([0-9a-fA-F]{2}[-:]+){5}[0-9a-fA-F]{2}");
        CONSOLE_MSG = PatternProtector.compile("\\[\\w*:CONSOLE.*\\].*");
        APP_NAMESPACE = new String[]{"com.ttnet.org.chromium.", "com.google.", "com.chrome."};
        SYSTEM_NAMESPACE = new String[]{"android.", "com.android.", "dalvik.", "java.", "javax.", "org.apache.", "org.json.", "org.w3c.dom.", "org.xml.", "org.xmlpull."};
    }

    public static String elideConsole(String r100) {
        return CONSOLE_MSG.matcher(r100).replaceAll(CONSOLE_ELISION);
    L4:
        return "";
    }

    public static String elideEmail(String r100) {
        return Patterns.EMAIL_ADDRESS.matcher(r100).replaceAll(EMAIL_ELISION);
    L4:
        return "";
    }

    public static String elideIp(String r100) {
        return Patterns.IP_ADDRESS.matcher(r100).replaceAll(IP_ELISION);
    L4:
        return "";
    }

    public static String elideMac(String r100) {
        return MAC_ADDRESS.matcher(r100).replaceAll(MAC_ELISION);
    L4:
        return "";
    }

    public static String elideUrl(String r100) {
    L18:
        return "";
    L3:
        if (LIKELY_EXCEPTION_LOG.matcher(r100).find() == false) goto L5;
        return r100;
    L5:
        StringBuilder r101 = new StringBuilder(r100);     // Catch: IllegalArgumentException -> L18
        Matcher r102 = WEB_URL.matcher(r101);     // Catch: IllegalArgumentException -> L18
        int r103 = 0;
    L7:
        if (r102.find(r103) == false) goto L16;
        int r104 = r102.start();     // Catch: IllegalArgumentException -> L18
        int r105 = r102.end();     // Catch: IllegalArgumentException -> L18
        String r106 = r101.substring(r104, r105);     // Catch: IllegalArgumentException -> L18
        if (likelyToBeAppNamespace(r106) == true) goto L15;
        if (likelyToBeSystemNamespace(r106) == true) goto L15;
        if (likelyToBeClassOrMethodName(r106) == true) goto L15;
        r101.replace(r104, r105, URL_ELISION);     // Catch: IllegalArgumentException -> L18
        r103 = r104 + 24;     // Catch: IllegalArgumentException -> L18
        r102 = WEB_URL.matcher(r101);     // Catch: IllegalArgumentException -> L18
    L15:
        r103 = r105;
        goto L7
    L16:
        return r101.toString();
    }

    private static boolean isClassName(String r100) {
        INVOKESTATIC_com_ttnet_org_chromium_base_PiiElider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100, false, ContextUtils.getApplicationContext().getClassLoader());     // Catch: Throwable -> L6
        return true;
    L6:
        return false;
    }

    private static boolean likelyToBeAppNamespace(String r100) {
        String[] r101 = APP_NAMESPACE;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r100.startsWith(r101[r103]) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static boolean likelyToBeClassOrMethodName(String r100) {
        if (isClassName(r100) == false) goto L6;
        return true;
    L6:
        int r101 = r100.lastIndexOf(".");
        if (r101 != (-1)) goto L10;
        return false;
    L10:
        return isClassName(r100.substring(0, r101));
    }

    private static boolean likelyToBeSystemNamespace(String r100) {
        String[] r101 = SYSTEM_NAMESPACE;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r100.startsWith(r101[r103]) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static String sanitizeStacktrace(String r100) {
        String[] r101 = r100.split("\\n");
        r101[0] = elideUrl(r101[0]);
        int r102 = 1;
    L4:
        if (r102 >= r101.length) goto L10;
        if (r101[r102].startsWith("Caused by:") == false) goto L8;
        r101[r102] = elideUrl(r101[r102]);
    L8:
        r102 = r102 + 1;
        goto L4
    L10:
        return TextUtils.join("\n", r101);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ttnet_org_chromium_base_PiiElider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
}
