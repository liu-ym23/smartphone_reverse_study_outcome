package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/LinkConfig;", "", "linkColor", "", "(Ljava/lang/String;)V", "getLinkColor", "()Ljava/lang/String;", "setLinkColor", "component1", "copy", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/LinkConfig;", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LinkConfig {
    private String linkColor;

    public static /* synthetic */ LinkConfig copy$default(LinkConfig r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.linkColor;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.linkColor;
    }

    public final LinkConfig copy(String r2) {
        return new LinkConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof LinkConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.linkColor, ((LinkConfig) r4).linkColor) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.linkColor;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "LinkConfig(linkColor=" + this.linkColor + ')';
    }

    public final lark_markdown_render.proto.LinkConfig into() {
        return new lark_markdown_render.proto.LinkConfig(this.linkColor);
    }

    public final String getLinkColor() {
        return this.linkColor;
    }

    public LinkConfig(String r1) {
        this.linkColor = r1;
    }

    public final void setLinkColor(String r1) {
        this.linkColor = r1;
    }
}
