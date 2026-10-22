package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyCommonGadgetPushRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "isOnline", "", "biz", "", "timestamp", "data", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getBiz", "()Ljava/lang/String;", "getTimestamp", "getData", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyCommonGadgetPushRequest implements NonProguard {
    private final String biz;
    private final String data;
    private final boolean isOnline;
    private final String timestamp;

    public static /* synthetic */ MyCommonGadgetPushRequest copy$default(MyCommonGadgetPushRequest r100, boolean r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.isOnline;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.biz;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.timestamp;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.data;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.isOnline;
    }

    public final String component2() {
        return this.biz;
    }

    public final String component3() {
        return this.timestamp;
    }

    public final String component4() {
        return this.data;
    }

    public final MyCommonGadgetPushRequest copy(boolean r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "biz");
        return new MyCommonGadgetPushRequest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MyCommonGadgetPushRequest) == true) goto L8;
        return false;
    L8:
        MyCommonGadgetPushRequest r101 = (MyCommonGadgetPushRequest) r100;
        if (this.isOnline == r101.isOnline) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.biz, r101.biz) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timestamp, r101.timestamp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.isOnline == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.biz.hashCode()) * 31;
        String r102 = this.timestamp;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.data;
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

    public String toString() {
        return "MyCommonGadgetPushRequest(isOnline=" + this.isOnline + ", biz=" + this.biz + ", timestamp=" + this.timestamp + ", data=" + this.data + ')';
    }

    public final String getBiz() {
        return this.biz;
    }

    public final String getData() {
        return this.data;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final boolean isOnline() {
        return this.isOnline;
    }

    public MyCommonGadgetPushRequest(boolean r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "biz");
        this.isOnline = r100;
        this.biz = r101;
        this.timestamp = r102;
        this.data = r103;
    }
}
