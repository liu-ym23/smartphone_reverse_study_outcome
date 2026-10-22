package com.bytedance.ee.bear.doc.cover;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.doc.cover.selectcover.local.LocalImageItem;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import j25.t;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0003'()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u000e\u001a\u00020\u000b2\u001a\u0010\u000f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00120\u0010H\u0016J\u001c\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J2\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010#\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010\u00112\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/CoverPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "mViewModel", "Lcom/bytedance/ee/bear/doc/cover/CoverViewModel;", "mDisposable", "Lio/reactivex/disposables/Disposable;", "mFetchCoverListener", "Lcom/bytedance/ee/bear/doc/cover/CoverViewModel$IFetchCoverListener;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onDetachFromUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "setOfficialCover", "entrance", "", "source", "token", "seriesName", "mimeType", "randomCover", "params", "Lcom/alibaba/fastjson/JSONObject;", "setLocalImage", "image", "Lcom/bytedance/ee/bear/doc/cover/selectcover/local/LocalImageItem;", "setCover", "encodeUrl", "path", "uuid", "SelectCoverHandler", "AdjustCoverPositionHandler", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoverPlugin extends DocumentPlugin {
    private static final String BIZ_ADJUST_COVER_POSITION = "biz.title.adjustCoverPosition";
    private static final String BIZ_RANDOM_COVER = "javascript:lark.biz.title.randomCover";
    private static final String BIZ_SELECT_COVER = "biz.title.selectCover";
    private static final String BIZ_SET_COVER = "javascript:lark.biz.title.setCover";
    private static final b Companion = null;
    private static final String TAG = "DocCover_NewCoverPlugin";
    private Disposable mDisposable;
    private CoverViewModel.b mFetchCoverListener;
    private CoverViewModel mViewModel;

    public final class a implements i<CoverPositionState> {
        public final /* synthetic */ CoverPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(CoverPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            CoverPositionState r4 = (CoverPositionState) r2;
            if (r4 == null) goto L5;
            boolean r5 = Intrinsics.areEqual(r4.getSetting(), Boolean.TRUE);
        L6:
            tt5.a.h(CoverPlugin.TAG, "AdjustCoverPositionHandler()... is setting ? " + r5);
            BaseTitlePlugin r6 = (BaseTitlePlugin) CoverPlugin.access$findPlugin(this.a, BaseTitlePlugin.class);
            if (r6 == null) goto L10;
            r6.updateEnableNestScroll(!r5);
            return;
        L10:
            return;
        L5:
            r5 = false;
            goto L6
        }
    }

    public static final class b {
        public b() {
        }
    }

    public final class c implements i<CurrentCoverData> {
        public final /* synthetic */ CoverPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(CoverPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r5, m r6) {
            CurrentCoverData r7 = (CurrentCoverData) r5;
            StringBuilder r8 = new StringBuilder("SelectCoverHandler()... exist cover ? ");
            if (r7 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            r8.append(r1);
            tt5.a.h(CoverPlugin.TAG, r8.toString());
            CoverViewModel r9 = null;
            if (r7 != null) goto L11;
        L21:
            CoverViewModel.b r10 = CoverPlugin.access$getMFetchCoverListener$p(this.a);
            if (r10 == null) goto L30;
            CoverPlugin r2 = this.a;
            CoverViewModel r3 = CoverPlugin.access$getMViewModel$p(r2);
            if (r3 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L27:
            r9.randomCover(1, ((DocumentPluginHost) r2.getHost()).a().getToken(), ((DocumentPluginHost) r2.getHost()).a().getDocumentTypeValue(), r10);
            return;
        L26:
            r9 = r3;
            goto L27
        L30:
            return;
        L11:
            if (TextUtils.isEmpty(r7.getToken()) == true) goto L21;
            CoverViewModel r0 = CoverPlugin.access$getMViewModel$p(this.a);
            if (r0 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            r0 = null;
        L16:
            r0.getSelectCoverActive().setValue(Boolean.TRUE);
            CoverViewModel r4 = CoverPlugin.access$getMViewModel$p(this.a);
            if (r4 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L20:
            r9.getCurrentCoverData().setValue(r7);
            return;
        L19:
            r9 = r4;
            goto L20
        L5:
            if (r7.isExistCover() == false) goto L7;
            r1 = true;
            goto L8
        }
    }

    public static final class d implements CoverViewModel.a {
        public final /* synthetic */ CoverPlugin a;

        @Override // com.bytedance.ee.bear.doc.cover.CoverViewModel.a
        public final void a() {
            CoverPlugin.access$setCover(this.a, null);
        }

        public d(CoverPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.doc.cover.CoverViewModel.a
        public final void b(String r2, LocalImageItem r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "image");
            CoverPlugin.access$setLocalImage(this.a, r2, r3);
        }

        @Override // com.bytedance.ee.bear.doc.cover.CoverViewModel.a
        public final void c(int r8, String r9, String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r9, "source");
            Intrinsics.checkNotNullParameter(r10, "token");
            Intrinsics.checkNotNullParameter(r11, "seriesName");
            CoverPlugin.access$setOfficialCover(this.a, r8, r9, r10, r11, r12);
        }
    }

    public static final class e implements CoverViewModel.b {
        public final /* synthetic */ CoverPlugin a;

        @Override // com.bytedance.ee.bear.doc.cover.CoverViewModel.b
        public final void onSuccess() {
            tt5.a.b(CoverPlugin.TAG, "CoverPlugin#onSuccess()");
            CoverViewModel r0 = CoverPlugin.access$getMViewModel$p(this.a);
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            r0 = null;
        L5:
            r0.randomCover(1);
        }

        public e(CoverPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.doc.cover.CoverViewModel.b
        public final void onFailure(Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "throwable");
            tt5.a.k(CoverPlugin.TAG, "CoverPlugin#onFailure(), throwable: " + r3.getMessage());
        }
    }

    public static final class f<T, R> implements Function {
        public final /* synthetic */ CoverPlugin a;

        public f(CoverPlugin r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            LocalImageItem r6 = (LocalImageItem) r5;
            Intrinsics.checkNotNullParameter(r6, "image");
            HashMap r0 = new HashMap();
            r0.put(CoverPlugin.access$encodeUrl(this.a, r6.getFilePath(), r6.getUuid()), r6.getFilePath());
            return t.a(CoverPlugin.access$getDocViewModel(this.a).getUrl(), r0, false, null);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ LocalImageItem b;
        public final /* synthetic */ CoverPlugin c;

        public g(String r1, LocalImageItem r2, CoverPlugin r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            Boolean r7 = (Boolean) r6;
            JSONObject r8 = new JSONObject();
            r8.put("coverSource", this.a);
            r8.put("type", 2);
            r8.put("code", 0);
            JSONArray r0 = new JSONArray();
            JSONObject r1 = new JSONObject();
            r1.put("uuid", this.b.getUuid());
            r1.put("contentType", this.b.getContentType());
            r1.put("src", CoverPlugin.access$encodeUrl(this.c, this.b.getFilePath(), this.b.getUuid()));
            r1.put("width", Integer.valueOf(this.b.getWidth()));
            r1.put("height", Integer.valueOf(this.b.getHeight()));
            r0.add(r1);
            r8.put("thumbs", r0);
            CoverPlugin.access$setCover(this.c, r8);
        }
    }

    public static final class h<T> implements Consumer {
        public static final h<T> a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void accept(Object r3) {
            tt5.a.d(CoverPlugin.TAG, "setLocalImage()... error = " + ((Throwable) r3));
        }
    }

    static {
        Companion = new b();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public CoverPlugin() {
    }

    public static final /* synthetic */ Context access$getContext(CoverPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(CoverPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ CoverViewModel.b access$getMFetchCoverListener$p(CoverPlugin r0) {
        return r0.mFetchCoverListener;
    }

    public static final /* synthetic */ CoverViewModel access$getMViewModel$p(CoverPlugin r0) {
        return r0.mViewModel;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.t access$getUIContainer(CoverPlugin r0) {
        return r0.getUIContainer();
    }

    public static final /* synthetic */ void access$removeFragment(CoverPlugin r0) {
        r0.removeFragment();
    }

    private final void randomCover(JSONObject r3) {
        tt5.a.h(TAG, "randomCover()...");
        execJS(BIZ_RANDOM_COVER, r3);
    }

    private final void setCover(JSONObject r3) {
        tt5.a.h(TAG, "setCover()...");
        CoverViewModel r0 = this.mViewModel;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        r0 = null;
    L5:
        r0.getSelectCoverActive().setValue(Boolean.FALSE);
        execJS(BIZ_SET_COVER, r3);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(BIZ_SELECT_COVER, new c(this));
        r3.put(BIZ_ADJUST_COVER_POSITION, new a(this));
    }

    public void onAttachToHost(DocumentPluginHost r5) {
        super.onAttachToHost(r5);
        CoverViewModel r6 = (CoverViewModel) viewModel(CoverViewModel.class);
        this.mViewModel = r6;
        CoverViewModel r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        r6 = null;
    L5:
        r6.getSelectCoverActive().observe(getLifecycleOwner(), new AnonymousClass1(this));
        CoverViewModel r7 = this.mViewModel;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        r7 = null;
    L8:
        r7.setDelegate(new d(this));
        CoverViewModel r8 = this.mViewModel;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L13:
        if (getDocViewModel().getOpenSource() != DocsOpenSource.vc) goto L15;
        boolean r9 = true;
    L16:
        r0.setVCFollowMode(r9);
        this.mFetchCoverListener = new e(this);
        return;
    L15:
        r9 = false;
        goto L16
    L11:
        r0 = r8;
        goto L13
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(CoverPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ Fragment access$instantiateFragment(CoverPlugin r0, Class r1) {
        return r0.instantiateFragment(r1);
    }

    public static final /* synthetic */ void access$setCover(CoverPlugin r0, JSONObject r1) {
        r0.setCover(r1);
    }

    private final String encodeUrl(String r9, String r10) {
        return "docsource://com.bytedance.net/file/f/" + r10 + r9.substring(StringsKt.lastIndexOf$default(r9, ".", 0, false, 6, null));
    }

    private final void setLocalImage(String r3, LocalImageItem r4) {
        this.mDisposable = Flowable.just(r4).flatMap(new f(this)).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).subscribe(new g(r3, r4, this), h.a);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onDetachFromUIContainer(r1, r2);
        CoverViewModel r3 = this.mViewModel;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        r3 = null;
    L5:
        r3.getCoverSeriesList().setValue(null);
        Disposable r4 = this.mDisposable;
        boolean r5 = false;
        if (r4 != null) goto L8;
    L10:
        if (r5 == false) goto L15;
        Disposable r6 = this.mDisposable;
        if (r6 == null) goto L16;
        r6.dispose();
        return;
    L16:
        return;
    L15:
        return;
    L8:
        if (r4.isDisposed() == true) goto L10;
        r5 = true;
        goto L10
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public static final /* synthetic */ String access$encodeUrl(CoverPlugin r0, String r1, String r2) {
        return r0.encodeUrl(r1, r2);
    }

    public static final /* synthetic */ void access$setLocalImage(CoverPlugin r0, String r1, LocalImageItem r2) {
        r0.setLocalImage(r1, r2);
    }

    private final void setOfficialCover(int r4, String r5, String r6, String r7, String r8) {
        JSONObject r0 = new JSONObject();
        r0.put("coverSource", r5);
        r0.put("type", 1);
        r0.put("token", r6);
        r0.put("contentType", r8);
        r0.put("series", r7);
        if (1 != r4) goto L5;
        randomCover(r0);
        return;
    L5:
        setCover(r0);
    }

    public static final /* synthetic */ void access$setOfficialCover(CoverPlugin r0, int r1, String r2, String r3, String r4, String r5) {
        r0.setOfficialCover(r1, r2, r3, r4, r5);
    }
}
