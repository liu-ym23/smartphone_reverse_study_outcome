package com.ss.android.lark.multitask.task;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public class DrawableIconFactory implements Task.IconFactory {
    public static final Parcelable.Creator<DrawableIconFactory> CREATOR = null;
    private static final String TAG = "MULTITASK-DrawableIconFactory";

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f432835id;
    private String name;

    public class a implements Parcelable.Creator<DrawableIconFactory> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DrawableIconFactory createFromParcel(Parcel r100) {
            return new DrawableIconFactory(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DrawableIconFactory[] newArray(int r100) {
            return new DrawableIconFactory[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "DrawableIconFactory{id=" + this.f432835id + ", name='" + this.name + "'}";
    }

    public String getName() {
        return this.name;
    }

    public String saveArgs() {
        return this.name;
    }

    public DrawableIconFactory(Parcel r100) {
        this.f432835id = r100.readInt();
        this.name = r100.readString();
    }

    public DrawableIconFactory(int r100) {
        this(r100, null);
    }

    public DrawableIconFactory(String r100) {
        this(0, r100);
    }

    public DrawableIconFactory(int r100, String r101) {
        this.f432835id = r100;
        this.name = r101;
    }

    public Drawable createDrawableForTask(Context r100, d r101) {
        if (this.name != null) goto L11;
        return ContextCompat.getDrawable(r100, this.f432835id);
    L11:
        return ContextCompat.getDrawable(r100, r100.getResources().getIdentifier(this.name, "drawable", r100.getPackageName()));
    L9:
        Log.w(TAG, "createDrawableForTask failed, name = " + this.name);
        return new ColorDrawable(0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f432835id);
        r100.writeString(this.name);
    }

    public void createDrawableForTask(Context r100, d r101, ImageView r102) {
        r102.setImageDrawable(createDrawableForTask(r100, r101));
    }
}
