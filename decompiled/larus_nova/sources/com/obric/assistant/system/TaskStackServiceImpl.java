package com.obric.assistant.system;

import android.app.ActivityManager;
import android.content.ComponentName;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lha.g;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\u0017\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\"\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0018\u0010!\u001a\u0004\u0018\u00010 2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\f\u0010\"\u001a\u00020\u001a*\u00020\u000eH\u0002J\u001c\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010)\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010'\u001a\u00020(H\u0002J\u0017\u0010+\u001a\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020 H\u0002¢\u0006\u0002\u0010-J\u0017\u0010.\u001a\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020 H\u0002¢\u0006\u0002\u0010-J\u001f\u0010/\u001a\u0004\u0018\u00010(2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\u00112\u0006\u0010\b\u001a\u000206H\u0003J\u001f\u00107\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0002\b8J\u001d\u00109\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010:\u001a\u00020(H\u0000¢\u0006\u0002\b;R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/obric/assistant/system/TaskStackServiceImpl;", "Lcom/obric/assistant/system/ITaskStackService;", "<init>", "()V", "activityManager", "Landroid/app/ActivityManager;", "getActivityManager", "()Landroid/app/ActivityManager;", "taskStackListener", "Lcom/obric/assistant/system/MyTaskStackListener;", "systemTaskStackListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/assistant/system/ITaskStackListener;", "componentName", "Landroid/content/ComponentName;", "previousComponentName", "init", "", "registerTaskStackListener", "listener", "unregisterTaskStackListener", "getTopComponentName", "getTopComponentNameExcludingIgnoredActivities", "getPreviousTopComponentName", "updateTopAppInfo", "isOnChange", "", "updateTopAppInfo$impl_mainlandRelease", "findTopComponentName", "excludeIgnoredActivities", "tasks", "", "Landroid/app/ActivityManager$RunningTaskInfo;", "findDefaultDisplayTask", "isIgnoredTopActivityComponent", "notifyListeners", "fromTop", "toTop", "notifyTaskCreated", DBDefinition.TASK_ID, "", "shouldDispatchTaskCreated", "findRunningTaskByTaskId", "readTaskDisplayId", "taskInfo", "(Landroid/app/ActivityManager$RunningTaskInfo;)Ljava/lang/Integer;", "readTaskId", "readIntField", PickerReporterConstants.KEY.TARGET, "", "fieldName", "", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Integer;", "registerSystemTaskStackListener", "Landroid/app/TaskStackListener;", "onTaskCreated", "onTaskCreated$impl_mainlandRelease", "onTaskDisplayChanged", "newDisplayId", "onTaskDisplayChanged$impl_mainlandRelease", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskStackServiceImpl implements ITaskStackService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActivityManager f393347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MyTaskStackListener f393348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<g> f393349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile ComponentName f393350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile ComponentName f393351e;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.system.ITaskStackService
    public final ComponentName e() {
        ComponentName r100 = g(true);
        if (r100 != null) goto L18;
        ComponentName r101 = this.f393350d;
        if (r101 != null) goto L7;
    L9:
        r101 = null;
    L10:
        if (r101 != null) goto L19;
        ComponentName r102 = this.f393351e;
        if (r102 == null) goto L17;
        if (Intrinsics.areEqual(r102, KeyguardService.f392886a.getHelperActivityComponentName()) == true) goto L17;
        return r102;
    L17:
        return null;
    L19:
        return r101;
    L7:
        if (Intrinsics.areEqual(r101, KeyguardService.f392886a.getHelperActivityComponentName()) == true) goto L9;
    L18:
        return r100;
    }

    public final ActivityManager h() {
        ActivityManager r100 = this.f393347a;
        if (r100 == null) goto L11;
        return r100;
    L11:
        Object r101 = AppHost.f326268a.getApplication().getSystemService("activity");     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L7
        ActivityManager r102 = (ActivityManager) r101;     // Catch: Throwable -> L7
    L9:
        this.f393347a = r102;
        return r102;
    L7:
        th = move-exception;
        FLogger.f375446a.e("TaskStackService", "get ActivityManager exception", th);
        r102 = null;
        goto L9
    }

    @Override // com.obric.assistant.system.ITaskStackService
    public final void init() {
        MyTaskStackListener r100 = this.f393348b;
        Class r101 = f("android.app.ActivityTaskManager");     // Catch: Exception -> L5
        Method r102 = r101.getDeclaredMethod("getInstance", new Class[0]);     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        Object r103 = r102.invoke(null, new Object[0]);     // Catch: Exception -> L5
        Method r104 = r101.getDeclaredMethod("registerTaskStackListener", new Class[]{f("android.app.TaskStackListener")});     // Catch: Exception -> L5
        r104.setAccessible(true);     // Catch: Exception -> L5
        r104.invoke(r103, new Object[]{r100});     // Catch: Exception -> L5
        FLogger.f375446a.i("TaskStackService", "registerTaskStackListener success!");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("TaskStackService", "registerTaskStackListener failed!", e);
    }

    public TaskStackServiceImpl() {
        this.f393348b = new MyTaskStackListener(this);
        this.f393349c = new CopyOnWriteArrayList();
    }

    @Override // com.obric.assistant.system.ITaskStackService
    public final ComponentName b() {
        return this.f393351e;
    }

    @Override // com.obric.assistant.system.ITaskStackService
    public final ComponentName c() {
        return this.f393350d;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class f(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static void j(TaskStackServiceImpl r100) {
        boolean r101 = false;
        ComponentName r102 = r100.g(false);
        if (r102 != null) goto L5;
    L7:
        if (r101 == true) goto L24;
        r100.f393351e = r100.f393350d;
        FLogger.f375446a.i("TaskStackService", "onTaskStackChanged isOnChange: true from topActivity: " + r100.f393350d + ", to topActivity: " + r102);
        ComponentName r103 = r100.f393350d;
        Iterator<g> r104 = r100.f393349c.iterator();
    L10:
        if (r104.hasNext() == false) goto L16;
        r104.next().onChange(r103, r102);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        FLogger.f375446a.e("TaskStackService", "notify listener error", th);
        goto L10
    L16:
        r100.f393350d = r102;
        return;
    L24:
        return;
    L5:
        if (r102.equals(r100.f393350d) != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // com.obric.assistant.system.ITaskStackService
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f393349c.remove(r100);
    }

    @Override // com.obric.assistant.system.ITaskStackService
    public final void d(g r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f393349c.contains(r100) == true) goto L6;
        this.f393349c.add(r100);
        return;
    }

    public final ComponentName g(boolean r100) {
        ActivityManager r101 = h();     // Catch: Throwable -> L7
        if (r101 == null) goto L9;
        List<ActivityManager.RunningTaskInfo> r102 = r101.getRunningTasks(5);     // Catch: Throwable -> L7
    L10:
        List<ActivityManager.RunningTaskInfo> r103 = r102;
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L20;
        return null;
    L20:
        if (r100 == true) goto L39;
        Iterator<T> r105 = r102.iterator();
    L23:
        if (r105.hasNext() == false) goto L33;
        Object r106 = r105.next();
        Integer r107 = i((ActivityManager.RunningTaskInfo) r106, "displayId");
        if (r107 != null) goto L27;
    L30:
        boolean r108 = true;
    L31:
        if (r108 == false) goto L23;
    L34:
        ActivityManager.RunningTaskInfo r109 = (ActivityManager.RunningTaskInfo) r106;
        if (r109 != null) goto L37;
        r109 = (ActivityManager.RunningTaskInfo) CollectionsKt.getOrNull(r102, 0);
    L37:
        if (r109 != null) goto L78;
        return null;
    L78:
        return r109.topActivity;
    L27:
        if (r107.intValue() == 0) goto L30;
        r108 = false;
        goto L31
    L33:
        r106 = null;
        goto L34
    L39:
        Iterator<ActivityManager.RunningTaskInfo> r110 = r102.iterator();
    L41:
        if (r110.hasNext() == false) goto L53;
        ActivityManager.RunningTaskInfo r111 = r110.next();
        Integer r112 = i(r111, "displayId");
        if (r112 == null) goto L47;
        if (r112.intValue() != 0) goto L41;
    L47:
        ComponentName r113 = r111.topActivity;
        if (r113 == null) goto L41;
        if (Intrinsics.areEqual(r113, KeyguardService.f392886a.getHelperActivityComponentName()) == true) goto L41;
        return r113;
    L53:
        ActivityManager.RunningTaskInfo r114 = (ActivityManager.RunningTaskInfo) CollectionsKt.getOrNull(r102, 0);
        if (r114 == null) goto L80;
        ComponentName r115 = r114.topActivity;
        if (r115 != null) goto L58;
        return null;
    L58:
        if (Intrinsics.areEqual(r115, KeyguardService.f392886a.getHelperActivityComponentName()) == false) goto L60;
        return null;
    L60:
        return r115;
    L80:
        return null;
    L13:
        if (r103.isEmpty() == true) goto L16;
        r104 = false;
    L9:
        r102 = null;
    L7:
        th = move-exception;
        FLogger.f375446a.e("TaskStackService", "getRunningTasks failed", th);
        goto L9
    }

    public static Integer i(Object r100, String r101) {
        return Integer.valueOf(r100.getClass().getField(r101).getInt(r100));
    L4:
        return null;
    }
}
