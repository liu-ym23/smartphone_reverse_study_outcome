package com.ss.android.lark.chat.cot;

import android.content.Context;
import com.larus.nova.R;
import com.larus.voicecall.impl.subtitle.SubtitleListUpdateType;
import com.ss.android.lark.chat.entity.message.CotStatus;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class h {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f415063a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f415064b = null;

        static {
            int[] r100 = new int[CotStatus.values().length];
            r100[CotStatus.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L32:
            r100[CotStatus.DONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L42:
            r100[CotStatus.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L34:
            r100[CotStatus.PAUSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            r100[CotStatus.INTERRUPTED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L26:
            r100[CotStatus.TIMEOUT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L11:
            f415063a = r100;
            int[] r101 = new int[CotViewBlockType.values().length];
            r101[CotViewBlockType.STEP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L38:
            r101[CotViewBlockType.TOOL_CALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L28:
            r101[CotViewBlockType.TEXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L15:
            f415064b = r101;
        }
    }

    static {
    }

    public static CharSequence a(CotViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        if (r100.getOverallStatus() == CotStatus.RUNNING) goto L5;
        return null;
    L5:
        CotViewBlock r101 = (CotViewBlock) CollectionsKt.lastOrNull(r100.getBlocks());
        if (r101 != null) goto L8;
        return null;
    L8:
        CotViewBlockType r102 = r101.getType();
        int r103 = a.f415064b[r102.ordinal()];
        if (r103 == 1) goto L18;
        if (r103 == 2) goto L20;
        if (r103 == 3) goto L19;
        return null;
    L19:
        return r101.getBody();
    L20:
        return r101.getTitle();
    L18:
        return r101.getTitle();
    }

    public static String c(CotViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        HashMap<String, String> r101 = r100.getRunStatusText();
        if (r101.isEmpty() == false) goto L5;
        return null;
    L5:
        int r102 = a.f415063a[r100.getOverallStatus().ordinal()];
        if (r102 != 1) goto L8;
        CotViewBlock r103 = (CotViewBlock) CollectionsKt.lastOrNull(r100.getBlocks());
        if (r103 == null) goto L23;
        CotViewBlockType r104 = r103.getType();
    L25:
        if (r104 != CotViewBlockType.REASONING) goto L27;
        String r105 = SubtitleListUpdateType.THINKING;
    L28:
        String r106 = r101.get(r105);
        if (r106 != null) goto L31;
        return null;
    L31:
        if ((!StringsKt.isBlank(r106)) == true) goto L33;
        return null;
    L33:
        return r106;
    L27:
        r105 = "running";
        goto L28
    L23:
        r104 = null;
        goto L25
    L8:
        if (r102 != 2) goto L10;
        r105 = "done";
        goto L28
    L10:
        if (r102 != 3) goto L12;
        r105 = "error";
        goto L28
    L12:
        if (r102 != 4) goto L14;
        r105 = "paused";
        goto L28
    L14:
        if (r102 == 5) goto L16;
        return null;
    L16:
        r105 = "interrupted";
        goto L28
    }

    public static String b(CotViewModel r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        CotStatus r102 = r100.getOverallStatus();
        switch(a.f415063a[r102.ordinal()]) {
            case 1: goto L11;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L12;
        };
    L12:
        return r101.getString(R.string.Lark_IM_AgentCot_Preparing_Text);
    L13:
        return r101.getString(R.string.Lark_IM_AgentCot_TaskTimeout_Text);
    L14:
        return r101.getString(R.string.Lark_IM_AgentCot_TaskInterrupted_Text);
    L15:
        return r101.getString(R.string.Lark_IM_AgentCot_TaskPaused_Text);
    L16:
        return r101.getString(R.string.Lark_IM_AgentCot_TaskFailed_Text);
    L17:
        return r101.getString(R.string.Lark_IM_AgentCot_TaskCompleted_Text);
    L11:
        return r101.getString(R.string.Lark_IM_AgentCot_TaskRunning_Text);
    }
}
