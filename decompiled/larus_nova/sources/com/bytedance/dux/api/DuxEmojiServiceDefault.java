package com.bytedance.dux.api;

import android.content.Context;
import android.text.Editable;
import android.widget.TextView;
import com.bytedance.dux.utils.ReplaceStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl4.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/dux/api/DuxEmojiServiceDefault;", "Lcom/bytedance/dux/api/IDuxEmojiService;", "<init>", "()V", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxEmojiServiceDefault implements IDuxEmojiService {
    @Override // com.bytedance.dux.api.IDuxEmojiService
    public final void addSystemEmojiLoadCallback(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // com.bytedance.dux.api.IDuxEmojiService
    public final boolean enableParseEmojiSwitch() {
        return false;
    }

    @Override // com.bytedance.dux.api.IDuxEmojiService
    public final Editable.Factory getEditableFactory() {
        return null;
    }

    @Override // com.bytedance.dux.api.IDuxEmojiService
    public final CharSequence process(Context r100, CharSequence r101, int r102, ReplaceStrategy r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r103, "replaceStrategy");
        return r101;
    }

    @Override // com.bytedance.dux.api.IDuxEmojiService
    public final CharSequence process(TextView r100, CharSequence r101) {
        return r101;
    }

    @Override // com.bytedance.dux.api.IDuxEmojiService
    public final void removeSystemEmojiLoadCallback(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // com.bytedance.dux.api.IDuxEmojiService
    public final boolean systemEmojiLoaded() {
        return false;
    }

    public DuxEmojiServiceDefault() {
    }
}
