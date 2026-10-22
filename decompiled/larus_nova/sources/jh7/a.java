package jh7;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f499098a = 0;

    static {
    }

    public static String a(Throwable r110) {
        String r100 = r110.getMessage();
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        ArrayList r101 = new ArrayList();
        StackTraceElement[] r102 = r110.getStackTrace();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L30;
        StackTraceElement r105 = r102[r104];
        String r106 = r105.getClassName();
        if (r106 != null) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == true) goto L29;
        if (StringsKt.startsWith$default(r105.getClassName(), "com.bytedance.timonbase.pipeline.TimonPipeline", false, 2, null) == true) goto L29;
        if (StringsKt.startsWith$default(r105.getClassName(), "com.bytedance.timon_monitor_impl.basicpipline", false, 2, null) == true) goto L29;
        if (StringsKt.startsWith$default(r105.getClassName(), "com.bytedance.timon_monitor_impl.TimonPipelineActionInvoker", false, 2, null) == true) goto L29;
        if (StringsKt.startsWith$default(r105.getClassName(), "com.bytedance.timon_monitor_impl.TimonActionInvoker", false, 2, null) == true) goto L29;
        if (StringsKt.startsWith$default(r105.getClassName(), "com.bytedance.helios.sdk.ActionInvoker", false, 2, null) == true) goto L29;
        if (StringsKt.startsWith$default(r105.getClassName(), "com.bytedance.helios.statichook", false, 2, null) == true) goto L29;
        r101.add(r105);
    L29:
        r104 = r104 + 1;
        goto L7
    L11:
        if (r106.length() == 0) goto L14;
        r107 = false;
        goto L15
    L30:
        StringBuilder r108 = new StringBuilder();
        r108.append(r110.getClass().getName());
        r108.append(": ");
        r108.append(r100);
        r108.append('\n');
        Iterator r109 = r101.iterator();
    L32:
        if (r109.hasNext() == false) goto L35;
        StackTraceElement r111 = (StackTraceElement) r109.next();
        r108.append("at ");
        r108.append(r111.toString());
        r108.append('\n');
        goto L32
    L35:
        return r108.toString();
    }
}
