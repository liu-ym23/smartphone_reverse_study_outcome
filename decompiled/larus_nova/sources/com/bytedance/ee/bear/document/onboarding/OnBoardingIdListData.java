package com.bytedance.ee.bear.document.onboarding;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;

/* JADX INFO: loaded from: classes16.dex */
public class OnBoardingIdListData implements NonProguard {
    private String[] ids;

    public OnBoardingIdListData() {
    }

    public String toString() {
        return "OnBoardingIdListData{ids=" + Arrays.toString(this.ids) + '}';
    }

    public String[] getIds() {
        return this.ids;
    }

    public void setIds(String[] r100) {
        this.ids = r100;
    }
}
