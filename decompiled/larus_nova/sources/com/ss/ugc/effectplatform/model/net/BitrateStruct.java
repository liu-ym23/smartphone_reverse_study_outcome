package com.ss.ugc.effectplatform.model.net;

import com.ss.ttvideoengine.model.BarrageMaskInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/BitrateStruct;", "", "GearName", "", BarrageMaskInfo.KEY_VER4_MASK_BITRATE, "", "QualityType", "PlayAddr", "Lcom/ss/ugc/effectplatform/model/net/UrlStruct;", "PlayAddrH265", "CodecType", "PlayAddrByteVC1", "HdrType", "HdrBit", "FPS", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class BitrateStruct {
    public Integer Bitrate;
    public String CodecType;
    public Long FPS;
    public String GearName;
    public String HdrBit;
    public String HdrType;
    public UrlStruct PlayAddr;
    public UrlStruct PlayAddrByteVC1;
    public UrlStruct PlayAddrH265;
    public Integer QualityType;

    public BitrateStruct() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public BitrateStruct(String r100, Integer r101, Integer r102, UrlStruct r103, UrlStruct r104, String r105, UrlStruct r106, String r107, String r108, Long r110) {
        this.GearName = r100;
        this.Bitrate = r101;
        this.QualityType = r102;
        this.PlayAddr = r103;
        this.PlayAddrH265 = r104;
        this.CodecType = r105;
        this.PlayAddrByteVC1 = r106;
        this.HdrType = r107;
        this.HdrBit = r108;
        this.FPS = r110;
    }

    public /* synthetic */ BitrateStruct(String r110, Integer r111, Integer r112, UrlStruct r113, UrlStruct r114, String r115, UrlStruct r116, String r117, String r210, Long r211, int r212, DefaultConstructorMarker r213) {
        Long r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        UrlStruct r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        UrlStruct r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        UrlStruct r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
