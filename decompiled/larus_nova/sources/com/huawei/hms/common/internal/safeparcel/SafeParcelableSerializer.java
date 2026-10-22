package com.huawei.hms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class SafeParcelableSerializer {
    public SafeParcelableSerializer() {
    }

    public static <S extends SafeParcelable> byte[] serializeToBytes(S r100) {
        Parcel r101 = Parcel.obtain();
        if (r100 == null) goto L5;
        r100.writeToParcel(r101, 0);
    L5:
        byte[] r102 = r101.marshall();
        r101.recycle();
        return r102;
    }

    public static <S extends SafeParcelable> String serializeToString(S r100) {
        return Base64Utils.encodeUrlSafe(serializeToBytes(r100));
    }

    public static <S extends SafeParcelable> S deserializeFromBytes(byte[] r100, Parcelable.Creator<S> r101) {
        Preconditions.checkNotNull(r101);
        Parcel r102 = Parcel.obtain();
        r102.unmarshall(r100, 0, r100.length);
        r102.setDataPosition(0);
        S r103 = r101.createFromParcel(r102);
        r102.recycle();
        return r103;
    }

    public static <S extends SafeParcelable> S deserializeFromString(String r100, Parcelable.Creator<S> r101) {
        return (S) deserializeFromBytes(Base64Utils.decodeUrlSafe(r100), r101);
    }

    public static <S extends SafeParcelable> S deserializeFromIntentExtra(Intent r100, String r101, Parcelable.Creator<S> r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        byte[] r103 = r100.getByteArrayExtra(r101);
        if (r103 != null) goto L9;
        return null;
    L9:
        return (S) deserializeFromBytes(r103, r102);
    }

    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromBundle(Bundle r100, String r101, Parcelable.Creator<S> r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r103 = (ArrayList) r100.getSerializable(r101);
        if (r103 != null) goto L8;
        return null;
    L8:
        MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1 r104 = (ArrayList<S>) new ArrayList(r103.size());
        Iterator r105 = r103.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r104.add(deserializeFromBytes((byte[]) r105.next(), r102));
        goto L10
    L12:
        return r104;
    }

    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromIntentExtra(Intent r100, String r101, Parcelable.Creator<S> r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r103 = (ArrayList) r100.getSerializableExtra(r101);
        if (r103 != null) goto L8;
        return null;
    L8:
        MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1 r104 = (ArrayList<S>) new ArrayList(r103.size());
        Iterator r105 = r103.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r104.add(deserializeFromBytes((byte[]) r105.next(), r102));
        goto L10
    L12:
        return r104;
    }

    public static <S extends SafeParcelable> void serializeIterableToBundle(Iterable<S> r100, Bundle r101, String r102) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        ArrayList r103 = new ArrayList();
        Iterator<S> r104 = r100.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        r103.add(serializeToBytes(r104.next()));
        goto L7
    L9:
        r101.putSerializable(r102, r103);
        return;
    L13:
        return;
    }

    public static <S extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<S> r100, Intent r101, String r102) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        ArrayList r103 = new ArrayList();
        Iterator<S> r104 = r100.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        r103.add(serializeToBytes(r104.next()));
        goto L7
    L9:
        r101.putExtra(r102, r103);
        return;
    L13:
        return;
    }

    public static <S extends SafeParcelable> void serializeToIntentExtra(S r100, Intent r101, String r102) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        r101.putExtra(r102, serializeToBytes(r100));
        return;
    L8:
        return;
    }
}
