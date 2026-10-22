package com.larus.home.impl.reddot.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/home/impl/reddot/api/RedDotAction;", "", "index", "", "<init>", "(Ljava/lang/String;II)V", "getIndex", "()I", "Set", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RedDotAction extends Enum<RedDotAction> {
    public static final RedDotAction Set = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RedDotAction[] f346025a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346026b = null;
    private final int index;

    public static EnumEntries<RedDotAction> getEntries() {
        return f346026b;
    }

    static {
        RedDotAction r100 = new RedDotAction();
        Set = r100;
        RedDotAction[] r101 = {r100};
        f346025a = r101;
        f346026b = EnumEntriesKt.enumEntries(r101);
    }

    public RedDotAction() {
        super("Set", 0);
        this.index = 1;
    }

    public static RedDotAction[] values() {
        return (RedDotAction[]) f346025a.clone();
    }

    public final int getIndex() {
        return this.index;
    }

    public static RedDotAction valueOf(String r100) {
        return (RedDotAction) a.a(RedDotAction.class, r100);
    }
}
