package ofa;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ItemTextArrow f523128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ItemTextArrow f523129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ItemTextArrow f523130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ItemTextArrow f523131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function5<? super View, ? super String, ? super String, ? super String, ? super String, Unit> f523132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Lifecycle f523133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f523134g;

    public c() {
    }

    public final void b() {
        this.f523128a = null;
        this.f523129b = null;
        this.f523130c = null;
        this.f523131d = null;
        this.f523132e = null;
        a r100 = this.f523134g;
        if (r100 == null) goto L7;
        Lifecycle r101 = this.f523133f;
        if (r101 == null) goto L7;
        r101.removeObserver(r100);
    L7:
        this.f523134g = null;
        this.f523133f = null;
    }

    public final void a(ItemTextArrow r100, final String r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        e1.x(r100);
        TextView r101 = r100.getTextView();
        Integer r102 = null;
        switch(r110.hashCode()) {
            case -178324674: goto L20;
            case -172298781: goto L16;
            case 114009: goto L12;
            case 951526432: goto L8;
            default: goto L23;
        };
    L23:
        String r103 = null;
    L24:
        r101.setText(r103);
        switch(r110.hashCode()) {
            case -178324674: goto L40;
            case -172298781: goto L36;
            case 114009: goto L32;
            case 951526432: goto L28;
            default: goto L43;
        };
    L43:
        String r104 = null;
    L44:
        if (r104 != null) goto L46;
        r104 = "";
    L46:
        r100.Z5(r104, null);
        switch(r110.hashCode()) {
            case -178324674: goto L62;
            case -172298781: goto L58;
            case 114009: goto L54;
            case 951526432: goto L50;
            default: goto L65;
        };
    L65:
        if (r102 == null) goto L67;
        int r105 = r102.intValue();
    L68:
        r100.setImageSrc(r105);
        e1.d(r100, new b(this, r110));
        return;
    L67:
        r105 = 0;
        goto L68
    L50:
        if (r110.equals("contact") == false) goto L65;
        r102 = Integer.valueOf(R.drawable.obric_ic_contact_privacy_and_permission);
        goto L65
    L54:
        if (r110.equals("sms") == false) goto L65;
        r102 = Integer.valueOf(R.drawable.obric_ic_sms_privacy_and_permission);
        goto L65
    L58:
        if (r110.equals("call_log") == false) goto L65;
        r102 = Integer.valueOf(R.drawable.obric_ic_call_log_privacy_and_permission);
        goto L65
    L62:
        if (r110.equals("calendar") == false) goto L65;
        r102 = Integer.valueOf(R.drawable.obric_ic_calendar_privacy_and_permission);
        goto L65
    L28:
        if (r110.equals("contact") == false) goto L70;
        r104 = AppHost.f326268a.getApplication().getString(R.string.obric_privacySetting_bottomsheet_btn_contact);
        goto L44
    L70:
        r104 = null;
        goto L44
    L32:
        if (r110.equals("sms") == false) goto L71;
        r104 = AppHost.f326268a.getApplication().getString(R.string.obric_privacySetting_bottomsheet_btn_sms);
        goto L44
    L71:
        r104 = null;
        goto L44
    L36:
        if (r110.equals("call_log") == false) goto L72;
        r104 = AppHost.f326268a.getApplication().getString(R.string.obric_privacySetting_bottomsheet_btn_call_log);
        goto L44
    L72:
        r104 = null;
        goto L44
    L40:
        if (r110.equals("calendar") == false) goto L73;
        r104 = AppHost.f326268a.getApplication().getString(R.string.obric_privacySetting_bottomsheet_btn_calendar);
        goto L44
    L73:
        r104 = null;
        goto L44
    L8:
        if (r110.equals("contact") == false) goto L74;
        r103 = AppHost.f326268a.getApplication().getString(R.string.obric_systemPrivacySetting_menuOption_contact);
        goto L24
    L74:
        r103 = null;
        goto L24
    L12:
        if (r110.equals("sms") == false) goto L75;
        r103 = AppHost.f326268a.getApplication().getString(R.string.obric_systemPrivacySetting_menuOption_sms);
        goto L24
    L75:
        r103 = null;
        goto L24
    L16:
        if (r110.equals("call_log") == false) goto L76;
        r103 = AppHost.f326268a.getApplication().getString(R.string.obric_systemPrivacySetting_menuOption_call_log);
        goto L24
    L76:
        r103 = null;
        goto L24
    L20:
        if (r110.equals("calendar") == false) goto L77;
        r103 = AppHost.f326268a.getApplication().getString(R.string.obric_systemPrivacySetting_menuOption_calendar);
        goto L24
    L77:
        r103 = null;
        goto L24
    }
}
