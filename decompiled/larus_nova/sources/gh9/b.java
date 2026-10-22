package gh9;

import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.Iterator;
import java.util.List;
import jh9.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {
    public static final String a(List<MixVoice> r100) {
        if (r100 == null) goto L27;
        Iterator<T> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L39;
        MixVoice r102 = (MixVoice) r101.next();
        List<SpeakerVoice> r103 = e.f499112a;
        SpeakerVoice r104 = r102.getVoiceItem();
        if (r104 == null) goto L9;
        String r105 = r104.getId();
    L10:
        boolean r106 = false;
        if (r105 == null) goto L24;
        List<SpeakerVoice> r107 = e.f499112a;
        if (r107.isEmpty() == true) goto L24;
        Iterator<SpeakerVoice> r108 = r107.iterator();
        int r109 = 0;
    L18:
        if (r108.hasNext() == false) goto L24;
        SpeakerVoice r110 = r108.next();
        if (Intrinsics.areEqual(r105, r110.getId()) == true) goto L21;
        r109 = r109 + 1;
        if (r109 < 10) goto L18;
    L21:
        r106 = r110.getBestMatch();
    L24:
        if (r106 == false) goto L5;
        return "1";
    L9:
        r105 = null;
        goto L10
    L39:
        return "0";
    L27:
        return "0";
    }

    public static final String b(List<MixVoice> r100) {
        if (r100 == null) goto L10;
        Iterator<T> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L15;
        if (((MixVoice) r101.next()).getPercentage() == 100) goto L5;
        return "1";
    L15:
        return "0";
    L10:
        return "0";
    }
}
