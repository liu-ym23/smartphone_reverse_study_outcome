package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CheckShortcutPuller$Params implements NonProguard {
    public int biz_type;
    public String obj_token;
    public int obj_type;
    public String parent_node_token;

    public CheckShortcutPuller$Params(String r1, String r2, int r3, int r4) {
        this.parent_node_token = r1;
        this.obj_token = r2;
        this.obj_type = r3;
        this.biz_type = r4;
    }
}
