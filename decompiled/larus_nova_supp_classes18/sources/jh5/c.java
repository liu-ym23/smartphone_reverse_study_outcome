package jh5;

import com.bytedance.ee.bear.middleground.permission.custompassword.state.PasswordItemState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public final String a;
    public final PasswordItemState b;

    public c(String r2, PasswordItemState r3) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r3, "itemState");
        this.a = r2;
        this.b = r3;
    }
}
