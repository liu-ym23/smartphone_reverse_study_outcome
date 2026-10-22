package pa8;

import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.location.dto.AddressComponent;
import com.ss.android.lark.location.dto.POIInfo;
import ew4.o;
import ew4.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h implements gqb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f528383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f528384b;

    @Override // gqb.a
    public final void b() {
        FLogger.f375446a.i("FlowLocationHostService", "map location canceled or back pressed");
    }

    public h(p r100, g r101) {
        this.f528383a = r100;
        this.f528384b = r101;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // gqb.a
    public final void a(FragmentActivity r110, POIInfo r210) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        p r100 = this.f528383a;
        o r101 = null;
        String r102 = null;
        if (r210 == null) goto L27;
        this.f528384b.getClass();
        double r103 = r210.getLatitude();
        double r104 = r210.getLongitude();
        String r105 = r210.getLocationName();
        String r111 = r210.getLocationAddress();
        AddressComponent r106 = r210.getAddressComponent();
        if (r106 == null) goto L7;
        String r112 = r106.getProvince();
    L8:
        AddressComponent r107 = r210.getAddressComponent();
        if (r107 == null) goto L11;
        String r113 = r107.getCity();
    L12:
        AddressComponent r108 = r210.getAddressComponent();
        if (r108 == null) goto L15;
        String r114 = r108.getDistrict();
    L16:
        AddressComponent r109 = r210.getAddressComponent();
        if (r109 == null) goto L19;
        r102 = r109.getTownship();
    L19:
        String r115 = r102;
        int r116 = r210.getErrorCode();
        if (r116 != 40100) goto L22;
        int r117 = 2;
    L26:
        r101 = new o(r103, r104, r105, r111, r112, r113, r114, r115, null, r117, r210.getErrorMsg());
        goto L27
    L22:
        if (r116 == 40400) goto L24;
        r117 = 0;
        goto L26
    L24:
        r117 = 3;
        goto L26
    L15:
        r114 = null;
        goto L16
    L11:
        r113 = null;
        goto L12
    L7:
        r112 = null;
    L27:
        r100.a(r101);
    }
}
