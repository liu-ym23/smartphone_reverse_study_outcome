package com.ss.android.lark.message.action.model;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public class ActionMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f431897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Type f431898b;

    public static final enum Type extends Enum<Type> {
        public static final Type FILE = null;
        public static final Type IMAGE = null;
        public static final Type MEDIA = null;
        public static final Type OTHERS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f431899a = null;

        static {
            Type r100 = new Type("FILE", 0);
            FILE = r100;
            Type r101 = new Type("IMAGE", 1);
            IMAGE = r101;
            Type r102 = new Type("MEDIA", 2);
            MEDIA = r102;
            Type r103 = new Type(AccountType.OTHERS, 3);
            OTHERS = r103;
            f431899a = new Type[]{r100, r101, r102, r103};
        }

        public static Type[] values() {
            return (Type[]) f431899a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ActionMessage() {
    }

    public String getMessageId() {
        return this.f431897a;
    }

    public Type getMessageType() {
        return this.f431898b;
    }

    public void setMessageId(String r100) {
        this.f431897a = r100;
    }

    public void setMessageType(Type r100) {
        this.f431898b = r100;
    }
}
