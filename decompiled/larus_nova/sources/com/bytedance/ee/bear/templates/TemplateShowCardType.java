package com.bytedance.ee.bear.templates;

/* JADX INFO: loaded from: classes18.dex */
public final enum TemplateShowCardType extends Enum<TemplateShowCardType> {
    public static final TemplateShowCardType SHOW_CARD_TYPE_BLANK = null;
    public static final TemplateShowCardType SHOW_CARD_TYPE_COMMON = null;
    public static final TemplateShowCardType SHOW_CARD_TYPE_EMPTY = null;
    public static final TemplateShowCardType SHOW_CARD_TYPE_FEEDBACK = null;
    public static final TemplateShowCardType SHOW_CARD_TYPE_HEAD = null;
    public static final TemplateShowCardType SHOW_CARD_TYPE_MORE_TEMPLATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TemplateShowCardType[] f238775a = null;

    static {
        TemplateShowCardType r100 = new TemplateShowCardType("SHOW_CARD_TYPE_COMMON", 0);
        SHOW_CARD_TYPE_COMMON = r100;
        TemplateShowCardType r101 = new TemplateShowCardType("SHOW_CARD_TYPE_BLANK", 1);
        SHOW_CARD_TYPE_BLANK = r101;
        TemplateShowCardType r102 = new TemplateShowCardType("SHOW_CARD_TYPE_HEAD", 2);
        SHOW_CARD_TYPE_HEAD = r102;
        TemplateShowCardType r103 = new TemplateShowCardType("SHOW_CARD_TYPE_FEEDBACK", 3);
        SHOW_CARD_TYPE_FEEDBACK = r103;
        TemplateShowCardType r104 = new TemplateShowCardType("SHOW_CARD_TYPE_EMPTY", 4);
        SHOW_CARD_TYPE_EMPTY = r104;
        TemplateShowCardType r105 = new TemplateShowCardType("SHOW_CARD_TYPE_MORE_TEMPLATE", 5);
        SHOW_CARD_TYPE_MORE_TEMPLATE = r105;
        f238775a = new TemplateShowCardType[]{r100, r101, r102, r103, r104, r105};
    }

    public static TemplateShowCardType[] values() {
        return (TemplateShowCardType[]) f238775a.clone();
    }

    public static TemplateShowCardType valueOf(String r100) {
        return (TemplateShowCardType) r27.a.a(TemplateShowCardType.class, r100);
    }

    public TemplateShowCardType(String r100, int r101) {
        super(r100, r101);
    }
}
