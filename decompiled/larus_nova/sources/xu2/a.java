package xu2;

import android.util.LongSparseArray;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.utils.TabTraceMonitor;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LongSparseArray<ArrayList<C8274a>> f565079a = null;

    /* JADX INFO: renamed from: xu2.a$a, reason: collision with other inner class name */
    public static final class C8274a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TabTraceMonitor.MultitabLinkEvent f565080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f565081b;

        public C8274a(TabTraceMonitor.MultitabLinkEvent r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f565080a = r100;
            this.f565081b = r101;
        }
    }

    static {
        f565079a = new LongSparseArray();
    }

    public static void a(long r100, TabTraceMonitor.MultitabLinkEvent r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r100 == 0) goto L9;
        LongSparseArray<ArrayList<C8274a>> r103 = f565079a;
        ArrayList<C8274a> r104 = r103.get(r100);
        if (r104 != null) goto L7;
        r104 = new ArrayList();
    L7:
        r104.add(new C8274a(r101, r102));
        r103.put(r100, r104);
        return;
    }
}
