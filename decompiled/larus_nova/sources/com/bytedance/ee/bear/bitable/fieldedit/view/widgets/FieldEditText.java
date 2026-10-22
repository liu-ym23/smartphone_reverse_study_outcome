package com.bytedance.ee.bear.bitable.fieldedit.view.widgets;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.ViewKt;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldEditPanelData;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.BitableFieldEditFragment;
import com.bytedance.ee.bear.bitable.fieldedit.viewmodel.BitableFieldEditViewModel;
import com.bytedance.ee.bear.bitable.utils.g;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0016\b\u0016\u0012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0005\u0010\u0006B%\b\u0016\u0012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004\u0012\r\u0010\u0007\u001a\t\u0018\u00010\b¢\u0006\u0002\b\t¢\u0006\u0004\b\u0005\u0010\nB-\b\u0016\u0012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004\u0012\r\u0010\u0007\u001a\t\u0018\u00010\b¢\u0006\u0002\b\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0005\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H\u0014R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/FieldEditText;", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Lorg/jetbrains/annotations/NotNull;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "Lorg/jetbrains/annotations/Nullable;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "updateEditMode", "onTextContextMenuItem", "", "id", "getDocToken", "isFilterMenuWhiteList", "isWordOver", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FieldEditText extends SpaceEditText {
    public final String V0;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f211718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FieldEditText f211719b;

        public a(boolean r100, FieldEditText r101) {
            this.f211718a = r100;
            this.f211719b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f211718a == true) goto L6;
            UDToast.show(this.f211719b.getContext(), R.string.Doc_Block_NotSupportEditInLandscape, R.drawable.ud_icon_warning_outlined);
            return;
        }
    }

    private final String getDocToken() {
        BitableFieldEditViewModel r100 = (BitableFieldEditViewModel) q.a((BitableFieldEditFragment) ViewKt.findFragment(this), BitableFieldEditViewModel.class);     // Catch: Exception -> L16
        String r101 = r100.getDocToken();     // Catch: Exception -> L16
        if (g.b() == false) goto L21;
        FieldEditPanelData r102 = r100.getPanelData().getValue();     // Catch: Exception -> L16
        if (r102 == null) goto L8;
        String r103 = r102.getSrcObjToken();     // Catch: Exception -> L16
    L10:
        if (TextUtils.isEmpty(r103) == true) goto L22;
        FieldEditPanelData r104 = r100.getPanelData().getValue();     // Catch: Exception -> L16
        if (r104 == null) goto L23;
        return r104.getSrcObjToken();
    L23:
        return null;
    L22:
        return r101;
    L8:
        r103 = null;
        goto L10
    L21:
        return r101;
    L16:
        e = move-exception;
        tt5.a.d(this.V0, "get_file_token_ex:" + e.getMessage());
        return "";
    }

    public final void C() {
        boolean r100 = true;
        boolean r101 = !ku5.c.k(getContext());
        if (getResources().getConfiguration().orientation != 2) goto L5;
        boolean r102 = true;
    L6:
        if (r101 == false) goto L10;
        if (r102 == false) goto L10;
        r100 = false;
    L10:
        setFocusable(r100);
        setFocusableInTouchMode(r100);
        setCursorVisible(r100);
        Resources r103 = getResources();
        if (r100 == false) goto L13;
        int r104 = R.color.text_title;
    L14:
        setTextColor(r103.getColor(r104));
        setOnClickListener(new a(r100, this));
        return;
    L13:
        r104 = R.color.text_disable;
        goto L14
    L5:
        r102 = false;
        goto L6
    }

    public FieldEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.V0 = "FieldEditText";
        C();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        C();
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText, androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r110) {
        switch(r110) {
            case 16908320: goto L4;
            case 16908321: goto L4;
            default: goto L20;
        };
    L4:
        String r100 = getDocToken();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L9;
        BaseEntity r101 = new BaseEntity(r100, sbb.e.f541298i, BizDomain.FileBizDomainCCM, "");
        PermissionResponse r102 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r101, "CONTENT_COPY"), null);
        r102.getCallback().a(getContext(), r102);
        if (r102.getAllow() == true) goto L20;
        return true;
    L9:
        gj5.b r103 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        FileBizDomain r104 = FileBizDomain.FileBizDomainCCM;
        gj5.c r105 = r103.g("CCM_CONTENT_COPY", r104, 8, r100);
        if (r105.f481503a == true) goto L20;
        FileAuthResultFrom r111 = r105.f481504b;
        if (r111 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L15;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_CONTENT_COPY", r104, 8, "");
    L18:
        return true;
    L15:
        if (r111 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L17;
        Toast.showFailureText(getContext(), R.string.CreationMobile_ECM_AdminDisableToast);
        goto L18
    L17:
        tt5.a.d(this.V0, "FieldEditText not allow copy/cut from unknown source");
    L20:
        return super.onTextContextMenuItem(r110);
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public final boolean y(boolean r100) {
        if (((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).o() == true) goto L5;
        return true;
    L5:
        BaseEntity r101 = new BaseEntity(getDocToken(), sbb.e.f541298i, BizDomain.FileBizDomainCCM, "");
        boolean r102 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r101, "CONTENT_COPY"), null).getAllow();
        if (r100 == false) goto L9;
        if (r102 == true) goto L9;
        return true;
    L9:
        return false;
    }

    public FieldEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.V0 = "FieldEditText";
        C();
    }

    public FieldEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.V0 = "FieldEditText";
        C();
    }
}
