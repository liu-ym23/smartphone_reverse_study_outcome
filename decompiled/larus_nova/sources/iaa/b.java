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

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f488963a = null;

    static {
        f488963a = new b();
    }

    public b() {
    }

    public static int a() {
        int r100 = AssistantVersion.getVersion();     // Catch: Throwable -> L4
    L10:
        ILogDepend.f384986a.i(b.class.getSimpleName(), "getObricApiVersion, version: " + r100);
        return r100;
    L4:
        th = move-exception;
        ILogDepend.f384986a.i(b.class.getSimpleName(), "getAssistantVersion failed, e: " + th);
        r100 = ObricVersion.getVersion();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        ILogDepend.f384986a.w(b.class.getSimpleName(), "getObricVersion failed, e: " + th);
        r100 = -1;
        goto L10
    }

    public static boolean d() {
        if (a() < 10) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "osFeatures");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return true;
    L9:
        if (d() == false) goto L12;
        return AssistantFeatureValidator.hasFeature(r100);
    L12:
        return ObricFeatureValidator.hasFeature(r100);
    L5:
        r101 = false;
        goto L6
    }

    public static boolean c(List r100) {
        Intrinsics.checkNotNullParameter(r100, "osFeatures");
        if (r100.isEmpty() == false) goto L5;
        return true;
    L5:
        List r101 = r100;
        if ((r101 instanceof Collection) == true) goto L8;
    L10:
        Iterator r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L21;
        String r103 = (String) r102.next();
        f488963a.getClass();
        if (b(r103) == true) goto L12;
        return false;
    L21:
        return true;
    L8:
        if (r101.isEmpty() == false) goto L10;
        return true;
    }
}
