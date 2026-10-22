package com.ss.android.lark.widget.codeblock.preview;

import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.span.SpanInfo;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\bH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/widget/codeblock/preview/CodeBlockV2Info;", "Lcom/ss/android/lark/widget/span/SpanInfo;", "lineContents", "", "Lcom/ss/android/lark/widget/codeblock/entity/LineContent;", "processParams", "Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams;", "languageValue", "", "wordWrap", "", "version", "<init>", "(Ljava/util/List;Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams;IZI)V", "getLineContents", "()Ljava/util/List;", "getProcessParams", "()Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams;", "getLanguageValue", "()I", "getWordWrap", "()Z", "getVersion", "equals", "other", "", "hashCode", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeBlockV2Info extends SpanInfo {
    private final int languageValue;
    private final List<LineContent> lineContents;
    private final CodeBlockV2ProcessParams processParams;
    private final int version;
    private final boolean wordWrap;

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.lineContents, this.processParams});
    }

    public final int getLanguageValue() {
        return this.languageValue;
    }

    public final List<LineContent> getLineContents() {
        return this.lineContents;
    }

    public final CodeBlockV2ProcessParams getProcessParams() {
        return this.processParams;
    }

    public final int getVersion() {
        return this.version;
    }

    public final boolean getWordWrap() {
        return this.wordWrap;
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CodeBlockV2Info) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == false) goto L15;
        CodeBlockV2Info r101 = (CodeBlockV2Info) r100;
        if (Intrinsics.areEqual(this.lineContents, r101.lineContents) == false) goto L15;
        if (Intrinsics.areEqual(this.processParams, r101.processParams) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public CodeBlockV2Info(List<LineContent> r100, CodeBlockV2ProcessParams r101, int r102, boolean r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "lineContents");
        Intrinsics.checkNotNullParameter(r101, "processParams");
        this.lineContents = r100;
        this.processParams = r101;
        this.languageValue = r102;
        this.wordWrap = r103;
        this.version = r104;
    }
}
