package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.plugins.markdown.MarkdownPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/coremd/facade/plugins/IMMarkdownParsePlugin;", "Lcom/ss/android/lark/coremd/base/parse/MarkdownParsePluginAdapter;", "<init>", "()V", com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS, "", "Lcom/ss/android/lark/coremd/base/parse/MarkdownParsePlugin;", "getPlugins", "()Ljava/util/List;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class IMMarkdownParsePlugin extends com.ss.android.lark.coremd.base.parse.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.ss.android.lark.coremd.base.parse.g> f419775a;

    public static final class a extends IMMarkdownParsePlugin {
        public a(int r100) {
        }
    }

    static {
        new a(0);
    }

    public IMMarkdownParsePlugin() {
        this.f419775a = CollectionsKt.mutableListOf(new com.ss.android.lark.coremd.base.parse.g[]{new l(), new p(), new i0(), new l0(), new f1(), new j1(), new com.ss.android.lark.coremdbiz.facade.plugins.n(), new com.ss.android.lark.coremdbiz.facade.plugins.j(), new com.ss.android.lark.coremdbiz.facade.plugins.g(), new com.ss.android.lark.coremdbiz.facade.plugins.b0(), new o0(), new q0(), new v0(), new s0(), new x0(), com.ss.android.lark.coremdbiz.facade.plugins.v.f420165a, new MarkdownPlugin()});
    }

    @Override // com.ss.android.lark.coremd.base.parse.h
    public List<com.ss.android.lark.coremd.base.parse.g> e() {
        return this.f419775a;
    }
}
