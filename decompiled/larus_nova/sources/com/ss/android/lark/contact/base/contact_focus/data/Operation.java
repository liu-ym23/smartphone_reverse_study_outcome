package com.ss.android.lark.contact.base.contact_focus.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/contact/base/contact_focus/data/Operation;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ADD", "DELETE", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Operation extends Enum<Operation> {
    public static final Operation ADD = null;
    public static final Operation DELETE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Operation[] f418568a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f418569b = null;
    private final int value;

    public static EnumEntries<Operation> getEntries() {
        return f418569b;
    }

    static {
        Operation r100 = new Operation("ADD", 0, 0);
        ADD = r100;
        Operation r101 = new Operation("DELETE", 1, 1);
        DELETE = r101;
        Operation[] r102 = {r100, r101};
        f418568a = r102;
        f418569b = EnumEntriesKt.enumEntries(r102);
    }

    public static Operation[] values() {
        return (Operation[]) f418568a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Operation valueOf(String r100) {
        return (Operation) a.a(Operation.class, r100);
    }

    public Operation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
