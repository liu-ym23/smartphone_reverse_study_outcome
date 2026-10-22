package com.bytedance.memory.upload;

import com.bytedance.apm.util.MultiProcessSharedPreferences;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends TimerTask {
    public static void a() {
        r17.c.b("setUploadDumpCost " + c.f265542h, new Object[0]);
        int r100 = c.f265542h;
        if (c.f265541g != null) goto L5;
        StringBuilder r101 = new StringBuilder();
        s17.c.b().getClass();
        r101.append(s17.c.f540158h);
        r101.append("_upload_dump_cost");
        c.f265545k = r101.toString();
        c.f265541g = MultiProcessSharedPreferences.c(q17.a.e().getContext());
    L5:
        c.f265541g.edit().putInt(c.f265545k, r100).commit();
        c.f265542h++;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b() {
    }
}
