package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ReaV3 implements NonProguard {

    @SerializedName("delay_time")
    public long delayTime;
    public String op;

    @SerializedName("op_uid")
    public String opUid;

    @SerializedName("parent_wiki_token")
    public String parentWikiToken;

    @SerializedName("space_id")
    public String spaceId;

    @SerializedName("synergy_uuid")
    public String synergyUuid;

    @SerializedName("too_many_coordinator")
    public boolean tooManyCoordinator;

    @SerializedName("wiki_token")
    public String wikiToken;

    public ReaV3() {
    }

    public String toString() {
        return "ReaV3{, spaceId='" + c.j(this.spaceId) + "', wikiToken='" + c.j(this.wikiToken) + "', parentWikiToken='" + c.j(this.parentWikiToken) + "'}";
    }
}
