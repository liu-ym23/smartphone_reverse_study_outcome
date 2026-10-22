package com.bytedance.vcloud.networkpredictor;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public class SpeedPredictorResultCollection {
    private ArrayList<SpeedPredictorResult> resultCollection;

    public int size() {
        return this.resultCollection.size();
    }

    public SpeedPredictorResultCollection() {
        this.resultCollection = new ArrayList();
    }

    public ArrayList<SpeedPredictorResult> getResultCollection() {
        return this.resultCollection;
    }

    public void add(SpeedPredictorResult r100) {
        this.resultCollection.add(r100);
    }

    public SpeedPredictorResult get(int r100) {
        return (SpeedPredictorResult) ListProtector.get(this.resultCollection, r100);
    }
}
