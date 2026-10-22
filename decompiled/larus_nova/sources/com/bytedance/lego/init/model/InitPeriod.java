package com.bytedance.lego.init.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes.dex */
public final enum InitPeriod extends Enum<InitPeriod> implements Serializable {
    public static final InitPeriod APP_ATTACHBASE2SUPER = null;
    public static final InitPeriod APP_ONCREATE2SUPER = null;
    public static final InitPeriod APP_SUPER2ATTACHBASEEND = null;
    public static final InitPeriod APP_SUPER2ONCREATEEND = null;
    public static final InitPeriod MAIN_ONCREATE2SUPER = null;
    public static final InitPeriod MAIN_ONRESUME2SUPER = null;
    public static final InitPeriod MAIN_SUPER2ONCREATEEND = null;
    public static final InitPeriod MAIN_SUPER2ONRESUMEEND = null;
    public static final InitPeriod NONE = null;
    public static final InitPeriod SPLASH_ONCREATE2SUPER = null;
    public static final InitPeriod SPLASH_ONRESUME2SUPER = null;
    public static final InitPeriod SPLASH_SUPER2ONCREATEEND = null;
    public static final InitPeriod SPLASH_SUPER2ONRESUMEEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InitPeriod[] f254535a = null;
    private int value;

    static {
        InitPeriod r100 = new InitPeriod("APP_ATTACHBASE2SUPER", 0, 0);
        APP_ATTACHBASE2SUPER = r100;
        InitPeriod r101 = new InitPeriod("APP_SUPER2ATTACHBASEEND", 1, 1);
        APP_SUPER2ATTACHBASEEND = r101;
        InitPeriod r102 = new InitPeriod("APP_ONCREATE2SUPER", 2, 2);
        APP_ONCREATE2SUPER = r102;
        InitPeriod r103 = new InitPeriod("APP_SUPER2ONCREATEEND", 3, 3);
        APP_SUPER2ONCREATEEND = r103;
        InitPeriod r104 = new InitPeriod("SPLASH_ONCREATE2SUPER", 4, 4);
        SPLASH_ONCREATE2SUPER = r104;
        InitPeriod r105 = new InitPeriod("SPLASH_SUPER2ONCREATEEND", 5, 5);
        SPLASH_SUPER2ONCREATEEND = r105;
        InitPeriod r110 = new InitPeriod("SPLASH_ONRESUME2SUPER", 6, 6);
        SPLASH_ONRESUME2SUPER = r110;
        InitPeriod r111 = new InitPeriod("SPLASH_SUPER2ONRESUMEEND", 7, 7);
        SPLASH_SUPER2ONRESUMEEND = r111;
        InitPeriod r112 = new InitPeriod("MAIN_ONCREATE2SUPER", 8, 8);
        MAIN_ONCREATE2SUPER = r112;
        InitPeriod r113 = new InitPeriod("MAIN_SUPER2ONCREATEEND", 9, 9);
        MAIN_SUPER2ONCREATEEND = r113;
        InitPeriod r114 = new InitPeriod("MAIN_ONRESUME2SUPER", 10, 10);
        MAIN_ONRESUME2SUPER = r114;
        InitPeriod r115 = new InitPeriod("MAIN_SUPER2ONRESUMEEND", 11, 11);
        MAIN_SUPER2ONRESUMEEND = r115;
        InitPeriod r106 = new InitPeriod(UserProfileEvent.POSITION_NONE, 12, 12);
        NONE = r106;
        f254535a = new InitPeriod[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
    }

    public static InitPeriod[] values() {
        return (InitPeriod[]) f254535a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static InitPeriod valueOf(String r100) {
        return (InitPeriod) a.a(InitPeriod.class, r100);
    }

    public InitPeriod(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
