package jh5;

import com.bytedance.ee.bear.middleground.permission.custompassword.model.PasswordLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f499090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PasswordLevel f499091b;

    public d(String r100, PasswordLevel r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "level");
        this.f499090a = r100;
        this.f499091b = r101;
    }
}
