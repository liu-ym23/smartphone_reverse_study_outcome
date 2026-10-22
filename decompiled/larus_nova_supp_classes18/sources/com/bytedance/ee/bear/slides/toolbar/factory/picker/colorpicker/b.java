package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorData;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorListItem;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorSelectedItem;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorValueItem;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ ColorPickerFragment a;

    public b(ColorPickerFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        ItemV2 r9 = (ItemV2) r8;
        ColorPickerFragment r0 = this.a;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L78
        String r10 = r9.getValue();     // Catch: Throwable -> L78
        Unit r2 = null;
        if (r10 == null) goto L76;
        ColorData r11 = (ColorData) ((Gson) r0.j.getValue()).fromJson(r10, ColorData.class);     // Catch: Throwable -> L78
        if (r0.e != ColorPickerStyle.FONT_COLOR) goto L19;
        List<ColorSelectedItem> r3 = r11.getValue();     // Catch: Throwable -> L78
        if (r3 == null) goto L31;
        Iterator<T> r4 = r3.iterator();     // Catch: Throwable -> L78
    L11:
        if (r4.hasNext() == false) goto L15;
        T r5 = r4.next();     // Catch: Throwable -> L78
        if (Intrinsics.areEqual(((ColorSelectedItem) r5).getKey(), "textColor") == false) goto L11;
    L16:
        ColorSelectedItem r6 = r5;     // Catch: Throwable -> L78
        if (r6 == null) goto L31;
        ColorValueItem r7 = r6.getValue();     // Catch: Throwable -> L78
    L33:
        if (r0.e != ColorPickerStyle.FONT_COLOR) goto L44;
        List<ColorListItem> r12 = r11.getChildren();     // Catch: Throwable -> L78
        if (r12 == null) goto L54;
        Iterator<T> r13 = r12.iterator();     // Catch: Throwable -> L78
    L38:
        if (r13.hasNext() == false) goto L42;
        T r14 = r13.next();     // Catch: Throwable -> L78
        if (Intrinsics.areEqual(((ColorListItem) r14).getId(), "usedTextColor") == false) goto L38;
    L43:
        ColorListItem r15 = r14;     // Catch: Throwable -> L78
    L56:
        if (r0.e != ColorPickerStyle.FONT_COLOR) goto L66;
        List<ColorListItem> r16 = r11.getChildren();     // Catch: Throwable -> L78
        if (r16 == null) goto L75;
        Iterator<T> r17 = r16.iterator();     // Catch: Throwable -> L78
    L61:
        if (r17.hasNext() == false) goto L65;
        T r18 = r17.next();     // Catch: Throwable -> L78
        if (Intrinsics.areEqual(((ColorListItem) r18).getId(), "basicTextColor") == false) goto L61;
        r2 = r18;
    L65:
        r2 = (ColorListItem) r2;     // Catch: Throwable -> L78
    L75:
        ColorPickerFragment.U90(r0, r7, r15, r2);     // Catch: Throwable -> L78
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L78
        goto L76
    L66:
        List<ColorListItem> r19 = r11.getChildren();     // Catch: Throwable -> L78
        if (r19 == null) goto L75;
        Iterator<T> r20 = r19.iterator();     // Catch: Throwable -> L78
    L70:
        if (r20.hasNext() == false) goto L74;
        T r21 = r20.next();     // Catch: Throwable -> L78
        if (Intrinsics.areEqual(((ColorListItem) r21).getId(), "basicTextBackground") == false) goto L70;
        r2 = r21;
    L74:
        r2 = (ColorListItem) r2;     // Catch: Throwable -> L78
        goto L75
    L42:
        r14 = (T) null;
    L54:
        r15 = null;
        goto L56
    L44:
        List<ColorListItem> r22 = r11.getChildren();     // Catch: Throwable -> L78
        if (r22 == null) goto L54;
        Iterator<T> r23 = r22.iterator();     // Catch: Throwable -> L78
    L48:
        if (r23.hasNext() == false) goto L52;
        T r24 = r23.next();     // Catch: Throwable -> L78
        if (Intrinsics.areEqual(((ColorListItem) r24).getId(), "usedTextBackground") == false) goto L48;
    L53:
        r15 = r24;     // Catch: Throwable -> L78
        goto L56
    L52:
        r24 = (T) null;
        goto L53
    L15:
        r5 = (T) null;
    L31:
        r7 = null;
        goto L33
    L19:
        List<ColorSelectedItem> r25 = r11.getValue();     // Catch: Throwable -> L78
        if (r25 == null) goto L31;
        Iterator<T> r26 = r25.iterator();     // Catch: Throwable -> L78
    L23:
        if (r26.hasNext() == false) goto L27;
        T r27 = r26.next();     // Catch: Throwable -> L78
        if (Intrinsics.areEqual(((ColorSelectedItem) r27).getKey(), "textBackground") == false) goto L23;
    L28:
        ColorSelectedItem r28 = r27;     // Catch: Throwable -> L78
        if (r28 == null) goto L31;
        r7 = r28.getValue();     // Catch: Throwable -> L78
        goto L33
    L27:
        r27 = (T) null;
    L76:
        Object r29 = Result.constructor-impl(r2);     // Catch: Throwable -> L78
    L80:
        Throwable r30 = Result.exceptionOrNull-impl(r29);
        if (r30 == null) goto L104;
        tt5.a.h("ColorPickerFragment", "ColorPickerFragment onToolbarItemClick error " + r30);
        return;
    L104:
        return;
    L78:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L80
    }
}
