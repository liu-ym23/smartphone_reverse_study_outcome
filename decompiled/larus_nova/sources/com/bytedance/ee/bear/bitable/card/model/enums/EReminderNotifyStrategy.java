package com.bytedance.ee.bear.bitable.card.model.enums;

import android.util.SparseArray;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum EReminderNotifyStrategy extends Enum<EReminderNotifyStrategy> {
    public static final EReminderNotifyStrategy AT_DAT_OF_EVENT = null;
    public static final EReminderNotifyStrategy AT_TIME_OF_EVENT = null;
    public static final EReminderNotifyStrategy BEFORE_15_MINUTE = null;
    public static final EReminderNotifyStrategy BEFORE_1_DAY = null;
    public static final EReminderNotifyStrategy BEFORE_1_HOUR = null;
    public static final EReminderNotifyStrategy BEFORE_1_WEEK = null;
    public static final EReminderNotifyStrategy BEFORE_2_DAY = null;
    public static final EReminderNotifyStrategy BEFORE_2_HOUR = null;
    public static final EReminderNotifyStrategy BEFORE_30_MINUTE = null;
    public static final EReminderNotifyStrategy BEFORE_5_MINUTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<EReminderNotifyStrategy> f207091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EReminderNotifyStrategy[] f207092b = null;
    public int value;

    static {
        int r100 = 0;
        EReminderNotifyStrategy r101 = new EReminderNotifyStrategy("AT_TIME_OF_EVENT", 0, 0);
        AT_TIME_OF_EVENT = r101;
        EReminderNotifyStrategy r102 = new EReminderNotifyStrategy("BEFORE_5_MINUTE", 1, 1);
        BEFORE_5_MINUTE = r102;
        EReminderNotifyStrategy r103 = new EReminderNotifyStrategy("BEFORE_15_MINUTE", 2, 2);
        BEFORE_15_MINUTE = r103;
        EReminderNotifyStrategy r104 = new EReminderNotifyStrategy("BEFORE_30_MINUTE", 3, 3);
        BEFORE_30_MINUTE = r104;
        EReminderNotifyStrategy r105 = new EReminderNotifyStrategy("BEFORE_1_HOUR", 4, 4);
        BEFORE_1_HOUR = r105;
        EReminderNotifyStrategy r106 = new EReminderNotifyStrategy("BEFORE_2_HOUR", 5, 5);
        BEFORE_2_HOUR = r106;
        EReminderNotifyStrategy r110 = new EReminderNotifyStrategy("AT_DAT_OF_EVENT", 6, 6);
        AT_DAT_OF_EVENT = r110;
        EReminderNotifyStrategy r111 = new EReminderNotifyStrategy("BEFORE_1_DAY", 7, 7);
        BEFORE_1_DAY = r111;
        EReminderNotifyStrategy r112 = new EReminderNotifyStrategy("BEFORE_2_DAY", 8, 8);
        BEFORE_2_DAY = r112;
        EReminderNotifyStrategy r113 = new EReminderNotifyStrategy("BEFORE_1_WEEK", 9, 9);
        BEFORE_1_WEEK = r113;
        f207092b = new EReminderNotifyStrategy[]{r101, r102, r103, r104, r105, r106, r110, r111, r112, r113};
        f207091a = new SparseArray();
        EReminderNotifyStrategy[] r107 = values();
        int r108 = r107.length;
    L3:
        if (r100 >= r108) goto L5;
        EReminderNotifyStrategy r109 = r107[r100];
        f207091a.put(r109.value, r109);
        r100 = r100 + 1;
        goto L3
    }

    public static EReminderNotifyStrategy[] values() {
        return (EReminderNotifyStrategy[]) f207092b.clone();
    }

    public static EReminderNotifyStrategy valueOf(int r100) {
        return f207091a.get(r100, AT_TIME_OF_EVENT);
    }

    public static EReminderNotifyStrategy valueOf(String r100) {
        return (EReminderNotifyStrategy) a.a(EReminderNotifyStrategy.class, r100);
    }

    public EReminderNotifyStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
