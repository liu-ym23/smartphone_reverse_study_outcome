package androidx.appcompat.graphics.drawable;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.compose.material3.MenuKt;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AnimatedStateListDrawableCompat extends StateListDrawable implements TintAwareDrawable {
    private static final String ELEMENT_ITEM = "item";
    private static final String ELEMENT_TRANSITION = "transition";
    private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String LOGTAG = null;
    private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private boolean mMutated;
    private AnimatedStateListState mState;
    private Transition mTransition;
    private int mTransitionFromIndex;
    private int mTransitionToIndex;

    /* JADX INFO: renamed from: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AnimatableTransition extends Transition {
        private final Animatable mA;

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mA.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mA.stop();
        }

        public AnimatableTransition(Animatable r2) {
            super(null);
            this.mA = r2;
        }
    }

    public static class AnimatedStateListState extends StateListDrawable.StateListState {
        private static final long REVERSED_BIT = 4294967296L;
        private static final long REVERSIBLE_FLAG_BIT = 8589934592L;
        SparseArrayCompat<Integer> mStateIds;
        LongSparseArray<Long> mTransitions;

        private static long generateTransitionKey(int r2, int r3) {
            long r0 = ((long) r2) << 32;
            return ((long) r3) | r0;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void mutate() {
            this.mTransitions = this.mTransitions.clone();
            this.mStateIds = this.mStateIds.clone();
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        public int getKeyframeIdAt(int r3) {
            if (r3 >= 0) goto L6;
            return 0;
        L6:
            return ((Integer) this.mStateIds.get(r3, 0)).intValue();
        }

        public int indexOfKeyframe(int[] r1) {
            int r2 = super.indexOfStateSet(r1);
            if (r2 < 0) goto L6;
            return r2;
        L6:
            return super.indexOfStateSet(StateSet.WILD_CARD);
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2) {
            return new AnimatedStateListDrawableCompat(this, r2);
        }

        public int indexOfTransition(int r4, int r5) {
            long r6 = generateTransitionKey(r4, r5);
            return (int) ((Long) this.mTransitions.get(r6, -1L)).longValue();
        }

        public boolean isTransitionReversed(int r4, int r5) {
            long r6 = generateTransitionKey(r4, r5);
            if ((((Long) this.mTransitions.get(r6, -1L)).longValue() & REVERSED_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean transitionHasReversibleFlag(int r4, int r5) {
            long r6 = generateTransitionKey(r4, r5);
            if ((((Long) this.mTransitions.get(r6, -1L)).longValue() & REVERSIBLE_FLAG_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public AnimatedStateListState(AnimatedStateListState r1, AnimatedStateListDrawableCompat r2, Resources r3) {
            super(r1, r2, r3);
            if (r1 == null) goto L5;
            this.mTransitions = r1.mTransitions;
            this.mStateIds = r1.mStateIds;
            return;
        L5:
            this.mTransitions = new LongSparseArray();
            this.mStateIds = new SparseArrayCompat();
        }

        public int addStateSet(int[] r1, Drawable r2, int r3) {
            int r4 = super.addStateSet(r1, r2);
            this.mStateIds.put(r4, Integer.valueOf(r3));
            return r4;
        }

        public int addTransition(int r10, int r11, Drawable r12, boolean r13) {
            int r14 = super.addChild(r12);
            long r0 = generateTransitionKey(r10, r11);
            if (r13 == false) goto L5;
            long r2 = REVERSIBLE_FLAG_BIT;
        L6:
            long r5 = r14;
            this.mTransitions.append(r0, Long.valueOf(r5 | r2));
            if (r13 == false) goto L9;
            this.mTransitions.append(generateTransitionKey(r11, r10), Long.valueOf((REVERSED_BIT | r5) | r2));
        L9:
            return r14;
        L5:
            r2 = 0;
            goto L6
        }
    }

    public static class AnimatedVectorDrawableTransition extends Transition {
        private final AnimatedVectorDrawableCompat mAvd;

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mAvd.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mAvd.stop();
        }

        public AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat r2) {
            super(null);
            this.mAvd = r2;
        }
    }

    public static class AnimationDrawableTransition extends Transition {
        private final ObjectAnimator mAnim;
        private final boolean mHasReversibleFlag;

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void reverse() {
            this.mAnim.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mAnim.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mAnim.cancel();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        public AnimationDrawableTransition(AnimationDrawable r6, boolean r7, boolean r8) {
            super(null);
            int r0 = r6.getNumberOfFrames();
            if (r7 == false) goto L5;
            int r2 = r0 - 1;
        L7:
            if (r7 == false) goto L9;
            int r1 = 0;
        L10:
            FrameInterpolator r4 = new FrameInterpolator(r6, r7);
            ObjectAnimator r9 = ObjectAnimator.ofInt(r6, "currentIndex", new int[]{r2, r1});
            r9.setAutoCancel(true);
            r9.setDuration(r4.getTotalDuration());
            r9.setInterpolator(r4);
            this.mHasReversibleFlag = r8;
            this.mAnim = r9;
            return;
        L9:
            r1 = r0 - 1;
            goto L10
        L5:
            r2 = 0;
            goto L7
        }
    }

    public static class FrameInterpolator implements TimeInterpolator {
        private int[] mFrameTimes;
        private int mFrames;
        private int mTotalDuration;

        public int getTotalDuration() {
            return this.mTotalDuration;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r5) {
            int r6 = (int) ((r5 * this.mTotalDuration) + 0.5f);
            int r0 = this.mFrames;
            int[] r1 = this.mFrameTimes;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L7;
            int r3 = r1[r2];
            if (r6 < r3) goto L7;
            r6 = r6 - r3;
            r2 = r2 + 1;
        L7:
            if (r2 >= r0) goto L9;
            float r7 = r6 / this.mTotalDuration;
        L11:
            return (r2 / r0) + r7;
        L9:
            r7 = MenuKt.ClosedAlphaTarget;
            goto L11
        }

        public FrameInterpolator(AnimationDrawable r1, boolean r2) {
            updateFrames(r1, r2);
        }

        public int updateFrames(AnimationDrawable r6, boolean r7) {
            int r0 = r6.getNumberOfFrames();
            this.mFrames = r0;
            int[] r1 = this.mFrameTimes;
            if (r1 != null) goto L5;
        L6:
            this.mFrameTimes = new int[r0];
        L7:
            int[] r2 = this.mFrameTimes;
            int r3 = 0;
            int r4 = 0;
        L8:
            if (r3 >= r0) goto L13;
            if (r7 == false) goto L11;
            int r5 = (r0 - r3) - 1;
        L12:
            int r8 = r6.getDuration(r5);
            r2[r3] = r8;
            r4 = r4 + r8;
            r3 = r3 + 1;
            goto L8
        L11:
            r5 = r3;
            goto L12
        L13:
            this.mTotalDuration = r4;
            return r4;
        L5:
            if (r1.length >= r0) goto L7;
            goto L6
        }
    }

    public static abstract class Transition {
        private Transition() {
        }

        public boolean canReverse() {
            return false;
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();

        public /* synthetic */ Transition(AnonymousClass1 r1) {
            this();
        }
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    static {
        LOGTAG = "AnimatedStateListDrawableCompat";
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public AnimatedStateListState cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        this.mState.mutate();
        this.mMutated = true;
        goto L7
    }

    private void init() {
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition r0 = this.mTransition;
        if (r0 == null) goto L6;
        r0.stop();
        this.mTransition = null;
        selectDrawable(this.mTransitionToIndex);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ DrawableContainer.DrawableContainerState cloneConstantState() {
        return cloneConstantState();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ StateListDrawable.StateListState cloneConstantState() {
        return cloneConstantState();
    }

    private boolean selectTransition(int r10) {
        Transition r0 = this.mTransition;
        if (r0 != null) goto L5;
        int r2 = getCurrentIndex();
    L15:
        this.mTransition = null;
        this.mTransitionFromIndex = -1;
        this.mTransitionToIndex = -1;
        AnimatedStateListState r1 = this.mState;
        int r3 = r1.getKeyframeIdAt(r2);
        int r4 = r1.getKeyframeIdAt(r10);
        if (r4 == 0) goto L33;
        if (r3 == 0) goto L33;
        int r6 = r1.indexOfTransition(r3, r4);
        if (r6 >= 0) goto L22;
        return false;
    L22:
        boolean r7 = r1.transitionHasReversibleFlag(r3, r4);
        selectDrawable(r6);
        AnimatedVectorDrawableCompat r8 = getCurrent();
        if ((r8 instanceof AnimationDrawable) == false) goto L26;
        AnimationDrawable r9 = (AnimationDrawable) r8;
        Transition r5 = new AnimationDrawableTransition(r9, r1.isTransitionReversed(r3, r4), r7);
    L31:
        r5.start();
        this.mTransition = r5;
        this.mTransitionFromIndex = r2;
        this.mTransitionToIndex = r10;
        return true;
    L26:
        if ((r8 instanceof AnimatedVectorDrawableCompat) == false) goto L29;
        r5 = new AnimatedVectorDrawableTransition(r8);
        goto L31
    L29:
        if ((r8 instanceof Animatable) == false) goto L33;
        r5 = new AnimatableTransition((Animatable) r8);
    L33:
        return false;
    L5:
        if (r10 != this.mTransitionToIndex) goto L8;
        return true;
    L8:
        if (r10 == this.mTransitionFromIndex) goto L10;
    L13:
        r2 = this.mTransitionToIndex;
        r0.stop();
        goto L15
    L10:
        if (r0.canReverse() == false) goto L13;
        r0.reverse();
        this.mTransitionToIndex = this.mTransitionFromIndex;
        this.mTransitionFromIndex = r10;
        return true;
    }

    private void updateStateFromTypedArray(TypedArray r4) {
        AnimatedStateListState r0 = this.mState;
        r0.mChangingConfigurations |= r4.getChangingConfigurations();
        r0.setVariablePadding(r4.getBoolean(2, r0.mVariablePadding));
        r0.setConstantSize(r4.getBoolean(3, r0.mConstantSize));
        r0.setEnterFadeDuration(r4.getInt(4, r0.mEnterFadeDuration));
        r0.setExitFadeDuration(r4.getInt(5, r0.mExitFadeDuration));
        setDither(r4.getBoolean(0, r0.mDither));
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme r1) {
        super.applyTheme(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas r1) {
        super.draw(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect r1) {
        super.getHotspotBounds(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline r1) {
        super.getOutline(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect r1) {
        return super.getPadding(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable r1) {
        super.invalidateDrawable(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int r1) {
        return super.onLayoutDirectionChanged(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r3) {
        int r0 = this.mState.indexOfKeyframe(r3);
        if (r0 != getCurrentIndex()) goto L5;
    L9:
        boolean r1 = false;
    L10:
        Drawable r2 = getCurrent();
        if (r2 != null) goto L13;
        return r1;
    L13:
        return r1 | r2.setState(r3);
    L5:
        if (selectTransition(r0) == false) goto L7;
    L8:
        r1 = true;
        goto L10
    L7:
        if (selectDrawable(r0) == false) goto L9;
        goto L8
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int r1) {
        super.setAlpha(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean r1) {
        super.setAutoMirrored(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter r1) {
        super.setColorFilter(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public void setConstantState(DrawableContainer.DrawableContainerState r2) {
        super.setConstantState(r2);
        if ((r2 instanceof AnimatedStateListState) == false) goto L6;
        this.mState = (AnimatedStateListState) r2;
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean r1) {
        super.setDither(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ void setEnterFadeDuration(int r1) {
        super.setEnterFadeDuration(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ void setExitFadeDuration(int r1) {
        super.setExitFadeDuration(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList r1) {
        super.setTintList(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode r1) {
        super.setTintMode(r1);
    }

    public AnimatedStateListDrawableCompat(AnimatedStateListState r2, Resources r3) {
        super(null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        setConstantState(new AnimatedStateListState(r2, this, r3));
        onStateChange(getState());
        jumpToCurrentState();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable
    public /* bridge */ /* synthetic */ void addState(int[] r1, Drawable r2) {
        super.addState(r1, r2);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float r1, float r2) {
        super.setHotspot(r1, r2);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean setVisible(boolean r3, boolean r4) {
        boolean r0 = super.setVisible(r3, r4);
        Transition r1 = this.mTransition;
        if (r1 == null) goto L9;
        if (r0 == true) goto L6;
        if (r4 == false) goto L9;
    L6:
        if (r3 == false) goto L8;
        r1.start();
        goto L9
    L8:
        jumpToCurrentState();
    L9:
        return r0;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable r1, Runnable r2) {
        super.unscheduleDrawable(r1, r2);
    }

    public static AnimatedStateListDrawableCompat create(Context r5, int r6, Resources.Theme r7) {
        Resources r0 = r5.getResources();     // Catch: Throwable -> L13
        XmlResourceParser r8 = r0.getXml(r6);     // Catch: Throwable -> L13
        AttributeSet r1 = Xml.asAttributeSet(r8);     // Catch: Throwable -> L13
    L3:
        int r2 = r8.next();     // Catch: Throwable -> L13
        if (r2 == 2) goto L8;
        if (r2 != 1) goto L3;
    L8:
        if (r2 != 2) goto L12;
        return createFromXmlInner(r5, r0, r8, r1, r7);
    L12:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L13
    L13:
        return null;
    }

    public void addState(int[] r2, Drawable r3, int r4) {
        if (r3 == null) goto L6;
        this.mState.addStateSet(r2, r3, r4);
        onStateChange(getState());
        return;
    L6:
        throw new IllegalArgumentException("Drawable must not be null");
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        super.scheduleDrawable(r1, r2, r3);
    }

    public <T extends Drawable & Animatable> void addTransition(int r2, int r3, T r4, boolean r5) {
        if (r4 == null) goto L6;
        this.mState.addTransition(r2, r3, r4, r5);
        return;
    L6:
        throw new IllegalArgumentException("Transition drawable must not be null");
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int r1, int r2, int r3, int r4) {
        super.setHotspotBounds(r1, r2, r3, r4);
    }

    public static AnimatedStateListDrawableCompat createFromXmlInner(Context r8, Resources r9, XmlPullParser r10, AttributeSet r11, Resources.Theme r12) throws IOException, XmlPullParserException {
        String r0 = r10.getName();
        if (r0.equals("animated-selector") == false) goto L7;
        AnimatedStateListDrawableCompat r1 = new AnimatedStateListDrawableCompat();
        r1.inflate(r8, r9, r10, r11, r12);
        return r1;
    L7:
        throw new XmlPullParserException(r10.getPositionDescription() + ": invalid animated-selector tag " + r0);
    }

    private void inflateChildElements(Context r6, Resources r7, XmlPullParser r8, AttributeSet r9, Resources.Theme r10) throws XmlPullParserException, IOException {
        int r0 = r8.getDepth() + 1;
    L3:
        int r2 = r8.next();
        if (r2 == 1) goto L20;
        int r3 = r8.getDepth();
        if (r3 >= r0) goto L10;
        if (r2 != 3) goto L10;
        return;
    L10:
        if (r2 != 2) goto L3;
        if (r3 > r0) goto L3;
        if (r8.getName().equals(ELEMENT_ITEM) == true) goto L16;
        if (r8.getName().equals(ELEMENT_TRANSITION) == false) goto L3;
        parseTransition(r6, r7, r8, r9, r10);
        goto L3
    L16:
        parseItem(r6, r7, r8, r9, r10);
        goto L3
    }

    private int parseItem(Context r6, Resources r7, XmlPullParser r8, AttributeSet r9, Resources.Theme r10) throws XmlPullParserException, IOException {
        TypedArray r1 = TypedArrayUtils.obtainAttributes(r7, r10, r9, new int[]{R.attr.id, R.attr.drawable});
        int r2 = r1.getResourceId(0, 0);
        int r3 = r1.getResourceId(1, -1);
        if (r3 <= 0) goto L5;
        Drawable r11 = ResourceManagerInternal.get().getDrawable(r6, r3);
    L6:
        r1.recycle();
        int[] r4 = extractStateSet(r9);
        if (r11 != null) goto L18;
    L8:
        int r12 = r8.next();
        if (r12 == 4) goto L8;
        if (r12 != 2) goto L17;
        if (r8.getName().equals("vector") == false) goto L15;
        r11 = VectorDrawableCompat.createFromXmlInner(r7, r8, r9, r10);
        goto L18
    L15:
        r11 = Drawable.createFromXmlInner(r7, r8, r9, r10);
        goto L18
    L17:
        throw new XmlPullParserException(r8.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    L18:
        if (r11 == null) goto L22;
        return this.mState.addStateSet(r4, r11, r2);
    L22:
        throw new XmlPullParserException(r8.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    L5:
        r11 = null;
        goto L6
    }

    private int parseTransition(Context r10, Resources r11, XmlPullParser r12, AttributeSet r13, Resources.Theme r14) throws XmlPullParserException, IOException {
        TypedArray r1 = TypedArrayUtils.obtainAttributes(r11, r14, r13, new int[]{R.attr.drawable, R.attr.toId, R.attr.fromId, R.attr.reversible});
        int r4 = r1.getResourceId(2, -1);
        int r5 = r1.getResourceId(1, -1);
        int r7 = r1.getResourceId(0, -1);
        if (r7 <= 0) goto L5;
        Drawable r8 = ResourceManagerInternal.get().getDrawable(r10, r7);
    L6:
        boolean r6 = r1.getBoolean(3, false);
        r1.recycle();
        if (r8 != null) goto L18;
    L8:
        int r9 = r12.next();
        if (r9 == 4) goto L8;
        if (r9 != 2) goto L17;
        if (r12.getName().equals("animated-vector") == false) goto L15;
        r8 = AnimatedVectorDrawableCompat.createFromXmlInner(r10, r11, r12, r13, r14);
        goto L18
    L15:
        r8 = Drawable.createFromXmlInner(r11, r12, r13, r14);
        goto L18
    L17:
        throw new XmlPullParserException(r12.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
    L18:
        if (r8 == null) goto L26;
        if (r4 == (-1)) goto L24;
        if (r5 == (-1)) goto L24;
        return this.mState.addTransition(r4, r5, r8, r6);
    L24:
        throw new XmlPullParserException(r12.getPositionDescription() + TRANSITION_MISSING_FROM_TO_ID);
    L26:
        throw new XmlPullParserException(r12.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
    L5:
        r8 = null;
        goto L6
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable
    public void inflate(Context r4, Resources r5, XmlPullParser r6, AttributeSet r7, Resources.Theme r8) throws XmlPullParserException, IOException {
        TypedArray r0 = TypedArrayUtils.obtainAttributes(r5, r8, r7, new int[]{R.attr.dither, R.attr.visible, R.attr.variablePadding, R.attr.constantSize, R.attr.enterFadeDuration, R.attr.exitFadeDuration});
        setVisible(r0.getBoolean(1, true), true);
        updateStateFromTypedArray(r0);
        updateDensity(r5);
        r0.recycle();
        inflateChildElements(r4, r5, r6, r7, r8);
        init();
    }
}
