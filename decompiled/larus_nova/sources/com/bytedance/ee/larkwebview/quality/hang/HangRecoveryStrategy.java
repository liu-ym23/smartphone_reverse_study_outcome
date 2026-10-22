package com.bytedance.ee.larkwebview.quality.hang;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/larkwebview/quality/hang/HangRecoveryStrategy;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "TERMINATE_RENDER_PROCESS", "KILL_SANDBOX_PROCESS", "lark-webview-base_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HangRecoveryStrategy extends Enum<HangRecoveryStrategy> {
    public static final HangRecoveryStrategy KILL_SANDBOX_PROCESS = null;
    public static final HangRecoveryStrategy TERMINATE_RENDER_PROCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HangRecoveryStrategy[] f242903a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242904b = null;
    private final int type;

    public static EnumEntries<HangRecoveryStrategy> getEntries() {
        return f242904b;
    }

    static {
        HangRecoveryStrategy r100 = new HangRecoveryStrategy("TERMINATE_RENDER_PROCESS", 0, 1);
        TERMINATE_RENDER_PROCESS = r100;
        HangRecoveryStrategy r101 = new HangRecoveryStrategy("KILL_SANDBOX_PROCESS", 1, 2);
        KILL_SANDBOX_PROCESS = r101;
        HangRecoveryStrategy[] r102 = {r100, r101};
        f242903a = r102;
        f242904b = EnumEntriesKt.enumEntries(r102);
    }

    public static HangRecoveryStrategy[] values() {
        return (HangRecoveryStrategy[]) f242903a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static HangRecoveryStrategy valueOf(String r100) {
        return (HangRecoveryStrategy) a.a(HangRecoveryStrategy.class, r100);
    }

    public HangRecoveryStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
