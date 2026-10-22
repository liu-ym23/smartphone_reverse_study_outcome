package to7;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.MessageQueue;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f546962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f546963b;

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        a r100 = this.f546963b;
        Application r101 = this.f546962a;
        r100.getClass();
        Field r102 = Application.class.getDeclaredField("mLoadedApk");     // Catch: Throwable -> L15
        r102.setAccessible(true);     // Catch: Throwable -> L15
        Object r103 = r102.get(r101);     // Catch: Throwable -> L15
        Field r104 = r103.getClass().getDeclaredField("mActivityThread");     // Catch: Throwable -> L15
        r104.setAccessible(true);     // Catch: Throwable -> L15
        Object r105 = r104.get(r103);     // Catch: Throwable -> L15
        Field r106 = r105.getClass().getDeclaredField("mActivities");     // Catch: Throwable -> L15
        r106.setAccessible(true);     // Catch: Throwable -> L15
        Object r107 = r106.get(r105);     // Catch: Throwable -> L15
        ActivityManager r108 = (ActivityManager) r101.getSystemService("activity");     // Catch: Throwable -> L15
        String r109 = ((ActivityManager.RunningTaskInfo) ListProtector.get(r108.getRunningTasks(1), 0)).topActivity.getClassName();     // Catch: Throwable -> L15
        r100.f546945b = ((ActivityManager.RunningTaskInfo) ListProtector.get(r108.getRunningTasks(1), 0)).numActivities;     // Catch: Throwable -> L15
        if ((r107 instanceof Map) == false) goto L17;
        Iterator r110 = ((Map) r107).entrySet().iterator();     // Catch: Throwable -> L15
    L7:
        if (r110.hasNext() == false) goto L17;
        Object r111 = ((Map.Entry) r110.next()).getValue();     // Catch: Throwable -> L15
        Field r112 = r111.getClass().getDeclaredField("activity");     // Catch: Throwable -> L15
        r112.setAccessible(true);     // Catch: Throwable -> L15
        Activity r113 = (Activity) r112.get(r111);     // Catch: Throwable -> L15
        if (r113 == null) goto L7;
        String r114 = r113.getClass().getName();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r114) == true) goto L7;
        if (r114.equals(r109) == false) goto L7;
    L18:
        if (r113 != null) goto L20;
    L31:
        return false;
    L20:
        if (a.b(this.f546963b, r113) == false) goto L23;
        return false;
    L23:
        if (this.f546963b.f546950g.contains(r113) == true) goto L31;
        this.f546963b.f546950g.add(r113);
        a r115 = this.f546963b;
        if (r115.f546946c == true) goto L27;
        a.c(r115, r113);
    L27:
        a r116 = this.f546963b;
        int r117 = r116.f546945b;
        if (r117 <= 1) goto L30;
        r116.f546944a = r117;
    L30:
        r116.f546948e = true;
    L17:
        r113 = null;
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    public b(a r100, Application r101) {
        this.f546963b = r100;
        this.f546962a = r101;
    }
}
