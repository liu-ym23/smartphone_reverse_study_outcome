package com.larus.im.callback;

import com.bytedance.android.ec.core.event.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0001H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/larus/im/callback/IMError;", "Lcom/larus/im/callback/IIMError;", "code", "", "tips", "", a.KEY_EXCEPTION, "", "ext", "", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", "getCode", "()I", "getTips", "()Ljava/lang/String;", "getException", "()Ljava/lang/Throwable;", "getExt", "()Ljava/util/Map;", "deepCopy", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMError implements IIMError {
    private final int code;
    private final Throwable exception;
    private final Map<String, String> ext;
    private final String tips;

    public IMError() {
        this(0, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IMError copy$default(IMError r100, int r101, String r102, Throwable r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.tips;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.exception;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.ext;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.tips;
    }

    public final Throwable component3() {
        return this.exception;
    }

    public final Map<String, String> component4() {
        return this.ext;
    }

    public final IMError copy(int r100, String r101, Throwable r102, Map<String, String> r103) {
        return new IMError(r100, r101, r102, r103);
    }

    @Override // com.larus.im.callback.IIMError
    public IIMError deepCopy() {
        return copy$default(this, 0, null, null, null, 15, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IMError) == true) goto L8;
        return false;
    L8:
        IMError r101 = (IMError) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tips, r101.tips) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.exception, r101.exception) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.code * 31;
        String r101 = this.tips;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Throwable r105 = this.exception;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, String> r108 = this.ext;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "IMError(code=" + this.code + ", tips=" + this.tips + ", exception=" + this.exception + ", ext=" + this.ext + ')';
    }

    @Override // com.larus.im.callback.IIMError
    public int getCode() {
        return this.code;
    }

    @Override // com.larus.im.callback.IIMError
    public Throwable getException() {
        return this.exception;
    }

    @Override // com.larus.im.callback.IIMError
    public Map<String, String> getExt() {
        return this.ext;
    }

    @Override // com.larus.im.callback.IIMError
    public String getTips() {
        return this.tips;
    }

    public IMError(int r100, String r101, Throwable r102, Map<String, String> r103) {
        this.code = r100;
        this.tips = r101;
        this.exception = r102;
        this.ext = r103;
    }

    public /* synthetic */ IMError(int r100, String r101, Throwable r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
