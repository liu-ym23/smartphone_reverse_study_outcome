package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge;

import android.content.Context;
import com.bytedance.android.live.ktv.common.midi.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {
    void addKtvChallengeStatusChangedListener(b r1);

    int challengeTargetValue();

    void checkAutoOpenChallenge();

    int currentScoreValue();

    me2.a getChallengeConfig();

    boolean isKtvChallengeOpen();

    boolean needHideMidi();

    void onComponentClose();

    void onMidiScoreChanged(k r1);

    void openChallenge(String r1, Context r2);

    void openGiftDialog();

    void removeKtvChallengeStatusChangedListener(b r1);
}
