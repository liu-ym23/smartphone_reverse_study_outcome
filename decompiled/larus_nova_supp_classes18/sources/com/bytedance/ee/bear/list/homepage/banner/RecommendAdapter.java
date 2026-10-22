package com.bytedance.ee.bear.list.homepage.banner;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.shadow.ShadowLinearLayout;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.n;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/banner/RecommendAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/list/homepage/banner/BannerCardInfo;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "isFromWorkbench", "", "hpFrom", "", "columnCount", "", "<init>", "(ZLjava/lang/String;I)V", "()Z", "getHpFrom", "()Ljava/lang/String;", "getColumnCount", "()I", "convert", "", "helper", "item", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendAdapter extends BaseQuickAdapter<BannerCardInfo, BaseViewHolder> {
    public final boolean a;
    public final String b;
    public final int c;

    public static final class a {
    }

    static {
    }

    public RecommendAdapter(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "hpFrom");
        super(2131558810);
        this.a = r2;
        this.b = r3;
        this.c = 3;
    }

    public final void convert(BaseViewHolder r9, Object r10) {
        BannerCardInfo r11 = (BannerCardInfo) r10;
        Intrinsics.checkNotNullParameter(r9, "helper");
        Intrinsics.checkNotNullParameter(r11, "item");
        int r0 = r9.getLayoutPosition() - getHeaderLayoutCount();
        lc5.f.a r1 = lc5.f.a;
        String r3 = r11.getRedirectUrl();
        String r4 = r11.getTitle();
        Integer r5 = Integer.valueOf(r0);
        if (this.a == false) goto L5;
        String r2 = "workbench";
    L6:
        r1.n("single_template_show", r3, r4, r5, r2, this.b);
        ShadowLinearLayout r6 = (ShadowLinearLayout) r9.getView(2131365185);
        int r7 = getRecyclerView().getMeasuredWidth();
        int r8 = y9c.d.a(16);
        int r12 = y9c.d.a(16);
        int r13 = n.d(12);
        int r14 = (r7 - r8) - r12;
        int r15 = this.c;
        int r16 = (int) (((r14 - ((r15 - 1) * r13)) / r15) * 0.55f);
        ViewGroup.LayoutParams r17 = r6.getLayoutParams();
        r17.height = r16;
        r6.setLayoutParams(r17);
        Glide.with(((BaseQuickAdapter) this).mContext).load(new BearGlideUrl(r11.getCover())).error(2131243858).diskCacheStrategy(DiskCacheStrategy.ALL).into((ImageView) r9.getView(2131365180));
        ((TextView) r9.getView(2131365218)).setText(r11.getTitle());
        return;
    L5:
        r2 = "larktab_bitable";
        goto L6
    }
}
