package vi4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.ss.android.ugc.tools.view.base.BaseTransitionView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f555314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f555315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f555316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f555317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f555318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseTransitionView f555319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f555320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f555321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f555322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PublishSubject<Boolean> f555323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PublishSubject<Boolean> f555324k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f555325l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f555326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f555327b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f555328c;

        public a() {
            this.f555326a = null;
            this.f555327b = 0;
            this.f555328c = 0;
        }
    }

    public final void a(boolean r100) {
        BaseTransitionView r101 = null;
        if (r100 == false) goto L9;
        BaseTransitionView r102 = this.f555319f;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("transitionView");
    L8:
        r101.show();
    L14:
        View r103 = this.f555321h;
        if (r103 == null) goto L22;
        ViewPropertyAnimator r104 = r103.animate();
        if (r100 == true) goto L19;
        float r105 = 0.0f;
    L20:
        r104.rotation(r105).setDuration(300).start();
        return;
    L19:
        r105 = 180.0f;
        goto L20
    L22:
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        BaseTransitionView r106 = this.f555319f;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("transitionView");
    L13:
        r101.hide();
        goto L14
    L12:
        r101 = r106;
        goto L13
    }

    public f(ViewGroup r100, View r101, boolean r102, Function1<? super a, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "folderListContentView");
        this.f555314a = r100;
        this.f555315b = r101;
        this.f555316c = r102;
        a r104 = new a();
        this.f555317d = r104;
        this.f555323j = PublishSubject.create();
        this.f555324k = PublishSubject.create();
        this.f555325l = new CompositeDisposable();
        if (r103 == null) goto L6;
        r103.invoke(r104);
        return;
    }
}
