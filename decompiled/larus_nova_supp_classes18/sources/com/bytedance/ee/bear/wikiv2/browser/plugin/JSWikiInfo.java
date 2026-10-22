package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        WikiInfo r0 = new WikiInfo();
        Info r1 = this.wiki_info;
        if (r1 == null) goto L5;
        r0.setCode(r1.code);
        r0.setObjToken(this.wiki_info.obj_token);
        r0.setObjType(this.wiki_info.obj_type);
        r0.setSpaceId(this.wiki_info.space_id);
        r0.setWikiToken(this.wiki_info.wiki_token);
    L5:
        return r0;
    }
}
