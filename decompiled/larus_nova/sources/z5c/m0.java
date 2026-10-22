package z5c;

import com.obric.capabilitykit.EntityProvider;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;

/* JADX INFO: loaded from: classes38.dex */
public final class m0 extends s5c.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s5c.a f570249c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s5c.a f570250d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final s5c.a f570251e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m0 f570252f = null;

    static {
        m0 r100 = new m0();
        f570252f = r100;
        f570249c = r100.a(PickerReporterConstants.VALUE.CLICK.USER_GROUP);
        f570250d = r100.a("single_user");
        f570251e = r100.a(INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE_BOT);
    }

    public m0() {
        super(EntityProvider.KEY_ENTITY_TYPE);
    }
}
