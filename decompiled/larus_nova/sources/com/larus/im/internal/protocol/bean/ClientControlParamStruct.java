package com.larus.im.internal.protocol.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0081\b\u0018\u0000 \u00122\u00060\u0001j\u0002`\u0002:\u0001\u0012B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/im/internal/protocol/bean/ClientControlParamStruct;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "commonPlaceHolder", "", "<init>", "(Ljava/lang/String;)V", "getCommonPlaceHolder", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClientControlParamStruct implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private final String commonPlaceHolder;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClientControlParamStruct() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ClientControlParamStruct copy$default(ClientControlParamStruct r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.commonPlaceHolder;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.commonPlaceHolder;
    }

    public final ClientControlParamStruct copy(String r100) {
        return new ClientControlParamStruct(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClientControlParamStruct) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.commonPlaceHolder, ((ClientControlParamStruct) r100).commonPlaceHolder) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r100 = this.commonPlaceHolder;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "ClientControlParamStruct(commonPlaceHolder=" + this.commonPlaceHolder + ')';
    }

    public final String getCommonPlaceHolder() {
        return this.commonPlaceHolder;
    }

    public ClientControlParamStruct(String r100) {
        this.commonPlaceHolder = r100;
    }

    public /* synthetic */ ClientControlParamStruct(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
