package com.bytedance.dux.utils;

import android.widget.TextView;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements nl4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f205858b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f205859a;

    public static final class a {
    }

    static {
    }

    public b(TextView r100, EmojiTextViewHelper$emojiInputFilter$2.a r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "textView");
        this.f205859a = LazyKt.lazy(EmojiLoadCallbackImpl$emojiService$2.INSTANCE);
        new WeakReference(r100);
        if (r101 == null) goto L9;
        new WeakReference(r101);
        return;
    }
}
