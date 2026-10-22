package com.bytedance.ee.bear.bitable.uikit.simpleitem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.panel.Style;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SearchConfigIcon;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "imageView", "Landroidx/appcompat/widget/AppCompatImageView;", "getImageView", "()Landroidx/appcompat/widget/AppCompatImageView;", "setImageView", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchConfigIcon extends FrameLayout implements b<Icon> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatImageView f216225a;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Icon f216226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ gv4.a f216227b;

        public a(Icon r100, gv4.a r101) {
            this.f216226a = r100;
            this.f216227b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ActionPayload r101 = this.f216226a.getClickActionPayload();
            if (r101 == null) goto L8;
            gv4.a r102 = this.f216227b;
            if (r102 == null) goto L9;
            r102.a(r101);
            return;
        L9:
            return;
        }
    }

    public final AppCompatImageView getImageView() {
        return this.f216225a;
    }

    public SearchConfigIcon(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setImageView(AppCompatImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f216225a = r100;
    }

    public SearchConfigIcon(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setLayoutParams(new ViewGroup.LayoutParams(n.d(24), n.d(24)));
        AppCompatImageView r102 = new AppCompatImageView(r100);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(n.d(16), n.d(16));
        r103.gravity = 17;
        r102.setLayoutParams(r103);
        r102.setImageResource(R.drawable.ud_icon_advanced_actived_outlined);
        this.f216225a = r102;
        addView(r102);
    }

    public final void a(Icon r100, gv4.a r101) {
        boolean r102 = false;
        if (r100 == null) goto L14;
        Integer r103 = r100.getStyle();
        int r104 = Style.Select.getValue();
        if (r103 != null) goto L8;
    L10:
        if (r102 == false) goto L12;
        setBackgroundResource(R.drawable.bitable_search_config_icon_bg);
        this.f216225a.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.primary_pri_600)));
    L13:
        setOnClickListener(new a(r100, r101));
        m.z(this, true);
        return;
    L12:
        setBackground(null);
        this.f216225a.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.icon_n1)));
        goto L13
    L8:
        if (r103.intValue() != r104) goto L10;
        r102 = true;
        goto L10
    L14:
        m.z(this, false);
    }
}
