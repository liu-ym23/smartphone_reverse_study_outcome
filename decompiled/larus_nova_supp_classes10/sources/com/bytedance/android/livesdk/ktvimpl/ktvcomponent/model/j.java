package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/j;", "", "", "audienceSingEnable", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "setAudienceSingEnable", "(Ljava/lang/Boolean;)V", "multiChorusEnable", "c", "setMultiChorusEnable", "autoOpenChallenge", "b", "setAutoOpenChallenge", "openStageHideLyricsSwitch", "e", "setOpenStageHideLyricsSwitch", "openRealtimeChorusSwitch", "d", "setOpenRealtimeChorusSwitch", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class j implements vh7.h {

    @SerializedName("open_audience_add_song_switch")
    protected Boolean audienceSingEnable;

    @SerializedName("can_auto_turn_on_sing_challenge")
    protected Boolean autoOpenChallenge;

    @SerializedName("open_audience_multi_chorus_switch")
    protected Boolean multiChorusEnable;

    @SerializedName("open_realtime_chorus_switch")
    protected Boolean openRealtimeChorusSwitch;

    @SerializedName("open_stage_hide_lyrics_switch")
    protected Boolean openStageHideLyricsSwitch;

    public j() {
        Boolean r0 = Boolean.FALSE;
        this.audienceSingEnable = r0;
        this.multiChorusEnable = r0;
        this.autoOpenChallenge = r0;
        this.openStageHideLyricsSwitch = r0;
        this.openRealtimeChorusSwitch = r0;
    }

    public final Boolean a() {
        return this.audienceSingEnable;
    }

    public final Boolean b() {
        return this.autoOpenChallenge;
    }

    public final Boolean c() {
        return this.multiChorusEnable;
    }

    public final Boolean d() {
        return this.openRealtimeChorusSwitch;
    }

    public final Boolean e() {
        return this.openStageHideLyricsSwitch;
    }

    public j(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.audienceSingEnable = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.multiChorusEnable = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.autoOpenChallenge = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.openStageHideLyricsSwitch = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.openRealtimeChorusSwitch = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
        if (this.audienceSingEnable != null) goto L25;
        this.audienceSingEnable = Boolean.FALSE;
    L25:
        if (this.multiChorusEnable != null) goto L28;
        this.multiChorusEnable = Boolean.FALSE;
    L28:
        if (this.autoOpenChallenge != null) goto L31;
        this.autoOpenChallenge = Boolean.FALSE;
    L31:
        if (this.openStageHideLyricsSwitch != null) goto L34;
        this.openStageHideLyricsSwitch = Boolean.FALSE;
    L34:
        if (this.openRealtimeChorusSwitch != null) goto L55;
        this.openRealtimeChorusSwitch = Boolean.FALSE;
        return;
    }
}
