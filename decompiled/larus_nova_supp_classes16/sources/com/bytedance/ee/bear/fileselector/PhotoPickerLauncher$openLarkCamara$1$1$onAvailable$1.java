package com.bytedance.ee.bear.fileselector;

import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.ss.android.lark.widget.photopicker.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/widget/photopicker/PickerParams$Builder;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class PhotoPickerLauncher$openLarkCamara$1$1$onAvailable$1 extends Lambda implements Function1<s.a, Unit> {
    final /* synthetic */ FileSelectConfig $fileSelectConfig;

    public PhotoPickerLauncher$openLarkCamara$1$1$onAvailable$1(FileSelectConfig r1) {
        this.$fileSelectConfig = r1;
        super(1);
    }

    public final void invoke(s.a r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$build");
        r5.a = 1;
        FileSelectConfig r1 = this.$fileSelectConfig;
        int r2 = 0;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L10;
    L12:
        if (r1 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L19;
        r2 = 1;
    L19:
        r5.b = r2;
        r5.k = true;
        r5.x = true;
        return;
    L14:
        if (r1.showTakeVideo != true) goto L16;
        r4 = true;
        goto L17
    L10:
        if (r1.showTakePhoto == false) goto L12;
        r2 = 2;
        goto L19
    L5:
        if (r1.showTakeVideo != true) goto L7;
        r3 = true;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((s.a) r1);
        return Unit.INSTANCE;
    }
}
