package com.bytedance.ee.bear.bitable.itemview.record.list;

import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001a\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001d¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/HiddenInfoData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "showDesc", "", "getShowDesc", "()Z", "setShowDesc", "(Z)V", "isFold", "setFold", "count", "getCount", "()I", "setCount", "(I)V", "clickAction", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getClickAction", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setClickAction", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "clickDescAction", "getClickDescAction", "setClickDescAction", "paddingHorizontal", "getPaddingHorizontal", "setPaddingHorizontal", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiddenInfoData implements NonProguard {
    private ActionPayload clickAction;
    private ActionPayload clickDescAction;
    private int count;
    private boolean isFold;
    private String name;
    private int paddingHorizontal;
    private boolean showDesc;
    private Integer type;

    public HiddenInfoData() {
    }

    public final ActionPayload getClickAction() {
        return this.clickAction;
    }

    public final ActionPayload getClickDescAction() {
        return this.clickDescAction;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPaddingHorizontal() {
        return this.paddingHorizontal;
    }

    public final boolean getShowDesc() {
        return this.showDesc;
    }

    public final Integer getType() {
        return this.type;
    }

    public final boolean isFold() {
        return this.isFold;
    }

    public final void setClickAction(ActionPayload r100) {
        this.clickAction = r100;
    }

    public final void setClickDescAction(ActionPayload r100) {
        this.clickDescAction = r100;
    }

    public final void setCount(int r100) {
        this.count = r100;
    }

    public final void setFold(boolean r100) {
        this.isFold = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setPaddingHorizontal(int r100) {
        this.paddingHorizontal = r100;
    }

    public final void setShowDesc(boolean r100) {
        this.showDesc = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }
}
