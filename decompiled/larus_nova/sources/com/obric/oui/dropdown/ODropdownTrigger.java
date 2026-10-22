package com.obric.oui.dropdown;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import com.facebook.keyframes.model.KFAnimation;
import com.larus.nova.R;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "use CardListItem")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR+\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u001c\u001a\u0004\u0018\u00010\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/obric/oui/dropdown/ODropdownTrigger;", "Lcom/obric/oui/layout/OUILinearLayout;", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "getValue", "()Landroid/widget/TextView;", "value", "Landroid/widget/ImageView;", "m", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "", "<set-?>", OfficeSDKRequestTag.KEY_NEW_USER, "Lkotlin/properties/ReadWriteProperty;", "getActive", "()Z", "setActive", "(Z)V", "active", "Landroid/app/Activity;", "getDropdownActivity", "()Landroid/app/Activity;", "setDropdownActivity", "(Landroid/app/Activity;)V", "dropdownActivity", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class ODropdownTrigger extends OUILinearLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f400798p = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f400799h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f400800i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f400801j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f400802k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final OBaseTextView f400803l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f400804m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f400805n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WeakReference<Activity> f400806o;

    public static final class a extends ObservableProperty<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ODropdownTrigger f400807a;

        public a(Object r100, ODropdownTrigger r101) {
            this.f400807a = r101;
            super(r100);
        }

        @Override // kotlin.properties.ObservableProperty
        public final void afterChange(KProperty<?> r100, Boolean r101, Boolean r102) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            boolean r103 = r102.booleanValue();
            if (r101.booleanValue() == r103) goto L10;
            if (r103 == false) goto L7;
            ODropdownTrigger r104 = this.f400807a;
            r104.f400804m.setImageResource(r104.f400802k);
            r104.setBackgroundColor(r104.f400800i);
            return;
        L7:
            ODropdownTrigger r105 = this.f400807a;
            r105.f400804m.setImageResource(r105.f400801j);
            r105.setBackgroundColor(r105.f400799h);
            return;
        }
    }

    static {
        f400798p = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(ODropdownTrigger.class, "active", "getActive()Z", 0))};
    }

    public ODropdownTrigger(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ODropdownTrigger(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.obric.oui.layout.OUILinearLayout, com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r100) {
    }

    public final boolean getActive() {
        return this.f400805n.getValue(this, f400798p[0]).booleanValue();
    }

    public final Activity getDropdownActivity() {
        WeakReference<Activity> r100 = this.f400806o;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("reference");
        r100 = null;
    L6:
        return r100.get();
    }

    public final ImageView getIcon() {
        return this.f400804m;
    }

    public final TextView getValue() {
        return this.f400803l;
    }

    public final void setActive(boolean r100) {
        this.f400805n.setValue(this, f400798p[0], Boolean.valueOf(r100));
    }

    public final void setDropdownActivity(Activity r100) {
        this.f400806o = new WeakReference(r100);
    }

    @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public ODropdownTrigger(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 8);
        Delegates r103 = Delegates.INSTANCE;
        this.f400805n = new a(Boolean.FALSE, this);
        if ((r100 instanceof Activity) == false) goto L5;
        setDropdownActivity((Activity) r100);
    L5:
        TypedArray r104 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.oui_backgroundOff, R.attr.oui_backgroundOn, R.attr.oui_iconOff, R.attr.oui_iconOn, R.attr.oui_imageStyle, R.attr.oui_midMargin, R.attr.oui_textStyle}, 0, 0);
        int r105 = r104.getColor(0, getResources().getColor(R.color.oui_fill_element_2, r100.getTheme()));
        this.f400799h = r105;
        this.f400800i = r104.getColor(1, getResources().getColor(R.color.oui_fill_active, r100.getTheme()));
        int r106 = r104.getResourceId(2, R.drawable.dropdown_default_off);
        this.f400801j = r106;
        this.f400802k = r104.getResourceId(3, R.drawable.dropdown_default_on);
        OBaseTextView r107 = new OBaseTextView(new ContextThemeWrapper(r100, r104.getResourceId(6, R.style.ODropdownTriggerText)), null, 6, 0);
        this.f400803l = r107;
        addView(r107);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(r107.getLayoutParams());
        r108.weight = 1.0f;
        r108.rightMargin = r104.getDimensionPixelOffset(5, d.n(this, 0));
        r107.setLayoutParams(r108);
        ImageView r109 = new ImageView(new ContextThemeWrapper(r100, r104.getResourceId(4, R.style.ODropdownTriggerIcon)));
        this.f400804m = r109;
        addView(r109);
        r109.setImageResource(r106);
        setBackgroundColor(r105);
        setOnClickListener(new b(this));
    }

    public /* synthetic */ ODropdownTrigger(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
