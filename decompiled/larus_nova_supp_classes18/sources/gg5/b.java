package gg5;

import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final Function1<Integer, Unit> a;
    public final Function3<String, String, Integer, Unit> b;

    public static final class a {
    }

    static {
    }

    public static PermissionResponse a(MessageConfig r4) {
        BaseEntity r0 = new BaseEntity(r4.getToken(), r4.getDocumentType(), BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r0, "CONTENT_COPY"), null);
    }

    public b(c0 r2, d0 r3) {
        Intrinsics.checkNotNullParameter(r2, "notifyItemChanged");
        Intrinsics.checkNotNullParameter(r3, "translate");
        this.a = r2;
        this.b = r3;
    }
}
