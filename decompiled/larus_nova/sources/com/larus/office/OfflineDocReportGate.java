package com.larus.office;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes20.dex */
public final class OfflineDocReportGate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfflineDocReportGate f360434a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f360435b = null;

    public OfflineDocReportGate() {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.office.s] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.office.r] */
    static {
        OfflineDocReportGate r100 = new OfflineDocReportGate();
        f360434a = r100;
        f360435b = new q(new r(), new OfflineDocReportGate$coordinator$2(r100), new s());
    }

    public static String e() {
        final String r100 = UUID.randomUUID().toString();
        f360434a.getClass();
        b("请求创建任务，attempt=" + r100);
        final q r101 = f360435b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "attemptId");
        if (StringsKt.isBlank(r100) == false) goto L5;
        r101.f363611c.invoke("忽略创建任务，原因=任务标识为空");
    L14:
        return r100;
    L5:
        Object r102 = r101.f363613e;
        monitor-enter(r102);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (r101.f363614f.containsKey(r100) == false) goto L12;
        r101.f363611c.invoke("忽略创建任务，attempt=" + r100 + "，原因=任务已存在");     // Catch: Throwable -> L15
        monitor-exit(r102);
    L18:
        goto L14
    L12:
        q.a r103 = new q.a(null);     // Catch: Throwable -> L15
        r101.f363614f.put(r100, r103);     // Catch: Throwable -> L15
        r103.f363618d = r101.f363610b.invoke(Long.valueOf(r101.f363609a), new p(r101, r100));     // Catch: Throwable -> L15
        r101.f363611c.invoke("任务已创建，attempt=" + r100 + "，超时毫秒=" + r101.f363609a);     // Catch: Throwable -> L15
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r102);
        goto L18
    }

    public static void b(String r100) {
        FLogger r101 = FLogger.f375446a;
        if (r101.isDebug() == false) goto L6;
        r101.i("OfflineDocReport", r100);
        return;
    }

    public static void c(String r100) {
        if (r100 != null) goto L5;
        String r101 = "";
    L6:
        b("请求处理宿主销毁，attempt=".concat(r101));
        q r102 = f360435b;
        if (r100 == null) goto L12;
        r102.getClass();
        if (StringsKt.isBlank(r100) == true) goto L12;
        boolean r103 = false;
    L13:
        if (r103 == false) goto L15;
        r102.f363611c.invoke("忽略宿主销毁，原因=任务标识为空");
        return;
    L15:
        Object r104 = r102.f363613e;
        monitor-enter(r104);
        q.a r105 = (q.a) ((LinkedHashMap) r102.f363614f).get(r100);     // Catch: Throwable -> L28
        if (r105 != null) goto L22;
        r102.f363611c.invoke("忽略宿主销毁，attempt=" + r100 + "，原因=任务不存在");     // Catch: Throwable -> L28
        monitor-exit(r104);
        return;
    L22:
        r105.f363616b = true;     // Catch: Throwable -> L28
        if ((r105.f363615a instanceof q.b.a) == false) goto L25;
        r102.f363614f.remove(r100);     // Catch: Throwable -> L28
    L25:
        r102.f363611c.invoke("宿主已销毁，attempt=" + r100 + "，任务是否已结束=" + (r105.f363615a instanceof q.b.a));     // Catch: Throwable -> L28
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r104);
        return;
    L28:
        th = move-exception;
        throw th;
    L12:
        r103 = true;
        goto L13
    L5:
        r101 = r100;
        goto L6
    }

    public static void d(String r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r111, "report");
        if (r110 != null) goto L5;
        String r100 = "";
    L6:
        b("请求上报或延迟埋点，attempt=".concat(r100));
        q r101 = f360435b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r111, "report");
        Object r102 = r101.f363613e;
        monitor-enter(r102);
        String r103 = null;
        if (r110 != null) goto L47;
        q.a r104 = null;
    L14:
        if (r104 == null) goto L16;
        q.b r105 = r104.f363615a;     // Catch: Throwable -> L11
    L17:
        boolean r106 = false;
        if (Intrinsics.areEqual(r105, q.b.C4450b.f363620a) == false) goto L21;
        r104.f363617c.add(r111);     // Catch: Throwable -> L11
        r101.f363611c.invoke("埋点已入队，attempt=" + r110 + "，待上报数量=" + r104.f363617c.size());     // Catch: Throwable -> L11
    L34:
        monitor-exit(r102);
        if (r106 == false) goto L48;
        r111.invoke(r103);     // Catch: Throwable -> L38
        return;
    L38:
        th = move-exception;
        r101.f363612d.invoke(th);
        return;
    L48:
        return;
    L21:
        if ((r105 instanceof q.b.a) == false) goto L28;
        String r107 = ((q.b.a) r105).f363619a;     // Catch: Throwable -> L11
        Function1<String, Unit> r108 = r101.f363611c;     // Catch: Throwable -> L11
        StringBuilder r109 = new StringBuilder("埋点立即上报，attempt=");     // Catch: Throwable -> L11
        r109.append(r110);     // Catch: Throwable -> L11
        r109.append("，原因=任务已结束，是否有卡片消息ID=");     // Catch: Throwable -> L11
        if (r107 != null) goto L25;
    L26:
        r106 = true;
    L27:
        r109.append(!r106);     // Catch: Throwable -> L11
        r108.invoke(r109.toString());     // Catch: Throwable -> L11
        r103 = r107;
    L33:
        r106 = true;
        goto L34
    L25:
        if (StringsKt.isBlank(r107) == false) goto L27;
    L28:
        if (r105 != null) goto L42;
        Function1<String, Unit> r112 = r101.f363611c;     // Catch: Throwable -> L11
        StringBuilder r113 = new StringBuilder("埋点立即上报，attempt=");     // Catch: Throwable -> L11
        if (r110 != null) goto L32;
        r110 = "";
    L32:
        r113.append(r110);     // Catch: Throwable -> L11
        r113.append("，原因=任务不存在");     // Catch: Throwable -> L11
        r112.invoke(r113.toString());     // Catch: Throwable -> L11
        goto L33
    L42:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L11
    L16:
        r105 = null;
        goto L17
    L47:
        r104 = (q.a) ((LinkedHashMap) r101.f363614f).get(r110);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L5:
        r100 = r110;
        goto L6
    }

    public static void a(String r100, boolean r101, Long r110, String r111) {
        boolean r102 = false;
        if (r111 == null) goto L15;
        if (r101 == false) goto L12;
        if (r110 == null) goto L12;
        if (r110.longValue() != 0) goto L12;
        if ((!StringsKt.isBlank(r111)) == false) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        String r104 = r111;
    L16:
        StringBuilder r105 = new StringBuilder("请求结束任务，attempt=");
        if (r100 != null) goto L19;
        String r106 = "";
    L20:
        r105.append(r106);
        r105.append("，请求是否成功=");
        r105.append(r101);
        r105.append("，业务码=");
        r105.append(r110);
        r105.append("，是否返回消息ID=");
        if (r111 != null) goto L23;
    L26:
        boolean r107 = true;
    L27:
        r105.append(!r107);
        r105.append("，是否有有效卡片消息ID=");
        if (r104 != null) goto L30;
    L33:
        boolean r108 = true;
    L34:
        r105.append(!r108);
        b(r105.toString());
        q r109 = f360435b;
        if (r100 == null) goto L40;
        r109.getClass();
        if (StringsKt.isBlank(r100) == true) goto L40;
        boolean r112 = false;
    L41:
        if (r112 == false) goto L43;
        r109.f363611c.invoke("忽略结束任务，原因=任务标识为空");
        return;
    L43:
        Object r113 = r109.f363613e;
        monitor-enter(r113);
        q.a r114 = (q.a) ((LinkedHashMap) r109.f363614f).get(r100);     // Catch: Throwable -> L77
        if (r114 != null) goto L51;
        r109.f363611c.invoke("忽略结束任务，attempt=" + r100 + "，原因=任务不存在");     // Catch: Throwable -> L77
        monitor-exit(r113);
        return;
    L51:
        if ((r114.f363615a instanceof q.b.C4450b) == true) goto L55;
        r109.f363611c.invoke("忽略结束任务，attempt=" + r100 + "，原因=任务已结束");     // Catch: Throwable -> L77
        monitor-exit(r113);
        return;
    L55:
        q.b.a r115 = new q.b.a(r104);     // Catch: Throwable -> L77
        Intrinsics.checkNotNullParameter(r115, "<set-?>");     // Catch: Throwable -> L77
        r114.f363615a = r115;     // Catch: Throwable -> L77
        v r116 = r114.f363618d;     // Catch: Throwable -> L77
        if (r116 == null) goto L58;
        r116.cancel();     // Catch: Throwable -> L77
    L58:
        r114.f363618d = null;     // Catch: Throwable -> L77
        List r117 = CollectionsKt.toList(r114.f363617c);     // Catch: Throwable -> L77
        r114.f363617c.clear();     // Catch: Throwable -> L77
        if (r114.f363616b == false) goto L61;
        r109.f363614f.remove(r100);     // Catch: Throwable -> L77
    L61:
        Function1<String, Unit> r118 = r109.f363611c;     // Catch: Throwable -> L77
        StringBuilder r119 = new StringBuilder("任务已结束，attempt=");     // Catch: Throwable -> L77
        r119.append(r100);     // Catch: Throwable -> L77
        r119.append("，释放数量=");     // Catch: Throwable -> L77
        r119.append(r117.size());     // Catch: Throwable -> L77
        r119.append("，是否有卡片消息ID=");     // Catch: Throwable -> L77
        if (r104 != null) goto L64;
    L65:
        r102 = true;
    L66:
        r119.append(!r102);     // Catch: Throwable -> L77
        r119.append("，宿主是否已销毁=");     // Catch: Throwable -> L77
        r119.append(r114.f363616b);     // Catch: Throwable -> L77
        r118.invoke(r119.toString());     // Catch: Throwable -> L77
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L77
        monitor-exit(r113);
        Iterator r121 = r117.iterator();
    L70:
        if (r121.hasNext() == false) goto L89;
        ((Function1) r121.next()).invoke(r104);     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        r109.f363612d.invoke(th);
        goto L70
    L89:
        return;
    L64:
        if (StringsKt.isBlank(r104) == false) goto L66;
    L77:
        th = move-exception;
        throw th;
    L40:
        r112 = true;
        goto L41
    L30:
        if (StringsKt.isBlank(r104) == true) goto L33;
        r108 = false;
        goto L34
    L23:
        if (StringsKt.isBlank(r111) == true) goto L26;
        r107 = false;
        goto L27
    L19:
        r106 = r100;
    L12:
        r103 = false;
    L15:
        r104 = null;
        goto L16
    }
}
