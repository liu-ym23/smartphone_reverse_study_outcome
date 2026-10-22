package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push;

import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import yu5.c;

/* JADX INFO: loaded from: classes18.dex */
public final class ReaV3 implements NonProguard {

    @SerializedName("delay_time")
    public long delayTime;

    /* JADX INFO: renamed from: op, reason: collision with root package name */
    public String f242209op;

    @SerializedName("op_uid")
    public String opUid;

    @SerializedName("parent_wiki_token")
    public String parentWikiToken;

    @SerializedName(DocViewModel.EXTRA_SPACE_ID)
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
