package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/RootSelectAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/wikiv2/selector/IRootSelectData;", "Lcom/bytedance/ee/bear/wikiv2/selector/ViewHolder;", "context", "Landroid/content/Context;", "list", "", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "listener", "Lcom/bytedance/ee/bear/wikiv2/selector/OnClickItemListener;", "getListener", "()Lcom/bytedance/ee/bear/wikiv2/selector/OnClickItemListener;", "setListener", "(Lcom/bytedance/ee/bear/wikiv2/selector/OnClickItemListener;)V", "convert", "", "helper", "item", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RootSelectAdapter extends BaseQuickAdapter<iq5.p, ViewHolder> {
    public final Context a;
    public iq5.r b;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public RootSelectAdapter(Context r2, List<? extends iq5.p> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "list");
        super(2131564506, r3);
        this.a = r2;
    }

    public final void convert(BaseViewHolder r4, Object r5) {
        ViewHolder r6 = (ViewHolder) r4;
        iq5.p r7 = (iq5.p) r5;
        Intrinsics.checkNotNullParameter(r6, "helper");
        int r0 = r6.getLayoutPosition() - getHeaderLayoutCount();
        if (r7 != null) goto L5;
        tt5.a.h("RootSelectAdapter", "recentData is null, position = " + r0 + ", return.");
        return;
    L5:
        r6.a.setOnClickListener(new iq5.t(r7, this, r0));
        r6.b.setTitle(r7.title());
        r6.b.setTitleSize(r7.b());
        r6.a.getLayoutParams().height = r7.height();
        if (r7.c() <= 0) goto L8;
        r6.c.setVisibility(0);
        r6.c.setImageResource(kac.a.b(r7.c()));
    L10:
        if (r7.d() == 0) goto L12;
        com.bytedance.ee.util.ui.l.c(r6.c, r7.d());
        return;
    L12:
        r6.c.setImageTintList(null);
        return;
    L8:
        r6.c.setVisibility(8);
        goto L10
    }
}
