package com.ss.android.lark.intent.export.entity;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/DispatchContext;", "", "questionId", "", "ext", "", "", "<init>", "(Ljava/lang/Long;Ljava/util/Map;)V", "getQuestionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExt", "()Ljava/util/Map;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/util/Map;)Lcom/ss/android/lark/intent/export/entity/DispatchContext;", "equals", "", "other", "hashCode", "", "toString", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DispatchContext {
    private final Map<String, String> ext;
    private final Long questionId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DispatchContext copy$default(DispatchContext r100, Long r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.questionId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.ext;
    L9:
        return r100.copy(r101, r102);
    }

    public final Long component1() {
        return this.questionId;
    }

    public final Map<String, String> component2() {
        return this.ext;
    }

    public final DispatchContext copy(Long r100, Map<String, String> r101) {
        return new DispatchContext(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DispatchContext) == true) goto L8;
        return false;
    L8:
        DispatchContext r101 = (DispatchContext) r100;
        if (Intrinsics.areEqual(this.questionId, r101.questionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Long r100 = this.questionId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.ext;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DispatchContext(questionId=" + this.questionId + ", ext=" + this.ext + ')';
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final Long getQuestionId() {
        return this.questionId;
    }

    public DispatchContext(Long r100, Map<String, String> r101) {
        this.questionId = r100;
        this.ext = r101;
    }

    public /* synthetic */ DispatchContext(Long r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
