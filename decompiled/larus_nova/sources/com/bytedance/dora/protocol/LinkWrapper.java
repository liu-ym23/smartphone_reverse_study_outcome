package com.bytedance.dora.protocol;

import com.bytedance.dora.transfer.DoraTransferDirection;
import com.bytedance.librarian.a;
import com.bytelink.syswrapper.ble.BTJniBridge;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.media.MediaScene;
import com.larus.utils.logger.FLogger;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ok4.b;
import pk4.e;
import pk4.j;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public class LinkWrapper {
    private static final int CRC_LENGTH = 2;
    public static final AtomicBoolean HAS_LINKED = null;
    private static final int HEADER_OFFSET = 3;
    private static final int PTL_BUFF_MAX = 2048;
    private static final String TAG = "LinkWrapper@8321b42";
    private static final b transferRateTracker = null;

    public LinkWrapper() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native int getProtocolMtu();

    public static void init() {
    }

    public static native void init(int r100);

    private static native void linked(int r100, String r101, String r102, int r103);

    public static native void rx(byte[] r100);

    public static native void setProtocolMtu(int r100);

    public static native void tx(int r100, int r101, byte[] r102, int r103);

    private static native void unlinked(int r100);

    public static native byte[] wlanConfigCommand(byte r100, byte[] r101, byte[] r102, byte r103, byte r104, int r105, byte[] r106);

    static {
        HAS_LINKED = new AtomicBoolean(false);
        transferRateTracker = b.a.f523640a;
        INVOKESTATIC_com_bytedance_dora_protocol_LinkWrapper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(MediaScene.DORA);
        INVOKESTATIC_com_bytedance_dora_protocol_LinkWrapper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("vui");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_dora_protocol_LinkWrapper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static void safeUnlinked(int r100) {
        HAS_LINKED.set(false);
        unlinked(r100);
        j.d(TAG, "safeUnlinked: type : " + r100);
    }

    public static void safeLinked(int r100, String r101, String r102, int r103) {
        if (HAS_LINKED.getAndSet(true) == true) goto L10;
        j.d(TAG, "safeLinked: type : " + r100 + ", sn : " + r101 + ", appKey : " + r102 + ", protocolType : " + r103);
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        linked(r100, r101, r102, r103);
        return;
    L10:
        j.d(TAG, "safeLinked skipped: already linked, request type : " + r100 + ", sn : " + r101 + ", appKey : " + r102 + ", protocolType : " + r103);
    }

    public static void loop(InputStream r110, byte[] r111, char[] r112, int r113, boolean r210) throws Throwable {
        DataInputStream r100 = new DataInputStream(r110);
        j.d(TAG, "read: is isDoraDevice stream : " + r210);
    L4:
        if (r210 == true) goto L5;
        int r101 = r100.readUnsignedByte();
        int r102 = r100.readUnsignedShort();
        int r114 = r102 + 2;
        if (r101 != 165) goto L122;
        if (r102 <= 0) goto L122;
        int r115 = r114 + 3;
        byte[] r116 = new byte[r115];
        r116[0] = (byte) r101;
        boolean r117 = true;
        r116[1] = (byte) ((r102 >> 8) & 255);
        r116[2] = (byte) (r102 & 255);
        int r118 = r100.read(r116, 3, r114);
        if (r118 == r114) goto L43;
        j.f(TAG, "read warning; expected " + r114 + " actually " + r118);
    L43:
        byte r103 = r116[0];
        byte r104 = r116[1];
        byte r105 = r116[2];
        if (r116[3] != 32) goto L46;
        byte r119 = r116[4];
        byte r106 = r116[5];
        int r107 = 6;
    L47:
        int r120 = r107 + 1;
        byte r108 = r116[r107];
        if (r108 != 0) goto L50;
        byte r109 = r116[r120];
        if (r109 != 1) goto L110;
    L114:
        byte[] r121 = r116;
    L116:
        if (r121.length > 0) goto L118;
        j.d(TAG, "rx:_skip_external_data: " + n.e(r116));
        goto L4
    L118:
        if (e.f529620a == false) goto L120;
        j.d(TAG, "rx:_external_data len: " + r121.length);
    L120:
        BTJniBridge.onSppDataReceived(r111, r112, r113, r121, r121.length);
        goto L4
    L110:
        if (r109 == 2) goto L114;
        j.d("ProtocolAdapter", "external protocol not support skip. cid = " + r109 + " ,sid : " + r108);
    L113:
        r121 = new byte[0];
        goto L116
    L50:
        if (r108 == 1) goto L94;
        if (r108 != 2) goto L53;
        byte r122 = r116[r120];
        if (r122 == 1) goto L114;
        if (r122 == 2) goto L114;
        if (r122 == 4) goto L114;
        if (r122 == 5) goto L114;
        j.d("ProtocolAdapter", "external protocol not support skip cid = " + r122 + " ,sid : " + r108);
        goto L113
    L53:
        if (r108 != 4) goto L55;
        int r123 = r120 + 1;
        byte r124 = r116[r120];
        if (r124 == 7) goto L68;
    L81:
        j.d("ProtocolAdapter", "external protocol not support skip cid = " + r124 + " ,sid : " + r108);
        goto L113
    L68:
        if (r123 >= (r115 - 2)) goto L81;
        byte r125 = r116[r123];
        if (r125 != 1) goto L72;
    L79:
        if (r117 == false) goto L81;
    L72:
        if (r125 == 2) goto L79;
        if (r125 == 3) goto L79;
        if (r125 == 4) goto L79;
        r117 = false;
        goto L79
    L55:
        if (r108 != 43) goto L113;
        byte r126 = r116[r120];
        int r127 = r126 & UByte.MAX_VALUE;
        if (r127 == 4) goto L114;
        if (r127 == 42) goto L114;
        if (r127 == 180) goto L114;
        j.d("ProtocolAdapter", "external protocol not support skip cid = " + r126 + " ,sid : " + r108);
        goto L113
    L94:
        byte r128 = r116[r120];
        if (r128 == 2) goto L114;
        if (r128 == 3) goto L114;
        if (r128 == 4) goto L114;
        if (r128 == 6) goto L114;
        j.d("ProtocolAdapter", "external protocol not support skip cid = " + r128 + " ,sid : " + r108);
        goto L113
    L46:
        r107 = 4;
    L122:
        j.d(TAG, "rx:_invalid_external_header magic: " + r101 + ", payload_len: " + r102 + ", len: " + r114);
        goto L4
    L5:
        byte[] r129 = new byte[2048];
        String r130 = "read begin, conn=" + r113;
        int r131 = j.f529630b;
        if (r131 > 4) goto L8;
        j.f529629a.a(r130);
    L8:
        int r132 = r100.read(r129, 0, 2048);
        String r133 = "read end, conn=" + r113 + ", len=" + r132;
        if (r131 > 4) goto L12;
        j.f529629a.a(r133);
    L12:
        if (r132 == (-1)) goto L35;
        if (r132 <= 0) goto L14;
        b r134 = transferRateTracker;
        DoraTransferDirection r135 = DoraTransferDirection.UPLINK;
        ok4.e r136 = (ok4.e) r134;
        if (r132 > 0) goto L18;
        r136.getClass();
    L34:
        BTJniBridge.onSppDataReceived(r111, r112, r113, r129, r132);
        goto L4
    L18:
        String r137 = r136.f523649a;
        if (r137 != null) goto L21;
    L22:
        Iterator<Map.Entry<String, String>> r138 = r136.f523651c.entrySet().iterator();
    L24:
        if (r138.hasNext() == false) goto L30;
        Map.Entry<String, String> r139 = r138.next();
        String r140 = r139.getKey();
        if (r140 == null) goto L24;
        if (r140.startsWith(FlowDoraWifiScene.VUI) == false) goto L24;
        r137 = r139.getValue();
    L31:
        r136.f523649a = r137;
    L32:
        if (r137 == null) goto L34;
        r136.d(r137, r132);
        goto L34
    L30:
        r137 = null;
        goto L31
    L21:
        if (r136.f523650b.containsKey(r137) == true) goto L32;
    L14:
        j.d(TAG, "readLen is unavailable == " + r132);
        goto L4
    L35:
        j.d(TAG, "readLen is -1 == no more data, the end of the stream has been reached. ");
        throw new IOException("readLen is -1 . no more data, the end of the stream has been reached.");
    }
}
