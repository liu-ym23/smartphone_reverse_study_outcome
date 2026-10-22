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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class AbstractLoadingLayout extends FrameLayout {
    public View a;
    public View b;
    public View c;
    public View d;
    public a e;
    public int f;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int a;

        public static class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r2) {
                return new SavedState(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r1) {
                return new SavedState[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r1) {
            super(r1);
            this.a = r1.readInt();
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.a);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public interface a {
        void a(CommentLoadingLayout r1);

        void b(CommentLoadingLayout r1);
    }

    public View a(Context r1, AttributeSet r2, int r3) {
        return null;
    }

    public View b(Context r1, AttributeSet r2, int r3) {
        return null;
    }

    public View c(Context r1) {
        return null;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.a = this.f;
        return r1;
    }

    public final int getState() {
        return this.f;
    }

    public AbstractLoadingLayout(Context r2) {
        this(r2, null);
    }

    public final void d(int r5) {
        View r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L8;
        if (r5 != 0) goto L6;
        int r2 = 0;
    L7:
        r0.setVisibility(r2);
        goto L8
    L6:
        r2 = 4;
    L8:
        View r3 = this.b;
        if (r3 != null) goto L11;
    L15:
        View r4 = this.d;
        if (r4 != null) goto L18;
    L22:
        View r6 = this.c;
        if (r6 != null) goto L25;
        return;
    L25:
        if (r5 == 3) goto L28;
        r1 = 8;
    L28:
        r6.setVisibility(r1);
        return;
    L18:
        if (r5 != 2) goto L20;
        int r7 = 0;
    L21:
        r4.setVisibility(r7);
        goto L22
    L20:
        r7 = 8;
        goto L21
    L11:
        if (r5 != 1) goto L13;
        int r8 = 0;
    L14:
        r3.setVisibility(r8);
        goto L15
    L13:
        r8 = 8;
        goto L14
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        setState(r3.a);
        super.onRestoreInstanceState(r3.getSuperState());
    }

    public final void setListener(a r1) {
        this.e = r1;
    }

    public final void setState(int r2) {
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L13;
        if (r2 == 3) goto L13;
        if (r2 == 2) goto L13;
        throw new IllegalArgumentException("state must be one of STATE_OK, STATE_LOADING, STATE_EMPTY and STATE_ERROR.");
    L13:
        if (this.f == r2) goto L16;
        this.f = r2;
        d(r2);
        return;
    }

    public AbstractLoadingLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public AbstractLoadingLayout(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.f = -1;
        this.b = c(r2);
        this.c = a(r2, r3, r4);
        this.d = b(r2, r3, r4);
        View r5 = this.b;
        if (r5 == null) goto L5;
        addView(r5);
    L5:
        View r6 = this.c;
        if (r6 == null) goto L8;
        addView(r6);
    L8:
        View r7 = this.d;
        if (r7 == null) goto L11;
        addView(r7);
    L11:
        d(this.f);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r3, int r4, ViewGroup.LayoutParams r5) {
        int r1 = 4;
        if (r3 != this.b) goto L5;
    L14:
        super.addView(r3, r4, r5);
    L15:
        View r6 = this.a;
        if (r6 == r3) goto L18;
        return;
    L18:
        if (this.f != 0) goto L20;
        r1 = 0;
    L20:
        r6.setVisibility(r1);
        return;
    L5:
        if (r3 == this.c) goto L14;
        if (r3 == this.d) goto L14;
        if (getChildCount() > 4) goto L13;
        super.addView(r3, r4, r5);
        this.a = r3;
        goto L15
    L13:
        throw new IllegalArgumentException("LoadingLayout can only contain one direct custom child.");
    }
}
