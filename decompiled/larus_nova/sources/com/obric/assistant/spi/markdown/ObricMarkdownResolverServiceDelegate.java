package com.obric.assistant.spi.markdown;

import android.view.View;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J+\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/spi/markdown/ObricMarkdownResolverServiceDelegate;", "Lcom/obric/assistant/spi/markdown/IObricMarkdownResolverService;", "<init>", "()V", "enableLinkStyle", "", "link", "", "needUnderline", JSEventListener.ACTION_RESOLVE, "view", "Landroid/view/View;", "chatMessage", "Lcom/larus/im/bean/message/Message;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMarkdownResolverServiceDelegate implements IObricMarkdownResolverService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricMarkdownResolverServiceDelegate f392892b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricMarkdownResolverService f392893a;

    static {
        f392892b = new ObricMarkdownResolverServiceDelegate();
    }

    @Override // com.obric.assistant.spi.markdown.IObricMarkdownResolverService
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "link");
        return this.f392893a.a(r100);
    }

    @Override // com.obric.assistant.spi.markdown.IObricMarkdownResolverService
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "link");
        return this.f392893a.b(r100);
    }

    @Override // com.obric.assistant.spi.markdown.IObricMarkdownResolverService
    public final boolean c(View r100, String r101, boolean r102, Message r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "link");
        return this.f392893a.c(r100, r101, r102, r103);
    }

    private ObricMarkdownResolverServiceDelegate() {
        IObricMarkdownResolverService r100 = (IObricMarkdownResolverService) ServiceManager.get().getService(IObricMarkdownResolverService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricMarkdownResolverServiceImpl();
    L5:
        this.f392893a = r100;
    }
}
