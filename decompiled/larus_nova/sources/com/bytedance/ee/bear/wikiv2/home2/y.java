package com.bytedance.ee.bear.wikiv2.home2;

import androidx.lifecycle.LifecycleOwner;
import androidx.room.RoomSQLiteQuery;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.functions.Function;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class y implements Function<SpaceBean, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f240957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f240958b;

    public y(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f240957a = r100;
        this.f240958b = new LinkedHashSet();
        yq5.q r101 = (yq5.q) WikiDatabase.c().d();
        r101.getClass();
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT DISTINCT space_id FROM t_wiki_relation WHERE wiki_node_type = 2", 0);
        r101.f568835a.getInvalidationTracker().createLiveData(new String[]{"t_wiki_relation"}, false, new yq5.g(r101, r102)).observe(r100, new x(this));
    }

    @Override // io.reactivex.functions.Function
    public final Boolean apply(SpaceBean r100) {
        SpaceBean r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == false) goto L6;
        return Boolean.TRUE;
    L6:
        return Boolean.valueOf(this.f240958b.contains(r101.space_id));
    }
}
