package com.ss.android.lark.coremd.nonimbiz.calendar;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.base.parse.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremd/nonimbiz/calendar/CalendarContextExtend;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/coremd/nonimbiz/calendar/CalendarContextExtend;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CalendarTextMarkdownPlugin$configureVisitor$1$showAbbrev$1 extends Lambda implements Function1<CalendarContextExtend, Boolean> {
    final /* synthetic */ r<a> $this_on;

    public CalendarTextMarkdownPlugin$configureVisitor$1$showAbbrev$1(r<a> r100) {
        this.$this_on = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(CalendarContextExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withExtend");
        r<a> r101 = this.$this_on;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return Boolean.valueOf(((Boolean) r100.f419923c.getValue(r101, CalendarContextExtend.f419922d[0])).booleanValue());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CalendarContextExtend r100) {
        return invoke2(r100);
    }
}
