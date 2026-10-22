package com.larus.bmhome.chat.component.block;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.ui.arch.component.external.api.Component;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ss8.g;
import tp8.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/component/block/ChatUIBlockComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/bmhome/view/actionbar/api/IChatUIBlockAbility;", "<init>", "()V", "activeConfigs", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/bmhome/view/actionbar/api/ChatUIBlockConfig;", "listeners", "Lcom/larus/bmhome/view/actionbar/api/IChatUIBlockAbility$OnBlockChangeListener;", "replacementViewFactory", "Lcom/larus/bmhome/view/actionbar/api/IChatUIBlockAbility$InputBarViewFactory;", "overlayViewFactory", "setBlockConfigs", "", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "", "addBlockConfig", "config", "removeBlockConfig", "isBlocked", "", "getBlockConfigs", "clearAllBlockConfigs", "addOnBlockChangeListener", "listener", "removeOnBlockChangeListener", "setInputBarReplacementViewFactory", "factory", "getInputBarReplacementViewFactory", "setInputBarOverlayViewFactory", "getInputBarOverlayViewFactory", LiveCommonConstants.REASON_ON_DEDTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatUIBlockComponent extends Component implements g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CopyOnWriteArraySet<ChatUIBlockConfig> f297944l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CopyOnWriteArraySet<g.b> f297945m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g.a f297946n;

    @Override // ss8.g
    public final void bA() {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        this.f297944l.clear();
        this.f297945m.clear();
        this.f297946n = null;
    }

    public ChatUIBlockComponent() {
        this.f297944l = new CopyOnWriteArraySet();
        this.f297945m = new CopyOnWriteArraySet();
    }

    @Override // ss8.g
    public final g.a TI() {
        return this.f297946n;
    }

    @Override // ss8.g
    public final void J10(ChatUIBlockConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if (this.f297944l.add(r100) == false) goto L8;
        Iterator<T> r101 = this.f297945m.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((g.b) r101.next()).a(r100, true);
        goto L6
    L10:
        return;
    }

    @Override // ss8.g
    public final void aZ(g.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f297945m.remove(r100);
    }

    @Override // ss8.g
    public final void bN(ChatUIBlockConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if (this.f297944l.remove(r100) == false) goto L8;
        Iterator<T> r101 = this.f297945m.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((g.b) r101.next()).a(r100, false);
        goto L6
    L10:
        return;
    }

    @Override // ss8.g
    public final boolean bc(ChatUIBlockConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return this.f297944l.contains(r100);
    }

    @Override // ss8.g
    public final void ch(d r100) {
        this.f297946n = r100;
        Iterator<g.b> r101 = this.f297945m.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().b();
        goto L4
    }

    @Override // ss8.g
    public final void ds(g.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f297945m.add(r100);
    }
}
