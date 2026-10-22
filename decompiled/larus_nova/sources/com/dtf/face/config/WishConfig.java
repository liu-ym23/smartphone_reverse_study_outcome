package com.dtf.face.config;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.ec.core.event.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class WishConfig {
    public static final String WISH_MODE_CODE = "codeMode";
    public static final String WISH_MODE_QA = "qaMode";
    public static final String WISH_MODE_READ = "readMode";
    public static final String WISH_MODE_REGISTER = "registerMode";

    @JSONField(name = "ControlConfig")
    public ControlConfig controlConfig;

    @JSONField(name = "WishContent")
    public List<WishContent> wishContent;

    public static class ControlConfig {

        @JSONField(name = "screenEvidence")
        public boolean screenEvidence;

        public ControlConfig() {
        }
    }

    public static class WishContent {

        @JSONField(name = "content")
        public List<WishItem> content;

        @JSONField(name = "recognizeType")
        public String recognizeType;

        @JSONField(name = "recognizeTypeName")
        public String recognizeTypeName;

        public WishContent() {
        }
    }

    public static class WishItem {

        @JSONField(name = "answerTitle")
        public String answerTitle;

        @JSONField(name = "answerType")
        public String answerType;

        @JSONField(name = a.VALUE_QUESTION)
        public String question;

        @JSONField(name = "time")
        public int time;

        public WishItem() {
        }
    }

    public WishConfig() {
    }

    public static WishConfig parse(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L23;
        return null;
    L23:
        WishConfig r102 = new WishConfig();     // Catch: Throwable -> L21
        ControlConfig r103 = (ControlConfig) JSON.parseObject(r101, ControlConfig.class);     // Catch: Throwable -> L21
        if (r103 == null) goto L8;
        r102.controlConfig = r103;     // Catch: Throwable -> L21
    L8:
        JSONArray r104 = JSON.parseArray(r100);     // Catch: Throwable -> L21
        if (r104 == null) goto L15;
        int r105 = r104.size();     // Catch: Throwable -> L21
        if (r105 <= 0) goto L15;
        r102.wishContent = new ArrayList();     // Catch: Throwable -> L21
        int r106 = 0;
    L13:
        if (r106 >= r105) goto L15;
        r102.wishContent.add((WishContent) JSON.parseObject(r104.getString(r106), WishContent.class));     // Catch: Throwable -> L21
        r106 = r106 + 1;     // Catch: Throwable -> L21
    L15:
        List<WishContent> r107 = r102.wishContent;     // Catch: Throwable -> L21
        if (r107 == null) goto L20;
        if (r107.size() <= 0) goto L20;
        return r102;
    L20:
        return null;
    L22:
        return new WishConfig();
    }
}
