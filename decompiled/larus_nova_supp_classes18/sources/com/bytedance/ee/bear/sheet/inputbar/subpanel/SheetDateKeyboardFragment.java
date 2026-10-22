package com.bytedance.ee.bear.sheet.inputbar.subpanel;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn5.m;
import cn5.n;
import cn5.o;
import cn5.p;
import cn5.r;
import cn5.s;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.TextSegment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetDateKeyboardFragment extends BaseSheetKeyboardFragment {
    public static final /* synthetic */ int n = 0;
    public UDCheckBox f;
    public UDCheckBox g;
    public TextView h;
    public TextView i;
    public UDTimePicker j;
    public String k;
    public final a l;
    public qm5.a m;

    public class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;

        public final void a() {
            Calendar r0 = Calendar.getInstance();
            this.a = r0.get(1);
            this.b = r0.get(2) + 1;
            this.c = r0.get(5);
            this.d = r0.get(11);
            this.e = r0.get(12);
            r0.get(13);
        }

        public a() {
        }
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.BaseSheetKeyboardFragment
    public final int W90() {
        return 2131564543;
    }

    public SheetDateKeyboardFragment() {
        this.k = "date";
        this.l = new a();
    }

    public final String Z90(List<BaseSegment> r2) {
        if (r2 != null) goto L4;
        return "";
    L4:
        if (r2.isEmpty() == true) goto L11;
        BaseSegment r3 = (BaseSegment) ListProtector.get(r2, 0);
        if ((r3 instanceof TextSegment) == true) goto L8;
        return "";
    L8:
        return ((TextSegment) r3).getText();
    L11:
        return "";
    }

    public final void aa0(String r8) {
        if (V90() == false) goto L5;
    L7:
        Editable r0 = (Editable) U90().getValue();
        if (r0 == null) goto L12;
        r0.clear();
        r0.insert(0, r8);
        return;
    L12:
        return;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L7;
        TextSegment r1 = new TextSegment(r8);
        ArrayList r3 = new ArrayList();
        r3.add(r1);
        String r4 = (String) this.e.getFormat().getValue();
        String r6 = this.e.getCellInfo();
        Y90(1, r3, r4, this.k, r6);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.BaseSheetKeyboardFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.m = new qm5.a();
        DocViewModel r3 = q.a(this, DocViewModel.class);
        qm5.a r0 = this.m;
        r0.a = r3.getBearUrl();
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.f = getView().findViewById(2131368553);
        this.g = getView().findViewById(2131388683);
        this.h = (TextView) getView().findViewById(2131390381);
        this.i = (TextView) getView().findViewById(2131390312);
        this.j = getView().findViewById(2131388693);
        this.f.setOnCheckedChangeListener(new r(this));
        this.g.setOnCheckedChangeListener(new s(this));
        this.h.setOnClickListener(new m(this));
        this.i.setOnClickListener(new n(this));
        this.e.getInputData().observe(this, new o(this));
        this.e.getDateType().observe(this, new p(this));
    }
}
