package wq5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.NetService;
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
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements td5.d {
    public final Fragment a;
    public final String b;
    public final String c;
    public final String d;
    public final Bundle e;
    public final sq5.a f;
    public final WikiSelectorBean g;
    public Disposable h;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ WikiSelectorBean a;
        public final /* synthetic */ j b;
        public final /* synthetic */ Context c;

        public b(WikiSelectorBean r1, j r2, Context r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r8) {
            DuplicateContentChecker.DuplicateResult r9 = (DuplicateContentChecker.DuplicateResult) r8;
            Intrinsics.checkNotNullParameter(r9, "res");
            if (r9 != DuplicateContentChecker.DuplicateResult.DuplicateAndUserCancel) goto L5;
            tt5.a.h("WikiShortcutToWikiCommand", "createShortcutToWiki cancel. ");
            return Flowable.empty();
        L5:
            WikiSelectorBean r10 = this.a;
            if (r10.l == false) goto L8;
            String r11 = r10.e;
        L9:
            String r4 = r11;
            CreateNodePuller r6 = new CreateNodePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
            j r0 = this.b;
            return r6.d(new CreateNodePuller.Params(r0.b, r0.c, this.a.g, r4, "")).doOnSubscribe(new k(this.c));
        L8:
            r11 = r10.d;
            goto L9
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
        public final /* synthetic */ j a;
        public final /* synthetic */ WikiSelectorBean b;

        public d(j r1, WikiSelectorBean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            TreeNode r6 = (TreeNode) r5;
            tt5.a.h("WikiShortcutToWikiCommand", "createShortcutToWiki ok. ");
            Toast.cancelLoading();
            Bundle r0 = new Bundle();
            r0.putString("space_id", this.a.b);
            r0.putString("space_name", this.a.d);
            r0.putString("dest_token", this.a.c);
            r0.putString("src_token", this.b.d);
            r0.putParcelable("tree_node", r6);
            Intent r1 = new Intent();
            r1.putExtras(r0);
            this.a.f.ww(r1);
            j r2 = this.a;
            Intrinsics.checkNotNull(r6);
            Bundle r3 = r2.e;
            if (r3 == null) goto L5;
            SelectorConfig r4 = (SelectorConfig) r3.getParcelable("extra_config");
        L6:
            if (r4 != null) goto L8;
        L10:
            boolean r7 = false;
        L11:
            if (r7 == false) goto L20;
            Activity r8 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).getActivity();
            if (r8 != null) goto L16;
            return;
        L16:
            if (AppInfoUtils.f().booleanValue() == false) goto L18;
            Map<String, Integer> r9 = q.a;
            Toast.showSuccessText(r8, q.f(WikiAction.SHORTCUT));
            return;
        L18:
            Map<String, Integer> r10 = q.a;
            WikiDialogs.g(r8, q.f(WikiAction.SHORTCUT), new l(r6, r2, r8));
            return;
        L20:
            return;
        L8:
            if (r4.g != 3025) goto L10;
            r7 = true;
            goto L11
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Context a;

        public e(Context r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("WikiShortcutToWikiCommand", "createShortcutToWiki err. ", r5, false);
            Toast.cancelLoading();
            if (((t) org.koin.java.a.c(t.class, null, null, 6)).a(r5, this.a) == true) goto L7;
            Context r0 = this.a;
            Map<String, Integer> r1 = q.a;
            Toast.showFailureText(r0, q.d(WikiAction.SHORTCUT, r5));
            return;
        }
    }

    static {
    }

    @Override // td5.d
    public final void destroy() {
        Disposable r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        Disposable r2 = this.h;
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
        WikiSelectorBean r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        Fragment r1 = this.a;
        if (r1 == null) goto L22;
        Context r2 = r1.getContext();
        if (r2 == null) goto L23;
        Disposable r3 = this.h;
        if (r3 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L20;
        Disposable r5 = this.h;
        if (r5 == null) goto L20;
        r5.dispose();
    L20:
        this.h = DuplicateContentChecker.a(r2, this.c, r0.i, r0.j, 2).flatMap(new b(r0, this, r2)).doOnSubscribe(new c(r2)).subscribe(new d(this, r0), new e(r2));
        return;
    L13:
        if (r3.isDisposed() == true) goto L15;
        r4 = true;
        goto L16
    L23:
        return;
    }

    public j(WikiShortcutToFragment r2, String r3, String r4, String r5, Bundle r6, WikiShortcutToFragment r7) {
        Intrinsics.checkNotNullParameter(r3, "destSpaceId");
        Intrinsics.checkNotNullParameter(r4, "destWikiToken");
        Intrinsics.checkNotNullParameter(r7, "dependence");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        if (r6 == null) goto L5;
        WikiSelectorBean r8 = (WikiSelectorBean) r6.getParcelable("extra_wiki_bean");
    L6:
        this.g = r8;
        return;
    L5:
        r8 = null;
        goto L6
    }
}
