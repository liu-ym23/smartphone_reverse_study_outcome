package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes40.dex */
public class SearchNilInfo implements Serializable {
    public static final String HIT_CORE_TABLE = "hit_core_table";
    public static final String HIT_DIRT_WORDS = "hit_dirt_words";
    public static final String HIT_HEAT_SPEECH = "hate_speech";
    public static final String HIT_LIMIT = "hit_limit";
    public static final String HIT_OBSCENE_REACTION_IMAGE = "hit_obscene_reaction_image";
    public static final int HIT_TYPE_SENSITIVE = 12;

    @SerializedName("is_load_more")
    public String isLoadMore;

    @SerializedName("search_nil_item")
    public String nilItem;

    @SerializedName("search_nil_type")
    public String searchNilType;

    @SerializedName(a.KEY_TEXT_TYPE)
    public Integer textType;

    public boolean isHate() {
        return HIT_HEAT_SPEECH.equals(this.nilItem);
    }

    public boolean isHitCoreTable() {
        return HIT_CORE_TABLE.equals(this.nilItem);
    }

    public boolean isHitDirtWords() {
        if (this.textType.equals(10) == false) goto L5;
    L10:
        return true;
    L5:
        if (this.textType.equals(11) == true) goto L10;
        if (this.textType.equals(12) == true) goto L10;
        return false;
    }

    public boolean isHitLimit() {
        return HIT_LIMIT.equals(this.nilItem);
    }

    public boolean isHitObsceneReactionImage() {
        return HIT_OBSCENE_REACTION_IMAGE.equals(this.nilItem);
    }

    public boolean isSensitive() {
        return this.textType.equals(12);
    }

    public SearchNilInfo() {
        this.textType = null;
    }
}
