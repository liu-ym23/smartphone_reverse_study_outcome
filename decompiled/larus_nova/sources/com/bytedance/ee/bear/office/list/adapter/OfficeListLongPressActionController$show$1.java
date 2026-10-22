package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult$NotHandled;", "<unused var>", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressMenuAction;", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressMenuContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeListLongPressActionController$show$1 extends Lambda implements Function2<OfficeLongPressMenuAction, a0, OfficeSpaceActionResult.NotHandled> {
    public static final OfficeListLongPressActionController$show$1 INSTANCE = null;

    static {
        INSTANCE = new OfficeListLongPressActionController$show$1();
    }

    public OfficeListLongPressActionController$show$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final OfficeSpaceActionResult.NotHandled invoke2(OfficeLongPressMenuAction r100, a0 r101) {
        Intrinsics.checkNotNullParameter(r100, "<unused var>");
        Intrinsics.checkNotNullParameter(r101, "<unused var>");
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ OfficeSpaceActionResult.NotHandled invoke(OfficeLongPressMenuAction r100, a0 r101) {
        return invoke2(r100, r101);
    }
}
