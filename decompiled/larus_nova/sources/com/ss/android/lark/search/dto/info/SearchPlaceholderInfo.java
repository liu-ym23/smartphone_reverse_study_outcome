package com.ss.android.lark.search.dto.info;

import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchPlaceholderInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "<init>", "()V", "attachInfo", "getAttachInfo", "()Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "setAttachInfo", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)V", "placeholderType", "Lcom/ss/android/lark/search/dto/info/SearchPlaceholderInfo$Type;", "getPlaceholderType", "()Lcom/ss/android/lark/search/dto/info/SearchPlaceholderInfo$Type;", "setPlaceholderType", "(Lcom/ss/android/lark/search/dto/info/SearchPlaceholderInfo$Type;)V", "markSymbol", "", "getMarkSymbol", "()Ljava/lang/String;", "setMarkSymbol", "(Ljava/lang/String;)V", "equals", "", "other", "", "hashCode", "", "Type", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchPlaceholderInfo extends SearchBaseInfo {
    private SearchBaseInfo attachInfo;
    private String markSymbol;
    private Type placeholderType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchPlaceholderInfo$Type;", "", "<init>", "(Ljava/lang/String;I)V", "CARD_HEADER", "RECOMMEND_ACTION_HEADER", "RECOMMEND_HISTORY_HEADER", "CARD_RECOMMEND_HEADER", "CARD_FOOTER", "CARD_FOOTER_8DP", "DIVIDER_8DP", "DIVIDER_14DP", "RECOMMEND_QA_HEADER", "COMMON_SEARCH_HEADER", "COMMON_SEARCH_FOOTER", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type CARD_FOOTER = null;
        public static final Type CARD_FOOTER_8DP = null;
        public static final Type CARD_HEADER = null;
        public static final Type CARD_RECOMMEND_HEADER = null;
        public static final Type COMMON_SEARCH_FOOTER = null;
        public static final Type COMMON_SEARCH_HEADER = null;
        public static final Type DIVIDER_14DP = null;
        public static final Type DIVIDER_8DP = null;
        public static final Type RECOMMEND_ACTION_HEADER = null;
        public static final Type RECOMMEND_HISTORY_HEADER = null;
        public static final Type RECOMMEND_QA_HEADER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f440164a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440165b = null;

        public static EnumEntries<Type> getEntries() {
            return f440165b;
        }

        static {
            Type r100 = new Type("CARD_HEADER", 0);
            CARD_HEADER = r100;
            Type r101 = new Type("RECOMMEND_ACTION_HEADER", 1);
            RECOMMEND_ACTION_HEADER = r101;
            Type r102 = new Type("RECOMMEND_HISTORY_HEADER", 2);
            RECOMMEND_HISTORY_HEADER = r102;
            Type r103 = new Type("CARD_RECOMMEND_HEADER", 3);
            CARD_RECOMMEND_HEADER = r103;
            Type r104 = new Type("CARD_FOOTER", 4);
            CARD_FOOTER = r104;
            Type r105 = new Type("CARD_FOOTER_8DP", 5);
            CARD_FOOTER_8DP = r105;
            Type r110 = new Type("DIVIDER_8DP", 6);
            DIVIDER_8DP = r110;
            Type r111 = new Type("DIVIDER_14DP", 7);
            DIVIDER_14DP = r111;
            Type r112 = new Type("RECOMMEND_QA_HEADER", 8);
            RECOMMEND_QA_HEADER = r112;
            Type r113 = new Type("COMMON_SEARCH_HEADER", 9);
            COMMON_SEARCH_HEADER = r113;
            Type r114 = new Type("COMMON_SEARCH_FOOTER", 10);
            COMMON_SEARCH_FOOTER = r114;
            Type[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
            f440164a = r115;
            f440165b = EnumEntriesKt.enumEntries(r115);
        }

        public static Type[] values() {
            return (Type[]) f440164a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public int hashCode() {
        return Objects.hash(new Object[]{getId(), Integer.valueOf(this.type), this.placeholderType});
    }

    public SearchPlaceholderInfo() {
        this.type = SearchCommonConstants.SearchResultType.PLACE_HOLDER;
        this.placeholderType = Type.CARD_HEADER;
    }

    public final SearchBaseInfo getAttachInfo() {
        return this.attachInfo;
    }

    public final String getMarkSymbol() {
        return this.markSymbol;
    }

    public final Type getPlaceholderType() {
        return this.placeholderType;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public boolean equals(Object r100) {
        if (super.equals(r100) == false) goto L13;
        Type r101 = null;
        if ((r100 instanceof SearchPlaceholderInfo) == false) goto L7;
        SearchPlaceholderInfo r102 = (SearchPlaceholderInfo) r100;
    L8:
        if (r102 == null) goto L11;
        r101 = r102.placeholderType;
    L11:
        if (r101 != this.placeholderType) goto L13;
        return true;
    L7:
        r102 = null;
    L13:
        return false;
    }

    public final void setAttachInfo(SearchBaseInfo r100) {
        this.attachInfo = r100;
    }

    public final void setMarkSymbol(String r100) {
        this.markSymbol = r100;
    }

    public final void setPlaceholderType(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.placeholderType = r100;
    }
}
