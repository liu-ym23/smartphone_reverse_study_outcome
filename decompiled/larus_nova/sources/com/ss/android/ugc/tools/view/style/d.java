package com.ss.android.ugc.tools.view.style;

import com.ss.android.ugc.aweme.shortvideo.sticker.widget.tablayout.TabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class d implements TabLayout.OnTabSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StyleTabLayout f454979a;

    public d(StyleTabLayout r100) {
        this.f454979a = r100;
    }

    @Override // com.ss.android.ugc.aweme.shortvideo.sticker.widget.tablayout.TabLayout.OnTabSelectedListener
    public final void a(TabLayout.Tab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        TabLayout.OnTabSelectedListener r101 = this.f454979a.f454969J;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r101.a(r100);
        return;
    }

    @Override // com.ss.android.ugc.aweme.shortvideo.sticker.widget.tablayout.TabLayout.OnTabSelectedListener
    public final void b(TabLayout.Tab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        TabLayout.OnTabSelectedListener r101 = this.f454979a.f454969J;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r101.b(r100);
        return;
    }

    @Override // com.ss.android.ugc.aweme.shortvideo.sticker.widget.tablayout.TabLayout.OnTabSelectedListener
    public final void c(TabLayout.Tab r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        TabLayout.OnTabSelectedListener r102 = this.f454979a.f454969J;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNull(r102);
        r102.c(r100, r101);
        return;
    }
}
