package com.bytedance.scene.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes19.dex */
class ActivityStatusRecord implements Parcelable {
    public static final Parcelable.Creator<ActivityStatusRecord> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f268746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f268747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f268748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f268749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f268750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f268751f;

    public static class a implements Parcelable.Creator<ActivityStatusRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityStatusRecord createFromParcel(Parcel r100) {
            return new ActivityStatusRecord(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityStatusRecord[] newArray(int r100) {
            return new ActivityStatusRecord[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ActivityStatusRecord() {
    }

    public ActivityStatusRecord(Parcel r100) {
        this.f268746a = r100.readInt();
        this.f268747b = r100.readInt();
        this.f268748c = r100.readInt();
        this.f268749d = r100.readInt();
        this.f268750e = r100.readInt();
        this.f268751f = r100.readInt();
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f268746a);
        r100.writeInt(this.f268747b);
        r100.writeInt(this.f268748c);
        r100.writeInt(this.f268749d);
        r100.writeInt(this.f268750e);
        r100.writeInt(this.f268751f);
    }
}
