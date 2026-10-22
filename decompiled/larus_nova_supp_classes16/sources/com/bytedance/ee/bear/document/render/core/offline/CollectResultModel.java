package com.bytedance.ee.bear.document.render.core.offline;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0005H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/document/render/core/offline/CollectResultModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "code", "", "message", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(ILjava/lang/String;Ljava/util/ArrayList;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Ljava/util/ArrayList;", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectResultModel implements NonProguard {
    private final int code;
    private final ArrayList<String> data;
    private final String message;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CollectResultModel copy$default(CollectResultModel r0, int r1, String r2, ArrayList r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.data;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final ArrayList<String> component3() {
        return this.data;
    }

    public final CollectResultModel copy(int r2, String r3, ArrayList<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "data");
        return new CollectResultModel(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CollectResultModel) == true) goto L8;
        return false;
    L8:
        CollectResultModel r6 = (CollectResultModel) r5;
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.code * 31) + this.message.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "{\"code\": " + this.code + ",\"message\": \"" + this.message + "\",\"data\": " + this.data + '}';
    }

    public final int getCode() {
        return this.code;
    }

    public final ArrayList<String> getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public CollectResultModel(int r2, String r3, ArrayList<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "data");
        this.code = r2;
        this.message = r3;
        this.data = r4;
    }
}
