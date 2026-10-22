package com.ss.android.lark.chat.plugin.adapter;

import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.e;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.f;
import com.ss.android.lark.chat.component.ChatWindowAdapterComponent;
import com.ss.android.lark.scaffold.PagePlugin;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import hac.c;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001\u000eB\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chat/plugin/adapter/ChatPluginFactoryAdapter;", "Lcom/ss/android/lark/scaffold/PagePlugin;", "Lcom/ss/android/lark/scaffold/LifecyclePagePlugin;", "Landroidx/lifecycle/LifecycleOwner;", ShortVideoSegments.KEY_PROP_PROVIDER, "Lkotlin/Function1;", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "Lcom/ss/android/lark/chat/chatwindow/biz/plugin/core/IChatPluginFactory;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", WidgetCostModule.TYPE_ON_CREATE, "", "runtime", "Lcom/ss/android/lark/scaffold/PageRuntime;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatPluginFactoryAdapter extends PagePlugin {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<i7b.a, e> f415969b;

    public static final class a {
    }

    public static final class b implements f, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f415970a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f415970a = r100;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.f
        public final /* synthetic */ e a(i7b.a r100) {
            return (e) this.f415970a.invoke(r100);
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof f) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f415970a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatPluginFactoryAdapter(Function1<? super i7b.a, ? extends e> r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f415969b = r100;
    }

    @Override // com.ss.android.lark.scaffold.PagePlugin
    public final void a(l3c.f r110) {
        Intrinsics.checkNotNullParameter(r110, "runtime");
        Intrinsics.checkNotNullParameter(r110, "runtime");
        ChatWindowOpenViewModel r100 = (ChatWindowOpenViewModel) r110.b(ChatWindowOpenViewModel.class);
        if (r100 != null) goto L6;
        hac.b r111 = hac.b.f484427a;
        c.a("PagePluginsAdapter", "chatViewModel == null");
        return;
    L6:
        ChatWindowAdapterComponent r101 = (ChatWindowAdapterComponent) r110.a(ChatWindowAdapterComponent.class);
        if (r101 != null) goto L10;
        hac.b r112 = hac.b.f484427a;
        c.a("PagePluginsAdapter", "chatWindowComponent == null");
        return;
    L10:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatPluginFactoryAdapter$onCreate$1(r100, this, r110, r101, null), 3, null);
    }
}
