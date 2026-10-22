package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiAction;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "INIT_LOAD", "RELOAD", "EXPAND", "COLLAPSE", "ADD", "DEL", "DEL_CURRENT_ONLY", "FAVORITE", "UNFAVORITE", "PIN", "UNPIN", "MOV", "SHORTCUT", "MAKE_COPY", "RENAME", "REFRESH", "PUSH_ADD", "PUSH_BATCH_ADD", "PUSH_DEL", "PUSH_MOV", "PUSH_BATCH_MOV", "PUSH_UDE_NAME_ICON", "PUSH_UDE_NODE_PERM", "PUSH_DES", "PUSH_FAVORITE", "PUSH_TOKEN", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WikiAction extends Enum<WikiAction> {
    public static final WikiAction ADD = null;
    public static final WikiAction COLLAPSE = null;
    public static final WikiAction DEL = null;
    public static final WikiAction DEL_CURRENT_ONLY = null;
    public static final WikiAction EXPAND = null;
    public static final WikiAction FAVORITE = null;
    public static final WikiAction INIT_LOAD = null;
    public static final WikiAction MAKE_COPY = null;
    public static final WikiAction MOV = null;
    public static final WikiAction PIN = null;
    public static final WikiAction PUSH_ADD = null;
    public static final WikiAction PUSH_BATCH_ADD = null;
    public static final WikiAction PUSH_BATCH_MOV = null;
    public static final WikiAction PUSH_DEL = null;
    public static final WikiAction PUSH_DES = null;
    public static final WikiAction PUSH_FAVORITE = null;
    public static final WikiAction PUSH_MOV = null;
    public static final WikiAction PUSH_TOKEN = null;
    public static final WikiAction PUSH_UDE_NAME_ICON = null;
    public static final WikiAction PUSH_UDE_NODE_PERM = null;
    public static final WikiAction REFRESH = null;
    public static final WikiAction RELOAD = null;
    public static final WikiAction RENAME = null;
    public static final WikiAction SHORTCUT = null;
    public static final WikiAction UNFAVORITE = null;
    public static final WikiAction UNKNOWN = null;
    public static final WikiAction UNPIN = null;
    public static final /* synthetic */ WikiAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<WikiAction> getEntries() {
        return b;
    }

    static {
        WikiAction r0 = new WikiAction("UNKNOWN", 0);
        UNKNOWN = r0;
        WikiAction r1 = new WikiAction("INIT_LOAD", 1);
        INIT_LOAD = r1;
        WikiAction r3 = new WikiAction("RELOAD", 2);
        RELOAD = r3;
        WikiAction r5 = new WikiAction("EXPAND", 3);
        EXPAND = r5;
        WikiAction r7 = new WikiAction("COLLAPSE", 4);
        COLLAPSE = r7;
        WikiAction r9 = new WikiAction("ADD", 5);
        ADD = r9;
        WikiAction r11 = new WikiAction("DEL", 6);
        DEL = r11;
        WikiAction r13 = new WikiAction("DEL_CURRENT_ONLY", 7);
        DEL_CURRENT_ONLY = r13;
        WikiAction r15 = new WikiAction("FAVORITE", 8);
        FAVORITE = r15;
        WikiAction r14 = new WikiAction("UNFAVORITE", 9);
        UNFAVORITE = r14;
        WikiAction r12 = new WikiAction("PIN", 10);
        PIN = r12;
        WikiAction r10 = new WikiAction("UNPIN", 11);
        UNPIN = r10;
        WikiAction r8 = new WikiAction("MOV", 12);
        MOV = r8;
        WikiAction r6 = new WikiAction("SHORTCUT", 13);
        SHORTCUT = r6;
        WikiAction r4 = new WikiAction("MAKE_COPY", 14);
        MAKE_COPY = r4;
        WikiAction r2 = new WikiAction("RENAME", 15);
        RENAME = r2;
        WikiAction r16 = new WikiAction("REFRESH", 16);
        REFRESH = r16;
        WikiAction r17 = new WikiAction("PUSH_ADD", 17);
        PUSH_ADD = r17;
        WikiAction r18 = new WikiAction("PUSH_BATCH_ADD", 18);
        PUSH_BATCH_ADD = r18;
        WikiAction r19 = new WikiAction("PUSH_DEL", 19);
        PUSH_DEL = r19;
        WikiAction r20 = new WikiAction("PUSH_MOV", 20);
        PUSH_MOV = r20;
        WikiAction r21 = new WikiAction("PUSH_BATCH_MOV", 21);
        PUSH_BATCH_MOV = r21;
        WikiAction r22 = new WikiAction("PUSH_UDE_NAME_ICON", 22);
        PUSH_UDE_NAME_ICON = r22;
        WikiAction r23 = new WikiAction("PUSH_UDE_NODE_PERM", 23);
        PUSH_UDE_NODE_PERM = r23;
        WikiAction r24 = new WikiAction("PUSH_DES", 24);
        PUSH_DES = r24;
        WikiAction r25 = new WikiAction("PUSH_FAVORITE", 25);
        PUSH_FAVORITE = r25;
        WikiAction r26 = new WikiAction("PUSH_TOKEN", 26);
        PUSH_TOKEN = r26;
        WikiAction[] r27 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26};
        a = r27;
        b = EnumEntriesKt.enumEntries(r27);
    }

    public static WikiAction[] values() {
        return (WikiAction[]) a.clone();
    }

    public static WikiAction valueOf(String r1) {
        return (WikiAction) r27.a.a(WikiAction.class, r1);
    }

    public WikiAction(String r1, int r2) {
        super(r1, r2);
    }
}
