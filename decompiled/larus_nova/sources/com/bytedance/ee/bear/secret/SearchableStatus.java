package com.bytedance.ee.bear.secret;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/secret/SearchableStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NOT_SET", "SEARCHABLE", "NOT_SEARCHABLE", "Companion", "docs-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SearchableStatus extends Enum<SearchableStatus> {
    public static final a Companion = null;
    public static final SearchableStatus NOT_SEARCHABLE = null;
    public static final SearchableStatus NOT_SET = null;
    public static final SearchableStatus SEARCHABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchableStatus[] f236987a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f236988b = null;
    private final int value;

    public static EnumEntries<SearchableStatus> getEntries() {
        return f236988b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.secret.SearchableStatus$a] */
    static {
        SearchableStatus r100 = new SearchableStatus("NOT_SET", 0, 0);
        NOT_SET = r100;
        SearchableStatus r101 = new SearchableStatus("SEARCHABLE", 1, 1);
        SEARCHABLE = r101;
        SearchableStatus r102 = new SearchableStatus("NOT_SEARCHABLE", 2, 2);
        NOT_SEARCHABLE = r102;
        SearchableStatus[] r103 = {r100, r101, r102};
        f236987a = r103;
        f236988b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static SearchableStatus[] values() {
        return (SearchableStatus[]) f236987a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SearchableStatus valueOf(String r100) {
        return (SearchableStatus) r27.a.a(SearchableStatus.class, r100);
    }

    public SearchableStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
