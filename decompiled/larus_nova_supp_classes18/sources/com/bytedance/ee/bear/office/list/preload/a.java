package com.bytedance.ee.bear.office.list.preload;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.ee.bear.list.office.preload.OfficeSpaceDbPreloadWorker;
import com.bytedance.ee.bear.list.office.preload.OfficeSpaceDbPreloadWorker$preloadDb$1;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadRequest;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mc5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.office.list.preload.a$a, reason: collision with other inner class name */
    public interface InterfaceC0135a {
        void cancel();
    }

    static {
    }

    public static b a(Context r28, OfficeSpacePreloadRequest r29, final String r30, final String r31, final Function1 r32) {
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r29, "request");
        Intrinsics.checkNotNullParameter(r30, "requestId");
        Intrinsics.checkNotNullParameter(r31, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r32, "onFinish");
        Handler r2 = OfficeSpaceDbPreloadWorker.a;
        final Integer r3 = r29.getConfig().getListConfig().getRecentFilterTabType();
        final long r15 = r29.getTtlMs() + r29.getCreatedAtMs();
        final String r11 = r29.getScene().name();
        final Function1<OfficeSpaceDbPreloadWorker.a, Unit> r5 = new OfficeRecentPreloadBridge$preloadDb$workerTask$1(r30, r31, r32);
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r30, "requestId");
        Intrinsics.checkNotNullParameter(r31, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r11, "originScene");
        Intrinsics.checkNotNullParameter(r5, "onFinish");
        final Context r18 = r28.getApplicationContext();
        final AtomicBoolean r0 = new AtomicBoolean(false);
        final ArrayList r19 = new ArrayList();
        final ArrayList r10 = new ArrayList();
        final Ref.IntRef r4 = new Ref.IntRef();
        r4.element = 4;
        final Ref.BooleanRef r21 = new Ref.BooleanRef();
        final long r23 = System.currentTimeMillis();
        final j r14 = (j) new ce5.a().a(j.class);
        tt5.a.h("OfficeSpaceDbPreloadWorker", "office_space_db_preload_start requestId=" + r30 + " key=" + r31 + " scene=" + r11);
        Handler r1 = OfficeSpaceDbPreloadWorker.a;
        r1.post(new OfficeSpaceDbPreloadWorker$preloadDb$1(r3, r21, r0, r19, r4, r30, r31, r10, r23, r18, r5, r14, r15, r11));
        r1.postAtTime(new com.bytedance.ee.bear.list.office.preload.a(r30, r31, r4, r21, r0, r10, r19, r23, r18, r5), r30, SystemClock.uptimeMillis() + 1500);
        return new b(new com.bytedance.ee.bear.list.office.preload.b(r0, r10, r30));
    }
}
