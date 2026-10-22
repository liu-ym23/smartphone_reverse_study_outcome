package com.bytedance.ee.bear.list.move.api;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class SpaceMoveToWikiStatusPuller$MoveObj implements NonProguard {
    public String obj_token;
    public int obj_type;
    public int status;
    public String wiki_token;

    public SpaceMoveToWikiStatusPuller$MoveObj() {
    }

    public String toString() {
        return "MoveObj{obj_token='" + yu5.c.j(this.obj_token) + "', obj_type='" + this.obj_type + "', status='" + this.status + "', wiki_token='" + yu5.c.j(this.wiki_token) + "'}";
    }
}
