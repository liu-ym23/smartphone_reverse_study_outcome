package vt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import bw.r;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f557176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f557177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f557178c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f557179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f557180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f557181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f557182d;

        public a(b r100, String r101, Context r102, String r103) {
            this.f557179a = r100;
            this.f557180b = r101;
            this.f557181c = r102;
            this.f557182d = r103;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = this.f557180b;
            if (r101 == null) goto L12;
            Function0<Unit> r102 = this.f557179a.f557178c;
            if (r102 == null) goto L7;
            Unit r103 = r102.invoke();
        L7:
            r r104 = com.bytedance.android.gamecp.host_api.a.b().getActionHandleService();
            Context r105 = this.f557181c;
            String r106 = this.f557182d;
            if (r106 != null) goto L10;
            r106 = "";
        L10:
            r104.openExternalBrowser(r105, r101, r106);
            return;
        }
    }

    public final void setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        TextView r101 = this.f557176a;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public void setFootDivideHeight(int r100) {
        View r101 = this.f557177b;
        if (r101 == null) goto L8;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L9;
        r102.height = r100;
        return;
    L9:
        return;
    }

    public final void setOnBeforeClick(Function0<Unit> r100) {
        this.f557178c = r100;
    }

    public b(Context r100, String r101, Float r102, Integer r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        View.inflate(r100, R.layout.gamecp_promote_list_privacy, this);
        setGravity(16);
        View r105 = findViewById(R.id.divider);
        this.f557177b = r105;
        TextView r106 = (TextView) findViewById(R.id.tv_game_privacy);
        this.f557176a = r106;
        if (r103 == null) goto L9;
        int r107 = y0.c(r103.intValue());
        if (r106 == null) goto L7;
        r106.setTextColor(r107);
    L7:
        if (r105 == null) goto L9;
        r105.setBackgroundColor(r107);
    L9:
        if (r106 == null) goto L11;
        r106.setOnClickListener(new a(this, r101, r100, r104));
    L11:
        if (r102 == null) goto L16;
        float r108 = r102.floatValue();
        if (r106 == null) goto L17;
        r106.setTextSize(1, r108);
        return;
    L17:
        return;
    }
}
