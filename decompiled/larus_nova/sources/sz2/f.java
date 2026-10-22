package sz2;

import android.view.View;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<View> f543922b;

    public final View a() {
        return this.f543922b.get();
    }

    public final String getType() {
        return this.f543921a;
    }

    public f(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f543921a = r101;
        this.f543922b = new WeakReference(r100);
    }
}
