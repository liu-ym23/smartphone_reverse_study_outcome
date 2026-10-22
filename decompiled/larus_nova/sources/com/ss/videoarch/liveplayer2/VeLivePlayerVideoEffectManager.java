package com.ss.videoarch.liveplayer2;

import com.ss.texturerender.effect.ICEffect.ICEffectWrapper;

/* JADX INFO: loaded from: classes38.dex */
public final class VeLivePlayerVideoEffectManager {

    /* JADX INFO: renamed from: com.ss.videoarch.liveplayer2.VeLivePlayerVideoEffectManager$1, reason: invalid class name */
    class AnonymousClass1 implements ICEffectWrapper.IEffectMsgListener {
        final /* synthetic */ VeLivePlayerVideoEffectManager this$0;
        final /* synthetic */ b val$configuration;

        public AnonymousClass1(VeLivePlayerVideoEffectManager r100, b r101) {
            this.this$0 = r100;
        }

        @Override // com.ss.texturerender.effect.ICEffect.ICEffectWrapper.IEffectMsgListener
        public void onMessageReceived(int r100, long r101, long r102, String r103) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.ss.videoarch.liveplayer2.VeLivePlayerVideoEffectManager$2, reason: invalid class name */
    class AnonymousClass2 implements ICEffectWrapper.IEffectInitCallback {
        final /* synthetic */ VeLivePlayerVideoEffectManager this$0;
        final /* synthetic */ b val$configuration;

        @Override // com.ss.texturerender.effect.ICEffect.ICEffectWrapper.IEffectInitCallback
        public void onInitCallback(int r100) {
            if (r100 != 0) goto L5;
            this.this$0.getClass();
        L5:
            throw null;
        }

        public AnonymousClass2(VeLivePlayerVideoEffectManager r100, b r101) {
            this.this$0 = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.videoarch.liveplayer2.VeLivePlayerVideoEffectManager$3, reason: invalid class name */
    class AnonymousClass3 implements ICEffectWrapper.IEffectResourceFinder {
        final /* synthetic */ VeLivePlayerVideoEffectManager this$0;
        final /* synthetic */ b val$configuration;
        final /* synthetic */ VeLivePlayer val$livePlayer;

        @Override // com.ss.texturerender.effect.ICEffect.ICEffectWrapper.IEffectResourceFinder
        public void release(long r100) {
        }

        @Override // com.ss.texturerender.effect.ICEffect.ICEffectWrapper.IEffectResourceFinder
        public long createNativeResourceFinder(long r100) {
            throw null;
        }

        public AnonymousClass3(VeLivePlayerVideoEffectManager r100, b r101, VeLivePlayer r102) {
            this.this$0 = r100;
            this.val$livePlayer = r102;
        }
    }
}
