package com.bytedance.android.shopping.store.tabkit.ssr;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0007\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0010R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/ssr/SSRModel;", "", "ssrData", "", "hydrateData", "", "hydrateUrl", "hydrateHash", "hydrateBytes", "timingData", "", "", "errorCode", "", "errorMsg", "errorNetCode", "([BLjava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/util/Map;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getErrorCode", "()Ljava/lang/Integer;", "setErrorCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "getErrorNetCode", "setErrorNetCode", "getHydrateBytes", "()[B", "setHydrateBytes", "([B)V", "getHydrateData", "setHydrateData", "getHydrateHash", "setHydrateHash", "getHydrateUrl", "setHydrateUrl", "getSsrData", "setSsrData", "getTimingData", "()Ljava/util/Map;", "setTimingData", "(Ljava/util/Map;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SSRModel {
    private Integer errorCode;
    private String errorMsg;
    private Integer errorNetCode;
    private byte[] hydrateBytes;
    private String hydrateData;
    private String hydrateHash;
    private String hydrateUrl;
    private byte[] ssrData;
    private Map<String, Long> timingData;

    public SSRModel() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final Integer getErrorNetCode() {
        return this.errorNetCode;
    }

    public final byte[] getHydrateBytes() {
        return this.hydrateBytes;
    }

    public final String getHydrateData() {
        return this.hydrateData;
    }

    public final String getHydrateHash() {
        return this.hydrateHash;
    }

    public final String getHydrateUrl() {
        return this.hydrateUrl;
    }

    public final byte[] getSsrData() {
        return this.ssrData;
    }

    public final Map<String, Long> getTimingData() {
        return this.timingData;
    }

    public final void setErrorCode(Integer r1) {
        this.errorCode = r1;
    }

    public final void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public final void setErrorNetCode(Integer r1) {
        this.errorNetCode = r1;
    }

    public final void setHydrateBytes(byte[] r1) {
        this.hydrateBytes = r1;
    }

    public final void setHydrateData(String r1) {
        this.hydrateData = r1;
    }

    public final void setHydrateHash(String r1) {
        this.hydrateHash = r1;
    }

    public final void setHydrateUrl(String r1) {
        this.hydrateUrl = r1;
    }

    public final void setSsrData(byte[] r1) {
        this.ssrData = r1;
    }

    public final void setTimingData(Map<String, Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.timingData = r2;
    }

    public SSRModel(byte[] r2, String r3, String r4, String r5, byte[] r6, Map<String, Long> r7, Integer r8, String r9, Integer r10) {
        Intrinsics.checkNotNullParameter(r7, "timingData");
        this.ssrData = r2;
        this.hydrateData = r3;
        this.hydrateUrl = r4;
        this.hydrateHash = r5;
        this.hydrateBytes = r6;
        this.timingData = r7;
        this.errorCode = r8;
        this.errorMsg = r9;
        this.errorNetCode = r10;
    }

    public /* synthetic */ SSRModel(byte[] r11, String r12, String r13, String r14, byte[] r15, Map r16, Integer r17, String r18, Integer r19, int r20, DefaultConstructorMarker r21) {
        Integer r2 = null;
        if ((r20 & 1) == 0) goto L5;
        byte[] r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        byte[] r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Map r7 = new LinkedHashMap();
    L27:
        if ((r20 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r2 = r19;
    L38:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
