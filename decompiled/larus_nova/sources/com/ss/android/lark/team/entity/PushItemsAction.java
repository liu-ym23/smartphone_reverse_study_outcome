package com.ss.android.lark.team.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/team/entity/PushItemsAction;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "UPDATE", "DELETE", "Companion", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PushItemsAction extends Enum<PushItemsAction> {
    public static final a Companion = null;
    public static final PushItemsAction DELETE = null;
    public static final PushItemsAction UNKNOWN = null;
    public static final PushItemsAction UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PushItemsAction[] f441172a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441173b = null;
    public final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<PushItemsAction> getEntries() {
        return f441173b;
    }

    static {
        PushItemsAction r100 = new PushItemsAction("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        PushItemsAction r101 = new PushItemsAction("UPDATE", 1, 1);
        UPDATE = r101;
        PushItemsAction r102 = new PushItemsAction("DELETE", 2, 2);
        DELETE = r102;
        PushItemsAction[] r103 = {r100, r101, r102};
        f441172a = r103;
        f441173b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static PushItemsAction[] values() {
        return (PushItemsAction[]) f441172a.clone();
    }

    @JvmStatic
    public static final PushItemsAction fromValue(int r100) {
        Companion.getClass();
        PushItemsAction r101 = UPDATE;
        if (r100 == r101.value) goto L10;
        PushItemsAction r102 = DELETE;
        if (r100 != r102.value) goto L9;
        return r102;
    L9:
        return UNKNOWN;
    L10:
        return r101;
    }

    public static PushItemsAction valueOf(String r100) {
        return (PushItemsAction) r27.a.a(PushItemsAction.class, r100);
    }

    public PushItemsAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
