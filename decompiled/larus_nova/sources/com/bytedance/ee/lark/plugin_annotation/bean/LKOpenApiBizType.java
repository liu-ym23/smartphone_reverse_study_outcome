package com.bytedance.ee.lark.plugin_annotation.bean;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum LKOpenApiBizType extends Enum<LKOpenApiBizType> {
    public static final LKOpenApiBizType ALL = null;
    public static final LKOpenApiBizType BLOCK = null;
    public static final LKOpenApiBizType GADGET = null;
    public static final LKOpenApiBizType WEB = null;
    public static final LKOpenApiBizType WEB_APP = null;
    public static final LKOpenApiBizType WIDGET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LKOpenApiBizType[] f242839a = null;

    static {
        LKOpenApiBizType r100 = new LKOpenApiBizType("WEB", 0);
        WEB = r100;
        LKOpenApiBizType r101 = new LKOpenApiBizType("WEB_APP", 1);
        WEB_APP = r101;
        LKOpenApiBizType r102 = new LKOpenApiBizType("GADGET", 2);
        GADGET = r102;
        LKOpenApiBizType r103 = new LKOpenApiBizType("BLOCK", 3);
        BLOCK = r103;
        LKOpenApiBizType r104 = new LKOpenApiBizType("WIDGET", 4);
        WIDGET = r104;
        LKOpenApiBizType r105 = new LKOpenApiBizType(AccountType.ALL, 5);
        ALL = r105;
        f242839a = new LKOpenApiBizType[]{r100, r101, r102, r103, r104, r105};
    }

    public static LKOpenApiBizType[] values() {
        return (LKOpenApiBizType[]) f242839a.clone();
    }

    public static LKOpenApiBizType valueOf(String r100) {
        return (LKOpenApiBizType) a.a(LKOpenApiBizType.class, r100);
    }

    public LKOpenApiBizType(String r100, int r101) {
        super(r100, r101);
    }
}
