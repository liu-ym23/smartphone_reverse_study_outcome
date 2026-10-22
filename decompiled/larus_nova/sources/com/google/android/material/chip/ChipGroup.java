package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public class ChipGroup extends FlowLayout {
    private int checkedId;
    private final CheckedStateTracker checkedStateTracker;
    private int chipSpacingHorizontal;
    private int chipSpacingVertical;
    private OnCheckedChangeListener onCheckedChangeListener;
    private PassThroughHierarchyChangeListener passThroughListener;
    private boolean protectFromCheckedChange;
    private boolean singleSelection;

    /* JADX INFO: renamed from: com.google.android.material.chip.ChipGroup$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ ChipGroup this$0;

        private CheckedStateTracker(ChipGroup r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ CheckedStateTracker(ChipGroup r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton r100, boolean r101) {
            if (ChipGroup.access$300(this.this$0) == false) goto L5;
            return;
        L5:
            int r102 = r100.getId();
            if (r101 == false) goto L16;
            if (ChipGroup.access$400(this.this$0) != (-1)) goto L10;
        L14:
            ChipGroup.access$700(this.this$0, r102);
            return;
        L10:
            if (ChipGroup.access$400(this.this$0) == r102) goto L14;
            if (ChipGroup.access$500(this.this$0) == false) goto L14;
            ChipGroup r103 = this.this$0;
            ChipGroup.access$600(r103, ChipGroup.access$400(r103), false);
            goto L14
        L16:
            if (ChipGroup.access$400(this.this$0) != r102) goto L20;
            ChipGroup.access$700(this.this$0, -1);
            return;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
        }
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(ChipGroup r100, int r101);
    }

    public class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
        final /* synthetic */ ChipGroup this$0;

        private PassThroughHierarchyChangeListener(ChipGroup r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ PassThroughHierarchyChangeListener(ChipGroup r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static /* synthetic */ ViewGroup.OnHierarchyChangeListener access$202(PassThroughHierarchyChangeListener r100, ViewGroup.OnHierarchyChangeListener r101) {
            r100.onHierarchyChangeListener = r101;
            return r101;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r100, View r101) {
            if (r100 == this.this$0) goto L5;
        L10:
            ViewGroup.OnHierarchyChangeListener r102 = this.onHierarchyChangeListener;
            if (r102 == null) goto L14;
            r102.onChildViewAdded(r100, r101);
            return;
        L14:
            return;
        L5:
            if ((r101 instanceof Chip) == false) goto L10;
            if (r101.getId() != (-1)) goto L9;
            r101.setId(View.generateViewId());
        L9:
            ((Chip) r101).setOnCheckedChangeListenerInternal(ChipGroup.access$800(this.this$0));
            goto L10
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r100, View r101) {
            if (r100 == this.this$0) goto L5;
        L7:
            ViewGroup.OnHierarchyChangeListener r102 = this.onHierarchyChangeListener;
            if (r102 == null) goto L11;
            r102.onChildViewRemoved(r100, r101);
            return;
        L11:
            return;
        L5:
            if ((r101 instanceof Chip) == false) goto L7;
            ((Chip) r101).setOnCheckedChangeListenerInternal(null);
            goto L7
        }
    }

    public void clearCheck() {
        this.protectFromCheckedChange = true;
        int r100 = 0;
    L4:
        if (r100 >= getChildCount()) goto L9;
        View r101 = getChildAt(r100);
        if ((r101 instanceof Chip) == false) goto L8;
        ((Chip) r101).setChecked(false);
    L8:
        r100 = r100 + 1;
        goto L4
    L9:
        this.protectFromCheckedChange = false;
        setCheckedId(-1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public int getCheckedChipId() {
        if (this.singleSelection == true) goto L7;
        return -1;
    L7:
        return this.checkedId;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r100 = this.checkedId;
        if (r100 == (-1)) goto L6;
        setCheckedStateForView(r100, true);
        setCheckedId(this.checkedId);
        return;
    }

    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    public ChipGroup(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ boolean access$300(ChipGroup r100) {
        return r100.protectFromCheckedChange;
    }

    public static /* synthetic */ int access$400(ChipGroup r100) {
        return r100.checkedId;
    }

    public static /* synthetic */ boolean access$500(ChipGroup r100) {
        return r100.singleSelection;
    }

    public static /* synthetic */ CheckedStateTracker access$800(ChipGroup r100) {
        return r100.checkedStateTracker;
    }

    private void setCheckedId(int r100) {
        this.checkedId = r100;
        OnCheckedChangeListener r101 = this.onCheckedChangeListener;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.singleSelection == false) goto L9;
        r101.onCheckedChanged(this, r100);
        return;
    }

    public void check(int r100) {
        int r101 = this.checkedId;
        if (r100 != r101) goto L6;
        return;
    L6:
        if (r101 != (-1)) goto L8;
    L10:
        if (r100 == (-1)) goto L12;
        setCheckedStateForView(r100, true);
    L12:
        setCheckedId(r100);
        return;
    L8:
        if (this.singleSelection == false) goto L10;
        setCheckedStateForView(r101, false);
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        if (super.checkLayoutParams(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof LayoutParams) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public void setChipSpacing(int r100) {
        setChipSpacingHorizontal(r100);
        setChipSpacingVertical(r100);
    }

    public void setChipSpacingHorizontal(int r100) {
        if (this.chipSpacingHorizontal == r100) goto L6;
        this.chipSpacingHorizontal = r100;
        setItemSpacing(r100);
        requestLayout();
        return;
    }

    public void setChipSpacingHorizontalResource(int r100) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(r100));
    }

    public void setChipSpacingResource(int r100) {
        setChipSpacing(getResources().getDimensionPixelOffset(r100));
    }

    public void setChipSpacingVertical(int r100) {
        if (this.chipSpacingVertical == r100) goto L6;
        this.chipSpacingVertical = r100;
        setLineSpacing(r100);
        requestLayout();
        return;
    }

    public void setChipSpacingVerticalResource(int r100) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(r100));
    }

    public void setDividerDrawableHorizontal(Drawable r100) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setDividerDrawableVertical(Drawable r100) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setFlexWrap(int r100) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener r100) {
        this.onCheckedChangeListener = r100;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r100) {
        PassThroughHierarchyChangeListener.access$202(this.passThroughListener, r100);
    }

    public void setShowDividerHorizontal(int r100) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setShowDividerVertical(int r100) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int r100) {
        setSingleLine(getResources().getBoolean(r100));
    }

    public void setSingleSelection(int r100) {
        setSingleSelection(getResources().getBoolean(r100));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new LayoutParams(r100);
    }

    public void setSingleSelection(boolean r100) {
        if (this.singleSelection == r100) goto L6;
        this.singleSelection = r100;
        clearCheck();
        return;
    }

    public ChipGroup(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.chipGroupStyle);
    }

    public static /* synthetic */ void access$700(ChipGroup r100, int r101) {
        r100.setCheckedId(r101);
    }

    private void setCheckedStateForView(int r100, boolean r101) {
        View r102 = findViewById(r100);
        if ((r102 instanceof Chip) == false) goto L6;
        this.protectFromCheckedChange = true;
        ((Chip) r102).setChecked(r101);
        this.protectFromCheckedChange = false;
        return;
    }

    public ChipGroup(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        AnonymousClass1 r100 = null;
        this.checkedStateTracker = new CheckedStateTracker(this, r100);
        this.passThroughListener = new PassThroughHierarchyChangeListener(this, r100);
        this.checkedId = -1;
        this.protectFromCheckedChange = false;
        TypedArray r113 = ThemeEnforcement.obtainStyledAttributes(r110, r111, new int[]{R.attr.checkedChip, R.attr.chipSpacing, R.attr.chipSpacingHorizontal, R.attr.chipSpacingVertical, R.attr.singleLine, R.attr.singleSelection}, r112, R.style.Widget_MaterialComponents_ChipGroup, new int[0]);
        int r114 = r113.getDimensionPixelOffset(1, 0);
        setChipSpacingHorizontal(r113.getDimensionPixelOffset(2, r114));
        setChipSpacingVertical(r113.getDimensionPixelOffset(3, r114));
        setSingleLine(r113.getBoolean(4, false));
        setSingleSelection(r113.getBoolean(5, false));
        int r115 = r113.getResourceId(0, -1);
        if (r115 == (-1)) goto L5;
        this.checkedId = r115;
    L5:
        r113.recycle();
        super.setOnHierarchyChangeListener(this.passThroughListener);
    }

    public static /* synthetic */ void access$600(ChipGroup r100, int r101, boolean r102) {
        r100.setCheckedStateForView(r101, r102);
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if ((r100 instanceof Chip) == false) goto L12;
        Chip r103 = (Chip) r100;
        if (r103.isChecked() == false) goto L12;
        int r104 = this.checkedId;
        if (r104 != (-1)) goto L9;
    L11:
        setCheckedId(r103.getId());
        goto L12
    L9:
        if (this.singleSelection == false) goto L11;
        setCheckedStateForView(r104, false);
    L12:
        super.addView(r100, r101, r102);
    }
}
