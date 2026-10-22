package tt1;

import com.bytedance.android.livesdk.dispatch.utils.DispatchLogUtil;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m extends com.bytedance.android.livesdk.user.h<FollowPair> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f547532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBaseCallbackSchemaHandler.SchemaCallback f547533b;

    @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
    public final void onComplete() {
        IBaseCallbackSchemaHandler.SchemaCallback r100 = this.f547533b;
        if (r100 == null) goto L6;
        r100.onComplete();
        return;
    }

    @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Lazy r101 = DispatchLogUtil.f122274a;
        DispatchLogUtil.d(8, DispatchLogUtil.InstanceType.FOLLOW);
        IBaseCallbackSchemaHandler.SchemaCallback r102 = this.f547533b;
        if (r102 == null) goto L6;
        r102.onFailure(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
    public final void onNext(Object r100) {
        FollowPair r101 = (FollowPair) r100;
        Intrinsics.checkNotNullParameter(r101, "followPair");
        Lazy r102 = DispatchLogUtil.f122274a;
        DispatchLogUtil.d(6, DispatchLogUtil.InstanceType.FOLLOW);
        IBaseCallbackSchemaHandler.SchemaCallback r103 = this.f547533b;
        if (r103 == null) goto L6;
        r103.onSuccess(Integer.valueOf(r101.followStatus), "");
        return;
    }

    @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.f547532a.f547536a = r100;
    }

    public m(o r100, IBaseCallbackSchemaHandler.SchemaCallback r101) {
        this.f547532a = r100;
        this.f547533b = r101;
    }
}
