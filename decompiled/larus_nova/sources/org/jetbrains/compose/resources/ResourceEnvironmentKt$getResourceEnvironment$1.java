package org.jetbrains.compose.resources;

import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ResourceEnvironmentKt$getResourceEnvironment$1 extends FunctionReferenceImpl implements Function0<q> {
    public static final ResourceEnvironmentKt$getResourceEnvironment$1 INSTANCE = null;

    static {
        INSTANCE = new ResourceEnvironmentKt$getResourceEnvironment$1();
    }

    public ResourceEnvironmentKt$getResourceEnvironment$1() {
        super(0, r.class, "getSystemEnvironment", "getSystemEnvironment()Lorg/jetbrains/compose/resources/ResourceEnvironment;", 1);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final q invoke2() {
        Locale r100 = Locale.getDefault();
        Configuration r101 = Resources.getSystem().getConfiguration();
        if ((r101.uiMode & 48) != 32) goto L5;
        boolean r102 = true;
    L6:
        int r103 = r101.densityDpi;
        k r104 = new k(r100.getLanguage());
        m r105 = new m(r100.getCountry());
        ThemeQualifier.Companion.getClass();
        if (r102 == false) goto L9;
        ThemeQualifier r106 = ThemeQualifier.DARK;
    L10:
        DensityQualifier.Companion.getClass();
        DensityQualifier r107 = DensityQualifier.LDPI;
        if (r103 <= r107.getDpi()) goto L27;
        r107 = DensityQualifier.MDPI;
        if (r103 <= r107.getDpi()) goto L27;
        r107 = DensityQualifier.HDPI;
        if (r103 <= r107.getDpi()) goto L27;
        r107 = DensityQualifier.XHDPI;
        if (r103 <= r107.getDpi()) goto L27;
        r107 = DensityQualifier.XXHDPI;
        if (r103 <= r107.getDpi()) goto L27;
        r107 = DensityQualifier.XXXHDPI;
    L27:
        return new q(r104, r105, r106, r107);
    L9:
        r106 = ThemeQualifier.LIGHT;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ q invoke() {
        return invoke2();
    }
}
