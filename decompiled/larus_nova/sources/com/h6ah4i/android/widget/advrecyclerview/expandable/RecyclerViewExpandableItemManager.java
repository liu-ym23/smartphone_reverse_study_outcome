package com.h6ah4i.android.widget.advrecyclerview.expandable;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import aw7.f;
import aw7.h;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;

/* JADX INFO: loaded from: classes23.dex */
public final class RecyclerViewExpandableItemManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SavedState f276036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f276037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f276038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f276039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f276040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f276041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f276042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f276043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f276044i;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f276045a;

        public class a implements Parcelable.Creator<SavedState> {
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

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            this.f276045a = r100.createLongArray();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeLongArray(this.f276045a);
        }
    }

    public RecyclerViewExpandableItemManager() {
        this.f276040e = -1;
        this.f276044i = false;
        this.f276039d = new h(this);
    }

    public final void a(RecyclerView r100) {
        h r101 = this.f276039d;
        if (r101 != null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L14;
        if (this.f276037b != null) goto L12;
        this.f276037b = r100;
        r100.addOnItemTouchListener(r101);
        this.f276041f = ViewConfiguration.get(this.f276037b.getContext()).getScaledTouchSlop();
        return;
    L12:
        throw new IllegalStateException("RecyclerView instance has already been set");
    L14:
        throw new IllegalStateException("Accessing released object");
    L5:
        r102 = false;
        goto L6
    }

    public final f b(AbstractExpandableItemAdapter r100) {
        if (r100.hasStableIds() == false) goto L15;
        if (this.f276038c != null) goto L13;
        SavedState r101 = this.f276036a;
        if (r101 == null) goto L9;
        long[] r102 = r101.f276045a;
    L10:
        this.f276036a = null;
        this.f276038c = new f(this, r100, r102);
        return this.f276038c;
    L9:
        r102 = null;
        goto L10
    L13:
        throw new IllegalStateException("already have a wrapped adapter");
    L15:
        throw new IllegalArgumentException("The passed adapter does not support stable IDs");
    }
}
