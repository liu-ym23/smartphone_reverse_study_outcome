package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public class WebServerPic {
    public static final Parcelable.Creator<WebServerPic> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f277130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f277131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f277132c;

    static {
        CREATOR = new WebServerPicCreator();
    }

    public final String toString() {
        return String.format(Locale.ENGLISH, "Image %dx%d %s", new Object[]{Integer.valueOf(this.f277131b), Integer.valueOf(this.f277132c), this.f277130a.toString()});
    }

    public final int getHeight() {
        return this.f277132c;
    }

    public final Uri getUrl() {
        return this.f277130a;
    }

    public final int getWidth() {
        return this.f277131b;
    }

    public WebServerPic(Uri r100) throws IllegalArgumentException {
        this(r100, 0, 0);
    }

    public final void writeToParcel(Parcel r100, int r101) {
        Preconditions.checkNotNull(r100);
        int r102 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeParcelable(r100, 1, getUrl(), r101, false);
        SafeParcelWriter.writeInt(r100, 2, getWidth());
        SafeParcelWriter.writeInt(r100, 3, getHeight());
        SafeParcelWriter.finishObjectHeader(r100, r102);
    }

    public WebServerPic(Uri r100, int r101, int r102) throws IllegalArgumentException {
        this.f277130a = r100;
        this.f277131b = r101;
        this.f277132c = r102;
        if (r100 == null) goto L10;
        if (r101 < 0) goto L8;
        if (r102 < 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("width and height should be positive or 0");
    L10:
        throw new IllegalArgumentException("url is not able to be null");
    }
}
