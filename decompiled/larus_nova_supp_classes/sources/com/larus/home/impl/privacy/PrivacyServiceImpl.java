package com.larus.home.impl.privacy;

import android.util.EventsUtils;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.home.api.main.IPrivacyService;
import com.larus.nova.view.FlowBDAuthorizeActivity;
import com.larus.nova.view.c;
import com.larus.nova.view.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import ec9.b0;
import ec9.c0;
import ec9.e0;
import ec9.f0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/home/impl/privacy/PrivacyServiceImpl;", "Lcom/larus/home/api/main/IPrivacyService;", "<init>", "()V", "isPrivacyAgreed", XmlPullParser.NO_NAMESPACE, "showPrivacyDialog", XmlPullParser.NO_NAMESPACE, "activity", "Landroid/app/Activity;", "successCallback", "Lkotlin/Function0;", "failCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class PrivacyServiceImpl implements IPrivacyService {

    public static final class a {
    }

    static {
    }

    public PrivacyServiceImpl() {
    }

    @Override // com.larus.home.api.main.IPrivacyService
    public final boolean a() {
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r0 = ISecPrivacyService.a.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.h();
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [T, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment] */
    @Override // com.larus.home.api.main.IPrivacyService
    public final void b(FlowBDAuthorizeActivity r4, c r5, d r6) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        AppHost.Companion r0 = AppHost.a;
        if (r0.isOversea() == false) goto L5;
    L6:
        r5.invoke();
    L7:
        Ref$ObjectRef r1 = new Ref$ObjectRef();
        if (r0.isOversea() == true) goto L27;
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r2 = ISecPrivacyService.a.a();
        if (r2 == null) goto L12;
        boolean r3 = r2.h();
    L13:
        if (r3 == true) goto L28;
        ?? r7 = c0.a(r4, new e0(r4, r1, r5), new f0(r4, r6), false);
        r1.element = r7;
        FragmentManager r8 = r4.getSupportFragmentManager();
        if (r8 == null) goto L29;
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, null, r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r7, r9) == false) goto L25;
    L22:
        b0.a.getClass();
        Result.m48boximpl(b0.d(r4));
        return;
    L25:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L21:
        r7.show(r8, null);
        goto L22
    L29:
        return;
    L28:
        return;
    L12:
        r3 = false;
        goto L13
    L27:
        return;
    L5:
        if (a() == false) goto L7;
        goto L6
    }
}
