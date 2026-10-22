package com.ss.android.ugc.aweme.search.common.result.sug;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\t\b\u0012¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u000e¨\u0006 "}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/ECSearchSugSession;", "", "", "cursorPos", "I", "getCursorPos", "()I", "c", "(I)V", "", "Lcom/ss/android/ugc/aweme/search/common/result/sug/Query;", "searchSugQueries", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "id", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "sugAfterSearch", "getSugAfterSearch", "", "isSugFromResult", "Z", "()Z", "d", "(Z)V", "searchHistories", "getSearchHistories", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchSugSession {

    @SerializedName("cursor_pos")
    private int cursorPos;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("sug_session_id")
    private final String f451914id;

    @SerializedName("is_sug_from_result")
    private boolean isSugFromResult;

    @SerializedName("last_search_query")
    private final List<Query> searchHistories;

    @SerializedName("last_prefix")
    private final List<Query> searchSugQueries;

    @SerializedName("sug_after_search")
    private final int sugAfterSearch;

    public final void d() {
        this.isSugFromResult = true;
    }

    private ECSearchSugSession() {
        this("", 0, new ArrayList());
        throw new RuntimeException("You should not call this constructor!");
    }

    public final String a() {
        return this.f451914id;
    }

    public final List<Query> b() {
        return this.searchSugQueries;
    }

    public final void c(int r100) {
        this.cursorPos = r100;
    }

    public ECSearchSugSession(String r100, int r101, List r102) {
        this.f451914id = r100;
        this.sugAfterSearch = r101;
        this.isSugFromResult = false;
        this.searchHistories = r102;
        this.searchSugQueries = new ArrayList();
    }
}
