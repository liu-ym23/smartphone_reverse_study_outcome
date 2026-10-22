package mb2;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.e5;
import com.bytedance.android.live.base.model.message.h5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.utils.w2;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import ek6.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ob2.f;
import py.k;
import qb2.g;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f512775a = 0;

    static {
        f512775a = s1.f(20.0f);
    }

    public static ImageStyle a(float r110) {
        return new ImageStyle(ImageStyle.AdjustType.SCALE, 0, 0, r110, (int) (f512775a * r110), 0, null, null, null, 0, 0, null, 0, 0, 0, 2097126);
    }

    public static ib2.a b(tb2.c r100, tb2.b r101) {
        m6 r102 = r100.getConvertedSchema();
        if (r102 != null) goto L5;
    L8:
        if (r101 != null) goto L10;
        i5 r103 = r100.getUserValue();
        if (r103 == null) goto L14;
        IBaseUser r104 = r103.getUser();
    L15:
        if (r104 != null) goto L17;
    L20:
        return null;
    L17:
        if (r100.getType() != PieceType.USER.getPieceType()) goto L20;
        return new ib2.a(new b(r104));
    L14:
        r104 = null;
        goto L15
    L10:
        return new ib2.a(r101);
    L5:
        if (TextUtils.isEmpty(r102.a()) == true) goto L8;
        return new ib2.a(new a(r102));
    }

    public static e c(tb2.d r310, float r311, String r312) {
        Intrinsics.checkNotNullParameter(r310, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r312, "source");
        bk6.a r100 = new bk6.a();
        yb2.a r101 = r310.f545243b;
        b5 r102 = r310.f545244c;
        float r103 = 0;
        if (r311 <= r103) goto L5;
        float r104 = r311;
    L6:
        List<tb2.c> r105 = r310.f545242a;
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L8:
        if (r107.hasNext() == false) goto L234;
        tb2.c r108 = (tb2.c) r107.next();
        int r110 = r108.getType();
        if (r110 != PieceType.IMAGE.getPieceType()) goto L116;
        ITextPieceImage r111 = r108.getImageValue();
        if (r111 == null) goto L14;
        Integer r112 = Integer.valueOf(r111.getLocalResId());
    L15:
        ITextPieceImage r113 = r108.getImageValue();
        if (r113 == null) goto L18;
        k r114 = r113.getImageModel();
    L19:
        if (r112 != null) goto L21;
    L23:
        if (r114 != null) goto L25;
    L29:
        if (r114 != null) goto L31;
    L35:
        if (r114 != null) goto L37;
    L39:
        ek6.b r115 = null;
    L40:
        if (r115 != null) goto L42;
        Iterator r313 = r107;
        bk6.a r314 = r100;
        float r315 = r103;
        r106 = r106;
    L126:
        ek6.d r116 = null;
    L230:
        ArrayList r109 = r106;
        if (r116 == null) goto L233;
        r109.add(r116);
    L233:
        r106 = r109;
        r107 = r313;
        r103 = r315;
        r100 = r314;
        goto L8
    L42:
        if (r114 == null) goto L53;
        k.b r117 = r114.getImageContent();
        if (r117 == null) goto L53;
        String r118 = r117.getAccessibilityText();
        if (r118 == null) goto L53;
        if ((!TextUtils.isEmpty(r118)) == true) goto L51;
        r118 = null;
    L51:
        if (r118 == null) goto L53;
        jb2.b r119 = new jb2.b(r118);
    L54:
        ITextPieceImage r120 = r108.getImageValue();
        if (r120 != null) goto L57;
        ImageStyle r121 = a(r104);
    L82:
        ImageStyle.AdjustType r122 = r121.f255752a;
        int r123 = r121.f255753b;
        int r124 = r121.f255754c;
        float r125 = r121.f255755d;
        r313 = r107;
        int r126 = r121.f255756e;
        r315 = r103;
        int r127 = r121.f255757f;
        ImageStyle.PlaceHolderType r210 = ImageStyle.PlaceHolderType.EMPTY;
        ITextPieceImage r128 = r108.getImageValue();
        if (r128 == null) goto L87;
        int r129 = r123;
        r314 = r100;
        if (r128.getEnableTextWhenFailed() != true) goto L88;
        ImageStyle.PlaceHolderType r211 = ImageStyle.PlaceHolderType.TEXT;
    L89:
        String r212 = r108.getText();
        ImageStyle.AdjustType r130 = r121.f255752a;
        ImageStyle.AdjustType r131 = ImageStyle.AdjustType.EXACTLY;
        if (r130 != r131) goto L92;
        int r213 = r121.f255754c;
    L93:
        if (r130 != r131) goto L95;
        int r214 = r121.f255753b;
    L96:
        ImageStyle.AlignmentType r215 = ImageStyle.AlignmentType.CENTER_ALIGN_TO_LINE_CENTER;
        int r216 = r108.getVerticalOffset();
        ITextPieceImage r132 = r108.getImageValue();
        if (r132 != null) goto L99;
    L101:
        int r217 = 0;
    L102:
        ImageStyle r133 = new ImageStyle(r122, r129, r124, r125, r126, r127, r210, r211, r212, r213, r214, r215, r216, r217, 0, 1048576);
        ib2.a r134 = b(r108, r108.getClickAction());
        ITextPieceImage r135 = r108.getImageValue();
        if ((r135 instanceof h5) == true) goto L105;
        ITextPieceImage r136 = null;
    L106:
        h5 r137 = (h5) r136;
        if (r137 != null) goto L109;
    L111:
        if (r137 != null) goto L113;
    L115:
        ek6.d r138 = new jb2.c(r115, r133, r134, r119);
    L123:
        r116 = r138;
        goto L230
    L113:
        if ((r115 instanceof f) == true) goto L115;
        r138 = new jb2.e(r137.getTextType(), r137.getTextContent(), r137.getTextColor(), r115, r133, r134, r119);
        goto L123
    L109:
        if ((r115 instanceof f) == false) goto L111;
        r138 = new jb2.f(r137.getTextContent(), r137.getTextColor(), r137.getTextSizeRate(), (f) r115, r133, r134, r119);
        goto L123
    L105:
        r136 = r135;
        goto L106
    L99:
        if (r132.isNeedExtraSpace() != true) goto L101;
        r217 = 10;
        goto L102
    L95:
        r214 = 0;
        goto L96
    L92:
        r213 = 0;
    L88:
        r211 = r210;
        goto L89
    L87:
        r314 = r100;
        r129 = r123;
        goto L88
    L57:
        k r139 = r120.getImageModel();
        if (r139 != null) goto L61;
        r121 = a(r104);
        goto L82
    L61:
        if (r120.getHeight() <= 0) goto L66;
        if (r120.getWidth() <= 0) goto L66;
        r121 = new ImageStyle(ImageStyle.AdjustType.EXACTLY, (int) (r120.getHeight() * r104), (int) (r120.getWidth() * r104), 0.0f, 0, 0, null, null, null, 0, 0, null, 0, 0, 0, 2097144);
    L66:
        if (r120.getScaleType() != ITextPieceImage.ScaleType.FIT_Y) goto L72;
        if (r120.getHeight() <= 0) goto L72;
        ImageStyle r140 = new ImageStyle(ImageStyle.AdjustType.ADJUST_HEIGHT, (int) (r120.getHeight() * r104), 0, 0.0f, 0, 0, null, null, null, 0, 0, null, 0, 0, 0, 2097148);
    L70:
        r121 = r140;
    L72:
        if (r120.getScaleX() <= r103) goto L77;
        if (r120.getScaleY() <= r103) goto L77;
        r140 = new ImageStyle(ImageStyle.AdjustType.SCALE, 0, 0, r120.getScaleX() * r104, 0, 0, null, null, null, 0, 0, null, 0, 0, 0, 2097142);
    L77:
        if (r139.getHeight() > 0) goto L79;
    L81:
        r121 = a(r104);
        goto L82
    L79:
        if (r139.getWidth() <= 0) goto L81;
        ImageStyle.AdjustType r141 = ImageStyle.AdjustType.EXACTLY;
        float r142 = r139.getWidth();
        int r143 = w2.f159201a;
        r121 = new ImageStyle(r141, (int) ((r139.getHeight() * s1.E()) * r104), (int) ((r142 * s1.E()) * r104), 0.0f, 0, 0, null, null, null, 0, 0, null, 0, 0, 0, 2097144);
    L53:
        r119 = null;
        goto L54
    L37:
        if (r114.isValid() != true) goto L39;
        r115 = new ob2.c(r114.getUrls(), r108.getImageDefaultRes());
        goto L40
    L31:
        if (r114.isResizableImg() != true) goto L35;
        if (r114.isValid() == false) goto L35;
        r115 = new f(r114.getUrls());
        goto L40
    L25:
        if (r114.isAnimated() != true) goto L29;
        if (r114.isValid() == false) goto L29;
        r115 = new ob2.a(r114.getUrls());
        goto L40
    L21:
        if (r112.intValue() == 0) goto L23;
        r115 = new ob2.d(r112.intValue());
        goto L40
    L18:
        r114 = null;
        goto L19
    L14:
        r112 = null;
        goto L15
    L116:
        r313 = r107;
        r314 = r100;
        r315 = r103;
        r106 = r106;
        if (r110 != PieceType.GIFT.getPieceType()) goto L125;
        e5 r144 = r108.getGiftValue();
        if (r144 == null) goto L121;
        long r145 = r144.getGiftId();
    L122:
        r138 = new jb2.c(new ob2.b(r145), a(r104), b(r108, r108.getClickAction()), null);
        goto L123
    L121:
        r145 = 0;
        goto L122
    L125:
        if (r110 == PieceType.HEART.getPieceType()) goto L126;
        PieceType r146 = PieceType.STRING;
        if (r110 != r146.getPieceType()) goto L153;
        String r147 = r108.getText();
        Integer r148 = Integer.valueOf(w.b(r146.getPieceType(), r108.getFormat(), r102, r101));
        b5 r149 = r108.getFormat();
        if (r149 == null) goto L138;
        Integer r150 = Integer.valueOf(r149.getFontSize());
        if (r150.intValue() <= 0) goto L134;
        boolean r151 = true;
    L136:
        if (Boolean.valueOf(r151).booleanValue() == false) goto L138;
        Integer r152 = r150;
    L139:
        Boolean r153 = Boolean.TRUE;
        b5 r154 = r108.getFormat();
        if (r154 != null) goto L142;
        boolean r155 = false;
    L147:
        b5 r156 = r108.getFormat();
        if (r156 == null) goto L150;
        boolean r157 = r156.isItalic();
    L151:
        r116 = new jb2.d(r147, new gk6.a(r148, r152, r153, r155, r157, false, null), b(r108, r108.getClickAction()), 8);
        goto L230
    L150:
        r157 = false;
        goto L151
    L142:
        if (Integer.valueOf(r154.getWeight()).intValue() < 700) goto L144;
        boolean r158 = true;
    L145:
        r155 = r158;
        goto L147
    L144:
        r158 = false;
        goto L145
    L134:
        r151 = false;
    L138:
        r152 = null;
        goto L139
    L153:
        PieceType r159 = PieceType.USER;
        if (r110 != r159.getPieceType()) goto L182;
        String r160 = r108.getText();
        Integer r161 = Integer.valueOf(w.b(r159.getPieceType(), r108.getFormat(), r102, r101));
        b5 r162 = r108.getFormat();
        if (r162 == null) goto L164;
        Integer r163 = Integer.valueOf(r162.getFontSize());
        if (r163.intValue() <= 0) goto L160;
        boolean r164 = true;
    L162:
        if (Boolean.valueOf(r164).booleanValue() == false) goto L164;
        Integer r165 = r163;
    L165:
        Boolean r166 = Boolean.TRUE;
        b5 r167 = r108.getFormat();
        if (r167 != null) goto L168;
        boolean r168 = false;
    L173:
        b5 r169 = r108.getFormat();
        if (r169 == null) goto L176;
        boolean r170 = r169.isItalic();
    L178:
        if (r101 == null) goto L180;
        Integer r171 = Integer.valueOf(r101.f567074m);
    L181:
        r116 = new jb2.d(r160, new gk6.a(r161, r165, r166, r168, r170, false, r171), b(r108, r108.getClickAction()), false);
        goto L230
    L180:
        r171 = null;
        goto L181
    L176:
        r170 = false;
        goto L178
    L168:
        if (Integer.valueOf(r167.getWeight()).intValue() < 700) goto L170;
        boolean r172 = true;
    L171:
        r168 = r172;
        goto L173
    L170:
        r172 = false;
        goto L171
    L160:
        r164 = false;
    L164:
        r165 = null;
        goto L165
    L182:
        PieceType r173 = PieceType.PATTERN_REF;
        if (r110 != r173.getPieceType()) goto L207;
        String r174 = r108.getText();
        Integer r175 = Integer.valueOf(w.b(r173.getPieceType(), r108.getFormat(), r102, r101));
        b5 r176 = r108.getFormat();
        if (r176 == null) goto L193;
        Integer r177 = Integer.valueOf(r176.getFontSize());
        if (r177.intValue() <= 0) goto L189;
        boolean r178 = true;
    L191:
        if (Boolean.valueOf(r178).booleanValue() == false) goto L193;
        Integer r179 = r177;
    L194:
        Boolean r180 = Boolean.TRUE;
        b5 r181 = r108.getFormat();
        if (r181 != null) goto L197;
        boolean r182 = false;
    L202:
        b5 r183 = r108.getFormat();
        if (r183 == null) goto L205;
        boolean r184 = r183.isItalic();
    L206:
        r116 = new jb2.d(r174, new gk6.a(r175, r179, r180, r182, r184, false, null), b(r108, r108.getClickAction()), 8);
        goto L230
    L205:
        r184 = false;
        goto L206
    L197:
        if (Integer.valueOf(r181.getWeight()).intValue() < 700) goto L199;
        boolean r185 = true;
    L200:
        r182 = r185;
        goto L202
    L199:
        r185 = false;
        goto L200
    L189:
        r178 = false;
    L193:
        r179 = null;
        goto L194
    L207:
        String r186 = r108.getText();
        Integer r187 = Integer.valueOf(w.b(r146.getPieceType(), r108.getFormat(), r102, r101));
        b5 r188 = r108.getFormat();
        if (r188 == null) goto L216;
        Integer r189 = Integer.valueOf(r188.getFontSize());
        if (r189.intValue() <= 0) goto L212;
        boolean r190 = true;
    L214:
        if (Boolean.valueOf(r190).booleanValue() == false) goto L216;
        Integer r191 = r189;
    L217:
        Boolean r192 = Boolean.TRUE;
        b5 r193 = r108.getFormat();
        if (r193 != null) goto L220;
        boolean r194 = false;
    L225:
        b5 r195 = r108.getFormat();
        if (r195 == null) goto L228;
        boolean r196 = r195.isItalic();
    L229:
        r116 = new jb2.d(r186, new gk6.a(r187, r191, r192, r194, r196, false, null), b(r108, r108.getClickAction()), 8);
        goto L230
    L228:
        r196 = false;
        goto L229
    L220:
        if (Integer.valueOf(r193.getWeight()).intValue() < 700) goto L222;
        boolean r197 = true;
    L223:
        r194 = r197;
        goto L225
    L222:
        r197 = false;
        goto L223
    L212:
        r190 = false;
    L216:
        r191 = null;
        goto L217
    L234:
        bk6.a r316 = r100;
        List r198 = CollectionsKt.toList(r106);
        Intrinsics.checkNotNullParameter(r198, "contents");
        ((ArrayList) r316.f19368a).addAll(r198);
        if (r102 == null) goto L249;
        Integer r199 = Integer.valueOf(w.b(PieceType.STRING.getPieceType(), null, r102, r101));
        g r200 = qb2.c.f532288a;
        Integer r201 = Integer.valueOf(r102.getFontSize());
        if (r201.intValue() <= 0) goto L239;
        boolean r202 = true;
    L240:
        if (r202 == false) goto L242;
        Integer r1100 = r201;
    L243:
        Boolean r1101 = Boolean.TRUE;
        if (r102.getWeight() < 700) goto L246;
        boolean r1102 = true;
    L247:
        gk6.a r1103 = new gk6.a(r199, r1100, r1101, r1102, r102.isItalic(), false, null);
    L254:
        r316.f19369b = r1103;
        return new e(CollectionsKt.toMutableList(r316.f19368a), r316.f19369b);
    L246:
        r1102 = false;
        goto L247
    L242:
        r1100 = null;
        goto L243
    L239:
        r202 = false;
        goto L240
    L249:
        if (r101 == null) goto L253;
        int r203 = r101.f567065d;
        if (r203 == 0) goto L253;
        r1103 = new gk6.a(Integer.valueOf(r203));
    L253:
        r1103 = null;
        goto L254
    L5:
        r104 = 1.0f;
        goto L6
    }
}
