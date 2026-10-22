package ms;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.gamecp.base.core.service.depend.x;
import com.bytedance.android.gamecp.business.download.DownloadInfoFactory;
import com.bytedance.android.gamecp.business.download.p;
import com.bytedance.android.gamecp.business.download.s;
import com.bytedance.android.gamecp.business.download.y0;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wu.b1;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f515090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f515091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f515092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f515093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f515094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f515095f;

    /* JADX INFO: renamed from: ms.a$a, reason: collision with other inner class name */
    public static final class C6846a {
    }

    public static final class b extends com.bytedance.android.gamecp.business.downloadview.hande.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f515096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f515097c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f515098d;

        @Override // com.bytedance.android.gamecp.business.downloadview.hande.a, com.bytedance.android.gamecp.base.core.service.depend.n
        public final void passThrough(int r100) {
            yr.c.a("DownloadPauseDialog", "passThrough status = " + r100);
            if (r100 != 2) goto L8;
            p r101 = this.f515097c.f515093d;
            if (r101 == null) goto L7;
            r101.f52878v0 = true;
        L7:
            y0.f52963a.a(this.f515098d, r101);
        L8:
            Integer r102 = this.f515096b;
            if (r102 != null) goto L12;
            this.f515096b = Integer.valueOf(r100);
            return;
        L12:
            if (r102 != null) goto L15;
        L16:
            y0.f52963a.i(this.f515098d, this.f515097c.f515093d);
            return;
        L15:
            if (r100 != r102.intValue()) goto L16;
        }

        public b(a r100, Context r101) {
            this.f515097c = r100;
            this.f515098d = r101;
            super(null);
        }
    }

    static {
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        com.bytedance.android.gamecp.common.ui.f r100 = com.bytedance.android.gamecp.common.ui.f.a();
        r100.getClass();
        com.bytedance.android.gamecp.common.ui.f.f56987c++;
        r100.f56988a.postValue(Boolean.TRUE);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        com.bytedance.android.gamecp.common.ui.f.a().b();
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r100 = getWindow();
        if (r100 == null) goto L10;
        WindowManager.LayoutParams r101 = r100.getAttributes();
    L11:
        if (r101 == null) goto L13;
        r101.width = com.bytedance.android.gamecp.common.utils.y0.b(280.0f);
    L13:
        Window r102 = getWindow();
        if (r102 == null) goto L20;
        r102.setAttributes(r101);
        return;
    L20:
        return;
    L10:
        r101 = null;
        goto L11
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        x r100 = null;
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.gamecp_dialog_download_pause_mobile_data_tips, null);
        this.f515090a = r101;
        Intrinsics.checkNotNull(r101);
        setContentView(r101);
        boolean r102 = false;
        if (this.f515095f == 1) goto L22;
        TokenCert r103 = i.f515456a;
        p r104 = this.f515093d;
        if (r104 == null) goto L9;
        s r105 = r104.G0;
        if (r105 == null) goto L9;
        Long r106 = Long.valueOf(r105.f52929m);
    L10:
        p r107 = this.f515093d;
        if (r107 == null) goto L15;
        s r108 = r107.G0;
        if (r108 == null) goto L15;
        r100 = r108.f52926j;
    L15:
        String r109 = i.b(r106, r100, true);
        if (r109.length() != 0) goto L18;
        boolean r111 = true;
    L19:
        if (r111 == false) goto L21;
        r109 = com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_dialog_default);
    L21:
        ((TextView) findViewById(R.id.tv_title)).setText(com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_wifi_data_tips_dialog_title));
        ((TextView) findViewById(R.id.tv_content)).setText(r109);
        ((TextView) findViewById(R.id.tv_btn_left)).setText(com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_wifi_data_tips_dialog_left));
        ((TextView) findViewById(R.id.tv_btn_right)).setText(com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_wifi_tips_dialog_right));
    L23:
        ((TextView) findViewById(R.id.tv_btn_left)).setOnClickListener(new e(this));
        ((TextView) findViewById(R.id.tv_btn_right)).setOnClickListener(new f(this));
        this.f515092c = b1.f561283a.getValue().a();
        yr.c.b("download_pause_dialog", "config.downloadManageUrl=" + this.f515092c);
        String r112 = this.f515092c;
        if (r112 != null) goto L26;
    L27:
        r102 = true;
    L28:
        if (r102 == false) goto L30;
        this.f515092c = "https://apps.bytesfield.com/app/download?from_scene=dygame_pause_dialog";
    L30:
        View r113 = findViewById(R.id.download_manage_container);
        this.f515091b = r113;
        if (r113 == null) goto L33;
        r113.setOnClickListener(new g(this));
    L33:
        View r114 = this.f515090a;
        if (r114 != null) goto L36;
        return;
    L36:
        if (this.f515095f == 1) goto L38;
        String r115 = "wifi_retrieve_page";
    L39:
        String r116 = r115;
        HashMap<String, String> r117 = GamecpTracker.f56755a;
        Intrinsics.checkNotNull(r114);
        GamecpTracker.x(this, r114, r116, MapsKt.emptyMap(), MapsKt.emptyMap(), true, false, 192);
        GamecpTracker.p(this);
        if (this.f515095f == 1) goto L42;
        String r118 = "continue_download_btn";
    L43:
        GamecpTracker.r(findViewById(R.id.tv_btn_right), r118, MapsKt.emptyMap(), new ms.b(), false, 112);
        GamecpTracker.r(findViewById(R.id.tv_btn_left), "pause_download", MapsKt.emptyMap(), new c(), false, 112);
        View r119 = this.f515091b;
        Intrinsics.checkNotNull(r119);
        GamecpTracker.r(r119, "manage_download_task", MapsKt.emptyMap(), new d(), false, 112);
        return;
    L42:
        r118 = "wifi_continue_download";
        goto L43
    L38:
        r115 = "mobile_retrieve_page";
        goto L39
    L26:
        if (r112.length() != 0) goto L28;
    L18:
        r111 = false;
    L9:
        r106 = null;
        goto L10
    L22:
        ((TextView) findViewById(R.id.tv_title)).setText(com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_mobile_data_tips_dialog_title));
        ((TextView) findViewById(R.id.tv_content)).setText(com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_mobile_data_tips_dialog_content));
        ((TextView) findViewById(R.id.tv_btn_left)).setText(com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_mobile_data_tips_dialog_left));
        ((TextView) findViewById(R.id.tv_btn_right)).setText(com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_mobile_data_tips_dialog_right));
        goto L23
    }

    public a(Context r100, int r101, p r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.gamecp_live_dialog);
        this.f515095f = r101;
        String r103 = GsonHelper.get().toJson(r102);     // Catch: Exception -> L5
        Object r104 = GsonHelper.get().fromJson(r103, p.class);     // Catch: Exception -> L5
        AtomicInteger r105 = DownloadInfoFactory.f52322a;     // Catch: Exception -> L5
        Integer r106 = Integer.valueOf(DownloadInfoFactory.f());     // Catch: Exception -> L5
        ((p) r104).f52873t = r106;     // Catch: Exception -> L5
        p r107 = (p) r104;     // Catch: Exception -> L5
    L6:
        this.f515093d = r107;
        this.f515094e = new b(this, r100);
        return;
    L5:
        r107 = null;
        goto L6
    }
}
