package com.relax.relaxframework;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/relax/relaxframework/TextEventLayoutDetail;", "", "lineCount", "", GXTemplateKey.STYLE_FONT_LINES, "Ljava/util/ArrayList;", "Lcom/relax/relaxframework/TextLineLayout;", "Lcom/bytedance/rts/foundation/RTSArray;", "(ILjava/util/ArrayList;)V", "getLineCount", "()I", "setLineCount", "(I)V", "getLines", "()Ljava/util/ArrayList;", "setLines", "(Ljava/util/ArrayList;)V", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextEventLayoutDetail {
    private int lineCount;
    private ArrayList<TextLineLayout> lines;

    public final int getLineCount() {
        return this.lineCount;
    }

    public final ArrayList<TextLineLayout> getLines() {
        return this.lines;
    }

    public final void setLineCount(int r100) {
        this.lineCount = r100;
    }

    public final void setLines(ArrayList<TextLineLayout> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lines = r100;
    }

    public TextEventLayoutDetail(int r100, ArrayList<TextLineLayout> r101) {
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.STYLE_FONT_LINES);
        this.lineCount = r100;
        this.lines = r101;
    }
}
