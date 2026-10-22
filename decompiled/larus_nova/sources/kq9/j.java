package kq9;

import androidx.camera.video.AudioStats;
import com.larus.platform.model.album.CreationReferenceAlbumAttachment;
import com.larus.platform.model.album.CreationReferenceAlbumConfig;
import com.larus.platform.model.album.CreationReferenceAlbumMediaRule;
import com.larus.platform.model.album.CreationReferenceAlbumMediaType;
import com.larus.platform.model.album.CreationReferenceAlbumMixedRule;
import com.larus.platform.model.album.CreationReferenceAlbumViolation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f505631a = 0;

    static {
    }

    public static CreationReferenceAlbumViolation a(CreationReferenceAlbumConfig r100, List r101, CreationReferenceAlbumAttachment r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "selected");
        Intrinsics.checkNotNullParameter(r102, "candidate");
        return b(r100, CollectionsKt.plus(r101, r102), CollectionsKt.listOf(r102));
    }

    public static CreationReferenceAlbumViolation b(CreationReferenceAlbumConfig r110, List r111, List r112) {
        List r113 = r112;
        Iterator r100 = r113.iterator();
    L3:
        int r101 = 0;
        if (r100.hasNext() == false) goto L15;
        CreationReferenceAlbumMediaRule r102 = r110.ruleFor(((CreationReferenceAlbumAttachment) r100.next()).getType());
        if (r102 == null) goto L8;
        Integer r103 = r102.getMaxCount();
        if (r103 == null) goto L12;
        r101 = r103.intValue();
    L12:
        if (r101 > 0) goto L3;
        return CreationReferenceAlbumViolation.UNSUPPORTED_TYPE;
    L8:
        return CreationReferenceAlbumViolation.UNSUPPORTED_TYPE;
    L15:
        List r114 = CollectionsKt.plus(r110.getExistingAttachments(), r111);
        CreationReferenceAlbumMediaRule r104 = r110.ruleFor(CreationReferenceAlbumMediaType.VIDEO);
        if (r104 == null) goto L20;
        Integer r105 = r104.getMaxCount();
        if (r105 == null) goto L20;
        int r106 = r105.intValue();
    L22:
        if (r106 <= 0) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == false) goto L27;
        int r108 = RangesKt.coerceAtLeast(r110.getAdditionalVideoCount(), 0);
    L28:
        Iterator<T> r109 = r110.getMediaRules().iterator();
    L30:
        if (r109.hasNext() == false) goto L56;
        CreationReferenceAlbumMediaRule r115 = (CreationReferenceAlbumMediaRule) r109.next();
        Integer r116 = r115.getMaxCount();
        if (r116 == null) goto L30;
        int r117 = r116.intValue();
        List r118 = r114;
        if ((r118 instanceof Collection) == true) goto L36;
    L38:
        Iterator r119 = r118.iterator();
        int r120 = 0;
    L40:
        if (r119.hasNext() == false) goto L50;
        if (((CreationReferenceAlbumAttachment) r119.next()).getType() != r115.getType()) goto L44;
        boolean r121 = true;
    L45:
        if (r121 == false) goto L40;
        r120 = r120 + 1;
        if (r120 >= 0) goto L40;
        CollectionsKt.throwCountOverflow();
        goto L40
    L44:
        r121 = false;
    L50:
        if (r115.getType() != CreationReferenceAlbumMediaType.VIDEO) goto L52;
        int r122 = r108;
    L54:
        if ((r120 + r122) <= r117) goto L30;
        CreationReferenceAlbumViolation r123 = CreationReferenceAlbumViolation.TYPE_COUNT;
    L88:
        if (r123 == null) goto L90;
        return r123;
    L90:
        Iterator r124 = r113.iterator();
    L92:
        if (r124.hasNext() == false) goto L112;
        CreationReferenceAlbumAttachment r125 = (CreationReferenceAlbumAttachment) r124.next();
        CreationReferenceAlbumMediaRule r126 = r110.ruleFor(r125.getType());
        if (r126 == null) goto L109;
        Long r127 = r126.getMaxResolution();
        if (r127 == null) goto L109;
        long r128 = r127.longValue();
        Integer r129 = r125.getWidth();
        Integer r130 = r125.getHeight();
        if (r129 == null) goto L108;
        if (r130 == null) goto L108;
        if (r129.intValue() <= 0) goto L108;
        if (r130.intValue() <= 0) goto L108;
        if (Math.max(r129.intValue(), r130.intValue()) <= r128) goto L109;
        CreationReferenceAlbumViolation r131 = CreationReferenceAlbumViolation.RESOLUTION;
    L110:
        if (r131 == null) goto L92;
        return r131;
    L108:
        r131 = CreationReferenceAlbumViolation.METADATA_UNAVAILABLE;
    L109:
        r131 = null;
        goto L110
    L112:
        Iterator r132 = r113.iterator();
    L114:
        if (r132.hasNext() == false) goto L154;
        CreationReferenceAlbumAttachment r133 = (CreationReferenceAlbumAttachment) r132.next();
        CreationReferenceAlbumMediaRule r134 = r110.ruleFor(r133.getType());
        if (r134 != null) goto L119;
    L149:
        CreationReferenceAlbumViolation r135 = null;
    L152:
        if (r135 == null) goto L114;
        return r135;
    L119:
        if (r134.getMinSingleDuration() == null) goto L121;
    L123:
        Double r136 = r133.getDurationSeconds();
        if (r136 != null) goto L126;
    L151:
        r135 = CreationReferenceAlbumViolation.METADATA_UNAVAILABLE;
        goto L152
    L126:
        if (r136.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L151;
        Double r137 = r134.getMinSingleDuration();
        if (r137 != null) goto L131;
    L136:
        boolean r138 = false;
    L137:
        if (r138 == true) goto L150;
        Double r139 = r134.getMaxSingleDuration();
        if (r139 != null) goto L141;
    L146:
        boolean r140 = false;
    L147:
        if (r140 == false) goto L149;
    L141:
        if (r136.doubleValue() <= r139.doubleValue()) goto L143;
        boolean r141 = true;
    L144:
        if (r141 != true) goto L146;
        r140 = true;
        goto L147
    L143:
        r141 = false;
    L150:
        r135 = CreationReferenceAlbumViolation.SINGLE_DURATION;
        goto L152
    L131:
        if (r136.doubleValue() >= r137.doubleValue()) goto L133;
        boolean r142 = true;
    L134:
        if (r142 != true) goto L136;
        r138 = true;
        goto L137
    L133:
        r142 = false;
        goto L134
    L121:
        if (r134.getMaxSingleDuration() != null) goto L123;
    L154:
        Iterator<T> r143 = r110.getMediaRules().iterator();
    L156:
        if (r143.hasNext() == false) goto L180;
        CreationReferenceAlbumMediaRule r144 = (CreationReferenceAlbumMediaRule) r143.next();
        if (r144.getType() == CreationReferenceAlbumMediaType.VIDEO) goto L162;
        if (r144.getType() != CreationReferenceAlbumMediaType.AUDIO) goto L156;
    L162:
        Double r145 = r144.getMaxTotalDuration();
        if (r145 == null) goto L156;
        double r146 = r145.doubleValue();
        ArrayList r147 = new ArrayList();
        Iterator r148 = r114.iterator();
    L166:
        if (r148.hasNext() == false) goto L174;
        Object r149 = r148.next();
        if (((CreationReferenceAlbumAttachment) r149).getType() != r144.getType()) goto L170;
        boolean r150 = true;
    L171:
        if (r150 == false) goto L166;
        r147.add(r149);
        goto L166
    L170:
        r150 = false;
        goto L171
    L174:
        if (r144.getType() != CreationReferenceAlbumMediaType.VIDEO) goto L176;
        Double r151 = r110.getAdditionalVideoDurationSeconds();
    L177:
        CreationReferenceAlbumViolation r152 = c(r147, r146, r151);
        if (r152 == null) goto L156;
    L208:
        if (r152 == null) goto L210;
        return r152;
    L210:
        Iterator r153 = r113.iterator();
    L212:
        if (r153.hasNext() == false) goto L233;
        CreationReferenceAlbumAttachment r154 = (CreationReferenceAlbumAttachment) r153.next();
        CreationReferenceAlbumMediaRule r155 = r110.ruleFor(r154.getType());
        if (r155 == null) goto L230;
        Long r156 = r155.getMaxFileSize();
        if (r156 == null) goto L230;
        long r157 = r156.longValue();
        Long r158 = r154.getFileSize();
        if (r158 == null) goto L230;
        if (r158.longValue() <= 0) goto L222;
        boolean r159 = true;
    L223:
        if (r159 == true) goto L226;
        r158 = null;
    L226:
        if (r158 == null) goto L230;
        if (r158.longValue() <= r157) goto L230;
        CreationReferenceAlbumViolation r160 = CreationReferenceAlbumViolation.FILE_SIZE;
    L231:
        if (r160 == null) goto L212;
        return r160;
    L222:
        r159 = false;
    L230:
        r160 = null;
        goto L231
    L233:
        Iterator r161 = r113.iterator();
    L235:
        if (r161.hasNext() == false) goto L278;
        CreationReferenceAlbumAttachment r162 = (CreationReferenceAlbumAttachment) r161.next();
        CreationReferenceAlbumMediaRule r163 = r110.ruleFor(r162.getType());
        if (r163 != null) goto L240;
    L273:
        CreationReferenceAlbumViolation r164 = null;
    L276:
        if (r164 == null) goto L235;
        return r164;
    L240:
        if (r163.getMinRatio() == null) goto L242;
    L244:
        Integer r165 = r162.getWidth();
        Integer r166 = r162.getHeight();
        if (r165 == null) goto L275;
        if (r166 == null) goto L275;
        if (r165.intValue() <= 0) goto L275;
        if (r166.intValue() <= 0) goto L275;
        double r167 = ((double) r165.intValue()) / ((double) r166.intValue());
        Double r168 = r163.getMinRatio();
        if (r168 != null) goto L255;
    L260:
        boolean r169 = false;
    L261:
        if (r169 == true) goto L274;
        Double r170 = r163.getMaxRatio();
        if (r170 != null) goto L265;
    L270:
        boolean r171 = false;
    L271:
        if (r171 == false) goto L273;
    L265:
        if (r167 <= r170.doubleValue()) goto L267;
        boolean r172 = true;
    L268:
        if (r172 != true) goto L270;
        r171 = true;
        goto L271
    L267:
        r172 = false;
    L274:
        r164 = CreationReferenceAlbumViolation.RATIO;
        goto L276
    L255:
        if (r167 >= r168.doubleValue()) goto L257;
        boolean r173 = true;
    L258:
        if (r173 != true) goto L260;
        r169 = true;
        goto L261
    L257:
        r173 = false;
    L275:
        r164 = CreationReferenceAlbumViolation.METADATA_UNAVAILABLE;
        goto L276
    L242:
        if (r163.getMaxRatio() != null) goto L244;
    L278:
        return null;
    L176:
        r151 = null;
        goto L177
    L180:
        Iterator<T> r174 = r110.getMixedRules().iterator();
    L182:
        if (r174.hasNext() == false) goto L207;
        CreationReferenceAlbumMixedRule r175 = (CreationReferenceAlbumMixedRule) r174.next();
        Double r176 = r175.getMaxTotalDuration();
        if (r176 == null) goto L182;
        double r177 = r176.doubleValue();
        ArrayList r178 = new ArrayList();
        Iterator r179 = r114.iterator();
    L187:
        if (r179.hasNext() == false) goto L198;
        Object r180 = r179.next();
        CreationReferenceAlbumAttachment r181 = (CreationReferenceAlbumAttachment) r180;
        if (r175.getSubTypes().contains(r181.getType()) == true) goto L191;
    L195:
        boolean r182 = false;
    L196:
        if (r182 == false) goto L187;
        r178.add(r180);
        goto L187
    L191:
        if (r181.getType() != CreationReferenceAlbumMediaType.VIDEO) goto L193;
    L194:
        r182 = true;
        goto L196
    L193:
        if (r181.getType() != CreationReferenceAlbumMediaType.AUDIO) goto L195;
    L198:
        Double r183 = r110.getAdditionalVideoDurationSeconds();
        if (r183 == null) goto L203;
        r183.doubleValue();
        if (r175.getSubTypes().contains(CreationReferenceAlbumMediaType.VIDEO) == false) goto L203;
    L205:
        if (c(r178, r177, r183) == null) goto L182;
        r152 = CreationReferenceAlbumViolation.MIXED_TOTAL_DURATION;
    L203:
        r183 = null;
        goto L205
    L207:
        r152 = null;
        goto L208
    L52:
        r122 = 0;
        goto L54
    L36:
        if (r118.isEmpty() == false) goto L38;
        r120 = 0;
        goto L50
    L56:
        Iterator<T> r184 = r110.getMixedRules().iterator();
    L58:
        if (r184.hasNext() == false) goto L87;
        CreationReferenceAlbumMixedRule r185 = (CreationReferenceAlbumMixedRule) r184.next();
        List r186 = r114;
        if ((r186 instanceof Collection) == true) goto L62;
    L64:
        Iterator r187 = r186.iterator();
        int r188 = 0;
    L66:
        if (r187.hasNext() == false) goto L73;
        if (r185.getSubTypes().contains(((CreationReferenceAlbumAttachment) r187.next()).getType()) == false) goto L66;
        r188 = r188 + 1;
        if (r188 >= 0) goto L66;
        CollectionsKt.throwCountOverflow();
    L73:
        if (r185.getSubTypes().contains(CreationReferenceAlbumMediaType.VIDEO) == false) goto L75;
        int r189 = r108;
    L76:
        int r190 = r188 + r189;
        Integer r191 = r185.getMaxCount();
        if (r191 != null) goto L79;
    L84:
        boolean r192 = false;
    L85:
        if (r192 == false) goto L58;
        r123 = CreationReferenceAlbumViolation.MIXED_COUNT;
        goto L88
    L79:
        if (r190 <= r191.intValue()) goto L81;
        boolean r193 = true;
    L82:
        if (r193 != true) goto L84;
        r192 = true;
        goto L85
    L81:
        r193 = false;
        goto L82
    L75:
        r189 = 0;
        goto L76
    L62:
        if (r186.isEmpty() == false) goto L64;
        r188 = 0;
        goto L73
    L87:
        r123 = null;
        goto L88
    L27:
        r108 = 0;
        goto L28
    L24:
        r107 = false;
    L20:
        r106 = 0;
        goto L22
    }

    public static CreationReferenceAlbumViolation c(List r100, double r101, Double r110) {
        boolean r102 = r100.isEmpty();
        boolean r103 = false;
        double r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r102 == true) goto L17;
        Iterator r105 = r100.iterator();
    L7:
        if (r105.hasNext() == false) goto L17;
        CreationReferenceAlbumAttachment r106 = (CreationReferenceAlbumAttachment) r105.next();
        if (r106.getDurationSeconds() != null) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == false) goto L7;
        boolean r108 = true;
    L18:
        if (r108 == true) goto L20;
        if (r110 == null) goto L32;
        double r109 = r110.doubleValue();
        if (Double.isInfinite(r109) == false) goto L25;
    L27:
        if (r103 == false) goto L31;
        if (r110.doubleValue() > AudioStats.AUDIO_AMPLITUDE_NONE) goto L32;
    L31:
        return CreationReferenceAlbumViolation.METADATA_UNAVAILABLE;
    L25:
        if (Double.isNaN(r109) == true) goto L27;
        r103 = true;
    L32:
        Iterator r111 = r100.iterator();
        double r112 = 0.0d;
    L34:
        if (r111.hasNext() == false) goto L40;
        Double r113 = ((CreationReferenceAlbumAttachment) r111.next()).getDurationSeconds();
        if (r113 == null) goto L38;
        double r114 = r113.doubleValue();
    L39:
        r112 = r112 + r114;
        goto L34
    L38:
        r114 = 0.0d;
        goto L39
    L40:
        if (r110 == null) goto L43;
        r104 = r110.doubleValue();
    L43:
        if ((r112 + r104) > r101) goto L55;
        return null;
    L55:
        return CreationReferenceAlbumViolation.TOTAL_DURATION;
    L20:
        return CreationReferenceAlbumViolation.METADATA_UNAVAILABLE;
    L11:
        if (r106.getDurationSeconds().doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        r107 = false;
    L17:
        r108 = false;
        goto L18
    }
}
