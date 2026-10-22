package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class CheckShortcutPuller$Params implements NonProguard {
    public int biz_type;
    public String obj_token;
    public int obj_type;
    public String parent_node_token;

    public CheckShortcutPuller$Params(String r100, String r101, int r102, int r103) {
        this.parent_node_token = r100;
        this.obj_token = r101;
        this.obj_type = r102;
        this.biz_type = r103;
    }
}
