package v71;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import m71.c;
import n71.b;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f553415a = 0;

    @JvmStatic
    public static final boolean a() {
        b r100 = c.f512325a.getValue();
        if (r100 == null) goto L7;
        Boolean r101 = r100.g();
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return false;
    }

    @JvmStatic
    public static final boolean e() {
        b r100 = c.f512325a.getValue();
        if (r100 == null) goto L7;
        Boolean r101 = r100.f();
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return false;
    }

    @JvmStatic
    public static final boolean b() {
        if (a() == false) goto L13;
        b r100 = c.f512325a.getValue();
        if (r100 == null) goto L9;
        Boolean r101 = r100.b();
        if (r101 == null) goto L9;
        boolean r102 = r101.booleanValue();
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r102 = false;
        goto L10
    L13:
        return false;
    }

    @JvmStatic
    public static final boolean c() {
        if (a() == false) goto L13;
        b r100 = c.f512325a.getValue();
        if (r100 == null) goto L9;
        Boolean r101 = r100.c();
        if (r101 == null) goto L9;
        boolean r102 = r101.booleanValue();
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r102 = false;
        goto L10
    L13:
        return false;
    }

    @JvmStatic
    public static final boolean d() {
        if (a() == false) goto L13;
        b r100 = c.f512325a.getValue();
        if (r100 == null) goto L9;
        Boolean r101 = r100.d();
        if (r101 == null) goto L9;
        boolean r102 = r101.booleanValue();
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r102 = false;
        goto L10
    L13:
        return false;
    }

    static {
    }

    @JvmStatic
    public static final String g(Integer r100) {
        StringBuilder r101 = new StringBuilder();
        StackTraceElement[] r102 = ThreadMethodProxy.currentThread().getStackTrace();     // Catch: Exception -> L7
        int r103 = r102.length;     // Catch: Exception -> L7
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L9;
        StackTraceElement r105 = r102[r104];     // Catch: Exception -> L7
        r101.append(r105.getClassName());     // Catch: Exception -> L7
        r101.append(".");     // Catch: Exception -> L7
        r101.append(r105.getMethodName());     // Catch: Exception -> L7
        r101.append("(");     // Catch: Exception -> L7
        r101.append(r105.getFileName());     // Catch: Exception -> L7
        r101.append(":");     // Catch: Exception -> L7
        r101.append(r105.getLineNumber());     // Catch: Exception -> L7
        r101.append(")\n");     // Catch: Exception -> L7
        r104 = r104 + 1;
    L9:
        if (r100 == null) goto L21;
        int r106 = r100.intValue();
        if (r101.length() <= r106) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == true) goto L17;
        r100 = null;
    L17:
        if (r100 == null) goto L21;
        String r108 = r101.substring(0, r100.intValue());
        if (r108 == null) goto L21;
        return r108;
    L13:
        r107 = false;
    L21:
        return r101.toString();
    L7:
        e = move-exception;
        ALogger.e("CardTraceParamsBuilder", e);
        goto L9
    }

    @JvmStatic
    public static final String f(o r100, DataCenter r101) {
        if (r100 == null) goto L19;
        Map<String, String> r102 = r100.F2();
        if (r102 == null) goto L19;
        Boolean r103 = null;
        if ((!r102.isEmpty()) == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L19;
        StringBuilder r104 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r105 = r102.entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        Map.Entry<String, String> r106 = r105.next();
        r104.append(r106.getKey());
        r104.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r104.append(r106.getValue());
        r104.append(",");
        goto L12
    L14:
        StringBuilder r107 = new StringBuilder("is_portrait=");
        if (r101 == null) goto L17;
        r103 = (Boolean) r101.get("data_is_portrait", Boolean.TRUE);
    L17:
        r107.append(r103);
        r104.append(r107.toString());
        String r108 = r104.toString();
        if (r108 == null) goto L19;
        return r108;
    L19:
        return "null";
    }
}
