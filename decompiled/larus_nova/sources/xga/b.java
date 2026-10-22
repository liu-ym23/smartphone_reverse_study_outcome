package xga;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f563827a = 0;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f563828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f563829b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f563830c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<View, Boolean> f563831d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f563832e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f563833f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f563834g;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            AssistantStartupTelemetry r100 = AssistantStartupTelemetry.f392915a;     // Catch: Exception -> L23
            if (Intrinsics.areEqual(r100.i(this.f563828a), this.f563829b) == true) goto L10;
            int r101 = b.f563827a;     // Catch: Exception -> L23
            ViewTreeObserver r102 = this.f563830c;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r102);     // Catch: Exception -> L23
            if (r102.isAlive() == false) goto L8;
            r102.removeOnPreDrawListener(this);     // Catch: Exception -> L23
        L8:
            return true;
        L10:
            if (this.f563831d.invoke(this.f563832e).booleanValue() == true) goto L12;
            return true;
        L12:
            Ref.BooleanRef r103 = this.f563833f;     // Catch: Exception -> L23
            if (r103.element == true) goto L15;
            r103.element = true;     // Catch: Exception -> L23
            IAssistantStartupTelemetry.a.b(r100, this.f563829b);     // Catch: Exception -> L23
        L15:
            this.f563834g.element++;     // Catch: Exception -> L23
            if (IAssistantStartupTelemetry.a.c(r100, this.f563829b, this.f563828a) == false) goto L18;
        L19:
            int r104 = b.f563827a;     // Catch: Exception -> L23
            ViewTreeObserver r105 = this.f563830c;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r105);     // Catch: Exception -> L23
            if (r105.isAlive() == false) goto L22;
            r105.removeOnPreDrawListener(this);     // Catch: Exception -> L23
        L22:
            return true;
        L18:
            if (this.f563834g.element < 3) goto L22;
        L23:
            e = move-exception;
            int r106 = b.f563827a;
            ViewTreeObserver r107 = this.f563830c;
            Intrinsics.checkNotNull(r107);
            if (r107.isAlive() == false) goto L27;
            r107.removeOnPreDrawListener(this);
        L27:
            FLogger.f375446a.w("AssistantStartupReadyView", "startup ready pre-draw callback failed, milestone=" + this.f563828a, e);
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r100, String r101, ViewTreeObserver r102, Function1<? super View, Boolean> r103, View r104, Ref.BooleanRef r105, Ref.IntRef r106) {
            this.f563828a = r100;
            this.f563829b = r101;
            this.f563830c = r102;
            this.f563831d = r103;
            this.f563832e = r104;
            this.f563833f = r105;
            this.f563834g = r106;
        }
    }

    static {
    }

    public static boolean a(View r110, String r111, String r112, Function1 r113) {
        Intrinsics.checkNotNullParameter(r112, "milestone");
        Intrinsics.checkNotNullParameter(r113, "isReady");
        if (r110 != null) goto L5;
        return false;
    L5:
        if (r111 != null) goto L7;
    L18:
        return false;
    L7:
        if ((!StringsKt.isBlank(r111)) == true) goto L10;
        r111 = null;
    L10:
        String r100 = r111;
        if (r100 == null) goto L18;
        final ViewTreeObserver r114 = r110.getViewTreeObserver();
        if (r114.isAlive() == true) goto L16;
        return false;
    L16:
        final a r101 = new a(r112, r100, r114, r113, r110, new Ref.BooleanRef(), new Ref.IntRef());
        r114.addOnPreDrawListener(r101);
        r110.postInvalidateOnAnimation();
        r110.postDelayed(new xga.a(r114, r101), 15000);
        return true;
    }
}
