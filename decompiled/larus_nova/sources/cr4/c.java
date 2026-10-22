package cr4;

import android.content.DialogInterface;
import com.bytedance.ee.bear.bitable.celleditor.bean.EditorLocation;
import com.bytedance.ee.bear.bitable.celleditor.editor.phone.PhoneEditorViewModel;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.document.telephoneability.TelephoneAbilityPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhoneEditorViewModel f465077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditorLocation f465078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.celleditor.editor.b f465079c;

    public c(PhoneEditorViewModel r100, EditorLocation r101, com.bytedance.ee.bear.bitable.celleditor.editor.b r102) {
        this.f465077a = r100;
        this.f465078b = r101;
        this.f465079c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        BitableAnalytic r102 = this.f465077a.f209436a.f486862d;
        r102.getClass();
        HashMap r103 = new HashMap();
        r103.put("click", "know");
        r103.put(PickerReporterConstants.KEY.TARGET, "none");
        r102.t("ccm_bitable_tel_contact_guide_click", r103);
        ay4.b.c(DocumentType.BITABLE_NAME).putBoolean(TelephoneAbilityPlugin.OPEN_CONTACTS_WARNING, false);
        this.f465077a.a(this.f465078b, this.f465079c);
    }
}
