package sa2;

import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.c;
import com.larus.nova.R;
import f52.i;
import f52.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends j<String> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f541155o;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f541156n;

    /* JADX INFO: renamed from: sa2.a$a, reason: collision with other inner class name */
    public static final class C7589a {
    }

    static {
    }

    public a(c r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        String r100 = r110.f133553a;
        if (r100 != null) goto L5;
        StringBuilder r101 = new StringBuilder("TestPSTopView_");
        int r102 = f541155o;
        f541155o = r102 + 1;
        r101.append(r102);
        r100 = r101.toString();
    L5:
        f52.a r103 = new f52.a(r110.f133554b);
        long r104 = r110.f133556d;
        int r105 = r110.f133557e;
        int r106 = r110.f133558f;
        Integer r107 = Integer.valueOf(r110.f133559g);
        if (r107.intValue() <= 0) goto L8;
        boolean r108 = true;
    L9:
        if (r108 == true) goto L12;
        r107 = null;
    L12:
        if (r107 == null) goto L14;
        int r109 = r107.intValue();
    L15:
        long r111 = r110.f133560h;
        ConflictStrategy r112 = r110.f133561i;
        ConflictStrategy r113 = r110.f133562j;
        ConflictStrategy r114 = r110.f133563k;
        boolean r115 = r110.f133564l;
        String r116 = r110.f133555c;
        if (r116 != null) goto L18;
        r116 = "这是一个测试视图";
    L18:
        super(r100, r103, r104, r105, r106, r109, r111, r112, r113, r114, r115, null, r116, 2048);
        this.f541156n = "id=" + this.f475619a + " priority=" + getType().getPriority();
        return;
    L14:
        r109 = 30;
        goto L15
    L8:
        r108 = false;
        goto L9
    }

    @Override // f52.c
    public final void a(DiscardReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        i.a("on TestPSTopView discard. reason=" + r100 + ". " + this.f541156n);
    }

    @Override // f52.c
    public final void h(f52.b r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        i.a("on TestPSTopView show. " + this.f541156n);
        ((TextView) r100.c(this).findViewById(R.id.content)).setText((CharSequence) this.f475631m);
    }

    @Override // f52.c
    public final CleanStrategy i(f52.b r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        i.a("on TestPSTopView show finish. " + this.f541156n);
        return CleanStrategy.REMOVE_WRAP_VIEW;
    }

    @Override // f52.c
    public final CleanStrategy b(f52.b r100, f52.c r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (r101 == null) goto L6;
        i.a("on TestPSTopView interrupt. triggerId=" + r101.getId() + " triggerType=" + r101.getType() + ' ' + this.f541156n + ". ");
    L6:
        return CleanStrategy.REMOVE_WRAP_VIEW;
    }
}
