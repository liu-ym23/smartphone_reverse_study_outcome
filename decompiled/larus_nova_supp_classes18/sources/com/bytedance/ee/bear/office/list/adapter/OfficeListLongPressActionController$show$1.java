package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult$NotHandled;", "<unused var>", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressMenuAction;", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressMenuContext;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeListLongPressActionController$show$1 extends Lambda implements Function2<OfficeLongPressMenuAction, a0, OfficeSpaceActionResult.NotHandled> {
    public static final OfficeListLongPressActionController$show$1 INSTANCE = null;

    static {
        INSTANCE = new OfficeListLongPressActionController$show$1();
    }

    public OfficeListLongPressActionController$show$1() {
        super(2);
    }

    public final OfficeSpaceActionResult.NotHandled invoke(OfficeLongPressMenuAction r2, a0 r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((OfficeLongPressMenuAction) r1, (a0) r2);
    }
}
