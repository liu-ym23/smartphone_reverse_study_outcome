package com.ss.android.lark.api.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/api/bean/ForsetiNodeMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL_R", "FULL_R", "INVISIBLE_R", "NORMAL_C", "INVISIBLE_C", "STACK_R", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForsetiNodeMode extends Enum<ForsetiNodeMode> {
    public static final ForsetiNodeMode FULL_R = null;
    public static final ForsetiNodeMode INVISIBLE_C = null;
    public static final ForsetiNodeMode INVISIBLE_R = null;
    public static final ForsetiNodeMode NORMAL_C = null;
    public static final ForsetiNodeMode NORMAL_R = null;
    public static final ForsetiNodeMode STACK_R = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForsetiNodeMode[] f408648a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f408649b = null;

    public static EnumEntries<ForsetiNodeMode> getEntries() {
        return f408649b;
    }

    static {
        ForsetiNodeMode r100 = new ForsetiNodeMode("NORMAL_R", 0);
        NORMAL_R = r100;
        ForsetiNodeMode r101 = new ForsetiNodeMode("FULL_R", 1);
        FULL_R = r101;
        ForsetiNodeMode r102 = new ForsetiNodeMode("INVISIBLE_R", 2);
        INVISIBLE_R = r102;
        ForsetiNodeMode r103 = new ForsetiNodeMode("NORMAL_C", 3);
        NORMAL_C = r103;
        ForsetiNodeMode r104 = new ForsetiNodeMode("INVISIBLE_C", 4);
        INVISIBLE_C = r104;
        ForsetiNodeMode r105 = new ForsetiNodeMode("STACK_R", 5);
        STACK_R = r105;
        ForsetiNodeMode[] r110 = {r100, r101, r102, r103, r104, r105};
        f408648a = r110;
        f408649b = EnumEntriesKt.enumEntries(r110);
    }

    public static ForsetiNodeMode[] values() {
        return (ForsetiNodeMode[]) f408648a.clone();
    }

    public static ForsetiNodeMode valueOf(String r100) {
        return (ForsetiNodeMode) a.a(ForsetiNodeMode.class, r100);
    }

    public ForsetiNodeMode(String r100, int r101) {
        super(r100, r101);
    }
}
