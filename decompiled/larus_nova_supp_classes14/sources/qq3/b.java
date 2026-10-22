package qq3;

import com.bytedance.android.window.shop.home.tab.common.WindowTabRequestParamKey;
import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowDataSourceConfig;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowVODataType;
import com.bytedance.android.window.shop.repository.tab.datasource.f;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.n0;
import com.bytedance.android.window.shop.repository.tab.entity.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class b<T extends WindowTabRequestParamKey> implements com.bytedance.android.window.shop.repository.tab.datasource.c {
    public String a;
    public String b;
    public com.bytedance.android.window.shop.repository.tab.datasource.c c;
    public com.bytedance.android.window.shop.repository.tab.datasource.impl.a<? extends mq3.a, ? extends ShopWindowDataSourceConfig<? extends mq3.a>> d;
    public final Map<Integer, f> e;
    public final LinkedHashSet<pq3.a> f;
    public boolean g;

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void F(int r1, long r2, Long r4) {
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void V(String r1, int r2, long r3, Long r5) {
    }

    public abstract com.bytedance.android.window.shop.repository.tab.datasource.impl.a<? extends mq3.a, ? extends ShopWindowDataSourceConfig<? extends mq3.a>> d(T r1);

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void e() {
        this.g = true;
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((pq3.a) r0.next()).onFinished();
        goto L4
    }

    public abstract void j(com.bytedance.android.window.shop.repository.tab.datasource.impl.a<? extends mq3.a, ? extends ShopWindowDataSourceConfig<? extends mq3.a>> r1, WindowTabDataListResponseDTODeprecated r2, WindowLayoutType r3);

    public final void b() {
        com.bytedance.android.window.shop.repository.tab.datasource.impl.a<? extends mq3.a, ? extends ShopWindowDataSourceConfig<? extends mq3.a>> r0 = this.d;
        if (r0 == null) goto L5;
        r0.a.dispose();
    L5:
        Iterator<T> r1 = this.f.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((pq3.a) r1.next()).onReset();
        goto L7
    }

    public final void h() {
        com.bytedance.android.window.shop.repository.tab.datasource.impl.a<? extends mq3.a, ? extends ShopWindowDataSourceConfig<? extends mq3.a>> r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.b.a == true) goto L8;
        com.bytedance.android.window.shop.repository.tab.datasource.c r1 = this.c;
        if (r1 == null) goto L17;
        r1.c(null);
        return;
    L17:
        return;
    L8:
        if (this.g == true) goto L10;
        r0.c(this);
        return;
    L10:
        r0.d(this);
    }

    public b() {
        this.e = MapsKt.mapOf(TuplesKt.to(1, new f()));
        this.f = new LinkedHashSet();
    }

    public final void a(List<? extends pq3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptorList");
        this.f.addAll(r2);
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void c(com.bytedance.android.window.shop.repository.tab.datasource.impl.a<?, ?> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, f>> r0 = this.e.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().getValue().getClass();
        Intrinsics.checkNotNullParameter(r3, "source");
        goto L6
    L8:
        com.bytedance.android.window.shop.repository.tab.datasource.c r4 = this.c;
        if (r4 == null) goto L11;
        r4.c(null);
    L11:
        Iterator<T> r5 = this.f.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        ((pq3.a) r5.next()).onFinished();
        goto L13
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void onError(String r4) {
        Intrinsics.checkNotNullParameter("", "msg");
        Iterator<Map.Entry<Integer, f>> r1 = this.e.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().getValue().getClass();
        Intrinsics.checkNotNullParameter("", "msg");
        goto L4
    L6:
        com.bytedance.android.window.shop.repository.tab.datasource.c r0 = this.c;
        if (r0 == null) goto L9;
        r0.onError("");
    L9:
        Iterator<T> r5 = this.f.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        ((pq3.a) r5.next()).onFinished();
        goto L11
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void f(WindowTabInfoProvider r2, mq3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "dto");
        Intrinsics.checkNotNullParameter(r3, "reqParam");
        com.bytedance.android.window.shop.repository.tab.datasource.c r0 = this.c;
        if (r0 == null) goto L6;
        r0.f(r2, r3);
        return;
    }

    public final void g(T r2, Function1<? super ShopWindowDataSourceConfig<?>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        com.bytedance.android.window.shop.repository.tab.datasource.impl.a<? extends mq3.a, ? extends ShopWindowDataSourceConfig<? extends mq3.a>> r0 = this.d;
        if (r0 == null) goto L5;
        r0.a.dispose();
    L5:
        com.bytedance.android.window.shop.repository.tab.datasource.impl.a<? extends mq3.a, ? extends ShopWindowDataSourceConfig<? extends mq3.a>> r4 = d(r2);
        if (r3 == null) goto L8;
        Unit r5 = (Unit) r3.invoke(r4.e);
    L8:
        String r6 = this.a;
        if (r6 == null) goto L11;
        ((mq3.a) r4.e.b()).setSecAuthorId(r6);
    L11:
        String r7 = this.b;
        if (r7 == null) goto L14;
        ((mq3.a) r4.e.b()).setPassThroughApi(r7);
    L14:
        this.d = r4;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void y(n0 r9, ShopWindowVODataType r10) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "dataType");
        Iterator<Map.Entry<Integer, f>> r1 = this.e.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L26;
        f r2 = r1.next().getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "data");
        if (Intrinsics.areEqual(r9.getType(), com.bytedance.android.window.shop.c.d) == false) goto L4;
        List<com.bytedance.android.window.shop.repository.tab.entity.f> r3 = r9.a;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        Object r6 = r5.next();
        com.bytedance.android.window.shop.repository.tab.entity.f r7 = (com.bytedance.android.window.shop.repository.tab.entity.f) r6;
        if ((r7 instanceof o0) == true) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == false) goto L9;
        r4.add(r6);
        goto L9
    L13:
        if (((o0) r7).o == null) goto L15;
        r8 = true;
        goto L16
    L18:
        Iterator r11 = r4.iterator();
    L20:
        if (r11.hasNext() == false) goto L4;
        com.bytedance.android.window.shop.repository.tab.entity.f r12 = (com.bytedance.android.window.shop.repository.tab.entity.f) r11.next();
        List<Long> r13 = r2.a;
        if (r12 == null) goto L25;
        Long r14 = ((o0) r12).o;
        Intrinsics.checkNotNull(r14);
        ((ArrayList) r13).add(r14);
        goto L20
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.repository.tab.entity.WindowVideoItemVO");
    L26:
        com.bytedance.android.window.shop.repository.tab.datasource.c r0 = this.c;
        if (r0 == null) goto L29;
        r0.y(r9, r10);
    L29:
        Iterator<T> r15 = this.f.iterator();
    L31:
        if (r15.hasNext() == false) goto L33;
        ((pq3.a) r15.next()).b(r9.a);
        goto L31
    }

    public final void i(WindowTabDataListResponseDTODeprecated r3, String r4, WindowLayoutType r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "secAuthorId");
        this.a = r4;
        this.b = r6;
        com.bytedance.android.window.shop.repository.tab.datasource.impl.a<? extends mq3.a, ? extends ShopWindowDataSourceConfig<? extends mq3.a>> r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        ((mq3.a) r0.e.b()).setSecAuthorId(r4);
        ((mq3.a) r0.e.b()).setPassThroughApi(r6);
        j(r0, r3, r5);
    }
}
