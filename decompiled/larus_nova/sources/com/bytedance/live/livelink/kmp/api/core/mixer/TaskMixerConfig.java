package com.bytedance.live.livelink.kmp.api.core.mixer;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;
import ti6.c;
import ti6.h;
import ti6.j;

/* JADX INFO: loaded from: classes19.dex */
public final class TaskMixerConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MixStreamType f255244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TaskType f255245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f255246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f255247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f255248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f255249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f255250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f255251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f255252i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<? extends j> f255253j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/core/mixer/TaskMixerConfig$TaskType;", "", AccountType.MAIN, "EXTRA", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum TaskType extends Enum<TaskType> {
        public static final TaskType EXTRA = null;
        public static final TaskType MAIN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TaskType[] f255254a = null;

        static {
            TaskType r100 = new TaskType(AccountType.MAIN, 0);
            MAIN = r100;
            TaskType r101 = new TaskType("EXTRA", 1);
            EXTRA = r101;
            f255254a = new TaskType[]{r100, r101};
        }

        public static TaskType valueOf(String r100) {
            return (TaskType) a.a(TaskType.class, r100);
        }

        public static TaskType[] values() {
            return (TaskType[]) f255254a.clone();
        }

        public TaskType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("TaskMixerConfig(mixStreamType=");
        r100.append(this.f255244a);
        r100.append(", taskType=");
        r100.append(this.f255245b);
        r100.append(", taskId='");
        r100.append(this.f255246c);
        r100.append("', roomId='");
        r100.append(this.f255247d);
        r100.append("', (streamMixer!=null)='");
        boolean r101 = true;
        if (this.f255248e == null) goto L5;
        boolean r102 = true;
    L6:
        r100.append(r102);
        r100.append("', (mixStreamConfig!=null)='");
        if (this.f255249f == null) goto L9;
        boolean r103 = true;
    L10:
        r100.append(r103);
        r100.append("', (mixSteamCallBack!=null)='");
        if (this.f255253j != null) goto L14;
        r101 = false;
    L14:
        r100.append(r101);
        r100.append("')");
        return r100.toString();
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public TaskMixerConfig() {
        this.f255244a = MixStreamType.SERVER_MIX;
        this.f255245b = TaskType.MAIN;
        this.f255246c = "";
        this.f255247d = "";
    }

    public final void a(MixStreamType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f255244a = r100;
    }

    public final void b(TaskType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f255245b = r100;
    }
}
