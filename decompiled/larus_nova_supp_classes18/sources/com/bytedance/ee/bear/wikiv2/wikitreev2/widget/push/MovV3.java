package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class MovV3 implements NonProguard {

    @SerializedName("delay_time")
    public long delayTime;
    public String from;

    @SerializedName("new_space_id")
    public String newSpaceId;

    @SerializedName("old_space_id")
    public String oldSpaceId;
    public String op;

    @SerializedName("op_uid")
    public String opUid;

    @SerializedName("synergy_uuid")
    public String synergyUuid;
    public String to;

    @SerializedName("too_many_coordinator")
    public boolean tooManyCoordinator;

    @SerializedName("wiki_token")
    public String wikiToken;

    public MovV3() {
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("MovV3{, oldSpaceId='");
        r0.append(c.j(this.oldSpaceId));
        r0.append("', newSpaceId='");
        r0.append(c.j(this.newSpaceId));
        r0.append("', wikiToken='");
        r0.append(c.j(this.wikiToken));
        r0.append("', from='");
        StringBuilder r1 = new StringBuilder();
        r1.append(this.from);
        r1.append("', to='");
        r1.append(c.j(this.to + "'}"));
        r0.append(c.j(r1.toString()));
        return r0.toString();
    }
}
