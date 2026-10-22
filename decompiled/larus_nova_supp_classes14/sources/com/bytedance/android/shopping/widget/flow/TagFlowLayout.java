package com.bytedance.android.shopping.widget.flow;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TagFlowLayout extends FlowLayout {
    public static final /* synthetic */ int j = 0;
    public final Set<Integer> i;

    public interface a {
    }

    public interface b {
    }

    public el3.a getAdapter() {
        return null;
    }

    public void setOnSelectListener(a r1) {
    }

    public void setOnTagClickListener(b r1) {
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.i);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putParcelable("key_default", super.onSaveInstanceState());
        StringBuilder r1 = new StringBuilder();
        if (((HashSet) this.i).size() <= 0) goto L9;
        Iterator r2 = ((HashSet) this.i).iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.append(((Integer) r2.next()).intValue());
        r1.append("|");
        goto L6
    L8:
        r1.deleteCharAt(r1.length() - 1);
    L9:
        r0.putString("key_choose_pos", r1.toString());
        return r0;
    }

    public List<List<View>> getAllViews() {
        return this.a;
    }

    public List<Integer> getLineHeight() {
        return this.b;
    }

    public TagFlowLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r7) {
        if ((r7 instanceof Bundle) == false) goto L15;
        Bundle r8 = (Bundle) r7;
        String r0 = r8.getString("key_choose_pos");
        if (TextUtils.isEmpty(r0) == true) goto L13;
        String[] r1 = r0.split("\\|");
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L13;
        int r4 = CastIntegerProtector.parseInt(r1[r3]);
        Set<Integer> r5 = this.i;
        HashSet r6 = (HashSet) r5;
        r6.add(Integer.valueOf(r4));
        el3.b r9 = (el3.b) getChildAt(r4);
        if (r9 != null) goto L11;
        r3 = r3 + 1;
        goto L7
    L11:
        r9.setChecked(true);
        r9.getTagView();
        throw null;
    L13:
        super.onRestoreInstanceState(r8.getParcelable("key_default"));
        return;
    L15:
        super.onRestoreInstanceState(r7);
    }

    public void setAdapter(el3.a r1) {
        throw null;
    }

    public void setMaxSelectCount(int r2) {
        if (((HashSet) this.i).size() <= r2) goto L6;
        ((HashSet) this.i).clear();
        return;
    }

    public TagFlowLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // com.bytedance.android.shopping.widget.flow.FlowLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        el3.b r2 = (el3.b) getChildAt(r1);
        if (r2.getVisibility() == 8) goto L10;
        if (r2.getTagView().getVisibility() != 8) goto L10;
        r2.setVisibility(8);
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        super.onMeasure(r6, r7);
    }

    public TagFlowLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.i = new HashSet();
        TypedArray r4 = r1.obtainStyledAttributes(r2, new int[]{2130972716, 2130974465, 2130974469, 2130974473, 2130974476});
        r4.getInt(0, -1);
        r4.recycle();
    }
}
