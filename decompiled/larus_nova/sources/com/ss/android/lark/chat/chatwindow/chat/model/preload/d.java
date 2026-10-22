package com.ss.android.lark.chat.chatwindow.chat.model.preload;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f413401a = null;

    public static final class a {
    }

    public static final class b implements Function1<f5b.b, f5b.b> {
        public b() {
        }

        @Override // kotlin.jvm.functions.Function1
        public final f5b.b invoke(f5b.b r100) {
            f5b.b r101 = r100;
            if (r101 != null) goto L5;
        L7:
            return r101;
        L5:
            if (r101.getMessage().getType() != Message.Type.STICKER) goto L7;
            Content r102 = r101.getMessage().getContent();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.StickerContent");
            ((StickerContent) r102).setAdded(true);
            goto L7
        }
    }

    static {
        f413401a = new ConcurrentHashMap();
    }
}
