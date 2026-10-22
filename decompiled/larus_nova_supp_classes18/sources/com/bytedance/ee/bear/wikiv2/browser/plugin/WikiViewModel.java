package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.NonStickyMutableLiveData;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePermPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a3;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\b*\u0002PS\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0007080:J\u0006\u0010;\u001a\u00020\u000eJ\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020\u000eJ\u000e\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020\u0007J\b\u0010C\u001a\u0004\u0018\u00010%J\u0006\u0010D\u001a\u00020\u0007J\u0006\u0010E\u001a\u00020\u0007J\b\u0010F\u001a\u00020GH\u0002J\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00070IJ\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010J\u001a\u00020G2\b\u0010K\u001a\u0004\u0018\u00010LJ\b\u0010M\u001a\u00020GH\u0002J\b\u0010N\u001a\u00020GH\u0002J\u0012\u0010U\u001a\u00020G2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\b\u0010V\u001a\u00020GH\u0002J\b\u0010W\u001a\u0004\u0018\u00010%J\b\u0010X\u001a\u00020GH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0007080\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u00020PX\u0082\u000e¢\u0006\u0004\n\u0002\u0010QR\u0010\u0010R\u001a\u00020SX\u0082\u000e¢\u0006\u0004\n\u0002\u0010T¨\u0006Z"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "isInit", "", "wikiInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/contract/route/parcelable/WikiInfo;", "getWikiInfo", "()Landroidx/lifecycle/MutableLiveData;", "wikiTokenLiveData", "", "getWikiTokenLiveData", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "getBearUrl", "()Lcom/bytedance/ee/bear/domain/BearUrl;", "setBearUrl", "(Lcom/bytedance/ee/bear/domain/BearUrl;)V", WikiFolderPushPlugin.WIKI_TOKEN, "getWikiToken", "()Ljava/lang/String;", "setWikiToken", "(Ljava/lang/String;)V", "spaceId", "getSpaceId", "setSpaceId", "spaceName", "getSpaceName", "setSpaceName", "uniqueUiId", "getUniqueUiId", "setUniqueUiId", "pathResolveContext", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/pathresolve/WikiPathResolveContext;", "pathResolveContextConsumed", "wikiPerm", "Lcom/bytedance/ee/bear/contract/route/parcelable/WikNodePerm;", "getWikiPerm", "()Lcom/bytedance/ee/bear/contract/route/parcelable/WikNodePerm;", "setWikiPerm", "(Lcom/bytedance/ee/bear/contract/route/parcelable/WikNodePerm;)V", "wikiMeta", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "getWikiMeta", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "setWikiMeta", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;)V", "isMyLib", "()Z", "setMyLib", "(Z)V", "wikiMetaStatus", "Lcom/bytedance/ee/util/Result;", "getWikiMetaStatus", "Landroidx/lifecycle/LiveData;", "getObjToken", "getObjType", "", "getObjTypeValueString", "isType", ResourceData.KEY_TYPE, "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "isShortcut", "consumePathResolveContext", "hasPathResolveContext", "isPathResolveContextConsumed", "resetPathResolveContext", "", "updatePerm", "Lio/reactivex/Flowable;", "init", "args", "Landroid/os/Bundle;", "doInit", "requestMetaAndPerm", "tokenChangeObserver", "com/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel$tokenChangeObserver$1", "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel$tokenChangeObserver$1;", "urlChangeObserver", "com/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel$urlChangeObserver$1", "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel$urlChangeObserver$1;", "readArgs", "preparePathResolveContext", "retryPathResolveContext", "onCleared", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "Wiki_WikiViewModel";
    private BearUrl bearUrl;
    private final CompositeDisposable disposables;
    private boolean isInit;
    private boolean isMyLib;
    private ar5.a pathResolveContext;
    private boolean pathResolveContextConsumed;
    private String spaceId;
    private String spaceName;
    private WikiViewModel$tokenChangeObserver$1 tokenChangeObserver;
    private String uniqueUiId;
    private WikiViewModel$urlChangeObserver$1 urlChangeObserver;
    private final MutableLiveData<WikiInfo> wikiInfo;
    private TreeNode wikiMeta;
    private final MutableLiveData<cu5.b<Boolean>> wikiMetaStatus;
    private WikNodePerm wikiPerm;
    private String wikiToken;
    private final MutableLiveData<String> wikiTokenLiveData;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ WikiViewModel a;

        public b(WikiViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            WikiViewModel r0 = this.a;
            r0.setWikiPerm((WikNodePerm) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r4) {
            tt5.a.e(WikiViewModel.TAG, "requestWikiPerm err. ", (Throwable) r4, false);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ WikiViewModel a;

        public d(WikiViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            TreeNode r5 = (TreeNode) r4;
            this.a.setWikiMeta(r5);
            WikiViewModel r0 = this.a;
            String r1 = r5.space_id;
            String r2 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r0.setSpaceId(r1);
            WikiInfo r3 = (WikiInfo) this.a.getWikiInfo().getValue();
            if (r3 == null) goto L13;
            String r6 = r5.space_id;
            if (r6 == null) goto L11;
            r2 = r6;
        L11:
            r3.setSpaceId(r2);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ WikiViewModel a;

        public e(WikiViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e(WikiViewModel.TAG, "requestWikiMeta err. ", r5, false);
            MutableLiveData r0 = WikiViewModel.access$getWikiMetaStatus$p(this.a);
            Intrinsics.checkNotNull(r5);
            r0.setValue(new cu5.b.a(r5, null));
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ WikiViewModel a;

        public f(WikiViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            SpaceInfo r4 = (SpaceInfo) r3;
            this.a.setMyLib(r4.isMyLib());
            this.a.setSpaceName(r4.getSpaceName());
        }
    }

    public static final class g<T> implements Consumer {
        public static final g<T> a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r3) {
            tt5.a.d(WikiViewModel.TAG, "getSpaceInfo fail: " + ((Throwable) r3));
        }
    }

    public static final class h<T, R> implements Function {
        public final /* synthetic */ WikiViewModel a;

        public h(WikiViewModel r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            WikNodePerm r3 = (WikNodePerm) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            this.a.setWikiPerm(r3);
            return Boolean.TRUE;
        }
    }

    public static final class i<T, R> implements Function {
        public static final i<T, R> a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final Object apply(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            tt5.a.e(WikiViewModel.TAG, "updatePerm err. ", r5, false);
            return Boolean.FALSE;
        }
    }

    static {
        Companion = new a();
    }

    private final void resetPathResolveContext() {
        this.pathResolveContext = null;
        this.pathResolveContextConsumed = false;
    }

    private final void doInit() {
        if (TextUtils.isEmpty(this.spaceId) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        tt5.a.b(TAG, "request WikiPerm and meta. emptyToken: " + r0);
        if (r0 == false) goto L12;
        return;
    L12:
        NonStickyMutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.f> r1 = WikiTreeObserver.a;
        WikiTreeObserver.f.a(this.tokenChangeObserver);
        WikiTreeObserver.g.a(this.urlChangeObserver);
        if (bx4.b.b(this.wikiToken) == false) goto L16;
        tt5.a.h(TAG, "current token is a fake token, skip request perm and meta. token: " + this.wikiToken);
        return;
    L16:
        requestMetaAndPerm();
        return;
    L5:
        if (TextUtils.isEmpty(this.wikiToken) == true) goto L8;
        r0 = false;
        goto L9
    }

    private final void requestMetaAndPerm() {
        tt5.a.h(TAG, "request meta and perm");
        up5.g.a(new GetNodePermPuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).d(new GetNodePermPuller.Params(this.spaceId, this.wikiToken)).subscribe(new b(this), c.a), this.disposables);
        up5.g.a(new GetNodePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).d(new GetNodePuller.Params(this.spaceId, this.wikiToken, true)).subscribe(new d(this), new e(this)), this.disposables);
        a3 r0 = a3.a;
        String r1 = this.spaceId;
        r0.getClass();
        up5.g.a(a3.a(r1).subscribe(new f(this), g.a), this.disposables);
    }

    public final ar5.a consumePathResolveContext() {
        ar5.a r0 = this.pathResolveContext;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (this.pathResolveContextConsumed == true) goto L11;
        this.pathResolveContextConsumed = true;
        return r0;
    L11:
        return null;
    }

    public final String getObjToken() {
        WikiInfo r0 = (WikiInfo) this.wikiInfo.getValue();
        if (r0 == null) goto L6;
        String r1 = r0.getObjToken();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final int getObjType() {
        WikiInfo r0 = (WikiInfo) this.wikiInfo.getValue();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getObjType();
    }

    public final String getObjTypeValueString() {
        WikiInfo r0 = (WikiInfo) this.wikiInfo.getValue();
        if (r0 == null) goto L6;
        String r1 = r0.getObjTypeString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "unknown";
    }

    public final boolean hasPathResolveContext() {
        if (this.pathResolveContext == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPathResolveContextConsumed() {
        if (this.pathResolveContext != null) goto L5;
    L7:
        return false;
    L5:
        if (this.pathResolveContextConsumed == false) goto L7;
        return true;
    }

    public final boolean isShortcut() {
        TreeNode r0 = this.wikiMeta;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isShortcut();
    }

    public final Flowable<Boolean> updatePerm() {
        return new GetNodePermPuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).d(new GetNodePermPuller.Params(this.spaceId, this.wikiToken)).map(new h(this)).onErrorReturn(i.a);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ee.bear.wikiv2.browser.plugin.WikiViewModel$tokenChangeObserver$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.ee.bear.wikiv2.browser.plugin.WikiViewModel$urlChangeObserver$1] */
    public WikiViewModel() {
        this.disposables = new CompositeDisposable();
        this.wikiInfo = new MutableLiveData();
        this.wikiTokenLiveData = new MutableLiveData();
        this.wikiToken = "";
        this.spaceId = "";
        this.uniqueUiId = "";
        this.wikiMetaStatus = new MutableLiveData();
        this.tokenChangeObserver = new WikiViewModel$tokenChangeObserver$1(this);
        this.urlChangeObserver = new WikiViewModel$urlChangeObserver$1(this);
    }

    private final void preparePathResolveContext() {
        if (yp5.c.h() == true) goto L6;
        resetPathResolveContext();
        return;
    L6:
        BearUrl r0 = this.bearUrl;
        String r1 = null;
        if (r0 == null) goto L9;
        String r2 = r0.b;
    L10:
        String r3 = "";
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        boolean r4 = false;
        if (r2.length() != 0) goto L16;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
    L67:
        StringBuilder r6 = new StringBuilder("preparePathResolveContext reset: empty token, urlTokenEmpty=");
        if (r2.length() != 0) goto L70;
        boolean r7 = true;
    L71:
        r6.append(r7);
        r6.append(", wikiTokenEmpty=");
        if (this.wikiToken.length() != 0) goto L74;
        r4 = true;
    L74:
        r6.append(r4);
        tt5.a.d(TAG, r6.toString());
        resetPathResolveContext();
        return;
    L70:
        r7 = false;
        goto L71
    L20:
        if (this.wikiToken.length() != 0) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L67;
        if (Intrinsics.areEqual(r2, this.wikiToken) == true) goto L35;
        boolean r9 = bx4.b.b(r2);
        boolean r10 = bx4.b.b(this.wikiToken);
        if (r9 == false) goto L31;
        if (r10 == true) goto L31;
        boolean r11 = true;
    L32:
        if (r11 == true) goto L35;
        tt5.a.d(TAG, "preparePathResolveContext reset: token mismatch, urlTokenFake=" + r9 + ", wikiTokenFake=" + r10);
        resetPathResolveContext();
        return;
    L31:
        r11 = false;
    L35:
        BearUrl r12 = this.bearUrl;
        if (r12 == null) goto L40;
        Map r13 = r12.d;
        if (r13 == null) goto L40;
        String r14 = (String) r13.get("visible_space_id");
    L41:
        if (r14 == null) goto L45;
        r3 = r14;
    L45:
        if (r3.length() != 0) goto L47;
        boolean r15 = true;
    L48:
        if (r15 == false) goto L57;
        ar5.a r16 = this.pathResolveContext;
        if (r16 == null) goto L53;
        r1 = r16.c;
    L53:
        if (Intrinsics.areEqual(r1, this.wikiToken) == true) goto L76;
        resetPathResolveContext();
        return;
    L76:
        return;
    L57:
        if (this.wikiToken.length() != 0) goto L59;
        r4 = true;
    L59:
        if (r4 == false) goto L61;
    L65:
        resetPathResolveContext();
        return;
    L61:
        if (Intrinsics.areEqual(r3, this.spaceId) == true) goto L65;
        resetPathResolveContext();
        this.pathResolveContext = new ar5.a(r3, 1, this.wikiToken, UUID.randomUUID().toString());
        return;
    L47:
        r15 = false;
    L40:
        r14 = null;
        goto L41
    L22:
        r8 = false;
        goto L23
    L16:
        r5 = false;
        goto L18
    L9:
        r2 = null;
        goto L10
    }

    public void onCleared() {
        super.onCleared();
        resetPathResolveContext();
        this.disposables.clear();
        NonStickyMutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.f> r0 = WikiTreeObserver.a;
        WikiTreeObserver.f.d(this.tokenChangeObserver);
        WikiTreeObserver.g.d(this.urlChangeObserver);
    }

    public final ar5.a retryPathResolveContext() {
        if (yp5.c.h() == true) goto L5;
        return null;
    L5:
        ar5.a r0 = this.pathResolveContext;
        if (r0 != null) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(r0.c, this.wikiToken) == true) goto L11;
        return null;
    L11:
        String r1 = UUID.randomUUID().toString();
        String r2 = r0.a;
        int r3 = r0.b;
        String r4 = r0.c;
        Intrinsics.checkNotNullParameter(r2, "visibleSpaceId");
        Intrinsics.checkNotNullParameter(r4, "targetWikiToken");
        Intrinsics.checkNotNullParameter(r1, "loadIdentity");
        return new ar5.a(r2, r3, r4, r1);
    }

    public final BearUrl getBearUrl() {
        return this.bearUrl;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final String getSpaceName() {
        return this.spaceName;
    }

    public final String getUniqueUiId() {
        return this.uniqueUiId;
    }

    public final MutableLiveData<WikiInfo> getWikiInfo() {
        return this.wikiInfo;
    }

    public final TreeNode getWikiMeta() {
        return this.wikiMeta;
    }

    public final LiveData<cu5.b<Boolean>> getWikiMetaStatus() {
        return this.wikiMetaStatus;
    }

    public final WikNodePerm getWikiPerm() {
        return this.wikiPerm;
    }

    public final String getWikiToken() {
        return this.wikiToken;
    }

    public final MutableLiveData<String> getWikiTokenLiveData() {
        return this.wikiTokenLiveData;
    }

    public final boolean isInit() {
        return this.isInit;
    }

    public final boolean isMyLib() {
        return this.isMyLib;
    }

    public static final /* synthetic */ MutableLiveData access$getWikiMetaStatus$p(WikiViewModel r0) {
        return r0.wikiMetaStatus;
    }

    public static final /* synthetic */ void access$preparePathResolveContext(WikiViewModel r0) {
        r0.preparePathResolveContext();
    }

    public static final /* synthetic */ void access$requestMetaAndPerm(WikiViewModel r0) {
        r0.requestMetaAndPerm();
    }

    private final void readArgs(Bundle r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        BearUrl r0 = s45.p.a().Z(r4.getString(ResourceData.KEY_URL));
        this.bearUrl = r0;
        if (r0 == null) goto L8;
        String r2 = r0.b;
        if (r2 == null) goto L8;
    L9:
        this.wikiToken = r2;
        MutableLiveData<String> r3 = this.wikiTokenLiveData;
        if (r0 == null) goto L13;
        String r1 = r0.b;
        if (r1 == null) goto L13;
    L14:
        r3.setValue(r1);
        String r5 = r4.getString("space_id");
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        this.spaceId = r5;
        this.spaceName = r4.getString("space_name");
        this.uniqueUiId = r4.getString("unique_ui_id", "");
        WikiInfo r6 = r4.getSerializable("wiki_info");
        if (r6 == null) goto L20;
        this.wikiInfo.setValue(r6);
        this.spaceId = r6.getSpaceId();
    L20:
        preparePathResolveContext();
        return;
    L13:
        r1 = "";
    L8:
        r2 = "";
        goto L9
    }

    public final void init(Bundle r3) {
        if (this.isInit == true) goto L6;
        tt5.a.h(TAG, "WikiViewModel.init");
        readArgs(r3);
        doInit();
        this.isInit = true;
        return;
    }

    public final boolean isType(sbb.e r2) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TYPE);
        if (r2.b != getObjType()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setBearUrl(BearUrl r1) {
        this.bearUrl = r1;
    }

    public final void setMyLib(boolean r1) {
        this.isMyLib = r1;
    }

    public final void setSpaceId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.spaceId = r2;
    }

    public final void setSpaceName(String r1) {
        this.spaceName = r1;
    }

    public final void setUniqueUiId(String r1) {
        this.uniqueUiId = r1;
    }

    public final void setWikiMeta(TreeNode r1) {
        this.wikiMeta = r1;
    }

    public final void setWikiPerm(WikNodePerm r1) {
        this.wikiPerm = r1;
    }

    public final void setWikiToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.wikiToken = r2;
    }
}
