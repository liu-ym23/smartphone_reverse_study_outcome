package ua2;

import android.os.SystemClock;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.settings.config.q;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import r52.p0;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<f<?>> f549234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<f<?>> f549235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f549236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f549237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Integer, Long> f549238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Integer, Pair<Long, Integer>> f549239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f549240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f549241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f549242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f549243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f549244k;

    /* JADX INFO: renamed from: ua2.a$a, reason: collision with other inner class name */
    public static final class C7852a {
    }

    static {
    }

    public a() {
        this.f549235b = new LinkedList();
        this.f549236c = 100;
        this.f549237d = SetsKt.mutableSetOf(new String[]{"WebcastGiftMessage", "GiftGroupMessage", "WebcastDoodleGiftMessage", "WebcastChatMessage", "WebcastMemberMessage", "WebcastScreenChatMessage", "WebcastLikeMessage", "WebcastSocialMessage", "WebcastRoomMessage", "WebcastPrivilegeScreenChatMessage"});
        LinkedHashMap r100 = new LinkedHashMap();
        this.f549238e = r100;
        this.f549239f = new LinkedHashMap();
        this.f549234a = new ArrayDeque(100);
        q r101 = p0.f536236a.getValue();
        this.f549240g = r101.c();
        this.f549241h = r101.d();
        this.f549242i = r101.b();
        this.f549243j = r101.a();
        r100.put(1, 0L);
        r100.put(2, 0L);
    }

    public final boolean a(int r110) {
        long r100 = SystemClock.uptimeMillis();
        Map<Integer, Pair<Long, Integer>> r101 = this.f549239f;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        Pair r103 = (Pair) r102.get(Integer.valueOf(r110));
        if (r103 != null) goto L5;
    L11:
        this.f549239f.put(Integer.valueOf(r110), new Pair(Long.valueOf(r100), 1));
        return false;
    L5:
        if ((r100 - ((Number) r103.getFirst()).longValue()) > this.f549242i) goto L11;
        if (((Number) r103.getSecond()).intValue() >= this.f549243j) goto L10;
        this.f549239f.put(Integer.valueOf(r110), new Pair(Long.valueOf(r100), Integer.valueOf(((Number) r103.getSecond()).intValue() + 1)));
        return false;
    L10:
        return true;
    }
}
