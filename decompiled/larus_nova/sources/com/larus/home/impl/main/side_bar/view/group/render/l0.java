package com.larus.home.impl.main.side_bar.view.group.render;

import com.larus.home.impl.main.side_bar.feed.SideBarFeedCardType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l0 implements eb9.w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SideBarFeedCardType f345680c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.datasource.lark.h f345681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SideBarFeedCardType f345682b;

    public static final class a {
    }

    static {
        f345680c = SideBarFeedCardType.HUMAN_FEED;
    }

    @Override // eb9.w
    public final eb9.x b() {
        return new m0(this.f345681a);
    }

    @Override // eb9.w
    public final eb9.v a() {
        return eb9.a.f471852a;
    }

    @Override // eb9.w
    public final eb9.p c() {
        return c0.f345613a;
    }

    @Override // eb9.w
    public final SideBarFeedCardType getCardType() {
        return this.f345682b;
    }

    public l0(com.larus.home.impl.main.side_bar.view.group.datasource.lark.h r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f345681a = r100;
        this.f345682b = f345680c;
    }
}
