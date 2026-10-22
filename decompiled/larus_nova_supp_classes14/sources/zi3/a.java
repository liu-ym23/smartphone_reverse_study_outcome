package zi3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements zi3.c {
    public final boolean a;
    public final IECAIHostService b;

    /* JADX INFO: renamed from: zi3.a$a, reason: collision with other inner class name */
    public static final class C0193a {
    }

    public static final class b implements BackComponent.OnClickListener {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a.invoke(r2);
        }
    }

    public static final class c implements CapsuleComponent.OnClickMenuListener {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Function1 b;

        public final void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a.invoke(r2);
        }

        public c(Function1 r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements CapsuleComponent.OnClickCloseListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ Function1 c;

        public final void onClick(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            this.a.b.closeApplet("shop");
            this.c.invoke(r3);
        }

        public d(a r1, Function1 r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @Override // zi3.c
    public final boolean c() {
        return !this.b.isLandingPage();
    }

    @Override // zi3.c
    public final boolean e() {
        return this.a;
    }

    public a(IECAIHostService r2) {
        Intrinsics.checkNotNullParameter(r2, "service");
        this.b = r2;
        this.a = true;
    }

    @Override // zi3.c
    public final void a(Context r4, List<PanelItem> r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "items");
        this.b.showAppletPanel(r4, "shop", r5, null);
    }

    @Override // zi3.c
    public final View d(Context r2, Function1<? super View, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onClick");
        BackComponent r4 = this.b.createBackComponent(r2);
        if (r4 == null) goto L5;
        r4.setScene("shop");
        r4.setOnClickListener(new b(r3));
        return r4.getView();
    L5:
        return null;
    }

    @Override // zi3.c
    public final View b(Context r2, Function1<? super View, Unit> r3, Function1<? super View, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onMenuClick");
        Intrinsics.checkNotNullParameter(r4, "onCloseClick");
        CapsuleComponent r5 = this.b.createCapsuleComponent(r2);
        if (r5 == null) goto L5;
        r5.setScene("shop");
        r5.setOnClickMenuListener(new c(r3, r4));
        r5.setOnClickCloseListener(new d(this, r3, r4));
        return r5.getView();
    L5:
        return null;
    }
}
