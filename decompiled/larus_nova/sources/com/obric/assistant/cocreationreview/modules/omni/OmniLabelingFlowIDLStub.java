package com.obric.assistant.cocreationreview.modules.omni;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDLSPI;
import com.obric.assistant.cocreationreview.s3;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.StringsKt;
import lda.a0;
import lda.w;
import lda.z;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J@\u0010\u0014\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/omni/OmniLabelingFlowIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowCocreationReviewIDLSPI;", "<init>", "()V", "logOmniStep", "", "recordId", "", "createdAt", "", "userQuery", "stepIndex", "", "stepDescription", "modelReply", "isLastStep", "", "isSuccess", "finishTimeMillis", "taskTriggerType", "logOmniUserStop", "reason", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniLabelingFlowIDLStub implements IFlowCocreationReviewIDLSPI {
    private static final a Companion = null;
    private static final String TAG = "omni.runtime.bridge";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public OmniLabelingFlowIDLStub() {
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniUserStop(String r110, long r111, String r112, long r113, String r114, String r115) {
        String r116 = "";
        if (r110 != null) goto L5;
        String r100 = "";
    L6:
        if (r112 != null) goto L8;
        String r101 = "";
    L9:
        if (r114 != null) goto L11;
        String r102 = "";
    L12:
        OmniTaskTriggerType.a r103 = OmniTaskTriggerType.Companion;
        if (r115 != null) goto L15;
        String r104 = "";
    L16:
        r103.getClass();
        a0 r105 = new a0(r100, r111, r101, r113, r102, OmniTaskTriggerType.a.a(r104));
        if (StringsKt.isBlank(r105.f508781a) == false) goto L19;
    L33:
        int r106 = s3.f387719a;
        s3.c(TAG, "skip invalid user stop recordId=" + r105.f508781a + ", queryLength=" + r105.f508783c.length());
        return;
    L19:
        if (StringsKt.isBlank(r105.f508783c) == true) goto L33;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L23
        z.b(r105);     // Catch: Throwable -> L23
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L37;
        int r117 = s3.f387719a;
        String r118 = r109.getMessage();
        if (r118 == null) goto L31;
        r116 = r118;
    L31:
        s3.c(TAG, "handle user stop failed error=".concat(r116));
        return;
    L37:
        return;
    L23:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L15:
        r104 = r115;
        goto L16
    L11:
        r102 = r114;
        goto L12
    L8:
        r101 = r112;
        goto L9
    L5:
        r100 = r110;
        goto L6
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniStep(String r110, long r111, String r112, int r210, String r211, String r212, boolean r213, boolean r214, long r215, String r216) {
        String r113 = "";
        if (r110 != null) goto L5;
        String r100 = "";
    L6:
        if (r112 != null) goto L8;
        String r101 = "";
    L9:
        if (r211 != null) goto L11;
        String r102 = "";
    L12:
        if (r212 != null) goto L14;
        String r103 = "";
    L15:
        OmniTaskTriggerType.a r104 = OmniTaskTriggerType.Companion;
        if (r216 != null) goto L18;
        String r105 = "";
    L19:
        r104.getClass();
        w r106 = new w(r100, r111, r101, r210, r102, r103, r213, r214, r215, OmniTaskTriggerType.a.a(r105));
        if (StringsKt.isBlank(r106.f508837a) == false) goto L22;
    L36:
        int r107 = s3.f387719a;
        s3.c(TAG, "skip invalid step recordId=" + r106.f508837a + ", queryLength=" + r106.f508839c.length());
        return;
    L22:
        if (StringsKt.isBlank(r106.f508839c) == true) goto L36;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L26
        z.a(r106);     // Catch: Throwable -> L26
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r109);
        if (r114 == null) goto L40;
        int r115 = s3.f387719a;
        String r116 = r114.getMessage();
        if (r116 == null) goto L34;
        r113 = r116;
    L34:
        s3.c(TAG, "handle step failed error=".concat(r113));
        return;
    L40:
        return;
    L26:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L18:
        r105 = r216;
        goto L19
    L14:
        r103 = r212;
        goto L15
    L11:
        r102 = r211;
        goto L12
    L8:
        r101 = r112;
        goto L9
    L5:
        r100 = r110;
        goto L6
    }
}
