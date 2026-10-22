package s62;

import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f540792a;

    public d(a r100) {
        this.f540792a = r100;
    }

    @Override // com.bytedance.android.livesdk.app.dataholder.Observer
    public final void onChanged(Object r100) {
        if (((Integer) r100) == null) goto L22;
        Integer r101 = (Integer) hd0.c.f().f481009b;
        boolean r102 = true;
        if (r101 != null) goto L9;
    L10:
        Integer r103 = (Integer) hd0.c.f().f481009b;
        if (r103 != null) goto L14;
    L16:
        r102 = false;
    L17:
        cc2.e r104 = new cc2.e();
        r104.a(cc2.a.class, cc2.a.b.f23137c, r102);
        DataCenter r105 = this.f540792a.f540789k;
        if (r105 == null) goto L21;
        r105.put("cmd_change_interactivity_component_visibility", r104);
        return;
    L21:
        return;
    L14:
        if (2 != r103.intValue()) goto L16;
    L9:
        if (1 == r101.intValue()) goto L17;
    }
}
