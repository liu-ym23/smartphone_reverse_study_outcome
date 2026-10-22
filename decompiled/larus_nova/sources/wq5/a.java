package wq5;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.folderselect.command.DuplicateContentChecker;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.bear.wikiv2.wikitreev2.shortcut.WikiShortcutToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.CreateNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements td5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f560704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f560705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f560706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f560707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final sq5.a f560708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SpaceSelectorBean f560709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f560710g;

    /* JADX INFO: renamed from: wq5.a$a, reason: collision with other inner class name */
    public static final class C8152a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f560711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SpaceSelectorBean f560712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f560713c;

        public b(a r100, SpaceSelectorBean r101, Context r102) {
            this.f560711a = r100;
            this.f560712b = r101;
            this.f560713c = r102;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            DuplicateContentChecker.DuplicateResult r101 = (DuplicateContentChecker.DuplicateResult) r100;
            Intrinsics.checkNotNullParameter(r101, "res");
            if (r101 != DuplicateContentChecker.DuplicateResult.DuplicateAndUserCancel) goto L5;
            tt5.a.h("SpaceShortcutToWikiCommand", "createShortcutToWiki cancel. ");
            return Flowable.empty();
        L5:
            CreateNodePuller r102 = new CreateNodePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
            a r103 = this.f560711a;
            String r104 = r103.f560705b;
            String r105 = r103.f560706c;
            SpaceSelectorBean r106 = this.f560712b;
            return r102.d(new CreateNodePuller.Params(r104, r105, r106.f229390f, r106.f229386b, r106.f229385a)).doOnSubscribe(new wq5.b(this.f560713c));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f560714a;

        public c(Context r100) {
            this.f560714a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            wwc.c r101 = (wwc.c) r100;
            Context r102 = this.f560714a;
            Map<String, Integer> r103 = q.f242003a;
            Toast.showLoading(r102, r102.getString(q.e(WikiAction.SHORTCUT)));
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f560715a;

        public d(a r100) {
            this.f560715a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            TreeNode r101 = (TreeNode) r100;
            Toast.cancelLoading();
            tt5.a.h("SpaceShortcutToWikiCommand", "createShortcutToWiki ok. ");
            this.f560715a.f560708e.ww(null);
            Activity r102 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).getActivity();
            if (com.bytedance.ee.util.ui.b.a(r102) == false) goto L10;
            if (r102 == null) goto L11;
            a r103 = this.f560715a;
            if (AppInfoUtils.f().booleanValue() == false) goto L8;
            Map<String, Integer> r104 = q.f242003a;
            Toast.showSuccessText(r102, q.f(WikiAction.SHORTCUT));
            return;
        L8:
            Map<String, Integer> r105 = q.f242003a;
            WikiDialogs.g(r102, q.f(WikiAction.SHORTCUT), new wq5.c(r103, r101, r102));
            return;
        L11:
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f560716a;

        public e(a r100) {
            this.f560716a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e("SpaceShortcutToWikiCommand", "createShortcutToWiki err. ", r101, false);
            Toast.cancelLoading();
            if (((t) org.koin.java.a.c(t.class, null, null, 6)).a(r101, this.f560716a.f560708e.P50().f23450e.getActivity()) == true) goto L7;
            Context r102 = this.f560716a.f560704a.getContext();
            Map<String, Integer> r103 = q.f242003a;
            Toast.showFailureText(r102, q.d(WikiAction.SHORTCUT, r101));
            return;
        }
    }

    static {
    }

    @Override // td5.d
    public final void destroy() {
        Disposable r100 = this.f560710g;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L12;
        Disposable r102 = this.f560710g;
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
        SpaceSelectorBean r100 = this.f560709f;
        if (r100 != null) goto L5;
        return;
    L5:
        Fragment r101 = this.f560704a;
        if (r101 == null) goto L22;
        Context r102 = r101.getContext();
        if (r102 == null) goto L23;
        Disposable r103 = this.f560710g;
        if (r103 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L20;
        Disposable r105 = this.f560710g;
        if (r105 == null) goto L20;
        r105.dispose();
    L20:
        this.f560710g = DuplicateContentChecker.a(r102, this.f560706c, r100.f229386b, r100.f229385a, 2).flatMap(new b(this, r100, r102)).doOnSubscribe(new c(r102)).subscribe(new d(this), new e(this));
        return;
    L13:
        if (r103.isDisposed() == true) goto L15;
        r104 = true;
        goto L16
    L23:
        return;
    }

    public a(WikiShortcutToFragment r100, String r101, String r102, String r103, Bundle r104, WikiShortcutToFragment r105) {
        Intrinsics.checkNotNullParameter(r101, "destSpaceId");
        Intrinsics.checkNotNullParameter(r102, "destWikiToken");
        Intrinsics.checkNotNullParameter(r105, "dependency");
        this.f560704a = r100;
        this.f560705b = r101;
        this.f560706c = r102;
        this.f560707d = r103;
        this.f560708e = r105;
        if (r104 == null) goto L5;
        SpaceSelectorBean r106 = (SpaceSelectorBean) r104.getParcelable("extra_space_bean");
    L6:
        this.f560709f = r106;
        return;
    L5:
        r106 = null;
        goto L6
    }
}
