package com.ss.texturerender.effect;

/* JADX INFO: loaded from: classes40.dex */
public class EmptyEffect extends AbsEffect {
    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r100, FrameBuffer r101) {
        return null;
    }

    public EmptyEffect(int r100) {
        super(r100, 6);
        this.mOrder = 101;
    }
}
