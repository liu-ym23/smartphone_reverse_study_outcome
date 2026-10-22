package tb9;

import android.view.View;
import com.larus.home.api.feed.FlowFeedActionScene;
import com.larus.home.impl.main.side_bar.feed.SideBarFeedCardType;
import com.larus.home.impl.main.side_bar.feed.factory.SideBarProjectEmptyAction;
import com.larus.home.impl.main.side_bar.view.group.module.j0;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import eb9.o;
import eb9.p;
import eb9.u;
import eb9.v;
import eb9.w;
import eb9.x;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d implements w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SideBarFeedCardType f545297c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f545298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SideBarFeedCardType f545299b;

    public static final class a {
    }

    public static final class b implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f545300a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f545301a = null;

            static {
                int[] r100 = new int[SideBarProjectEmptyAction.values().length];
                r100[SideBarProjectEmptyAction.CREATE_BLANK_PROJECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                f545301a = r100;
            }
        }

        public b(d r100) {
            this.f545300a = r100;
        }

        @Override // eb9.p
        public final boolean a(o<?> r100, u r101) {
            Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            return false;
        }

        @Override // eb9.p
        public final boolean c(o<?> r100, u r101) {
            Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // eb9.p
        public final void d(o<?> r100, int r101, u r102) {
            Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            DATA r103 = r100.f471909c;
            if ((r103 instanceof SideBarProjectEmptyAction) == false) goto L5;
            SideBarProjectEmptyAction r104 = (SideBarProjectEmptyAction) r103;
        L7:
            if (r104 != null) goto L9;
            int r105 = -1;
        L10:
            if (r105 != (-1)) goto L12;
            return;
        L12:
            if (r105 != 1) goto L15;
            this.f545300a.f545298a.invoke();
            return;
        L15:
            throw new NoWhenBranchMatchedException();
        L9:
            r105 = a.f545301a[r104.ordinal()];
            goto L10
        L5:
            r104 = null;
            goto L7
        }

        @Override // eb9.p
        public final List<eb9.d> f(o<?> r100, FlowFeedActionScene r101, u r102) {
            return p.a.a(r100, r101, r102);
        }

        @Override // eb9.p
        public final boolean b(o<?> r100, View r101, int r102, u r103) {
            p.a.c(r100, r101, r103);
            return false;
        }

        @Override // eb9.p
        public final void e(o<?> r100, eb9.d r101, eb9.c r102, u r103) {
            p.a.b(r100, r101, r102, r103);
        }
    }

    static {
        f545297c = SideBarFeedCardType.PROJECT_EMPTY_ACTION;
    }

    @Override // eb9.w
    public final x b() {
        return new com.larus.home.impl.main.side_bar.feed.cell.i();
    }

    @Override // eb9.w
    public final p c() {
        return new b(this);
    }

    @Override // eb9.w
    public final v a() {
        return eb9.a.f471852a;
    }

    @Override // eb9.w
    public final SideBarFeedCardType getCardType() {
        return this.f545299b;
    }

    public d(j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "onCreateBlankProject");
        this.f545298a = r100;
        this.f545299b = f545297c;
    }
}
