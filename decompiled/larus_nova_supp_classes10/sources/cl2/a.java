package cl2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.livecommerce.saascoupon.presenter.d;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends QUIModule {
    public a() {
        super(0);
    }

    public final QIPresenter h() {
        Fragment r1 = a().i();
        if (r1 == null) goto L7;
        return new d(r1);
    L7:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final View f(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return th.a.d(r3, 2131564845, r4, 4);
    }
}
