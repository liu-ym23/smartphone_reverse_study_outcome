package androidx.compose.foundation.text;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/text/DeadKeyCombiner;", "", "<init>", "()V", "deadKeyCode", "", "Ljava/lang/Integer;", "consume", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "consume-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Integer;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeadKeyCombiner {
    public static final int $stable = 8;
    private Integer deadKeyCode;

    public DeadKeyCombiner() {
    }

    /* JADX INFO: renamed from: consume-ZmokQxo, reason: not valid java name */
    public final Integer m1366consumeZmokQxo(KeyEvent r4) {
        int r5 = KeyEvent_androidKt.getUtf16CodePoint-ZmokQxo(r4);
        Integer r1 = null;
        if ((Integer.MIN_VALUE & r5) == 0) goto L6;
        this.deadKeyCode = Integer.valueOf(r5 & Integer.MAX_VALUE);
        return null;
    L6:
        Integer r0 = this.deadKeyCode;
        if (r0 == null) goto L19;
        this.deadKeyCode = null;
        Integer r2 = Integer.valueOf(KeyCharacterMap.getDeadChar(r0.intValue(), r5));
        if (r2.intValue() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
        r1 = r2;
    L14:
        if (r1 == null) goto L17;
        r5 = r1.intValue();
    L17:
        return Integer.valueOf(r5);
    L11:
        r3 = false;
        goto L12
    L19:
        return Integer.valueOf(r5);
    }
}
