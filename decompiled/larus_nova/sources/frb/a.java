package frb;

import android.os.SystemClock;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.statistics.c;
import com.ss.android.lark.mention.base.impl.statistics.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Boolean> f478644e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Long> f478645f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f478646g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f478648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f478649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f478650d;

    /* JADX INFO: renamed from: frb.a$a, reason: collision with other inner class name */
    public static final class C5946a {
        @JvmStatic
        public static Pair a() {
            Intrinsics.checkNotNullParameter("mention_ai_knowledge", "targetId");
            Boolean r100 = (Boolean) ((LinkedHashMap) a.f478644e).get("mention_ai_knowledge");
            if (r100 == null) goto L5;
            boolean r101 = r100.booleanValue();
        L6:
            if (r101 == false) goto L8;
            Long r102 = (Long) ((LinkedHashMap) a.f478645f).get("mention_ai_knowledge");
            if (r102 == null) goto L12;
            long r103 = r102.longValue();
        L14:
            if ((SystemClock.elapsedRealtime() - r103) < 1500) goto L17;
            return new Pair(Boolean.TRUE, Boolean.valueOf(a.f478646g));
        L17:
            return new Pair(Boolean.FALSE, Boolean.valueOf(a.f478646g));
        L12:
            r103 = SystemClock.elapsedRealtime();
            goto L14
        L8:
            return new Pair(Boolean.FALSE, Boolean.valueOf(a.f478646g));
        L5:
            r101 = false;
            goto L6
        }
    }

    static {
        f478644e = new LinkedHashMap();
        f478645f = new LinkedHashMap();
    }

    public final void a(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        b r102 = null;
        if ((r101 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r103 = (LinearLayoutManager) r101;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        Object r104 = r100.getAdapter();
        if ((r104 instanceof b) == false) goto L11;
        r102 = (b) r104;
    L11:
        if (r102 != null) goto L13;
        return;
    L13:
        boolean r105 = this.f478650d;
        int r106 = r103.findFirstVisibleItemPosition();
        int r107 = r103.findLastVisibleItemPosition();
        int r108 = r102.getItemCount();
        boolean r109 = false;
        int r110 = Math.max(0, r106);
        int r111 = Math.min(r107, r108 - 1);
        if (r110 <= r111) goto L16;
    L20:
        this.f478650d = r109;
        f478644e.put(this.f478647a, Boolean.valueOf(r109));
        f478646g = this.f478649c;
        if (r105 == false) goto L23;
        return;
    L23:
        if (this.f478650d == false) goto L29;
        f478645f.put(this.f478647a, Long.valueOf(SystemClock.elapsedRealtime()));
        String r112 = this.f478647a;
        boolean r113 = this.f478649c;
        String r114 = this.f478648b;
        Log.i("ItemVisibilityTracker", "mention ai knowledge is visible , " + r113);
        int r115 = e.f431876a;
        Intrinsics.checkNotNullParameter(r112, "targetId");
        Intrinsics.checkNotNullParameter(r114, "configJson");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new c(r112, r114, r113));
        return;
    L29:
        return;
    L16:
        if (Intrinsics.areEqual(r102.k2(r110), this.f478647a) == true) goto L17;
        if (r110 == r111) goto L20;
        r110 = r110 + 1;
        goto L16
    L17:
        r109 = true;
        goto L20
    L5:
        r103 = null;
        goto L6
    }

    public a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter("mention_ai_knowledge", "targetId");
        Intrinsics.checkNotNullParameter(r100, "configJson");
        this.f478647a = "mention_ai_knowledge";
        this.f478648b = r100;
        this.f478649c = r101;
    }
}
