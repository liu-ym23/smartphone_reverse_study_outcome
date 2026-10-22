package j8b;

import com.bytedance.lark.policy.model.ResponseType;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T, R> f497749a = null;

    static {
        f497749a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.ss.android.lark.security.compliance.infra.network.h r101 = (com.ss.android.lark.security.compliance.infra.network.h) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        j r102 = (j) r101.f440448d;
        if (r102 == null) goto L5;
        ResponseType r103 = ResponseType.REMOTE;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f497753a = r103;
        r102.a().put("CCM_FILE_DOWNLOAD", r102.a().get("CCM_EXPORT"));
        return r102;
    L5:
        return null;
    }
}
