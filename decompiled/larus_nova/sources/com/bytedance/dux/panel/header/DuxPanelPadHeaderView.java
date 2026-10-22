package com.bytedance.dux.panel.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.dux.divider.DuxDivider;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/dux/panel/header/DuxPanelPadHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/appcompat/widget/AppCompatImageView;", "getCloseIconView", "Landroid/widget/TextView;", "getTitleView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxPanelPadHeaderView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatImageView f205379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f205380b;

    public final AppCompatImageView getCloseIconView() {
        return this.f205379a;
    }

    public final TextView getTitleView() {
        return this.f205380b;
    }

    public DuxPanelPadHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public DuxPanelPadHeaderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.dux_basic_panel_pad_header, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.bytedance.dux.utils.a.a(r100)));
        setBackgroundColor(0);
        this.f205379a = (AppCompatImageView) findViewById(R.id.iv_close);
        this.f205380b = (TextView) findViewById(R.id.tv_title);
        ImageView r102 = (ImageView) findViewById(R.id.iv_back);
        DuxDivider r103 = (DuxDivider) findViewById(R.id.divider);
    }
}
