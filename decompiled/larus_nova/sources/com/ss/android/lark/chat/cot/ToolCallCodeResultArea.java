package com.ss.android.lark.chat.cot;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/cot/ToolCallCodeResultArea;", "Lcom/ss/android/lark/chat/cot/ToolCallResultArea;", "code", "", "language", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getLanguage", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToolCallCodeResultArea implements ToolCallResultArea {
    private final String code;
    private final String language;

    public static /* synthetic */ ToolCallCodeResultArea copy$default(ToolCallCodeResultArea r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.language;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.language;
    }

    public final ToolCallCodeResultArea copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        return new ToolCallCodeResultArea(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ToolCallCodeResultArea) == true) goto L8;
        return false;
    L8:
        ToolCallCodeResultArea r101 = (ToolCallCodeResultArea) r100;
        if (Intrinsics.areEqual(this.code, r101.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.language, r101.language) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.code.hashCode() * 31;
        String r101 = this.language;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ToolCallCodeResultArea(code=" + this.code + ", language=" + this.language + ')';
    }

    public final String getCode() {
        return this.code;
    }

    public final String getLanguage() {
        return this.language;
    }

    public ToolCallCodeResultArea(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        this.code = r100;
        this.language = r101;
    }

    public /* synthetic */ ToolCallCodeResultArea(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
