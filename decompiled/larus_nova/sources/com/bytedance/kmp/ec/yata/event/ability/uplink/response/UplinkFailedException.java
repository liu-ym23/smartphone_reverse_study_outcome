package com.bytedance.kmp.ec.yata.event.ability.uplink.response;

import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00122\u00060\u0001j\u0002`\u0002:\u0001\u0013R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/kmp/ec/yata/event/ability/uplink/response/UplinkFailedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "response", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "getResponse", "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "", "statusCode", "I", "getStatusCode", "()I", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class UplinkFailedException extends RuntimeException {
    public static final a Companion = null;
    private final e response;
    private final int statusCode;
    private final String statusMsg;

    public static final class a {
        public a() {
        }

        public static UplinkFailedException a(e r100) {
            if (r100 == null) goto L7;
            Integer r101 = r100.a();
            if (r101 == null) goto L7;
            int r102 = r101.intValue();
        L8:
            if (r100 == null) goto L11;
            String r103 = r100.b();
            if (r103 == null) goto L11;
        L13:
            return new UplinkFailedException(r100, r102, r103, null);
        L11:
            r103 = "Unknown exception";
        L7:
            r102 = -1;
            goto L8
        }
    }

    static {
        Companion = new a();
    }

    public final e getResponse() {
        return this.response;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public UplinkFailedException(e r100, int r101, String r102, DefaultConstructorMarker r103) {
        StringBuilder r104 = new StringBuilder("uplink failed. statusCode is ");
        r104.append(r101);
        r104.append(", statusCode is ");
        r104.append(r101);
        r104.append(", logId:");
        if (r100 == null) goto L5;
        String r105 = f.b(r100);
    L6:
        r104.append(r105);
        super(r104.toString());
        this.response = r100;
        this.statusCode = r101;
        this.statusMsg = r102;
        return;
    L5:
        r105 = null;
        goto L6
    }
}
