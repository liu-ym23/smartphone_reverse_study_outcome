package com.bytedance.ee.bear.templates;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum TemplateShowCardType extends Enum<TemplateShowCardType> {
    public static final TemplateShowCardType SHOW_CARD_TYPE_BLANK = null;
    public static final TemplateShowCardType SHOW_CARD_TYPE_COMMON = null;
    public static final TemplateShowCardType SHOW_CARD_TYPE_EMPTY = null;
    public static final TemplateShowCardType SHOW_CARD_TYPE_FEEDBACK = null;
    public static final TemplateShowCardType SHOW_CARD_TYPE_HEAD = null;
    public static final TemplateShowCardType SHOW_CARD_TYPE_MORE_TEMPLATE = null;
    public static final /* synthetic */ TemplateShowCardType[] a = null;

    static {
        TemplateShowCardType r0 = new TemplateShowCardType("SHOW_CARD_TYPE_COMMON", 0);
        SHOW_CARD_TYPE_COMMON = r0;
        TemplateShowCardType r1 = new TemplateShowCardType("SHOW_CARD_TYPE_BLANK", 1);
        SHOW_CARD_TYPE_BLANK = r1;
        TemplateShowCardType r3 = new TemplateShowCardType("SHOW_CARD_TYPE_HEAD", 2);
        SHOW_CARD_TYPE_HEAD = r3;
        TemplateShowCardType r5 = new TemplateShowCardType("SHOW_CARD_TYPE_FEEDBACK", 3);
        SHOW_CARD_TYPE_FEEDBACK = r5;
        TemplateShowCardType r7 = new TemplateShowCardType("SHOW_CARD_TYPE_EMPTY", 4);
        SHOW_CARD_TYPE_EMPTY = r7;
        TemplateShowCardType r9 = new TemplateShowCardType("SHOW_CARD_TYPE_MORE_TEMPLATE", 5);
        SHOW_CARD_TYPE_MORE_TEMPLATE = r9;
        a = new TemplateShowCardType[]{r0, r1, r3, r5, r7, r9};
    }

    public static TemplateShowCardType[] values() {
        return (TemplateShowCardType[]) a.clone();
    }

    public static TemplateShowCardType valueOf(String r1) {
        return (TemplateShowCardType) r27.a.a(TemplateShowCardType.class, r1);
    }

    public TemplateShowCardType(String r1, int r2) {
        super(r1, r2);
    }
}
