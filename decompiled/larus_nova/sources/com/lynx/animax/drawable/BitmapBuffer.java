package com.lynx.animax.drawable;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.Build;
import java.util.concurrent.atomic.AtomicReference;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public class BitmapBuffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f380272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HardwareBuffer f380273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<BufferState> f380274c;

    public static final enum BufferState extends Enum<BufferState> {
        public static final BufferState Destroyed = null;
        public static final BufferState NotReady = null;
        public static final BufferState Prepare = null;
        public static final BufferState Ready = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BufferState[] f380275a = null;

        static {
            BufferState r100 = new BufferState("NotReady", 0);
            NotReady = r100;
            BufferState r101 = new BufferState("Prepare", 1);
            Prepare = r101;
            BufferState r102 = new BufferState("Ready", 2);
            Ready = r102;
            BufferState r103 = new BufferState("Destroyed", 3);
            Destroyed = r103;
            f380275a = new BufferState[]{r100, r101, r102, r103};
        }

        public static BufferState[] values() {
            return (BufferState[]) f380275a.clone();
        }

        public static BufferState valueOf(String r100) {
            return (BufferState) a.a(BufferState.class, r100);
        }

        public BufferState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final void a() {
        AtomicReference<BufferState> r100 = this.f380274c;
        BufferState r101 = BufferState.Destroyed;
        BufferState r102 = r100.getAndSet(r101);
        if (r102 != r101) goto L5;
        return;
    L5:
        if (r102 != BufferState.Prepare) goto L8;
        return;
    L8:
        if (this.f380272a.isRecycled() == true) goto L10;
        this.f380272a.recycle();
    L10:
        HardwareBuffer r103 = this.f380273b;
        if (r103 != null) goto L13;
        return;
    L13:
        if (Build.VERSION.SDK_INT < 26) goto L18;
        r103.close();
        return;
    }

    public Bitmap getBitmap() {
        if (this.f380274c.get() != BufferState.Destroyed) goto L7;
        return null;
    L7:
        return this.f380272a;
    }

    public HardwareBuffer getHardwareBuffer() {
        if (this.f380274c.get() != BufferState.Destroyed) goto L7;
        return null;
    L7:
        return this.f380273b;
    }

    public void setState(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 < BufferState.values().length) goto L7;
        return;
    L7:
        if (this.f380274c.getAndSet(BufferState.values()[r100]) != BufferState.Destroyed) goto L11;
        a();
        return;
    }

    public BitmapBuffer(Bitmap r100, HardwareBuffer r101) {
        this.f380274c = new AtomicReference(BufferState.NotReady);
        this.f380272a = r100;
        this.f380273b = r101;
    }
}
