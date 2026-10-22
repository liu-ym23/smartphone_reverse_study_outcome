package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vma.c;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u001b\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006R(\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/selection/OActionSheetButton;", "Lcom/obric/oui/layout/OUIFrameLayout;", "", "str", "", "setText", "", "color", "setTextColor", "Lcom/obric/oui/text/OTextView;", "h", "Lcom/obric/oui/text/OTextView;", "getTvTitle", "()Lcom/obric/oui/text/OTextView;", "setTvTitle", "(Lcom/obric/oui/text/OTextView;)V", "getTvTitle$annotations", "()V", "tvTitle", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OActionSheetButton extends OUIFrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OTextView f402767h;

    public static final class a {
    }

    static {
    }

    public static /* synthetic */ void getTvTitle$annotations() {
    }

    public final OTextView getTvTitle() {
        OTextView r100 = this.f402767h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        return null;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        getTvTitle().setText(r100);
    }

    public final void setTextColor(int r100) {
        getTvTitle().setTextColor(r100);
    }

    public final void setTvTitle(OTextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402767h = r100;
    }

    public OActionSheetButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0, 12);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_button, this);
        ViewParent r102 = (ViewGroup) findViewById(R.id.ll_root);
        int r103 = c.f556351a;
        if (r102 != null) goto L6;
    L8:
        r102 = null;
    L9:
        com.obric.oui.common.style.a r104 = (com.obric.oui.common.style.a) r102;
        if (r104 == null) goto L13;
        r104.setChangeAlphaWhenPress(false);
    L13:
        setTvTitle((OTextView) findViewById(R.id.tv_content_title));
        setRadius((int) getResources().getDimension(R.dimen.oui_r_l3_rect));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if ((r102 instanceof com.obric.oui.common.style.a) == false) goto L8;
        goto L8
    }
}
