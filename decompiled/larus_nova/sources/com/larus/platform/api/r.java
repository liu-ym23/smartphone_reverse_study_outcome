package com.larus.platform.api;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003JI\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006#"}, d2 = {"Lcom/larus/platform/api/FlowComposerBean;", "", "doubleDirection", "", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "value", "", "tag", "", "name", "<init>", "(ZIIFLjava/lang/String;Ljava/lang/String;)V", "getDoubleDirection", "()Z", "getMin", "()I", "getMax", "getValue", "()F", "getTag", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class r {

    @SerializedName("doubleDirection")
    private final boolean doubleDirection;

    @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX)
    private final int max;

    @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN)
    private final int min;

    @SerializedName("name")
    private final String name;

    @SerializedName("tag")
    private final String tag;

    @SerializedName("value")
    private final float value;

    public r() {
        this(false, 0, 0, 0.0f, "", "");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (this.doubleDirection == r101.doubleDirection) goto L12;
        return false;
    L12:
        if (this.min == r101.min) goto L15;
        return false;
    L15:
        if (this.max == r101.max) goto L18;
        return false;
    L18:
        if (Float.compare(this.value, r101.value) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.doubleDirection == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((((r100 * 31) + this.min) * 31) + this.max) * 31) + Float.floatToIntBits(this.value)) * 31;
        String r102 = this.tag;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.name;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowComposerBean(doubleDirection=" + this.doubleDirection + ", min=" + this.min + ", max=" + this.max + ", value=" + this.value + ", tag=" + this.tag + ", name=" + this.name + ')';
    }

    public final boolean a() {
        return this.doubleDirection;
    }

    public final int b() {
        return this.max;
    }

    public final int c() {
        return this.min;
    }

    public final String d() {
        return this.name;
    }

    public final String e() {
        return this.tag;
    }

    public final float f() {
        return this.value;
    }

    public r(boolean r100, int r101, int r102, float r103, String r104, String r105) {
        this.doubleDirection = r100;
        this.min = r101;
        this.max = r102;
        this.value = r103;
        this.tag = r104;
        this.name = r105;
    }
}
