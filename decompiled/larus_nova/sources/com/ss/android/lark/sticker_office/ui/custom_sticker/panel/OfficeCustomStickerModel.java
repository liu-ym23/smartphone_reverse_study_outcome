package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import com.ss.android.lark.chat.entity.sticker.Sticker;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class OfficeCustomStickerModel {

    public static final class a {
    }

    static {
    }

    public OfficeCustomStickerModel() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel$deleteStickers$2$1] */
    public final Object a(final List<? extends Sticker> r100, Continuation<? super Result<Unit>> r101) {
        if ((r101 instanceof OfficeCustomStickerModel$deleteStickers$1) == false) goto L7;
        OfficeCustomStickerModel$deleteStickers$1 r102 = (OfficeCustomStickerModel$deleteStickers$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        List r107 = (List) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L20:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.label = 1;
        final kotlinx.coroutines.j r108 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r108.C();
        com.ss.android.lark.sticker.core.di.c.a().cf(r100, new OfficeCustomStickerModel$deleteStickers$2$1(r100, r108));
        r104 = r108.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L17:
        if (r104 != r105) goto L20;
        return r105;
    L7:
        r102 = new OfficeCustomStickerModel$deleteStickers$1(this, r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel$getCustomStickers$2$1] */
    public final Object b(boolean r100, Continuation<? super Result<? extends List<? extends Sticker>>> r101) {
        if ((r101 instanceof OfficeCustomStickerModel$getCustomStickers$1) == false) goto L7;
        OfficeCustomStickerModel$getCustomStickers$1 r102 = (OfficeCustomStickerModel$getCustomStickers$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        String r107 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L24:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100 == false) goto L17;
        final String r108 = "[local]";
    L18:
        r102.L$0 = r108;
        r102.Z$0 = r100;
        r102.label = 1;
        final kotlinx.coroutines.j r109 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r109.C();
        com.ss.android.lark.sticker.core.di.c.a().de(r100, new OfficeCustomStickerModel$getCustomStickers$2$1(r108, r109));
        r104 = r109.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L21:
        if (r104 != r105) goto L24;
        return r105;
    L17:
        r108 = "[server]";
    L7:
        r102 = new OfficeCustomStickerModel$getCustomStickers$1(this, r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel$uploadStickers$2$1] */
    public final Object c(List<String> r100, boolean r101, Continuation<? super Result<? extends c6c.b>> r102) {
        if ((r102 instanceof OfficeCustomStickerModel$uploadStickers$1) == false) goto L7;
        OfficeCustomStickerModel$uploadStickers$1 r103 = (OfficeCustomStickerModel$uploadStickers$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        List r108 = (List) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L20:
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.Z$0 = r101;
        r103.label = 1;
        final kotlinx.coroutines.j r109 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r103), 1);
        r109.C();
        com.ss.android.lark.sticker.core.di.c.a().Pa(r100, r101, new OfficeCustomStickerModel$uploadStickers$2$1(r109));
        r105 = r109.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L17:
        if (r105 != r106) goto L20;
        return r106;
    L7:
        r103 = new OfficeCustomStickerModel$uploadStickers$1(this, r102);
        goto L8
    }
}
