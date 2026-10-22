package sj3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001e¨\u0006!"}, d2 = {"Lsj3/e;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "bgImgSingle", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "bgImgDouble", "a", "Lsj3/n;", "title", "Lsj3/n;", "i", "()Lsj3/n;", "subTitle", "g", "subTitleDouble", "h", "icon", "e", "Lsj3/d;", "button", "Lsj3/d;", "c", "()Lsj3/d;", "", "", "logExtra", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "extra", "d", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("bg_img_double")
    private final ECUrlModel bgImgDouble;

    @SerializedName("bg_img_single")
    private final ECUrlModel bgImgSingle;

    @SerializedName("button")
    private final d button;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("log_extra")
    private final Map<String, String> logExtra;

    @SerializedName("sub_title")
    private final n subTitle;

    @SerializedName("sub_title_double")
    private final n subTitleDouble;

    @SerializedName("title")
    private final n title;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L24;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.bgImgSingle, r4.bgImgSingle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bgImgDouble, r4.bgImgDouble) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subTitle, r4.subTitle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.subTitleDouble, r4.subTitleDouble) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.button, r4.button) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.logExtra, r4.logExtra) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r0 = this.bgImgSingle;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECUrlModel r4 = this.bgImgDouble;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        n r7 = this.title;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        n r10 = this.subTitle;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        n r13 = this.subTitleDouble;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        ECUrlModel r16 = this.icon;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        d r19 = this.button;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Map<String, String> r22 = this.logExtra;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Map<String, String> r25 = this.extra;
        if (r25 == null) goto L38;
        r1 = r25.hashCode();
    L38:
        return r24 + r1;
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ShopMemberDTO(bgImgSingle=" + this.bgImgSingle + ", bgImgDouble=" + this.bgImgDouble + ", title=" + this.title + ", subTitle=" + this.subTitle + ", subTitleDouble=" + this.subTitleDouble + ", icon=" + this.icon + ", button=" + this.button + ", logExtra=" + this.logExtra + ", extra=" + this.extra + ")";
    }

    public e() {
        this.bgImgSingle = null;
        this.bgImgDouble = null;
        this.title = null;
        this.subTitle = null;
        this.subTitleDouble = null;
        this.icon = null;
        this.button = null;
        this.logExtra = null;
        this.extra = null;
    }

    public final ECUrlModel a() {
        return this.bgImgDouble;
    }

    public final ECUrlModel b() {
        return this.bgImgSingle;
    }

    public final d c() {
        return this.button;
    }

    public final Map<String, String> d() {
        return this.extra;
    }

    public final ECUrlModel e() {
        return this.icon;
    }

    public final Map<String, String> f() {
        return this.logExtra;
    }

    public final n g() {
        return this.subTitle;
    }

    public final n h() {
        return this.subTitleDouble;
    }

    public final n i() {
        return this.title;
    }
}
