package vf7;

import android.app.Activity;
import android.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.supervisor.token.AtomicInfoDef;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import lf7.d;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f554596a = null;

    static {
        f554596a = new b();
    }

    public b() {
    }

    public final a g() {
        lf7.b r100 = d.f509087a;
        Intrinsics.checkNotNullParameter(this, "this");
        lf7.a r101 = d.a("permission");
        if ((r101 instanceof a) == false) goto L6;
        return (a) r101;
    L6:
        return new c();
    }

    public static List f(String[] r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L152;
        String r104 = r100[r103];
        switch(r104.hashCode()) {
            case -2062386608: goto L148;
            case -1928411001: goto L144;
            case -1921431796: goto L140;
            case -1888586689: goto L136;
            case -1674700861: goto L132;
            case -1479758289: goto L128;
            case -1164582768: goto L124;
            case -1142799244: goto L120;
            case -895679497: goto L116;
            case -895673731: goto L112;
            case -798669607: goto L108;
            case -406040016: goto L104;
            case -142952445: goto L100;
            case -63024214: goto L96;
            case -5573545: goto L92;
            case 52602690: goto L88;
            case 112197485: goto L84;
            case 175802396: goto L80;
            case 214526995: goto L76;
            case 441496538: goto L72;
            case 463403621: goto L68;
            case 603653886: goto L64;
            case 610633091: goto L60;
            case 691260818: goto L56;
            case 710297143: goto L52;
            case 784519842: goto L48;
            case 952819282: goto L44;
            case 1166454870: goto L40;
            case 1365911975: goto L36;
            case 1740987387: goto L32;
            case 1780337063: goto L28;
            case 1831139720: goto L24;
            case 1977429404: goto L20;
            case 2062356686: goto L16;
            case 2114579147: goto L12;
            case 2133799037: goto L8;
            default: goto L151;
        };
    L8:
        if (r104.equals("com.android.voicemail.permission.ADD_VOICEMAIL") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_ADD_VOICEMAIL);
        goto L151
    L12:
        if (r104.equals("android.permission.ACCESS_MEDIA_LOCATION") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_ACCESS_MEDIA_LOCATION);
        goto L151
    L16:
        if (r104.equals("android.permission.BLUETOOTH_SCAN") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_BLUETOOTH_SCAN);
        goto L151
    L20:
        if (r104.equals("android.permission.READ_CONTACTS") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_READ_CONTACTS);
        goto L151
    L24:
        if (r104.equals("android.permission.RECORD_AUDIO") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_RECORD_AUDIO);
        goto L151
    L28:
        if (r104.equals("android.permission.ACTIVITY_RECOGNITION") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_ACTIVITY_RECOGNITION);
        goto L151
    L32:
        if (r104.equals("android.permission.UWB_RANGING") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_UWB_RANGING);
        goto L151
    L36:
        if (r104.equals("android.permission.WRITE_EXTERNAL_STORAGE") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_WRITE_EXTERNAL_STORAGE);
        goto L151
    L40:
        if (r104.equals("android.permission.BLUETOOTH_ADVERTISE") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_BLUETOOTH_ADVERTISE);
        goto L151
    L44:
        if (r104.equals("android.permission.PROCESS_OUTGOING_CALLS") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_PROCESS_OUTGOING_CALLS);
        goto L151
    L48:
        if (r104.equals("android.permission.USE_SIP") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_USE_SIP);
        goto L151
    L52:
        if (r104.equals(BaseConstants.PERMISSION_READ_MEDIA_VIDEO) == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_READ_MEDIA_VIDEO);
        goto L151
    L56:
        if (r104.equals(BaseConstants.PERMISSION_READ_MEDIA_AUDIO) == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_READ_MEDIA_AUDIO);
        goto L151
    L60:
        if (r104.equals("android.permission.WRITE_CALL_LOG") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_WRITE_CALL_LOG);
        goto L151
    L64:
        if (r104.equals("android.permission.WRITE_CALENDAR") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_WRITE_CALENDAR);
        goto L151
    L68:
        if (r104.equals("android.permission.CAMERA") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_CAMERA);
        goto L151
    L72:
        if (r104.equals("android.permission.ACCEPT_HANDOVER") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_ACCEPT_HANDOVER);
        goto L151
    L76:
        if (r104.equals("android.permission.WRITE_CONTACTS") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_WRITE_CONTACTS);
        goto L151
    L80:
        if (r104.equals(BaseConstants.PERMISSION_READ_MEDIA_IMAGES) == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_READ_MEDIA_IMAGES);
        goto L151
    L84:
        if (r104.equals("android.permission.CALL_PHONE") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_CALL_PHONE);
        goto L151
    L88:
        if (r104.equals("android.permission.SEND_SMS") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_SEND_SMS);
        goto L151
    L92:
        if (r104.equals("android.permission.READ_PHONE_STATE") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_READ_PHONE_STATE);
        goto L151
    L96:
        if (r104.equals("android.permission.ACCESS_COARSE_LOCATION") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_ACCESS_COARSE_LOCATION);
        goto L151
    L100:
        if (r104.equals("android.permission.GET_ACCOUNTS_PRIVILEGED") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_GET_ACCOUNTS_PRIVILEGED);
        goto L151
    L104:
        if (r104.equals("android.permission.READ_EXTERNAL_STORAGE") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_READ_EXTERNAL_STORAGE);
        goto L151
    L108:
        if (r104.equals("android.permission.BLUETOOTH_CONNECT") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_BLUETOOTH_CONNECT);
        goto L151
    L112:
        if (r104.equals("android.permission.RECEIVE_SMS") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_RECEIVE_SMS);
        goto L151
    L116:
        if (r104.equals("android.permission.RECEIVE_MMS") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_RECEIVE_MMS);
        goto L151
    L120:
        if (r104.equals("android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_READ_MEDIA_VISUAL);
        goto L151
    L124:
        if (r104.equals("android.permission.READ_PHONE_NUMBERS") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_READ_PHONE_NUMBERS);
        goto L151
    L128:
        if (r104.equals("android.permission.RECEIVE_WAP_PUSH") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_RECEIVE_WAP_PUSH);
        goto L151
    L132:
        if (r104.equals("android.permission.ANSWER_PHONE_CALLS") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_ANSWER_PHONE_CALLS);
        goto L151
    L136:
        if (r104.equals("android.permission.ACCESS_FINE_LOCATION") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_ACCESS_FINE_LOCATION);
        goto L151
    L140:
        if (r104.equals("android.permission.READ_CALL_LOG") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_READ_CALL_LOG);
        goto L151
    L144:
        if (r104.equals("android.permission.READ_CALENDAR") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_READ_CALENDAR);
        goto L151
    L148:
        if (r104.equals("android.permission.READ_SMS") == false) goto L151;
        r101.add(AtomicInfoDef.REQUEST_PERMISSIONS_READ_SMS);
    L151:
        r103 = r103 + 1;
        goto L3
    L152:
        return r101;
    }

    @Override // vf7.a
    public final void c(Activity r100, String[] r101, int r102, Token r103) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r103, "token");
        rf7.a.a(r103, new of7.b(f(r101), r101));
        g().c(r100, r101, r102, r103);
    }

    @Override // vf7.a
    public void requestPermissions(Activity r100, String[] r101, int r102, Token r103) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r103, "token");
        rf7.a.a(r103, new of7.b(f(r101), r101));
        g().requestPermissions(r100, r101, r102, r103);
    }

    @Override // vf7.a
    public void requestPermissions(Fragment r100, String[] r101, int r102, Token r103) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r103, "token");
        rf7.a.a(r103, new of7.b(f(r101), r101));
        g().requestPermissions(r100, r101, r102, r103);
    }

    @Override // vf7.a
    public void requestPermissions(androidx.fragment.app.Fragment r100, String[] r101, int r102, Token r103) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r103, "token");
        rf7.a.a(r103, new of7.b(f(r101), r101));
        g().requestPermissions(r100, r101, r102, r103);
    }
}
