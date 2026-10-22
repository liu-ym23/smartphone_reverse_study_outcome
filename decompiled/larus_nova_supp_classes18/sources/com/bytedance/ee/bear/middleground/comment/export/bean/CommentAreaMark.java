package com.bytedance.ee.bear.middleground.comment.export.bean;

import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u0000J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentAreaMark;", "Ljava/io/Serializable;", "<init>", "()V", "areaData", "", "getAreaData", "()[F", "setAreaData", "([F)V", "createTimeStamp", "", "getCreateTimeStamp", "()J", "setCreateTimeStamp", "(J)V", "areaUUID", "", "getAreaUUID", "()Ljava/lang/String;", "setAreaUUID", "(Ljava/lang/String;)V", "userId", "getUserId", "setUserId", "userName", "getUserName", "setUserName", "copy", "equals", "", "other", "", "hashCode", "", "toString", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentAreaMark implements Serializable {
    private float[] areaData;
    private String areaUUID;
    private long createTimeStamp;
    private String userId;
    private String userName;

    public final CommentAreaMark copy() {
        CommentAreaMark r0 = new CommentAreaMark();
        float[] r1 = this.areaData;
        r0.areaData = Arrays.copyOf(r1, r1.length);
        r0.createTimeStamp = this.createTimeStamp;
        r0.areaUUID = this.areaUUID;
        r0.userId = this.userId;
        r0.userName = this.userName;
        return r0;
    }

    public int hashCode() {
        long r0 = this.createTimeStamp;
        return (((((((((int) (r0 ^ (r0 >>> 32))) * 31) + Arrays.hashCode(this.areaData)) * 31) + this.areaUUID.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.userName.hashCode();
    }

    public String toString() {
        return "CommentAreaMark(areaData=" + Arrays.toString(this.areaData) + ", userId='" + this.userId + "', userName='" + this.userName + "', createTimeStamp=" + this.createTimeStamp + ", areaUUID='" + du5.b.h(this.areaUUID) + "')";
    }

    public CommentAreaMark() {
        this.areaData = new float[0];
        this.areaUUID = "";
        this.userId = "";
        this.userName = "";
    }

    public final float[] getAreaData() {
        return this.areaData;
    }

    public final String getAreaUUID() {
        return this.areaUUID;
    }

    public final long getCreateTimeStamp() {
        return this.createTimeStamp;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 == null) goto L8;
        Class<?> r2 = r8.getClass();
    L10:
        if (Intrinsics.areEqual(CommentAreaMark.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.export.bean.CommentAreaMark");
        CommentAreaMark r9 = (CommentAreaMark) r8;
        if (this.createTimeStamp == r9.createTimeStamp) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.areaData, r9.areaData) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.areaUUID, r9.areaUUID) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.userId, r9.userId) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.userName, r9.userName) == true) goto L27;
        return false;
    L27:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final void setAreaData(float[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.areaData = r2;
    }

    public final void setAreaUUID(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.areaUUID = r2;
    }

    public final void setCreateTimeStamp(long r1) {
        this.createTimeStamp = r1;
    }

    public final void setUserId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userId = r2;
    }

    public final void setUserName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userName = r2;
    }
}
