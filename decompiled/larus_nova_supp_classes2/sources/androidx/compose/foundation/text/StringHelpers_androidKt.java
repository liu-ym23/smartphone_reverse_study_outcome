package androidx.compose.foundation.text;

import androidx.emoji2.text.EmojiCompat;
import java.text.BreakIterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u000b"}, d2 = {"findPrecedingBreak", "", "", "index", "findFollowingBreak", "findCodePointBefore", "", "ifNotFound", "findCodePointOrEmojiStartBefore", "getEmojiCompatIfLoaded", "Landroidx/emoji2/text/EmojiCompat;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StringHelpers_androidKt {
    private static final EmojiCompat getEmojiCompatIfLoaded() {
        if (EmojiCompat.isConfigured() == false) goto L11;
        EmojiCompat r0 = EmojiCompat.get();
        boolean r3 = true;
        if (r0.getLoadState() == 1) goto L8;
        r3 = false;
    L8:
        if (r3 == true) goto L10;
        return null;
    L10:
        return r0;
    L11:
        return null;
    }

    public static final int findFollowingBreak(String r4, int r5) {
        EmojiCompat r0 = getEmojiCompatIfLoaded();
        Integer r1 = null;
        if (r0 == null) goto L10;
        Integer r2 = Integer.valueOf(r0.getEmojiEnd(r4, r5));
        if (r2.intValue() != (-1)) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L10;
        r1 = r2;
        goto L10
    L7:
        r3 = false;
    L10:
        if (r1 != null) goto L12;
        BreakIterator r6 = BreakIterator.getCharacterInstance();
        r6.setText(r4);
        return r6.following(r5);
    L12:
        return r1.intValue();
    }

    public static final int findPrecedingBreak(String r5, int r6) {
        EmojiCompat r0 = getEmojiCompatIfLoaded();
        Integer r1 = null;
        if (r0 == null) goto L9;
        boolean r3 = false;
        Integer r2 = Integer.valueOf(r0.getEmojiStart(r5, Math.max(0, r6 - 1)));
        if (r2.intValue() != (-1)) goto L7;
        r3 = true;
    L7:
        if (r3 == true) goto L9;
        r1 = r2;
    L9:
        if (r1 != null) goto L11;
        BreakIterator r4 = BreakIterator.getCharacterInstance();
        r4.setText(r5);
        return r4.preceding(r6);
    L11:
        return r1.intValue();
    }

    private static final int findCodePointBefore(CharSequence r0, int r1, int r2) {
        if (r1 > 0) goto L5;
        return r2;
    L5:
        return Character.offsetByCodePoints(r0, r1, -1);
    }

    public static final int findCodePointOrEmojiStartBefore(String r2, int r3, int r4) {
        if (r3 > 0) goto L4;
        return r4;
    L4:
        EmojiCompat r0 = getEmojiCompatIfLoaded();
        if (r0 == null) goto L7;
        int r1 = r0.getEmojiStart(r2, r3 - 1);
        if (r1 < 0) goto L11;
        return r1;
    L11:
        return findCodePointBefore(r2, r3, r4);
    L7:
        return findCodePointBefore(r2, r3, r4);
    }
}
