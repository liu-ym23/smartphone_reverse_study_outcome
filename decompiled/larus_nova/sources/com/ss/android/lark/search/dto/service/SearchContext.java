package com.ss.android.lark.search.dto.service;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.bytedance.lark.pb.search.v1.ChatFilterParam;
import com.larksuite.framework.utils.e;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.UserGroupScene;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class SearchContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Scene.Type f440172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f440173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f440174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f440175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f440176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f440177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f440178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f440179h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f440180i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f440181j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f440182k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f440183l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f440184m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f440185n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Union f440186o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<ChatFilterParam.ChatMode> f440187p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f440188q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f440189r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f440190s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f440191t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f440192u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List<Doc.Type> f440193v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List<? extends ActionType> f440194w;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/search/dto/service/SearchContext$ChatSearchSortType;", "", "<init>", "(Ljava/lang/String;I)V", "RELEVANCE", "RECENTLY_UPDATE_TIME", "RECENTLY_CREATE_TIME", "LEAST_MEMBER", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatSearchSortType extends Enum<ChatSearchSortType> {
        public static final a Companion = null;
        public static final ChatSearchSortType LEAST_MEMBER = null;
        public static final ChatSearchSortType RECENTLY_CREATE_TIME = null;
        public static final ChatSearchSortType RECENTLY_UPDATE_TIME = null;
        public static final ChatSearchSortType RELEVANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatSearchSortType[] f440195a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440196b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ChatSearchSortType> getEntries() {
            return f440196b;
        }

        static {
            ChatSearchSortType r100 = new ChatSearchSortType("RELEVANCE", 0);
            RELEVANCE = r100;
            ChatSearchSortType r101 = new ChatSearchSortType("RECENTLY_UPDATE_TIME", 1);
            RECENTLY_UPDATE_TIME = r101;
            ChatSearchSortType r102 = new ChatSearchSortType("RECENTLY_CREATE_TIME", 2);
            RECENTLY_CREATE_TIME = r102;
            ChatSearchSortType r103 = new ChatSearchSortType("LEAST_MEMBER", 3);
            LEAST_MEMBER = r103;
            ChatSearchSortType[] r104 = {r100, r101, r102, r103};
            f440195a = r104;
            f440196b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static ChatSearchSortType[] values() {
            return (ChatSearchSortType[]) f440195a.clone();
        }

        public static ChatSearchSortType valueOf(String r100) {
            return (ChatSearchSortType) r27.a.a(ChatSearchSortType.class, r100);
        }

        public ChatSearchSortType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/search/dto/service/SearchContext$DocCategory;", "", "<init>", "(Ljava/lang/String;I)V", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "WIKI", AccountType.ALL, "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DocCategory extends Enum<DocCategory> {
        public static final DocCategory ALL = null;
        public static final a Companion = null;
        public static final DocCategory DOC = null;
        public static final DocCategory WIKI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DocCategory[] f440197a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440198b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<DocCategory> getEntries() {
            return f440198b;
        }

        static {
            DocCategory r100 = new DocCategory(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 0);
            DOC = r100;
            DocCategory r101 = new DocCategory("WIKI", 1);
            WIKI = r101;
            DocCategory r102 = new DocCategory(AccountType.ALL, 2);
            ALL = r102;
            DocCategory[] r103 = {r100, r101, r102};
            f440197a = r103;
            f440198b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static DocCategory[] values() {
            return (DocCategory[]) f440197a.clone();
        }

        public static DocCategory valueOf(String r100) {
            return (DocCategory) r27.a.a(DocCategory.class, r100);
        }

        public DocCategory(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/search/dto/service/SearchContext$DocSearchContentType;", "", "<init>", "(Ljava/lang/String;I)V", "ONLY_MATCH_TITLE", "ONLY_MATCH_COMMENT", AccountType.ALL, "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DocSearchContentType extends Enum<DocSearchContentType> {
        public static final DocSearchContentType ALL = null;
        public static final a Companion = null;
        public static final DocSearchContentType ONLY_MATCH_COMMENT = null;
        public static final DocSearchContentType ONLY_MATCH_TITLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DocSearchContentType[] f440199a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440200b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<DocSearchContentType> getEntries() {
            return f440200b;
        }

        static {
            DocSearchContentType r100 = new DocSearchContentType("ONLY_MATCH_TITLE", 0);
            ONLY_MATCH_TITLE = r100;
            DocSearchContentType r101 = new DocSearchContentType("ONLY_MATCH_COMMENT", 1);
            ONLY_MATCH_COMMENT = r101;
            DocSearchContentType r102 = new DocSearchContentType(AccountType.ALL, 2);
            ALL = r102;
            DocSearchContentType[] r103 = {r100, r101, r102};
            f440199a = r103;
            f440200b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static DocSearchContentType[] values() {
            return (DocSearchContentType[]) f440199a.clone();
        }

        public static DocSearchContentType valueOf(String r100) {
            return (DocSearchContentType) r27.a.a(DocSearchContentType.class, r100);
        }

        public DocSearchContentType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/search/dto/service/SearchContext$DocSearchSortType;", "", "<init>", "(Ljava/lang/String;I)V", "RELEVANCE", "RECENTLY_UPDATE_TIME", "RECENTLY_CREATE_TIME", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DocSearchSortType extends Enum<DocSearchSortType> {
        public static final a Companion = null;
        public static final DocSearchSortType RECENTLY_CREATE_TIME = null;
        public static final DocSearchSortType RECENTLY_UPDATE_TIME = null;
        public static final DocSearchSortType RELEVANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DocSearchSortType[] f440201a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440202b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<DocSearchSortType> getEntries() {
            return f440202b;
        }

        static {
            DocSearchSortType r100 = new DocSearchSortType("RELEVANCE", 0);
            RELEVANCE = r100;
            DocSearchSortType r101 = new DocSearchSortType("RECENTLY_UPDATE_TIME", 1);
            RECENTLY_UPDATE_TIME = r101;
            DocSearchSortType r102 = new DocSearchSortType("RECENTLY_CREATE_TIME", 2);
            RECENTLY_CREATE_TIME = r102;
            DocSearchSortType[] r103 = {r100, r101, r102};
            f440201a = r103;
            f440202b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static DocSearchSortType[] values() {
            return (DocSearchSortType[]) f440201a.clone();
        }

        public static DocSearchSortType valueOf(String r100) {
            return (DocSearchSortType) r27.a.a(DocSearchSortType.class, r100);
        }

        public DocSearchSortType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/search/dto/service/SearchContext$MessageMatchType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "AT_ME", "HIDE_BOT", "ONLY_BOT", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MessageMatchType extends Enum<MessageMatchType> {
        public static final MessageMatchType AT_ME = null;
        public static final a Companion = null;
        public static final MessageMatchType HIDE_BOT = null;
        public static final MessageMatchType NONE = null;
        public static final MessageMatchType ONLY_BOT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MessageMatchType[] f440203a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440204b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<MessageMatchType> getEntries() {
            return f440204b;
        }

        static {
            MessageMatchType r100 = new MessageMatchType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            MessageMatchType r101 = new MessageMatchType("AT_ME", 1);
            AT_ME = r101;
            MessageMatchType r102 = new MessageMatchType("HIDE_BOT", 2);
            HIDE_BOT = r102;
            MessageMatchType r103 = new MessageMatchType("ONLY_BOT", 3);
            ONLY_BOT = r103;
            MessageMatchType[] r104 = {r100, r101, r102, r103};
            f440203a = r104;
            f440204b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static MessageMatchType[] values() {
            return (MessageMatchType[]) f440203a.clone();
        }

        public static MessageMatchType valueOf(String r100) {
            return (MessageMatchType) r27.a.a(MessageMatchType.class, r100);
        }

        public MessageMatchType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public SearchContext() {
        this.f440172a = Scene.Type.UNKNOWN;
        this.f440173b = "";
        this.f440174c = new ArrayList();
        this.f440185n = true;
        this.f440186o = Union.NO;
        new ArrayList();
        new ArrayList();
        new LinkedHashMap();
        this.f440187p = new ArrayList();
        this.f440188q = true;
        this.f440190s = true;
        this.f440191t = true;
        new ArrayList();
        new ArrayList();
        ChatSearchSortType.a r100 = ChatSearchSortType.Companion;
        new ArrayList();
        new ArrayList();
        new ArrayList();
        Scene.Type.a r101 = Scene.Type.Companion;
        new ArrayList();
        new ArrayList();
        this.f440192u = 20;
        e.e();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        this.f440193v = new ArrayList();
        DocCategory.a r102 = DocCategory.Companion;
        new ArrayList();
        new ArrayList();
        new LinkedHashMap();
        new ArrayList();
        new ArrayList();
        DocSearchSortType.a r103 = DocSearchSortType.Companion;
        DocSearchContentType.a r104 = DocSearchContentType.Companion;
        UserGroupScene.a r105 = UserGroupScene.Companion;
        new ArrayList();
    }

    public final void a(Scene.Type r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f440172a = r100;
    }
}
