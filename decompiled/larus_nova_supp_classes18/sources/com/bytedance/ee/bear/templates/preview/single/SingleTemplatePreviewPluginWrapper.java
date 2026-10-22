package com.bytedance.ee.bear.templates.preview.single;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.templatePlugin.BaseTemplatePreviewPlugin;
import com.bytedance.ee.bear.templates.preview.single.common.CommonTemplatePreviewPlugin;
import com.bytedance.ee.bear.templates.preview.single.common.ForsetiTemplatePreviewPlugin;
import com.bytedance.ee.bear.templates.preview.single.custom.CustomTemplatePreviewPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/single/SingleTemplatePreviewPluginWrapper;", "Lcom/bytedance/ee/bear/document/templatePlugin/BaseTemplatePreviewPlugin;", "<init>", "()V", "delegate", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onBackPressed", "", "hideTemplatePreview", "showTemplatePreview", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleTemplatePreviewPluginWrapper extends BaseTemplatePreviewPlugin {
    private BaseTemplatePreviewPlugin delegate;

    public SingleTemplatePreviewPluginWrapper() {
        super(true);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public void hideTemplatePreview() {
        BaseTemplatePreviewPlugin r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.hideTemplatePreview();
        return;
    }

    public boolean onBackPressed() {
        BaseTemplatePreviewPlugin r0 = this.delegate;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onBackPressed();
    }

    public void showTemplatePreview() {
        BaseTemplatePreviewPlugin r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.showTemplatePreview();
        return;
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        if (Intrinsics.areEqual(getDocViewModel().getCommonTemplatePreviewType(), "link") == false) goto L5;
        BaseTemplatePreviewPlugin r0 = new CustomTemplatePreviewPlugin();
    L14:
        this.delegate = r0;
        r0.onAttachToHost(r3);
        return;
    L5:
        if (r3 == null) goto L7;
        Fragment r1 = r3.getHostFragment();
    L9:
        if (ForsetiHelper.s(r1) == true) goto L11;
    L13:
        r0 = new CommonTemplatePreviewPlugin();
        goto L14
    L11:
        if (DowngradeSettingUtil.a("downgradeForsetiTemplatePreview") == true) goto L13;
        r0 = new ForsetiTemplatePreviewPlugin();
        goto L14
    L7:
        r1 = null;
        goto L9
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        BaseTemplatePreviewPlugin r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.onAttachToUIContainer(r2, r3);
        return;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r2, t r3) {
        super.onDetachFromUIContainer(r2, r3);
        BaseTemplatePreviewPlugin r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.onDetachFromUIContainer(r2, r3);
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
