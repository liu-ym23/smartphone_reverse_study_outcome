package com.obric.oui.infopanel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import ema.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/obric/oui/infopanel/content/OInfoPanelContentEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "text", "", "setEntranceText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OInfoPanelContentEntranceView extends ConstraintLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f401284c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f401285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f401286b;

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new a(this));
    }

    public OInfoPanelContentEntranceView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setEntranceText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f401285a.setText(r100);
    }

    public OInfoPanelContentEntranceView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.o_info_panel_content_entrance_view, this);
        ViewGroup.MarginLayoutParams r102 = new ViewGroup.MarginLayoutParams(-1, -2);
        r102.setMargins(0, d.n(this, 8), 0, d.n(this, 12));
        setLayoutParams(r102);
        this.f401285a = (TextView) findViewById(R.id.tv_title);
        ImageView r103 = (ImageView) findViewById(R.id.iv_arrow);
        this.f401286b = (ViewGroup) findViewById(R.id.entrance_container);
    }
}
