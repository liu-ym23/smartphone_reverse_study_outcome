package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatResourceCache$getDrawable$1 extends Lambda implements Function1<Integer, Drawable> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $resId;

    public ChatResourceCache$getDrawable$1(Context r100, int r101) {
        this.$context = r100;
        this.$resId = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Drawable invoke(Integer r100) {
        return invoke(r100.intValue());
    }

    public final Drawable invoke(int r100) {
        return this.$context.getDrawable(this.$resId);
    }
}
