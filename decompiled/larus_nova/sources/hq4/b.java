package hq4;

import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.AsyncFetchResult;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends com.bytedance.ee.bear.bitable.card.view.table.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f486501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hq4.a f486502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f486503c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f486504a;

        public a(b r100) {
            this.f486504a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f486504a;
            r101.f486502b.onRetry(r101.f486503c);
            this.f486504a.o();
        }
    }

    /* JADX INFO: renamed from: hq4.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C6184b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f486505a = null;

        static {
            int[] r100 = new int[AsyncFetchResult.EResultState.values().length];
            r100[AsyncFetchResult.EResultState.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[AsyncFetchResult.EResultState.TIMEOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f486505a = r100;
        }
    }

    public final void o() {
        View r100 = this.f486501a.findViewById(R.id.loadingLayout);
        if (r100 == null) goto L5;
        r100.setVisibility(0);
    L5:
        SpaceEmptyState r101 = (SpaceEmptyState) this.f486501a.findViewById(R.id.emptyView);
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        BearLottieView r102 = (BearLottieView) this.f486501a.findViewById(R.id.loadingIcon);
        if (r102 == null) goto L12;
        r102.playAnimation();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.table.n
    public final View getRootView() {
        return this.f486501a;
    }

    public b(View r100, hq4.a r101) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "retryDelegate");
        this.f486501a = r100;
        this.f486502b = r101;
        SpaceEmptyState r102 = (SpaceEmptyState) r100.findViewById(R.id.emptyView);
        if (r102 == null) goto L6;
        r102.setDesc(UIHelper.mustacheFormat(R.string.Bitable_SingleOption_ReloadTimeoutRetry, EventConstant.Value.RETRY, UIHelper.getString(R.string.Bitable_Common_ButtonRetry)));
        r102.setPrimaryClickListener(new a(this));
        return;
    }

    public final void p(int r100, AsyncFetchResult.EResultState r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f486503c = r100;
        int r102 = C6184b.f486505a[r101.ordinal()];
        if (r102 != 1) goto L5;
        o();
        return;
    L5:
        if (r102 == 2) goto L9;
        BearLottieView r103 = (BearLottieView) this.f486501a.findViewById(R.id.loadingIcon);
        if (r103 == null) goto L20;
        r103.cancelAnimation();
        return;
    L20:
        return;
    L9:
        BearLottieView r104 = (BearLottieView) this.f486501a.findViewById(R.id.loadingIcon);
        if (r104 == null) goto L12;
        r104.cancelAnimation();
    L12:
        View r105 = this.f486501a.findViewById(R.id.loadingLayout);
        if (r105 == null) goto L15;
        r105.setVisibility(8);
    L15:
        SpaceEmptyState r106 = (SpaceEmptyState) this.f486501a.findViewById(R.id.emptyView);
        if (r106 == null) goto L22;
        r106.setVisibility(0);
        return;
    }
}
