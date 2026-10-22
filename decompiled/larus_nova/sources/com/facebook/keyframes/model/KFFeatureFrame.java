package com.facebook.keyframes.model;

import com.facebook.keyframes.KFPath;
import com.facebook.keyframes.util.ListHelper;
import com.facebook.keyframes.util.VectorCommand;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class KFFeatureFrame implements HasKeyFrame {
    public static final String DATA_JSON_FIELD = "data";
    public static final String START_FRAME_JSON_FIELD = "start_frame";
    private final ShapeMoveListData mShapeData;
    private final int mStartFrame;

    public static class Builder {
        public List<String> data;
        public int startFrame;

        public Builder() {
        }

        public KFFeatureFrame build() {
            return new KFFeatureFrame(this.startFrame, this.data);
        }
    }

    public static class ShapeMoveListData {
        private final List<VectorCommand> mVectorCommands;

        public List<VectorCommand> getVectorCommands() {
            return this.mVectorCommands;
        }

        public ShapeMoveListData(List<String> r100) {
            ArrayList r101 = new ArrayList();
            int r102 = r100.size();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            r101.add(VectorCommand.createVectorCommand(r100.get(r103)));
            r103 = r103 + 1;
            goto L3
        L5:
            this.mVectorCommands = ListHelper.immutableOrEmpty(r101);
        }

        public void applyFeature(KFPath r100) {
            int r101 = this.mVectorCommands.size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            this.mVectorCommands.get(r102).apply(r100);
            r102 = r102 + 1;
            goto L3
        }
    }

    @Override // com.facebook.keyframes.model.HasKeyFrame
    public int getKeyFrame() {
        return this.mStartFrame;
    }

    public ShapeMoveListData getShapeData() {
        return this.mShapeData;
    }

    public KFFeatureFrame(int r100, List<String> r101) {
        this.mStartFrame = r100;
        this.mShapeData = new ShapeMoveListData(r101);
    }
}
