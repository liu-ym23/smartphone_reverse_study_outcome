package com.larus.photopicker.impl.ui;

import android.content.Context;
import androidx.core.view.WindowInsetsCompat;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PhotoPickerFragment$setupInjectInputSafeBottom$1 extends FunctionReferenceImpl implements Function3<Context, WindowInsetsCompat, Integer, Integer> {
    public PhotoPickerFragment$setupInjectInputSafeBottom$1(Object r100) {
        super(3, r100, ObricChatUIDelegate.class, "resolveGestureSafeBottom", "resolveGestureSafeBottom(Landroid/content/Context;Landroidx/core/view/WindowInsetsCompat;I)I", 0);
    }

    public final Integer invoke(Context r100, WindowInsetsCompat r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return Integer.valueOf(((ObricChatUIDelegate) this.receiver).j(r100, r101, r102));
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Integer invoke(Context r100, WindowInsetsCompat r101, Integer r102) {
        return invoke(r100, r101, r102.intValue());
    }
}
