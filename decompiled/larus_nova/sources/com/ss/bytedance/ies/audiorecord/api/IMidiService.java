package com.ss.bytedance.ies.audiorecord.api;

import com.ss.android.ugc.aweme.framework.services.dyext.annotation.DouyinImpl;
import com.ss.bytedance.ies.audiorecord.api.model.KtvMidiData;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/ss/bytedance/ies/audiorecord/api/IMidiService;", "", "getMidiDrawingData", "", "Lcom/ss/bytedance/ies/audiorecord/api/model/KtvMidiData;", "midiFile", "", "audiorecord-api-0.0.0.2-alpha.93@aar_release"}, k = 1, mv = {1, 1, 16})
@DouyinImpl(plugin = "com.ss.android.ugc.aweme.iesvideoclip")
public interface IMidiService {
    List<KtvMidiData> getMidiDrawingData(String r100);
}
