package com.ss.android.lark.chameleonv2.lkapi.net;

import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpResponse;", "Lcom/bytedance/ee/util/io/NonProguard;", ContainerPosition.BODY, "", "status", "", "headers", "", "<init>", "(Ljava/lang/String;ILjava/util/Map;)V", "getBody", "()Ljava/lang/String;", "setBody", "(Ljava/lang/String;)V", "getStatus", "()I", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class INet$Internal$HttpResponse implements NonProguard {
    private String body;
    private Map<String, String> headers;
    private final int status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ INet$Internal$HttpResponse copy$default(INet$Internal$HttpResponse r100, String r101, int r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.body;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.status;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.headers;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.body;
    }

    public final int component2() {
        return this.status;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    public final INet$Internal$HttpResponse copy(String r100, int r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        return new INet$Internal$HttpResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof INet$Internal$HttpResponse) == true) goto L8;
        return false;
    L8:
        INet$Internal$HttpResponse r101 = (INet$Internal$HttpResponse) r100;
        if (Intrinsics.areEqual(this.body, r101.body) == true) goto L12;
        return false;
    L12:
        if (this.status == r101.status) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.headers, r101.headers) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.body.hashCode() * 31) + this.status) * 31;
        Map<String, String> r101 = this.headers;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "HttpResponse(body=" + this.body + ", status=" + this.status + ", headers=" + this.headers + ')';
    }

    public final String getBody() {
        return this.body;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setBody(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.body = r100;
    }

    public final void setHeaders(Map<String, String> r100) {
        this.headers = r100;
    }

    public INet$Internal$HttpResponse(String r100, int r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        this.body = r100;
        this.status = r101;
        this.headers = r102;
    }
}
