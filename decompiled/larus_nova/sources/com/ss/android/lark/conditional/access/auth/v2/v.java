package com.ss.android.lark.conditional.access.auth.v2;

import androidx.room.util.TableInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;

/* JADX INFO: loaded from: classes35.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f417928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f417929b;

    public v(String r100, d r101) {
        this.f417928a = r100;
        this.f417929b = r101;
    }

    public final void a() {
        com.ss.android.lark.storage.kv.repo.a r100 = y.f417933b;
        if (r100 == null) goto L17;
        String r101 = this.f417928a;
        d r102 = this.f417929b;
        if (r100.a(r101, d.class) == false) goto L8;
        r100.putJSONObject(r101, r102);
        return;
    L8:
        String r103 = TableInfo.Index.DEFAULT_PREFIX + y.f417935d;
        if (r100.a(r103, String.class) == false) goto L13;
        String r104 = r100.getString(r103, null);
        if (r104 == null) goto L13;
        r100.remove(r104);
    L13:
        r100.putJSONObject(r101, r102);
        r100.putString(r103, r101);
        y.f417935d = (y.f417935d + 1) % y.f417936e;
        y.f417937f = Math.min(y.f417937f + 1, y.f417936e);
        r100.putInt("IM_FILE_READ_HEAD", y.f417935d);
        r100.putInt("IM_FILE_READ_COUNT", y.f417937f);
        if ((y.f417937f % 100) != 0) goto L18;
        FileAuthMonitor.UpdateTrigger[] r105 = FileAuthMonitor.f418450a;
        FileAuthMonitor.k("PointKey_IM_MSG_FILE_READ", y.f417937f);
        return;
    L18:
        return;
    }

    @Override // java.lang.Runnable
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
}
