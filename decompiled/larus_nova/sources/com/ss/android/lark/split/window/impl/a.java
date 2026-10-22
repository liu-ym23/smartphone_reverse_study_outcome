package com.ss.android.lark.split.window.impl;

import android.app.Activity;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f440617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, WeakReference<Activity>> f440618b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f440619c;

    public a() {
    }

    static {
        f440617a = new a();
        f440618b = new ConcurrentHashMap();
        f440619c = -1;
    }

    public static void b(int r100) {
        ConcurrentHashMap<Integer, WeakReference<Activity>> r101 = f440618b;
        if (r101.containsKey(Integer.valueOf(r100)) == false) goto L5;
        r101.remove(Integer.valueOf(r100));
        Log.i("SplitWindow_SplitWindowStackManager", "removeActivityFromStack: taskId=" + r100 + " successfully removed");
        return;
    L5:
        Log.w("SplitWindow_SplitWindowStackManager", "removeActivityFromStack: taskId=" + r100 + " does not exist");
    }

    public static void a(int r100, Activity r101, boolean r102) {
        if (r101 != null) goto L6;
        Log.i("SplitWindow_SplitWindowStackManager", "addActivityToStack: activity is null for taskId=" + r100);
        return;
    L6:
        Log.i("SplitWindow_SplitWindowStackManager", "addActivityToStack: taskId=" + r100 + ", activity=" + r101.getLocalClassName());
        f440618b.put(Integer.valueOf(r100), new WeakReference(r101));
        if (r102 == true) goto L11;
        f440619c = r100;
        return;
    }
}
