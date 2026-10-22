package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.apps.framework.comment.view.widget.CommentLoadingLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes14.dex */
public class AbstractLoadingLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f193141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f193142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f193143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f193144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f193145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f193146f;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f193147a;

        public static class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.f193147a = r100.readInt();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f193147a);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public interface a {
        void a(CommentLoadingLayout r100);

        void b(CommentLoadingLayout r100);
    }

    public View a(Context r100, AttributeSet r101, int r102) {
        return null;
    }

    public View b(Context r100, AttributeSet r101, int r102) {
        return null;
    }

    public View c(Context r100) {
        return null;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f193147a = this.f193146f;
        return r100;
    }

    public final int getState() {
        return this.f193146f;
    }

    public AbstractLoadingLayout(Context r100) {
        this(r100, null);
    }

    public final void d(int r100) {
        View r101 = this.f193141a;
        int r102 = 0;
        if (r101 == null) goto L8;
        if (r100 != 0) goto L6;
        int r103 = 0;
    L7:
        r101.setVisibility(r103);
        goto L8
    L6:
        r103 = 4;
    L8:
        View r104 = this.f193142b;
        if (r104 != null) goto L11;
    L15:
        View r105 = this.f193144d;
        if (r105 != null) goto L18;
    L22:
        View r106 = this.f193143c;
        if (r106 != null) goto L25;
        return;
    L25:
        if (r100 == 3) goto L28;
        r102 = 8;
    L28:
        r106.setVisibility(r102);
        return;
    L18:
        if (r100 != 2) goto L20;
        int r107 = 0;
    L21:
        r105.setVisibility(r107);
        goto L22
    L20:
        r107 = 8;
        goto L21
    L11:
        if (r100 != 1) goto L13;
        int r108 = 0;
    L14:
        r104.setVisibility(r108);
        goto L15
    L13:
        r108 = 8;
        goto L14
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        setState(r101.f193147a);
        super.onRestoreInstanceState(r101.getSuperState());
    }

    public final void setListener(a r100) {
        this.f193145e = r100;
    }

    public final void setState(int r100) {
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L13;
        if (r100 == 3) goto L13;
        if (r100 == 2) goto L13;
        throw new IllegalArgumentException("state must be one of STATE_OK, STATE_LOADING, STATE_EMPTY and STATE_ERROR.");
    L13:
        if (this.f193146f == r100) goto L16;
        this.f193146f = r100;
        d(r100);
        return;
    }

    public AbstractLoadingLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public AbstractLoadingLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193146f = -1;
        this.f193142b = c(r100);
        this.f193143c = a(r100, r101, r102);
        this.f193144d = b(r100, r101, r102);
        View r103 = this.f193142b;
        if (r103 == null) goto L5;
        addView(r103);
    L5:
        View r104 = this.f193143c;
        if (r104 == null) goto L8;
        addView(r104);
    L8:
        View r105 = this.f193144d;
        if (r105 == null) goto L11;
        addView(r105);
    L11:
        d(this.f193146f);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        int r103 = 4;
        if (r100 != this.f193142b) goto L5;
    L14:
        super.addView(r100, r101, r102);
    L15:
        View r104 = this.f193141a;
        if (r104 == r100) goto L18;
        return;
    L18:
        if (this.f193146f != 0) goto L20;
        r103 = 0;
    L20:
        r104.setVisibility(r103);
        return;
    L5:
        if (r100 == this.f193143c) goto L14;
        if (r100 == this.f193144d) goto L14;
        if (getChildCount() > 4) goto L13;
        super.addView(r100, r101, r102);
        this.f193141a = r100;
        goto L15
    L13:
        throw new IllegalArgumentException("LoadingLayout can only contain one direct custom child.");
    }
}
