package com.bytedance.android.shopping.slice.action.entity;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J-\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/entity/CheckLoginParam;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "enterFrom", "enterMethod", "source", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getEnterFrom", "()Ljava/lang/String;", "getEnterMethod", "getSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CheckLoginParam implements Serializable {
    public static final a Companion = null;
    public static final String KET_TIMESTAMP = "pdp_check_login_time";
    public static final String KEY_FAILED = "failed";
    public static final String KEY_SUCCESS = "success";

    @SerializedName(SimilarProductParam.ENTER_FROM)
    private final String enterFrom;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("source")
    private final String source;

    public static final class a {
        public a() {
        }

        public static CheckLoginParam a(Map r5) {
            Object r0 = null;
            if (r5 == null) goto L16;
            Object r2 = r5.get(SimilarProductParam.ENTER_FROM);
            if ((r2 instanceof String) == true) goto L7;
            r2 = null;
        L7:
            String r3 = (String) r2;
            Object r4 = r5.get("enter_method");
            if ((r4 instanceof String) == true) goto L10;
            r4 = null;
        L10:
            String r6 = (String) r4;
            Object r7 = r5.get("source");
            if ((r7 instanceof String) == false) goto L15;
            r0 = r7;
        L15:
            return new CheckLoginParam(r3, r6, (String) r0);
        L16:
            return null;
        }
    }

    static {
        Companion = new a();
    }

    public CheckLoginParam() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CheckLoginParam copy$default(CheckLoginParam r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enterFrom;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.enterMethod;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.source;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.enterFrom;
    }

    public final String component2() {
        return this.enterMethod;
    }

    public final String component3() {
        return this.source;
    }

    public final CheckLoginParam copy(String r2, String r3, String r4) {
        return new CheckLoginParam(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CheckLoginParam) == false) goto L12;
        CheckLoginParam r4 = (CheckLoginParam) r3;
        if (Intrinsics.areEqual(this.enterFrom, r4.enterFrom) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterMethod, r4.enterMethod) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.source, r4.source) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.enterFrom;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.enterMethod;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.source;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "CheckLoginParam(enterFrom=" + this.enterFrom + ", enterMethod=" + this.enterMethod + ", source=" + this.source + ")";
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getSource() {
        return this.source;
    }

    public CheckLoginParam(String r1, String r2, String r3) {
        this.enterFrom = r1;
        this.enterMethod = r2;
        this.source = r3;
    }

    public /* synthetic */ CheckLoginParam(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
