package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import yu5.c;

/* JADX INFO: loaded from: classes18.dex */
public final class BatchMovV3 implements NonProguard {

    @SerializedName("delay_time")
    public long delayTime;
    public String from;

    @SerializedName("new_space_id")
    public String newSpaceId;

    @SerializedName("old_space_id")
    public String oldSpaceId;

    /* JADX INFO: renamed from: op, reason: collision with root package name */
    public String f242180op;

    @SerializedName("op_uid")
    public String opUid;

    @SerializedName("synergy_uuid")
    public String synergyUuid;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    public String f242181to;

    @SerializedName("too_many_coordinator")
    public boolean tooManyCoordinator;

    @SerializedName("wiki_tokens")
    public ArrayList<String> wikiTokens;

    public BatchMovV3() {
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("MovV3{, oldSpaceId='");
        r100.append(c.j(this.oldSpaceId));
        r100.append("', newSpaceId='");
        r100.append(c.j(this.newSpaceId));
        r100.append("', wikiToken='");
        r100.append(c.j(this.wikiTokens.toString()));
        r100.append("', from='");
        StringBuilder r101 = new StringBuilder();
        r101.append(this.from);
        r101.append("', to='");
        r101.append(c.j(this.f242181to + "'}"));
        r100.append(c.j(r101.toString()));
        return r100.toString();
    }
}
