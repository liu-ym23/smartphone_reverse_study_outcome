package gw8;

import android.app.Application;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.bmhome.chat.list.cell.text.components.middle.x;
import com.larus.business.markdown.api.ExperimentalMarkdownApi;
import com.larus.business.markdown.api.model.MarkdownNodeModifyType;
import com.larus.business.markdown.impl.markwon.MarkwonStruct;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lw8.h;
import lw8.i;
import lw8.l;
import lw8.m;
import me.ele.lancet.base.annotations.Skip;
import vg8.f;

/* JADX INFO: loaded from: classes4.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f483071a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f483072a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static c f483073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Application f483074c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static com.larus.business.markdown.api.depend.d f483075d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static com.larus.business.markdown.api.depend.c f483076e;

        static {
            f483072a = new a();
        }

        public a() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.larus.business.markdown.impl.MarkdownServiceImpl");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.larus.business.markdown.impl.MarkdownServiceImpl");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.larus.business.markdown.impl.MarkdownServiceImpl");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.larus.business.markdown.impl.MarkdownServiceImpl");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.larus.business.markdown.impl.MarkdownServiceImpl");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.larus.business.markdown.impl.MarkdownServiceImpl");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.larus.business.markdown.impl.MarkdownServiceImpl");
        }

        public static c b() {
            c r100 = f483073b;
            if (r100 == null) goto L6;
            return r100;
        L6:
            monitor-enter("com.larus.business.markdown.impl.MarkdownServiceImpl");
            c r101 = null;
            Object r102 = a().newInstance();     // Catch: Throwable -> L19
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.larus.business.markdown.api.MarkdownService");     // Catch: Throwable -> L19
            c r103 = (c) r102;     // Catch: Throwable -> L19
            f483073b = r103;     // Catch: Throwable -> L16
            if (r103 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("instance");     // Catch: Throwable -> L16
        L14:
            monitor-exit("com.larus.business.markdown.impl.MarkdownServiceImpl");
            return r101;
        L13:
            r101 = r103;
        L16:
            th = move-exception;
            throw th;
        L20:
            return null;
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class b {
        public static /* synthetic */ l b(c r100, ow8.a r101, String r102, boolean r103, lw8.d r110) {
            return r100.createMarkdownContent(r101, r102, r103, r110, null);
        }

        public static /* synthetic */ l a(c r110, Context r111, int r112, String r113, boolean r114, lw8.d r115, h r116, CharSequence r117, int r118) {
            if ((r118 & 32) == 0) goto L5;
            h r100 = null;
        L7:
            if ((r118 & 64) == 0) goto L9;
            CharSequence r101 = null;
        L11:
            return r110.createMarkdownContent(r111, r112, r113, r114, r115, r100, r101, null);
        L9:
            r101 = r117;
            goto L11
        L5:
            r100 = r116;
            goto L7
        }

        public static /* synthetic */ uvc.b c(c r110, Context r111, String r112, boolean r113, lw8.d r114, MarkwonStruct r115, f r116, x r117, int r118) {
            if ((r118 & 8) == 0) goto L5;
            lw8.d r100 = null;
        L7:
            if ((r118 & 16) == 0) goto L9;
            MarkwonStruct r101 = null;
        L11:
            if ((r118 & 32) == 0) goto L13;
            f r102 = null;
        L15:
            if ((r118 & 64) == 0) goto L17;
            x r103 = null;
        L19:
            return r110.createMarkdownNode(r111, r112, r113, r100, r101, r102, r103);
        L17:
            r103 = r117;
            goto L19
        L13:
            r102 = r116;
            goto L15
        L9:
            r101 = r115;
            goto L11
        L5:
            r100 = r114;
            goto L7
        }
    }

    static {
        f483071a = a.f483072a;
    }

    void clearMarkdownDrawableCachePool();

    h createCacheMarkwonStruct(Context r100, Integer r101, lw8.d r102, Map<String, ? extends Object> r103, boolean r104);

    l createMarkdownContent(Context r100, int r101, String r102, boolean r103, lw8.d r104, h r105, CharSequence r106, Map<String, ? extends Object> r107);

    @Deprecated(message = "尽量使用不包含TextView的同名类")
    l createMarkdownContent(ow8.a r100, String r101, boolean r102, lw8.d r103, Map<String, ? extends Object> r104);

    @ExperimentalMarkdownApi
    l createMarkdownContentFromNode(Context r100, int r101, uvc.b r102, boolean r103, lw8.d r104, CharSequence r105, Map<String, ? extends Object> r106, h r107, i r108, Function1<? super m, Unit> r110);

    @ExperimentalMarkdownApi
    uvc.b createMarkdownNode(Context r100, String r101, boolean r102, lw8.d r103, h r104, Function1<? super Set<? extends MarkdownNodeModifyType>, Unit> r105, Function1<? super m, Unit> r106);

    @ExperimentalMarkdownApi
    void createMarkdownWidget(Context r100, int r101, boolean r102, uvc.b r103, ViewGroup r104, uvc.b r105, List<? extends pw8.b> r106);

    @ExperimentalMarkdownApi
    List<uvc.b> createMarkdownWidgets(Context r100, int r101, uvc.b r102, boolean r103, boolean r104, lw8.d r105, ViewGroup r106, List<? extends uvc.b> r107, List<? extends pw8.b> r108, boolean r110, h r111);

    String getNodeReportName(uvc.b r100);

    void init(Application r100, com.larus.business.markdown.api.depend.b r101);

    void registerInjectParser(ysc.a r100);

    void registerLinkResolver(com.larus.business.markdown.api.depend.f r100);
}
