package com.bytedance.android.shopping.feed.model.feedbackboard;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/feed/model/feedbackboard/a;", "", "", "btm", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "desc", "b", "tagName", "f", "tagCode", "e", "", "logExtra", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("btm")
    private final String btm;

    @SerializedName("desc")
    private final String desc;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("log_extra")
    private final Map<String, String> logExtra;

    @SerializedName("tag_code")
    private final String tagCode;

    @SerializedName("tag_name")
    private final String tagName;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L18;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.btm, r4.btm) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.desc, r4.desc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tagName, r4.tagName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.tagCode, r4.tagCode) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.logExtra, r4.logExtra) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.btm;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECUrlModel r4 = this.icon;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.desc;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.tagName;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.tagCode;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, String> r16 = this.logExtra;
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
        return "Feedback(btm=" + this.btm + ", icon=" + this.icon + ", desc=" + this.desc + ", tagName=" + this.tagName + ", tagCode=" + this.tagCode + ", logExtra=" + this.logExtra + ")";
    }

    public a() {
        this.btm = null;
        this.icon = null;
        this.desc = null;
        this.tagName = null;
        this.tagCode = null;
        this.logExtra = null;
    }

    public final String a() {
        return this.btm;
    }

    public final String b() {
        return this.desc;
    }

    public final ECUrlModel c() {
        return this.icon;
    }

    public final Map<String, String> d() {
        return this.logExtra;
    }

    public final String e() {
        return this.tagCode;
    }

    public final String f() {
        return this.tagName;
    }
}
