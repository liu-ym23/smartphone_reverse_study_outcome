package com.larus.bmhome.chat.standarduikit.clarification.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/clarification/view/InteractionAskAttachmentView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "resourceBarOperator", "Lcom/larus/bmhome/view/resourcebar/bean/IResourceItemOperator;", "bind", "", "attachmentItems", "", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "ensureResourceBarOperator", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionAskAttachmentView extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f308959b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mt8.a f308960a;

    public static final class a {
    }

    static {
    }

    public InteractionAskAttachmentView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InteractionAskAttachmentView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public InteractionAskAttachmentView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public final void a(List<ResourceItemBean> r100, BaseResourceViewHolder.a r101, ResourceBarConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "attachmentItems");
        Intrinsics.checkNotNullParameter(r102, "config");
        List<ResourceItemBean> r103 = r100;
        boolean r104 = !r103.isEmpty();
        if (r104 == false) goto L5;
        int r105 = 0;
    L6:
        setVisibility(r105);
        if (r104 == true) goto L12;
        mt8.a r106 = this.f308960a;
        if (r106 == null) goto L29;
        r106.e(new ArrayList());
        return;
    L29:
        return;
    L12:
        mt8.a r107 = this.f308960a;
        if (r107 == null) goto L27;
    L23:
        if (r107 != null) goto L25;
        return;
    L25:
        r107.h(r102, new ArrayList(r103), r101);
        return;
    L27:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L17
        Object r109 = Result.m9449constructorimpl(InputViewCreatorDelegate.f298409b.e(getContext()));     // Catch: Throwable -> L17
    L19:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 != null) goto L22;
        r107 = (mt8.a) r109;
        addView(r107.getView(), new FrameLayout.LayoutParams(-1, -2));
        this.f308960a = r107;
        goto L23
    L22:
        FLogger.f375446a.e("InteractionAskAttachmentView", "create resource bar failed", r110);
        r107 = null;
    L17:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L5:
        r105 = 8;
        goto L6
    }

    public /* synthetic */ InteractionAskAttachmentView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
