package oz0;

import android.content.Context;
import com.bytedance.android.live.base.model.m;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;
import vh7.e;
import vlc.l;
import zh6.c;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements zh6.a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f527169a;

    /* JADX INFO: renamed from: oz0.a$a, reason: collision with other inner class name */
    public static final class C7132a implements zh6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, l> f527170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.android.livesdk.revenue.message.b f527171b;

        /* JADX INFO: renamed from: oz0.a$a$a, reason: collision with other inner class name */
        public static final class C7133a implements l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ zh6.b.a f527172a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Class f527173b;

            public C7133a(zh6.b.a r100, Class r101) {
                this.f527172a = r100;
                this.f527173b = r101;
            }

            @Override // vlc.l
            public final void onMessage(d r100) {
                zh6.b.a r101 = this.f527172a;
                if (r100 == null) goto L11;
                e r102 = m.a((vh7.c) r100, this.f527173b);
                if (r102 == null) goto L9;
                r101.a((yh6.c) r102);
                return;
            L9:
                throw new NullPointerException("null cannot be cast to non-null type T");
            L11:
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<*>");
            }
        }

        /* JADX INFO: renamed from: oz0.a$a$b */
        public static final class b implements l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ zh6.b.a f527174a;

            public b(zh6.b.a r100) {
                this.f527174a = r100;
            }

            @Override // vlc.l
            public final void onMessage(d r100) {
                zh6.b.a r101 = this.f527174a;
                if (r100 == null) goto L7;
                r101.a((yh6.c) r100);
                return;
            L7:
                throw new NullPointerException("null cannot be cast to non-null type T");
            }
        }

        @Override // zh6.b
        public final void release() {
            this.f527171b.release();
        }

        @Override // zh6.b
        public final void startMessage() {
            this.f527171b.startMessage();
        }

        public C7132a(com.bytedance.android.livesdk.revenue.message.b r100) {
            Intrinsics.checkNotNullParameter(r100, "manager");
            this.f527171b = r100;
            this.f527170a = new LinkedHashMap();
        }

        @Override // zh6.b
        public final <T extends yh6.c> void a(yh6.b<T> r100, zh6.b.a<T> r101) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
            Intrinsics.checkNotNullParameter(r101, "listener");
            Map<String, l> r102 = this.f527170a;
            LinkedHashMap r103 = (LinkedHashMap) r102;
            l r104 = (l) r103.get(r100.getName());
            if (r104 == null) goto L6;
            this.f527171b.removeMessageListener(r100.getName(), r104);
            l r105 = this.f527170a.remove(r100.getName());
            return;
        }

        public final <T extends yh6.c> void b(yh6.b<T> r100, zh6.b.a<T> r101) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
            Intrinsics.checkNotNullParameter(r101, "listener");
            Class<T> r102 = r100.getType().getType();
            if (e.class.isAssignableFrom(r102) == false) goto L5;
            l r103 = new C7133a(r101, r102);
        L6:
            this.f527170a.put(r100.getName(), r103);
            this.f527171b.addMessageListener(r100.getName(), r103);
            return;
        L5:
            r103 = new b(r101);
            goto L6
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f527169a = r100;
    }

    @Override // zh6.a
    public final C7132a f(String r100, Context r101, Map r102) {
        Intrinsics.checkNotNullParameter("linkmic_channel", "scene");
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "extraParams");
        return new C7132a(this.f527169a.f(r100, r101, r102));
    }
}
