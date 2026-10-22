package com.larus.bmhome.chat.outerinput;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes25.dex */
public final class OuterInputEventBus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutableSharedFlow<Integer> f308397a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableSharedFlow<Integer> f308398b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, MutableSharedFlow<OuterInputEvent>> f308399c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, MutableSharedFlow<OuterInputEvent>> f308400d = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020!H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/outerinput/OuterInputEventBus$OuterInputEvent;", "Landroid/os/Parcelable;", "action", "", "x", "", "y", "deltaX", "deltaY", "<init>", "(IFFFF)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAction", "()I", "setAction", "(I)V", "getX", "()F", "setX", "(F)V", "getY", "setY", "getDeltaX", "setDeltaX", "getDeltaY", "setDeltaY", "writeToParcel", "", "flags", "describeContents", "toString", "", "CREATOR", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OuterInputEvent implements Parcelable {
        public static final a CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f308401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f308402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f308403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f308404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f308405e;

        public static final class a implements Parcelable.Creator<OuterInputEvent> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final OuterInputEvent createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                Intrinsics.checkNotNullParameter(r100, "parcel");
                return new OuterInputEvent(r100.readInt(), r100.readFloat(), r100.readFloat(), r100.readFloat(), r100.readFloat());
            }

            @Override // android.os.Parcelable.Creator
            public final OuterInputEvent[] newArray(int r100) {
                return new OuterInputEvent[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "action:" + this.f308401a + ",x:" + this.f308402b + ",y:" + this.f308403c + ",deltaX:" + this.f308404d + ",deltaY:" + this.f308405e;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            r100.writeInt(this.f308401a);
            r100.writeFloat(this.f308402b);
            r100.writeFloat(this.f308403c);
            r100.writeFloat(this.f308404d);
            r100.writeFloat(this.f308405e);
        }

        public OuterInputEvent(int r100, float r101, float r102, float r103, float r104) {
            this.f308401a = r100;
            this.f308402b = r101;
            this.f308403c = r102;
            this.f308404d = r103;
            this.f308405e = r104;
        }
    }

    static {
        BufferOverflow r100 = BufferOverflow.DROP_OLDEST;
        f308397a = SharedFlowKt.MutableSharedFlow$default(1, 0, r100, 2, null);
        f308398b = SharedFlowKt.MutableSharedFlow$default(1, 0, r100, 2, null);
        f308399c = new ConcurrentHashMap();
        f308400d = new ConcurrentHashMap();
    }

    public static MutableSharedFlow a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ConcurrentHashMap<String, MutableSharedFlow<OuterInputEvent>> r101 = f308399c;
        MutableSharedFlow<OuterInputEvent> r102 = r101.get(r100);
        if (r102 != null) goto L6;
        MutableSharedFlow<OuterInputEvent> r103 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        r101.put(r100, r103);
        return r103;
    L6:
        return r102;
    }

    public static MutableSharedFlow b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ConcurrentHashMap<String, MutableSharedFlow<OuterInputEvent>> r101 = f308400d;
        MutableSharedFlow<OuterInputEvent> r102 = r101.get(r100);
        if (r102 != null) goto L6;
        MutableSharedFlow<OuterInputEvent> r103 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        r101.put(r100, r103);
        return r103;
    L6:
        return r102;
    }
}
