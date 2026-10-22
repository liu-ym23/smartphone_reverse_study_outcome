package com.obric.assistant.task;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.utils.l;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes4.dex */
public final class ObricTaskStatusManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricTaskStatusManager f393357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f393358b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f393359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f393360d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicLong f393361e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final StateFlowImpl f393362f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f393363g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CoroutineScope f393364h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final CoroutineScope f393365i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ObricTaskStatusManager$complexTaskStateListener$1 f393366j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ObricTaskStatusManager$oAutoTaskStateObserver$1 f393367k = null;

    public ObricTaskStatusManager() {
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.obric.assistant.task.ObricTaskStatusManager$complexTaskStateListener$1] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.assistant.task.ObricTaskStatusManager$oAutoTaskStateObserver$1] */
    static {
        f393357a = new ObricTaskStatusManager();
        f393358b = new AtomicBoolean(false);
        f393360d = new AtomicBoolean(false);
        f393361e = new AtomicLong(0);
        f393362f = j1.a(null);
        f393363g = new AtomicBoolean(false);
        f393364h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f393365i = CoroutineScopeKt.MainScope();
        f393366j = new ObricTaskStatusManager$complexTaskStateListener$1();
        final Handler r100 = new Handler(Looper.getMainLooper());
        f393367k = new ObricTaskStatusManager$oAutoTaskStateObserver$1(r100);
    }

    public static String b() {
        FLogger.f375446a.i("ObricTaskStatusManager", "getOpenPanelType: " + f393359c);
        return f393359c;
    }

    public static DMTaskState c() {
        DMStateInfo r100 = (DMStateInfo) f393362f.getValue();
        DMTaskState r101 = null;
        if (r100 == null) goto L17;
        List<DMTaskState> r102 = r100.getActiveTasks();
        if (r102 == null) goto L18;
        ListIterator<DMTaskState> r103 = r102.listIterator(r102.size());
    L8:
        if (r103.hasPrevious() == false) goto L13;
        DMTaskState r104 = r103.previous();
        if (l.f(r104) == false) goto L8;
        r101 = r104;
    L13:
        return r101;
    L18:
        return null;
    L17:
        return null;
    }

    public static String a() {
        DMTaskState r100 = c();
        if (r100 == null) goto L7;
        Map<String, String> r101 = r100.getExtra();
        if (r101 == null) goto L7;
        String r102 = r101.get("is_call_for_me_ask_user");
    L9:
        if (Intrinsics.areEqual(r102, "1") == false) goto L12;
        return "call_for_me_reply";
    L12:
        return null;
    L7:
        r102 = null;
        goto L9
    }

    public static DMTaskState d(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        Object r102 = null;
        if (r101 == false) goto L10;
        FLogger.f375446a.w("ObricTaskStatusManager", "getTaskByQueryMessageId: msg is empty");
        return null;
    L10:
        DMStateInfo r103 = (DMStateInfo) f393362f.getValue();
        if (r103 == null) goto L31;
        List<DMTaskState> r104 = r103.getActiveTasks();
        if (r104 == null) goto L32;
        Iterator<T> r105 = r104.iterator();
    L16:
        if (r105.hasNext() == false) goto L27;
        Object r106 = r105.next();
        DMTaskInfo r107 = ((DMTaskState) r106).getTaskInfo();
        if (r107 == null) goto L22;
        IMMessage r108 = r107.getMessage();
        if (r108 == null) goto L22;
        String r109 = r108.getMessageId();
    L24:
        if (Intrinsics.areEqual(r109, r100) == false) goto L16;
        r102 = r106;
    L22:
        r109 = null;
    L27:
        return (DMTaskState) r102;
    L32:
        return null;
    L31:
        return null;
    L5:
        r101 = false;
        goto L6
    }

    public static DMTaskState e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "omniTaskId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        Object r102 = null;
        if (r101 == false) goto L10;
        FLogger.f375446a.w("ObricTaskStatusManager", "getTaskByQueryOmniTaskId: msg is empty");
        return null;
    L10:
        DMStateInfo r103 = (DMStateInfo) f393362f.getValue();
        if (r103 == null) goto L25;
        List<DMTaskState> r104 = r103.getActiveTasks();
        if (r104 == null) goto L26;
        Iterator<T> r105 = r104.iterator();
    L16:
        if (r105.hasNext() == false) goto L21;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(l.d((DMTaskState) r106), r100) == false) goto L16;
        r102 = r106;
    L21:
        return (DMTaskState) r102;
    L26:
        return null;
    L25:
        return null;
    L5:
        r101 = false;
        goto L6
    }

    public static void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "openPanelType");
        FLogger.f375446a.i("ObricTaskStatusManager", "setOpenPanelType: ".concat(r100));
        f393359c = r100;
    }

    public static void g(boolean r100) {
        FLogger.f375446a.i("ObricTaskStatusManager", "setStartPanelOpen: " + r100);
        f393360d.set(r100);
    }
}
