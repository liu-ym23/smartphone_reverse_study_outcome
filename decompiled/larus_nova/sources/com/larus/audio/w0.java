package com.larus.audio;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.EditPos;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public interface w0 {
    void a(Fragment r100, SpeakerVoice r101, EditPos r102);

    LiveData<Integer> b(Fragment r100);

    LiveData<ArrayList<p68.h>> c(Fragment r100);
}
