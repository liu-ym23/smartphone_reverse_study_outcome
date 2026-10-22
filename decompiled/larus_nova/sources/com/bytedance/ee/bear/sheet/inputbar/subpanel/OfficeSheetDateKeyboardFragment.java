package com.bytedance.ee.bear.sheet.inputbar.subpanel;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn5.b;
import cn5.c;
import cn5.d;
import cn5.f;
import cn5.g;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.TextSegment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class OfficeSheetDateKeyboardFragment extends OfficeBaseSheetKeyboardFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f238036n = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDCheckBox f238037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDCheckBox f238038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f238039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f238040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public UDTimePicker f238041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f238042k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f238043l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public on5.a f238044m;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f238045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f238046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f238047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f238048d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f238049e;

        public final void a() {
            Calendar r100 = Calendar.getInstance();
            this.f238045a = r100.get(1);
            this.f238046b = r100.get(2) + 1;
            this.f238047c = r100.get(5);
            this.f238048d = r100.get(11);
            this.f238049e = r100.get(12);
            r100.get(13);
        }

        public a() {
        }
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.OfficeBaseSheetKeyboardFragment
    public final int W90() {
        return R.layout.sheet_date_keyboard_fragment;
    }

    public OfficeSheetDateKeyboardFragment() {
        this.f238042k = "date";
        this.f238043l = new a();
    }

    public final String Z90(List<BaseSegment> r100) {
        if (CollectionUtils.isEmpty(r100) == true) goto L8;
        BaseSegment r101 = (BaseSegment) ListProtector.get(r100, 0);
        if ((r101 instanceof TextSegment) == true) goto L7;
        return "";
    L7:
        return ((TextSegment) r101).getText();
    L8:
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
        String r104 = this.f238035e.getFormat().getValue();
        String r105 = this.f238035e.getCellInfo();
        Y90(1, r103, r104, this.f238042k, r105);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.OfficeBaseSheetKeyboardFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f238044m = new on5.a();
        DocViewModel r101 = (DocViewModel) q.a(this, DocViewModel.class);
        on5.a r102 = this.f238044m;
        r102.f524353a = r101.getBearUrl();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.f238037f = (UDCheckBox) getView().findViewById(R.id.date_selector);
        this.f238038g = (UDCheckBox) getView().findViewById(R.id.time_selector);
        this.f238039h = (TextView) getView().findViewById(R.id.tv_confirm);
        this.f238040i = (TextView) getView().findViewById(R.id.tv_clear);
        this.f238041j = (UDTimePicker) getView().findViewById(R.id.timepicker_view);
        this.f238037f.setOnCheckedChangeListener(new f(this));
        this.f238038g.setOnCheckedChangeListener(new g(this));
        this.f238039h.setOnClickListener(new cn5.a(this));
        this.f238040i.setOnClickListener(new b(this));
        this.f238035e.getInputData().observe(this, new c(this));
        this.f238035e.getDateType().observe(this, new d(this));
    }
}
