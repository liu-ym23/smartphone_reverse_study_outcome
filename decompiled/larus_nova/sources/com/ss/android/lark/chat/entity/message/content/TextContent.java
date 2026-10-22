package com.ss.android.lark.chat.entity.message.content;

import com.alibaba.fastjson.annotation.JSONType;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.chat.export.entity.message.Content;
import kotlin.Metadata;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/TextContent;", "Lcom/ss/android/lark/chat/entity/message/content/BaseTextContent;", "<init>", "()V", "equals", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "hashCode", "", "isContentSame", "diffable", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "TextContent")
public final class TextContent extends BaseTextContent<TextContent> {
    public int hashCode() {
        return super.hashCode();
    }

    public TextContent() {
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextContent) == true) goto L8;
    L10:
        return false;
    L8:
        if (super.isContentSame((TextContent) r100) == false) goto L10;
        return true;
    }

    @Override // com.ss.android.lark.chat.entity.message.content.BaseTextContent, com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r100) {
        if (super.isContentSame(r100) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r100 instanceof TextContent) == false) goto L9;
        if (y28.a.c(getDocResult(), ((TextContent) r100).getDocResult()) == false) goto L9;
        return true;
    }

    @Override // com.ss.android.lark.chat.entity.message.content.BaseTextContent, com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Content) r100);
    }
}
