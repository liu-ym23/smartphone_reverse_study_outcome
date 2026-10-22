package dp8;

import android.util.LruCache;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Pair<String, CreationMsgContentData> f469614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, CreationMsgContentData> f469615b = null;

    static {
        f469615b = new LruCache(30);
    }

    public static CreationMsgContentData a(String r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "parseCallback");
        if (r100 != null) goto L5;
        return null;
    L5:
        Pair<String, CreationMsgContentData> r102 = f469614a;
        if (r102 == null) goto L8;
        String r103 = r102.getFirst();
    L10:
        if (Intrinsics.areEqual(r100, r103) == false) goto L15;
        Pair<String, CreationMsgContentData> r104 = f469614a;
        if (r104 != null) goto L14;
        return null;
    L14:
        return r104.getSecond();
    L15:
        LruCache<String, CreationMsgContentData> r105 = f469615b;
        CreationMsgContentData r106 = r105.get(r100);
        if (r106 != null) goto L20;
        r106 = (CreationMsgContentData) r101.invoke(r100);
        if (r106 == null) goto L20;
        r105.put(r100, r106);
    L20:
        f469614a = TuplesKt.to(r100, r106);
        return r106;
    L8:
        r103 = null;
        goto L10
    }
}
