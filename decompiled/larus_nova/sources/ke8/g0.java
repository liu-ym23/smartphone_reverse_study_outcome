package ke8;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.nestedfile.NestFileService;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.mainbot.impl.databinding.LarusCotDetailUserNestfileCellBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
public final class g0 extends le8.a<he8.h> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f503063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h38.d f503064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f503065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ie8.a f503066e;

    public static final class a implements BaseResourceViewHolder.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g0 f503067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f503068b;

        /* JADX INFO: renamed from: ke8.g0$a$a, reason: collision with other inner class name */
        public static final class C6546a implements lr8.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f503069a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g0 f503070b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ie8.a f503071c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ NestedFileContent f503072d;

            @Override // lr8.a
            public final com.larus.trace.tracknode.a f() {
                return null;
            }

            @Override // lr8.a
            public final /* bridge */ /* synthetic */ q0 getAdapter() {
                return null;
            }

            @Override // lr8.a
            public final /* bridge */ /* synthetic */ wc9.e h() {
                return null;
            }

            @Override // lr8.a
            public final boolean i0() {
                return false;
            }

            @Override // lr8.a
            public final void a() {
                g0 r100 = this.f503070b;
                r100.f503064c.a(this.f503071c.f489498a, this.f503072d, g0.c(r100));
            }

            @Override // lr8.a
            public final CoroutineScope c() {
                Object r100 = this.f503069a;
                if ((r100 instanceof LifecycleOwner) == false) goto L5;
                LifecycleOwner r101 = (LifecycleOwner) r100;
            L6:
                if (r101 != null) goto L8;
                return null;
            L8:
                return LifecycleOwnerKt.getLifecycleScope(r101);
            L5:
                r101 = null;
                goto L6
            }

            @Override // lr8.a
            public final FragmentManager getFragmentManager() {
                Context r100 = this.f503069a;
                if ((r100 instanceof FragmentActivity) == false) goto L5;
                FragmentActivity r101 = (FragmentActivity) r100;
            L6:
                if (r101 != null) goto L8;
                return null;
            L8:
                return r101.getSupportFragmentManager();
            L5:
                r101 = null;
                goto L6
            }

            @Override // lr8.a
            public final BotModel i() {
                return new BotModel("unknown", null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
            }

            public C6546a(Context r100, g0 r101, ie8.a r102, NestedFileContent r103) {
                this.f503069a = r100;
                this.f503070b = r101;
                this.f503071c = r102;
                this.f503072d = r103;
            }
        }

        public a(g0 r100, Context r101) {
            this.f503067a = r100;
            this.f503068b = r101;
        }

        @Override // com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder.a
        public final boolean b(String r100, View r101) {
            BaseResourceViewHolder.a.C4120a.a(r100, r101);
            return false;
        }

        @Override // com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder.a
        public final void a(String r110, int r111, View r112) {
            Intrinsics.checkNotNullParameter(r110, "key");
            Intrinsics.checkNotNullParameter(r112, BaseSwitches.V);
            if (r111 != 103) goto L9;
            ie8.a r100 = this.f503067a.f503066e;
            if (r100 != null) goto L7;
            return;
        L7:
            NestedFileContent r101 = com.larus.bmhome.chat.bean.d.f(r100.f489498a);
            Context r102 = this.f503068b;
            final g0 r103 = this.f503067a;
            lr8.f r113 = new lr8.f(r110, r112, r100.f489498a, r101, -1, this, new C6546a(r102, r103, r100, r101), new f0(r103), Boolean.TRUE, false, 512);
            NestFileService.f313407b.c(r113);
            return;
        }
    }

    @Override // le8.a
    public final void b() {
    }

    private final LarusCotDetailUserNestfileCellBinding getBinding() {
        return (LarusCotDetailUserNestfileCellBinding) this.f503063b.getValue();
    }

    private final BaseResourceViewHolder.a getCallback() {
        return (BaseResourceViewHolder.a) this.f503065d.getValue();
    }

    public g0(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f503063b = LazyKt.lazy(new d0(r100, this));
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        h38.d r101 = NestFileService.f313407b.e(r100);
        this.f503064c = r101;
        getBinding().f358561b.addView(r101);
        this.f503065d = LazyKt.lazy(new e0(this, r100));
    }

    public static final /* synthetic */ BaseResourceViewHolder.a c(g0 r100) {
        return r100.getCallback();
    }

    @Override // le8.b
    public final void a(ie8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f503066e = r100;
        NestedFileContent r101 = com.larus.bmhome.chat.bean.d.f(r100.f489498a);
        this.f503064c.a(r100.f489498a, r101, getCallback());
    }
}
