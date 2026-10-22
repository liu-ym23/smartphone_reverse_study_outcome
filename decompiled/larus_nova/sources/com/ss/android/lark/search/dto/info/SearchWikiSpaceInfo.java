package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.search.v2.UniversalFilters;
import com.bytedance.lark.pb.search.v2.WikiSpaceMeta;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\u001a\u0010$\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\u001a\u0010'\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001a\u0010*\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR\u001a\u0010-\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u001a\u00100\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\t¨\u00063"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchWikiSpaceInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "<init>", "()V", "spaceId", "", "getSpaceId", "()Ljava/lang/String;", "setSpaceId", "(Ljava/lang/String;)V", "spaceName", "getSpaceName", "setSpaceName", "description", "getDescription", "setDescription", "isStar", "", "()Z", "setStar", "(Z)V", "wikiSpaceType", "Lcom/bytedance/lark/pb/search/v2/UniversalFilters$WikiSpaceFilter$SpaceType;", "getWikiSpaceType", "()Lcom/bytedance/lark/pb/search/v2/UniversalFilters$WikiSpaceFilter$SpaceType;", "setWikiSpaceType", "(Lcom/bytedance/lark/pb/search/v2/UniversalFilters$WikiSpaceFilter$SpaceType;)V", "wikiScope", "Lcom/bytedance/lark/pb/search/v2/WikiSpaceMeta$SpaceScope;", "getWikiScope", "()Lcom/bytedance/lark/pb/search/v2/WikiSpaceMeta$SpaceScope;", "setWikiScope", "(Lcom/bytedance/lark/pb/search/v2/WikiSpaceMeta$SpaceScope;)V", "rootToken", "getRootToken", "setRootToken", "coverColorValue", "getCoverColorValue", "setCoverColorValue", "coverIsGraphDark", "getCoverIsGraphDark", "setCoverIsGraphDark", "coverKey", "getCoverKey", "setCoverKey", "coverOrigin", "getCoverOrigin", "setCoverOrigin", "coverThumbnail", "getCoverThumbnail", "setCoverThumbnail", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchWikiSpaceInfo extends SearchBaseInfo {
    private String coverColorValue;
    private boolean coverIsGraphDark;
    private String coverKey;
    private String coverOrigin;
    private String coverThumbnail;
    private String description;
    private boolean isStar;
    private String rootToken;
    private String spaceId;
    private String spaceName;
    private WikiSpaceMeta.SpaceScope wikiScope;
    private UniversalFilters.WikiSpaceFilter.SpaceType wikiSpaceType;

    public SearchWikiSpaceInfo() {
        this.type = 24;
        this.spaceId = "";
        this.spaceName = "";
        this.description = "";
        this.rootToken = "";
        this.coverColorValue = "";
        this.coverKey = "";
        this.coverOrigin = "";
        this.coverThumbnail = "";
    }

    public final String getCoverColorValue() {
        return this.coverColorValue;
    }

    public final boolean getCoverIsGraphDark() {
        return this.coverIsGraphDark;
    }

    public final String getCoverKey() {
        return this.coverKey;
    }

    public final String getCoverOrigin() {
        return this.coverOrigin;
    }

    public final String getCoverThumbnail() {
        return this.coverThumbnail;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getRootToken() {
        return this.rootToken;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final String getSpaceName() {
        return this.spaceName;
    }

    public final WikiSpaceMeta.SpaceScope getWikiScope() {
        return this.wikiScope;
    }

    public final UniversalFilters.WikiSpaceFilter.SpaceType getWikiSpaceType() {
        return this.wikiSpaceType;
    }

    public final boolean isStar() {
        return this.isStar;
    }

    public final void setCoverColorValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.coverColorValue = r100;
    }

    public final void setCoverIsGraphDark(boolean r100) {
        this.coverIsGraphDark = r100;
    }

    public final void setCoverKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.coverKey = r100;
    }

    public final void setCoverOrigin(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.coverOrigin = r100;
    }

    public final void setCoverThumbnail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.coverThumbnail = r100;
    }

    public final void setDescription(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.description = r100;
    }

    public final void setRootToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rootToken = r100;
    }

    public final void setSpaceId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.spaceId = r100;
    }

    public final void setSpaceName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.spaceName = r100;
    }

    public final void setStar(boolean r100) {
        this.isStar = r100;
    }

    public final void setWikiScope(WikiSpaceMeta.SpaceScope r100) {
        this.wikiScope = r100;
    }

    public final void setWikiSpaceType(UniversalFilters.WikiSpaceFilter.SpaceType r100) {
        this.wikiSpaceType = r100;
    }
}
