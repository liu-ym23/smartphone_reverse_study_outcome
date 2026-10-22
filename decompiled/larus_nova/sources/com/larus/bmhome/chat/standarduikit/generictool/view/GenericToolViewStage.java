package com.larus.bmhome.chat.standarduikit.generictool.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/generictool/view/GenericToolViewStage;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "FINISHED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GenericToolViewStage extends Enum<GenericToolViewStage> {
    public static final GenericToolViewStage FINISHED = null;
    public static final GenericToolViewStage LOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GenericToolViewStage[] f309178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f309179b = null;

    public static EnumEntries<GenericToolViewStage> getEntries() {
        return f309179b;
    }

    static {
        GenericToolViewStage r100 = new GenericToolViewStage("LOADING", 0);
        LOADING = r100;
        GenericToolViewStage r101 = new GenericToolViewStage("FINISHED", 1);
        FINISHED = r101;
        GenericToolViewStage[] r102 = {r100, r101};
        f309178a = r102;
        f309179b = EnumEntriesKt.enumEntries(r102);
    }

    public static GenericToolViewStage[] values() {
        return (GenericToolViewStage[]) f309178a.clone();
    }

    public static GenericToolViewStage valueOf(String r100) {
        return (GenericToolViewStage) a.a(GenericToolViewStage.class, r100);
    }

    public GenericToolViewStage(String r100, int r101) {
        super(r100, r101);
    }
}
