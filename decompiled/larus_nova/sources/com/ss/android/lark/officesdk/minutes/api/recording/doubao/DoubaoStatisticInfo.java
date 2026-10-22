package com.ss.android.lark.officesdk.minutes.api.recording.doubao;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/DoubaoStatisticInfo;", "Ljava/io/Serializable;", "rawParams", "", "<init>", "(Ljava/lang/String;)V", "getRawParams", "()Ljava/lang/String;", "toJSONObject", "Lorg/json/JSONObject;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoStatisticInfo implements Serializable {
    private final String rawParams;

    public static /* synthetic */ DoubaoStatisticInfo copy$default(DoubaoStatisticInfo r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.rawParams;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.rawParams;
    }

    public final DoubaoStatisticInfo copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawParams");
        return new DoubaoStatisticInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoubaoStatisticInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.rawParams, ((DoubaoStatisticInfo) r100).rawParams) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.rawParams.hashCode();
    }

    public String toString() {
        return "DoubaoStatisticInfo(rawParams=" + this.rawParams + ')';
    }

    public final JSONObject toJSONObject() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(new JSONObject(this.rawParams));     // Catch: Throwable -> L4
    L6:
        JSONObject r102 = new JSONObject();
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = r102;
    L10:
        return (JSONObject) r101;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final String getRawParams() {
        return this.rawParams;
    }

    public DoubaoStatisticInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawParams");
        this.rawParams = r100;
    }
}
