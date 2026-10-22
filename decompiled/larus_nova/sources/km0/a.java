package km0;

import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import s71.b;
import s71.d;
import s71.e;
import s71.g;
import v61.c;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements g<v61.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<CardTypeAndPriority> f504040a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f504041b = null;

    public a() {
    }

    static {
        f504041b = new a();
        f504040a = CollectionsKt.listOf(new CardTypeAndPriority[]{CardTypeAndPriority.DrawAndGuess, CardTypeAndPriority.WatchVideo, CardTypeAndPriority.AudienceLink, CardTypeAndPriority.VideoTalk});
    }

    public static boolean c(v61.a r100) {
        List<CardTypeAndPriority> r101 = f504040a;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        r102.add(((CardTypeAndPriority) r103.next()).getType());
        goto L4
    L7:
        return CollectionsKt.contains(r102, r100.f553379j);
    }

    @Override // s71.g
    public final d a(v61.a r100, c r101) {
        v61.a r102 = (v61.a) r101;
        Intrinsics.checkNotNullParameter(r100, EnvConst$GEO.US);
        Intrinsics.checkNotNullParameter(r102, "others");
        if (r100.f553380k < r102.f553380k) goto L6;
        return d.c.f540906a;
    L6:
        if (c(r100) == false) goto L9;
        return d.C7580d.f540907a;
    L9:
        return d.a.f540904a;
    }

    @Override // s71.g
    public final e b(c r100, v61.a r101) {
        v61.a r102 = (v61.a) r100;
        Intrinsics.checkNotNullParameter(r102, EnvConst$GEO.US);
        Intrinsics.checkNotNullParameter(r101, "winner");
        if (r102.f553380k > r101.f553380k) goto L8;
        if (c(r102) == false) goto L8;
        return b.f540901a;
    L8:
        return s71.a.f540900a;
    }
}
