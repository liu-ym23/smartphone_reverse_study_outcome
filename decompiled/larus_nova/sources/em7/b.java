package em7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f473100a = null;

    public static final class a {
        public a() {
        }

        public static List a(String r110, List r111, boolean r112) {
            ArrayList r100 = new ArrayList();
            Iterator r113 = r111.iterator();
        L4:
            if (r113.hasNext() == false) goto L21;
            String r101 = (String) r113.next();
            List r102 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
            List r103 = StringsKt.split$default(r101, new String[]{"."}, false, 0, 6, null);
            if (r112 == false) goto L11;
            if (r102.size() < r103.size()) goto L17;
        L13:
            int r104 = RangesKt.coerceAtMost(r102.size(), r103.size());
            int r105 = 0;
        L14:
            if (r105 >= r104) goto L19;
            if ((!Intrinsics.areEqual((String) ListProtector.get(r102, r105), (String) ListProtector.get(r103, r105))) == true) goto L17;
            r105 = r105 + 1;
        L19:
            if (r101 == null) goto L4;
            r100.add(r101);
        L17:
            r101 = null;
            goto L19
        L11:
            if (r102.size() <= r103.size()) goto L13;
        L21:
            return r100;
        }
    }

    static {
        f473100a = new a();
    }
}
