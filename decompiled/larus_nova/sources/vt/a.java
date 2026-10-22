package vt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f557171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f557172b;

    /* JADX INFO: renamed from: vt.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC8040a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f557173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f557174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f557175c;

        public ViewOnClickListenerC8040a(a r100, String r101, Context r102) {
            this.f557173a = r100;
            this.f557174b = r101;
            this.f557175c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = this.f557174b;
            if (r101 == null) goto L5;
            com.bytedance.android.gamecp.host_api.a.b().getActionHandleService().handle(this.f557175c, c.b(r101));
        L5:
            this.f557173a.getAction();
        }
    }

    public interface b {
    }

    public final b getAction() {
        return null;
    }

    public final void setAction(b r100) {
    }

    public final void setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        TextView r101 = this.f557171a;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public void setFootDivideHeight(int r100) {
        View r101 = this.f557172b;
        if (r101 == null) goto L8;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L9;
        r102.height = r100;
        return;
    L9:
        return;
    }

    public a(Context r100, String r101, Float r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        View.inflate(r100, R.layout.gamecp_promote_list_permission, this);
        View r104 = findViewById(R.id.divider);
        this.f557172b = r104;
        TextView r105 = (TextView) findViewById(R.id.tv_game_permission);
        this.f557171a = r105;
        setGravity(16);
        if (r103 == null) goto L9;
        int r106 = y0.c(r103.intValue());
        if (r105 == null) goto L7;
        r105.setTextColor(r106);
    L7:
        if (r104 == null) goto L9;
        r104.setBackgroundColor(r106);
    L9:
        if (r105 == null) goto L11;
        r105.setOnClickListener(new ViewOnClickListenerC8040a(this, r101, r100));
    L11:
        if (r102 == null) goto L16;
        float r107 = r102.floatValue();
        if (r105 == null) goto L17;
        r105.setTextSize(1, r107);
        return;
    L17:
        return;
    }
}
