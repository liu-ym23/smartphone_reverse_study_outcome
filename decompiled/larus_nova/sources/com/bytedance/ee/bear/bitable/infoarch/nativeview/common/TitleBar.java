package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import com.alipay.sdk.m.x.d;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/TitleBar;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "leftIcon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getLeftIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setLeftIcon", "(Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "rightIcon", "getRightIcon", "setRightIcon", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleBar implements NonProguard {
    private Icon leftIcon;
    private Icon rightIcon;
    private String title;

    public TitleBar() {
    }

    public final Icon getLeftIcon() {
        return this.leftIcon;
    }

    public final Icon getRightIcon() {
        return this.rightIcon;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setLeftIcon(Icon r100) {
        this.leftIcon = r100;
    }

    public final void setRightIcon(Icon r100) {
        this.rightIcon = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
