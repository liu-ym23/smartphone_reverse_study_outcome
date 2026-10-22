package com.bytedance.ee.bear.fileselector;

import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.widget.photopicker.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/widget/photopicker/PickerParams$Builder;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class PhotoPickerLauncher$openLarkCamara$1$1$onAvailable$1 extends Lambda implements Function1<s.a, Unit> {
    final /* synthetic */ FileSelectConfig $fileSelectConfig;

    public PhotoPickerLauncher$openLarkCamara$1$1$onAvailable$1(FileSelectConfig r100) {
        this.$fileSelectConfig = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(s.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$build");
        r100.f447582a = 1;
        FileSelectConfig r101 = this.$fileSelectConfig;
        int r102 = 0;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
    L12:
        if (r101 != null) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L19;
        r102 = 1;
    L19:
        r100.f447583b = r102;
        r100.f447592k = true;
        r100.f447605x = true;
        return;
    L14:
        if (r101.showTakeVideo != true) goto L16;
        r104 = true;
        goto L17
    L10:
        if (r101.showTakePhoto == false) goto L12;
        r102 = 2;
        goto L19
    L5:
        if (r101.showTakeVideo != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(s.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
