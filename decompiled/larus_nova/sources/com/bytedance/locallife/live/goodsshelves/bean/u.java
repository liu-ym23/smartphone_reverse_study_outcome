package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/u;", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "titleImage", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "d", "()Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "summaryText", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "c", "()Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "", "schema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "previewImage", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("preview_image")
    private final List<t> previewImage;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("summary_text")
    private final x summaryText;

    @SerializedName("title_image")
    private final t titleImage;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.titleImage, r101.titleImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.summaryText, r101.summaryText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.previewImage, r101.previewImage) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        t r100 = this.titleImage;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        x r104 = this.summaryText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.schema;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<t> r110 = this.previewImage;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LiveLifeBFFCardPreviewModuleInfo(titleImage=" + this.titleImage + ", summaryText=" + this.summaryText + ", schema=" + this.schema + ", previewImage=" + this.previewImage + ')';
    }

    public final List<t> a() {
        return this.previewImage;
    }

    public final String b() {
        return this.schema;
    }

    public final x c() {
        return this.summaryText;
    }

    public final t d() {
        return this.titleImage;
    }
}
