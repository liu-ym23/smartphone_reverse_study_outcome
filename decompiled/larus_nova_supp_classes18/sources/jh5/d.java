package jh5;

import com.bytedance.ee.bear.middleground.permission.custompassword.model.PasswordLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final String a;
    public final PasswordLevel b;

    public d(String r2, PasswordLevel r3) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r3, "level");
        this.a = r2;
        this.b = r3;
    }
}
