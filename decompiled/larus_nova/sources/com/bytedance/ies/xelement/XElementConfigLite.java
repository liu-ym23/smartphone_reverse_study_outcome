package com.bytedance.ies.xelement;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\b\u0002\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\n\u0010\u000bR+\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0004\u0018\u0001`\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/xelement/XElementConfigLite;", "", "Lkotlin/Function1;", "Landroid/content/Context;", "Lcom/bytedance/ies/xelement/DeclarativeVideoPlayBoxViewDelegate;", "Lcom/bytedance/ies/xelement/DeclarativeVideoPlayBoxViewLiteProvider;", "declarativeVideoPlayBoxViewProvider", "Lkotlin/jvm/functions/Function1;", "getDeclarativeVideoPlayBoxViewProvider", "()Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "x-element-video_release"}, k = 1, mv = {1, 6, 0})
public final class XElementConfigLite {
    private final Function1<Context, DeclarativeVideoPlayBoxViewDelegate> declarativeVideoPlayBoxViewProvider;

    public /* synthetic */ XElementConfigLite(Function1 r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public final Function1<Context, DeclarativeVideoPlayBoxViewDelegate> getDeclarativeVideoPlayBoxViewProvider() {
        return this.declarativeVideoPlayBoxViewProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private XElementConfigLite(Function1<? super Context, ? extends DeclarativeVideoPlayBoxViewDelegate> r100) {
        this.declarativeVideoPlayBoxViewProvider = r100;
    }
}
