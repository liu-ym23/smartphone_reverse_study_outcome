package mf5;

import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SharePermissionViewModel f513636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f513637b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(SharePermissionViewModel r100, Function1<? super Throwable, Unit> r101) {
        this.f513636a = r100;
        this.f513637b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.e(this.f513636a.f232154d, "requestMentionUserReadPermissions failed", r101, false);
        this.f513637b.invoke(r101);
    }
}
