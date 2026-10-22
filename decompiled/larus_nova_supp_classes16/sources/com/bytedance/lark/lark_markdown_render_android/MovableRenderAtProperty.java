package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJF\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0007\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\b\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006$"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderAtProperty;", "", "userId", "", "content", "isOuter", "", "isAnonymous", "isHighlight", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setAnonymous", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setHighlight", "setOuter", "getUserId", "setUserId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderAtProperty;", "equals", "other", "hashCode", "", "into", "Llark_markdown_render/proto/MovableRenderAtProperty;", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MovableRenderAtProperty {
    private String content;
    private Boolean isAnonymous;
    private Boolean isHighlight;
    private Boolean isOuter;
    private String userId;

    public static /* synthetic */ MovableRenderAtProperty copy$default(MovableRenderAtProperty r3, String r4, String r5, Boolean r6, Boolean r7, Boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.userId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.content;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.isOuter;
    L11:
        Boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.isAnonymous;
    L14:
        Boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.isHighlight;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.content;
    }

    public final Boolean component3() {
        return this.isOuter;
    }

    public final Boolean component4() {
        return this.isAnonymous;
    }

    public final Boolean component5() {
        return this.isHighlight;
    }

    public final MovableRenderAtProperty copy(String r8, String r9, Boolean r10, Boolean r11, Boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "userId");
        Intrinsics.checkNotNullParameter(r9, "content");
        return new MovableRenderAtProperty(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MovableRenderAtProperty) == true) goto L8;
        return false;
    L8:
        MovableRenderAtProperty r6 = (MovableRenderAtProperty) r5;
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isOuter, r6.isOuter) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isAnonymous, r6.isAnonymous) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isHighlight, r6.isHighlight) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.userId.hashCode() * 31) + this.content.hashCode()) * 31;
        Boolean r1 = this.isOuter;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Boolean r5 = this.isAnonymous;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Boolean r8 = this.isHighlight;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "MovableRenderAtProperty(userId=" + this.userId + ", content=" + this.content + ", isOuter=" + this.isOuter + ", isAnonymous=" + this.isAnonymous + ", isHighlight=" + this.isHighlight + ')';
    }

    public final lark_markdown_render.proto.MovableRenderAtProperty into() {
        return new lark_markdown_render.proto.MovableRenderAtProperty(this.userId, this.content, this.isOuter, this.isAnonymous, this.isHighlight);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Boolean isAnonymous() {
        return this.isAnonymous;
    }

    public final Boolean isHighlight() {
        return this.isHighlight;
    }

    public final Boolean isOuter() {
        return this.isOuter;
    }

    public final void setAnonymous(Boolean r1) {
        this.isAnonymous = r1;
    }

    public final void setContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public final void setHighlight(Boolean r1) {
        this.isHighlight = r1;
    }

    public final void setOuter(Boolean r1) {
        this.isOuter = r1;
    }

    public final void setUserId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userId = r2;
    }

    public MovableRenderAtProperty(String r2, String r3, Boolean r4, Boolean r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "content");
        this.userId = r2;
        this.content = r3;
        this.isOuter = r4;
        this.isAnonymous = r5;
        this.isHighlight = r6;
    }
}
