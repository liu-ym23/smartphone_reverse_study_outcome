package com.bytedance.ee.bear.bitable.itemview.cell.other;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u0011\u0010\u0015\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/other/EmptyCellData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "icon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setIcon", "(Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "text", "getText", "setText", "showEmpty", "", "isDashLine", "()Z", "isEmptyIcon", "isTextPlaceholder", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyCellData implements NonProguard {
    private Icon icon;
    private String text;
    private String type;

    public final boolean isDashLine() {
        return Intrinsics.areEqual(this.type, "dashLine");
    }

    public final boolean isEmptyIcon() {
        return Intrinsics.areEqual(this.type, "emptyRoundDashButton");
    }

    public final boolean isTextPlaceholder() {
        return Intrinsics.areEqual(this.type, GXTemplateKey.GAIAX_PLACEHOLDER);
    }

    public EmptyCellData() {
        this.type = "none";
    }

    public final boolean showEmpty() {
        if (isDashLine() == false) goto L5;
    L10:
        return true;
    L5:
        if (isEmptyIcon() == true) goto L10;
        if (isTextPlaceholder() == true) goto L10;
        return false;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public final void setIcon(Icon r100) {
        this.icon = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }
}
