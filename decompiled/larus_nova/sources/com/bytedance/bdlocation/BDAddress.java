package com.bytedance.bdlocation;

import android.location.Address;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import f06.d;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes9.dex */
public class BDAddress extends Address {
    private float accuracy;
    private double altitude;
    private float horizontalAccuracy;
    private float speed;
    private float verticalAccuracy;

    @Override // android.location.Address
    public String toString() {
        return "BDAddress{speed=" + this.speed + ", accuracy=" + this.accuracy + ", altitude=" + this.altitude + ", verticalAccuracy=" + this.verticalAccuracy + ", horizontalAccuracy=" + this.horizontalAccuracy + ", addr= " + super.toString() + '}';
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public float getHorizontalAccuracy() {
        return this.horizontalAccuracy;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getVerticalAccuracy() {
        return this.verticalAccuracy;
    }

    public BDAddress(Address r100) {
        super(r100.getLocale());
        setFeatureName(r100.getFeatureName());
        int r101 = 0;
    L4:
        if (r101 > r100.getMaxAddressLineIndex()) goto L6;
        setAddressLine(r101, r100.getAddressLine(r101));
        r101 = r101 + 1;
        goto L4
    L6:
        setAdminArea(r100.getAdminArea());
        setSubAdminArea(r100.getSubAdminArea());
        setLocality(r100.getLocality());
        setSubLocality(r100.getSubLocality());
        setThoroughfare(r100.getThoroughfare());
        setSubThoroughfare(r100.getSubThoroughfare());
        setPremises(r100.getPremises());
        setPostalCode(r100.getPostalCode());
        setCountryCode(r100.getCountryCode());
        setCountryName(r100.getCountryName());
        setLatitude(com_bytedance_bdlocation_BDAddress_android_location_Address_getLatitude(r100));
        setLongitude(com_bytedance_bdlocation_BDAddress_android_location_Address_getLongitude(r100));
        setUrl(r100.getUrl());
        setExtras(r100.getExtras());
    }

    private static double com_bytedance_bdlocation_BDAddress_android_location_Address_getLatitude(Address r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(100045);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(100045, "android/location/Address", "getLatitude", r110, r111, ItemStyle.ITEM_STYLE_DOUBLE, r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return ((Double) r106.f474983b).doubleValue();
    L21:
        return r110.getLatitude();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    private static double com_bytedance_bdlocation_BDAddress_android_location_Address_getLongitude(Address r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(100046);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(100046, "android/location/Address", "getLongitude", r110, r111, ItemStyle.ITEM_STYLE_DOUBLE, r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return ((Double) r106.f474983b).doubleValue();
    L21:
        return r110.getLongitude();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public void setAccuracy(float r100) {
        this.accuracy = r100;
    }

    public void setAltitude(double r100) {
        this.altitude = r100;
    }

    public void setHorizontalAccuracy(float r100) {
        this.horizontalAccuracy = r100;
    }

    public void setSpeed(float r100) {
        this.speed = r100;
    }

    public void setVerticalAccuracy(float r100) {
        this.verticalAccuracy = r100;
    }

    public BDAddress(Locale r100) {
        super(r100);
    }
}
