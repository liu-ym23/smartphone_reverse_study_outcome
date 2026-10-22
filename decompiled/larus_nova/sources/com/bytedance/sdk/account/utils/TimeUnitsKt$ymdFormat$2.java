package com.bytedance.sdk.account.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/text/SimpleDateFormat;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class TimeUnitsKt$ymdFormat$2 extends Lambda implements Function0<SimpleDateFormat> {
    public static final TimeUnitsKt$ymdFormat$2 INSTANCE = null;

    static {
        INSTANCE = new TimeUnitsKt$ymdFormat$2();
    }

    public TimeUnitsKt$ymdFormat$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SimpleDateFormat invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SimpleDateFormat invoke2() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }
}
