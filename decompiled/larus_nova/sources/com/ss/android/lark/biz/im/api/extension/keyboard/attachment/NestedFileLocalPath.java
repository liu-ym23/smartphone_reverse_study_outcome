package com.ss.android.lark.biz.im.api.extension.keyboard.attachment;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u0003H\u0016J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/NestedFileLocalPath;", "Ljava/io/Serializable;", LocationMonitorConst.IDENTIFIER, "", "path", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "getPath", "setPath", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestedFileLocalPath implements Serializable {

    @SerializedName(LocationMonitorConst.IDENTIFIER)
    private String identifier;

    @SerializedName("path")
    private String path;

    /* JADX WARN: Multi-variable type inference failed */
    public NestedFileLocalPath() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ NestedFileLocalPath copy$default(NestedFileLocalPath r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.identifier;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.path;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.identifier;
    }

    public final String component2() {
        return this.path;
    }

    public final NestedFileLocalPath copy(String r100, String r101) {
        return new NestedFileLocalPath(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NestedFileLocalPath) == true) goto L8;
        return false;
    L8:
        NestedFileLocalPath r101 = (NestedFileLocalPath) r100;
        if (Intrinsics.areEqual(this.identifier, r101.identifier) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.identifier;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.path;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(new Gson().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setIdentifier(String r100) {
        this.identifier = r100;
    }

    public final void setPath(String r100) {
        this.path = r100;
    }

    public NestedFileLocalPath(String r100, String r101) {
        this.identifier = r100;
        this.path = r101;
    }

    public /* synthetic */ NestedFileLocalPath(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
