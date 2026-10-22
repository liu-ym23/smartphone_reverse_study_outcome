package com.larus.office.card.doc;

import android.view.View;
import com.larus.office.card.databinding.LarusLayoutDocumentCollapseBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class DocumentCard$collapseViewStub$2$1 extends FunctionReferenceImpl implements Function1<View, LarusLayoutDocumentCollapseBinding> {
    public static final DocumentCard$collapseViewStub$2$1 INSTANCE = null;

    static {
        INSTANCE = new DocumentCard$collapseViewStub$2$1();
    }

    public DocumentCard$collapseViewStub$2$1() {
        super(1, LarusLayoutDocumentCollapseBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/office/card/databinding/LarusLayoutDocumentCollapseBinding;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LarusLayoutDocumentCollapseBinding invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return LarusLayoutDocumentCollapseBinding.a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LarusLayoutDocumentCollapseBinding invoke(View r100) {
        return invoke2(r100);
    }
}
