package com.ss.android.lark.coremd.facade.mdeditor.plugins;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.base.parse.r;
import com.ss.android.lark.coremd.facade.mdeditor.theme.IMEditorAtThemeData;
import com.ss.android.lark.coremd.facade.mdeditor.theme.IMEditorThemeExtend;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/coremd/facade/mdeditor/theme/IMEditorAtThemeData;", "Lcom/ss/android/lark/coremd/facade/mdeditor/theme/IMEditorThemeExtend;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorAtPlugin$configureVisitor$1$theme$1 extends Lambda implements Function1<IMEditorThemeExtend, IMEditorAtThemeData> {
    final /* synthetic */ r<eab.a> $this_on;

    public IMEditorAtPlugin$configureVisitor$1$theme$1(r<eab.a> r100) {
        this.$this_on = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final IMEditorAtThemeData invoke2(IMEditorThemeExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$IMEditorThemeExtend");
        return r100.m(this.$this_on.getTheme());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ IMEditorAtThemeData invoke(IMEditorThemeExtend r100) {
        return invoke2(r100);
    }
}
