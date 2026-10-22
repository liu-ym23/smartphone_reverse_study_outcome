package com.bytedance.ee.bear.drive.biz.preview.copy;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.utils.TextViewMenuUtilsKt;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/copy/DriveCopyProtectPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "isCCMInteceptFgEnable", "", "imiuiMenuJumpListener", "Lcom/suite/lark/emm/impl/clipboard/IMIUIMenuJumpListener;", "onAttachPreview", "", "onDetachPreview", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveCopyProtectPlugin extends AbsDrivePlugin {
    private final boc.a imiuiMenuJumpListener;
    private boolean isCCMInteceptFgEnable;

    public static final class a implements boc.a {
        public a() {
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveCopyProtectPlugin() {
        this.imiuiMenuJumpListener = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        if (getHost() == null) goto L5;
        this.isCCMInteceptFgEnable = true;
    L5:
        Lazy r0 = SCClipboardProvider.a;
        boc.a r1 = this.imiuiMenuJumpListener;
        Intrinsics.checkNotNullParameter(r1, "listener");
        if (TextViewMenuUtilsKt.f() == false) goto L10;
        ((CopyOnWriteArraySet) SCClipboardProvider.a.getValue()).add(r1);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        Lazy r0 = SCClipboardProvider.a;
        boc.a r1 = this.imiuiMenuJumpListener;
        Intrinsics.checkNotNullParameter(r1, "listener");
        if (TextViewMenuUtilsKt.f() == false) goto L7;
        ((CopyOnWriteArraySet) SCClipboardProvider.a.getValue()).remove(r1);
        return;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveCopyProtectPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ Context access$getContext(DriveCopyProtectPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ boolean access$isCCMInteceptFgEnable$p(DriveCopyProtectPlugin r0) {
        return r0.isCCMInteceptFgEnable;
    }
}
