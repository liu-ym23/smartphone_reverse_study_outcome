package fpb;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.passport.signinsdk_api.env.EnvironmentType;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kzb.b;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final izb.a f478394a;

    @Override // kzb.b
    public final kzb.a a() {
        Pair<EnvironmentType, String> r100 = this.f478394a.a();
        LarkAppContext.a r101 = LarkAppContext.Companion;
        r101.getClass();
        String r102 = (String) LarkAppContext.access$getInstance$cp().buildConfig().getValue("DEFAULT_UNIT");
        r101.getClass();
        String r103 = (String) LarkAppContext.access$getInstance$cp().buildConfig().getValue("DEFAULT_BRAND");
        boolean r104 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L16;
        if (r103 != null) goto L12;
    L13:
        r104 = true;
    L14:
        if (r104 == true) goto L16;
        Pair r106 = new Pair(r102, r103);
    L20:
        if (r100 == null) goto L22;
        r106 = new Pair(r100.getSecond(), r106.getSecond());
    L22:
        String r107 = (String) r106.getSecond();
        String r108 = (String) r106.getFirst();
        String r109 = this.f478394a.b((String) r106.getFirst());
        if (r100 == null) goto L26;
        EnvironmentType r110 = r100.getFirst();
        if (r110 == null) goto L26;
    L28:
        return new kzb.a(r107, r108, r109, r110);
    L26:
        r110 = EnvironmentType.RELEASE;
        goto L28
    L12:
        if (StringsKt.isBlank(r103) == false) goto L14;
    L16:
        r101.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isUsPackage() == false) goto L19;
        r106 = new Pair("larksgaws", "lark");
        goto L20
    L19:
        r106 = new Pair("eu_nc", "feishu");
        goto L20
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r105 = false;
        goto L9
    }

    @Inject
    public a(izb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "environmentDependency");
        this.f478394a = r100;
    }
}
