package ms.bd.c;

import androidx.collection.SieveCacheKt;
import com.ss.ttm.player.MediaPlayer;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class f {
    public static LinkedHashMap a(ByteBuffer r110) {
        if (r110.order() != ByteOrder.LITTLE_ENDIAN) goto L51;
        int r100 = r110.capacity() - 24;
        if (r100 < 8) goto L49;
        r110.capacity();
        if (r100 > r110.capacity()) goto L47;
        int r101 = r110.limit();
        int r102 = r110.position();
        r110.position(0);     // Catch: Throwable -> L43
        r110.limit(r100);     // Catch: Throwable -> L43
        r110.position(8);     // Catch: Throwable -> L43
        ByteBuffer r103 = r110.slice();     // Catch: Throwable -> L43
        r103.order(r110.order());     // Catch: Throwable -> L43
        r110.position(0);
        r110.limit(r101);
        r110.position(r102);
        LinkedHashMap r111 = new LinkedHashMap();
    L12:
        if (r103.hasRemaining() == false) goto L42;
        if (r103.remaining() < 8) goto L41;
        long r104 = r103.getLong();
        if (r104 < 4) goto L39;
        if (r104 > SieveCacheKt.NodeLinkMask) goto L39;
        int r105 = (int) r104;
        int r106 = r103.position() + r105;
        if (r105 > r103.remaining()) goto L37;
        Integer r107 = Integer.valueOf(r103.getInt());
        int r108 = r105 - 4;
        if (r108 < 0) goto L35;
        int r109 = r103.limit();
        int r112 = r103.position();
        int r113 = r108 + r112;
        if (r113 < r112) goto L33;
        if (r113 > r109) goto L33;
        r103.limit(r113);
        ByteBuffer r114 = r103.slice();     // Catch: Throwable -> L29
        r114.order(r103.order());     // Catch: Throwable -> L29
        r103.position(r113);     // Catch: Throwable -> L29
        r103.limit(r109);
        r111.put(r107, r114);
        r103.position(r106);
    L29:
        th = move-exception;
        r103.limit(r109);
        throw th;
    L33:
        throw new BufferUnderflowException();
    L35:
        throw new IllegalArgumentException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "82142c", new byte[]{123}));
    L37:
        throw new e((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "8e0ff5", new byte[]{113}));
    L39:
        throw new e((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "797128", new byte[]{113}));
    L41:
        throw new e((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "6d1bb9", new byte[]{113}));
    L42:
        return r111;
    L43:
        th = move-exception;
        r110.position(0);
        r110.limit(r101);
        r110.position(r102);
        throw th;
    L47:
        throw new IllegalArgumentException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "eee3fe", new byte[]{33}));
    L49:
        throw new IllegalArgumentException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "bb94a0", new byte[]{39}));
    L51:
        throw new IllegalArgumentException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "8333fb", new byte[]{120}));
    }

    public static d b(FileChannel r110) {
        long r100 = r110.size();
        if (r100 < 22) goto L38;
        long r101 = r100 - 22;
        long r102 = Math.min(r101, 65535);
        int r103 = 0;
    L5:
        long r104 = r103;
        if (r104 > r102) goto L36;
        long r105 = r101 - r104;
        ByteBuffer r111 = ByteBuffer.allocate(4);
        r110.position(r105);
        r110.read(r111);
        ByteOrder r112 = ByteOrder.LITTLE_ENDIAN;
        r111.order(r112);
        if (r111.getInt(0) != 101010256) goto L34;
        ByteBuffer r113 = ByteBuffer.allocate(2);
        r110.position(r105 + 20);
        r110.read(r113);
        r113.order(r112);
        short r106 = r113.getShort(0);
        if (r106 != r103) goto L34;
        ByteBuffer r107 = ByteBuffer.allocate(4);
        r107.order(r112);
        r110.position((r110.size() - ((long) r106)) - 6);
        r110.read(r107);
        long r108 = r107.getInt(0);
        if (r108 < 32) goto L33;
        r110.position(r108 - 24);
        ByteBuffer r109 = ByteBuffer.allocate(24);
        r110.read(r109);
        r109.order(r112);
        if (r109.getLong(8) == 2334950737559900225L) goto L16;
    L30:
        return null;
    L16:
        if (r109.getLong(16) != 3617552046287187010L) goto L30;
        long r114 = r109.getLong(0);
        if (r114 < r109.capacity()) goto L30;
        if (r114 > 2147483639) goto L30;
        int r115 = (int) (8 + r114);
        long r116 = r108 - ((long) r115);
        if (r116 < 0) goto L30;
        r110.position(r116);
        ByteBuffer r117 = ByteBuffer.allocate(r115);
        r110.read(r117);
        r117.order(r112);
        if (r117.getLong(0) != r114) goto L30;
        return new d(r117, Long.valueOf(r116));
    L33:
        throw new e((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "150726", new byte[]{121}));
    L34:
        r103 = r103 + 1;
        goto L5
    L36:
        throw new IOException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "255618", new byte[]{114, 103}));
    L38:
        throw new IOException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f72618", new byte[]{38, 100}));
    }
}
