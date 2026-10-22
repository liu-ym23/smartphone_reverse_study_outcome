package com.bytedance.ee.bear.list.move.api;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public class SpaceMoveToWikiStatusPuller$Result implements NonProguard {
    public ArrayList<SpaceMoveToWikiStatusPuller$MoveObj> move_objs;
    public String task_id;
    public int task_status;

    public SpaceMoveToWikiStatusPuller$Result() {
    }

    public String toString() {
        return "Result{task_id='" + yu5.c.j(this.task_id) + "', status=" + this.task_status + ", move_objs=" + this.move_objs + '}';
    }
}
