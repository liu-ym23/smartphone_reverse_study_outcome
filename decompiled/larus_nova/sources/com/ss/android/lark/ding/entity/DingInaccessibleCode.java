package com.ss.android.lark.ding.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/ding/entity/DingInaccessibleCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "DEFAULT", "EMPTY_NAME", "EMPTY_PHONE", "CROSS_PLATFORM", "NOT_FRIEND", "USER_SETTING_DISABLED", "getValue", "Companion", "ding-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DingInaccessibleCode extends Enum<DingInaccessibleCode> {
    public static final DingInaccessibleCode CROSS_PLATFORM = null;
    public static final a Companion = null;
    public static final DingInaccessibleCode DEFAULT = null;
    public static final DingInaccessibleCode EMPTY_NAME = null;
    public static final DingInaccessibleCode EMPTY_PHONE = null;
    public static final DingInaccessibleCode NOT_FRIEND = null;
    public static final DingInaccessibleCode USER_SETTING_DISABLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DingInaccessibleCode[] f420399a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420400b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DingInaccessibleCode> getEntries() {
        return f420400b;
    }

    static {
        DingInaccessibleCode r100 = new DingInaccessibleCode("DEFAULT", 0, 0);
        DEFAULT = r100;
        DingInaccessibleCode r101 = new DingInaccessibleCode("EMPTY_NAME", 1, 1);
        EMPTY_NAME = r101;
        DingInaccessibleCode r102 = new DingInaccessibleCode("EMPTY_PHONE", 2, 2);
        EMPTY_PHONE = r102;
        DingInaccessibleCode r103 = new DingInaccessibleCode("CROSS_PLATFORM", 3, 3);
        CROSS_PLATFORM = r103;
        DingInaccessibleCode r104 = new DingInaccessibleCode("NOT_FRIEND", 4, 4);
        NOT_FRIEND = r104;
        DingInaccessibleCode r105 = new DingInaccessibleCode("USER_SETTING_DISABLED", 5, 5);
        USER_SETTING_DISABLED = r105;
        DingInaccessibleCode[] r110 = {r100, r101, r102, r103, r104, r105};
        f420399a = r110;
        f420400b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static DingInaccessibleCode[] values() {
        return (DingInaccessibleCode[]) f420399a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DingInaccessibleCode valueOf(String r100) {
        return (DingInaccessibleCode) r27.a.a(DingInaccessibleCode.class, r100);
    }

    public DingInaccessibleCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
