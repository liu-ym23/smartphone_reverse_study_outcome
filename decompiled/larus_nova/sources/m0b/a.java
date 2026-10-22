package m0b;

import android.content.Context;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.AbsChameleonJsRuntime;
import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.di.core.deps.JsEngineKind;
import com.ss.android.lark.officesdk.utils.di.g;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import ntb.i;
import ntb.l;
import vv4.m;
import z0b.f;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class a implements AbsChameleonJsRuntime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f511540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ChameleonBizType f511541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<AbsChameleonService> f511542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f511543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f511544e;

    /* JADX INFO: renamed from: m0b.a$a, reason: collision with other inner class name */
    public static final class C6755a {
    }

    public final class b implements IChameleonHandlerContext {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f511545a;

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final String getSession() {
            return "";
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final String getBizName() {
            ChameleonBizType r100 = this.f511545a.f511541b;
            if (r100 == null) goto L6;
            String r101 = r100.getType();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final Context getCmlContext() {
            return this.f511545a.f511540a;
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final ChameleonConfig getChameleonConfig() {
            return IChameleonHandlerContext.DefaultImpls.getChameleonConfig(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final Fragment getFragment() {
            return IChameleonHandlerContext.DefaultImpls.getFragment(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final WebView getWebview() {
            return IChameleonHandlerContext.DefaultImpls.getWebview(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final IChameleonLoader getWebviewLoader() {
            return IChameleonHandlerContext.DefaultImpls.getWebviewLoader(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final void destroyWebview() {
            IChameleonHandlerContext.DefaultImpls.destroyWebview(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final void reloadWebview() {
            IChameleonHandlerContext.DefaultImpls.reloadWebview(this);
        }

        public b(a r100) {
            this.f511545a = r100;
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final <T extends m> T getWebService(Class<T> r100) {
            return (T) IChameleonHandlerContext.DefaultImpls.getWebService(this, r100);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final <T extends Serializable> void sendEvent(String r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f511545a.getClass();
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void destroy() {
        this.f511543d = false;
        Iterator r100 = ((ArrayList) this.f511542c).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((AbsChameleonService) r100.next()).onDetach(this.f511544e);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void run() {
        DependencyContainer r100 = DependencyContainer.f433166a;
        l r101 = (l) DependencyContainer.a(l.class, null);
        this.f511543d = true;
        Iterator r102 = ((ArrayList) this.f511542c).iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        AbsChameleonService r103 = (AbsChameleonService) r102.next();
        r103.onAttach(this.f511544e);
        Iterator<AbsChameleonHandler<?>> r104 = r103.getBridgeHandlers().iterator();
    L7:
        if (r104.hasNext() == false) goto L4;
        r104.next().setContext(this.f511544e);
        goto L7
    }

    @Inject
    public a() {
        this.f511542c = new ArrayList();
        this.f511544e = new b(this);
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void registerService(AbsChameleonService r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        ((ArrayList) this.f511542c).add(r100);
        if (this.f511543d == false) goto L8;
        r100.onAttach(this.f511544e);
        Iterator<AbsChameleonHandler<?>> r101 = r100.getBridgeHandlers().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        r101.next().setContext(this.f511544e);
        goto L6
    L10:
        return;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void init(Context r100, String r101, ChameleonBizType r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "bizType");
        this.f511540a = r100;
        this.f511541b = r102;
        DependencyContainer r103 = DependencyContainer.f433166a;
        l r104 = (l) DependencyContainer.a(l.class, null);
        if (r104 != null) goto L5;
    L7:
        j.b("CML_TAG_ChameleonJsRuntimeImpl", "init, LKAPIDependency is null");
    L8:
        int r105 = g.f437223a;
        if (g.a.a("ccm.mobile.chameleon.use_quickjs") == false) goto L11;
        JsEngineKind r106 = JsEngineKind.QUICKJS;
    L12:
        i r107 = (i) DependencyContainer.a(i.class, null);
        if (r107 == null) goto L16;
        r102.getType();
        r107.B();
        return;
    L16:
        return;
    L11:
        JsEngineKind r108 = JsEngineKind.QUICKJS;
        goto L12
    L5:
        if ((r104.R() instanceof AbsChameleonService) == false) goto L7;
        List<AbsChameleonService> r109 = this.f511542c;
        f r110 = r104.R();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.ss.android.lark.chameleon.AbsChameleonService");
        ((ArrayList) r109).add(r110);
        goto L8
    }
}
