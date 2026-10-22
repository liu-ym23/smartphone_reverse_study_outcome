package zi3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements zi3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f572233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IECAIHostService f572234b;

    /* JADX INFO: renamed from: zi3.a$a, reason: collision with other inner class name */
    public static final class C8460a {
    }

    public static final class b implements BackComponent.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f572235a;

        public b(Function1 r100) {
            this.f572235a = r100;
        }

        @Override // com.bytedance.android.ec.base.api.ai.framework.component.BackComponent.OnClickListener
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f572235a.invoke(r100);
        }
    }

    public static final class c implements CapsuleComponent.OnClickMenuListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f572236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f572237b;

        @Override // com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent.OnClickMenuListener
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f572236a.invoke(r100);
        }

        public c(Function1 r100, Function1 r101) {
            this.f572236a = r100;
            this.f572237b = r101;
        }
    }

    public static final class d implements CapsuleComponent.OnClickCloseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f572238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f572239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f572240c;

        @Override // com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent.OnClickCloseListener
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f572238a.f572234b.closeApplet("shop");
            this.f572240c.invoke(r100);
        }

        public d(a r100, Function1 r101, Function1 r102) {
            this.f572238a = r100;
            this.f572239b = r101;
            this.f572240c = r102;
        }
    }

    static {
    }

    @Override // zi3.c
    public final boolean c() {
        return !this.f572234b.isLandingPage();
    }

    @Override // zi3.c
    public final boolean e() {
        return this.f572233a;
    }

    public a(IECAIHostService r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f572234b = r100;
        this.f572233a = true;
    }

    @Override // zi3.c
    public final void a(Context r100, List<PanelItem> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "items");
        this.f572234b.showAppletPanel(r100, "shop", r101, null);
    }

    @Override // zi3.c
    public final View d(Context r100, Function1<? super View, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        BackComponent r102 = this.f572234b.createBackComponent(r100);
        if (r102 == null) goto L5;
        r102.setScene("shop");
        r102.setOnClickListener(new b(r101));
        return r102.getView();
    L5:
        return null;
    }

    @Override // zi3.c
    public final View b(Context r100, Function1<? super View, Unit> r101, Function1<? super View, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onMenuClick");
        Intrinsics.checkNotNullParameter(r102, "onCloseClick");
        CapsuleComponent r103 = this.f572234b.createCapsuleComponent(r100);
        if (r103 == null) goto L5;
        r103.setScene("shop");
        r103.setOnClickMenuListener(new c(r101, r102));
        r103.setOnClickCloseListener(new d(this, r101, r102));
        return r103.getView();
    L5:
        return null;
    }
}
