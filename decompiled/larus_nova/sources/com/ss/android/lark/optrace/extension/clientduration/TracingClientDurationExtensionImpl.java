package com.ss.android.lark.optrace.extension.clientduration;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.optrace.extension.TracingExtension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes37.dex */
public class TracingClientDurationExtensionImpl extends TracingClientDurationExtension implements Parcelable {
    public static final Parcelable.Creator<TracingClientDurationExtensionImpl> CREATOR = null;

    public class a implements Parcelable.Creator<TracingClientDurationExtensionImpl> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TracingClientDurationExtensionImpl createFromParcel(Parcel r100) {
            return new TracingClientDurationExtensionImpl(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final TracingClientDurationExtensionImpl[] newArray(int r100) {
            return new TracingClientDurationExtensionImpl[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtension
    public void endAll() {
        Map<String, TracingClientDurationEvent> r100 = this.eventStartMap;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<String> r101 = r100.keySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        String r102 = r101.next();
        Log.d("TracingClientDurationEx", "end key:" + r102);
        end(r102);
        goto L7
    }

    public TracingClientDurationExtensionImpl() {
    }

    public TracingClientDurationExtensionImpl(Parcel r100) {
        HashMap r101 = new HashMap();
        this.eventStartMap = r101;
        r100.readMap(r101, getClass().getClassLoader());
    }

    @Override // com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtension
    public long duration(String r100) {
        TracingClientDurationEvent r101 = this.eventStartMap.get(r100);
        if (r101 != null) goto L7;
        Log.i("TracingClientDurationEx", "this key not start! key=" + r100);
        return -1;
    L7:
        return r101.duration();
    }

    @Override // com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtension
    public long end(String r100) {
        TracingClientDurationEvent r101 = this.eventStartMap.get(r100);
        if (r101 != null) goto L7;
        Log.i("TracingClientDurationEx", "this key not start! key=" + r100);
        return -1;
    L7:
        if (r101.isFinished() == false) goto L9;
        Log.i("TracingClientDurationEx", "this key finished! key=" + r100);
    L11:
        return r101.duration();
    L9:
        r101.finish();
        goto L11
    }

    @Override // com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtension, com.ss.android.lark.optrace.extension.TracingExtension
    public TracingExtension mergeExtension(TracingExtension r100) {
        if (r100 != null) goto L7;
        Log.e("TracingClientDurationEx", "linkExtension is Null !!!");
        return this;
    L7:
        if ((r100 instanceof TracingClientDurationExtension) == true) goto L10;
        Log.e("TracingClientDurationEx", "linkExtension is not clientDurationExtension !!!");
        return this;
    L10:
        Map<String, TracingClientDurationEvent> r101 = ((TracingClientDurationExtension) r100).eventStartMap;
        if (r101.isEmpty() == false) goto L14;
        Log.i("TracingClientDurationEx", "link client duration extension eventStartMap is empty!!");
        return this;
    L14:
        Iterator<String> r102 = r101.keySet().iterator();
    L16:
        if (r102.hasNext() == false) goto L30;
        String r103 = r102.next();
        TracingClientDurationEvent r104 = r101.get(r103);
        if (r104 == null) goto L19;
        if (r104.isFinished() == true) goto L22;
        TracingClientDurationEvent r105 = this.eventStartMap.get(r103);
        if (r105 != null) goto L26;
        this.eventStartMap.put(r103, r104);
        Log.w("TracingClientDurationEx", "add event key = " + r103 + " linkClientDurationEvent:" + r104.toString());
        goto L16
    L26:
        if (r105.isFinished() == false) goto L27;
        Log.i("TracingClientDurationEx", "duplicate key = " + r103 + " finished, not merge!");
        goto L16
    L27:
        Log.e("TracingClientDurationEx", "duplicate key =" + r103 + " not finished!");
        goto L16
    L22:
        Log.d("TracingClientDurationEx", "this key finished, key = " + r103);
        goto L16
    L19:
        Log.e("TracingClientDurationEx", "linkClientDurationEvent is null, key =" + r103);
        goto L16
    L30:
        return this;
    }

    @Override // com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtension
    public void start(String r100) {
        if (this.eventStartMap.containsKey(r100) == false) goto L6;
        Log.w("TracingClientDurationEx", "this key has already started! key = " + r100);
        return;
    L6:
        this.eventStartMap.put(r100, new TracingClientDurationEvent());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeMap(this.eventStartMap);
    }
}
