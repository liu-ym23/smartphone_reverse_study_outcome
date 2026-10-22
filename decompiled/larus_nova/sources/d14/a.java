package d14;

import android.util.Log;
import com.bytedance.awemeopen.appserviceimpl.ad.CsjAdService;
import com.bytedance.awemeopen.appserviceimpl.ad.LiveAdService;
import com.bytedance.awemeopen.appserviceimpl.ad.VideoLeftBottomAdService;
import com.bytedance.awemeopen.appserviceimpl.author.AuthorService;
import com.bytedance.awemeopen.appserviceimpl.collect.CollectService;
import com.bytedance.awemeopen.appserviceimpl.comment.CommentService;
import com.bytedance.awemeopen.appserviceimpl.digg.DiggService;
import com.bytedance.awemeopen.appserviceimpl.dislike.DislikeService;
import com.bytedance.awemeopen.appserviceimpl.ecom.EcomService;
import com.bytedance.awemeopen.appserviceimpl.event.EventReportService;
import com.bytedance.awemeopen.appserviceimpl.feed.preload.FeedPreloadService;
import com.bytedance.awemeopen.appserviceimpl.feed.recommend.ListenRecFeedService;
import com.bytedance.awemeopen.appserviceimpl.feed.recommend.RecFeedService;
import com.bytedance.awemeopen.appserviceimpl.follow.FollowService;
import com.bytedance.awemeopen.appserviceimpl.livehead.LiveStatusService;
import com.bytedance.awemeopen.appserviceimpl.locallife.LocalLifeService;
import com.bytedance.awemeopen.appserviceimpl.mix.MixService;
import com.bytedance.awemeopen.appserviceimpl.pendant.PendantService;
import com.bytedance.awemeopen.appserviceimpl.performance.PerformanceReportService;
import com.bytedance.awemeopen.appserviceimpl.report.ReportService;
import com.bytedance.awemeopen.appserviceimpl.share.InternalShareService;
import com.bytedance.awemeopen.appserviceimpl.user.UserInfoService;
import com.bytedance.awemeopen.appserviceimpl.young.digg.YoungDiggService;
import com.bytedance.awemeopen.appserviceimpl.young.feed.YoungFeedService;
import com.bytedance.awemeopen.infra.base.debug.AoDebug;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.util.b;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p24.e;
import w24.c;
import w24.d;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f466374a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, k24.a> f466375b = null;

    public a() {
    }

    static {
        f466374a = new a();
        f466375b = new ConcurrentHashMap();
        b();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        int r100 = b.f198959a;
        Intrinsics.checkNotNullParameter(th, "<this>");
        AoLogger.c("AoServiceManagerInner", new Object[]{Log.getStackTraceString(th)});
    }

    public static void b() {
        AoNpthService r100 = AoExceptionReporter.f198706a;
        c(k34.b.class, new UserInfoService());
        c(d.class, new RecFeedService());
        c(c.class, new ListenRecFeedService());
        c(y24.d.class, new FollowService());
        c(q24.c.class, new DiggService());
        c(e.class, new CommentService());
        c(m24.c.class, new AuthorService());
        c(r24.c.class, new DislikeService());
        c(f34.b.class, new ReportService());
        c(t24.a.class, new EventReportService());
        c(d34.a.class, new PerformanceReportService());
        c(e34.a.class, new g14.a());
        c(i34.a.class, new InternalShareService());
        c(o24.b.class, new CollectService());
        c(b34.a.class, new MixService());
        c(g34.a.class, new h14.a());
        c(l24.a.class, new CsjAdService());
        c(l24.c.class, new VideoLeftBottomAdService());
        c(l24.b.class, new LiveAdService());
        c(a34.a.class, new LiveStatusService());
        c(n34.a.class, new YoungFeedService());
        c(m34.a.class, new YoungDiggService());
        c(c34.a.class, new PendantService());
        c(v24.c.class, new FeedPreloadService());
        c(h34.a.class, new i14.a());
        c(s24.a.class, new EcomService());
        c(com.bytedance.awemeopen.common.service.locallife.a.class, new LocalLifeService());
        c(x24.a.class, new e14.a());
        c(z24.a.class, new f14.a());
        c(j34.a.class, new com.bytedance.awemeopen.appserviceimpl.shop.a());
        Iterator<T> r101 = f466375b.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((k24.a) r101.next()).x0();
        goto L4
    }

    public static k24.a a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceCls");
        if (r100.isInterface() == false) goto L5;
        Class r101 = r100;
    L16:
        if (r101 == null) goto L21;
        k24.a r102 = f466375b.get(r101.getName());
        if (r102 == null) goto L21;
        return r102;
    L21:
        throw new Error("service " + r100 + " is not registered!");
    L5:
        Class<?>[] r103 = r100.getInterfaces();
        ArrayList r104 = new ArrayList();
        int r105 = r103.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L15;
        Class<?> r107 = r103[r106];
        Class r108 = (Class) ArraysKt.firstOrNull(r107.getInterfaces());
        if (r108 == null) goto L10;
        String r109 = r108.getName();
    L12:
        if (Intrinsics.areEqual(r109, k24.a.class.getName()) == false) goto L15;
        r104.add(r107);
        r106 = r106 + 1;
        goto L6
    L10:
        r109 = null;
    L15:
        r101 = (Class) CollectionsKt.firstOrNull(r104);
        goto L16
    }

    public static void c(Class r100, k24.a r101) {
        Intrinsics.checkNotNullParameter(r100, "serviceCls");
        Intrinsics.checkNotNullParameter(r101, "impl");
        f466375b.put(r100.getName(), r101);
        if (AoDebug.c() == true) goto L5;
        return;
    L5:
        if (r100.isInterface() == false) goto L8;
        return;
    L8:
        throw new Error("service " + r100 + " must be interface");
    }
}
