package ip0;

import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f495253a = null;

    static {
        f495253a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b r101 = (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        LinkedHashMap r102 = new LinkedHashMap();
        List<MiniAppEntranceCell> r103 = r101.entranceList;
        if (r103 == null) goto L11;
        Iterator<T> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L11;
        T r105 = r104.next();
        Long r106 = Long.valueOf(((MiniAppEntranceCell) r105).groupId);
        Object r107 = r102.get(r106);
        if (r107 != null) goto L10;
        r107 = new ArrayList();
        r102.put(r106, r107);
    L10:
        ((List) r107).add(r105);
    L11:
        int r108 = qo0.a.f534145a;
        StringBuilder r109 = new StringBuilder("start update grouped list, entrance cell count: ");
        r109.append(r102.size());
        r109.append(", banner count: ");
        List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> r110 = r101.a();
        if (r110 == null) goto L14;
        Integer r111 = Integer.valueOf(r110.size());
    L15:
        r109.append(String.valueOf(r111));
        qo0.a.c("choose_list", r109.toString());
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r112 = AnchorMiniAppDataContext.a.a();
        if (r112 == null) goto L24;
        m<Boolean> r113 = r112.getSupportComponentCoexist();
        if (r113 == null) goto L24;
        if (r113.getValue().booleanValue() != true) goto L24;
        List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> r114 = r101.a();
        if (r114 != null) goto L25;
        r114 = CollectionsKt.emptyList();
    L25:
        List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c> r115 = r101.groupPropertyList;
        if (r115 != null) goto L29;
        r115 = CollectionsKt.emptyList();
    L29:
        return new b(r102, r114, r115);
    L24:
        r114 = CollectionsKt.emptyList();
        goto L25
    L14:
        r111 = null;
        goto L15
    }
}
