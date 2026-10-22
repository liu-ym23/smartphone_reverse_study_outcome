package com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;
import com.bytedance.android.livesdk.livecommerce.ECLiveCommerceModel_ProvideAbServiceFactory;
import el2.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardViewModelProviderFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECScrollProductCardViewModelProviderFactory implements ViewModelProvider.Factory {
    public g a;
    public final ml.b b;
    public final ml.a c;
    public final JSONObject d;
    public final int e;
    public final String f;
    public final xk.a g;
    public final String h;
    public final long i;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final <T extends ViewModel> T create(Class<T> r14) {
        Intrinsics.checkNotNullParameter(r14, "modelClass");
        if (Intrinsics.areEqual(r14, ECScrollProductCardViewModel.class) == false) goto L13;
        g r15 = this.a;
        if (r15 == null) goto L9;
        Integer r16 = (Integer) r15.getLiveSettingValue("ecom_live_replay_product_page_size", 10);
        if (r16 == null) goto L9;
        int r6 = r16.intValue();
    L11:
        return new ECScrollProductCardViewModel(this.b, this.c, this.d, r6, this.e, this.f, this.g, this.h, this.i);
    L9:
        r6 = 10;
        goto L11
    L13:
        if (Intrinsics.areEqual(r14, ECReplayScrollProductCardViewModel.class) == false) goto L23;
        ExplainPlaybackRequest r17 = this.g.a();
        if (r17 == null) goto L19;
        Integer r18 = r17.getPageSize();
        if (r18 == null) goto L19;
        int r7 = r18.intValue();
    L21:
        return new ECReplayScrollProductCardViewModel(this.b, this.c, this.d, r7, this.e, this.f, this.g, this.h, this.i);
    L19:
        r7 = 10;
        goto L21
    L23:
        return r14.newInstance();
    }

    public ECScrollProductCardViewModelProviderFactory(ml.b r2, ml.a r3, JSONObject r4, int r5, String r6, xk.a r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r2, "roomInfo");
        Intrinsics.checkNotNullParameter(r3, "btmInfo");
        Intrinsics.checkNotNullParameter(r4, "entranceInfo");
        Intrinsics.checkNotNullParameter(r6, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "replayId");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.a = ECLiveCommerceModel_ProvideAbServiceFactory.proxyProvideAbService(hh2.a.a().f);
    }
}
