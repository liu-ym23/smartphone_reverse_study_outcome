package reb;

import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.export.feedcard.e;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f537463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b<T> f537464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<FeedCard.Type, T> f537465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<AppFeedCardType, T> f537466d;

    /* JADX INFO: renamed from: reb.a$a, reason: collision with other inner class name */
    public static final class C7471a {
    }

    public interface b<T> {
        T a(e r100);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f537467a = null;

        static {
            int[] r100 = new int[FeedCard.Type.values().length];
            r100[FeedCard.Type.APP_FEED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f537467a = r100;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends e> r100, b<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "injectFactories");
        Intrinsics.checkNotNullParameter(r101, "creator");
        this.f537463a = r100;
        this.f537464b = r101;
        this.f537465c = new LinkedHashMap();
        this.f537466d = new LinkedHashMap();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        e r103 = (e) r102.next();
        T r104 = this.f537464b.a(r103);
        if (r104 == null) goto L4;
        this.f537465c.put(r103.type(), r104);
        if (r103.bizType() == AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE) goto L4;
        this.f537466d.put(r103.bizType(), r104);
        goto L4
    }

    public final T a(FeedCard.Type r100, AppFeedCardType r101) {
        if (r100 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != (-1)) goto L9;
        Log.e("OpenFeedCardWrapper", "feedType is empty");
        return null;
    L9:
        if (r102 != 1) goto L19;
        if (r101 == null) goto L16;
        T r103 = (T) ((LinkedHashMap) this.f537466d).get(r101);
        if (r103 == null) goto L16;
        return r103;
    L16:
        Log.e("OpenFeedCardWrapper", "bizType is empty");
        return null;
    L19:
        return (T) ((LinkedHashMap) this.f537465c).get(r100);
    L5:
        r102 = c.f537467a[r100.ordinal()];
        goto L7
    }
}
