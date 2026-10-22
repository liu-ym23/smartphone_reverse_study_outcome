package te9;

import com.larus.im.internal.network.link.impl.sami.o;
import com.larus.im.internal.network.link.impl.sami.p;
import com.larus.im.internal.network.link.impl.sami.u;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545629a;

    public e() {
        this.f545629a = "InterruptUplinkHandler";
    }

    @Override // te9.d
    public final String a() {
        return this.f545629a;
    }

    @Override // te9.d
    public final boolean b(xe9.b r100, o r101, pe9.e r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        xe9.c r103 = r100.f563384c;
        if (r103 != null) goto L5;
    L9:
        return false;
    L5:
        if ((r103 instanceof we9.d) == false) goto L9;
        p r104 = u.f349499a;
        SAMICore r105 = r102.f528727a;
        String r106 = r101.f349482b;
        String r107 = r101.f349483c;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        Intrinsics.checkNotNullParameter(r106, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r107, "sessionId");
        SAMICoreVoiceAssistantPropertyParameter r108 = new SAMICoreVoiceAssistantPropertyParameter();
        r108.taskId = r106;
        u.a(r107, r108);
        SAMICoreProperty r109 = new SAMICoreProperty();
        r109.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Interrupt_Call;
        r109.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r109.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r108};
        r109.dataArrayLen = 1;
        u.c("sendInterrupt", r105.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r109), r109);
        return true;
    }
}
