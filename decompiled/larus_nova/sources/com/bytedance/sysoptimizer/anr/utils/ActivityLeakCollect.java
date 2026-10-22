package com.bytedance.sysoptimizer.anr.utils;

import android.app.Activity;
import android.app.Application;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityLeakCollect {
    private static final String TAG = "SysAnrOpt";
    private static List<WeakReference<Activity>> activityReferences;
    private static Map<String, Integer> leakCountMap;

    public ActivityLeakCollect() {
    }

    static {
        activityReferences = new ArrayList();
        leakCountMap = new HashMap();
    }

    private static void checkForLeaks() {
        leakCountMap.clear();     // Catch: Exception -> L10
        Iterator<WeakReference<Activity>> r100 = activityReferences.iterator();     // Catch: Exception -> L10
    L3:
        if (r100.hasNext() == false) goto L21;
        Activity r101 = r100.next().get();     // Catch: Exception -> L10
        if (r101 == null) goto L7;
        String r102 = r101.getClass().getSimpleName();     // Catch: Exception -> L10
        Map<String, Integer> r103 = leakCountMap;     // Catch: Exception -> L10
        r103.put(r102, Integer.valueOf(r103.getOrDefault(r102, 0).intValue() + 1));     // Catch: Exception -> L10
        goto L3
    L7:
        r100.remove();     // Catch: Exception -> L10
        goto L3
    L21:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public static Map<String, Integer> getLeaksGreaterThanOne() {
        HashMap r100 = new HashMap();
        Iterator<Map.Entry<String, Integer>> r101 = getLeakCountMap().entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<String, Integer> r102 = r101.next();
        if (r102.getValue().intValue() > 1) goto L7;
        String r103 = r102.getKey();
        goto L4
    L7:
        r100.put(r102.getKey(), r102.getValue());
        goto L4
    L9:
        return r100;
    }

    public static Map<String, Integer> getLeakCountMap() {
        checkForLeaks();
        return leakCountMap;
    }

    public static /* synthetic */ List access$000() {
        return activityReferences;
    }

    public static void registerActivity(Application r100) {
        r100.registerActivityLifecycleCallbacks(new AnonymousClass1());
    }
}
