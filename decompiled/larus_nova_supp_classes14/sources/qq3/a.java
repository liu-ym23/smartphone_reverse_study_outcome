package qq3;

import com.bytedance.android.window.shop.home.tab.common.TabTypeRequestParamKey;
import com.bytedance.android.window.shop.home.tab.common.WindowTabRequestParamKey;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowDataSourceConfig;
import com.bytedance.android.window.shop.repository.tab.datasource.impl.e;
import com.bytedance.android.window.shop.repository.tab.datasource.impl.f;
import com.bytedance.android.window.shop.repository.tab.datasource.impl.h;
import com.bytedance.android.window.shop.repository.tab.datasource.impl.j;
import com.bytedance.android.window.shop.repository.tab.datasource.impl.k;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends b<TabTypeRequestParamKey> {

    /* JADX INFO: renamed from: qq3.a$a, reason: collision with other inner class name */
    public static final class C0158a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public a() {
    }

    @Override // qq3.b
    public final com.bytedance.android.window.shop.repository.tab.datasource.impl.a d(WindowTabRequestParamKey r2) {
        TabTypeRequestParamKey r3 = (TabTypeRequestParamKey) r2;
        Intrinsics.checkNotNullParameter(r3, "key");
        int r0 = C0158a.a;
        ConcurrentHashMap<Integer, com.bytedance.android.window.shop.c> r1 = com.bytedance.android.window.shop.c.b;
        com.bytedance.android.window.shop.c r4 = com.bytedance.android.window.shop.c.a.a(r3.getTabType());
        Intrinsics.checkNotNullParameter(r4, "type");
        if (Intrinsics.areEqual(r4, com.bytedance.android.window.shop.c.c) == false) goto L6;
        return new j();
    L6:
        if (Intrinsics.areEqual(r4, com.bytedance.android.window.shop.c.e) == false) goto L9;
        return new h();
    L9:
        if (Intrinsics.areEqual(r4, com.bytedance.android.window.shop.c.d) == false) goto L12;
        return new k();
    L12:
        if (Intrinsics.areEqual(r4, com.bytedance.android.window.shop.c.f) == false) goto L15;
        return new f();
    L15:
        return new e(r4);
    }

    @Override // qq3.b
    public final void j(com.bytedance.android.window.shop.repository.tab.datasource.impl.a<? extends mq3.a, ? extends ShopWindowDataSourceConfig<? extends mq3.a>> r4, WindowTabDataListResponseDTODeprecated r5, WindowLayoutType r6) {
        Intrinsics.checkNotNullParameter(r4, "dataSource");
        int r0 = com.bytedance.android.window.shop.d.a;
        Object r1 = null;
        if (r5 == null) goto L5;
        Integer r2 = r5.getTabType();
    L6:
        if (r2 != null) goto L8;
        com.bytedance.android.window.shop.c r3 = null;
    L10:
        if (Intrinsics.areEqual(r4.getType(), r3) == false) goto L21;
        r4.e.b = r5;
        if (r3.getType() != 100) goto L22;
        Object r7 = r4.e;
        if ((r7 instanceof com.bytedance.android.window.shop.repository.tab.datasource.d) == false) goto L17;
        r1 = r7;
    L17:
        com.bytedance.android.window.shop.repository.tab.datasource.d r8 = (com.bytedance.android.window.shop.repository.tab.datasource.d) r1;
        if (r8 == null) goto L23;
        r8.d = r6;
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L8:
        ConcurrentHashMap<Integer, com.bytedance.android.window.shop.c> r9 = com.bytedance.android.window.shop.c.b;
        r3 = com.bytedance.android.window.shop.c.a.a(r2.intValue());
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
