package eq5;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.route.parcelable.f;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.wikiv2.searchv2.c;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.j;
import iq5.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements f {
    public a() {
    }

    public final void a(Fragment r2, SelectorConfig r3, td5.f r4, SpaceSelectorBean r5, WikiSelectorBean r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        y.b(r2, r3, r4, r5, r6);
    }

    public final void b(Context r1, c r2, Bundle r3, int r4, Fragment r5) {
        Intrinsics.checkNotNullParameter(r2, "navigationData");
        j.b(r2, r3, r4, r5);
    }

    public final void c(Context r1, SelectorConfig r2, td5.f r3, SpaceSelectorBean r4, WikiSelectorBean r5) {
        y.a(r1, r2, r3, r4, r5);
    }
}
