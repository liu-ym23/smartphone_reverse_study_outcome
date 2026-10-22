package com.larus.network.http;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/larus/network/http/EvaluateData;", "Ljava/io/Serializable;", "from_date", "", "to_date", "encryption_message_id_list", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFrom_date", "()Ljava/lang/String;", "getTo_date", "getEncryption_message_id_list", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EvaluateData implements Serializable {
    private final List<String> encryption_message_id_list;
    private final String from_date;
    private final String to_date;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EvaluateData copy$default(EvaluateData r100, String r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.from_date;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.to_date;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.encryption_message_id_list;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.from_date;
    }

    public final String component2() {
        return this.to_date;
    }

    public final List<String> component3() {
        return this.encryption_message_id_list;
    }

    public final EvaluateData copy(String r100, String r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r101, "to_date");
        return new EvaluateData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EvaluateData) == true) goto L8;
        return false;
    L8:
        EvaluateData r101 = (EvaluateData) r100;
        if (Intrinsics.areEqual(this.from_date, r101.from_date) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.to_date, r101.to_date) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.encryption_message_id_list, r101.encryption_message_id_list) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.from_date;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.to_date.hashCode()) * 31;
        List<String> r104 = this.encryption_message_id_list;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "EvaluateData(from_date=" + this.from_date + ", to_date=" + this.to_date + ", encryption_message_id_list=" + this.encryption_message_id_list + ')';
    }

    public final List<String> getEncryption_message_id_list() {
        return this.encryption_message_id_list;
    }

    public final String getFrom_date() {
        return this.from_date;
    }

    public final String getTo_date() {
        return this.to_date;
    }

    public EvaluateData(String r100, String r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r101, "to_date");
        this.from_date = r100;
        this.to_date = r101;
        this.encryption_message_id_list = r102;
    }
}
