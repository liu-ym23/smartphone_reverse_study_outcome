package androidx.appcompat.graphics.drawable;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class StateListDrawable extends DrawableContainer {
    private static final boolean DEBUG = false;
    private static final String TAG = "StateListDrawable";
    private boolean mMutated;
    private StateListState mStateListState;

    public static class StateListState extends DrawableContainer.DrawableContainerState {
        int[][] mStateSets;

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void mutate() {
            int[][] r0 = this.mStateSets;
            int[][] r1 = new int[r0.length][];
            int r2 = r0.length - 1;
        L3:
            if (r2 < 0) goto L9;
            int[] r3 = this.mStateSets[r2];
            if (r3 == null) goto L7;
            int[] r4 = (int[]) r3.clone();
        L8:
            r1[r2] = r4;
            r2 = r2 - 1;
            goto L3
        L7:
            r4 = null;
            goto L8
        L9:
            this.mStateSets = r1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new StateListDrawable(this, null);
        }

        public int indexOfStateSet(int[] r5) {
            int[][] r0 = this.mStateSets;
            int r1 = getChildCount();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            if (StateSet.stateSetMatches(r0[r2], r5) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r2;
        L8:
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2) {
            return new StateListDrawable(this, r2);
        }

        public int addStateSet(int[] r2, Drawable r3) {
            int r4 = addChild(r3);
            this.mStateSets[r4] = r2;
            return r4;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void growArray(int r3, int r4) {
            super.growArray(r3, r4);
            int[][] r5 = new int[r4][];
            System.arraycopy(this.mStateSets, 0, r5, 0, r3);
            this.mStateSets = r5;
        }

        public StateListState(StateListState r1, StateListDrawable r2, Resources r3) {
            super(r1, r2, r3);
            if (r1 == null) goto L5;
            this.mStateSets = r1.mStateSets;
            return;
        L5:
            this.mStateSets = new int[getCapacity()][];
        }
    }

    public StateListDrawable() {
        this(null, null);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public StateListState cloneConstantState() {
        return new StateListState(this.mStateListState, this, null);
    }

    int getStateCount() {
        return this.mStateListState.getChildCount();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        this.mStateListState.mutate();
        this.mMutated = true;
        goto L7
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    public StateListState getStateListState() {
        return this.mStateListState;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ DrawableContainer.DrawableContainerState cloneConstantState() {
        return cloneConstantState();
    }

    public StateListDrawable(StateListState r1) {
        if (r1 == null) goto L6;
        setConstantState(r1);
        return;
    }

    private void updateStateFromTypedArray(TypedArray r4) {
        StateListState r0 = this.mStateListState;
        r0.mChangingConfigurations |= r4.getChangingConfigurations();
        r0.mVariablePadding = r4.getBoolean(2, r0.mVariablePadding);
        r0.mConstantSize = r4.getBoolean(3, r0.mConstantSize);
        r0.mEnterFadeDuration = r4.getInt(4, r0.mEnterFadeDuration);
        r0.mExitFadeDuration = r4.getInt(5, r0.mExitFadeDuration);
        r0.mDither = r4.getBoolean(0, r0.mDither);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r1) {
        super.applyTheme(r1);
        onStateChange(getState());
    }

    public int[] extractStateSet(AttributeSet r9) {
        int r0 = r9.getAttributeCount();
        int[] r1 = new int[r0];
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r0) goto L17;
        int r5 = r9.getAttributeNameResource(r3);
        if (r5 == 0) goto L15;
        if (r5 == 16842960) goto L15;
        if (r5 == 16843161) goto L15;
        int r6 = r4 + 1;
        if (r9.getAttributeBooleanValue(r3, false) == true) goto L14;
        r5 = -r5;
    L14:
        r1[r4] = r5;
        r4 = r6;
    L15:
        r3 = r3 + 1;
        goto L3
    L17:
        return StateSet.trimStateSet(r1, r4);
    }

    Drawable getStateDrawable(int r2) {
        return this.mStateListState.getChild(r2);
    }

    public int getStateDrawableIndex(int[] r2) {
        return this.mStateListState.indexOfStateSet(r2);
    }

    int[] getStateSet(int r2) {
        return this.mStateListState.mStateSets[r2];
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r3) {
        boolean r0 = super.onStateChange(r3);
        int r4 = this.mStateListState.indexOfStateSet(r3);
        if (r4 >= 0) goto L6;
        r4 = this.mStateListState.indexOfStateSet(StateSet.WILD_CARD);
    L6:
        if (selectDrawable(r4) == true) goto L10;
        if (r0 == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public void setConstantState(DrawableContainer.DrawableContainerState r2) {
        super.setConstantState(r2);
        if ((r2 instanceof StateListState) == false) goto L6;
        this.mStateListState = (StateListState) r2;
        return;
    }

    public StateListDrawable(StateListState r2, Resources r3) {
        setConstantState(new StateListState(r2, this, r3));
        onStateChange(getState());
    }

    public void addState(int[] r2, Drawable r3) {
        if (r3 == null) goto L5;
        this.mStateListState.addStateSet(r2, r3);
        onStateChange(getState());
        return;
    }

    private void inflateChildElements(Context r8, Resources r9, XmlPullParser r10, AttributeSet r11, Resources.Theme r12) throws XmlPullParserException, IOException {
        StateListState r0 = this.mStateListState;
        int r1 = r10.getDepth() + 1;
    L3:
        int r3 = r10.next();
        if (r3 == 1) goto L30;
        int r4 = r10.getDepth();
        if (r4 >= r1) goto L10;
        if (r3 != 3) goto L10;
        return;
    L10:
        if (r3 != 2) goto L3;
        if (r4 > r1) goto L3;
        if (r10.getName().equals("item") == false) goto L3;
        TypedArray r5 = TypedArrayUtils.obtainAttributes(r9, r12, r11, new int[]{R.attr.drawable});
        int r6 = r5.getResourceId(0, -1);
        if (r6 <= 0) goto L19;
        Drawable r7 = ResourceManagerInternal.get().getDrawable(r8, r6);
    L20:
        r5.recycle();
        int[] r13 = extractStateSet(r11);
        if (r7 != null) goto L29;
    L22:
        int r14 = r10.next();
        if (r14 == 4) goto L22;
        if (r14 != 2) goto L28;
        r7 = Drawable.createFromXmlInner(r9, r10, r11, r12);
        goto L29
    L28:
        throw new XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    L29:
        r0.addStateSet(r13, r7);
        goto L3
    L19:
        r7 = null;
        goto L20
    }

    public void inflate(Context r4, Resources r5, XmlPullParser r6, AttributeSet r7, Resources.Theme r8) throws XmlPullParserException, IOException {
        TypedArray r0 = TypedArrayUtils.obtainAttributes(r5, r8, r7, new int[]{R.attr.dither, R.attr.visible, R.attr.variablePadding, R.attr.constantSize, R.attr.enterFadeDuration, R.attr.exitFadeDuration});
        setVisible(r0.getBoolean(1, true), true);
        updateStateFromTypedArray(r0);
        updateDensity(r5);
        r0.recycle();
        inflateChildElements(r4, r5, r6, r7, r8);
        onStateChange(getState());
    }
}
