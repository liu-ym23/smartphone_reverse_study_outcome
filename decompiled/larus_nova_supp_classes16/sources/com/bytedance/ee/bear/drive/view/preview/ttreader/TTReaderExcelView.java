package com.bytedance.ee.bear.drive.view.preview.ttreader;

import aa5.c;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.mime.DriveLocalMime;
import com.bytedance.ee.plugin.common.PluginManager;
import com.bytedance.ee.plugin.common.ttreader.ITTOfficePlugin;
import com.bytedance.ee.plugin.common.ttreader.ITTReaderViewWrapper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import org.json.JSONObject;
import w55.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TTReaderExcelView extends TTReaderBaseView {
    public b k;
    public boolean l;

    public class ExcelHeaderAdapter extends RecyclerView.Adapter<a> {
        public ArrayList<String> a;
        public int b;
        public final /* synthetic */ TTReaderExcelView c;

        public class a extends RecyclerView.ViewHolder {
            public final TextView a;
            public final /* synthetic */ ExcelHeaderAdapter b;

            public a(ExcelHeaderAdapter r1, View r2) {
                this.b = r1;
                super(r2);
                this.a = (TextView) r2.findViewById(2131371836);
                r2.setOnClickListener(new c(this));
            }
        }

        public final int getItemCount() {
            ArrayList<String> r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public ExcelHeaderAdapter(TTReaderExcelView r1) {
            this.c = r1;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            a r5 = (a) r3;
            TTReaderExcelView r0 = this.c;
            if (r0.l == false) goto L5;
            String r1 = com.bytedance.ee.util.io.a.d(r0.f.a);
        L6:
            r5.a.setText(r1);
            if (r4 != this.b) goto L9;
            r5.a.setTextColor(this.c.getResources().getColor(2131105548));
            r5.a.setBackgroundColor(this.c.getResources().getColor(2131100548));
            return;
        L9:
            r5.a.setTextColor(this.c.getResources().getColor(2131106622));
            r5.a.setBackgroundColor(this.c.getResources().getColor(2131100549));
            return;
        L5:
            r1 = (String) ListProtector.get(this.a, r4);
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            return new a(this, LayoutInflater.from(r4.getContext()).inflate(2131560187, r4, false));
        }
    }

    public class a implements ITTReaderViewWrapper.Listener {
        public final /* synthetic */ ExcelHeaderAdapter a;
        public final /* synthetic */ TTReaderExcelView b;

        public a(TTReaderExcelView r1, ExcelHeaderAdapter r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void onError(int r5, Bundle r6) {
            if (r6 == null) goto L4;
            String r7 = r6.toString();
        L5:
            String r8 = String.format("onError what: %s, data: %s", new Object[]{String.valueOf(r5), r7});
            Throwable r0 = new Throwable(r8);
            tt5.a.d("TTReaderExcelView", r8);
            if (r5 == 2002) goto L9;
            this.b.h("tt_excel", r0);
            j65.a.a(this.b.g, "TTReaderExcelView");
        L9:
            if (r5 != 2000) goto L11;
        L15:
            PreviewViewModel r9 = this.b.g;
            if (r9 == null) goto L21;
            r9.getLiveInnerDowngrade().postValue(Integer.valueOf(DriveLocalMime.DOCUMENT.getValue()));
            return;
        L21:
            return;
        L11:
            if (r5 == 2001) goto L15;
            if (r5 != 2002) goto L19;
            this.b.g();
            return;
        L19:
            return;
        L4:
            r7 = "";
            goto L5
        }

        public final void onInfo(int r3, Bundle r4) {
            tt5.a.h("TTReaderExcelView", "onInfo what: " + r3);
            if (r3 != 1000) goto L9;
            String r5 = r4.getString("page_list");
            if (r5 == null) goto L7;
            Pattern r6 = yu5.c.a;
            String[] r7 = r5.split(":");
            ArrayList<String> r8 = new ArrayList(r7.length);
            Collections.addAll(r8, r7);
            ExcelHeaderAdapter r9 = this.a;
            r9.a = r8;
            r9.notifyDataSetChanged();
        L7:
            this.b.d("tt_excel");
            this.b.i("tt_excel");
            return;
        L9:
            if (r3 != 1004) goto L19;
            if (r4 == null) goto L20;
            TTReaderExcelView r10 = this.b;
            String r11 = r4.getString("link");
            r10.getClass();
            if (TextUtils.isEmpty(r11) == false) goto L14;
            tt5.a.d("TTReaderBaseView", "onClickLink link is empty");
            return;
        L14:
            c95.a.InterfaceC0013a r12 = r10.d;
            if (r12 == null) goto L22;
            r12.a(r11);
            return;
        L22:
            return;
        L20:
            return;
        }

        public final void onReport(String r2, JSONObject r3) {
            this.b.f(r2, r3);
        }
    }

    public static class b {
        public final z a;

        public b(z r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.TTReaderBaseView
    public /* bridge */ /* synthetic */ z getPreviewFileModel() {
        return null;
    }

    public TTReaderExcelView(Context r1) {
        super(r1);
        j(r1);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.TTReaderBaseView
    public final void e(String r4) {
        Uri r0 = Uri.fromFile(z75.b.e(this.k.a.d, this.j.b));
        if (TextUtils.isEmpty(this.k.a.c) == true) goto L5;
        String r1 = this.k.a.c;
    L6:
        this.a.openBook(r0, r4, r1);
        this.a.turnTo(0);
        return;
    L5:
        r1 = this.k.a.b;
        goto L6
    }

    public final void j(Context r4) {
        LayoutInflater.from(r4).inflate(2131560239, this, true);
        RecyclerView r5 = findViewById(2131371837);
        r5.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ExcelHeaderAdapter r0 = new ExcelHeaderAdapter(this);
        r5.setAdapter(r0);
        ITTOfficePlugin r6 = PluginManager.getPluginApi(ITTOfficePlugin.class);
        n.g().getClass();
        this.a = r6.newTTReaderViewWrapper(eu5.b.a);
        ViewGroup.LayoutParams r7 = new ViewGroup.LayoutParams(-1, -1);
        ((LinearLayout) findViewById(2131371835)).addView(this.a.getTTReaderView(), r7);
        this.a.setListener(new a(this, r0));
    }

    public TTReaderExcelView(Context r1, AttributeSet r2) {
        super(r1, r2);
        j(r1);
    }

    public TTReaderExcelView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        j(r1);
    }
}
