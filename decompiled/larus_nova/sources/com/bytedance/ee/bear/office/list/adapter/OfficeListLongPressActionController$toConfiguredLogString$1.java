package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/ee/bear/office/list/menuconfig/OfficeConfiguredLongPressMenuItem;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeListLongPressActionController$toConfiguredLogString$1 extends Lambda implements Function1<com.bytedance.ee.bear.office.list.menuconfig.a, CharSequence> {
    final /* synthetic */ OfficeListLongPressActionController this$0;

    public OfficeListLongPressActionController$toConfiguredLogString$1(OfficeListLongPressActionController r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(com.bytedance.ee.bear.office.list.menuconfig.a r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return OfficeListLongPressActionController.D(this.this$0, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(com.bytedance.ee.bear.office.list.menuconfig.a r100) {
        return invoke2(r100);
    }
}
