package xz5;

import android.content.ClipData;
import android.location.Location;
import android.telephony.CellLocation;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.mt.protector.impl.string2number.CastShortProtector;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class e {
    public static final Object a(Object r100, String r101) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        if (r101 != null) goto L7;
    L144:
        return null;
    L7:
        switch(r101.hashCode()) {
            case -2056817302: goto L142;
            case -1947708150: goto L139;
            case -1402722386: goto L136;
            case -1402716492: goto L133;
            case -1383349348: goto L130;
            case -1383343454: goto L127;
            case -1374008726: goto L124;
            case -1361632968: goto L121;
            case -1325958191: goto L118;
            case -1114099497: goto L115;
            case -1103257993: goto L112;
            case -1097129250: goto L109;
            case -916468148: goto L106;
            case -855981108: goto L103;
            case -766441794: goto L100;
            case -527879800: goto L97;
            case -515992664: goto L94;
            case -486343958: goto L91;
            case 104431: goto L88;
            case 3039496: goto L85;
            case 3052374: goto L82;
            case 3327612: goto L79;
            case 64711720: goto L76;
            case 65821278: goto L73;
            case 97526364: goto L70;
            case 100361105: goto L67;
            case 109413500: goto L64;
            case 155276373: goto L61;
            case 344809556: goto L58;
            case 398507100: goto L55;
            case 398795216: goto L52;
            case 649504438: goto L49;
            case 713236670: goto L46;
            case 761287205: goto L43;
            case 990116146: goto L40;
            case 1195259493: goto L37;
            case 1258621781: goto L34;
            case 1258627675: goto L31;
            case 1359468275: goto L28;
            case 1452566599: goto L25;
            case 1754524719: goto L22;
            case 1888107655: goto L19;
            case 2058423690: goto L16;
            case 2067161310: goto L13;
            case 2105438894: goto L10;
            default: goto L144;
        };
    L10:
        if (r101.equals("android.content.ClipData") == false) goto L144;
        return ClipData.newPlainText("", "");
    L13:
        if (r101.equals("short[]") == false) goto L144;
        return new short[0];
    L16:
        if (r101.equals("boolean[]") == false) goto L144;
        return new boolean[0];
    L19:
        if (r101.equals("java.lang.String[]") == false) goto L144;
        return new String[0];
    L22:
        if (r101.equals("android.location.Location") == false) goto L144;
        return new Location("");
    L25:
        if (r101.equals("java.lang.Double[]") == false) goto L144;
        return new Double[0];
    L28:
        if (r101.equals("double[]") == false) goto L144;
        return new double[0];
    L31:
        if (r101.equals("java.util.LinkedHashSet") == false) goto L144;
        return new LinkedHashSet(0);
    L34:
        if (r101.equals("java.util.LinkedHashMap") == false) goto L144;
        return new LinkedHashMap(0);
    L37:
        if (r101.equals("java.lang.String") == false) goto L144;
        return "";
    L40:
        if (r101.equals("java.lang.Long[]") == false) goto L144;
        return new Long[0];
    L43:
        if (r101.equals("java.lang.Double") == false) goto L144;
    L173:
        return Double.valueOf(-1.0d);
    L46:
        if (r101.equals("java.lang.Byte[]") == false) goto L144;
        return new Byte[0];
    L49:
        if (r101.equals("java.lang.Boolean[]") == false) goto L144;
        return new Boolean[0];
    L52:
        if (r101.equals("java.lang.Long") == false) goto L144;
    L161:
        return -1L;
    L55:
        if (r101.equals("java.lang.Byte") == false) goto L144;
    L163:
        return Byte.valueOf(CastByteProtector.parseByte("-1"));
    L58:
        if (r101.equals("java.lang.Boolean") == false) goto L144;
    L160:
        return Boolean.FALSE;
    L61:
        if (r101.equals("java.lang.Character") == false) goto L144;
    L162:
        return ' ';
    L64:
        if (r101.equals("short") == false) goto L144;
    L165:
        return Short.valueOf((short) (-1));
    L67:
        if (r101.equals("int[]") == false) goto L144;
        return new int[0];
    L70:
        if (r101.equals("float") == false) goto L144;
    L166:
        return Float.valueOf(-1.0f);
    L73:
        if (r101.equals("java.util.List") == false) goto L144;
        return Collections.EMPTY_LIST;
    L76:
        if (r101.equals("boolean") == false) goto L144;
    L79:
        if (r101.equals("long") == false) goto L144;
    L82:
        if (r101.equals("char") == false) goto L144;
    L85:
        if (r101.equals("byte") == false) goto L144;
    L88:
        if (r101.equals("int") == false) goto L144;
    L181:
        return -1;
    L91:
        if (r101.equals("java.lang.Float[]") == false) goto L144;
        return new Float[0];
    L94:
        if (r101.equals("java.lang.Short") == false) goto L144;
    L97:
        if (r101.equals("java.lang.Float") == false) goto L144;
    L100:
        if (r101.equals("float[]") == false) goto L144;
        return new float[0];
    L103:
        if (r101.equals("android.telephony.CellLocation") == false) goto L144;
        return CellLocation.getEmpty();
    L106:
        if (r101.equals("java.lang.Integer[]") == false) goto L144;
        return new Integer[0];
    L109:
        if (r101.equals("long[]") == false) goto L144;
        return new long[0];
    L112:
        if (r101.equals("java.lang.Character[]") == false) goto L144;
        return new Character[0];
    L115:
        if (r101.equals("java.util.ArrayList") == false) goto L144;
        return new ArrayList(0);
    L118:
        if (r101.equals(ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L144;
    L121:
        if (r101.equals("char[]") == false) goto L144;
        return new char[0];
    L124:
        if (r101.equals("byte[]") == false) goto L144;
        return new byte[0];
    L127:
        if (r101.equals("java.util.Set") == false) goto L144;
        return Collections.EMPTY_SET;
    L130:
        if (r101.equals("java.util.Map") == false) goto L144;
        return Collections.EMPTY_MAP;
    L133:
        if (r101.equals("java.util.HashSet") == false) goto L144;
        return new HashSet(0);
    L136:
        if (r101.equals("java.util.HashMap") == false) goto L144;
        return new HashMap(0);
    L139:
        if (r101.equals("java.lang.Short[]") == false) goto L144;
        return new Short[0];
    L142:
        if (r101.equals("java.lang.Integer") == false) goto L144;
        goto L144
    }

    public static final Object b(String r100, String r101) {
        if (r101 == null) goto L107;
        switch(r101.hashCode()) {
            case -2056817302: goto L104;
            case -1374008726: goto L98;
            case -1361632968: goto L92;
            case -1325958191: goto L89;
            case -1097129250: goto L83;
            case -766441794: goto L77;
            case -527879800: goto L74;
            case -515992664: goto L71;
            case 104431: goto L68;
            case 3039496: goto L65;
            case 3052374: goto L62;
            case 3327612: goto L59;
            case 64711720: goto L56;
            case 97526364: goto L53;
            case 100361105: goto L47;
            case 109413500: goto L44;
            case 155276373: goto L41;
            case 344809556: goto L38;
            case 398507100: goto L35;
            case 398795216: goto L32;
            case 761287205: goto L29;
            case 1195259493: goto L26;
            case 1359468275: goto L20;
            case 2058423690: goto L14;
            case 2067161310: goto L8;
            default: goto L107;
        };
    L8:
        if (r101.equals("short[]") == false) goto L107;
        short[] r102 = (short[]) e06.c.a(r100, short[].class);
        if (r102 == null) goto L140;
        return r102;
    L140:
        return new short[0];
    L14:
        if (r101.equals("boolean[]") == false) goto L107;
        boolean[] r103 = (boolean[]) e06.c.a(r100, boolean[].class);
        if (r103 == null) goto L145;
        return r103;
    L145:
        return new boolean[0];
    L20:
        if (r101.equals("double[]") == false) goto L107;
        double[] r104 = (double[]) e06.c.a(r100, double[].class);
        if (r104 == null) goto L146;
        return r104;
    L146:
        return new double[0];
    L26:
        if (r101.equals("java.lang.String") == false) goto L107;
        return r100;
    L29:
        if (r101.equals("java.lang.Double") == false) goto L107;
    L156:
        return Double.valueOf(CastDoubleProtector.parseDouble(r100));
    L32:
        if (r101.equals("java.lang.Long") == false) goto L107;
    L149:
        return Long.valueOf(CastLongProtector.parseLong(r100));
    L35:
        if (r101.equals("java.lang.Byte") == false) goto L107;
    L151:
        return Byte.valueOf(CastByteProtector.parseByte(r100));
    L38:
        if (r101.equals("java.lang.Boolean") == false) goto L107;
    L148:
        return Boolean.valueOf(Boolean.parseBoolean(r100));
    L41:
        if (r101.equals("java.lang.Character") == false) goto L107;
    L150:
        return Character.valueOf(StringsKt.single(r100));
    L44:
        if (r101.equals("short") == false) goto L107;
    L152:
        return Short.valueOf(CastShortProtector.parseShort(r100));
    L47:
        if (r101.equals("int[]") == false) goto L107;
        int[] r105 = (int[]) e06.c.a(r100, int[].class);
        if (r105 == null) goto L147;
        return r105;
    L147:
        return new int[0];
    L53:
        if (r101.equals("float") == false) goto L107;
    L153:
        return Float.valueOf(CastFloatProtector.parseFloat(r100));
    L56:
        if (r101.equals("boolean") == false) goto L107;
    L59:
        if (r101.equals("long") == false) goto L107;
    L62:
        if (r101.equals("char") == false) goto L107;
    L65:
        if (r101.equals("byte") == false) goto L107;
    L68:
        if (r101.equals("int") == false) goto L107;
    L159:
        return Integer.valueOf(CastIntegerProtector.parseInt(r100));
    L71:
        if (r101.equals("java.lang.Short") == false) goto L107;
    L74:
        if (r101.equals("java.lang.Float") == false) goto L107;
    L77:
        if (r101.equals("float[]") == false) goto L107;
        float[] r106 = (float[]) e06.c.a(r100, float[].class);
        if (r106 == null) goto L154;
        return r106;
    L154:
        return new float[0];
    L83:
        if (r101.equals("long[]") == false) goto L107;
        long[] r107 = (long[]) e06.c.a(r100, long[].class);
        if (r107 == null) goto L155;
        return r107;
    L155:
        return new long[0];
    L89:
        if (r101.equals(ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L107;
    L92:
        if (r101.equals("char[]") == false) goto L107;
        char[] r108 = (char[]) e06.c.a(r100, char[].class);
        if (r108 == null) goto L157;
        return r108;
    L157:
        return new char[0];
    L98:
        if (r101.equals("byte[]") == false) goto L107;
        byte[] r109 = (byte[]) e06.c.a(r100, byte[].class);
        if (r109 == null) goto L158;
        return r109;
    L158:
        return new byte[0];
    L104:
        if (r101.equals("java.lang.Integer") == true) goto L159;
    L107:
        if (StringsKt.isBlank(r100) == true) goto L160;
        if (r101 == null) goto L160;
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r110 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r111 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L143;
        Class<?> r112 = Class.forName(r101);     // Catch: Throwable -> L116
        if (r111 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L161;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L116
    L161:
        return e06.c.a(r100, r112);
    L116:
        th = move-exception;
        if (r111 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L120;
        FastClassNotFoundHandler.b(r101);
    L120:
        throw th;
    L143:
        r112 = Class.forName(r101);     // Catch: Throwable -> L125
        if (r111 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L161;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L125
    L125:
        th = move-exception;
        if (r111 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L130;
        FastClassNotFoundHandler.b(r101);
    L130:
        if ((th instanceof PluginClassNotFoundException) == false) goto L132;
        throw th;
    L132:
        if ((th instanceof ClassNotFoundException) == false) goto L134;
    L137:
        r112 = MiraPluginFix.forName(r101);
        goto L161
    L134:
        if ((th instanceof NoClassDefFoundError) == true) goto L137;
        throw th;
    L160:
        return null;
    }
}
