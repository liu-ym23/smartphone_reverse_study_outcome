package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image;

import android.graphics.drawable.Drawable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ImageCellPlaceHolderCal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2b.a f412202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f412203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f412204c;

    public ImageCellPlaceHolderCal(m2b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        this.f412202a = r100;
        this.f412204c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ImageCellPlaceHolderCal$mIsImageAsyncLoadEnabled$2.INSTANCE);
    }
}
