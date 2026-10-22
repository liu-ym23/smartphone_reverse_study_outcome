package com.bytedance.ee.bear.clip.handlers;

import at5.j;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements UDToast.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f216699a;

    public e(j r100) {
        this.f216699a = r100;
    }

    @Override // com.larksuite.component.universe_design.toast.UDToast.b
    public final void a(com.ss.android.lark.compose.foundation.toast.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toast");
        r100.cancel();
        this.f216699a.a(Status.SUCCESS, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(WikiFolderPushPlugin.OPT, "click_retry")}));
    }
}
