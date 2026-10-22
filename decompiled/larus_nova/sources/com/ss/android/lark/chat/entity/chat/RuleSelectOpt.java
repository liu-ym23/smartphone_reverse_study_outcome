package com.ss.android.lark.chat.entity.chat;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/RuleSelectOpt;", "Ljava/io/Serializable;", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "equals", "", "other", "", "hashCode", "", "component1", "component2", "copy", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RuleSelectOpt implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f415167id;
    private String name;

    public static /* synthetic */ RuleSelectOpt copy$default(RuleSelectOpt r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f415167id;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.name;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.f415167id;
    }

    public final String component2() {
        return this.name;
    }

    public final RuleSelectOpt copy(String r100, String r101) {
        return new RuleSelectOpt(r100, r101);
    }

    public String toString() {
        return "RuleSelectOpt(id=" + this.f415167id + ", name=" + this.name + ')';
    }

    public int hashCode() {
        String r100 = this.f415167id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String getId() {
        return this.f415167id;
    }

    public final String getName() {
        return this.name;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(RuleSelectOpt.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.chat.RuleSelectOpt");
        RuleSelectOpt r102 = (RuleSelectOpt) r100;
        if (Intrinsics.areEqual(this.f415167id, r102.f415167id) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.name, r102.name) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setId(String r100) {
        this.f415167id = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public RuleSelectOpt(String r100, String r101) {
        this.f415167id = r100;
        this.name = r101;
    }
}
