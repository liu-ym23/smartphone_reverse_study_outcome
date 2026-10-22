package com.ss.android.lark.feed.molten.page;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.feed.shared.page.t;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f421064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.feed.molten.cache.b f421065b;

    @Override // com.ss.android.lark.feed.shared.page.t
    public final s a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "storeOwner");
        return (s) new ViewModelProvider(r100, new FeedItemsMoltenViewModelFactory$create$1(this)).get(Reflection.getOrCreateKotlinClass(FeedItemsMoltenViewModel.class));
    }

    @Inject
    public a(m r100, com.ss.android.lark.feed.molten.cache.b r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "localCache");
        this.f421064a = r100;
        this.f421065b = r101;
    }
}
