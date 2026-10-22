package jh9;

import com.larus.im.bean.bot.SpeakerVoice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f499116a = 0;

    static {
    }

    public static int e(Boolean r100) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L5;
        return 0;
    L5:
        return 2;
    }

    public static List f(List r100) {
        if (r100 != null) goto L4;
        r100 = CollectionsKt.emptyList();
    L4:
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (((SpeakerVoice) r103).getStatus() == 2) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L6;
        r101.add(r103);
        goto L6
    L10:
        r104 = false;
        goto L11
    L13:
        return r101;
    }

    public static h b(f r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        boolean r102 = false;
        if (r101 == null) goto L5;
        List<SpeakerVoice> r103 = r100.f499115c;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r106).getId(), r101) == true) goto L8;
        r104.add(r106);
        goto L8
    L12:
        List<SpeakerVoice> r107 = r100.f499113a;
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L14:
        if (r109.hasNext() == false) goto L18;
        Object r110 = r109.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r110).getId(), r101) == true) goto L14;
        r108.add(r110);
        goto L14
    L18:
        List<SpeakerVoice> r111 = r100.f499114b;
        ArrayList r112 = new ArrayList();
        Iterator<T> r113 = r111.iterator();
    L20:
        if (r113.hasNext() == false) goto L24;
        Object r114 = r113.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r114).getId(), r101) == true) goto L20;
        r112.add(r114);
        goto L20
    L24:
        f r115 = f.a(r108, r112, r104);
        if (r104.size() == r100.f499115c.size()) goto L28;
        r102 = true;
    L28:
        return new h(r115, r102);
    L5:
        return new h(r100, false);
    }

    public static h a(f r100, String r101, SpeakerVoice r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r102, "voice");
        List<SpeakerVoice> r103 = r100.f499115c;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L3:
        boolean r106 = true;
        if (r105.hasNext() == false) goto L24;
        Object r107 = r105.next();
        SpeakerVoice r108 = (SpeakerVoice) r107;
        if (r101 != null) goto L8;
    L11:
        boolean r109 = true;
    L12:
        if (r109 == false) goto L14;
    L16:
        boolean r110 = false;
    L17:
        if (r110 == false) goto L19;
    L22:
        if (r106 == true) goto L3;
        r104.add(r107);
        goto L3
    L19:
        if (Intrinsics.areEqual(r108.getId(), r102.getId()) == true) goto L22;
        r106 = false;
        goto L22
    L14:
        if (Intrinsics.areEqual(r108.getId(), r101) == false) goto L16;
        r110 = true;
        goto L17
    L8:
        if (StringsKt.isBlank(r101) == true) goto L11;
        r109 = false;
        goto L12
    L24:
        f r111 = f.a(c(r102, r100.f499113a, r101), c(r102, r100.f499114b, r101), r104);
        if (r104.size() != r100.f499115c.size()) goto L29;
        r106 = false;
    L29:
        return new h(r111, r106);
    }

    public static List c(SpeakerVoice r100, List r101, String r102) {
        String r103 = r100.getId();
        List r104 = CollectionsKt.listOf(r100);
        ArrayList r105 = new ArrayList();
        Iterator r106 = r101.iterator();
    L4:
        if (r106.hasNext() == false) goto L25;
        Object r107 = r106.next();
        SpeakerVoice r108 = (SpeakerVoice) r107;
        boolean r109 = true;
        if (Intrinsics.areEqual(r108.getId(), r103) == false) goto L8;
    L22:
        if (r109 == true) goto L4;
        r105.add(r107);
        goto L4
    L8:
        if (r102 != null) goto L10;
    L13:
        boolean r110 = true;
    L14:
        if (r110 == false) goto L16;
    L18:
        boolean r111 = false;
    L19:
        if (r111 == true) goto L22;
        r109 = false;
        goto L22
    L16:
        if (Intrinsics.areEqual(r108.getId(), r102) == false) goto L18;
        r111 = true;
        goto L19
    L10:
        if (StringsKt.isBlank(r102) == true) goto L13;
        r110 = false;
        goto L14
    L25:
        return CollectionsKt.plus(r104, r105);
    }

    public static List d(List r100, String r101, SpeakerVoice r102) {
        List r103 = r100;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L9;
        SpeakerVoice r106 = (SpeakerVoice) r105.next();
        if (Intrinsics.areEqual(r106.getId(), r101) == false) goto L8;
        r106 = r102;
    L8:
        r104.add(r106);
        goto L4
    L9:
        return r104;
    }
}
