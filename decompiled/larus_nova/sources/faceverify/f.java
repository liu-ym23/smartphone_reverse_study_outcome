package faceverify;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.alipay.zoloz.toyger.blob.FaceDataFrameInfo;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.model.Meta;
import com.dtf.toyger.base.HandlerThreadPool;
import com.dtf.toyger.base.algorithm.TGFrame;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class f {
    public static int a(byte r100) {
        int r101 = (r100 >> 4) & 15;
        int r102 = r101 * 16;
        return r102 + (r100 & 15);
    }

    public static String a(int r100) {
        switch(r100) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L3;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            case 8: goto L4;
            default: goto L3;
        };
    L3:
        return "null";
    L4:
        return "equipment";
    L5:
        return "nearFar";
    L6:
        return q.KEY_PHOTINUS_CONFIG;
    L7:
        return "lipMovement";
    L8:
        return "headRight";
    L9:
        return "headLeft";
    L10:
        return IPerformanceManager.MODULE_BLINK;
    L11:
        return "noLiveness";
    }

    public static void a(Meta r100, ns7.a r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.collectInfo == null) goto L12;
        List<Pair<String, String>> r102 = r101.f520326g;
        if (r102 == null) goto L12;
        Iterator<Pair<String, String>> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L12;
        Pair<String, String> r104 = r103.next();
        Map<String, Object> r105 = r100.collectInfo;
        Object r106 = r104.first;
        String r107 = (String) r106;
        r105.put(r107, r104.second);
    L12:
        if (TextUtils.isEmpty(r101.f520331l) == true) goto L17;
        r100.collectInfoSig = r101.f520331l;
        return;
    }

    public static void b(Meta r100, ns7.a r101) {
        if (r100 == null) goto L10;
        String r102 = r101.f520327h;
        String r103 = r101.f520328i;
        Map<String, Object> r104 = r100.collectInfo;
        if (r104 == null) goto L11;
        if (r102 == null) goto L7;
        r104.put("photinusMetadataFileId", r102);
    L7:
        if (r103 == null) goto L12;
        r100.collectInfo.put("photinusVideoFileId", r103);
        return;
    L12:
        return;
    L11:
        return;
    }

    public static Bitmap a(Bitmap r100, int r101) {
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        float r104 = r101 / r102;
        Matrix r105 = new Matrix();
        r105.postScale(r104, r104);
        Bitmap r106 = Bitmap.createBitmap(r100, 0, 0, r102, r103, r105, true);
        if (r106 == r100) goto L5;
        r100.recycle();
    L5:
        return r106;
    }

    public static void a(Map<String, Object> r100, ns7.a r101) {
        List<String> r102 = r101.f520341v;
        if (r102 == null) goto L5;
        r100.put("chameleonFrameFile", r102);
    L6:
        String r103 = r101.f520342w;
        if (r103 == null) goto L9;
        r100.put("chameleonMetaInfo", r103);
        return;
    L9:
        r100.remove("chameleonMetaInfo");
        return;
    L5:
        r100.remove("chameleonFrameFile");
        goto L6
    }

    public static Bitmap a(Bitmap r310, int r311, boolean r312) {
        int r100 = r311;
        if (r312 == false) goto L5;
        Bitmap r101 = r310;
    L6:
        if (r100 >= 1) goto L9;
        return null;
    L9:
        int r110 = r101.getWidth();
        int r111 = r101.getHeight();
        int r112 = r110 * r111;
        int[] r113 = new int[r112];
        r101.getPixels(r113, 0, r110, 0, 0, r110, r111);
        int r102 = r110 - 1;
        int r103 = r111 - 1;
        int r104 = (r100 + r100) + 1;
        int[] r105 = new int[r112];
        int[] r106 = new int[r112];
        int[] r107 = new int[r112];
        int[] r108 = new int[Math.max(r110, r111)];
        int r114 = (r104 + 1) >> 1;
        int r115 = r114 * r114;
        int r116 = r115 * 256;
        int[] r117 = new int[r116];
        int r109 = 0;
    L10:
        if (r109 >= r116) goto L12;
        r117[r109] = r109 / r115;
        r109 = r109 + 1;
        goto L10
    L12:
        int[][] r118 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r104, 3});
        int r119 = r100 + 1;
        int r120 = 0;
        int r121 = 0;
        int r122 = 0;
    L13:
        if (r120 >= r111) goto L30;
        Bitmap r123 = r101;
        int r210 = r111;
        int r211 = 0;
        int r212 = 0;
        int r213 = 0;
        int r214 = 0;
        int r215 = 0;
        int r216 = 0;
        int r217 = 0;
        int r218 = 0;
        int r124 = -r100;
        int r125 = 0;
    L16:
        if (r124 > r100) goto L22;
        int r313 = r103;
        int[] r314 = r108;
        int r126 = r113[r121 + Math.min(r102, Math.max(r124, 0))];
        int[] r315 = r118[r124 + r100];
        r315[0] = (r126 & 16711680) >> 16;
        r315[1] = (r126 & 65280) >> 8;
        r315[2] = r126 & 255;
        int r127 = r119 - Math.abs(r124);
        int r316 = r315[0];
        r212 = r212 + (r316 * r127);
        int r128 = r315[1];
        r211 = r211 + (r128 * r127);
        int r317 = r315[2];
        r125 = r125 + (r127 * r317);
        if (r124 <= 0) goto L20;
        r218 = r218 + r316;
        r217 = r217 + r128;
        r216 = r216 + r317;
    L21:
        r124 = r124 + 1;
        r103 = r313;
        r108 = r314;
        goto L16
    L20:
        r215 = r215 + r316;
        r214 = r214 + r128;
        r213 = r213 + r317;
        goto L21
    L22:
        int r318 = r103;
        int[] r319 = r108;
        int r129 = r100;
        int r130 = r125;
        int r131 = 0;
    L23:
        if (r131 >= r110) goto L29;
        r105[r121] = r117[r212];
        r106[r121] = r117[r211];
        r107[r121] = r117[r130];
        int r219 = r212 - r215;
        int r220 = r211 - r214;
        int r132 = r130 - r213;
        int[] r133 = r118[((r129 - r100) + r104) % r104];
        int r221 = r215 - r133[0];
        int r222 = r214 - r133[1];
        int r223 = r213 - r133[2];
        if (r120 != 0) goto L28;
        r319[r131] = Math.min((r131 + r100) + 1, r102);
    L28:
        int r134 = r113[r122 + r319[r131]];
        int r320 = (r134 & 16711680) >> 16;
        r133[0] = r320;
        int r321 = (r134 & 65280) >> 8;
        r133[1] = r321;
        int r135 = r134 & 255;
        r133[2] = r135;
        int r224 = r218 + r320;
        int r225 = r217 + r321;
        int r226 = r216 + r135;
        r212 = r219 + r224;
        r211 = r220 + r225;
        r130 = r132 + r226;
        r129 = (r129 + 1) % r104;
        int[] r136 = r118[r129 % r104];
        int r322 = r136[0];
        r215 = r221 + r322;
        int r323 = r136[1];
        r214 = r222 + r323;
        int r137 = r136[2];
        r213 = r223 + r137;
        r218 = r224 - r322;
        r217 = r225 - r323;
        r216 = r226 - r137;
        r121 = r121 + 1;
        r131 = r131 + 1;
        r117 = r117;
        goto L23
    L29:
        r122 = r122 + r110;
        r120 = r120 + 1;
        r101 = r123;
        r111 = r210;
        r103 = r318;
        r108 = r319;
        goto L13
    L30:
        Bitmap r138 = r101;
        int r324 = r103;
        int[] r325 = r108;
        int r227 = r111;
        int[] r326 = r117;
        int r139 = 0;
    L31:
        if (r139 >= r110) goto L49;
        int r140 = -r100;
        int r228 = r104;
        int[] r229 = r113;
        int r141 = 0;
        int r142 = 0;
        int r143 = 0;
        int r144 = 0;
        int r145 = 0;
        int r146 = 0;
        int r230 = 0;
        int r147 = r140;
        int r148 = r140 * r110;
        int r149 = 0;
        int r150 = 0;
    L33:
        if (r147 > r100) goto L42;
        int r231 = r110;
        int r232 = Math.max(0, r148) + r139;
        int[] r233 = r118[r147 + r100];
        r233[0] = r105[r232];
        r233[1] = r106[r232];
        r233[2] = r107[r232];
        int r151 = r119 - Math.abs(r147);
        r141 = r141 + (r105[r232] * r151);
        r150 = r150 + (r106[r232] * r151);
        r149 = r149 + (r107[r232] * r151);
        if (r147 <= 0) goto L37;
        r230 = r230 + r233[0];
        r146 = r146 + r233[1];
        r145 = r145 + r233[2];
    L38:
        int r152 = r324;
        if (r147 >= r152) goto L41;
        r148 = r148 + r231;
    L41:
        r147 = r147 + 1;
        r324 = r152;
        r110 = r231;
        goto L33
    L37:
        r144 = r144 + r233[0];
        r143 = r143 + r233[1];
        r142 = r142 + r233[2];
        goto L38
    L42:
        int r234 = r110;
        int r153 = r324;
        int r235 = r100;
        int r236 = r139;
        int r154 = r227;
        int r155 = 0;
    L43:
        if (r155 >= r154) goto L48;
        r229[r236] = (((r229[r236] & (-16777216)) | (r326[r141] << 16)) | (r326[r150] << 8)) | r326[r149];
        int r156 = r141 - r144;
        int r157 = r150 - r143;
        int r158 = r149 - r142;
        int[] r237 = r118[((r235 - r100) + r228) % r228];
        int r159 = r144 - r237[0];
        int r160 = r143 - r237[1];
        int r161 = r142 - r237[2];
        if (r139 != 0) goto L47;
        r325[r155] = Math.min(r155 + r119, r153) * r234;
    L47:
        int r162 = r325[r155] + r139;
        int r238 = r105[r162];
        r237[0] = r238;
        int r239 = r106[r162];
        r237[1] = r239;
        int r163 = r107[r162];
        r237[2] = r163;
        int r240 = r230 + r238;
        int r164 = r146 + r239;
        int r165 = r145 + r163;
        r141 = r156 + r240;
        r150 = r157 + r164;
        r149 = r158 + r165;
        r235 = (r235 + 1) % r228;
        int[] r166 = r118[r235];
        int r241 = r166[0];
        r144 = r159 + r241;
        int r242 = r166[1];
        r143 = r160 + r242;
        int r167 = r166[2];
        r142 = r161 + r167;
        r230 = r240 - r241;
        r146 = r164 - r242;
        r145 = r165 - r167;
        r236 = r236 + r234;
        r155 = r155 + 1;
        r100 = r311;
        goto L43
    L48:
        r139 = r139 + 1;
        r100 = r311;
        r324 = r153;
        r227 = r154;
        r104 = r228;
        r113 = r229;
        r110 = r234;
        goto L31
    L49:
        int r243 = r110;
        r138.setPixels(r113, 0, r243, 0, 0, r243, r227);
        return r138;
    L5:
        r101 = r310.copy(r310.getConfig(), true);
        goto L6
    }

    public static byte[] a(TGFrame r100, int r110, float r111, String r112, boolean r113) {
        a0 r114 = new a0();
        System.currentTimeMillis();
        if (r100 == null) goto L57;
        Bitmap r115 = r114.a(r100, r110, false);
        if (r115 == null) goto L57;
        String r116 = String.valueOf(System.identityHashCode(r115));
        StringBuilder r101 = new StringBuilder();
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L11
        r102.update(r116.getBytes());     // Catch: NoSuchAlgorithmException -> L10
    L13:
        if (r102 == null) goto L17;
        byte[] r103 = r102.digest();
        int r104 = r103.length;
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L17;
        r101.append(String.format("%02X", new Object[]{Byte.valueOf(r103[r105])}));
        r105 = r105 + 1;
    L17:
        String r106 = r101.toString().toLowerCase();
        FaceDataFrameInfo.info_cache_bak = r106;
        int r107 = 0;
    L19:
        if (r107 >= HandlerThreadPool.result_image_frame_hash.size()) goto L24;
        if (((String) ListProtector.get(HandlerThreadPool.result_image_frame_hash, r107)).equals(r106) == true) goto L23;
        r107 = r107 + 1;
        goto L19
    L23:
        boolean r108 = true;
    L25:
        SgomInfoManager.updateSgomInfo(1424421581, null);
        if (r108 == true) goto L28;
        HandlerThreadPool.check_image_frame_result.add(1);
    L28:
        ByteArrayOutputStream r109 = new ByteArrayOutputStream();
        if (r111 > 1.0f) goto L34;
        if (r111 <= 0.0f) goto L34;
        r111 = r111 * 100.0f;
    L36:
        int r117 = (int) r111;
    L37:
        r115.compress(Bitmap.CompressFormat.JPEG, r117, r109);
        r109.flush();     // Catch: IOException -> L40
        r109.close();     // Catch: IOException -> L40
    L42:
        byte[] r118 = r109.toByteArray();
        StringBuilder r119 = new StringBuilder();
        MessageDigest r120 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L47
        r120.update(r118);     // Catch: NoSuchAlgorithmException -> L46
    L48:
        if (r120 == null) goto L53;
        byte[] r121 = r120.digest();
        int r122 = r121.length;
        int r123 = 0;
    L50:
        if (r123 >= r122) goto L53;
        r119.append(String.format("%02X", new Object[]{Byte.valueOf(r121[r123])}));
        r123 = r123 + 1;
    L53:
        if (TextUtils.isEmpty(r100.f273696md5) == false) goto L55;
        String r124 = r119.toString().toLowerCase();
    L56:
        HandlerThreadPool.result_image_frame_hash.add(r124);
        FaceDataFrameInfo.info_cache = r124;
        SgomInfoManager.updateSgomInfo(1186066869, null);
    L58:
        SgomInfoManager.updateSgomInfo(-1574272955, null);
        return r118;
    L55:
        r124 = r100.f273696md5;
    L47:
        r120 = null;
    L40:
        e = move-exception;
        RecordService.getInstance().recordException(e);
    L34:
        if (r111 > 0.0f) goto L36;
        r117 = 70;
        goto L37
    L24:
        r108 = false;
    L11:
        r102 = null;
    L57:
        r118 = null;
        goto L58
    }
}
