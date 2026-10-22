package com.larksuite.component.universe_design.edittext;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 52\u00020\u0001:\u00015B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\fJ\u0006\u0010#\u001a\u00020!J\u0010\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\fJ\u0018\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020!J\u0010\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\fJ\u0018\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u0007J\u0018\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u0013J \u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020!H\u0002J\b\u0010/\u001a\u00020!H\u0002J\u001a\u00100\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u0007H\u0002J\b\u00101\u001a\u00020!H\u0002J\u001a\u00102\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u0013H\u0002J\b\u00104\u001a\u00020!H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mTitleText", "", "mTitleTextColor", "mTitleTextSize", "", "mTitleInputMargin", "mHelperText", "mHelperTextColor", "Landroid/content/res/ColorStateList;", "mBottomTextSize", "mBottomInputMargin", "mErrorText", "mErrorTextColor", "mInputFrame", "Landroid/widget/FrameLayout;", "mEditText", "Landroid/widget/EditText;", "mTopTextView", "Landroid/widget/TextView;", "mBottomTextView", "getEditText", "showTitleText", "", "titleText", "showErrorText", "errorText", "textColor", "showHelperText", "helperText", "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "initView", "initBottomTextView", "refreshTitleText", "initInputFrame", "refreshBottomText", "showText", "initTopTextView", "Companion", "universe-ui-edittext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDTextInputLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f284993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f284994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EditText f284995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f284996d;

    public static final class a {
    }

    static {
    }

    public UDTextInputLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public UDTextInputLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public UDTextInputLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final EditText getEditText() {
        return this.f284995c;
    }

    public final void b(CharSequence r100) {
        a(r100, this.f284993a);
    }

    public final void a(CharSequence r100, ColorStateList r101) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.f284996d.setText(r100);
        this.f284996d.setTextColor(r101);
        this.f284996d.setVisibility(0);
        return;
    L5:
        this.f284996d.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "params");
        if ((r100 instanceof EditText) == true) goto L5;
        super.addView(r100, r101, r102);
        return;
    L5:
        if (this.f284995c != null) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L11;
        this.f284995c = (EditText) r100;
        this.f284994b.addView(r100, r102);
        return;
    L11:
        throw new IllegalArgumentException("We already have an EditText, can only have one".toString());
    L7:
        r103 = false;
        goto L8
    }

    public UDTextInputLayout(Context r110, AttributeSet r111, int r112, int r210) {
        if ((r210 & 2) == 0) goto L5;
        AttributeSet r100 = null;
    L7:
        if ((r210 & 4) == 0) goto L9;
        int r101 = 0;
    L10:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r100, r101);
        ColorStateList.valueOf(0);
        this.f284993a = ColorStateList.valueOf(0);
        FrameLayout r102 = new FrameLayout(r110);
        this.f284994b = r102;
        TextView r103 = new TextView(r110);
        TextView r104 = new TextView(r110);
        this.f284996d = r104;
        setOrientation(1);
        TypedArray r105 = r110.obtainStyledAttributes(r100, new int[]{R.attr.ud_inputLayout_bottomTextInputMargin, R.attr.ud_inputLayout_bottomTextSize, R.attr.ud_inputLayout_errorText, R.attr.ud_inputLayout_errorTextColor, R.attr.ud_inputLayout_helperText, R.attr.ud_inputLayout_helperTextColor, R.attr.ud_inputLayout_titleInputMargin, R.attr.ud_inputLayout_titleText, R.attr.ud_inputLayout_titleTextColor, R.attr.ud_inputLayout_titleTextSize}, r101, 0);
        String r106 = r105.getString(7);
        int r113 = r105.getColor(8, UDColorUtils.getColor(r110, R.color.text_title));
        float r114 = r105.getDimension(9, d.a(r110, 16.0f));
        int r115 = r105.getDimensionPixelSize(6, (int) d.a(r110, 8.0f));
        CharSequence r107 = r105.getString(4);
        ColorStateList r116 = r105.getColorStateList(5);
        if (r116 != null) goto L13;
        r116 = UDColorUtils.getColorStateList(r110, R.color.ud_edittext_hint);
    L13:
        r105.getString(2);
        ColorStateList r117 = r105.getColorStateList(3);
        if (r117 != null) goto L16;
        r117 = UDColorUtils.getColorStateList(r110, R.color.function_danger_fill_default);
    L16:
        this.f284993a = r117;
        float r118 = r105.getDimension(1, d.a(r110, 14.0f));
        int r108 = r105.getDimensionPixelSize(0, (int) d.a(r110, 8.0f));
        r105.recycle();
        r103.setTextSize(0, r114);
        r103.setTextColor(r113);
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(-1, -2);
        r109.bottomMargin = r115;
        if (TextUtils.isEmpty(r106) == true) goto L19;
        r103.setText(r106);
        r103.setVisibility(0);
    L20:
        addView(r103, r109);
        r102.setAddStatesFromChildren(true);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(r102);
        r104.setTextSize(0, r118);
        LinearLayout.LayoutParams r119 = new LinearLayout.LayoutParams(-1, -2);
        r119.topMargin = r108;
        addView(r104, r119);
        a(r107, r116);
        return;
    L19:
        r103.setVisibility(8);
        goto L20
    L9:
        r101 = r112;
        goto L10
    L5:
        r100 = r111;
        goto L7
    }
}
