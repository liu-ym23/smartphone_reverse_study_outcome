package com.bytedance.ee.bear.bitable.card.viewmodel.cell;

import com.alipay.sdk.m.x.d;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/IButtonEditorCellValue;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "color", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ButtonColorBean;", "getColor", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ButtonColorBean;", "setColor", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ButtonColorBean;)V", "status", "getStatus", "setStatus", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/BitableCardButtonLoadingStatus;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IButtonEditorCellValue implements NonProguard {
    private ButtonColorBean color;
    private String status;
    private String title;

    public IButtonEditorCellValue() {
    }

    public final BitableCardButtonLoadingStatus getStatus() {
        String r100 = this.status;
        if (r100 == null) goto L24;
        switch(r100.hashCode()) {
            case 3089282: goto L20;
            case 270940796: goto L16;
            case 336650556: goto L12;
            case 1544803905: goto L8;
            default: goto L24;
        };
    L8:
        if (r100.equals("default") == false) goto L24;
        return BitableCardButtonLoadingStatus.Default;
    L12:
        if (r100.equals("loading") == false) goto L24;
        return BitableCardButtonLoadingStatus.Loading;
    L16:
        if (r100.equals("disabled") == false) goto L24;
        return BitableCardButtonLoadingStatus.Disabled;
    L20:
        if (r100.equals("done") == false) goto L24;
        return BitableCardButtonLoadingStatus.Done;
    L24:
        return BitableCardButtonLoadingStatus.Default;
    }

    public final ButtonColorBean getColor() {
        return this.color;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: getStatus, reason: collision with other method in class */
    public final String m8308getStatus() {
        return this.status;
    }

    public final void setColor(ButtonColorBean r100) {
        this.color = r100;
    }

    public final void setStatus(String r100) {
        this.status = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
