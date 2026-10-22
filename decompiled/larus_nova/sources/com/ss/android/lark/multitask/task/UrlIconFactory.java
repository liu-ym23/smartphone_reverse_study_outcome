package com.ss.android.lark.multitask.task;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u000b\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0003J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/multitask/task/UrlIconFactory;", "Lcom/ss/android/lark/multitask/task/Task$IconFactory;", "url", "", "<init>", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getUrl", "()Ljava/lang/String;", "createDrawableForTask", "Landroid/graphics/drawable/Drawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "task", "Lcom/ss/android/lark/multitask/task/TaskSnapshot;", "", "imageView", "Landroid/widget/ImageView;", "saveArgs", "writeToParcel", "flags", "", "describeContents", "CREATOR", "multitask_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlIconFactory implements Task.IconFactory {
    public static final a CREATOR = null;
    private final String url;

    public static final class a implements Parcelable.Creator<UrlIconFactory> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UrlIconFactory createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new UrlIconFactory(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final UrlIconFactory[] newArray(int r100) {
            return new UrlIconFactory[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String saveArgs() {
        return this.url;
    }

    public UrlIconFactory(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        String r101 = r100.readString();
        Intrinsics.checkNotNull(r101);
        this(r101);
    }

    public UrlIconFactory(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.url = r100;
    }

    public Drawable createDrawableForTask(Context r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "task");
        return new ColorDrawable(0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.url);
    }

    public void createDrawableForTask(Context r100, d r101, ImageView r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "task");
        Intrinsics.checkNotNullParameter(r102, "imageView");
        ImageLoader.with(r100).load(this.url).asBitmap().into(r102);
    }
}
