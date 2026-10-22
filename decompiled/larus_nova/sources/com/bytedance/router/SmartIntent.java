package com.bytedance.router;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.mt.protector.impl.string2number.CastShortProtector;
import java.util.Objects;

/* JADX INFO: loaded from: classes21.dex */
class SmartIntent extends Intent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267525a = 0;

    @Override // android.content.Intent
    public final Uri getData() {
        return super.getData();
    }

    @Override // android.content.Intent
    public final Bundle getExtras() {
        return super.getExtras();
    }

    public SmartIntent(Intent r100) {
        super(r100);
    }

    public static void a(Object r100, Object r101) {
        r100.getClass();
        Objects.toString(r101);
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
        if ((r103 instanceof String) == true) goto L20;
        return ((Boolean) r103).booleanValue();
    L16:
        a(r103, Boolean.valueOf(r101));
        return r101;
    L20:
        return Boolean.parseBoolean((String) r103);
    L12:
        a(r103, Boolean.valueOf(r101));
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
        if ((r103 instanceof String) == true) goto L20;
        return ((Byte) r103).byteValue();
    L16:
        a(r103, Byte.valueOf(r101));
        return r101;
    L20:
        return CastByteProtector.parseByte((String) r103);
    L12:
        a(r103, Byte.valueOf(r101));
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
        if ((r103 instanceof String) == false) goto L20;
        String r104 = (String) r103;
        if (r104.length() == 1) goto L13;
        a(r103, Character.valueOf(r101));
        return r101;
    L13:
        return r104.charAt(0);
    L20:
        return ((Character) r103).charValue();
    L18:
        a(r103, Character.valueOf(r101));
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
        if ((r103 instanceof String) == true) goto L20;
        return ((Double) r103).doubleValue();
    L16:
        a(r103, Double.valueOf(r101));
        return r101;
    L20:
        return CastDoubleProtector.parseDouble((String) r103);
    L12:
        a(r103, Double.valueOf(r101));
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
        if ((r103 instanceof String) == true) goto L20;
        return ((Float) r103).floatValue();
    L16:
        a(r103, Float.valueOf(r101));
        return r101;
    L20:
        return CastFloatProtector.parseFloat((String) r103);
    L12:
        a(r103, Float.valueOf(r101));
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
        if ((r103 instanceof String) == true) goto L20;
        return ((Integer) r103).intValue();
    L16:
        a(r103, Integer.valueOf(r101));
        return r101;
    L20:
        return CastIntegerProtector.parseInt((String) r103);
    L12:
        a(r103, Integer.valueOf(r101));
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
        if ((r103 instanceof String) == true) goto L20;
        return ((Long) r103).longValue();
    L16:
        a(r103, Long.valueOf(r101));
        return r101;
    L20:
        return CastLongProtector.parseLong((String) r103);
    L12:
        a(r103, Long.valueOf(r101));
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
        if ((r103 instanceof String) == true) goto L20;
        return ((Short) r103).shortValue();
    L16:
        a(r103, Short.valueOf(r101));
        return r101;
    L20:
        return Short.valueOf(CastShortProtector.parseShort((String) r103)).shortValue();
    L12:
        a(r103, Short.valueOf(r101));
        return r101;
    }
}
