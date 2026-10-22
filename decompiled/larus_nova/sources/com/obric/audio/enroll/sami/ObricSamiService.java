package com.obric.audio.enroll.sami;

import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.obric.assistant.common.spi.IObricSamiService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import gd9.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/audio/enroll/sami/ObricSamiService;", "Lcom/obric/assistant/common/spi/IObricSamiService;", "Lcom/larus/im/depend/IPersonalContextProvider;", "<init>", "()V", "TAG", "", "resetAec", "", "samiCore", "", "getPersonalContextParam", PerfLog.PARAM_KEY_CONTEXT_ID, DBDefinition.TASK_ID, "getPersonalContextId", "getPersonalContextType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSamiService implements IObricSamiService, x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f395489a;

    @Override // com.obric.assistant.common.spi.IObricSamiService, gd9.x
    public final SAMICorePropertyId b() {
        FLogger.f375446a.i(this.f395489a, "getPersonalContextId: Voice_Assistant_Update_Personal_Context");
        return SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Update_Personal_Context;
    }

    @Override // com.obric.assistant.common.spi.IObricSamiService, gd9.x
    public final SAMICoreDataType c() {
        FLogger.f375446a.i(this.f395489a, "getPersonalContextType: Voice_Assistant_Property_Param");
        return SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
    }

    public ObricSamiService() {
        this.f395489a = "ObricSamiAbility";
    }

    @Override // com.obric.assistant.common.spi.IObricSamiService
    public final void d(SAMICore r100) {
        Intrinsics.checkNotNullParameter(r100, "samiCore");
        FLogger.f375446a.i(this.f395489a, "resetAec");
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICorePropertyId r102 = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Reset_Aec;
        r101.f384359id = r102;
        if ((r100 instanceof SAMICore) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L9;
        r100.SAMICoreSetProperty(r102, r101);
        return;
    }

    @Override // com.obric.assistant.common.spi.IObricSamiService, gd9.x
    public final SAMICoreVoiceAssistantPropertyParameter a(String r100, String r101) {
        FLogger.f375446a.i(this.f395489a, "getPersonalContextParam: " + r100 + com.alipay.sdk.m.n.a.f25612h + r100 + ", " + r101 + com.alipay.sdk.m.n.a.f25612h + r101);
        SAMICoreVoiceAssistantPropertyParameter r102 = new SAMICoreVoiceAssistantPropertyParameter();
        r102.updatePersonalContextPayload = r100;
        r102.taskId = r101;
        return r102;
    }
}
