package com.bytedance.ee.bear.secret;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/secret/SearchBoxStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "HIDDEN", "SHOW", "Companion", "docs-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SearchBoxStatus extends Enum<SearchBoxStatus> {
    public static final a Companion = null;
    public static final SearchBoxStatus HIDDEN = null;
    public static final SearchBoxStatus SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchBoxStatus[] f236985a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f236986b = null;
    private final int value;

    public static EnumEntries<SearchBoxStatus> getEntries() {
        return f236986b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.secret.SearchBoxStatus$a] */
    static {
        SearchBoxStatus r100 = new SearchBoxStatus("HIDDEN", 0, 0);
        HIDDEN = r100;
        SearchBoxStatus r101 = new SearchBoxStatus("SHOW", 1, 1);
        SHOW = r101;
        SearchBoxStatus[] r102 = {r100, r101};
        f236985a = r102;
        f236986b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static SearchBoxStatus[] values() {
        return (SearchBoxStatus[]) f236985a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SearchBoxStatus valueOf(String r100) {
        return (SearchBoxStatus) r27.a.a(SearchBoxStatus.class, r100);
    }

    public SearchBoxStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
