package com.bytedance.ee.bear.bitable.card.model.jsmodel.common;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ColorBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "color", "getColor", "setColor", "textColor", "getTextColor", "setTextColor", "borderColor", "getBorderColor", "setBorderColor", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ColorBean implements NonProguard {
    private String borderColor;
    private String color;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f207117id;
    private String textColor;

    public ColorBean() {
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getId() {
        return this.f207117id;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final void setBorderColor(String r100) {
        this.borderColor = r100;
    }

    public final void setColor(String r100) {
        this.color = r100;
    }

    public final void setId(String r100) {
        this.f207117id = r100;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }
}
