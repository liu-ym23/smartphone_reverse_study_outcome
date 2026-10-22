package z5c;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* JADX INFO: loaded from: classes38.dex */
public final class t3 extends s5c.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t3 f570376c = null;

    static {
        t3 r100 = new t3();
        f570376c = r100;
        r100.a("此次点击动作发生所属的thread id");
    }

    public t3() {
        super(CrashHianalyticsData.THREAD_ID);
    }
}
