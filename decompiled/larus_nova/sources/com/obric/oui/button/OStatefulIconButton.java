package com.obric.oui.button;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0001\nR*\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/button/OStatefulIconButton;", "Lcom/obric/oui/button/OIconButton;", "", "value", "m", "Z", "isChecked", "()Z", "setChecked", "(Z)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OStatefulIconButton extends OIconButton {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f399160n = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f399161m;

    public static final class a {
    }

    public OStatefulIconButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public OStatefulIconButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public OStatefulIconButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    @Override // com.obric.oui.button.OIconButton, com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r100) {
    }

    @Override // com.obric.oui.button.OIconButton
    public /* bridge */ /* synthetic */ void setFakePressed(boolean r100) {
    }

    static {
        f399160n = new int[]{R.attr.state_checked};
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (this.f399161m == false) goto L5;
        ImageView.mergeDrawableStates(r101, f399160n);
    L5:
        return r101;
    }

    public final void setChecked(boolean r100) {
        if (this.f399161m == r100) goto L6;
        this.f399161m = r100;
        refreshDrawableState();
        return;
    }

    public OStatefulIconButton(Context r100, AttributeSet r101, int r102, int r110) {
        if ((r110 & 2) == 0) goto L5;
        r101 = null;
    L5:
        AttributeSet r103 = r101;
        if ((r110 & 4) == 0) goto L8;
        int r104 = 0;
    L9:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r103, r104, 0, 16);
        return;
    L8:
        r104 = r102;
        goto L9
    }
}
