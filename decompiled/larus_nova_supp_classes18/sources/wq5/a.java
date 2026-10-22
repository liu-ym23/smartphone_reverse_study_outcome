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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements td5.d {
    public final Fragment a;
    public final String b;
    public final String c;
    public final String d;
    public final sq5.a e;
    public final SpaceSelectorBean f;
    public Disposable g;

    /* JADX INFO: renamed from: wq5.a$a, reason: collision with other inner class name */
    public static final class C0329a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ a a;
        public final /* synthetic */ SpaceSelectorBean b;
        public final /* synthetic */ Context c;

        public b(a r1, SpaceSelectorBean r2, Context r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r8) {
            DuplicateContentChecker.DuplicateResult r9 = (DuplicateContentChecker.DuplicateResult) r8;
            Intrinsics.checkNotNullParameter(r9, "res");
            if (r9 != DuplicateContentChecker.DuplicateResult.DuplicateAndUserCancel) goto L5;
            tt5.a.h("SpaceShortcutToWikiCommand", "createShortcutToWiki cancel. ");
            return Flowable.empty();
        L5:
            CreateNodePuller r0 = new CreateNodePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
            a r1 = this.a;
            String r2 = r1.b;
            String r3 = r1.c;
            SpaceSelectorBean r4 = this.b;
            return r0.d(new CreateNodePuller.Params(r2, r3, r4.f, r4.b, r4.a)).doOnSubscribe(new wq5.b(this.c));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Context a;

        public c(Context r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            wwc.c r3 = (wwc.c) r2;
            Context r4 = this.a;
            Map<String, Integer> r0 = q.a;
            Toast.showLoading(r4, r4.getString(q.e(WikiAction.SHORTCUT)));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            TreeNode r6 = (TreeNode) r5;
            Toast.cancelLoading();
            tt5.a.h("SpaceShortcutToWikiCommand", "createShortcutToWiki ok. ");
            this.a.e.ww(null);
            Activity r0 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).getActivity();
            if (com.bytedance.ee.util.ui.b.a(r0) == false) goto L10;
            if (r0 == null) goto L11;
            a r1 = this.a;
            if (AppInfoUtils.f().booleanValue() == false) goto L8;
            Map<String, Integer> r7 = q.a;
            Toast.showSuccessText(r0, q.f(WikiAction.SHORTCUT));
            return;
        L8:
            Map<String, Integer> r2 = q.a;
            WikiDialogs.g(r0, q.f(WikiAction.SHORTCUT), new wq5.c(r1, r6, r0));
            return;
        L11:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("SpaceShortcutToWikiCommand", "createShortcutToWiki err. ", r5, false);
            Toast.cancelLoading();
            if (((t) org.koin.java.a.c(t.class, null, null, 6)).a(r5, this.a.e.P50().e.getActivity()) == true) goto L7;
            Context r0 = this.a.a.getContext();
            Map<String, Integer> r1 = q.a;
            Toast.showFailureText(r0, q.d(WikiAction.SHORTCUT, r5));
            return;
        }
    }

    static {
    }

    @Override // td5.d
    public final void destroy() {
        Disposable r0 = this.g;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        Disposable r2 = this.g;
        if (r2 == null) goto L12;
        r2.dispose();
    L12:
        Toast.cancelLoading();
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // td5.d
    public final void execute() {
        SpaceSelectorBean r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        Fragment r1 = this.a;
        if (r1 == null) goto L22;
        Context r2 = r1.getContext();
        if (r2 == null) goto L23;
        Disposable r3 = this.g;
        if (r3 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L20;
        Disposable r5 = this.g;
        if (r5 == null) goto L20;
        r5.dispose();
    L20:
        this.g = DuplicateContentChecker.a(r2, this.c, r0.b, r0.a, 2).flatMap(new b(this, r0, r2)).doOnSubscribe(new c(r2)).subscribe(new d(this), new e(this));
        return;
    L13:
        if (r3.isDisposed() == true) goto L15;
        r4 = true;
        goto L16
    L23:
        return;
    }

    public a(WikiShortcutToFragment r2, String r3, String r4, String r5, Bundle r6, WikiShortcutToFragment r7) {
        Intrinsics.checkNotNullParameter(r3, "destSpaceId");
        Intrinsics.checkNotNullParameter(r4, "destWikiToken");
        Intrinsics.checkNotNullParameter(r7, "dependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        if (r6 == null) goto L5;
        SpaceSelectorBean r8 = (SpaceSelectorBean) r6.getParcelable("extra_space_bean");
    L6:
        this.f = r8;
        return;
    L5:
        r8 = null;
        goto L6
    }
}
