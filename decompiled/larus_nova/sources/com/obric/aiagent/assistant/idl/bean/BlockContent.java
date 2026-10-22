package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/BlockContent;", "Ljava/io/Serializable;", "textBlock", "Lcom/obric/aiagent/assistant/idl/bean/TextBlock;", "appletBlock", "Lcom/obric/aiagent/assistant/idl/bean/AppletBlock;", "<init>", "(Lcom/obric/aiagent/assistant/idl/bean/TextBlock;Lcom/obric/aiagent/assistant/idl/bean/AppletBlock;)V", "getTextBlock", "()Lcom/obric/aiagent/assistant/idl/bean/TextBlock;", "getAppletBlock", "()Lcom/obric/aiagent/assistant/idl/bean/AppletBlock;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockContent implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("applet_block")
    private final AppletBlock appletBlock;

    @SerializedName("text_block")
    private final TextBlock textBlock;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockContent() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BlockContent copy$default(BlockContent r100, TextBlock r101, AppletBlock r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.textBlock;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.appletBlock;
    L9:
        return r100.copy(r101, r102);
    }

    public final TextBlock component1() {
        return this.textBlock;
    }

    public final AppletBlock component2() {
        return this.appletBlock;
    }

    public final BlockContent copy(TextBlock r100, AppletBlock r101) {
        return new BlockContent(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BlockContent) == true) goto L8;
        return false;
    L8:
        BlockContent r101 = (BlockContent) r100;
        if (Intrinsics.areEqual(this.textBlock, r101.textBlock) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appletBlock, r101.appletBlock) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        TextBlock r100 = this.textBlock;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        AppletBlock r104 = this.appletBlock;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BlockContent(textBlock=" + this.textBlock + ", appletBlock=" + this.appletBlock + ')';
    }

    public final AppletBlock getAppletBlock() {
        return this.appletBlock;
    }

    public final TextBlock getTextBlock() {
        return this.textBlock;
    }

    public BlockContent(TextBlock r100, AppletBlock r101) {
        this.textBlock = r100;
        this.appletBlock = r101;
    }

    public /* synthetic */ BlockContent(TextBlock r100, AppletBlock r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
