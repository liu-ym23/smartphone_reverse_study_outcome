package com.obric.oui.panel.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.obric.oui.divider.ODivider;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\f"}, d2 = {"Lcom/obric/oui/panel/header/OPanelPadHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/appcompat/widget/AppCompatImageView;", "getCloseIconView", "Landroid/widget/TextView;", "getTitleView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OPanelPadHeaderView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatImageView f402115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f402116b;

    public final AppCompatImageView getCloseIconView() {
        return this.f402115a;
    }

    public final TextView getTitleView() {
        return this.f402116b;
    }

    public OPanelPadHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public OPanelPadHeaderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.o_basic_panel_pad_header, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, pla.a.a(r100)));
        setBackgroundColor(0);
        this.f402115a = (AppCompatImageView) findViewById(R.id.iv_close);
        this.f402116b = (TextView) findViewById(R.id.tv_title);
        ImageView r102 = (ImageView) findViewById(R.id.iv_back);
        ODivider r103 = (ODivider) findViewById(R.id.divider);
    }
}
