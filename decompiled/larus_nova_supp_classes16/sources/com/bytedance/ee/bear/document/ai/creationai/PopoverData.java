package com.bytedance.ee.bear.document.ai.creationai;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/creationai/PopoverData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "menuId", "getMenuId", "setMenuId", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopoverData implements NonProguard {
    private String menuId;
    private boolean show;
    private String text;

    public String toString() {
        return "PopoverData(show=" + this.show + ", text='" + this.text + "', menuId='" + this.menuId + "')";
    }

    public PopoverData() {
        this.text = "";
        this.menuId = "";
    }

    public final String getMenuId() {
        return this.menuId;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final String getText() {
        return this.text;
    }

    public final void setMenuId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.menuId = r2;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.text = r2;
    }
}
