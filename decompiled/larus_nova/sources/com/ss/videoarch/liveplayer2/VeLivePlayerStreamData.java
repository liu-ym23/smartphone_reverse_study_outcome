package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final class VeLivePlayerStreamData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VeLivePlayerResolution f459703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VeLivePlayerFormat f459704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VeLivePlayerProtocol f459705c;

    public final String toString() {
        return "VeLivePlayerStreamData{enableABR=false, enableMainBackupSwitch=false, defaultResolution=" + this.f459703a + ", defaultFormat=" + this.f459704b + ", defaultProtocol=" + this.f459705c + ", mainStreamList=null, backupStreamList=null}";
    }

    public VeLivePlayerStreamData() {
        this.f459703a = new VeLivePlayerResolution();
        this.f459704b = VeLivePlayerFormat.VeLivePlayerFormatFLV;
        this.f459705c = VeLivePlayerProtocol.VeLivePlayerProtocolTCP;
    }
}
