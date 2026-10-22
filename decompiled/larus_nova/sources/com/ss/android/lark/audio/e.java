package com.ss.android.lark.audio;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import com.ss.android.lark.audio.opus.l;
import com.ss.android.lark.log.Log;
import faceverify.w;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SensorManager f408972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile b f408973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f408974c;

    public class a implements SensorEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f408975a;

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor r100, int r101) {
        }

        public a(e r100) {
            this.f408975a = r100;
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent r100) {
            if (r100.sensor.getType() != 8) goto L62;
            float[] r101 = r100.values;
            if (r101 == null) goto L71;
            boolean r102 = false;
            if (r101[0] < r100.sensor.getMaximumRange()) goto L32;
            if (this.f408975a.f408973b == null) goto L63;
            AudioManager r103 = com.ss.android.lark.audio.opus.e.d().f409010d;
            if (r103 == null) goto L15;
            r102 = r103.isWiredHeadsetOn();
        L15:
            if (r102 == false) goto L17;
            Log.i("AudioSensorHandler", "isWiredHeadsetOn");
            return;
        L17:
            com.ss.android.lark.audio.opus.e r104 = com.ss.android.lark.audio.opus.e.d();
            com.ss.android.lark.audio.opus.e.b r105 = r104.c();
            if (r105 == null) goto L22;
            l r106 = r105.f409025a;
            if (r106 == null) goto L22;
            int r107 = r106.f409062a;
        L24:
            if (r107 == 1) goto L65;
            Log.i("AudioSensorHandler", "onFarAwayFromPhone");
            com.ss.android.lark.audio.opus.e r108 = com.ss.android.lark.audio.opus.e.d();
            com.ss.android.lark.audio.opus.e.b r109 = r108.c();
            if (r109 == null) goto L30;
            l r110 = r109.f409025a;
            if (r110 == null) goto L30;
            r110.a(1);
            r108.f409017k = 1;
        L30:
            com.ss.android.lark.audio.opus.e.d().h();
            return;
        L65:
            return;
        L22:
            r107 = r104.f409016j;
            goto L24
        L63:
            return;
        L32:
            if (this.f408975a.f408973b == null) goto L67;
            AudioManager r111 = com.ss.android.lark.audio.opus.e.d().f409010d;
            if (r111 != null) goto L36;
            boolean r112 = false;
        L37:
            if (r112 == false) goto L39;
            Log.i("AudioSensorHandler", "isWiredHeadsetOn");
            return;
        L39:
            com.ss.android.lark.audio.opus.e r113 = com.ss.android.lark.audio.opus.e.d();
            com.ss.android.lark.audio.opus.e.b r114 = r113.c();
            if (r114 == null) goto L44;
            l r115 = r114.f409025a;
            if (r115 == null) goto L44;
            int r116 = r115.f409062a;
        L46:
            if (r116 == 2) goto L69;
            Log.i("AudioSensorHandler", "onCloseToPhone");
            com.ss.android.lark.audio.opus.e r117 = com.ss.android.lark.audio.opus.e.d();
            com.ss.android.lark.audio.opus.e.b r118 = r117.c();
            if (r118 == null) goto L52;
            l r119 = r118.f409025a;
            if (r119 == null) goto L52;
            r119.a(2);
            r117.f409017k = 2;
        L52:
            com.ss.android.lark.audio.opus.e.b r120 = com.ss.android.lark.audio.opus.e.d().c();
            if (r120 == null) goto L59;
            l r121 = r120.f409025a;
            if (r121 == null) goto L59;
            r102 = r121.d();
        L59:
            if (r102 == false) goto L70;
            com.ss.android.lark.audio.opus.e.d().a();
            return;
        L70:
            return;
        L69:
            return;
        L44:
            r116 = r113.f409016j;
            goto L46
        L36:
            r112 = r111.isWiredHeadsetOn();
            goto L37
        L67:
            return;
        L71:
            return;
        }
    }

    public interface b {
    }

    public e(Context r100) {
        this.f408974c = new a(this);
        if (r100 != null) goto L5;
        return;
    L5:
        this.f408972a = (SensorManager) r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
    }
}
