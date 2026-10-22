package com.bytedance.ee.bear.document.tts;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocShareUserInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mo5.e;
import mo5.f;
import mo5.g;
import mo5.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J$\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002R\u001f\u0010\u0004\u001a\u00060\u0005R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/document/tts/TtsPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "docRouter", "Lcom/bytedance/ee/bear/document/tts/TtsPlugin$TtsDocRouter;", "getDocRouter", "()Lcom/bytedance/ee/bear/document/tts/TtsPlugin$TtsDocRouter;", "docRouter$delegate", "Lkotlin/Lazy;", "onTtsSessionActive", "", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onDetachFromHost", "checkSessionDestroy", "addTtsRouter", "removeTtsRouter", "checkUrlAnchorFragment", "clearUrlAnchorFragment", "docViewModel", "Lcom/bytedance/ee/bear/document/DocViewModel;", "documentInfo", "Lcom/bytedance/ee/bear/document/documentinfo/DocumentInfo;", "shareUserInfo", "Lcom/bytedance/ee/bear/document/DocShareUserInfo;", "Companion", "TtsDocRouter", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final String JS_BIZ_NAVIGATION_JUMP_FUNCTION_NAME = "window.lark.biz.navigation.jump";
    private static final String TAG = "TtsPlugin";
    private final Lazy docRouter$delegate;

    public static final class a {
        public a() {
        }
    }

    public final class b implements mo5.d {
        public final /* synthetic */ TtsPlugin a;

        public b(TtsPlugin r1) {
            this.a = r1;
        }

        public final boolean a(g r10) {
            Intrinsics.checkNotNullParameter(r10, "itemVM");
            DocViewModel r1 = TtsPlugin.access$getDocViewModel(this.a);
            if (r1 != null) goto L6;
            tt5.a.h(TtsPlugin.TAG, "TtsDocRouter-openItemSource, docVM is null");
            return false;
        L6:
            String r4 = h.a(r10);
            if (r4 != null) goto L10;
            tt5.a.d(TtsPlugin.TAG, "TtsDocRouter-openItemSource, itemVM token invalid: " + r10);
            return false;
        L10:
            Integer r5 = h.b(r10);
            if (r5 != null) goto L13;
        L51:
            tt5.a.d(TtsPlugin.TAG, "TtsDocRouter-openItemSource, itemVM type invalid: " + r10);
            return false;
        L13:
            if (r5.intValue() != (-1)) goto L15;
            boolean r6 = true;
        L17:
            if (r6 == false) goto L20;
            r5 = null;
        L20:
            if (r5 == null) goto L51;
            int r7 = r5.intValue();
            if (Intrinsics.areEqual(r4, r1.getToken()) == true) goto L24;
        L49:
            tt5.a.d(TtsPlugin.TAG, "TtsDocRouter-openItemSource, doc info not matched, itemToken: " + du5.b.i(r4) + ", itemType: " + r7 + ", docToken: " + du5.b.i(r1.getToken()) + ", docType: " + r1.getDocumentTypeValue());
            return false;
        L24:
            if (r7 != r1.getDocumentTypeValue()) goto L49;
            qo5.b r11 = (qo5.b) r10.b().getValue();
            if (r11 != null) goto L53;
            tt5.a.h(TtsPlugin.TAG, "TtsDocRouter-openItemSource, m3u8Segment is null.");
            return false;
        L53:
            String r12 = "anchor-" + r11.a().toString();     // Catch: Exception -> L32
        L34:
            if (r12 != null) goto L36;
        L39:
            boolean r0 = true;
        L41:
            if ((!r0) == true) goto L44;
            r12 = null;
        L44:
            if (r12 == null) goto L47;
            TtsPlugin r2 = this.a;
            tt5.a.h(TtsPlugin.TAG, "TtsDocRouter-openItemSource, call js: " + du5.b.h(r12));
            JSONObject r3 = new JSONObject();
            r3.put("hash", r12);
            r2.dispatchBridgeMsg(TtsPlugin.JS_BIZ_NAVIGATION_JUMP_FUNCTION_NAME, r3, null);
            return true;
        L47:
            tt5.a.k(TtsPlugin.TAG, "TtsDocRouter-openItemSource, not handled.");
            return false;
        L36:
            if (r12.length() == 0) goto L39;
            r0 = false;
        L32:
            e = move-exception;
            tt5.a.e(TtsPlugin.TAG, "TtsDocRouter-openItemSource, json error:", e, false);
            r12 = "";
            goto L34
        L15:
            r6 = false;
            goto L17
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ TtsPlugin a;
        public final /* synthetic */ DocViewModel b;

        public c(TtsPlugin r1, DocViewModel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            DocShareUserInfo r5 = (DocShareUserInfo) r4;
            TtsPlugin r0 = this.a;
            DocViewModel r1 = this.b;
            MutableLiveData<DocumentInfo> r2 = r1.liveDocumentInfoData();
            if (r2 == null) goto L5;
            DocumentInfo r3 = (DocumentInfo) r2.getValue();
        L6:
            TtsPlugin.access$clearUrlAnchorFragment(r0, r1, r3, r5);
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ TtsPlugin a;
        public final /* synthetic */ DocViewModel b;

        public d(TtsPlugin r1, DocViewModel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            DocumentInfo r5 = (DocumentInfo) r4;
            TtsPlugin r0 = this.a;
            DocViewModel r1 = this.b;
            MutableLiveData<DocShareUserInfo> r2 = r1.getmDocShareInfo();
            if (r2 == null) goto L5;
            DocShareUserInfo r3 = (DocShareUserInfo) r2.getValue();
        L6:
            TtsPlugin.access$clearUrlAnchorFragment(r0, r1, r5, r3);
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void addTtsRouter() {
        f r1 = null;
        e r0 = (e) org.koin.java.a.c(e.class, null, null, 6);
        if (r0.z5() == true) goto L6;
        tt5.a.k(TAG, "addTtsRouter, FG disabled.");
        return;
    L6:
        f r2 = r0.V6(false);
        if (r2 != null) goto L9;
    L14:
        tt5.a.h(TAG, "addTtsRouter, no active session.");
        return;
    L9:
        if (r2.a() == true) goto L11;
        r1 = r2;
    L11:
        if (r1 == null) goto L14;
        tt5.a.k(TAG, "addTtsRouter.");
        r1.k().i(getDocRouter());
    }

    private final void checkSessionDestroy() {
        FragmentActivity r1 = null;
        f r0 = ((e) org.koin.java.a.c(e.class, null, null, 6)).V6(false);
        if (r0 != null) goto L5;
    L23:
        tt5.a.h(TAG, "checkSessionDestroy, no active session.");
        return;
    L5:
        if (r0.a() == false) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L23;
        PluginHost r3 = getHost();
        if (r3 == null) goto L20;
        FragmentActivity r4 = r3.getActivity();
        if (r4 == null) goto L20;
        if (r4.isChangingConfigurations() == false) goto L16;
        r1 = r4;
    L16:
        if (r1 == null) goto L20;
        tt5.a.k(TAG, "onDetachFromHost, isChangingConfigurations, ignore zombie check.");
        return;
    L20:
        if (r0.l() == true) goto L25;
        tt5.a.k(TAG, "onDetachFromHost, TTS no view showing, destroy zombie session.");
        r0.j();
        return;
    }

    private final void checkUrlAnchorFragment() {
        if (((e) org.koin.java.a.c(e.class, null, null, 6)).z5() == true) goto L6;
        tt5.a.k(TAG, "checkUrlAnchorFragment, FG disabled.");
        return;
    L6:
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L10;
        tt5.a.h(TAG, "clearUrlAnchorFragment, docVM is null");
        return;
    L10:
        MutableLiveData<DocShareUserInfo> r1 = r0.getmDocShareInfo();
        if (r1 == null) goto L13;
        r1.observe(getHost().getLifecycleOwner(), new c(this, r0));
    L13:
        MutableLiveData<DocumentInfo> r2 = r0.liveDocumentInfoData();
        if (r2 == null) goto L17;
        r2.observe(getHost().getLifecycleOwner(), new d(this, r0));
        return;
    }

    private final b getDocRouter() {
        return (b) this.docRouter$delegate.getValue();
    }

    private final void removeTtsRouter() {
        f r0 = ((e) org.koin.java.a.c(e.class, null, null, 6)).V6(false);
        if (r0 != null) goto L6;
        tt5.a.h(TAG, "removeTtsRouter, no active session.");
        return;
    L6:
        tt5.a.k(TAG, "removeTtsRouter.");
        r0.k().k(getDocRouter());
    }

    public TtsPlugin() {
        this.docRouter$delegate = LazyKt.lazy(new TtsPlugin$docRouter$2(this));
    }

    public final void onTtsSessionActive() {
        removeTtsRouter();
        addTtsRouter();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(TtsPlugin r0) {
        return r0.getDocViewModel();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r2) {
        super.onAttachToHost(r2);
        tt5.a.h(TAG, "onAttachToHost");
        addTtsRouter();
        checkUrlAnchorFragment();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r2) {
        super.onDetachFromHost(r2);
        tt5.a.h(TAG, "onDetachFromHost");
        checkSessionDestroy();
        removeTtsRouter();
    }

    private final void clearUrlAnchorFragment(DocViewModel r5, DocumentInfo r6, DocShareUserInfo r7) {
        String r0 = r5.getOriginUrl();
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L29;
        if (r6 == null) goto L29;
        if (r7 == null) goto L29;
        if (StringsKt.contains$default(r0, "#", false, 2, null) == true) goto L31;
        tt5.a.h(TAG, "clearUrlAnchorFragment, url doesn't contain fragment.");
        return;
    L31:
        Uri r8 = UriProtector.parse(r0);     // Catch: Exception -> L26
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L26
        String r9 = r8.getFragment();
        if (r9 != null) goto L21;
        tt5.a.h(TAG, "clearUrlAnchorFragment, no fragment found in uri.");
        return;
    L21:
        if (StringsKt.startsWith$default(r9, "anchor", false, 2, null) == true) goto L24;
        tt5.a.h(TAG, "clearUrlAnchorFragment, unrecognized uriFragment: " + du5.b.h(r9));
        return;
    L24:
        r5.updateUrlFragment(null);
        tt5.a.k(TAG, "clearUrlAnchorFragment, fragment updated to null.");
        return;
    L26:
        e = move-exception;
        tt5.a.e(TAG, "clearUrlAnchorFragment, parse url error:", e, false);
        return;
    L29:
        tt5.a.k(TAG, "clearUrlAnchorFragment, doc not ready.");
        return;
    L5:
        r1 = false;
        goto L7
    }

    public static final /* synthetic */ void access$clearUrlAnchorFragment(TtsPlugin r0, DocViewModel r1, DocumentInfo r2, DocShareUserInfo r3) {
        r0.clearUrlAnchorFragment(r1, r2, r3);
    }
}
