package lk9;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaState;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f509633a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f509634a = null;

        static {
            int[] r100 = new int[MediaOccupyStrategy.values().length];
            r100[MediaOccupyStrategy.PAUSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MediaOccupyStrategy.INTERRUPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f509634a = r100;
        }
    }

    static {
    }

    public static boolean a(j r100, List r101, f r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "mediaStack");
        Intrinsics.checkNotNullParameter(r101, "top");
        Intrinsics.checkNotNullParameter(r102, "applicant");
        CopyOnWriteArrayList<f> r103 = new CopyOnWriteArrayList();
        ListIterator r104 = r101.listIterator(r101.size());
    L4:
        if (r104.hasPrevious() == false) goto L11;
        Object r105 = r104.previous();
        f r106 = (f) r105;
        if (r106.f509629b.f509625a.c(r106, r102, r110) != MediaOccupyStrategy.REJECT) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L4;
    L13:
        if (((f) r105) == null) goto L15;
        return false;
    L15:
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r109 = r101.iterator();
    L17:
        if (r109.hasNext() == false) goto L19;
        f r111 = (f) r109.next();
        r108.add(r111.f509629b.f509625a.c(r111, r102, r110));
        goto L17
    L19:
        Iterator r112 = r101.iterator();
        int r113 = 0;
    L21:
        if (r112.hasNext() == false) goto L35;
        Object r114 = r112.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        f r116 = (f) r114;
        int r117 = a.f509634a[((MediaOccupyStrategy) ListProtector.get(r108, r113)).ordinal()];
        if (r117 != 1) goto L28;
        r116.a(MediaState.PAUSED);
        r103.add(r116);
        r116.f509629b.f509625a.i(r116, r102);
    L33:
        r113 = r115;
        goto L21
    L28:
        if (r117 != 2) goto L31;
        r116.a(MediaState.INVALID);
        r116.f509629b.f509625a.e(r116);
        goto L33
    L31:
        throw new IllegalAccessException("reject has not been handle");
    L35:
        if (r108.contains(MediaOccupyStrategy.REJECT) == false) goto L38;
        return false;
    L38:
        if (r100.f509632a.isEmpty() == true) goto L41;
        FLogger.f375446a.i("OnMediaStateChangeListener", "tryPauseCurrentAndPushNew pop : " + r100.a());
        CopyOnWriteArrayList<f> r118 = r100.f509632a.pollFirst();
    L41:
        if ((!r103.isEmpty()) == false) goto L43;
        Intrinsics.checkNotNullParameter(r103, "applicants");
        r100.f509632a.push(r103);
    L43:
        CopyOnWriteArrayList<f> r119 = new CopyOnWriteArrayList(CollectionsKt.mutableListOf(new f[]{r102}));
        Intrinsics.checkNotNullParameter(r119, "applicants");
        r100.f509632a.push(r119);
        return true;
    L8:
        r107 = false;
        goto L9
    L11:
        r105 = null;
        goto L13
    }
}
