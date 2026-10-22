package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.CreateNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/create/WikiCreateToViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "createWiki", "Lio/reactivex/Flowable;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "spaceId", "", WikiFolderPushPlugin.WIKI_TOKEN, "documentType", "", "title", "templateToken", "extraInfo", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiCreateToViewModel extends ViewModel {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            TreeNode r3 = (TreeNode) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3;
        }
    }

    static {
        Companion = new a();
    }

    public WikiCreateToViewModel() {
    }

    @JvmStatic
    public static final WikiCreateToViewModel get(Fragment r1) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "fragment");
        return (WikiCreateToViewModel) ViewModelProviders.of(r1).get(WikiCreateToViewModel.class);
    }

    public final Flowable<TreeNode> createWiki(String r8, String r9, int r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r8, "spaceId");
        Intrinsics.checkNotNullParameter(r9, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r12, "templateToken");
        Intrinsics.checkNotNullParameter(r13, "extraInfo");
        CreateNodePuller.Params r0 = new CreateNodePuller.Params(r8, r9, r11, r10, "");
        if ((!StringsKt.isBlank(r12)) == false) goto L6;
        r0.template_token = r12;
    L6:
        if ((!StringsKt.isBlank(r13)) == false) goto L9;
        r0.ext_info_str = r13;
    L9:
        return new CreateNodePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).d(r0).map(b.a);
    }
}
