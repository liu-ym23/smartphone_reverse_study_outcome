package com.bytedance.ee.bear.bitable.uikit.search;

import com.bytedance.ee.bear.bitable.uikit.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/search/SearchAction;", "Lcom/bytedance/ee/bear/bitable/uikit/Action;", "id", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchAction extends Action {
    private String text;

    @Override // com.bytedance.ee.bear.bitable.uikit.Action
    public String toString() {
        return "SearchAction(text='" + this.text + "') " + super.toString();
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.text = r2;
    }

    public SearchAction(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        super(r2, "TableSearch");
        this.text = r3;
    }
}
