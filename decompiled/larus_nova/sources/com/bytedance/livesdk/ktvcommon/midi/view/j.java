package com.bytedance.livesdk.ktvcommon.midi.view;

import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.livesdk.ktvcommon.midi.model.HitType;
import kotlin.Pair;
import py.k;

/* JADX INFO: loaded from: classes20.dex */
public interface j {
    void A();

    int B();

    int C();

    int D();

    Pair<String, String> E();

    int F();

    k G();

    void H();

    String a(HitType r100, boolean r101);

    String b(HitType r100);

    void c();

    void clear();

    int getCurrentMode();

    void y(MidiSkinDressInfo r100);

    MidiSkinDressInfo z();
}
