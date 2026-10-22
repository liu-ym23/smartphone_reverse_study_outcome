package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/BrandLabel;", "Ljava/io/Serializable;", "()V", "labelSchema", "", "getLabelSchema", "()Ljava/lang/String;", "setLabelSchema", "(Ljava/lang/String;)V", "labelText", "getLabelText", "setLabelText", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class BrandLabel implements Serializable {

    @SerializedName("label_schema")
    private String labelSchema;

    @SerializedName("label_text")
    private String labelText;

    public BrandLabel() {
    }

    public final String getLabelSchema() {
        return this.labelSchema;
    }

    public final String getLabelText() {
        return this.labelText;
    }

    public final void setLabelSchema(String r100) {
        this.labelSchema = r100;
    }

    public final void setLabelText(String r100) {
        this.labelText = r100;
    }
}
