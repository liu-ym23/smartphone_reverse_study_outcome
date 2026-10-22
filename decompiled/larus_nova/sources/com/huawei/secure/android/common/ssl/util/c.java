package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* JADX INFO: loaded from: classes23.dex */
public class c extends AsyncTask<Context, Integer, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278182a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f278183b = 432000000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f278184c = "lastCheckTime";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f278185d;

    static {
        f278182a = "c";
        f278185d = false;
    }

    private static boolean b() {
        if (f278185d == false) goto L5;
        return false;
    L5:
        Context r100 = ContextUtil.getInstance();
        if (r100 != null) goto L9;
        e.e(f278182a, "checkUpgradeBks, context is null");
        return false;
    L9:
        f278185d = true;
        long r101 = g.a(f278184c, 0, r100);
        long r102 = System.currentTimeMillis();
        if ((r102 - r101) <= f278183b) goto L13;
        g.b(f278184c, r102, r100);
        return true;
    L13:
        e.c(f278182a, "checkUpgradeBks, ignore");
        return false;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        e.a(f278182a, "onPreExecute");
    }

    public static void a() {
        if (b() == false) goto L6;
        e.c(f278182a, "checkUpgradeBks, execute check task");
        new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Context[]{ContextUtil.getInstance()});
        return;
    }

    public c() {
    }

    public Boolean a(Context... r100) {
        long r101 = System.currentTimeMillis();
        InputStream r102 = BksUtil.getBksFromTss(r100[0]);     // Catch: Exception -> L5
    L7:
        e.a(f278182a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - r101) + " ms");
        if (r102 == null) goto L12;
        d.a(r102);
        return Boolean.TRUE;
    L12:
        return Boolean.FALSE;
    L5:
        e = move-exception;
        e.b(f278182a, "doInBackground: exception : " + e.getMessage());
        r102 = null;
        goto L7
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Boolean doInBackground(Context[] r100) {
        return a(r100);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Boolean r100) {
        a(r100);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onProgressUpdate(Integer[] r100) {
        a(r100);
    }

    public void a(Boolean r100) {
        if (r100.booleanValue() == false) goto L5;
        e.c(f278182a, "onPostExecute: upate done");
        return;
    L5:
        e.b(f278182a, "onPostExecute: upate failed");
    }

    public void a(Integer... r100) {
        e.c(f278182a, "onProgressUpdate");
    }
}
