package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Parameters;", "Ljava/io/Serializable;", "parameters", "", "", "userId", "sourceId", "previewId", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getParameters", "()Ljava/util/Map;", "getUserId", "()Ljava/lang/String;", "getSourceId", "getPreviewId", "equals", "", "other", "", "hashCode", "", "component1", "component2", "component3", "component4", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Parameters implements Serializable {
    private final Map<String, String> parameters;
    private final String previewId;
    private final String sourceId;
    private final String userId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Parameters copy$default(Parameters r100, Map r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.parameters;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.userId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.sourceId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.previewId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Map<String, String> component1() {
        return this.parameters;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.sourceId;
    }

    public final String component4() {
        return this.previewId;
    }

    public final Parameters copy(Map<String, String> r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "parameters");
        return new Parameters(r100, r101, r102, r103);
    }

    public String toString() {
        return "Parameters(parameters=" + this.parameters + ", userId=" + this.userId + ", sourceId=" + this.sourceId + ", previewId=" + this.previewId + ')';
    }

    public int hashCode() {
        int r100 = this.parameters.hashCode() * 31;
        String r101 = this.userId;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.sourceId;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.previewId;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    public final String getPreviewId() {
        return this.previewId;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(Parameters.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Parameters");
        Parameters r102 = (Parameters) r100;
        if (Intrinsics.areEqual(this.parameters, r102.parameters) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.userId, r102.userId) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.sourceId, r102.sourceId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.previewId, r102.previewId) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public Parameters(Map<String, String> r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "parameters");
        this.parameters = r100;
        this.userId = r101;
        this.sourceId = r102;
        this.previewId = r103;
    }
}
