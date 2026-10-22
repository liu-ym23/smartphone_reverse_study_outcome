package com.obric.oui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/titlebar/OCentralizedTextTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "", "color", "", "setDividerLineBackground", "Landroid/widget/FrameLayout;", "getLeadingElement", "()Landroid/widget/FrameLayout;", "leadingElement", "getTrailingElement", "trailingElement", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OCentralizedTextTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f403378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f403379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f403380d;

    public OCentralizedTextTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OCentralizedTextTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final FrameLayout getLeadingElement() {
        return this.f403378b;
    }

    public final FrameLayout getTrailingElement() {
        return this.f403379c;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r100) {
        View r101 = this.f403380d;
        if (r101 == null) goto L7;
        r101.setBackgroundColor(r100);
        return;
    }

    public OCentralizedTextTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(r100, R.layout.o_centralized_title_bar, this);
        this.f403378b = (FrameLayout) findViewById(R.id.fl_leading_element);
        this.f403379c = (FrameLayout) findViewById(R.id.fl_trailing_element);
        this.f403462a = (TextView) findViewById(R.id.tv_content_title);
        this.f403380d = findViewById(R.id.divider_view);
    }

    public /* synthetic */ OCentralizedTextTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
