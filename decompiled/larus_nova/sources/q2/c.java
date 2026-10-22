package q2;

import com.bytedance.ai.applet.render.core.lynx.o;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.TemplateBundle;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class c extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f531327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f531328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f531329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f531330d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.render.core.lynx.o
    public final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        AppletResourceTool r101 = AppletResourceTool.f37276a;
        String r102 = this.f531327a;
        h2.a r103 = f2.b.f475099c;
        if (r103 == null) goto L6;
        String r104 = r103.f483574m;
        if (r104 == null) goto L6;
    L7:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r104, "bid");
        return IIvyAIPackageResourceService.f278317a.d(r102, r100, r104);
    L6:
        r104 = "";
        goto L7
    }

    @Override // w2.d
    public Object a(String r100, Continuation<? super TemplateBundle> r101) {
        String r102 = UriProtector.getQueryParameter(UriProtector.parse(r100), "forest_session_id");
        if (r102 == null) goto L5;
        this.f531327a = r102;
    L5:
        int r103 = AppletLynxViewApi.f36629a;
        return AppletLynxViewApi.b(this.f531327a, r100, this.f531328b, this.f531329c, this.f531330d, r101);
    }

    @Override // com.bytedance.ai.applet.render.core.lynx.o
    public final void b(String r100, final Function1<? super byte[], Unit> r101, final Function1<? super Exception, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "onSuccess");
        Intrinsics.checkNotNullParameter(r102, "onFailure");
        boolean r103 = true;
        if (r100.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L9;
        r102.invoke(new Exception("url is empty"));
        return;
    L9:
        g.f37637a.i("DefaultLynxResourceLoader", "loadResourceAsync: start to load ".concat(r100));
        String r105 = this.f531329c;
        if (r105 != null) goto L12;
    L15:
        if (r103 == true) goto L18;
        r100 = AppletResourceTool.f37276a.g(r100, this.f531329c);
    L18:
        AppletResourceTool r106 = AppletResourceTool.f37276a;
        String r107 = this.f531327a;
        Function1 r108 = new q2.a(r101, r102);
        Function1 r109 = new b(r102);
        r106.getClass();
        AppletResourceTool.q(r107, r100, r108, r109, false);
        return;
    L12:
        if (r105.length() == 0) goto L15;
        r103 = false;
        goto L15
    L5:
        r104 = false;
        goto L6
    }

    public c(String r100, boolean r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f531327a = r100;
        this.f531328b = r101;
        this.f531329c = r102;
        this.f531330d = r103;
    }
}
