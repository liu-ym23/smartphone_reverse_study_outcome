package com.ss.android.lark.feed.cardcomponent.preview;

import com.ss.android.lark.chat.entity.reaction.Reaction;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f420946g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Reaction> f420947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f420948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f420949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f420950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f420951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f420952f;

    public static final class a {
    }

    static {
        f420946g = new c(CollectionsKt.emptyList(), 0);
    }

    public c(List r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "reactionList");
        this.f420947a = r100;
        this.f420948b = r101;
        this.f420949c = false;
        this.f420950d = false;
        this.f420951e = false;
        this.f420952f = 14;
    }
}
