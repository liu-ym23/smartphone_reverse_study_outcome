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
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class SheetDateKeyboardFragment extends BaseSheetKeyboardFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f238056n = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDCheckBox f238057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDCheckBox f238058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f238059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f238060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public UDTimePicker f238061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f238062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f238063l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public qm5.a f238064m;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f238065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f238066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f238067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f238068d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f238069e;

        public final void a() {
            Calendar r100 = Calendar.getInstance();
            this.f238065a = r100.get(1);
            this.f238066b = r100.get(2) + 1;
            this.f238067c = r100.get(5);
            this.f238068d = r100.get(11);
            this.f238069e = r100.get(12);
            r100.get(13);
        }

        public a() {
        }
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.BaseSheetKeyboardFragment
    public final int W90() {
        return R.layout.sheet_date_keyboard_fragment;
    }

    public SheetDateKeyboardFragment() {
        this.f238062k = "date";
        this.f238063l = new a();
    }

    public final String Z90(List<BaseSegment> r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.isEmpty() == true) goto L11;
        BaseSegment r101 = (BaseSegment) ListProtector.get(r100, 0);
        if ((r101 instanceof TextSegment) == true) goto L8;
        return "";
    L8:
        return ((TextSegment) r101).getText();
    L11:
        return "";
    }

    public final void aa0(String r100) {
        if (V90() == false) goto L5;
    L7:
        Editable r101 = U90().getValue();
        if (r101 == null) goto L12;
        r101.clear();
        r101.insert(0, r100);
        return;
    L12:
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L7;
        TextSegment r102 = new TextSegment(r100);
        ArrayList r103 = new ArrayList();
        r103.add(r102);
        String r104 = this.f238034e.getFormat().getValue();
        String r105 = this.f238034e.getCellInfo();
        Y90(1, r103, r104, this.f238062k, r105);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.BaseSheetKeyboardFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f238064m = new qm5.a();
        DocViewModel r101 = (DocViewModel) q.a(this, DocViewModel.class);
        qm5.a r102 = this.f238064m;
        r102.f533874a = r101.getBearUrl();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.f238057f = (UDCheckBox) getView().findViewById(R.id.date_selector);
        this.f238058g = (UDCheckBox) getView().findViewById(R.id.time_selector);
        this.f238059h = (TextView) getView().findViewById(R.id.tv_confirm);
        this.f238060i = (TextView) getView().findViewById(R.id.tv_clear);
        this.f238061j = (UDTimePicker) getView().findViewById(R.id.timepicker_view);
        this.f238057f.setOnCheckedChangeListener(new r(this));
        this.f238058g.setOnCheckedChangeListener(new s(this));
        this.f238059h.setOnClickListener(new m(this));
        this.f238060i.setOnClickListener(new n(this));
        this.f238034e.getInputData().observe(this, new o(this));
        this.f238034e.getDateType().observe(this, new p(this));
    }
}
