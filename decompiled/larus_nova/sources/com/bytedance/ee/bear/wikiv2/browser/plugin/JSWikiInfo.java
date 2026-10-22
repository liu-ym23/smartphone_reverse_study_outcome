package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class JSWikiInfo implements NonProguard {
    public Info wiki_info;

    public static class Info implements NonProguard {
        public int code;
        public String obj_token;
        public int obj_type;
        public String space_id;
        public String wiki_token;

        public Info() {
        }
    }

    public JSWikiInfo() {
    }

    public WikiInfo toWikiInfo() {
        WikiInfo r100 = new WikiInfo();
        Info r101 = this.wiki_info;
        if (r101 == null) goto L5;
        r100.setCode(r101.code);
        r100.setObjToken(this.wiki_info.obj_token);
        r100.setObjType(this.wiki_info.obj_type);
        r100.setSpaceId(this.wiki_info.space_id);
        r100.setWikiToken(this.wiki_info.wiki_token);
    L5:
        return r100;
    }
}
