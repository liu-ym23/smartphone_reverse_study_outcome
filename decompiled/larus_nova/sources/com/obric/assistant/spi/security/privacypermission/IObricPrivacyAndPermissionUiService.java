package com.obric.assistant.spi.security.privacypermission;

import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u008f\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072u\u0010\b\u001aq\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00030\tH&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0015H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH&J\b\u0010\u0019\u001a\u00020\u000eH&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0015H&J\b\u0010\u001c\u001a\u00020\u0015H&¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/spi/security/privacypermission/IObricPrivacyAndPermissionUiService;", "", "setupObricSystemPermissionItems", "", "host", "Landroidx/fragment/app/Fragment;", "itemsStub", "Landroid/view/ViewStub;", "onRequestGoSettings", "Lkotlin/Function5;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "permissionType", "title", "message", "confirmText", "releaseObricSystemPermissionItems", "isPermissionRequestUiCustomizeEnabled", "", "getPermissionRequestUiDialogTitle", "type", "getPermissionRequestUiDialogSubtitle", "getNotesDisplayName", "setInterceptGoToSettingsDialog", "intercept", "shouldInterceptGoToSettingsDialog", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricPrivacyAndPermissionUiService {
    String a();

    void b(Fragment r100, ViewStub r101, Function5<? super View, ? super String, ? super String, ? super String, ? super String, Unit> r102);

    void c();

    boolean d();

    void e();

    String f(String r100);

    String g(String r100);
}
