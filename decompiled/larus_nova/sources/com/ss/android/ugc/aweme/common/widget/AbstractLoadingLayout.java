package com.ss.android.ugc.aweme.common.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
public class AbstractLoadingLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f449999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f450000b;

    public interface Listener {
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f450001a;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.f450001a = r100.readInt();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f450001a);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public final void setListener(Listener r100) {
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f450001a = this.f450000b;
        return r100;
    }

    public AbstractLoadingLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        setState(r101.f450001a);
        super.onRestoreInstanceState(r101.getSuperState());
    }

    public final void setState(int r100) {
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L13;
        if (r100 == 3) goto L13;
        if (r100 == 2) goto L13;
        throw new IllegalArgumentException("state must be one of STATE_OK, STATE_LOADING, STATE_EMPTY and STATE_ERROR.");
    L13:
        if (this.f450000b == r100) goto L16;
        this.f450000b = r100;
        return;
    }

    public AbstractLoadingLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public AbstractLoadingLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setState(0);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (r100 == null) goto L11;
        if (r100 == null) goto L11;
        if (r100 == null) goto L11;
        if (getChildCount() > 4) goto L10;
        super.addView(r100, r101, r102);
        this.f449999a = r100;
        return;
    L10:
        throw new IllegalArgumentException("LoadingLayout can only contain one direct custom child.");
    L11:
        super.addView(r100, r101, r102);
    }
}
