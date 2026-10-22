package com.ss.android.lark.message.action.model;

import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public class ActionContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionChat f431894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ActionMode f431895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<ActionMessage> f431896c;

    public ActionContext() {
    }

    public ActionChat getActionChat() {
        return this.f431894a;
    }

    public List<ActionMessage> getActionMessages() {
        return this.f431896c;
    }

    public ActionMode getActionMode() {
        return this.f431895b;
    }

    public void setActionChat(ActionChat r100) {
        this.f431894a = r100;
    }

    public void setActionMessages(List<ActionMessage> r100) {
        this.f431896c = r100;
    }

    public void setActionMode(ActionMode r100) {
        this.f431895b = r100;
    }
}
