package com.ss.videoarch.liveplayer;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;

/* JADX INFO: loaded from: classes38.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f458854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VeLivePlayerDef$VeLivePlayerFormat f458855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VeLivePlayerDef$VeLivePlayerProtocol f458856c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b0 f458857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final VeLivePlayerDef$VeLivePlayerFormat f458858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final VeLivePlayerDef$VeLivePlayerStreamType f458859c;

        public void VeLivePlayerStream() {
        }

        public String toString() {
            return "VeLivePlayerStream{url='null', resolution=" + this.f458857a + ", bitrate=0, format=" + this.f458858b + ", streamType=" + this.f458859c + '}';
        }

        public a() {
            this.f458857a = new b0(PlayerResolution.SDKKEY.ORIGIN);
            this.f458858b = VeLivePlayerDef$VeLivePlayerFormat.VeLivePlayerFormatFLV;
            this.f458859c = VeLivePlayerDef$VeLivePlayerStreamType.VeLivePlayerStreamTypeMain;
        }
    }

    public String toString() {
        return "VeLivePlayerStreamData{enableABR=false, enableMainBackupSwitch=false, defaultResolution=" + this.f458854a + ", defaultFormat=" + this.f458855b + ", defaultProtocol=" + this.f458856c + ", mainStreamList=null, backupStreamList=null}";
    }

    public i0() {
        this.f458854a = new b0(PlayerResolution.SDKKEY.ORIGIN);
        this.f458855b = VeLivePlayerDef$VeLivePlayerFormat.VeLivePlayerFormatFLV;
        this.f458856c = VeLivePlayerDef$VeLivePlayerProtocol.VeLivePlayerProtocolTCP;
    }
}
