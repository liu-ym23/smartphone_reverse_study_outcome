package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/SearchBar;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "hint", "", "getHint", "()Ljava/lang/String;", "setHint", "(Ljava/lang/String;)V", "action", "getAction", "setAction", "rightIcon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getRightIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setRightIcon", "(Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchBar implements NonProguard {
    private String action;
    private String hint;
    private Icon rightIcon;

    public SearchBar() {
    }

    public final String getAction() {
        return this.action;
    }

    public final String getHint() {
        return this.hint;
    }

    public final Icon getRightIcon() {
        return this.rightIcon;
    }

    public final void setAction(String r100) {
        this.action = r100;
    }

    public final void setHint(String r100) {
        this.hint = r100;
    }

    public final void setRightIcon(Icon r100) {
        this.rightIcon = r100;
    }
}
