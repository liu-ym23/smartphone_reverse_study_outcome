package com.ss.ugc.effectplatform.model.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0012R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/VideoControlStruct;", "", "AllowDownload", "", "AllowDuet", "AllowReact", "DraftProgressBar", "", "ShareType", "ShowProgressBar", "PreventDownloadType", "AllowDynamicWallpaper", "TimerStatus", "AllowUseMusic", "HideDownload", "HideDouplus", "AllowStitch", "DownloadSetting", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class VideoControlStruct {
    public Boolean AllowDownload;
    public Boolean AllowDuet;
    public Boolean AllowDynamicWallpaper;
    public Boolean AllowReact;
    public Boolean AllowStitch;
    public Boolean AllowUseMusic;
    public Integer DownloadSetting;
    public Integer DraftProgressBar;
    public Boolean HideDouplus;
    public Boolean HideDownload;
    public Integer PreventDownloadType;
    public Integer ShareType;
    public Integer ShowProgressBar;
    public Integer TimerStatus;

    public VideoControlStruct() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public VideoControlStruct(Boolean r100, Boolean r101, Boolean r102, Integer r103, Integer r104, Integer r105, Integer r106, Boolean r107, Integer r108, Boolean r110, Boolean r111, Boolean r112, Boolean r113, Integer r114) {
        this.AllowDownload = r100;
        this.AllowDuet = r101;
        this.AllowReact = r102;
        this.DraftProgressBar = r103;
        this.ShareType = r104;
        this.ShowProgressBar = r105;
        this.PreventDownloadType = r106;
        this.AllowDynamicWallpaper = r107;
        this.TimerStatus = r108;
        this.AllowUseMusic = r110;
        this.HideDownload = r111;
        this.HideDouplus = r112;
        this.AllowStitch = r113;
        this.DownloadSetting = r114;
    }

    public /* synthetic */ VideoControlStruct(Boolean r110, Boolean r111, Boolean r112, Integer r113, Integer r210, Integer r211, Integer r212, Boolean r213, Integer r214, Boolean r215, Boolean r216, Boolean r217, Boolean r218, Integer r219, int r310, DefaultConstructorMarker r311) {
        Integer r100 = null;
        if ((r310 & 1) == 0) goto L5;
        Boolean r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        Boolean r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        Boolean r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Boolean r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        Integer r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        Boolean r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Boolean r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Boolean r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Boolean r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
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
