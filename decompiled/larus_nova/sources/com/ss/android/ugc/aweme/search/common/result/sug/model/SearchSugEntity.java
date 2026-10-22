package com.ss.android.ugc.aweme.search.common.result.sug.model;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.suggest.Word;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class SearchSugEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f451935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f451936b;

    @SerializedName("content")
    private String content;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
    private List<Position> position;

    @SerializedName("extra_info")
    private SugExtraInfo sugExtraInfo;

    @SerializedName("sug_type")
    private String sugType;

    @SerializedName("word_record")
    private Word word;

    public final String b() {
        if (TextUtils.equals(this.sugType, "newHistory") == false) goto L6;
        return "1";
    L6:
        return "0";
    }

    public SearchSugEntity() {
        this.f451935a = false;
    }

    public final String a() {
        return this.content;
    }

    public final SugExtraInfo c() {
        return this.sugExtraInfo;
    }

    public final Word d() {
        return this.word;
    }
}
