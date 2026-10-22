package com.mammon.speechaudiosdk.kmp.param;

import com.mammon.speechaudiosdk.kmp.type.SpeechAudioNetConnectionStateType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioNetConnectionEventParam;", "", "state", "Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioNetConnectionStateType;", "url", "", "textMsg", "<init>", "(Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioNetConnectionStateType;Ljava/lang/String;Ljava/lang/String;)V", "getState", "()Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioNetConnectionStateType;", "getUrl", "()Ljava/lang/String;", "getTextMsg", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechAudioNetConnectionEventParam {
    private final SpeechAudioNetConnectionStateType state;
    private final String textMsg;
    private final String url;

    public SpeechAudioNetConnectionEventParam() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SpeechAudioNetConnectionEventParam copy$default(SpeechAudioNetConnectionEventParam r100, SpeechAudioNetConnectionStateType r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.state;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.url;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.textMsg;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final SpeechAudioNetConnectionStateType component1() {
        return this.state;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.textMsg;
    }

    public final SpeechAudioNetConnectionEventParam copy(SpeechAudioNetConnectionStateType r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        return new SpeechAudioNetConnectionEventParam(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpeechAudioNetConnectionEventParam) == true) goto L8;
        return false;
    L8:
        SpeechAudioNetConnectionEventParam r101 = (SpeechAudioNetConnectionEventParam) r100;
        if (this.state == r101.state) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textMsg, r101.textMsg) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.state.hashCode() * 31;
        String r101 = this.url;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.textMsg;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "SpeechAudioNetConnectionEventParam(state=" + this.state + ", url=" + this.url + ", textMsg=" + this.textMsg + ')';
    }

    public final SpeechAudioNetConnectionStateType getState() {
        return this.state;
    }

    public final String getTextMsg() {
        return this.textMsg;
    }

    public final String getUrl() {
        return this.url;
    }

    public SpeechAudioNetConnectionEventParam(SpeechAudioNetConnectionStateType r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.state = r100;
        this.url = r101;
        this.textMsg = r102;
    }

    public /* synthetic */ SpeechAudioNetConnectionEventParam(SpeechAudioNetConnectionStateType r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = SpeechAudioNetConnectionStateType.ConnectionStateConnectUnknown;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
