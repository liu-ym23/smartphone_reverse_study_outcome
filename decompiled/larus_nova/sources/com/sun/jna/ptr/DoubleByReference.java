package com.sun.jna.ptr;

import androidx.camera.video.AudioStats;
import com.sun.jna.Pointer;

/* JADX INFO: loaded from: classes40.dex */
public class DoubleByReference extends ByReference {
    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("double@0x%x=%s", new Object[]{Long.valueOf(Pointer.nativeValue(getPointer())), Double.valueOf(getValue())});
    }

    public DoubleByReference() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public double getValue() {
        return getPointer().getDouble(0);
    }

    public DoubleByReference(double r100) {
        super(8);
        setValue(r100);
    }

    public void setValue(double r100) {
        getPointer().setDouble(0, r100);
    }
}
