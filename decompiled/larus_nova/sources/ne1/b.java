package ne1;

import com.bytedance.android.livesdk.arch.task.TaskId;
import com.bytedance.android.livesdk.arch.task.TaskResult;
import com.lynx.tasm.LynxError;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f518858a;

    public static class a extends b {

        /* JADX INFO: renamed from: ne1.b$a$a, reason: collision with other inner class name */
        public static final class C6916a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C6916a f518859b = null;

            static {
                f518859b = new C6916a();
            }

            public C6916a() {
                super("任务链完成");
            }
        }

        /* JADX INFO: renamed from: ne1.b$a$b, reason: collision with other inner class name */
        public static final class C6917b extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Throwable f518860b;

            public C6917b(Throwable r100) {
                Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
                super("任务链执行异常");
                this.f518860b = r100;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f518861b = null;

            static {
                f518861b = new c();
            }

            public c() {
                super("任务链开始");
            }
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
            super(r100);
        }
    }

    /* JADX INFO: renamed from: ne1.b$b, reason: collision with other inner class name */
    public static class C6918b extends b {

        /* JADX INFO: renamed from: ne1.b$b$a */
        public static final class a extends C6918b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f518862b = null;

            static {
                f518862b = new a();
            }

            public a() {
                super("加载Behavior");
            }
        }

        /* JADX INFO: renamed from: ne1.b$b$b, reason: collision with other inner class name */
        public static final class C6919b extends C6918b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C6919b f518863b = null;

            static {
                f518863b = new C6919b();
            }

            public C6919b() {
                super("卸载Behavior");
            }
        }

        /* JADX INFO: renamed from: ne1.b$b$c */
        public static final class c extends C6918b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f518864b = null;

            static {
                f518864b = new c();
            }

            public c() {
                super("更新Behavior");
            }
        }

        public C6918b(String r100) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
            super(r100);
        }
    }

    public static class c extends b {
        public c() {
            super("预加载内容");
        }
    }

    public static class d extends b {
        public d(TaskId r100) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            super(r100.name());
        }
    }

    public static class e extends b {
        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
            super(r100);
        }
    }

    public static class f extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TaskResult.b f518865b;

        public f(TaskResult.b r100) {
            Intrinsics.checkNotNullParameter(r100, "failure");
            super(r100.f103872b.name());
            this.f518865b = r100;
        }
    }

    public static class g extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TaskResult.c f518866b;

        public g(TaskResult.c r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            super(r100.f103872b.name());
            this.f518866b = r100;
        }
    }

    public b(String r100) {
        this.f518858a = r100;
    }
}
