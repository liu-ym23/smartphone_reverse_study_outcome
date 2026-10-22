package pi2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.livesdk.livecommerce.livereplay.module.ECContainerUIModule;
import com.bytedance.android.livesdk.livecommerce.livereplay.presenter.ECScrollProductCardPresenter;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModelProviderFactory;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends QUIModule {
    public final String l;
    public final ViewModelProvider.Factory m;

    public final List<QUIModule> i() {
        return CollectionsKt.listOf(new QUIModule[]{new b(this.l, this.m), new ECContainerUIModule(this.l, this.m)});
    }

    public final QIPresenter h() {
        return new ECScrollProductCardPresenter(this.l, this.m);
    }

    public a(String r2, ECScrollProductCardViewModelProviderFactory r3) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        Intrinsics.checkNotNullParameter(r3, "factory");
        super(0);
        this.l = r2;
        this.m = r3;
    }

    public final View f(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        i r5 = i.a;
        String r0 = mi2.a.a;
        d r6 = r5.get(mi2.a.a);
        if (r6 == null) goto L5;
        r6.a("render_start");
    L5:
        LinearLayout r7 = new LinearLayout(r3);
        r7.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilityKotlinExtentionsKt.d(149)));
        r7.setOrientation(1);
        r7.setGravity(80);
        return r7;
    }
}
