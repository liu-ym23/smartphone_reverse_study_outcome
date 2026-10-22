package com.ss.bytertc.engine.video;

import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IAmazingEffect {
    public IAmazingEffect() {
    }

    public abstract int appendEffectNodes(List<String> r100);

    public abstract int removeEffectNodes(List<String> r100);

    public abstract int replaceEffectNodes(List<String> r100, List<String> r101);

    public abstract int setAlgoModelResourceFinder(IRtcResourceFinder r100);

    public abstract int setEffectNodes(List<String> r100);

    public abstract void setVirtualBackgroundFilePath(String r100, int r101);

    public abstract int updateEffectNode(String r100, String r101, float r102);

    public static String getEffectSDKVersion() {
        return AmazingEffect.getEffectSDKVersion();
    }
}
