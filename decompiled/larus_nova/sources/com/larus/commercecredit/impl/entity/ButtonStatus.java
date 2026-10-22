package com.larus.commercecredit.impl.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/commercecredit/impl/entity/ButtonStatus;", "", "status", "", "<init>", "(Ljava/lang/String;II)V", "getStatus", "()I", "BUTTON_STATUS_UNFINISHED", "BUTTON_STATUS_FINISHED", "BUTTON_STATUS_ONGOING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ButtonStatus extends Enum<ButtonStatus> {
    public static final ButtonStatus BUTTON_STATUS_FINISHED = null;
    public static final ButtonStatus BUTTON_STATUS_ONGOING = null;
    public static final ButtonStatus BUTTON_STATUS_UNFINISHED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ButtonStatus[] f325715a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f325716b = null;
    private final int status;

    public static EnumEntries<ButtonStatus> getEntries() {
        return f325716b;
    }

    static {
        ButtonStatus r100 = new ButtonStatus("BUTTON_STATUS_UNFINISHED", 0, 1);
        BUTTON_STATUS_UNFINISHED = r100;
        ButtonStatus r101 = new ButtonStatus("BUTTON_STATUS_FINISHED", 1, 2);
        BUTTON_STATUS_FINISHED = r101;
        ButtonStatus r102 = new ButtonStatus("BUTTON_STATUS_ONGOING", 2, 3);
        BUTTON_STATUS_ONGOING = r102;
        ButtonStatus[] r103 = {r100, r101, r102};
        f325715a = r103;
        f325716b = EnumEntriesKt.enumEntries(r103);
    }

    public static ButtonStatus[] values() {
        return (ButtonStatus[]) f325715a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public static ButtonStatus valueOf(String r100) {
        return (ButtonStatus) a.a(ButtonStatus.class, r100);
    }

    public ButtonStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
