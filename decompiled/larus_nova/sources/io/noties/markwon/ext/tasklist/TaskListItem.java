package io.noties.markwon.ext.tasklist;

import org.commonmark.node.CustomBlock;

/* JADX INFO: loaded from: classes5.dex */
public class TaskListItem extends CustomBlock {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f492570h;

    @Override // uvc.b
    public final String toString() {
        return "TaskListItem{isDone=" + this.f492570h + '}';
    }

    public TaskListItem(boolean r100) {
        this.f492570h = r100;
    }
}
