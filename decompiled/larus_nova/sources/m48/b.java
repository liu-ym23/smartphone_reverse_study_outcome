package m48;

import androidx.fragment.app.Fragment;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import pr9.d;
import pr9.h;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d54.a f511894a;

    public static final class a {
    }

    /* JADX INFO: renamed from: m48.b$b, reason: collision with other inner class name */
    public static final class C6769b implements k54.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f511895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ pr9.b f511896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f511897c;

        /* JADX INFO: renamed from: m48.b$b$a */
        public static final class a implements b54.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f511898a;

            @Override // b54.a
            public final void onRefreshFinish() {
                d r100 = this.f511898a;
                if (r100 == null) goto L6;
                r100.onRefreshFinish();
                return;
            }

            @Override // b54.a
            public final void onRefreshStartManually() {
                d r100 = this.f511898a;
                if (r100 == null) goto L6;
                r100.onRefreshStartManually();
                return;
            }

            @Override // b54.a
            public final void onReleaseAndRefresh() {
                d r100 = this.f511898a;
                if (r100 == null) goto L6;
                r100.onReleaseAndRefresh();
                return;
            }

            @Override // b54.a
            public final void onReleaseAndScrollBack() {
                d r100 = this.f511898a;
                if (r100 == null) goto L6;
                r100.onReleaseAndScrollBack();
                return;
            }

            public a(d r100) {
                this.f511898a = r100;
            }

            @Override // b54.a
            public final void onOverScroll(float r100, float r101) {
                d r102 = this.f511898a;
                if (r102 == null) goto L6;
                r102.g();
                return;
            }
        }

        @Override // k54.c
        public final void g(String r100) {
            Intrinsics.checkNotNullParameter(r100, "aid");
        }

        @Override // k54.c
        public final b54.a a() {
            return new a(this.f511895a);
        }

        @Override // k54.c
        public final void onLoadSuccess() {
            this.f511896b.onLoadSuccess();
        }

        @Override // k54.c
        public final void j(k54.b r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            pr9.b r101 = this.f511896b;
            this.f511897c.getClass();
            if ((r100 instanceof k54.b.c) == false) goto L6;
            CustomFeedPlayerEvent r102 = new CustomFeedPlayerEvent.FirstFrame(r100.f501834a, r100.f501835b);
        L44:
            r101.b(r102);
            return;
        L6:
            if ((r100 instanceof k54.b.h) == false) goto L9;
            r102 = new CustomFeedPlayerEvent.StartPlay(r100.f501834a, r100.f501835b);
            goto L44
        L9:
            if ((r100 instanceof k54.b.i) == false) goto L11;
            r102 = new CustomFeedPlayerEvent.StopPlay(r100.f501834a, r100.f501835b);
            goto L44
        L11:
            int r103 = 0;
            Integer r104 = null;
            if ((r100 instanceof k54.b.d) == false) goto L24;
            Map<String, ? extends Object> r105 = r100.f501836c;
            if (r105 == null) goto L16;
            Object r106 = r105.get("reason");
        L18:
            if ((r106 instanceof Integer) == false) goto L20;
            r104 = (Integer) r106;
        L20:
            if (r104 == null) goto L22;
            r103 = r104.intValue();
        L22:
            r102 = new CustomFeedPlayerEvent.PausePlay(r100.f501834a, r100.f501835b, r103);
            goto L44
        L16:
            r106 = null;
            goto L18
        L24:
            if ((r100 instanceof k54.b.g) == false) goto L36;
            Map<String, ? extends Object> r107 = r100.f501836c;
            if (r107 == null) goto L28;
            Object r108 = r107.get("reason");
        L30:
            if ((r108 instanceof Integer) == false) goto L32;
            r104 = (Integer) r108;
        L32:
            if (r104 == null) goto L34;
            r103 = r104.intValue();
        L34:
            r102 = new CustomFeedPlayerEvent.ResumePlay(r100.f501834a, r100.f501835b, r103);
            goto L44
        L28:
            r108 = null;
            goto L30
        L36:
            if ((r100 instanceof k54.b.C6508b) == false) goto L39;
            r102 = new CustomFeedPlayerEvent.CompletePlay(r100.f501834a, r100.f501835b);
            goto L44
        L39:
            if ((r100 instanceof k54.b.f) == false) goto L42;
            r102 = new CustomFeedPlayerEvent.RestartPlay(r100.f501834a, r100.f501835b);
            goto L44
        L42:
            if ((r100 instanceof k54.b.e) == false) goto L47;
            r102 = new CustomFeedPlayerEvent.PlayError(r100.f501834a, r100.f501835b);
            goto L44
        L47:
            throw new NoWhenBranchMatchedException();
        }

        @Override // k54.c
        public final void onLoadError(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f511896b.onLoadError(r100);
        }

        public C6769b(d r100, pr9.b r101, b r102) {
            this.f511895a = r100;
            this.f511896b = r101;
            this.f511897c = r102;
        }

        @Override // k54.c
        public final void e(boolean r100, String r101, k54.a r102) {
            Intrinsics.checkNotNullParameter(r101, "aid");
            Intrinsics.checkNotNullParameter(r102, "feedItemInfo");
            FLogger.f375446a.d("CustomIRecFeedFragment", "notifyFeedChange: ");
            this.f511896b.c(r100, r101);
        }
    }

    static {
    }

    @Override // pr9.h
    public final void N7() {
        this.f511894a.N7();
    }

    @Override // pr9.h
    public final void V5() {
        this.f511894a.V5();
    }

    @Override // pr9.h
    public final Fragment f() {
        return this.f511894a.f();
    }

    @Override // pr9.h
    public final boolean onBackPressed() {
        Boolean r100 = this.f511894a.onBackPressed();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public b(d54.a r100) {
        Intrinsics.checkNotNullParameter(r100, "iRecFeedFragment");
        this.f511894a = r100;
    }

    @Override // pr9.h
    public final void xQ(pr9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        d r101 = r100.a();
        this.f511894a.RF(new C6769b(r101, r100, this));
    }
}
