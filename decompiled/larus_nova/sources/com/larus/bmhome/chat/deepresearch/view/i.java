package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.mainbot.impl.databinding.LarusBlockItemResearchBannerBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i extends AbsBlockView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LarusBlockItemResearchBannerBinding f302399b;

    public i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(final Block r110, Map<String, Object> r111) {
        String r100 = null;
        if (r111 == null) goto L5;
        Object r101 = r111.get("block_view_extra_message");
    L6:
        final Message r102 = (Message) r101;
        if (r111 == null) goto L9;
        Object r103 = r111.get("block_view_extra_bot_model");
    L11:
        if ((r103 instanceof BotModel) == false) goto L13;
        final BotModel r104 = (BotModel) r103;
    L14:
        if (r111 == null) goto L16;
        Object r105 = r111.get("block_view_extra_chat_key");
    L18:
        if ((r105 instanceof Long) == false) goto L20;
        Long r106 = (Long) r105;
    L21:
        if (r106 == null) goto L23;
        long r107 = r106.longValue();
    L24:
        final long r108 = r107;
        if (r111 == null) goto L27;
        Object r112 = r111.get("block_view_extra_current_page");
    L29:
        if ((r112 instanceof String) == false) goto L31;
        r100 = (String) r112;
    L31:
        final String r113 = r100;
        final boolean r109 = Intrinsics.areEqual(r113, "dr_process_detail");
        String r114 = AbsBlockView.a.f(r110, r109, false);
        LarusBlockItemResearchBannerBinding r115 = this.f302399b;
        if (r115 == null) goto L43;
        if (r114 != null) goto L35;
    L38:
        boolean r116 = true;
    L39:
        if (r116 == false) goto L41;
        r115.f358494a.setVisibility(8);
        return;
    L41:
        r115.f358494a.setVisibility(0);
        r115.f358495b.setText(r114);
        com.larus.utils.e1.d(r115.f358494a, new h(r110, this, r109, r102, r104, r108, r113));
        return;
    L35:
        if (r114.length() == 0) goto L38;
        r116 = false;
        goto L39
    L43:
        return;
    L27:
        r112 = null;
        goto L29
    L23:
        r107 = 0;
        goto L24
    L20:
        r106 = null;
        goto L21
    L16:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_block_item_research_banner, this, false);
        addView(r102);
        LinearLayout r103 = (LinearLayout) r102;
        int r104 = R.id.iv_arrow;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.iv_arrow)) == null) goto L9;
        r104 = R.id.tv_title;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r102, R.id.tv_title);
        if (r105 == null) goto L9;
        this.f302399b = new LarusBlockItemResearchBannerBinding(r103, r105);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r104)));
    }
}
