package tq5;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.apply.ApplyMoveWikiToWikiFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMoveNodeAuthorizedUserInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ x a;
    public final /* synthetic */ WikiSelectorBean b;
    public final /* synthetic */ String c;

    public y(x r1, WikiSelectorBean r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r11) {
        GetMoveNodeAuthorizedUserInfoPuller.Result r2 = (GetMoveNodeAuthorizedUserInfoPuller.Result) r11;
        int r12 = x.k;
        tt5.a.h("WikiMoveToWikiCommand", "getMoveNodeAuthorizedUserInfo()...success, userInfo = " + r2);
        Toast.cancelLoading();
        x r13 = this.a;
        WikiDialogs r8 = r13.i;
        FragmentManager r1 = r13.b.getChildFragmentManager();
        Intrinsics.checkNotNull(r2);
        WikiSelectorBean r14 = this.b;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.f r9 = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.f(r1, r2, r14.d, r14.a, r14.f, this.a.c.getSpaceId(), this.c);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "param");
        r8.c();
        int r0 = ApplyMoveWikiToWikiFragment.s;
        Intrinsics.checkNotNullParameter(r9, "param");
        ApplyMoveWikiToWikiFragment r15 = new ApplyMoveWikiToWikiFragment();
        Bundle r3 = new Bundle();
        r3.putSerializable("extra_user", r9.b);
        r3.putString("extra_wiki_token", r9.c);
        r3.putString("extra_src_space_id", r9.d);
        r3.putString("extra_src_parent_token", r9.e);
        r3.putString("extra_space_id", r9.f);
        r3.putString("extra_parent_token", r9.g);
        r15.setArguments(r3);
        FragmentManager r4 = r9.a;
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r15, "ApplyMoveWikiToWikiFragment", r5);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r15, r5) == false) goto L10;
    L7:
        r8.i = r15;
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        r15.show(r4, "ApplyMoveWikiToWikiFragment");
        goto L7
    }
}
