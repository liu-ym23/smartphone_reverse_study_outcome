package com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table;

import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.viewstub.e;
import com.ss.android.lark.widget.light.viewstub.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/light/viewstub/SpanViewCoordinator;", "it", "Landroid/content/Context;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class PreviewTableUtils$renderRichText$1 extends Lambda implements Function1<Context, f> {
    final /* synthetic */ Context $context;

    public PreviewTableUtils$renderRichText$1(Context r100) {
        this.$context = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final f invoke2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        f.a r101 = f.f446339a;
        Context r102 = this.$context;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new e(r102);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ f invoke(Context r100) {
        return invoke2(r100);
    }
}
