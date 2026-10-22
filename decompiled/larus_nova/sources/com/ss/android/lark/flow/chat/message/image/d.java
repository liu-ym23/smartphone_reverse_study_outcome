package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Function1<Continuation<? super Bitmap>, Object>, SuspendFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f422580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhotoItem f422581b;

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Bitmap> r100) {
        f r101 = f.f422584a;
        Context r102 = this.f422580a;
        PhotoItem r103 = this.f422581b;
        CoroutineDispatcher r104 = Dispatchers.getIO();
        FlowImageLoaderUtils$loadCover$2 r105 = new FlowImageLoaderUtils$loadCover$2(r103, r102, null);
        return BuildersKt.withContext(r104, r105, r100);
    }

    public d(Context r100, PhotoItem r101) {
        this.f422580a = r100;
        this.f422581b = r101;
    }
}
