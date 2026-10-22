package com.larus.apm.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J0\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/larus/apm/api/IApmTrace;", "", "addPerfTag", "", "key", "", "value", "addTag", "traceAll", "reportApmEvent", "category", "Lorg/json/JSONObject;", "metric", "extra", "reportTeaEvent", "startApmScene", "scene", "stopApmScene", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IApmTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286937a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J,\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/larus/apm/api/IApmTrace$Companion;", "Lcom/larus/apm/api/IApmTrace;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/apm/api/IApmTrace;", "impl$delegate", "Lkotlin/Lazy;", "addPerfTag", "", "key", "", "value", "addTag", "traceAll", "reportApmEvent", "category", "Lorg/json/JSONObject;", "metric", "extra", "reportTeaEvent", "startApmScene", "scene", "stopApmScene", "ApmScene", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IApmTrace {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f286938b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IApmTrace> f286939c = null;

        /* JADX INFO: loaded from: classes24.dex */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/apm/api/IApmTrace$Companion$ApmScene;", "", "<init>", "(Ljava/lang/String;I)V", "DORA_QUERY", "TTS_PLAY", "REALTIME_CALL", "NAVIGATION_LOCATING", "MUSIC_PLAY", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum ApmScene extends Enum<ApmScene> {
            public static final ApmScene DORA_QUERY = null;
            public static final ApmScene MUSIC_PLAY = null;
            public static final ApmScene NAVIGATION_LOCATING = null;
            public static final ApmScene REALTIME_CALL = null;
            public static final ApmScene TTS_PLAY = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ApmScene[] f286940a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f286941b = null;

            public static EnumEntries<ApmScene> getEntries() {
                return f286941b;
            }

            static {
                ApmScene r100 = new ApmScene("DORA_QUERY", 0);
                DORA_QUERY = r100;
                ApmScene r101 = new ApmScene("TTS_PLAY", 1);
                TTS_PLAY = r101;
                ApmScene r102 = new ApmScene("REALTIME_CALL", 2);
                REALTIME_CALL = r102;
                ApmScene r103 = new ApmScene("NAVIGATION_LOCATING", 3);
                NAVIGATION_LOCATING = r103;
                ApmScene r104 = new ApmScene("MUSIC_PLAY", 4);
                MUSIC_PLAY = r104;
                ApmScene[] r105 = {r100, r101, r102, r103, r104};
                f286940a = r105;
                f286941b = EnumEntriesKt.enumEntries(r105);
            }

            public static ApmScene[] values() {
                return (ApmScene[]) f286940a.clone();
            }

            public static ApmScene valueOf(String r100) {
                return (ApmScene) a.a(ApmScene.class, r100);
            }

            public ApmScene(String r100, int r101) {
                super(r100, r101);
            }
        }

        private Companion() {
        }

        static {
            f286938b = new Companion();
            f286939c = LazyKt.lazy(new p48.a());
        }

        public static IApmTrace h() {
            return f286939c.getValue();
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void b() {
            Intrinsics.checkNotNullParameter("TYPEWRITER", "key");
            Intrinsics.checkNotNullParameter("STOP", "value");
            IApmTrace r100 = h();
            if (r100 == null) goto L6;
            r100.b();
            return;
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            IApmTrace r101 = h();
            if (r101 == null) goto L6;
            r101.e(r100);
            return;
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void g(String r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            IApmTrace r101 = h();
            if (r101 == null) goto L6;
            r101.g(r100);
            return;
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            IApmTrace r102 = h();
            if (r102 == null) goto L6;
            r102.a(r100, r101);
            return;
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void c(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            IApmTrace r102 = h();
            if (r102 == null) goto L6;
            r102.c(r100, r101);
            return;
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            IApmTrace r102 = h();
            if (r102 == null) goto L6;
            r102.d(r100, r101);
            return;
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void f(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "category");
            IApmTrace r104 = h();
            if (r104 == null) goto L6;
            r104.f(r100, r101, r102, r103);
            return;
        }
    }

    static {
        f286937a = Companion.f286938b;
    }

    void a(String r100, String r101);

    void b();

    void c(String r100, JSONObject r101);

    void d(String r100, String r101);

    void e(String r100);

    void f(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void g(String r100);
}
