package com.bytedance.ee.bear.bitable.titlebar;

import android.content.res.Configuration;
import com.bytedance.ee.bear.bitable.core.f;
import com.bytedance.ee.bear.bitable.core.infoarch.BitableContentContainer;
import com.bytedance.ee.bear.bitable.core.infoarch.BitableInfoArchManagerNew;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.ViewHolder;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.titlebar.TitlePlugin;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ku5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Deprecated(message = "Legacy Bitable flow only; pending removal")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/titlebar/BitableTitlePlugin;", "Lcom/bytedance/ee/bear/document/titlebar/TitlePlugin;", "enableTemplatePreview", "", "<init>", "(Z)V", "showStatusBar", "getShowStatusBar", "()Z", "setShowStatusBar", "handleOrientation", "", "configuration", "Landroid/content/res/Configuration;", "isPadEnableNestScroll", "updateContentContainerPaddingTop", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableTitlePlugin extends TitlePlugin {
    public static final a Companion = null;
    public static final String TAG = "BitableTitlePlugin";
    private boolean showStatusBar;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BitableTitlePlugin() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.TitlePlugin
    public boolean isPadEnableNestScroll() {
        return true;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.TitlePlugin, com.bytedance.ee.bear.document.x2.b
    public /* bridge */ /* synthetic */ void onLoadCancel() {
    }

    @Override // com.bytedance.ee.bear.document.titlebar.TitlePlugin, com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.titlebar.TitlePlugin, com.bytedance.ee.bear.document.x2.b
    public /* bridge */ /* synthetic */ void onSSRLoadSuccess() {
    }

    @Override // com.bytedance.ee.bear.document.titlebar.TitlePlugin
    public void updateContentContainerPaddingTop() {
        super.updateContentContainerPaddingTop();
        f r1 = getUIContainer();     // Catch: Exception -> L16 IllegalStateException -> L18
        if ((r1 instanceof f) == false) goto L6;
        f r2 = r1;     // Catch: Exception -> L16 IllegalStateException -> L18
    L7:
        if (r2 == null) goto L22;
        BitableInfoArchManagerNew r3 = r2.o;     // Catch: Exception -> L16 IllegalStateException -> L18
        if (r3 == null) goto L23;
        ViewHolder r4 = r3.g;     // Catch: Exception -> L16 IllegalStateException -> L18
        if (r4 == null) goto L24;
        BitableContentContainer r5 = r4.m;     // Catch: Exception -> L16 IllegalStateException -> L18
        if (r5 == null) goto L25;
        r5.setPadding(0, 0, 0, getPaddingBottom());     // Catch: Exception -> L16 IllegalStateException -> L18
    L27:
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L6:
        r2 = null;
    L18:
        tt5.a.d(TAG, " getUIContainer when plugin not attached!");
        return;
    L16:
        e = move-exception;
        tt5.a.d(TAG, e.getMessage());
    }

    public final boolean getShowStatusBar() {
        return this.showStatusBar;
    }

    public BitableTitlePlugin(boolean r2) {
        super(true, r2);
        this.showStatusBar = true;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.TitlePlugin, com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public void handleOrientation(Configuration r2) {
        if (c.k(getContext()) == false) goto L5;
        return;
    L5:
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.orientation);
    L8:
        if (r3 != null) goto L11;
    L13:
        getUIContainer().a();
        this.showStatusBar = true;
        return;
    L11:
        if (r3.intValue() != 2) goto L13;
        getUIContainer().hideStatusBar();
        this.showStatusBar = false;
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void setShowStatusBar(boolean r1) {
        this.showStatusBar = r1;
    }

    public /* synthetic */ BitableTitlePlugin(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }
}
