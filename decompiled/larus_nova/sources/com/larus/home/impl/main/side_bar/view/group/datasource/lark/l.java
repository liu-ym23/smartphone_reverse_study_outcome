package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import com.larus.home.impl.main.side_bar.data.SideBarItemType;
import com.larus.home.impl.main.side_bar.data.j0;
import com.ss.ttm.player.MediaPlayer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l {

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((d) r101).a()), Long.valueOf(((d) r100).a()));
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f345432a;

        public b(a r100) {
            this.f345432a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f345432a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(((d) r100).f345406a, ((d) r101).f345406a);
        }
    }

    public static final zb9.i b(d r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        j0 r111 = new j0(SideBarItemType.HUMAN_FEED, null, null, null, null, null, null, r110, false, r110.f345410e, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300);
        long r100 = r110.a();
        long r101 = r110.a();
        if (r110.b() == false) goto L5;
        long r102 = r110.f345407b;
    L7:
        return new zb9.i(r111, r100, r101, r102, false, 16);
    L5:
        r102 = 0;
        goto L7
    }

    public static final List<d> c(List<d> r100) {
        return CollectionsKt.sortedWith(r100, new b(new a()));
    }

    public static final List a(List r100, List r101) {
        if (r101.isEmpty() == true) goto L17;
        LinkedHashMap r102 = new LinkedHashMap(r100.size() + r101.size());
        Iterator r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        d r104 = (d) r103.next();
        r102.put(r104.f345406a, r104);
        goto L7
    L9:
        Iterator r105 = r101.iterator();
    L11:
        if (r105.hasNext() == false) goto L14;
        d r106 = (d) r105.next();
        r102.put(r106.f345406a, r106);
        goto L11
    L14:
        return c(CollectionsKt.toList(r102.values()));
    L17:
        return r100;
    }
}
