package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.NonStickyMutableLiveData;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePermPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a3;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\b*\u0002PS\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0007080:J\u0006\u0010;\u001a\u00020\u000eJ\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020\u000eJ\u000e\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020\u0007J\b\u0010C\u001a\u0004\u0018\u00010%J\u0006\u0010D\u001a\u00020\u0007J\u0006\u0010E\u001a\u00020\u0007J\b\u0010F\u001a\u00020GH\u0002J\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00070IJ\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010J\u001a\u00020G2\b\u0010K\u001a\u0004\u0018\u00010LJ\b\u0010M\u001a\u00020GH\u0002J\b\u0010N\u001a\u00020GH\u0002J\u0012\u0010U\u001a\u00020G2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\b\u0010V\u001a\u00020GH\u0002J\b\u0010W\u001a\u0004\u0018\u00010%J\b\u0010X\u001a\u00020GH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0007080\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u00020PX\u0082\u000e¢\u0006\u0004\n\u0002\u0010QR\u0010\u0010R\u001a\u00020SX\u0082\u000e¢\u0006\u0004\n\u0002\u0010T¨\u0006Z"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "isInit", "", "wikiInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/contract/route/parcelable/WikiInfo;", "getWikiInfo", "()Landroidx/lifecycle/MutableLiveData;", "wikiTokenLiveData", "", "getWikiTokenLiveData", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "getBearUrl", "()Lcom/bytedance/ee/bear/domain/BearUrl;", "setBearUrl", "(Lcom/bytedance/ee/bear/domain/BearUrl;)V", WikiFolderPushPlugin.WIKI_TOKEN, "getWikiToken", "()Ljava/lang/String;", "setWikiToken", "(Ljava/lang/String;)V", "spaceId", "getSpaceId", "setSpaceId", "spaceName", "getSpaceName", "setSpaceName", "uniqueUiId", "getUniqueUiId", "setUniqueUiId", "pathResolveContext", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/pathresolve/WikiPathResolveContext;", "pathResolveContextConsumed", "wikiPerm", "Lcom/bytedance/ee/bear/contract/route/parcelable/WikNodePerm;", "getWikiPerm", "()Lcom/bytedance/ee/bear/contract/route/parcelable/WikNodePerm;", "setWikiPerm", "(Lcom/bytedance/ee/bear/contract/route/parcelable/WikNodePerm;)V", "wikiMeta", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "getWikiMeta", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "setWikiMeta", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;)V", "isMyLib", "()Z", "setMyLib", "(Z)V", "wikiMetaStatus", "Lcom/bytedance/ee/util/Result;", "getWikiMetaStatus", "Landroidx/lifecycle/LiveData;", "getObjToken", "getObjType", "", "getObjTypeValueString", "isType", "type", "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "isShortcut", "consumePathResolveContext", "hasPathResolveContext", "isPathResolveContextConsumed", "resetPathResolveContext", "", "updatePerm", "Lio/reactivex/Flowable;", "init", "args", "Landroid/os/Bundle;", "doInit", "requestMetaAndPerm", "tokenChangeObserver", "com/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel$tokenChangeObserver$1", "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel$tokenChangeObserver$1;", "urlChangeObserver", "com/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel$urlChangeObserver$1", "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel$urlChangeObserver$1;", "readArgs", "preparePathResolveContext", "retryPathResolveContext", "onCleared", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiViewModel f240521a;

        public b(WikiViewModel r100) {
            this.f240521a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            WikiViewModel r101 = this.f240521a;
            r101.setWikiPerm((WikNodePerm) r100);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f240522a = null;

        static {
            f240522a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e(WikiViewModel.TAG, "requestWikiPerm err. ", (Throwable) r100, false);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiViewModel f240523a;

        public d(WikiViewModel r100) {
            this.f240523a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            TreeNode r101 = (TreeNode) r100;
            this.f240523a.setWikiMeta(r101);
            WikiViewModel r102 = this.f240523a;
            String r103 = r101.space_id;
            String r104 = "";
            if (r103 != null) goto L5;
            r103 = "";
        L5:
            r102.setSpaceId(r103);
            WikiInfo r105 = this.f240523a.getWikiInfo().getValue();
            if (r105 == null) goto L13;
            String r106 = r101.space_id;
            if (r106 == null) goto L11;
            r104 = r106;
        L11:
            r105.setSpaceId(r104);
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiViewModel f240524a;

        public e(WikiViewModel r100) {
            this.f240524a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e(WikiViewModel.TAG, "requestWikiMeta err. ", r101, false);
            MutableLiveData r102 = WikiViewModel.access$getWikiMetaStatus$p(this.f240524a);
            Intrinsics.checkNotNull(r101);
            r102.setValue(new cu5.b.a(r101, null));
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiViewModel f240525a;

        public f(WikiViewModel r100) {
            this.f240525a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            SpaceInfo r101 = (SpaceInfo) r100;
            this.f240525a.setMyLib(r101.isMyLib());
            this.f240525a.setSpaceName(r101.getSpaceName());
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g<T> f240526a = null;

        static {
            f240526a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d(WikiViewModel.TAG, "getSpaceInfo fail: " + ((Throwable) r100));
        }
    }

    public static final class h<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiViewModel f240527a;

        public h(WikiViewModel r100) {
            this.f240527a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            WikNodePerm r101 = (WikNodePerm) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            this.f240527a.setWikiPerm(r101);
            return Boolean.TRUE;
        }
    }

    public static final class i<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i<T, R> f240528a = null;

        static {
            f240528a = new i();
        }

        public i() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            tt5.a.e(WikiViewModel.TAG, "updatePerm err. ", r101, false);
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
        boolean r100 = true;
    L9:
        tt5.a.b(TAG, "request WikiPerm and meta. emptyToken: " + r100);
        if (r100 == false) goto L12;
        return;
    L12:
        NonStickyMutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.f> r101 = WikiTreeObserver.f241338a;
        WikiTreeObserver.f241343f.a(this.tokenChangeObserver);
        WikiTreeObserver.f241344g.a(this.urlChangeObserver);
        if (bx4.b.b(this.wikiToken) == false) goto L16;
        tt5.a.h(TAG, "current token is a fake token, skip request perm and meta. token: " + this.wikiToken);
        return;
    L16:
        requestMetaAndPerm();
        return;
    L5:
        if (TextUtils.isEmpty(this.wikiToken) == true) goto L8;
        r100 = false;
        goto L9
    }

    private final void requestMetaAndPerm() {
        tt5.a.h(TAG, "request meta and perm");
        up5.g.a(new GetNodePermPuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).d(new GetNodePermPuller.Params(this.spaceId, this.wikiToken)).subscribe(new b(this), c.f240522a), this.disposables);
        up5.g.a(new GetNodePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).d(new GetNodePuller.Params(this.spaceId, this.wikiToken, true)).subscribe(new d(this), new e(this)), this.disposables);
        a3 r100 = a3.f241764a;
        String r101 = this.spaceId;
        r100.getClass();
        up5.g.a(a3.a(r101).subscribe(new f(this), g.f240526a), this.disposables);
    }

    public final ar5.a consumePathResolveContext() {
        ar5.a r100 = this.pathResolveContext;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (this.pathResolveContextConsumed == true) goto L11;
        this.pathResolveContextConsumed = true;
        return r100;
    L11:
        return null;
    }

    public final String getObjToken() {
        WikiInfo r100 = this.wikiInfo.getValue();
        if (r100 == null) goto L6;
        String r101 = r100.getObjToken();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final int getObjType() {
        WikiInfo r100 = this.wikiInfo.getValue();
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getObjType();
    }

    public final String getObjTypeValueString() {
        WikiInfo r100 = this.wikiInfo.getValue();
        if (r100 == null) goto L6;
        String r101 = r100.getObjTypeString();
        if (r101 == null) goto L6;
        return r101;
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
        TreeNode r100 = this.wikiMeta;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isShortcut();
    }

    public final Flowable<Boolean> updatePerm() {
        return new GetNodePermPuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).d(new GetNodePermPuller.Params(this.spaceId, this.wikiToken)).map(new h(this)).onErrorReturn(i.f240528a);
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
        BearUrl r100 = this.bearUrl;
        String r101 = null;
        if (r100 == null) goto L9;
        String r102 = r100.f222561b;
    L10:
        String r103 = "";
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        boolean r104 = false;
        if (r102.length() != 0) goto L16;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L20;
    L67:
        StringBuilder r106 = new StringBuilder("preparePathResolveContext reset: empty token, urlTokenEmpty=");
        if (r102.length() != 0) goto L70;
        boolean r107 = true;
    L71:
        r106.append(r107);
        r106.append(", wikiTokenEmpty=");
        if (this.wikiToken.length() != 0) goto L74;
        r104 = true;
    L74:
        r106.append(r104);
        tt5.a.d(TAG, r106.toString());
        resetPathResolveContext();
        return;
    L70:
        r107 = false;
        goto L71
    L20:
        if (this.wikiToken.length() != 0) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == true) goto L67;
        if (Intrinsics.areEqual(r102, this.wikiToken) == true) goto L35;
        boolean r109 = bx4.b.b(r102);
        boolean r110 = bx4.b.b(this.wikiToken);
        if (r109 == false) goto L31;
        if (r110 == true) goto L31;
        boolean r111 = true;
    L32:
        if (r111 == true) goto L35;
        tt5.a.d(TAG, "preparePathResolveContext reset: token mismatch, urlTokenFake=" + r109 + ", wikiTokenFake=" + r110);
        resetPathResolveContext();
        return;
    L31:
        r111 = false;
    L35:
        BearUrl r112 = this.bearUrl;
        if (r112 == null) goto L40;
        Map<String, String> r113 = r112.f222563d;
        if (r113 == null) goto L40;
        String r114 = r113.get("visible_space_id");
    L41:
        if (r114 == null) goto L45;
        r103 = r114;
    L45:
        if (r103.length() != 0) goto L47;
        boolean r115 = true;
    L48:
        if (r115 == false) goto L57;
        ar5.a r116 = this.pathResolveContext;
        if (r116 == null) goto L53;
        r101 = r116.f16015c;
    L53:
        if (Intrinsics.areEqual(r101, this.wikiToken) == true) goto L76;
        resetPathResolveContext();
        return;
    L76:
        return;
    L57:
        if (this.wikiToken.length() != 0) goto L59;
        r104 = true;
    L59:
        if (r104 == false) goto L61;
    L65:
        resetPathResolveContext();
        return;
    L61:
        if (Intrinsics.areEqual(r103, this.spaceId) == true) goto L65;
        resetPathResolveContext();
        this.pathResolveContext = new ar5.a(r103, 1, this.wikiToken, UUID.randomUUID().toString());
        return;
    L47:
        r115 = false;
    L40:
        r114 = null;
        goto L41
    L22:
        r108 = false;
        goto L23
    L16:
        r105 = false;
        goto L18
    L9:
        r102 = null;
        goto L10
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        resetPathResolveContext();
        this.disposables.clear();
        NonStickyMutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.f> r100 = WikiTreeObserver.f241338a;
        WikiTreeObserver.f241343f.d(this.tokenChangeObserver);
        WikiTreeObserver.f241344g.d(this.urlChangeObserver);
    }

    public final ar5.a retryPathResolveContext() {
        if (yp5.c.h() == true) goto L5;
        return null;
    L5:
        ar5.a r100 = this.pathResolveContext;
        if (r100 != null) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(r100.f16015c, this.wikiToken) == true) goto L11;
        return null;
    L11:
        String r101 = UUID.randomUUID().toString();
        String r102 = r100.f16013a;
        int r103 = r100.f16014b;
        String r104 = r100.f16015c;
        Intrinsics.checkNotNullParameter(r102, "visibleSpaceId");
        Intrinsics.checkNotNullParameter(r104, "targetWikiToken");
        Intrinsics.checkNotNullParameter(r101, "loadIdentity");
        return new ar5.a(r102, r103, r104, r101);
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

    public static final /* synthetic */ MutableLiveData access$getWikiMetaStatus$p(WikiViewModel r100) {
        return r100.wikiMetaStatus;
    }

    public static final /* synthetic */ void access$preparePathResolveContext(WikiViewModel r100) {
        r100.preparePathResolveContext();
    }

    public static final /* synthetic */ void access$requestMetaAndPerm(WikiViewModel r100) {
        r100.requestMetaAndPerm();
    }

    private final void readArgs(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        BearUrl r101 = s45.p.a().Z(r100.getString("url"));
        this.bearUrl = r101;
        if (r101 == null) goto L8;
        String r102 = r101.f222561b;
        if (r102 == null) goto L8;
    L9:
        this.wikiToken = r102;
        MutableLiveData<String> r103 = this.wikiTokenLiveData;
        if (r101 == null) goto L13;
        String r104 = r101.f222561b;
        if (r104 == null) goto L13;
    L14:
        r103.setValue(r104);
        String r105 = r100.getString(DocViewModel.EXTRA_SPACE_ID);
        if (r105 != null) goto L17;
        r105 = "";
    L17:
        this.spaceId = r105;
        this.spaceName = r100.getString("space_name");
        this.uniqueUiId = r100.getString("unique_ui_id", "");
        WikiInfo r106 = (WikiInfo) r100.getSerializable("wiki_info");
        if (r106 == null) goto L20;
        this.wikiInfo.setValue(r106);
        this.spaceId = r106.getSpaceId();
    L20:
        preparePathResolveContext();
        return;
    L13:
        r104 = "";
    L8:
        r102 = "";
        goto L9
    }

    public final void init(Bundle r100) {
        if (this.isInit == true) goto L6;
        tt5.a.h(TAG, "WikiViewModel.init");
        readArgs(r100);
        doInit();
        this.isInit = true;
        return;
    }

    public final boolean isType(sbb.e r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100.f541317b != getObjType()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setBearUrl(BearUrl r100) {
        this.bearUrl = r100;
    }

    public final void setMyLib(boolean r100) {
        this.isMyLib = r100;
    }

    public final void setSpaceId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.spaceId = r100;
    }

    public final void setSpaceName(String r100) {
        this.spaceName = r100;
    }

    public final void setUniqueUiId(String r100) {
        this.uniqueUiId = r100;
    }

    public final void setWikiMeta(TreeNode r100) {
        this.wikiMeta = r100;
    }

    public final void setWikiPerm(WikNodePerm r100) {
        this.wikiPerm = r100;
    }

    public final void setWikiToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.wikiToken = r100;
    }
}
