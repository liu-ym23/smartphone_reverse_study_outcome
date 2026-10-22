package qx4;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.contract.DebugRequest;
import com.bytedance.ee.bear.debug.net.RequestActivity;
import com.bytedance.ee.bear.debug.net.RequestAdapter;
import com.bytedance.ee.bear.debug.net.RequestDetailFragment;
import com.bytedance.ee.bear.widgets.t;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends t {
    public final /* synthetic */ RequestAdapter c;
    public final /* synthetic */ DebugRequest d;

    public final void a(View r7) {
        if ((RequestAdapter.y2(this.c) instanceof RequestActivity) == false) goto L10;
        Object r8 = RequestAdapter.y2(this.c);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.bytedance.ee.bear.debug.net.RequestActivity");
        RequestActivity r9 = (RequestActivity) r8;
        DebugRequest r0 = this.d;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "request");
        FragmentTransaction r10 = r9.getSupportFragmentManager().beginTransaction().setCustomAnimations(2130772290, 2130772289, 2130772288, 2130772293);
        int r2 = RequestDetailFragment.f;
        Intrinsics.checkNotNullParameter(r0, "request");
        RequestDetailFragment r1 = new RequestDetailFragment();
        Bundle r3 = new Bundle();
        r3.putParcelable("extra_request", r0);
        r1.setArguments(r3);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131367728) == true) goto L8;
        r10 = r10.add(2131367728, r1);
    L8:
        r10.addToBackStack(null).commitAllowingStateLoss();
        return;
    }

    public e(RequestAdapter r1, DebugRequest r2) {
        this.c = r1;
        this.d = r2;
    }
}
