package ha8;

import android.content.Context;
import com.baidu.platform.comapi.map.MapController;
import com.larus.avlink.activeSummary.SoundPlayManager;
import com.larus.avlink.n1;
import com.larus.avlink.simulInterpret.page.model.TextType;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ea8.w;
import ea8.x;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f484397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f484398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<w> f484399c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<w> f484400d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Function1<? super x, Unit> f484401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Function1<? super x, Unit> f484402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Function1<Boolean, Unit>> f484403g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Function1<? super Boolean, Unit> f484404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Function1<? super w, Unit> f484405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Function1<? super w, Unit> f484406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f484407k = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f484408a = null;

        static {
            int[] r100 = new int[TextType.values().length];
            r100[TextType.ORIGINAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TextType.TRANSLATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f484408a = r100;
        }
    }

    static {
        f484398b = "";
        f484399c = new CopyOnWriteArrayList();
        f484400d = new CopyOnWriteArrayList();
        f484403g = new CopyOnWriteArrayList();
        f484407k = LazyKt.lazy(new c());
    }

    public static String c() {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 == null) goto L9;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.b0() != true) goto L9;
    L10:
        if (r102 == false) goto L13;
        return DoraConfig.c();
    L13:
        return DoraConfig.a();
    L9:
        r102 = false;
        goto L10
    }

    public static String d() {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 == null) goto L9;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.b0() != true) goto L9;
    L10:
        if (r102 == false) goto L13;
        return DoraConfig.d();
    L13:
        return DoraConfig.b();
    L9:
        r102 = false;
        goto L10
    }

    public static void a(w r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        CopyOnWriteArrayList<w> r101 = f484400d;
        ListIterator<w> r102 = r101.listIterator(r101.size());
    L4:
        if (r102.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r102.previous().f471658a, r100.f471658a) == false) goto L4;
        int r103 = r102.nextIndex();
    L9:
        if (r103 == (-1)) goto L11;
        f484400d.set(r103, r100);
    L11:
        Function1<? super w, Unit> r104 = f484406j;
        if (r104 == null) goto L18;
        Unit r105 = r104.invoke(r100);
        return;
    L18:
        return;
    L8:
        r103 = -1;
        goto L9
    }

    public static void b(w r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        CopyOnWriteArrayList<w> r101 = f484399c;
        ListIterator<w> r102 = r101.listIterator(r101.size());
    L4:
        if (r102.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r102.previous().f471658a, r100.f471658a) == false) goto L4;
        int r103 = r102.nextIndex();
    L9:
        if (r103 == (-1)) goto L11;
        f484399c.set(r103, r100);
    L11:
        Function1<? super w, Unit> r104 = f484405i;
        if (r104 == null) goto L18;
        Unit r105 = r104.invoke(r100);
        return;
    L18:
        return;
    L8:
        r103 = -1;
        goto L9
    }

    public static void f(x r100) {
        Intrinsics.checkNotNullParameter(r100, "resultSentence");
        CopyOnWriteArrayList<w> r101 = f484400d;
        ListIterator<w> r102 = r101.listIterator(r101.size());
    L4:
        if (r102.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r102.previous().f471658a, r100.f471662b) == false) goto L4;
        int r103 = r102.nextIndex();
    L10:
        if (r103 == (-1)) goto L19;
        CopyOnWriteArrayList<w> r104 = f484400d;
        w r105 = r104.get(r103);
        int r106 = a.f484408a[r100.getType().ordinal()];
        if (r106 == 1) goto L17;
        if (r106 != 2) goto L16;
        w r107 = w.a(r105, null, StringsKt.trim(r105.f471660c + r100.f471663c).toString(), 3);
    L18:
        r104.set(r103, r107);
    L27:
        Function1<? super x, Unit> r108 = f484402f;
        if (r108 == null) goto L34;
        Unit r109 = r108.invoke(r100);
        return;
    L34:
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r107 = w.a(r105, StringsKt.trim(r105.f471659b + r100.f471663c).toString(), null, 5);
        goto L18
    L19:
        int r110 = a.f484408a[r100.getType().ordinal()];
        if (r110 == 1) goto L25;
        if (r110 != 2) goto L24;
        w r111 = new w(r100.f471662b, "", StringsKt.trim(r100.f471663c).toString());
    L26:
        f484400d.add(r111);
        goto L27
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r111 = new w(r100.f471662b, StringsKt.trim(r100.f471663c).toString(), "");
        goto L26
    L8:
        r103 = -1;
        goto L10
    }

    public static void g(x r100) {
        Intrinsics.checkNotNullParameter(r100, "resultSentence");
        CopyOnWriteArrayList<w> r101 = f484399c;
        ListIterator<w> r102 = r101.listIterator(r101.size());
    L4:
        if (r102.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r102.previous().f471658a, r100.f471662b) == false) goto L4;
        int r103 = r102.nextIndex();
    L10:
        if (r103 == (-1)) goto L19;
        CopyOnWriteArrayList<w> r104 = f484399c;
        w r105 = r104.get(r103);
        int r106 = a.f484408a[r100.getType().ordinal()];
        if (r106 == 1) goto L17;
        if (r106 != 2) goto L16;
        w r107 = w.a(r105, null, StringsKt.trim(r105.f471660c + r100.f471663c).toString(), 3);
    L18:
        r104.set(r103, r107);
    L27:
        Function1<? super x, Unit> r108 = f484401e;
        if (r108 == null) goto L34;
        Unit r109 = r108.invoke(r100);
        return;
    L34:
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r107 = w.a(r105, StringsKt.trim(r105.f471659b + r100.f471663c).toString(), null, 5);
        goto L18
    L19:
        int r110 = a.f484408a[r100.getType().ordinal()];
        if (r110 == 1) goto L25;
        if (r110 != 2) goto L24;
        w r111 = new w(r100.f471662b, "", StringsKt.trim(r100.f471663c).toString());
    L26:
        f484399c.add(r111);
        goto L27
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r111 = new w(r100.f471662b, StringsKt.trim(r100.f471663c).toString(), "");
        goto L26
    L8:
        r103 = -1;
        goto L10
    }

    public static void h(boolean r100) {
        f484397a = r100;
        f484399c.clear();
        f484400d.clear();
        Iterator<Function1<Boolean, Unit>> r101 = f484403g.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().invoke(Boolean.valueOf(r100));
        goto L4
    }

    public static void e(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L7;
        String r102 = a98.a.f2300c;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        boolean r103 = false;
        if (StringsKt.contains$default(r102, "female", false, 2, null) == false) goto L12;
    L14:
        r103 = true;
    L15:
        n1.d("SimultaneousInterpretSettingManager", "styleName is " + r101 + ", botStyleId is " + a98.a.f2300c + ", isFemaleTimbre is " + r103);
        if (r103 == false) goto L18;
        String r104 = "simulInterpret_female_start_error_music.mp3";
    L19:
        SoundPlayManager.e((SoundPlayManager) f484407k.getValue(), r100, r104, true, null);
        return;
    L18:
        r104 = "simulInterpret_male_start_error_music.mp3";
        goto L19
    L12:
        if (StringsKt.contains$default(r102, "male", false, 2, null) == false) goto L14;
    L7:
        r102 = r101;
        goto L8
    }
}
