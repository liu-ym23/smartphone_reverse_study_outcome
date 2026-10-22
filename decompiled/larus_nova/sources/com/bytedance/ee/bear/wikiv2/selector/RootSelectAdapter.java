package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import com.baidu.platform.comapi.map.MapController;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/RootSelectAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/wikiv2/selector/IRootSelectData;", "Lcom/bytedance/ee/bear/wikiv2/selector/ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "list", "", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "listener", "Lcom/bytedance/ee/bear/wikiv2/selector/OnClickItemListener;", "getListener", "()Lcom/bytedance/ee/bear/wikiv2/selector/OnClickItemListener;", "setListener", "(Lcom/bytedance/ee/bear/wikiv2/selector/OnClickItemListener;)V", "convert", "", "helper", MapController.ITEM_LAYER_TAG, "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RootSelectAdapter extends BaseQuickAdapter<iq5.p, ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f241112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public iq5.r f241113b;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.f241112a;
    }

    public RootSelectAdapter(Context r100, List<? extends iq5.p> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "list");
        super(R.layout.selector_doc_recycler_item_content, r101);
        this.f241112a = r100;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, iq5.p r101) {
        ViewHolder r102 = (ViewHolder) r100;
        iq5.p r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "helper");
        int r104 = r102.getLayoutPosition() - getHeaderLayoutCount();
        if (r103 != null) goto L5;
        tt5.a.h("RootSelectAdapter", "recentData is null, position = " + r104 + ", return.");
        return;
    L5:
        r102.f241125a.setOnClickListener(new iq5.t(r103, this, r104));
        r102.f241126b.setTitle(r103.title());
        r102.f241126b.setTitleSize(r103.b());
        r102.f241125a.getLayoutParams().height = r103.height();
        if (r103.c() <= 0) goto L8;
        r102.f241127c.setVisibility(0);
        r102.f241127c.setImageResource(kac.a.b(r103.c()));
    L10:
        if (r103.d() == 0) goto L12;
        com.bytedance.ee.util.ui.l.c(r102.f241127c, r103.d());
        return;
    L12:
        r102.f241127c.setImageTintList(null);
        return;
    L8:
        r102.f241127c.setVisibility(8);
        goto L10
    }
}
