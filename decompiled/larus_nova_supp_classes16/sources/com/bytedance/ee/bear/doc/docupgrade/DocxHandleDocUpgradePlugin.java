package com.bytedance.ee.bear.doc.docupgrade;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocActivity;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w05.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/doc/docupgrade/DocxHandleDocUpgradePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "handleDocStatus", "docMetaInfo", "Lcom/bytedance/ee/bear/DocMetaInfo;", "docToken", "", "docxToken", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocxHandleDocUpgradePlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    public static final String TAG = "DocxHandleDocUpgradePlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b<T1, T2, R> implements BiFunction {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r5, Object r6) {
            Boolean r7 = (Boolean) r5;
            Boolean r8 = (Boolean) r6;
            Intrinsics.checkNotNullParameter(r7, "isDocManualOffline");
            Intrinsics.checkNotNullParameter(r8, "isDocxManualOffline");
            if (r7.booleanValue() == false) goto L6;
            Document r0 = new Document();
            r0.d = this.a;
            r0.b = sbb.e.g.b;
            ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).A(r0);
        L6:
            if (r7.booleanValue() == true) goto L8;
        L10:
            boolean r9 = false;
        L12:
            return Boolean.valueOf(r9);
        L8:
            if (r8.booleanValue() == true) goto L10;
            r9 = true;
            goto L12
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ DocxHandleDocUpgradePlugin b;
        public final /* synthetic */ DocMetaInfo c;

        public c(String r1, DocxHandleDocUpgradePlugin r2, DocMetaInfo r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r5) {
            Boolean r6 = (Boolean) r5;
            Intrinsics.checkNotNullParameter(r6, "shouldManualOfflineOn");
            if (r6.booleanValue() == false) goto L11;
            Document r7 = new Document();
            String r0 = this.a;
            DocxHandleDocUpgradePlugin r1 = this.b;
            DocMetaInfo r2 = this.c;
            r7.d = r0;
            sbb.e r3 = sbb.e.o;
            r7.b = r3.b;
            DocViewModel r4 = DocxHandleDocUpgradePlugin.access$getDocViewModel(r1);
            if (r4 == null) goto L8;
            String r8 = r4.getDocTitle();
        L9:
            r7.a = r8;
            r7.j = r2.getCreateTime();
            r7.F = r3.getType();
            r7.e = r2.getOwnerUid();
            r7.f = r2.getCreatorTenantId();
            r7.i = r2.getEditTime();
            return ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).L(this.a).map(new com.bytedance.ee.bear.doc.docupgrade.c(r7));
        L8:
            r8 = null;
            goto L9
        L11:
            return Flowable.just(Boolean.TRUE);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            tt5.a.h(DocxHandleDocUpgradePlugin.TAG, "handle manual offline download success");
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r4) {
            tt5.a.e(DocxHandleDocUpgradePlugin.TAG, "handle manual offline download failed!", (Throwable) r4, false);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DocxHandleDocUpgradePlugin() {
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(DocxHandleDocUpgradePlugin r0) {
        return r0.getDocViewModel();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToUIContainer(r2, r3);
        DocViewModel r4 = getDocViewModel();
        if (r4 == null) goto L10;
        i r5 = r4.getDocumentInfoProvider();
        if (r5 == null) goto L11;
        MutableLiveData<DocumentInfo> r6 = r5.g();
        if (r6 == null) goto L12;
        r6.observe(r2.getLifecycleOwner(), new C03371(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void handleDocStatus(DocMetaInfo r5, final String r6, final String r7) {
        Flowable.zip(((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).S(r6), ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).S(r7), new b(r6)).flatMap(new c(r7, this, r5)).subscribe(d.a, e.a);
        if ((getActivity() instanceof DocActivity) == true) goto L6;
        vqb.b.a().getAllTabs(new AnonymousClass1(r6, r7));
        return;
    L6:
        com.ss.android.lark.multitask.task.c.a();
        throw null;
    }

    public static final /* synthetic */ void access$handleDocStatus(DocxHandleDocUpgradePlugin r0, DocMetaInfo r1, String r2, String r3) {
        r0.handleDocStatus(r1, r2, r3);
    }
}
