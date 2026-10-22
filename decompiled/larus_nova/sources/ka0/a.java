package ka0;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.monitorV2.util.o;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.e;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HybridCard f502170b;

    /* JADX INFO: renamed from: ka0.a$a, reason: collision with other inner class name */
    public static final class C6524a extends b7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f502171a;

        public C6524a(a r100) {
            this.f502171a = r100;
        }

        @Override // b7.a, b7.b
        public final void onLoadSuccess(View r100) {
            super.onLoadSuccess(r100);
            a r101 = this.f502171a;
            HybridCard r102 = r101.f502170b;
            if (r102 == null) goto L5;
            IHybridComponent.HybridType r103 = r102.hybridType();
        L7:
            if (r103 != IHybridComponent.HybridType.LYNX) goto L9;
            b.f502172a.getClass();
            int r104 = 1;
        L10:
            r101.b(r102, r100, r104);
            return;
        L9:
            b.f502172a.getClass();
            r104 = 2;
            goto L10
        L5:
            r103 = null;
            goto L7
        }

        @Override // b7.a, b7.b
        public final void onLoadFail(View r100, String r101, String r102) {
            super.onLoadFail(r100, r101, r102);
            a r103 = this.f502171a;
            r103.a(r103.f502170b, r102);
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class c() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("q20.h");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.live.browser.debug.mock.HybridMockTool");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.live.browser.debug.mock.HybridMockTool");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("q20.h");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.live.browser.debug.mock.HybridMockTool");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.live.browser.debug.mock.HybridMockTool");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.live.browser.debug.mock.HybridMockTool");
    }

    @Override // ka0.b
    public final void release() {
        HybridCard r100 = this.f502170b;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    public static String e(String r100) {
        if (r100 != null) goto L12;
        return r100;
    L12:
        int r101 = e.f498076a;     // Catch: Throwable -> L11
        Object r102 = o.b(c(), "onLynxLoad", new Object[]{UriProtector.parse(r100)});     // Catch: Throwable -> L11
        if (r102 == null) goto L14;
        String r103 = r102.toString();     // Catch: Throwable -> L11
        if (r103 != null) goto L10;
        return r100;
    L10:
        return r103;
    L14:
        return r100;
    L16:
        return r100;
    }

    @Override // ka0.b
    public final void loadUrl(String r100) {
        if (xa1.a.f563027a.getValue().booleanValue() == false) goto L7;
        HybridCard r101 = this.f502170b;
        if (r101 == null) goto L11;
        a7.a.a(r101, e(r100), null, 2);
        return;
    L11:
        return;
    L7:
        HybridCard r102 = this.f502170b;
        if (r102 == null) goto L13;
        a7.a.a(r102, r100, null, 2);
        return;
    }

    public final void d(String r100, Map<String, ? extends Object> r101) {
        if (xa1.a.f563027a.getValue().booleanValue() == false) goto L7;
        HybridCard r102 = this.f502170b;
        if (r102 == null) goto L11;
        r102.load(e(r100), r101);
        return;
    L11:
        return;
    L7:
        HybridCard r103 = this.f502170b;
        if (r103 == null) goto L13;
        r103.load(r100, r101);
        return;
    }

    @Override // ka0.b
    public final <T> void sendJsEvent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        HybridCard r102 = this.f502170b;
        if (r102 == null) goto L6;
        r102.sendJsEvent(r100, r101);
        return;
    }

    public a(Context r100, Uri r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "originUri");
        this.f502170b = ((IBaseBrowserService) k.n(IBaseBrowserService.class)).getHybridCard(r100, r101, r102, new C6524a(this));
    }
}
