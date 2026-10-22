package com.ss.android.lark.contact.customized.externalinvite.view;

import android.view.View;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeInviteExternalFragment f419268a;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.externalinvite.view.a$a, reason: collision with other inner class name */
    public static final class C4936a implements com.ss.android.lark.utils.h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeInviteExternalFragment f419269a;

        public C4936a(OfficeInviteExternalFragment r100) {
            this.f419269a = r100;
        }

        @Override // com.ss.android.lark.utils.h.e
        public final void a(boolean r100) {
            if (r100 == true) goto L10;
            return;
        L10:
            Statistics.sendEvent("Scan_QRCode_Contacts", InvHitPoint.b(this.f419269a.f419263d).put("origination", "invite_external_contacts_scan").put("source", "add_external_contact"));     // Catch: JSONException -> L6
        L8:
            this.f419269a.U90().startScanQRCodeActivity(this.f419269a);
            Statistics.sendEvent("invite_people_external_Scan_QRCode_click", InvHitPoint.b(this.f419269a.f419263d));
            return;
        L6:
            e = move-exception;
            Log.e("InvHitPoint", e);
            goto L8
        }
    }

    public a(OfficeInviteExternalFragment r100) {
        this.f419268a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.ss.android.lark.utils.h.b(this.f419268a.getActivity(), new C4936a(this.f419268a));
    }
}
