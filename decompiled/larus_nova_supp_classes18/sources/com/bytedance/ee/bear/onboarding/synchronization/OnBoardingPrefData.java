package com.bytedance.ee.bear.onboarding.synchronization;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
class OnBoardingPrefData implements NonProguard {
    private Map<String, OnBoardingItem> onBoardingItemMap;

    public static class OnBoardingItem implements NonProguard {
        private String id;
        private boolean isDone;
        private int maxCount;
        private int updatedCount;

        public OnBoardingItem() {
        }

        public String toString() {
            return "OnBoardingItem{id='" + this.id + "', maxCount=" + this.maxCount + ", updatedCount=" + this.updatedCount + ", isDone=" + this.isDone + '}';
        }

        public String getId() {
            return this.id;
        }

        public int getMaxCount() {
            return this.maxCount;
        }

        public int getUpdatedCount() {
            return this.updatedCount;
        }

        public boolean isDone() {
            return this.isDone;
        }

        public static /* synthetic */ int access$100(OnBoardingItem r0) {
            return r0.maxCount;
        }

        public static /* synthetic */ int access$200(OnBoardingItem r0) {
            return r0.updatedCount;
        }

        public static /* synthetic */ int access$208(OnBoardingItem r2) {
            int r0 = r2.updatedCount;
            r2.updatedCount = r0 + 1;
            return r0;
        }

        public static /* synthetic */ boolean access$300(OnBoardingItem r0) {
            return r0.isDone;
        }

        public void setDone(boolean r1) {
            this.isDone = r1;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setMaxCount(int r1) {
            this.maxCount = r1;
        }

        public void setUpdatedCount(int r1) {
            this.updatedCount = r1;
        }

        public static /* synthetic */ String access$002(OnBoardingItem r0, String r1) {
            r0.id = r1;
            return r1;
        }

        public static /* synthetic */ int access$102(OnBoardingItem r0, int r1) {
            r0.maxCount = r1;
            return r1;
        }

        public static /* synthetic */ int access$202(OnBoardingItem r0, int r1) {
            r0.updatedCount = r1;
            return r1;
        }

        public static /* synthetic */ boolean access$302(OnBoardingItem r0, boolean r1) {
            r0.isDone = r1;
            return r1;
        }
    }

    public Map<String, OnBoardingItem> getOnBoardingItemMap() {
        if (this.onBoardingItemMap != null) goto L6;
        this.onBoardingItemMap = new HashMap(1);
    L6:
        return this.onBoardingItemMap;
    }

    public String toString() {
        return "OnBoardingData{onBoardingStatusMap=" + this.onBoardingItemMap + '}';
    }

    public OnBoardingPrefData() {
        this.onBoardingItemMap = new HashMap();
    }

    public OnBoardingItem get(String r2) {
        return getOnBoardingItemMap().get(r2);
    }

    public boolean getStatus(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        OnBoardingItem r4 = getOnBoardingItemMap().get(r3);
        if (r4 != null) goto L8;
        return false;
    L8:
        if (OnBoardingItem.access$300(r4) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public OnBoardingItem put(String r3) {
        OnBoardingItem r0 = new OnBoardingItem();
        OnBoardingItem.access$002(r0, r3);
        OnBoardingItem.access$102(r0, ((wk5.a) org.koin.java.a.a(wk5.a.class)).a(r3));
        OnBoardingItem.access$202(r0, 0);
        getOnBoardingItemMap().put(r3, r0);
        return r0;
    }

    public void putAll(Map<String, Boolean> r4) {
        Iterator<Map.Entry<String, Boolean>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Map.Entry<String, Boolean> r0 = r5.next();
        String r1 = r0.getKey();
        OnBoardingItem r2 = getOnBoardingItemMap().get(r1);
        if (r2 != null) goto L8;
        r2 = put(r1);
    L8:
        OnBoardingItem.access$302(r2, r0.getValue().booleanValue());
        goto L4
    }

    public void setMissionFinished(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        OnBoardingItem r3 = getOnBoardingItemMap().get(r2);
        if (r3 == null) goto L9;
        OnBoardingItem.access$302(r3, true);
        return;
    }

    public void setOnBoardingItemMap(Map<String, OnBoardingItem> r1) {
        this.onBoardingItemMap = r1;
    }

    public boolean update(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        OnBoardingItem r0 = getOnBoardingItemMap().get(r6);
        if (r0 != null) goto L8;
        r0 = put(r6);
    L9:
        tt5.a.h("OnBoardingData", "update onBoardingItem: " + r0);
        if (OnBoardingItem.access$100(r0) > OnBoardingItem.access$200(r0)) goto L13;
        tt5.a.h("OnBoardingData", " onBoardingItem: " + r6 + ", set status: true");
        OnBoardingItem.access$302(r0, true);
        return true;
    L13:
        return false;
    L8:
        OnBoardingItem.access$208(r0);
        goto L9
    }

    public void update(String r4, boolean r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        OnBoardingItem r0 = getOnBoardingItemMap().get(r4);
        if (r0 != null) goto L8;
        r0 = put(r4);
    L8:
        OnBoardingItem.access$208(r0);
        tt5.a.h("OnBoardingData", "update onBoardingItem: " + r4 + ", set status: " + r5);
        OnBoardingItem.access$302(r0, r5);
    }
}
