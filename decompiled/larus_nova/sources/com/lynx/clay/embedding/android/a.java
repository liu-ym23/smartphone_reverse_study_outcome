package com.lynx.clay.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FlutterRenderer f380629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u5a.b f380630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f380631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C4544a f380632d;

    /* JADX INFO: renamed from: com.lynx.clay.embedding.android.a$a, reason: collision with other inner class name */
    public static class C4544a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Deque<KeyEvent> f380633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f380634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public u5a.b f380635c;

        public final KeyEvent a(int r100) {
            Iterator r101 = ((ArrayDeque) this.f380633a).iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            KeyEvent r102 = (KeyEvent) r101.next();
            if (r102.hashCode() != r100) goto L4;
            return r102;
        L8:
            return null;
        }

        public C4544a(View r100, u5a.b r101) {
            this.f380633a = new ArrayDeque();
            this.f380634b = r100;
            this.f380635c = r101;
        }
    }

    public interface b {
    }

    public interface c {
    }

    public final boolean a(KeyEvent r110) {
        int r100 = r110.getAction();
        if (r100 == 0) goto L7;
        if (r100 == 1) goto L7;
        return false;
    L7:
        if (this.f380632d.a(r110.hashCode()) == null) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        ((ArrayDeque) this.f380632d.f380633a).remove(r110);
        return false;
    L13:
        int r102 = r110.getUnicodeChar();
        if (r102 != 0) goto L16;
        Character r103 = null;
    L32:
        if (r103 == null) goto L34;
        String r104 = r103.toString();
    L35:
        Long r105 = KeyboardMap.f380588a.get(Long.valueOf(r110.getScanCode()));
        Long r106 = KeyboardMap.f380589b.get(Long.valueOf(r110.getKeyCode()));
        ByteBuffer r107 = ByteBuffer.allocateDirect(40);
        r107.order(ByteOrder.LITTLE_ENDIAN);
        r107.putLong(r110.getEventTime());
        if (r100 != 0) goto L38;
        long r108 = 0;
    L39:
        r107.putLong(r108);
        if (r105 != null) goto L42;
        long r109 = 0;
    L43:
        r107.putLong(r109);
        if (r106 != null) goto L46;
        long r111 = 0;
    L47:
        r107.putLong(r111);
        r107.putLong(0);
        C4544a r112 = this.f380632d;
        ((ArrayDeque) r112.f380633a).addLast(r110);
        if (((ArrayDeque) r112.f380633a).size() <= 1000) goto L50;
        c5a.c.d(6, "AndroidKeyProcessor", "There are " + ((ArrayDeque) r112.f380633a).size() + " keyboard events that have not yet received a response. Are responses being sent?");
    L50:
        FlutterRenderer r113 = this.f380629a;
        r113.f380933a.dispatchKeyDataPacket(r107, r104, r110.hashCode());
        return true;
    L46:
        r111 = r106.longValue();
        goto L47
    L42:
        r109 = r105.longValue();
        goto L43
    L38:
        r108 = 1;
        goto L39
    L34:
        r104 = "";
        goto L35
    L16:
        char r114 = (char) r102;
        if ((Integer.MIN_VALUE & r102) == 0) goto L19;
        boolean r115 = true;
    L20:
        if (r115 == false) goto L25;
        int r116 = Integer.MAX_VALUE & r102;
        int r117 = this.f380631c;
        if (r117 == 0) goto L24;
        this.f380631c = KeyCharacterMap.getDeadChar(r117, r116);
    L31:
        r103 = Character.valueOf(r114);
        goto L32
    L24:
        this.f380631c = r116;
        goto L31
    L25:
        int r118 = this.f380631c;
        if (r118 == 0) goto L31;
        int r119 = KeyCharacterMap.getDeadChar(r118, r102);
        if (r119 <= 0) goto L30;
        r114 = (char) r119;
    L30:
        this.f380631c = 0;
        goto L31
    L19:
        r115 = false;
        goto L20
    L9:
        r101 = false;
        goto L10
    }

    public a(View r100, FlutterRenderer r101, u5a.b r102) {
        this.f380629a = r101;
        this.f380630b = r102;
        r102.f548895f = this;
        C4544a r103 = new C4544a(r100, r102);
        this.f380632d = r103;
        this.f380629a.f380933a.setEventResponseHandler(r103);
    }
}
