package com.bytedance.ee.bear.bitable.common.model.field;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/model/field/OriginStageOptionItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "color", "", "getColor", "()I", "setColor", "(I)V", "capsuleColor", "getCapsuleColor", "setCapsuleColor", "type", "getType", "setType", "status", "getStatus", "setStatus", "canConvert", "", "getCanConvert", "()Ljava/lang/Boolean;", "setCanConvert", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OriginStageOptionItem implements NonProguard {
    private Boolean canConvert;
    private String capsuleColor;
    private int color;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f209863id;
    private String name;
    private String status;
    private String type;

    public OriginStageOptionItem() {
        this.canConvert = Boolean.FALSE;
    }

    public final Boolean getCanConvert() {
        return this.canConvert;
    }

    public final String getCapsuleColor() {
        return this.capsuleColor;
    }

    public final int getColor() {
        return this.color;
    }

    public final String getId() {
        return this.f209863id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getType() {
        return this.type;
    }

    public final void setCanConvert(Boolean r100) {
        this.canConvert = r100;
    }

    public final void setCapsuleColor(String r100) {
        this.capsuleColor = r100;
    }

    public final void setColor(int r100) {
        this.color = r100;
    }

    public final void setId(String r100) {
        this.f209863id = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setStatus(String r100) {
        this.status = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
