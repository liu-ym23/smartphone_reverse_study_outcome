package com.obric.update.impl.v2.gateway;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes5.dex */
public final class PluginInstallGateway {

    public static final class a {
    }

    static {
    }

    public PluginInstallGateway() {
    }

    public final Object b(PolarisFileWrapper r100, Continuation r101) {
        if (r100 == null) goto L7;
        boolean r102 = true;
        if (r100.exists() != true) goto L7;
    L8:
        if (r102 == true) goto L12;
        FLogger.f375446a.i("PluginInstallGateway", "isPluginPreInstalled apkFile not exists:" + r100);
        return Boxing.boxBoolean(false);
    L12:
        return BuildersKt.withContext(Dispatchers.getIO(), new PluginInstallGateway$isPluginPreInstalled$2(this, r100, null), r101);
    L7:
        r102 = false;
        goto L8
    }

    public final Object c(File r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof PluginInstallGateway$preInstallPlugin$1) == false) goto L7;
        PluginInstallGateway$preInstallPlugin$1 r102 = (PluginInstallGateway$preInstallPlugin$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L17;
        if (r106 != 1) goto L16;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L13
    L25:
        Unit r107 = (Unit) r104;     // Catch: Exception -> L13
    L30:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r104);
        if (r100 != null) goto L20;
    L26:
        FLogger.f375446a.i("PluginInstallGateway", "preInstallPlugin apkFile not exists:" + r100);     // Catch: Exception -> L13
        return Unit.INSTANCE;
    L20:
        if (r100.exists() == false) goto L26;
        CoroutineDispatcher r108 = Dispatchers.getIO();     // Catch: Exception -> L13
        PluginInstallGateway$preInstallPlugin$2 r109 = new PluginInstallGateway$preInstallPlugin$2(r100, null);     // Catch: Exception -> L13
        r102.label = 1;     // Catch: Exception -> L13
        r104 = BuildersKt.withContext(r108, r109, r102);     // Catch: Exception -> L13
        if (r104 != r105) goto L25;
        return r105;
    L13:
        e = move-exception;
        FLogger.f375446a.e("PluginInstallGateway", "preInstallPlugin fail:" + e);
    L7:
        r102 = new PluginInstallGateway$preInstallPlugin$1(this, r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public static final long a(PluginInstallGateway r100, Context r101, String r102) {
        r100.getClass();
        String r103 = "PluginInstallGateway";
        long r104 = -1;
        PackageInfo r105 = r101.getPackageManager().getPackageArchiveInfo(r102, 0);     // Catch: Exception -> L11
        if (r105 != null) goto L6;
        FLogger.f375446a.w("PluginInstallGateway", "getApkVersionCode failed, packageInfo is null, path: " + r102);     // Catch: Exception -> L11
        r103 = r103;
    L14:
    L13:
        return r104;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L8;
        r104 = r105.getLongVersionCode();     // Catch: Exception -> L11
        r103 = r103;
        goto L14
    L8:
        int r106 = r105.versionCode;     // Catch: Exception -> L11
        r104 = r106;
        r103 = r106;
    L11:
        e = move-exception;
        FLogger.f375446a.e(r103, "getApkVersionCode error, path: " + r102, e);
        goto L13
    }
}
