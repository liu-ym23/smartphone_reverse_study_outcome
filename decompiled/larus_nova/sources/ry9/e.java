package ry9;

import androidx.camera.video.AudioStats;
import com.larus.bmhome.actionbar.model.CreationReferenceMediaType;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentType;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentViolation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import wa8.d1;
import wa8.g1;
import wa8.h1;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f539927a = null;

        static {
            int[] r100 = new int[CreationReferenceAttachmentType.values().length];
            r100[CreationReferenceAttachmentType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[CreationReferenceAttachmentType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[CreationReferenceAttachmentType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[CreationReferenceAttachmentType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f539927a = r100;
        }
    }

    static {
    }

    public static CreationReferenceMediaType a(CreationReferenceAttachmentType r100) {
        int r101 = a.f539927a[r100.ordinal()];
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 != 4) goto L12;
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return CreationReferenceMediaType.AUDIO;
    L19:
        return CreationReferenceMediaType.VIDEO;
    L16:
        return CreationReferenceMediaType.IMAGE;
    }

    public static CreationReferenceAttachmentViolation b(d1 r110, d r111) {
        Intrinsics.checkNotNullParameter(r110, "capability");
        Intrinsics.checkNotNullParameter(r111, "snapshot");
        CreationReferenceAttachmentViolation r100 = c(r110, r111);
        if (r100 == null) goto L5;
        return r100;
    L5:
        List<c> r101 = r111.f539924a;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        c r104 = (c) r103.next();
        CreationReferenceMediaType r105 = a(r104.getType());
        if (r105 == null) goto L12;
        r102.add(TuplesKt.to(r105, r104));
        goto L7
    L12:
        throw new IllegalArgumentException("Required value was null.".toString());
    L13:
        Iterator r106 = r102.iterator();
    L15:
        if (r106.hasNext() == false) goto L34;
        Pair r107 = (Pair) r106.next();
        CreationReferenceMediaType r108 = (CreationReferenceMediaType) r107.component1();
        c r109 = (c) r107.component2();
        g1 r112 = r110.d(r108);
        if (r112 == null) goto L15;
        Long r113 = r112.f558864g;
        if (r113 == null) goto L15;
        long r114 = r113.longValue();
        Integer r115 = r109.f539920h;
        Integer r116 = r109.f539921i;
        if (r115 == null) goto L33;
        if (r116 == null) goto L33;
        if (r115.intValue() <= 0) goto L33;
        if (r116.intValue() <= 0) goto L33;
        if (Math.max(r115.intValue(), r116.intValue()) <= r114) goto L15;
        return CreationReferenceAttachmentViolation.RESOLUTION;
    L33:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L34:
        Iterator r117 = r102.iterator();
    L36:
        if (r117.hasNext() == false) goto L75;
        Pair r118 = (Pair) r117.next();
        CreationReferenceMediaType r119 = (CreationReferenceMediaType) r118.component1();
        c r120 = (c) r118.component2();
        g1 r121 = r110.d(r119);
        if (r121 == null) goto L36;
        Double r122 = r120.f539922j;
        if (r121.f558869l == null) goto L43;
    L44:
        if (r122 == null) goto L74;
        if (r122.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L74;
    L48:
        if (r122 == null) goto L36;
        if (r122.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L36;
        Double r123 = r121.f558869l;
        if (r123 != null) goto L54;
    L59:
        boolean r124 = false;
    L60:
        if (r124 == true) goto L72;
        Double r125 = r121.f558870m;
        if (r125 != null) goto L64;
    L69:
        boolean r126 = false;
    L70:
        if (r126 == false) goto L36;
    L64:
        if (r122.doubleValue() <= r125.doubleValue()) goto L66;
        boolean r127 = true;
    L67:
        if (r127 != true) goto L69;
        r126 = true;
        goto L70
    L66:
        r127 = false;
    L72:
        return CreationReferenceAttachmentViolation.SINGLE_DURATION;
    L54:
        if (r122.doubleValue() >= r123.doubleValue()) goto L56;
        boolean r128 = true;
    L57:
        if (r128 != true) goto L59;
        r124 = true;
        goto L60
    L56:
        r128 = false;
    L74:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L43:
        if (r121.f558870m == null) goto L48;
    L75:
        Iterator<T> r129 = r110.f558847c.values().iterator();
    L76:
        Double r130 = null;
        if (r129.hasNext() == false) goto L143;
        g1 r131 = (g1) r129.next();
        if (r131.getType() == CreationReferenceMediaType.VIDEO) goto L83;
        if (r131.getType() != CreationReferenceMediaType.AUDIO) goto L76;
    L83:
        Double r132 = r131.f558861d;
        if (r132 == null) goto L76;
        double r133 = r132.doubleValue();
        ArrayList r134 = new ArrayList();
        Iterator r135 = r102.iterator();
    L87:
        if (r135.hasNext() == false) goto L95;
        Object r136 = r135.next();
        if (((Pair) r136).getFirst() != r131.getType()) goto L91;
        boolean r137 = true;
    L92:
        if (r137 == false) goto L87;
        r134.add(r136);
        goto L87
    L91:
        r137 = false;
        goto L92
    L95:
        if (r134.isEmpty() == true) goto L109;
        Iterator r138 = r134.iterator();
    L99:
        if (r138.hasNext() == false) goto L109;
        Double r139 = ((c) ((Pair) r138.next()).getSecond()).f539922j;
        if (r139 != null) goto L103;
    L106:
        boolean r140 = true;
    L107:
        if (r140 == false) goto L99;
        boolean r141 = true;
    L110:
        if (r141 == true) goto L112;
        if (r131.getType() != CreationReferenceMediaType.VIDEO) goto L116;
        r130 = r111.f539926c;
    L116:
        if (r130 == null) goto L128;
        double r142 = r130.doubleValue();
        if (Double.isInfinite(r142) == false) goto L120;
    L122:
        boolean r143 = false;
    L123:
        if (r143 == false) goto L127;
        if (r130.doubleValue() > AudioStats.AUDIO_AMPLITUDE_NONE) goto L128;
    L127:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L120:
        if (Double.isNaN(r142) == true) goto L122;
        r143 = true;
    L128:
        Iterator r144 = r134.iterator();
        double r145 = 0.0d;
    L130:
        if (r144.hasNext() == false) goto L136;
        Double r146 = ((c) ((Pair) r144.next()).getSecond()).f539922j;
        if (r146 == null) goto L134;
        double r147 = r146.doubleValue();
    L135:
        r145 = r145 + r147;
        goto L130
    L134:
        r147 = 0.0d;
        goto L135
    L136:
        if (r130 == null) goto L138;
        double r148 = r130.doubleValue();
    L140:
        if ((r145 + r148) <= r133) goto L76;
        return CreationReferenceAttachmentViolation.TOTAL_DURATION;
    L138:
        r148 = 0.0d;
        goto L140
    L112:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L103:
        if (r139.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L106;
        r140 = false;
    L109:
        r141 = false;
        goto L110
    L143:
        Iterator<T> r149 = r110.f558848d.iterator();
    L145:
        if (r149.hasNext() == false) goto L213;
        h1 r150 = (h1) r149.next();
        ArrayList r151 = new ArrayList();
        Iterator r152 = r102.iterator();
    L148:
        if (r152.hasNext() == false) goto L159;
        Object r153 = r152.next();
        Pair r154 = (Pair) r153;
        if (r150.f558872a.contains(r154.getFirst()) == true) goto L152;
    L156:
        boolean r155 = false;
    L157:
        if (r155 == false) goto L148;
        r151.add(r153);
        goto L148
    L152:
        if (r154.getFirst() != CreationReferenceMediaType.VIDEO) goto L154;
    L155:
        r155 = true;
        goto L157
    L154:
        if (r154.getFirst() != CreationReferenceMediaType.AUDIO) goto L156;
    L159:
        Double r156 = r150.f558875d;
        if (r156 == null) goto L145;
        double r157 = r156.doubleValue();
        Double r158 = r111.f539926c;
        if (r158 == null) goto L166;
        r158.doubleValue();
        if (r150.f558872a.contains(CreationReferenceMediaType.VIDEO) == false) goto L166;
    L168:
        if (r151.isEmpty() == true) goto L182;
        Iterator r159 = r151.iterator();
    L172:
        if (r159.hasNext() == false) goto L182;
        Double r160 = ((c) ((Pair) r159.next()).getSecond()).f539922j;
        if (r160 != null) goto L176;
    L179:
        boolean r161 = true;
    L180:
        if (r161 == false) goto L172;
        boolean r162 = true;
    L183:
        if (r162 == true) goto L185;
        if (r158 == null) goto L198;
        double r163 = r158.doubleValue();
        if (Double.isInfinite(r163) == false) goto L190;
    L192:
        boolean r164 = false;
    L193:
        if (r164 == false) goto L197;
        if (r158.doubleValue() > AudioStats.AUDIO_AMPLITUDE_NONE) goto L198;
    L197:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L190:
        if (Double.isNaN(r163) == true) goto L192;
        r164 = true;
    L198:
        Iterator r165 = r151.iterator();
        double r166 = 0.0d;
    L200:
        if (r165.hasNext() == false) goto L206;
        Double r167 = ((c) ((Pair) r165.next()).getSecond()).f539922j;
        if (r167 == null) goto L204;
        double r168 = r167.doubleValue();
    L205:
        r166 = r166 + r168;
        goto L200
    L204:
        r168 = 0.0d;
        goto L205
    L206:
        if (r158 == null) goto L208;
        double r169 = r158.doubleValue();
    L210:
        if ((r166 + r169) <= r157) goto L145;
        return CreationReferenceAttachmentViolation.TOTAL_DURATION;
    L208:
        r169 = 0.0d;
        goto L210
    L185:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L176:
        if (r160.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L179;
        r161 = false;
    L182:
        r162 = false;
    L166:
        r158 = null;
        goto L168
    L213:
        Iterator r170 = r102.iterator();
    L215:
        if (r170.hasNext() == false) goto L235;
        Pair r171 = (Pair) r170.next();
        CreationReferenceMediaType r172 = (CreationReferenceMediaType) r171.component1();
        c r173 = (c) r171.component2();
        g1 r174 = r110.d(r172);
        if (r174 == null) goto L215;
        Long r175 = r174.f558871n;
        if (r175 == null) goto L215;
        long r176 = r175.longValue();
        Long r177 = r173.f539923k;
        if (r177 != null) goto L224;
    L229:
        r177 = null;
    L230:
        if (r177 == null) goto L215;
        if (r177.longValue() <= r176) goto L215;
        return CreationReferenceAttachmentViolation.FILE_SIZE;
    L224:
        if (r177.longValue() <= 0) goto L226;
        boolean r178 = true;
    L227:
        if (r178 == false) goto L229;
    L226:
        r178 = false;
        goto L227
    L235:
        Iterator r179 = r102.iterator();
    L237:
        if (r179.hasNext() == false) goto L278;
        Pair r180 = (Pair) r179.next();
        CreationReferenceMediaType r181 = (CreationReferenceMediaType) r180.component1();
        c r182 = (c) r180.component2();
        g1 r183 = r110.d(r181);
        if (r183 == null) goto L237;
        if (r183.f558867j != null) goto L246;
        if (r183.f558868k == null) goto L237;
    L246:
        Integer r184 = r182.f539920h;
        Integer r185 = r182.f539921i;
        if (r184 == null) goto L277;
        if (r185 == null) goto L277;
        if (r184.intValue() <= 0) goto L277;
        if (r185.intValue() <= 0) goto L277;
        double r186 = ((double) r184.intValue()) / ((double) r185.intValue());
        Double r187 = r183.f558867j;
        if (r187 != null) goto L257;
    L262:
        boolean r188 = false;
    L263:
        if (r188 == true) goto L275;
        Double r189 = r183.f558868k;
        if (r189 != null) goto L267;
    L272:
        boolean r190 = false;
    L273:
        if (r190 == false) goto L237;
    L267:
        if (r186 <= r189.doubleValue()) goto L269;
        boolean r191 = true;
    L270:
        if (r191 != true) goto L272;
        r190 = true;
        goto L273
    L269:
        r191 = false;
    L275:
        return CreationReferenceAttachmentViolation.RATIO;
    L257:
        if (r186 >= r187.doubleValue()) goto L259;
        boolean r192 = true;
    L260:
        if (r192 != true) goto L262;
        r188 = true;
        goto L263
    L259:
        r192 = false;
    L277:
        return CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE;
    L278:
        return null;
    }

    public static CreationReferenceAttachmentViolation c(d1 r110, d r111) {
        Intrinsics.checkNotNullParameter(r110, "capability");
        Intrinsics.checkNotNullParameter(r111, "snapshot");
        if (r110.a(CreationReferenceMediaType.VIDEO) == false) goto L5;
        int r100 = RangesKt.coerceAtLeast(r111.f539925b, 0);
    L6:
        List<c> r112 = r111.f539924a;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r113 = r112.iterator();
    L8:
        if (r113.hasNext() == false) goto L14;
        c r102 = (c) r113.next();
        CreationReferenceMediaType r103 = a(r102.getType());
        if (r103 == null) goto L12;
        r101.add(TuplesKt.to(r103, r102));
        goto L8
    L12:
        return CreationReferenceAttachmentViolation.UNSUPPORTED_TYPE;
    L14:
        Iterator r114 = r101.iterator();
    L16:
        if (r114.hasNext() == false) goto L28;
        g1 r104 = r110.d((CreationReferenceMediaType) ((Pair) r114.next()).component1());
        if (r104 == null) goto L20;
        Integer r105 = r104.f558859b;
        if (r105 == null) goto L24;
        int r106 = r105.intValue();
    L25:
        if (r106 > 0) goto L16;
        return CreationReferenceAttachmentViolation.UNSUPPORTED_TYPE;
    L24:
        r106 = 0;
        goto L25
    L20:
        return CreationReferenceAttachmentViolation.UNSUPPORTED_TYPE;
    L28:
        Iterator<T> r115 = r110.f558847c.values().iterator();
    L29:
        boolean r107 = true;
        if (r115.hasNext() == false) goto L61;
        g1 r108 = (g1) r115.next();
        Integer r109 = r108.f558859b;
        if (r109 == null) goto L57;
        int r116 = r109.intValue();
        if (r101.isEmpty() == false) goto L36;
        int r117 = 0;
    L48:
        if (r108.getType() != CreationReferenceMediaType.VIDEO) goto L50;
        int r118 = r100;
    L52:
        if ((r117 + r118) <= r116) goto L54;
        boolean r119 = true;
    L55:
        if (r119 != true) goto L57;
    L58:
        if (r107 == false) goto L29;
        return CreationReferenceAttachmentViolation.TYPE_COUNT;
    L54:
        r119 = false;
        goto L55
    L50:
        r118 = 0;
        goto L52
    L36:
        Iterator r120 = r101.iterator();
        r117 = 0;
    L38:
        if (r120.hasNext() == false) goto L48;
        if (((Pair) r120.next()).getFirst() != r108.getType()) goto L42;
        boolean r121 = true;
    L43:
        if (r121 == false) goto L38;
        r117 = r117 + 1;
        if (r117 >= 0) goto L38;
        CollectionsKt.throwCountOverflow();
        goto L38
    L42:
        r121 = false;
    L57:
        r107 = false;
        goto L58
    L61:
        Iterator<T> r122 = r110.f558848d.iterator();
    L63:
        if (r122.hasNext() == false) goto L91;
        h1 r123 = (h1) r122.next();
        if (r101.isEmpty() == false) goto L67;
        int r124 = 0;
    L76:
        if (r123.f558872a.contains(CreationReferenceMediaType.VIDEO) == false) goto L78;
        int r125 = r100;
    L79:
        int r126 = r124 + r125;
        Integer r127 = r123.f558873b;
        if (r127 != null) goto L82;
    L87:
        boolean r128 = false;
    L88:
        if (r128 == false) goto L63;
        return CreationReferenceAttachmentViolation.MIXED_COUNT;
    L82:
        if (r126 <= r127.intValue()) goto L84;
        boolean r129 = true;
    L85:
        if (r129 != true) goto L87;
        r128 = true;
        goto L88
    L84:
        r129 = false;
        goto L85
    L78:
        r125 = 0;
        goto L79
    L67:
        Iterator r130 = r101.iterator();
        r124 = 0;
    L69:
        if (r130.hasNext() == false) goto L76;
        Pair r131 = (Pair) r130.next();
        if (r123.f558872a.contains(r131.getFirst()) == false) goto L69;
        r124 = r124 + 1;
        if (r124 >= 0) goto L69;
        CollectionsKt.throwCountOverflow();
        goto L69
    L91:
        return null;
    L5:
        r100 = 0;
        goto L6
    }
}
