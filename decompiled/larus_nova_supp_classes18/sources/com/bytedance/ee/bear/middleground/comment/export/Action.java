package com.bytedance.ee.bear.middleground.comment.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/Action;", "", "<init>", "(Ljava/lang/String;I)V", "FETCH", "CHANGE", "PUBLISH", "DELETE", "RESOLVE", "EDIT", "TRANSLATE", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Action extends Enum<Action> {
    public static final Action CHANGE = null;
    public static final Action DELETE = null;
    public static final Action EDIT = null;
    public static final Action FETCH = null;
    public static final Action PUBLISH = null;
    public static final Action RESOLVE = null;
    public static final Action TRANSLATE = null;
    public static final /* synthetic */ Action[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<Action> getEntries() {
        return b;
    }

    static {
        Action r0 = new Action("FETCH", 0);
        FETCH = r0;
        Action r1 = new Action("CHANGE", 1);
        CHANGE = r1;
        Action r3 = new Action("PUBLISH", 2);
        PUBLISH = r3;
        Action r5 = new Action("DELETE", 3);
        DELETE = r5;
        Action r7 = new Action("RESOLVE", 4);
        RESOLVE = r7;
        Action r9 = new Action("EDIT", 5);
        EDIT = r9;
        Action r11 = new Action("TRANSLATE", 6);
        TRANSLATE = r11;
        Action[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static Action[] values() {
        return (Action[]) a.clone();
    }

    public static Action valueOf(String r1) {
        return (Action) r27.a.a(Action.class, r1);
    }

    public Action(String r1, int r2) {
        super(r1, r2);
    }
}
