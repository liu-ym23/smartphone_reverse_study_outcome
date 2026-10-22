package com.ss.android.lark.keyboard.edittext2.utils;

import android.text.Spannable;
import android.text.Spanned;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f429249a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f429250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f429251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f429252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f429253d;

        public a(String r100, int r101, int r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f429250a = r100;
            this.f429251b = r101;
            this.f429252c = r102;
            this.f429253d = r103;
        }
    }

    static {
        f429249a = CollectionsKt.listOf(new String[]{"http://", "https://"});
    }

    @JvmStatic
    public static final void a(CharSequence r110, List r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "urls");
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "urls");
        Intrinsics.checkNotNullParameter("^https?://(www\\.)?([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})+([.|/]([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})+)*/?(\\?(&?([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})*=([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})*)*)?(?:#(([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})*))?", "regexString");
        Regex r100 = new Regex("^https?://(www\\.)?([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})+([.|/]([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})+)*/?(\\?(&?([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})*=([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})*)*)?(?:#(([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})*))?");
        LinkedList r101 = new LinkedList();
        int r102 = r110.length();
    L3:
        if (r102 < 0) goto L12;
        int r103 = StringsKt.lastIndexOfAny$default(r110, f429249a, r102 - 1, false, 4, null);
        if (r103 == (-1)) goto L11;
        MatchResult r104 = Regex.find$default(r100, r110.subSequence(r103, r102), 0, 2, null);
        if (r104 == null) goto L11;
        String r105 = r104.getValue();
        if (r105 == null) goto L11;
        r101.add(0, new a(r105, r103, r105.length() + r103, false));
    L11:
        r102 = r103;
        goto L3
    L12:
        Log.i("AnchorParseUtils", "findUrls: find " + r101.size() + " urls");
        ((ArrayList) r111).addAll(r101);
        r101.isEmpty();
    }

    public static void b(CharSequence r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "urls");
        if (d.a("messenger.chat.editor.disable_filter_bare_markdown_link") == false) goto L5;
        Regex r102 = new Regex("(((https?)://([\\-a-zA-Z0-9:%_+~#@]{1,256}\\.){1,50}[a-z\\-]{2,15})|(([\\-a-zA-Z0-9:%_+~#@]{1,256}\\.){1,50}(com|org|net|int|edu|gov|mil|ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|bg|bh|bi|bj|bm|bn|bo|br|bs|bt|bv|bw|by|bz|ca|cc|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cu|cv|cw|cx|cy|cz|de|dj|dk|dm|do|dz|ec|ee|eg|eh|er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gh|gi|gl|gm|gn|gp|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|io|iq|ir|is|it|jm|jo|jp|ke|kg|kh|ki|km|kn|kp|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|lv|ly|ma|mc|md|me|mf|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|rs|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|ss|st|su|sv|sx|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|um|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|za|zm|zw|site|top|wtf|xxx|xyz|cloud|engineering|help|one)))(:[0-9]{2,5})?\\b([/?#][-a-zA-Z0-9@:%_+.~#?&/=;()$,!\\*\\[\\]{}^|<>]*)?");
    L6:
        List r103 = SequencesKt.toList(r102.findAll(r100, 0));
        if (r103.isEmpty() == false) goto L9;
        return;
    L9:
        Iterator r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        MatchResult r105 = (MatchResult) r104.next();
        String r106 = r105.getValue();
        int r107 = r105.getRange().getFirst();
        a r108 = new a(r106, r107, r106.length() + r107, false);
        ((ArrayList) r101).add(r108);
        goto L11
    L13:
        return;
    L5:
        r102 = new Regex("(((https?)://([\\-a-zA-Z0-9:%_+~#@]{1,256}\\.){1,50}[a-z\\-]{2,15})|(([\\-a-zA-Z0-9:%_+~#@]{1,256}\\.){1,50}(com|org|net|int|edu|gov|mil|ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|bg|bh|bi|bj|bm|bn|bo|br|bs|bt|bv|bw|by|bz|ca|cc|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cu|cv|cw|cx|cy|cz|de|dj|dk|dm|do|dz|ec|ee|eg|eh|er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gh|gi|gl|gm|gn|gp|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|io|iq|ir|is|it|jm|jo|jp|ke|kg|kh|ki|km|kn|kp|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|lv|ly|ma|mc|me|mf|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|rs|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|ss|st|su|sv|sx|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|um|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|za|zm|zw|site|top|wtf|xxx|xyz|cloud|engineering|help|one)))(:[0-9]{2,5})?\\b([/?#][-a-zA-Z0-9@:%_+.~#?&/=;()$,!\\*\\[\\]{}^|<>]*)?");
        goto L6
    }

    @JvmStatic
    public static final void e(CharSequence r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "urls");
        List r102 = SequencesKt.toList(new Regex("^https?://([^\\./:@\\s#\\?\\,=]+\\.){1,50}[^\\./:@\\s#\\?\\,=]+(:[0-9]{2,5})?([/?#]\\S*)?$").findAll(r100, 0));
        if (r102.size() != 1) goto L6;
        MatchResult r103 = (MatchResult) ListProtector.get(r102, 0);
        String r104 = r103.getValue();
        int r105 = r103.getRange().getFirst();
        ArrayList r106 = (ArrayList) r101;
        r106.add(new a(r104, r105, r104.length() + r105, true));
        return;
    }

    @JvmStatic
    public static final boolean c(CharSequence r100, int r110, int r111) {
        Intrinsics.checkNotNullParameter(com.ss.android.lark.keyboard.edittext2.widget.f.class, "clazz");
        Intrinsics.checkNotNullParameter("Anchor", PushClientConstants.TAG_CLASS_NAME);
        boolean r101 = false;
        if (r100 != null) goto L6;
    L33:
        return r101;
    L6:
        if ((r100 instanceof Spanned) == false) goto L33;
        Spanned r102 = (Spanned) r100;
        Object[] r103 = r102.getSpans(r110, r111, com.ss.android.lark.keyboard.edittext2.widget.f.class);
        ArrayList r104 = new ArrayList(r103.length);
        int r105 = r103.length;
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L12;
        Object r107 = r103[r106];
        r104.add(new Integer[]{Integer.valueOf(r102.getSpanStart(r107)), Integer.valueOf(r102.getSpanEnd(r107))});
        r106 = r106 + 1;
        goto L10
    L12:
        List r108 = CollectionsKt.sortedWith(r104, new c());
        if (r108.isEmpty() == false) goto L15;
        Log.i("AnchorParseUtils", "isParsedAnchor: markIndices is empty");
        goto L33
    L15:
        ArrayList r109 = new ArrayList();
        Iterator r112 = r108.iterator();
    L17:
        if (r112.hasNext() == false) goto L26;
        Integer[] r113 = (Integer[]) r112.next();
        int r114 = r113[0].intValue();
        int r115 = r113[1].intValue();
        if (r109.isEmpty() == true) goto L24;
        if (((Integer[]) CollectionsKt.last(r109))[1].intValue() < r114) goto L24;
        ((Integer[]) CollectionsKt.last(r109))[1] = Integer.valueOf(Math.max(((Integer[]) CollectionsKt.last(r109))[1].intValue(), r115));
    L24:
        r109.add(r113);
        goto L17
    L26:
        if (r109.size() == 1) goto L28;
    L32:
        Log.i("AnchorParseUtils", "isParsedAnchor: " + r101);
        goto L33
    L28:
        if (((Integer[]) ListProtector.get(r109, 0))[0].intValue() > r110) goto L32;
        if (((Integer[]) ListProtector.get(r109, 0))[1].intValue() < r111) goto L32;
        r101 = true;
        goto L32
    }

    @JvmStatic
    public static final void d(Spannable r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        com.ss.android.lark.keyboard.edittext2.widget.f.J1.getClass();
        r100.setSpan(new com.ss.android.lark.keyboard.edittext2.widget.e(), r101, r102, 33);
    }
}
