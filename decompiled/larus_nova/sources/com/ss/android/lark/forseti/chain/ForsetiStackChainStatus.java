package com.ss.android.lark.forseti.chain;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/forseti/chain/ForsetiStackChainStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", EffectConstants.NORMAL, "DELETING", "DELETED", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForsetiStackChainStatus extends Enum<ForsetiStackChainStatus> {
    public static final ForsetiStackChainStatus DELETED = null;
    public static final ForsetiStackChainStatus DELETING = null;
    public static final ForsetiStackChainStatus NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForsetiStackChainStatus[] f424391a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f424392b = null;
    private final int value;

    public static EnumEntries<ForsetiStackChainStatus> getEntries() {
        return f424392b;
    }

    static {
        ForsetiStackChainStatus r100 = new ForsetiStackChainStatus(EffectConstants.NORMAL, 0, 1);
        NORMAL = r100;
        ForsetiStackChainStatus r101 = new ForsetiStackChainStatus("DELETING", 1, 2);
        DELETING = r101;
        ForsetiStackChainStatus r102 = new ForsetiStackChainStatus("DELETED", 2, 3);
        DELETED = r102;
        ForsetiStackChainStatus[] r103 = {r100, r101, r102};
        f424391a = r103;
        f424392b = EnumEntriesKt.enumEntries(r103);
    }

    public static ForsetiStackChainStatus[] values() {
        return (ForsetiStackChainStatus[]) f424391a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ForsetiStackChainStatus valueOf(String r100) {
        return (ForsetiStackChainStatus) r27.a.a(ForsetiStackChainStatus.class, r100);
    }

    public ForsetiStackChainStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
