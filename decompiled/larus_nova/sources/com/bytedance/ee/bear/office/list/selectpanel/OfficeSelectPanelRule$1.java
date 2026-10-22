package com.bytedance.ee.bear.office.list.selectpanel;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/ee/bear/list/dto/Document;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/ee/bear/list/dto/Document;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeSelectPanelRule$1 extends Lambda implements Function1<Document, Boolean> {
    public static final OfficeSelectPanelRule$1 INSTANCE = null;

    static {
        INSTANCE = new OfficeSelectPanelRule$1();
    }

    public OfficeSelectPanelRule$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Document r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Boolean.FALSE;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Document r100) {
        return invoke2(r100);
    }
}
