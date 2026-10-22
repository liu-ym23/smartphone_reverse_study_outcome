package com.ss.android.lark.chameleonv2.lkapi.transport;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003Bm\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\f\u001a\u00028\u0000\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J%\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003J\u000e\u0010&\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003J\u008c\u0001\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b2\b\b\u0002\u0010\f\u001a\u00028\u00002\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0005HÖ\u0001J\t\u00102\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001f¨\u00063"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$CallApiResponse;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "command", "", "hasError", "", "packetBizMeta", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "result", "rustApiCostTimeMs", "sdkUserId", "trace", "verifyUserId", "packetBuffer", "<init>", "(IZLjava/util/HashMap;Ljava/io/Serializable;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getCommand", "()I", "getHasError", "()Z", "getPacketBizMeta", "()Ljava/util/HashMap;", "getResult", "()Ljava/io/Serializable;", "Ljava/io/Serializable;", "getRustApiCostTimeMs", "getSdkUserId", "()Ljava/lang/String;", "getTrace", "getVerifyUserId", "getPacketBuffer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IZLjava/util/HashMap;Ljava/io/Serializable;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$CallApiResponse;", "equals", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITransport$Internal$CallApiResponse<T extends Serializable> implements NonProguard {
    private final int command;
    private final boolean hasError;
    private final HashMap<String, String> packetBizMeta;
    private final String packetBuffer;
    private final T result;
    private final int rustApiCostTimeMs;
    private final String sdkUserId;
    private final String trace;
    private final boolean verifyUserId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ITransport$Internal$CallApiResponse copy$default(ITransport$Internal$CallApiResponse r110, int r111, boolean r112, HashMap r113, Serializable r114, int r115, String r116, String r117, boolean r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.command;
    L7:
        if ((r210 & 2) == 0) goto L9;
        boolean r101 = r110.hasError;
    L11:
        if ((r210 & 4) == 0) goto L13;
        HashMap r102 = r110.packetBizMeta;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Serializable r103 = r110.result;
    L19:
        if ((r210 & 16) == 0) goto L21;
        int r104 = r110.rustApiCostTimeMs;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.sdkUserId;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.trace;
    L31:
        if ((r210 & 128) == 0) goto L33;
        boolean r107 = r110.verifyUserId;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.packetBuffer;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.command;
    }

    public final boolean component2() {
        return this.hasError;
    }

    public final HashMap<String, String> component3() {
        return this.packetBizMeta;
    }

    public final T component4() {
        return this.result;
    }

    public final int component5() {
        return this.rustApiCostTimeMs;
    }

    public final String component6() {
        return this.sdkUserId;
    }

    public final String component7() {
        return this.trace;
    }

    public final boolean component8() {
        return this.verifyUserId;
    }

    public final String component9() {
        return this.packetBuffer;
    }

    public final ITransport$Internal$CallApiResponse<T> copy(int r110, boolean r111, HashMap<String, String> r112, T r113, int r114, String r115, String r116, boolean r117, String r210) {
        Intrinsics.checkNotNullParameter(r112, "packetBizMeta");
        Intrinsics.checkNotNullParameter(r113, "result");
        Intrinsics.checkNotNullParameter(r115, "sdkUserId");
        Intrinsics.checkNotNullParameter(r116, "trace");
        return new ITransport$Internal$CallApiResponse(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ITransport$Internal$CallApiResponse) == true) goto L8;
        return false;
    L8:
        ITransport$Internal$CallApiResponse r101 = (ITransport$Internal$CallApiResponse) r100;
        if (this.command == r101.command) goto L12;
        return false;
    L12:
        if (this.hasError == r101.hasError) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packetBizMeta, r101.packetBizMeta) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.result, r101.result) == true) goto L21;
        return false;
    L21:
        if (this.rustApiCostTimeMs == r101.rustApiCostTimeMs) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sdkUserId, r101.sdkUserId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.trace, r101.trace) == true) goto L30;
        return false;
    L30:
        if (this.verifyUserId == r101.verifyUserId) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.packetBuffer, r101.packetBuffer) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = this.command * 31;
        int r101 = 1231;
        if (this.hasError == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((((((r100 + r102) * 31) + this.packetBizMeta.hashCode()) * 31) + this.result.hashCode()) * 31) + this.rustApiCostTimeMs) * 31) + this.sdkUserId.hashCode()) * 31) + this.trace.hashCode()) * 31;
        if (this.verifyUserId == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        String r105 = this.packetBuffer;
        if (r105 != null) goto L13;
        int r106 = 0;
    L15:
        return r104 + r106;
    L13:
        r106 = r105.hashCode();
        goto L15
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "CallApiResponse(command=" + this.command + ", hasError=" + this.hasError + ", packetBizMeta=" + this.packetBizMeta + ", result=" + this.result + ", rustApiCostTimeMs=" + this.rustApiCostTimeMs + ", sdkUserId=" + this.sdkUserId + ", trace=" + this.trace + ", verifyUserId=" + this.verifyUserId + ", packetBuffer=" + this.packetBuffer + ')';
    }

    public final int getCommand() {
        return this.command;
    }

    public final boolean getHasError() {
        return this.hasError;
    }

    public final HashMap<String, String> getPacketBizMeta() {
        return this.packetBizMeta;
    }

    public final String getPacketBuffer() {
        return this.packetBuffer;
    }

    public final T getResult() {
        return this.result;
    }

    public final int getRustApiCostTimeMs() {
        return this.rustApiCostTimeMs;
    }

    public final String getSdkUserId() {
        return this.sdkUserId;
    }

    public final String getTrace() {
        return this.trace;
    }

    public final boolean getVerifyUserId() {
        return this.verifyUserId;
    }

    public ITransport$Internal$CallApiResponse(int r100, boolean r101, HashMap<String, String> r102, T r103, int r104, String r105, String r106, boolean r107, String r110) {
        Intrinsics.checkNotNullParameter(r102, "packetBizMeta");
        Intrinsics.checkNotNullParameter(r103, "result");
        Intrinsics.checkNotNullParameter(r105, "sdkUserId");
        Intrinsics.checkNotNullParameter(r106, "trace");
        this.command = r100;
        this.hasError = r101;
        this.packetBizMeta = r102;
        this.result = r103;
        this.rustApiCostTimeMs = r104;
        this.sdkUserId = r105;
        this.trace = r106;
        this.verifyUserId = r107;
        this.packetBuffer = r110;
    }
}
