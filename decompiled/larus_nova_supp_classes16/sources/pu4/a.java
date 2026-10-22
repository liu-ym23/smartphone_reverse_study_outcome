package pu4;

import com.bytedance.ee.bear.bitable.share.permission.BitableSharePermission;
import com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission;
import com.bytedance.ee.bear.bitable.share.permission.IBitableShareUserPermission;
import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: pu4.a$a, reason: collision with other inner class name */
    public static final class C0273a<T1, T2, R> implements BiFunction {
        public static final C0273a<T1, T2, R> a = null;

        static {
            a = new C0273a();
        }

        public C0273a() {
        }

        public final Object apply(Object r2, Object r3) {
            IBitableShareUserPermission r4 = (IBitableShareUserPermission) r2;
            IBitableSharePublicPermission r5 = (IBitableSharePublicPermission) r3;
            Intrinsics.checkNotNullParameter(r4, "t1");
            Intrinsics.checkNotNullParameter(r5, "t2");
            return new BitableSharePermission(r4, r5);
        }
    }

    static {
    }

    @JvmStatic
    public static final Flowable<BitableSharePermission> a(String r8, String r9, String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r8, "baseToken");
        Intrinsics.checkNotNullParameter(r9, "shareToken");
        Intrinsics.checkNotNullParameter(r10, "tableId");
        Intrinsics.checkNotNullParameter(r11, "viewId");
        Intrinsics.checkNotNullParameter(r8, "baseToken");
        Intrinsics.checkNotNullParameter(r10, "tableId");
        Intrinsics.checkNotNullParameter(r11, "viewId");
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        NetService.f r7 = new NetService.f(String.format("/space/api/bitable/%s/share/user_permission", Arrays.copyOf(new Object[]{r8}, 1)));
        r7.b("tableId", r10);
        r7.b("viewId", r11);
        r7.b("shareType", String.valueOf(r12));
        r7.c = 2;
        Flowable r13 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new f()).a(r7).map(c.a);
        Intrinsics.checkNotNullParameter(r8, "baseToken");
        Intrinsics.checkNotNullParameter(r9, "shareToken");
        NetService.f r0 = new NetService.f(String.format("space/api/bitable/%s/share/permission", Arrays.copyOf(new Object[]{r8}, 1)));
        r0.b("shareToken", r9);
        r0.c = 2;
        return Flowable.zip(r13, ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new e()).a(r0).map(b.a), C0273a.a);
    }
}
