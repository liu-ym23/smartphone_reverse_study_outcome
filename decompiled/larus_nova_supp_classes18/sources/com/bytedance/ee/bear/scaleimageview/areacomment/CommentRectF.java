package com.bytedance.ee.bear.scaleimageview.areacomment;

import android.graphics.RectF;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Objects;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CommentRectF extends RectF {
    public int a;
    public String b;
    public String c;
    public long d;
    public int e;
    public String f;
    public String g;
    public String h;
    public Quad[] i;
    public String j;

    @Override // android.graphics.RectF
    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.b});
    }

    @Override // android.graphics.RectF
    public final String toString() {
        return "CommentRectF{mType=" + this.a + ", mCommentId='" + this.b + "', replyId=" + this.c + "', mCreateTime=" + this.d + ", mPage=" + this.e + ", mQuads=" + Arrays.toString(this.i) + ", rect=" + super.toShortString() + ", userName='" + this.f + "', userId='" + this.g + "', uuid='" + this.h + "'}\n";
    }

    public CommentRectF() {
        this.a = 1;
        this.b = "";
        this.c = "";
        this.f = "";
        this.g = "";
        this.h = "";
    }

    public int getType() {
        return this.a;
    }

    public CommentRectF(String r2) {
        this.a = 1;
        this.c = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.b = r2;
    }

    @Override // android.graphics.RectF
    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L15;
        if (super.equals(r4) == true) goto L14;
        return false;
    L14:
        return this.b.equals(((CommentRectF) r4).b);
    }

    public static CommentRectF a(String r4, AreaCoordinate r5) {
        if (TextUtils.isEmpty(r4) == true) goto L10;
        if (r5 == null) goto L10;
        CommentRectF r0 = new CommentRectF(r4);
        r0.a = r5.getType();
        if (r5.getPosition() == null) goto L9;
        r0.e = r5.getPosition().getPage();
        r0.set(r5.getPosition().getLeft(), r5.getPosition().getTop(), r5.getPosition().getRight(), r5.getPosition().getBottom());
        r0.j = r5.getPosition().getText();
        r0.i = r5.getPosition().getQuads();
    L9:
        return r0;
    L10:
        a.k("CommentRectF", "area comment Coordinate wrong. = " + r5);
        return null;
    }

    public CommentRectF(float r1, float r2, float r3, float r4) {
        super(r1, r2, r3, r4);
        this.a = 1;
        this.b = "";
        this.c = "";
        this.f = "";
        this.g = "";
        this.h = "";
    }

    public CommentRectF(String r1, float r2, float r3, float r4, float r5) {
        super(r2, r3, r4, r5);
        this.a = 1;
        this.c = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.b = r1;
    }
}
