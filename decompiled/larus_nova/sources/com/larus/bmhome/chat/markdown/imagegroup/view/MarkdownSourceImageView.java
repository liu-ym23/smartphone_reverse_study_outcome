package com.larus.bmhome.chat.markdown.imagegroup.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.search.api.event.HybridEventParams;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nh8.a;
import oi8.j;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ(\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/markdown/imagegroup/view/MarkdownSourceImageView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initSourceIcon", "", RuleConditionBean.OPEN_URL_KEY, "", "iconUrl", "hybridEventParams", "Lcom/larus/search/api/event/HybridEventParams;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownSourceImageView extends SimpleDraweeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f307072a = 0;

    public MarkdownSourceImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public MarkdownSourceImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public MarkdownSourceImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public static void f(final MarkdownSourceImageView r110, final String r111, String r112, HybridEventParams r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r114 & 4) == 0) goto L9;
        final HybridEventParams r115 = null;
    L10:
        r110.getClass();
        if (AppHost.f326268a.isOversea() == true) goto L13;
        r110.setVisibility(8);
        return;
    L13:
        boolean r101 = true;
        if (r111 != null) goto L16;
    L19:
        boolean r102 = true;
    L20:
        if (r102 == false) goto L22;
        r110.setVisibility(8);
        return;
    L22:
        r110.setVisibility(0);
        if (r100 == null) goto L29;
        if (r100.length() == 0) goto L29;
        r101 = false;
    L29:
        if (r101 == false) goto L31;
        r110.setImageResource(R.drawable.larus_md_image_group_layout_source_icon);
    L32:
        e1.d(r110, new a(r111, r110, r115));
        return;
    L31:
        r110.getHierarchy().setFailureImage(R.drawable.larus_md_image_group_layout_source_icon);
        int r103 = j.f523459a;
        j.b(r110, r100, "chat.searchlist_icon", Integer.valueOf(i5.q()), Integer.valueOf(i5.q()), null, null, null, false, 992);
        goto L32
    L16:
        if (r111.length() == 0) goto L19;
        r102 = false;
        goto L20
    L9:
        r115 = r113;
        goto L10
    L5:
        r100 = r112;
        goto L7
    }
}
