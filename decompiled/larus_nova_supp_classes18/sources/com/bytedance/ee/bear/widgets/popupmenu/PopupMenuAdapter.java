package com.bytedance.ee.bear.widgets.popupmenu;

import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/widgets/popupmenu/PopupMenuAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/widgets/popupmenu/PopupMenuItem;", "Lcom/chad/library/adapter/base/BaseViewHolder;", WikiFolderPushPlugin.DATA, "", "<init>", "(Ljava/util/List;)V", "convert", "", "helper", "item", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuAdapter extends BaseQuickAdapter<kp5.a, BaseViewHolder> {
    public PopupMenuAdapter(List<kp5.a> r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        super(2131568225, r2);
    }

    public final void convert(BaseViewHolder r3, Object r4) {
        kp5.a r5 = (kp5.a) r4;
        Intrinsics.checkNotNullParameter(r3, "helper");
        Intrinsics.checkNotNullParameter(r5, "item");
        ImageView r0 = (ImageView) r3.getView(2131393197);
        TextView r6 = (TextView) r3.getView(2131393198);
        r5.getClass();
        r0.setImageResource(0);
        r6.setText(null);
    }
}
