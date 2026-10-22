package com.ss.android.medialib.qr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.SparseArray;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzer;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.vesdk.VELogUtil;
import el9.a;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class TEHMScanUtil {
    private static final int CODE_TYPE_AZTEC_SCAN = 513;
    private static final int CODE_TYPE_CODABAR = 515;
    private static final int CODE_TYPE_CODE128_CODE = 128;
    private static final int CODE_TYPE_CODE39_CODE = 64;
    private static final int CODE_TYPE_DATA_MATRIX = 256;
    private static final int CODE_TYPE_EAN_13_CODE = 32;
    private static final int CODE_TYPE_EAN_8_CODE = 16;
    private static final int CODE_TYPE_ITF14 = 514;
    private static final int CODE_TYPE_PDF_417 = 512;
    private static final int CODE_TYPE_QRCODE = 1;
    private static final int CODE_TYPE_UPC_A_CODE = 4;
    private static final int CODE_TYPE_UPC_E_CODE = 8;
    private static final int CODE_TYPE_VORTEX_CODE = 2;
    private static final String TAG = null;
    private static volatile TEHMScanUtil sInstance;
    private Context applicationContext;
    private boolean hasPlugin;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        TAG = "TEHMScanUtil";
        sInstance = null;
    }

    public static TEHMScanUtil getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(TEHMScanUtil.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TEHMScanUtil();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TEHMScanUtil.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private boolean getPlugin() {
        INVOKESTATIC_com_ss_android_medialib_qr_TEHMScanUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.hms.ml.scan.HmsScanAnalyzerOptions");     // Catch: ClassNotFoundException -> L5
        VELogUtil.i(TAG, "getInstance real find class!");
        return true;
    L5:
        VELogUtil.e(TAG, "getInstance not find class!");
        return false;
    }

    private TEHMScanUtil() {
        this.applicationContext = null;
        this.hasPlugin = false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_medialib_qr_TEHMScanUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private long convert2VEScanType(int r100) {
        if (r100 != HmsScan.QRCODE_SCAN_TYPE) goto L7;
        return 1;
    L7:
        if (r100 != HmsScan.EAN13_SCAN_TYPE) goto L11;
        return 32;
    L11:
        if (r100 != HmsScan.EAN8_SCAN_TYPE) goto L15;
        return 16;
    L15:
        if (r100 != HmsScan.UPCCODE_A_SCAN_TYPE) goto L19;
        return 4;
    L19:
        if (r100 != HmsScan.UPCCODE_E_SCAN_TYPE) goto L23;
        return 8;
    L23:
        if (r100 != HmsScan.CODE39_SCAN_TYPE) goto L27;
        return 64;
    L27:
        if (r100 != HmsScan.CODE128_SCAN_TYPE) goto L31;
        return 128;
    L31:
        if (r100 != HmsScan.DATAMATRIX_SCAN_TYPE) goto L35;
        return 256;
    L35:
        if (r100 != HmsScan.PDF417_SCAN_TYPE) goto L39;
        return 512;
    L39:
        if (r100 != HmsScan.AZTEC_SCAN_TYPE) goto L43;
        return 513;
    L43:
        if (r100 != HmsScan.ITF14_SCAN_TYPE) goto L47;
        return 514;
    L47:
        if (r100 != HmsScan.CODABAR_SCAN_TYPE) goto L50;
        return 515;
    L50:
        return 0;
    }

    private HmsScanAnalyzerOptions createOptions(long r100) {
        Vector r101 = new Vector();
        if ((r100 & 1) != 1) goto L6;
        r101.add(Integer.valueOf(HmsScan.QRCODE_SCAN_TYPE));
    L6:
        if ((r100 & 4) != 4) goto L9;
        r101.add(Integer.valueOf(HmsScan.UPCCODE_A_SCAN_TYPE));
    L9:
        if ((r100 & 8) != 8) goto L12;
        r101.add(Integer.valueOf(HmsScan.UPCCODE_E_SCAN_TYPE));
    L12:
        if ((r100 & 16) != 16) goto L15;
        r101.add(Integer.valueOf(HmsScan.EAN8_SCAN_TYPE));
    L15:
        if ((r100 & 32) != 32) goto L18;
        r101.add(Integer.valueOf(HmsScan.EAN13_SCAN_TYPE));
    L18:
        if ((r100 & 64) != 64) goto L21;
        r101.add(Integer.valueOf(HmsScan.CODE39_SCAN_TYPE));
    L21:
        if ((r100 & 128) != 128) goto L24;
        r101.add(Integer.valueOf(HmsScan.CODE128_SCAN_TYPE));
    L24:
        if ((r100 & 256) != 256) goto L27;
        r101.add(Integer.valueOf(HmsScan.DATAMATRIX_SCAN_TYPE));
    L27:
        if ((r100 & 512) != 512) goto L30;
        r101.add(Integer.valueOf(HmsScan.PDF417_SCAN_TYPE));
    L30:
        if ((r100 & 513) != 513) goto L33;
        r101.add(Integer.valueOf(HmsScan.AZTEC_SCAN_TYPE));
    L33:
        if ((r100 & 514) != 514) goto L36;
        r101.add(Integer.valueOf(HmsScan.ITF14_SCAN_TYPE));
    L36:
        if ((r100 & 515) != 515) goto L38;
        r101.add(Integer.valueOf(HmsScan.CODABAR_SCAN_TYPE));
    L38:
        int r102 = 1;
        if (r101.size() <= 1) goto L44;
        int[] r103 = new int[r101.size() - 1];
    L42:
        if (r102 >= r101.size()) goto L46;
        r103[r102 - 1] = ((Integer) r101.get(r102)).intValue();
        r102 = r102 + 1;
    L46:
        return new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(((Integer) r101.get(0)).intValue(), r103).setPhotoMode(false).create();
    L44:
        r103 = null;
        goto L46
    }

    public void attachContext(Context r100) {
        this.applicationContext = r100;
    }

    public String[] decode(byte[] r100, int r101, int r102, long r103) {
        if (this.applicationContext != null) goto L6;
        VELogUtil.e(TAG, "applicationContext is null");
        return null;
    L6:
        Bitmap r104 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        r104.copyPixelsFromBuffer(ByteBuffer.wrap(r100));
        HmsScan[] r105 = ScanUtil.decodeWithBitmap(this.applicationContext, r104, createOptions(r103));
        if (r105 != null) goto L9;
    L12:
        return null;
    L9:
        if (r105.length <= 0) goto L12;
        String.format("HMS scan finish. size %d, 0 result %s, 0 zoom %f, type %d", new Object[]{Integer.valueOf(r105.length), r105[0].getOriginalValue(), Double.valueOf(r105[0].getZoomValue()), Integer.valueOf(r105[0].scanType)});
        return new String[]{r105[0].getOriginalValue(), String.valueOf(r105[0].getZoomValue()), String.valueOf(convert2VEScanType(r105[0].scanType))};
    }

    public String[][] decodeMultiCode(byte[] r110, int r111, int r112, long r210) {
        if (this.applicationContext != null) goto L7;
        VELogUtil.e(TAG, "applicationContext is null");
        return null;
    L7:
        if (this.hasPlugin == true) goto L12;
        boolean r100 = getPlugin();
        this.hasPlugin = r100;
        if (r100 == true) goto L12;
        String[][] r101 = (String[][]) Array.newInstance(String.class, new int[]{1, 7});
        r101[0][0] = "";
        String[] r102 = r101[0];
        r102[1] = "";
        r102[2] = "";
        r102[3] = "";
        r102[4] = "";
        r102[5] = "";
        r102[6] = String.valueOf(-112);
        return r101;
    L12:
        Bitmap r103 = Bitmap.createBitmap(r111, r112, Bitmap.Config.ARGB_8888);
        r103.copyPixelsFromBuffer(ByteBuffer.wrap(r110));
        SparseArray r104 = new HmsScanAnalyzer(createOptions(r210)).analyseFrame(MLFrame.fromBitmap(r103));
        if (r104.size() != 0) goto L15;
        return null;
    L15:
        String[][] r105 = (String[][]) Array.newInstance(String.class, new int[]{r104.size(), 7});
        VELogUtil.i(TAG, "HMS scan code num is " + r104.size());
        int r113 = 0;
    L17:
        if (r113 >= r104.size()) goto L23;
        HmsScan r114 = (HmsScan) r104.valueAt(r113);
        VELogUtil.i(TAG, "scanResult is  " + r114);
        if (r114 == null) goto L22;
        String r115 = r114.originalValue;
        int r116 = r114.getScanType();
        Rect r117 = r114.getBorderRect();
        r105[r113][0] = r115;
        r105[r113][1] = String.valueOf(convert2VEScanType(r116));
        r105[r113][2] = String.valueOf(r117.left);
        r105[r113][3] = String.valueOf(r117.top);
        r105[r113][4] = String.valueOf(r117.right);
        r105[r113][5] = String.valueOf(r117.bottom);
        r105[r113][6] = String.valueOf(0);
        convert2VEScanType(r116);
    L22:
        r113 = r113 + 1;
        goto L17
    L23:
        return r105;
    }
}
