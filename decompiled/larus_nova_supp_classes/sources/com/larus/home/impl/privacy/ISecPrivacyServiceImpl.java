package com.larus.home.impl.privacy;

import android.content.Context;
import android.util.EventsUtils;
import com.bytedance.apm.d;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.api.INpth;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import ec9.d0;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\u0018"}, d2 = {"Lcom/larus/home/impl/privacy/ISecPrivacyServiceImpl;", "Lcom/larus/common/mssdk/api/ISecPrivacyService;", "<init>", "()V", "initPrivacy", XmlPullParser.NO_NAMESPACE, "base", "Landroid/content/Context;", "isPrivacyProcess", XmlPullParser.NO_NAMESPACE, "updateIsFirstStartMark", "isFirstStart", "registerPrivacyReceiver", "context", "checkFirstStartAsyncTaskInit", "taskName", XmlPullParser.NO_NAMESPACE, "isFirstInstallStarting", "checkAgreed", "notifyAgree", "result", "sendKillMySelfBroadcast", "privacyNotifyStartEventDelay", "privacyUpdateIsFirstStartMark", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ISecPrivacyServiceImpl implements ISecPrivacyService {
    public ISecPrivacyServiceImpl() {
    }

    @Override // com.larus.common.mssdk.api.ISecPrivacyService
    public final boolean a() {
        a r0 = a.a;
        String r1 = a.b;
        String r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentProcessName");
        r1 = null;
    L5:
        String r3 = a.c;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("privacyProcessName");
    L10:
        return Intrinsics.areEqual(r1, r2);
    L8:
        r2 = r3;
        goto L10
    }

    @Override // com.larus.common.mssdk.api.ISecPrivacyService
    public final void d() {
        a r0 = a.a;
        if (a.a() == false) goto L6;
        a.e.storeBoolean("first_start", true);
        return;
    }

    @Override // com.larus.common.mssdk.api.ISecPrivacyService
    public final void e() {
        PolarisFileWrapper r0 = a.d;
        PolarisFileWrapper r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("flagFile");
        r0 = null;
    L6:
        if (r0.exists() == true) goto L13;
        PolarisFileWrapper r2 = a.d;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("flagFile");
    L11:
        r1.createNewFile();
        return;
    L10:
        r1 = r2;
        goto L11
    }

    @Override // com.larus.common.mssdk.api.ISecPrivacyService
    public final boolean h() {
        a r0 = a.a;
        return a.a();
    }

    @Override // com.larus.common.mssdk.api.ISecPrivacyService
    public final boolean j() {
        a r0 = a.a;
        if (AppHost.a.isOversea() == false) goto L5;
    L9:
        boolean r1 = false;
    L10:
        z2.a.getFirstInstallOptConfig().toString();
        return r1;
    L5:
        if (a.a() == true) goto L9;
        e10 r2 = e10.a;
        if (e10.V().b() == true) goto L9;
        r1 = true;
        goto L10
    }

    @Override // com.larus.common.mssdk.api.ISecPrivacyService
    public final void b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        a r0 = a.a;
        a.b(r2);
    }

    @Override // com.larus.common.mssdk.api.ISecPrivacyService
    public final void c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        a.a.registerReceiver(r2);
    }

    @Override // com.larus.common.mssdk.api.ISecPrivacyService
    public final boolean f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskName");
        a r1 = a.a;
        Intrinsics.checkNotNullParameter(r4, "taskName");
        boolean r2 = false;
        if (a.e.getBoolean("first_start", false) == false) goto L14;
        e10 r0 = e10.a;
        if (e10.V().a() == true) goto L14;
        List<String> r3 = e10.V().c();
        if (r3 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        if (r5 == true) goto L14;
        r2 = true;
        goto L14
    L9:
        if (r3.contains(r4) != true) goto L11;
        r5 = true;
    L14:
        e10 r6 = e10.a;
        Objects.toString(e10.V().c());
        return r2;
    }

    @Override // com.larus.common.mssdk.api.ISecPrivacyService
    public final void g(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "base");
        a r1 = a.a;
        Intrinsics.checkNotNullParameter(r5, "base");
        String r0 = d.c();
        a.b = r0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentProcessName");
    L5:
        r5.getPackageName();
        a.c = r5.getPackageName() + ":privacy";
        a.d = new PolarisFileWrapper(r5.getFilesDir(), "privacy_agreed");
        String r2 = a.b;
        String r3 = null;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("currentProcessName");
        r2 = null;
    L8:
        String r4 = a.c;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("privacyProcessName");
    L13:
        if (Intrinsics.areEqual(r2, r3) == false) goto L17;
        INpth.a r6 = INpth.a;
        d0 r7 = new d0(r5);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "crashCallback");
        INpth r8 = INpth.a.b.getValue();
        if (r8 == null) goto L17;
        r8.b(r7);
    L17:
        INpth.a r9 = INpth.a;
        boolean r10 = !a.a();
        r9.getClass();
        INpth r11 = INpth.a.b.getValue();
        if (r11 == null) goto L21;
        r11.c(r10);
        return;
    L21:
        return;
    L11:
        r3 = r4;
        goto L13
    }

    @Override // com.larus.common.mssdk.api.ISecPrivacyService
    public final void i(boolean r3) {
        a r0 = a.a;
        if (a.a() == false) goto L6;
        a.e.storeBoolean("first_start", r3);
        return;
    }
}
