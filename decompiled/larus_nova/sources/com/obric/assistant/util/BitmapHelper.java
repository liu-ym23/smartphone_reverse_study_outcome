package com.obric.assistant.util;

import android.content.Context;
import android.graphics.Bitmap;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes33.dex */
public final class BitmapHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f393572a = 0;

    static {
    }

    public static Object a(Context r100, Bitmap r101, String r102, Continuation r103) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelper$saveBitMapToFile$2(r100, r102, r101, null), r103);
    }
}
