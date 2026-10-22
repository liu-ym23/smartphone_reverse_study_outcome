package com.bytedance.bdlocation.api;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.CellIdentityLte;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public interface IBPEALocal extends IManager {
    void addGpsStatusListener(LocationManager r100, GpsStatus.Listener r101, Object r102);

    void addNmeaListener(LocationManager r100, OnNmeaMessageListener r101, Handler r102, Object r103);

    void bluetoothStartScan(BluetoothLeScanner r100, List<ScanFilter> r101, ScanSettings r102, ScanCallback r103, Object r104);

    BPEACertCheckResult checkAndTranslateCert(Object r100, String r101) throws BDLocationException;

    String getAddress(BluetoothDevice r100, Object r101);

    List<CellInfo> getAllCellInfo(TelephonyManager r100, Object r101);

    String getBSSID(WifiInfo r100, Object r101);

    int getBaseStationId(CdmaCellLocation r100, Object r101);

    int getBaseStationLatitude(CdmaCellLocation r100, Object r101);

    int getBaseStationLongitude(CdmaCellLocation r100, Object r101);

    Object getBpeaCert(String r100);

    String getBpeaToken(Object r100) throws BDLocationException;

    CellLocation getCellLocation(TelephonyManager r100, Object r101);

    int getCid(GsmCellLocation r100, Object r101);

    WifiInfo getConnectionInfo(WifiManager r100, Object r101);

    Sensor getDefaultSensor(SensorManager r100, int r101, Object r102);

    int getLac(GsmCellLocation r100, Object r101);

    Location getLastKnownLocation(LocationManager r100, String r101, Object r102);

    int getNetworkId(CdmaCellLocation r100, Object r101);

    int getPsc(GsmCellLocation r100, Object r101);

    String getSSID(WifiInfo r100, Object r101);

    List<ScanResult> getScanResults(WifiManager r100, Object r101);

    int getSystemId(CdmaCellLocation r100, Object r101);

    int getTac(CellIdentityLte r100, Object r101);

    void registerGnssMeasurementsCallback(LocationManager r100, GnssMeasurementsEvent.Callback r101, Handler r102, Object r103);

    void registerGnssStatusCallback(LocationManager r100, GnssStatus.Callback r101, Object r102);

    void removeNmeaListener(LocationManager r100, OnNmeaMessageListener r101);

    void requestCellInfoUpdate(TelephonyManager r100, Executor r101, TelephonyManager.CellInfoCallback r102, Object r103);

    void requestLocationUpdates(LocationManager r100, String r101, long r102, float r103, LocationListener r104, Looper r105, Object r106) throws BDLocationException;

    void requestSingleUpdate(LocationManager r100, String r101, LocationListener r102, Looper r103, Object r104) throws BDLocationException;

    boolean startDiscovery(BluetoothAdapter r100, Object r101);

    boolean startLeScan(BluetoothAdapter r100, BluetoothAdapter.LeScanCallback r101, Object r102);

    void unregisterGnssMeasurementsCallback(LocationManager r100, GnssMeasurementsEvent.Callback r101, Object r102);

    boolean wifiStartScan(WifiManager r100, Object r101);
}
