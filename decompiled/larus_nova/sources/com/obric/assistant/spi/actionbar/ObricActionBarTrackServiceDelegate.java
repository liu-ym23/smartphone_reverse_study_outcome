package com.obric.assistant.spi.actionbar;

import android.view.View;
import android.widget.TextView;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.im.bean.message.ReferenceInfo;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0001J2\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0002\u0010\u0012J1\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018H\u0096\u0001J\u001b\u0010\u0019\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0096\u0001¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/spi/actionbar/ObricActionBarTrackServiceDelegate;", "Lcom/obric/assistant/spi/actionbar/IObricActionBarTrackService;", "<init>", "()V", "getCurrentModelLevel", "", "getObricMockClickActionBarKey", "getReferenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "onObricActionBarInstructionShow", "", "tag", "Landroid/widget/TextView;", "status", "", "displayText", "itemView", "Landroid/view/View;", "(Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/String;Landroid/view/View;)V", "onObricVoiceAuthenAsrUpdate", "lifeState", "Lcom/larus/audio/audiov3/task/asr/AsrLifeState;", DBDefinition.TASK_ID, "extraMap", "", "setObricVoiceAuthenParams", "json", "Lorg/json/JSONObject;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActionBarTrackServiceDelegate implements IObricActionBarTrackService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricActionBarTrackServiceDelegate f392818b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricActionBarTrackService f392819a;

    static {
        f392818b = new ObricActionBarTrackServiceDelegate();
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final String h() {
        return this.f392819a.h();
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final void k(TextView r100, Integer r101, String r102, View r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r103, "itemView");
        this.f392819a.k(r100, r101, r102, r103);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final void n(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "json");
        this.f392819a.n(r100, r101);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final String p() {
        return this.f392819a.p();
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final ReferenceInfo r() {
        return this.f392819a.r();
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final void t(AsrLifeState r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "lifeState");
        this.f392819a.t(r100, r101, r102);
    }

    private ObricActionBarTrackServiceDelegate() {
        IObricActionBarTrackService r100 = (IObricActionBarTrackService) ServiceManager.get().getService(IObricActionBarTrackService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricActionBarTrackServiceImpl();
    L5:
        this.f392819a = r100;
    }
}
