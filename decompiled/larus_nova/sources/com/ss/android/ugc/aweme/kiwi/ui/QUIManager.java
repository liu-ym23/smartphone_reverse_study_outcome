package com.ss.android.ugc.aweme.kiwi.ui;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIMust;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.util.QExecutor;
import com.ss.android.ugc.aweme.kiwi.util.QHandler;
import com.ss.android.ugc.aweme.kiwi.util.QUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/ui/QUIManager;", "", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "()V", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public final class QUIManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Fragment f450906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f450907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f450908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public QUIModule f450909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f450910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, ArrayList<QUIModule>> f450911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<Class<?>, QUIModule> f450912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public QHandler f450913h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public QHandler f450914i;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f450915a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f450916b = null;

        static {
            int[] r100 = new int[QUIAction.values().length];
            f450915a = r100;
            QUIAction r101 = QUIAction.NONE;
            r100[r101.ordinal()] = 1;
            QUIAction r102 = QUIAction.SHOW;
            r100[r102.ordinal()] = 2;
            QUIAction r103 = QUIAction.REPLACE;
            r100[r103.ordinal()] = 3;
            QUIAction r104 = QUIAction.HIDE;
            r100[r104.ordinal()] = 4;
            int[] r105 = new int[QUIAction.values().length];
            f450916b = r105;
            r105[r101.ordinal()] = 1;
            r105[r102.ordinal()] = 2;
            r105[r103.ordinal()] = 3;
            r105[r104.ordinal()] = 4;
        }
    }

    public final Context getContext() {
        Context r100 = this.f450907b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    public final Fragment i() {
        Fragment r100 = this.f450906a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(WidgetService.PARAM_FRAGMENT);
    L5:
        return r100;
    }

    public final View p() {
        View r100 = this.f450910e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        return r100;
    }

    public QUIManager() {
        this.f450911f = new HashMap();
        this.f450912g = new HashMap();
    }

    public static void b(QUIModule r100) {
        View r101 = r100.f450923g;
        if ((r101 instanceof ViewStub) == false) goto L40;
        QUtils.f450935a.getClass();
        View r102 = r100.f450923g;
        if (r102 == null) goto L39;
        ViewStub r103 = (ViewStub) r102;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        View r105 = r100.f450923g;
        if (r105 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        if (r105.getParent() == null) goto L20;
        View r106 = r100.f450923g;
        if (r106 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        ViewParent r107 = r106.getParent();
        if (r107 == null) goto L18;
        QUtils.a((ViewGroup) r107, r103, r104, r100);
        return;
    L18:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    L20:
        if (r100.f450926j == (-1)) goto L28;
        QUIModule r108 = r100.f450924h;
        if (r108 != null) goto L24;
        Intrinsics.throwNpe();
    L24:
        View r109 = r108.f450923g;
        if (r109 != null) goto L27;
        Intrinsics.throwNpe();
    L27:
        ViewGroup r110 = (ViewGroup) r109.findViewById(r100.f450926j);
    L34:
        QUtils.a(r110, r103, r104, r100);
        return;
    L28:
        QUIModule r111 = r100.f450924h;
        if (r111 != null) goto L31;
        Intrinsics.throwNpe();
    L31:
        View r112 = r111.f450923g;
        if (r112 == null) goto L37;
        r110 = (ViewGroup) r112;
        goto L34
    L37:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    L39:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewStub");
    L40:
        if (r101 != null) goto L43;
        Intrinsics.throwNpe();
    L43:
        if (r101.getParent() == null) goto L46;
        return;
    L46:
        if (r100.f450926j == (-1)) goto L54;
        QUIModule r113 = r100.f450924h;
        if (r113 != null) goto L50;
        Intrinsics.throwNpe();
    L50:
        View r114 = r113.f450923g;
        if (r114 != null) goto L53;
        Intrinsics.throwNpe();
    L53:
        ViewGroup r115 = (ViewGroup) r114.findViewById(r100.f450926j);
    L60:
        ViewGroup.LayoutParams r116 = r100.f450927k;
        if (r116 == null) goto L63;
        r115.addView(r100.f450923g, r116);
        return;
    L63:
        r115.addView(r100.f450923g);
        return;
    L54:
        QUIModule r117 = r100.f450924h;
        if (r117 != null) goto L57;
        Intrinsics.throwNpe();
    L57:
        View r118 = r117.f450923g;
        if (r118 == null) goto L66;
        r115 = (ViewGroup) r118;
        goto L60
    L66:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static void s(QUIModule r100) {
        QIPresenter r101 = r100.f450919c;
        if ((r101 instanceof QIMust) == false) goto L9;
        if (r101 == null) goto L7;
        ((QIMust) r101).a();
        goto L9
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.ss.android.ugc.aweme.kiwi.presenter.QIMust");
    L9:
        if (r100.f450921e == false) goto L13;
        QIPresenter r102 = r100.f450919c;
        if (r102 == null) goto L13;
        r102.unbind();
    L13:
        List<? extends QUIModule> r103 = r100.f450925i;
        if (r103 == null) goto L19;
        Iterator<? extends QUIModule> r104 = r103.iterator();
    L17:
        if (r104.hasNext() == false) goto L21;
        s(r104.next());
        goto L17
    L21:
        return;
    }

    public final void f(QUIModule r100) {
        if (r100.j(null) != 8) goto L5;
        return;
    L5:
        ArrayList<QUIModule> r101 = j(r100);
        r101.remove(r100);
        boolean r102 = true;
        if ((!r101.isEmpty()) == false) goto L8;
        QUIAction r103 = r100.c(r101);
    L9:
        int r104 = WhenMappings.f450916b[r103.ordinal()];
        if (r104 != 1) goto L12;
        r100.f450923g = h(r100);
    L27:
        if (r100.b().length() > 0) goto L30;
        r102 = false;
    L30:
        if (r102 == false) goto L32;
        j(r100).add(r100);
    L32:
        List<? extends QUIModule> r105 = r100.f450925i;
        if (r105 == null) goto L38;
        Iterator<? extends QUIModule> r106 = r105.iterator();
    L36:
        if (r106.hasNext() == false) goto L38;
        f(r106.next());
    L38:
        int r107 = r100.j(null);
        QHandler r108 = this.f450913h;
        if (r108 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException(PullConfiguration.PROCESS_NAME_MAIN);
    L41:
        r108.a(new QUIManager$moduleCreated$1(this, r100, r107));
        return;
    L12:
        if (r104 != 2) goto L14;
        r100.f450923g = h(r100);
        goto L27
    L14:
        if (r104 != 3) goto L16;
        r100.f450923g = h(r100);
        Iterator<QUIModule> r109 = j(r100).iterator();
    L21:
        if (r109.hasNext() == false) goto L23;
        n(r109.next(), 8);
        goto L21
    L23:
        j(r100).clear();
        goto L27
    L16:
        if (r104 != 4) goto L27;
        return;
    L8:
        r103 = QUIAction.NONE;
        goto L9
    }

    public final View h(QUIModule r100) {
        View r101 = this.f450910e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        Context r102 = r101.getContext();
        QUIModule r103 = r100.f450924h;
        if (r103 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        View r104 = r100.f(r102, (ViewGroup) r103.f450923g);
        if ((r104 instanceof ViewStub) == false) goto L20;
        QUtils r105 = QUtils.f450935a;
        ViewStub r106 = (ViewStub) r104;
        QUIModule r107 = r100.f450924h;
        if (r107 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        ViewGroup r108 = (ViewGroup) r107.f450923g;
        View r109 = this.f450910e;
        if (r109 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L16:
        Context r110 = r109.getContext();
        r105.getClass();
        View r111 = LayoutInflater.from(r110).inflate(r106.getLayoutResource(), r108, false);
        if (r106.getInflatedId() == (-1)) goto L19;
        r111.setId(r106.getInflatedId());
    L19:
        r106.setTag(-2, r111);
    L20:
        return r104;
    }

    public final ArrayList<QUIModule> j(QUIModule r100) {
        if (this.f450911f.get(r100.b()) != null) goto L5;
        this.f450911f.put(r100.b(), new ArrayList());
    L5:
        ArrayList<QUIModule> r101 = this.f450911f.get(r100.b());
        if (r101 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        return r101;
    }

    public final <T extends QUIModule> void r(Class<T> r100) {
        if (this.f450908c == false) goto L8;
        QUIModule r101 = this.f450912g.get(r100);
        if (r101 == null) goto L9;
        s(r101);
        return;
    L9:
        return;
    }

    public static final void a(QUIManager r100, QUIModule r101) {
        r100.getClass();
        boolean r102 = false;
        if (r101.f450923g != null) goto L5;
        r100.g(r101, true);
    L7:
        if (r101.b().length() <= 0) goto L9;
        r102 = true;
    L9:
        if (r102 == false) goto L12;
        r100.j(r101).add(r101);
        return;
    L12:
        return;
    L5:
        r100.n(r101, 0);
        goto L7
    }

    public static void o(QUIModule r100, QModel r101) {
        r100.f450920d = true;
        r100.f450918b = r101;
        List<? extends QUIModule> r102 = r100.f450925i;
        if (r102 == null) goto L8;
        Iterator<? extends QUIModule> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        o(r103.next(), r101);
        goto L6
    L10:
        return;
    }

    public static void t(QUIModule r100, QModel r101) {
        r100.f450922f = r100.j(r101);
        List<? extends QUIModule> r102 = r100.f450925i;
        if (r102 == null) goto L8;
        Iterator<? extends QUIModule> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        t(r103.next(), r101);
        goto L6
    L10:
        return;
    }

    public final <T extends QUIModule> void c(Class<T> r100, final QModel r101) {
        if (this.f450908c == false) goto L11;
        final QUIModule r102 = this.f450912g.get(r100);
        if (r102 == null) goto L12;
        e(r102, r101);
        QHandler r103 = this.f450914i;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("work");
    L9:
        r103.a(new QUIManager$bind$1(this, r102, r101));
        return;
    L12:
        return;
    }

    public final void d(QUIModule r100, QModel r101) {
        Fragment r102 = this.f450906a;
        if (r102 != null) goto L5;
    L6:
        r100.f450918b = r101;
        if (r100.f450922f != 8) goto L9;
        o(r100, r101);
    L27:
        if (r100.f450921e == false) goto L30;
        q(r100.getClass(), r100.f450922f);
    L30:
        if (r100.f450922f == 8) goto L39;
        List<? extends QUIModule> r103 = r100.f450925i;
        if (r103 == null) goto L40;
        Iterator<? extends QUIModule> r104 = r103.iterator();
    L35:
        if (r104.hasNext() == false) goto L41;
        d(r104.next(), r101);
        goto L35
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L9:
        if (r100.f450921e == false) goto L16;
        QIPresenter r105 = r100.f450919c;
        if (r105 == null) goto L27;
        View r106 = r100.f450923g;
        if (r106 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        r105.J(r101, r106, this);
        goto L27
    L16:
        r100.f450923g = h(r100);
        b(r100);
        r100.f450921e = true;
        View r107 = r100.f450923g;
        if (r107 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        r100.g(r107);
        QIPresenter r108 = r100.f450919c;
        if (r108 == null) goto L27;
        View r109 = r100.f450923g;
        if (r109 != null) goto L24;
        Intrinsics.throwNpe();
    L24:
        r108.J(r101, r109, this);
        goto L27
    L5:
        if (r102.getActivity() != null) goto L6;
    }

    public final void e(QUIModule r100, QModel r101) {
        QIPresenter r102 = r100.f450919c;
        if ((r102 instanceof QIMust) == false) goto L8;
        if (r102 == null) goto L7;
        ((QIMust) r102).b();
        goto L8
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.ss.android.ugc.aweme.kiwi.presenter.QIMust");
    L8:
        List<? extends QUIModule> r103 = r100.f450925i;
        if (r103 == null) goto L14;
        Iterator<? extends QUIModule> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        e(r104.next(), r101);
        goto L12
    L16:
        return;
    }

    public final void g(QUIModule r100, boolean r101) {
        if (r100.j(r100.f450918b) != 8) goto L5;
        if (r101 == true) goto L5;
        return;
    L5:
        r100.f450923g = h(r100);
        List<? extends QUIModule> r102 = r100.f450925i;
        if (r102 == null) goto L11;
        Iterator<? extends QUIModule> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        g(r103.next(), false);
    L11:
        QHandler r104 = this.f450913h;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException(PullConfiguration.PROCESS_NAME_MAIN);
    L14:
        r104.a(new QUIManager$moduleCreated$1(this, r100, 0));
    }

    public final void n(final QUIModule r100, final int r101) {
        QHandler r102 = this.f450913h;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PullConfiguration.PROCESS_NAME_MAIN);
    L5:
        r102.a(new QUIManager$moduleVisibility$1(this, r100, r101));
    }

    public final <T extends QUIModule> void q(Class<T> r100, final int r101) {
        if (this.f450908c == true) goto L5;
        return;
    L5:
        final QUIModule r102 = this.f450912g.get(r100);
        if (r102 == null) goto L12;
        QHandler r103 = this.f450914i;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("work");
    L10:
        r103.a(new QUIManager$setVisibility$1(this, r101, r102));
        return;
    }

    public final void k(QUIModule r100, Context r101, Fragment r102) {
        this.f450906a = r102;
        l(r100, r101, false);
    }

    public final void l(QUIModule r100, final Context r101, boolean r102) {
        this.f450907b = r101;
        if (r102 == false) goto L5;
        this.f450913h = new QHandler(new Handler(), true);
        this.f450914i = new QHandler(new Handler(), true);
    L6:
        this.f450909d = r100;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L9:
        r100.f450917a = this;
        r100.f450924h = null;
        r100.e(r101);
        r100.f450919c = r100.h();
        r100.f450925i = r100.i();
        QUIModule r103 = this.f450909d;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L12:
        QUIModule r104 = this.f450909d;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L15:
        r103.f450923g = r104.f(r101, null);
        QUIModule r105 = this.f450909d;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L18:
        View r106 = r105.f450923g;
        if (r106 != null) goto L21;
        Intrinsics.throwNpe();
    L21:
        this.f450910e = r106;
        QUIModule r107 = this.f450909d;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L24:
        View r108 = r107.f450923g;
        if (r108 != null) goto L27;
        Intrinsics.throwNpe();
    L27:
        QUIModule r109 = this.f450909d;
        if (r109 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L30:
        r108.setVisibility(r109.j(null));
        QUIModule r110 = this.f450909d;
        if (r110 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L33:
        r110.f450921e = true;
        QUIModule r111 = this.f450909d;
        if (r111 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L36:
        View r112 = this.f450910e;
        if (r112 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L39:
        r111.g(r112);
        HashMap<Class<?>, QUIModule> r113 = this.f450912g;
        QUIModule r114 = this.f450909d;
        if (r114 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L42:
        Class<?> r115 = r114.getClass();
        QUIModule r116 = this.f450909d;
        if (r116 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L45:
        r113.put(r115, r116);
        QUIModule r117 = this.f450909d;
        if (r117 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L49:
        if (r117.f450925i == null) goto L66;
        QUIModule r118 = this.f450909d;
        if (r118 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L53:
        List<? extends QUIModule> r119 = r118.f450925i;
        if (r119 != null) goto L56;
        Intrinsics.throwNpe();
    L56:
        Iterator<? extends QUIModule> r120 = r119.iterator();
    L58:
        if (r120.hasNext() == false) goto L66;
        final QUIModule r121 = r120.next();
        QUIModule r122 = this.f450909d;
        if (r122 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L62:
        m(r121, r101, r122);
        QHandler r123 = this.f450914i;
        if (r123 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("work");
    L65:
        r123.a(new QUIManager$init$1(this, r121, r101));
    L66:
        this.f450908c = true;
        return;
    L5:
        QExecutor r124 = QExecutor.f450931c;
        r124.getClass();
        this.f450913h = new QHandler(QExecutor.f450930b, false);
        this.f450914i = new QHandler(r124.a(), false);
        goto L6
    }

    public final void m(QUIModule r100, Context r101, QUIModule r102) {
        this.f450912g.put(r100.getClass(), r100);
        r100.f450917a = this;
        r100.f450924h = r102;
        r100.e(r101);
        r100.f450919c = r100.h();
        List<QUIModule> r103 = r100.i();
        r100.f450925i = r103;
        if (r103 == null) goto L8;
        Iterator<QUIModule> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        m(r104.next(), r101, r100);
        goto L6
    L10:
        return;
    }
}
