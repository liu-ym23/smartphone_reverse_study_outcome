package vmb;

import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.feed.shared.page.t;
import com.ss.android.lark.feed.shared.page.u;
import com.ss.android.lark.flow.feed.page.FlowMixedFeedFragment;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.passportc.api.m;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKUserScope
public final class b extends c0c.c implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f556354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f556355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f556356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.flow.feed.data.a f556357e;

    @Override // vmb.a
    public final String t() {
        return this.f21993a.getUser().userId;
    }

    @Override // vmb.a
    public final com.ss.android.lark.flow.feed.data.a Q() {
        return this.f556357e;
    }

    @Override // vmb.a
    public final l w() {
        return this.f556354b;
    }

    @Override // vmb.a
    public final s M(FlowMixedFeedFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "storeOwner");
        s r101 = this.f556355c.a(r100);
        r101.setFilterDoubaoConversation(false);
        return r101;
    }

    @Override // vmb.a
    public final s t0(ViewModelStoreOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "storeOwner");
        return this.f556356d.a(r100);
    }

    @Inject
    public b(m r100, l r101, t r102, u r103, com.ss.android.lark.flow.feed.data.a r104) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "rustClient");
        Intrinsics.checkNotNullParameter(r102, "feedItemsViewModelFactory");
        Intrinsics.checkNotNullParameter(r103, "feedSidebarItemsViewModelFactory");
        Intrinsics.checkNotNullParameter(r104, "doubaoFeedMigrateStatus");
        super(r100);
        this.f556354b = r101;
        this.f556355c = r102;
        this.f556356d = r103;
        this.f556357e = r104;
    }
}
