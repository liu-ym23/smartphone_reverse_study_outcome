package com.ss.android.lark.message.action.model;

import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum ActionMode extends Enum<ActionMode> {
    public static final ActionMode MULTI = null;
    public static final ActionMode SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionMode[] f431900a = null;

    static {
        ActionMode r100 = new ActionMode("SINGLE", 0);
        SINGLE = r100;
        ActionMode r101 = new ActionMode("MULTI", 1);
        MULTI = r101;
        f431900a = new ActionMode[]{r100, r101};
    }

    public static ActionMode[] values() {
        return (ActionMode[]) f431900a.clone();
    }

    public static ActionMode valueOf(String r100) {
        return (ActionMode) a.a(ActionMode.class, r100);
    }

    public ActionMode(String r100, int r101) {
        super(r100, r101);
    }
}
