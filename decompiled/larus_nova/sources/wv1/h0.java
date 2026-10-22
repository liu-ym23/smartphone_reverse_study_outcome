package wv1;

import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class h0 implements Function {
    public /* synthetic */ h0() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        return Integer.valueOf(((FeedDataKey) r100).hashCode());
    }
}
