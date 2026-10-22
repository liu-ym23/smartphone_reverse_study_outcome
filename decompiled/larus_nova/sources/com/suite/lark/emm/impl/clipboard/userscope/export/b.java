package com.suite.lark.emm.impl.clipboard.userscope.export;

import doc.d;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Singleton
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f460445a;

    @Override // com.suite.lark.emm.impl.clipboard.userscope.export.a
    public final boc.b getClipboardManager() {
        return new SCClipboardManagerUserScopeWrapper(this.f460445a);
    }

    @Inject
    public b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "clipboardService");
        this.f460445a = r100;
    }
}
