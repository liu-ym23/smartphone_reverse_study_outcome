package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import gv4.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/uikit/CommentView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "getCommentBgRes", "", "textCount", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentView extends FrameLayout implements b<SimpleItemModel> {

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimpleItemModel f213367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ gv4.a f213368b;

        public a(SimpleItemModel r100, e r101) {
            this.f213367a = r100;
            this.f213368b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SimpleItemModel r101 = this.f213367a;
            if (r101 == null) goto L10;
            ActionPayload r102 = r101.getClickActionPayload();
            if (r102 == null) goto L11;
            gv4.a r103 = this.f213368b;
            if (r103 == null) goto L12;
            r103.a(r102);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public CommentView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public CommentView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        if (c.y() == true) goto L5;
    L7:
        LayoutInflater.from(r100).inflate(R.layout.bitable_uikit_comment_layout, this, true);
        return;
    L5:
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.comment_optimization.enable") == true) goto L7;
        LayoutInflater.from(r100).inflate(R.layout.bitable_uikit_comment_layout_v2, this, true);
    }

    public final void a(SimpleItemModel r100, gv4.a r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.getText();
    L7:
        if (TextUtils.isEmpty(r103) == false) goto L9;
        setVisibility(8);
        return;
    L9:
        setVisibility(0);
        TextView r104 = (TextView) findViewById(R.id.comment_num);
        if (r100 == null) goto L26;
        String r105 = r100.getText();
        if (r105 == null) goto L26;
        if (c.y() == true) goto L16;
    L25:
        r102 = r105;
        goto L26
    L16:
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.comment_optimization.enable") == true) goto L25;
        int r106 = r105.length();
        Context r107 = getContext();
        if (r106 != 1) goto L20;
        int r108 = R.drawable.icon_chat_all_filled_small;
    L24:
        r104.setBackground(l.a(r107, r108, R.color.primary_pri_100));
        goto L25
    L20:
        if (r106 == 2) goto L22;
        r108 = R.drawable.icon_chat_all_filled_large;
        goto L24
    L22:
        r108 = R.drawable.icon_chat_all_filled_mid;
    L26:
        r104.setText(r102);
        setOnClickListener(new a(r100, (e) r101));
        return;
    L5:
        r103 = null;
        goto L7
    }
}
