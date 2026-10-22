package com.bytedance.ee.bear.list.homepage.title;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/title/DocPageEnum;", "", "id", "", "textResId", "<init>", "(Ljava/lang/String;III)V", "getId", "()I", "getTextResId", "RECENT_VISIT", "SHARE_WITH_ME", "FAVORITE", "MY_FOLDER", "SHARE_FOLDER", "OFFLINE", "OWNED_BY_ME", "MY_INVOLVED", "AI_NOTE_SHARE_WITH_ME", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocPageEnum extends Enum<DocPageEnum> {
    public static final DocPageEnum AI_NOTE_SHARE_WITH_ME = null;
    public static final DocPageEnum FAVORITE = null;
    public static final DocPageEnum MY_FOLDER = null;
    public static final DocPageEnum MY_INVOLVED = null;
    public static final DocPageEnum OFFLINE = null;
    public static final DocPageEnum OWNED_BY_ME = null;
    public static final DocPageEnum RECENT_VISIT = null;
    public static final DocPageEnum SHARE_FOLDER = null;
    public static final DocPageEnum SHARE_WITH_ME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocPageEnum[] f228345a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f228346b = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f228347id;
    private final int textResId;

    public static EnumEntries<DocPageEnum> getEntries() {
        return f228346b;
    }

    static {
        DocPageEnum r100 = new DocPageEnum("RECENT_VISIT", 0, 1, R.string.LarkCCM_NewCM_RecentVisits_Menu);
        RECENT_VISIT = r100;
        DocPageEnum r101 = new DocPageEnum("SHARE_WITH_ME", 1, 2, R.string.Doc_List_Share_With_Me);
        SHARE_WITH_ME = r101;
        DocPageEnum r102 = new DocPageEnum("FAVORITE", 2, 3, R.string.Doc_List_MainTabHomeFavorite);
        FAVORITE = r102;
        DocPageEnum r103 = new DocPageEnum("MY_FOLDER", 3, 4, R.string.LarkCCM_NewCM_MyFolder_Menu);
        MY_FOLDER = r103;
        DocPageEnum r104 = new DocPageEnum("SHARE_FOLDER", 4, 5, R.string.LarkCCM_NewCM_SharedFolder_Menu);
        SHARE_FOLDER = r104;
        DocPageEnum r105 = new DocPageEnum("OFFLINE", 5, 6, R.string.Doc_List_OfflineTitle);
        OFFLINE = r105;
        DocPageEnum r110 = new DocPageEnum("OWNED_BY_ME", 6, 7, R.string.LarkCCM_AINotes_OwnedByMe_Tab);
        OWNED_BY_ME = r110;
        DocPageEnum r111 = new DocPageEnum("MY_INVOLVED", 7, 8, R.string.View_RecordNotes_AttendedByMe_Menu);
        MY_INVOLVED = r111;
        DocPageEnum r112 = new DocPageEnum("AI_NOTE_SHARE_WITH_ME", 8, 9, R.string.Doc_List_MainTabHomeShareWithMe);
        AI_NOTE_SHARE_WITH_ME = r112;
        DocPageEnum[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f228345a = r106;
        f228346b = EnumEntriesKt.enumEntries(r106);
    }

    public static DocPageEnum[] values() {
        return (DocPageEnum[]) f228345a.clone();
    }

    public final int getId() {
        return this.f228347id;
    }

    public final int getTextResId() {
        return this.textResId;
    }

    public static DocPageEnum valueOf(String r100) {
        return (DocPageEnum) r27.a.a(DocPageEnum.class, r100);
    }

    public DocPageEnum(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.f228347id = r102;
        this.textResId = r103;
    }
}
