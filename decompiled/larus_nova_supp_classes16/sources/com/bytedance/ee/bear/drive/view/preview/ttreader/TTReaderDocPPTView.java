package com.bytedance.ee.bear.drive.view.preview.ttreader;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.mime.DriveLocalMime;
import com.bytedance.ee.plugin.common.PluginManager;
import com.bytedance.ee.plugin.common.ttreader.ITTOfficePlugin;
import com.bytedance.ee.plugin.common.ttreader.ITTReaderViewWrapper;
import org.json.JSONObject;
import w55.n;
import z75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TTReaderDocPPTView extends TTReaderBaseView {
    public TextView k;
    public int l;
    public boolean m;

    public class a implements ITTReaderViewWrapper.Listener {
        public final /* synthetic */ TTReaderDocPPTView a;

        public a(TTReaderDocPPTView r1) {
            this.a = r1;
        }

        public final void onError(int r5, Bundle r6) {
            if (r6 == null) goto L4;
            String r7 = r6.toString();
        L5:
            String r8 = String.format("onError what: %s, data: %s", new Object[]{String.valueOf(r5), r7});
            Throwable r0 = new Throwable(r8);
            tt5.a.d("TTReaderDocPPTView", r8);
            if (r5 == 2002) goto L9;
            this.a.h("tt_pdf", r0);
            j65.a.a(this.a.g, "TTReaderDocPPTView");
        L9:
            if (r5 != 2000) goto L11;
        L15:
            PreviewViewModel r9 = this.a.g;
            if (r9 == null) goto L21;
            r9.getLiveInnerDowngrade().postValue(Integer.valueOf(DriveLocalMime.DOCUMENT.getValue()));
            return;
        L21:
            return;
        L11:
            if (r5 == 2001) goto L15;
            if (r5 != 2002) goto L19;
            this.a.g();
            return;
        L19:
            return;
        L4:
            r7 = "";
            goto L5
        }

        public final void onInfo(int r4, Bundle r5) {
            if (r5 == null) goto L4;
            String r0 = r5.toString();
        L5:
            tt5.a.h("TTReaderDocPPTView", "onInfo what: " + r4 + " msg: " + r0);
            if (r4 != 1000) goto L11;
            if (r5 == null) goto L9;
            this.a.l = r5.getInt("pages");
        L9:
            this.a.d("tt_pdf");
            this.a.i("tt_pdf");
            return;
        L11:
            if (r4 != 1001) goto L15;
            if (r5 == null) goto L31;
            this.a.l = r5.getInt("page_count", 0);
            TTReaderDocPPTView.j(this.a, r5.getInt("page") + 1);
            return;
        L31:
            return;
        L15:
            if (r4 != 1004) goto L24;
            if (r5 == null) goto L33;
            TTReaderDocPPTView r6 = this.a;
            String r7 = r5.getString("link");
            r6.getClass();
            if (TextUtils.isEmpty(r7) == false) goto L20;
            tt5.a.d("TTReaderBaseView", "onClickLink link is empty");
            return;
        L20:
            c95.a.InterfaceC0013a r8 = r6.d;
            if (r8 == null) goto L35;
            r8.a(r7);
            return;
        L35:
            return;
        L33:
            return;
        L24:
            if (r4 != 1006) goto L27;
            TTReaderDocPPTView r9 = this.a;
            System.currentTimeMillis();
            r9.getClass();
            this.a.getClass();
            return;
        L27:
            if (r4 != 1005) goto L38;
            System.currentTimeMillis();
            this.a.getClass();
            return;
        L38:
            return;
        L4:
            r0 = "";
            goto L5
        }

        public final void onReport(String r2, JSONObject r3) {
            this.a.f(r2, r3);
        }
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.TTReaderBaseView
    public /* bridge */ /* synthetic */ z getPreviewFileModel() {
        return null;
    }

    public TTReaderDocPPTView(Context r2) {
        super(r2);
        this.m = true;
        k(r2);
    }

    private void setIndicator(int r4) {
        TextView r0 = this.k;
        if (this.m == true) goto L5;
    L8:
        int r1 = 8;
    L9:
        r0.setVisibility(r1);
        this.k.setText(String.format("%d/%d", new Object[]{Integer.valueOf(r4), Integer.valueOf(this.l)}));
        return;
    L5:
        if (this.l <= 0) goto L8;
        if (r4 <= 0) goto L8;
        r1 = 0;
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.TTReaderBaseView
    public final void e(String r4) {
        Uri r0 = Uri.fromFile(b.e(this.f.d, this.j.b));
        if (TextUtils.isEmpty(this.f.c) == true) goto L5;
        String r1 = this.f.c;
    L6:
        this.a.openBook(r0, r4, r1);
        this.a.turnTo(0);
        return;
    L5:
        r1 = this.f.b;
        goto L6
    }

    public final void k(Context r4) {
        LayoutInflater.from(r4).inflate(2131560240, this, true);
        ITTOfficePlugin r5 = PluginManager.getPluginApi(ITTOfficePlugin.class);
        n.g().getClass();
        ITTReaderViewWrapper r6 = r5.newTTReaderViewWrapper(eu5.b.a);
        this.a = r6;
        r6.setOption(3100, "false");
        View r7 = this.a.getTTReaderView();
        ViewGroup.LayoutParams r0 = new ViewGroup.LayoutParams(-1, -1);
        ((ViewGroup) findViewById(2131392488)).addView(r7, 0, r0);
        this.k = (TextView) findViewById(2131375249);
        this.a.setListener(new a(this));
    }

    public void setIndicatorVisible(boolean r1) {
        this.m = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.TTReaderBaseView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void setUserAbility(a95.a r1) {
        super.setUserAbility(r1);
    }

    public TTReaderDocPPTView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.m = true;
        k(r1);
    }

    public static /* synthetic */ void j(TTReaderDocPPTView r0, int r1) {
        r0.setIndicator(r1);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.TTReaderBaseView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onSetup(ViewOwner r1, ViewOwner r2) {
        super.onSetup(r1, r2);
    }

    public TTReaderDocPPTView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.m = true;
        k(r1);
    }
}
