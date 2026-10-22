package u87;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.relax.ttmlstatic.CardSession;
import com.bytedance.relax.ttmlstatic.c;
import com.bytedance.relax.ttmlstatic.g;
import com.bytedance.relax.ttmlstatic.h;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import me.ele.lancet.base.annotations.Skip;
import t87.b;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f549185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f549186b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f549187c;

    public a() {
    }

    static {
        f549185a = new a();
        f549186b = new String[]{"com.lynx.xelement.input.BehaviorGenerator", "com.lynx.xelement.input.LynxUIInputNG", "com.lynx.xelement.input.LynxUIInputNGShadowNode", "com.lynx.xelement.input.LynxUIInput", "com.lynx.xelement.input.LynxUIInputShadowNode", "com.lynx.xelement.input.LynxEditTextView", "com.lynx.xelement.input.LynxEditText", "com.lynx.xelement.input.LynxInputConnectionWrapper", "com.lynx.xelement.input.LynxInputUtils"};
    }

    public final void b() {
        int r100 = 0;
        if (f549187c == true) goto L9;
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L7:
        if (f549187c == false) goto L10;
        monitor-exit(this);
        goto L9
    L10:
        f549187c = true;     // Catch: Throwable -> L28
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(this);
        boolean r102 = true;
    L13:
        if (r102 == true) goto L33;
        return;
    L33:
        a(g.class.getName());     // Catch: Throwable -> L31
        a(com.bytedance.relax.ttmlstatic.a.class.getName());     // Catch: Throwable -> L31
        a(c.class.getName());     // Catch: Throwable -> L31
        a(h.class.getName());     // Catch: Throwable -> L31
        a(CardSession.class.getName());     // Catch: Throwable -> L31
        a(b.class.getName());     // Catch: Throwable -> L31
        a(t87.c.class.getName());     // Catch: Throwable -> L31
    L39:
        a("com.bytedance.relax.ttmlstatic.IndexKt");     // Catch: Throwable -> L32
    L17:
        String[] r103 = f549186b;
        ArrayList r104 = new ArrayList();
        int r105 = r103.length;
    L18:
        if (r100 >= r105) goto L25;
        String r106 = r103[r100];
        a(r106);     // Catch: Throwable -> L22
    L23:
        r100 = r100 + 1;
    L22:
        r104.add(r106);
        goto L23
    L25:
        if ((!r104.isEmpty()) == false) goto L44;
        CollectionsKt.joinToString$default(r104, null, null, null, 0, null, null, 63, null);
        return;
    L44:
        return;
    L9:
        r102 = false;
        goto L13
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName(r100);
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }
}
