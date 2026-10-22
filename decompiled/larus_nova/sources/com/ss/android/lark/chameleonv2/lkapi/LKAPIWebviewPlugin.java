package com.ss.android.lark.chameleonv2.lkapi;

import android.content.Intent;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import sa5.a;
import z0b.c;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t`\nH\u0016J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/LKAPIWebviewPlugin;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "mPlugin", "Lcom/ss/android/lark/chameleonv2/lkapi/LKAPIBasePlugin;", "getBridgeHandlers", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleon/AbsChameleonHandler;", "Lkotlin/collections/ArrayList;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LKAPIWebviewPlugin extends AbsChameleonPlugin implements a {
    private final c mPlugin;

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin
    public ArrayList<AbsChameleonHandler<?>> getBridgeHandlers() {
        c r100 = this.mPlugin;
        r100.getClass();
        ArrayList<AbsChameleonHandler<?>> r101 = new ArrayList();
        Iterator<z0b.a> r102 = r100.f569647a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.addAll(r102.next().b());
        goto L4
    L6:
        Iterator<z0b.a> r103 = r100.f569648b.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r101.addAll(r103.next().b());
        goto L8
    L10:
        return r101;
    }

    public LKAPIWebviewPlugin() {
        this.mPlugin = new c();
    }

    public void onAttachToHost(ChameleonPluginHost r100) {
        super.onAttachToHost(r100);
        Iterator<z0b.a> r101 = this.mPlugin.f569648b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().d(getWebviewHandlerContext());
        goto L4
    }

    public void onDetachFromHost(ChameleonPluginHost r100) {
        Iterator<z0b.a> r101 = this.mPlugin.f569648b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().e(getWebviewHandlerContext());
        goto L4
    L6:
        super.onDetachFromHost(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((ChameleonPluginHost) r100);
    }

    @Override // sa5.a
    public void onActivityResult(int r100, int r101, Intent r102) {
        Iterator<z0b.a> r103 = this.mPlugin.f569648b.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = (z0b.a) r103.next();
        if ((r104 instanceof a) == false) goto L4;
        ((a) r104).onActivityResult(r100, r101, r102);
        goto L4
    }
}
