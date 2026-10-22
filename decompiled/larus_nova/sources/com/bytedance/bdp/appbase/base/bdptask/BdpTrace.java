package com.bytedance.bdp.appbase.base.bdptask;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u001e\u0010\r\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0007J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0007R\u0016\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/BdpTrace;", "", "", "trace", "sub", "", "appendTrace", "Lcom/bytedance/bdp/appbase/base/bdptask/TracePoint;", "point", "", "sectionPoint", "Ljava/util/LinkedList;", "originList", "addNewPointToList", "getTraceString", "getSimpleTrace", "ENABLE", "Z", "<init>", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class BdpTrace {
    public static boolean ENABLE;

    public BdpTrace() {
    }

    static {
        new BdpTrace();
        new ThreadLocal();
        ENABLE = k.f();
    }

    @JvmStatic
    public static final LinkedList<TracePoint> a() {
        return k.f200515b.get();
    }

    @JvmStatic
    public static final String getSimpleTrace() {
        LinkedList<TracePoint> r100 = a();
        if (r100 == null) goto L19;
        StringBuilder r101 = new StringBuilder();
        monitor-enter(r100);
        Iterator<TracePoint> r102 = r100.iterator();     // Catch: Throwable -> L16
    L8:
        if (r102.hasNext() == false) goto L13;
        TracePoint r103 = r102.next();     // Catch: Throwable -> L16
        if (r101.length() <= 0) goto L12;
        r101.append("\n");     // Catch: Throwable -> L16
    L12:
        r101.append(">> ");     // Catch: Throwable -> L16
        r101.append(r103.trace);     // Catch: Throwable -> L16
        goto L8
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L16
        return r101.toString();
    L16:
        th = move-exception;
        throw th;
    L19:
        return null;
    }

    @JvmStatic
    public static final String getTraceString() {
        LinkedList<TracePoint> r100 = a();
        if (r100 == null) goto L29;
        StringBuilder r101 = new StringBuilder();
        monitor-enter(r100);
        Iterator<TracePoint> r102 = r100.iterator();     // Catch: Throwable -> L26
        long r103 = 0;
        long r104 = 0;
    L8:
        if (r102.hasNext() == false) goto L23;
        TracePoint r105 = r102.next();     // Catch: Throwable -> L26
        r101.append("\n>> ");     // Catch: Throwable -> L26
        if (k.f() == true) goto L11;
        r101.append(r105.getEventKeyName());     // Catch: Throwable -> L26
        r101.append(":");     // Catch: Throwable -> L26
        r101.append(r105.trace);     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r105.f200479sub) == true) goto L8;
        r101.append("(");     // Catch: Throwable -> L26
        r101.append(r105.f200479sub);     // Catch: Throwable -> L26
        r101.append(")");     // Catch: Throwable -> L26
        goto L8
    L11:
        r101.append("[");     // Catch: Throwable -> L26
        String r110 = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date(r105.getTime()));     // Catch: Throwable -> L31
        r101.append("time=");     // Catch: Throwable -> L31
        r101.append(r110);     // Catch: Throwable -> L31
    L13:
        r101.append(",pName=");     // Catch: Throwable -> L26
        r101.append(r105.getPName());     // Catch: Throwable -> L26
        r101.append(",tid=");     // Catch: Throwable -> L26
        r101.append(r105.getTid());     // Catch: Throwable -> L26
        if (r103 != 0) goto L16;
        r103 = r105.getTime();     // Catch: Throwable -> L26
        r104 = r105.getTime();     // Catch: Throwable -> L26
    L16:
        r101.append(",elapse=");     // Catch: Throwable -> L26
        r101.append(r105.getTime() - r103);     // Catch: Throwable -> L26
        r101.append(",total=");     // Catch: Throwable -> L26
        r101.append(r105.getTime() - r104);     // Catch: Throwable -> L26
        r103 = r105.getTime();     // Catch: Throwable -> L26
        r101.append(",tName=");     // Catch: Throwable -> L26
        r101.append(r105.getTName());     // Catch: Throwable -> L26
        r101.append("] ");     // Catch: Throwable -> L26
        r101.append(r105.getEventKeyName());     // Catch: Throwable -> L26
        r101.append(":");     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r105.f200479sub) == true) goto L19;
        r101.append("(");     // Catch: Throwable -> L26
        r101.append(r105.f200479sub);     // Catch: Throwable -> L26
        r101.append(")");     // Catch: Throwable -> L26
    L19:
        r101.append(r105.trace);     // Catch: Throwable -> L26
        goto L8
    L23:
        monitor-exit(r100);     // Catch: Throwable -> L26
        return r101.toString();
    L26:
        th = move-exception;
        throw th;
    L29:
        return null;
    }

    @JvmStatic
    public static final boolean appendTrace(TracePoint r100) {
        LinkedList<TracePoint> r101 = a();
        if (r101 == null) goto L6;
        k.c(r101, r100);
        return true;
    L6:
        return false;
    }

    @JvmStatic
    public static final void b(List<TracePoint> r100) {
        LinkedList<TracePoint> r101 = a();
        if (r101 == null) goto L18;
        monitor-enter(r101);
        Iterator<TracePoint> r102 = r100.iterator();     // Catch: Throwable -> L15
    L7:
        if (r102.hasNext() == false) goto L13;
        TracePoint r103 = r102.next();     // Catch: Throwable -> L15
        if (r101.size() > k.f200516c) goto L10;
        r101.addLast(r103);     // Catch: Throwable -> L15
        goto L7
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void sectionPoint(TracePoint r100) {
        if (k.f() == false) goto L6;
        k.d(r100);
        k.e();
        return;
    }

    @JvmStatic
    public static final void addNewPointToList(LinkedList<TracePoint> r100, TracePoint r101) {
        k.b(r100, r101);
    }

    @JvmStatic
    public static final boolean appendTrace(String r100, String r101) {
        if (ENABLE == true) goto L5;
        return false;
    L5:
        LinkedList<TracePoint> r102 = a();
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        k.c(r102, new TracePoint(r100, r101, 2));
        return true;
    }
}
