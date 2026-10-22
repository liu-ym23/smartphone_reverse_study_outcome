package com.bytedance.android.shopping.slice.action.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u0006\u001a\u00020\u0002HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/entity/SendClosePdpEventParam;", "Ljava/io/Serializable;", "", "component1", "lynxUrl", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getLynxUrl", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SendClosePdpEventParam implements Serializable {
    public static final a Companion = null;
    public static final String KEY_LYNX_URL = "lynx_url";

    @SerializedName(KEY_LYNX_URL)
    private final String lynxUrl;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SendClosePdpEventParam() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ SendClosePdpEventParam copy$default(SendClosePdpEventParam r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.lynxUrl;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.lynxUrl;
    }

    public final SendClosePdpEventParam copy(String r2) {
        return new SendClosePdpEventParam(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof SendClosePdpEventParam) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.lynxUrl, ((SendClosePdpEventParam) r2).lynxUrl) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r0 = this.lynxUrl;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "SendClosePdpEventParam(lynxUrl=" + this.lynxUrl + ")";
    }

    public final String getLynxUrl() {
        return this.lynxUrl;
    }

    public SendClosePdpEventParam(String r1) {
        this.lynxUrl = r1;
    }

    public /* synthetic */ SendClosePdpEventParam(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
