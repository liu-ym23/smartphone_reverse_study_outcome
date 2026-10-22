package uw1;

import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.h;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import com.larus.nova.R;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FeedStyle f551925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f551926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FeedDataKey f551927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PublishSubject<Boolean> f551928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IFeedActionCallback f551929e;

    public final Map<Integer, b90.a> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(R.layout.ttlive_item_feed_live_simple), new d(this)), TuplesKt.to(Integer.valueOf(R.layout.ttlive_feed_item_rank), new c(this))});
    }

    public e(FeedStyle r100, h r101, FeedDataKey r102, PublishSubject<Boolean> r103, IFeedActionCallback r104) {
        Intrinsics.checkNotNullParameter(r100, "feedStyle");
        Intrinsics.checkNotNullParameter(r101, "feedLiveParams");
        Intrinsics.checkNotNullParameter(r102, "feedDataKey");
        Intrinsics.checkNotNullParameter(r103, "userVisibility");
        Intrinsics.checkNotNullParameter(r104, "feedActionCallback");
        this.f551925a = r100;
        this.f551926b = r101;
        this.f551927c = r102;
        this.f551928d = r103;
        this.f551929e = r104;
    }
}
