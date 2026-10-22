package com.bytedance.ee.bear.bitable.itemview.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewNotice;", "Lcom/larksuite/component/universe_design/notice/UDNotice;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewNoticeData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewNotice extends UDNotice implements gv4.b<ItemViewNoticeData> {

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gv4.a f213989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionPayload f213990b;

        public a(gv4.a r100, ActionPayload r101) {
            this.f213989a = r100;
            this.f213990b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            gv4.a r101 = this.f213989a;
            if (r101 == null) goto L6;
            r101.a(this.f213990b);
            return;
        }
    }

    public ItemViewNotice(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public ItemViewNotice(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setIconColorful(true);
        setIconButton(R.drawable.icon_feed_close);
    }

    public final void o6(ItemViewNoticeData r100, gv4.a r101) {
        if (r100 == null) goto L24;
        m.z(this, true);
        SimpleItemModel r102 = r100.getData();
        if (r102 == null) goto L10;
        String r103 = r102.getText();
        if (r103 == null) goto L10;
        setText(r103);
    L10:
        if (r100.isInfo() == false) goto L13;
        setIcon(R.drawable.ud_icon_info_colorful);
        setTextColor(UIHelper.getColor(R.color.text_title));
        setBackground(UIHelper.getColor(R.color.function_info_100));
    L18:
        SimpleItemModel r104 = r100.getData();
        if (r104 == null) goto L23;
        ActionPayload r105 = r104.getClickActionPayload();
        if (r105 == null) goto L23;
        i6(true);
        setIconButtonListener(new a(r101, r105));
        return;
    L23:
        i6(false);
        return;
    L13:
        if (r100.isWarning() == false) goto L16;
        setIcon(R.drawable.ud_icon_warning_light_colorful);
        setTextColor(UIHelper.getColor(R.color.function_warning_fill_default));
        setBackground(UIHelper.getColor(R.color.function_warning_fill_solid_02));
        goto L18
    L16:
        if (r100.isError() == false) goto L18;
        setIcon(R.drawable.ud_icon_error_colorful);
        setTextColor(UIHelper.getColor(R.color.text_title));
        setBackground(UIHelper.getColor(R.color.function_danger_fill_solid_01));
        goto L18
    L24:
        m.z(this, false);
    }
}
