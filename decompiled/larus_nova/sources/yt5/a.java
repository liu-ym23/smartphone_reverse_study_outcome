package yt5;

import com.bytedance.ee.permission.sdk.define.IPermissionApi$ERequestMethod;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements xt5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f569137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f569138b;

    @Override // xt5.b
    public final Map<String, Serializable> b() {
        return null;
    }

    @Override // xt5.b
    public final String a() {
        StringCompanionObject r100 = StringCompanionObject.INSTANCE;
        return String.format("/api/suite/permission/public.v4/?token=%s&type=%d", Arrays.copyOf(new Object[]{this.f569137a, Integer.valueOf(this.f569138b)}, 2));
    }

    @Override // xt5.b
    public final IPermissionApi$ERequestMethod getMethod() {
        return IPermissionApi$ERequestMethod.GET;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        this.f569137a = r100;
        this.f569138b = 3;
    }
}
