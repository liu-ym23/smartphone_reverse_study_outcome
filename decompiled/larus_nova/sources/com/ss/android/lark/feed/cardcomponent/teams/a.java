package com.ss.android.lark.feed.cardcomponent.teams;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Comparator;
import java.util.List;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class a<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f420981a;

    public a(List r100) {
        this.f420981a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        int r102 = ((Number) r100).intValue();
        Float r103 = Float.valueOf(((FeedTeamView.b) ListProtector.get(this.f420981a, r102)).f420977b);
        int r104 = ((Number) r101).intValue();
        return ComparisonsKt.compareValues(r103, Float.valueOf(((FeedTeamView.b) ListProtector.get(this.f420981a, r104)).f420977b));
    }
}
