package com.bytedance.dux.utils;

import android.widget.EditText;
import com.bytedance.dux.api.IDuxEmojiService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class EmojiEditTextHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f205842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f205843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f205844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f205845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f205846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f205847f;

    public final IDuxEmojiService a() {
        return (IDuxEmojiService) this.f205845d.getValue();
    }

    public EmojiEditTextHelper(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        this.f205842a = r100;
        this.f205843b = true;
        this.f205845d = LazyKt.lazy(EmojiEditTextHelper$emojiService$2.INSTANCE);
        this.f205846e = LazyKt.lazy(new EmojiEditTextHelper$enableParseEmojiSwitch$2(this));
        this.f205847f = LazyKt.lazy(new EmojiEditTextHelper$textWatcher$2(this));
    }
}
