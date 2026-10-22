package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/f;", "", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "componentId", "getComponentId", "text", "getText", "", "priority", "I", "getPriority", "()I", "duration", "getDuration", "pageType", "getPageType", "Lcom/bytedance/locallife/groupon/struct/TopGuideType;", "guideType", "Lcom/bytedance/locallife/groupon/struct/TopGuideType;", "getGuideType", "()Lcom/bytedance/locallife/groupon/struct/TopGuideType;", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("duration")
    private final int duration;

    @SerializedName("guide_type")
    private final TopGuideType guideType;

    @SerializedName("page_type")
    private final int pageType;

    @SerializedName("priority")
    private final int priority;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("text")
    private final String text;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.componentId, r101.componentId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L18;
        return false;
    L18:
        if (this.priority == r101.priority) goto L21;
        return false;
    L21:
        if (this.duration == r101.duration) goto L24;
        return false;
    L24:
        if (this.pageType == r101.pageType) goto L27;
        return false;
    L27:
        if (this.guideType == r101.guideType) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.scene.hashCode() * 31) + this.componentId.hashCode()) * 31) + this.text.hashCode()) * 31) + this.priority) * 31) + this.duration) * 31) + this.pageType) * 31;
        TopGuideType r101 = this.guideType;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DurationConfig(scene=" + this.scene + ", componentId=" + this.componentId + ", text=" + this.text + ", priority=" + this.priority + ", duration=" + this.duration + ", pageType=" + this.pageType + ", guideType=" + this.guideType + ')';
    }

    public f() {
        TopGuideType r100 = TopGuideType.GuideTypeSnackBar;
        Intrinsics.checkNotNullParameter("", "scene");
        Intrinsics.checkNotNullParameter("", "componentId");
        Intrinsics.checkNotNullParameter("", "text");
        this.scene = "";
        this.componentId = "";
        this.text = "";
        this.priority = 0;
        this.duration = 30;
        this.pageType = 1;
        this.guideType = r100;
    }
}
