package nm5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.view.ShareAdapter;
import com.bytedance.ee.bear.share.view.ShareNewFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareNewFragment f519598a;

    public b(ShareNewFragment r100) {
        this.f519598a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        e0 r101 = (e0) r100;
        ShareAdapter r102 = this.f519598a.f237277n;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r102.z2(r101);
        return;
    }
}
