package com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.model.api.h0;
import com.bytedance.android.live.ktv.common.model.api.x0;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressPageItem;
import com.bytedance.android.livesdkapi.depend.message.TagDressPageItem;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {
    void changeDress(int r1, String r2, String r3, int r4, int r5);

    TagDressPageItem getCurrentSelectHonorTag();

    MidiSkinDressPageItem getCurrentSelectMidiSkin();

    void getPageDressList();

    boolean hasNewKtvDress();

    void observeHonorTagList(LifecycleOwner r1, Observer<x0> r2);

    void observeKtvDressChangedState(LifecycleOwner r1, Observer<Pair<Integer, Integer>> r2);

    void observeMidiSkinList(LifecycleOwner r1, Observer<h0> r2);

    x0 obtainHonorTagList();

    h0 obtainMidiSkinList();

    void wearMidiSkin();
}
