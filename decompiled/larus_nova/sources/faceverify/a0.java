package faceverify;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.alipay.zoloz.toyger.blob.FaceDataFrameInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.dtf.toyger.base.HandlerThreadPool;
import com.dtf.toyger.base.algorithm.TGFrame;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes41.dex */
public class a0 {
    public a0() {
    }

    public Bitmap a(TGFrame r210, int r211, boolean r212) {
        int r100 = r211;
        if (r210 != null) goto L5;
        return null;
    L5:
        switch(r210.frameMode) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L8;
            default: goto L6;
        };
    L6:
        byte r101 = -1;
    L13:
        if (r101 < 0) goto L257;
        byte[] r110 = r210.data;
        int r111 = r210.width;
        int r102 = r210.height;
        if (r101 == 0) goto L41;
        if (r101 == 3) goto L40;
        if (r101 != 4) goto L38;
        int r103 = r110.length;
        if (r103 != 0) goto L23;
        int[] r112 = null;
    L37:
        if (r112 == null) goto L38;
        String r104 = "%02X";
        int r105 = -1637885684;
        Bitmap r106 = Bitmap.createBitmap(r112, 0, r111, r111, r102, Bitmap.Config.ARGB_8888);
    L77:
        SgomInfoManager.updateSgomInfo(-1917552295, null);
        if (r106 == null) goto L258;
        String r107 = String.valueOf(System.identityHashCode(r106));
        StringBuilder r108 = new StringBuilder();
        MessageDigest r113 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L84
        r113.update(r107.getBytes());     // Catch: NoSuchAlgorithmException -> L83
    L85:
        if (r113 == null) goto L89;
        byte[] r109 = r113.digest();
        int r114 = r109.length;
        int r115 = 0;
    L87:
        if (r115 >= r114) goto L89;
        r108.append(String.format(r104, new Object[]{Byte.valueOf(r109[r115])}));
        r115 = r115 + 1;
    L89:
        FaceDataFrameInfo.info_cache = r108.toString().toLowerCase();
        SgomInfoManager.updateSgomInfo(r105, null);
        int r116 = r210.rotation;
        String r117 = String.valueOf(System.identityHashCode(r106));
        StringBuilder r118 = new StringBuilder();
        MessageDigest r119 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L94
        r119.update(r117.getBytes());     // Catch: NoSuchAlgorithmException -> L93
    L95:
        if (r119 == null) goto L99;
        byte[] r120 = r119.digest();
        int r121 = r120.length;
        int r122 = 0;
    L97:
        if (r122 >= r121) goto L99;
        r118.append(String.format(r104, new Object[]{Byte.valueOf(r120[r122])}));
        r122 = r122 + 1;
    L99:
        String r123 = r118.toString().toLowerCase();
        FaceDataFrameInfo.info_cache_bak = r123;
        SgomInfoManager.updateSgomInfo(-888356471, null);
        int r124 = 0;
    L101:
        if (r124 >= HandlerThreadPool.result_image_frame_hash.size()) goto L106;
        if (((String) ListProtector.get(HandlerThreadPool.result_image_frame_hash, r124)).equals(r123) == true) goto L105;
        r124 = r124 + 1;
        goto L101
    L105:
        boolean r125 = true;
    L107:
        if (r125 == true) goto L109;
        HandlerThreadPool.check_image_frame_result.add(1);
    L109:
        int r126 = r106.getWidth();
        int r127 = r106.getHeight();
        Matrix r128 = new Matrix();
        r128.setRotate(r116);
        Bitmap r129 = Bitmap.createBitmap(r106, 0, 0, r126, r127, r128, false);
        String r130 = String.valueOf(System.identityHashCode(r129));
        StringBuilder r131 = new StringBuilder();
        MessageDigest r132 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L114
        r132.update(r130.getBytes());     // Catch: NoSuchAlgorithmException -> L113
    L115:
        if (r132 == null) goto L119;
        byte[] r133 = r132.digest();
        int r134 = r133.length;
        int r135 = 0;
    L117:
        if (r135 >= r134) goto L119;
        r131.append(String.format(r104, new Object[]{Byte.valueOf(r133[r135])}));
        r135 = r135 + 1;
    L119:
        String r136 = r131.toString().toLowerCase();
        FaceDataFrameInfo.info_cache = r136;
        SgomInfoManager.updateSgomInfo(47393405, null);
        HandlerThreadPool.result_image_frame_hash.add(r136);
        if (r129.equals(r106) == true) goto L123;
        r106.recycle();
    L123:
        SgomInfoManager.updateSgomInfo(2100103573, null);
        if (r212 == false) goto L156;
        SgomInfoManager.updateSgomInfo(r105, null);
        String r137 = String.valueOf(System.identityHashCode(r129));
        StringBuilder r138 = new StringBuilder();
        MessageDigest r139 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L130
        r139.update(r137.getBytes());     // Catch: NoSuchAlgorithmException -> L129
    L131:
        if (r139 == null) goto L135;
        byte[] r140 = r139.digest();
        int r141 = r140.length;
        int r142 = 0;
    L133:
        if (r142 >= r141) goto L135;
        r138.append(String.format(r104, new Object[]{Byte.valueOf(r140[r142])}));
        r142 = r142 + 1;
    L135:
        String r143 = r138.toString().toLowerCase();
        FaceDataFrameInfo.info_cache_bak = r143;
        SgomInfoManager.updateSgomInfo(-888356471, null);
        int r144 = 0;
    L137:
        if (r144 >= HandlerThreadPool.result_image_frame_hash.size()) goto L142;
        if (((String) ListProtector.get(HandlerThreadPool.result_image_frame_hash, r144)).equals(r143) == true) goto L141;
        r144 = r144 + 1;
        goto L137
    L141:
        boolean r145 = true;
    L143:
        if (r145 == true) goto L145;
        HandlerThreadPool.check_image_frame_result.add(1);
    L145:
        Matrix r146 = new Matrix();
        r146.setValues(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        Bitmap r147 = Bitmap.createBitmap(r129, 0, 0, r129.getWidth(), r129.getHeight(), r146, true);
        r129.recycle();
        String r148 = String.valueOf(System.identityHashCode(r147));
        StringBuilder r149 = new StringBuilder();
        MessageDigest r150 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L150
        r150.update(r148.getBytes());     // Catch: NoSuchAlgorithmException -> L149
    L151:
        if (r150 == null) goto L155;
        byte[] r151 = r150.digest();
        int r152 = r151.length;
        int r153 = 0;
    L153:
        if (r153 >= r152) goto L155;
        r149.append(String.format(r104, new Object[]{Byte.valueOf(r151[r153])}));
        r153 = r153 + 1;
    L155:
        String r154 = r149.toString().toLowerCase();
        FaceDataFrameInfo.info_cache = r154;
        SgomInfoManager.updateSgomInfo(47393405, null);
        HandlerThreadPool.result_image_frame_hash.add(r154);
        SgomInfoManager.updateSgomInfo(2100103573, null);
        r129 = r147;
    L150:
        r150 = null;
        goto L151
    L142:
        r145 = false;
    L130:
        r139 = null;
    L156:
        if (r129 != null) goto L158;
        r129 = null;
    L197:
        SgomInfoManager.updateSgomInfo(-1221899931, null);
        return r129;
    L158:
        if (r129.getWidth() <= r100) goto L161;
        if (r100 <= 0) goto L161;
    L163:
        if (r100 == r210.width) goto L197;
        String r155 = String.valueOf(System.identityHashCode(r129));
        StringBuilder r156 = new StringBuilder();
        MessageDigest r157 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L169
        r157.update(r155.getBytes());     // Catch: NoSuchAlgorithmException -> L168
    L170:
        if (r157 == null) goto L174;
        byte[] r158 = r157.digest();
        int r159 = r158.length;
        int r160 = 0;
    L172:
        if (r160 >= r159) goto L174;
        r156.append(String.format(r104, new Object[]{Byte.valueOf(r158[r160])}));
        r160 = r160 + 1;
    L174:
        String r161 = r156.toString().toLowerCase();
        FaceDataFrameInfo.info_cache_bak = r161;
        int r162 = 0;
    L176:
        if (r162 >= HandlerThreadPool.result_image_frame_hash.size()) goto L181;
        if (((String) ListProtector.get(HandlerThreadPool.result_image_frame_hash, r162)).equals(r161) == true) goto L180;
        r162 = r162 + 1;
        goto L176
    L180:
        boolean r163 = true;
    L182:
        SgomInfoManager.updateSgomInfo(-1662748464, null);
        if (r163 == true) goto L185;
        HandlerThreadPool.check_image_frame_result.add(1);
    L185:
        r129 = f.a(r129, r100);
        String r164 = String.valueOf(System.identityHashCode(r129));
        StringBuilder r165 = new StringBuilder();
        MessageDigest r166 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L190
        r166.update(r164.getBytes());     // Catch: NoSuchAlgorithmException -> L189
    L191:
        if (r166 == null) goto L195;
        byte[] r167 = r166.digest();
        int r168 = r167.length;
        int r169 = 0;
    L193:
        if (r169 >= r168) goto L195;
        r165.append(String.format(r104, new Object[]{Byte.valueOf(r167[r169])}));
        r169 = r169 + 1;
    L195:
        String r170 = r165.toString().toLowerCase();
        FaceDataFrameInfo.info_cache = r170;
        SgomInfoManager.updateSgomInfo(537768257, null);
        HandlerThreadPool.result_image_frame_hash.add(r170);
    L190:
        r166 = null;
        goto L191
    L181:
        r163 = false;
    L169:
        r157 = null;
    L161:
        r100 = r129.getWidth();
    L114:
        r132 = null;
        goto L115
    L106:
        r125 = false;
    L94:
        r119 = null;
    L84:
        r113 = null;
        goto L85
    L258:
        return null;
    L23:
        if ((r103 % 3) == 0) goto L25;
        int r171 = 1;
    L26:
        int r172 = (r103 / 3) + r171;
        int[] r173 = new int[r172];
        if (r171 != 0) goto L31;
        int r174 = 0;
    L29:
        if (r174 >= r172) goto L36;
        int r175 = r174 * 3;
        r173[r174] = (((f.a(r110[r175]) << 16) | (f.a(r110[r175 + 1]) << 8)) | f.a(r110[r175 + 2])) | (-16777216);
        r174 = r174 + 1;
    L36:
        r112 = r173;
        goto L37
    L31:
        int r176 = 0;
    L32:
        int r177 = r172 - 1;
        if (r176 >= r177) goto L35;
        int r178 = r176 * 3;
        r173[r176] = (((f.a(r110[r178]) << 16) | (f.a(r110[r178 + 1]) << 8)) | f.a(r110[r178 + 2])) | (-16777216);
        r176 = r176 + 1;
        goto L32
    L35:
        r173[r177] = -16777216;
        goto L36
    L25:
        r171 = 0;
    L38:
        r106 = null;
        r104 = "%02X";
        r105 = -1637885684;
        goto L77
    L40:
        r104 = "%02X";
        r105 = -1637885684;
        r106 = Bitmap.createBitmap(r111, r102, Bitmap.Config.ARGB_8888);
        r106.copyPixelsFromBuffer(ByteBuffer.wrap(r110));
        goto L77
    L41:
        r104 = "%02X";
        r105 = -1637885684;
        StringBuilder r179 = new StringBuilder();
        MessageDigest r180 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L46
        r180.update(r110);     // Catch: NoSuchAlgorithmException -> L45
    L47:
        if (r180 == null) goto L51;
        byte[] r181 = r180.digest();
        int r182 = r181.length;
        int r183 = 0;
    L49:
        if (r183 >= r182) goto L51;
        r179.append(String.format(r104, new Object[]{Byte.valueOf(r181[r183])}));
        r183 = r183 + 1;
    L51:
        String r184 = r179.toString().toLowerCase();
        FaceDataFrameInfo.info_cache_bak = r184;
        int r185 = 0;
    L53:
        if (r185 >= HandlerThreadPool.result_image_frame_hash.size()) goto L58;
        if (((String) ListProtector.get(HandlerThreadPool.result_image_frame_hash, r185)).equals(r184) == true) goto L57;
        r185 = r185 + 1;
        goto L53
    L57:
        boolean r186 = true;
    L59:
        SgomInfoManager.updateSgomInfo(47450968, null);
        if (r186 == true) goto L62;
        HandlerThreadPool.check_image_frame_result.add(1);
    L62:
        YuvImage r187 = new YuvImage(r110, 17, r111, r102, null);
        ByteArrayOutputStream r188 = new ByteArrayOutputStream();
        r187.compressToJpeg(new Rect(0, 0, r111, r102), 100, r188);
        byte[] r189 = r188.toByteArray();     // Catch: Throwable -> L65
        r106 = BitmapFactory.decodeByteArray(r189, 0, r189.length);     // Catch: Throwable -> L65
    L66:
        String r190 = String.valueOf(System.identityHashCode(r106));
        StringBuilder r191 = new StringBuilder();
        MessageDigest r192 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L71
        r192.update(r190.getBytes());     // Catch: NoSuchAlgorithmException -> L70
    L72:
        if (r192 == null) goto L76;
        byte[] r193 = r192.digest();
        int r194 = r193.length;
        int r195 = 0;
    L74:
        if (r195 >= r194) goto L76;
        r191.append(String.format(r104, new Object[]{Byte.valueOf(r193[r195])}));
        r195 = r195 + 1;
    L76:
        String r196 = r191.toString().toLowerCase();
        HandlerThreadPool.result_image_frame_hash.add(r196);
        FaceDataFrameInfo.info_cache = r196;
        SgomInfoManager.updateSgomInfo(-1637885684, null);
    L71:
        r192 = null;
    L65:
        r106 = null;
        goto L66
    L58:
        r186 = false;
    L46:
        r180 = null;
        goto L47
    L257:
        return null;
    L7:
        r101 = 6;
        goto L13
    L8:
        r101 = 4;
        goto L13
    L9:
        r101 = 3;
        goto L13
    L10:
        r101 = 2;
        goto L13
    L11:
        r101 = 1;
        goto L13
    L12:
        r101 = 0;
        goto L13
    }
}
