package com.bytedance.ee.bear.document.toast;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ToastModel implements BaseJSModel {
    public static final int TYPE_BOTTOM = 2;
    public static final int TYPE_CENTER = 3;
    public static final int TYPE_FAIL = 1;
    public static final int TYPE_LOADING = 8;
    public static final int TYPE_SUCCESS = 0;
    public static final int TYPE_SUCCESS_WITH_ACTION = 5;
    public static final int TYPE_TOAST_WITH_ACTION = 6;
    public static final int TYPE_TOP = 4;
    public static final int TYPE_WARING_WITH_ACTION = 9;
    public static final int TYPE_WARNING = 7;
    public String buttonMessage;
    public int duration;
    public String message;
    public int type;

    public String toString() {
        return "ToastModel{message='" + this.message + "', type=" + this.type + ", duration=" + this.duration + '}';
    }

    public ToastModel() {
    }

    public ToastModel(String r1, int r2, int r3) {
        this.message = r1;
        this.type = r2;
        this.duration = r3;
    }
}
