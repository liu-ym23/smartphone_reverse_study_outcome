package ppc;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f530255a = null;

    static {
        f530255a = new i();
    }

    public i() {
    }

    @Override // ppc.e
    public final boolean a(g r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        BasicDialogContentConfig r101 = r100.f530254d.getDialogContent();
        if ((!StringsKt.isBlank(r101.f425130c)) == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
    L18:
        return false;
    L10:
        if (Intrinsics.areEqual(r100.f530254d.getDialogContent().f425128a, "doubao_profile") == true) goto L20;
        Message r103 = r100.f530254d.getSourceMessage();
        if (r103 == null) goto L14;
        Message.Type r104 = r103.getType();
    L16:
        if (r104 != Message.Type.SHARE_USER_CARD) goto L18;
        return true;
    L14:
        r104 = null;
        goto L16
    L20:
        return true;
    L5:
        if (r101.f425135h == null) goto L7;
        r102 = true;
        goto L8
    }

    @Override // ppc.e
    public final boolean b(g r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        BasicDialogContentConfig r100 = r110.f530254d.getDialogContent();
        a r101 = new a(r100.f425129b, r100.f425130c, r100.f425131d, r100.f425135h);
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r101, "data");
        if ((!StringsKt.isBlank(r101.f530241a)) == false) goto L5;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == true) goto L15;
        return false;
    L15:
        r110.f530253c.setBackgroundResource(R.drawable.doubao_forward_preview_bg);
        View r103 = r110.getActivity().getLayoutInflater().inflate(R.layout.view_doubao_forward_basic_preview, r110.f530253c, false);
        ImageView r104 = (ImageView) r103.findViewById(R.id.doubao_forward_preview_icon);
        TextView r105 = (TextView) r103.findViewById(R.id.doubao_forward_preview_title);
        TextView r111 = (TextView) r103.findViewById(R.id.doubao_forward_preview_content);
        TextView r112 = (TextView) r103.findViewById(R.id.doubao_forward_preview_desc);
        Image r106 = r101.f530244d;
        if (r106 == null) goto L18;
        r104.setVisibility(0);
        int r113 = y9c.d.a(40);
        Activity r107 = r110.getActivity();
        Intrinsics.checkNotNull(r104);
        com.ss.android.lark.forwardv3.utils.a.a(r107, r104, false, r106, false, true, r113, r113);
    L18:
        Intrinsics.checkNotNull(r105);
        h.a(r105, r101.f530241a);
        Intrinsics.checkNotNull(r111);
        h.a(r111, r101.f530242b);
        Intrinsics.checkNotNull(r112);
        h.a(r112, r101.f530243c);
        r110.f530253c.addView(r103);
        r110.f530253c.setVisibility(0);
        return true;
    L5:
        if ((!StringsKt.isBlank(r101.f530242b)) == true) goto L12;
        if ((!StringsKt.isBlank(r101.f530243c)) == true) goto L12;
        if (r101.f530244d != null) goto L12;
        r102 = false;
        goto L13
    }
}
