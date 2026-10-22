package uq3;

import com.bytedance.android.window.shop.repository.vo.WindowLabelType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f551213d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f551214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WindowLabelType f551215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<i> f551216c;

    public static final class a {
        public static d a(com.bytedance.android.window.shop.repository.dto.m r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            List<com.bytedance.android.window.shop.repository.dto.r> r101 = r100.b();
            if (r101 == null) goto L8;
            List<com.bytedance.android.window.shop.repository.dto.r> r102 = r101;
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<T> r104 = r102.iterator();
        L6:
            if (r104.hasNext() == false) goto L9;
            com.bytedance.android.window.shop.repository.dto.r r105 = (com.bytedance.android.window.shop.repository.dto.r) r104.next();
            int r106 = i.f551227f;
            r103.add(i.a.a(r105));
        L9:
            List<com.bytedance.android.window.shop.repository.dto.r> r107 = r100.a();
            if (r107 == null) goto L15;
            List<com.bytedance.android.window.shop.repository.dto.r> r108 = r107;
            ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
            Iterator<T> r110 = r108.iterator();
        L13:
            if (r110.hasNext() == false) goto L16;
            com.bytedance.android.window.shop.repository.dto.r r111 = (com.bytedance.android.window.shop.repository.dto.r) r110.next();
            int r112 = i.f551227f;
            r109.add(i.a.a(r111));
        L16:
            ArrayList r113 = new ArrayList();
            if (r109 != null) goto L19;
            List r114 = CollectionsKt.emptyList();
        L20:
            r113.addAll(r114);
            List r115 = r103;
            if (r103 != null) goto L23;
            r115 = CollectionsKt.emptyList();
        L23:
            r113.addAll(r115);
            if (r113.isEmpty() == false) goto L26;
            return null;
        L26:
            d r116 = new d(r113);
            r116.f551214a = r100.c();
            if (r109 != null) goto L29;
        L31:
            return r116;
        L29:
            if ((!r109.isEmpty()) != true) goto L31;
            WindowLabelType r117 = WindowLabelType.Hybrid;
            Intrinsics.checkNotNullParameter(r117, "<set-?>");
            r116.f551215b = r117;
            goto L31
        L19:
            r114 = r109;
            goto L20
        L15:
            r109 = null;
            goto L16
        L8:
            r103 = null;
            goto L9
        }
    }

    static {
    }

    public d(List<i> r100) {
        Intrinsics.checkNotNullParameter(r100, "labelInfos");
        this.f551216c = r100;
        this.f551215b = WindowLabelType.PureText;
    }
}
