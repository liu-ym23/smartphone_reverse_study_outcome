package com.bytedance.ee.bear.wikiv2.home2.model;

import com.larus.nova.R;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class i<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<V> f240933a = null;

    static {
        f240933a = new i();
    }

    public i() {
    }

    @Override // java.util.concurrent.Callable
    public final List<WikiSpaceType> call() {
        if (yp5.c.c() == false) goto L6;
        return CollectionsKt.listOf(new WikiSpaceType[]{new WikiSpaceType("all", eu5.b.f474075a.getString(R.string.LarkCCM_Wiki_CategoryMgmt_AllSpaces_Title)), new WikiSpaceType(WikiSpaceType.TEAM, eu5.b.f474075a.getString(R.string.LarkCCM_Wiki_CategoryMgmt_TeamSpaces_Title)), new WikiSpaceType(WikiSpaceType.PERSONAL, eu5.b.f474075a.getString(R.string.LarkCCM_Wiki_CategoryMgmt_PersonalSpaces_Title))});
    L6:
        return CollectionsKt.emptyList();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
