package com.ss.android.lark.usersetting.service.timeformat;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.usersetting.base.UserSetting;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserSetting f444652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserSetting f444653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f444654c;

    public final void a() {
        UserSetting r100 = this.f444652a;
        if (r100 != null) goto L5;
        return;
    L5:
        TimeFormatSetting r101 = r100.getTimeFormatSetting();
        UserSetting r102 = this.f444653b;
        if (r102 != null) goto L8;
        this.f444654c.getClass();
        TimeFormatSetting r103 = b.a(null);
    L10:
        if (Objects.equals(r103, r101) == false) goto L13;
        Log.i("TimeFormatSetting", "time format is not changed");
        return;
    L13:
        Iterator r104 = ((ConcurrentHashMap) this.f444654c.f444649a).keySet().iterator();
    L15:
        if (r104.hasNext() == false) goto L17;
        ((a) r104.next()).a(r101);
        goto L15
    L17:
        return;
    L8:
        r103 = r102.getTimeFormatSetting();
        goto L10
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

    public c(b r100, UserSetting r101, UserSetting r102) {
        this.f444654c = r100;
        this.f444652a = r101;
        this.f444653b = r102;
    }
}
