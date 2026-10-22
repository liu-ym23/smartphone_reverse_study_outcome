package com.larus.account.base.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/account/base/model/NeutralAgeGatePage;", "", "page", "", "mobPage", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getPage", "()I", "getMobPage", "()Ljava/lang/String;", "DEFAULT", "FIRST_PAGE", "SECOND_PAGE", "THIRD_PAGE", "FOURTH_PAGE", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NeutralAgeGatePage extends Enum<NeutralAgeGatePage> {
    public static final a Companion = null;
    public static final NeutralAgeGatePage DEFAULT = null;
    public static final NeutralAgeGatePage FIRST_PAGE = null;
    public static final NeutralAgeGatePage FOURTH_PAGE = null;
    public static final NeutralAgeGatePage SECOND_PAGE = null;
    public static final NeutralAgeGatePage THIRD_PAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NeutralAgeGatePage[] f286201a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286202b = null;
    private final String mobPage;
    private final int page;

    public static EnumEntries<NeutralAgeGatePage> getEntries() {
        return f286202b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.account.base.model.NeutralAgeGatePage$a] */
    static {
        NeutralAgeGatePage r100 = new NeutralAgeGatePage("DEFAULT", 0, 0, "default");
        DEFAULT = r100;
        NeutralAgeGatePage r101 = new NeutralAgeGatePage("FIRST_PAGE", 1, 1, "primary_page");
        FIRST_PAGE = r101;
        NeutralAgeGatePage r102 = new NeutralAgeGatePage("SECOND_PAGE", 2, 2, "secondary_page");
        SECOND_PAGE = r102;
        NeutralAgeGatePage r103 = new NeutralAgeGatePage("THIRD_PAGE", 3, 3, "tertiary_page");
        THIRD_PAGE = r103;
        NeutralAgeGatePage r104 = new NeutralAgeGatePage("FOURTH_PAGE", 4, 4, "quaternary_page");
        FOURTH_PAGE = r104;
        NeutralAgeGatePage[] r105 = {r100, r101, r102, r103, r104};
        f286201a = r105;
        f286202b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static NeutralAgeGatePage[] values() {
        return (NeutralAgeGatePage[]) f286201a.clone();
    }

    public final String getMobPage() {
        return this.mobPage;
    }

    public final int getPage() {
        return this.page;
    }

    public static NeutralAgeGatePage valueOf(String r100) {
        return (NeutralAgeGatePage) r27.a.a(NeutralAgeGatePage.class, r100);
    }

    public NeutralAgeGatePage(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.page = r102;
        this.mobPage = r103;
    }
}
