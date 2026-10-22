package lr1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f510387b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f510388a;

    /* JADX INFO: renamed from: lr1.a$a, reason: collision with other inner class name */
    public static final class C6730a {
        @JvmStatic
        public static a a(DataCenter r100) {
            if (r100 != null) goto L7;
            return new a(null);
        L7:
            if (r100.has("data_center_vs_config_key") == true) goto L10;
            r100.put("data_center_vs_config_key", new a(r100));
        L10:
            return (a) r100.get("data_center_vs_config_key", new a(null));
        }
    }

    static {
    }

    public final int a() {
        if (this.f510388a != null) goto L6;
        return 0;
    L6:
        if (PadConfigUtils.d() == false) goto L8;
        return 4;
    L8:
        PadConfigUtils.c();
        if (h.d(this.f510388a, true) == false) goto L12;
        return 1;
    L12:
        if (h.d(this.f510388a, true) == true) goto L17;
        return 2;
    L17:
        return 0;
    }

    public final float b() {
        int r100 = a();
        float r101 = 74.0f;
        if (r100 != 3) goto L5;
        ReplayDataContext.a r102 = ReplayDataContext.Companion;
        DataCenter r103 = this.f510388a;
        r102.getClass();
        ReplayDataContext r104 = ReplayDataContext.a.b(r103);
        if (r104 == null) goto L33;
        j<Float> r105 = r104.getPlayerControllerBottomMargin();
        if (r105 == null) goto L33;
        Float r106 = r105.getValue();
        if (r106 == null) goto L33;
        r101 = r106.floatValue();
    L33:
        return 15.0f + r101;
    L5:
        if (r100 != 5) goto L7;
        ReplayDataContext.a r107 = ReplayDataContext.Companion;
        DataCenter r108 = this.f510388a;
        r107.getClass();
        ReplayDataContext r109 = ReplayDataContext.a.b(r108);
        if (r109 == null) goto L34;
        j<Float> r110 = r109.getPlayerControllerBottomMargin();
        if (r110 == null) goto L34;
        Float r111 = r110.getValue();
        if (r111 == null) goto L34;
        r101 = r111.floatValue();
    L34:
        return (r101 + 20.0f) - 8.0f;
    L7:
        if (r100 != 7) goto L35;
        ReplayDataContext.a r112 = ReplayDataContext.Companion;
        DataCenter r113 = this.f510388a;
        r112.getClass();
        ReplayDataContext r114 = ReplayDataContext.a.b(r113);
        if (r114 == null) goto L16;
        j<Float> r115 = r114.getPlayerControllerBottomMargin();
        if (r115 == null) goto L16;
        Float r116 = r115.getValue();
        if (r116 == null) goto L16;
        r101 = r116.floatValue();
    L16:
        r101 = r101 + 15.0f;
        goto L34
    L35:
        return 15.0f;
    }

    public a(DataCenter r100) {
        this.f510388a = r100;
    }
}
