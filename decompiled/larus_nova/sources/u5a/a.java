package u5a;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import com.lynx.clay.embedding.android.KeyEventType;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends BaseInputConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterRenderer f548886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.lynx.clay.embedding.android.a f548887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f548888c;

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int r100) {
        this.f548886a.f380933a.performEditorAction(r100);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent r100) {
        com.lynx.clay.embedding.android.a r101 = this.f548887b;
        if (r101 != null) goto L5;
    L12:
        int r102 = r100.getUnicodeChar();
        if (r102 != 0) goto L15;
        Character r103 = null;
    L31:
        if (r103 == null) goto L33;
        String r104 = r103.toString();
    L34:
        ByteBuffer r105 = ByteBuffer.allocateDirect(40);
        r105.order(ByteOrder.LITTLE_ENDIAN);
        r105.putLong(r100.getEventTime());
        r105.putLong(r100.getAction());
        r105.putLong(0);
        r105.putLong(r100.getKeyCode());
        r105.putLong(0);
        this.f548886a.f380933a.sendKeyboardEventDataPacket(r105, r104);
        return true;
    L33:
        r104 = "";
        goto L34
    L15:
        char r106 = (char) r102;
        if ((Integer.MIN_VALUE & r102) == 0) goto L18;
        boolean r107 = true;
    L19:
        if (r107 == false) goto L24;
        int r108 = r102 & Integer.MAX_VALUE;
        int r109 = this.f548888c;
        if (r109 == 0) goto L23;
        this.f548888c = KeyCharacterMap.getDeadChar(r109, r108);
    L30:
        r103 = Character.valueOf(r106);
        goto L31
    L23:
        this.f548888c = r108;
        goto L30
    L24:
        int r110 = this.f548888c;
        if (r110 == 0) goto L30;
        int r111 = KeyCharacterMap.getDeadChar(r110, r102);
        if (r111 <= 0) goto L29;
        r106 = (char) r111;
    L29:
        this.f548888c = 0;
        goto L30
    L18:
        r107 = false;
        goto L19
    L5:
        if (r101.f380632d.a(r100.hashCode()) == null) goto L7;
        boolean r112 = true;
    L8:
        if (r112 == true) goto L12;
        if (this.f548887b.a(r100) == false) goto L12;
        return true;
    L7:
        r112 = false;
        goto L8
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence r100, int r101) {
        ByteBuffer r102 = ByteBuffer.allocateDirect(40);
        r102.order(ByteOrder.LITTLE_ENDIAN);
        r102.putLong(0);
        r102.putLong(KeyEventType.COMMIT_TEXT.ordinal());
        r102.putLong(0);
        r102.putLong(0);
        r102.putLong(0);
        FlutterRenderer r103 = this.f548886a;
        r103.f380933a.sendKeyboardEventDataPacket(r102, r100.toString());
        return super.commitText(r100, r101);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int r100, int r101) {
        this.f548886a.f380933a.deleteSurroundingText(r100, r101);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence r100, int r101) {
        ByteBuffer r102 = ByteBuffer.allocateDirect(40);
        r102.order(ByteOrder.LITTLE_ENDIAN);
        r102.putLong(0);
        r102.putLong(KeyEventType.COMMIT_COMPOSING_TEXT.ordinal());
        r102.putLong(0);
        r102.putLong(0);
        r102.putLong(0);
        FlutterRenderer r103 = this.f548886a;
        r103.f380933a.sendKeyboardEventDataPacket(r102, r100.toString());
        return true;
    }

    public a(View r100, FlutterRenderer r101, com.lynx.clay.embedding.android.a r102) {
        super(r100, true);
        this.f548888c = 0;
        this.f548886a = r101;
        this.f548887b = r102;
    }
}
