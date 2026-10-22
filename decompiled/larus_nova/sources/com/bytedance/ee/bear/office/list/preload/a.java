package com.bytedance.ee.bear.office.list.preload;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.ee.bear.list.office.preload.OfficeSpaceDbPreloadWorker;
import com.bytedance.ee.bear.list.office.preload.OfficeSpaceDbPreloadWorker$preloadDb$1;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadRequest;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mc5.j;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f235950a = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.office.list.preload.a$a, reason: collision with other inner class name */
    public interface InterfaceC3382a {
        void cancel();
    }

    static {
    }

    public static b a(Context r210, OfficeSpacePreloadRequest r211, final String r310, final String r311, final Function1 r312) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "request");
        Intrinsics.checkNotNullParameter(r310, "requestId");
        Intrinsics.checkNotNullParameter(r311, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r312, "onFinish");
        Handler r100 = OfficeSpaceDbPreloadWorker.f229096a;
        final Integer r101 = r211.getConfig().getListConfig().getRecentFilterTabType();
        final long r110 = r211.getTtlMs() + r211.getCreatedAtMs();
        final String r111 = r211.getScene().name();
        final Function1<OfficeSpaceDbPreloadWorker.a, Unit> r102 = new OfficeRecentPreloadBridge$preloadDb$workerTask$1(r310, r311, r312);
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r310, "requestId");
        Intrinsics.checkNotNullParameter(r311, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r111, "originScene");
        Intrinsics.checkNotNullParameter(r102, "onFinish");
        final Context r112 = r210.getApplicationContext();
        final AtomicBoolean r103 = new AtomicBoolean(false);
        final ArrayList r113 = new ArrayList();
        final ArrayList r114 = new ArrayList();
        final Ref.IntRef r104 = new Ref.IntRef();
        r104.element = 4;
        final Ref.BooleanRef r212 = new Ref.BooleanRef();
        final long r213 = System.currentTimeMillis();
        final j r115 = (j) new ce5.a().a(j.class);
        tt5.a.h("OfficeSpaceDbPreloadWorker", "office_space_db_preload_start requestId=" + r310 + " key=" + r311 + " scene=" + r111);
        Handler r105 = OfficeSpaceDbPreloadWorker.f229096a;
        r105.post(new OfficeSpaceDbPreloadWorker$preloadDb$1(r101, r212, r103, r113, r104, r310, r311, r114, r213, r112, r102, r115, r110, r111));
        r105.postAtTime(new com.bytedance.ee.bear.list.office.preload.a(r310, r311, r104, r212, r103, r114, r113, r213, r112, r102), r310, SystemClock.uptimeMillis() + 1500);
        return new b(new com.bytedance.ee.bear.list.office.preload.b(r103, r114, r310));
    }
}
