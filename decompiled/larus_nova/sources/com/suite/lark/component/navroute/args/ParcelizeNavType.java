package com.suite.lark.component.navroute.args;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/suite/lark/component/navroute/args/ParcelizeNavType;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "Landroidx/navigation/NavType;", "<init>", "()V", MonitorConstants.CONNECT_TYPE_GET, "bundle", "Landroid/os/Bundle;", "key", "", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "parseValue", "value", "(Ljava/lang/String;)Landroid/os/Parcelable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Parcelable;)V", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ParcelizeNavType<T extends Parcelable> extends NavType<T> {
    public ParcelizeNavType() {
        super(false);
    }

    @Override // androidx.navigation.NavType
    public final Object parseValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // androidx.navigation.NavType
    public final Object get(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getParcelable(r101);
    }

    @Override // androidx.navigation.NavType
    public final void put(Bundle r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        Intrinsics.checkNotNullParameter(r101, "key");
        r100.putParcelable(r101, (Parcelable) r102);
    }
}
