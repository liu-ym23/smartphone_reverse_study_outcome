package wq5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.folderselect.command.DuplicateContentChecker;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.shortcut.WikiShortcutToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.CreateNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements td5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f560738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f560739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f560740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f560741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f560742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final sq5.a f560743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WikiSelectorBean f560744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f560745h;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiSelectorBean f560746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f560747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f560748c;

        public b(WikiSelectorBean r100, j r101, Context r102) {
            this.f560746a = r100;
            this.f560747b = r101;
            this.f560748c = r102;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            DuplicateContentChecker.DuplicateResult r101 = (DuplicateContentChecker.DuplicateResult) r100;
            Intrinsics.checkNotNullParameter(r101, "res");
            if (r101 != DuplicateContentChecker.DuplicateResult.DuplicateAndUserCancel) goto L5;
            tt5.a.h("WikiShortcutToWikiCommand", "createShortcutToWiki cancel. ");
            return Flowable.empty();
        L5:
            WikiSelectorBean r102 = this.f560746a;
            if (r102.f241139l == false) goto L8;
            String r103 = r102.f241132e;
        L9:
            String r104 = r103;
            CreateNodePuller r105 = new CreateNodePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
            j r106 = this.f560747b;
            return r105.d(new CreateNodePuller.Params(r106.f560739b, r106.f560740c, this.f560746a.f241134g, r104, "")).doOnSubscribe(new k(this.f560748c));
        L8:
            r103 = r102.f241131d;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f560749a;

        public c(Context r100) {
            this.f560749a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            wwc.c r101 = (wwc.c) r100;
            Context r102 = this.f560749a;
            Map<String, Integer> r103 = q.f242003a;
            Toast.showLoading(r102, r102.getString(q.e(WikiAction.SHORTCUT)));
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f560750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WikiSelectorBean f560751b;

        public d(j r100, WikiSelectorBean r101) {
            this.f560750a = r100;
            this.f560751b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            TreeNode r101 = (TreeNode) r100;
            tt5.a.h("WikiShortcutToWikiCommand", "createShortcutToWiki ok. ");
            Toast.cancelLoading();
            Bundle r102 = new Bundle();
            r102.putString(DocViewModel.EXTRA_SPACE_ID, this.f560750a.f560739b);
            r102.putString("space_name", this.f560750a.f560741d);
            r102.putString("dest_token", this.f560750a.f560740c);
            r102.putString("src_token", this.f560751b.f241131d);
            r102.putParcelable("tree_node", r101);
            Intent r103 = new Intent();
            r103.putExtras(r102);
            this.f560750a.f560743f.ww(r103);
            j r104 = this.f560750a;
            Intrinsics.checkNotNull(r101);
            Bundle r105 = r104.f560742e;
            if (r105 == null) goto L5;
            SelectorConfig r106 = (SelectorConfig) r105.getParcelable(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG);
        L6:
            if (r106 != null) goto L8;
        L10:
            boolean r107 = false;
        L11:
            if (r107 == false) goto L20;
            Activity r108 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).getActivity();
            if (r108 != null) goto L16;
            return;
        L16:
            if (AppInfoUtils.f().booleanValue() == false) goto L18;
            Map<String, Integer> r109 = q.f242003a;
            Toast.showSuccessText(r108, q.f(WikiAction.SHORTCUT));
            return;
        L18:
            Map<String, Integer> r110 = q.f242003a;
            WikiDialogs.g(r108, q.f(WikiAction.SHORTCUT), new l(r101, r104, r108));
            return;
        L20:
            return;
        L8:
            if (r106.f229375g != 3025) goto L10;
            r107 = true;
            goto L11
        L5:
            r106 = null;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f560752a;

        public e(Context r100) {
            this.f560752a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e("WikiShortcutToWikiCommand", "createShortcutToWiki err. ", r101, false);
            Toast.cancelLoading();
            if (((t) org.koin.java.a.c(t.class, null, null, 6)).a(r101, this.f560752a) == true) goto L7;
            Context r102 = this.f560752a;
            Map<String, Integer> r103 = q.f242003a;
            Toast.showFailureText(r102, q.d(WikiAction.SHORTCUT, r101));
            return;
        }
    }

    static {
    }

    @Override // td5.d
    public final void destroy() {
        Disposable r100 = this.f560745h;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L12;
        Disposable r102 = this.f560745h;
        if (r102 == null) goto L12;
        r102.dispose();
    L12:
        Toast.cancelLoading();
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // td5.d
    public final void execute() {
        WikiSelectorBean r100 = this.f560744g;
        if (r100 != null) goto L5;
        return;
    L5:
        Fragment r101 = this.f560738a;
        if (r101 == null) goto L22;
        Context r102 = r101.getContext();
        if (r102 == null) goto L23;
        Disposable r103 = this.f560745h;
        if (r103 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L20;
        Disposable r105 = this.f560745h;
        if (r105 == null) goto L20;
        r105.dispose();
    L20:
        this.f560745h = DuplicateContentChecker.a(r102, this.f560740c, r100.f241136i, r100.f241137j, 2).flatMap(new b(r100, this, r102)).doOnSubscribe(new c(r102)).subscribe(new d(this, r100), new e(r102));
        return;
    L13:
        if (r103.isDisposed() == true) goto L15;
        r104 = true;
        goto L16
    L23:
        return;
    }

    public j(WikiShortcutToFragment r100, String r101, String r102, String r103, Bundle r104, WikiShortcutToFragment r105) {
        Intrinsics.checkNotNullParameter(r101, "destSpaceId");
        Intrinsics.checkNotNullParameter(r102, "destWikiToken");
        Intrinsics.checkNotNullParameter(r105, "dependence");
        this.f560738a = r100;
        this.f560739b = r101;
        this.f560740c = r102;
        this.f560741d = r103;
        this.f560742e = r104;
        this.f560743f = r105;
        if (r104 == null) goto L5;
        WikiSelectorBean r106 = (WikiSelectorBean) r104.getParcelable("extra_wiki_bean");
    L6:
        this.f560744g = r106;
        return;
    L5:
        r106 = null;
        goto L6
    }
}
