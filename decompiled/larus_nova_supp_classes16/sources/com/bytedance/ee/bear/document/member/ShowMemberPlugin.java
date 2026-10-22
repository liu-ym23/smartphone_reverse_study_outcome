package com.bytedance.ee.bear.document.member;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/member/ShowMemberPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/document/member/DocumentMemberViewModel;", "kotlin.jvm.PlatformType", "getViewModel", "()Lcom/bytedance/ee/bear/document/member/DocumentMemberViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "ShowListHandler", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowMemberPlugin extends DocumentPlugin {
    public static final a Companion = null;
    private static final String SHOW_LIST = "biz.docInfo.showList";
    private static final String TAG = "ShowMemberPlugin";
    private final Lazy viewModel$delegate;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<MemberListData> {
        public final /* synthetic */ ShowMemberPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(ShowMemberPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            MemberListData r3 = (MemberListData) r1;
            if (r3 == null) goto L6;
            ShowMemberPlugin.access$getViewModel(this.a).showMemberList(r3);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final DocumentMemberViewModel getViewModel() {
        return (DocumentMemberViewModel) this.viewModel$delegate.getValue();
    }

    public ShowMemberPlugin() {
        this.viewModel$delegate = LazyKt.lazy(new ShowMemberPlugin$viewModel$2(this));
    }

    public static final /* synthetic */ t access$getUIContainer(ShowMemberPlugin r0) {
        return r0.getUIContainer();
    }

    public static final /* synthetic */ DocumentMemberViewModel access$getViewModel(ShowMemberPlugin r0) {
        return r0.getViewModel();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(SHOW_LIST, new b(this));
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        getViewModel().getActive().observe(getLifecycleOwner(), new AnonymousClass1(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ Fragment access$instantiateFragment(ShowMemberPlugin r0, Class r1) {
        return r0.instantiateFragment(r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(ShowMemberPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }
}
