package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push;

import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import hu5.a;
import java.util.ArrayList;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class UdeNodePermV3 implements NonProguard {

    @SerializedName("affected_user")
    public ArrayList<String> affectedUser;

    @SerializedName("delay_time")
    public String delayTime;
    public String op;

    @SerializedName("op_uid")
    public String opUid;
    public String parent;

    @SerializedName("space_id")
    public String spaceId;

    @SerializedName("synergy_uuid")
    public String synergyUuid;

    @SerializedName("too_many_coordinator")
    public boolean tooManyCoordinator;

    @SerializedName("wiki_token")
    public String wikiToken;

    public UdeNodePermV3() {
    }

    public boolean effect() {
        if (a.d(this.affectedUser) == false) goto L7;
        return true;
    L7:
        return this.affectedUser.contains(((b0) org.koin.java.a.a(b0.class)).getUid());
    }

    public String toString() {
        return "UdeNodePermV3{, spaceId='" + c.j(this.spaceId) + "', wikiToken='" + c.j(this.wikiToken) + "', parentWikiToken='" + c.j(this.parent) + "', affectedUser='" + Integer.valueOf(a.c(this.affectedUser)) + "'}";
    }
}
