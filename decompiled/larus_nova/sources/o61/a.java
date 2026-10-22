package o61;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l61.b;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f522154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static k61.a f522155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static n61.a f522156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f522157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final PropertyOwner<Boolean> f522158e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final PropertyOwner f522159f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PropertyOwner<Boolean> f522160g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PropertyOwner f522161h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<b> f522162i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<String> f522163j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PropertyOwner<String> f522164k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final PropertyOwner f522165l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f522166m;

    static {
        Keva r100 = Keva.getRepo("exp_app_store");
        f522154a = r100;
        List r101 = StringsKt.split$default(r100.getString("normal_fluency_info", ""), new String[]{","}, false, 0, 6, null);
        boolean r102 = false;
        if (r101 != null) goto L5;
    L38:
        PropertyOwner<Boolean> r103 = new PropertyOwner(Boolean.valueOf(r102));
        f522158e = r103;
        f522159f = r103;
        PropertyOwner<Boolean> r104 = new PropertyOwner(Boolean.FALSE);
        f522160g = r104;
        f522161h = r104;
        f522162i = new LinkedHashSet();
        f522163j = new LinkedHashSet();
        PropertyOwner<String> r105 = new PropertyOwner(b());
        f522164k = r105;
        f522165l = r105;
        f522166m = true;
        return;
    L5:
        if (r101.size() < 2) goto L7;
        boolean r106 = true;
    L8:
        Long r107 = null;
        if (r106 == true) goto L12;
        r101 = null;
    L12:
        if (r101 == null) goto L38;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L15
        Object r109 = Result.m9449constructorimpl(Boolean.valueOf(Boolean.parseBoolean((String) ListProtector.get(r101, 0))));     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r109) == false) goto L21;
        r109 = null;
    L21:
        if (Intrinsics.areEqual((Boolean) r109, Boolean.TRUE) == false) goto L38;
        Long r110 = StringsKt.toLongOrNull((String) ListProtector.get(r101, 1));
        if (r110 != null) goto L25;
    L37:
        r102 = !r102;
        goto L38
    L25:
        if (r110.longValue() <= 0) goto L27;
        boolean r111 = true;
    L28:
        if (r111 == false) goto L30;
        r107 = r110;
    L30:
        if (r107 == null) goto L37;
        if (Long.valueOf(System.currentTimeMillis() - r107.longValue()).longValue() < (PlatformExpUtils.c().j() * ((long) BaseConstants.Time.DAY))) goto L34;
        boolean r112 = true;
    L35:
        if (r112 != true) goto L37;
        r102 = true;
        goto L37
    L34:
        r112 = false;
        goto L35
    L27:
        r111 = false;
    L15:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L7:
        r106 = false;
        goto L8
    }

    public static String b() {
        if (f522157d == false) goto L16;
        Set<b> r100 = f522162i;
        if (r100.isEmpty() == false) goto L7;
        return "当前性能状态优秀，无需优化。重启APP后将关闭流畅看播";
    L7:
        StringBuilder r101 = new StringBuilder("当前性能状态一般，已为你优化");
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r103 = r100.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        r102.add(((b) r103.next()).getDesc());
        goto L9
    L11:
        Set r104 = CollectionsKt.toMutableSet(r102);
        String r105 = CollectionsKt.joinToString$default(CollectionsKt.take(r104, 5), "、", null, null, 0, null, null, 62, null);
        StringBuilder r106 = new StringBuilder();
        r106.append(r105);
        if (r104.size() <= 5) goto L14;
        String r107 = "等" + r104.size() + 20010;
    L15:
        r106.append(r107);
        r101.append(r106.toString());
        r101.append("功能。重启APP后将关闭流畅看播");
        return r101.toString();
    L14:
        r107 = "";
        goto L15
    L16:
        return "开启后，基于性能状态，为你自动优化动画和功能表现，减少性能负载、耗能，提升看播的流畅度";
    }

    public static void a(boolean r100) {
        ILiveExpMiddlewareService r101 = (ILiveExpMiddlewareService) k.f(ILiveExpMiddlewareService.class);
        if (r101 == null) goto L5;
        r101.shouldResetPerfBySwitchClose(!r100);
    L5:
        f522160g.a(Boolean.valueOf(r100));
    }

    public static void c(boolean r100) {
        ILiveExpMiddlewareService r101 = (ILiveExpMiddlewareService) k.f(ILiveExpMiddlewareService.class);
        if (r101 == null) goto L5;
        r101.shouldResetPerfBySwitchClose(!r100);
    L5:
        Keva r102 = f522154a;
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append(',');
        r103.append(System.currentTimeMillis());
        r102.storeString("normal_fluency_info", r103.toString());
        f522158e.a(Boolean.valueOf(r100));
    }

    public static void d(b r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        f522162i.remove(r100);
        f522164k.a(b());
    }
}
