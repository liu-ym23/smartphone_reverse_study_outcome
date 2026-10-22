package com.bytedance.mira.log.event;

import com.bytedance.mira.helper.MiraThreadPoolHelper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class MiraEvent {
    private JSONObject mCategory;
    private String mEventName;
    private JSONObject mExtra;
    private JSONObject mMetric;

    public void submit() {
        MiraThreadPoolHelper.sMiraFastExecutor.execute(new AnonymousClass1(this));
    }

    public MiraEvent() {
    }

    public String eventName() {
        return this.mEventName;
    }

    public MiraEvent(String r100) {
        this.mEventName = r100;
    }

    public static /* synthetic */ JSONObject access$000(MiraEvent r100) {
        return r100.mCategory;
    }

    public static /* synthetic */ JSONObject access$100(MiraEvent r100) {
        return r100.mMetric;
    }

    public static /* synthetic */ JSONObject access$200(MiraEvent r100) {
        return r100.mExtra;
    }

    public void putCategory(String r100, Object r101) {
        if (this.mCategory != null) goto L5;
        this.mCategory = new JSONObject();
    L5:
        safePut(this.mCategory, r100, r101);
    }

    public void putExtra(String r100, Object r101) {
        if (this.mExtra != null) goto L5;
        this.mExtra = new JSONObject();
    L5:
        safePut(this.mExtra, r100, r101);
    }

    public void putMetric(String r100, Object r101) {
        if (this.mMetric != null) goto L5;
        this.mMetric = new JSONObject();
    L5:
        safePut(this.mMetric, r100, r101);
    }

    private void safePut(JSONObject r100, String r101, Object r102) {
        r100.put(r101, r102);     // Catch: Throwable -> L4
        return;
    }
}
