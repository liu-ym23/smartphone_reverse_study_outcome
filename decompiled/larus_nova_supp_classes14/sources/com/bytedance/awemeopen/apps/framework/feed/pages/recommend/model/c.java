package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.card.video.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends a {
    public final com.bytedance.awemeopen.apps.framework.utils.audio.a i;
    public k54.c j;

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a
    public final com.bytedance.awemeopen.apps.framework.utils.audio.a a() {
        return this.i;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a
    public final k54.c b() {
        return this.j;
    }

    public c(View r11, ViewGroup r12, j r13, Activity r14, b r15, g54.b r16, Function0 r17) {
        Intrinsics.checkNotNullParameter(r11, "itemView");
        Intrinsics.checkNotNullParameter(r12, "viewPager");
        Intrinsics.checkNotNullParameter(r13, "vm");
        Intrinsics.checkNotNullParameter(r15, "pageOwner");
        Intrinsics.checkNotNullParameter(r16, "impression");
        Intrinsics.checkNotNullParameter(r17, "bottomMargin");
        vz3.c r8 = new vz3.c();
        r8.c = !AosExtConfig.b.Y0();
        Unit r0 = Unit.INSTANCE;
        super(r11, r12, r13, r14, r15, r16, r8, r17);
        this.i = new com.bytedance.awemeopen.apps.framework.utils.audio.a();
    }
}
