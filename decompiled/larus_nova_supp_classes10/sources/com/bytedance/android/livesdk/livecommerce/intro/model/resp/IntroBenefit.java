package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroBenefit;", "", "", "benefitType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s;", "elasticTitle", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s;", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", LocationMonitorConst.TAG, "Ljava/util/List;", "f", "()Ljava/util/List;", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "benefitLabel", "a", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i0;", "progressBar", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i0;", "e", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i0;", "customTag", "c", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroBenefit {

    @SerializedName("benefit_label")
    private final List<PromotionBenefitLabel> benefitLabel;

    @SerializedName("benefit_type")
    private final Integer benefitType;

    @SerializedName("custom_tag")
    private final List<ECRitTag> customTag;

    @SerializedName("elastic_title")
    private final s elasticTitle;

    @SerializedName("progress_bar")
    private final i0 progressBar;

    @SerializedName(LocationMonitorConst.TAG)
    private final List<ECRitTag> tag;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroBenefit$Companion$IntroBenefitType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroBenefitType {
        }
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof IntroBenefit) == false) goto L18;
        IntroBenefit r4 = (IntroBenefit) r3;
        if (Intrinsics.areEqual(this.benefitType, r4.benefitType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.elasticTitle, r4.elasticTitle) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tag, r4.tag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.benefitLabel, r4.benefitLabel) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.progressBar, r4.progressBar) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.customTag, r4.customTag) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.benefitType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        s r4 = this.elasticTitle;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<ECRitTag> r7 = this.tag;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<PromotionBenefitLabel> r10 = this.benefitLabel;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        i0 r13 = this.progressBar;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<ECRitTag> r16 = this.customTag;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
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
        return "IntroBenefit(benefitType=" + this.benefitType + ", elasticTitle=" + this.elasticTitle + ", tag=" + this.tag + ", benefitLabel=" + this.benefitLabel + ", progressBar=" + this.progressBar + ", customTag=" + this.customTag + ")";
    }

    public IntroBenefit() {
        this.benefitType = null;
        this.elasticTitle = null;
        this.tag = null;
        this.benefitLabel = null;
        this.progressBar = null;
        this.customTag = null;
    }

    public final List<PromotionBenefitLabel> a() {
        return this.benefitLabel;
    }

    public final Integer b() {
        return this.benefitType;
    }

    public final List<ECRitTag> c() {
        return this.customTag;
    }

    public final s d() {
        return this.elasticTitle;
    }

    public final i0 e() {
        return this.progressBar;
    }

    public final List<ECRitTag> f() {
        return this.tag;
    }
}
