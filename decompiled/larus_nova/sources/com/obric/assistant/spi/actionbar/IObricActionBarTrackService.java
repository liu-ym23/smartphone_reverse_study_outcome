package com.obric.assistant.spi.actionbar;

import android.view.View;
import android.widget.TextView;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.im.bean.message.ReferenceInfo;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u001a\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0012H&J0\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0017H&J\b\u0010\u0018\u001a\u00020\tH&J\b\u0010\u0019\u001a\u00020\tH&¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/spi/actionbar/IObricActionBarTrackService;", "", "onObricActionBarInstructionShow", "", "tag", "Landroid/widget/TextView;", "status", "", "displayText", "", "itemView", "Landroid/view/View;", "(Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/String;Landroid/view/View;)V", "getReferenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "setObricVoiceAuthenParams", DBDefinition.TASK_ID, "json", "Lorg/json/JSONObject;", "onObricVoiceAuthenAsrUpdate", "lifeState", "Lcom/larus/audio/audiov3/task/asr/AsrLifeState;", "extraMap", "", "getObricMockClickActionBarKey", "getCurrentModelLevel", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricActionBarTrackService {
    String h();

    void k(TextView r100, Integer r101, String r102, View r103);

    void n(String r100, JSONObject r101);

    String p();

    ReferenceInfo r();

    void t(AsrLifeState r100, String r101, Map<String, String> r102);
}
