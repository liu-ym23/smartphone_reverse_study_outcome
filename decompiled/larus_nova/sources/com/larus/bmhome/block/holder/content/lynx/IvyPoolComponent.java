package com.larus.bmhome.block.holder.content.lynx;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/block/holder/content/lynx/IvyPoolComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/bmhome/chat/lynx/IvyPoolAbility;", "<init>", "()V", "maxKeyCount", "", "maxCacheViewPerKey", "ivyPool", "Lcom/larus/bmhome/block/holder/content/lynx/IvyPluginViewPool;", "getIvyPool", "()Lcom/larus/bmhome/block/holder/content/lynx/IvyPluginViewPool;", "ivyPool$delegate", "Lkotlin/Lazy;", "ivyPluginViewPool", "Lcom/larus/bmhome/chat/lynx/IIvyPluginViewPool;", "configCache", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IvyPoolComponent extends ComponentFeature implements eh8.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f296166k = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f296167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f296168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f296169j;

    public static final class a {
    }

    static {
    }

    @Override // eh8.c
    public final void rG() {
        this.f296167h = 5;
        this.f296168i = 8;
        FLogger.f375446a.i("IvyViewPool", "configCache: maxKeyCount=5, maxCacheViewPerKey=8");
    }

    @Override // eh8.c
    public final IvyPluginViewPool Yy() {
        return (IvyPluginViewPool) this.f296169j.getValue();
    }

    public IvyPoolComponent() {
        this.f296167h = 3;
        this.f296168i = 2;
        this.f296169j = LazyKt.lazy(new com.larus.bmhome.block.holder.content.lynx.a(this));
    }
}
