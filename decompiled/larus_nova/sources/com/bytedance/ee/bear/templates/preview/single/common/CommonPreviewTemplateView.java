package com.bytedance.ee.bear.templates.preview.single.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.templates.preview.data.Item;
import com.bytedance.ee.bear.workspace.NewBaseEntry;
import com.bytedance.ee.bear.workspace.NewBaseType;
import com.bytedance.ee.bear.workspace.WorkspaceAction;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class CommonPreviewTemplateView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<List<String>> f239196i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f239197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f239198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f239199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f239200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f239201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f239202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f239203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CommonTemplateViewModel f239204h;

    public static final class a {
    }

    public CommonPreviewTemplateView() {
    }

    static {
        f239196i = LazyKt.lazy(CommonPreviewTemplateView$Companion$bitableSourceList$2.INSTANCE);
    }

    public final void c(boolean r100) {
        if (r100 == false) goto L6;
        l.c(this.f239200d, R.color.icon_n1);
        TextView r101 = this.f239202f;
        if (r101 == null) goto L10;
        r101.setTextColor(r101.getResources().getColor(R.color.text_title));
        return;
    L10:
        return;
    L6:
        l.c(this.f239200d, R.color.icon_disable);
        TextView r102 = this.f239202f;
        if (r102 == null) goto L12;
        r102.setTextColor(r102.getResources().getColor(R.color.text_disable));
        return;
    }

    public final void d(boolean r100) {
        if (r100 == false) goto L6;
        l.c(this.f239199c, R.color.icon_n1);
        TextView r101 = this.f239201e;
        if (r101 == null) goto L10;
        r101.setTextColor(r101.getResources().getColor(R.color.text_title));
        return;
    L10:
        return;
    L6:
        l.c(this.f239199c, R.color.icon_disable);
        TextView r102 = this.f239201e;
        if (r102 == null) goto L12;
        r102.setTextColor(r102.getResources().getColor(R.color.text_disable));
        return;
    }

    public final void e(int r100) {
        CommonTemplateViewModel r101 = this.f239204h;
        if (r101 == null) goto L21;
        List<Item> r102 = r101.getTemplates();
        if (r102 == null) goto L22;
        int r103 = r102.size();
        boolean r104 = false;
        if (r100 < 0) goto L19;
        if (r100 >= r103) goto L19;
        if (r100 >= (r103 - 1)) goto L13;
        boolean r105 = true;
    L14:
        c(r105);
        if (r100 <= 0) goto L17;
        r104 = true;
    L17:
        d(r104);
        return;
    L13:
        r105 = false;
    L19:
        c(false);
        d(false);
        return;
    L22:
        return;
    }

    public static final void a(CommonPreviewTemplateView r100, Context r101, boolean r102) {
        r100.getClass();
        er5.b r103 = (er5.b) org.koin.java.a.c(er5.b.class, null, null, 6);
        WorkspaceAction r104 = WorkspaceAction.NewTo;
        NewBaseEntry r105 = NewBaseEntry.TemplateCenter;
        if (r102 == false) goto L5;
        NewBaseType r106 = NewBaseType.Form;
    L7:
        if ((28 & 64) == 0) goto L9;
        NewBaseType r107 = null;
    L11:
        if ((28 & 128) == 0) goto L13;
        NewBaseEntry r108 = null;
    L14:
        r103.e(r101, r104, null, null, r107, r108);
        return;
    L13:
        r108 = r105;
        goto L14
    L9:
        r107 = r106;
        goto L11
    L5:
        r106 = NewBaseType.App;
        goto L7
    }

    public final void b(Context r100, ViewGroup r101, CommonTemplateViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        this.f239204h = r102;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.common_template_preview_panel_fragment, r101, true);
        Intrinsics.checkNotNull(r103);
        this.f239197a = (LinearLayout) r103.findViewById(R.id.ll_prev_temp);
        this.f239198b = (LinearLayout) r103.findViewById(R.id.ll_next_temp);
        this.f239199c = (ImageView) r103.findViewById(R.id.title_bar_prev);
        this.f239200d = (ImageView) r103.findViewById(R.id.title_bar_next);
        this.f239201e = (TextView) r103.findViewById(R.id.title_prev);
        this.f239202f = (TextView) r103.findViewById(R.id.title_next);
        this.f239203g = (TextView) r103.findViewById(R.id.tv_use_curr_temp);
        CommonTemplateViewModel r104 = this.f239204h;
        if (r104 == null) goto L9;
        MutableLiveData<Integer> r105 = r104.getCurrTemplatePos();
        if (r105 == null) goto L9;
        Integer r106 = r105.getValue();
        if (r106 == null) goto L9;
        int r107 = r106.intValue();
    L10:
        e(r107);
        TextView r108 = this.f239203g;
        if (r108 == null) goto L13;
        r108.setOnClickListener(new com.bytedance.ee.bear.templates.preview.single.common.a(this));
    L13:
        LinearLayout r109 = this.f239197a;
        if (r109 == null) goto L16;
        r109.setOnClickListener(new b(this));
    L16:
        LinearLayout r110 = this.f239198b;
        if (r110 == null) goto L20;
        r110.setOnClickListener(new c(this));
        return;
    L20:
        return;
    L9:
        r107 = 0;
        goto L10
    }
}
