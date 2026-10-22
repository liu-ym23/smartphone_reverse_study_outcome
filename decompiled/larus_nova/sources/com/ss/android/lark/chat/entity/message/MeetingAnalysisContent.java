package com.ss.android.lark.chat.entity.message;

import com.ss.android.lark.widget.richtext.RichText;
import java.io.Serializable;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0000H\u0016J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MeetingAnalysisContent;", "Lcom/larksuite/framework/utils/diff/Diffable;", "Ljava/io/Serializable;", "content", "", "jumpUrl", "buttons", "Ljava/util/LinkedList;", "Lcom/ss/android/lark/chat/entity/message/Button;", "richText", "Lcom/ss/android/lark/widget/richtext/RichText;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Lcom/ss/android/lark/widget/richtext/RichText;)V", "getContent", "()Ljava/lang/String;", "getJumpUrl", "getButtons", "()Ljava/util/LinkedList;", "getRichText", "()Lcom/ss/android/lark/widget/richtext/RichText;", "isItemSame", "", "diffable", "isContentSame", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MeetingAnalysisContent implements b<MeetingAnalysisContent>, Serializable {
    private final LinkedList<Button> buttons;
    private final String content;
    private final String jumpUrl;
    private final RichText richText;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MeetingAnalysisContent copy$default(MeetingAnalysisContent r100, String r101, String r102, LinkedList r103, RichText r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.content;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.jumpUrl;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.buttons;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.richText;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.content;
    }

    public final String component2() {
        return this.jumpUrl;
    }

    public final LinkedList<Button> component3() {
        return this.buttons;
    }

    public final RichText component4() {
        return this.richText;
    }

    public final MeetingAnalysisContent copy(String r100, String r101, LinkedList<Button> r102, RichText r103) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "jumpUrl");
        return new MeetingAnalysisContent(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MeetingAnalysisContent) == true) goto L8;
        return false;
    L8:
        MeetingAnalysisContent r101 = (MeetingAnalysisContent) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.buttons, r101.buttons) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.richText, r101.richText) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.content.hashCode() * 31) + this.jumpUrl.hashCode()) * 31;
        LinkedList<Button> r101 = this.buttons;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        RichText r105 = this.richText;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "MeetingAnalysisContent(content=" + this.content + ", jumpUrl=" + this.jumpUrl + ", buttons=" + this.buttons + ", richText=" + this.richText + ')';
    }

    public final LinkedList<Button> getButtons() {
        return this.buttons;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final RichText getRichText() {
        return this.richText;
    }

    public boolean isContentSame(MeetingAnalysisContent r100) {
        String r101 = this.content;
        if (r100 == null) goto L5;
        String r102 = r100.content;
    L7:
        if (Intrinsics.areEqual(r101, r102) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpUrl, r100.jumpUrl) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.buttons, r100.buttons) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.richText, r100.richText) == true) goto L18;
        return false;
    L18:
        return true;
    L5:
        r102 = null;
        goto L7
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((MeetingAnalysisContent) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((MeetingAnalysisContent) r100);
    }

    public boolean isItemSame(MeetingAnalysisContent r100) {
        return Intrinsics.areEqual(this, r100);
    }

    public MeetingAnalysisContent(String r100, String r101, LinkedList<Button> r102, RichText r103) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "jumpUrl");
        this.content = r100;
        this.jumpUrl = r101;
        this.buttons = r102;
        this.richText = r103;
    }
}
