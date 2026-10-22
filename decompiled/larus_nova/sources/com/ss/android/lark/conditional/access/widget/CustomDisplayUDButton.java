package com.ss.android.lark.conditional.access.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.button.d;
import com.larksuite.component.universe_design.button.e;
import com.larus.nova.R;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.a;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u8b.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\rJ*\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J \u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0002J\u0012\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u001cH\u0016J\b\u0010,\u001a\u00020\u001cH\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/conditional/access/widget/CustomDisplayUDButton;", "Lcom/larksuite/component/universe_design/button/UDButton;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/lark/conditional/access/widget/CustomLoadingView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "handler", "Lcom/bytedance/lark/pb/security/v1/CustomDisplayHandler;", "internalSecurityAction", "Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "buttonTypeFunction", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/ButtonTypeFunction;", "isLoading", "", "normalBackground", "Landroid/content/res/ColorStateList;", "normalTextColor", "loadingBackgroundRes", "loadingProgressColorRes", "setCustomDisplayHandler", "", "pageUiMode", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/CustomDisplayPageUiMode;", "applyDoubaoStyle", "applyDoubaoPlainStyle", "doubaoPrimaryTextColorStateList", "doubaoPlainTextColorStateList", "doubaoStaticWhiteTextColorStateList", "doubaoColorStateList", "normal", "pressed", "disabled", SendEventContainerMethodParamModel.EventKinds.onClick, BaseSwitches.V, "Landroid/view/View;", "startLoading", "endLoading", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomDisplayUDButton extends UDButton implements View.OnClickListener, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CustomDisplayHandler f418518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InternalSecurityAction f418519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f418520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f418521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorStateList f418522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorStateList f418523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f418524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f418525h;

    @Override // u8b.b
    public final void endLoading() {
        this.f418521d = false;
        CustomDisplayHandler r100 = this.f418518a;
        if (r100 == null) goto L6;
        String r101 = r100.name;
        if (r101 == null) goto L6;
    L7:
        e.a r102 = e.f284623a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        e.b(this, r101);
        ColorStateList r103 = this.f418523f;
        if (r103 == null) goto L10;
        setTextColor(r103);
    L10:
        ColorStateList r104 = this.f418522e;
        if (r104 == null) goto L14;
        setBackgroundColor(r104);
        return;
    L14:
        return;
    L6:
        r101 = "";
        goto L7
    }

    @Override // u8b.b
    public final void startLoading() {
        this.f418521d = true;
        d r100 = new d();
        CustomDisplayHandler r101 = this.f418518a;
        if (r101 == null) goto L7;
        String r102 = r101.name;
        if (r102 == null) goto L7;
    L8:
        r100.f284588b = r102;
        r100.f284621j = Integer.valueOf(getResources().getColor(this.f418525h));
        e.g(this, r100);
        if (this.f418523f == null) goto L12;
        setTextColor(ColorStateList.valueOf(getResources().getColor(this.f418525h)));
    L12:
        if (this.f418524g == 0) goto L15;
        setBackgroundColor(AppCompatResources.getColorStateList(getContext(), this.f418524g));
        return;
    L15:
        return;
    L7:
        r102 = "";
        goto L8
    }

    public CustomDisplayUDButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f418521d == false) goto L5;
        return;
    L5:
        CustomDisplayHandler r101 = this.f418518a;
        if (r101 == null) goto L15;
        a r102 = this.f418520c;
        if (r102 == null) goto L10;
        Boolean r103 = Boolean.valueOf(r102.dL(r101, this.f418519b, getContext()));
    L12:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L16;
        startLoading();
        return;
    L16:
        return;
    L10:
        r103 = null;
        goto L12
    }

    public CustomDisplayUDButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public CustomDisplayUDButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f418525h = R.color.static_white;
    }

    public static ColorStateList a(int r100, int r101, int r102) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{r102, r101, r100});
    }
}
