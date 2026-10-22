package com.ss.android.ugc.aweme.search.dynamic.core;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.search.dynamic.core.lifecycle.DocumentStateChangeListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/ugc/aweme/search/dynamic/core/lifecycle/DocumentStateChangeListener;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class DocumentStatusManager$setState$2 extends Lambda implements Function1<DocumentStateChangeListener, Object> {
    public static final DocumentStatusManager$setState$2 INSTANCE = null;

    static {
        INSTANCE = new DocumentStatusManager$setState$2();
    }

    public DocumentStatusManager$setState$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(DocumentStateChangeListener r100) {
        if (r100 == null) goto L4;
        r100.onHidden();
        return Unit.INSTANCE;
    L4:
        return null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(DocumentStateChangeListener r100) {
        return invoke2(r100);
    }
}
