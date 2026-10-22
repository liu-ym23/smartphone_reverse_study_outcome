package com.larus.larkfeed.impl.gallery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/larkfeed/impl/gallery/PreviewState;", "", "<init>", "(Ljava/lang/String;I)V", "Allow", "Loading", "Deny", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewState extends Enum<PreviewState> {
    public static final PreviewState Allow = null;
    public static final PreviewState Deny = null;
    public static final PreviewState Loading = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewState[] f355190a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f355191b = null;

    public static EnumEntries<PreviewState> getEntries() {
        return f355191b;
    }

    static {
        PreviewState r100 = new PreviewState("Allow", 0);
        Allow = r100;
        PreviewState r101 = new PreviewState("Loading", 1);
        Loading = r101;
        PreviewState r102 = new PreviewState("Deny", 2);
        Deny = r102;
        PreviewState[] r103 = {r100, r101, r102};
        f355190a = r103;
        f355191b = EnumEntriesKt.enumEntries(r103);
    }

    public static PreviewState[] values() {
        return (PreviewState[]) f355190a.clone();
    }

    public static PreviewState valueOf(String r100) {
        return (PreviewState) r27.a.a(PreviewState.class, r100);
    }

    public PreviewState(String r100, int r101) {
        super(r100, r101);
    }
}
