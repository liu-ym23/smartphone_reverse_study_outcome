package com.ss.android.lark.feed.molten.page;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.feed.shared.page.u;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class FeedSidebarItemsMoltenViewModelFactory implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f421061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.feed.molten.cache.b f421062b;

    @Override // com.ss.android.lark.feed.shared.page.u
    public final s a(ViewModelStoreOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "storeOwner");
        return (s) new ViewModelProvider(r100, new FeedSidebarItemsMoltenViewModelFactory$create$1(this)).get(Reflection.getOrCreateKotlinClass(FeedSidebarItemsMoltenViewModel.class));
    }

    @Inject
    public FeedSidebarItemsMoltenViewModelFactory(m r100, com.ss.android.lark.feed.molten.cache.b r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "localCache");
        this.f421061a = r100;
        this.f421062b = r101;
    }
}
