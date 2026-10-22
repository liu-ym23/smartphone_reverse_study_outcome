package mf5;

import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ SharePermissionViewModel a;
    public final /* synthetic */ Function1<Throwable, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(SharePermissionViewModel r1, Function1<? super Throwable, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e(this.a.d, "requestMentionUserReadPermissions failed", r5, false);
        this.b.invoke(r5);
    }
}
