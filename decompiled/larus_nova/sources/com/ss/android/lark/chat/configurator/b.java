package com.ss.android.lark.chat.configurator;

import com.ss.android.lark.biz.im.api.extension.scroll.ScrollEvent;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements com.ss.android.lark.biz.im.api.extension.scroll.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f414733a;

    public b(a r100) {
        this.f414733a = r100;
    }

    @Override // com.ss.android.lark.biz.im.api.extension.scroll.b
    public final void a(String r100, ScrollEvent r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
    }

    @Override // com.ss.android.lark.biz.im.api.extension.scroll.b
    public final void b(String r100, ScrollEvent r101) {
        com.ss.android.lark.biz.im.api.extension.scroll.b.a.c(r100, r101);
    }

    @Override // com.ss.android.lark.biz.im.api.extension.scroll.b
    public final void c(String r100, ScrollEvent r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        this.f414733a.c();
    }

    @Override // com.ss.android.lark.biz.im.api.extension.scroll.b
    public final void d(String r100, ScrollEvent r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        com.ss.android.lark.biz.im.api.extension.scroll.b.a.b(r100, r101);
    }

    @Override // com.ss.android.lark.biz.im.api.extension.scroll.b
    public final void e(String r100, ScrollEvent r101) {
        com.ss.android.lark.biz.im.api.extension.scroll.b.a.a(r100, r101);
    }
}
