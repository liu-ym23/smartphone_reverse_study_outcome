package com.bytedance.ee.bear.templates.preview.announce;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/TemplateData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "visible", "", "getVisible", "()Ljava/lang/Boolean;", "setVisible", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "needAnimation", "getNeedAnimation", "setNeedAnimation", "x", "", "getX", "()Ljava/lang/Float;", "setX", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "y", "getY", "setY", "position", "", "getPosition", "()I", "setPosition", "(I)V", "baseRev", "getBaseRev", "setBaseRev", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateData implements NonProguard {
    private int baseRev;
    private Boolean needAnimation;
    private int position;
    private Boolean visible;
    private Float x;
    private Float y;

    public TemplateData() {
        Boolean r0 = Boolean.FALSE;
        this.visible = r0;
        this.needAnimation = r0;
    }

    public final int getBaseRev() {
        return this.baseRev;
    }

    public final Boolean getNeedAnimation() {
        return this.needAnimation;
    }

    public final int getPosition() {
        return this.position;
    }

    public final Boolean getVisible() {
        return this.visible;
    }

    public final Float getX() {
        return this.x;
    }

    public final Float getY() {
        return this.y;
    }

    public final void setBaseRev(int r1) {
        this.baseRev = r1;
    }

    public final void setNeedAnimation(Boolean r1) {
        this.needAnimation = r1;
    }

    public final void setPosition(int r1) {
        this.position = r1;
    }

    public final void setVisible(Boolean r1) {
        this.visible = r1;
    }

    public final void setX(Float r1) {
        this.x = r1;
    }

    public final void setY(Float r1) {
        this.y = r1;
    }
}
