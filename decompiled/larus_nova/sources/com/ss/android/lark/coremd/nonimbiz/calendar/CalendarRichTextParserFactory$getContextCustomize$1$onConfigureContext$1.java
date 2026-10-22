package com.ss.android.lark.coremd.nonimbiz.calendar;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.base.parse.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremd/nonimbiz/calendar/CalendarContextExtend;", "it", "Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CalendarRichTextParserFactory$getContextCustomize$1$onConfigureContext$1 extends Lambda implements Function2<CalendarContextExtend, b, Unit> {
    final /* synthetic */ f5b.b $message;

    public CalendarRichTextParserFactory$getContextCustomize$1$onConfigureContext$1(f5b.b r100) {
        this.$message = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CalendarContextExtend r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$markdownContext");
        Intrinsics.checkNotNullParameter(r101, "it");
        if (this.$message.getMessageFoldDetail() == null) goto L5;
        boolean r102 = true;
    L6:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r100.f419923c.setValue(r101, CalendarContextExtend.f419922d[0], Boolean.valueOf(r102));
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(CalendarContextExtend r100, b r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
