package na0;

import com.bytedance.android.live.impl.b;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements sb1.a {
    public a() {
    }

    @Override // sb1.a
    public final boolean a(Object r110, Object r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "currentCharacter");
        if (r111 == null) goto L286;
        if (r112 == null) goto L286;
        switch(r112.hashCode()) {
            case -913705004: goto L285;
            case -567445985: goto L269;
            case -83901120: goto L244;
            case 60: goto L224;
            case 62: goto L204;
            case 1084: goto L182;
            case 1921: goto L162;
            case 1952: goto L140;
            case 1983: goto L120;
            case 3365: goto L67;
            case 35078: goto L13;
            case 96673: goto L10;
            default: goto L286;
        };
    L285:
        r112.equals("all not");
        goto L286
    L10:
        if (r112.equals("all") == false) goto L286;
        return true;
    L13:
        if (r112.equals("!in") == false) goto L286;
        if ((r111 instanceof ArrayList) == false) goto L65;
        ArrayList r113 = (ArrayList) r111;
        if (r113.size() == 2) goto L19;
        return false;
    L19:
        Object r114 = ListProtector.get(r113, 0);
        if ((r114 instanceof Integer) == false) goto L35;
        int r115 = b.c(r110);
        Object r100 = ListProtector.get(r113, 0);
        if (r100 == null) goto L33;
        if (r115 < ((Integer) r100).intValue()) goto L62;
        int r116 = b.c(r110);
        Object r117 = ListProtector.get(r113, 1);
        if (r117 == null) goto L31;
        if (r116 > ((Integer) r117).intValue()) goto L62;
        return false;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L62:
        return true;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L35:
        if ((r114 instanceof Double) == false) goto L50;
        double r101 = b.b(r110);
        Object r118 = ListProtector.get(r113, 0);
        if (r118 == null) goto L48;
        if (r101 < ((Double) r118).doubleValue()) goto L62;
        double r102 = b.b(r110);
        Object r119 = ListProtector.get(r113, 1);
        if (r119 == null) goto L46;
        if (r102 > ((Double) r119).doubleValue()) goto L62;
        return false;
    L46:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L48:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L50:
        if ((r114 instanceof Long) == false) goto L289;
        long r103 = b.d(r110);
        Object r120 = ListProtector.get(r113, 0);
        if (r120 == null) goto L64;
        if (r103 < ((Long) r120).longValue()) goto L62;
        long r104 = b.d(r110);
        Object r121 = ListProtector.get(r113, 1);
        if (r121 == null) goto L61;
        if (r104 > ((Long) r121).longValue()) goto L62;
        return false;
    L61:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L64:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L289:
        return false;
    L65:
        return false;
    L67:
        if (r112.equals("in") == false) goto L286;
        if ((r111 instanceof ArrayList) == false) goto L118;
        ArrayList r122 = (ArrayList) r111;
        if (r122.size() == 2) goto L73;
        return false;
    L73:
        Object r123 = ListProtector.get(r122, 0);
        if ((r123 instanceof Integer) == false) goto L89;
        int r124 = b.c(r110);
        Object r105 = ListProtector.get(r122, 0);
        if (r105 == null) goto L87;
        if (r124 < ((Integer) r105).intValue()) goto L292;
        int r125 = b.c(r110);
        Object r126 = ListProtector.get(r122, 1);
        if (r126 == null) goto L85;
        if (r125 > ((Integer) r126).intValue()) goto L293;
    L113:
        return true;
    L293:
        return false;
    L85:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L292:
        return false;
    L87:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L89:
        if ((r123 instanceof Double) == false) goto L104;
        double r106 = b.b(r110);
        Object r127 = ListProtector.get(r122, 0);
        if (r127 == null) goto L102;
        if (r106 < ((Double) r127).doubleValue()) goto L294;
        double r107 = b.b(r110);
        Object r128 = ListProtector.get(r122, 1);
        if (r128 == null) goto L100;
        if (r107 <= ((Double) r128).doubleValue()) goto L113;
        return false;
    L100:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L294:
        return false;
    L102:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L104:
        if ((r123 instanceof Long) == false) goto L296;
        long r108 = b.d(r110);
        Object r129 = ListProtector.get(r122, 0);
        if (r129 == null) goto L117;
        if (r108 < ((Long) r129).longValue()) goto L297;
        long r109 = b.d(r110);
        Object r130 = ListProtector.get(r122, 1);
        if (r130 == null) goto L115;
        if (r109 <= ((Long) r130).longValue()) goto L113;
        return false;
    L115:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L297:
        return false;
    L117:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L296:
        return false;
    L118:
        return false;
    L120:
        if (r112.equals(">=") == false) goto L286;
        if ((r111 instanceof Integer) == false) goto L128;
        if (b.c(r110) < ((Integer) r111).intValue()) goto L300;
        return true;
    L300:
        return false;
    L128:
        if ((r111 instanceof Double) == false) goto L134;
        if (b.b(r110) < ((Double) r111).doubleValue()) goto L301;
        return true;
    L301:
        return false;
    L134:
        if ((r111 instanceof Long) == true) goto L136;
        return false;
    L136:
        if (b.d(r110) < ((Long) r111).longValue()) goto L303;
        return true;
    L303:
        return false;
    L140:
        if (r112.equals("==") == false) goto L286;
        if ((r111 instanceof Integer) == false) goto L148;
        if (b.c(r110) != ((Integer) r111).intValue()) goto L304;
        return true;
    L304:
        return false;
    L148:
        if ((r111 instanceof Double) == false) goto L154;
        if (b.b(r110) != ((Double) r111).doubleValue()) goto L305;
        return true;
    L305:
        return false;
    L154:
        if ((r111 instanceof Long) == false) goto L160;
        if (b.d(r110) != ((Long) r111).longValue()) goto L306;
        return true;
    L306:
        return false;
    L160:
        return Intrinsics.areEqual(r110, r111);
    L162:
        if (r112.equals("<=") == false) goto L286;
        if ((r111 instanceof Integer) == false) goto L170;
        if (b.c(r110) > ((Integer) r111).intValue()) goto L307;
        return true;
    L307:
        return false;
    L170:
        if ((r111 instanceof Double) == false) goto L176;
        if (b.b(r110) > ((Double) r111).doubleValue()) goto L308;
        return true;
    L308:
        return false;
    L176:
        if ((r111 instanceof Long) == true) goto L178;
        return false;
    L178:
        if (b.d(r110) > ((Long) r111).longValue()) goto L310;
        return true;
    L310:
        return false;
    L182:
        if (r112.equals("!=") == false) goto L286;
        if ((r111 instanceof Integer) == false) goto L190;
        if (b.c(r110) == ((Integer) r111).intValue()) goto L311;
        return true;
    L311:
        return false;
    L190:
        if ((r111 instanceof Double) == false) goto L196;
        if (b.b(r110) == ((Double) r111).doubleValue()) goto L312;
        return true;
    L312:
        return false;
    L196:
        if ((r111 instanceof Long) == false) goto L202;
        if (b.d(r110) == ((Long) r111).longValue()) goto L313;
        return true;
    L313:
        return false;
    L202:
        return !Intrinsics.areEqual(r110, r111);
    L204:
        if (r112.equals(">") == false) goto L286;
        if ((r111 instanceof Integer) == false) goto L212;
        if (b.c(r110) <= ((Integer) r111).intValue()) goto L314;
        return true;
    L314:
        return false;
    L212:
        if ((r111 instanceof Double) == false) goto L218;
        if (b.b(r110) <= ((Double) r111).doubleValue()) goto L315;
        return true;
    L315:
        return false;
    L218:
        if ((r111 instanceof Long) == true) goto L220;
        return false;
    L220:
        if (b.d(r110) <= ((Long) r111).longValue()) goto L317;
        return true;
    L317:
        return false;
    L224:
        if (r112.equals("<") == false) goto L286;
        if ((r111 instanceof Integer) == false) goto L232;
        if (b.c(r110) >= ((Integer) r111).intValue()) goto L318;
        return true;
    L318:
        return false;
    L232:
        if ((r111 instanceof Double) == false) goto L238;
        if (b.b(r110) >= ((Double) r111).doubleValue()) goto L319;
        return true;
    L319:
        return false;
    L238:
        if ((r111 instanceof Long) == true) goto L240;
        return false;
    L240:
        if (b.d(r110) >= ((Long) r111).longValue()) goto L321;
        return true;
    L321:
        return false;
    L244:
        if (r112.equals("!contains") == false) goto L286;
        if ((r111 instanceof ArrayList) == false) goto L322;
        ArrayList r131 = (ArrayList) r111;
        Object r132 = ListProtector.get(r131, 0);
        if ((r132 instanceof Integer) == false) goto L253;
        if (CollectionsKt.contains(r131, Integer.valueOf(b.c(r110))) == true) goto L323;
    L266:
        return true;
    L323:
        return false;
    L253:
        if ((r132 instanceof Double) == false) goto L258;
        if (CollectionsKt.contains(r131, Double.valueOf(b.b(r110))) == false) goto L266;
        return false;
    L258:
        if ((r132 instanceof Long) == false) goto L263;
        if (CollectionsKt.contains(r131, Long.valueOf(b.d(r110))) == false) goto L266;
        return false;
    L263:
        if ((r132 instanceof String) == true) goto L265;
        return false;
    L265:
        if (CollectionsKt.contains(r131, b.e(r110)) == false) goto L266;
        return false;
    L322:
        return false;
    L269:
        if (r112.equals("contains") == false) goto L286;
        if ((r111 instanceof ArrayList) == false) goto L328;
        ArrayList r133 = (ArrayList) r111;
        Object r134 = ListProtector.get(r133, 0);
        if ((r134 instanceof Integer) == false) goto L276;
        return CollectionsKt.contains(r133, Integer.valueOf(b.c(r110)));
    L276:
        if ((r134 instanceof Double) == false) goto L279;
        return CollectionsKt.contains(r133, Double.valueOf(b.b(r110)));
    L279:
        if ((r134 instanceof Long) == false) goto L282;
        return CollectionsKt.contains(r133, Long.valueOf(b.d(r110)));
    L282:
        if ((r134 instanceof String) == true) goto L284;
        return false;
    L284:
        return CollectionsKt.contains(r133, b.e(r110));
    L328:
        return false;
    L286:
        return false;
    }
}
