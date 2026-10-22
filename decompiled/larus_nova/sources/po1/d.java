package po1;

import android.text.TextUtils;
import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.chatroom.utils.pngloader.ChunkReader;
import com.bytedance.android.livesdk.chatroom.utils.pngloader.FlexData;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.zip.InflaterInputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.utils.pngloader.b f530033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InputStream f530034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f530035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f530036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f530037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f530038f;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.bytedance.android.livesdk.chatroom.utils.pngloader.b r100 = this.f530033a;     // Catch: Exception -> L7
        if (r100 == null) goto L9;
        r100.f114595f = true;     // Catch: Exception -> L7
    L9:
        this.f530038f = true;
        this.f530035c = null;
        this.f530036d = 0;
        this.f530037e = 0;
        InputStream r101 = this.f530034b;
        if (r101 != null) goto L17;
    L15:
        this.f530034b = null;
        return;
    L17:
        r101.close();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public final FlexData b() {
        c r100 = this.f530033a.f114601l;
        if (r100 != null) goto L5;
    L12:
        return null;
    L5:
        if (TextUtils.isEmpty(r100.f530032a) == true) goto L12;
        Matcher r101 = PatternProtector.compile("<xmp:FlexData>(.*)</xmp:FlexData>").matcher(this.f530033a.f114601l.f530032a);     // Catch: Exception -> L13
        if (r101.find() == false) goto L12;
        if (r101.group(1) == null) goto L12;
        String r102 = new String(Base64.decode(r101.group(1), 0));     // Catch: Exception -> L13
        return (FlexData) GsonHelper.get().fromJson(r102, FlexData.class);
    }

    static {
    }

    public d(InputStream r100) {
        this.f530038f = false;
        this.f530034b = r100;
        this.f530035c = new byte[16384];
        com.bytedance.android.livesdk.chatroom.utils.pngloader.b r101 = new com.bytedance.android.livesdk.chatroom.utils.pngloader.b();
        this.f530033a = r101;
        int r102 = 36;
    L3:
        if (r102 <= 0) goto L10;
        int r103 = a(r101, r102);     // Catch: RuntimeException -> L8
        if (r103 <= 0) goto L11;
        r102 = r102 - r103;     // Catch: RuntimeException -> L8
    L11:
        if (r103 != 36) goto L21;
    L12:
        com.bytedance.android.livesdk.chatroom.utils.pngloader.b r104 = this.f530033a;     // Catch: RuntimeException -> L8
        if (r104.f114598i >= 4) goto L19;
        if (a(r104, Integer.MAX_VALUE) > 0) goto L12;
        throw new RuntimeException();     // Catch: RuntimeException -> L8
    L19:
        return;
    L21:
        throw new RuntimeException();     // Catch: RuntimeException -> L8
    L8:
        e = move-exception;
        close();
        this.f530033a.f114595f = true;
        throw e;
    L10:
        r103 = 36;
        goto L11
    }

    public final int a(com.bytedance.android.livesdk.chatroom.utils.pngloader.b r110, int r111) {
        int r100 = r111;
        int r101 = 0;
        if (this.f530036d <= 0) goto L5;
    L16:
        if (r100 > 0) goto L18;
    L20:
        r100 = this.f530036d;
    L21:
        if (r100 <= 0) goto L249;
        byte[] r102 = this.f530035c;
        int r103 = this.f530037e;
        if (r110.f114595f == true) goto L139;
        if (r100 == 0) goto L236;
        if (r100 < 0) goto L247;
        boolean r104 = true;
        if (r110.f114593d == false) goto L224;
        com.bytedance.android.livesdk.chatroom.utils.pngloader.a r105 = r110.f114600k;
        if (r105 == null) goto L145;
        int r112 = r105.f114587d;
        if (r112 != 4) goto L35;
        boolean r113 = true;
    L36:
        if (r113 == true) goto L145;
        if (r100 == 0) goto L138;
        if (r100 < 0) goto L144;
        b r106 = r105.f114585b;
        int r114 = r106.f530028a;
        int r115 = r105.f114586c;
        int r116 = r114 - r115;
        if (r116 <= r100) goto L44;
        r116 = r100;
    L44:
        if (r116 > 0) goto L46;
        if (r112 == 0) goto L46;
    L55:
        int r107 = r105.f114586c;
        b r108 = r105.f114585b;
        if (r107 != r108.f530028a) goto L132;
        int r109 = r105.f114587d;
        int r117 = 4 - r109;
        if (r117 > r100) goto L61;
        r100 = r117;
    L61:
        if (r100 <= 0) goto L130;
        int r118 = r109 + r100;
        r105.f114587d = r118;
        if (r118 != 4) goto L130;
        com.bytedance.android.livesdk.chatroom.utils.pngloader.b r119 = r105.f114589e;
        if (r119.f114596g != 1) goto L72;
        if ("IHDR".equals(r108.f530030c) == true) goto L72;
        throw new RuntimeException();
    L72:
        if (r105.f114585b.f530030c.equals("IEND") == false) goto L74;
        r119.f114594e = true;
        r119.f114595f = true;
    L74:
        ChunkReader.ChunkReaderMode r120 = r105.f114584a;
        ChunkReader.ChunkReaderMode r121 = ChunkReader.ChunkReaderMode.BUFFER;
        if (r120 != r121) goto L81;
        String r122 = r105.f114585b.f530030c;
        byte[] r123 = a.f530026a;
        if ((!Character.isUpperCase(r122.charAt(0))) == false) goto L81;
        r119.f114599j += (long) r105.f114585b.f530028a;
    L81:
        if (r105.f114584a != r121) goto L131;
        b r124 = r105.f114585b;
        if (r124.f530030c.equals("iTXt") == false) goto L131;
        if (r124.f530031d == null) goto L131;
        c r125 = new c();
        r119.f114601l = r125;
        int[] r126 = new int[3];
        int r127 = 0;
        int r128 = 0;
    L87:
        byte[] r129 = r124.f530031d;
        if (r127 >= r129.length) goto L98;
        if (r129[r127] != 0) goto L97;
        r126[r128] = r127;
        r128 = r128 + 1;
        if (r128 != 1) goto L95;
        r127 = r127 + 2;
    L95:
        if (r128 == 3) goto L98;
    L97:
        r127 = r127 + 1;
    L98:
        if (r128 != 3) goto L129;
        int r130 = r126[0];
        byte[] r131 = a.f530026a;
        new String(r129, 0, r130, Charset.forName("ISO-8859-1"));
        int r132 = r126[0] + 1;
        byte[] r133 = r124.f530031d;
        if (r133[r132] == 0) goto L102;
        boolean r134 = true;
    L103:
        int r135 = r132 + 1;
        if (r134 == true) goto L106;
    L110:
        int r136 = r126[2] + 1;
        if (r134 == true) goto L260;
        r125.f530032a = new String(r133, r136, r133.length - r136, Charset.forName("UTF-8"));
        goto L131
    L260:
        InflaterInputStream r137 = new InflaterInputStream(new ByteArrayInputStream(r133, r136, r133.length - r136));     // Catch: Exception -> L124
        ByteArrayOutputStream r138 = new ByteArrayOutputStream();     // Catch: Exception -> L124
        byte[] r139 = a.f530026a;     // Catch: Exception -> L124
        monitor-enter(r139);     // Catch: Exception -> L124
    L257:
        byte[] r140 = a.f530026a;     // Catch: Throwable -> L121
        int r141 = r137.read(r140);     // Catch: Throwable -> L121
        if (r141 <= 0) goto L118;
        r138.write(r140, 0, r141);     // Catch: Throwable -> L121
        goto L257
    L118:
        monitor-exit(r139);     // Catch: Throwable -> L121
        r137.close();     // Catch: Exception -> L124
        r138.close();     // Catch: Exception -> L124
        r125.f530032a = new String(r138.toByteArray(), Charset.forName("UTF-8"));
        goto L131
    L121:
        th = move-exception;
        throw th;     // Catch: Exception -> L124
    L124:
        e = move-exception;
        throw new RuntimeException(e);
    L106:
        if (r133[r135] == 0) goto L110;
        throw new RuntimeException();
    L102:
        r134 = false;
        goto L103
    L129:
        throw new RuntimeException();
    L131:
        r101 = r100;
    L133:
        if (r116 > 0) goto L137;
        if (r101 > 0) goto L137;
        r101 = -1;
    L137:
        r101 = r101 + r116;
    L130:
        r116 = r116;
        goto L131
    L132:
        r116 = r116;
    L46:
        ChunkReader.ChunkReaderMode r142 = r105.f114584a;
        if (r142 != ChunkReader.ChunkReaderMode.BUFFER) goto L53;
        byte[] r143 = r106.f530031d;
        if (r143 == r102) goto L54;
        if (r116 <= 0) goto L54;
        System.arraycopy(r102, r103, r143, r115, r116);
    L54:
        r105.f114586c += r116;
        r100 = r100 - r116;
        goto L55
    L53:
        if (r142 != ChunkReader.ChunkReaderMode.PROCESS) goto L54;
        throw new RuntimeException();
    L144:
        throw new RuntimeException();
    L138:
        if (r101 < 0) goto L139;
        r110.f114597h += (long) r101;
        r101 = r101 + 0;
        goto L236
    L35:
        r113 = false;
    L145:
        int r144 = r110.f114592c;
        int r145 = 8 - r144;
        if (r145 > r100) goto L149;
        r100 = r145;
    L149:
        System.arraycopy(r102, r103, r110.f114591b, r144, r100);
        int r146 = r110.f114592c + r100;
        r110.f114592c = r146;
        int r147 = r100 + 0;
        r110.f114597h += (long) r100;
        if (r146 != 8) goto L223;
        r110.f114596g++;
        byte[] r148 = r110.f114591b;
        byte[] r149 = a.f530026a;
        int r150 = ((((r148[0] & UByte.MAX_VALUE) << 24) | ((r148[1] & UByte.MAX_VALUE) << 16)) | ((r148[2] & UByte.MAX_VALUE) << 8)) | (r148[3] & UByte.MAX_VALUE);
        if (r148.length >= 8) goto L154;
        String r151 = "?";
    L156:
        if ("IHDR".equals(r151) == false) goto L163;
        if (r110.f114598i >= 0) goto L161;
        r110.f114598i = 0;
    L259:
        if (r151.length() != 4) goto L220;
        if (a.f530027b.matcher(r151).matches() == false) goto L220;
        if (r150 < 0) goto L218;
        long r152 = r150;
        if ((r110.f114597h + r152) > 901001001) goto L216;
        if (Character.isUpperCase(r151.charAt(0)) == false) goto L203;
    L208:
        r104 = false;
    L210:
        if (r104 == false) goto L212;
        ChunkReader.ChunkReaderMode r153 = ChunkReader.ChunkReaderMode.SKIP;     // Catch: Exception -> L221
    L213:
        r110.f114600k = new com.bytedance.android.livesdk.chatroom.utils.pngloader.a(r110, r150, r151, r153);     // Catch: Exception -> L221
        r110.f114592c = 0;
        goto L223
    L212:
        r153 = ChunkReader.ChunkReaderMode.BUFFER;     // Catch: Exception -> L221
        goto L213
    L203:
        if (r152 > 2024024) goto L210;
        if (r152 <= (5024024 - r110.f114599j)) goto L208;
    L216:
        throw new RuntimeException();     // Catch: Exception -> L221
    L218:
        throw new RuntimeException();     // Catch: Exception -> L221
    L220:
        throw new RuntimeException();     // Catch: Exception -> L221
    L222:
        throw new RuntimeException();
    L161:
        throw new RuntimeException("unexpected chunk ".concat(r151));
    L163:
        if ("PLTE".equals(r151) == false) goto L172;
        int r154 = r110.f114598i;
        if (r154 == 0) goto L170;
        if (r154 == 1) goto L170;
        throw new RuntimeException("unexpected chunk here ".concat(r151));
    L170:
        r110.f114598i = 2;
        goto L259
    L172:
        if ("IDAT".equals(r151) == false) goto L180;
        int r155 = r110.f114598i;
        if (r155 < 0) goto L178;
        if (r155 > 4) goto L178;
        r110.f114598i = 4;
    L178:
        throw new RuntimeException("unexpected chunk ".concat(r151));
    L180:
        if ("IEND".equals(r151) == true) goto L182;
        int r156 = r110.f114598i;
        if (r156 > 1) goto L189;
        r110.f114598i = 1;
        goto L259
    L189:
        if (r156 > 3) goto L191;
        r110.f114598i = 3;
        goto L259
    L191:
        r110.f114598i = 5;
        goto L259
    L182:
        if (r110.f114598i < 4) goto L185;
        r110.f114598i = 6;
        goto L259
    L185:
        throw new RuntimeException("unexpected chunk ".concat(r151));
    L154:
        r151 = new String(r148, 4, 4, Charset.forName("ISO-8859-1"));
    L223:
        r101 = r147;
        goto L236
    L224:
        int r157 = r110.f114590a;
        int r158 = r110.f114592c;
        int r159 = r157 - r158;
        if (r159 > r100) goto L228;
        r100 = r159;
    L228:
        System.arraycopy(r102, r103, r110.f114591b, r158, r100);
        int r160 = r110.f114592c + r100;
        r110.f114592c = r160;
        if (r160 != r110.f114590a) goto L235;
        byte[] r161 = r110.f114591b;
        byte[] r162 = a.f530026a;
        if (Arrays.equals(r161, new byte[]{-119, 80, 78, 71, HTTP.CR, 10, 26, 10}) == false) goto L234;
        r110.f114592c = 0;
        r110.f114593d = true;
        goto L235
    L234:
        throw new RuntimeException();
    L235:
        r101 = 0 + r100;
        r110.f114597h += (long) r100;
        goto L236
    L247:
        throw new RuntimeException();
    L236:
        if (r101 <= 0) goto L238;
        this.f530037e += r101;
        this.f530036d -= r101;
    L238:
        if (r101 <= 0) goto L241;
        return r101;
    L241:
        if (r110.f114594e == false) goto L245;
        return -1;
    L245:
        throw new RuntimeException();
    L139:
        r101 = -1;
        goto L236
    L249:
        if (this.f530038f == false) goto L255;
        if (r110.f114594e == false) goto L266;
        return -1;
    L266:
        return 0;
    L255:
        throw new RuntimeException();
    L18:
        if (r100 >= this.f530036d) goto L20;
    L5:
        if (this.f530038f == true) goto L16;
        this.f530037e = 0;     // Catch: IOException -> L13
        int r163 = this.f530034b.read(this.f530035c);     // Catch: IOException -> L13
        this.f530036d = r163;     // Catch: IOException -> L13
        if (r163 == 0) goto L12;
        if (r163 >= 0) goto L16;
        close();     // Catch: IOException -> L13
        goto L16
    L12:
        throw new RuntimeException();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
