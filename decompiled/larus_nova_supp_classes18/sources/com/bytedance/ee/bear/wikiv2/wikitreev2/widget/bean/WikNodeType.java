package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/WikNodeType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TITLE_ROOT", "TITLE", "SPACE", "DOCUMENT", "ROOT", "DIR", "LEAF", "NONE", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WikNodeType extends Enum<WikNodeType> {
    public static final WikNodeType DIR = null;
    public static final WikNodeType DOCUMENT = null;
    public static final WikNodeType LEAF = null;
    public static final WikNodeType NONE = null;
    public static final WikNodeType ROOT = null;
    public static final WikNodeType SPACE = null;
    public static final WikNodeType TITLE = null;
    public static final WikNodeType TITLE_ROOT = null;
    public static final /* synthetic */ WikNodeType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<WikNodeType> getEntries() {
        return b;
    }

    static {
        WikNodeType r0 = new WikNodeType("TITLE_ROOT", 0, -4);
        TITLE_ROOT = r0;
        WikNodeType r1 = new WikNodeType("TITLE", 1, -3);
        TITLE = r1;
        WikNodeType r2 = new WikNodeType("SPACE", 2, -2);
        SPACE = r2;
        WikNodeType r4 = new WikNodeType("DOCUMENT", 3, -1);
        DOCUMENT = r4;
        WikNodeType r6 = new WikNodeType("ROOT", 4, 0);
        ROOT = r6;
        WikNodeType r8 = new WikNodeType("DIR", 5, 2);
        DIR = r8;
        WikNodeType r11 = new WikNodeType("LEAF", 6, 3);
        LEAF = r11;
        WikNodeType r13 = new WikNodeType("NONE", 7, 4);
        NONE = r13;
        WikNodeType[] r15 = {r0, r1, r2, r4, r6, r8, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static WikNodeType[] values() {
        return (WikNodeType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static WikNodeType valueOf(String r1) {
        return (WikNodeType) r27.a.a(WikNodeType.class, r1);
    }

    public WikNodeType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
