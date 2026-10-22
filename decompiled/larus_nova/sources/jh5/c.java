package jh5;

import com.bytedance.ee.bear.middleground.permission.custompassword.state.PasswordItemState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f499088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PasswordItemState f499089b;

    public c(String r100, PasswordItemState r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "itemState");
        this.f499088a = r100;
        this.f499089b = r101;
    }
}
