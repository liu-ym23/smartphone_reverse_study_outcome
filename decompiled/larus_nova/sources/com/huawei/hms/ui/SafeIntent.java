package com.huawei.hms.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public class SafeIntent extends Intent {
    public static /* synthetic */ Bundle access$000(Intent r100, String r101) {
        return super.getBundleExtra(r101);
    }

    @Override // android.content.Intent
    public String getAction() {
        return super.getAction();
    L4:
        return "";
    }

    @Override // android.content.Intent
    public Bundle getExtras() {
        return super.getExtras();
    L5:
        return new Bundle();
    }

    public SafeIntent(Intent r100) {
        if (r100 != null) goto L4;
        r100 = new Intent();
    L4:
        super(r100);
    }

    @Override // android.content.Intent
    public boolean[] getBooleanArrayExtra(String r100) {
        return super.getBooleanArrayExtra(r100);
    L5:
        return new boolean[0];
    }

    @Override // android.content.Intent
    public Bundle getBundleExtra(String r100) {
        return INVOKESPECIAL_com_huawei_hms_ui_SafeIntent_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(this, r100);
    L5:
        return new Bundle();
    }

    @Override // android.content.Intent
    public byte[] getByteArrayExtra(String r100) {
        return super.getByteArrayExtra(r100);
    L5:
        return new byte[0];
    }

    @Override // android.content.Intent
    public char[] getCharArrayExtra(String r100) {
        return super.getCharArrayExtra(r100);
    L5:
        return new char[0];
    }

    @Override // android.content.Intent
    public CharSequence[] getCharSequenceArrayExtra(String r100) {
        return super.getCharSequenceArrayExtra(r100);
    L5:
        return new CharSequence[0];
    }

    @Override // android.content.Intent
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String r100) {
        return super.getCharSequenceArrayListExtra(r100);
    L5:
        return new ArrayList();
    }

    @Override // android.content.Intent
    public CharSequence getCharSequenceExtra(String r100) {
        return super.getCharSequenceExtra(r100);
    L4:
        return "";
    }

    @Override // android.content.Intent
    public double[] getDoubleArrayExtra(String r100) {
        return super.getDoubleArrayExtra(r100);
    L5:
        return new double[0];
    }

    @Override // android.content.Intent
    public float[] getFloatArrayExtra(String r100) {
        return super.getFloatArrayExtra(r100);
    L5:
        return new float[0];
    }

    @Override // android.content.Intent
    public int[] getIntArrayExtra(String r100) {
        return super.getIntArrayExtra(r100);
    L5:
        return new int[0];
    }

    @Override // android.content.Intent
    public ArrayList<Integer> getIntegerArrayListExtra(String r100) {
        return super.getIntegerArrayListExtra(r100);
    L5:
        return new ArrayList();
    }

    @Override // android.content.Intent
    public long[] getLongArrayExtra(String r100) {
        return super.getLongArrayExtra(r100);
    L5:
        return new long[0];
    }

    @Override // android.content.Intent
    public Parcelable[] getParcelableArrayExtra(String r100) {
        return super.getParcelableArrayExtra(r100);
    L5:
        return new Parcelable[0];
    }

    @Override // android.content.Intent
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String r100) {
        return super.getParcelableArrayListExtra(r100);
    L4:
        return null;
    }

    @Override // android.content.Intent
    public <T extends Parcelable> T getParcelableExtra(String r100) {
        return (T) super.getParcelableExtra(r100);
    L4:
        return null;
    }

    @Override // android.content.Intent
    public Serializable getSerializableExtra(String r100) {
        return super.getSerializableExtra(r100);
    L4:
        return null;
    }

    @Override // android.content.Intent
    public short[] getShortArrayExtra(String r100) {
        return super.getShortArrayExtra(r100);
    L5:
        return new short[0];
    }

    @Override // android.content.Intent
    public String[] getStringArrayExtra(String r100) {
        return super.getStringArrayExtra(r100);
    L5:
        return new String[0];
    }

    @Override // android.content.Intent
    public ArrayList<String> getStringArrayListExtra(String r100) {
        return super.getStringArrayListExtra(r100);
    L5:
        return new ArrayList();
    }

    @Override // android.content.Intent
    public String getStringExtra(String r100) {
        return super.getStringExtra(r100);
    L4:
        return "";
    }

    @Override // android.content.Intent
    public boolean hasExtra(String r100) {
        return super.hasExtra(r100);
    L4:
        return false;
    }

    public static Bundle INVOKESPECIAL_com_huawei_hms_ui_SafeIntent_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(Intent r100, String r101) {
        Bundle r102 = access$000(r100, r101);
        Context r103 = BadParcelableCrashOptimizer.getContext();
        if (r102 == null) goto L6;
        if (r103 == null) goto L6;
        r102.setClassLoader(r103.getClassLoader());
    L6:
        return r102;
    }

    @Override // android.content.Intent
    public boolean getBooleanExtra(String r100, boolean r101) {
        return super.getBooleanExtra(r100, r101);
    L4:
        return r101;
    }

    @Override // android.content.Intent
    public byte getByteExtra(String r100, byte r101) {
        return super.getByteExtra(r100, r101);
    L4:
        return r101;
    }

    @Override // android.content.Intent
    public char getCharExtra(String r100, char r101) {
        return super.getCharExtra(r100, r101);
    L4:
        return r101;
    }

    @Override // android.content.Intent
    public double getDoubleExtra(String r100, double r101) {
        return super.getDoubleExtra(r100, r101);
    L4:
        return r101;
    }

    @Override // android.content.Intent
    public float getFloatExtra(String r100, float r101) {
        return super.getFloatExtra(r100, r101);
    L4:
        return r101;
    }

    @Override // android.content.Intent
    public int getIntExtra(String r100, int r101) {
        return super.getIntExtra(r100, r101);
    L4:
        return r101;
    }

    @Override // android.content.Intent
    public long getLongExtra(String r100, long r101) {
        return super.getLongExtra(r100, r101);
    L4:
        return r101;
    }

    @Override // android.content.Intent
    public short getShortExtra(String r100, short r101) {
        return super.getShortExtra(r100, r101);
    L4:
        return r101;
    }
}
