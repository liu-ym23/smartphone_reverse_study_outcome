package com.ss.ugc.effectplatform.model.net;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0095\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u000f\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u00108R\u0014\u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u00109R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010:R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010;R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010:R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010<R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010:R\u0016\u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010:R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010<R\u0016\u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010:R \u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010<R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010;R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010<R\u0014\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010:R\u0014\u0010.\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/VideoInfo;", "", "Id", "", "Height", "", "Width", "Duration", "Ratio", "HasWatermark", "", "Cover", "Lcom/ss/ugc/effectplatform/model/net/UrlStruct;", "OriginCover", "BitrateInfos", "", "Lcom/ss/ugc/effectplatform/model/net/BitrateStruct;", "DynamicCover", "PlayAddrH264", "PlayAddr", "DownloadAddr", "PlayAddrLowbr", "NewDownloadAddr", "DownloadSuffixLogoAddr", "PlayAddrH265", "CodecType", "UIAlikeDownloadAddr", "CaptionDownloadAddr", "ContentType", "ControlInfo", "Lcom/ss/ugc/effectplatform/model/net/VideoControlStruct;", "CdnUrlExpired", "", "IsLongVideo", "VideoModel", "AnimatedCover", "NeedSetToken", "AiCover", "CoverTsp", "", "MiscDownloadAddrs", "", "IsCallBack", "PlayAddrByteVC1", "BigThumbs", "Lcom/ss/ugc/effectplatform/model/net/BigThumb;", "meta", "UseStaticCover", "OptimizedCover", "HorizontalType", "FakeHorizontalInfo", "Lcom/ss/ugc/effectplatform/model/net/FakeHorizontalStruct;", "TrailerStartTime", "MiscDownloadAddrsStr", "BlurCover", "ResetCover", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/Integer;Lcom/ss/ugc/effectplatform/model/net/VideoControlStruct;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/Boolean;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/Double;Ljava/util/Map;Ljava/lang/Boolean;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/Integer;Lcom/ss/ugc/effectplatform/model/net/FakeHorizontalStruct;Ljava/lang/Double;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;)V", "Ljava/lang/Long;", "Ljava/lang/Integer;", "Ljava/lang/Double;", "Ljava/lang/Boolean;", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class VideoInfo {
    public UrlStruct AiCover;
    public UrlStruct AnimatedCover;
    public List<BigThumb> BigThumbs;
    public List<BitrateStruct> BitrateInfos;
    public UrlStruct BlurCover;
    public UrlStruct CaptionDownloadAddr;
    public Long CdnUrlExpired;
    public String CodecType;
    public Integer ContentType;
    public VideoControlStruct ControlInfo;
    public UrlStruct Cover;
    public Double CoverTsp;
    public UrlStruct DownloadAddr;
    public UrlStruct DownloadSuffixLogoAddr;
    public Integer Duration;
    public UrlStruct DynamicCover;
    public FakeHorizontalStruct FakeHorizontalInfo;
    public Boolean HasWatermark;
    public Integer Height;
    public Integer HorizontalType;
    public String Id;
    public Boolean IsCallBack;
    public Integer IsLongVideo;
    public Map<String, UrlStruct> MiscDownloadAddrs;
    public String MiscDownloadAddrsStr;
    public Boolean NeedSetToken;
    public UrlStruct NewDownloadAddr;
    public UrlStruct OptimizedCover;
    public UrlStruct OriginCover;
    public UrlStruct PlayAddr;
    public UrlStruct PlayAddrByteVC1;
    public UrlStruct PlayAddrH264;
    public UrlStruct PlayAddrH265;
    public UrlStruct PlayAddrLowbr;
    public String Ratio;
    public UrlStruct ResetCover;
    public Double TrailerStartTime;
    public UrlStruct UIAlikeDownloadAddr;
    public Boolean UseStaticCover;
    public String VideoModel;
    public Integer Width;
    public String meta;

    public VideoInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1023, null);
    }

    public VideoInfo(String r100, Integer r101, Integer r102, Integer r103, String r104, Boolean r105, UrlStruct r106, UrlStruct r110, List<BitrateStruct> r111, UrlStruct r112, UrlStruct r113, UrlStruct r114, UrlStruct r115, UrlStruct r116, UrlStruct r117, UrlStruct r118, UrlStruct r119, String r210, UrlStruct r211, UrlStruct r212, Integer r213, VideoControlStruct r214, Long r215, Integer r216, String r217, UrlStruct r218, Boolean r219, UrlStruct r310, Double r311, Map<String, UrlStruct> r312, Boolean r313, UrlStruct r314, List<BigThumb> r315, String r316, Boolean r317, UrlStruct r318, Integer r319, FakeHorizontalStruct r410, Double r411, String r412, UrlStruct r413, UrlStruct r414) {
        this.Id = r100;
        this.Height = r101;
        this.Width = r102;
        this.Duration = r103;
        this.Ratio = r104;
        this.HasWatermark = r105;
        this.Cover = r106;
        this.OriginCover = r110;
        this.BitrateInfos = r111;
        this.DynamicCover = r112;
        this.PlayAddrH264 = r113;
        this.PlayAddr = r114;
        this.DownloadAddr = r115;
        this.PlayAddrLowbr = r116;
        this.NewDownloadAddr = r117;
        this.DownloadSuffixLogoAddr = r118;
        this.PlayAddrH265 = r119;
        this.CodecType = r210;
        this.UIAlikeDownloadAddr = r211;
        this.CaptionDownloadAddr = r212;
        this.ContentType = r213;
        this.ControlInfo = r214;
        this.CdnUrlExpired = r215;
        this.IsLongVideo = r216;
        this.VideoModel = r217;
        this.AnimatedCover = r218;
        this.NeedSetToken = r219;
        this.AiCover = r310;
        this.CoverTsp = r311;
        this.MiscDownloadAddrs = r312;
        this.IsCallBack = r313;
        this.PlayAddrByteVC1 = r314;
        this.BigThumbs = r315;
        this.meta = r316;
        this.UseStaticCover = r317;
        this.OptimizedCover = r318;
        this.HorizontalType = r319;
        this.FakeHorizontalInfo = r410;
        this.TrailerStartTime = r411;
        this.MiscDownloadAddrsStr = r412;
        this.BlurCover = r413;
        this.ResetCover = r414;
    }

    public /* synthetic */ VideoInfo(String r410, Integer r411, Integer r412, Integer r413, String r414, Boolean r415, UrlStruct r416, UrlStruct r417, List r510, UrlStruct r511, UrlStruct r512, UrlStruct r513, UrlStruct r514, UrlStruct r515, UrlStruct r516, UrlStruct r517, UrlStruct r518, String r519, UrlStruct r610, UrlStruct r611, Integer r612, VideoControlStruct r613, Long r614, Integer r615, String r616, UrlStruct r617, Boolean r618, UrlStruct r619, Double r710, Map r711, Boolean r712, UrlStruct r713, List r714, String r715, Boolean r716, UrlStruct r717, Integer r718, FakeHorizontalStruct r719, Double r810, String r811, UrlStruct r812, UrlStruct r813, int r814, int r815, DefaultConstructorMarker r816) {
        if ((r814 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r814 & 2) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r814 & 4) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r814 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r814 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r814 & 32) == 0) goto L25;
        Boolean r105 = null;
    L27:
        if ((r814 & 64) == 0) goto L29;
        UrlStruct r106 = null;
    L31:
        if ((r814 & 128) == 0) goto L33;
        UrlStruct r110 = null;
    L35:
        if ((r814 & 256) == 0) goto L37;
        List r111 = null;
    L39:
        if ((r814 & 512) == 0) goto L41;
        UrlStruct r112 = null;
    L43:
        if ((r814 & 1024) == 0) goto L45;
        UrlStruct r113 = null;
    L47:
        if ((r814 & 2048) == 0) goto L49;
        UrlStruct r114 = null;
    L51:
        if ((r814 & 4096) == 0) goto L53;
        UrlStruct r115 = null;
    L55:
        if ((r814 & 8192) == 0) goto L57;
        UrlStruct r107 = null;
    L58:
        UrlStruct r116 = r107;
        if ((r814 & 16384) == 0) goto L61;
        UrlStruct r108 = null;
    L63:
        if ((r814 & 32768) == 0) goto L65;
        UrlStruct r117 = null;
    L67:
        if ((r814 & 65536) == 0) goto L69;
        UrlStruct r118 = null;
    L71:
        if ((r814 & 131072) == 0) goto L73;
        String r119 = null;
    L75:
        if ((r814 & 262144) == 0) goto L77;
        UrlStruct r210 = null;
    L79:
        if ((r814 & 524288) == 0) goto L81;
        UrlStruct r211 = null;
    L83:
        if ((r814 & 1048576) == 0) goto L85;
        Integer r212 = null;
    L87:
        if ((r814 & 2097152) == 0) goto L89;
        VideoControlStruct r213 = null;
    L91:
        if ((r814 & 4194304) == 0) goto L93;
        Long r214 = null;
    L95:
        if ((r814 & 8388608) == 0) goto L97;
        Integer r215 = null;
    L99:
        if ((r814 & 16777216) == 0) goto L101;
        String r216 = null;
    L103:
        if ((r814 & 33554432) == 0) goto L105;
        UrlStruct r217 = null;
    L107:
        if ((r814 & 67108864) == 0) goto L109;
        Boolean r218 = null;
    L111:
        if ((r814 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        UrlStruct r219 = null;
    L115:
        if ((r814 & 268435456) == 0) goto L117;
        Double r310 = null;
    L119:
        if ((r814 & 536870912) == 0) goto L121;
        Map r311 = null;
    L123:
        if ((r814 & 1073741824) == 0) goto L125;
        Boolean r312 = null;
    L127:
        if ((r814 & Integer.MIN_VALUE) == 0) goto L129;
        UrlStruct r109 = null;
    L131:
        if ((r815 & 1) == 0) goto L133;
        List r313 = null;
    L135:
        if ((r815 & 2) == 0) goto L137;
        String r314 = null;
    L139:
        if ((r815 & 4) == 0) goto L141;
        Boolean r315 = null;
    L143:
        if ((r815 & 8) == 0) goto L145;
        UrlStruct r316 = null;
    L147:
        if ((r815 & 16) == 0) goto L149;
        Integer r317 = null;
    L151:
        if ((r815 & 32) == 0) goto L153;
        FakeHorizontalStruct r318 = null;
    L155:
        if ((r815 & 64) == 0) goto L157;
        Double r319 = null;
    L158:
        UrlStruct r817 = r109;
        if ((r815 & 128) == 0) goto L161;
        String r120 = null;
    L162:
        String r418 = r120;
        if ((r815 & 256) == 0) goto L165;
        UrlStruct r121 = null;
    L167:
        if ((r815 & 512) == 0) goto L169;
        UrlStruct r122 = null;
    L170:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r108, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r817, r313, r314, r315, r316, r317, r318, r319, r418, r121, r122);
        return;
    L169:
        r122 = r813;
        goto L170
    L165:
        r121 = r812;
        goto L167
    L161:
        r120 = r811;
        goto L162
    L157:
        r319 = r810;
        goto L158
    L153:
        r318 = r719;
        goto L155
    L149:
        r317 = r718;
        goto L151
    L145:
        r316 = r717;
        goto L147
    L141:
        r315 = r716;
        goto L143
    L137:
        r314 = r715;
        goto L139
    L133:
        r313 = r714;
        goto L135
    L129:
        r109 = r713;
        goto L131
    L125:
        r312 = r712;
        goto L127
    L121:
        r311 = r711;
        goto L123
    L117:
        r310 = r710;
        goto L119
    L113:
        r219 = r619;
        goto L115
    L109:
        r218 = r618;
        goto L111
    L105:
        r217 = r617;
        goto L107
    L101:
        r216 = r616;
        goto L103
    L97:
        r215 = r615;
        goto L99
    L93:
        r214 = r614;
        goto L95
    L89:
        r213 = r613;
        goto L91
    L85:
        r212 = r612;
        goto L87
    L81:
        r211 = r611;
        goto L83
    L77:
        r210 = r610;
        goto L79
    L73:
        r119 = r519;
        goto L75
    L69:
        r118 = r518;
        goto L71
    L65:
        r117 = r517;
        goto L67
    L61:
        r108 = r516;
        goto L63
    L57:
        r107 = r515;
        goto L58
    L53:
        r115 = r514;
        goto L55
    L49:
        r114 = r513;
        goto L51
    L45:
        r113 = r512;
        goto L47
    L41:
        r112 = r511;
        goto L43
    L37:
        r111 = r510;
        goto L39
    L33:
        r110 = r417;
        goto L35
    L29:
        r106 = r416;
        goto L31
    L25:
        r105 = r415;
        goto L27
    L21:
        r104 = r414;
        goto L23
    L17:
        r103 = r413;
        goto L19
    L13:
        r102 = r412;
        goto L15
    L9:
        r101 = r411;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }
}
