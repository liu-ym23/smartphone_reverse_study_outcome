package yfc;

import com.bytedance.common.support.PushCommonSupport;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f567457a;

    public a() {
    }

    public static String a(String r100) {
        StringBuilder r101 = new StringBuilder();
        if (f567457a == null) goto L5;
    L14:
        r101.append(f567457a);
        r101.append(r100);
        return r101.toString();
    L5:
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f567457a != null) goto L9;
        f567457a = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mHost;     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        goto L14
    }
}
