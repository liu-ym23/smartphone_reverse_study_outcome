package com.bytedance.ee.bear.middleground.comment.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/Action;", "", "<init>", "(Ljava/lang/String;I)V", "FETCH", "CHANGE", "PUBLISH", "DELETE", "RESOLVE", "EDIT", "TRANSLATE", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Action extends Enum<Action> {
    public static final Action CHANGE = null;
    public static final Action DELETE = null;
    public static final Action EDIT = null;
    public static final Action FETCH = null;
    public static final Action PUBLISH = null;
    public static final Action RESOLVE = null;
    public static final Action TRANSLATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Action[] f231300a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f231301b = null;

    public static EnumEntries<Action> getEntries() {
        return f231301b;
    }

    static {
        Action r100 = new Action("FETCH", 0);
        FETCH = r100;
        Action r101 = new Action("CHANGE", 1);
        CHANGE = r101;
        Action r102 = new Action("PUBLISH", 2);
        PUBLISH = r102;
        Action r103 = new Action("DELETE", 3);
        DELETE = r103;
        Action r104 = new Action("RESOLVE", 4);
        RESOLVE = r104;
        Action r105 = new Action("EDIT", 5);
        EDIT = r105;
        Action r110 = new Action("TRANSLATE", 6);
        TRANSLATE = r110;
        Action[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f231300a = r111;
        f231301b = EnumEntriesKt.enumEntries(r111);
    }

    public static Action[] values() {
        return (Action[]) f231300a.clone();
    }

    public static Action valueOf(String r100) {
        return (Action) r27.a.a(Action.class, r100);
    }

    public Action(String r100, int r101) {
        super(r100, r101);
    }
}
