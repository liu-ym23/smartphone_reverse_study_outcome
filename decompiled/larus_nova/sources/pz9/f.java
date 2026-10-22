package pz9;

import androidx.fragment.app.Fragment;
import com.facebook.keyframes.model.KFAnimation;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.common_ui.image.ImageAdapter;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.creation.ChatCreationPagerFragment;
import com.larus.uaigc.creation.detail.image.BigImageDetailFragment;
import com.larus.uaigc.creation.detail.image.l;
import com.larus.uaigc.creation.detail.image.m;
import com.larus.uaigc.creation.detail.image.o;
import com.larus.utils.o0;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;
import uo8.k;

/* JADX INFO: loaded from: classes31.dex */
public final class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass<? extends zo8.a> f531132a;

    public f() {
        this.f531132a = Reflection.getOrCreateKotlinClass(zo8.b.class);
    }

    @Override // pz9.b
    public KClass<? extends zo8.a> getType() {
        return this.f531132a;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [pz9.d] */
    /* JADX WARN: Type inference failed for: r3v2, types: [pz9.e] */
    @Override // pz9.c
    public final Fragment a(final Fragment r410, zo8.a r411, int r412, int r413) {
        Intrinsics.checkNotNullParameter(r411, "data");
        if ((r411 instanceof zo8.b) == false) goto L5;
        zo8.b r100 = (zo8.b) r411;
    L6:
        if (r100 == null) goto L121;
        final BigImageDetailFragment r101 = new BigImageDetailFragment();
        boolean r102 = r410 instanceof ChatCreationPagerFragment;
        if (r102 == false) goto L10;
        ChatCreationPagerFragment r103 = (ChatCreationPagerFragment) r410;
    L11:
        if (r103 == null) goto L13;
        iy9.a<? extends zo8.a> r104 = r103.f372777p;
    L14:
        if (r102 == false) goto L16;
        ChatCreationPagerFragment r105 = (ChatCreationPagerFragment) r410;
    L18:
        if (r105 == null) goto L20;
        int r210 = r105.f372776o;
    L21:
        List r110 = CollectionsKt.mutableListOf(new zo8.b[]{r100});
        if (r104 == null) goto L24;
        String r106 = r104.f496593e;
    L25:
        String r310 = "";
        if (r106 != null) goto L28;
        String r111 = "";
    L29:
        if (r104 == null) goto L31;
        k r112 = r104.f496591c;
    L32:
        if (r104 == null) goto L34;
        String r113 = r104.f496599k;
    L35:
        zo8.b r107 = (zo8.b) r411;
        List r114 = CollectionsKt.listOf(r107.f573135a);
        if (o0.d(r107.f573136b) == false) goto L38;
        List r115 = CollectionsKt.listOf(r107.f573136b);
    L39:
        if (r102 == false) goto L41;
        ChatCreationPagerFragment r108 = (ChatCreationPagerFragment) r410;
    L43:
        if (r108 == null) goto L45;
        JSONObject r211 = r108.qa0(r413);
    L46:
        if (r104 == null) goto L49;
        ic8.d r109 = r104.f496606r;
        if (r109 == null) goto L49;
    L50:
        ic8.d r212 = r109;
        if (r104 == null) goto L56;
        ic8.d r116 = r104.f496607s;
        if (r116 == null) goto L56;
        ic8.d r213 = r116;
    L57:
        if (r104 == null) goto L62;
        ic8.d r117 = r104.f496608t;
        if (r117 == null) goto L62;
        ic8.d r214 = r117;
    L63:
        if (r104 == null) goto L68;
        ic8.d r118 = r104.f496609u;
        if (r118 == null) goto L68;
        ic8.d r215 = r118;
    L69:
        if (r104 == null) goto L72;
        ic8.d r119 = r104.f496610v;
        if (r119 == null) goto L72;
    L73:
        ic8.d r216 = r119;
        if (r104 == null) goto L76;
        boolean r217 = r104.f496612x;
    L77:
        if (r104 == null) goto L79;
        long r120 = r104.f496613y;
    L80:
        long r311 = r120;
        if (r104 == null) goto L83;
        boolean r312 = r104.f496614z;
    L84:
        if (r104 == null) goto L86;
        Integer r218 = r104.f496605q;
    L87:
        if (r104 == null) goto L89;
        com.larus.bmhome.bigimg.e r121 = r104.f496592d;
    L90:
        final iy9.a<zo8.b> r122 = new iy9.a(r110, 0, r112, r121, r111, r114, r115, r413, r113, new d(r410), new e(r410), r210, r211, r218, r212, r213, r214, r215, r216, r217, r311, r312, null, 71336450);
        Intrinsics.checkNotNullParameter(r122, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        r101.F = r122;
        ImageAdapter r123 = new ImageAdapter();
        r123.f310686h = r122.f496600l;
        r123.f310687i = r122.f496601m;
        r123.f310689k = r122.f496602n;
        r123.f310690l = true;
        List<n1> r124 = CollectionsKt.toMutableList(r122.f496594f);
        List<String> r125 = r122.f496595g;
        Function1<? super Integer, Unit> r126 = new com.larus.uaigc.creation.detail.image.a();
        Intrinsics.checkNotNullParameter(r123, "adapter");
        r101.f372794d = r123;
        r101.f372795e = r124;
        r101.f372796f = r125;
        r101.f372797g = r126;
        System.currentTimeMillis();
        ImageAdapter r127 = r101.f372794d;
        if (r127 == null) goto L93;
        Function1<? super Integer, Unit> r128 = new com.larus.uaigc.creation.detail.image.k(r122, r101);
        Intrinsics.checkNotNullParameter(r128, "<set-?>");
        r127.f310682d = r128;
    L93:
        ImageAdapter r129 = r101.f372794d;
        if (r129 == null) goto L96;
        r129.f310683e = new l(r101);
    L96:
        if (r129 == null) goto L98;
        r129.f310684f = new m(r122, r101);
    L98:
        if (r129 == null) goto L100;
        r129.f310688j = new o(r101);
    L100:
        iy9.a<zo8.b> r130 = r101.F;
        if (r102 == false) goto L103;
        ChatCreationPagerFragment r131 = (ChatCreationPagerFragment) r410;
    L104:
        if (r131 == null) goto L106;
        int r132 = r131.oa0(qz9.a.a(r411));
    L107:
        r130.B = r132;
        if (r102 == false) goto L110;
        ChatCreationPagerFragment r133 = (ChatCreationPagerFragment) r410;
    L111:
        if (r133 == null) goto L120;
        String r134 = qz9.a.a(r411);
        Intrinsics.checkNotNullParameter(r134, "creationKey");
        Map<String, UserCreationFromIM> r135 = r133.f372772k;
        if (r135 == null) goto L120;
        UserCreationFromIM r136 = r135.get(r134);
        if (r136 == null) goto L120;
        String r137 = r136.getCreationId();
        if (r137 == null) goto L120;
        r310 = r137;
    L120:
        String r138 = r310;
        Intrinsics.checkNotNullParameter(r138, "<set-?>");
        r130.C = r138;
        r130.D = r107.f573137c;
        return r101;
    L110:
        r133 = null;
        goto L111
    L106:
        r132 = 0;
        goto L107
    L103:
        r131 = null;
        goto L104
    L89:
        r121 = null;
        goto L90
    L86:
        r218 = null;
        goto L87
    L83:
        r312 = false;
        goto L84
    L79:
        r120 = 0;
        goto L80
    L76:
        r217 = false;
    L72:
        r119 = new ic8.d(false, null, null, false, null, null, 63);
    L68:
        r215 = new ic8.d(false, null, null, false, null, null, 63);
    L62:
        r214 = new ic8.d(false, null, null, false, null, null, 63);
    L56:
        r213 = new ic8.d(false, null, null, false, null, null, 63);
    L49:
        r109 = new ic8.d(false, null, null, false, null, null, 63);
        goto L50
    L45:
        r211 = null;
        goto L46
    L41:
        r108 = null;
        goto L43
    L38:
        r115 = null;
        goto L39
    L34:
        r113 = null;
        goto L35
    L31:
        r112 = null;
        goto L32
    L28:
        r111 = r106;
        goto L29
    L24:
        r106 = null;
        goto L25
    L20:
        r210 = 0;
        goto L21
    L16:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L10:
        r103 = null;
        goto L11
    L121:
        return null;
    L5:
        r100 = null;
        goto L6
    }
}
