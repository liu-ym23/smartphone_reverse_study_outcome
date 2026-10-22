package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/l;", "", "", "stageHideLyricsSwitch", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "setStageHideLyricsSwitch", "(Ljava/lang/Boolean;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class l implements vh7.h {

    @SerializedName("stage_hide_lyrics_switch")
    protected Boolean stageHideLyricsSwitch;

    public l() {
        this.stageHideLyricsSwitch = Boolean.FALSE;
    }

    public final Boolean a() {
        return this.stageHideLyricsSwitch;
    }

    public l(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.stageHideLyricsSwitch = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
        if (this.stageHideLyricsSwitch != null) goto L19;
        this.stageHideLyricsSwitch = Boolean.FALSE;
        return;
    }
}
