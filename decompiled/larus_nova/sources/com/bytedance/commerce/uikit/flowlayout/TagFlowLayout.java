package com.bytedance.commerce.uikit.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3ProductFormatItemView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003:\u0003()*B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0004¢\u0006\u0004\b&\u0010'J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\bR>\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006+"}, d2 = {"Lcom/bytedance/commerce/uikit/flowlayout/TagFlowLayout;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/commerce/uikit/flowlayout/FlowLayout;", "", "", "count", "", "setMaxSelectCount", "", "getSelectedList", "Lfg4/a;", "value", ce.f26396k, "Lfg4/a;", "getTagAdapter", "()Lfg4/a;", "setTagAdapter", "(Lfg4/a;)V", "tagAdapter", "Lcom/bytedance/commerce/uikit/flowlayout/TagFlowLayout$b;", "onSelectListener", "Lcom/bytedance/commerce/uikit/flowlayout/TagFlowLayout$b;", "getOnSelectListener", "()Lcom/bytedance/commerce/uikit/flowlayout/TagFlowLayout$b;", "setOnSelectListener", "(Lcom/bytedance/commerce/uikit/flowlayout/TagFlowLayout$b;)V", "Lcom/bytedance/commerce/uikit/flowlayout/TagFlowLayout$c;", "tagClickListener", "Lcom/bytedance/commerce/uikit/flowlayout/TagFlowLayout$c;", "getTagClickListener", "()Lcom/bytedance/commerce/uikit/flowlayout/TagFlowLayout$c;", "setTagClickListener", "(Lcom/bytedance/commerce/uikit/flowlayout/TagFlowLayout$c;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "uikit_release"}, k = 1, mv = {1, 4, 0})
public final class TagFlowLayout<T> extends FlowLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f202948l = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f202949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<Integer> f202950j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public fg4.a<T> f202951k;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
    }

    static {
    }

    public TagFlowLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TagFlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final b getOnSelectListener() {
        return null;
    }

    public final c getTagClickListener() {
        return null;
    }

    public final void setOnSelectListener(b r100) {
    }

    public final void setTagClickListener(c r100) {
    }

    public final Set<Integer> getSelectedList() {
        return new HashSet(this.f202950j);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("key_default", super.onSaveInstanceState());
        StringBuilder r101 = new StringBuilder();
        if (((HashSet) this.f202950j).size() <= 0) goto L9;
        Iterator r102 = ((HashSet) this.f202950j).iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.append(((Number) r102.next()).intValue());
        r101.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        goto L6
    L8:
        r101.deleteCharAt(r101.length() - 1);
    L9:
        r100.putString("key_choose_pos", r101.toString());
        return r100;
    }

    public final fg4.a<T> getTagAdapter() {
        return this.f202951k;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof Bundle) == false) goto L29;
        Bundle r101 = (Bundle) r100;
        String r102 = r101.getString("key_choose_pos");
        int r103 = 0;
        if (r102 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L27;
        Object[] r105 = new Regex("\\|").split(r102, 0).toArray(new String[0]);
        if (r105 == null) goto L26;
        String[] r106 = (String[]) r105;
        int r107 = r106.length;
    L15:
        if (r103 >= r107) goto L27;
        int r108 = CastIntegerProtector.parseInt(r106[r103]);
        Set<Integer> r109 = this.f202950j;
        HashSet r110 = (HashSet) r109;
        r110.add(Integer.valueOf(r108));
        View r111 = getChildAt(r108);
        if ((r111 instanceof fg4.c) == true) goto L19;
        r111 = null;
    L19:
        fg4.c r112 = (fg4.c) r111;
        if (r112 == null) goto L24;
        r112.setChecked(true);
        if (this.f202951k == null) goto L24;
        r112.getTagView();
    L24:
        r103 = r103 + 1;
        goto L15
    L26:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L27:
        super.onRestoreInstanceState(r101.getParcelable("key_default"));
        return;
    L7:
        if (r102.length() == 0) goto L10;
        r104 = false;
        goto L11
    L29:
        super.onRestoreInstanceState(r100);
    }

    public final void setMaxSelectCount(int r100) {
        if (((HashSet) this.f202950j).size() <= r100) goto L5;
        ((HashSet) this.f202950j).clear();
    L5:
        this.f202949i = r100;
    }

    public final void setTagAdapter(fg4.a<T> r110) {
        this.f202951k = r110;
        ((HashSet) this.f202950j).clear();
        removeAllViews();
        fg4.a<T> r111 = this.f202951k;
        if (r111 == null) goto L35;
        HashSet<Integer> r100 = r111.f476829b;
        List<? extends T> r101 = r111.f476828a;
        if (r101 == null) goto L7;
        int r102 = r101.size();
    L8:
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L30;
        List<? extends T> r104 = r111.f476828a;
        if (r104 == null) goto L13;
        Object r105 = ListProtector.get(r104, r103);
    L14:
        AnchorV3ProductFormatItemView r106 = r111.a(this, r105);
        if (r106 == null) goto L29;
        fg4.c r107 = new fg4.c(getContext());
        r106.setDuplicateParentStateEnabled(true);
        if (r106.getLayoutParams() == null) goto L19;
        r107.setLayoutParams(r106.getLayoutParams());
    L20:
        r106.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r107.addView(r106);
        addView(r107);
        if (r100.contains(Integer.valueOf(r103)) == false) goto L25;
        r107.setChecked(true);
        if (this.f202951k == null) goto L25;
        r107.getTagView();
    L25:
        List<? extends T> r108 = r111.f476828a;
        if (r108 == null) goto L28;
        ListProtector.get(r108, r103);
    L28:
        r106.setClickable(false);
        r107.setOnClickListener(new fg4.b(this, r107, r103));
        goto L29
    L19:
        r107.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
    L29:
        r103 = r103 + 1;
        goto L9
    L13:
        r105 = null;
        goto L14
    L30:
        this.f202950j.addAll(r100);
        return;
    L7:
        r102 = 0;
        goto L8
    }

    @Override // com.bytedance.commerce.uikit.flowlayout.FlowLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L24;
        View r104 = getChildAt(r103);
        if ((r104 instanceof fg4.c) == true) goto L7;
        r104 = null;
    L7:
        fg4.c r105 = (fg4.c) r104;
        if (r105 == null) goto L23;
        if (r105.getVisibility() != 8) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == true) goto L23;
        View r107 = r105.getTagView();
        if (r107 == null) goto L23;
        if (r107.getVisibility() != 8) goto L20;
        boolean r108 = true;
    L21:
        if (r108 != true) goto L23;
        r105.setVisibility(8);
        goto L23
    L20:
        r108 = false;
        goto L21
    L12:
        r106 = false;
    L23:
        r103 = r103 + 1;
        goto L3
    L24:
        super.onMeasure(r100, r101);
    }

    public TagFlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f202950j = new HashSet();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.commerce_fll_max_select, R.attr.commerce_fll_tag_gravity, R.attr.commerce_fll_tag_maxLine, R.attr.commerce_fll_tag_space_horizontal, R.attr.commerce_fll_tag_space_vertical});
        this.f202949i = r103.getInt(0, -1);
        r103.recycle();
    }

    public /* synthetic */ TagFlowLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
