package com.larksuite.framework.launch.task;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final enum Period extends Enum<Period> {
    public static final Period APP_ONATTACHBASECONTEXT_AFTER_SUPER = null;
    public static final Period APP_ONATTACHBASECONTEXT_BEFORE_SUPER = null;
    public static final Period APP_ONATTACHBASECONTEXT_BEGIN = null;
    public static final Period APP_ONATTACHBASECONTEXT_END = null;
    public static final Period APP_ONCREATE_AFTER_SUPER = null;
    public static final Period APP_ONCREATE_BEFORE_SUPER = null;
    public static final Period APP_ONCREATE_BEGIN = null;
    public static final Period APP_ONCREATE_END = null;
    public static final Period APP_ON_CPU_IDLE = null;
    public static final Period APP_ON_FIRST_SCREEN_SHOWED = null;
    public static final Period NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Period[] f285672a = null;
    private int value;

    static {
        Period r100 = new Period("APP_ONATTACHBASECONTEXT_BEGIN", 0, 0);
        APP_ONATTACHBASECONTEXT_BEGIN = r100;
        Period r101 = new Period("APP_ONATTACHBASECONTEXT_BEFORE_SUPER", 1, 1);
        APP_ONATTACHBASECONTEXT_BEFORE_SUPER = r101;
        Period r102 = new Period("APP_ONATTACHBASECONTEXT_AFTER_SUPER", 2, 2);
        APP_ONATTACHBASECONTEXT_AFTER_SUPER = r102;
        Period r103 = new Period("APP_ONATTACHBASECONTEXT_END", 3, 3);
        APP_ONATTACHBASECONTEXT_END = r103;
        Period r104 = new Period("APP_ONCREATE_BEGIN", 4, 4);
        APP_ONCREATE_BEGIN = r104;
        Period r105 = new Period("APP_ONCREATE_BEFORE_SUPER", 5, 5);
        APP_ONCREATE_BEFORE_SUPER = r105;
        Period r110 = new Period("APP_ONCREATE_AFTER_SUPER", 6, 6);
        APP_ONCREATE_AFTER_SUPER = r110;
        Period r111 = new Period("APP_ONCREATE_END", 7, 7);
        APP_ONCREATE_END = r111;
        Period r112 = new Period("APP_ON_FIRST_SCREEN_SHOWED", 8, 8);
        APP_ON_FIRST_SCREEN_SHOWED = r112;
        Period r113 = new Period("APP_ON_CPU_IDLE", 9, 9);
        APP_ON_CPU_IDLE = r113;
        Period r114 = new Period(UserProfileEvent.POSITION_NONE, 10, 1000);
        NONE = r114;
        f285672a = new Period[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public static Period[] values() {
        return (Period[]) f285672a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static Period forNumber(int r100) {
        switch(r100) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        return NONE;
    L6:
        return APP_ON_CPU_IDLE;
    L8:
        return APP_ON_FIRST_SCREEN_SHOWED;
    L10:
        return APP_ONCREATE_END;
    L12:
        return APP_ONCREATE_AFTER_SUPER;
    L14:
        return APP_ONCREATE_BEFORE_SUPER;
    L16:
        return APP_ONCREATE_BEGIN;
    L18:
        return APP_ONATTACHBASECONTEXT_END;
    L20:
        return APP_ONATTACHBASECONTEXT_AFTER_SUPER;
    L22:
        return APP_ONATTACHBASECONTEXT_BEFORE_SUPER;
    L24:
        return APP_ONATTACHBASECONTEXT_BEGIN;
    }

    public static Period valueOf(String r100) {
        return (Period) a.a(Period.class, r100);
    }

    public Period(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
