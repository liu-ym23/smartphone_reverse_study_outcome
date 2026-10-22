package iaa;

import aiassistant.version.AssistantVersion;
import com.aiassistant.utils.AssistantFeatureValidator;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.utils.ObricFeatureValidator;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import obric.version.ObricVersion;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static int a() {
        int r0 = AssistantVersion.getVersion();     // Catch: Throwable -> L4
    L10:
        ILogDepend.a.i(b.class.getSimpleName(), "getObricApiVersion, version: " + r0);
        return r0;
    L4:
        th = move-exception;
        ILogDepend.a.i(b.class.getSimpleName(), "getAssistantVersion failed, e: " + th);
        r0 = ObricVersion.getVersion();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        ILogDepend.a.w(b.class.getSimpleName(), "getObricVersion failed, e: " + th);
        r0 = -1;
        goto L10
    }

    public static boolean d() {
        if (a() < 10) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "osFeatures");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return true;
    L9:
        if (d() == false) goto L12;
        return AssistantFeatureValidator.hasFeature(r2);
    L12:
        return ObricFeatureValidator.hasFeature(r2);
    L5:
        r0 = false;
        goto L6
    }

    public static boolean c(List r3) {
        Intrinsics.checkNotNullParameter(r3, "osFeatures");
        if (r3.isEmpty() == false) goto L5;
        return true;
    L5:
        List r4 = r3;
        if ((r4 instanceof Collection) == true) goto L8;
    L10:
        Iterator r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L21;
        String r0 = (String) r5.next();
        a.getClass();
        if (b(r0) == true) goto L12;
        return false;
    L21:
        return true;
    L8:
        if (r4.isEmpty() == false) goto L10;
        return true;
    }
}
