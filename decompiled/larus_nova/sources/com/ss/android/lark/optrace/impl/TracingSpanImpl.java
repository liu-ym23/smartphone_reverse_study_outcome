package com.ss.android.lark.optrace.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.optrace.api.TracingCoreSpan;
import com.ss.android.lark.optrace.core.TracingCoreTarget;
import com.ss.android.lark.optrace.core.TracingSpanMemData;
import java.util.HashMap;

/* JADX INFO: loaded from: classes37.dex */
public class TracingSpanImpl extends TracingCoreTarget implements Parcelable {
    public static final Parcelable.Creator<TracingSpanImpl> CREATOR = null;

    public class a implements Parcelable.Creator<TracingSpanImpl> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TracingSpanImpl createFromParcel(Parcel r100) {
            return new TracingSpanImpl(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final TracingSpanImpl[] newArray(int r100) {
            return new TracingSpanImpl[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    public TracingCoreSpan generateSpan() {
        return new TracingSpanImpl(this);
    }

    @Override // com.ss.android.lark.optrace.core.TracingCoreTarget
    public void generateSpanData() {
        this.spanData = new TracingSpanMemData();
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    public TracingCoreSpan subTrace() {
        return new TracingSpanImpl(this);
    }

    public TracingSpanImpl() {
    }

    public TracingSpanImpl(Parcel r100) {
        this.cacheTracingId = r100.readString();
        HashMap r101 = new HashMap();
        this.extensions = r101;
        r100.readMap(r101, getClass().getClassLoader());
    }

    public TracingSpanImpl(TracingCoreSpan r100) {
        super(r100);
    }

    public TracingSpanImpl(String r100) {
        super(r100);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.cacheTracingId);
        r100.writeMap(this.extensions);
    }
}
