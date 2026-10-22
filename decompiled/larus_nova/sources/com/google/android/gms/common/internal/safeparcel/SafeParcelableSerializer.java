package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.common.zzag;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class SafeParcelableSerializer {
    private SafeParcelableSerializer() {
    }

    public static <T extends SafeParcelable> byte[] serializeToBytes(T r100) {
        Parcel r101 = Parcel.obtain();
        r100.writeToParcel(r101, 0);
        byte[] r102 = r101.marshall();
        r101.recycle();
        return r102;
    }

    public static <T extends SafeParcelable> String serializeToString(T r100) {
        return Base64Utils.encodeUrlSafe(serializeToBytes(r100));
    }

    private static byte[] zza(Iterable r100) {
        Parcel r101 = Parcel.obtain();
        r101.writeTypedList(zzag.zzj(r100));     // Catch: Throwable -> L6
        byte[] r102 = r101.marshall();     // Catch: Throwable -> L6
        r101.recycle();
        return r102;
    L6:
        th = move-exception;
        r101.recycle();
        throw th;
    }

    public static <T extends SafeParcelable> T deserializeFromBytes(byte[] r100, Parcelable.Creator<T> r101) {
        Preconditions.checkNotNull(r101);
        Parcel r102 = Parcel.obtain();
        r102.unmarshall(r100, 0, r100.length);
        r102.setDataPosition(0);
        T r103 = r101.createFromParcel(r102);
        r102.recycle();
        return r103;
    }

    public static <T extends SafeParcelable> T deserializeFromString(String r100, Parcelable.Creator<T> r101) {
        return (T) deserializeFromBytes(Base64Utils.decodeUrlSafe(r100), r101);
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBytes(byte[] r100, Parcelable.Creator<T> r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Parcel r102 = Parcel.obtain();
        r102.unmarshall(r100, 0, r100.length);
        r102.setDataPosition(0);
        ArrayList<T> r103 = new ArrayList();     // Catch: Throwable -> L9
        r102.readTypedList(r103, r101);     // Catch: Throwable -> L9
        r102.recycle();
        return r103;
    L9:
        th = move-exception;
        r102.recycle();
        throw th;
    }

    public static <T extends SafeParcelable> T deserializeFromIntentExtra(Intent r100, String r101, Parcelable.Creator<T> r102) {
        byte[] r103 = r100.getByteArrayExtra(r101);
        if (r103 != null) goto L7;
        return null;
    L7:
        return (T) deserializeFromBytes(r103, r102);
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(Bundle r100, String r101, Parcelable.Creator<T> r102) {
        ArrayList r103 = (ArrayList) r100.getSerializable(r101);
        if (r103 != null) goto L6;
        return null;
    L6:
        MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1 r104 = (ArrayList<T>) new ArrayList(r103.size());
        int r105 = r103.size();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104.add(deserializeFromBytes((byte[]) ListProtector.get(r103, r106), r102));
        r106 = r106 + 1;
        goto L7
    L9:
        return r104;
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundleSafe(Bundle r100, String r101, Parcelable.Creator<T> r102) {
        return deserializeIterableFromBytes(r100.getByteArray(r101), r102);
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(Intent r100, String r101, Parcelable.Creator<T> r102) {
        ArrayList r103 = (ArrayList) r100.getSerializableExtra(r101);
        if (r103 != null) goto L6;
        return null;
    L6:
        MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1 r104 = (ArrayList<T>) new ArrayList(r103.size());
        int r105 = r103.size();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104.add(deserializeFromBytes((byte[]) ListProtector.get(r103, r106), r102));
        r106 = r106 + 1;
        goto L7
    L9:
        return r104;
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtraSafe(Intent r100, String r101, Parcelable.Creator<T> r102) {
        return deserializeIterableFromBytes(r100.getByteArrayExtra(r101), r102);
    }

    public static <T extends SafeParcelable> void serializeIterableToBundle(Iterable<T> r100, Bundle r101, String r102) {
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(serializeToBytes(r104.next()));
        goto L4
    L6:
        r101.putSerializable(r102, r103);
    }

    public static <T extends SafeParcelable> void serializeIterableToBundleSafe(Iterable<T> r100, Bundle r101, String r102) {
        r101.putByteArray(r102, zza(r100));
    }

    public static <T extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<T> r100, Intent r101, String r102) {
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(serializeToBytes(r104.next()));
        goto L4
    L6:
        r101.putExtra(r102, r103);
    }

    public static <T extends SafeParcelable> void serializeIterableToIntentExtraSafe(Iterable<T> r100, Intent r101, String r102) {
        r101.putExtra(r102, zza(r100));
    }

    public static <T extends SafeParcelable> void serializeToIntentExtra(T r100, Intent r101, String r102) {
        r101.putExtra(r102, serializeToBytes(r100));
    }
}
