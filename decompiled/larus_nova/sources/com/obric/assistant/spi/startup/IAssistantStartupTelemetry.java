package com.obric.assistant.spi.startup;

import android.os.SystemClock;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JP\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH&J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H&J\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\fH&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u0003H&J\"\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0018H&J&\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016J@\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH&J@\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\n\u0010 \u001a\u0004\u0018\u00010\u0003H&¨\u0006!"}, d2 = {"Lcom/obric/assistant/spi/startup/IAssistantStartupTelemetry;", "", GearStrategyConsts.EV_SELECT_BEGIN, "", "spec", "Lcom/obric/assistant/spi/startup/AssistantStartupAttemptSpec;", "updateAttempt", "", "attemptId", "action", PickerReporterConstants.KEY.TARGET, "requiredMilestones", "", "attributes", "", "replaceRequiredMilestone", "oldMilestone", "newMilestone", "addRequiredMilestones", "milestones", "activeAttemptIdRequiring", "milestone", "markReady", "timestampElapsedRealtimeMs", "", "markFirstFrame", "source", VideoEventOneOutSync.END_TYPE_FINISH, "result", "reason", "reportDetachedResult", "discard", "activeAttemptId", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAssistantStartupTelemetry {

    public static final class a {
        public static /* synthetic */ void b(AssistantStartupTelemetry r100, String r101) {
            r100.k(r101, SystemClock.elapsedRealtime(), "main_view");
        }

        public static /* synthetic */ boolean c(AssistantStartupTelemetry r100, String r101, String r102) {
            return r100.d(r101, r102, SystemClock.elapsedRealtime());
        }

        public static /* synthetic */ boolean d(AssistantStartupTelemetry r100, uga.a r101, String r102, String r110) {
            return r100.e(r101, r102, r110, SystemClock.elapsedRealtime(), MapsKt.emptyMap());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean a(IAssistantStartupTelemetry r100, String r110, String r111, String r112, Map r113, int r114) {
            if ((r114 & 8) == 0) goto L5;
            long r101 = SystemClock.elapsedRealtime();
        L6:
            long r102 = r101;
            if ((r114 & 16) == 0) goto L10;
            r113 = MapsKt.emptyMap();
        L10:
            return r100.j(r110, r111, r112, r102, r113);
        L5:
            r101 = 0;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void e(AssistantStartupTelemetry r100, String r101, String r102, Set r103, Map r110, int r111) {
            if ((r111 & 4) == 0) goto L5;
            String r104 = null;
        L7:
            if ((r111 & 8) == 0) goto L9;
            Set r105 = null;
        L11:
            if ((r111 & 16) == 0) goto L13;
            r110 = MapsKt.emptyMap();
        L13:
            r100.g(r101, null, r104, r105, r110);
            return;
        L9:
            r105 = r103;
            goto L11
        L5:
            r104 = r102;
            goto L7
        }
    }

    String a(uga.a r100);

    boolean b(String r100, Set<String> r101);

    boolean c(String r100, String r101, String r102);

    boolean d(String r100, String r101, long r102);

    boolean e(uga.a r100, String r101, String r102, long r103, Map<String, String> r104);

    boolean f(String r100);

    boolean g(String r100, String r101, String r102, Set<String> r103, Map<String, String> r104);

    String h();

    String i(String r100);

    boolean j(String r100, String r101, String r102, long r103, Map<String, String> r104);

    boolean k(String r100, long r101, String r102);
}
