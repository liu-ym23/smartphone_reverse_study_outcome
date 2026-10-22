package com.ss.android.lark.inline.ai.api.creationai;

import com.alipay.sdk.m.x.d;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/Header;", "Ljava/io/Serializable;", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "title", "Lcom/ss/android/lark/inline/ai/api/creationai/Title;", "getTitle", "()Lcom/ss/android/lark/inline/ai/api/creationai/Title;", d.f25925o, "(Lcom/ss/android/lark/inline/ai/api/creationai/Title;)V", "leftItem", "Lcom/ss/android/lark/inline/ai/api/creationai/ItemContainer;", "getLeftItem", "()Lcom/ss/android/lark/inline/ai/api/creationai/ItemContainer;", "setLeftItem", "(Lcom/ss/android/lark/inline/ai/api/creationai/ItemContainer;)V", "rightItem", "getRightItem", "setRightItem", "toString", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Header implements Serializable {
    private ItemContainer leftItem;
    private ItemContainer rightItem;
    private boolean show;
    private Title title;

    public Header() {
    }

    public String toString() {
        return "Header(show=" + this.show + ", title=" + this.title + ", leftItem=" + this.leftItem + ", rightItem=" + this.rightItem + ')';
    }

    public final ItemContainer getLeftItem() {
        return this.leftItem;
    }

    public final ItemContainer getRightItem() {
        return this.rightItem;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final Title getTitle() {
        return this.title;
    }

    public final void setLeftItem(ItemContainer r100) {
        this.leftItem = r100;
    }

    public final void setRightItem(ItemContainer r100) {
        this.rightItem = r100;
    }

    public final void setShow(boolean r100) {
        this.show = r100;
    }

    public final void setTitle(Title r100) {
        this.title = r100;
    }
}
