package ppc;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.forward.textforward.TextForwardContent;
import com.ss.android.lark.forwardv3.messageforward.SingleMessageForwardContent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f530256a = null;

    static {
        f530256a = new j();
    }

    public j() {
    }

    @Override // ppc.e
    public final boolean a(g r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IForwardContent r101 = r100.f530254d.getForwardContent();
        if ((r101 instanceof TextForwardContent) == false) goto L5;
    L14:
        return true;
    L5:
        if ((r101 instanceof SingleMessageForwardContent) == false) goto L13;
        Message r102 = r100.f530254d.getSourceMessage();
        if (r102 == null) goto L9;
        Message.Type r103 = r102.getType();
    L11:
        if (r103 != Message.Type.TEXT) goto L13;
    L9:
        r103 = null;
    L13:
        return false;
    }

    @Override // ppc.e
    public final boolean b(g r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        IForwardContent r100 = r110.f530254d.getForwardContent();
        String r101 = null;
        if ((r100 instanceof TextForwardContent) == false) goto L6;
        String r102 = ((TextForwardContent) r100).f425377b;
    L21:
        if ((!StringsKt.isBlank(r102)) == false) goto L24;
        r101 = r102;
    L24:
        if (r101 != null) goto L26;
        return false;
    L26:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r101, "text");
        if (StringsKt.isBlank(r101) == false) goto L29;
        return false;
    L29:
        FrameLayout r103 = r110.f530253c;
        GradientDrawable r104 = new GradientDrawable();
        r104.setColor(ContextCompat.getColor(r110.getActivity(), R.color.ud_N100));
        r104.setCornerRadius(y9c.d.a(10));
        r103.setBackground(r104);
        LinearLayout r105 = new LinearLayout(r110.getActivity());
        r105.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r105.setGravity(16);
        r105.setMinimumHeight(y9c.d.a(56));
        r105.setOrientation(0);
        r105.setPadding(y9c.d.a(16), y9c.d.a(12), y9c.d.a(16), y9c.d.a(12));
        TextView r106 = new TextView(r110.getActivity());
        r106.setText(r101);
        r106.setEllipsize(TextUtils.TruncateAt.END);
        r106.setMaxLines(2);
        r106.setLineSpacing(y9c.d.a(2), 1.0f);
        r106.setTextColor(ContextCompat.getColor(r110.getActivity(), R.color.ud_N600));
        r106.setTextSize(16.0f);
        r105.addView(r106, new LinearLayout.LayoutParams(-1, -2));
        r110.f530253c.addView(r105);
        r110.f530253c.setVisibility(0);
        return true;
    L6:
        if ((r100 instanceof SingleMessageForwardContent) == false) goto L19;
        Message r107 = r110.f530254d.getSourceMessage();
        if (r107 == null) goto L10;
        TextContent r108 = (TextContent) r107.getContent();
    L12:
        if ((r108 instanceof TextContent) == true) goto L15;
        r108 = null;
    L15:
        if (r108 == null) goto L17;
        r102 = r108.getText();
    L18:
        if (r102 != null) goto L21;
    L17:
        r102 = null;
        goto L18
    L10:
        r108 = null;
    L19:
        r102 = "";
        goto L21
    }
}
