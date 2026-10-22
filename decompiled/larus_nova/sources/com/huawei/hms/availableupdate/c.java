package com.huawei.hms.availableupdate;

import android.app.Activity;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes23.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f276994b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f276995a;

    public c() {
    }

    static {
        f276994b = new c();
    }

    private Activity a() {
        WeakReference<Activity> r100 = this.f276995a;
        if (r100 != null) goto L5;
        return null;
    L5:
        Activity r101 = r100.get();
        if (r101 != null) goto L8;
    L10:
        return null;
    L8:
        if (r101.isFinishing() == true) goto L10;
        return r101;
    }

    public boolean b() {
        Activity r100 = a();
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r100.isTaskRoot() == false) goto L9;
        return false;
    L9:
        r100.finish();
        HMSLog.i("UpdateAdapterMgr", " finish old activity.");
        return true;
    }

    public void a(Activity r100) {
        HMSLog.i("UpdateAdapterMgr", "onActivityCreate");
        Activity r101 = a();
        if (r101 == null) goto L5;
        r101.finish();
        HMSLog.i("UpdateAdapterMgr", "finish old activity.");
    L5:
        this.f276995a = new WeakReference(r100);
    }

    public void b(Activity r100) {
        HMSLog.i("UpdateAdapterMgr", "onActivityDestroy");
        Activity r101 = a();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.equals(r101) == false) goto L9;
        HMSLog.i("UpdateAdapterMgr", BasicTestActionHandler.TEST_ACTION_RESET);
        this.f276995a = null;
        return;
    }
}
