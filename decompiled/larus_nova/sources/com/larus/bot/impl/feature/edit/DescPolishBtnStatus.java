package com.larus.bot.impl.feature.edit;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bot/impl/feature/edit/DescPolishBtnStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DISABLE", "ENABLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DescPolishBtnStatus extends Enum<DescPolishBtnStatus> {
    public static final DescPolishBtnStatus DISABLE = null;
    public static final DescPolishBtnStatus ENABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DescPolishBtnStatus[] f318191a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f318192b = null;
    private final int value;

    public static EnumEntries<DescPolishBtnStatus> getEntries() {
        return f318192b;
    }

    static {
        DescPolishBtnStatus r100 = new DescPolishBtnStatus("DISABLE", 0, 0);
        DISABLE = r100;
        DescPolishBtnStatus r101 = new DescPolishBtnStatus("ENABLE", 1, 1);
        ENABLE = r101;
        DescPolishBtnStatus[] r102 = {r100, r101};
        f318191a = r102;
        f318192b = EnumEntriesKt.enumEntries(r102);
    }

    public static DescPolishBtnStatus[] values() {
        return (DescPolishBtnStatus[]) f318191a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DescPolishBtnStatus valueOf(String r100) {
        return (DescPolishBtnStatus) r27.a.a(DescPolishBtnStatus.class, r100);
    }

    public DescPolishBtnStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
