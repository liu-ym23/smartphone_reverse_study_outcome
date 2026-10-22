package com.ss.android.lark.search.dto.constant;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/search/dto/constant/SearchInsideTarget;", "", "<init>", "(Ljava/lang/String;I)V", "QUICK_JUMP", "MESSAGE", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "WIKI", "TOPIC", "THREAD", "APP", "MAIL", "CONTACTS", "CHAT", "CALENDAR", "PANO", "OPEN_SEARCH", "SLASH_COMMAND", "ONCALL", "toSearchResultType", "", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SearchInsideTarget extends Enum<SearchInsideTarget> {
    public static final SearchInsideTarget APP = null;
    public static final SearchInsideTarget CALENDAR = null;
    public static final SearchInsideTarget CHAT = null;
    public static final SearchInsideTarget CONTACTS = null;
    public static final SearchInsideTarget DOC = null;
    public static final SearchInsideTarget MAIL = null;
    public static final SearchInsideTarget MESSAGE = null;
    public static final SearchInsideTarget ONCALL = null;
    public static final SearchInsideTarget OPEN_SEARCH = null;
    public static final SearchInsideTarget PANO = null;
    public static final SearchInsideTarget QUICK_JUMP = null;
    public static final SearchInsideTarget SLASH_COMMAND = null;
    public static final SearchInsideTarget THREAD = null;
    public static final SearchInsideTarget TOPIC = null;
    public static final SearchInsideTarget WIKI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchInsideTarget[] f440136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440137b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f440138a = null;

        static {
            int[] r100 = new int[SearchInsideTarget.values().length];
            r100[SearchInsideTarget.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r100[SearchInsideTarget.DOC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r100[SearchInsideTarget.APP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[SearchInsideTarget.CONTACTS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[SearchInsideTarget.CHAT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r100[SearchInsideTarget.OPEN_SEARCH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[SearchInsideTarget.SLASH_COMMAND.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[SearchInsideTarget.ONCALL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r100[SearchInsideTarget.CALENDAR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[SearchInsideTarget.MAIL.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f440138a = r100;
        }
    }

    public static EnumEntries<SearchInsideTarget> getEntries() {
        return f440137b;
    }

    static {
        SearchInsideTarget r100 = new SearchInsideTarget("QUICK_JUMP", 0);
        QUICK_JUMP = r100;
        SearchInsideTarget r101 = new SearchInsideTarget("MESSAGE", 1);
        MESSAGE = r101;
        SearchInsideTarget r102 = new SearchInsideTarget(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 2);
        DOC = r102;
        SearchInsideTarget r103 = new SearchInsideTarget("WIKI", 3);
        WIKI = r103;
        SearchInsideTarget r104 = new SearchInsideTarget("TOPIC", 4);
        TOPIC = r104;
        SearchInsideTarget r105 = new SearchInsideTarget("THREAD", 5);
        THREAD = r105;
        SearchInsideTarget r110 = new SearchInsideTarget("APP", 6);
        APP = r110;
        SearchInsideTarget r111 = new SearchInsideTarget("MAIL", 7);
        MAIL = r111;
        SearchInsideTarget r112 = new SearchInsideTarget("CONTACTS", 8);
        CONTACTS = r112;
        SearchInsideTarget r113 = new SearchInsideTarget("CHAT", 9);
        CHAT = r113;
        SearchInsideTarget r114 = new SearchInsideTarget("CALENDAR", 10);
        CALENDAR = r114;
        SearchInsideTarget r115 = new SearchInsideTarget("PANO", 11);
        PANO = r115;
        SearchInsideTarget r106 = new SearchInsideTarget("OPEN_SEARCH", 12);
        OPEN_SEARCH = r106;
        SearchInsideTarget r107 = new SearchInsideTarget("SLASH_COMMAND", 13);
        SLASH_COMMAND = r107;
        SearchInsideTarget r108 = new SearchInsideTarget("ONCALL", 14);
        ONCALL = r108;
        SearchInsideTarget[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        f440136a = r109;
        f440137b = EnumEntriesKt.enumEntries(r109);
    }

    public static SearchInsideTarget[] values() {
        return (SearchInsideTarget[]) f440136a.clone();
    }

    public final int toSearchResultType() {
        switch(a.f440138a[ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 5;
    L6:
        return SearchCommonConstants.SearchResultType.CALENDAR_EVENT;
    L7:
        return 10;
    L8:
        return 21;
    L9:
        return 2;
    L10:
        return 1;
    L11:
        return 12;
    L12:
        return 6;
    L13:
        return 3;
    }

    public static SearchInsideTarget valueOf(String r100) {
        return (SearchInsideTarget) r27.a.a(SearchInsideTarget.class, r100);
    }

    public SearchInsideTarget(String r100, int r101) {
        super(r100, r101);
    }
}
