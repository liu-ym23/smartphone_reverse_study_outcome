package com.larus.bmhome.social.userchat.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/social/userchat/model/LoadState;", "", "<init>", "(Ljava/lang/String;I)V", "READY_TO_LOAD", "LOADING", "COMPLETE", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum LoadState extends Enum<LoadState> {
    public static final LoadState COMPLETE = null;
    public static final LoadState LOADING = null;
    public static final LoadState READY_TO_LOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadState[] f314104a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314105b = null;

    public static EnumEntries<LoadState> getEntries() {
        return f314105b;
    }

    static {
        LoadState r100 = new LoadState("READY_TO_LOAD", 0);
        READY_TO_LOAD = r100;
        LoadState r101 = new LoadState("LOADING", 1);
        LOADING = r101;
        LoadState r102 = new LoadState("COMPLETE", 2);
        COMPLETE = r102;
        LoadState[] r103 = {r100, r101, r102};
        f314104a = r103;
        f314105b = EnumEntriesKt.enumEntries(r103);
    }

    public static LoadState[] values() {
        return (LoadState[]) f314104a.clone();
    }

    public static LoadState valueOf(String r100) {
        return (LoadState) r27.a.a(LoadState.class, r100);
    }

    public LoadState(String r100, int r101) {
        super(r100, r101);
    }
}
