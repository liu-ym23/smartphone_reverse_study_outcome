package com.ss.android.lark.forwardv3.forward.imageforward;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/forwardv3/forward/imageforward/ImageForwardContent;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "imageSource", "", "getImageSource$annotations", "getImageSource", "()I", "setImageSource", "(I)V", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageForwardContent implements IForwardContent {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f425357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<String> f425358b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<String> f425359a;

        public final ImageForwardContent a() {
            ImageForwardContent r100 = new ImageForwardContent();
            r100.f425357a = 0;
            ArrayList<String> r101 = this.f425359a;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f425358b = r101;
            return r100;
        }

        public a() {
            this.f425359a = new ArrayList();
        }
    }

    public static final class b implements Parcelable.Creator<ImageForwardContent> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImageForwardContent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ImageForwardContent r101 = new ImageForwardContent();
            r101.f425357a = r100.readInt();
            r100.readStringList(r101.f425358b);
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ImageForwardContent[] newArray(int r100) {
            return new ImageForwardContent[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ImageForwardContent() {
        this.f425358b = new ArrayList();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f425357a);
        r100.writeStringList(this.f425358b);
    }
}
