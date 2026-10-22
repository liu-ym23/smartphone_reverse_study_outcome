package com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository;

import androidx.paging.DataSource;
import com.bytedance.android.livesdk.livecommerce.ECLiveCommerceModel_ProvideNetServiceFactory;
import el2.l;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nl2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/replayrepository/ECReplayScrollProductCardDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "", "Lni2/a;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECReplayScrollProductCardDataSourceFactory extends DataSource.Factory<Integer, ni2.a> {
    public l a;
    public final oi2.a b;
    public final com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a c;
    public final c d;

    public final class a implements DataSource.InvalidatedCallback {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void onInvalidated() {
            this.a.invoke();
        }
    }

    public final DataSource<Integer, ni2.a> create() {
        ECReplayScrollProductCardDataSource r0 = new ECReplayScrollProductCardDataSource(this.a, this.b, this.c, this.d);
        r0.addInvalidatedCallback(new a(new ECReplayScrollProductCardDataSourceFactory$create$1$1(this.c)));
        return r0;
    }

    public ECReplayScrollProductCardDataSourceFactory(oi2.a r2, com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a r3, c r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "disposableScope");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = ECLiveCommerceModel_ProvideNetServiceFactory.proxyProvideNetService(hh2.a.a().f);
    }
}
