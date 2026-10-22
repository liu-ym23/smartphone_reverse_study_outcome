package com.bytedance.ee.bear.document;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.utils.TextViewMenuUtilsKt;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/document/SecurityCopyPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "TAG", "", "isCCMInteceptFgEnable", "", "imiuiMenuJumpListener", "Lcom/suite/lark/emm/impl/clipboard/IMIUIMenuJumpListener;", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecurityCopyPlugin extends DocumentPluginV2 {
    private final String TAG;
    private final boc.a imiuiMenuJumpListener;
    private boolean isCCMInteceptFgEnable;

    public static final class a implements boc.a {
        public a() {
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SecurityCopyPlugin() {
        this.TAG = "SecurityCopyPlugin";
        this.imiuiMenuJumpListener = new a();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(SecurityCopyPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ Context access$getContext(SecurityCopyPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ String access$getTAG$p(SecurityCopyPlugin r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ boolean access$isCCMInteceptFgEnable$p(SecurityCopyPlugin r0) {
        return r0.isCCMInteceptFgEnable;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        super.onAttachToUIContainer(r3, r4);
        tt5.a.b(this.TAG, "onAttachToUIContainer " + getActivity());
        if (r3 == null) goto L5;
        this.isCCMInteceptFgEnable = true;
    L5:
        Lazy r5 = SCClipboardProvider.a;
        boc.a r6 = this.imiuiMenuJumpListener;
        Intrinsics.checkNotNullParameter(r6, "listener");
        if (TextViewMenuUtilsKt.f() == false) goto L10;
        ((CopyOnWriteArraySet) SCClipboardProvider.a.getValue()).add(r6);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onDetachFromUIContainer(r2, r3);
        tt5.a.b(this.TAG, "onDetachFromUIContainer " + getActivity());
        Lazy r4 = SCClipboardProvider.a;
        boc.a r5 = this.imiuiMenuJumpListener;
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (TextViewMenuUtilsKt.f() == false) goto L7;
        ((CopyOnWriteArraySet) SCClipboardProvider.a.getValue()).remove(r5);
        return;
    }
}
