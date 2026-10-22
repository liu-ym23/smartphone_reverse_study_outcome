package com.ss.android.lark.utils;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.mt.protector.impl.string2number.CastShortProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
class EasyIntent extends Intent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f444661a = 0;

    @Override // android.content.Intent
    public final Bundle getExtras() {
        return super.getExtras();
    }

    public EasyIntent(Intent r100) {
        super(r100);
    }

    @Override // android.content.Intent
    public final boolean getBooleanExtra(String r100, boolean r101) {
        Bundle r102 = super.getExtras();
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = r102.get(r100);
        if (r103 != null) goto L9;
        return r101;
    L9:
        if ((r103 instanceof String) == true) goto L22;
        return ((Boolean) r103).booleanValue();
    L17:
        e = move-exception;
        a(r100, r103, "Boolean", Boolean.valueOf(r101), e);
        return r101;
    L22:
        return Boolean.parseBoolean((String) r103);
    L12:
        e = move-exception;
        a(r100, r103, "Boolean", Boolean.valueOf(r101), e);
        return r101;
    }

    @Override // android.content.Intent
    public final byte getByteExtra(String r100, byte r101) {
        Bundle r102 = super.getExtras();
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = r102.get(r100);
        if (r103 != null) goto L9;
        return r101;
    L9:
        if ((r103 instanceof String) == true) goto L22;
        return ((Byte) r103).byteValue();
    L17:
        e = move-exception;
        a(r100, r103, "Byte", Byte.valueOf(r101), e);
        return r101;
    L22:
        return CastByteProtector.parseByte((String) r103);
    L12:
        e = move-exception;
        a(r100, r103, "Byte", Byte.valueOf(r101), e);
        return r101;
    }

    @Override // android.content.Intent
    public final char getCharExtra(String r100, char r101) {
        Bundle r102 = super.getExtras();
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = r102.get(r100);
        if (r103 != null) goto L9;
        return r101;
    L9:
        if ((r103 instanceof String) == false) goto L21;
        String r104 = (String) r103;
        if (r104.length() == 1) goto L13;
        a(r100, r103, "Char", Character.valueOf(r101), null);
        return r101;
    L13:
        return r104.charAt(0);
    L21:
        return ((Character) r103).charValue();
    L18:
        e = move-exception;
        a(r100, r103, "Char", Character.valueOf(r101), e);
        return r101;
    }

    @Override // android.content.Intent
    public final double getDoubleExtra(String r100, double r101) {
        Bundle r102 = super.getExtras();
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = r102.get(r100);
        if (r103 != null) goto L9;
        return r101;
    L9:
        if ((r103 instanceof String) == true) goto L22;
        return ((Double) r103).doubleValue();
    L17:
        e = move-exception;
        a(r100, r103, "Double", Double.valueOf(r101), e);
        return r101;
    L22:
        return CastDoubleProtector.parseDouble((String) r103);
    L12:
        e = move-exception;
        a(r100, r103, "Double", Double.valueOf(r101), e);
        return r101;
    }

    @Override // android.content.Intent
    public final float getFloatExtra(String r100, float r101) {
        Bundle r102 = super.getExtras();
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = r102.get(r100);
        if (r103 != null) goto L9;
        return r101;
    L9:
        if ((r103 instanceof String) == true) goto L22;
        return ((Float) r103).floatValue();
    L17:
        e = move-exception;
        a(r100, r103, "Float", Float.valueOf(r101), e);
        return r101;
    L22:
        return CastFloatProtector.parseFloat((String) r103);
    L12:
        e = move-exception;
        a(r100, r103, "Float", Float.valueOf(r101), e);
        return r101;
    }

    @Override // android.content.Intent
    public final int getIntExtra(String r100, int r101) {
        Bundle r102 = super.getExtras();
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = r102.get(r100);
        if (r103 != null) goto L9;
        return r101;
    L9:
        if ((r103 instanceof String) == true) goto L22;
        return ((Integer) r103).intValue();
    L17:
        e = move-exception;
        a(r100, r103, "Integer", Integer.valueOf(r101), e);
        return r101;
    L22:
        return CastIntegerProtector.parseInt((String) r103);
    L12:
        e = move-exception;
        a(r100, r103, "Integer", Integer.valueOf(r101), e);
        return r101;
    }

    @Override // android.content.Intent
    public final long getLongExtra(String r100, long r101) {
        Bundle r102 = super.getExtras();
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = r102.get(r100);
        if (r103 != null) goto L9;
        return r101;
    L9:
        if ((r103 instanceof String) == true) goto L22;
        return ((Long) r103).longValue();
    L17:
        e = move-exception;
        a(r100, r103, "Long", Long.valueOf(r101), e);
        return r101;
    L22:
        return CastLongProtector.parseLong((String) r103);
    L12:
        e = move-exception;
        a(r100, r103, "Long", Long.valueOf(r101), e);
        return r101;
    }

    @Override // android.content.Intent
    public final short getShortExtra(String r100, short r101) {
        Bundle r102 = super.getExtras();
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = r102.get(r100);
        if (r103 != null) goto L9;
        return r101;
    L9:
        if ((r103 instanceof String) == true) goto L22;
        return ((Short) r103).shortValue();
    L17:
        e = move-exception;
        a(r100, r103, "Short", Short.valueOf(r101), e);
        return r101;
    L22:
        return Short.valueOf(CastShortProtector.parseShort((String) r103)).shortValue();
    L12:
        e = move-exception;
        a(r100, r103, "Short", Short.valueOf(r101), e);
        return r101;
    }

    public static void a(String r100, Object r101, String r102, Object r103, RuntimeException r104) {
        Log.w("EasyIntent", "Key " + r100 + " expected " + r102 + " but value was a " + r101.getClass().getName() + ".  The default value " + r103 + " was returned.");
        if (r104 == null) goto L6;
        Log.w("EasyIntent", "Attempt to cast generated internal exception:", r104);
        return;
    }
}
