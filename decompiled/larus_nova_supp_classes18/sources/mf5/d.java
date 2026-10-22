package mf5;

import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ SharePermissionViewModel a;

    public d(SharePermissionViewModel r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "throwable");
        tt5.a.e(this.a.d, "fetchUserPermission: ", r5, false);
    }
}
