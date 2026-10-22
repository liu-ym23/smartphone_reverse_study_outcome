package qq3;

import com.bytedance.android.window.shop.home.tab.common.CategoryRequestParamKey;
import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowDataSourceConfig;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowVODataType;
import com.bytedance.android.window.shop.repository.tab.datasource.g;
import com.bytedance.android.window.shop.repository.tab.datasource.impl.WindowTabHybridDataSource;
import com.bytedance.android.window.shop.repository.tab.entity.n0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements com.bytedance.android.window.shop.repository.tab.datasource.c {
    public String a;
    public String b;
    public String c;
    public com.bytedance.android.window.shop.repository.tab.datasource.c d;
    public WindowTabHybridDataSource e;
    public final LinkedHashSet<pq3.a> f;

    public final void a() {
        WindowTabHybridDataSource r0 = this.e;
        if (r0 == null) goto L5;
        r0.b.dispose();
    L5:
        Iterator<T> r1 = this.f.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((pq3.a) r1.next()).onReset();
        goto L7
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void e() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((pq3.a) r0.next()).onFinished();
        goto L4
    }

    public d() {
        this.f = new LinkedHashSet();
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void c(com.bytedance.android.window.shop.repository.tab.datasource.impl.a<?, ?> r2) {
        com.bytedance.android.window.shop.repository.tab.datasource.c r3 = this.d;
        if (r3 == null) goto L5;
        r3.c(null);
    L5:
        Iterator<T> r4 = this.f.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        ((pq3.a) r4.next()).onFinished();
        goto L7
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void onError(String r2) {
        Intrinsics.checkNotNullParameter("", "msg");
        com.bytedance.android.window.shop.repository.tab.datasource.c r3 = this.d;
        if (r3 == null) goto L5;
        r3.onError("");
    L5:
        Iterator<T> r4 = this.f.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        ((pq3.a) r4.next()).onFinished();
        goto L7
    }

    public final void b(CategoryRequestParamKey r3, Function1<? super ShopWindowDataSourceConfig<?>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        WindowTabHybridDataSource r0 = this.e;
        if (r0 == null) goto L5;
        r0.b.dispose();
    L5:
        WindowTabHybridDataSource r1 = new WindowTabHybridDataSource(r3.getCategoryId(), new g());
        if (r4 == null) goto L8;
        Unit r5 = (Unit) r4.invoke(r1.g);
    L8:
        String r6 = this.a;
        if (r6 == null) goto L11;
        r1.g.b().setSecAuthorId(r6);
    L11:
        String r7 = this.c;
        if (r7 == null) goto L14;
        r1.g.b().setPassThroughApi(r7);
    L14:
        String r8 = this.b;
        if (r8 == null) goto L17;
        r1.g.b().setEcExtra(r8);
    L17:
        this.e = r1;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void f(WindowTabInfoProvider r2, mq3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "dto");
        Intrinsics.checkNotNullParameter(r3, "reqParam");
        com.bytedance.android.window.shop.repository.tab.datasource.c r0 = this.d;
        if (r0 == null) goto L6;
        r0.f(r2, r3);
        return;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void y(n0 r4, ShopWindowVODataType r5) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r5, "dataType");
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((pq3.a) r0.next()).a(r4.a);
        goto L4
    L6:
        com.bytedance.android.window.shop.repository.tab.datasource.c r1 = this.d;
        if (r1 == null) goto L9;
        r1.y(r4, r5);
    L9:
        Iterator<T> r6 = this.f.iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        ((pq3.a) r6.next()).b(r4.a);
        goto L11
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void F(int r2, long r3, Long r5) {
        com.bytedance.android.window.shop.repository.tab.datasource.c r0 = this.d;
        if (r0 == null) goto L6;
        r0.F(r2, r3, r5);
        return;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void V(String r7, int r8, long r9, Long r11) {
        com.bytedance.android.window.shop.repository.tab.datasource.c r0 = this.d;
        if (r0 == null) goto L6;
        r0.V(r7, r8, r9, r11);
        return;
    }
}
