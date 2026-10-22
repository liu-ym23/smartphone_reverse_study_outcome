package com.obric.assistant.spi.startup;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uga.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0001H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016JH\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012H\u0016J \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u001e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J \u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\"\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0016J<\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012H\u0016J<\u0010\"\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012H\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010'\u001a\u0002H&2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0082\b¢\u0006\u0002\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/assistant/spi/startup/AssistantStartupTelemetry;", "Lcom/obric/assistant/spi/startup/IAssistantStartupTelemetry;", "<init>", "()V", "TAG", "", "service", GearStrategyConsts.EV_SELECT_BEGIN, "spec", "Lcom/obric/assistant/spi/startup/AssistantStartupAttemptSpec;", "updateAttempt", "", "attemptId", "action", PickerReporterConstants.KEY.TARGET, "requiredMilestones", "", "attributes", "", "replaceRequiredMilestone", "oldMilestone", "newMilestone", "addRequiredMilestones", "milestones", "activeAttemptIdRequiring", "milestone", "markReady", "timestampElapsedRealtimeMs", "", "markFirstFrame", "source", VideoEventOneOutSync.END_TYPE_FINISH, "result", "reason", "reportDetachedResult", "discard", "activeAttemptId", "safely", ExifInterface.GPS_DIRECTION_TRUE, "fallback", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantStartupTelemetry implements IAssistantStartupTelemetry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AssistantStartupTelemetry f392915a = null;

    static {
        f392915a = new AssistantStartupTelemetry();
    }

    private AssistantStartupTelemetry() {
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final String h() {
        f392915a.getClass();     // Catch: Exception -> L4 CancellationException -> L6
    L10:
        return l().h();
    L6:
        e = move-exception;
        throw e;
    L4:
        return null;
    }

    public static IAssistantStartupTelemetry l() {
        return (IAssistantStartupTelemetry) ServiceManager.get().getService(IAssistantStartupTelemetry.class);
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final String a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        String r101 = r100.f550057a;
        if (r101 != null) goto L5;
    L9:
        r101 = UUID.randomUUID().toString();
    L29:
        f392915a.getClass();     // Catch: Exception -> L12 CancellationException -> L25
        String r102 = l().a(a.a(r100, r101));     // Catch: Exception -> L12 CancellationException -> L25
    L14:
        if ((!StringsKt.isBlank(r102)) == true) goto L16;
    L24:
        return r102;
    L16:
        if (Intrinsics.areEqual(r102, r101) == true) goto L24;
        f392915a.getClass();     // Catch: Exception -> L27 CancellationException -> L22
        l().f(r101);     // Catch: Exception -> L27 CancellationException -> L22
    L22:
        e = move-exception;
        throw e;
    L33:
        f392915a.getClass();     // Catch: Exception -> L28 CancellationException -> L20
        l().f(r102);     // Catch: Exception -> L28 CancellationException -> L20
    L20:
        e = move-exception;
        throw e;
    L19:
        return "";
    L25:
        e = move-exception;
        throw e;
    L12:
        r102 = "";
        goto L14
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 != null) goto L29;
        goto L9
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "attemptId");
        f392915a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().f(r100);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final String i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "milestone");
        f392915a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().i(r100);
    L7:
        e = move-exception;
        throw e;
    L5:
        return null;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean b(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "attemptId");
        Intrinsics.checkNotNullParameter(r101, "milestones");
        f392915a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().b(r100, r101);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "attemptId");
        Intrinsics.checkNotNullParameter(r101, "oldMilestone");
        Intrinsics.checkNotNullParameter(r102, "newMilestone");
        f392915a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().c(r100, r101, r102);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean d(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "attemptId");
        Intrinsics.checkNotNullParameter(r101, "milestone");
        f392915a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().d(r100, r101, r102);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean k(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "attemptId");
        f392915a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().k(r100, r101, r102);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean e(a r100, String r110, String r111, long r112, Map<String, String> r113) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        Intrinsics.checkNotNullParameter(r110, "result");
        Intrinsics.checkNotNullParameter(r111, "reason");
        Intrinsics.checkNotNullParameter(r113, "attributes");
        f392915a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().e(r100, r110, r111, r112, r113);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean g(String r100, String r101, String r110, Set<String> r111, Map<String, String> r112) {
        Intrinsics.checkNotNullParameter(r100, "attemptId");
        Intrinsics.checkNotNullParameter(r112, "attributes");
        f392915a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().g(r100, r101, r110, r111, r112);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean j(String r100, String r110, String r111, long r112, Map<String, String> r113) {
        Intrinsics.checkNotNullParameter(r100, "attemptId");
        Intrinsics.checkNotNullParameter(r110, "result");
        Intrinsics.checkNotNullParameter(r111, "reason");
        Intrinsics.checkNotNullParameter(r113, "attributes");
        f392915a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().j(r100, r110, r111, r112, r113);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }
}
