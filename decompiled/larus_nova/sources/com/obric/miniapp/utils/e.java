package com.obric.miniapp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f398468a = 0;

    static {
    }

    public static Drawable a(Context r100, Drawable r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L9;
        return null;
    L9:
        Bitmap r104 = Bitmap.createBitmap(r102, r103, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L8
        Canvas r105 = new Canvas(r104);     // Catch: Exception -> L8
        r101.setBounds(0, 0, r102, r103);     // Catch: Exception -> L8
        r101.draw(r105);     // Catch: Exception -> L8
        RenderScript r106 = RenderScript.create(r100);     // Catch: Exception -> L8
        Allocation r107 = Allocation.createFromBitmap(r106, r104);     // Catch: Exception -> L8
        Allocation r108 = Allocation.createTyped(r106, r107.getType());     // Catch: Exception -> L8
        ScriptIntrinsicBlur r109 = ScriptIntrinsicBlur.create(r106, Element.U8_4(r106));     // Catch: Exception -> L8
        r109.setRadius(4.0f);     // Catch: Exception -> L8
        r109.setInput(r107);     // Catch: Exception -> L8
        r109.forEach(r108);     // Catch: Exception -> L8
        r108.copyTo(r104);     // Catch: Exception -> L8
        BitmapDrawable r110 = new BitmapDrawable(r100.getResources(), r104);     // Catch: Exception -> L8
        r107.destroy();     // Catch: Exception -> L8
        r108.destroy();     // Catch: Exception -> L8
        r109.destroy();     // Catch: Exception -> L8
        r106.destroy();     // Catch: Exception -> L8
        return r110;
    L11:
        return null;
    }
}
