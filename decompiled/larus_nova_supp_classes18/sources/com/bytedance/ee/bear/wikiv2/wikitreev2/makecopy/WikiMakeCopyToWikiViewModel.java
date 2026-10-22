package com.bytedance.ee.bear.wikiv2.wikitreev2.makecopy;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.CopyNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import sbb.e;
import sq5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/makecopy/WikiMakeCopyToWikiViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "makeCopy", "Lio/reactivex/Flowable;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "params", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/makecopy/WikiCopy2WikiVMInitParams;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiMakeCopyToWikiViewModel extends ViewModel {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ NetService a;
        public final /* synthetic */ f b;
        public final /* synthetic */ String c;

        public b(NetService r1, f r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r9) {
            String r4 = (String) r9;
            CopyNodePuller r7 = new CopyNodePuller(this.a);
            f r0 = this.b;
            String r1 = r0.d;
            String r2 = r0.b;
            String r3 = r0.g;
            String r5 = this.c;
            if (r0.c != e.h.b) goto L5;
            boolean r6 = true;
        L7:
            return r7.d(new CopyNodePuller.Params(r1, r2, r3, r4, r5, r6));
        L5:
            r6 = false;
            goto L7
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            TreeNode r3 = (TreeNode) r2;
            Intrinsics.checkNotNullParameter(r3, "node1");
            return r3.parent_wiki_token;
        }
    }

    static {
        Companion = new a();
    }

    public WikiMakeCopyToWikiViewModel() {
    }

    @JvmStatic
    public static final WikiMakeCopyToWikiViewModel get(Fragment r1) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "fragment");
        return (WikiMakeCopyToWikiViewModel) new ViewModelProvider(r1).get(WikiMakeCopyToWikiViewModel.class);
    }

    public final Flowable<TreeNode> makeCopy(f r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        String r2 = "";
        if (TextUtils.equals("wikiroot%shared", r11.e) == false) goto L7;
        if (TextUtils.equals(r11.e, r11.h) == false) goto L7;
    L8:
        Flowable r1 = new GetNodePuller(r0).d(new GetNodePuller.Params(r11.d, r11.b)).map(c.a);
        String r3 = r11.h;
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        Flowable r4 = r1.onErrorReturnItem(r3);
        Intrinsics.checkNotNull(r4);
    L14:
        if (TextUtils.isEmpty(r11.f) == false) goto L16;
        String r5 = t0.e(r11.getContext(), r11.c);
    L19:
        Context r6 = r11.getContext();
        if (r6 == null) goto L26;
        String r7 = r6.getString(2131887720);
        if (r7 == null) goto L26;
        r2 = r7;
    L26:
        if (r11.c != e.l.b) goto L31;
        Intrinsics.checkNotNull(r5);
        int r8 = StringsKt.lastIndexOf$default(r5, ".", 0, false, 6, null);
        if (r8 >= 0) goto L30;
        r8 = r5.length();
    L30:
        String r9 = new StringBuilder(r5).insert(r8, " ".concat(r2)).toString();
    L33:
        return r4.flatMap(new b(r0, r11, r9));
    L31:
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        r9 = String.format("%s %s", Arrays.copyOf(new Object[]{r5, r2}, 2));
        goto L33
    L16:
        r5 = r11.f;
        if (r5 != null) goto L19;
        r5 = "";
    L7:
        if (TextUtils.isEmpty(r11.h) == true) goto L8;
        r4 = Flowable.just(r11.h);
        Intrinsics.checkNotNull(r4);
        goto L14
    }
}
