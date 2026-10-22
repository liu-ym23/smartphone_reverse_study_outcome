package com.ss.android.lark.conditional.access.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomDisplayPageUiMode;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.a;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import u8b.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\rJ*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0014J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/conditional/access/widget/CustomDisplayLinkTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/lark/conditional/access/widget/CustomLoadingView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "handler", "Lcom/bytedance/lark/pb/security/v1/CustomDisplayHandler;", "internalSecurityAction", "Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "buttonTypeFunction", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/ButtonTypeFunction;", "pageUiMode", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/CustomDisplayPageUiMode;", "setCustomDisplayHandler", "", SendEventContainerMethodParamModel.EventKinds.onClick, BaseSwitches.V, "Landroid/view/View;", "onDetachedFromWindow", "startLoading", "endLoading", "linkTextColorRes", "linkLoadingColorRes", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomDisplayLinkTextView extends AppCompatTextView implements View.OnClickListener, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CustomDisplayHandler f418514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InternalSecurityAction f418515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f418516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CustomDisplayPageUiMode f418517d;

    @Override // u8b.b
    public final void endLoading() {
        setEnabled(true);
        Resources r100 = getResources();
        if (this.f418517d != CustomDisplayPageUiMode.LARK) goto L5;
        int r101 = R.color.text_link_hover;
    L6:
        setTextColor(r100.getColor(r101));
        setCompoundDrawables(null, null, null, null);
        return;
    L5:
        r101 = R.color.doubao_policy_center_link;
        goto L6
    }

    @Override // u8b.b
    public final void startLoading() {
        List r100 = CollectionsKt.listOf(new String[]{"DeviceApply", "DeviceAuth", "DeviceTokenClaimsChallenge", "DeviceCertAuth"});
        CustomDisplayHandler r101 = this.f418514a;
        if (r101 == null) goto L5;
        String r102 = r101.type;
    L7:
        if (CollectionsKt.contains(r100, r102) == false) goto L18;
        CircularProgressDrawable r103 = new CircularProgressDrawable(getContext());
        r103.setStyle(1);
        int[] r104 = new int[1];
        Resources r105 = getResources();
        CustomDisplayPageUiMode r106 = this.f418517d;
        CustomDisplayPageUiMode r107 = CustomDisplayPageUiMode.LARK;
        int r108 = R.color.text_link_loading;
        if (r106 != r107) goto L11;
        int r109 = R.color.text_link_loading;
    L12:
        r104[0] = r105.getColor(r109);
        r103.setColorSchemeColors(r104);
        r103.setCenterRadius(UIUtils.dp2px(getContext(), 5.0f));
        r103.setStrokeWidth(UIUtils.dp2px(getContext(), 1.5f));
        r103.setStrokeCap(Paint.Cap.ROUND);
        int r110 = ((int) (r103.getCenterRadius() + r103.getStrokeWidth())) * 2;
        r103.setBounds(0, 0, r110, r110);
        setCompoundDrawablePadding(UIUtils.dp2px(getContext(), 4.0f));
        setCompoundDrawables(r103, null, null, null);
        r103.start();
        setEnabled(false);
        Resources r111 = getResources();
        if (this.f418517d == r107) goto L16;
        r108 = R.color.doubao_policy_center_link;
    L16:
        setTextColor(r111.getColor(r108));
        return;
    L11:
        r109 = R.color.doubao_policy_center_link;
        goto L12
    L18:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Object[] r100 = getCompoundDrawables();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        Object r103 = r100[r102];
        if ((r103 instanceof Animatable) == false) goto L9;
        Animatable r104 = (Animatable) r103;
        if (r104.isRunning() == false) goto L9;
        r104.stop();
    L9:
        r102 = r102 + 1;
        goto L3
    }

    public CustomDisplayLinkTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CustomDisplayHandler r101 = this.f418514a;
        if (r101 == null) goto L12;
        a r102 = this.f418516c;
        if (r102 == null) goto L7;
        Boolean r103 = Boolean.valueOf(r102.dL(r101, this.f418515b, getContext()));
    L9:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L13;
        startLoading();
        return;
    L13:
        return;
    L7:
        r103 = null;
        goto L9
    }

    public CustomDisplayLinkTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public CustomDisplayLinkTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f418517d = CustomDisplayPageUiMode.LARK;
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        if (Build.VERSION.SDK_INT < 23) goto L5;
        setTextAppearance(R.style.UDText_Body0);
    L5:
        setTextSize(2, 14.0f);
        setTextColor(getResources().getColor(R.color.text_link_hover));
        setClickable(true);
        setGravity(17);
    }
}
