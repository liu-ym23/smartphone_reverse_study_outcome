package kp0;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.d;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f505489a = null;

    static {
        f505489a = new a();
    }

    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        e r111 = (e) r110;
        Intrinsics.checkNotNullParameter(r111, "it");
        List<MiniAppEntranceCell> r112 = ((d) r111.data).entranceList;
        if (r112 == null) goto L9;
        List<MiniAppEntranceCell> r113 = r112;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator<T> r114 = r113.iterator();
    L6:
        if (r114.hasNext() == false) goto L11;
        MiniAppEntranceCell r101 = (MiniAppEntranceCell) r114.next();
        r100.add(new MiniAppEntranceCell(r101.title, r101.desc, r101.icon, -1, r101.appId, r101.schema, r101.serverScenes, r101.extendExtra));
        goto L6
    L11:
        return r100;
    L9:
        return CollectionsKt.emptyList();
    }
}
