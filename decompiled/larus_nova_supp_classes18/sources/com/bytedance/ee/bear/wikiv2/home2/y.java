package com.bytedance.ee.bear.wikiv2.home2;

import androidx.lifecycle.LifecycleOwner;
import androidx.room.RoomSQLiteQuery;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.functions.Function;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y implements Function<SpaceBean, Boolean> {
    public final LifecycleOwner a;
    public final Set<String> b;

    public y(LifecycleOwner r7) {
        Intrinsics.checkNotNullParameter(r7, "owner");
        this.a = r7;
        this.b = new LinkedHashSet();
        yq5.q r0 = (yq5.q) WikiDatabase.c().d();
        r0.getClass();
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT DISTINCT space_id FROM t_wiki_relation WHERE wiki_node_type = 2", 0);
        r0.a.getInvalidationTracker().createLiveData(new String[]{"t_wiki_relation"}, false, new yq5.g(r0, r1)).observe(r7, new x(this));
    }

    public final Object apply(Object r2) {
        SpaceBean r3 = (SpaceBean) r2;
        Intrinsics.checkNotNullParameter(r3, "t");
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L6;
        return Boolean.TRUE;
    L6:
        return Boolean.valueOf(this.b.contains(r3.space_id));
    }
}
