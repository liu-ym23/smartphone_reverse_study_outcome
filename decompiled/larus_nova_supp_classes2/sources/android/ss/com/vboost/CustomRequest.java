package android.ss.com.vboost;

import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class CustomRequest {
    public Bundle bundle;
    public int cluster;
    public int level;
    public int priority;
    public boolean restore;
    public CustomScene scene;
    public int tid;
    public long timeout;
    public int type;

    public CustomRequest() {
    }

    public CustomRequest(CapabilityType r1, CustomScene r2) {
        this.type = r1.getIndex();
        this.scene = r2;
    }

    public CustomRequest(CapabilityType r1, FrequencyLevel r2, long r3) {
        this.type = r1.getIndex();
        this.level = r2.ordinal();
        this.timeout = r3;
    }
}
