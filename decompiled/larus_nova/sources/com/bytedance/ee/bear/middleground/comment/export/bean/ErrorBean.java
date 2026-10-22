package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: classes18.dex */
public class ErrorBean implements BaseJSModel {
    public static final int BAN_FAIL = 90500;
    public int code;
    public String msg;

    public ErrorBean() {
    }

    public boolean isBanFail() {
        if (this.code != 90500) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCancelLoading() {
        if (this.code != (-1111)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCommentQuantityLimit() {
        if (this.code != 16001) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isMultiGeoFail() {
        int r100 = this.code;
        if (r100 != 900004510) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 900004511) goto L8;
        return false;
    }

    public boolean isMultiGeoPrepare() {
        if (this.code != 900004230) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNetFail() {
        if (this.code != (-8)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNoPermission() {
        if (this.code != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isReviewFail() {
        return ((com.bytedance.ee.bear.review.a) org.koin.java.a.a(com.bytedance.ee.bear.review.a.class)).b(this.code);
    }

    public boolean isSuccess() {
        if (this.code != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ErrorBean) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ErrorBean) r100).code != this.code) goto L7;
        return true;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setMsg(String r100) {
        this.msg = r100;
    }
}
