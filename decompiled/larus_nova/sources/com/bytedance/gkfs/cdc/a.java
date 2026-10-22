package com.bytedance.gkfs.cdc;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.gkfs.GkFSExecutor;
import com.bytedance.gkfs.UtilsKt;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<GkFSByteBuffer> f245147a = null;

    /* JADX INFO: renamed from: com.bytedance.gkfs.cdc.a$a, reason: collision with other inner class name */
    public static final class RunnableC3508a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RunnableC3508a f245148a = null;

        static {
            f245148a = new RunnableC3508a();
        }

        public RunnableC3508a() {
        }

        public static void a() {
            EventSubType r100 = EventSubType.BUFFER_CREATE_OVER_CACHE_SIZE;
            JSONObject r101 = new JSONObject();
            r101.put("sub_type", r100.getType());
            r101.put(LocationMonitorConst.ERR_MSG, "");
            y86.a.c("geckosdk_event_message", r101);
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

    static {
        f245147a = new ArrayList(100);
    }

    public static GkFSByteBuffer a(int r110) {
        ArrayList<GkFSByteBuffer> r100 = f245147a;
        boolean r101 = true;
        if ((!r100.isEmpty()) == false) goto L7;
        GkFSByteBuffer r102 = (GkFSByteBuffer) ListProtector.remove(r100, 0);
        if (UtilsKt.d() == false) goto L11;
        com.bytedance.gkfs.c.b(com.bytedance.gkfs.c.f245127c, "ChunkBufferAllocator", "reuse " + r102 + ", poll size:" + r100.size(), 0, false, 12);
    L11:
        if (r110 > r102.f245146f) goto L14;
        if (r110 < 0) goto L14;
    L15:
        if (r101 == false) goto L22;
        r102.f245144d = r110;
        if (r102.f245145e <= r110) goto L19;
        r102.d(r110);
    L19:
        r102.d(0);
        return r102;
    L22:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L14:
        r101 = false;
        goto L15
    L7:
        r102 = new GkFSByteBuffer();
        if (UtilsKt.d() == false) goto L11;
        com.bytedance.gkfs.c.b(com.bytedance.gkfs.c.f245127c, "ChunkBufferAllocator", "create " + r102, 0, false, 12);
        goto L11
    }

    public static void b(GkFSByteBuffer r110) {
        ArrayList<GkFSByteBuffer> r100 = f245147a;
        if (r100.size() >= 100) goto L7;
        r100.add(r110);
        if (UtilsKt.d() == false) goto L12;
        com.bytedance.gkfs.c.b(com.bytedance.gkfs.c.f245127c, "ChunkBufferAllocator", "return " + r110 + ", poll size:" + r100.size(), 0, false, 12);
        return;
    L12:
        return;
    L7:
        GkFSExecutor.a(RunnableC3508a.f245148a);
        if (UtilsKt.d() == false) goto L10;
        com.bytedance.gkfs.c.b(com.bytedance.gkfs.c.f245127c, "ChunkBufferAllocator", "release " + r110 + ", poll size:" + r100.size(), 0, false, 12);
    L10:
        r110.c();
    }
}
