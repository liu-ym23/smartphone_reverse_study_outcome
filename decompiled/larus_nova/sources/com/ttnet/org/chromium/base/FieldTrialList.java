package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes41.dex */
@MainDex
public class FieldTrialList {

    public interface Natives {
        boolean createFieldTrial(String r100, String r101);

        String findFullName(String r100);

        String getVariationParameter(String r100, String r101);

        void logActiveTrials();

        boolean trialExists(String r100);
    }

    private FieldTrialList() {
    }

    public static void logActiveTrials() {
        FieldTrialListJni.get().logActiveTrials();
    }

    public static String findFullName(String r100) {
        return FieldTrialListJni.get().findFullName(r100);
    }

    public static boolean trialExists(String r100) {
        return FieldTrialListJni.get().trialExists(r100);
    }

    public static boolean createFieldTrial(String r100, String r101) {
        return FieldTrialListJni.get().createFieldTrial(r100, r101);
    }

    public static String getVariationParameter(String r100, String r101) {
        return FieldTrialListJni.get().getVariationParameter(r100, r101);
    }
}
