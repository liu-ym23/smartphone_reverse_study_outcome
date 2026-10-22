package com.bytedance.ee.bear.scaleimageview.areacomment;

import android.graphics.RectF;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Objects;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
public class CommentRectF extends RectF {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f236774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f236775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f236776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f236777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f236778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f236779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f236780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f236781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Quad[] f236782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f236783j;

    @Override // android.graphics.RectF
    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.f236775b});
    }

    @Override // android.graphics.RectF
    public final String toString() {
        return "CommentRectF{mType=" + this.f236774a + ", mCommentId='" + this.f236775b + "', replyId=" + this.f236776c + "', mCreateTime=" + this.f236777d + ", mPage=" + this.f236778e + ", mQuads=" + Arrays.toString(this.f236782i) + ", rect=" + super.toShortString() + ", userName='" + this.f236779f + "', userId='" + this.f236780g + "', uuid='" + this.f236781h + "'}\n";
    }

    public CommentRectF() {
        this.f236774a = 1;
        this.f236775b = "";
        this.f236776c = "";
        this.f236779f = "";
        this.f236780g = "";
        this.f236781h = "";
    }

    public int getType() {
        return this.f236774a;
    }

    public CommentRectF(String r100) {
        this.f236774a = 1;
        this.f236776c = "";
        this.f236779f = "";
        this.f236780g = "";
        this.f236781h = "";
        this.f236775b = r100;
    }

    @Override // android.graphics.RectF
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L15;
        if (super.equals(r100) == true) goto L14;
        return false;
    L14:
        return this.f236775b.equals(((CommentRectF) r100).f236775b);
    }

    public static CommentRectF a(String r100, AreaCoordinate r101) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (r101 == null) goto L10;
        CommentRectF r102 = new CommentRectF(r100);
        r102.f236774a = r101.getType();
        if (r101.getPosition() == null) goto L9;
        r102.f236778e = r101.getPosition().getPage();
        r102.set(r101.getPosition().getLeft(), r101.getPosition().getTop(), r101.getPosition().getRight(), r101.getPosition().getBottom());
        r102.f236783j = r101.getPosition().getText();
        r102.f236782i = r101.getPosition().getQuads();
    L9:
        return r102;
    L10:
        a.k("CommentRectF", "area comment Coordinate wrong. = " + r101);
        return null;
    }

    public CommentRectF(float r100, float r101, float r102, float r103) {
        super(r100, r101, r102, r103);
        this.f236774a = 1;
        this.f236775b = "";
        this.f236776c = "";
        this.f236779f = "";
        this.f236780g = "";
        this.f236781h = "";
    }

    public CommentRectF(String r100, float r101, float r102, float r103, float r104) {
        super(r101, r102, r103, r104);
        this.f236774a = 1;
        this.f236776c = "";
        this.f236779f = "";
        this.f236780g = "";
        this.f236781h = "";
        this.f236775b = r100;
    }
}
