package com.bytedance.ee.bear.onboarding.synchronization;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
class OnBoardingPrefData implements NonProguard {
    private Map<String, OnBoardingItem> onBoardingItemMap;

    public static class OnBoardingItem implements NonProguard {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f236171id;
        private boolean isDone;
        private int maxCount;
        private int updatedCount;

        public OnBoardingItem() {
        }

        public String toString() {
            return "OnBoardingItem{id='" + this.f236171id + "', maxCount=" + this.maxCount + ", updatedCount=" + this.updatedCount + ", isDone=" + this.isDone + '}';
        }

        public String getId() {
            return this.f236171id;
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

        public static /* synthetic */ int access$100(OnBoardingItem r100) {
            return r100.maxCount;
        }

        public static /* synthetic */ int access$200(OnBoardingItem r100) {
            return r100.updatedCount;
        }

        public static /* synthetic */ int access$208(OnBoardingItem r100) {
            int r101 = r100.updatedCount;
            r100.updatedCount = r101 + 1;
            return r101;
        }

        public static /* synthetic */ boolean access$300(OnBoardingItem r100) {
            return r100.isDone;
        }

        public void setDone(boolean r100) {
            this.isDone = r100;
        }

        public void setId(String r100) {
            this.f236171id = r100;
        }

        public void setMaxCount(int r100) {
            this.maxCount = r100;
        }

        public void setUpdatedCount(int r100) {
            this.updatedCount = r100;
        }

        public static /* synthetic */ String access$002(OnBoardingItem r100, String r101) {
            r100.f236171id = r101;
            return r101;
        }

        public static /* synthetic */ int access$102(OnBoardingItem r100, int r101) {
            r100.maxCount = r101;
            return r101;
        }

        public static /* synthetic */ int access$202(OnBoardingItem r100, int r101) {
            r100.updatedCount = r101;
            return r101;
        }

        public static /* synthetic */ boolean access$302(OnBoardingItem r100, boolean r101) {
            r100.isDone = r101;
            return r101;
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

    public OnBoardingItem get(String r100) {
        return getOnBoardingItemMap().get(r100);
    }

    public boolean getStatus(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        OnBoardingItem r101 = getOnBoardingItemMap().get(r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (OnBoardingItem.access$300(r101) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public OnBoardingItem put(String r100) {
        OnBoardingItem r101 = new OnBoardingItem();
        OnBoardingItem.access$002(r101, r100);
        OnBoardingItem.access$102(r101, ((wk5.a) org.koin.java.a.a(wk5.a.class)).a(r100));
        OnBoardingItem.access$202(r101, 0);
        getOnBoardingItemMap().put(r100, r101);
        return r101;
    }

    public void putAll(Map<String, Boolean> r100) {
        Iterator<Map.Entry<String, Boolean>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<String, Boolean> r102 = r101.next();
        String r103 = r102.getKey();
        OnBoardingItem r104 = getOnBoardingItemMap().get(r103);
        if (r104 != null) goto L8;
        r104 = put(r103);
    L8:
        OnBoardingItem.access$302(r104, r102.getValue().booleanValue());
        goto L4
    }

    public void setMissionFinished(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        OnBoardingItem r101 = getOnBoardingItemMap().get(r100);
        if (r101 == null) goto L9;
        OnBoardingItem.access$302(r101, true);
        return;
    }

    public void setOnBoardingItemMap(Map<String, OnBoardingItem> r100) {
        this.onBoardingItemMap = r100;
    }

    public boolean update(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        OnBoardingItem r101 = getOnBoardingItemMap().get(r100);
        if (r101 != null) goto L8;
        r101 = put(r100);
    L9:
        tt5.a.h("OnBoardingData", "update onBoardingItem: " + r101);
        if (OnBoardingItem.access$100(r101) > OnBoardingItem.access$200(r101)) goto L13;
        tt5.a.h("OnBoardingData", " onBoardingItem: " + r100 + ", set status: true");
        OnBoardingItem.access$302(r101, true);
        return true;
    L13:
        return false;
    L8:
        OnBoardingItem.access$208(r101);
        goto L9
    }

    public void update(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        OnBoardingItem r102 = getOnBoardingItemMap().get(r100);
        if (r102 != null) goto L8;
        r102 = put(r100);
    L8:
        OnBoardingItem.access$208(r102);
        tt5.a.h("OnBoardingData", "update onBoardingItem: " + r100 + ", set status: " + r101);
        OnBoardingItem.access$302(r102, r101);
    }
}
