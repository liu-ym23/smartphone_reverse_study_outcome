package com.ss.ttm.player;

import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public interface FrameMetadataListener {

    /* JADX INFO: renamed from: com.ss.ttm.player.FrameMetadataListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$didReceivePacket(FrameMetadataListener r100, int r101, long r102, long r103, Map r104) {
        }

        public static void $default$onAbrDecisionInfo(FrameMetadataListener r100, long r101, String r102) {
        }

        public static void $default$receiveBinarySei(FrameMetadataListener r100, ByteBuffer r101) {
        }

        public static void $default$willRenderFrame(FrameMetadataListener r100, int r101, long r102, long r103, String r104) {
        }
    }

    void didReceivePacket(int r100, long r101, long r102, Map<Integer, String> r103);

    void frameDTSNotify(int r100, long r101, long r102);

    void onAbrDecisionInfo(long r100, String r101);

    void onFrameAboutToBeRendered(int r100, long r101, long r102, Map<Integer, String> r103);

    void receiveBinarySei(ByteBuffer r100);

    void updateFrameTerminatedDTS(int r100, long r101, long r102);

    void willRenderFrame(int r100, long r101, long r102, String r103);
}
