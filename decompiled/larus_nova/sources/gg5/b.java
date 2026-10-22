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

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Integer, Unit> f481123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<String, String, Integer, Unit> f481124b;

    public static final class a {
    }

    static {
    }

    public static PermissionResponse a(MessageConfig r100) {
        BaseEntity r101 = new BaseEntity(r100.getToken(), r100.getDocumentType(), BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r101, "CONTENT_COPY"), null);
    }

    public b(c0 r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "notifyItemChanged");
        Intrinsics.checkNotNullParameter(r101, "translate");
        this.f481123a = r100;
        this.f481124b = r101;
    }
}
