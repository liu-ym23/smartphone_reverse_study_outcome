package com.larus.business.debug.base.register;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/business/debug/base/register/EntranceType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "BUTTON", "SWITCH", "SPINNER", "INPUT", CardAdapter.TEXT, "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EntranceType extends Enum<EntranceType> {
    public static final EntranceType BUTTON = null;
    public static final EntranceType INPUT = null;
    public static final EntranceType SPINNER = null;
    public static final EntranceType SWITCH = null;
    public static final EntranceType TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntranceType[] f320068a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f320069b = null;
    private final int type;

    public static EnumEntries<EntranceType> getEntries() {
        return f320069b;
    }

    static {
        EntranceType r100 = new EntranceType("BUTTON", 0, 0);
        BUTTON = r100;
        EntranceType r101 = new EntranceType("SWITCH", 1, 1);
        SWITCH = r101;
        EntranceType r102 = new EntranceType("SPINNER", 2, 2);
        SPINNER = r102;
        EntranceType r103 = new EntranceType("INPUT", 3, 3);
        INPUT = r103;
        EntranceType r104 = new EntranceType(CardAdapter.TEXT, 4, 4);
        TEXT = r104;
        EntranceType[] r105 = {r100, r101, r102, r103, r104};
        f320068a = r105;
        f320069b = EnumEntriesKt.enumEntries(r105);
    }

    public static EntranceType[] values() {
        return (EntranceType[]) f320068a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static EntranceType valueOf(String r100) {
        return (EntranceType) a.a(EntranceType.class, r100);
    }

    public EntranceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
