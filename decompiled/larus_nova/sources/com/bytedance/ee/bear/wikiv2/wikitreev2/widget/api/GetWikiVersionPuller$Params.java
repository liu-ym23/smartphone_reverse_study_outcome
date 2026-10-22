package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class GetWikiVersionPuller$Params implements NonProguard {
    public String space_id;
    public String wiki_token;

    public String toString() {
        return "Params{space_id='" + yu5.c.j(this.space_id) + "'wiki_token='" + yu5.c.j(this.wiki_token) + "'}";
    }

    public GetWikiVersionPuller$Params(String r100, String r101) {
        this.space_id = r100;
        this.wiki_token = r101;
    }
}
