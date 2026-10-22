package com.bytedance.ee.bear.bitable.card.view.cell;

import androidx.core.app.NotificationCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/ECellEditMenuItem;", "", "icon", "", "itemTitle", "", "reportValue", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getIcon", "()I", "getItemTitle", "()Ljava/lang/String;", "getReportValue", "SEND_EMAIL", "EDIT", "VIEW_MAP", "RELOCATE", "CALL_PHONE", "SEND_MESSAGE", "OPEN_URL", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ECellEditMenuItem extends Enum<ECellEditMenuItem> {
    public static final ECellEditMenuItem CALL_PHONE = null;
    public static final ECellEditMenuItem EDIT = null;
    public static final ECellEditMenuItem OPEN_URL = null;
    public static final ECellEditMenuItem RELOCATE = null;
    public static final ECellEditMenuItem SEND_EMAIL = null;
    public static final ECellEditMenuItem SEND_MESSAGE = null;
    public static final ECellEditMenuItem VIEW_MAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECellEditMenuItem[] f207271a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207272b = null;
    private final int icon;
    private final String itemTitle;
    private final String reportValue;

    public static EnumEntries<ECellEditMenuItem> getEntries() {
        return f207272b;
    }

    static {
        ECellEditMenuItem r100 = new ECellEditMenuItem("SEND_EMAIL", 0, R.drawable.ud_icon_mail_outlined, UIHelper.getString(R.string.Bitable_Mobile_Field_SendEmail_Option), "email");
        SEND_EMAIL = r100;
        ECellEditMenuItem r101 = new ECellEditMenuItem("EDIT", 1, R.drawable.ud_icon_ccm_edit_outlined, UIHelper.getString(R.string.Bitable_Common_ButtonEdit), "edit");
        EDIT = r101;
        ECellEditMenuItem r102 = new ECellEditMenuItem("VIEW_MAP", 2, R.drawable.ud_icon_local_outlined, UIHelper.getString(R.string.Bitable_Mobile_Field_ViewMap_Option), "map");
        VIEW_MAP = r102;
        ECellEditMenuItem r103 = new ECellEditMenuItem("RELOCATE", 3, R.drawable.ud_icon_refresh_outlined, UIHelper.getString(R.string.Bitable_Mobile_Field_Relocate_Option), "locate");
        RELOCATE = r103;
        ECellEditMenuItem r104 = new ECellEditMenuItem("CALL_PHONE", 4, R.drawable.ud_icon_call_net_outlined, UIHelper.getString(R.string.Bitable_PhoneNumber_Call_Mobile), NotificationCompat.CATEGORY_CALL);
        CALL_PHONE = r104;
        ECellEditMenuItem r105 = new ECellEditMenuItem("SEND_MESSAGE", 5, R.drawable.ud_icon_mail_outlined, UIHelper.getString(R.string.Bitable_PhoneNumber_Message_Mobile), "message");
        SEND_MESSAGE = r105;
        ECellEditMenuItem r106 = new ECellEditMenuItem("OPEN_URL", 6, R.drawable.ud_icon_window_new_outlined, UIHelper.getString(R.string.Bitable_Form_OpenLinkMobileVer), "open_link");
        OPEN_URL = r106;
        ECellEditMenuItem[] r107 = {r100, r101, r102, r103, r104, r105, r106};
        f207271a = r107;
        f207272b = EnumEntriesKt.enumEntries(r107);
    }

    public static ECellEditMenuItem[] values() {
        return (ECellEditMenuItem[]) f207271a.clone();
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getItemTitle() {
        return this.itemTitle;
    }

    public final String getReportValue() {
        return this.reportValue;
    }

    public static ECellEditMenuItem valueOf(String r100) {
        return (ECellEditMenuItem) r27.a.a(ECellEditMenuItem.class, r100);
    }

    public ECellEditMenuItem(String r100, int r101, int r102, String r103, String r104) {
        super(r100, r101);
        this.icon = r102;
        this.itemTitle = r103;
        this.reportValue = r104;
    }
}
