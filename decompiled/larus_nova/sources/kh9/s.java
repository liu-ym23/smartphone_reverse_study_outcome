package kh9;

import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class s {
    public static final List<q> a(List<MixVoice> r100) {
        if (r100 == null) goto L18;
        List<MixVoice> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L5:
        if (r103.hasNext() == false) goto L24;
        MixVoice r104 = (MixVoice) r103.next();
        SpeakerVoice r105 = r104.getVoiceItem();
        String r106 = "";
        if (r105 == null) goto L10;
        String r107 = r105.getId();
        if (r107 == null) goto L10;
    L11:
        SpeakerVoice r108 = r104.getVoiceItem();
        if (r108 == null) goto L17;
        String r109 = r108.getStyleId();
        if (r109 == null) goto L17;
        r106 = r109;
    L17:
        r102.add(new q(r107, r106, r104.getPercentage()));
    L10:
        r107 = "";
        goto L11
    L24:
        return r102;
    L18:
        return null;
    }
}
