package uq3;

import com.bytedance.android.window.shop.repository.vo.WindowLabelType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final /* synthetic */ int d = 0;
    public String a;
    public WindowLabelType b;
    public final List<i> c;

    public static final class a {
        public static d a(com.bytedance.android.window.shop.repository.dto.m r6) {
            Intrinsics.checkNotNullParameter(r6, "dto");
            List<com.bytedance.android.window.shop.repository.dto.r> r0 = r6.b();
            if (r0 == null) goto L8;
            List<com.bytedance.android.window.shop.repository.dto.r> r1 = r0;
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator<T> r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L9;
            com.bytedance.android.window.shop.repository.dto.r r4 = (com.bytedance.android.window.shop.repository.dto.r) r2.next();
            int r5 = i.f;
            r3.add(i.a.a(r4));
        L9:
            List<com.bytedance.android.window.shop.repository.dto.r> r7 = r6.a();
            if (r7 == null) goto L15;
            List<com.bytedance.android.window.shop.repository.dto.r> r8 = r7;
            ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r10 = r8.iterator();
        L13:
            if (r10.hasNext() == false) goto L16;
            com.bytedance.android.window.shop.repository.dto.r r11 = (com.bytedance.android.window.shop.repository.dto.r) r10.next();
            int r12 = i.f;
            r9.add(i.a.a(r11));
        L16:
            ArrayList r13 = new ArrayList();
            if (r9 != null) goto L19;
            List r14 = CollectionsKt.emptyList();
        L20:
            r13.addAll(r14);
            List r15 = r3;
            if (r3 != null) goto L23;
            r15 = CollectionsKt.emptyList();
        L23:
            r13.addAll(r15);
            if (r13.isEmpty() == false) goto L26;
            return null;
        L26:
            d r16 = new d(r13);
            r16.a = r6.c();
            if (r9 != null) goto L29;
        L31:
            return r16;
        L29:
            if ((!r9.isEmpty()) != true) goto L31;
            WindowLabelType r17 = WindowLabelType.Hybrid;
            Intrinsics.checkNotNullParameter(r17, "<set-?>");
            r16.b = r17;
            goto L31
        L19:
            r14 = r9;
            goto L20
        L15:
            r9 = null;
            goto L16
        L8:
            r3 = null;
            goto L9
        }
    }

    static {
    }

    public d(List<i> r2) {
        Intrinsics.checkNotNullParameter(r2, "labelInfos");
        this.c = r2;
        this.b = WindowLabelType.PureText;
    }
}
