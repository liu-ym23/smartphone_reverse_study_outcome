package com.ss.android.lark.qrcode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.core.api.BarcodeFormat;
import com.ss.android.lark.biz.core.api.BaseCodeType;
import com.ss.android.lark.biz.core.api.IQRCodeScanResultHandler;
import com.ss.android.lark.biz.core.api.VEBaseScanResult;
import com.ss.android.lark.biz.core.api.VEScanStrategy;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.component.appcontext.model.DynamicPlugins;
import com.ss.android.lark.component.appcontext.model.LarkBuildConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.medialib.model.Enigma;
import com.ss.android.medialib.model.EnigmaResult;
import com.ss.android.medialib.qr.PicScanner;
import com.ss.android.medialib.qr.ScanSettings;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.android.vesdk.VEUtils;
import com.ss.android.vesdk.algorithm.VEBachQRCodeParam;
import com.ss.android.vesdk.algorithm.VEBachQRCodeResult;
import com.ss.android.vesdk.algorithm.VEScanResult;
import com.ss.android.vesdk.algorithm.VEThirdQRCodeDetectParam;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<IQRCodeScanResultHandler> f439058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<IQRCodeScanResultHandler> f439059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public dxa.b f439060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a2c.a f439061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public QRCodeScanFragment f439062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f439063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f439064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f439065h;

    public class a implements PicScanner.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PicScanner f439066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EnigmaResult f439067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f439068c;

        public a(PicScanner r100, EnigmaResult r101, Object r102) {
            this.f439066a = r100;
            this.f439067b = r101;
            this.f439068c = r102;
        }
    }

    public static class b implements com.ss.android.lark.qrcode.ui.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f439069a;

        public b(Bitmap r100) {
            this.f439069a = r100;
        }

        @Override // com.ss.android.lark.qrcode.ui.a.b
        public final int a(PicScanner r100) {
            return r100.start(this.f439069a, new ScanSettings());
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f439070a = null;

        static {
            f439070a = new h();
        }
    }

    public static class d implements com.ss.android.lark.qrcode.ui.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f439071a;

        public d(String r100) {
            this.f439071a = r100;
        }

        @Override // com.ss.android.lark.qrcode.ui.a.b
        public final int a(PicScanner r100) {
            return r100.start(this.f439071a, new ScanSettings());
        }
    }

    private Context getContext() {
        dxa.b r100 = this.f439060c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContext();
    }

    public static boolean k() {
        boolean r100 = z1c.a.f569729a.isFeatureGatingEnable("im.scan_code.multi_code_identification");
        Log.i("QRCodeScanManager", "im.scan_code.multi_code_identification is " + r100);
        if (r100 == true) goto L5;
        return false;
    L5:
        Log.i("QRCodeScanManager", "im.scan_code.multi_code_identification is true");
        LarkBuildConfig r101 = LarkAppContext.inst().buildConfig();
        if (r101.isHWComponentEnabled() == false) goto L10;
        Log.i("QRCodeScanManager", "isHWComponentEnabled is true");
        return true;
    L10:
        if (r101.isPluginEnable(DynamicPlugins.HW) == true) goto L13;
        Log.i("QRCodeScanManager", "MiraModule.isPluginEnable is false");
        return false;
    L13:
        int r102 = vrb.a.f556941a;
        Intrinsics.checkNotNullParameter("com.ss.android.lark.plugin.hw_sdk", "pluginPackageName");
        Log.i("QRCodeScanManager", "MiraModule.isPluginInstalled is false");
        return false;
    }

    public static boolean l() {
        boolean r100 = z1c.a.f569729a.isFeatureGatingEnable("im.scan_code.use_enigma_detect");
        Log.i("QRCodeScanManager", "im.scan_code.use_enigma_detect is " + r100);
        return r100;
    }

    public final VEBachQRCodeParam.Builder j() {
        AtomicBoolean r100 = com.ss.android.lark.videosend.tools.f.f445008a;
        if (com.ss.android.lark.videosend.tools.f.f445012e == false) goto L11;
        if (this.f439065h.booleanValue() == false) goto L7;
        int r101 = UnixStat.PERM_MASK;
    L9:
        return new VEBachQRCodeParam.Builder().setCodeType(r101).setScanMode(VEBachQRCodeParam.VE_SCAN_MODE.PICTURE).setRunSyncMode(true);
    L7:
        r101 = 4093;
        goto L9
    L11:
        if (this.f439065h.booleanValue() == false) goto L13;
        int r102 = 1023;
    L15:
        return new VEBachQRCodeParam.Builder().setCodeType(r102).setScanMode(VEBachQRCodeParam.VE_SCAN_MODE.PICTURE).setRunSyncMode(true);
    L13:
        r102 = 1021;
        goto L15
    }

    public h() {
        ArrayList r100 = new ArrayList();
        this.f439058a = r100;
        ArrayList r101 = new ArrayList();
        this.f439059b = r101;
        this.f439063f = new Handler(Looper.getMainLooper());
        Boolean r102 = Boolean.FALSE;
        this.f439064g = r102;
        this.f439065h = r102;
        VideoTools.checkToInitSDK();
        a2c.a r103 = z1c.a.f569729a;
        this.f439061d = r103;
        if (r103 != null) goto L5;
        Log.e("QRCodeScanManager", "QRCodeModule.getDependency() is null");
        return;
    L5:
        r100.addAll(r103.getQRCodeHandlers());
        this.f439064g = Boolean.valueOf(!m());
        this.f439065h = Boolean.valueOf(r103.isFeatureGatingEnable("lark.im.scan_ve_algorithm.enableVortextCode"));
        r101.addAll(r103.getQRCodeInterceptHandlers());
        r101.addAll(((soc.a) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(soc.a.class)).getInterceptors());
    }

    public static boolean m() {
        if (k() == false) goto L7;
        boolean r100 = z1c.a.f569729a.isFeatureGatingEnable("im.scan_code.use_bach");
        Log.i("QRCodeScanManager", "im.scan_code.use_bach is " + r100);
        if (r100 == false) goto L7;
    L8:
        return true;
    L7:
        if (k() == false) goto L8;
        return false;
    }

    public final void n() {
        Context r100 = getContext();
        if (r100 == null) goto L8;
        Vibrator r101 = (Vibrator) r100.getSystemService("vibrator");
        if (r101 == null) goto L9;
        r101.vibrate(200);
        return;
    L9:
        return;
    }

    public static dxa.g c(com.ss.android.lark.qrcode.ui.a.b r100) {
        Object r101 = new Object();
        PicScanner r102 = new PicScanner();
        EnigmaResult r103 = new EnigmaResult();     // Catch: Throwable -> L34
        r102.setListener(new a(r102, r103, r101));     // Catch: Throwable -> L34
        monitor-enter(r101);     // Catch: InterruptedException -> L31 Throwable -> L34
        int r104 = r100.a(r102);     // Catch: Throwable -> L28
        if (r104 == 0) goto L13;
        Log.w("QRCodeScanManager", "decodeQRCode start failed, startResult = " + r104);     // Catch: Throwable -> L28
        monitor-exit(r101);     // Catch: Throwable -> L28
    L38:
    L10:
        r102.stop();
        r102.release();
        return null;
    L13:
        r101.wait(3000);     // Catch: Throwable -> L28
        monitor-exit(r101);     // Catch: Throwable -> L28
        Enigma[] r105 = r103.getResult();     // Catch: InterruptedException -> L31 Throwable -> L34
        if (r105 == null) goto L38;
        if (r105.length <= 0) goto L38;
        Enigma r106 = r105[0];     // Catch: InterruptedException -> L31 Throwable -> L34
        if (r106 == null) goto L38;
        String r107 = r106.getText();     // Catch: InterruptedException -> L31 Throwable -> L34
        if (r106.getType() != 1) goto L38;
        if (r107 == null) goto L25;
        BarcodeFormat r108 = BarcodeFormat.CODABAR;     // Catch: InterruptedException -> L31 Throwable -> L34
        dxa.g r109 = new dxa.g(r107);     // Catch: InterruptedException -> L31 Throwable -> L34
    L26:
        r102.stop();
        r102.release();
        return r109;
    L25:
        BarcodeFormat r110 = BarcodeFormat.CODABAR;     // Catch: InterruptedException -> L31 Throwable -> L34
        r109 = new dxa.g("");     // Catch: InterruptedException -> L31 Throwable -> L34
    L28:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L31 Throwable -> L34
    L31:
        e = move-exception;
        Log.e("QRCodeScanManager", "Scanning is interrupted", e);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r102.stop();
        r102.release();
        throw th;
    }

    public static dxa.g e(VEBachQRCodeParam r110) {
        long r100 = System.currentTimeMillis();
        List<VEScanResult> r101 = VEUtils.scanPicture(r110);
        if (CollectionUtils.isEmpty(r101) == false) goto L21;
        Log.i("QRCodeScanManager", "scan result is isEmpty");
        return new dxa.g("");
    L21:
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L20
        int r103 = 0;
    L8:
        if (r103 >= r101.size()) goto L14;
        VEBachQRCodeResult r104 = (VEBachQRCodeResult) ListProtector.get(r101, r103);     // Catch: Throwable -> L20
        int r111 = a(r104.getCurrentFrameWidth(), r104.getLocation(), 0, true);     // Catch: Throwable -> L20
        int r112 = a(r104.getCurrentFrameWidth(), r104.getLocation(), 0, false);     // Catch: Throwable -> L20
        int r113 = a(r104.getCurrentFrameHeight(), r104.getLocation(), 1, true);     // Catch: Throwable -> L20
        int r114 = a(r104.getCurrentFrameHeight(), r104.getLocation(), 1, false);     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r104.getResult()) == true) goto L12;
        String r115 = r104.getResult();     // Catch: Throwable -> L20
        r104.getIsFromBach();     // Catch: Throwable -> L20
        r104.getCurrentFrameWidth();     // Catch: Throwable -> L20
        r104.getCurrentFrameHeight();     // Catch: Throwable -> L20
        r104.getCurrentFrame();     // Catch: Throwable -> L20
        r102.add(new dxa.f(r115, r111, r112, r113, r114, r104.getCodeType()));     // Catch: Throwable -> L20
        c2c.a.b(System.currentTimeMillis() - r100, r104);     // Catch: Throwable -> L20
        Log.i("QRCodeScanManager", "res is * ,codeType is " + r104.getCodeType() + " ,left is " + r104.getLeft() + " ,right is " + r104.getRight() + " ,top is " + r104.getTop() + " ,bottom is " + r104.getBottom() + " ,isFromBach is " + r104.getIsFromBach());     // Catch: Throwable -> L20
    L12:
        r103 = r103 + 1;     // Catch: Throwable -> L20
        goto L8
    L14:
        if (CollectionUtils.isEmpty(r102) == true) goto L17;
        dxa.f r105 = (dxa.f) ListProtector.get(r102, 0);     // Catch: Throwable -> L20
        String r106 = r105.f470443a;     // Catch: Throwable -> L20
        f(r105.f470448f);     // Catch: Throwable -> L20
        return new dxa.g(r106, r102);
    L17:
        Log.i("QRCodeScanManager", "scan pic return non-zero code. return default empty value");     // Catch: Throwable -> L20
        return null;
    L25:
        return null;
    }

    public static BarcodeFormat f(int r100) {
        a2c.a r101 = z1c.a.f569729a;
        if (r101 == null) goto L5;
        boolean r102 = r101.isFeatureGatingEnable("im.scan_code.support_code_type_93");
    L7:
        if (r102 == false) goto L31;
        switch(r100) {
            case 1: goto L29;
            case 4: goto L27;
            case 8: goto L25;
            case 16: goto L23;
            case 32: goto L25;
            case 64: goto L21;
            case 128: goto L19;
            case 256: goto L17;
            case 512: goto L15;
            case 1024: goto L13;
            case 2048: goto L11;
            default: goto L9;
        };
    L9:
        return null;
    L11:
        return BarcodeFormat.CODE_ITF;
    L13:
        return BarcodeFormat.CODE_93;
    L15:
        return BarcodeFormat.PDF_417;
    L17:
        return BarcodeFormat.DATA_MATRIX;
    L19:
        return BarcodeFormat.CODE_128;
    L21:
        return BarcodeFormat.CODE_39;
    L23:
        return BarcodeFormat.EAN_8;
    L25:
        return BarcodeFormat.UPC_E;
    L27:
        return BarcodeFormat.UPC_A;
    L29:
        return BarcodeFormat.QR_CODE;
    L31:
        if (r100 == 1) goto L64;
        if (r100 == 4) goto L62;
        if (r100 == 8) goto L60;
        if (r100 == 16) goto L58;
        if (r100 == 32) goto L60;
        if (r100 == 64) goto L56;
        if (r100 == 128) goto L54;
        if (r100 == 256) goto L52;
        if (r100 == 512) goto L50;
        return null;
    L50:
        return BarcodeFormat.PDF_417;
    L52:
        return BarcodeFormat.DATA_MATRIX;
    L54:
        return BarcodeFormat.CODE_128;
    L56:
        return BarcodeFormat.CODE_39;
    L58:
        return BarcodeFormat.EAN_8;
    L60:
        return BarcodeFormat.UPC_E;
    L62:
        return BarcodeFormat.UPC_A;
    L64:
        return BarcodeFormat.QR_CODE;
    L5:
        r102 = false;
        goto L7
    }

    public final VEBachQRCodeParam h(Bitmap r100) {
        AtomicBoolean r101 = com.ss.android.lark.videosend.tools.f.f445008a;
        if (com.ss.android.lark.videosend.tools.f.f445012e == false) goto L7;
        return j().setBitmap(r100).setMultoCode(true).build();
    L7:
        return j().setBitmap(r100).build();
    }

    public final VEBachQRCodeParam i(String r100) {
        AtomicBoolean r101 = com.ss.android.lark.videosend.tools.f.f445008a;
        if (com.ss.android.lark.videosend.tools.f.f445012e == false) goto L7;
        return j().setPicturePath(r100).setMultoCode(true).build();
    L7:
        return j().setPicturePath(r100).build();
    }

    public static ArrayList g(dxa.g r210, Bitmap r211) {
        float r100 = r211.getWidth();
        float r101 = r211.getHeight();
        ArrayList r102 = new ArrayList();
        if (r210 == null) goto L49;
        List<dxa.f> r103 = r210.f470450b;
        if (r103 == null) goto L48;
        Iterator<dxa.f> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L49;
        dxa.f r105 = r104.next();
        String r106 = r105.f470443a;
        float r107 = r105.f470444b / r100;
        float r108 = r105.f470446d / r101;
        float r109 = r105.f470445c / r100;
        float r110 = r105.f470447e / r101;
        int r111 = r105.f470448f;
        if (z1c.a.f569729a.isFeatureGatingEnable("im.scan_code.support_code_type_93") == false) goto L31;
        if (r111 == 4) goto L30;
        if (r111 == 8) goto L30;
        if (r111 == 16) goto L30;
        if (r111 == 32) goto L30;
        if (r111 == 64) goto L30;
        if (r111 == 128) goto L30;
        if (r111 == 512) goto L30;
        if (r111 == 1024) goto L30;
        if (r111 == 2048) goto L30;
        if (r111 == 514) goto L30;
        if (r111 == 515) goto L30;
        BaseCodeType r112 = BaseCodeType.QRCODE;
    L47:
        r102.add(new VEBaseScanResult(r106, r107, r108, r109, r110, r112));
    L30:
        r112 = BaseCodeType.BARCODE;
        goto L47
    L31:
        if (r111 == 4) goto L46;
        if (r111 == 8) goto L46;
        if (r111 == 16) goto L46;
        if (r111 == 32) goto L46;
        if (r111 == 64) goto L46;
        if (r111 == 128) goto L46;
        if (r111 == 512) goto L46;
        if (r111 == 514) goto L46;
        if (r111 == 515) goto L46;
        r112 = BaseCodeType.QRCODE;
    L46:
        r112 = BaseCodeType.BARCODE;
        goto L47
    L48:
        r102.add(new VEBaseScanResult(r210.f470449a, 0.0f, 0.0f, 0.0f, 0.0f, BaseCodeType.QRCODE));
    L49:
        return r102;
    }

    public final void b(IGetDataCallback<dxa.g> r100, String r101) {
        VEBachQRCodeParam r102 = i(r101);
        if (com.ss.android.lark.videosend.tools.f.f445012e == false) goto L5;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new g(this, r102, r100));
        return;
    L5:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new f(this, r102, r100));
    }

    public final dxa.g d(b r110, Bitmap r111, VEScanStrategy r112) {
        if (r112 != VEScanStrategy.HW_SCAN) goto L30;
        if (this.f439064g.booleanValue() == false) goto L30;
        VEThirdQRCodeDetectParam r100 = new VEThirdQRCodeDetectParam();
        if (com.ss.android.lark.videosend.tools.f.f445012e == false) goto L9;
        this.f439065h.booleanValue();
        r100.codeType = UnixStat.PERM_MASK;
    L10:
        ArrayList r101 = new ArrayList();
        if (r111 == null) goto L13;
        r100.bitmap = r111;
    L13:
        r100.isMultiCode = true;
        List<VEScanResult> r102 = VEUtils.scanPicture(r100);
        if (CollectionUtils.isEmpty(r102) == false) goto L16;
        Log.i("QRCodeScanManager", "scan result is isEmpty");
        return new dxa.g("", r101);
    L16:
        int r103 = 0;
    L18:
        if (r103 >= r102.size()) goto L28;
        VEBachQRCodeResult r104 = (VEBachQRCodeResult) ListProtector.get(r102, r103);
        if (r104.getRetCode() >= 0) goto L26;
        if (com.ss.android.lark.videosend.tools.f.f445012e == false) goto L42;
        if (r111 == null) goto L26;
        return e(h(r111));
    L42:
        return c(r110);
    L26:
        String r105 = r104.getResult();
        int r113 = r104.getLeft();
        int r114 = r104.getRight();
        int r115 = r104.getTop();
        int r116 = r104.getBottom();
        r104.getIsFromBach();
        r104.getCurrentFrameWidth();
        r104.getCurrentFrameHeight();
        r104.getCurrentFrame();
        r101.add(new dxa.f(r105, r113, r114, r115, r116, r104.getCodeType()));
        Log.i("QRCodeScanManager", "res is * ,codeType is " + r104.getCodeType() + " ,left is " + r104.getLeft() + " ,right is " + r104.getRight() + " ,top is " + r104.getTop() + " ,bottom is " + r104.getBottom() + " ,isFromBach is " + r104.getIsFromBach());
        r103 = r103 + 1;
        goto L18
    L28:
        return new dxa.g("", r101);
    L9:
        this.f439065h.booleanValue();
        r100.codeType = 1023;
    L30:
        if (com.ss.android.lark.videosend.tools.f.f445012e == false) goto L34;
        return e(h(r111));
    L34:
        return c(r110);
    }

    public static int a(int r100, float[][] r101, int r102, boolean r103) {
        if (r103 == false) goto L4;
        float r104 = Float.MAX_VALUE;
    L5:
        int r105 = r101.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L13;
        float r107 = r101[r106][r102];
        if (r103 == false) goto L10;
        r104 = Math.min(r104, r107);
    L11:
        r106 = r106 + 1;
        goto L6
    L10:
        r104 = Math.max(r104, r107);
        goto L11
    L13:
        return (int) (r104 * r100);
    L4:
        r104 = Float.MIN_VALUE;
        goto L5
    }
}
